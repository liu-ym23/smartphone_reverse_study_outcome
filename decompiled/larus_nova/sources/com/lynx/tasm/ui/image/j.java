package com.lynx.tasm.ui.image;

import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import java.io.Closeable;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements e8a.a<Closeable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f384012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f384013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f384014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f384015d;

    @Override // e8a.a
    public final void onResponse(LynxResourceResponse<Closeable> r110) {
        if (r110.f383708a != LynxResourceResponse.ResponseState.SUCCESS) goto L7;
        Closeable r111 = r110.f383709b;
        if ((r111 instanceof CloseableReference) == false) goto L7;
        this.f384015d.A.f((CloseableReference) r111);
        long r100 = System.currentTimeMillis();
        int r112 = this.f384015d.c(this.f384012a, this.f384013b);
        h r101 = this.f384015d;
        r101.l(r101.f383984v, true, true, this.f384014c, r100, 0, r112);
        return;
    L7:
        this.f384015d.A.d();
    }

    public j(h r100, int r101, int r102, long r103) {
        this.f384015d = r100;
        this.f384012a = r101;
        this.f384013b = r102;
        this.f384014c = r103;
    }
}
