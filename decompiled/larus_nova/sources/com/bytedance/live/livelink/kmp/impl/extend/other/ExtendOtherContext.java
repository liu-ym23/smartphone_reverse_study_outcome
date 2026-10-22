package com.bytedance.live.livelink.kmp.impl.extend.other;

import com.bytedance.live.livelink.kmp.api.base.interceptor.InterceptModule;
import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import com.bytedance.live.livelink.kmp.impl.extend.InterceptorCallExtendKt;
import com.bytedance.live.livelink.kmp.impl.extend.b;
import com.bytedance.revenue.platform.api.core.rx.f;
import hi6.h;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ExtendOtherContext implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f255597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExtendContext f255598b;

    public final void a() {
        f.a(InterceptorCallExtendKt.a(this, InterceptModule.SEI_MANAGER, new h("process_sei_to_biz"), new ExtendOtherContext$init$1(this)), this.f255597a);
    }

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255598b;
    }

    public ExtendOtherContext(ExtendContext r100) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        this.f255598b = r100;
        this.f255597a = new CompositeDisposable();
    }
}
