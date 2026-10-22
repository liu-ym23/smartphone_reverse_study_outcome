package com.bytedance.ee.bear.document.imageviewer.areacomment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.l2;
import com.bytedance.ee.bear.document.comment.m2;
import com.bytedance.ee.bear.document.comment.n2;
import com.bytedance.ee.bear.document.comment.o2;
import com.bytedance.ee.bear.document.comment.p2;
import com.bytedance.ee.bear.document.comment.q2;
import com.bytedance.ee.bear.document.comment.r2;
import com.bytedance.ee.bear.document.comment.t2;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerViewModel;
import com.bytedance.ee.bear.document.imageviewer.bean.CardCommentData;
import com.bytedance.ee.bear.document.imageviewer.bean.ImageCardsData;
import com.bytedance.ee.bear.document.imageviewer.bean.ImageDataModel;
import com.bytedance.ee.bear.middleground.comment.export.CardCommentHeight;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public final Context a;
    public final ImageViewerViewModel b;
    public final IImageViewer c;
    public final CommentPlugin d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final com.bytedance.ee.bear.document.comment.e h;
    public LargeImageView i;
    public final b j;
    public final C0079c k;
    public final d l;
    public final com.bytedance.ee.bear.document.imageviewer.areacomment.a m;
    public IImageViewer.ImageCommentMode n;
    public final com.bytedance.ee.bear.document.imageviewer.areacomment.e o;
    public final int p;
    public final a q;
    public ValueAnimator r;
    public com.bytedance.ee.bear.document.imageviewer.areacomment.d s;
    public boolean t;
    public long u;
    public final g v;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public final void a() {
            if (this.a.c.c7() != null) goto L7;
            tt5.a.h("AreaCommentRender", "attachRunnable: image is null");
            return;
        L7:
            if (this.a.c.iF() == null) goto L11;
            c r0 = this.a;
            if (Intrinsics.areEqual(r0.i, r0.c.iF()) == true) goto L11;
            tt5.a.h("AreaCommentRender", "attachRunnable: mLargeImageView!= imageViewer.currPageSubView");
            c r1 = this.a;
            r1.g(r1.c.iF());
        L11:
            RectF r2 = this.a.c();
            if (r2 == null) goto L15;
            c r3 = this.a;
            r3.b(r2, r3.d());
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public static final class b implements SubsamplingScaleImageView.i {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void a(RectF r3) {
            Intrinsics.checkNotNullParameter(r3, "rectF");
            c r0 = this.a;
            r0.b(r3, r0.d());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.imageviewer.areacomment.c$c, reason: collision with other inner class name */
    public static final class C0079c implements SubsamplingScaleImageView.OnScaleEventListener {
        public boolean a;
        public final /* synthetic */ c b;

        public C0079c(c r1) {
            this.b = r1;
        }

        public final void b(float r5) {
            if (this.b.n == IImageViewer.ImageCommentMode.COMMENT_VIEW) goto L6;
            return;
        L6:
            if (r5 <= 1.0f) goto L8;
            boolean r0 = true;
        L9:
            tt5.a.h("AreaCommentRender", "onScaling: " + r5 + ", zoomIn = " + r0);
            if (r0 == true) goto L12;
            return;
        L12:
            if (this.a == true) goto L16;
            this.b.d.updatePanelHeight(CardCommentHeight.SHRINK_ONE_LEVEL);
            this.a = true;
            return;
        L16:
            return;
        L8:
            r0 = false;
            goto L9
        }

        public final void a(float r3, float r4, SubsamplingScaleImageView.OnScaleEventListener.ScaleCause r5) {
            if (this.b.n == IImageViewer.ImageCommentMode.COMMENT_VIEW) goto L5;
            return;
        L5:
            tt5.a.h("AreaCommentRender", "onScaleEvent: scaleStart = " + r3 + ", scaleEnd = " + r4 + ", scaleCause = " + r5);
            if (r3 < r4) goto L8;
        L13:
            this.a = false;
            return;
        L8:
            if (this.a == true) goto L10;
            this.b.d.updatePanelHeight(CardCommentHeight.SHRINK_ONE_LEVEL);
        L10:
            g r6 = this.b.v;
            if ((r6 instanceof j) == false) goto L13;
            ((j) r6).c = Float.valueOf(r4);
            goto L13
        }
    }

    public static final class d implements l2 {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.comment.l2
        public final void a(o2 r9) {
            Intrinsics.checkNotNullParameter(r9, "state");
            c r0 = this.a;
            int r2 = 0;
            if (r0.g == true) goto L14;
            com.bytedance.ee.bear.middleground.comment.export.h r1 = ((com.bytedance.ee.bear.document.comment.d) r0.h).a;
            if (r1 != null) goto L8;
        L9:
            boolean r3 = true;
        L11:
            if (r3 == false) goto L14;
            tt5.a.h("AreaCommentRender", "stateChange: isNewCardComment");
            return;
        L8:
            if (r1.n0() != CommentStyle.HALF_SCREEN) goto L9;
            r3 = false;
        L14:
            tt5.a.h("AreaCommentRender", "stateChange: " + r9);
            if ((r9 instanceof com.bytedance.ee.bear.document.comment.a) == false) goto L34;
            c r4 = this.a;
            com.bytedance.ee.bear.document.comment.a r10 = (com.bytedance.ee.bear.document.comment.a) r9;
            r4.getClass();
            if (r10.a == false) goto L22;
            r4.g(r4.c.iF());
            ViewGroup r5 = r4.c.getContainerView();
            if (r5 == null) goto L21;
            r5.addView(r4.o.d);
        L21:
            r4.v.attach();
        L30:
            if (r10.a == false) goto L32;
            IImageViewer.ImageCommentMode r11 = IImageViewer.ImageCommentMode.COMMENT_VIEW;
        L33:
            r4.n = r11;
            r4.c.hl(r11);
            return;
        L32:
            r11 = IImageViewer.ImageCommentMode.EXIT;
            goto L33
        L22:
            ViewGroup r6 = r4.c.getContainerView();
            if (r6 == null) goto L25;
            r6.removeView(r4.o.d);
        L25:
            ViewGroup r7 = r4.c.getContainerView();
            if (r7 == null) goto L28;
            r7.setPadding(0, 0, 0, 0);
        L28:
            r4.v.detach();
            goto L30
        L34:
            SubsamplingScaleImageView.f r8 = null;
            if ((r9 instanceof m2) == false) goto L79;
            c r12 = this.a;
            m2 r13 = (m2) r9;
            CommentRectLayout r14 = r12.o.e;
            String r16 = r13.a;
            Iterator r17 = ((ArrayList) r14.b).iterator();
        L38:
            if (r17.hasNext() == false) goto L42;
            if (TextUtils.equals(((CommentRectF) r17.next()).b, r16) == false) goto L38;
            r2 = 1;
        L42:
            if (r2 == 0) goto L44;
            String r18 = r13.a;
        L45:
            String r19 = r12.o.e.getHighLightCommentId();
            CommentRectLayout r20 = r12.o.e;
            r20.B = r18;
            r20.J.invalidate();
            ImageData.Image r21 = r12.c.c7();
            if (r21 == null) goto L50;
            Map<String, ImageData.Image.a> r22 = r21.getTransformAreaComments();
            if (r22 == null) goto L50;
            ImageData.Image.a r23 = r22.get(r13.a);
        L51:
            LargeImageView r24 = r12.c.iF();
            if ((r24 instanceof LargeImageView) == false) goto L54;
            LargeImageView r26 = r24;
        L55:
            if (r26 == null) goto L57;
            SubsamplingScaleImageView r27 = r26.getScaleImageView();
        L58:
            if (r27 != null) goto L61;
            tt5.a.h("AreaCommentRender", "handleCommentSwitchCardEvent: scaleImageView is null");
            return;
        L61:
            if (Intrinsics.areEqual(r19, r18) == false) goto L63;
            tt5.a.h("AreaCommentRender", "handleCommentSwitchCardEvent: highlightCommentId = " + r18 + ", not change, no need to scroll");
            return;
        L63:
            if (r23 == null) goto L71;
            float r28 = r23.a;
            float r29 = (r28 + ((r23.c - r28) / 2.0f)) * r27.getSWidth();
            float r30 = r23.b;
            float r31 = (r30 + ((r23.d - r30) / 2.0f)) * r27.getSHeight();
            PointF r32 = new PointF(r29, r31);
            if (r27.b1 == false) goto L68;
            r8 = new SubsamplingScaleImageView.f(r27, r32);
        L68:
            if (r8 == null) goto L70;
            r8.a();
        L70:
            tt5.a.h("AreaCommentRender", "handleCommentSwitchCardEvent: centerX = " + r29 + ", centerY = " + r31);
            return;
        L71:
            float r33 = r27.getMinScale();
            if (r27.b1 == false) goto L75;
            r8 = new SubsamplingScaleImageView.f(r27, r33);
        L75:
            if (r8 == null) goto L77;
            r8.a();
        L77:
            tt5.a.h("AreaCommentRender", "handleCommentSwitchCardEvent: minScale = " + r27.getMinScale());
            return;
        L57:
            r27 = null;
            goto L58
        L54:
            r26 = null;
        L50:
            r23 = null;
            goto L51
        L44:
            r18 = r13.b;
            goto L45
        L79:
            if ((r9 instanceof n2) == false) goto L84;
            if (((com.bytedance.ee.bear.document.comment.d) this.a.h).b() == true) goto L141;
            this.a.v.a((n2) r9);
            return;
        L141:
            return;
        L84:
            if ((r9 instanceof t2) == false) goto L91;
            com.bytedance.ee.bear.document.imageviewer.areacomment.e r34 = this.a.o;
            boolean r36 = ((t2) r9).a;
            TextView r37 = r34.f;
            if (r36 == true) goto L89;
            r2 = 8;
        L89:
            r37.setVisibility(r2);
            return;
        L91:
            if ((r9 instanceof q2) == false) goto L119;
            c r38 = this.a;
            q2 r39 = (q2) r9;
            r38.getClass();
            tt5.a.h("AreaCommentRender", "handleInputHeightChangeEvent: height = " + r39.a + ", isInputShow = " + ((com.bytedance.ee.bear.document.comment.d) r38.h).b() + ", mode = " + r38.n);
            if (r38.f == false) goto L110;
            if (r38.n != IImageViewer.ImageCommentMode.COMMENT_VIEW) goto L110;
            SubsamplingScaleImageView.f r40 = r38.v;
            if ((r40 instanceof j) == false) goto L99;
            r8 = (j) r40;
        L99:
            if (r8 == null) goto L110;
            if (r8.d != null) goto L110;
            SubsamplingScaleImageView r41 = r8.l;
            if (r41 == null) goto L107;
            PointF r42 = r41.getCenter();
            if (r42 == null) goto L107;
        L108:
            r8.d = r42;
            tt5.a.h("AreaCommentRender", "setTargetZoomCenter before input show: targetZoomCenter = " + r8.d);
        L107:
            r42 = new PointF(0.0f, 0.0f);
        L110:
            if (r38.g == true) goto L112;
            return;
        L112:
            if (r38.n != IImageViewer.ImageCommentMode.EXIT) goto L152;
            com.bytedance.ee.bear.document.imageviewer.areacomment.d r43 = r38.s;
            if (r43 == null) goto L117;
            com.bytedance.ee.util.ui.j.e(r43);
        L117:
            com.bytedance.ee.bear.document.imageviewer.areacomment.d r44 = new com.bytedance.ee.bear.document.imageviewer.areacomment.d(r39, r38);
            r38.s = r44;
            com.bytedance.ee.util.ui.j.d(r44, 150);
            return;
        L152:
            return;
        L119:
            if ((r9 instanceof r2) == false) goto L126;
            c r46 = this.a;
            if (r46.g == false) goto L146;
            tt5.a.h("AreaCommentRender", "handleInputShowEvent");
            r46.u = SystemClock.elapsedRealtime();
            if (r46.n != IImageViewer.ImageCommentMode.EXIT) goto L147;
            r46.d.setInputCommentFullClick(false);
            r46.c.f00(false);
            r46.c.oZ(true);
            return;
        L147:
            return;
        L146:
            return;
        L126:
            if ((r9 instanceof p2) == false) goto L149;
            c r47 = this.a;
            if (r47.g == false) goto L150;
            tt5.a.h("AreaCommentRender", "handleInputCloseEvent");
            if (r47.n != IImageViewer.ImageCommentMode.EXIT) goto L151;
            r47.d.setInputCommentFullClick(true);
            r47.c.oZ(false);
            r47.c.f00(true);
            r47.h();
            return;
        L151:
            return;
        L150:
            return;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            com.bytedance.ee.util.ui.j.e(this.a.q);
            com.bytedance.ee.util.ui.j.c(this.a.q);
        }
    }

    public static final class f implements uw4.g {
        public final /* synthetic */ c a;

        @Override // uw4.g
        public final boolean a() {
            c r0 = this.a;
            boolean r3 = false;
            if (r0.n == IImageViewer.ImageCommentMode.EXIT) goto L5;
        L14:
            return false;
        L5:
            if (((com.bytedance.ee.bear.document.comment.d) r0.h).b() == false) goto L14;
            c r1 = this.a;
            r1.getClass();
            if ((SystemClock.elapsedRealtime() - r1.u) >= 500) goto L9;
            r3 = true;
        L9:
            if (r3 == false) goto L12;
            tt5.a.h("AreaCommentRender", "ignore close comment by image click after input show");
            return true;
        L12:
            this.a.d.closeComment(true, true);
            return true;
        }

        public f(c r1) {
            this.a = r1;
        }
    }

    public interface g {
        void a(n2 r1);

        void attach();

        void detach();
    }

    public static final class h {
    }

    public final class i implements g {
        public final /* synthetic */ c a;

        @Override // com.bytedance.ee.bear.document.imageviewer.areacomment.c.g
        public final /* synthetic */ void attach() {
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.areacomment.c.g
        public final /* synthetic */ void detach() {
        }

        public i(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.areacomment.c.g
        public final void a(n2 r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            c r0 = this.a;
            if (r0.n == IImageViewer.ImageCommentMode.COMMENT_VIEW) goto L5;
            return;
        L5:
            if (r4.a == 0) goto L11;
            ViewGroup r1 = r0.c.getContainerView();
            if (r1 == null) goto L12;
            r1.setPadding(0, 0, 0, r4.a - this.a.p);
            return;
        L12:
            return;
        }
    }

    public final class j implements g {
        public Float a;
        public PointF b;
        public Float c;
        public PointF d;
        public int e;
        public boolean f;
        public Runnable g;
        public boolean h;
        public SubsamplingScaleImageView.j i;
        public final b j;
        public LargeImageView k;
        public SubsamplingScaleImageView l;
        public final /* synthetic */ c m;

        public static final class a implements Runnable {
            public final /* synthetic */ j a;
            public final /* synthetic */ c b;

            public a(j r1, c r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                tt5.a.h("AreaCommentRender", "initFinishRunnable run");     // Catch: Throwable -> L9
                this.a.f = true;     // Catch: Throwable -> L9
                LargeImageView r0 = this.b.i;     // Catch: Throwable -> L9
                if (r0 == null) goto L7;
                SubsamplingScaleImageView r1 = r0.getScaleImageView();     // Catch: Throwable -> L9
                if (r1 == null) goto L7;
                r1.setOnSizeChangedStrategy(this.a.j);     // Catch: Throwable -> L9
            L7:
                this.a.g = null;     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L13;
                return;
            L13:
                throw th;
            }
        }

        public static final class b implements SubsamplingScaleImageView.j {
            public final /* synthetic */ j a;

            public b(j r1) {
                this.a = r1;
            }

            public final PointF a(PointF r3) {
                tt5.a.h("AreaCommentRender", "calculateCenterDiff: viewCenter = " + r3 + ", targetZoomCenter = " + this.a.d);
                j r0 = this.a;
                if (r0.h == false) goto L7;
                r3 = r0.d;
                if (r3 != null) goto L11;
                r3 = r0.b;
            L11:
                r0.d = null;
                r0.h = false;
                if (r3 == null) goto L14;
                return r3;
            L14:
                return new PointF(0.0f, 0.0f);
            L7:
                PointF r1 = r0.d;
                if (r1 == null) goto L11;
                r3 = r1;
                goto L11
            }

            public final float b(int r2, int r3, int r4, int r5) {
                j r6 = this.a;
                float r0 = 1.0f;
                if (r6.h == false) goto L12;
                Float r7 = r6.c;
                if (r7 == null) goto L7;
                float r8 = r7.floatValue();
            L10:
                r0 = r8;
            L11:
                this.a.c = null;
            L15:
                tt5.a.h("AreaCommentRender", "calculateScale: newW = " + r2 + ", newH = " + r3 + ", curScale=" + this.a.a + ", targetScale=" + r0);
                return r0;
            L7:
                Float r9 = r6.a;
                if (r9 == null) goto L11;
                r8 = r9.floatValue();
                goto L10
            L12:
                SubsamplingScaleImageView r10 = r6.l;
                if (r10 == null) goto L15;
                r0 = r10.getScale();
                goto L15
            }
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.areacomment.c.g
        public final void detach() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = false;
            Runnable r2 = this.g;
            if (r2 == null) goto L5;
            com.bytedance.ee.util.ui.j.e(r2);
            this.g = null;
        L5:
            this.h = false;
            SubsamplingScaleImageView.j r1 = this.i;
            this.i = null;
            SubsamplingScaleImageView r3 = this.l;
            if (r3 == null) goto L8;
            r3.setOnSizeChangedStrategy(r1);
        L8:
            this.k = null;
            this.l = null;
            tt5.a.h("AreaCommentRender", "CommentHeightHandler, detach");
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.areacomment.c.g
        public final void attach() {
            LargeImageView r0 = this.m.c.iF();
            if ((r0 instanceof LargeImageView) == false) goto L5;
            LargeImageView r1 = r0;
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            this.k = r1;
            SubsamplingScaleImageView r2 = r1.getScaleImageView();
            if (r2 != null) goto L11;
            return;
        L11:
            this.l = r2;
            this.i = r2.getOnSizeChangedStrategy();
            tt5.a.h("AreaCommentRender", "CommentHeightHandler, attach");
            return;
        L5:
            r1 = null;
            goto L6
        }

        public j(c r1) {
            this.m = r1;
            this.e = -1;
            this.j = new b(this);
        }

        @Override // com.bytedance.ee.bear.document.imageviewer.areacomment.c.g
        public final void a(n2 r7) {
            Intrinsics.checkNotNullParameter(r7, "event");
            LargeImageView r0 = this.m.c.iF();
            if ((r0 instanceof LargeImageView) == false) goto L5;
            LargeImageView r1 = r0;
        L7:
            if (r1 != null) goto L10;
        L23:
            LargeImageView r2 = this.m.i;
            if (r2 == null) goto L30;
            SubsamplingScaleImageView r3 = r2.getScaleImageView();
            if (r3 == null) goto L30;
            if (r3.u() != true) goto L30;
            boolean r4 = true;
        L31:
            if (r4 == false) goto L45;
            LargeImageView r5 = this.m.i;
            if (r5 == null) goto L37;
            SubsamplingScaleImageView r6 = r5.getScaleImageView();
            if (r6 == null) goto L37;
            float r8 = r6.getScale();
        L38:
            this.a = Float.valueOf(r8);
            LargeImageView r9 = this.m.i;
            if (r9 == null) goto L43;
            SubsamplingScaleImageView r10 = r9.getScaleImageView();
            if (r10 == null) goto L43;
            PointF r11 = r10.getCenter();
        L44:
            this.b = r11;
        L43:
            r11 = null;
        L37:
            r8 = 1.0f;
        L45:
            tt5.a.h("AreaCommentRender", "handleHeightChangeEvent: height = " + r7.a + ", lastHeight = " + this.e + ", curScale = " + this.a + ", curCenter = " + this.b + ", targetZoomScale = " + this.c);
            if (this.m.n != IImageViewer.ImageCommentMode.COMMENT_VIEW) goto L64;
            int r12 = r7.a;
            if (r12 == 0) goto L65;
            int r13 = this.e;
            if (r13 == (-1)) goto L54;
            if (r13 >= r12) goto L54;
            this.c = null;
        L54:
            if (this.f == true) goto L59;
            Runnable r14 = this.g;
            if (r14 == null) goto L58;
            com.bytedance.ee.util.ui.j.e(r14);
        L58:
            a r16 = new a(this, this.m);
            this.g = r16;
            com.bytedance.ee.util.ui.j.d(r16, 300);
        L59:
            ViewGroup r17 = this.m.c.getContainerView();
            if (r17 == null) goto L62;
            r17.setPadding(0, 0, 0, r7.a - this.m.p);
        L62:
            this.h = true;
            this.e = r7.a;
            return;
        L65:
            return;
        L64:
            return;
        L30:
            r4 = false;
            goto L31
        L10:
            if (Intrinsics.areEqual(r1, this.k) == true) goto L23;
            tt5.a.h("AreaCommentRender", "CommentHeightHandler, onHeightChange: view changed");
            detach();
            LargeImageView r18 = this.m.c.iF();
            if ((r18 instanceof LargeImageView) == false) goto L14;
            LargeImageView r19 = r18;
        L15:
            if (r19 == null) goto L23;
            this.k = r19;
            SubsamplingScaleImageView r20 = r19.getScaleImageView();
            if (r20 == null) goto L23;
            this.l = r20;
            this.i = r20.getOnSizeChangedStrategy();
            SubsamplingScaleImageView r21 = this.l;
            if (r21 == null) goto L23;
            r21.setOnSizeChangedStrategy(this.j);
            goto L23
        L14:
            r19 = null;
            goto L15
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class k implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public k(View r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "anim");
            Object r4 = r3.getAnimatedValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Int");
            int r5 = ((Integer) r4).intValue();
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            if (r0 == null) goto L6;
            View r1 = this.a;
            r0.height = r5;
            r1.setLayoutParams(r0);
            r1.requestLayout();
            return;
        }
    }

    static {
    }

    public final RectF c() {
        LargeImageView r0 = this.i;
        if (r0 == null) goto L5;
        ImageView r1 = r0.getImageView();
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        if (r2 == false) goto L17;
        RectF r3 = new RectF();
        Drawable r4 = r1.getDrawable();
        if (r4 != null) goto L15;
        return null;
    L15:
        r3.set(0.0f, 0.0f, r4.getIntrinsicWidth(), r4.getIntrinsicHeight());
        r1.getImageMatrix().mapRect(r3);
        return r3;
    L17:
        LargeImageView r5 = this.i;
        if (r5 == null) goto L23;
        SubsamplingScaleImageView r6 = r5.getScaleImageView();
        if (r6 != null) goto L22;
        return null;
    L22:
        return r6.getContentRect();
    L23:
        return null;
    L9:
        if (r1.getVisibility() != 0) goto L11;
        r2 = true;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final float d() {
        LargeImageView r0 = this.i;
        boolean r1 = false;
        if (r0 == null) goto L9;
        SubsamplingScaleImageView r2 = r0.getScaleImageView();
        if (r2 == null) goto L9;
        if (r2.u() != true) goto L9;
        r1 = true;
    L9:
        float r3 = 1.0f;
        if (r1 == false) goto L24;
        LargeImageView r4 = this.i;
        if (r4 == null) goto L16;
        SubsamplingScaleImageView r5 = r4.getScaleImageView();
        if (r5 == null) goto L16;
        float r6 = r5.getScale();
    L17:
        LargeImageView r7 = this.i;
        if (r7 == null) goto L23;
        SubsamplingScaleImageView r8 = r7.getScaleImageView();
        if (r8 == null) goto L23;
        r3 = r8.getMinScale();
    L23:
        return r6 / r3;
    L16:
        r6 = 1.0f;
        goto L17
    L24:
        return 1.0f;
    }

    public final boolean e() {
        LargeImageView r0 = this.i;
        boolean r1 = false;
        if (r0 == null) goto L9;
        SubsamplingScaleImageView r2 = r0.getScaleImageView();
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 0) goto L9;
        r1 = true;
    L9:
        tt5.a.h("AreaCommentRender", "isCurrentSSIV: " + r1);
        return r1;
    }

    public final void f() {
        ImageData.Image r1 = this.c.c7();
        LiveData<ImageDataModel> r2 = this.b.getImageData();
        if (r2 == null) goto L9;
        ImageDataModel r3 = (ImageDataModel) r2.getValue();
        if (r3 == null) goto L9;
        ImageData.Image r4 = r3.getImage();
        if (r4 == null) goto L9;
        String r5 = r4.getUuid();
    L10:
        if (r1 == null) goto L12;
        String r6 = r1.getUuid();
    L14:
        if (Intrinsics.areEqual(r5, r6) == false) goto L21;
        LiveData<ImageDataModel> r7 = this.b.getImageData();
        if (r7 == null) goto L20;
        ImageDataModel r8 = (ImageDataModel) r7.getValue();
        if (r8 == null) goto L20;
        r1 = r8.getImage();
    L41:
        ArrayList r9 = new ArrayList();
        if (r1 != null) goto L45;
        this.o.e.w(r9, null);
        tt5.a.h("AreaCommentRender", "notifyImageDataChange: image is null");
        return;
    L45:
        LiveData<ImageCardsData> r10 = this.b.getCardsData();
        if (r10 == null) goto L55;
        ImageCardsData r11 = (ImageCardsData) r10.getValue();
        if (r11 == null) goto L55;
        Map<String, CardCommentData> r12 = r11.getData();
        if (r12 == null) goto L55;
        CardCommentData r13 = r12.get(r1.getUuid());
        if (r13 == null) goto L55;
        List<Card> r14 = r13.getComments();
        if (r14 == null) goto L55;
    L56:
        Map<String, ImageData.Image.a> r16 = r1.getTransformAreaComments(Boolean.valueOf(e()));
        if (e() == false) goto L65;
        float[] r17 = {0.0f, 0.0f, 1.0f, 1.0f};
        com.bytedance.ee.bear.contract.imageviewer.bean.a r18 = r1.getLocalTransformerInfo();
        if (r18 == null) goto L61;
        ImageData.Image.a r19 = r18.c(r17, e());
    L62:
        if (r19 != null) goto L64;
        RectF r20 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    L66:
        Iterator<T> r21 = r14.iterator();
    L68:
        if (r21.hasNext() == false) goto L76;
        Card r22 = (Card) r21.next();
        if (r16 == null) goto L72;
        ImageData.Image.a r23 = r16.get(r22.getCommentId());
    L73:
        if (r23 != null) goto L74;
        CommentRectF r24 = new CommentRectF(r22.getCommentId(), 0.0f, 0.0f, 1.0f, 1.0f);
        r24.a = 3;
        r9.add(r24);
        goto L68
    L74:
        r9.add(new CommentRectF(r22.getCommentId(), r23.a, r23.b, r23.c, r23.d));
        goto L68
    L72:
        r23 = null;
        goto L73
    L76:
        this.o.e.w(r9, r20);
        return;
    L64:
        r20 = new RectF(r19.a, r19.b, r19.c, r19.d);
        goto L66
    L61:
        r19 = null;
        goto L62
    L65:
        r20 = null;
    L55:
        r14 = CollectionsKt.emptyList();
    L20:
        r1 = null;
        goto L41
    L21:
        LiveData<ImageDataModel> r26 = this.b.getImageData();
        if (r26 == null) goto L41;
        ImageDataModel r27 = (ImageDataModel) r26.getValue();
        if (r27 == null) goto L41;
        List<ImageData.Image> r28 = r27.getImageList();
        if (r28 == null) goto L41;
        Iterator<T> r29 = r28.iterator();
    L29:
        if (r29.hasNext() == false) goto L37;
        Object r30 = r29.next();
        String r31 = ((ImageData.Image) r30).getUuid();
        if (r1 == null) goto L33;
        String r32 = r1.getUuid();
    L35:
        if (Intrinsics.areEqual(r31, r32) == false) goto L29;
    L38:
        ImageData.Image r33 = (ImageData.Image) r30;
        if (r33 == null) goto L41;
        r1 = r33;
        goto L41
    L33:
        r32 = null;
        goto L35
    L37:
        r30 = null;
        goto L38
    L12:
        r6 = null;
    L9:
        r5 = null;
        goto L10
    }

    public final void h() {
        tt5.a.h("AreaCommentRender", "restoreImageViewerHeight, isVC = " + this.e);
        if (this.e == false) goto L23;
        ViewGroup r0 = this.c.getContainerView();
        if (r0 == null) goto L8;
        r0.setPadding(0, 0, 0, 0);
    L8:
        if (this.t == false) goto L22;
        ValueAnimator r1 = this.r;
        if (r1 == null) goto L12;
        r1.cancel();
    L12:
        ViewGroup r2 = this.c.getContainerView();
        if (r2 == null) goto L22;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L22;
        r3.height = -1;
        ViewGroup r4 = this.c.getContainerView();
        if (r4 == null) goto L19;
        r4.setLayoutParams(r3);
    L19:
        ViewGroup r5 = this.c.getContainerView();
        if (r5 == null) goto L22;
        r5.requestLayout();
    L22:
        this.t = false;
        return;
    L23:
        ViewGroup r6 = this.c.getContainerView();
        if (r6 == null) goto L35;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L36;
        r7.height = -1;
        ViewGroup r8 = this.c.getContainerView();
        if (r8 == null) goto L30;
        r8.setLayoutParams(r7);
    L30:
        ViewGroup r9 = this.c.getContainerView();
        if (r9 == null) goto L37;
        r9.requestLayout();
        return;
    L37:
        return;
    L36:
        return;
    }

    public final Context getContext() {
        return this.a;
    }

    public final void g(View r4) {
        com.bytedance.ee.bear.document.imageviewer.areacomment.a r0 = this.m;
        if (r0.f.isAttachedToWindow() == true) goto L5;
    L9:
        if (r4 != null) goto L12;
        tt5.a.h("AreaCommentRender", "onPageSelected: contentView is null");
        return;
    L12:
        LargeImageView r1 = this.i;
        if (r1 == null) goto L17;
        SubsamplingScaleImageView r2 = r1.getScaleImageView();
        if (r2 == null) goto L17;
        r2.setOnMatrixChangeListener(null);
    L17:
        this.i = null;
        if ((r4 instanceof LargeImageView) == false) goto L31;
        LargeImageView r5 = (LargeImageView) r4;
        this.i = r5;
        SubsamplingScaleImageView r6 = r5.getScaleImageView();
        if (r6 == null) goto L23;
        r6.setOnMatrixChangeListener(this.j);
    L23:
        if (this.f == false) goto L29;
        LargeImageView r7 = this.i;
        if (r7 == null) goto L29;
        SubsamplingScaleImageView r8 = r7.getScaleImageView();
        if (r8 == null) goto L29;
        r8.setOnScaleEventListener(this.k);
    L29:
        com.bytedance.ee.util.ui.j.d(this.q, 50);
        f();
        return;
    L31:
        return;
    L5:
        if (Intrinsics.areEqual(r0.l, r0.b.iF()) == true) goto L9;
        ViewGroup r3 = r0.b.getContainerView();
        if (r3 == null) goto L9;
        r3.removeView(r0.f);
        goto L9
    }

    public final void b(RectF r6, float r7) {
        Intrinsics.checkNotNullParameter(r6, "rect");
        CommentRectLayout r0 = this.o.e;
        boolean r3 = true;
        if (r6.height() != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L13:
        r3 = false;
    L14:
        r0.setCommentRectVisible(r3);
        this.o.e.e(r6, r7);
        return;
    L8:
        if (r6.width() != 0.0f) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
    L10:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    public final void a(int r3, int r4, View r5) {
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{r3, r4});
        r6.setDuration(100);
        r6.addUpdateListener(new k(r5));
        r6.start();
        this.r = r6;
    }

    public c(Context r16, ImageViewerViewModel r17, IImageViewer r18, ImageViewerPlugin r19, CommentPlugin r20) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r17, "imageViewerViewModel");
        Intrinsics.checkNotNullParameter(r18, "imageViewer");
        Intrinsics.checkNotNullParameter(r19, "imageViewerPlugin");
        Intrinsics.checkNotNullParameter(r20, "commentPlugin");
        this.a = r16;
        this.b = r17;
        this.c = r18;
        this.d = r20;
        com.bytedance.ee.bear.appsetting.c r1 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r2 = r1.h("ccm.mobile.support_img_zoom_when_area_mark");
        boolean r3 = r1.h("ccm.mobile.shrink_comment_panel_when_zoom_in");
        boolean r10 = false;
        if (r19.getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L5;
        boolean r12 = true;
    L6:
        this.e = r12;
        boolean r4 = r1.h("ccm.mobile.area_comment_polish_for_ms");
        if (r3 == false) goto L11;
        if (r12 == false) goto L10;
        if (r4 == false) goto L11;
    L10:
        boolean r13 = true;
    L12:
        this.f = r13;
        if (r2 == false) goto L17;
        if (r12 == false) goto L16;
        if (r4 == false) goto L17;
    L16:
        r10 = true;
    L17:
        this.g = r10;
        com.bytedance.ee.bear.document.comment.e r11 = r20.getCommentStateDispatcher();
        this.h = r11;
        this.m = new com.bytedance.ee.bear.document.imageviewer.areacomment.a(r16, r18, r19, r20, r10);
        this.n = IImageViewer.ImageCommentMode.EXIT;
        com.bytedance.ee.bear.document.imageviewer.areacomment.e r5 = new com.bytedance.ee.bear.document.imageviewer.areacomment.e(r16, r18, r20);
        this.o = r5;
        this.p = n.d(22);
        if (r13 == false) goto L20;
        g r6 = new j(this);
    L21:
        this.v = r6;
        tt5.a.h("AreaCommentRender", "attachView: init, isZoomEnabled: " + r10 + ", isShrinkEnabled: " + r13 + ", isVC = " + r12);
        this.q = new a(this);
        this.j = new b(this);
        this.k = new C0079c(this);
        d r7 = new d(this);
        this.l = r7;
        ((com.bytedance.ee.bear.document.comment.d) r11).c(r7);
        r5.e.addOnLayoutChangeListener(new e(this));
        if (r10 == false) goto L25;
        r18.LN(new f(this));
        return;
    L25:
        return;
    L20:
        r6 = new i(this);
    L11:
        r13 = false;
        goto L12
    L5:
        r12 = false;
        goto L6
    }
}
