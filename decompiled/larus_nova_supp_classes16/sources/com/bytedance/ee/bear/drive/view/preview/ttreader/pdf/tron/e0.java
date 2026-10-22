package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.view.MotionEvent;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 implements CommentRectLayout.c {
    public final /* synthetic */ PDFCtrlView a;
    public final /* synthetic */ CommentRectLayout b;

    public final /* synthetic */ void a() {
    }

    public final /* synthetic */ void onTouchEvent(MotionEvent r1) {
    }

    public final void b() {
        tt5.a.h("PDFCtrlView", "initCommentRectLayout - onReadyCreateViewVisibleChange, visible: false");
        CommentRectLayout r0 = this.b;
        r0.E.setBackground(null);
        SubsamplingScaleImageView r1 = r0.E;
        r1.G(true);
        r1.G1 = null;
        r1.H1 = null;
        r1.L1 = null;
        r1.M1 = null;
    }

    public final void c() {
        ViewOwner r0 = this.a.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L6:
        if (((PreviewViewModel) r0.viewModel(PreviewViewModel.class)) == null) goto L8;
        PDFCtrlView r1 = this.a;
        tt5.a.d("PDFCtrlView", "initCommentRectLayout - onCloseBtnClick, set forceFullscreen to: false");
        r1.j();
        return;
    L8:
        tt5.a.d("PDFCtrlView", "initCommentRectLayout - onCloseBtnClick, PreviewViewModel is null.");
    }

    public final void e() {
        ViewOwner r0 = this.a.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L5:
        PreviewViewModel r1 = (PreviewViewModel) r0.viewModel(PreviewViewModel.class);
        if (r1 == null) goto L8;
        tt5.a.d("PDFCtrlView", "initCommentRectLayout - onInputTextClick, create new comment for area mark.");
        r1.liveInnerCreateNewComment().postValue(Boolean.TRUE);
        return;
    L8:
        tt5.a.d("PDFCtrlView", "initCommentRectLayout - onInputTextClick, PreviewViewModel is null.");
    }

    public final void d(boolean r3) {
        tt5.a.h("PDFCtrlView", "initCommentRectLayout - onCreateViewVisibleChange, visible: " + r3);
        ViewOwner r0 = this.a.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r0 = null;
    L5:
        PreviewViewModel r1 = (PreviewViewModel) r0.viewModel(PreviewViewModel.class);
        if (r1 == null) goto L11;
        MutableLiveData<Boolean> r2 = r1.liveInnerAreaCommentActive();
        if (r2 == null) goto L12;
        r2.postValue(Boolean.valueOf(r3));
        return;
    L12:
        return;
    }

    public e0(PDFCtrlView r1, CommentRectLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
