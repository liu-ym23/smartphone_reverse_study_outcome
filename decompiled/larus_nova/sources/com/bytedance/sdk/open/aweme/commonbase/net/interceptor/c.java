package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class c implements OpenInterceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<OpenInterceptor> f269618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f269619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final OpenHostRequest f269620c;

    public c(List<OpenInterceptor> r100, int r101, OpenHostRequest r102) {
        this.f269618a = r100;
        this.f269619b = r101;
        this.f269620c = r102;
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor.Chain
    public OpenHostResponse proceed(OpenHostRequest r100) throws Exception {
        if (this.f269619b >= this.f269618a.size()) goto L18;
        c r101 = new c(this.f269618a, this.f269619b + 1, r100);
        OpenInterceptor r102 = (OpenInterceptor) ListProtector.get(this.f269618a, this.f269619b);
        if (r102 == null) goto L16;
        OpenHostResponse r103 = r102.intercept(r101);
        if (r103 == null) goto L14;
        if (r103.body == null) goto L12;
        return r103;
    L12:
        throw new IllegalStateException("interceptor " + r102 + " returned a ssResponse with no body");
    L14:
        throw new NullPointerException("interceptor " + r102 + " returned null");
    L16:
        throw new NullPointerException("interceptor " + this.f269619b + " is null");
    L18:
        throw new AssertionError();
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor.Chain
    public OpenHostRequest request() {
        return this.f269620c;
    }
}
