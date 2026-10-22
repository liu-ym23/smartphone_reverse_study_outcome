package com.bytedance.lark.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class q extends WaitConditionInterceptor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.lark.sdk.refactor.e f254010d;

    public static final class a implements com.bytedance.lark.sdk.refactor.state.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f254011a;

        public a(q r100) {
            this.f254011a = r100;
        }

        @Override // com.bytedance.lark.sdk.refactor.state.b
        public final void a(boolean r100) {
            if (r100 == true) goto L5;
            this.f254011a.d();
            return;
        }
    }

    public q(com.bytedance.lark.sdk.refactor.e r100) {
        Intrinsics.checkNotNullParameter(r100, "rustBarrier");
        this.f254010d = r100;
        r100.s(new a(this));
    }

    @Override // com.bytedance.lark.rustclient.internal.WaitConditionInterceptor
    public final <T> boolean c(com.bytedance.lark.rustclient.api.b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return !this.f254010d.c();
    }
}
