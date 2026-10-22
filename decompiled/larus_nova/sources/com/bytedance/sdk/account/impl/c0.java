package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.network.dispatcher.IRequest;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.settings.common.ErrorCodeTransferUtil;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.facebook.net.NetUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.token.TokenFactory;
import com.ss.android.update.UpdateService;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Lazy;
import kotlin.reflect.KProperty;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONObject;
import ua7.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0<R extends ua7.b> implements wa7.b, wa7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f268952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lb7.a f268953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public lb7.b f268954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public wqa.k f268955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ua7.a<R> f268956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.sdk.account.impl.b f268957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f268958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile d f268959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f268960i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f268961j;

    public static class a {
        public a() {
        }
    }

    public static class b {
        public b() {
        }
    }

    public static class c extends com.bytedance.sdk.account.utils.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final wa7.b f268962h;

        /* JADX WARN: Multi-variable type inference failed */
        public final void b() {
            c0 r100 = (c0) this.f268962h;
            ua7.b r101 = r100.c();
            if (r101 == null) goto L39;
            lb7.b r102 = r100.f268954c;
            if (r102 == null) goto L8;
            r101.f549250d = r102.f508368d;
            r101.f549247a = r102.f508370f;
            r101.f549248b = r102.f508371g;
            r101.f549258l = r102.f508373i;
            r101.f549259m = r102.f508374j;
            r101.f549260n = r100.f268958g;
        L8:
            if (TextUtils.isEmpty(r101.f549250d) == false) goto L12;
            lb7.a r103 = r100.f268953b;
            if (r103 == null) goto L12;
            r101.f549250d = r103.f508352a;
        L12:
            r100.h(r101);
            lb7.b r104 = r100.f268954c;
            if (r104 == null) goto L34;
            int r105 = r104.f508366b;
            if (r105 == 0) goto L34;
            com.bytedance.sdk.account.utils.b.f269536a.b(r105);
            b0 r106 = new b0(r100, false, r101);
            Iterator r107 = ((ArrayList) jb7.b.f498010b).iterator();
        L18:
            if (r107.hasNext() == false) goto L22;
            if (((jb7.a) r107.next()).b(r100.f268954c.f508366b, r100.f268953b.f508354c, r101, r106) == false) goto L18;
            return;
        L22:
            int r108 = r100.f268954c.f508366b;
            Map<Integer, jb7.a> r109 = jb7.b.f498009a;
            HashMap r110 = (HashMap) r109;
            jb7.a r111 = (jb7.a) r110.get(Integer.valueOf(r108));
            if (r111 != null) goto L26;
            r111 = null;
        L26:
            if (r111 == null) goto L31;
            if (r111.b(r100.f268954c.f508366b, r100.f268953b.f508354c, r101, r106) == false) goto L31;
            return;
        L31:
            if (r100.o(r101, false) == true) goto L41;
            com.bytedance.sdk.account.monitor.c.f(r100.f268954c.f508368d, r101, r100.f268959h.f268977o, 0);
            goto L34
        L41:
            return;
        L34:
            r100.g(r101);
            return;
        }

        @Override // com.bytedance.sdk.account.network.dispatcher.b, java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(wa7.b r100) {
            this.f268962h = r100;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f268963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f268964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f268965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f268966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f268967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f268968f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f268969g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f268970h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f268971i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f268972j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f268973k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f268974l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f268975m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f268976n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Throwable f268977o;

        public d() {
            this.f268963a = 0;
            this.f268964b = "";
            this.f268965c = "";
            this.f268966d = "";
            this.f268967e = "";
            this.f268968f = "";
            this.f268972j = "";
            this.f268973k = "";
            this.f268974l = false;
            this.f268975m = false;
            this.f268976n = "";
            this.f268977o = null;
        }
    }

    public abstract void h(R r100);

    public abstract void i(JSONObject r100, JSONObject r101);

    public abstract void k(JSONObject r100, JSONObject r101) throws Exception;

    public abstract R n(boolean r100, lb7.b r101);

    static {
        new a();
        new b();
    }

    public R c() {
        boolean r100 = false;
        this.f268961j = false;
        this.f268959h = new d();
        this.f268961j = d();     // Catch: Throwable -> L5
        tb7.a.a("BaseAccountApi", "executeRequest path: " + this.f268953b.f508352a + "  executeStatus: " + this.f268961j);     // Catch: Throwable -> L5
    L45:
        ua7.e r101 = (R) n(this.f268961j, this.f268954c);
        int r102 = r101.f549253g;
        if (r102 == 0) goto L48;
        ((ArrayList) this.f268958g).add(Integer.valueOf(r102));
    L48:
        int r103 = this.f268954c.f508366b;
        if (r103 < 0) goto L51;
        if (r103 <= 0) goto L66;
        r101.f549254h = r103;
        if ((r101 instanceof ua7.e) == true) goto L66;
    L66:
        if (r103 != 0) goto L68;
    L74:
        return r101;
    L68:
        if (TextUtils.isEmpty(r101.f549256j) == false) goto L74;
        String r104 = this.f268954c.f508369e;
        if (r104 != null) goto L73;
        r104 = "";
    L73:
        r101.f549256j = r104;
        goto L74
    L51:
        if (r103 != (-26)) goto L53;
    L56:
        r101.f549253g = -1009;
    L57:
        r101.f549254h = r103;
        if ((r101 instanceof ua7.e) == false) goto L66;
        T r105 = r101.f549264p;
        if (r105 == 0) goto L66;
        r105.f559013a = r101.f549253g;
        goto L66
    L53:
        if (r103 == (-27)) goto L56;
        r101.f549253g = -1005;
    L5:
        th = move-exception;
        this.f268959h.f268977o = th;
        com.bytedance.sdk.account.impl.b r106 = this.f268957f;
        long r107 = System.currentTimeMillis();
        if (r106.f268940a == false) goto L10;
        r106.f268945f = r107;
    L10:
        tb7.a.b("BaseAccountApi", "executeRequest failed with exception, path:" + this.f268953b.f508352a + ", error:" + th);
        lb7.b r108 = this.f268954c;
        Context r109 = this.f268952a;
        sa7.k r110 = com.ss.android.account.k.d().a();
        if (r110 == null) goto L16;
        int r111 = r110.checkResponseException(th);
        if (r111 >= 0) goto L16;
    L44:
        r108.f508366b = r111;
        this.f268954c.f508369e = th.getMessage();
    L16:
        if ((th instanceof ConnectTimeoutException) == false) goto L19;
        r111 = -13;
    L32:
        if (r109 == null) goto L44;
        if (r111 == (-15)) goto L77;
        if (r111 != (-14)) goto L44;
    L77:
        NetworkInfo r112 = ((ConnectivityManager) r109.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L40
        if (r112 == null) goto L42;
        if (r112.isAvailable() == false) goto L42;
        r100 = true;
    L42:
        if (r100 == true) goto L44;
        r111 = -12;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L19:
        if ((th instanceof SocketTimeoutException) == false) goto L22;
        r111 = -14;
        goto L32
    L22:
        if ((th instanceof SocketException) == false) goto L25;
        tb7.a.f545271a.b(2, NetUtils.TAG, "api socket exception: " + th, null);
    L30:
        r111 = -15;
        goto L32
    L25:
        if ((th instanceof SSLPeerUnverifiedException) == false) goto L28;
        tb7.a.f545271a.b(2, NetUtils.TAG, "api ssl exception: " + th, null);
        r111 = -21;
        goto L32
    L28:
        if ((th instanceof IOException) == false) goto L31;
        tb7.a.f545271a.b(2, NetUtils.TAG, "api io exception: " + th, null);
        goto L30
    L31:
        tb7.a.e(NetUtils.TAG, "api exception: " + th);
        r111 = -18;
        goto L32
    }

    public final boolean d() throws Exception {
        if (this.f268952a != null) goto L6;
        lb7.b r100 = this.f268954c;
        r100.f508366b = -24;
        r100.f508369e = UpdateService.REASON_CONTEXT_IS_NULL;
        return false;
    L6:
        Map<String, String> r101 = this.f268953b.f508354c;
        if (r101 != null) goto L9;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L422;
    L25:
        lb7.a r103 = this.f268953b;
        Map<String, String> r104 = r103.f508354c;
        boolean r105 = r103.f508358g;
        if (r104 != null) goto L28;
    L39:
        if (r104 != null) goto L41;
        r104 = new HashMap();
    L41:
        wqa.h r106 = com.ss.android.account.k.f406319c;
        if (r106 == null) goto L48;
        Map<String, String> r107 = r106.f560774a;
        if (r107 == null) goto L48;
        if (((HashMap) r107).isEmpty() == true) goto L48;
        r104.putAll(r107);
    L48:
        lb7.a r108 = this.f268953b;
        Map<String, String> r109 = r108.f508354c;
        if (r109 != null) goto L51;
    L106:
        String r210 = "1";
        Map<String, String> r211 = r104;
        String r212 = "from";
    L107:
        this.f268953b = r108;
        long r110 = System.currentTimeMillis();
        com.bytedance.sdk.account.settings.common.a.a();
        mc7.a r111 = com.bytedance.sdk.account.settings.common.a.I;
        if (MonitorConstants.CONNECT_TYPE_GET.equals(this.f268953b.f508353b) == false) goto L128;
        lb7.a r112 = this.f268953b;
        String r113 = r112.f508352a;
        List<wqa.i> r114 = r112.f508355d;
        fc7.c r115 = NetworkUtils.c(r113);
        Iterator<Map.Entry<String, String>> r116 = r211.entrySet().iterator();
    L111:
        if (r116.hasNext() == false) goto L113;
        Map.Entry<String, String> r117 = r116.next();
        r115.a(r117.getKey(), r117.getValue());
        goto L111
    L113:
        if (r114 != null) goto L115;
        r114 = new ArrayList();
    L115:
        com.ss.android.account.k.d().d();
        r115.b("multi_login", r210);
        b(r114, r113);
        a(r113, r114);
        r115.b("account_sdk_source", "app");
        r115.b("passport_support_flow", jb7.b.f498011c);
        String r118 = r115.toString();
        this.f268954c.f508368d = r118;
        com.bytedance.sdk.account.impl.b r119 = this.f268957f;
        long r120 = System.currentTimeMillis();
        if (r119.f268940a == false) goto L119;
        r119.f268944e = r120;
    L119:
        int r121 = this.f268953b.f508359h;
        sa7.k r122 = com.ss.android.account.k.d().a();
        if (r122 == null) goto L122;
        wqa.k r123 = r122.e(r118, r114, r121);
    L123:
        com.bytedance.sdk.account.impl.b r124 = this.f268957f;
        long r125 = System.currentTimeMillis();
        if (r124.f268940a == false) goto L127;
        r124.f268945f = r125;
    L127:
        this.f268955d = r123;
    L161:
        long r126 = System.currentTimeMillis() - r110;
        wqa.k r127 = this.f268955d;
        if (r127 != null) goto L164;
    L378:
        long r128 = r110;
    L379:
        wqa.k r129 = this.f268955d;
        if (r129 != null) goto L382;
    L397:
        lb7.b r130 = this.f268954c;
        r130.f508366b = -25;
        r130.f508369e = "response null";
        return false;
    L382:
        if (StringUtils.isEmpty(r129.f560780c) == true) goto L397;
        JSONObject r131 = new JSONObject(this.f268955d.f560780c);
        this.f268954c.f508374j = r131;
        JSONObject r132 = j(r131);
        String r133 = r131.optString("message");
    L393:
        e = move-exception;
        e.printStackTrace();
        boolean r213 = false;
    L395:
        f(r126, this.f268954c.f508370f, r128);
        return r213;
    L386:
        if (TextUtils.isEmpty(r133) == true) goto L389;
        boolean r134 = l(r131, r132, r133);     // Catch: Exception -> L393
    L388:
        r213 = r134;
        goto L395
    L389:
        if (r132 == null) goto L391;
        r134 = l(r132, j(r132), r132.optString("message"));     // Catch: Exception -> L393
        goto L388
    L391:
        r134 = l(r131, new JSONObject(), "success");     // Catch: Exception -> L393
        goto L388
    L164:
        if (r127.f560779b == null) goto L378;
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Exception -> L375
        boolean r135 = com.bytedance.sdk.account.settings.common.b.f269404b;     // Catch: Exception -> L375
        com.bytedance.sdk.account.settings.common.b.a();     // Catch: Exception -> L375
        Collection<String> r136 = com.bytedance.sdk.account.settings.common.b.f269405c.f269551c;     // Catch: Exception -> L375
        List<wqa.i> r137 = r127.f560779b;     // Catch: Exception -> L375
        this.f268954c.f508373i = r137;     // Catch: Exception -> L375
        StringBuilder r138 = new StringBuilder();     // Catch: Exception -> L375
        Iterator<wqa.i> r139 = r137.iterator();     // Catch: Exception -> L375
        String r140 = "";
        String r141 = r140;
        String r142 = r141;
        String r143 = null;
    L168:
        String r144 = r140;
        r128 = r110;
        if (r139.hasNext() == false) goto L269;
        wqa.i r145 = r139.next();     // Catch: Exception -> L230
        String r146 = r145.f560775a;     // Catch: Exception -> L230
        if (TextUtils.isEmpty(r146) == false) goto L174;
        Iterator<wqa.i> r214 = r139;
    L267:
        r140 = r144;
    L268:
        r110 = r128;
        r139 = r214;
        goto L168
    L174:
        r214 = r139;
        String r147 = r145.f560776b;     // Catch: Exception -> L230
        if (TextUtils.isEmpty(r147) == true) goto L267;
        String r148 = r146.toLowerCase();     // Catch: Exception -> L230
        switch(r148.hashCode()) {
            case -1976085669: goto L211;
            case -1846329444: goto L208;
            case -1403626347: goto L205;
            case -1210797355: goto L202;
            case -694021551: goto L199;
            case -272647289: goto L196;
            case -265255391: goto L193;
            case 213977896: goto L190;
            case 458273718: goto L187;
            case 1200578924: goto L184;
            case 1237214767: goto L181;
            default: goto L213;
        };     // Catch: Exception -> L230
    L213:
        byte r149 = -1;
    L214:
        switch(r149) {
            case 0: goto L256;
            case 1: goto L253;
            case 2: goto L252;
            case 3: goto L251;
            case 4: goto L224;
            case 5: goto L222;
            case 6: goto L221;
            case 7: goto L220;
            case 8: goto L219;
            case 9: goto L218;
            case 10: goto L217;
            default: goto L215;
        };     // Catch: Exception -> L230
    L215:
        if (r135 == false) goto L267;
        if (r136.contains(r148) == false) goto L267;
        if (r138.length() <= 0) goto L263;
        r138.append(",");     // Catch: Exception -> L230
    L263:
        r138.append(r148);     // Catch: Exception -> L230
        r138.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L230
        if (TextUtils.isEmpty(r145.f560776b) == false) goto L266;
        r138.append(0);     // Catch: Exception -> L230
        goto L267
    L266:
        r138.append(1);     // Catch: Exception -> L230
        goto L267
    L217:
        this.f268959h.f268976n = r147;     // Catch: Exception -> L230
        goto L267
    L218:
        this.f268959h.f268972j = r147;     // Catch: Exception -> L230
        goto L267
    L219:
        r141 = r147;
        goto L267
    L220:
        r140 = r147;
        goto L268
    L221:
        r143 = r147;
        goto L267
    L222:
        this.f268954c.f508372h = r147;     // Catch: Exception -> L230
        this.f268959h.f268970h = true;     // Catch: Exception -> L230
        goto L267
    L251:
        j r150 = j.m(this.f268952a);     // Catch: Exception -> L230
        r150.H.c(r147);     // Catch: Exception -> L230
        r150.P0.edit().putString("session_sign", r147).apply();     // Catch: Exception -> L230
        goto L267
    L252:
        this.f268954c.f508370f = r147;     // Catch: Exception -> L230
        goto L267
    L253:
        Context r151 = this.f268952a;     // Catch: Exception -> L230
        if (r151 == null) goto L267;
        j.m(r151).f269041y.c(r147);     // Catch: Exception -> L230
        goto L267
    L256:
        Context r152 = this.f268952a;     // Catch: Exception -> L230
        if (r152 == null) goto L267;
        j r153 = j.m(r152);     // Catch: Exception -> L230
        r153.f269040x.c(r147);     // Catch: Exception -> L230
        r153.P0.edit().putString("multi_sids", r147).apply();     // Catch: Exception -> L230
        goto L267
    L224:
        if (r147.contains(InteractConst.INTENT_SESSION_ID) == false) goto L233;
        this.f268959h.f268969g = true;     // Catch: Exception -> L230
        CookieSyncManager.getInstance().sync();     // Catch: Throwable -> L228
    L228:
        th = move-exception;
        th.printStackTrace();     // Catch: Exception -> L230
        goto L267
    L233:
        if (r147.startsWith("passport_csrf_token=") == false) goto L235;
    L248:
        this.f268959h.f268971i = e(r147);     // Catch: Exception -> L230
        if (TextUtils.isEmpty(this.f268959h.f268971i) == true) goto L267;
        sa7.i.a(this.f268959h.f268971i);     // Catch: Exception -> L230
        goto L267
    L235:
        if (TextUtils.isEmpty(this.f268959h.f268971i) == false) goto L240;
        if (r147.startsWith("passport_csrf_token_default=") == true) goto L248;
    L240:
        if (r147.startsWith("d_ticket=") == false) goto L243;
        r142 = e(r147);     // Catch: Exception -> L230
        goto L267
    L243:
        if (r147.startsWith("session_tlb_tag") == false) goto L246;
        this.f268959h.f268974l = true;     // Catch: Exception -> L230
        goto L267
    L246:
        if (r147.startsWith("token_tlb_tag") == false) goto L267;
        this.f268959h.f268975m = true;     // Catch: Exception -> L230
        goto L267
    L181:
        if (r148.equals("set-cookie") == false) goto L213;
        r149 = 4;
        goto L214
    L184:
        if (r148.equals("x-tt-session-sign") == false) goto L213;
        r149 = 3;
        goto L214
    L187:
        if (r148.equals("x-tt-passport-tlb-tag-result") == false) goto L213;
        r149 = 10;
        goto L214
    L190:
        if (r148.equals("x-tt-passport-ip-match-result") == false) goto L213;
        r149 = 6;
        goto L214
    L193:
        if (r148.equals("x-tt-token") == false) goto L213;
        r149 = 5;
        goto L214
    L196:
        if (r148.equals(NetResponse.HEADER_KEY_LOG_ID) == false) goto L213;
        r149 = 2;
        goto L214
    L199:
        if (r148.equals("x-tt-multi-sids") == false) goto L213;
        r149 = 0;
        goto L214
    L202:
        if (r148.equals("x-tt-multi-sids-sec") == false) goto L213;
        r149 = 1;
        goto L214
    L205:
        if (r148.equals("d-ticket") == false) goto L213;
        r149 = 8;
        goto L214
    L208:
        if (r148.equals("d-ticket-sec-uid") == false) goto L213;
        r149 = 7;
        goto L214
    L211:
        if (r148.equals("bd-ticket-guard-result") == false) goto L213;
        r149 = 9;
    L230:
        e = e;
    L377:
        e.printStackTrace();
        goto L379
    L269:
        StringBuilder r154 = new StringBuilder();     // Catch: Exception -> L230
        wqa.j r155 = r127.f560781d;     // Catch: Exception -> L230
        if (r155 == null) goto L308;
        List<wqa.i> r156 = r155.f560777a;     // Catch: Exception -> L230
        if (r156 == null) goto L308;
        Iterator<wqa.i> r157 = r156.iterator();     // Catch: Exception -> L230
    L275:
        if (r157.hasNext() == false) goto L308;
        wqa.i r158 = r157.next();     // Catch: Exception -> L230
        if (r158 == null) goto L275;
        if (TextUtils.isEmpty(r158.f560775a) == true) goto L275;
        String r159 = r158.f560775a.toLowerCase();     // Catch: Exception -> L230
        String r160 = r158.f560776b;     // Catch: Exception -> L230
        if (TextUtils.isEmpty(r160) == true) goto L275;
        if ("x-tt-token".equals(r159) == false) goto L288;
        this.f268959h.f268964b = r160;     // Catch: Exception -> L230
        Iterator<wqa.i> r215 = r157;
    L307:
        r157 = r215;
        goto L275
    L288:
        r215 = r157;
        if (AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION.equals(r159) == false) goto L292;
        this.f268959h.f268965c = r160;     // Catch: Exception -> L230
        goto L307
    L292:
        if ("bd-ticket-guard-iteration-version".equals(r159) == false) goto L295;
        this.f268959h.f268966d = r160;     // Catch: Exception -> L230
        goto L307
    L295:
        if ("bd-ticket-guard-client-data".equals(r159) == false) goto L297;
        this.f268959h.f268967e = r160;     // Catch: Exception -> L230
        goto L307
    L297:
        if (r135 == false) goto L307;
        if (r136.contains(r159) == false) goto L307;
        if (r154.length() <= 0) goto L303;
        r154.append(",");     // Catch: Exception -> L230
    L303:
        r154.append(r159);     // Catch: Exception -> L230
        r154.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L230
        if (TextUtils.isEmpty(r160) == false) goto L306;
        r154.append(0);     // Catch: Exception -> L230
        goto L307
    L306:
        r154.append(1);     // Catch: Exception -> L230
    L308:
        boolean r161 = true;
        if (r135 == false) goto L327;
        Iterator<String> r162 = r136.iterator();     // Catch: Exception -> L230
    L312:
        if (r162.hasNext() == false) goto L325;
        String r163 = r162.next();     // Catch: Exception -> L230
        if (r154.indexOf(r163) >= 0) goto L320;
        if (r154.length() <= 0) goto L318;
        r154.append(",");     // Catch: Exception -> L230
    L318:
        r154.append(r163);     // Catch: Exception -> L230
        r154.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L230
        r154.append(0);     // Catch: Exception -> L230
    L320:
        if (r138.indexOf(r163) >= 0) goto L312;
        if (r138.length() <= 0) goto L324;
        r138.append(",");     // Catch: Exception -> L230
    L324:
        r138.append(r163);     // Catch: Exception -> L230
        r138.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L230
        r138.append(0);     // Catch: Exception -> L230
        goto L312
    L325:
        this.f268959h.f268968f = r154.toString();     // Catch: Exception -> L230
        this.f268959h.f268973k = r138.toString();     // Catch: Exception -> L230
    L327:
        if (TextUtils.isEmpty(r143) == false) goto L329;
    L343:
        String r164 = r144;
        SharedPreferences r165 = null;
    L345:
        if (TextUtils.isEmpty(r164) == true) goto L379;
        if (TextUtils.isEmpty(r141) == false) goto L349;
        String r166 = r142;
    L351:
        if (TextUtils.isEmpty(r166) == true) goto L379;
        SharedPreferences r167 = ib7.a.f488997a;     // Catch: Exception -> L230
        if (r164.length() == 0) goto L356;
        r161 = false;
    L356:
        if (r161 == true) goto L379;
        if (ib7.a.f488997a != null) goto L367;
        wqa.f r168 = com.ss.android.account.k.f406318b;     // Catch: Exception -> L230
        if (r168 == null) goto L365;
        Context r169 = r168.getApplicationContext();     // Catch: Exception -> L230
        if (r169 == null) goto L365;
        SharedPreferences r170 = r169.getSharedPreferences("account_sdk_d_ticket", 0);     // Catch: Exception -> L230
    L366:
        ib7.a.f488997a = r170;     // Catch: Exception -> L230
    L365:
        r170 = r165;
    L367:
        SharedPreferences r171 = ib7.a.f488997a;     // Catch: Exception -> L230
        if (r171 == null) goto L379;
        SharedPreferences.Editor r172 = r171.edit();     // Catch: Exception -> L230
        if (r172 == null) goto L379;
        SharedPreferences.Editor r173 = r172.putString(r164, r166);     // Catch: Exception -> L230
        if (r173 == null) goto L379;
        r173.apply();     // Catch: Exception -> L230
        goto L379
    L349:
        r166 = r141;
        goto L351
    L329:
        if (SliceInitService.DEFAULT_SWITCH.equals(r143) == true) goto L343;
        JSONObject r174 = new JSONObject(r143);     // Catch: Throwable -> L340
        r165 = null;
        r164 = r144;
        com.bytedance.sdk.account.monitor.c.e(this.f268953b.a(r212), com.bytedance.sdk.account.utils.q.a(this.f268953b.f508352a), this.f268954c.f508370f, r174.optString("ip_match", null), r174.optString("pre_ip_match", null), r111);     // Catch: Throwable -> L336
    L336:
        th = th;
    L342:
        tb7.a.d("BaseAccountApi", "parse x-tt-passport-ip-match-result fail, value=" + r143 + ", error=" + th.getMessage());     // Catch: Exception -> L230
    L338:
        th = th;
        r164 = r144;
    L340:
        th = th;
        r164 = r144;
        r165 = null;
    L375:
        e = e;
        r128 = r110;
        goto L377
    L122:
        r123 = null;
        goto L123
    L128:
        String r175 = r210;
        if (UGCMonitor.TYPE_POST.equals(this.f268953b.f508353b) == false) goto L142;
        lb7.a r176 = this.f268953b;
        String r177 = r176.f508352a;
        List<wqa.i> r178 = r176.f508355d;
        HashMap r179 = new HashMap();
        fc7.c r180 = NetworkUtils.c(r177);
        r179.putAll(r211);
        r179.put("account_sdk_source", "app");
        r179.put("passport_support_flow", jb7.b.f498011c);
        if (r178 != null) goto L133;
        r178 = new ArrayList();
    L133:
        com.ss.android.account.k.d().d();
        r179.put("multi_login", r175);
        b(r178, r177);
        a(r177, r178);
        String r181 = r180.toString();
        this.f268954c.f508368d = r181;
        com.bytedance.sdk.account.impl.b r182 = this.f268957f;
        long r183 = System.currentTimeMillis();
        if (r182.f268940a == false) goto L137;
        r182.f268944e = r183;
    L137:
        wqa.k r184 = NetworkUtils.a(r181, r179, r178, this.f268953b.f508359h);
        com.bytedance.sdk.account.impl.b r185 = this.f268957f;
        long r186 = System.currentTimeMillis();
        if (r185.f268940a == false) goto L141;
        r185.f268945f = r186;
    L141:
        this.f268955d = r184;
        goto L161
    L142:
        Map<String, String> r187 = r211;
        if ("post_file".equals(this.f268953b.f508353b) == false) goto L161;
        lb7.a r188 = this.f268953b;
        String r189 = r188.f508352a;
        List<wqa.i> r190 = r188.f508355d;
        String r191 = r188.f508356e;
        String r192 = r188.f508357f;
        HashMap r193 = new HashMap();
        fc7.c r194 = NetworkUtils.c(r189);
        r193.putAll(r187);
        r193.put("account_sdk_source", "app");
        r193.put("passport_support_flow", jb7.b.f498011c);
        if (r190 != null) goto L147;
        r190 = new ArrayList();
    L147:
        com.ss.android.account.k.d().d();
        r193.put("multi_login", r175);
        b(r190, r189);
        a(r189, r190);
        String r195 = r194.toString();
        this.f268954c.f508368d = r195;
        com.bytedance.sdk.account.impl.b r196 = this.f268957f;
        long r197 = System.currentTimeMillis();
        if (r196.f268940a == false) goto L151;
        r196.f268944e = r197;
    L151:
        sa7.k r198 = com.ss.android.account.k.d().a();
        if (r198 == null) goto L154;
        wqa.k r199 = r198.d(r195, r193, r191, r192, r190);
    L155:
        com.bytedance.sdk.account.impl.b r200 = this.f268957f;
        long r201 = System.currentTimeMillis();
        if (r200.f268940a == false) goto L159;
        r200.f268945f = r201;
    L159:
        this.f268955d = r199;
        goto L161
    L154:
        r199 = null;
        goto L155
    L51:
        if (r109.isEmpty() == true) goto L106;
        com.bytedance.sdk.account.settings.common.a.a();
        mc7.a r202 = com.bytedance.sdk.account.settings.common.a.I;
        if (r202.f513238a == false) goto L106;
        String r1100 = r108.f508354c.get("from");
        if (TextUtils.isEmpty(r1100) == true) goto L106;
        if (r202.f513239b.contains(r1100) == false) goto L106;
        String r1101 = com.bytedance.sdk.account.utils.q.a(r108.f508352a);
        if (TextUtils.isEmpty(r1101) == true) goto L106;
        String r1102 = r108.f508354c.get("token");
        if (TextUtils.isEmpty(r1102) == false) goto L67;
        r1102 = r108.f508354c.get("validate_token");
    L67:
        if (TextUtils.isEmpty(r1102) == false) goto L69;
    L71:
        boolean r1103 = false;
    L72:
        if (r1103 == false) goto L106;
        r108.f508359h |= 536870912;
        tb7.a.d("BaseAccountApi", "processApiRequest(), set requestFlag:" + r108.f508359h + ", url=" + r108.f508352a);
        if (r202.f513241d == false) goto L106;
        if (r202.f513242e.contains(r1100) == false) goto L106;
        String r203 = r202.f513243f;
        if (TextUtils.isEmpty(r203) == false) goto L81;
        tb7.a.e("BaseAccountApi", "processApiRequest(), ipv4Host is empty");
        goto L106
    L81:
        String r1104 = r108.f508352a;
        String r1105 = UriProtector.parse(r1104).buildUpon().authority(r203).build().toString();     // Catch: Throwable -> L103
        String r1106 = r108.f508353b;     // Catch: Throwable -> L103
        Map<String, String> r1107 = r108.f508354c;     // Catch: Throwable -> L103
        List<wqa.i> r204 = r108.f508355d;     // Catch: Throwable -> L103
        String r205 = r108.f508356e;     // Catch: Throwable -> L103
        r212 = "from";
        String r1108 = r108.f508357f;     // Catch: Throwable -> L101
        r210 = "1";
        boolean r206 = r108.f508358g;     // Catch: Throwable -> L99
        r211 = r104;
        int r207 = r108.f508359h;     // Catch: Throwable -> L97
        if (TextUtils.isEmpty(r1106) == false) goto L91;
        String r1109 = MonitorConstants.CONNECT_TYPE_GET;
    L92:
        lb7.a r216 = new lb7.a(r1105, r1109, r1107, r204, r205, r1108, r206, r207);     // Catch: Throwable -> L97
        tb7.a.d("BaseAccountApi", "processApiRequest(), replace host to " + r203 + ", oldUrl=" + r1104 + ", newUrl=" + r1105);     // Catch: Throwable -> L95
        r108 = r216;
    L95:
        th = th;
        r108 = r216;
    L105:
        tb7.a.e("BaseAccountApi", "processApiRequest(), path:" + r1101 + ", replace host fail, " + th);
        goto L107
    L91:
        r1109 = r1106;
    L97:
        th = th;
    L99:
        th = th;
    L100:
        r211 = r104;
    L101:
        th = th;
        r210 = "1";
    L103:
        th = th;
        r210 = "1";
        r211 = r104;
        r212 = "from";
        goto L105
    L69:
        if (r202.f513240c.contains(r1101) == false) goto L71;
        r1103 = true;
        goto L72
    L28:
        if (r104.size() <= 0) goto L39;
        HashMap r208 = new HashMap();
        Iterator<Map.Entry<String, String>> r209 = r104.entrySet().iterator();
    L31:
        if (r209.hasNext() == false) goto L38;
        Map.Entry<String, String> r217 = r209.next();
        if (TextUtils.isEmpty(r217.getKey()) == true) goto L31;
        if (r105 == true) goto L37;
        if (TextUtils.isEmpty(r217.getValue()) == true) goto L31;
    L37:
        r208.put(r217.getKey(), r217.getValue());
        goto L31
    L38:
        r104 = r208;
        goto L39
    L422:
        NetworkInfo r218 = ((ConnectivityManager) this.f268952a.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r218 == null) goto L19;
        if (r218.isAvailable() == false) goto L19;
        boolean r219 = true;
    L22:
        if (r219 == true) goto L25;
        lb7.b r220 = this.f268954c;
        r220.f508366b = -12;
        r220.f508369e = "no net work";
        return false;
    L19:
        r219 = false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L9:
        if ("1".equals(r101.remove("local_account_sdk_skip_network_check")) == false) goto L11;
        r102 = false;
        goto L12
    }

    public final void m() {
        c r100 = new c(this);
        if (r100.f269213a.compareAndSet(false, true) == true) goto L5;
    L21:
        this.f268960i = r100;
        return;
    L5:
        if (com.bytedance.sdk.account.network.dispatcher.b.f269212g != null) goto L7;
        com.bytedance.sdk.account.network.dispatcher.b.f269212g = com.bytedance.sdk.account.network.dispatcher.c.a();
    L7:
        com.bytedance.sdk.account.network.dispatcher.c r101 = com.bytedance.sdk.account.network.dispatcher.b.f269212g;
        monitor-enter(r101);
        r100.f269216d = com.bytedance.sdk.account.network.dispatcher.c.f269219n.incrementAndGet();     // Catch: Throwable -> L18
        if (r101.f269222a == true) goto L13;
        r101.f();     // Catch: Throwable -> L18
    L13:
        if (r100.f269218f != IRequest.Priority.IMMEDIATE) goto L15;
        ThreadPlus.submitRunnable(r100);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r101);
        goto L21
    L15:
        r100.f269215c.removeMessages(0);     // Catch: Throwable -> L18
        r100.f269215c.sendEmptyMessageDelayed(0, 1000);     // Catch: Throwable -> L18
        r101.f269226e.add(r100);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static String e(String r100) {
        int r101 = r100.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
        int r102 = r100.indexOf(com.alipay.sdk.m.u.i.f25853b);
        if (r102 != (-1)) goto L5;
        r102 = r100.length();
    L5:
        if (r101 <= 0) goto L11;
        int r103 = r101 + 1;
        if (r103 >= r100.length()) goto L13;
        if (r103 < r102) goto L10;
        return "";
    L10:
        return r100.substring(r103, r102);
    L13:
        return "";
    L11:
        return "";
    }

    public static JSONObject j(JSONObject r100) {
        JSONObject r101 = null;
        if (r100 != null) goto L5;
    L22:
        return r101;
    L5:
        if (r100.has("data") == false) goto L22;
        Object r102 = r100.opt("data");     // Catch: Exception -> L20
        if (r102 != null) goto L11;
        return null;
    L11:
        if ((r102 instanceof JSONObject) == false) goto L14;
        r101 = (JSONObject) r102;     // Catch: Exception -> L20
    L23:
        goto L22
    L14:
        if ((r102 instanceof JSONArray) == false) goto L23;
        JSONArray r103 = (JSONArray) r102;     // Catch: Exception -> L20
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L20
        r104.put("data", r103);     // Catch: Exception -> L18
        r101 = r104;
    L18:
        e = e;
        r101 = r104;
    L21:
        e.printStackTrace();
    L20:
        e = e;
        goto L21
    }

    public final void g(R r100) {
        if (r100 == null) goto L19;
        int r101 = r100.f549253g;
        KProperty[] r102 = ErrorCodeTransferUtil.f269336a;
        com.bytedance.sdk.account.settings.common.a.a();
        JSONObject r103 = com.bytedance.sdk.account.settings.common.a.f269376b;
        fc7.a r104 = null;
        if (r103 == null) goto L7;
        JSONObject r105 = r103.optJSONObject(String.valueOf(r101));
    L9:
        if (r105 == null) goto L11;
        r104 = new fc7.a(r101, r105.optInt("type"), r105.optString("info"), r105.optString("detail"));
    L14:
        if (r104 == null) goto L18;
        r100.f549251e = r104;
        if (TextUtils.isEmpty(r104.f476361d) == false) goto L18;
        r104.f476361d = r100.f549255i;
    L18:
        tb7.a.a("BaseAccountApi", "handleErrorCodeTask, errorCode: " + r101 + ", task: " + r104);
        goto L19
    L11:
        ErrorCodeTransferUtil.f269338c.getClass();
        Lazy r106 = ErrorCodeTransferUtil.f269337b;
        KProperty r107 = ErrorCodeTransferUtil.f269336a[0];
        JSONObject r108 = ((JSONObject) r106.getValue()).optJSONObject(String.valueOf(r101));
        if (r108 == null) goto L14;
        r104 = new fc7.a(r101, r108.optInt("type"), r108.optString("info"), r108.optString("detail"));
        goto L14
    L7:
        r105 = null;
    L19:
        f0 r109 = new f0(this.f268956e, r100);
        WeakHandler r110 = j.m(com.ss.android.account.k.d().getApplicationContext()).V0;
        Message r111 = Message.obtain(r110, 100);
        r111.obj = r109;
        r110.sendMessage(r111);
    }

    public final void a(String r100, List<wqa.i> r101) {
        String r102 = com.bytedance.sdk.account.utils.r.b(r100, "passport_csrf_token");     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r102 = com.bytedance.sdk.account.utils.r.b(r100, "passport_csrf_token_default");     // Catch: Exception -> L17
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L8;
        int r103 = 1;
    L12:
        Pair r104 = new Pair(Integer.valueOf(r103), r102);     // Catch: Exception -> L17
        this.f268959h.f268963a = ((Integer) r104.first).intValue();     // Catch: Exception -> L17
        String r105 = (String) r104.second;     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r105) == true) goto L15;
        r101.add(new wqa.i("x-tt-passport-csrf-token", r105));     // Catch: Exception -> L17
        sa7.i.a(r105);     // Catch: Exception -> L17
        return;
    L15:
        sa7.i.b();     // Catch: Exception -> L17
        tb7.a.a("BaseAccountApi", String.format("Csrf token is empty: csrf_token_status=%s", new Object[]{Boolean.valueOf(true ^ TextUtils.isEmpty(sa7.i.f541196c))}));     // Catch: Exception -> L17
        return;
    L8:
        sa7.i.b();     // Catch: Exception -> L17
        r102 = sa7.i.f541196c;     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r102) == true) goto L11;
        r103 = -2;
        goto L12
    L11:
        r103 = 0;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b(List<wqa.i> r100, String r101) {
        if (this.f268952a != null) goto L25;
        return;
    L25:
        String r102 = UriProtector.parse(r101).getHost();     // Catch: Throwable -> L9
        if (com.ss.android.token.p.f449778b == false) goto L11;
        boolean r103 = TokenFactory.j().s(r101, r102);     // Catch: Throwable -> L9
    L12:
        if (r103 == false) goto L27;
        j r104 = j.m(this.f268952a);     // Catch: Exception -> L20
        String r105 = r104.f269040x.a();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r105) == true) goto L16;
        r100.add(new wqa.i("x-tt-multi-sids", r105));     // Catch: Exception -> L20
    L16:
        String r106 = r104.f269041y.a();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r106) == true) goto L28;
        r100.add(new wqa.i("x-tt-multi-sids-sec", r106));     // Catch: Exception -> L20
        return;
    L28:
        return;
    L27:
        return;
    L11:
        r103 = false;
    L9:
        th = move-exception;
        tb7.a.e("BaseAccountApi", "isArrowShareToken(), parse url fail, " + th.getMessage());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    public final boolean o(R r100, boolean r101) {
        Iterator r102 = ((ArrayList) jb7.b.f498010b).iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        jb7.a r103 = (jb7.a) r102.next();
        if ((r103 instanceof jb7.c) == false) goto L4;
        int r104 = this.f268954c.f508366b;
        Map<String, String> r105 = this.f268953b.f508354c;
        if (((jb7.c) r103).a() == false) goto L4;
        return true;
    L10:
        Iterator r106 = ((HashMap) jb7.b.f498009a).values().iterator();
    L12:
        if (r106.hasNext() == false) goto L18;
        jb7.a r107 = (jb7.a) r106.next();
        if ((r107 instanceof jb7.c) == false) goto L12;
        int r108 = this.f268954c.f508366b;
        Map<String, String> r109 = this.f268953b.f508354c;
        if (((jb7.c) r107).a() == false) goto L12;
        return true;
    L18:
        return false;
    }

    public c0(Context r100, lb7.a r101, ua7.a r102) {
        this.f268958g = new ArrayList();
        this.f268959h = new d();
        this.f268952a = r100.getApplicationContext();
        this.f268953b = r101;
        this.f268956e = r102;
        if (r102 == null) goto L5;
        r102.attachController(this);
    L5:
        lb7.b r103 = new lb7.b(r101);
        this.f268954c = r103;
        this.f268957f = new com.bytedance.sdk.account.impl.b(r101, r103);
    }

    public final void f(long r110, String r111, long r112) {
        Uri r100 = UriProtector.parse(this.f268953b.f508352a);
        String r101 = r100.getHost();
        String r102 = r100.getPath();
        d r103 = this.f268959h;
        int r104 = 1;
        if (TextUtils.isEmpty(r103.f268971i) == true) goto L6;
        tb7.a.a("BaseAccountApi", String.format("Passport service has set csrf token: host=%s, path=%s, logid=%s", new Object[]{r101, r102, r111}));
    L6:
        if (r103.f268970h == false) goto L9;
        tb7.a.a("BaseAccountApi", String.format("Passport service has set x-tt-token: host=%s, path=%s, logid=%s", new Object[]{r101, r102, r111}));
    L9:
        if (r103.f268969g == false) goto L11;
        tb7.a.a("BaseAccountApi", String.format("set-cookie sessionid: host=%s, path=%s, logid=%s", new Object[]{r101, r102, r111}));
    L11:
        lb7.b r105 = this.f268954c;
        int r106 = r105.f508366b;
        String r107 = r105.f508369e;
        sa7.i.b();
        boolean r108 = !TextUtils.isEmpty(sa7.i.f541196c);
        StringBuilder r113 = new StringBuilder("session_tlb_tag=");     // Catch: Throwable -> L56
        if (r103.f268974l == false) goto L15;
        int r114 = 1;
    L16:
        r113.append(r114);     // Catch: Throwable -> L56
        r113.append(",token_tlb_tag=");     // Catch: Throwable -> L56
        if (r103.f268975m == false) goto L19;
        int r109 = 1;
    L20:
        r113.append(r109);     // Catch: Throwable -> L56
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L56
        r115.put("host", r101);     // Catch: Throwable -> L56
        r115.put("path", r102);     // Catch: Throwable -> L56
        r115.put("duration", r110);     // Catch: Throwable -> L56
        r115.put("error_code", r106);     // Catch: Throwable -> L56
        r115.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r107);     // Catch: Throwable -> L56
        r115.put(CronetDataStorageAccess.LOGID, r111);     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r103.f268964b) == true) goto L23;
        int r116 = 1;
    L24:
        r115.put("request_x_tt_token", r116);     // Catch: Throwable -> L56
        r115.put("request_csrf_token", r103.f268963a);     // Catch: Throwable -> L56
        if (r103.f268970h == false) goto L27;
        int r117 = 1;
    L28:
        r115.put("response_x_tt_token", r117);     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r103.f268971i) == true) goto L31;
        int r118 = 1;
    L32:
        r115.put("response_csrf_token", r118);     // Catch: Throwable -> L56
        if (r108 == false) goto L35;
        int r119 = 1;
    L36:
        r115.put("csrf_token_status", r119);     // Catch: Throwable -> L56
        if (h.a().isLogin() == false) goto L39;
        int r120 = 1;
    L40:
        r115.put("is_login", r120);     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r103.f268965c) == true) goto L43;
        int r121 = 1;
    L44:
        r115.put("had_interceptor", r121);     // Catch: Throwable -> L56
        r115.put("request_extra_header", r103.f268968f);     // Catch: Throwable -> L56
        r115.put("response_extra_header", r103.f268973k);     // Catch: Throwable -> L56
        r115.put("response_cookie", r113.toString());     // Catch: Throwable -> L56
        r115.put("ticket_guard_iteration_version", r103.f268966d);     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r103.f268967e) == false) goto L48;
        r104 = 0;
    L48:
        r115.put("ticket_guard_client_data", r104);     // Catch: Throwable -> L56
        r115.put("ticket_guard_result", r103.f268972j);     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r103.f268976n) == true) goto L51;
        r115.put("tlb_tag_result", r103.f268976n);     // Catch: Throwable -> L56
    L51:
        long r122 = com.ss.android.account.k.f406327k;     // Catch: Throwable -> L56
        if (r122 <= 0) goto L54;
        r115.put("interval_from_sdk_init", r112 - r122);     // Catch: Throwable -> L56
    L54:
        com.bytedance.sdk.account.monitor.a.a("passport_net_request_result", r115);     // Catch: Throwable -> L56
        return;
    L43:
        r121 = 0;
        goto L44
    L39:
        r120 = 0;
        goto L40
    L35:
        r119 = 0;
        goto L36
    L31:
        r118 = 0;
        goto L32
    L27:
        r117 = 0;
        goto L28
    L23:
        r116 = 0;
        goto L24
    L19:
        r109 = 0;
        goto L20
    L15:
        r114 = 0;
    L56:
        th = move-exception;
        th.printStackTrace();
    }

    public final boolean l(JSONObject r100, JSONObject r101, String r102) throws Exception {
        if ("success".equals(r102) == false) goto L5;
        if (r101 == null) goto L26;
        k(r100, r101);
        return true;
    L26:
        return true;
    L5:
        if ("error".equals(r102) == false) goto L7;
    L8:
        if (r101 != null) goto L10;
        r101 = r100;
    L10:
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r101.has("error_code") == false) goto L15;
        lb7.b r103 = this.f268954c;
        r103.f508366b = r101.optInt("error_code", r103.f508366b);
    L17:
        lb7.b r104 = this.f268954c;
        r104.f508367c = r101.optString("description");
        lb7.b r105 = this.f268954c;
        r105.f508369e = r105.f508367c;
        r101.optString("verify_center_decision_conf");
        lb7.b r106 = this.f268954c;
        r106.f508371g = r101.optString("verify_center_secondary_decision_conf");
        i(r101, r100);
        return false;
    L15:
        if (r101.has("code") == false) goto L17;
        lb7.b r107 = this.f268954c;
        r107.f508366b = r101.optInt("code", r107.f508366b);
        goto L17
    L7:
        if (com.bytedance.android.ec.core.event.a.KEY_EXCEPTION.equals(r102) == true) goto L8;
        return false;
    }
}
