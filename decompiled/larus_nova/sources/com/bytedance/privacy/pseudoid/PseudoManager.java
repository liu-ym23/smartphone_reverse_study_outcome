package com.bytedance.privacy.pseudoid;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import j67.a;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k67.b;
import k67.d;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class PseudoManager {
    public static final String TAG = null;
    private static volatile PseudoManager pseudoManager;

    public PseudoManager() {
    }

    static {
        TAG = "PseudoManager";
    }

    public static PseudoManager getInstance() {
        if (pseudoManager != null) goto L15;
        monitor-enter(PseudoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pseudoManager != null) goto L9;
        pseudoManager = new PseudoManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L11
    L15:
        return pseudoManager;
    }

    private void deletePseudoIDs(Context r100, String r101) {
        AccountApi r102 = AccountApi.INSTANCE;
        String r103 = r102.getDeviceId();
        if (isRPDIDExist(r100, r101, r103) == false) goto L20;
        String r104 = queryRPDID(r100, r101, r103);
        if (r104 != null) goto L7;
    L17:
        b.c(TAG, "RPDID is already stored, but query failed!");
        return;
    L7:
        if (r104.isEmpty() == true) goto L17;
        if (isDeviceIdExist(r100, r101, r104) == false) goto L14;
        int r105 = a.b().m(r100, d.a(h67.b.a(r101, r104, "_did")), new Bundle());
        if (r105 == 0) goto L14;
        b.c(TAG, "delete DeviceID failed, result = " + r105);
    L14:
        int r106 = a.b().m(r100, d.a(h67.b.a(r101, r103, "_rpdid")), new Bundle());
        if (r106 == 0) goto L20;
        b.c(TAG, "delete RPDID failed, result = " + r106);
    L20:
        if (r102.isLogin() == false) goto L27;
        String r107 = r102.getUserId();
        if (isRPUIDExist(r100, r101, r107) == false) goto L28;
        int r108 = a.b().m(r100, d.a(h67.b.a(r101, r107, "_rpuid")), new Bundle());
        if (r108 == 0) goto L29;
        b.c(TAG, "delete RPUID failed, result = " + r108);
        return;
    L29:
        return;
    L28:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getPseudoDID(Context r110, String r111) {
        String r100 = r111;
        long r101 = System.currentTimeMillis();
        String r102 = TAG;
        b.e(r102, "getPseudoDID enter");
        byte r103 = 0;
        if (r110 == null) goto L76;
        if (r100 == null) goto L76;
        String r104 = r110.getPackageName();     // Catch: Throwable -> L83 Exception -> L85
        if (r111.isEmpty() == false) goto L9;
    L73:
        b.c(r102, "AppId size is invalid!!");     // Catch: Throwable -> L83 Exception -> L85
        h67.a.a(-3, 0, r104, r111, System.currentTimeMillis() - r101);
        return null;
    L9:
        if (r111.length() > 128) goto L73;
        AccountApi r112 = AccountApi.INSTANCE;     // Catch: Throwable -> L83 Exception -> L85
        String r113 = r112.getDeviceId();     // Catch: Throwable -> L83 Exception -> L85
        if (r113.isEmpty() == false) goto L17;
        b.c(r102, "deviceId is empty!");     // Catch: Throwable -> L83 Exception -> L85
        h67.a.a(-4, 0, r104, r111, System.currentTimeMillis() - r101);
        return null;
    L17:
        if (isRPDIDExist(r110, r100, r113) == false) goto L25;
        String r105 = queryRPDID(r110, r100, r113);     // Catch: Throwable -> L83 Exception -> L85
        if (TextUtils.isEmpty(r105) == false) goto L22;
        b.c(r102, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L83 Exception -> L85
        int r106 = -6;
    L23:
        h67.a.a(r106, 0, r104, r111, System.currentTimeMillis() - r101);
        return r105;
    L22:
        r106 = 0;
        goto L23
    L25:
        String r114 = r111.intern();     // Catch: Throwable -> L83 Exception -> L85
        monitor-enter(r114);     // Catch: Throwable -> L83 Exception -> L85
    L66:
        th = th;
    L67:
        monitor-exit(r114);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L69 Exception -> L71
    L71:
        e = e;
        char r115 = r103;
        String r107 = r104;
        int r108 = r115 == true ? 1 : 0;
    L108:
    L98:
        th = th;
    L99:
        long r116 = System.currentTimeMillis() - r101;
        if (r100 != null) goto L103;
        r100 = "";
    L103:
        h67.a.a(r108, 0, r107, r100, r116);
        throw th;
    L88:
        if (e.getMessage() != null) goto L90;
        String r109 = e.getClass().getSimpleName();     // Catch: Throwable -> L98
    L91:
        b.c(TAG, "getPseudoDID failed, error: " + r109);     // Catch: Throwable -> L98
        long r117 = System.currentTimeMillis() - r101;
        if (r100 != null) goto L96;
        r100 = "";
    L96:
        h67.a.a(r108 == true ? 1 : 0, 0, r107, r100, r117);
        return 0;
    L90:
        r109 = e.getMessage();     // Catch: Throwable -> L98
    L69:
        th = th;
        char r118 = r103;
        r107 = r104;
        r108 = r118 == true ? 1 : 0;
        goto L99
    L107:
        if (isRPDIDExist(r110, r100, r113) == false) goto L39;
        String r119 = queryRPDID(r110, r100, r113);     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r119) == false) goto L33;
        b.c(r102, "RPDID is already stored, but query failed!");     // Catch: Throwable -> L66
        int r120 = -6;
    L34:
        monitor-exit(r114);     // Catch: Throwable -> L37
        h67.a.a(r120, 0, r104, r111, System.currentTimeMillis() - r101);
        return r119;
    L33:
        r120 = 0;
        goto L34
    L39:
        b.e(r102, "need to get pseudoID from cloud");     // Catch: Throwable -> L66
        if (r112.isLogin() == true) goto L42;
        b.e(r102, "Account is not login!!");     // Catch: Throwable -> L66
        int r121 = getPseudoIDFromCloud(r110, r113, "", r100);     // Catch: Throwable -> L66
    L52:
        if (r121 == 0) goto L57;
        b.c(r102, "get pseudoID from cloud failed, error: " + r121);     // Catch: Throwable -> L66
        monitor-exit(r114);     // Catch: Throwable -> L66
        h67.a.a(r121, 0, r104, r111, System.currentTimeMillis() - r101);
        return null;
    L57:
        String r122 = queryRPDID(r110, r100, r113);     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r122) == false) goto L61;
        b.c(r102, "RPDID store success, but query failed!");     // Catch: Throwable -> L66
        int r123 = -6;
    L62:
        monitor-exit(r114);     // Catch: Throwable -> L37
        h67.a.a(r123, 0, r104, r111, System.currentTimeMillis() - r101);
        return r122;
    L61:
        r123 = r121;
        goto L62
    L42:
        b.e(r102, "Account is login!!");     // Catch: Throwable -> L66
        String r124 = r112.getUserId();     // Catch: Throwable -> L66
        if (r124.isEmpty() == false) goto L51;
        b.c(r102, "Account is login, but userId is empty!");     // Catch: Throwable -> L66
        monitor-exit(r114);     // Catch: Throwable -> L49
        h67.a.a(-5, 0, r104, r111, System.currentTimeMillis() - r101);
        return null;
    L49:
        th = th;
        r103 = -5;
        goto L67
    L51:
        r121 = getPseudoIDFromCloud(r110, r113, r124, r100);     // Catch: Throwable -> L66
    L37:
        th = th;
        r103 = "get pseudoID from cloud failed, error: ";
    L76:
        b.c(r102, "Context or appId is null!!");     // Catch: Throwable -> L83 Exception -> L85
        long r125 = System.currentTimeMillis() - r101;
        if (r100 == null) goto L80;
        String r126 = r100;
    L81:
        h67.a.a(-2, 0, "", r126, r125);
        return null;
    L80:
        r126 = "";
    L85:
        e = e;
        r107 = "";
        r108 = 0;
    L83:
        th = th;
        r107 = "";
        r108 = 0;
        goto L99
    }

    public String getPseudoUID(Context r110, String r111) {
        String r100 = r111;
        long r101 = System.currentTimeMillis();
        String r102 = TAG;
        b.e(r102, "getPseudoUID enter");
        int r103 = 0;
        String r104 = null;
        if (r110 == null) goto L71;
        if (r100 == null) goto L71;
        String r105 = r110.getPackageName();     // Catch: Throwable -> L78 Exception -> L80
        if (r111.isEmpty() == false) goto L9;
    L68:
        b.c(r102, "AppId size is invalid!!");     // Catch: Throwable -> L78 Exception -> L80
        h67.a.a(-3, 1, r105, r111, System.currentTimeMillis() - r101);
        return null;
    L9:
        if (r111.length() > 128) goto L68;
        AccountApi r112 = AccountApi.INSTANCE;     // Catch: Throwable -> L78 Exception -> L80
        if (r112.isLogin() == true) goto L16;
        b.c(r102, "Account is not login, no userId!!");     // Catch: Throwable -> L78 Exception -> L80
        h67.a.a(-20, 1, r105, r111, System.currentTimeMillis() - r101);
        return null;
    L16:
        String r113 = r112.getUserId();     // Catch: Throwable -> L78 Exception -> L80
        if (r113.isEmpty() == false) goto L22;
        b.c(r102, "Account is login, but userId is empty!");     // Catch: Throwable -> L78 Exception -> L80
        h67.a.a(-5, 1, r105, r111, System.currentTimeMillis() - r101);
        return null;
    L22:
        if (isRPUIDExist(r110, r100, r113) == false) goto L30;
        String r106 = queryRPUID(r110, r100, r113);     // Catch: Throwable -> L78 Exception -> L80
        if (TextUtils.isEmpty(r106) == false) goto L27;
        b.c(r102, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L78 Exception -> L80
        int r107 = -7;
    L28:
        h67.a.a(r107, 1, r105, r111, System.currentTimeMillis() - r101);
        return r106;
    L27:
        r107 = 0;
        goto L28
    L30:
        b.e(r102, "need to get pseudoID from cloud");     // Catch: Throwable -> L78 Exception -> L80
        String r114 = r112.getDeviceId();     // Catch: Throwable -> L78 Exception -> L80
        if (r114.isEmpty() == false) goto L35;
        b.c(r102, "getPseudoUID, DID is empty!");     // Catch: Throwable -> L78 Exception -> L80
        h67.a.a(-4, 1, r105, r111, System.currentTimeMillis() - r101);
        return null;
    L35:
        String r115 = r111.intern();     // Catch: Throwable -> L78 Exception -> L80
        monitor-enter(r115);     // Catch: Throwable -> L78 Exception -> L80
    L61:
        th = th;
    L62:
        monitor-exit(r115);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L64 Exception -> L66
    L66:
        e = e;
        String r108 = r104;
        int r116 = r103;
        String r109 = r105;
        int r117 = r116;
    L102:
    L93:
        th = th;
    L94:
        long r118 = System.currentTimeMillis() - r101;
        if (r100 != null) goto L98;
        r100 = "";
    L98:
        h67.a.a(r117, 1, r109, r100, r118);
        throw th;
    L83:
        if (e.getMessage() != null) goto L85;
        String r119 = e.getClass().getSimpleName();     // Catch: Throwable -> L93
    L86:
        b.c(TAG, "getPseudoUID failed, error: " + r119);     // Catch: Throwable -> L93
        long r120 = System.currentTimeMillis() - r101;
        if (r100 != null) goto L91;
        r100 = "";
    L91:
        h67.a.a(r117, 1, r109, r100, r120);
        return r108;
    L85:
        r119 = e.getMessage();     // Catch: Throwable -> L93
    L64:
        th = th;
        int r121 = r103;
        r109 = r105;
        r117 = r121;
        goto L94
    L38:
        if (isRPUIDExist(r110, r100, r113) == false) goto L49;
        r104 = queryRPUID(r110, r100, r113);     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r104) == false) goto L43;
        b.c(r102, "RPUID is already stored, but query failed!");     // Catch: Throwable -> L61
        int r122 = -7;
    L100:
        monitor-exit(r115);     // Catch: Throwable -> L47
        h67.a.a(r122, 1, r105, r111, System.currentTimeMillis() - r101);
        return r104;
    L47:
        th = th;
        r103 = r122;
        goto L62
    L43:
        r122 = 0;
        goto L100
    L49:
        int r123 = getPseudoIDFromCloud(r110, r114, r113, r100);     // Catch: Throwable -> L61
        if (r123 == 0) goto L55;
        b.c(r102, "get pseudoID from cloud failed, error: " + r123);     // Catch: Throwable -> L61
        monitor-exit(r115);     // Catch: Throwable -> L61
        h67.a.a(r123, 1, r105, r111, System.currentTimeMillis() - r101);
        return null;
    L55:
        String r124 = queryRPUID(r110, r100, r113);     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r124) == false) goto L58;
        b.c(r102, "RPUID store success, but query failed!");     // Catch: Throwable -> L61
    L58:
        monitor-exit(r115);     // Catch: Throwable -> L61
        h67.a.a(r123, 1, r105, r111, System.currentTimeMillis() - r101);
        return r124;
    L71:
        b.c(r102, "Context or app Id is null!!");     // Catch: Throwable -> L78 Exception -> L80
        long r125 = System.currentTimeMillis() - r101;
        if (r100 == null) goto L75;
        String r126 = r100;
    L76:
        h67.a.a(-2, 1, "", r126, r125);
        return null;
    L75:
        r126 = "";
    L80:
        e = e;
        r109 = "";
        r108 = null;
        r117 = 0;
    L78:
        th = th;
        r109 = "";
        r117 = 0;
        goto L94
    }

    private boolean isDeviceIdExist(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        a.e();
        a.b().e();
        r103.putInt("query_mode", 0);
        a.e r104 = a.d(r100, d.a(h67.b.a(r101, r102, "_did")), r103);
        if (r104.f497531a == false) goto L5;
    L9:
        return false;
    L5:
        if (r104.f497532b != 0) goto L9;
        return true;
    }

    private boolean isRPDIDExist(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        a.e();
        a.b().e();
        r103.putInt("query_mode", 0);
        a.e r104 = a.d(r100, d.a(h67.b.a(r101, r102, "_rpdid")), r103);
        if (r104.f497531a == false) goto L5;
    L9:
        return false;
    L5:
        if (r104.f497532b != 0) goto L9;
        return true;
    }

    private boolean isRPUIDExist(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        a.e();
        a.b().e();
        r103.putInt("query_mode", 0);
        a.e r104 = a.d(r100, d.a(h67.b.a(r101, r102, "_rpuid")), r103);
        if (r104.f497531a == false) goto L5;
    L9:
        return false;
    L5:
        if (r104.f497532b != 0) goto L9;
        return true;
    }

    private String queryRPDID(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        a.e();
        a.b().p();
        r103.putInt("query_mode", 2);
        a.e r104 = a.d(r100, d.a(h67.b.a(r101, r102, "_rpdid")), r103);
        if (r104.f497531a == false) goto L5;
    L15:
        b.c(TAG, "Query RPDID failed!!");
        return null;
    L5:
        if (r104.f497532b != 0) goto L15;
        String r105 = r104.f497533c;
        if (r105 != null) goto L10;
    L13:
        b.c(TAG, "Query success, but RPDID is null!!");
        return null;
    L10:
        if (r105.isEmpty() == true) goto L13;
        return r105;
    }

    private String queryRPUID(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        a.e();
        a.b().p();
        r103.putInt("query_mode", 2);
        a.e r104 = a.d(r100, d.a(h67.b.a(r101, r102, "_rpuid")), r103);
        if (r104.f497531a == false) goto L5;
    L15:
        b.c(TAG, "Query RPUID failed!!");
        return null;
    L5:
        if (r104.f497532b != 0) goto L15;
        String r105 = r104.f497533c;
        if (r105 != null) goto L10;
    L13:
        b.c(TAG, "Query success, but RPUID is null!!");
        return null;
    L10:
        if (r105.isEmpty() == true) goto L13;
        return r105;
    }

    public String queryDIDFromRPDID(Context r100, String r101, String r102) {
        if (r100 == null) goto L31;
        if (r101 == null) goto L31;
        if (r102 == null) goto L31;
        if (r101.isEmpty() == false) goto L10;
    L29:
        b.c(TAG, "AppId or rpDID size is invalid!!");
        return null;
    L10:
        if (r101.length() > 128) goto L29;
        if (r102.isEmpty() == true) goto L29;
        Bundle r103 = new Bundle();
        a.e();
        a.b().p();
        r103.putInt("query_mode", 2);
        a.e r104 = a.d(r100, d.a(h67.b.a(r101, r102, "_did")), r103);
        if (r104.f497531a == false) goto L17;
    L27:
        b.c(TAG, "Query original deviceId failed!!");
        return null;
    L17:
        if (r104.f497532b != 0) goto L27;
        String r105 = r104.f497533c;
        if (r105 != null) goto L22;
    L25:
        b.c(TAG, "Query success, but original deviceId is null!!");
        return null;
    L22:
        if (r105.isEmpty() == true) goto L25;
        return r105;
    L31:
        b.c(TAG, "input param is null!!");
        return null;
    }

    private int getPseudoIDFromCloud(Context r100, String r101, String r102, String r103) {
        if (r100 == null) goto L14;
        if (r103 == null) goto L14;
        if (r101 != null) goto L8;
    L12:
        b.c(TAG, "deviceId cannot be empty!!");
        return -2;
    L8:
        if (r101.isEmpty() == true) goto L12;
        return requestPseudoID(r100, r101, r102, r103);
    L14:
        b.c(TAG, "context or appID is null!!");
        return -2;
    }

    private int requestPseudoID(Context r110, String r111, String r210, String r211) {
        String r100 = TAG;
        b.a(r100, "request PseudoID, PackageName: " + r110.getPackageName());
        b.a(r100, "request PseudoID, appId:" + r211);
        b.a(r100, "request PseudoID, deviceId:" + r111);
        if (r210.isEmpty() == true) goto L5;
        b.a(r100, "request PseudoID, userId:".concat(r210));
    L5:
        String r101 = i67.a.f488437a;
        if (e67.b.a().b() == false) goto L8;
        String r102 = "https://ocean-secret-boe.bytedance.net/api/identity/pseudonymize";
    L9:
        d67.a.d().getClass();
        d67.a.a(r110, r211);
        Bundle r103 = new Bundle();
        a.b().o();
        a.b().keyAlgorithmEcc();
        r103.putInt("key_algorithm", 2);
        a.b().i();
        r103.putInt("key_length", 256);
        a.b().u();
        a.b().purposeAttestKey();
        r103.putInt("key_purpose", 64);
        d67.a.d().getClass();
        String r104 = e67.a.c();
        boolean r112 = TextUtils.isEmpty(r104);
        String r113 = d67.a.f467209a;
        if (r112 == false) goto L12;
        b.c(r113, "Request challenge failed!!");
        List r105 = new ArrayList();
    L20:
        if (r105.isEmpty() == false) goto L152;
        b.c(r100, "Get attest cert chain failed!!");
        int r106 = -9;
    L147:
        d67.a.d().getClass();
        d67.a.a(r110, r211);
        b.e(TAG, "requestPseudoID end, result:" + r106);
        return r106;
    L152:
        String r107 = k67.a.a(r105, 3);     // Catch: Exception -> L145
        if (i67.a.f488439c == null) goto L27;
    L36:
        i67.a.f488439c.getClass();
        String r114 = i67.a.f488437a;
        b.a(r114, "executeRequest enter");
        RequestBody r115 = RequestBody.create(MediaType.parse("application/json"), SliceInitService.DEFAULT_SWITCH);
        Map<String, String> r116 = AccountApi.INSTANCE.getXttTokenMap();
        Iterator<Map.Entry<String, String>> r117 = r116.entrySet().iterator();
    L38:
        if (r117.hasNext() == false) goto L40;
        Map.Entry<String, String> r118 = r117.next();
        b.a(r114, "xttTokenMap entry key:" + r118.getKey() + " value:" + r118.getValue());
        r117 = r117;
        goto L38
    L40:
        Request r108 = new Request.Builder().url(r102).method("POST", r115).headers(Headers.of(r116)).addHeader("Content-Type", "application/json").addHeader("x-att-certchain", r107).build();
        b.a(r114, "PseudoID Request:" + r108.toString());
        b.a(r114, "PseudoID Request body:" + r108.body());
        Object r119 = null;
        i67.b r109 = new i67.b(400, "", null);
        int r120 = 1;
    L42:
        if (r120 > 3) goto L117;
        Response r121 = i67.a.f488438b.newCall(r108).execute();     // Catch: Exception -> L96 IOException -> L100 ConnectException -> L104 SocketTimeoutException -> L108
        if (r121.body() == null) goto L47;
        String r122 = r121.body().string();     // Catch: Throwable -> L78
    L50:
        if (r121.isSuccessful() == false) goto L160;
        b.a(r114, "PseudoID Response received successfully");     // Catch: Throwable -> L76
        b.a(r114, "PseudoID Response body:" + r122);     // Catch: Throwable -> L76
        r109 = i67.a.a(r122);     // Catch: Throwable -> L76
        r121.close();     // Catch: Exception -> L96 IOException -> L100 ConnectException -> L104 SocketTimeoutException -> L108
    L76:
        th = th;
    L79:
        Object r123 = r119;
    L80:
        Throwable r124 = th;
        if (r121 != null) goto L150;
    L87:
        throw r124;     // Catch: Exception -> L88 IOException -> L90 ConnectException -> L92 SocketTimeoutException -> L94
    L92:
        e = e;
    L106:
        i67.b r125 = r109;
    L107:
        b.c(r114, "Challenge Attempt " + r120 + ": ConnectException (connect timeout): " + e.getMessage());
    L112:
        r109 = r125;
        if (r120 >= 3) goto L116;
        Thread.sleep(500);     // Catch: InterruptedException -> L149
    L116:
        r120 = r120 + 1;
        r119 = r123;
    L94:
        e = e;
    L110:
        r125 = r109;
    L111:
        b.c(r114, "Challenge Attempt " + r120 + ": SocketTimeoutException (read/write timeout): " + e.getMessage());
    L90:
        e = e;
    L102:
        r125 = r109;
    L103:
        b.c(r114, "Challenge Attempt " + r120 + ": IOException: " + e.getMessage());
    L88:
        e = e;
    L98:
        r125 = r109;
    L99:
        b.c(r114, "Challenge Attempt " + r120 + ": Unexpected exception: " + e.getMessage());
        goto L112
    L150:
        r121.close();     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        r124.addSuppressed(th);     // Catch: Exception -> L88 IOException -> L90 ConnectException -> L92 SocketTimeoutException -> L94
        goto L87
    L160:
        StringBuilder r126 = new StringBuilder();     // Catch: Throwable -> L76
        r126.append("PseudoID Attempt ");     // Catch: Throwable -> L74
        r126.append(r120);     // Catch: Throwable -> L74
        r126.append(": Response failed, code = ");     // Catch: Throwable -> L74
        r126.append(r121.code());     // Catch: Throwable -> L74
        b.c(r114, r126.toString());     // Catch: Throwable -> L74
        b.c(r114, "PseudoID Response body:" + r122);     // Catch: Throwable -> L74
        r123 = null;
        r125 = new i67.b(r121.code(), r121.message(), null);     // Catch: Throwable -> L72
        r121.close();     // Catch: Exception -> L64 IOException -> L66 ConnectException -> L68 SocketTimeoutException -> L70
    L68:
        e = e;
    L70:
        e = e;
    L66:
        e = e;
    L64:
        e = e;
    L72:
        th = th;
    L74:
        th = th;
        r123 = null;
        goto L80
    L47:
        r122 = "";
    L78:
        th = th;
    L104:
        e = e;
        r123 = r119;
    L108:
        e = e;
        r123 = r119;
    L100:
        e = e;
        r123 = r119;
    L96:
        e = e;
        r123 = r119;
    L117:
        String r127 = TAG;
        b.a(r127, "response code:" + r109.f488440a);
        b.a(r127, "response msg:" + r109.f488441b);
        int r128 = r109.f488440a;
        if (r128 >= 200) goto L120;
    L144:
        b.c(r127, "Network request failed, error code:" + r109.f488440a);
        r106 = -21;
        goto L147
    L120:
        if (r128 >= 300) goto L144;
        if (r109.f488442c != null) goto L125;
        b.c(r127, "Network response pseudoID is null!");
        r106 = -8;
        goto L147
    L125:
        b.a(r127, "PRDID:" + r109.f488442c.f488443a);
        b.a(r127, "PRUID:" + r109.f488442c.f488444b);
        if (r111.isEmpty() == false) goto L128;
        int r129 = 0;
    L135:
        if (r210.isEmpty() == false) goto L137;
    L143:
        r106 = r129;
        goto L147
    L137:
        if (r109.f488442c.f488444b.isEmpty() == false) goto L140;
        b.c(r127, "Network response RPUID is empty!!");
    L139:
        r106 = -22;
        goto L147
    L140:
        r129 = storePseudoUID(r110, r211, r210, r109.f488442c.f488444b);
        if (r129 == 0) goto L143;
        b.c(r127, "storePseudoUID failed!, result:" + r129);
        goto L143
    L128:
        if (r109.f488442c.f488443a.isEmpty() == false) goto L130;
        b.c(r127, "Network response RPDID is empty!!");
        goto L139
    L130:
        r129 = storePseudoDID(r110, r211, r111, r109.f488442c.f488443a);
        if (r129 == 0) goto L135;
        b.c(r127, "storePseudoDID failed!, result:" + r129);
        goto L143
    L27:
        monitor-enter(PseudoManager.class);
    L33:
        th = move-exception;
        throw th;
    L29:
        if (i67.a.f488439c != null) goto L31;
        i67.a.f488439c = new i67.a();     // Catch: Throwable -> L33
    L31:
        monitor-exit(PseudoManager.class);     // Catch: Throwable -> L33
    L145:
        e = move-exception;
        b.c(TAG, "Set certificate chain failed!! error:" + e.getMessage());
        r106 = -100;
        goto L147
    L12:
        b.a(r113, "Request challenge succeed! challenge:" + r104);
        int r130 = d67.a.b(r110, r211, r103);
        a.c();
        if (r130 == 0) goto L15;
        b.c(r113, "Generate attestation key pair failed! ret:" + r130);
        r105 = new ArrayList();
        goto L20
    L15:
        String r131 = r104 + ":" + r111 + ":" + r211;
        Bundle r132 = new Bundle();
        a.b().f();
        r132.putString("challenge", r131);
        a.c r133 = a.b().keyAttestation(r110, r211, r132);
        int r134 = r133.f497528a;
        a.c();
        if (r134 == 0) goto L18;
        b.c(r113, "Attest key failed! ret:" + r133.f497528a);
        r105 = new ArrayList();
        goto L20
    L18:
        r105 = r133.f497529b;
        b.a(r113, "Attest key succeed! cert chain size:" + r105.size());
        goto L20
    L8:
        r102 = "https://ocean-secret.oceancloudapi.com/api/identity/pseudonymize";
        goto L9
    }

    private int storePseudoDID(Context r110, String r111, String r112, String r113) {
        if (isRPDIDExist(r110, r111, r112) == true) goto L12;
        int r100 = a.b().h(r110, r113, r111, d.a(h67.b.a(r111, r112, "_rpdid")), "RPDID", new Bundle());
        if (r100 != (-1)) goto L8;
        b.c(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r100 == 0) goto L12;
        b.c(TAG, "Store RPDID failed!! result: " + r100);
        return r100;
    L12:
        if (isDeviceIdExist(r110, r111, r113) == true) goto L20;
        int r114 = a.b().h(r110, r112, r111, d.a(h67.b.a(r111, r113, "_did")), "DID", new Bundle());
        if (r114 != (-1)) goto L17;
        b.c(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L17:
        if (r114 == 0) goto L22;
        b.c(TAG, "Store deviceID failed!! result: " + r114);
        return r114;
    L22:
        return 0;
    L20:
        return 0;
    }

    private int storePseudoUID(Context r100, String r101, String r110, String r111) {
        if (isRPUIDExist(r100, r101, r110) == true) goto L11;
        int r102 = a.b().h(r100, r111, r101, d.a(h67.b.a(r101, r110, "_rpuid")), "RPUID", new Bundle());
        if (r102 != (-1)) goto L8;
        b.c(TAG, "addSecretData failed, SecretDataManager service error");
        return -14;
    L8:
        if (r102 == 0) goto L13;
        b.c(TAG, "Store RPUID failed!! result: " + r102);
        return r102;
    L13:
        return 0;
    L11:
        return 0;
    }
}
