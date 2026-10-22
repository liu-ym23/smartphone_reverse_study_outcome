package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher$closeChatMode$1$1;
import com.bytedance.ee.bear.list.homepage.ai.SpaceHomePageAiLauncher$getMyAIParam$1;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class h1 implements com.bytedance.ee.bear.lark.dependency.e0 {
    @Inject
    public h1() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void e(com.bytedance.ee.bear.lark.dependency.a r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "onLaunchRequested");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void h() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void i() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void j(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void k() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void l() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void c(osb.b r100, IGetDataCallback<osb.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.onError(new ErrorResult(-1, "Office not supported"));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void d(String r100, SpaceHomePageAiLauncher$getMyAIParam$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatModeId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.onError(new ErrorResult(-1, "Office not supported"));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.e0
    public final void f(String r100, SpaceHomePageAiLauncher$closeChatMode$1$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "chatModeId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.onError(new ErrorResult(-1, "Office not supported"));
    }
}
