package com.bytedance.ee.bear.middleground.comment.imageviewer.areamark;

import android.R;
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
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final p a;
    public final IImageViewer b;
    public final AreaMarkMode c;
    public List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> d;
    public final com.bytedance.ee.bear.middleground.comment.p e;
    public final z f;
    public final String g;
    public final String h;
    public final CommentBean i;
    public CommentImageShowSource j;
    public final CommentAreaMarkLayout.AreaMarkMode k;
    public final c l;
    public final CommentAreaMarkLayout m;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.a$a, reason: collision with other inner class name */
    public static final class C0068a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AreaMarkMode.values().length];
            r0[AreaMarkMode.EDIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AreaMarkMode.READ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements uw4.d, sa5.d {
        public final /* synthetic */ a a;

        public final boolean onBackPressed() {
            tt5.a.h("CommentImageAreaMarkRender", "onBackPressed");
            IImageViewer r0 = this.a.b;
            if (r0 == null) goto L9;
            ViewGroup r1 = r0.getContainerView();
            if (r1 == null) goto L10;
            r1.removeView(this.a.m);
            return true;
        L10:
            return true;
        L9:
            return true;
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    public static final class d implements CommentRectLayout.c {
        public final /* synthetic */ a a;
        public final /* synthetic */ View b;
        public final /* synthetic */ VFSPath c;

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final /* synthetic */ void a() {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void d(boolean r1) {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void onTouchEvent(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void c() {
            tt5.a.h("CommentImageAreaMarkRender", "onCloseBtnClick");
            this.a.getClass();
            IImageViewer r0 = this.a.b;
            if (r0 == null) goto L8;
            ViewGroup r1 = r0.getContainerView();
            if (r1 == null) goto L9;
            r1.removeView(this.a.m);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void e() {
            tt5.a.h("CommentImageAreaMarkRender", "onInputTextClick");
            CommentRectF r1 = this.a.m.getCurrentAreaRect();
            if (r1 != null) goto L6;
            tt5.a.k("CommentImageAreaMarkRender", "onInputTextClick, newRect is null");
            return;
        L6:
            a r2 = this.a;
            View r3 = this.b;
            VFSPath r6 = this.c;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r1, "rect");
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r6, "path");
            CommentAreaMarkLayout r4 = (CommentAreaMarkLayout) r3.findViewWithTag("comment_area_mark_layout");
            if (r4 != null) goto L9;
            tt5.a.k("CommentImageAreaMarkRender", "handleCreate: showAreaMarkLayout is null");
            return;
        L9:
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r5 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r4.getTag(2131367360);
            if (r5 != null) goto L12;
            tt5.a.k("CommentImageAreaMarkRender", "handleCreate: imageEntity is null");
            return;
        L12:
            tt5.a.h("CommentImageAreaMarkRender", "handleCreate: imageEntity=" + r5 + ", path=" + r6);
            r2.e.getClass();
            String r7 = com.bytedance.ee.bear.middleground.comment.p.a();
            String r8 = "";
            if (r7 != null) goto L15;
            r7 = "";
        L15:
            r2.e.getClass();
            String r9 = com.bytedance.ee.bear.middleground.comment.p.b();
            if (r9 == null) goto L19;
            r8 = r9;
        L19:
            tt5.a.h("CommentImageAreaMarkRender", "handleCreate: userId=" + r7 + ", userName=" + r8);
            CommentAreaMark r10 = new CommentAreaMark();
            r10.setAreaData(new float[]{((RectF) r1).left, ((RectF) r1).top, ((RectF) r1).right, ((RectF) r1).bottom});
            r10.setCreateTimeStamp(System.currentTimeMillis());
            r10.setAreaUUID(l0.a().toString());
            r10.setUserId(r7);
            r10.setUserName(r8);
            int r11 = b.a[r2.c.ordinal()];
            if (r11 == 1) goto L28;
            if (r11 != 2) goto L27;
            tt5.a.b("CommentImageAreaMarkRender", "handleCreate: READ, close image viewer");
            CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r12 = r5.copy();
            r12.getAreaMark().add(r10);
            r2.c();
            IImageViewer r13 = r2.b;
            if (r13 == null) goto L25;
            r13.close();
        L25:
            tt5.a.b("CommentImageAreaMarkRender", "handleCreate: READ, insert reply from area mark");
            z r14 = r2.f;
            Intrinsics.checkNotNull(r12);
            r14.Q(r12, r6, r2.g, r2.h, r2.i, r2.j);
            return;
        L27:
            throw new NoWhenBranchMatchedException();
        L28:
            ArrayList<CommentAreaMark> r15 = r5.getAreaMark();
            r15.add(r10);
            r5.setAreaMark(r15);
            IImageViewer r16 = r2.b;
            if (r16 == null) goto L33;
            ViewGroup r17 = r16.getContainerView();
            if (r17 == null) goto L33;
            r17.removeView(r2.m);
        L33:
            tt5.a.h("CommentImageAreaMarkRender", "handleCreate: EDIT, exit create mode and refresh");
            a.d(r4, r5, r10);
        }

        public d(a r1, View r2, VFSPath r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("CommentImageAreaMarkRender", "showReadyAddComment: post");     // Catch: Throwable -> L4
            this.a.m.u();     // Catch: Throwable -> L4
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
        this.m.setCommentRectVisible(false);
        if (this.m.getParent() == null) goto L10;
        tt5.a.k("CommentImageAreaMarkRender", "hideCommentAreaMark, remove from container");
        IImageViewer r0 = this.b;
        if (r0 == null) goto L11;
        ViewGroup r1 = r0.getContainerView();
        if (r1 == null) goto L12;
        r1.removeView(this.m);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static float b(LargeImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "largeImageView");
        SubsamplingScaleImageView r0 = r2.getScaleImageView();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.u() != true) goto L7;
    L8:
        float r3 = 1.0f;
        if (r1 == false) goto L19;
        SubsamplingScaleImageView r4 = r2.getScaleImageView();
        if (r4 == null) goto L13;
        float r5 = r4.getScale();
    L14:
        SubsamplingScaleImageView r6 = r2.getScaleImageView();
        if (r6 == null) goto L18;
        r3 = r6.getMinScale();
    L18:
        return r5 / r3;
    L13:
        r5 = 1.0f;
        goto L14
    L19:
        return 1.0f;
    L7:
        r1 = false;
        goto L8
    }

    public static void a(CommentAreaMarkLayout r5, RectF r6, float r7) {
        Intrinsics.checkNotNullParameter(r5, "showAreaMarkLayout");
        Intrinsics.checkNotNullParameter(r6, "rect");
        boolean r1 = true;
        if (r6.width() != 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L19:
        tt5.a.k("CommentImageAreaMarkRender", "attachView: skip zero-sized rect=" + r6);
        r5.setCommentRectVisible(false);
        return;
    L9:
        if (r6.height() == 0.0f) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L19;
        tt5.a.h("CommentImageAreaMarkRender", "attachView: rect=" + r6 + ", scale=" + r7);
        if (r5.n == true) goto L17;
        r5.setCommentRectVisible(false);
    L17:
        r5.e(r6, r7);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public static void d(CommentAreaMarkLayout r12, CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r13, CommentAreaMark r14) {
        StringBuilder r0 = new StringBuilder("notifyImageDataChange image:");
        ArrayList<CommentAreaMark> r1 = r13.getAreaMark();
        CommentRectF r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.size());
    L6:
        r0.append(r3);
        tt5.a.h("CommentImageAreaMarkRender", r0.toString());
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r13.getAreaMark().iterator();
        CommentRectF r6 = null;
    L7:
        boolean r7 = true;
        if (r5.hasNext() == false) goto L16;
        CommentAreaMark r8 = (CommentAreaMark) r5.next();
        CommentRectF r9 = new CommentRectF(r8.getAreaData()[0], r8.getAreaData()[1], r8.getAreaData()[2], r8.getAreaData()[3]);
        r9.d = r8.getCreateTimeStamp();
        r9.a = 5;
        r9.f = r8.getUserName();
        r9.g = r8.getUserId();
        r9.h = r8.getAreaUUID();
        r4.add(r9);
        if (r14 == null) goto L12;
        String r10 = r14.getAreaUUID();
    L14:
        if (Intrinsics.areEqual(r10, r9.h) == false) goto L7;
        r6 = r9;
        goto L7
    L12:
        r10 = null;
        goto L14
    L16:
        String r15 = r13.getUuid();
        if (r15 != null) goto L19;
    L22:
        boolean r16 = true;
    L23:
        if (r16 == false) goto L25;
        String r17 = r13.getToken();
    L26:
        if (r17 != null) goto L28;
    L31:
        boolean r18 = true;
    L32:
        if (r18 == false) goto L34;
        tt5.a.k("CommentImageAreaMarkRender", "notifyImageDataChange, image token is empty");
        r17 = "";
    L34:
        if (r12 == null) goto L79;
        if (r6 == null) goto L37;
        String r19 = r6.h;
    L38:
        Intrinsics.checkNotNullParameter(r4, "commentRectFList");
        if (r19 != null) goto L41;
        r12.k0 = null;
    L41:
        String r11 = r12.W;
        if (r11 == null) goto L48;
        if (r11.length() == 0) goto L48;
        r7 = false;
    L48:
        if (r7 == false) goto L50;
        r12.W = r17;
        tt5.a.h("CommentAreaMarkLayout", "updateComment: " + r17);
    L50:
        r12.w(r4, null);
        if (r19 != null) goto L53;
        return;
    L53:
        if (TextUtils.isEmpty(r19) == false) goto L55;
        tt5.a.h("CommentAreaMarkLayout", "highlightRectF: areaUUID is empty");
    L69:
        r12.k0 = r2;
        return;
    L55:
        Iterator<T> r110 = r12.b.iterator();
    L57:
        if (r110.hasNext() == false) goto L61;
        Object r20 = r110.next();
        if (TextUtils.equals(((CommentRectF) r20).h, r19) == false) goto L57;
    L62:
        CommentRectF r21 = (CommentRectF) r20;
        if (r21 == null) goto L69;
        r12.k0 = r21;
        CommentRectLayout.b r111 = r12.J;
        if (r111 == null) goto L68;
        r111.invalidate();
    L68:
        r2 = r21;
        goto L69
    L61:
        r20 = null;
        goto L62
    L37:
        r19 = null;
        goto L38
    L79:
        return;
    L28:
        if (r17.length() == 0) goto L31;
        r18 = false;
        goto L32
    L25:
        r17 = r13.getUuid();
        goto L26
    L19:
        if (r15.length() == 0) goto L22;
        r16 = false;
        goto L23
    L5:
        r3 = null;
        goto L6
    }

    public static void f(String r2, int r3, View r4) {
        tt5.a.h("CommentImageAreaMarkRender", "onSwipe uuid:" + du5.b.h(r2) + ", index:" + r3 + ", currContentView:" + r4);
        if (r4 != null) goto L6;
        tt5.a.k("CommentImageAreaMarkRender", "onSwipe: currContentView is null");
        return;
    L6:
        Object r5 = r4.getParent();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.View");
        CommentAreaMarkLayout r6 = (CommentAreaMarkLayout) ((View) r5).findViewWithTag("comment_area_mark_layout");
        if (r6 != null) goto L10;
        tt5.a.k("CommentImageAreaMarkRender", "onSwipe: showAreaMarkLayout is null");
        return;
    L10:
        r6.k0 = null;
        CommentRectLayout.b r7 = r6.J;
        if (r7 == null) goto L14;
        r7.invalidate();
        return;
    }

    public final void e(String r11, ViewGroup r12, LargeImageView r13) {
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark uuid:" + du5.b.h(r11) + ", container:" + r12 + ", currPageSubView:" + r13);
        boolean r0 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L98;
        if (r12 == null) goto L98;
        if (r13 == null) goto L98;
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        View r5 = r12.findViewWithTag("comment_area_mark_layout");
        r4.element = r5;
        if (r5 != null) goto L39;
        CommentAreaMarkLayout r6 = new CommentAreaMarkLayout(this.a.getActivity());
        r6.setTag("comment_area_mark_layout");
        r4.element = r6;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r7 = this.d;
        if (r7 == null) goto L37;
        Iterator<T> r8 = r7.iterator();
    L19:
        if (r8.hasNext() == false) goto L29;
        Object r9 = r8.next();
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r10 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r9;
        if (Intrinsics.areEqual(r10.getToken(), r11) == false) goto L23;
    L26:
        boolean r14 = true;
    L27:
        if (r14 == false) goto L19;
    L30:
        final CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r15 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r9;
        if (r15 == null) goto L37;
        ((CommentAreaMarkLayout) r4.element).setTag(2131367307, r11);
        ((CommentAreaMarkLayout) r4.element).setTag(2131367360, r15);
        SubsamplingScaleImageView r16 = r13.getScaleImageView();
        if (r16 == null) goto L36;
        r16.setOnMatrixChangeListener(new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.d(this, r4, r13));
    L36:
        CommentAreaMarkLayout r17 = (CommentAreaMarkLayout) r4.element;
        r17.setClickable(false);
        r17.setCommentRectVisible(true);
        r17.setAreaMarkMode(this.k);
        r17.setOnTouchListener(new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.c(r17, this));
        r17.setCommentAreaMarkClickListener(new CommentImageAreaMarkRender$initShowLayout$2(r15, this));
        r12.addView((View) r4.element);
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: create new CommentAreaMarkLayout and add to container");
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: " + r15);
        d((CommentAreaMarkLayout) r4.element, r15, null);
    L40:
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: showAreaMarkLayout=" + r4.element);
        CommentAreaMarkLayout r18 = (CommentAreaMarkLayout) r4.element;
        Intrinsics.checkNotNullParameter(r18, "showAreaMarkLayout");
        Intrinsics.checkNotNullParameter(r13, "largeImageView");
        if (r15 != null) goto L43;
        tt5.a.k("CommentImageAreaMarkRender", "refresh, but imageEntity is null");
        return;
    L43:
        tt5.a.h("CommentImageAreaMarkRender", "refresh imageEntity:" + r18.getImageUUID());
        SubsamplingScaleImageView r19 = r13.getScaleImageView();
        ImageView r20 = r13.getImageView();
        tt5.a.h("CommentImageAreaMarkRender", "getRect: ");
        if (r19 != null) goto L46;
    L48:
        boolean r21 = false;
    L50:
        if (r21 == true) goto L52;
    L68:
        if (r20 != null) goto L70;
    L72:
        boolean r22 = false;
    L73:
        if (r22 == false) goto L90;
        Drawable r110 = r20.getDrawable();
        if (r110 != null) goto L77;
        tt5.a.k("CommentImageAreaMarkRender", "getRect: ImageView drawable is null");
    L93:
        RectF r1 = null;
    L94:
        if (r1 == null) goto L96;
        a(r18, r1, b(r13));
    L96:
        d(r18, r15, null);
        return;
    L77:
        RectF r23 = new RectF(0.0f, 0.0f, r110.getIntrinsicWidth(), r110.getIntrinsicHeight());
        r20.getImageMatrix().mapRect(r23);
        tt5.a.h("CommentImageAreaMarkRender", "getRect: use ImageView mapped rect=" + r23 + ", iv.left=" + r20.getLeft() + ", iv.top=" + r20.getTop());
        r23.offset((float) r20.getLeft(), (float) r20.getTop());
        tt5.a.h("CommentImageAreaMarkRender", "getRect: use ImageView mapped+offset rect=" + r23 + " (iv.left=" + r20.getLeft() + ", iv.top=" + r20.getTop() + ')');
        if (r23.width() != 0.0f) goto L80;
        boolean r111 = true;
    L81:
        if (r111 == false) goto L83;
    L89:
        tt5.a.k("CommentImageAreaMarkRender", "getRect: ImageView rect is zero-sized (possibly intermediate): " + r23);
        goto L93
    L83:
        if (r23.height() == 0.0f) goto L86;
        r0 = false;
    L86:
        if (r0 == true) goto L89;
        r1 = r23;
        goto L94
    L80:
        r111 = false;
        goto L81
    L90:
        RectF r112 = r19.getContentRect();
        tt5.a.h("CommentImageAreaMarkRender", "getRect: fallback to SSV=" + r112);
        if (r112 == null) goto L93;
        r1 = new RectF(r112);
        goto L94
    L70:
        if (r20.getVisibility() != 0) goto L72;
        r22 = true;
        goto L73
    L52:
        if (r19.u() == false) goto L68;
        RectF r113 = r19.getContentRect();
        if (r113 != null) goto L56;
    L67:
        tt5.a.k("CommentImageAreaMarkRender", "getRect: ssv content rect is empty: " + r113);
        goto L93
    L56:
        if (r113.width() != 0.0f) goto L58;
        boolean r24 = true;
    L59:
        if (r24 == true) goto L67;
        if (r113.height() == 0.0f) goto L64;
        r0 = false;
    L64:
        if (r0 == true) goto L67;
        tt5.a.h("CommentImageAreaMarkRender", "getRect: use SSV contentRect=" + r113);
        r1 = new RectF(r113);
        goto L94
    L58:
        r24 = false;
        goto L59
    L46:
        if (r19.getVisibility() != 0) goto L48;
        r21 = true;
        goto L50
    L23:
        if (Intrinsics.areEqual(r10.getUuid(), r11) == true) goto L26;
        r14 = false;
        goto L27
    L29:
        r9 = null;
    L37:
        tt5.a.k("CommentImageAreaMarkRender", "onLoadCommentAreaMark imageEntity is null, uuid=" + r11);
        return;
    L39:
        r15 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) ((CommentAreaMarkLayout) r5).getTag(2131367360);
        tt5.a.h("CommentImageAreaMarkRender", "onLoadCommentAreaMark: reuse existing CommentAreaMarkLayout from container");
    L98:
        tt5.a.k("CommentImageAreaMarkRender", "onLoadCommentAreaMark uuid or container or currPageSubView is null");
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void g(View r5, View r6, VFSPath r7) {
        tt5.a.h("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView, enter create mode, view = " + r5 + ", container = " + r6 + ", path = " + r7);
        if (r5 == null) goto L69;
        if (r6 == null) goto L69;
        if (r7 == null) goto L69;
        this.m.setCommentClickListener(new d(this, r6, r7));
        IImageViewer r8 = this.b;
        Bitmap r9 = null;
        if (r8 == null) goto L10;
        ImageData.Image r10 = r8.c7();
    L11:
        if (r10 != null) goto L15;
        tt5.a.k("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView image is null");
        return;
    L15:
        if ((r5 instanceof LargeImageView) == false) goto L17;
        LargeImageView r11 = (LargeImageView) r5;
    L18:
        tt5.a.h("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView, image=" + r10);
        if (r11 != null) goto L21;
        tt5.a.k("CommentImageAreaMarkRender", "showReadyAddComment: largeImageView is null");
    L49:
        if (r9 != null) goto L71;
        tt5.a.h("CommentImageAreaMarkRender", "showReadyAddComment: bitmap is null");
        return;
    L71:
        this.m.t(ContextCompat.getColor(this.a.getActivity(), 2131106500), r9);     // Catch: Exception -> L66
        if (this.m.getParent() == null) goto L59;
        tt5.a.k("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView view is attached");     // Catch: Exception -> L66
        IImageViewer r12 = this.b;     // Catch: Exception -> L66
        if (r12 == null) goto L59;
        ViewGroup r13 = r12.getContainerView();     // Catch: Exception -> L66
        if (r13 == null) goto L59;
        r13.removeView(this.m);     // Catch: Exception -> L66
    L59:
        IImageViewer r14 = this.b;     // Catch: Exception -> L66
        if (r14 == null) goto L64;
        ViewGroup r15 = r14.getContainerView();     // Catch: Exception -> L66
        if (r15 == null) goto L64;
        r15.addView(this.m);     // Catch: Exception -> L66
    L64:
        this.m.post(new e(this));     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        tt5.a.e("CommentImageAreaMarkRender", "showReadyAddComment: ", e, false);
        return;
    L21:
        ImageView r0 = r11.getImageView();
        Intrinsics.checkNotNull(r0);
        boolean r3 = true;
        if (r0.getVisibility() != 0) goto L24;
        boolean r2 = true;
    L25:
        if (r2 == true) goto L27;
    L33:
        SubsamplingScaleImageView r16 = r11.getScaleImageView();
        if (r16 != null) goto L36;
    L38:
        r3 = false;
    L39:
        if (r3 == true) goto L41;
        tt5.a.h("CommentImageAreaMarkRender", "showReadyAddComment: does not have image");
        goto L49
    L41:
        Bitmap r1 = r16.getImageBitmap();
        if (r1 == null) goto L49;
        Bitmap r17 = r16.getImageBitmap();
        if (r17 == null) goto L47;
        Bitmap.Config r18 = r17.getConfig();
        if (r18 == null) goto L47;
    L48:
        r9 = r1.copy(r18, false);
    L47:
        r18 = Bitmap.Config.ARGB_8888;
        goto L48
    L36:
        if (r16.u() != true) goto L38;
    L27:
        if (r0.getDrawable() == null) goto L33;
        if (r0.getDrawable().getIntrinsicWidth() <= 0) goto L49;
        if (r0.getDrawable().getIntrinsicHeight() <= 0) goto L49;
        r9 = Bitmap.createBitmap(r0.getDrawable().getIntrinsicWidth(), r0.getDrawable().getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        r0.getDrawable().draw(new Canvas(r9));
        goto L49
    L24:
        r2 = false;
        goto L25
    L17:
        r11 = null;
        goto L18
    L10:
        r10 = null;
    L69:
        tt5.a.k("CommentImageAreaMarkRender", "showCommentAreaMarkCreateView, param is null");
    }

    public /* synthetic */ a(p r12, IImageViewer r13, AreaMarkMode r14, List r15, com.bytedance.ee.bear.middleground.comment.p r16, z r17, String r18, String r19) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, null, null);
    }

    public a(p r2, IImageViewer r3, AreaMarkMode r4, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r5, com.bytedance.ee.bear.middleground.comment.p r6, z r7, String r8, String r9, CommentBean r10, CommentImageShowSource r11) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r4, "mAreaMarkMode");
        Intrinsics.checkNotNullParameter(r6, "commentServiceImpl");
        Intrinsics.checkNotNullParameter(r7, "commentListeners");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        int r12 = b.a[r4.ordinal()];
        if (r12 == 1) goto L8;
        if (r12 != 2) goto L7;
        CommentAreaMarkLayout.AreaMarkMode r13 = CommentAreaMarkLayout.AreaMarkMode.READ;
    L9:
        this.k = r13;
        this.l = new c(this);
        CommentAreaMarkLayout r14 = new CommentAreaMarkLayout(r2.getActivity());
        this.m = r14;
        r14.setClickable(true);
        r14.setAreaMarkMode(r13);
        Drawable r15 = AppCompatResources.getDrawable(r2.getActivity(), 2131254250);
        String r16 = r2.getActivity().getString(r4.getCreateTextRes());
        r14.H.setSingleLine(true);
        r14.H.setEllipsize(TextUtils.TruncateAt.END);
        r14.H.setIncludeFontPadding(false);
        r14.H.setAllCaps(false);
        r14.H.setMinHeight(n.d(36));
        if (r15 == null) goto L12;
        DrawableCompat.setTintList(r15, new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[0]}, new int[]{ContextCompat.getColor(r14.getContext(), 2131102156), ContextCompat.getColor(r14.getContext(), 2131102154), ContextCompat.getColor(r14.getContext(), 2131102153)}));
        r15.setBounds(0, 0, n.d(14), n.d(14));
    L12:
        r14.H.setPadding(n.d(16), n.d(12), n.d(16), n.d(12));
        r14.H.setGravity(17);
        r14.H.setCompoundDrawablePadding(n.d(8));
        r14.H.setCompoundDrawablesRelativeWithIntrinsicBounds(r15, null, null, null);
        if (r16 == null) goto L15;
        r14.H.setText(r16);
    L15:
        r14.addOnAttachStateChangeListener(new com.bytedance.ee.bear.middleground.comment.imageviewer.areamark.b(this));
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r13 = CommentAreaMarkLayout.AreaMarkMode.EDIT;
        goto L9
    }
}
