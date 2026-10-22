package com.ss.android.ad.applinksdk.interceptor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ad.applinksdk.model.AppLinkResult;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f406369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterceptorModel f406370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f406371c;

    public final AppLinkResult a() {
        return ((a) ListProtector.get(this.f406369a, this.f406371c)).intercept(new b(this.f406369a, this.f406370b, this.f406371c + 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends a> r100, InterceptorModel r101, int r102) {
        this.f406369a = r100;
        this.f406370b = r101;
        this.f406371c = r102;
    }
}
