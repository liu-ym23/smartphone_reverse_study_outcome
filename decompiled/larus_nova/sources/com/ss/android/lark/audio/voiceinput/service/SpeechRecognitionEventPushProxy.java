package com.ss.android.lark.audio.voiceinput.service;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class SpeechRecognitionEventPushProxy extends c0c.b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f409405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f409406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<o> f409407d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.o
    public final void M3(final w.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f409407d.a(new com.ss.android.lark.passportc.convention.b.C5239b(w.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new SpeechRecognitionEventPushProxy$addPushListener$1(r100), new SpeechRecognitionEventPushProxy$addPushListener$2(r100)));
    }

    @Override // c0c.b
    public final void mf(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ChatTabPushProxy", "destroy user: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
        o r101 = this.f409407d.c();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.audio.voiceinput.service.SpeechRecognitionEventPush");
        ((w) r101).f409437c.b();
    }

    @Override // c0c.b
    public final void of(f0c.g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("ChatTabPushProxy", "user onPrepared: " + r100.f475034b.f438138b);
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.o
    public final void x4(w.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f409407d.d(new com.ss.android.lark.passportc.convention.b.C5239b(w.a.class, r100));
    }

    public SpeechRecognitionEventPushProxy(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<o> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), o.class), o.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f409405b = r103.b();
        this.f409406c = r101;
        this.f409407d = r103;
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
        Log.i("ChatTabPushProxy", r102.toString());
        o r108 = this.f409407d.c();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.audio.voiceinput.service.SpeechRecognitionEventPush");
        w r109 = (w) r108;
        p r110 = r109.f409437c;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.audio.voiceinput.service.SpeechRecognitionEventPushRepoV2");
        if (Intrinsics.areEqual(((x) r110).f409438a, "absent_user") == false) goto L20;
        Log.w("ChatTabPushProxy", "from user is ABSENT_USER, call release manually");
        r109.f409437c.b();
    L20:
        com.ss.android.lark.passportc.internal.v r111 = this.f409406c;
        if (r101 == null) goto L24;
        UserSession r112 = r101.f475034b;
        if (r112 == null) goto L24;
    L25:
        o r113 = (o) e0c.k.b(r111.c(r112), o.class);
        this.f409407d.e(r113);
        return;
    L24:
        r112 = ContainerConstsKt.a();
    L8:
        r105 = "";
        goto L9
    }
}
