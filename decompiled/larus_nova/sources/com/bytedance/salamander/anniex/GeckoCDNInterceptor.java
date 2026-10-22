package com.bytedance.salamander.anniex;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.keva.Keva;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class GeckoCDNInterceptor implements i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c5 f267876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w4 f267877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d5 f267878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f267879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GeckoCDNSource f267880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.salamander.adapter.e f267881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f267882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f267883h;

    public final void c() {
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "start refresh");
        GeckoCDNSource r100 = this.f267880e;
        com.bytedance.salamander.adapter.e r101 = this.f267881f;
        c5 r102 = this.f267876a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("diskStorage");
        r102 = null;
    L6:
        r100.b(new e5(r101, r102, new GeckoCDNInterceptor$refreshCache$1(this)));
    }

    public final void d() {
        if (this.f267879d == true) goto L9;
        return;
    L9:
        c();     // Catch: Throwable -> L7
        int r100 = com.bytedance.salamander.adapter.r.f267796a;     // Catch: Throwable -> L7
        Function1<Boolean, Object> r101 = new GeckoCDNInterceptor$scheduleNextExecution$1(this);     // Catch: Throwable -> L7
        com.bytedance.salamander.adapter.i r102 = com.bytedance.salamander.adapter.i.f267785d;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.salamander.adapter.Queue");     // Catch: Throwable -> L7
        int r103 = com.bytedance.rts.foundation.e.f267578a;     // Catch: Throwable -> L7
        Long r104 = this.f267882g;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L7
        com.bytedance.salamander.adapter.r.a.a(r101, r102, r104.longValue());     // Catch: Throwable -> L7
        return;
    L7:
        this.f267879d = false;
    }

    public GeckoCDNInterceptor(c5 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "diskStorage");
        GeckoCDNSource r102 = new GeckoCDNSource();
        this.f267880e = r102;
        this.f267881f = new com.bytedance.salamander.adapter.e();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f267876a = r100;
        r102.f267884a = r101;
    }

    @Override // com.bytedance.salamander.anniex.i3
    public final void a(y4 r210, Function1<? super z4, Unit> r211, Function2<? super Integer, ? super String, Unit> r212) {
        Intrinsics.checkNotNullParameter(r210, "info");
        Intrinsics.checkNotNullParameter(r211, "success");
        Intrinsics.checkNotNullParameter(r212, "fail");
        a5 r100 = r210.f268528f;
        String r101 = null;
        if (r100 == null) goto L5;
        q2 r102 = r100.f267953a;
    L7:
        if (r102 == null) goto L9;
        Intrinsics.checkNotNull(r100);
        q2 r103 = r100.f267953a;
        r103.getClass();
        Intrinsics.checkNotNullParameter("cdn", "<set-?>");
        r103.f268319o = "cdn";
    L9:
        this.f267881f.a();
        if (this.f267878c == null) goto L12;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "settings use memory cache");
        d5 r104 = this.f267878c;
        Intrinsics.checkNotNull(r104);
    L13:
        long r105 = 0;
        String r110 = "";
        if (r104 == null) goto L21;
        a5 r106 = r210.f268528f;
        if (r106 == null) goto L18;
        q2 r111 = r106.f267953a;
    L19:
        if (r111 == null) goto L50;
        Intrinsics.checkNotNull(r106);
        q2 r107 = r106.f267953a;
        r107.getClass();
        Intrinsics.checkNotNullParameter("memory", "<set-?>");
        r107.f268308d = "memory";
    L50:
        this.f267881f.b();
        boolean r108 = false;
        if (r104 == null) goto L84;
        a5 r112 = r210.f268528f;
        if (r112 == null) goto L55;
        q2 r113 = r112.f267953a;
    L56:
        if (r113 == null) goto L67;
        Intrinsics.checkNotNull(r112);
        q2 r114 = r112.f267953a;
        JSONObject r115 = r104.f268025b;
        if (r115 == null) goto L60;
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNull(r115);
        r101 = com.bytedance.anniex.bd.foundation.impl.o.o(r115, "api_type");
    L60:
        if (r101 != null) goto L62;
        r101 = "";
    L62:
        r114.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r114.f268316l = r101;
        a5 r109 = r210.f268528f;
        Intrinsics.checkNotNull(r109);
        q2 r116 = r109.f267953a;
        String r117 = r104.f268026c;
        if (r117 == null) goto L66;
        r110 = r117;
    L66:
        r116.getClass();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r116.f268309e = r110;
    L67:
        z4 r118 = r104.a(r210);
        this.f267883h = false;
        int r119 = r118.f268539b;
        int r120 = x4.f268501d;
        if (r119 != 0) goto L71;
        r211.invoke(r118);
    L74:
        boolean r121 = false;
    L75:
        JSONObject r122 = r104.f268025b;
        if (r122 == null) goto L78;
        Intrinsics.checkNotNull(r122);
        Intrinsics.checkNotNull(r122);
        r105 = 1000 * com.bytedance.anniex.bd.foundation.impl.o.l(r122, "limit_second", 0);
    L78:
        int r123 = com.bytedance.rts.foundation.c.f267576a;
        int r124 = com.bytedance.rts.foundation.b.f267575a;
        if ((System.currentTimeMillis() - r104.f268027d) <= r105) goto L81;
        r108 = true;
    L81:
        if (r108 == false) goto L88;
        if (r121 == true) goto L89;
        c();
        return;
    L89:
        return;
    L88:
        return;
    L71:
        if (r119 != 3) goto L73;
        this.f267883h = true;
        r212.invoke(Integer.valueOf(r119), r118.f268540c);
        r121 = true;
        goto L75
    L73:
        r212.invoke(Integer.valueOf(r119), r118.f268540c);
        goto L74
    L55:
        r113 = null;
        goto L56
    L84:
        this.f267883h = false;
        b(r210, r211, r212, "remote");
        return;
    L18:
        r111 = null;
        goto L19
    L21:
        c5 r125 = this.f267876a;
        if (r125 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("diskStorage");
        r125 = null;
    L25:
        r125.getClass();
        com.bytedance.anniex.bd.foundation.impl.r r126 = new com.bytedance.anniex.bd.foundation.impl.r("annie_redirect");
        Intrinsics.checkNotNullParameter("redirect_rules", "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        Keva r127 = r126.f190153a;
        if (r127 == null) goto L28;
        String r128 = r127.getString("redirect_rules", "");
    L29:
        if (r128 != null) goto L32;
        r128 = "";
    L32:
        if (Intrinsics.areEqual(r128, "") == false) goto L34;
        r104 = null;
    L41:
        if (r104 == null) goto L43;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c("AnnieXRedirectTag", "settings use disk cache");
        this.f267878c = r104;
    L43:
        if (r104 == null) goto L50;
        a5 r129 = r210.f268528f;
        if (r129 == null) goto L47;
        q2 r130 = r129.f267953a;
    L48:
        if (r130 == null) goto L50;
        Intrinsics.checkNotNull(r129);
        q2 r131 = r129.f267953a;
        r131.getClass();
        Intrinsics.checkNotNullParameter(UploadTypeInf.DISK, "<set-?>");
        r131.f268308d = UploadTypeInf.DISK;
        goto L50
    L47:
        r130 = null;
        goto L48
    L34:
        Intrinsics.checkNotNullParameter(r128, "jsonString");
        JSONObject r132 = com.bytedance.anniex.bd.foundation.impl.o.d(r128);     // Catch: Throwable -> L37
        d5 r133 = new d5(com.bytedance.anniex.bd.foundation.impl.o.j(r132, "redirectRules", com.bytedance.anniex.bd.foundation.impl.o.c()), com.bytedance.anniex.bd.foundation.impl.o.j(r132, "commonConfig", com.bytedance.anniex.bd.foundation.impl.o.c()), com.bytedance.anniex.bd.foundation.impl.o.p(r132, "geckoCDNVersion"), com.bytedance.anniex.bd.foundation.impl.o.l(r132, "settingsDataInitTime", 0));     // Catch: Throwable -> L37
    L38:
        if (r133 != null) goto L40;
        r126.a("redirect_rules", "");
    L40:
        r104 = r133;
    L37:
        r133 = null;
        goto L38
    L28:
        r128 = null;
        goto L29
    L12:
        r104 = null;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public final void b(y4 r110, Function1<? super z4, Unit> r111, Function2<? super Integer, ? super String, Unit> r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Intrinsics.checkNotNullParameter(r111, "success");
        Intrinsics.checkNotNullParameter(r112, "fail");
        Intrinsics.checkNotNullParameter(r113, "configType");
        a5 r100 = r110.f268528f;
        if (r100 == null) goto L5;
        q2 r101 = r100.f267953a;
    L6:
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r100);
        q2 r102 = r100.f267953a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r102.f268308d = r113;
    L8:
        GeckoCDNSource r114 = this.f267880e;
        com.bytedance.salamander.adapter.e r103 = this.f267881f;
        c5 r104 = this.f267876a;
        if (r104 == null) goto L11;
        c5 r105 = r104;
    L12:
        r114.b(new a3(r103, r105, r110, r111, r112, new GeckoCDNInterceptor$fetchConfig$1(this)));
        return;
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("diskStorage");
        r105 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }
}
