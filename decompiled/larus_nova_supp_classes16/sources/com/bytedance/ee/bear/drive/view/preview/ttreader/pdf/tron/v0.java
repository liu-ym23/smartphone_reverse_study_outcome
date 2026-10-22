package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.biz.preview.viewfinder.DriveViewFinderVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentArea;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.bear.scaleimageview.areacomment.Quad;
import com.bytedance.ee.plugin.common.ttpdfreader.PagePart;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v0 implements com.bytedance.ee.bear.drive.view.preview.wrapper.m {
    public PDFCtrlView a;
    public ViewOwner b;
    public com.bytedance.ee.bear.drive.biz.preview.vc.connector.g c;
    public a95.a d;
    public final List<CommentRectF> e;
    public final List<c> f;
    public final List<a> g;
    public final List<d> h;
    public String i;
    public com.bytedance.ee.bear.drive.biz.bubblemenu.c j;

    public static final class a {
        public static final /* synthetic */ int e = 0;
        public final String a;
        public final int b;
        public final List<RectF> c;
        public final float d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.v0$a$a, reason: collision with other inner class name */
        public static final class C0185a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "AreaMark(markId=" + this.a + ", pageIndex=" + this.b + ", areaRates=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r2, int r3, List<? extends RectF> r4) {
            Intrinsics.checkNotNullParameter(r2, "markId");
            Intrinsics.checkNotNullParameter(r4, "areaRates");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            boolean r5 = !r4.isEmpty();
            Object r6 = r4;
            if (r5 == true) goto L6;
            r6 = null;
        L6:
            if (r6 == null) goto L15;
            Iterator r7 = ((Iterable) r6).iterator();
            if (r7.hasNext() == false) goto L14;
            float r8 = ((RectF) r7.next()).top;
        L11:
            if (r7.hasNext() == false) goto L16;
            r8 = Math.min(r8, ((RectF) r7.next()).top);
        L16:
            this.d = r8;
            return;
        L14:
            throw new NoSuchElementException();
        L15:
            r8 = 0.0f;
            goto L16
        }
    }

    public static final class b {
    }

    public static final class c {
        public static final /* synthetic */ int e = 0;
        public final String a;
        public final int b;
        public final List<RectF> c;
        public final float d;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "ContentMark(markId=" + this.a + ", pageIndex=" + this.b + ", areaRates=" + this.c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(String r2, int r3, List<? extends RectF> r4) {
            Intrinsics.checkNotNullParameter(r2, "markId");
            Intrinsics.checkNotNullParameter(r4, "areaRates");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            boolean r5 = !r4.isEmpty();
            Iterable r6 = r4;
            if (r5 == true) goto L6;
            r6 = null;
        L6:
            if (r6 == null) goto L15;
            Iterator r7 = r6.iterator();
            if (r7.hasNext() == false) goto L14;
            float r8 = ((RectF) r7.next()).top;
        L11:
            if (r7.hasNext() == false) goto L16;
            r8 = Math.min(r8, ((RectF) r7.next()).top);
        L16:
            this.d = r8;
            return;
        L14:
            throw new NoSuchElementException();
        L15:
            r8 = 0.0f;
            goto L16
        }
    }

    public static final class d {
        public static final /* synthetic */ int c = 0;
        public final String a;
        public final int b;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "DefaultMark(markId=" + this.a + ", pageIndex=" + this.b + ')';
        }

        public d(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "markId");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // c95.d
    public final void setOnShowViewTrackEventCallback(c95.c r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final String getCommentQuote() {
        tt5.a.h("TTStreamingPdfView", "getCommentQuote");
        PDFCtrlView r1 = null;
        if (w55.n.d == true) goto L5;
        return null;
    L5:
        PDFCtrlView r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
    L10:
        return r1.getCommentQuote();
    L8:
        r1 = r0;
        goto L10
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final View getView() {
        PDFCtrlView r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        return null;
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        tt5.a.h("TTStreamingPdfView", "hideCreateComment");
        PDFCtrlViewModel r1 = null;
        PDFCtrlViewModel r2 = null;
        CommentRectF r3 = null;
        Quad[] r4 = null;
        r4 = null;
        r4 = null;
        CommentRectF r5 = null;
        r5 = null;
        r5 = null;
        if (w55.n.d == true) goto L5;
        return null;
    L5:
        PDFCtrlView r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L8:
        CommentRectLayout r6 = r0.C;
        int r7 = 0;
        if (r6 == null) goto L13;
        boolean r8 = true;
        if (r6.q() != true) goto L13;
    L15:
        if (r8 == false) goto L33;
        CommentRectLayout r9 = r0.C;
        if (r9 != null) goto L19;
    L24:
        CommentRectF r10 = null;
    L25:
        if (r10 == null) goto L31;
        PDFCtrlViewModel r11 = r0.k;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        r10.e = r2.getCurrentPageIndex();
        r3 = r10;
        goto L31
    L29:
        r2 = r11;
    L31:
        r0.j();
        return r3;
    L19:
        if (r9.q() == true) goto L22;
        r9 = null;
    L22:
        if (r9 == null) goto L24;
        r10 = r9.j();
        goto L25
    L33:
        if (r0.D == null) goto L54;
        r0.u("ContentMarkId.PendingCreate", PDFCtrlView.G);
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r12 = r0.D;
        if (r12 == null) goto L53;
        List<TTReaderSelectionInfo> r13 = r12.a;
        if (r13 == null) goto L53;
        TTReaderSelectionInfo r14 = (TTReaderSelectionInfo) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L53;
        CommentRectF r16 = new CommentRectF();
        r16.a = 4;
        r16.e = r14.pageIndex;
        r16.j = r14.selectedText;
        RectF[] r17 = r14.selectedRects;
        SizeF r18 = r14.pageResolution;
        ArrayMap<String, Integer> r19 = com.bytedance.ee.bear.drive.biz.comment.data.c.a;
        if (r17 == null) goto L52;
        float r20 = r18.getWidth();
        float r21 = r18.getHeight();
        if (r20 <= 0.0f) goto L52;
        if (r21 <= 0.0f) goto L52;
        r4 = new Quad[r17.length];
    L50:
        if (r7 >= r17.length) goto L52;
        Quad r22 = new Quad();
        r4[r7] = r22;
        RectF r23 = r17[r7];
        float r24 = r23.left / r20;
        r22.x1 = r24;
        float r110 = r23.top / r21;
        r22.y1 = r110;
        float r111 = r23.right / r20;
        r22.x2 = r111;
        r22.y2 = r110;
        r22.x3 = r111;
        float r26 = r23.bottom / r21;
        r22.y3 = r26;
        r22.x4 = r24;
        r22.y4 = r26;
        r7 = r7 + 1;
    L52:
        r16.i = r4;
        r5 = r16;
    L53:
        r0.k();
        return r5;
    L54:
        CommentRectF r27 = new CommentRectF();
        r27.a = 3;
        PDFCtrlViewModel r28 = r0.k;
        if (r28 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        r27.e = r1.getCurrentPageIndex();
        return r27;
    L57:
        r1 = r28;
    L13:
        r8 = false;
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        tt5.a.h("TTStreamingPdfView", "onAreaClick");
        PDFCtrlView r0 = this.a;
        ViewOwner r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L5:
        CommentRectLayout r2 = r0.C;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L22;
        r0.j();
        ViewOwner r4 = r0.j;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L17:
        PreviewViewModel r5 = (PreviewViewModel) r1.viewModel(PreviewViewModel.class);
        if (r5 == null) goto L108;
        MutableLiveData<Boolean> r6 = r5.liveInnerCreateNewComment();
        if (r6 == null) goto L109;
        r6.postValue(Boolean.FALSE);
        return false;
    L109:
        return false;
    L108:
        return false;
    L16:
        r1 = r4;
        goto L17
    L22:
        CommentRectLayout r7 = r0.C;
        if (r7 != null) goto L26;
        tt5.a.k("PDFCtrlView", "enterAreaMarker, commentRectLayout is null.");
    L106:
        return true;
    L26:
        if (r7.q() == false) goto L28;
        tt5.a.k("PDFCtrlView", "enterAreaMarker, already entered.");
        goto L106
    L28:
        tt5.a.h("PDFCtrlView", "enterAreaMarker.");
        View r8 = r0.C;
        if (r8 != null) goto L31;
        tt5.a.d("PDFCtrlView", "addCommentRectLayout, commentRectLayout is null.");
    L71:
        ViewOwner r9 = r0.j;
        if (r9 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r9 = null;
    L74:
        PreviewViewModel r10 = (PreviewViewModel) r9.viewModel(PreviewViewModel.class);
        if (r10 == null) goto L77;
        r10.liveInnerForcePortrait.postValue(Boolean.TRUE);
        r10.liveInnerCommentSelected().postValue(null);
    L77:
        r0.k();
        PDFCtrlViewModel r11 = r0.k;
        if (r11 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r11 = null;
    L80:
        int r12 = r11.getCurrentPageIndex();
        PDFCtrlViewModel r13 = r0.k;
        if (r13 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L83:
        SizeF r14 = r13.getPageSizeF(r12);
        float r16 = r14.getWidth() / r14.getHeight();
        int r17 = r0.getWidth();
        int r18 = r0.getHeight();
        if (r17 <= r18) goto L86;
        r17 = (int) (r18 * r16);
    L87:
        PDFCtrlViewModel r19 = r0.k;
        if (r19 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r19 = null;
    L90:
        PagePart r20 = r19.getPageForPresentation(r12, r17, r18);
        if (r20 == null) goto L97;
        Bitmap r21 = r20.getRenderedBitmap();
        if (r21 == null) goto L97;
        CommentRectLayout r22 = r0.C;
        if (r22 == null) goto L97;
        r22.t(r0.getContext().getResources().getColor(2131106500), r21);
    L97:
        r7.v(RangesKt.coerceAtLeast(r0.getWidth(), 0) / 2.0f, RangesKt.coerceAtLeast(r0.getHeight(), 0) / 2.0f);
        ViewOwner r23 = r0.j;
        if (r23 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L101:
        DriveCommentVM r24 = (DriveCommentVM) r1.viewModel(DriveCommentVM.class);
        if (r24 == null) goto L106;
        MutableLiveData<CommentArea.Type> r26 = r24.getLiveInnerCommentMarkType();
        if (r26 == null) goto L106;
        r26.postValue(CommentArea.Type.AREA);
        goto L106
    L100:
        r1 = r23;
        goto L101
    L86:
        r18 = (int) (r17 / r16);
        goto L87
    L31:
        ViewOwner r27 = r0.j;
        if (r27 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r27 = null;
    L34:
        DriveViewFinderVM r28 = (DriveViewFinderVM) r27.viewModel(DriveViewFinderVM.class);
        if (r28 == null) goto L70;
        View r29 = r28.findViewById(2131379451);
        if (r29 == null) goto L70;
        if ((r29 instanceof ViewGroup) == true) goto L42;
        r29 = null;
    L42:
        if (r29 == null) goto L70;
        if ((r29 instanceof ViewGroup) == false) goto L46;
        ViewGroup r30 = (ViewGroup) r29;
    L47:
        if (r30 == null) goto L70;
        r0.r();
        tt5.a.h("PDFCtrlView", "addCommentRectLayout");
        r30.addView(r8, -1, new ViewGroup.LayoutParams(-1, -1));
        xu5.b.a r31 = r0.E;
        if (r31 == null) goto L51;
        r31.saveState();
    L51:
        xu5.b.a r32 = r0.E;
        if (r32 == null) goto L54;
        r32.d(2131106500, false);
    L54:
        ca5.a r33 = r0.F;
        FragmentActivity r34 = r0.getContext();
        if ((r34 instanceof FragmentActivity) == false) goto L57;
        FragmentActivity r36 = r34;
    L58:
        r33.getClass();
        if (com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.drive.pdf_comment_onboard_enable") == true) goto L62;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "fg disabled, skip");
        goto L71
    L62:
        if (r33.a == false) goto L64;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "already shown in this page, skip");
        goto L71
    L64:
        sk5.c r110 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        tt5.a.h("DrivePdfCommentOnboardCtrl", "tryShow, try show, isDebugMode: " + r110.isDebugMode());
        if (r110.isDebugMode() == true) goto L69;
        int r111 = ca5.c.b;
        if (((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().f("ccm_mobile_drive_pdf_area_box_comment_intro") == false) goto L69;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "mission finished, skip");
    L69:
        com.bytedance.ee.util.ui.j.d(new ca5.b(r36, r8, r33, r110), 500);
        goto L71
    L57:
        r36 = null;
        goto L58
    L46:
        r30 = null;
    L70:
        tt5.a.d("PDFCtrlView", "addCommentRectLayout, driveMainPageView not found.");
        goto L71
    L8:
        if (r2.q() != true) goto L10;
        r3 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        tt5.a.h("TTStreamingPdfView", "onBackPressed");
        PDFCtrlView r0 = this.a;
        CommentRectLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L5:
        CommentRectLayout r2 = r0.C;
        if (r2 != null) goto L8;
    L12:
        return false;
    L8:
        if (r2.q() == false) goto L10;
        r1 = r2;
    L10:
        if (r1 == null) goto L12;
        r0.j();
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
        tt5.a.h("TTStreamingPdfView", "onCommentInputPanelOpen");
        if (w55.n.d == true) goto L5;
        return;
    L5:
        PDFCtrlView r0 = this.a;
        ViewOwner r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L8:
        CommentRectLayout r2 = r0.C;
        int r3 = 0;
        if (r2 == null) goto L13;
        boolean r4 = true;
        if (r2.q() != true) goto L13;
    L14:
        if (r4 == true) goto L72;
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r5 = r0.D;
        if (r5 == null) goto L53;
        Intrinsics.checkNotNullParameter(r5, "selectionData");
        List<TTReaderSelectionInfo> r6 = r5.a;
        if (r6 == null) goto L65;
        TTReaderSelectionInfo r7 = (TTReaderSelectionInfo) CollectionsKt.firstOrNull(r6);
        if (r7 == null) goto L66;
        SizeF r8 = r7.pageResolution;
        if (r8 == null) goto L25;
        float r9 = r8.getWidth();
    L26:
        SizeF r10 = r7.pageResolution;
        if (r10 == null) goto L29;
        float r11 = r10.getHeight();
    L31:
        if (r9 > 0.0f) goto L33;
        return;
    L33:
        if (r11 <= 0.0f) goto L73;
        RectF[] r12 = r7.selectedRects;
        if (r12 == null) goto L68;
        ArrayList r13 = new ArrayList(r12.length);
        int r14 = r12.length;
    L38:
        if (r3 >= r14) goto L40;
        RectF r16 = r12[r3];
        r13.add(new RectF(r16.left / r9, r16.top / r11, r16.right / r9, r16.bottom / r11));
        r3 = r3 + 1;
        goto L38
    L40:
        Iterator r17 = r13.iterator();
        if (r17.hasNext() == false) goto L52;
        float r18 = ((RectF) r17.next()).top;
    L44:
        if (r17.hasNext() == false) goto L46;
        r18 = Math.min(r18, ((RectF) r17.next()).top);
        goto L44
    L46:
        float r19 = RangesKt.coerceAtLeast(r18, 0.0f);
        SizeF r20 = r7.pageSize;
        if (r20 == null) goto L49;
        float r21 = RangesKt.coerceAtLeast(r20.getHeight(), 0.0f);
    L50:
        float r22 = (0.0f - (r19 * r21)) + 100.0f;
        r0.q("ContentMarkId.PendingCreate", r7.pageIndex, r13, PDFCtrlView.H, false, false);
        r0.e(r7.pageIndex, (int) r22);
        return;
    L49:
        r21 = 0.0f;
        goto L50
    L52:
        throw new NoSuchElementException();
    L68:
        return;
    L73:
        return;
    L29:
        r11 = 0.0f;
        goto L31
    L25:
        r9 = 0.0f;
        goto L26
    L66:
        return;
    L65:
        return;
    L53:
        ViewOwner r23 = r0.j;
        if (r23 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L57:
        DriveCommentVM r24 = (DriveCommentVM) r1.viewModel(DriveCommentVM.class);
        if (r24 == null) goto L70;
        MutableLiveData<CommentArea.Type> r26 = r24.getLiveInnerCommentMarkType();
        if (r26 == null) goto L71;
        r26.postValue(CommentArea.Type.WHOLE_PAGE);
        return;
    L71:
        return;
    L70:
        return;
    L56:
        r1 = r23;
        goto L57
    L72:
        return;
    L13:
        r4 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
        tt5.a.h("TTStreamingPdfView", "onCommentListPanelClose");
        if (w55.n.d == true) goto L5;
        return;
    L5:
        this.i = null;
        Iterator<T> r1 = this.f.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        c r2 = (c) r1.next();
        PDFCtrlView r4 = this.a;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r4 = null;
    L11:
        String r3 = r2.a;
        int r5 = PDFCtrlView.G;
        r4.u(r3, PDFCtrlView.G);
        goto L7
    L12:
        Iterator<T> r6 = this.g.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        a r7 = (a) r6.next();
        PDFCtrlView r8 = this.a;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r8 = null;
    L18:
        String r9 = r7.a;
        int r10 = PDFCtrlView.G;
        r8.t(r9, PDFCtrlView.G);
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        PDFCtrlView r0 = this.a;
        ViewOwner r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L5:
        PDFCtrlViewModel r2 = r0.k;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r2 = null;
    L8:
        a95.a r3 = r0.B;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r3 = null;
    L11:
        r2.openPdf(null, r3);
        if (w55.n.d == false) goto L24;
        ViewOwner r4 = this.b;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L17:
        PreviewViewModel r5 = (PreviewViewModel) r1.viewModel(PreviewViewModel.class);
        if (r5 == null) goto L22;
        MutableLiveData<Boolean> r6 = r5.liveInnerAreaCommentEnableState();
        if (r6 == null) goto L22;
        r6.postValue(Boolean.TRUE);
        Unit r7 = Unit.INSTANCE;
        tt5.a.h("TTStreamingPdfView", "show, comment enabled, enable area comment.");
        return;
    L22:
        tt5.a.d("TTStreamingPdfView", "show, comment enabled, but PreviewViewModel is null.");
        return;
    L16:
        r1 = r4;
        goto L17
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
        tt5.a.h("TTStreamingPdfView", "showThumbnailPreview");
    }

    public v0() {
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    public final void b(List<? extends CommentRectF> r18) {
        if (r18 != null) goto L6;
        tt5.a.k("TTStreamingPdfView", "showMarks, rect is null.");
        return;
    L6:
        tt5.a.h("TTStreamingPdfView", "showMarks, rect size: " + r18.size());
        Iterator<T> r1 = r18.iterator();
    L8:
        if (r1.hasNext() == false) goto L35;
        CommentRectF r2 = (CommentRectF) r1.next();
        if (Intrinsics.areEqual(this.i, r2.b) == false) goto L12;
        int r3 = PDFCtrlView.G;
        int r4 = PDFCtrlView.H;
    L13:
        int r8 = r4;
        int r5 = r2.getType();
        if (r5 != 1) goto L16;
        int r6 = a.e;
        Intrinsics.checkNotNullParameter(r2, "commentRectF");
        a r7 = new a(r2.b, r2.e, CollectionsKt.listOf(new RectF(r2)));
        ((ArrayList) this.g).add(r7);
        PDFCtrlView r9 = this.a;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r9 = null;
    L34:
        r9.p(r7.a, r7.b, r7.c, r8, true, true);
        goto L8
    L16:
        if (r5 != 4) goto L17;
        int r10 = c.e;
        Intrinsics.checkNotNullParameter(r2, "commentRectF");
        ArrayList r11 = new ArrayList();
        Quad[] r12 = r2.i;
        if (r12 == null) goto L27;
        int r13 = r12.length;
        int r14 = 0;
    L25:
        if (r14 >= r13) goto L27;
        Quad r16 = r12[r14];
        RectF r17 = new RectF();
        r17.left = ComparisonsKt.minOf(r16.x1, new float[]{r16.x2, r16.x3, r16.x4});
        r17.top = ComparisonsKt.minOf(r16.y1, new float[]{r16.y2, r16.y3, r16.y4});
        r17.right = ComparisonsKt.maxOf(r16.x1, new float[]{r16.x2, r16.x3, r16.x4});
        r17.bottom = ComparisonsKt.maxOf(r16.y1, new float[]{r16.y2, r16.y3, r16.y4});
        r11.add(r17);
        r14 = r14 + 1;
    L27:
        c r19 = new c(r2.b, r2.e, r11);
        ((ArrayList) this.f).add(r19);
        PDFCtrlView r20 = this.a;
        if (r20 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r20 = null;
    L30:
        r20.q(r19.a, r19.b, r19.c, r8, true, true);
        goto L8
    L17:
        int r21 = d.c;
        Intrinsics.checkNotNullParameter(r2, "commentRectF");
        d r22 = new d(r2.b, r2.e);
        ((ArrayList) this.h).add(r22);
        List<? extends RectF> r23 = CollectionsKt.listOf(new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        PDFCtrlView r24 = this.a;
        if (r24 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        PDFCtrlView r26 = null;
    L21:
        r26.p(r22.a, r22.b, r23, r8, false, true);
        goto L8
    L20:
        r26 = r24;
        goto L21
    L12:
        int r27 = PDFCtrlView.G;
        r4 = PDFCtrlView.G;
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r4) {
        tt5.a.h("TTStreamingPdfView", "onCommentInputPanelClose, isBySend: " + r4);
        if (w55.n.d == true) goto L5;
        return;
    L5:
        PDFCtrlView r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L8:
        CommentRectLayout r1 = r0.C;
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.q() != true) goto L13;
    L14:
        if (r2 == false) goto L17;
        return;
    L17:
        if (r0.D == null) goto L22;
        if (r4 == false) goto L20;
        r0.u("ContentMarkId.PendingCreate", PDFCtrlView.G);
        return;
    L20:
        r0.k();
        return;
    L22:
        return;
    L13:
        r2 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void setUserAbility(a95.a r1) {
        if (r1 == null) goto L5;
        this.d = r1;
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r13) {
        tt5.a.h("TTStreamingPdfView", "showSelectedComment, commentId: " + r13);
        if (w55.n.d == true) goto L5;
        return;
    L5:
        this.i = r13;
        Iterator<T> r0 = this.f.iterator();
        int r5 = 0;
        float r6 = 0.0f;
    L6:
        PDFCtrlView r9 = null;
        if (r0.hasNext() == false) goto L16;
        c r7 = (c) r0.next();
        int r10 = PDFCtrlView.G;
        int r11 = PDFCtrlView.G;
        if (Intrinsics.areEqual(r7.a, r13) == false) goto L11;
        r11 = PDFCtrlView.H;
        r5 = r7.b;
        r6 = r7.d;
    L11:
        PDFCtrlView r12 = this.a;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
    L15:
        r9.u(r7.a, r11);
        goto L6
    L14:
        r9 = r12;
        goto L15
    L16:
        Iterator<T> r1 = this.g.iterator();
    L18:
        if (r1.hasNext() == false) goto L26;
        a r8 = (a) r1.next();
        int r14 = PDFCtrlView.G;
        int r16 = PDFCtrlView.G;
        if (Intrinsics.areEqual(r8.a, r13) == false) goto L22;
        r16 = PDFCtrlView.H;
        r5 = r8.b;
        r6 = r8.d;
    L22:
        PDFCtrlView r17 = this.a;
        if (r17 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r17 = null;
    L25:
        r17.t(r8.a, r16);
        goto L18
    L26:
        Iterator<T> r2 = this.h.iterator();
    L28:
        if (r2.hasNext() == false) goto L37;
        d r18 = (d) r2.next();
        int r19 = PDFCtrlView.G;
        int r110 = PDFCtrlView.G;
        if (Intrinsics.areEqual(r18.a, r13) == false) goto L32;
        r110 = PDFCtrlView.H;
        r5 = r18.b;
        r6 = 0.0f;
    L32:
        PDFCtrlView r111 = this.a;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r111 = null;
    L35:
        r111.t(r18.a, r110);
        goto L28
    L37:
        if (r5 >= 0) goto L40;
        tt5.a.h("TTStreamingPdfView", "showSelectedComment, page invalid, commentId: " + r13 + ", pageIndex: " + r5 + ", pageOffsetYRate: " + r6);
        return;
    L40:
        PDFCtrlView r112 = this.a;
        if (r112 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r112 = null;
    L43:
        PDFCtrlViewModel r113 = r112.k;
        if (r113 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r113 = null;
    L46:
        float r114 = RangesKt.coerceAtLeast(r113.getPageSizeF(r5).getHeight(), 0.0f);
        tt5.a.h("TTStreamingPdfView", "showSelectedComment, commentId: " + r13 + ", pageIndex: " + r5 + ", pageOffsetYRate: " + r6 + ", pageHeight: " + r114);
        float r115 = (((float) 0) - (RangesKt.coerceIn(r6, 0.0f, 1.0f) * r114)) + 100.0f;
        PDFCtrlView r3 = this.a;
        if (r3 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
    L50:
        r9.e(r5, (int) r115);
        return;
    L49:
        r9 = r3;
        goto L50
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r7) {
        if (w55.n.d == true) goto L5;
        return;
    L5:
        ((ArrayList) this.e).clear();
        ((ArrayList) this.f).clear();
        ((ArrayList) this.g).clear();
        ((ArrayList) this.h).clear();
        PDFCtrlView r0 = this.a;
        Boolean r2 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r0 = null;
    L8:
        PDFCtrlViewModel r1 = r0.k;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r1 = null;
    L11:
        r1.removeAllMarks();
        if (r7 != null) goto L15;
        tt5.a.h("TTStreamingPdfView", "updateComment, no comments.");
        return;
    L15:
        ((ArrayList) this.e).addAll(r7);
        PDFCtrlView r4 = this.a;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r4 = null;
    L18:
        PDFCtrlViewModel r3 = r4.k;
        if (r3 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L21:
        Boolean r5 = Boolean.valueOf(Intrinsics.areEqual(r3.getBookLoaded().getValue(), Boolean.TRUE));
        tt5.a.h("TTStreamingPdfView", "updateComment, isPdfLoaded: " + r5.booleanValue() + ", new rect size: " + r7.size() + ", all rect size: " + ((ArrayList) this.e).size());
        if (r5.booleanValue() == false) goto L24;
        r2 = r5;
    L24:
        if (r2 == null) goto L27;
        r2.booleanValue();
        b(r7);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r1, ViewOwner r2) {
        Intrinsics.checkNotNullParameter(r1, "parentViewOwner");
        tt5.a.h("TTStreamingPdfView", "onSetup");
    }

    public static final void a(Ref.BooleanRef r13, Ref.BooleanRef r14, Ref.ObjectRef r16, TTPdfReader r17, DrivePreviewAiResourceContextVM r18, BubbleMenuVM r19, com.bytedance.ee.bear.drive.view.widget.a r110, com.bytedance.ee.bear.drive.view.widget.a r20) {
        if (r13.element == false) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        long r11 = r18.getCurrentGeneration();
        Long r3 = (Long) r16.element;
        if (r3 == null) goto L21;
        if (r3.longValue() != r11) goto L21;
        return;
    L21:
        if (r16.element == null) goto L23;
        r17.setSelectionClient(null);
        r17.clearSelection();
        r19.clearSelectionData();
        r18.clearSelections();
    L23:
        r17.setSelectionClient(new c1(r110, r20, r18, r11, r19));
        r16.element = Long.valueOf(r11);
        return;
    L12:
        if (r16.element == null) goto L25;
        r17.setSelectionClient(null);
        r16.element = null;
        r17.clearSelection();
        r19.clearSelectionData();
        r18.clearSelections();
        return;
    L25:
        return;
    L5:
        if (r14.element == true) goto L8;
        r2 = false;
        goto L10
    }
}
