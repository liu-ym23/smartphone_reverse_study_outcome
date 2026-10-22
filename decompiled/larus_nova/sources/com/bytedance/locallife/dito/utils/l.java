package com.bytedance.locallife.dito.utils;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.host.settings.DitoSettings;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DitoSettings f258706a;

    public static final jq6.a a() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.i();
        return en6.f.f473170a;
    L5:
        return null;
    }

    public static final hq6.a b() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.h();
        return en6.b.f473166a;
    L5:
        return null;
    }

    public static final iq6.a c() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.a();
        return en6.d.f473168a;
    L5:
        return null;
    }

    public static final Gson d() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L7;
        r101.m();
        Gson r102 = en6.i.f473172a.a();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new Gson();
    }

    public static final iq6.b f() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.c();
        return en6.k.f473174a;
    L5:
        return null;
    }

    public static final lq6.a g() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.getLogService();
        return en6.e.f473169a;
    L5:
        return null;
    }

    public static final mq6.d h() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.j();
        return en6.l.f473175a;
    L5:
        return null;
    }

    public static final nq6.a i() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.b();
        return en6.m.f473176a;
    L5:
        return null;
    }

    public static final oq6.b j() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.g();
        return en6.n.f473177a;
    L5:
        return null;
    }

    public static final DitoSettings k() {
        Intrinsics.checkNotNullParameter(Dito.f257280a, "<this>");
        com.bytedance.locallife.dito.config.h r100 = (com.bytedance.locallife.dito.config.h) Dito.a().a(com.bytedance.locallife.dito.config.h.class);
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a() != true) goto L7;
    L9:
        if (r101 == false) goto L22;
        DitoSettings r102 = f258706a;
        if (r102 == null) goto L13;
        return r102;
    L13:
        pq6.a r103 = l();
        if (r103 == null) goto L16;
        DitoSettings r104 = (DitoSettings) ((en6.p) r103).a("aweme_dito_settings", DitoSettings.class);
    L17:
        if (r104 == null) goto L21;
        f258706a = r104;
        return r104;
    L21:
        return (DitoSettings) Dito.f257283d.getValue();
    L16:
        r104 = null;
        goto L17
    L22:
        pq6.a r105 = l();
        if (r105 == null) goto L28;
        DitoSettings r106 = (DitoSettings) ((en6.p) r105).a("aweme_dito_settings", DitoSettings.class);
        if (r106 == null) goto L28;
        return r106;
    L28:
        return (DitoSettings) Dito.f257283d.getValue();
    L7:
        r101 = false;
        goto L9
    }

    public static final pq6.a l() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.getSettingsService();
        return en6.p.f473180a;
    L5:
        return null;
    }

    public static final qq6.a m() {
        Dito r100 = Dito.f257280a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        gq6.a r101 = e(r100);
        if (r101 == null) goto L5;
        r101.l();
        return en6.q.f473181a;
    L5:
        return null;
    }

    public static final gq6.a e(Dito r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getClass();
        return (gq6.a) Dito.a().a(gq6.a.class);
    }
}
