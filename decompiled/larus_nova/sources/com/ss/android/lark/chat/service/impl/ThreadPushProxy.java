package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadPushProxy extends c0c.b implements m6b.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.q f416445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.q> f416447d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.q
    public final void G1(final k2.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f416447d.a(new com.ss.android.lark.passportc.convention.b.C5239b(k2.b.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ThreadPushProxy$addPushThreadListener$1(r100), new ThreadPushProxy$addPushThreadListener$2(r100)));
    }

    @Override // m6b.q
    public final void Ia(k2.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f416447d.d(new com.ss.android.lark.passportc.convention.b.C5239b(k2.b.class, r100));
    }

    @Override // m6b.q
    public final void be(k2.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f416447d.d(new com.ss.android.lark.passportc.convention.b.C5239b(k2.a.class, r100));
    }

    @Override // m6b.q
    public final void je(final k2.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f416447d.a(new com.ss.android.lark.passportc.convention.b.C5239b(k2.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new ThreadPushProxy$addPushMyThreadReplyPromptListener$1(r100), new ThreadPushProxy$addPushMyThreadReplyPromptListener$2(r100)));
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ThreadPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        m6b.q r101 = this.f416447d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ThreadPush");
        k2 r102 = (k2) r101;
        r102.f416535c.d();
        r102.f416535c.a();
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ThreadPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    public ThreadPushProxy(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.q> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.q.class), m6b.q.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416445b = r103.b();
        this.f416446c = r101;
        this.f416447d = r103;
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
        Log.i("ThreadPushProxy", r102.toString());
        m6b.q r108 = this.f416447d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ThreadPush");
        k2 r109 = (k2) r108;
        m6b.r r110 = r109.f416535c;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.ThreadPushRepositoryV2");
        if (Intrinsics.areEqual(((l2) r110).f416540a, "absent_user") == false) goto L20;
        Log.w("ThreadPushProxy", "from user is ABSENT_USER, call release manually");
        r109.f416535c.d();
        r109.f416535c.a();
    L20:
        com.ss.android.lark.passportc.internal.v r111 = this.f416446c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        m6b.q r113 = (m6b.q) e0c.k.b(r111.c(r112), m6b.q.class);
        this.f416447d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
