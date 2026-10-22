package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.chat.video.InnerVideoPreviewFragment$playVideo$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class x1 extends c0c.b implements m6b.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.n f416593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.n> f416595d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.n
    public final void Z2(String r100, boolean r101, InnerVideoPreviewFragment$playVideo$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f416593b.Z2(r100, r101, r102);
    }

    public x1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.n> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.n.class), m6b.n.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416593b = r103.b();
        this.f416594c = r101;
        this.f416595d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("PreviewVideoServiceProxy", "preparing IPreviewVideoService");
        com.ss.android.lark.passportc.internal.v r102 = this.f416594c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        m6b.n r104 = (m6b.n) e0c.k.b(r102.c(r103), m6b.n.class);
        this.f416595d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
