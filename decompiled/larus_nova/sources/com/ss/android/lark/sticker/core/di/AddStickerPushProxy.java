package com.ss.android.lark.sticker.core.di;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AddStickerPushProxy extends c0c.b implements e6c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e6c.a f440781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f440782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<e6c.a> f440783d;

    @Override // e6c.a
    public final void I4(e6c.a.InterfaceC5749a r100) {
        if (r100 == null) goto L5;
        this.f440783d.d(new com.ss.android.lark.passportc.convention.b.C5239b(e6c.a.InterfaceC5749a.class, r100));
        return;
    }

    @Override // e6c.a
    public final void X0(final e6c.a.InterfaceC5749a r100) {
        if (r100 == null) goto L5;
        this.f440783d.a(new com.ss.android.lark.passportc.convention.b.C5239b(e6c.a.InterfaceC5749a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new AddStickerPushProxy$registerAddStickerPushListener$1$1(r100), new AddStickerPushProxy$registerAddStickerPushListener$1$2(r100)));
        return;
    }

    public AddStickerPushProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<e6c.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), e6c.a.class), e6c.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f440781b = r103.b();
        this.f440782c = r101;
        this.f440783d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f440782c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        e6c.a r105 = (e6c.a) k.b(r102.c(r104), e6c.a.class);
        this.f440783d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
