package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j extends c0c.b implements m6b.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.d f416518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.d> f416520d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.d
    public final void K6(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        this.f416518b.K6(r100, r101);
    }

    @Override // m6b.d
    public final void V(Object r100, String r101) {
        this.f416518b.V(r100, r101);
    }

    @Override // m6b.d
    public final void W1(Object r100, String r101, aqb.a r102) {
        this.f416518b.W1(r100, r101, r102);
    }

    @Override // m6b.d
    public final void registerPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102, m6b.o r103) {
        this.f416518b.registerPushChatRelation(r100, r101, r102, r103);
    }

    @Override // m6b.d
    public final void unregisterPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102) {
        this.f416518b.unregisterPushChatRelation(r100, r101, r102);
    }

    @Override // m6b.d
    public final void z9(String r100, SubscribeChatEventRequest.SubscriptionKey r101) {
        this.f416518b.z9(r100, r101);
    }

    public j(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.d> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.d.class), m6b.d.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416518b = r103.b();
        this.f416519c = r101;
        this.f416520d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("ChatSubscribeServiceProxy", "preparing IChatSubscribeService");
        com.ss.android.lark.passportc.internal.v r102 = this.f416519c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        m6b.d r104 = (m6b.d) e0c.k.b(r102.c(r103), m6b.d.class);
        this.f416520d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
