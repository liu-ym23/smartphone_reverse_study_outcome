package com.privacy.azerothprivacy;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.security.SecurityUtil;
import com.bytedance.common.utility.NetworkClient;
import com.privacy.azerothprivacy.alarm.receiver.ColdBootDelayExecutor;
import com.privacy.azerothprivacy.alarm.receiver.KeyAgreementUpdater;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import dpa.d;
import dpa.h;
import fpa.c;
import java.security.Key;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import org.json.JSONException;
import org.json.JSONObject;
import poa.a;
import poa.b;
import poa.e;
import poa.f;

/* JADX INFO: loaded from: classes5.dex */
public class AzerothPrivacy {
    private static final String TAG = "AzerothPrivacy";

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private static Application f404393app;
    private static Context appContext;
    private static a appInfo;
    private static volatile boolean hasInitiated;
    private static f sdkConfig;

    public AzerothPrivacy() {
    }

    public static /* synthetic */ void a() {
        lambda$initAsync$1();
    }

    public static /* synthetic */ void b(a r100) {
        lambda$init$0(r100);
    }

    public static /* synthetic */ void c() {
        lambda$invokeAfterLogin$3();
    }

    public static /* synthetic */ void d(String r100) {
        lambda$invokeAfterLogin$2(r100);
    }

    public static String getVersion() {
        return "1.5.1";
    }

