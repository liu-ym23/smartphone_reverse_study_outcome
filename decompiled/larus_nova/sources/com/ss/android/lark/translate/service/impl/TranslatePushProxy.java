package com.ss.android.lark.translate.service.impl;

import com.ss.android.lark.biz.im.api.m0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TranslatePushProxy extends c0c.b implements com.ss.android.lark.translate.service.impl.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.translate.service.impl.a f444328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f444329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.translate.service.impl.a> f444330d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void g0(fcb.a r100) {
        this.f444328b.g0(r100);
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void Q6(final n.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f444330d.a(new com.ss.android.lark.passportc.convention.b.C5239b(n.b.class, r100), new com.ss.android.lark.passportc.convention.b.c(new TranslatePushProxy$addPushTranslateStateListener$1(r100), new TranslatePushProxy$addPushTranslateStateListener$2(r100)));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void X6(n.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f444330d.d(new com.ss.android.lark.passportc.convention.b.C5239b(n.a.class, r100));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void addPushTranslateLanguageSettingListener(final m0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f444330d.a(new com.ss.android.lark.passportc.convention.b.C5239b(m0.class, r100), new com.ss.android.lark.passportc.convention.b.c(new AnonymousClass1(r100), new AnonymousClass2(r100)));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void ee(final n.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f444330d.a(new com.ss.android.lark.passportc.convention.b.C5239b(n.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new TranslatePushProxy$addPushImageTranslationInfoListener$1(r100), new TranslatePushProxy$addPushImageTranslationInfoListener$2(r100)));
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void ef(n.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f444330d.d(new com.ss.android.lark.passportc.convention.b.C5239b(n.b.class, r100));
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ImSdkChatPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        com.ss.android.lark.translate.service.impl.a r101 = this.f444330d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.translate.service.impl.TranslatePush");
        n r102 = (n) r101;
        r102.f444346e.f();
        r102.f444346e.c();
        r102.f444346e.b();
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ImSdkChatPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // com.ss.android.lark.translate.service.impl.a
    public final void removePushTranslateLanguageSettingListener(m0 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f444330d.d(new com.ss.android.lark.passportc.convention.b.C5239b(m0.class, r100));
    }

    public TranslatePushProxy(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.translate.service.impl.a> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), com.ss.android.lark.translate.service.impl.a.class), com.ss.android.lark.translate.service.impl.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f444328b = r103.b();
        this.f444329c = r101;
        this.f444330d = r103;
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
        Log.i("ImSdkChatPushProxy", r102.toString());
        com.ss.android.lark.translate.service.impl.a r108 = this.f444330d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.translate.service.impl.TranslatePush");
        n r109 = (n) r108;
        b r110 = r109.f444346e;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.translate.service.impl.TranslatePushRepositoryV2");
        if (Intrinsics.areEqual(((o) r110).f444348a, "absent_user") == false) goto L20;
        Log.w("ImSdkChatPushProxy", "from user is ABSENT_USER, call release manually");
        r109.f444346e.f();
        r109.f444346e.c();
        r109.f444346e.b();
    L20:
        v r111 = this.f444329c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        com.ss.android.lark.translate.service.impl.a r113 = (com.ss.android.lark.translate.service.impl.a) e0c.k.b(r111.c(r112), com.ss.android.lark.translate.service.impl.a.class);
        this.f444330d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
