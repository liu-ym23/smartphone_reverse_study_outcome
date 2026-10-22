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

/* JADX INFO: loaded from: classes16.dex */
public final class x0 implements IReaderMarkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v0 f225446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewOwner f225447b;

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IReaderMarkClient
    public final void onClickedCounter(int r110) {
        List<CommentRectF> r100 = this.f225446a.f225422e;
        Unit r101 = null;
        if (r100 != null) goto L5;
        CommentRectF r102 = null;
    L18:
        if (r102 == null) goto L25;
        ViewOwner r103 = this.f225447b;
        tt5.a.h("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedCounter, pageIndex: " + r110 + ", select comment: " + r102.f236775b);
        PreviewViewModel r104 = (PreviewViewModel) r103.viewModel(PreviewViewModel.class);
        if (r104 == null) goto L24;
        MutableLiveData<CommentRectF> r105 = r104.liveInnerCommentSelected();
        if (r105 == null) goto L24;
        r105.postValue(r102);
        r101 = Unit.INSTANCE;
    L24:
        if (r101 == null) goto L25;
        return;
    L25:
        tt5.a.d("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedCounter, comment not found, pageIndex: " + r110);
        return;
    L5:
        Iterator r106 = ((ArrayList) r100).iterator();
        r102 = null;
    L7:
        if (r106.hasNext() == false) goto L18;
        CommentRectF r107 = (CommentRectF) r106.next();
        if (r107 == null) goto L7;
        if (r107.f236778e != r110) goto L7;
        if (r102 == null) goto L16;
        if (com.bytedance.ee.bear.drive.biz.comment.f.a(r107, r107.f236777d, r102, r102.f236777d) >= 0) goto L7;
    L16:
        r102 = r107;
        goto L7
    }

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IReaderMarkClient
    public final void onClickedMark(String r100) {
        Intrinsics.checkNotNullParameter(r100, "markId");
        Iterator<T> r101 = this.f225446a.f225422e.iterator();
    L3:
        Unit r102 = null;
        if (r101.hasNext() == false) goto L8;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((CommentRectF) r103).f236775b, r100) == false) goto L3;
    L9:
        CommentRectF r104 = (CommentRectF) r103;
        if (r104 == null) goto L17;
        ViewOwner r105 = this.f225447b;
        tt5.a.h("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedMark, select comment: " + r100);
        PreviewViewModel r106 = (PreviewViewModel) r105.viewModel(PreviewViewModel.class);
        if (r106 == null) goto L16;
        MutableLiveData<CommentRectF> r107 = r106.liveInnerCommentSelected();
        if (r107 == null) goto L16;
        r107.postValue(r104);
        r102 = Unit.INSTANCE;
    L16:
        if (r102 == null) goto L17;
        return;
    L17:
        tt5.a.d("TTStreamingPdfView", "initMarkClient, setMarkClient - onClickedMark, comment not found: : " + r100);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public x0(v0 r100, ViewOwner r101) {
        this.f225446a = r100;
        this.f225447b = r101;
    }
}
