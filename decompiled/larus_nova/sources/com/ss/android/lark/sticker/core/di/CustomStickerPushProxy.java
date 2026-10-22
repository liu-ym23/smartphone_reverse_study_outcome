package com.ss.android.lark.sticker.core.di;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CustomStickerPushProxy extends c0c.b implements e6c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e6c.b f440784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f440785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<e6c.b> f440786d;

    @Override // e6c.b
    public final void q7(final e6c.b.a r100) {
        if (r100 == null) goto L5;
        this.f440786d.a(new com.ss.android.lark.passportc.convention.b.C5239b(e6c.b.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new CustomStickerPushProxy$registerCustomStickerPushListener$1$1(r100), new CustomStickerPushProxy$registerCustomStickerPushListener$1$2(r100)));
        return;
    }

    @Override // e6c.b
    public final void y1(e6c.b.a r100) {
        if (r100 == null) goto L5;
        this.f440786d.d(new com.ss.android.lark.passportc.convention.b.C5239b(e6c.b.a.class, r100));
        return;
    }

    public CustomStickerPushProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<e6c.b> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), e6c.b.class), e6c.b.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f440784b = r103.b();
        this.f440785c = r101;
        this.f440786d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f440785c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        e6c.b r105 = (e6c.b) k.b(r102.c(r104), e6c.b.class);
        this.f440786d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
