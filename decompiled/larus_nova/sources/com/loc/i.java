package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintSharedPrefUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.tencent.connect.common.Constants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import n4a.b5;
import n4a.c4;
import n4a.e5;
import n4a.f5;
import n4a.i4;
import n4a.j0;
import n4a.k0;
import n4a.k1;
import n4a.l0;
import n4a.l1;
import n4a.n;
import n4a.r;
import n4a.r0;
import n4a.s0;
import n4a.x4;
import n4a.y;
import n4a.z4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class i {
    public static final Queue<com.loc.d.c> A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f380094a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f380095b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f380096c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f380097d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Vector<f> f380098e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f380099f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f380100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f380101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f380102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, h> f380103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, Long> f380104k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, e> f380105l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f380106m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f380107n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f380108o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f380109p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f380110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f380111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f380112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f380113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f380114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f380115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f380116w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f380117x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ArrayList<com.loc.d.a> f380118y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile boolean f380119z;

    public class a extends l1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f380120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f380121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f380122d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f380123e;

        public a(String r100, String r101, String r102, String r103) {
            this.f380120b = r100;
            this.f380121c = r101;
            this.f380122d = r102;
            this.f380123e = r103;
        }

        @Override // n4a.l1
        public final void a() {
            e r100 = i.f380105l.get(this.f380120b);
            if (r100 != null) goto L5;
            return;
        L5:
            b r101 = r100.f380135c;
            e5 r110 = r100.f380133a;
            String r102 = r100.f380134b;
            Context r111 = i.f380096c;
            String r103 = this.f380121c;
            String r104 = this.f380122d;
            String r105 = this.f380123e;
            String r112 = "info";
            c r106 = new c();
            r106.f380125b = new JSONObject();
            if (r111 == null) goto L8;
            i.f380096c = r111.getApplicationContext();
        L8:
            i.x();
            SharedPreferences.Editor r113 = null;
            i.j(r110);     // Catch: Throwable -> L87 IllegalBlockSizeException -> L91 l -> L95
            i.x();     // Catch: Throwable -> L87 IllegalBlockSizeException -> L91 l -> L95
            boolean r107 = TextUtils.isEmpty(r102);     // Catch: Throwable -> L87 IllegalBlockSizeException -> L91 l -> L95
        L205:
            if (r107 == false) goto L206;
        L25:
            String r210 = r102;
            if (i.f380106m == true) goto L201;
            n4a.c.f517196b = y.i(r111, "a4", true);     // Catch: Throwable -> L178
            n4a.c.f517197c = y.i(r111, "a5", true);     // Catch: Throwable -> L178
            i.f380106m = true;     // Catch: Throwable -> L178
        L201:
            i.y(r111);     // Catch: Throwable -> L73 l -> L77
            String r211 = "infocode";
            String r212 = "info";
            r112 = "status";
            String r213 = "ver";
            l0 r108 = com.loc.c.a(new d(r111, r110, r210, r103, r104, r105));     // Catch: l -> L71 Throwable -> L175
            if (r107 == false) goto L212;
        L151:
            if (r101 == null) goto L217;
            Context r109 = ((com.loc.h.a) r101).f380093a;
            SharedPreferences.Editor r114 = r109.getSharedPreferences("pref", 0).edit();     // Catch: Throwable -> L169
            com.loc.h.c(r106, r114);     // Catch: Throwable -> L168
            e5 r115 = c4.k();     // Catch: Throwable -> L176
            r115.f517261c = com.loc.h.f380068b ? 1 : 0;     // Catch: Throwable -> L176
            r.b(r109, r115);     // Catch: Throwable -> L176
        L156:
            JSONObject r116 = r106.f380125b;     // Catch: Throwable -> L168
            if (r116 != null) goto L160;
            if (r114 != null) goto L197;
            return;
        L197:
            i4.e(r114);     // Catch: Throwable -> L177
            return;
        L221:
            return;
        L160:
            com.loc.h.b(r109, r116, r114);     // Catch: Throwable -> L168
            com.loc.h.d(r116, r114);     // Catch: Throwable -> L168
            com.loc.h.i(r116, r114);     // Catch: Throwable -> L168
            com.loc.h.j(r116, r114);     // Catch: Throwable -> L168
            com.loc.h.l(r116, r114);     // Catch: Throwable -> L168
            com.loc.h.k(r116, r114);     // Catch: Throwable -> L168
            com.loc.h.m(r116, r114);     // Catch: Throwable -> L168
            com.loc.h.h(r116, r114);     // Catch: Throwable -> L168
            JSONObject r117 = JSONObjectProtectorUtils.getJSONObject(r116, "1A6");     // Catch: Throwable -> L165
            if (r117 == null) goto L166;
            boolean r118 = i.o(r117.optString("ic"), false);     // Catch: Throwable -> L165
            i4.i(r114, "1A6", r118);     // Catch: Throwable -> L165
            com.loc.h.G = r118;     // Catch: Throwable -> L165
        L166:
            if (r114 != null) goto L197;
            return;
        L168:
            r113 = r114;
        L170:
            if (r113 == null) goto L220;
            r114 = r113;
            goto L197
        L220:
            return;
        L217:
            return;
        L212:
            byte[] r119 = r108.f517453a;     // Catch: Throwable -> L65 IllegalBlockSizeException -> L67 l -> L69
            Map<String, List<String>> r120 = r108.f517454b;     // Catch: Throwable -> L55
            if (r120 != null) goto L39;
        L57:
            byte[] r121 = new byte[16];     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            byte[] r122 = new byte[r119.length - 16];     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            System.arraycopy(r119, 0, r121, 0, 16);     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            System.arraycopy(r119, 16, r122, 0, r119.length - 16);     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            SecretKeySpec r123 = new SecretKeySpec(r121, f5.o("EQUVT"));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            Cipher r124 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            r124.init(2, r123, new IvParameterSpec(f5.p()));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            String r125 = f5.d(r124.doFinal(r122));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
        L100:
            String r126 = r210;
            if (r119 == null) goto L151;
            if (TextUtils.isEmpty(r125) == false) goto L107;
            r125 = f5.d(r119);
        L107:
            if (TextUtils.isEmpty(r125) == false) goto L183;
            i.d(r111, r110, "result is null");
        L183:
            JSONObject r127 = new JSONObject(r125);     // Catch: Throwable -> L149
            if (r127.has(r112) == false) goto L151;
            int r128 = JSONObjectProtectorUtils.getInt(r127, r112);     // Catch: Throwable -> L149
            if (r128 != 1) goto L114;
            i.f380094a = 1;     // Catch: Throwable -> L149
        L129:
            String r129 = r213;
        L134:
            th = move-exception;
            n.a(th, INotificationHitPoint.NoticeType.AT, "lc");     // Catch: Throwable -> L149
        L137:
            if (f5.h(r127, "result") == false) goto L151;
            JSONObject r130 = JSONObjectProtectorUtils.getJSONObject(r127, "result");     // Catch: Throwable -> L149
            i.e(r111, r110, r126, r106, r130);     // Catch: Throwable -> L149
            JSONObject r131 = JSONObjectProtectorUtils.getJSONObject(r130, "15K");     // Catch: Throwable -> L148
            boolean r132 = i.o(r131.optString("isTargetAble"), false);     // Catch: Throwable -> L148
            if (i.o(r131.optString("able"), false) == true) goto L143;
            z4 r133 = z4.a.f517980a;     // Catch: Throwable -> L148
            SharedPreferences.Editor r134 = y.b(r111, "open_common");     // Catch: Throwable -> L148
            y.h(r134, "a3", true);     // Catch: Throwable -> L148
            y.e(r134);     // Catch: Throwable -> L148
            goto L151
        L143:
            z4 r135 = z4.a.f517980a;     // Catch: Throwable -> L148
            if (r135.f517979a != null) goto L146;
            r135.f517979a = new z4.b();     // Catch: Throwable -> L148
        L146:
            SharedPreferences.Editor r136 = y.b(r111, "open_common");     // Catch: Throwable -> L148
            y.h(r136, "a3", r132);     // Catch: Throwable -> L148
            y.e(r136);     // Catch: Throwable -> L148
            r135.f517979a.f517982b = r132;     // Catch: Throwable -> L148
            goto L151
        L131:
            if (r127.has(r129) == false) goto L137;
            JSONObjectProtectorUtils.getInt(r127, r129);     // Catch: Throwable -> L134
        L114:
            if (r128 != 0) goto L129;
            if (r108 == null) goto L118;
            String r137 = r108.f517455c;     // Catch: Throwable -> L149
            String r138 = r108.f517456d;     // Catch: Throwable -> L149
        L119:
            f5.e(r111, r137, r138, r127);     // Catch: Throwable -> L149
            i.f380094a = 0;     // Catch: Throwable -> L149
            String r139 = r212;
            if (r127.has(r139) == false) goto L122;
            i.f380095b = JSONObjectProtectorUtils.getString(r127, r139);     // Catch: Throwable -> L149
        L122:
            String r140 = r211;
            if (r127.has(r140) == false) goto L125;
            String r141 = JSONObjectProtectorUtils.getString(r127, r140);     // Catch: Throwable -> L149
        L126:
            r.d(r110, "/v3/iasdkauth", i.f380095b, r138, r137, r141);     // Catch: Throwable -> L149
            if (i.f380094a != 0) goto L129;
        L125:
            r141 = "";
            goto L126
        L118:
            r137 = "authcsid";
            r138 = "authgsid";
        L149:
            th = move-exception;
            n.a(th, INotificationHitPoint.NoticeType.AT, "lc");
            goto L151
        L63:
            e = e;
            l0 r142 = r108;
            byte[] r143 = r119;
        L98:
            e.a();
            i.d(r111, r110, e.a());
            Set<Integer> r144 = r.f517629e;
            r.d(r110, "/v3/iasdkauth", e.c(), e.d(), e.e(), e.b());
            r108 = r142;
            r119 = r143;
        L99:
            r125 = null;
        L61:
            e = e;
        L94:
            i.d(r111, r110, e.getMessage());
        L59:
            e = th;
        L90:
            r.f(e, INotificationHitPoint.NoticeType.AT, "lc");
            goto L94
        L39:
            if (r120.containsKey("lct") == false) goto L57;
            List<String> r145 = r120.get("lct");     // Catch: Throwable -> L55
            List<String> r146 = r120.get("lct-info");     // Catch: Throwable -> L55
            r106.f380124a = i.a(r145);     // Catch: Throwable -> L55
            if (r146 != null) goto L199;
        L47:
            String r147 = "";
        L49:
            if (r106.f380124a == 0) goto L57;
            if (r110 == null) goto L57;
            String r148 = r110.a();     // Catch: Throwable -> L55
            if (TextUtils.isEmpty(r148) == true) goto L57;
            i.g(r148, r106.f380124a, r147);     // Catch: Throwable -> L55
            goto L57
        L199:
            if (r146.size() <= 0) goto L47;
            r147 = (String) ListProtector.get(r146, 0);     // Catch: Exception -> L179 Throwable -> L55
            if (TextUtils.isEmpty(r147) == true) goto L47;
        L55:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            r.f(th, INotificationHitPoint.NoticeType.AT, "lct");     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            goto L57
        L69:
            e = e;
            r142 = r108;
            r143 = null;
        L67:
            e = e;
            r119 = null;
        L65:
            e = th;
            r119 = null;
            goto L90
        L71:
            e = move-exception;
            throw e;     // Catch: Throwable -> L81 IllegalBlockSizeException -> L83 l -> L85
        L76:
            throw new l("未知的错误");     // Catch: Throwable -> L81 IllegalBlockSizeException -> L83 l -> L85
        L77:
            e = e;
            String r149 = r210;
        L80:
            throw e;     // Catch: Throwable -> L81 IllegalBlockSizeException -> L83 l -> L85
        L73:
            String r150 = r210;
            goto L76
        L206:
        L20:
            e = e;
            String r214 = r102;
        L24:
            r149 = r214;
        L19:
            r214 = r102;
        L23:
            r150 = r214;
            goto L76
        L12:
            if (TextUtils.isEmpty(r102) == true) goto L25;
            StringBuilder r151 = new StringBuilder();     // Catch: Throwable -> L19 l -> L20
            r151.append(r102);     // Catch: Throwable -> L19 l -> L20
            r214 = r102;
            r151.append(";15K;16H;17I;1A4;17S;183");     // Catch: l -> L17 Throwable -> L174
            r102 = r151.toString();     // Catch: l -> L17 Throwable -> L174
        L17:
            e = e;
            goto L24
        L85:
            e = e;
        L97:
            r210 = r102;
            r142 = null;
            r143 = null;
        L83:
            e = e;
        L93:
            r210 = r102;
            r108 = null;
            r119 = null;
        L81:
            e = th;
        L89:
            r210 = r102;
            r108 = null;
            r119 = null;
        L95:
            e = e;
            r213 = "ver";
            r211 = "infocode";
            r212 = "info";
            r112 = "status";
        L91:
            e = e;
            r213 = "ver";
            r211 = "infocode";
            r212 = "info";
            r112 = "status";
        L87:
            e = th;
            r213 = "ver";
            r211 = "infocode";
            r212 = "info";
            r112 = "status";
            goto L89
        }
    }

    public interface b {
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f380124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f380125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f380126c;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f380127a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public JSONObject f380128b;

            public a() {
            }
        }

        public c() {
            this.f380124a = 0;
        }
    }

    public static class d extends j0 {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f380129n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f380130o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f380131p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f380132q;

        @Override // com.loc.bo
        public final Map<String, String> a() {
            if (TextUtils.isEmpty(this.f380132q) == true) goto L6;
            HashMap r100 = new HashMap();
            r100.put("host", this.f380132q);
            return r100;
        L6:
            return null;
        }

        @Override // com.loc.bo
        public final String j() {
            if (TextUtils.isEmpty(this.f380132q) == false) goto L5;
            return "";
        L5:
            return this.f380132q;
        }

        @Override // n4a.j0
        public final byte[] p() {
            return null;
        }

        @Override // n4a.j0
        public final String r() {
            return "3.0";
        }

        @Override // com.loc.bo
        public final String c() {
            String r100 = this.f380130o;
            if (TextUtils.isEmpty(r100) == true) goto L10;
            return UriProtector.parse("https://restsdk.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(r100).build().toString();
        L10:
            return "https://restsdk.amap.com/v3/iasdkauth";
        L11:
            return "https://restsdk.amap.com/v3/iasdkauth";
        }

        @Override // n4a.a5, com.loc.bo
        public final String e() {
            String r100 = this.f380131p;
            if (TextUtils.isEmpty(r100) == true) goto L10;
            return UriProtector.parse("https://dualstack-arestapi.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(r100).build().toString();
        L10:
            return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
        L11:
            return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
        }

        @Override // n4a.j0
        public final byte[] q() {
            String r100 = x4.u(this.f517395k);
            if (TextUtils.isEmpty(r100) == true) goto L5;
            r100 = b5.a(new StringBuilder(r100).reverse().toString());
        L5:
            HashMap r101 = new HashMap();
            if (TextUtils.isEmpty(this.f380129n) == false) goto L8;
            String r102 = "";
        L9:
            r101.put("authkey", r102);
            r101.put("plattype", "android");
            r101.put("ccver", "1");
            r101.put("product", this.f517396l.a());
            r101.put("version", this.f517396l.f517264f);
            r101.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
            StringBuilder r103 = new StringBuilder();
            r103.append(Build.VERSION.SDK_INT);
            r101.put("androidversion", r103.toString());
            r101.put("deviceId", r100);
            r101.put("manufacture", Build.MANUFACTURER);
            r101.put("abitype", f5.c(this.f517395k));
            r101.put("ext", this.f517396l.c());
            if (r101.size() != 0) goto L12;
            String r104 = null;
        L26:
            return f5.j(r104);
        L12:
            StringBuffer r105 = new StringBuffer();
            Iterator r106 = r101.entrySet().iterator();     // Catch: Throwable -> L22
            boolean r107 = true;
        L14:
            if (r106.hasNext() == false) goto L24;
            Map.Entry r108 = (Map.Entry) r106.next();     // Catch: Throwable -> L22
            if (r107 == true) goto L19;
            r105.append("&");     // Catch: Throwable -> L22
            r105.append((String) r108.getKey());     // Catch: Throwable -> L22
            r105.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L22
            r105.append((String) r108.getValue());     // Catch: Throwable -> L22
            goto L14
        L19:
            r105.append((String) r108.getKey());     // Catch: Throwable -> L22
            r105.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L22
            r105.append((String) r108.getValue());     // Catch: Throwable -> L22
            r107 = false;
        L24:
            r104 = r105.toString();
        L22:
            th = move-exception;
            n.a(th, "ut", "abP");
            goto L24
        L8:
            r102 = this.f380129n;
            goto L9
        }

        public d(Context r100, e5 r101, String r102, String r103, String r104, String r105) {
            super(r100, r101);
            this.f380129n = r102;
            this.f380130o = r103;
            this.f380131p = r104;
            this.f380132q = r105;
            b(bo.c.f379951b);
            this.f379932i = bo.a.f379937d;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e5 f380133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f380134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f380135c;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f380136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f380137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f380138c;

        public f(String r100, String r101, int r102) {
            this.f380136a = r100;
            this.f380137b = r101;
            this.f380138c = new AtomicInteger(r102);
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f380139a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f380140b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f380141c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f380142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static boolean f380143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f380144f;
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f380145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f380146b;

        public h(Long r100, String r101) {
            this.f380145a = 0;
            this.f380146b = "";
            this.f380145a = r100.longValue();
            this.f380146b = r101;
        }
    }

    static {
        f380098e = new Vector();
        f380099f = new HashMap();
        f380100g = null;
        f380101h = 0;
        f380102i = false;
        f380103j = new ConcurrentHashMap(8);
        f380104k = new ConcurrentHashMap(8);
        f380105l = new ConcurrentHashMap(8);
        f380106m = false;
        f380107n = false;
        f380108o = 5000;
        f380109p = true;
        f380110q = false;
        f380111r = 3;
        f380112s = true;
        f380113t = false;
        f380114u = 3;
        f380115v = false;
        f380116w = new ConcurrentHashMap();
        f380117x = new ConcurrentHashMap();
        f380118y = new ArrayList();
        A = new LinkedList();
    }

    public static synchronized h A(String r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.loc.i> r0 = com.loc.i.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.i$h> r1 = com.loc.i.f380103j     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L10
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L22
            r2 = 8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L22
            com.loc.i.f380103j = r1     // Catch: java.lang.Throwable -> L22
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.i$h> r1 = com.loc.i.f380103j     // Catch: java.lang.Throwable -> L22
            boolean r1 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.i$h> r1 = com.loc.i.f380103j     // Catch: java.lang.Throwable -> L22
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L22
            com.loc.i$h r3 = (com.loc.i.h) r3     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r3
        L22:
            r3 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "glcut"
            n4a.n.a(r3, r1, r2)     // Catch: java.lang.Throwable -> L39
        L2a:
            com.loc.i$h r3 = new com.loc.i$h     // Catch: java.lang.Throwable -> L39
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = ""
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L39
            monitor-exit(r0)
            return r3
        L39:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.i.A(java.lang.String):com.loc.i$h");
    }

    public static long a(List<String> r100) {
        if (r100 == null) goto L15;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (r100.size() <= 0) goto L16;
        String r101 = (String) ListProtector.get(r100, 0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r101) == true) goto L17;
        return CastLongProtector.valueOf(r101).longValue();
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    }

    public static void d(Context r100, e5 r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("amap_sdk_auth_fail", "1");
        r103.put("amap_sdk_auth_fail_type", r102);
        r103.put("amap_sdk_name", r101.a());
        r103.put("amap_sdk_version", r101.b());
        String r104 = new JSONObject(r103).toString();
        if (TextUtils.isEmpty(r104) == false) goto L8;
        return;
    L8:
        r0 r105 = new r0(r100, "core", EventConstant.Value.AUTH_VERSION_2, "O001");     // Catch: l -> L7
        r105.a(r104);     // Catch: l -> L7
        s0.c(r105, r100);     // Catch: l -> L7
        return;
    }

    public static void i(String r100, boolean r101, boolean r102, boolean r103) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (f380096c == null) goto L32;
        HashMap r104 = new HashMap();
        r104.put("url", r100);
        r104.put("downLevel", String.valueOf(r101));
        String r105 = "0";
        if (x4.r(f380096c) != 0) goto L10;
        Object r106 = "0";
    L11:
        r104.put("ant", r106);
        if (r103 == false) goto L16;
        if (r101 == false) goto L15;
        String r107 = Constants.VIA_SHARE_TYPE_MINI_PROGRAM;
    L19:
        r104.put("type", r107);
        if (r102 == true) goto L23;
        r105 = "1";
    L23:
        r104.put("status", r105);
        String r108 = new JSONObject(r104).toString();
        if (TextUtils.isEmpty(r108) == false) goto L29;
        return;
    L29:
        r0 r109 = new r0(f380096c, "core", EventConstant.Value.AUTH_VERSION_2, "O002");     // Catch: l -> L28
        r109.a(r108);     // Catch: l -> L28
        s0.c(r109, f380096c);     // Catch: l -> L28
        return;
    L33:
        return;
    L15:
        r107 = "8";
        goto L19
    L16:
        if (r101 == false) goto L18;
        r107 = "6";
        goto L19
    L18:
        r107 = "4";
        goto L19
    L10:
        r106 = "1";
        goto L11
    }

    public static void k(boolean r100, com.loc.d.a r101) {
        if (f380119z == false) goto L31;
        if (r101 == null) goto L47;
        ArrayList<com.loc.d.a> r102 = f380118y;
        monitor-enter(r102);
        if (r100 == true) goto L32;
    L22:
        f380119z = false;     // Catch: Throwable -> L28
        Iterator<com.loc.d.a> r103 = f380118y.iterator();     // Catch: Throwable -> L28
    L24:
        if (r103.hasNext() == false) goto L26;
        com.loc.d.a r104 = r103.next();     // Catch: Throwable -> L28
        String r105 = r104.f379975d;     // Catch: Throwable -> L28
        Objects.toString(r104.f379980i);     // Catch: Throwable -> L28
        goto L24
    L26:
        monitor-exit(r102);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L32:
        Iterator<com.loc.d.a> r106 = r102.iterator();     // Catch: Throwable -> L28
    L11:
        if (r106.hasNext() == false) goto L22;
        com.loc.d.a r107 = r106.next();     // Catch: Throwable -> L28
        if (r107.f379972a.equals(r101.f379972a) == false) goto L11;
        if (r107.f379975d.equals(r101.f379975d) == false) goto L11;
        if (r107.f379976e != r101.f379976e) goto L11;
        if (r107.f379980i == r101.f379980i) goto L20;
        r107.f379980i.set(r107.f379980i.get() - r101.f379980i.get());     // Catch: Throwable -> L28
        goto L11
    L20:
        r106.remove();     // Catch: Throwable -> L28
        goto L11
    L47:
        return;
    }

    public static void l(boolean r100, String r101) {
        "--markHostNameFailed---hostname=".concat(String.valueOf(r101));     // Catch: Throwable -> L24
        if (f380109p == true) goto L7;
        if (r100 == true) goto L7;
        return;
    L7:
        if (f380113t == true) goto L11;
        if (r100 == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return;
    L13:
        if (r100 == true) goto L19;
        ConcurrentHashMap<String, Boolean> r102 = f380116w;     // Catch: Throwable -> L24
        if (r102.get(r101) == null) goto L17;
        return;
    L17:
        r102.put(r101, Boolean.TRUE);     // Catch: Throwable -> L24
        f(p(r101, "a14"));     // Catch: Throwable -> L24
        return;
    L19:
        ConcurrentHashMap<String, Boolean> r103 = f380117x;     // Catch: Throwable -> L24
        if (r103.get(r101) == null) goto L22;
        return;
    L22:
        r103.put(r101, Boolean.TRUE);     // Catch: Throwable -> L24
        f(p(r101, "a15"));     // Catch: Throwable -> L24
        return;
    }

    public static synchronized boolean n(String r100, long r101) {
        monitor-enter(i.class);
        boolean r102 = false;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(i.class);
        return false;
    L9:
        h r103 = A(r100);     // Catch: Throwable -> L26
        long r104 = 0;
        if (r103 == null) goto L12;
        long r105 = r103.f380145a;     // Catch: Throwable -> L26
    L14:
        if (r101 == r105) goto L24;
        if (f380104k != null) goto L18;
    L20:
        if ((SystemClock.elapsedRealtime() - r104) <= 30000) goto L24;
        r102 = true;
        goto L24
    L18:
        if (f380104k.containsKey(r100) == false) goto L20;
        r104 = f380104k.get(r100).longValue();     // Catch: Throwable -> L26
        goto L20
    L12:
        r105 = 0;
    L24:
        monitor-exit(i.class);
        return r102;
    }

    public static boolean o(String r100, boolean r101) {
    L10:
        return r101;
    L3:
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        String[] r102 = URLDecoder.decode(r100).split(HTTP.URL_DEFAULT);     // Catch: Throwable -> L10
        if ((r102[r102.length - 1].charAt(4) % 2) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static void q(com.loc.d.c r100) {
        ArrayList<com.loc.d.a> r101 = f380118y;
        monitor-enter(r101);
        int r102 = 0;
        boolean r103 = false;
    L25:
        ArrayList<com.loc.d.a> r104 = f380118y;     // Catch: Throwable -> L22
        if (r102 >= r104.size()) goto L18;
        com.loc.d.a r105 = r104.get(r102);     // Catch: Throwable -> L22
        if (r100.f379984c.equals(r105.f379972a) == false) goto L17;
        if (r100.f379985d.equals(r105.f379975d) == false) goto L17;
        int r106 = r100.f379994m;     // Catch: Throwable -> L22
        int r107 = r105.f379976e;     // Catch: Throwable -> L22
        if (r106 != r107) goto L17;
        r103 = true;
        if (r107 != 1) goto L16;
        r105.f379979h = ((((long) r105.f379980i.get()) * r105.f379979h) + r100.f379987f) / ((long) (r105.f379980i.get() + 1));     // Catch: Throwable -> L22
    L16:
        r105.f379980i.getAndIncrement();     // Catch: Throwable -> L22
    L17:
        r102 = r102 + 1;     // Catch: Throwable -> L22
        goto L25
    L18:
        if (r103 == true) goto L20;
        r104.add(new com.loc.d.a(r100));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static synchronized void r(String r100, boolean r101) {
        monitor-enter(i.class);
        h(r100, r101, null, null, null);     // Catch: Throwable -> L8
        monitor-exit(i.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean s() {
        Context r100 = f380096c;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = x4.t(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        Map<String, Integer> r102 = f380099f;
        HashMap r103 = (HashMap) r102;
        Integer r104 = (Integer) r103.get(r101.toUpperCase());
        if (r104 != null) goto L12;
        return false;
    L12:
        if (r104.intValue() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void t(Context r100) {
        f380109p = y.i(r100, "a13", true);
        f380112s = y.i(r100, "a6", true);
        f380110q = y.i(r100, "a7", false);
        f380108o = y.a(r100, "a8", 5000);
        f380111r = y.a(r100, "a9", 3);
        f380113t = y.i(r100, "a10", false);
        f380114u = y.a(r100, "a11", 3);
        f380115v = y.i(r100, "a12", false);
    }

    public static boolean u() {
        Context r100 = f380096c;
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = x4.t(r100);
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        Map<String, Integer> r102 = f380099f;
        HashMap r103 = (HashMap) r102;
        Integer r104 = (Integer) r103.get(r101.toUpperCase());
        if (r104 != null) goto L12;
        return false;
    L12:
        if (r104.intValue() < 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static synchronized boolean w(String r100) {
        monitor-enter(i.class);
    L24:
        th = move-exception;
        n.a(th, INotificationHitPoint.NoticeType.AT, "cslct");     // Catch: Throwable -> L28
    L26:
        monitor-exit(i.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        monitor-exit(i.class);
        return false;
    L10:
        if (f380105l != null) goto L14;
        monitor-exit(i.class);
        return false;
    L14:
        if (f380104k != null) goto L17;
        f380104k = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (f380105l.containsKey(r100) == false) goto L26;
        if (f380104k.containsKey(r100) == true) goto L26;
        f380104k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(i.class);
        return true;
    }

    public static com.loc.d.a z() {
        if (f380119z == false) goto L5;
        return null;
    L5:
        ArrayList<com.loc.d.a> r100 = f380118y;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (f380119z == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L18
        return null;
    L11:
        Collections.sort(r100);     // Catch: Throwable -> L18
        if (r100.size() <= 0) goto L16;
        com.loc.d.a r101 = r100.get(0).a();     // Catch: Throwable -> L18
        f380119z = true;     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return r101;
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L18
        return null;
    }

    public static boolean m() {
        Context r100 = f380096c;
        if (r100 == null) goto L73;
        String r101 = x4.t(r100);     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(f380100g) == true) goto L14;
        if (TextUtils.isEmpty(r101) == true) goto L14;
        if (f380100g.equals(r101) == false) goto L14;
        if ((System.currentTimeMillis() - f380101h) >= 60000) goto L14;
    L67:
        if (u() == true) goto L70;
        return false;
    L70:
        if (s() == false) goto L73;
        return true;
    L14:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        f380100g = r101;     // Catch: Throwable -> L64
    L16:
        f380101h = System.currentTimeMillis();     // Catch: Throwable -> L64
        ((HashMap) f380099f).clear();     // Catch: Throwable -> L64
        Iterator r102 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L64
    L17:
        if (r102.hasNext() == false) goto L67;
        NetworkInterface r103 = (NetworkInterface) r102.next();     // Catch: Throwable -> L64
        if (r103.getInterfaceAddresses().isEmpty() == true) goto L17;
        String r104 = r103.getDisplayName();     // Catch: Throwable -> L64
        Iterator<InterfaceAddress> r105 = r103.getInterfaceAddresses().iterator();     // Catch: Throwable -> L64
        int r106 = 0;
    L23:
        if (r105.hasNext() == false) goto L52;
        InetAddress r107 = r105.next().getAddress();     // Catch: Throwable -> L64
        if ((r107 instanceof Inet6Address) == true) goto L26;
        if ((r107 instanceof Inet4Address) == false) goto L23;
        Inet4Address r108 = (Inet4Address) r107;     // Catch: Throwable -> L64
        if (r108.isLoopbackAddress() == false) goto L42;
    L47:
        boolean r109 = true;
    L48:
        if (r109 == true) goto L23;
        if (r108.getHostAddress().startsWith(f5.o("FMTkyLjE2OC40My4")) == true) goto L23;
        r106 = r106 | 1;     // Catch: Throwable -> L64
        goto L23
    L42:
        if (r108.isLinkLocalAddress() == true) goto L47;
        if (r108.isAnyLocalAddress() == true) goto L47;
        r109 = false;
        goto L48
    L26:
        Inet6Address r110 = (Inet6Address) r107;     // Catch: Throwable -> L64
        if (r110.isLoopbackAddress() == false) goto L29;
    L34:
        boolean r111 = true;
    L35:
        if (r111 == true) goto L23;
        r106 = r106 | 2;     // Catch: Throwable -> L64
        goto L23
    L29:
        if (r110.isLinkLocalAddress() == true) goto L34;
        if (r110.isAnyLocalAddress() == true) goto L34;
        r111 = false;
        goto L35
    L52:
        if (r106 == 0) goto L17;
        if (r104 != null) goto L55;
    L58:
        if (r104 == null) goto L17;
        if (r104.startsWith("rmnet") == false) goto L17;
        Map<String, Integer> r112 = f380099f;     // Catch: Throwable -> L64
        String r113 = "MOBILE";
    L62:
        ((HashMap) r112).put(r113, Integer.valueOf(r106));     // Catch: Throwable -> L64
        goto L17
    L55:
        if (r104.startsWith("wlan") == false) goto L58;
        r112 = f380099f;     // Catch: Throwable -> L64
        r113 = "WIFI";
    L64:
        th = move-exception;
        n.a(th, INotificationHitPoint.NoticeType.AT, "ipstack");
    L73:
        if (f380097d == true) goto L75;
        return false;
    L75:
        f r114 = b(f380096c, "IPV6_CONFIG_NAME");
        if (r114 != null) goto L78;
        return false;
    L78:
        AtomicInteger r115 = r114.f380138c;
        if (r115 != null) goto L81;
        int r116 = 0;
    L83:
        if (r116 >= 5) goto L85;
        return true;
    L85:
        return false;
    L81:
        r116 = r115.get();
        goto L83
    }

    public static void v() {
        f r100 = b(f380096c, "IPV6_CONFIG_NAME");     // Catch: Throwable -> L7
        String r101 = f5.b(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L7
        if (r101.equals(r100.f380137b) == true) goto L5;
        r100.f380137b = r101;     // Catch: Throwable -> L7
        r100.f380138c.set(0);     // Catch: Throwable -> L7
    L5:
        r100.f380138c.incrementAndGet();     // Catch: Throwable -> L7
        c(f380096c, "IPV6_CONFIG_NAME", r100);     // Catch: Throwable -> L7
        return;
    }

    public static void x() {
        if (f380102i == false) goto L11;
        return;
    L11:
        Context r100 = f380096c;     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        return;
    L8:
        f380102i = true;     // Catch: Throwable -> L10
        z4.a.f517980a.a(r100);     // Catch: Throwable -> L10
        f380097d = y.i(r100, "a2", true);     // Catch: Throwable -> L10
        t(r100);     // Catch: Throwable -> L10
        g.f380139a = y.i(r100, "ucf", g.f380139a);     // Catch: Throwable -> L10
        g.f380140b = y.i(r100, "fsv2", g.f380140b);     // Catch: Throwable -> L10
        g.f380141c = y.i(r100, "usc", g.f380141c);     // Catch: Throwable -> L10
        g.f380142d = y.a(r100, "umv", g.f380142d);     // Catch: Throwable -> L10
        g.f380143e = y.i(r100, "ust", g.f380143e);     // Catch: Throwable -> L10
        g.f380144f = y.a(r100, "ustv", g.f380144f);     // Catch: Throwable -> L10
        return;
    }

    public static boolean B(String r100) {
    L29:
        return true;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return true;
    L7:
        if (f380109p == true) goto L10;
        return false;
    L10:
        if (f380116w.get(r100) != null) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == true) goto L15;
        return false;
    L15:
        Context r102 = f380096c;     // Catch: Throwable -> L29
        if (r102 != null) goto L18;
        return true;
    L18:
        f r103 = b(r102, p(r100, "a14"));     // Catch: Throwable -> L29
        if (r103 != null) goto L21;
        return true;
    L21:
        AtomicInteger r104 = r103.f380138c;     // Catch: Throwable -> L29
        if (r104 != null) goto L24;
        int r105 = 0;
    L25:
        if (r105 >= f380111r) goto L28;
        return true;
    L28:
        return false;
    L24:
        r105 = r104.get();     // Catch: Throwable -> L29
        goto L25
    L12:
        r101 = false;
        goto L13
    }

    public static void f(String r100) {
        f r101 = b(f380096c, r100);
        String r102 = f5.b(System.currentTimeMillis(), "yyyyMMdd");
        if (r102.equals(r101.f380137b) == true) goto L5;
        r101.f380137b = r102;
        r101.f380138c.set(0);
    L5:
        r101.f380138c.incrementAndGet();
        c(f380096c, r100, r101);
    }

    public static void j(e5 r100) {
        if (r100 == null) goto L17;
        if (TextUtils.isEmpty(r100.a()) == false) goto L6;
        return;
    L6:
        String r101 = r100.b();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = r100.f517264f;     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        n4a.c.b(r100.a(), r101);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public static void y(Context r100) {
        if (f380107n == false) goto L6;
        return;
    L6:
        o(y.k(r100, "open_common", "a16"), true);     // Catch: Throwable -> L14
        r100.getSharedPreferences("open_common", 0).getLong("a17", 86400000);     // Catch: Throwable -> L10
    L12:
        f380107n = true;     // Catch: Throwable -> L14
        return;
    L10:
        th = move-exception;
        r.f(th, "csp", "glv");     // Catch: Throwable -> L14
    }

    public static synchronized f b(Context r100, String r101) {
        monitor-enter(i.class);
        f r102 = null;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r103 = 0;
    L7:
        Vector<f> r104 = f380098e;     // Catch: Throwable -> L36
        if (r103 >= r104.size()) goto L15;
        f r105 = r104.get(r103);     // Catch: Throwable -> L36
        if (r105 == null) goto L14;
        if (r101.equals(r105.f380136a) == false) goto L14;
    L16:
        if (r105 == null) goto L19;
        monitor-exit(i.class);
        return r105;
    L19:
        if (r100 != null) goto L22;
        monitor-exit(i.class);
        return null;
    L22:
        String r106 = y.k(r100, "open_common", r101);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r106) == false) goto L42;
    L27:
        String r107 = f5.b(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L36
        if (r102 != null) goto L31;
        r102 = new f(r101, r107, 0);     // Catch: Throwable -> L36
    L31:
        if (r107.equals(r102.f380137b) == true) goto L33;
        r102.f380137b = r107;     // Catch: Throwable -> L36
        r102.f380138c.set(0);     // Catch: Throwable -> L36
    L33:
        f380098e.add(r102);     // Catch: Throwable -> L36
        monitor-exit(i.class);
        return r102;
    L42:
        JSONObject r108 = new JSONObject(r106);     // Catch: Throwable -> L39
        r102 = new f(r108.optString(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY), r108.optString("f"), r108.optInt("h"));     // Catch: Throwable -> L39
    L14:
        r103 = r103 + 1;
    L15:
        r105 = null;
    L36:
        th = move-exception;
        throw th;
    }

    public static String p(String r100, String r101) {
        byte[] r102 = r100.getBytes();
        String r103 = null;
        MessageDigest r104 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L5
        r104.update(r102);     // Catch: Throwable -> L5
        byte[] r105 = r104.digest();     // Catch: Throwable -> L5
    L13:
        r103 = f5.s(r105);     // Catch: Throwable -> L9
    L12:
        return r101 + "_" + r103;
    L9:
        th = move-exception;
        n.a(th, "ut", "h2s");
    L5:
        th = move-exception;
        n.a(th, "MD5", "gmb");
        r105 = null;
        goto L13
    }

    public static void c(Context r100, String r101, f r102) {
        if (TextUtils.isEmpty(r102.f380136a) == true) goto L17;
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L7
        r103.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, r102.f380136a);     // Catch: Throwable -> L7
        r103.put("f", r102.f380137b);     // Catch: Throwable -> L7
        r103.put("h", r102.f380138c.get());     // Catch: Throwable -> L7
        String r104 = r103.toString();     // Catch: Throwable -> L7
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L11;
        return;
    L11:
        if (r100 != null) goto L13;
        return;
    L13:
        SharedPreferences.Editor r105 = y.b(r100, "open_common");
        r105.putString(r101, r104);
        y.e(r105);
        return;
    L7:
        r104 = "";
        goto L9
    }

    public static synchronized void g(String r100, long r101, String r102) {
        monitor-enter(i.class);
    L23:
        th = move-exception;
        n.a(th, INotificationHitPoint.NoticeType.AT, "ucut");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (f380105l != null) goto L7;
    L28:
        monitor-exit(i.class);
        return;
    L7:
        if (f380105l.containsKey(r100) == false) goto L28;
        if (f380103j != null) goto L12;
        f380103j = new ConcurrentHashMap(8);     // Catch: Throwable -> L23
    L12:
        f380103j.put(r100, new h(Long.valueOf(r101), r102));     // Catch: Throwable -> L23
        Context r103 = f380096c;     // Catch: Throwable -> L23
        if (r103 == null) goto L26;
        SharedPreferences.Editor r104 = y.b(r103, "open_common");     // Catch: Throwable -> L23
        if (r104 != null) goto L17;
    L25:
        y.g(r104, r100 + "lct-info", r102);     // Catch: Throwable -> L23
        y.e(r104);     // Catch: Throwable -> L23
        goto L26
    L17:
        if (TextUtils.isEmpty(r100) == true) goto L25;
        r104.putLong(r100, r101);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r.f(th, "csp", "plv");     // Catch: Throwable -> L23
    L26:
        monitor-exit(i.class);
    }

    public static void e(Context r210, e5 r211, String r212, c r213, JSONObject r214) throws JSONException {
        c r100 = r213;
        c.a r110 = new c.a();
        r110.f380127a = false;
        r100.f380126c = r110;
        String[] r111 = r212.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L13
        if (r111 == null) goto L16;
        if (r111.length <= 0) goto L16;
        int r112 = r111.length;     // Catch: Throwable -> L13
        int r113 = 0;
    L8:
        if (r113 >= r112) goto L16;
        String r114 = r111[r113];     // Catch: Throwable -> L13
        if (r214.has(r114) == false) goto L12;
        r100.f380125b.putOpt(r114, r214.get(r114));     // Catch: Throwable -> L13
    L12:
        r113 = r113 + 1;
        r100 = r213;
    L16:
        if (f5.h(r214, "16H") == false) goto L22;
        o(JSONObjectProtectorUtils.getJSONObject(r214, "16H").optString("able"), false);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 16H");
    L22:
        if (f5.h(r214, "11K") == false) goto L30;
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r214, "11K");     // Catch: Throwable -> L27
        r110.f380127a = o(JSONObjectProtectorUtils.getString(r101, "able"), false);     // Catch: Throwable -> L27
        if (r101.has("off") == false) goto L30;
        r110.f380128b = JSONObjectProtectorUtils.getJSONObject(r101, "off");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 11K");
    L30:
        if (f5.h(r214, "145") == false) goto L36;
        JSONObjectProtectorUtils.getJSONObject(r214, "145");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 145");
    L36:
        if (f5.h(r214, "14D") == false) goto L42;
        JSONObjectProtectorUtils.getJSONObject(r214, "14D");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 14D");
    L42:
        if (f5.h(r214, "151") == false) goto L50;
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r214, "151");     // Catch: Throwable -> L47
        if (r102 == null) goto L50;
        o(r102.optString("able"), false);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 151");
    L50:
        if (f5.h(r214, "17S") == true) goto L171;
    L96:
        String r115 = "ustv";
        String r116 = "ust";
        String r117 = "umv";
    L98:
        if (f5.h(r214, "15K") == true) goto L149;
    L119:
        Context r103 = r210;
    L121:
        if (f5.h(r214, "183") == false) goto L127;
        k0.f(r211, JSONObjectProtectorUtils.getJSONObject(r214, "183"));     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 183");
    L127:
        if (f5.h(r214, "17I") == false) goto L133;
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r214, "17I");     // Catch: Throwable -> L130
        boolean r105 = o(r104.optString("na"), false);     // Catch: Throwable -> L130
        boolean r106 = o(r104.optString("aa"), false);     // Catch: Throwable -> L130
        n4a.c.f517196b = r105;     // Catch: Throwable -> L130
        n4a.c.f517197c = r106;     // Catch: Throwable -> L130
        SharedPreferences.Editor r107 = y.b(r103, "open_common");     // Catch: Throwable -> L130
        y.h(r107, "a4", r105);     // Catch: Throwable -> L130
        y.h(r107, "a5", r106);     // Catch: Throwable -> L130
        y.e(r107);     // Catch: Throwable -> L130
    L130:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 17I");
    L133:
        if (f5.h(r214, "1A4") == false) goto L184;
        JSONObject r108 = JSONObjectProtectorUtils.getJSONObject(r214, "1A4");     // Catch: Throwable -> L146
        String r109 = r108.optString("ada");     // Catch: Throwable -> L146
        o(r109, true);     // Catch: Throwable -> L146
        long r118 = r108.optLong(CJPayFingerprintSharedPrefUtils.KEY_IV, 86400000);     // Catch: Throwable -> L146
        SharedPreferences.Editor r119 = y.b(r103, "open_common");     // Catch: Throwable -> L146
        y.g(r119, "a16", r109);     // Catch: Throwable -> L146
        if (r119 != null) goto L137;
    L144:
        y.e(r119);     // Catch: Throwable -> L146
        return;
    L137:
        if (TextUtils.isEmpty("a17") == true) goto L144;
        r119.putLong("a17", r118);     // Catch: Throwable -> L141
    L141:
        th = move-exception;
        r.f(th, "csp", "plv");     // Catch: Throwable -> L146
    L146:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 1A4");
        return;
    L184:
        return;
    L149:
        JSONObject r120 = JSONObjectProtectorUtils.getJSONObject(r214, "15K");     // Catch: Throwable -> L117
        if (r120 == null) goto L119;
        boolean r121 = o(r120.optString("ucf"), g.f380139a);     // Catch: Throwable -> L117
        boolean r122 = o(r120.optString("fsv2"), g.f380140b);     // Catch: Throwable -> L117
        boolean r123 = o(r120.optString("usc"), g.f380141c);     // Catch: Throwable -> L117
        String r124 = r117;
        int r125 = r120.optInt(r124, g.f380142d);     // Catch: Throwable -> L117
        String r126 = r116;
        boolean r127 = o(r120.optString(r126), g.f380143e);     // Catch: Throwable -> L117
        String r128 = r115;
        int r129 = r120.optInt(r128, g.f380144f);     // Catch: Throwable -> L117
        if (r121 == g.f380139a) goto L104;
    L112:
        g.f380139a = r121;     // Catch: Throwable -> L117
        g.f380140b = r122;     // Catch: Throwable -> L117
        g.f380141c = r123;     // Catch: Throwable -> L117
        g.f380142d = r125;     // Catch: Throwable -> L117
        g.f380143e = r127;     // Catch: Throwable -> L117
        g.f380144f = r129;     // Catch: Throwable -> L117
        r103 = r210;
        SharedPreferences.Editor r130 = y.b(r103, "open_common");     // Catch: Throwable -> L116
        y.h(r130, "ucf", g.f380139a);     // Catch: Throwable -> L116
        y.h(r130, "fsv2", g.f380140b);     // Catch: Throwable -> L116
        y.h(r130, "usc", g.f380141c);     // Catch: Throwable -> L116
        y.f(r130, r124, g.f380142d);     // Catch: Throwable -> L116
        y.h(r130, r126, g.f380143e);     // Catch: Throwable -> L116
        y.f(r130, r128, g.f380144f);     // Catch: Throwable -> L116
        y.e(r130);     // Catch: Throwable -> L116
        goto L121
    L104:
        if (r122 != g.f380140b) goto L112;
        if (r123 != g.f380141c) goto L112;
        int r131 = g.f380142d;     // Catch: Throwable -> L117
        if (r125 != r131) goto L112;
        if (r127 != g.f380143e) goto L112;
        if (r129 == r131) goto L119;
    L117:
        th = move-exception;
        r103 = r210;
        n.a(th, "AuthConfigManager", "load 15K");
        goto L121
    L171:
        JSONObject r132 = JSONObjectProtectorUtils.getJSONObject(r214, "17S");     // Catch: Throwable -> L92
        if (r132 == null) goto L58;
        boolean r133 = o(r132.optString("able"), false);     // Catch: Throwable -> L92
        if (r133 == f380097d) goto L58;
        f380097d = r133;     // Catch: Throwable -> L92
        if (r210 == null) goto L58;
        SharedPreferences.Editor r134 = y.b(r210, "open_common");     // Catch: Throwable -> L92
        y.h(r134, "a2", r133);     // Catch: Throwable -> L92
        y.e(r134);     // Catch: Throwable -> L92
    L58:
        if (r132 == null) goto L96;
        boolean r135 = o(r132.optString("static_enable"), true);     // Catch: Throwable -> L92
        boolean r136 = o(r132.optString("static_ip_direct_enable"), false);     // Catch: Throwable -> L92
        int r137 = r132.optInt("static_timeout", 5) * 1000;     // Catch: Throwable -> L92
        int r138 = r132.optInt("static_retry", 3);     // Catch: Throwable -> L92
        r115 = "ustv";
        boolean r139 = o(r132.optString("bgp_enable"), true);     // Catch: Throwable -> L90
        r116 = "ust";
        boolean r140 = o(r132.optString("bgp_ip_direct_enable"), false);     // Catch: Throwable -> L88
        r117 = "umv";
        int r141 = r132.optInt("bgp_retry", 3);     // Catch: Throwable -> L86
        boolean r142 = o(r132.optString("perf_data_upload_enable"), false);     // Catch: Throwable -> L86
        if (r135 == f380109p) goto L68;
    L81:
        f380109p = r135;     // Catch: Throwable -> L86
        f380110q = r136;     // Catch: Throwable -> L86
        f380108o = r137;     // Catch: Throwable -> L86
        f380111r = r138;     // Catch: Throwable -> L86
        f380112s = r139;     // Catch: Throwable -> L86
        f380113t = r140;     // Catch: Throwable -> L86
        f380114u = r141;     // Catch: Throwable -> L86
        f380115v = r142;     // Catch: Throwable -> L86
        if (r210 == null) goto L84;
        SharedPreferences.Editor r143 = y.b(r210, "open_common");     // Catch: Throwable -> L86
        y.h(r143, "a13", r135);     // Catch: Throwable -> L86
        y.h(r143, "a6", r139);     // Catch: Throwable -> L86
        y.h(r143, "a7", r136);     // Catch: Throwable -> L86
        y.f(r143, "a8", r137);     // Catch: Throwable -> L86
        y.f(r143, "a9", r138);     // Catch: Throwable -> L86
        y.h(r143, "a10", r140);     // Catch: Throwable -> L86
        y.f(r143, "a11", r141);     // Catch: Throwable -> L86
        y.h(r143, "a12", r142);     // Catch: Throwable -> L86
        y.e(r143);     // Catch: Throwable -> L86
    L84:
        goto L98
    L68:
        if (r136 != f380110q) goto L81;
        if (r137 != f380108o) goto L81;
        if (r138 != f380111r) goto L81;
        if (r139 != f380112s) goto L81;
        if (r140 != f380113t) goto L81;
        if (r141 != f380114u) goto L81;
        if (r142 == f380115v) goto L84;
    L86:
        th = th;
    L95:
        n.a(th, "AuthConfigManager", "load 17S");
    L88:
        th = th;
    L89:
        r117 = "umv";
    L90:
        th = th;
    L94:
        r116 = "ust";
    L92:
        th = th;
        r115 = "ustv";
    L13:
        th = move-exception;
        n.a(th, INotificationHitPoint.NoticeType.AT, "co");
        goto L16
    }

    public static synchronized void h(String r100, boolean r101, String r102, String r103, String r104) {
        monitor-enter(i.class);
    L29:
        th = move-exception;
        n.a(th, INotificationHitPoint.NoticeType.AT, "lca");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(i.class);
        return;
    L9:
        if (f380104k != null) goto L11;
        f380104k = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        f380104k.put(r100, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (f380105l != null) goto L16;
        monitor-exit(i.class);
        return;
    L16:
        if (f380105l.containsKey(r100) == true) goto L20;
        monitor-exit(i.class);
        return;
    L20:
        if (TextUtils.isEmpty(r100) == false) goto L23;
        monitor-exit(i.class);
        return;
    L23:
        if (r101 == true) goto L25;
    L26:
        k1.f517430d.b(new a(r100, r102, r103, r104));     // Catch: Throwable -> L29
        monitor-exit(i.class);
        return;
    L25:
        k0.g(true, r100);     // Catch: Throwable -> L29
        goto L26
    }
}
