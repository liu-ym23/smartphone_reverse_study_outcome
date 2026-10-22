package com.bytedance.live.livelink.kmp.impl.extend.chorus;

import com.bytedance.live.livelink.kmp.impl.extend.ExtendContext;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements com.bytedance.live.livelink.kmp.impl.extend.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f255575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f255576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExtendContext f255577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f255578d;

    @Override // com.bytedance.live.livelink.kmp.impl.extend.b
    public final ExtendContext c() {
        return this.f255577c;
    }

    public b(ExtendContext r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "extendContext");
        Intrinsics.checkNotNullParameter(r101, "chorusScope");
        this.f255577c = r100;
        this.f255578d = r101;
        this.f255575a = new CompositeDisposable();
        this.f255576b = "none";
    }
}
