package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$showMoreOperationMenu$1;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$showMoreOperationMenu$2;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class u1 extends c0c.b implements com.ss.android.lark.biz.im.api.o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.biz.im.api.o0 f411662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f411663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.biz.im.api.o0> f411664d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void Dd(String r100, UIGetDataCallback r101) {
        this.f411662b.Dd(r100, r101);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void J7(String r100, boolean r101, ReplyInThreadTitleBarPlugin$showMoreOperationMenu$1.AnonymousClass2 r102) {
        this.f411662b.J7(r100, r101, r102);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void N6(String r100, SyncDataStrategy r101, IGetDataCallback r102) {
        this.f411662b.N6(r100, r101, r102);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final l5b.a Qb(String r110, MessageFetchScene r111, int r112, int r113, int r114, ChannelDataFetcherStrategy r115, int r116, boolean r117) {
        return this.f411662b.Qb(r110, r111, r112, r113, r114, r115, r116, true);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final ThreadTopic Vd(String r100) {
        return this.f411662b.Vd(r100);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void ja(String r100, boolean r101, ReplyInThreadTitleBarPlugin$showMoreOperationMenu$2.AnonymousClass1 r102) {
        this.f411662b.ja(r100, r101, r102);
    }

    @Override // com.ss.android.lark.biz.im.api.o0
    public final void q5(List r100, int r101, int r102) {
        this.f411662b.q5(r100, r101, r102);
    }

    public u1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.biz.im.api.o0> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), com.ss.android.lark.biz.im.api.o0.class), com.ss.android.lark.biz.im.api.o0.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411662b = r103.b();
        this.f411663c = r101;
        this.f411664d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("ThreadServiceProxy", "preparing IThreadService");
        com.ss.android.lark.passportc.internal.v r102 = this.f411663c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.ss.android.lark.biz.im.api.o0 r104 = (com.ss.android.lark.biz.im.api.o0) e0c.k.b(r102.c(r103), com.ss.android.lark.biz.im.api.o0.class);
        this.f411664d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
