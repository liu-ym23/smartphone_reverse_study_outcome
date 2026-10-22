package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CommentImageShowSource;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAreaMark;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentAreaMarkLayout;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.l0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f231662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IImageViewer f231663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AreaMarkMode f231664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f231665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.p f231666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z f231667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f231668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f231669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommentBean f231670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CommentImageShowSource f231671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CommentAreaMarkLayout.AreaMarkMode f231672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f231673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CommentAreaMarkLayout f231674m;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a$a, reason: collision with other inner class name */
    public static final class C3315a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f231675a = null;

        static {
            int[] r100 = new int[AreaMarkMode.values().length];
            r100[AreaMarkMode.EDIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AreaMarkMode.READ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f231675a = r100;
        }
    }

    public static final class c implements uw4.d, sa5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f231676a;

        @Override // uw4.d, sa5.d
        public final boolean onBackPressed() {
            tt5.a.h("CommentImageAreaMarkRender", "onBackPressed");
            IImageViewer r100 = this.f231676a.f231663b;
            if (r100 == null) goto L9;
            ViewGroup r101 = r100.getContainerView();
            if (r101 == null) goto L10;
            r101.removeView(this.f231676a.f231674m);
            return true;
        L10:
            return true;
        L9:
            return true;
        }

        public c(a r100) {
            this.f231676a = r100;
        }
    }

    public static final class d implements CommentRectLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f231677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f231678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VFSPath f231679c;

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final /* synthetic */ void a() {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void d(boolean r100) {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void c() {
            tt5.a.h("CommentImageAreaMarkRender", "onCloseBtnClick");
            this.f231677a.getClass();
            IImageViewer r100 = this.f231677a.f231663b;
            if (r100 == null) goto L8;
            ViewGroup r101 = r100.getContainerView();
            if (r101 == null) goto L9;
            r101.removeView(this.f231677a.f231674m);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void e() {
            tt5.a.h("CommentImageAreaMarkRender", "onInputTextClick");
            CommentRectF r100 = this.f231677a.f231674m.getCurrentAreaRect();
            if (r100 != null) goto L6;
            tt5.a.k("CommentImageAreaMarkRender", "onInputTextClick, newRect is null");
            return;
        L6:
            a r101 = this.f231677a;
            View r102 = this.f231678b;
            VFSPath r103 = this.f231679c;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
            Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r103, "path");
            CommentAreaMarkLayout r104 = (CommentAreaMarkLayout) r102.findViewWithTag("comment_area_mark_layout");
            if (r104 != null) goto L9;
            tt5.a.k("CommentImageAreaMarkRender", "handleCreate: showAreaMarkLayout is null");
            return;
        L9:
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r105 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r104.getTag(R.id.comment_image_entity);
            if (r105 != null) goto L12;
            tt5.a.k("CommentImageAreaMarkRender", "handleCreate: imageEntity is null");
            return;
        L12:
            tt5.a.h("CommentImageAreaMarkRender", "handleCreate: imageEntity=" + r105 + ", path=" + r103);
            r101.f231666e.getClass();
            String r106 = com.bytedance.ee.bear.middleground.comment.p.a();
            String r107 = "";
            if (r106 != null) goto L15;
            r106 = "";
        L15:
            r101.f231666e.getClass();
            String r108 = com.bytedance.ee.bear.middleground.comment.p.b();
            if (r108 == null) goto L19;
            r107 = r108;
        L19:
            tt5.a.h("CommentImageAreaMarkRender", "handleCreate: userId=" + r106 + ", userName=" + r107);
            CommentAreaMark r109 = new CommentAreaMark();
            r109.setAreaData(new float[]{((RectF) r100).left, ((RectF) r100).top, ((RectF) r100).right, ((RectF) r100).bottom});
            r109.setCreateTimeStamp(System.currentTimeMillis());
            r109.setAreaUUID(l0.a().toString());
            r109.setUserId(r106);
            r109.setUserName(r107);
            int r110 = b.f231675a[r101.f231664c.ordinal()];
            if (r110 == 1) goto L28;
            if (r110 != 2) goto L27;
            tt5.a.b("CommentImageAreaMarkRender", "handleCreate: READ, close image viewer");
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r111 = r105.copy();
            r111.getAreaMark().add(r109);
            r101.c();
            IImageViewer r112 = r101.f231663b;
            if (r112 == null) goto L25;
            r112.close();
        L25:
            tt5.a.b("CommentImageAreaMarkRender", "handleCreate: READ, insert reply from area mark");
            z r113 = r101.f231667f;
            Intrinsics.checkNotNull(r111);
            r113.Q(r111, r103, r101.f231668g, r101.f231669h, r101.f231670i, r101.f231671j);
            return;
        L27:
            throw new NoWhenBranchMatchedException();
        L28:
            ArrayList<CommentAreaMark> r114 = r105.getAreaMark();
            r114.add(r109);
            r105.setAreaMark(r114);
            IImageViewer r115 = r101.f231663b;
            if (r115 == null) goto L33;
            ViewGroup r116 = r115.getContainerView();
            if (r116 == null) goto L33;
            r116.removeView(r101.f231674m);
        L33:
            tt5.a.h("CommentImageAreaMarkRender", "handleCreate: EDIT, exit create mode and refresh");
            a.d(r104, r105, r109);
        }

        public d(a r100, View r101, VFSPath r102) {
            this.f231677a = r100;
            this.f231678b = r101;
            this.f231679c = r102;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f231680a;

        public e(a r100) {
            this.f231680a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("CommentImageAreaMarkRender", "showReadyAddComment: post");     // Catch: Throwable -> L4
            this.f231680a.f231674m.u();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        this.f231674m.setCommentRectVisible(false);
        if (this.f231674m.getParent() == null) goto L10;
        tt5.a.k("CommentImageAreaMarkRender", "hideCommentAreaMark, remove from container");
        IImageViewer r100 = this.f231663b;
        if (r100 == null) goto L11;
        ViewGroup r101 = r100.getContainerView();
        if (r101 == null) goto L12;
        r101.removeView(this.f231674m);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static float b(LargeImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "largeImageView");
        SubsamplingScaleImageView r101 = r100.getScaleImageView();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.u() != true) goto L7;
    L8:
        float r103 = 1.0f;
        if (r102 == false) goto L19;
        SubsamplingScaleImageView r104 = r100.getScaleImageView();
        if (r104 == null) goto L13;
        float r105 = r104.getScale();
    L14:
        SubsamplingScaleImageView r106 = r100.getScaleImageView();
        if (r106 == null) goto L18;
        r103 = r106.getMinScale();
    L18:
        return r105 / r103;
    L13:
        r105 = 1.0f;
        goto L14
    L19:
        return 1.0f;
    L7:
        r102 = false;
        goto L8
    }

    public static void a(CommentAreaMarkLayout r100, RectF r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "showAreaMarkLayout");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        boolean r103 = true;
        if (r101.width() != 0.0f) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L9;
    L19:
        tt5.a.k("CommentImageAreaMarkRender", "attachView: skip zero-sized rect=" + r101);
        r100.setCommentRectVisible(false);
        return;
    L9:
        if (r101.height() == 0.0f) goto L12;
        r103 = false;
    L12:
        if (r103 == true) goto L19;
        tt5.a.h("CommentImageAreaMarkRender", "attachView: rect=" + r101 + ", scale=" + r102);
        if (r100.f236798n == true) goto L17;
        r100.setCommentRectVisible(false);
    L17:
        r100.e(r101, r102);
        return;
    L5:
        r104 = false;
        goto L7
    }

    public static void d(CommentAreaMarkLayout r110, CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r111, CommentAreaMark r112) {
        StringBuilder r100 = new StringBuilder("notifyImageDataChange image:");
        ArrayList<CommentAreaMark> r101 = r111.getAreaMark();
        CommentRectF r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.size());
    L6:
        r100.append(r103);
        tt5.a.h("CommentImageAreaMarkRender", r100.toString());
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r111.getAreaMark().iterator();
        CommentRectF r106 = null;
    L7:
        boolean r107 = true;
        if (r105.hasNext() == false) goto L16;
        CommentAreaMark r108 = (CommentAreaMark) r105.next();
        CommentRectF r109 = new CommentRectF(r108.getAreaData()[0], r108.getAreaData()[1], r108.getAreaData()[2], r108.getAreaData()[3]);
        r109.f236777d = r108.getCreateTimeStamp();
        r109.f236774a = 5;
        r109.f236779f = r108.getUserName();
        r109.f236780g = r108.getUserId();
        r109.f236781h = r108.getAreaUUID();
        r104.add(r109);
        if (r112 == null) goto L12;
        String r113 = r112.getAreaUUID();
    L14:
        if (Intrinsics.areEqual(r113, r109.f236781h) == false) goto L7;
        r106 = r109;
        goto L7
    L12:
        r113 = null;
        goto L14
    L16:
        String r114 = r111.getUuid();
        if (r114 != null) goto L19;
    L22:
        boolean r115 = true;
    L23:
        if (r115 == false) goto L25;
        String r116 = r111.getToken();
    L26:
        if (r116 != null) goto L28;
    L31:
        boolean r117 = true;
    L32:
        if (r117 == false) goto L34;
        tt5.a.k("CommentImageAreaMarkRender", "notifyImageDataChange, image token is empty");
        r116 = "";
    L34:
        if (r110 == null) goto L79;
        if (r106 == null) goto L37;
        String r118 = r106.f236781h;
    L38:
        Intrinsics.checkNotNullParameter(r104, "commentRectFList");
        if (r118 != null) goto L41;
        r110.f236763k0 = null;
    L41:
        String r119 = r110.W;
        if (r119 == null) goto L48;
        if (r119.length() == 0) goto L48;
        r107 = false;
    L48:
        if (r107 == false) goto L50;
        r110.W = r116;
        tt5.a.h("CommentAreaMarkLayout", "updateComment: " + r116);
    L50:
        r110.w(r104, null);
        if (r118 != null) goto L53;
        return;
    L53:
        if (TextUtils.isEmpty(r118) == false) goto L55;
        tt5.a.h("CommentAreaMarkLayout", "highlightRectF: areaUUID is empty");
    L69:
        r110.f236763k0 = r102;
        return;
    L55:
        Iterator<T> r120 = r110.f236786b.iterator();
    L57:
        if (r120.hasNext() == false) goto L61;
        Object r121 = r120.next();
        if (TextUtils.equals(((CommentRectF) r121).f236781h, r118) == false) goto L57;
    L62:
        CommentRectF r122 = (CommentRectF) r121;
        if (r122 == null) goto L69;
        r110.f236763k0 = r122;
        CommentRectLayout.b r123 = r110.f236784J;
        if (r123 == null) goto L68;
        r123.invalidate();
    L68:
        r102 = r122;
        goto L69
    L61:
        r121 = null;
        goto L62
    L37:
        r118 = null;
        goto L38
    L79:
        return;
    L28:
        if (r116.length() == 0) goto L31;
        r117 = false;
        goto L32
    L25:
        r116 = r111.getUuid();
        goto L26
    L19:
        if (r114.length() == 0) goto L22;
        r115 = false;
        goto L23
    L5:
        r103 = null;
        goto L6
    }

    public static void f(String r100, int r101, View r102) {
        tt5.a.h("CommentImageAreaMarkRender", "onSwipe uuid:" + du5.b.h(r100) + ", index:" + r101 + ", currContentView:" + r102);
        if (r102 != null) goto L6;
        tt5.a.k("CommentImageAreaMarkRender", "onSwipe: currContentView is null");
        return;
    L6:
        Object r103 = r102.getParent();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.View");
        CommentAreaMarkLayout r104 = (CommentAreaMarkLayout) ((View) r103).findViewWithTag("comment_area_mark_layout");
        if (r104 != null) goto L10;
        tt5.a.k("CommentImageAreaMarkRender", "onSwipe: showAreaMarkLayout is null");
        return;
    L10:
        r104.f236763k0 = null;
        CommentRectLayout.b r105 = r104.f236784J;
        if (r105 == null) goto L14;
        r105.invalidate();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, android.widget.FrameLayout, com.bytedance.ee.bear.scaleimageview.areacomment.CommentAreaMarkLayout] */
    public final void e(String r110, ViewGroup r111, LargeImageView r112) {
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark uuid:" + du5.b.h(r110) + ", container:" + r111 + ", currPageSubView:" + r112);
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L98;
        if (r111 == null) goto L98;
        if (r112 == null) goto L98;
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = r111.findViewWithTag("comment_area_mark_layout");
        r102.element = r103;
        if (r103 != 0) goto L39;
        ?? r104 = new CommentAreaMarkLayout(this.f231662a.getActivity());
        r104.setTag("comment_area_mark_layout");
        r102.element = r104;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r105 = this.f231665d;
        if (r105 == null) goto L37;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L29;
        Object r107 = r106.next();
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r108 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r107;
        if (Intrinsics.areEqual(r108.getToken(), r110) == false) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L19;
    L30:
        final CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r113 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r107;
        if (r113 == null) goto L37;
        ((CommentAreaMarkLayout) r102.element).setTag(R.id.comment_area_mark_layout, r110);
        ((CommentAreaMarkLayout) r102.element).setTag(R.id.comment_image_entity, r113);
        SubsamplingScaleImageView r114 = r112.getScaleImageView();
        if (r114 == null) goto L36;
        r114.setOnMatrixChangeListener(new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.d(this, r102, r112));
    L36:
        CommentAreaMarkLayout r115 = (CommentAreaMarkLayout) r102.element;
        r115.setClickable(false);
        r115.setCommentRectVisible(true);
        r115.setAreaMarkMode(this.f231672k);
        r115.setOnTouchListener(new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.c(r115, this));
        r115.setCommentAreaMarkClickListener(new CommentImageAreaMarkRender$initShowLayout$2(r113, this));
        r111.addView((View) r102.element);
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: create new CommentAreaMarkLayout and add to container");
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: " + r113);
        d((CommentAreaMarkLayout) r102.element, r113, null);
    L40:
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: showAreaMarkLayout=" + r102.element);
        CommentAreaMarkLayout r116 = (CommentAreaMarkLayout) r102.element;
        Intrinsics.checkNotNullParameter(r116, "showAreaMarkLayout");
        Intrinsics.checkNotNullParameter(r112, "largeImageView");
        if (r113 != null) goto L43;
        tt5.a.k("CommentImageAreaMarkRender", "refresh, but imageEntity is null");
        return;
    L43:
        tt5.a.h("CommentImageAreaMarkRender", "refresh imageEntity:" + r116.getImageUUID());
        SubsamplingScaleImageView r117 = r112.getScaleImageView();
        ImageView r118 = r112.getImageView();
        tt5.a.h("CommentImageAreaMarkRender", "getRect: ");
        if (r117 != null) goto L46;
    L48:
        boolean r119 = false;
    L50:
        if (r119 == true) goto L52;
    L68:
        if (r118 != null) goto L70;
    L72:
        boolean r120 = false;
    L73:
        if (r120 == false) goto L90;
        Drawable r121 = r118.getDrawable();
        if (r121 != null) goto L77;
        tt5.a.k("CommentImageAreaMarkRender", "getRect: ImageView drawable is null");
    L93:
        RectF r122 = null;
    L94:
        if (r122 == null) goto L96;
        a(r116, r122, b(r112));
    L96:
        d(r116, r113, null);
        return;
    L77:
        RectF r123 = new RectF(0.0f, 0.0f, r121.getIntrinsicWidth(), r121.getIntrinsicHeight());
        r118.getImageMatrix().mapRect(r123);
        tt5.a.h("CommentImageAreaMarkRender", "getRect: use ImageView mapped rect=" + r123 + ", iv.left=" + r118.getLeft() + ", iv.top=" + r118.getTop());
        r123.offset((float) r118.getLeft(), (float) r118.getTop());
        tt5.a.h("CommentImageAreaMarkRender", "getRect: use ImageView mapped+offset rect=" + r123 + " (iv.left=" + r118.getLeft() + ", iv.top=" + r118.getTop() + ')');
        if (r123.width() != 0.0f) goto L80;
        boolean r124 = true;
    L81:
        if (r124 == false) goto L83;
    L89:
        tt5.a.k("CommentImageAreaMarkRender", "getRect: ImageView rect is zero-sized (possibly intermediate): " + r123);
        goto L93
    L83:
        if (r123.height() == 0.0f) goto L86;
        r100 = false;
    L86:
        if (r100 == true) goto L89;
        r122 = r123;
        goto L94
    L80:
        r124 = false;
        goto L81
    L90:
        RectF r125 = r117.getContentRect();
        tt5.a.h("CommentImageAreaMarkRender", "getRect: fallback to SSV=" + r125);
        if (r125 == null) goto L93;
        r122 = new RectF(r125);
        goto L94
    L70:
        if (r118.getVisibility() != 0) goto L72;
        r120 = true;
        goto L73
    L52:
        if (r117.u() == false) goto L68;
        RectF r126 = r117.getContentRect();
        if (r126 != null) goto L56;
    L67:
        tt5.a.k("CommentImageAreaMarkRender", "getRect: ssv content rect is empty: " + r126);
        goto L93
    L56:
        if (r126.width() != 0.0f) goto L58;
        boolean r127 = true;
    L59:
        if (r127 == true) goto L67;
        if (r126.height() == 0.0f) goto L64;
        r100 = false;
    L64:
        if (r100 == true) goto L67;
        tt5.a.h("CommentImageAreaMarkRender", "getRect: use SSV contentRect=" + r126);
        r122 = new RectF(r126);
        goto L94
    L58:
        r127 = false;
        goto L59
    L46:
        if (r117.getVisibility() != 0) goto L48;
        r119 = true;
        goto L50
    L23:
        if (Intrinsics.areEqual(r108.getUuid(), r110) == true) goto L26;
        r109 = false;
        goto L27
    L29:
        r107 = null;
    L37:
        tt5.a.k("CommentImageAreaMarkRender", "onLoadCommentAreaMark imageEntity is null, uuid=" + r110);
        return;
    L39:
        r113 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) ((CommentAreaMarkLayout) r103).getTag(R.id.comment_image_entity);
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: reuse existing CommentAreaMarkLayout from container");
    L98:
        tt5.a.k("CommentImageAreaMarkRender", "onLoadCommentAreaMark uuid or container or currPageSubView is null");
        return;
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void g(View r100, View r101, VFSPath r102) {
        tt5.a.h("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView, enter create mode, view = " + r100 + ", container = " + r101 + ", path = " + r102);
        if (r100 == null) goto L69;
        if (r101 == null) goto L69;
        if (r102 == null) goto L69;
        this.f231674m.setCommentClickListener(new d(this, r101, r102));
        IImageViewer r103 = this.f231663b;
        Bitmap r104 = null;
        if (r103 == null) goto L10;
        ImageData.Image r105 = r103.c7();
    L11:
        if (r105 != null) goto L15;
        tt5.a.k("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView image is null");
        return;
    L15:
        if ((r100 instanceof LargeImageView) == false) goto L17;
        LargeImageView r106 = (LargeImageView) r100;
    L18:
        tt5.a.h("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView, image=" + r105);
        if (r106 != null) goto L21;
        tt5.a.k("CommentImageAreaMarkRender", "showReadyAddComment: largeImageView is null");
    L49:
        if (r104 != null) goto L71;
        tt5.a.h("CommentImageAreaMarkRender", "showReadyAddComment: bitmap is null");
        return;
    L71:
        this.f231674m.t(ContextCompat.getColor(this.f231662a.getActivity(), R.color.static_black), r104);     // Catch: Exception -> L66
        if (this.f231674m.getParent() == null) goto L59;
        tt5.a.k("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView view is attached");     // Catch: Exception -> L66
        IImageViewer r107 = this.f231663b;     // Catch: Exception -> L66
        if (r107 == null) goto L59;
        ViewGroup r108 = r107.getContainerView();     // Catch: Exception -> L66
        if (r108 == null) goto L59;
        r108.removeView(this.f231674m);     // Catch: Exception -> L66
    L59:
        IImageViewer r109 = this.f231663b;     // Catch: Exception -> L66
        if (r109 == null) goto L64;
        ViewGroup r110 = r109.getContainerView();     // Catch: Exception -> L66
        if (r110 == null) goto L64;
        r110.addView(this.f231674m);     // Catch: Exception -> L66
    L64:
        this.f231674m.post(new e(this));     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        tt5.a.e("CommentImageAreaMarkRender", "showReadyAddComment: ", e, false);
        return;
    L21:
        ImageView r111 = r106.getImageView();
        Intrinsics.checkNotNull(r111);
        boolean r112 = true;
        if (r111.getVisibility() != 0) goto L24;
        boolean r113 = true;
    L25:
        if (r113 == true) goto L27;
    L33:
        SubsamplingScaleImageView r114 = r106.getScaleImageView();
        if (r114 != null) goto L36;
    L38:
        r112 = false;
    L39:
        if (r112 == true) goto L41;
        tt5.a.h("CommentImageAreaMarkRender", "showReadyAddComment: does not have image");
        goto L49
    L41:
        Bitmap r115 = r114.getImageBitmap();
        if (r115 == null) goto L49;
        Bitmap r116 = r114.getImageBitmap();
        if (r116 == null) goto L47;
        Bitmap.Config r117 = r116.getConfig();
        if (r117 == null) goto L47;
    L48:
        r104 = r115.copy(r117, false);
    L47:
        r117 = Bitmap.Config.ARGB_8888;
        goto L48
    L36:
        if (r114.u() != true) goto L38;
    L27:
        if (r111.getDrawable() == null) goto L33;
        if (r111.getDrawable().getIntrinsicWidth() <= 0) goto L49;
        if (r111.getDrawable().getIntrinsicHeight() <= 0) goto L49;
        r104 = Bitmap.createBitmap(r111.getDrawable().getIntrinsicWidth(), r111.getDrawable().getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        r111.getDrawable().draw(new Canvas(r104));
        goto L49
    L24:
        r113 = false;
        goto L25
    L17:
        r106 = null;
        goto L18
    L10:
        r105 = null;
    L69:
        tt5.a.k("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView, param is null");
    }

    public /* synthetic */ a(p r110, IImageViewer r111, AreaMarkMode r112, List r113, com.bytedance.ee.bear.middleground.comment.p r114, z r115, String r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, null, null);
    }

    public a(p r100, IImageViewer r101, AreaMarkMode r102, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r103, com.bytedance.ee.bear.middleground.comment.p r104, z r105, String r106, String r107, CommentBean r110, CommentImageShowSource r111) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "mAreaMarkMode");
        Intrinsics.checkNotNullParameter(r104, "commentServiceImpl");
        Intrinsics.checkNotNullParameter(r105, "commentListeners");
        this.f231662a = r100;
        this.f231663b = r101;
        this.f231664c = r102;
        this.f231665d = r103;
        this.f231666e = r104;
        this.f231667f = r105;
        this.f231668g = r106;
        this.f231669h = r107;
        this.f231670i = r110;
        this.f231671j = r111;
        int r108 = b.f231675a[r102.ordinal()];
        if (r108 == 1) goto L8;
        if (r108 != 2) goto L7;
        CommentAreaMarkLayout.AreaMarkMode r109 = CommentAreaMarkLayout.AreaMarkMode.READ;
    L9:
        this.f231672k = r109;
        this.f231673l = new c(this);
        CommentAreaMarkLayout r112 = new CommentAreaMarkLayout(r100.getActivity());
        this.f231674m = r112;
        r112.setClickable(true);
        r112.setAreaMarkMode(r109);
        Drawable r113 = AppCompatResources.getDrawable(r100.getActivity(), R.drawable.ud_icon_done_large_outlined);
        String r114 = r100.getActivity().getString(r102.getCreateTextRes());
        r112.H.setSingleLine(true);
        r112.H.setEllipsize(TextUtils.TruncateAt.END);
        r112.H.setIncludeFontPadding(false);
        r112.H.setAllCaps(false);
        r112.H.setMinHeight(n.d(36));
        if (r113 == null) goto L12;
        DrawableCompat.setTintList(r113, new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_hovered}, new int[0]}, new int[]{ContextCompat.getColor(r112.getContext(), R.color.function_success_content_pressed), ContextCompat.getColor(r112.getContext(), R.color.function_success_content_hover), ContextCompat.getColor(r112.getContext(), R.color.function_success_content_default)}));
        r113.setBounds(0, 0, n.d(14), n.d(14));
    L12:
        r112.H.setPadding(n.d(16), n.d(12), n.d(16), n.d(12));
        r112.H.setGravity(17);
        r112.H.setCompoundDrawablePadding(n.d(8));
        r112.H.setCompoundDrawablesRelativeWithIntrinsicBounds(r113, null, null, null);
        if (r114 == null) goto L15;
        r112.H.setText(r114);
    L15:
        r112.addOnAttachStateChangeListener(new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.b(this));
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r109 = CommentAreaMarkLayout.AreaMarkMode.EDIT;
        goto L9
    }
}
