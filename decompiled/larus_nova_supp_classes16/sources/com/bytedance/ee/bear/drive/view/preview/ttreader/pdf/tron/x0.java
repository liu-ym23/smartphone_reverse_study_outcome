package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.plugin.common.ttpdfreader.IReaderMarkClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x0 implements IReaderMarkClient {
    public final /* synthetic */ v0 a;
    public final /* synthetic */ ViewOwner b;

    public final void onClickedCounter(int r11) {
        List<CommentRectF> r0 = this.a.e;
        Unit r1 = null;
        if (r0 != null) goto L5;
        CommentRectF r8 = null;
    L18:
        if (r8 == null) goto L25;
        ViewOwner r2 = this.b;
        tt5.a.h("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedCounter, pageIndex: " + r11 + ", select comment: " + r8.b);
        PreviewViewModel r3 = (PreviewViewModel) r2.viewModel(PreviewViewModel.class);
        if (r3 == null) goto L24;
        MutableLiveData<CommentRectF> r4 = r3.liveInnerCommentSelected();
        if (r4 == null) goto L24;
        r4.postValue(r8);
        r1 = Unit.INSTANCE;
    L24:
        if (r1 == null) goto L25;
        return;
    L25:
        tt5.a.d("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedCounter, comment not found, pageIndex: " + r11);
        return;
    L5:
        Iterator r5 = ((ArrayList) r0).iterator();
        r8 = null;
    L7:
        if (r5.hasNext() == false) goto L18;
        CommentRectF r9 = (CommentRectF) r5.next();
        if (r9 == null) goto L7;
        if (r9.e != r11) goto L7;
        if (r8 == null) goto L16;
        if (com.bytedance.ee.bear.drive.biz.comment.f.a(r9, r9.d, r8, r8.d) >= 0) goto L7;
    L16:
        r8 = r9;
        goto L7
    }

    public final void onClickedMark(String r7) {
        Intrinsics.checkNotNullParameter(r7, "markId");
        Iterator<T> r0 = this.a.e.iterator();
    L3:
        Unit r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((CommentRectF) r1).b, r7) == false) goto L3;
    L9:
        CommentRectF r3 = (CommentRectF) r1;
        if (r3 == null) goto L17;
        ViewOwner r4 = this.b;
        tt5.a.h("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedMark, select comment: " + r7);
        PreviewViewModel r5 = (PreviewViewModel) r4.viewModel(PreviewViewModel.class);
        if (r5 == null) goto L16;
        MutableLiveData<CommentRectF> r6 = r5.liveInnerCommentSelected();
        if (r6 == null) goto L16;
        r6.postValue(r3);
        r2 = Unit.INSTANCE;
    L16:
        if (r2 == null) goto L17;
        return;
    L17:
        tt5.a.d("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedMark, comment not found: : " + r7);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public x0(v0 r1, ViewOwner r2) {
        this.a = r1;
        this.b = r2;
    }
}
