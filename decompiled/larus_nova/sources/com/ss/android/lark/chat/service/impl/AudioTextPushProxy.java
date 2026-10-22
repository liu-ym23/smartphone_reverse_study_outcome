package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class AudioTextPushProxy extends c0c.b implements m6b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.a f416318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.a> f416320d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.a
    public final void L7(final f.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f416320d.a(new com.ss.android.lark.passportc.convention.b.C5239b(f.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new AudioTextPushProxy$addPushAudioTextListener$1(r100), new AudioTextPushProxy$addPushAudioTextListener$2(r100)));
    }

    @Override // m6b.a
    public final void Oe(f.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f416320d.d(new com.ss.android.lark.passportc.convention.b.C5239b(f.a.class, r100));
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("AudioTextPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        m6b.a r101 = this.f416320d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.AudioTextPush");
        ((f) r101).f416472c.b();
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("AudioTextPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    public AudioTextPushProxy(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.a> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.a.class), m6b.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416318b = r103.b();
        this.f416319c = r101;
        this.f416320d = r103;
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
        Log.i("AudioTextPushProxy", r102.toString());
        m6b.a r108 = this.f416320d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.AudioTextPush");
        f r109 = (f) r108;
        m6b.b r110 = r109.f416472c;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.chat.service.impl.AudioTextPushRepositoryV2");
        if (Intrinsics.areEqual(((g) r110).f416476a, "absent_user") == false) goto L20;
        Log.w("AudioTextPushProxy", "from user is ABSENT_USER, call release manually");
        r109.f416472c.b();
    L20:
        com.ss.android.lark.passportc.internal.v r111 = this.f416319c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        m6b.a r113 = (m6b.a) e0c.k.b(r111.c(r112), m6b.a.class);
        this.f416320d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
