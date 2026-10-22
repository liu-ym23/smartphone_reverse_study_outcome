package com.bytedance.bdinstall;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import g84.c;
import g84.e;
import i84.a;
import i84.m;
import i84.p;
import i84.q;
import i84.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public d0 a;
    public volatile boolean b;
    public int c;
    public final y d;
    public final Map<String, String> e;
    public final Map<String, String> f;
    public i84.l g;

    public f(y r2) {
        this.b = false;
        this.c = 36;
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.d = r2;
    }

    public static void c(Map<String, String> r3, Map<String, String> r4, boolean r5) {
        if (r3 != null) goto L24;
        return;
    L24:
        if (r3.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r6 = r3.entrySet().iterator();     // Catch: Exception -> L23
    L6:
        if (r6.hasNext() == false) goto L43;
        Map.Entry<String, String> r0 = r6.next();     // Catch: Exception -> L23
        if (r0 == null) goto L6;
        String r1 = r0.getKey();     // Catch: Exception -> L23
        String r2 = r0.getValue();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (TextUtils.isEmpty(r2) == true) goto L6;
        if (r5 == false) goto L20;
        if (r4.containsKey(r1) == true) goto L6;
    L20:
        r4.put(r1, r2);     // Catch: Exception -> L23
        goto L6
    L43:
        return;
    L41:
        return;
    }

    public final String a(Context r6, StringBuilder r7, boolean r8, Level r9) {
        String r0 = r7.toString();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return r0;
    L5:
        Uri r1 = UriProtector.parse(r0);
        Set<String> r2 = UriProtector.getQueryParameterNames(r1);
        Uri.Builder r3 = r1.buildUpon();
        LinkedHashMap r4 = new LinkedHashMap(this.c);
        b(r6, r8, r4, r9);
        Iterator r10 = r4.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        String r5 = (String) r11.getValue();
        if (r2.contains(r12) == true) goto L7;
        if (TextUtils.isEmpty(r5) == true) goto L7;
        r3.appendQueryParameter(r12, (String) r11.getValue());
        goto L7
    L13:
        r7.delete(0, r7.length());
        r7.append(r3.build().toString());
        this.c = r4.size();
        return r7.toString();
    }

    public final void b(Context r10, boolean r11, Map r12, Level r13) {
        if (r12 != null) goto L4;
        return;
    L4:
        String r1 = "android";
        r12.put("device_platform", "android");
        p.a r0 = p.a;
        boolean r2 = false;
        if (((Boolean) r0.b(new Object[0])).booleanValue() == false) goto L7;
        r1 = "harmony";
    L7:
        r12.put("os", r1);
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        if (r11 == false) goto L16;
        r12.put("ssmix", "a");
    L16:
        r12.put("_rticket", String.valueOf(System.currentTimeMillis()));
        o0 r14 = ((k) this.d).a;
        x r3 = ((k) this.d).b;
        String r4 = n.b(r14);
        if (TextUtils.isEmpty(r4) == false) goto L21;
        if (r3 == null) goto L21;
        r3.a();
        r4 = n.d(r10);
    L21:
        if (TextUtils.isEmpty(r4) == true) goto L24;
        r12.put("cdid", r4);
    L24:
        if (r14 == null) goto L26;
        m r5 = new m(r14);
    L27:
        if (r5 != null) goto L31;
        if (r3 == null) goto L31;
        r5 = new m(r3);
    L31:
        if (r5 == null) goto L95;
        o0 r6 = r5.b;
        if (r6 == null) goto L37;
        String r7 = r6.h;
        if (TextUtils.isEmpty(r7) == false) goto L44;
        r7 = r5.b.g;
    L44:
        if (TextUtils.isEmpty(r7) == true) goto L46;
        r12.put("channel", r7);
    L46:
        o0 r8 = r5.b;
        if (r8 == null) goto L49;
        int r9 = r8.a;
    L52:
        long r15 = r9;
    L54:
        r12.put("aid", String.valueOf(r15));
        o0 r16 = r5.b;
        if (r16 == null) goto L57;
        String r17 = r16.f;
    L61:
        if (r17 == null) goto L63;
        r12.put("app_name", r17);
    L64:
        o0 r18 = r5.b;
        if (r18 == null) goto L67;
        long r19 = r18.f();
    L71:
        r12.put("version_code", String.valueOf(r19));
        o0 r20 = r5.b;
        if (r20 == null) goto L74;
        String r21 = r20.e();
    L78:
        if (r21 == null) goto L80;
        r12.put("version_name", r21);
    L80:
        o0 r22 = r5.b;
        if (r22 == null) goto L83;
        long r23 = r22.b();
    L87:
        r12.put("manifest_version_code", String.valueOf(r23));
        o0 r24 = r5.b;
        if (r24 == null) goto L90;
        long r25 = r24.d();
    L94:
        r12.put("update_version_code", String.valueOf(r25));
        goto L95
    L90:
        g r26 = r5.a;
        if (r26 == null) goto L93;
        r25 = r26.getUpdateVersionCode();
        goto L94
    L93:
        r25 = 0;
        goto L94
    L83:
        g r28 = r5.a;
        if (r28 == null) goto L86;
        r23 = r28.getManifestVersionCode();
        goto L87
    L86:
        r23 = 0;
        goto L87
    L74:
        g r29 = r5.a;
        if (r29 == null) goto L77;
        r21 = r29.getVersion();
        goto L78
    L77:
        r21 = null;
        goto L78
    L67:
        g r30 = r5.a;
        if (r30 == null) goto L70;
        r19 = r30.getVersionCode();
        goto L71
    L70:
        r19 = 0;
        goto L71
    L63:
        t.e(new IllegalArgumentException("app_name is null"));
        goto L64
    L57:
        g r31 = r5.a;
        if (r31 == null) goto L60;
        r17 = r31.getAppName();
        goto L61
    L60:
        r17 = null;
        goto L61
    L49:
        g r32 = r5.a;
        if (r32 == null) goto L53;
        r9 = r32.getAid();
        goto L52
    L53:
        r15 = 0;
        goto L54
    L37:
        g r33 = r5.a;
        if (r33 == null) goto L42;
        r7 = r33.getTweakedChannel();
        if (TextUtils.isEmpty(r7) == false) goto L44;
        r7 = r5.a.getChannel();
        goto L44
    L42:
        r7 = null;
    L95:
        if (r14 == null) goto L97;
        x r34 = r14.j;
    L98:
        if (r34 == null) goto L101;
        r3 = r34;
    L101:
        if (r3 == null) goto L117;
        String r35 = r3.getAbVersion();
        if (TextUtils.isEmpty(r35) == true) goto L105;
        r12.put("ab_version", r35);
    L105:
        String r36 = r3.getAbClient();
        if (TextUtils.isEmpty(r36) == true) goto L108;
        r12.put("ab_client", r36);
    L108:
        String r37 = r3.getAbGroup();
        if (TextUtils.isEmpty(r37) == true) goto L111;
        r12.put("ab_group", r37);
    L111:
        String r38 = r3.getAbFeature();
        if (TextUtils.isEmpty(r38) == true) goto L114;
        r12.put("ab_feature", r38);
    L114:
        long r39 = r3.getAbFlag();
        if (r39 <= 0) goto L117;
        r12.put("abflag", String.valueOf(r39));
    L117:
        if (r14 == null) goto L122;
        c r40 = (c) e.a(c.class, String.valueOf(r14.a));
        if (r40 == null) goto L122;
        r40.a();
    L122:
        if (TextUtils.isEmpty(i84.y.a) == false) goto L135;
        if (r10 == null) goto L135;
        Resources r41 = r10.getResources();
        DisplayMetrics r42 = WindowDisplayMetricsOverride.apply(r41, r41.getDisplayMetrics());
        if (r42 != null) goto L127;
        int r43 = 0;
    L128:
        Resources r44 = r10.getResources();
        DisplayMetrics r45 = WindowDisplayMetricsOverride.apply(r44, r44.getDisplayMetrics());
        if (r45 != null) goto L131;
        int r46 = 0;
    L132:
        if (r43 <= 0) goto L135;
        if (r46 <= 0) goto L135;
        i84.y.a = r43 + "*" + r46;
        goto L135
    L131:
        r46 = r45.heightPixels;
        goto L132
    L127:
        r43 = r42.widthPixels;
    L135:
        String r47 = i84.y.a;
        if (TextUtils.isEmpty(r47) == true) goto L139;
        r12.put("resolution", r47);
    L139:
        if (i84.y.b != (-1)) goto L142;
        if (r10 == null) goto L142;
        Resources r48 = r10.getApplicationContext().getResources();
        i84.y.b = WindowDisplayMetricsOverride.apply(r48, r48.getDisplayMetrics()).densityDpi;
    L142:
        int r49 = i84.y.b;
        if (r49 <= 0) goto L145;
        r12.put("dpi", String.valueOf(r49));
    L145:
        String r50 = Build.BRAND;
        if (r50.equals("Pico") == false) goto L148;
        String r51 = p.b();
    L149:
        r12.put("device_type", r51);
        r12.put("device_brand", r50);
        r12.put("language", Locale.getDefault().getLanguage());
        r12.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        String r52 = Build.VERSION.RELEASE;     // Catch: Exception -> L157
        if (r52 != null) goto L153;
    L155:
        r12.put("os_version", r52);     // Catch: Exception -> L157
        goto L159
    L153:
        if (r52.length() <= 10) goto L155;
        r52 = r52.substring(0, 10);     // Catch: Exception -> L157
    L159:
        if (this.g == null) goto L163;
        String r53 = i84.l.d.name();
        if (TextUtils.isEmpty(r53) == true) goto L166;
        r12.put("ac", r53);
        t.a("NetworkStatusProvider network type is " + r53);
    L166:
        c(this.e, r12, false);
        if (r13 != Level.L0) goto L273;
        c(this.f, r12, false);
    L273:
        d0 r54 = this.a;     // Catch: Exception -> L176
        if (r54 != null) goto L173;
        HashMap r55 = null;
    L174:
        c(r55, r12, true);     // Catch: Exception -> L176
    L178:
        boolean r56 = c1.g(r10);
        n0 r57 = ((k) this.d).j();
        if (r56 == false) goto L185;
        boolean r58 = this.b;
        if (r58 == true) goto L192;
        r58 = a.a(r10, r14).getBoolean("_install_started_v2", false);
        if (r58 == false) goto L192;
        this.b = true;
    L192:
        if (r58 == false) goto L263;
        if (r57 == null) goto L215;
        if (TextUtils.isEmpty(null) == true) goto L198;
        r12.put("klink_edi", null);
    L198:
        if (TextUtils.isEmpty(null) == true) goto L201;
        r12.put("klink_eii", null);
    L201:
        if (TextUtils.isEmpty(r57.b) == true) goto L204;
        r12.put("iid", r57.b);
    L204:
        if (TextUtils.isEmpty(r57.a) == true) goto L207;
        r12.put("device_id", r57.a);
    L207:
        if (TextUtils.isEmpty(r57.f) == true) goto L210;
        r12.put("klink_egdi", r57.f);
    L210:
        if (r13 != Level.L0) goto L215;
        String r59 = r57.c;
        if (TextUtils.isEmpty(r59) == true) goto L215;
        r12.put("openudid", r59);
    L215:
        if (r13 != Level.L0) goto L263;
        if (r14 == null) goto L242;
        if (r14.u == true) goto L242;
        String r110 = (String) q.e.b(new Object[]{r10, String.valueOf(r14.a), r14});
        if (TextUtils.isEmpty(r110) == true) goto L222;
        r12.put("mac_address", r110);
    L222:
        String r111 = q.b(r10, r14);
        if (TextUtils.isEmpty(r111) == false) goto L226;
    L238:
        r2 = true;
    L239:
        if (r2 == true) goto L242;
        r12.put("uuid", r111);
        goto L242
    L226:
        if (r111.equalsIgnoreCase("unknown") == true) goto L238;
        if (r111.equalsIgnoreCase("None") == true) goto L238;
        int r60 = 0;
    L233:
        if (r60 >= r111.length()) goto L238;
        if (r111.charAt(r60) != '0') goto L239;
        r60 = r60 + 1;
    L242:
        if (b84.a.b == null) goto L244;
    L253:
        String r112 = b84.a.b.a;
        if (TextUtils.isEmpty(r112) == true) goto L256;
        r12.put("aliyun_uuid", r112);
    L256:
        if (r56 == false) goto L263;
        String r113 = e84.k.e(r10).c();     // Catch: Throwable -> L261
        if (TextUtils.isEmpty(r113) == true) goto L263;
        r12.put("oaid", r113);     // Catch: Throwable -> L261
    L261:
        th = move-exception;
        th.printStackTrace();
        goto L263
    L244:
        monitor-enter(b84.a.class);
    L250:
        th = move-exception;
        throw th;
    L246:
        if (b84.a.b != null) goto L248;
        b84.a.b = new b84.a();     // Catch: Throwable -> L250
    L248:
        monitor-exit(b84.a.class);     // Catch: Throwable -> L250
    L263:
        if (r14 == null) goto L271;
        String r114 = r14.a();
        j74.a r115 = i.a;
        k r116 = k.k(r114);
        if (r116 == null) goto L271;
        boolean r117 = r116.c.b();
        if (r56 == false) goto L271;
        if (r117 == false) goto L271;
        e84.k.e(r10).d();
    L271:
        this.d.getClass();
        return;
    L185:
        if (r57 != null) goto L187;
    L191:
        r58 = false;
        goto L192
    L187:
        if (TextUtils.isEmpty(r57.a) == true) goto L191;
        if (TextUtils.isEmpty(r57.b) == true) goto L191;
        r58 = true;
        goto L192
    L173:
        r55 = r54.a(r13);     // Catch: Exception -> L176
    L176:
        e = move-exception;
        t.e(e);
        goto L178
    L163:
        String r61 = NetworkUtils.getNetworkAccessType(r10);
        if (TextUtils.isEmpty(r61) == true) goto L166;
        r12.put("ac", r61);
        t.a("NetworkUtils network type is " + r61);
        goto L166
    L148:
        r51 = Build.MODEL;
        goto L149
    L97:
        r34 = null;
        goto L98
    L26:
        r5 = null;
        goto L27
    L9:
        if (((Boolean) r0.b(new Object[0])).booleanValue() == false) goto L14;
        r12.put("sub_os_api", String.valueOf(u.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L12
        goto L14
    }
}
