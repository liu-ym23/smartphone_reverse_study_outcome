package com.bytedance.ee.bear.document.imageviewer.areacomment;

import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements SubsamplingScaleImageView.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubsamplingScaleImageView f220032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f220033b;

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.h
    public final void a() {
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.h
    public final void b() {
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.h
    public final void c() {
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.h
    public final void onPreviewReleased() {
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.h
    public final void onReady() {
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.h
    public final void onImageLoaded() {
        tt5.a.h("ImageCommentAreaView", "showReadyAddComment: scaleImageView imageLoaded");
        this.f220032a.setOnImageEventListener(null);
        this.f220033b.b(this.f220032a);
    }

    public b(SubsamplingScaleImageView r100, a r101) {
        this.f220032a = r100;
        this.f220033b = r101;
    }
}
