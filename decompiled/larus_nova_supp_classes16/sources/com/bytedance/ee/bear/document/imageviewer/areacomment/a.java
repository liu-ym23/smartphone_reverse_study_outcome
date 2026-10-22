package com.bytedance.ee.bear.document.imageviewer.areacomment;

import am5.j;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.doc.follow.event.KeyboardStateChangedEvent;
import com.bytedance.ee.bear.doc.follow.impl.BaseFollowImpl;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.comment.l2;
import com.bytedance.ee.bear.document.comment.o2;
import com.bytedance.ee.bear.document.comment.p2;
import com.bytedance.ee.bear.document.comment.r2;
import com.bytedance.ee.bear.document.comment.w2;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerPlugin;
import com.bytedance.ee.bear.document.imageviewer.ImageViewerViewModel;
import com.bytedance.ee.bear.document.imageviewer.bean.AreaCommentMode;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final Context a;
    public final IImageViewer b;
    public final ImageViewerPlugin c;
    public final CommentPlugin d;
    public final boolean e;
    public final CommentRectLayout f;
    public final c g;
    public final d h;
    public final BaseUnspecifiedOrientationPlugin<?> i;
    public final h j;
    public final C0078a k;
    public View l;
    public boolean m;
    public AreaCommentMode n;
    public s15.a o;
    public final boolean p;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.imageviewer.areacomment.a$a, reason: collision with other inner class name */
    public static final class C0078a implements sa5.d {
        public final /* synthetic */ a a;

        @Override // sa5.d
        public final boolean onBackPressed() {
            tt5.a.h("ImageCommentAreaView", "onBackPressed");
            ViewGroup r0 = this.a.b.getContainerView();
            if (r0 == null) goto L7;
            r0.removeView(this.a.f);
            return true;
        L7:
            return true;
        }

        public C0078a(a r1) {
            this.a = r1;
        }
    }

    public static final class b implements CommentRectLayout.c {
        public final /* synthetic */ a a;

        public final void b() {
        }

        public final void d(boolean r1) {
        }

        public final void a() {
            a r0 = this.a;
            if (r0.e == true) goto L5;
            return;
        L5:
            if (r0.m == false) goto L9;
            r0.d.closeComment(true, true);
            return;
        }

        public final void c() {
            tt5.a.h("ImageCommentAreaView", "onCloseBtnClick");
            a r0 = this.a;
            if (r0.e == true) goto L5;
            r0.d.setInputCommentFullClick(true);
        L5:
            ViewGroup r1 = this.a.b.getContainerView();
            if (r1 == null) goto L8;
            r1.removeView(this.a.f);
        L8:
            this.a.d.closeComment(true, true);
        }

        public final void e() {
            a r0 = this.a;
            CommentPlugin r1 = r0.d;
            AreaCommentMode r2 = r0.n;
            ImageData.Image r3 = r0.b.c7();
            if (r3 == null) goto L5;
            String r4 = r3.getUuid();
        L6:
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.addAreaComment(r2, r4, this.a.o);
            return;
        L5:
            r4 = null;
            goto L6
        }

        public b(a r1) {
            this.a = r1;
        }

        public final void onTouchEvent(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            a r0 = this.a;
            if (r0.e == false) goto L6;
            return;
        L6:
            if (r0.m == true) goto L8;
            return;
        L8:
            if (r3.getAction() != 1) goto L12;
            this.a.d.closeComment(true, true);
            return;
        }
    }

    public static final class c implements l2 {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.comment.l2
        public final void a(o2 r18) {
            Intrinsics.checkNotNullParameter(r18, "state");
            tt5.a.h("ImageCommentAreaView", "stateChange: " + r18);
            if ((r18 instanceof com.bytedance.ee.bear.document.comment.a) == false) goto L10;
            if (((com.bytedance.ee.bear.document.comment.a) r18).a == false) goto L101;
            ViewGroup r1 = this.a.b.getContainerView();
            if (r1 == null) goto L102;
            r1.removeView(this.a.f);
            return;
        L102:
            return;
        L101:
            return;
        L10:
            if ((r18 instanceof w2) == false) goto L92;
            CommentRectF r2 = this.a.f.getCurrentAreaRect();
            if (r2 != null) goto L18;
            ViewGroup r3 = this.a.b.getContainerView();
            if (r3 == null) goto L16;
            r3.removeView(this.a.f);
        L16:
            tt5.a.k("ImageCommentAreaView", "stateChange: commentRectF is null");
            return;
        L18:
            a r6 = this.a;
            ImageData.Image r7 = r6.b.c7();
            int r8 = vw4.a.a;
            Intrinsics.checkNotNullParameter(r2, "r");
            float[] r9 = {((RectF) r2).left, ((RectF) r2).top, ((RectF) r2).right, ((RectF) r2).bottom};
            String r4 = null;
            if (r7 == null) goto L58;
            if (r6.p == true) goto L24;
        L51:
            float[] r10 = r7.getCrop();
            Intrinsics.checkNotNullParameter(r9, "areaPercent");
            if (r10 == null) goto L58;
            if (r10.length < 4) goto L58;
            float r11 = r10[0];
            float r12 = r10[1];
            float r13 = r10[2] - r11;
            float r14 = r10[3] - r12;
            r9 = new float[]{(r9[0] * r13) + r11, (r9[1] * r14) + r12, r11 + (r9[2] * r13), r12 + (r9[3] * r14)};
            goto L58
        L24:
            if (r7.getTransformerInfo() == null) goto L51;
            if (r7.getLocalTransformerInfo() == null) goto L51;
            com.bytedance.ee.bear.contract.imageviewer.bean.a r16 = r7.getLocalTransformerInfo();
            r16.getClass();
            float[] r17 = r16.b();
            float r19 = r17[0];
            float r110 = r17[1];
            float r111 = r17[2];
            float r20 = r17[3];
            Float r112 = Float.valueOf(r111 - r19);
            if (r112.floatValue() != 0.0f) goto L31;
            boolean r113 = true;
        L33:
            if ((!r113) == true) goto L36;
            r112 = null;
        L36:
            float r114 = 1.0f;
            if (r112 == null) goto L39;
            float r115 = r112.floatValue();
        L40:
            Float r21 = Float.valueOf(r20 - r110);
            if (r21.floatValue() != 0.0f) goto L43;
            boolean r116 = true;
        L45:
            if ((!r116) == true) goto L48;
            r21 = null;
        L48:
            if (r21 == null) goto L50;
            r114 = r21.floatValue();
        L50:
            float r22 = (r9[0] * r115) + r19;
            float r117 = (r9[1] * r114) + r110;
            float r23 = r19 + (r9[2] * r115);
            float r118 = r110 + (r9[3] * r114);
            r9 = new float[]{com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.min(r22, r23)), com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.min(r117, r118)), com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.max(r22, r23)), com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.max(r117, r118))};
            goto L58
        L43:
            r116 = false;
            goto L45
        L39:
            r115 = 1.0f;
            goto L40
        L31:
            r113 = false;
        L58:
            if (AreaCommentMode.CREATE != this.a.n) goto L60;
            String r5 = ((w2) r18).c;
        L61:
            Pair[] r24 = new Pair[3];
            r24[0] = TuplesKt.to("areaComment", r9);
            String r26 = "";
            if (r5 != null) goto L64;
            String r27 = "";
        L65:
            r24[1] = TuplesKt.to("commentId", r27);
            r24[2] = TuplesKt.to("mode", this.a.n.getValue());
            Map<String, Object> r28 = MapsKt.mutableMapOf(r24);
            a r29 = this.a;
            if (r29.n != AreaCommentMode.EDIT) goto L78;
            s15.a r30 = r29.o;
            if (r30 == null) goto L70;
            String r31 = r30.b;
        L72:
            if (TextUtils.isEmpty(r31) == true) goto L78;
            s15.a r32 = this.a.o;
            if (r32 == null) goto L76;
            String r33 = r32.b;
        L77:
            r28.put("replyId", r33);
            goto L78
        L76:
            r33 = null;
            goto L77
        L70:
            r31 = null;
        L78:
            a r34 = this.a;
            ImageViewerPlugin r36 = r34.c;
            ImageData.Image r37 = r34.b.c7();
            if (r37 == null) goto L81;
            String r38 = r37.getUuid();
        L82:
            if (r38 == null) goto L85;
            r26 = r38;
        L85:
            r36.onCallback(ImageViewerViewModel.TYPE_ADD_AREA_COMMENT, r26, this.a.c.getCurrIndex(), r28);
            StringBuilder r39 = new StringBuilder("stateChange: mode: ");
            r39.append(this.a.n);
            r39.append(", areaComment: ");
            r39.append(r9);
            r39.append(", commentId: ");
            r39.append(du5.b.h(r5));
            r39.append(", replyId: ");
            s15.a r40 = this.a.o;
            if (r40 == null) goto L88;
            r4 = r40.b;
        L88:
            r39.append(du5.b.h(r4));
            tt5.a.h("ImageCommentAreaView", r39.toString());
            ViewGroup r41 = this.a.b.getContainerView();
            if (r41 == null) goto L104;
            r41.removeView(this.a.f);
            return;
        L104:
            return;
        L81:
            r38 = null;
            goto L82
        L64:
            r27 = r5;
            goto L65
        L60:
            r5 = ((w2) r18).b;
            goto L61
        L92:
            if ((r18 instanceof p2) == false) goto L98;
            a r42 = this.a;
            r42.m = false;
            if (r42.e == true) goto L96;
            r42.d.setInputCommentFullClick(true);
        L96:
            this.a.f.i(false, true);
            return;
        L98:
            if ((r18 instanceof r2) == false) goto L107;
            a r43 = this.a;
            r43.m = true;
            r43.d.setInputCommentFullClick(false);
            this.a.f.i(true, true);
            return;
        }
    }

    public static final class d implements sy4.d {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // sy4.d
        public final void a(sy4.b r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            tt5.a.h("ImageCommentAreaView", "onStateChanged: " + r3);
            if ((r3 instanceof sy4.e) == true) goto L5;
            return;
        L5:
            if (((sy4.e) r3).b == false) goto L11;
            ViewGroup r4 = this.a.b.getContainerView();
            if (r4 == null) goto L12;
            r4.removeView(this.a.f);
            return;
        L12:
            return;
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            sa5.b r5 = a.a(this.a);
            if (r5 == null) goto L5;
            r5.e(this.a.k);
        L5:
            this.a.d.closeCommentCards();
            this.a.b.hl(IImageViewer.ImageCommentMode.AREA_COMMENT_ADD);
            FollowPlugin r6 = (FollowPlugin) this.a.c.getHost().findPlugin(FollowPlugin.class);
            if (r6 == null) goto L10;
            BaseFollowImpl r7 = r6.getDocumentFollow();
            if (r7 == null) goto L10;
            r7.registerDocFollowStateObserver(this.a.h);
        L10:
            com.bytedance.ee.bear.document.comment.e r8 = this.a.d.getCommentStateDispatcher();
            com.bytedance.ee.bear.document.comment.d r9 = (com.bytedance.ee.bear.document.comment.d) r8;
            r9.c(this.a.g);
            a r10 = this.a;
            BaseUnspecifiedOrientationPlugin<?> r0 = r10.i;
            if (r0 == null) goto L13;
            r0.onOrientationSupportPanelShowing(r10.j);
        L13:
            FollowPlugin r11 = (FollowPlugin) this.a.c.getHost().findPlugin(FollowPlugin.class);
            if (r11 == null) goto L19;
            BaseFollowImpl r12 = r11.getDocumentFollow();
            if (r12 == null) goto L20;
            r12.processContentEvent(new KeyboardStateChangedEvent(false, true));
            return;
        L20:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            sa5.b r4 = a.a(this.a);
            if (r4 == null) goto L5;
            r4.d(this.a.k);
        L5:
            this.a.b.hl(IImageViewer.ImageCommentMode.EXIT);
            FollowPlugin r5 = (FollowPlugin) this.a.c.getHost().findPlugin(FollowPlugin.class);
            if (r5 == null) goto L10;
            BaseFollowImpl r6 = r5.getDocumentFollow();
            if (r6 == null) goto L10;
            r6.unregisterDocFollowStateObserver(this.a.h);
        L10:
            com.bytedance.ee.bear.document.comment.e r7 = this.a.d.getCommentStateDispatcher();
            c r0 = this.a.g;
            com.bytedance.ee.bear.document.comment.d r8 = (com.bytedance.ee.bear.document.comment.d) r7;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r0, "listener");
            ((ArrayList) r8.b).remove(r0);
            this.a.f.i(false, false);
            this.a.f.j();
            a r9 = this.a;
            BaseUnspecifiedOrientationPlugin<?> r1 = r9.i;
            if (r1 == null) goto L13;
            r1.onOrientationSupportPanelDismiss(r9.j);
        L13:
            a r10 = this.a;
            r10.l = null;
            r10.d.closeComment(true, true);
            FollowPlugin r11 = (FollowPlugin) this.a.c.getHost().findPlugin(FollowPlugin.class);
            if (r11 == null) goto L19;
            BaseFollowImpl r12 = r11.getDocumentFollow();
            if (r12 == null) goto L20;
            r12.processContentEvent(new KeyboardStateChangedEvent(false, false));
            return;
        L20:
            return;
        }
    }

    public static final class f {
    }

    public static final class g implements Runnable {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("ImageCommentAreaView", "attachCreateViewWithBitmap: post show");     // Catch: Throwable -> L4
            this.a.f.u();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements p {
        public final /* synthetic */ a a;

        @Override // com.bytedance.ee.bear.document.orientation.p
        public final boolean shouldDisableLandscape() {
            return !DeviceUtils.isPad(this.a.getContext());
        }

        public h(a r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void d() {
        if (this.m == false) goto L12;
        CommentRectLayout r0 = this.f;
        if (r0.E.u() == true) goto L7;
    L10:
        tt5.a.b("CommentRectLayout", "moveBgImageToCreateRect: mBgImage does not have image or mCommentCreateView is not visible");
        return;
    L7:
        if (r0.y.getVisibility() != 0) goto L10;
        r0.post(new j(r0));
        return;
    }

    public final Context getContext() {
        return this.a;
    }

    public static final sa5.b a(a r2) {
        r2.getClass();
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r0 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r1 = r2.c.getHost().getActivity();
        Fragment r3 = r2.c.getHost().getHostFragment();
        r0.getClass();
        return com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r1, r3);
    }

    public final void b(SubsamplingScaleImageView r10) {
        Bitmap r11 = r10.getImageBitmap();
        if (r11 != null) goto L7;
        tt5.a.k("ImageCommentAreaView", "scaleImageView: bitmap is null");
        return;
    L7:
        if (this.p == false) goto L28;
        ImageData.Image r0 = this.b.c7();
        if (r0 == null) goto L11;
        com.bytedance.ee.bear.contract.imageviewer.bean.a r1 = r0.getLocalTransformerInfo();
    L12:
        if (r1 == null) goto L24;
        int r2 = com.ss.android.lark.imagewidget.largeimage.transform.a.a;
        float r3 = r1.a;
        float r4 = r1.b;
        Path r5 = r1.f;
        AreaCommentCreate$applyScaleAndClipPathIfNeeded$outBitmap$1 r6 = AreaCommentCreate$applyScaleAndClipPathIfNeeded$outBitmap$1.INSTANCE;
        if (r5 == null) goto L16;
        boolean r7 = true;
    L17:
        Bitmap r8 = com.ss.android.lark.imagewidget.largeimage.transform.a.a(r11, r3, r4, r5, r7, r6);
        tt5.a.b("ImageCommentAreaView", "transform result=" + r8.getWidth() + Permission.EXECUTE + r8.getHeight());
        if (r8 != r11) goto L32;
        Bitmap.Config r9 = r11.getConfig();
        if (r9 != null) goto L23;
        r9 = Bitmap.Config.ARGB_8888;
    L23:
        r8 = r11.copy(r9, false);
    L32:
        if (r8 == null) goto L34;
        c(r8);
        return;
    L34:
        tt5.a.h("ImageCommentAreaView", "scaleImageView: bitmap is null");
        return;
    L16:
        r7 = false;
        goto L17
    L24:
        Bitmap.Config r12 = r11.getConfig();
        if (r12 != null) goto L27;
        r12 = Bitmap.Config.ARGB_8888;
    L27:
        r8 = r11.copy(r12, false);
        goto L32
    L11:
        r1 = null;
        goto L12
    L28:
        Bitmap.Config r13 = r11.getConfig();
        if (r13 != null) goto L31;
        r13 = Bitmap.Config.ARGB_8888;
    L31:
        r8 = r11.copy(r13, false);
        goto L32
    }

    public final void c(Bitmap r4) {
        this.l = this.b.iF();     // Catch: Exception -> L7
        this.f.t(ContextCompat.getColor(this.a, 2131106500), r4);     // Catch: Exception -> L7
        ViewGroup r5 = this.b.getContainerView();     // Catch: Exception -> L7
        if (r5 == null) goto L5;
        r5.addView(this.f);     // Catch: Exception -> L7
    L5:
        this.f.post(new g(this));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e("ImageCommentAreaView", "attachCreateViewWithBitmap: ", e, false);
    }

    public a(Context r2, IImageViewer r3, ImageViewerPlugin r4, CommentPlugin r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageViewer");
        Intrinsics.checkNotNullParameter(r4, "imageViewPlugin");
        Intrinsics.checkNotNullParameter(r5, "commentPlugin");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        CommentRectLayout r7 = new CommentRectLayout(r2);
        this.f = r7;
        this.j = new h(this);
        this.n = AreaCommentMode.CREATE;
        this.p = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.slides.image_area_comment_enabled");
        this.i = (BaseUnspecifiedOrientationPlugin) r4.getHost().findPlugin(BaseUnspecifiedOrientationPlugin.class);
        this.k = new C0078a(this);
        r7.setClickable(true);
        r7.setCommentClickListener(new b(this));
        this.g = new c(this);
        this.h = new d(this);
        r7.addOnAttachStateChangeListener(new e(this));
    }
}
