package com.bytedance.lark.molten_livequery_wrapper.adapter;

import com.bytedance.lark.molten_livequery_wrapper.g;
import com.bytedance.lark.molten_livequery_wrapper.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements m<T>, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveQuerySubscriber<T> f253388a;

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void pause() {
        this.f253388a.pause();
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void release() {
        this.f253388a.release();
    }

    @Override // com.bytedance.lark.molten_livequery_wrapper.g
    public final void resume() {
        this.f253388a.resume();
    }

    public c(LiveQuerySubscriber<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataStore");
        this.f253388a = r100;
    }

    public final void a(Function2<? super com.bytedance.lark.molten_livequery_wrapper.a, Object, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        LiveQuerySubscriber<T> r101 = this.f253388a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        r101.f253367d = r100;
    }
}
