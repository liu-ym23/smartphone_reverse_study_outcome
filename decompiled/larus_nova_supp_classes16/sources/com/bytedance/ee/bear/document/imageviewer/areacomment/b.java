package com.bytedance.ee.bear.document.imageviewer.areacomment;

import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements SubsamplingScaleImageView.h {
    public final /* synthetic */ SubsamplingScaleImageView a;
    public final /* synthetic */ a b;

    public final void a() {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void onPreviewReleased() {
    }

    public final void onReady() {
    }

    public final void onImageLoaded() {
        tt5.a.h("ImageCommentAreaView", "showReadyAddComment: scaleImageView imageLoaded");
        this.a.setOnImageEventListener(null);
        this.b.b(this.a);
    }

    public b(SubsamplingScaleImageView r1, a r2) {
        this.a = r1;
        this.b = r2;
    }
}
