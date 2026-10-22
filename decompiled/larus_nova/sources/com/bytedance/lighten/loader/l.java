package com.bytedance.lighten.loader;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: classes20.dex */
public final class l extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ df6.v f254740a;

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestCancellation(String r100) {
        df6.v r101 = this.f254740a;
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    public l(df6.v r100, df6.t r101) {
        this.f254740a = r100;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        df6.v r103 = this.f254740a;
        if (r103 == null) goto L8;
        if (r100 == null) goto L6;
        r100.getSourceUri();
        r103.b();
        return;
    L6:
        r103.b();
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onUltimateProducerReached(String r100, String r101, boolean r102) {
        df6.v r103 = this.f254740a;
        if (r103 == null) goto L6;
        r103.c();
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
        df6.v r104 = this.f254740a;
        if (r104 == null) goto L8;
        if (r100 == null) goto L6;
        r100.getSourceUri();
        r104.d();
        return;
    L6:
        r104.d();
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        df6.v r104 = this.f254740a;
        if (r104 == null) goto L8;
        if (r100 == null) goto L6;
        r100.getSourceUri();
        r104.a();
        return;
    L6:
        r104.a();
        return;
    }
}
