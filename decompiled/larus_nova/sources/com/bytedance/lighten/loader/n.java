package com.bytedance.lighten.loader;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes20.dex */
public final class n extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f254774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakReference f254775b;

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestCancellation(String r100) {
        df6.v r101 = (df6.v) this.f254774a.get();
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    public n(WeakReference r100, WeakReference r101) {
        this.f254774a = r100;
        this.f254775b = r101;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        df6.t r103 = (df6.t) this.f254775b.get();
        df6.v r104 = (df6.v) this.f254774a.get();
        if (r104 == null) goto L9;
        if (r103 == null) goto L10;
        if (r100 == null) goto L7;
        r100.getSourceUri();
        r104.b();
        return;
    L7:
        r104.b();
        return;
    L10:
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public final void onUltimateProducerReached(String r100, String r101, boolean r102) {
        df6.v r103 = (df6.v) this.f254774a.get();
        if (r103 == null) goto L6;
        r103.c();
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
        df6.t r104 = (df6.t) this.f254775b.get();
        df6.v r105 = (df6.v) this.f254774a.get();
        if (r105 == null) goto L9;
        if (r104 == null) goto L10;
        if (r100 == null) goto L7;
        r100.getSourceUri();
        r105.d();
        return;
    L7:
        r105.d();
        return;
    L10:
        return;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
        df6.t r104 = (df6.t) this.f254775b.get();
        df6.v r105 = (df6.v) this.f254774a.get();
        if (r105 == null) goto L9;
        if (r104 == null) goto L10;
        if (r100 == null) goto L7;
        r100.getSourceUri();
        r105.a();
        return;
    L7:
        r105.a();
        return;
    L10:
        return;
    }
}
