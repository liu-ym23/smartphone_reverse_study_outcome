package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.entity.message.AIRecommendQuestions;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class p0 extends c0c.b implements z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f414652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f414653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<z> f414654d;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public final AIRecommendQuestions kf(long r100) {
        return this.f414652b.kf(r100);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.z
    public void update(long r100, AIRecommendQuestions r101) {
        Intrinsics.checkNotNullParameter(r101, "aIRecommendQuestions");
        this.f414652b.update(r100, r101);
    }

    public p0(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<z> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), z.class), z.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "holder");
        super(r100);
        this.f414652b = r103.b();
        this.f414653c = r101;
        this.f414654d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        com.ss.android.lark.passportc.internal.v r102 = this.f414653c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        z r104 = (z) e0c.k.b(r102.c(r103), z.class);
        this.f414654d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
