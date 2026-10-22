package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.content.Context;
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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
public final class v0 implements com.bytedance.ee.bear.drive.view.preview.wrapper.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PDFCtrlView f225418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewOwner f225419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.preview.vc.connector.g f225420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a95.a f225421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<CommentRectF> f225422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<c> f225423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<a> f225424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f225425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f225426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.bubblemenu.c f225427j;

    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f225428e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f225429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<RectF> f225431c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f225432d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.v0$a$a, reason: collision with other inner class name */
        public static final class C3241a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f225429a, r101.f225429a) == true) goto L12;
            return false;
        L12:
            if (this.f225430b == r101.f225430b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f225431c, r101.f225431c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f225429a.hashCode() * 31) + this.f225430b) * 31) + this.f225431c.hashCode();
        }

        public final String toString() {
            return "AreaMark(markId=" + this.f225429a + ", pageIndex=" + this.f225430b + ", areaRates=" + this.f225431c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, int r101, List<? extends RectF> r102) {
            Intrinsics.checkNotNullParameter(r100, "markId");
            Intrinsics.checkNotNullParameter(r102, "areaRates");
            this.f225429a = r100;
            this.f225430b = r101;
            this.f225431c = r102;
            boolean r103 = !r102.isEmpty();
            Object r104 = r102;
            if (r103 == true) goto L6;
            r104 = null;
        L6:
            if (r104 == null) goto L15;
            Iterator r105 = ((Iterable) r104).iterator();
            if (r105.hasNext() == false) goto L14;
            float r106 = ((RectF) r105.next()).top;
        L11:
            if (r105.hasNext() == false) goto L16;
            r106 = Math.min(r106, ((RectF) r105.next()).top);
        L16:
            this.f225432d = r106;
            return;
        L14:
            throw new NoSuchElementException();
        L15:
            r106 = 0.0f;
            goto L16
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f225433e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f225434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<RectF> f225436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f225437d;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f225434a, r101.f225434a) == true) goto L12;
            return false;
        L12:
            if (this.f225435b == r101.f225435b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f225436c, r101.f225436c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f225434a.hashCode() * 31) + this.f225435b) * 31) + this.f225436c.hashCode();
        }

        public final String toString() {
            return "ContentMark(markId=" + this.f225434a + ", pageIndex=" + this.f225435b + ", areaRates=" + this.f225436c + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(String r100, int r101, List<? extends RectF> r102) {
            Intrinsics.checkNotNullParameter(r100, "markId");
            Intrinsics.checkNotNullParameter(r102, "areaRates");
            this.f225434a = r100;
            this.f225435b = r101;
            this.f225436c = r102;
            boolean r103 = !r102.isEmpty();
            Iterable r104 = r102;
            if (r103 == true) goto L6;
            r104 = null;
        L6:
            if (r104 == null) goto L15;
            Iterator r105 = r104.iterator();
            if (r105.hasNext() == false) goto L14;
            float r106 = ((RectF) r105.next()).top;
        L11:
            if (r105.hasNext() == false) goto L16;
            r106 = Math.min(r106, ((RectF) r105.next()).top);
        L16:
            this.f225437d = r106;
            return;
        L14:
            throw new NoSuchElementException();
        L15:
            r106 = 0.0f;
            goto L16
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f225438c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f225439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225440b;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f225439a, r101.f225439a) == true) goto L12;
            return false;
        L12:
            if (this.f225440b == r101.f225440b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f225439a.hashCode() * 31) + this.f225440b;
        }

        public final String toString() {
            return "DefaultMark(markId=" + this.f225439a + ", pageIndex=" + this.f225440b + ')';
        }

        public d(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "markId");
            this.f225439a = r100;
            this.f225440b = r101;
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
    public final /* synthetic */ void onNewConfiguration(Configuration r100) {
    }

    @Override // c95.d
    public final void setOnShowViewTrackEventCallback(c95.c r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final String getCommentQuote() {
        tt5.a.h("TTStreamingPdfView", "getCommentQuote");
        PDFCtrlView r100 = null;
        if (w55.n.f558339d == true) goto L5;
        return null;
    L5:
        PDFCtrlView r101 = this.f225418a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
    L10:
        return r100.getCommentQuote();
    L8:
        r100 = r101;
        goto L10
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final View getView() {
        PDFCtrlView r100 = this.f225418a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        return null;
    L6:
        return r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        tt5.a.h("TTStreamingPdfView", "hideCreateComment");
        PDFCtrlViewModel r100 = null;
        PDFCtrlViewModel r101 = null;
        CommentRectF r102 = null;
        Quad[] r103 = null;
        r103 = null;
        r103 = null;
        CommentRectF r104 = null;
        r104 = null;
        r104 = null;
        if (w55.n.f558339d == true) goto L5;
        return null;
    L5:
        PDFCtrlView r105 = this.f225418a;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r105 = null;
    L8:
        CommentRectLayout r106 = r105.C;
        int r107 = 0;
        if (r106 == null) goto L13;
        boolean r108 = true;
        if (r106.q() != true) goto L13;
    L15:
        if (r108 == false) goto L33;
        CommentRectLayout r109 = r105.C;
        if (r109 != null) goto L19;
    L24:
        CommentRectF r110 = null;
    L25:
        if (r110 == null) goto L31;
        PDFCtrlViewModel r111 = r105.f225230k;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        r110.f236778e = r101.getCurrentPageIndex();
        r102 = r110;
        goto L31
    L29:
        r101 = r111;
    L31:
        r105.j();
        return r102;
    L19:
        if (r109.q() == true) goto L22;
        r109 = null;
    L22:
        if (r109 == null) goto L24;
        r110 = r109.j();
        goto L25
    L33:
        if (r105.D == null) goto L54;
        r105.u("ContentMarkId.PendingCreate", PDFCtrlView.G);
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r112 = r105.D;
        if (r112 == null) goto L53;
        List<TTReaderSelectionInfo> r113 = r112.f222610a;
        if (r113 == null) goto L53;
        TTReaderSelectionInfo r114 = (TTReaderSelectionInfo) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L53;
        CommentRectF r115 = new CommentRectF();
        r115.f236774a = 4;
        r115.f236778e = r114.pageIndex;
        r115.f236783j = r114.selectedText;
        RectF[] r116 = r114.selectedRects;
        SizeF r117 = r114.pageResolution;
        ArrayMap<String, Integer> r118 = com.bytedance.ee.bear.drive.biz.comment.data.c.f222739a;
        if (r116 == null) goto L52;
        float r119 = r117.getWidth();
        float r120 = r117.getHeight();
        if (r119 <= 0.0f) goto L52;
        if (r120 <= 0.0f) goto L52;
        r103 = new Quad[r116.length];
    L50:
        if (r107 >= r116.length) goto L52;
        Quad r121 = new Quad();
        r103[r107] = r121;
        RectF r122 = r116[r107];
        float r123 = r122.left / r119;
        r121.f236813x1 = r123;
        float r124 = r122.top / r120;
        r121.f236817y1 = r124;
        float r125 = r122.right / r119;
        r121.f236814x2 = r125;
        r121.f236818y2 = r124;
        r121.f236815x3 = r125;
        float r126 = r122.bottom / r120;
        r121.f236819y3 = r126;
        r121.f236816x4 = r123;
        r121.f236820y4 = r126;
        r107 = r107 + 1;
    L52:
        r115.f236782i = r103;
        r104 = r115;
    L53:
        r105.k();
        return r104;
    L54:
        CommentRectF r127 = new CommentRectF();
        r127.f236774a = 3;
        PDFCtrlViewModel r128 = r105.f225230k;
        if (r128 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        r127.f236778e = r100.getCurrentPageIndex();
        return r127;
    L57:
        r100 = r128;
    L13:
        r108 = false;
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        tt5.a.h("TTStreamingPdfView", "onAreaClick");
        PDFCtrlView r100 = this.f225418a;
        ViewOwner r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r100 = null;
    L5:
        CommentRectLayout r102 = r100.C;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L22;
        r100.j();
        ViewOwner r104 = r100.f225229j;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L17:
        PreviewViewModel r105 = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        if (r105 == null) goto L108;
        MutableLiveData<Boolean> r106 = r105.liveInnerCreateNewComment();
        if (r106 == null) goto L109;
        r106.postValue(Boolean.FALSE);
        return false;
    L109:
        return false;
    L108:
        return false;
    L16:
        r101 = r104;
        goto L17
    L22:
        CommentRectLayout r107 = r100.C;
        if (r107 != null) goto L26;
        tt5.a.k("PDFCtrlView", "enterAreaMarker, commentRectLayout is null.");
    L106:
        return true;
    L26:
        if (r107.q() == false) goto L28;
        tt5.a.k("PDFCtrlView", "enterAreaMarker, already entered.");
        goto L106
    L28:
        tt5.a.h("PDFCtrlView", "enterAreaMarker.");
        CommentRectLayout r108 = r100.C;
        if (r108 != null) goto L31;
        tt5.a.d("PDFCtrlView", "addCommentRectLayout, commentRectLayout is null.");
    L71:
        ViewOwner r109 = r100.f225229j;
        if (r109 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r109 = null;
    L74:
        PreviewViewModel r110 = (PreviewViewModel) r109.viewModel(PreviewViewModel.class);
        if (r110 == null) goto L77;
        r110.liveInnerForcePortrait.postValue(Boolean.TRUE);
        r110.liveInnerCommentSelected().postValue(null);
    L77:
        r100.k();
        PDFCtrlViewModel r111 = r100.f225230k;
        if (r111 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r111 = null;
    L80:
        int r112 = r111.getCurrentPageIndex();
        PDFCtrlViewModel r113 = r100.f225230k;
        if (r113 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r113 = null;
    L83:
        SizeF r114 = r113.getPageSizeF(r112);
        float r115 = r114.getWidth() / r114.getHeight();
        int r116 = r100.getWidth();
        int r117 = r100.getHeight();
        if (r116 <= r117) goto L86;
        r116 = (int) (r117 * r115);
    L87:
        PDFCtrlViewModel r118 = r100.f225230k;
        if (r118 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r118 = null;
    L90:
        PagePart r119 = r118.getPageForPresentation(r112, r116, r117);
        if (r119 == null) goto L97;
        Bitmap r120 = r119.getRenderedBitmap();
        if (r120 == null) goto L97;
        CommentRectLayout r121 = r100.C;
        if (r121 == null) goto L97;
        r121.t(r100.getContext().getResources().getColor(R.color.static_black), r120);
    L97:
        r107.v(RangesKt.coerceAtLeast(r100.getWidth(), 0) / 2.0f, RangesKt.coerceAtLeast(r100.getHeight(), 0) / 2.0f);
        ViewOwner r122 = r100.f225229j;
        if (r122 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L101:
        DriveCommentVM r123 = (DriveCommentVM) r101.viewModel(DriveCommentVM.class);
        if (r123 == null) goto L106;
        MutableLiveData<CommentArea.Type> r124 = r123.getLiveInnerCommentMarkType();
        if (r124 == null) goto L106;
        r124.postValue(CommentArea.Type.AREA);
        goto L106
    L100:
        r101 = r122;
        goto L101
    L86:
        r117 = (int) (r116 / r115);
        goto L87
    L31:
        ViewOwner r125 = r100.f225229j;
        if (r125 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r125 = null;
    L34:
        DriveViewFinderVM r126 = (DriveViewFinderVM) r125.viewModel(DriveViewFinderVM.class);
        if (r126 == null) goto L70;
        View r127 = r126.findViewById(R.id.main_page_holder_view);
        if (r127 == null) goto L70;
        if ((r127 instanceof ViewGroup) == true) goto L42;
        r127 = null;
    L42:
        if (r127 == null) goto L70;
        if ((r127 instanceof ViewGroup) == false) goto L46;
        ViewGroup r128 = (ViewGroup) r127;
    L47:
        if (r128 == null) goto L70;
        r100.r();
        tt5.a.h("PDFCtrlView", "addCommentRectLayout");
        r128.addView(r108, -1, new ViewGroup.LayoutParams(-1, -1));
        xu5.b.a r129 = r100.E;
        if (r129 == null) goto L51;
        r129.saveState();
    L51:
        xu5.b.a r130 = r100.E;
        if (r130 == null) goto L54;
        r130.d(R.color.static_black, false);
    L54:
        ca5.a r131 = r100.F;
        Context r132 = r100.getContext();
        if ((r132 instanceof FragmentActivity) == false) goto L57;
        FragmentActivity r133 = (FragmentActivity) r132;
    L58:
        r131.getClass();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.drive.pdf_comment_onboard_enable") == true) goto L62;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "fg disabled, skip");
        goto L71
    L62:
        if (r131.f22941a == false) goto L64;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "already shown in this page, skip");
        goto L71
    L64:
        sk5.c r134 = ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b();
        tt5.a.h("DrivePdfCommentOnboardCtrl", "tryShow, try show, isDebugMode: " + r134.isDebugMode());
        if (r134.isDebugMode() == true) goto L69;
        int r135 = ca5.c.f22946b;
        if (((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().f("ccm_mobile_drive_pdf_area_box_comment_intro") == false) goto L69;
        tt5.a.h("DrivePdfCommentOnboardCtrl", "mission finished, skip");
    L69:
        com.bytedance.ee.util.ui.j.d(new ca5.b(r133, r108, r131, r134), 500);
        goto L71
    L57:
        r133 = null;
        goto L58
    L46:
        r128 = null;
    L70:
        tt5.a.d("PDFCtrlView", "addCommentRectLayout, driveMainPageView not found.");
        goto L71
    L8:
        if (r102.q() != true) goto L10;
        r103 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        tt5.a.h("TTStreamingPdfView", "onBackPressed");
        PDFCtrlView r100 = this.f225418a;
        CommentRectLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r100 = null;
    L5:
        CommentRectLayout r102 = r100.C;
        if (r102 != null) goto L8;
    L12:
        return false;
    L8:
        if (r102.q() == false) goto L10;
        r101 = r102;
    L10:
        if (r101 == null) goto L12;
        r100.j();
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
        tt5.a.h("TTStreamingPdfView", "onCommentInputPanelOpen");
        if (w55.n.f558339d == true) goto L5;
        return;
    L5:
        PDFCtrlView r100 = this.f225418a;
        ViewOwner r101 = null;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r100 = null;
    L8:
        CommentRectLayout r102 = r100.C;
        int r103 = 0;
        if (r102 == null) goto L13;
        boolean r104 = true;
        if (r102.q() != true) goto L13;
    L14:
        if (r104 == true) goto L72;
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r105 = r100.D;
        if (r105 == null) goto L53;
        Intrinsics.checkNotNullParameter(r105, "selectionData");
        List<TTReaderSelectionInfo> r106 = r105.f222610a;
        if (r106 == null) goto L65;
        TTReaderSelectionInfo r107 = (TTReaderSelectionInfo) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L66;
        SizeF r108 = r107.pageResolution;
        if (r108 == null) goto L25;
        float r109 = r108.getWidth();
    L26:
        SizeF r110 = r107.pageResolution;
        if (r110 == null) goto L29;
        float r111 = r110.getHeight();
    L31:
        if (r109 > 0.0f) goto L33;
        return;
    L33:
        if (r111 <= 0.0f) goto L73;
        RectF[] r112 = r107.selectedRects;
        if (r112 == null) goto L68;
        ArrayList r113 = new ArrayList(r112.length);
        int r114 = r112.length;
    L38:
        if (r103 >= r114) goto L40;
        RectF r115 = r112[r103];
        r113.add(new RectF(r115.left / r109, r115.top / r111, r115.right / r109, r115.bottom / r111));
        r103 = r103 + 1;
        goto L38
    L40:
        Iterator r116 = r113.iterator();
        if (r116.hasNext() == false) goto L52;
        float r117 = ((RectF) r116.next()).top;
    L44:
        if (r116.hasNext() == false) goto L46;
        r117 = Math.min(r117, ((RectF) r116.next()).top);
        goto L44
    L46:
        float r118 = RangesKt.coerceAtLeast(r117, 0.0f);
        SizeF r119 = r107.pageSize;
        if (r119 == null) goto L49;
        float r120 = RangesKt.coerceAtLeast(r119.getHeight(), 0.0f);
    L50:
        float r121 = (0.0f - (r118 * r120)) + 100.0f;
        r100.q("ContentMarkId.PendingCreate", r107.pageIndex, r113, PDFCtrlView.H, false, false);
        r100.e(r107.pageIndex, (int) r121);
        return;
    L49:
        r120 = 0.0f;
        goto L50
    L52:
        throw new NoSuchElementException();
    L68:
        return;
    L73:
        return;
    L29:
        r111 = 0.0f;
        goto L31
    L25:
        r109 = 0.0f;
        goto L26
    L66:
        return;
    L65:
        return;
    L53:
        ViewOwner r122 = r100.f225229j;
        if (r122 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L57:
        DriveCommentVM r123 = (DriveCommentVM) r101.viewModel(DriveCommentVM.class);
        if (r123 == null) goto L70;
        MutableLiveData<CommentArea.Type> r124 = r123.getLiveInnerCommentMarkType();
        if (r124 == null) goto L71;
        r124.postValue(CommentArea.Type.WHOLE_PAGE);
        return;
    L71:
        return;
    L70:
        return;
    L56:
        r101 = r122;
        goto L57
    L72:
        return;
    L13:
        r104 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
        tt5.a.h("TTStreamingPdfView", "onCommentListPanelClose");
        if (w55.n.f558339d == true) goto L5;
        return;
    L5:
        this.f225426i = null;
        Iterator<T> r100 = this.f225423f.iterator();
    L7:
        if (r100.hasNext() == false) goto L12;
        c r101 = (c) r100.next();
        PDFCtrlView r102 = this.f225418a;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r102 = null;
    L11:
        String r103 = r101.f225434a;
        int r104 = PDFCtrlView.G;
        r102.u(r103, PDFCtrlView.G);
        goto L7
    L12:
        Iterator<T> r105 = this.f225424g.iterator();
    L14:
        if (r105.hasNext() == false) goto L19;
        a r106 = (a) r105.next();
        PDFCtrlView r107 = this.f225418a;
        if (r107 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r107 = null;
    L18:
        String r108 = r106.f225429a;
        int r109 = PDFCtrlView.G;
        r107.t(r108, PDFCtrlView.G);
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        PDFCtrlView r100 = this.f225418a;
        ViewOwner r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r100 = null;
    L5:
        PDFCtrlViewModel r102 = r100.f225230k;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r102 = null;
    L8:
        a95.a r103 = r100.B;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("userComponentAbility");
        r103 = null;
    L11:
        r102.openPdf(null, r103);
        if (w55.n.f558339d == false) goto L24;
        ViewOwner r104 = this.f225419b;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
    L17:
        PreviewViewModel r105 = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        if (r105 == null) goto L22;
        MutableLiveData<Boolean> r106 = r105.liveInnerAreaCommentEnableState();
        if (r106 == null) goto L22;
        r106.postValue(Boolean.TRUE);
        Unit r107 = Unit.INSTANCE;
        tt5.a.h("TTStreamingPdfView", "show, comment enabled, enable area comment.");
        return;
    L22:
        tt5.a.d("TTStreamingPdfView", "show, comment enabled, but PreviewViewModel is null.");
        return;
    L16:
        r101 = r104;
        goto L17
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
        tt5.a.h("TTStreamingPdfView", "showThumbnailPreview");
    }

    public v0() {
        this.f225422e = new ArrayList();
        this.f225423f = new ArrayList();
        this.f225424g = new ArrayList();
        this.f225425h = new ArrayList();
    }

    public final void b(List<? extends CommentRectF> r110) {
        if (r110 != null) goto L6;
        tt5.a.k("TTStreamingPdfView", "showMarks, rect is null.");
        return;
    L6:
        tt5.a.h("TTStreamingPdfView", "showMarks, rect size: " + r110.size());
        Iterator<T> r100 = r110.iterator();
    L8:
        if (r100.hasNext() == false) goto L35;
        CommentRectF r101 = (CommentRectF) r100.next();
        if (Intrinsics.areEqual(this.f225426i, r101.f236775b) == false) goto L12;
        int r102 = PDFCtrlView.G;
        int r103 = PDFCtrlView.H;
    L13:
        int r104 = r103;
        int r105 = r101.getType();
        if (r105 != 1) goto L16;
        int r106 = a.f225428e;
        Intrinsics.checkNotNullParameter(r101, "commentRectF");
        a r107 = new a(r101.f236775b, r101.f236778e, CollectionsKt.listOf(new RectF(r101)));
        ((ArrayList) this.f225424g).add(r107);
        PDFCtrlView r108 = this.f225418a;
        if (r108 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r108 = null;
    L34:
        r108.p(r107.f225429a, r107.f225430b, r107.f225431c, r104, true, true);
        goto L8
    L16:
        if (r105 != 4) goto L17;
        int r109 = c.f225433e;
        Intrinsics.checkNotNullParameter(r101, "commentRectF");
        ArrayList r111 = new ArrayList();
        Quad[] r112 = r101.f236782i;
        if (r112 == null) goto L27;
        int r113 = r112.length;
        int r114 = 0;
    L25:
        if (r114 >= r113) goto L27;
        Quad r115 = r112[r114];
        RectF r116 = new RectF();
        r116.left = ComparisonsKt.minOf(r115.f236813x1, new float[]{r115.f236814x2, r115.f236815x3, r115.f236816x4});
        r116.top = ComparisonsKt.minOf(r115.f236817y1, new float[]{r115.f236818y2, r115.f236819y3, r115.f236820y4});
        r116.right = ComparisonsKt.maxOf(r115.f236813x1, new float[]{r115.f236814x2, r115.f236815x3, r115.f236816x4});
        r116.bottom = ComparisonsKt.maxOf(r115.f236817y1, new float[]{r115.f236818y2, r115.f236819y3, r115.f236820y4});
        r111.add(r116);
        r114 = r114 + 1;
    L27:
        c r117 = new c(r101.f236775b, r101.f236778e, r111);
        ((ArrayList) this.f225423f).add(r117);
        PDFCtrlView r118 = this.f225418a;
        if (r118 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r118 = null;
    L30:
        r118.q(r117.f225434a, r117.f225435b, r117.f225436c, r104, true, true);
        goto L8
    L17:
        int r119 = d.f225438c;
        Intrinsics.checkNotNullParameter(r101, "commentRectF");
        d r120 = new d(r101.f236775b, r101.f236778e);
        ((ArrayList) this.f225425h).add(r120);
        List<? extends RectF> r121 = CollectionsKt.listOf(new RectF(0.0f, 0.0f, 1.0f, 1.0f));
        PDFCtrlView r122 = this.f225418a;
        if (r122 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        PDFCtrlView r123 = null;
    L21:
        r123.p(r120.f225439a, r120.f225440b, r121, r104, false, true);
        goto L8
    L20:
        r123 = r122;
        goto L21
    L12:
        int r124 = PDFCtrlView.G;
        r103 = PDFCtrlView.G;
        goto L13
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r100) {
        tt5.a.h("TTStreamingPdfView", "onCommentInputPanelClose, isBySend: " + r100);
        if (w55.n.f558339d == true) goto L5;
        return;
    L5:
        PDFCtrlView r101 = this.f225418a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r101 = null;
    L8:
        CommentRectLayout r102 = r101.C;
        if (r102 == null) goto L13;
        boolean r103 = true;
        if (r102.q() != true) goto L13;
    L14:
        if (r103 == false) goto L17;
        return;
    L17:
        if (r101.D == null) goto L22;
        if (r100 == false) goto L20;
        r101.u("ContentMarkId.PendingCreate", PDFCtrlView.G);
        return;
    L20:
        r101.k();
        return;
    L22:
        return;
    L13:
        r103 = false;
        goto L14
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void setUserAbility(a95.a r100) {
        if (r100 == null) goto L5;
        this.f225421d = r100;
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r110) {
        tt5.a.h("TTStreamingPdfView", "showSelectedComment, commentId: " + r110);
        if (w55.n.f558339d == true) goto L5;
        return;
    L5:
        this.f225426i = r110;
        Iterator<T> r100 = this.f225423f.iterator();
        int r101 = 0;
        float r102 = 0.0f;
    L6:
        PDFCtrlView r103 = null;
        if (r100.hasNext() == false) goto L16;
        c r104 = (c) r100.next();
        int r111 = PDFCtrlView.G;
        int r112 = PDFCtrlView.G;
        if (Intrinsics.areEqual(r104.f225434a, r110) == false) goto L11;
        r112 = PDFCtrlView.H;
        r101 = r104.f225435b;
        r102 = r104.f225437d;
    L11:
        PDFCtrlView r113 = this.f225418a;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
    L15:
        r103.u(r104.f225434a, r112);
        goto L6
    L14:
        r103 = r113;
        goto L15
    L16:
        Iterator<T> r105 = this.f225424g.iterator();
    L18:
        if (r105.hasNext() == false) goto L26;
        a r106 = (a) r105.next();
        int r114 = PDFCtrlView.G;
        int r115 = PDFCtrlView.G;
        if (Intrinsics.areEqual(r106.f225429a, r110) == false) goto L22;
        r115 = PDFCtrlView.H;
        r101 = r106.f225430b;
        r102 = r106.f225432d;
    L22:
        PDFCtrlView r116 = this.f225418a;
        if (r116 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r116 = null;
    L25:
        r116.t(r106.f225429a, r115);
        goto L18
    L26:
        Iterator<T> r107 = this.f225425h.iterator();
    L28:
        if (r107.hasNext() == false) goto L37;
        d r108 = (d) r107.next();
        int r117 = PDFCtrlView.G;
        int r118 = PDFCtrlView.G;
        if (Intrinsics.areEqual(r108.f225439a, r110) == false) goto L32;
        r118 = PDFCtrlView.H;
        r101 = r108.f225440b;
        r102 = 0.0f;
    L32:
        PDFCtrlView r119 = this.f225418a;
        if (r119 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r119 = null;
    L35:
        r119.t(r108.f225439a, r118);
        goto L28
    L37:
        if (r101 >= 0) goto L40;
        tt5.a.h("TTStreamingPdfView", "showSelectedComment, page invalid, commentId: " + r110 + ", pageIndex: " + r101 + ", pageOffsetYRate: " + r102);
        return;
    L40:
        PDFCtrlView r120 = this.f225418a;
        if (r120 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r120 = null;
    L43:
        PDFCtrlViewModel r121 = r120.f225230k;
        if (r121 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r121 = null;
    L46:
        float r122 = RangesKt.coerceAtLeast(r121.getPageSizeF(r101).getHeight(), 0.0f);
        tt5.a.h("TTStreamingPdfView", "showSelectedComment, commentId: " + r110 + ", pageIndex: " + r101 + ", pageOffsetYRate: " + r102 + ", pageHeight: " + r122);
        float r123 = (((float) 0) - (RangesKt.coerceIn(r102, 0.0f, 1.0f) * r122)) + 100.0f;
        PDFCtrlView r109 = this.f225418a;
        if (r109 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
    L50:
        r103.e(r101, (int) r123);
        return;
    L49:
        r103 = r109;
        goto L50
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r100) {
        if (w55.n.f558339d == true) goto L5;
        return;
    L5:
        ((ArrayList) this.f225422e).clear();
        ((ArrayList) this.f225423f).clear();
        ((ArrayList) this.f225424g).clear();
        ((ArrayList) this.f225425h).clear();
        PDFCtrlView r101 = this.f225418a;
        Boolean r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r101 = null;
    L8:
        PDFCtrlViewModel r103 = r101.f225230k;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L11:
        r103.removeAllMarks();
        if (r100 != null) goto L15;
        tt5.a.h("TTStreamingPdfView", "updateComment, no comments.");
        return;
    L15:
        ((ArrayList) this.f225422e).addAll(r100);
        PDFCtrlView r104 = this.f225418a;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r104 = null;
    L18:
        PDFCtrlViewModel r105 = r104.f225230k;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r105 = null;
    L21:
        Boolean r106 = Boolean.valueOf(Intrinsics.areEqual(r105.getBookLoaded().getValue(), Boolean.TRUE));
        tt5.a.h("TTStreamingPdfView", "updateComment, isPdfLoaded: " + r106.booleanValue() + ", new rect size: " + r100.size() + ", all rect size: " + ((ArrayList) this.f225422e).size());
        if (r106.booleanValue() == false) goto L24;
        r102 = r106;
    L24:
        if (r102 == null) goto L27;
        r102.booleanValue();
        b(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r100, ViewOwner r101) {
        Intrinsics.checkNotNullParameter(r100, "parentViewOwner");
        tt5.a.h("TTStreamingPdfView", "onSetup");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Long] */
    public static final void a(Ref.BooleanRef r110, Ref.BooleanRef r111, Ref.ObjectRef r112, TTPdfReader r113, DrivePreviewAiResourceContextVM r114, BubbleMenuVM r115, com.bytedance.ee.bear.drive.view.widget.a r116, com.bytedance.ee.bear.drive.view.widget.a r210) {
        if (r110.element == false) goto L5;
    L8:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
        long r117 = r114.getCurrentGeneration();
        Long r101 = (Long) r112.element;
        if (r101 == null) goto L21;
        if (r101.longValue() != r117) goto L21;
        return;
    L21:
        if (r112.element == 0) goto L23;
        r113.setSelectionClient(null);
        r113.clearSelection();
        r115.clearSelectionData();
        r114.clearSelections();
    L23:
        r113.setSelectionClient(new c1(r116, r210, r114, r117, r115));
        r112.element = Long.valueOf(r117);
        return;
    L12:
        if (r112.element == 0) goto L25;
        r113.setSelectionClient(null);
        r112.element = null;
        r113.clearSelection();
        r115.clearSelectionData();
        r114.clearSelections();
        return;
    L25:
        return;
    L5:
        if (r111.element == true) goto L8;
        r100 = false;
        goto L10
    }
}