    public static synchronized a getAppInfo() {
        monitor-enter(AzerothPrivacy.class);
        a r100 = appInfo;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return r100;
    L8:
        a r101 = new a();     // Catch: Throwable -> L11
        monitor-exit(AzerothPrivacy.class);
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized f getSdkConfig() {
        monitor-enter(AzerothPrivacy.class);
        f r100 = sdkConfig;     // Catch: Throwable -> L7
        monitor-exit(AzerothPrivacy.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    private static void initAsync() {
        Runnable r100 = new b();
        c.f478390a.execute(r100);
    }

    private static void lambda$initAsync$1() {
        apa.a.a(TAG, "initAsync start");     // Catch: Exception -> L4
        zoa.a.a();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        xoa.a.a(e, "initAsync exception", null);
    }

    private static void lambda$invokeAfterLogin$3() {
        com.privacy.azerothprivacy.userAuthToken.b.f404399b.a();
    }

    public static synchronized void invokeAfterLogout() {
        monitor-enter(AzerothPrivacy.class);
    L46:
        th = move-exception;
        throw th;
    L5:
        if (hasInitiated == true) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return;
    L8:
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L46
        String r101 = appInfo.f530146e;     // Catch: Throwable -> L46
        String r102 = "user logout: " + r101;     // Catch: Throwable -> L23 Exception -> L25
        if (apa.a.f15862a == null) goto L15;
        apa.a.f15862a.i(r102);     // Catch: Throwable -> L23 Exception -> L25
    L15:
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L35;
        long r103 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L46
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L46
        r104.put("running_status", 1);     // Catch: JSONException -> L19 Throwable -> L46
        r105.put("running_time", r103);     // Catch: JSONException -> L19 Throwable -> L46
        r106.put("user_id", null);     // Catch: JSONException -> L19 Throwable -> L46
    L34:
        bpa.a.b("invokeAfterLogout", r104, r105, r106);     // Catch: Throwable -> L46
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L46
    L35:
        monitor-exit(AzerothPrivacy.class);
        return;
    L23:
        th = move-exception;
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L45;
        long r107 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L46
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L46
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L46
        r108.put("running_status", 1);     // Catch: JSONException -> L42 Throwable -> L46
        r109.put("running_time", r107);     // Catch: JSONException -> L42 Throwable -> L46
        r110.put("user_id", r101);     // Catch: JSONException -> L42 Throwable -> L46
    L44:
        bpa.a.b("invokeAfterLogout", r108, r109, r110);     // Catch: Throwable -> L46
        goto L45
    L42:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L46
    L45:
        throw th;     // Catch: Throwable -> L46
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        HashMap r111 = new HashMap();     // Catch: Throwable -> L23
        r111.put("user_id", r101);     // Catch: Throwable -> L23
        xoa.a.a(e, "invokeAfterLogout exception", r111);     // Catch: Throwable -> L23
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L35;
        long r112 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L46
        r104 = new JSONObject();     // Catch: Throwable -> L46
        r105 = new JSONObject();     // Catch: Throwable -> L46
        r106 = new JSONObject();     // Catch: Throwable -> L46
        r104.put("running_status", 2);     // Catch: JSONException -> L32 Throwable -> L46
        r105.put("running_time", r112);     // Catch: JSONException -> L32 Throwable -> L46
        r106.put("user_id", r101);     // Catch: JSONException -> L32 Throwable -> L46
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L46
        goto L34
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static Application getApplication() {
        return f404393app;
    }

    public static boolean isInitiated() {
        return hasInitiated;
    }

    public static synchronized void invokeAfterLogin(final String r100) {
        monitor-enter(AzerothPrivacy.class);
    L47:
        th = move-exception;
        throw th;
    L5:
        if (hasInitiated == true) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return;
    L8:
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L47
        int r102 = 1;
        String r103 = "user login: " + r100;     // Catch: Throwable -> L24 Exception -> L26
        if (apa.a.f15862a == null) goto L14;
        apa.a.f15862a.i(r103);     // Catch: Throwable -> L24 Exception -> L26
    L14:
        appInfo.f530146e = r100;     // Catch: Throwable -> L24 Exception -> L26
        ThreadMethodProxy.start(new PthreadThreadV2(new poa.c(r100), "zerothPrivacy"));     // Catch: Throwable -> L24 Exception -> L26
        c.f478390a.execute(new poa.d());     // Catch: Throwable -> L24 Exception -> L26
    L16:
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L36;
        long r104 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L47
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L47
        r105.put("running_status", 1);     // Catch: JSONException -> L20 Throwable -> L47
        r106.put("running_time", r104);     // Catch: JSONException -> L20 Throwable -> L47
        r107.put("user_id", r100);     // Catch: JSONException -> L20 Throwable -> L47
    L35:
        bpa.a.b("invokeAfterLogin", r105, r106, r107);     // Catch: Throwable -> L47
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L36:
        monitor-exit(AzerothPrivacy.class);
        return;
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        r102 = 2;
        HashMap r108 = new HashMap();     // Catch: Throwable -> L24
        r108.put("user_id", r100);     // Catch: Throwable -> L24
        xoa.a.a(e, "invokeAfterLogin exception", r108);     // Catch: Throwable -> L24
    L29:
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L36;
        long r109 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L47
        r105 = new JSONObject();     // Catch: Throwable -> L47
        r106 = new JSONObject();     // Catch: Throwable -> L47
        r107 = new JSONObject();     // Catch: Throwable -> L47
        r105.put("running_status", 2);     // Catch: JSONException -> L33 Throwable -> L47
        r106.put("running_time", r109);     // Catch: JSONException -> L33 Throwable -> L47
        r107.put("user_id", r100);     // Catch: JSONException -> L33 Throwable -> L47
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L24:
        th = move-exception;
        if (d.a().azerothGlobalSettings.global_function_switch == false) goto L46;
        long r110 = System.currentTimeMillis() - r101;     // Catch: Throwable -> L47
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L47
        JSONObject r113 = new JSONObject();     // Catch: Throwable -> L47
        r111.put("running_status", r102);     // Catch: JSONException -> L43 Throwable -> L47
        r112.put("running_time", r110);     // Catch: JSONException -> L43 Throwable -> L47
        r113.put("user_id", r100);     // Catch: JSONException -> L43 Throwable -> L47
    L45:
        bpa.a.b("invokeAfterLogin", r111, r112, r113);     // Catch: Throwable -> L47
        goto L46
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
    L46:
        throw th;     // Catch: Throwable -> L47
    }

    private static void lambda$init$0(a r100) {
        toa.d r101 = toa.d.f546986h;
        Context r102 = appContext;
        String r103 = r100.f530146e;
        monitor-enter(r101);
        Key r104 = toa.d.h(r102, r103, null);     // Catch: Throwable -> L14
        if (r104 != null) goto L8;
    L11:
        r101.c(r102, r103);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
        return;
    L8:
        if (toa.d.g(r102, r103, null) == null) goto L11;
        toa.d.k(r102, r103, r104);     // Catch: Throwable -> L14
        qoa.b.b(r102, new KeyAgreementUpdater());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static void lambda$invokeAfterLogin$2(String r100) {
        toa.d r101 = toa.d.f546986h;
        Context r102 = appContext;
        monitor-enter(r101);
        Key r103 = toa.d.h(r102, r100, null);     // Catch: Throwable -> L14
        if (r103 != null) goto L8;
    L11:
        r101.c(r102, r100);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
        return;
    L8:
        if (toa.d.g(r102, r100, null) == null) goto L11;
        toa.d.k(r102, r100, r103);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static voa.a encryptArray(Context r100, byte[] r101) {
        if (TextUtils.isEmpty(appInfo.f530146e) == false) goto L7;
        new Exception("UID is not found");
        return new voa.a();
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        if (d.a().cryptoSetting.disable_crypto == true) goto L24;
        JSONObject r102 = new JSONObject();
        long r103 = System.currentTimeMillis();
        r102.put("SYMMETRIC", "EncryptArray");     // Catch: JSONException -> L14
    L16:
        int r104 = 0;
        toa.d.f546986h.getClass();     // Catch: Throwable -> L19 Exception -> L21
        uoa.a.a(r101, toa.d.a(r100));     // Catch: Throwable -> L19 Exception -> L21
        voa.a r105 = new voa.a();     // Catch: Throwable -> L19 Exception -> L21
    L18:
        bpa.a.d(r103, r104, r102);
        return r105;
    L21:
        e = move-exception;
        HashMap r106 = new HashMap();     // Catch: Throwable -> L19
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L19
        r106.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L19
        xoa.a.a(e, "AES encryption exception", r106);     // Catch: Throwable -> L19
        r104 = 1;
        r105 = new voa.a();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        bpa.a.d(r103, r104, r102);
        throw th;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L16
    L24:
        return new voa.a();
    L28:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    public static voa.b encryptString(Context r100, String r110) {
        if (TextUtils.isEmpty(appInfo.f530146e) == false) goto L7;
        return new voa.b(r110, 2, new Exception("UID is not found"));
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L32;
        int r101 = 1;
        if (d.a().cryptoSetting.disable_crypto == true) goto L40;
        JSONObject r102 = new JSONObject();
        long r103 = System.currentTimeMillis();
        r102.put("SYMMETRIC", "EncryptString");     // Catch: JSONException -> L14
    L33:
        toa.d.f546986h.getClass();     // Catch: Throwable -> L19 Exception -> L21
        uoa.b r104 = toa.d.a(r100);     // Catch: Throwable -> L19 Exception -> L21
        voa.b r105 = new voa.b(Base64.encodeToString(uoa.a.a(r110.getBytes("UTF-8"), r104), 2), 0, null);     // Catch: Throwable -> L19 Exception -> L21
        bpa.a.d(r103, 0, r102);
        return r105;
    L21:
        e = move-exception;
        HashMap r106 = new HashMap();     // Catch: Throwable -> L19
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L19
        r106.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L19
        xoa.a.a(e, "AES encryption exception", r106);     // Catch: Throwable -> L19
        voa.b r107 = new voa.b(r110, 2, e);     // Catch: Throwable -> L26
        bpa.a.d(r103, 1, r102);
        return r107;
    L26:
        th = th;
    L29:
        bpa.a.d(r103, r101, r102);
        throw th;
    L19:
        th = th;
        r101 = 0;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L33
    L40:
        return new voa.b(r110, 1, null);
    L32:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    public static voa.a decryptArray(Context r100, byte[] r101, byte[] r110) {
        if (TextUtils.isEmpty(appInfo.f530146e) == false) goto L7;
        new Exception("UID is not found");
        return new voa.a();
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L42;
        if (d.a().cryptoSetting.disable_crypto == true) goto L49;
        JSONObject r111 = new JSONObject();
        long r102 = System.currentTimeMillis();
        Key r103 = null;
        r111.put("SYMMETRIC", "DecryptString");     // Catch: JSONException -> L14
    L16:
        int r104 = 0;
        uoa.d r105 = new uoa.d(r101);     // Catch: Throwable -> L24 Exception -> L26
        if (Arrays.equals(r105.f550966a, uoa.d.f550964e) == false) goto L29;
        toa.d r106 = toa.d.f546986h;     // Catch: Throwable -> L24 Exception -> L26
        long r107 = r105.f550967b;     // Catch: Throwable -> L24 Exception -> L26
        r106.getClass();     // Catch: Throwable -> L24 Exception -> L26
        r103 = toa.d.h(r100, getAppInfo().f530146e, Long.valueOf(r107));     // Catch: Throwable -> L24 Exception -> L26
        if (r103 == null) goto L23;
    L31:
        Cipher r108 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Throwable -> L24 Exception -> L26
        r108.init(2, r103, new GCMParameterSpec(128, r105.f550968c));     // Catch: Throwable -> L24 Exception -> L26
        r108.doFinal(r105.f550969d);     // Catch: Throwable -> L24 Exception -> L26
        voa.a r109 = new voa.a();     // Catch: Throwable -> L24 Exception -> L26
        bpa.a.d(r102, 0, r111);
        return r109;
    L23:
        throw new KeyStoreException("null key returned");     // Catch: Throwable -> L24 Exception -> L26
    L29:
        if (Arrays.equals(r105.f550966a, uoa.d.f550965f) == false) goto L31;
        toa.d r112 = toa.d.f546986h;     // Catch: Throwable -> L24 Exception -> L26
        long r113 = r105.f550967b;     // Catch: Throwable -> L24 Exception -> L26
        r112.getClass();     // Catch: Throwable -> L24 Exception -> L26
        r103 = toa.d.b(r100, r113);     // Catch: Throwable -> L24 Exception -> L26
    L26:
        e = move-exception;
        HashMap r114 = new HashMap();     // Catch: Throwable -> L24
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L24
        r114.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L24
        xoa.a.a(e, "AES decryption exception", r114);     // Catch: Throwable -> L24
        voa.a r115 = new voa.a();     // Catch: Throwable -> L37
        bpa.a.d(r102, 2, r111);
        return r115;
    L37:
        th = th;
        r104 = 2;
    L39:
        bpa.a.d(r102, r104, r111);
        throw th;
    L24:
        th = th;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L16
    L49:
        return new voa.a();
    L42:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    public static voa.b decryptString(Context r110, String r111, String r112) {
        int r100 = 2;
        if (TextUtils.isEmpty(appInfo.f530146e) == false) goto L7;
        return new voa.b(r112, 2, new Exception("UID is not found"));
    L7:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L44;
        if (d.a().cryptoSetting.disable_crypto == true) goto L51;
        JSONObject r101 = new JSONObject();
        long r102 = System.currentTimeMillis();
        r101.put("SYMMETRIC", "DecryptString");     // Catch: JSONException -> L14
    L50:
        uoa.d r103 = new uoa.d(r111);     // Catch: Exception -> L24 Throwable -> L32
        if (Arrays.equals(r103.f550966a, uoa.d.f550964e) == false) goto L27;
        toa.d r113 = toa.d.f546986h;     // Catch: Exception -> L24 Throwable -> L32
        long r104 = r103.f550967b;     // Catch: Exception -> L24 Throwable -> L32
        r113.getClass();     // Catch: Exception -> L24 Throwable -> L32
        Key r114 = toa.d.h(r110, getAppInfo().f530146e, Long.valueOf(r104));     // Catch: Exception -> L24 Throwable -> L32
        if (r114 == null) goto L23;
    L30:
        Cipher r115 = Cipher.getInstance(SecurityUtil.ENCRYPT_GCM);     // Catch: Exception -> L24 Throwable -> L32
        r115.init(2, r114, new GCMParameterSpec(128, r103.f550968c));     // Catch: Exception -> L24 Throwable -> L32
        voa.b r116 = new voa.b(new String(r115.doFinal(r103.f550969d)), 0, null);     // Catch: Exception -> L24 Throwable -> L32
        bpa.a.d(r102, 0, r101);
        return r116;
    L23:
        throw new KeyStoreException("null key returned");     // Catch: Exception -> L24 Throwable -> L32
    L27:
        if (Arrays.equals(r103.f550966a, uoa.d.f550965f) == false) goto L29;
        toa.d r117 = toa.d.f546986h;     // Catch: Exception -> L24 Throwable -> L32
        long r105 = r103.f550967b;     // Catch: Exception -> L24 Throwable -> L32
        r117.getClass();     // Catch: Exception -> L24 Throwable -> L32
        r114 = toa.d.b(r110, r105);     // Catch: Exception -> L24 Throwable -> L32
        goto L30
    L29:
        r114 = null;
    L24:
        e = move-exception;
        HashMap r118 = new HashMap();     // Catch: Throwable -> L32
        epa.a.b(getAppContext()).getClass();     // Catch: Throwable -> L32
        r118.put("shared_preference", epa.a.a().toString());     // Catch: Throwable -> L32
        xoa.a.a(e, "AES decryption exception", r118);     // Catch: Throwable -> L32
        voa.b r119 = new voa.b(r112, 2, e);     // Catch: Throwable -> L38
        bpa.a.d(r102, 2, r101);
        return r119;
    L38:
        th = th;
    L41:
        bpa.a.d(r102, r100, r101);
        throw th;
    L32:
        th = th;
        r100 = 0;
    L14:
        e = move-exception;
        xoa.a.a(e, "Json exception", null);
        goto L50
    L51:
        return new voa.b(r111, 1, null);
    L44:
        throw new IllegalStateException("This method cannot be called from the Main Thread");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized void init(Application r210, final a r211, f r212, NetworkClient r213, h r214, xoa.b r215, soa.b r216, apa.b r217) {
        monitor-enter(AzerothPrivacy.class);
    L159:
        th = move-exception;
        throw th;
    L5:
        if (hasInitiated == false) goto L8;
        monitor-exit(AzerothPrivacy.class);
        return;
    L8:
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L159
        f404393app = r210;     // Catch: Throwable -> L82 Exception -> L86
        appContext = r210.getApplicationContext();     // Catch: Throwable -> L82 Exception -> L86
        appInfo = r211;     // Catch: Throwable -> L82 Exception -> L86
        sdkConfig = r212;     // Catch: Throwable -> L82 Exception -> L86
        apa.a.f15862a = r217;     // Catch: Throwable -> L82 Exception -> L86
        fpa.d.f478391a = r213;     // Catch: Throwable -> L82 Exception -> L86
        d.f469618a = r214;     // Catch: Throwable -> L82 Exception -> L86
        xoa.a.f564690a = r215;     // Catch: Throwable -> L82 Exception -> L86
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L82 Exception -> L86
        long r102 = r101 - r100;
        bpa.a.a(appContext);     // Catch: Throwable -> L78 Exception -> L80
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L78 Exception -> L80
        long r104 = r103 - r101;
        long r110 = System.currentTimeMillis();     // Catch: Throwable -> L72 Exception -> L76
        long r105 = r110 - r103;
        Context r106 = appContext;     // Catch: Throwable -> L68 Exception -> L70
        ColdBootDelayExecutor r111 = new ColdBootDelayExecutor();     // Catch: Throwable -> L68 Exception -> L70
        qoa.b.a(r106, r111);     // Catch: Throwable -> L68 Exception -> L70
        qoa.b.b(r106, r111);     // Catch: Throwable -> L68 Exception -> L70
        qoa.b.a(appContext, new KeyAgreementUpdater());     // Catch: Throwable -> L68 Exception -> L70
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L68 Exception -> L70
        long r113 = r112 - r110;
        if (TextUtils.isEmpty(r211.f530146e) == false) goto L189;
    L22:
        long r114 = System.currentTimeMillis() - r112;
        initAsync();     // Catch: Throwable -> L56 Exception -> L58
        hasInitiated = true;     // Catch: Throwable -> L56 Exception -> L58
        if (apa.a.f15862a == null) goto L28;
        apa.a.f15862a.i("Azeroth SDK inited");     // Catch: Throwable -> L56 Exception -> L58
    L28:
        long r107 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L159
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L159
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L159
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L159
        r108.put("running_status", 1);     // Catch: JSONException -> L51 Throwable -> L159
        r109.put("running_time", r107);     // Catch: JSONException -> L51 Throwable -> L159
        if (r102 == (-1)) goto L34;
        r109.put("runningTimeSetAttr", r102);     // Catch: JSONException -> L51 Throwable -> L159
    L34:
        if (r104 == (-1)) goto L37;
        r109.put("runningTimeMonitorInit", r104);     // Catch: JSONException -> L51 Throwable -> L159
    L37:
        if (r105 == (-1)) goto L40;
        r109.put("runningTimePLOInit", r105);     // Catch: JSONException -> L51 Throwable -> L159
    L40:
        if (r113 == (-1)) goto L43;
        r109.put("runningTimeSetAlarm", r113);     // Catch: JSONException -> L51 Throwable -> L159
    L43:
        if (r114 == (-1)) goto L45;
        r109.put("runningTimeSessionKeyInit", r114);     // Catch: JSONException -> L51 Throwable -> L159
    L45:
        JSONObject r116 = r115;
        r116.put("user_id", r211.f530146e);     // Catch: JSONException -> L49 Throwable -> L159
        epa.a.b(getAppContext()).getClass();     // Catch: JSONException -> L49 Throwable -> L159
        r116.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L49 Throwable -> L159
    L54:
        String r117 = "sdk_init";
        JSONObject r118 = r116;
    L176:
        bpa.a.b(r117, r108, r109, r118);     // Catch: Exception -> L123 Throwable -> L159
    L125:
        monitor-exit(AzerothPrivacy.class);
        return;
    L123:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
    L49:
        e = e;
    L53:
        e.printStackTrace();     // Catch: Throwable -> L159
    L51:
        e = e;
        r116 = r115;
    L58:
        e = e;
    L174:
        e.printStackTrace();     // Catch: Throwable -> L131
        HashMap r119 = new HashMap();     // Catch: Throwable -> L131
        long r218 = r114;
        r119.put("app_info", r211.toString());     // Catch: Throwable -> L127
        if (r214 != null) goto L162;
    L99:
        xoa.a.a(e, "sdk init exception", r119);     // Catch: Throwable -> L127
        long r120 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L159
        r108 = new JSONObject();     // Catch: Throwable -> L159
        r109 = new JSONObject();     // Catch: Throwable -> L159
        r118 = new JSONObject();     // Catch: Throwable -> L159
        r108.put("running_status", 2);     // Catch: JSONException -> L118 Throwable -> L159
        r109.put("running_time", r120);     // Catch: JSONException -> L118 Throwable -> L159
        if (r102 == (-1)) goto L105;
        r109.put("runningTimeSetAttr", r102);     // Catch: JSONException -> L118 Throwable -> L159
    L105:
        if (r104 == (-1)) goto L108;
        r109.put("runningTimeMonitorInit", r104);     // Catch: JSONException -> L118 Throwable -> L159
    L108:
        if (r105 == (-1)) goto L111;
        r109.put("runningTimePLOInit", r105);     // Catch: JSONException -> L118 Throwable -> L159
    L111:
        if (r113 == (-1)) goto L114;
        r109.put("runningTimeSetAlarm", r113);     // Catch: JSONException -> L118 Throwable -> L159
    L114:
        if (r218 == (-1)) goto L116;
        r109.put("runningTimeSessionKeyInit", r218);     // Catch: JSONException -> L118 Throwable -> L159
    L116:
        r118.put("user_id", r211.f530146e);     // Catch: JSONException -> L118 Throwable -> L159
        epa.a.b(getAppContext()).getClass();     // Catch: JSONException -> L118 Throwable -> L159
        r118.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L118 Throwable -> L159
    L120:
        r117 = "sdk_init";
        goto L176
    L118:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
        goto L120
    L162:
        com.larus.security.api.a r121 = (com.larus.security.api.a) r214;     // Catch: Throwable -> L97
        r121.a();     // Catch: Throwable -> L97
        r119.put("settings", r121.a().toString());     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        long r122 = r113;
        int r123 = 2;
        long r124 = r105;
        long r125 = r102;
        long r126 = r104;
        Throwable r127 = th;
        long r128 = r218;
    L134:
        long r129 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L159
        JSONObject r130 = new JSONObject();     // Catch: Throwable -> L159
        Throwable r219 = r127;
        JSONObject r131 = new JSONObject();     // Catch: Throwable -> L159
        long r220 = r128;
        JSONObject r132 = new JSONObject();     // Catch: Throwable -> L159
        r130.put("running_status", r123);     // Catch: JSONException -> L152 Throwable -> L159
        r131.put("running_time", r129);     // Catch: JSONException -> L152 Throwable -> L159
        if (r125 == (-1)) goto L139;
        r131.put("runningTimeSetAttr", r125);     // Catch: JSONException -> L152 Throwable -> L159
    L139:
        if (r126 == (-1)) goto L142;
        r131.put("runningTimeMonitorInit", r126);     // Catch: JSONException -> L152 Throwable -> L159
    L142:
        if (r124 == (-1)) goto L145;
        r131.put("runningTimePLOInit", r124);     // Catch: JSONException -> L152 Throwable -> L159
    L145:
        if (r122 == (-1)) goto L148;
        r131.put("runningTimeSetAlarm", r122);     // Catch: JSONException -> L152 Throwable -> L159
    L148:
        if (r220 == (-1)) goto L150;
        r131.put("runningTimeSessionKeyInit", r220);     // Catch: JSONException -> L152 Throwable -> L159
    L150:
        r132.put("user_id", r211.f530146e);     // Catch: JSONException -> L152 Throwable -> L159
        epa.a.b(getAppContext()).getClass();     // Catch: JSONException -> L152 Throwable -> L159
        r132.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L152 Throwable -> L159
    L166:
        bpa.a.b("sdk_init", r130, r131, r132);     // Catch: Exception -> L156 Throwable -> L159
    L195:
        throw r219;     // Catch: Throwable -> L159
    L156:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
        throw r219;     // Catch: Throwable -> L159
    L152:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L159
    L127:
        Throwable th10 = th;
        r114 = r218;
    L132:
        r123 = 2;
    L133:
        long r133 = r104;
        r127 = th10;
        r128 = r114;
        r122 = r113;
        r124 = r105;
        r125 = r102;
        r126 = r133;
    L131:
        th10 = th;
    L56:
        th10 = th;
        r123 = 1;
        goto L133
    L62:
        e = e;
    L67:
        r114 = -1;
    L60:
        th = th;
    L75:
        long r134 = -1;
    L85:
        r122 = r113;
        r124 = r105;
        r125 = r102;
        r126 = r104;
        r127 = th;
        r128 = r134;
        r123 = 1;
        goto L134
    L189:
        if (r211.f530146e.equals("0") == true) goto L22;
        ThreadMethodProxy.start(new PthreadThreadV2(new e(r211), "zerothPrivacy"));     // Catch: Throwable -> L60 Exception -> L62
        goto L22
    L66:
        e = e;
    L64:
        th = th;
        goto L75
    L70:
        e = e;
    L89:
        r114 = -1;
        r113 = -1;
    L68:
        th = th;
    L74:
        r113 = -1;
        goto L75
    L76:
        e = e;
    L88:
        r105 = -1;
    L72:
        th = th;
        r105 = -1;
        goto L74
    L80:
        e = e;
        r104 = -1;
    L78:
        th = th;
    L84:
        r134 = -1;
        r104 = -1;
        r105 = -1;
        r113 = -1;
        goto L85
    L86:
        e = e;
        r104 = -1;
        r102 = -1;
    L82:
        th = th;
        r102 = -1;
        goto L84
    }
}
