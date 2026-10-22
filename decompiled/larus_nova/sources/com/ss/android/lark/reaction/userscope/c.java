package com.ss.android.lark.reaction.userscope;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.reaction.service.impl.ReactionOrderService2$fetchEmojiPanelData$2;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends c0c.b implements m2c.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m2c.b f439192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f439193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m2c.b> f439194d;

    @Override // m2c.b
    public final List<String> N(boolean r100) {
        return this.f439192b.N(r100);
    }

    @Override // m2c.b
    public final void Ya(String r100, String r101, boolean r102, IGetDataCallback<Integer> r103) {
        this.f439192b.Ya(r100, r101, r102, r103);
    }

    @Override // m2c.b
    public final void o7(boolean r100, ReactionOrderService2$fetchEmojiPanelData$2 r101) {
        this.f439192b.o7(r100, r101);
    }

    @Override // m2c.b
    public final void q(String r100, IGetDataCallback<Integer> r101) {
        this.f439192b.q(r100, r101);
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m2c.b> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), m2c.b.class), m2c.b.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f439192b = r103.b();
        this.f439193c = r101;
        this.f439194d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f439193c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        m2c.b r105 = (m2c.b) k.b(r102.c(r104), m2c.b.class);
        this.f439194d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
