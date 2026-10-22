package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class PreviewPushProxy extends c0c.b implements a2b.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a2b.c f411549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f411550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a2b.c> f411551d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.c
    public final void N4(tya.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f411551d.d(new com.ss.android.lark.passportc.convention.b.C5239b(tya.a.class, r100));
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("PreviewPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        a2b.c r101 = this.f411551d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.PreviewPush");
        ((PreviewPush) r101).f411542a.a();
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("PreviewPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // a2b.c
    public final void v9(final tya.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f411551d.a(new com.ss.android.lark.passportc.convention.b.C5239b(tya.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new PreviewPushProxy$startPush$1(r100), new PreviewPushProxy$startPush$2(r100)));
    }

    public PreviewPushProxy(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a2b.c> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), a2b.c.class), a2b.c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411549b = r103.b();
        this.f411550c = r101;
        this.f411551d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        StringBuilder r102 = new StringBuilder("preparing, fromUser: ");
        String r103 = "";
        if (r100 == null) goto L8;
        UserSession r104 = r100.f475034b;
        if (r104 == null) goto L8;
        String r105 = r104.f438138b;
        if (r105 == null) goto L8;
    L9:
        r102.append(r105);
        r102.append(", toUser: ");
        if (r101 == null) goto L17;
        UserSession r106 = r101.f475034b;
        if (r106 == null) goto L17;
        String r107 = r106.f438138b;
        if (r107 == null) goto L17;
        r103 = r107;
    L17:
        r102.append(r103);
        Log.i("PreviewPushProxy", r102.toString());
        a2b.c r108 = this.f411551d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.PreviewPush");
        PreviewPush r109 = (PreviewPush) r108;
        a2b.d r110 = r109.f411542a;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chat.api.service.impl.PreviewPushRepositoryV2");
        if (Intrinsics.areEqual(((PreviewPushRepositoryV2) r110).f411552a, "absent_user") == false) goto L20;
        Log.w("PreviewPushProxy", "from user is ABSENT_USER, call release manually");
        r109.f411542a.a();
    L20:
        com.ss.android.lark.passportc.internal.v r111 = this.f411550c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        a2b.c r113 = (a2b.c) e0c.k.b(r111.c(r112), a2b.c.class);
        this.f411551d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
