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
import com.bytedance.ee.bear.document.imageviewer.bean.AreaCommentMode;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f220009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IImageViewer f220010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageViewerPlugin f220011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentPlugin f220012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f220013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CommentRectLayout f220014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f220015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f220016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BaseUnspecifiedOrientationPlugin<?> f220017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f220018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C3134a f220019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f220020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f220021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AreaCommentMode f220022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public s15.a f220023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f220024p;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.imageviewer.areacomment.a$a, reason: collision with other inner class name */
    public static final class C3134a implements sa5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220025a;

        @Override // sa5.d
        public final boolean onBackPressed() {
            tt5.a.h("ImageCommentAreaView", "onBackPressed");
            ViewGroup r100 = this.f220025a.f220010b.getContainerView();
            if (r100 == null) goto L7;
            r100.removeView(this.f220025a.f220014f);
            return true;
        L7:
            return true;
        }

        public C3134a(a r100) {
            this.f220025a = r100;
        }
    }

    public static final class b implements CommentRectLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220026a;

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void d(boolean r100) {
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void a() {
            a r100 = this.f220026a;
            if (r100.f220013e == true) goto L5;
            return;
        L5:
            if (r100.f220021m == false) goto L9;
            r100.f220012d.closeComment(true, true);
            return;
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void c() {
            tt5.a.h("ImageCommentAreaView", "onCloseBtnClick");
            a r100 = this.f220026a;
            if (r100.f220013e == true) goto L5;
            r100.f220012d.setInputCommentFullClick(true);
        L5:
            ViewGroup r101 = this.f220026a.f220010b.getContainerView();
            if (r101 == null) goto L8;
            r101.removeView(this.f220026a.f220014f);
        L8:
            this.f220026a.f220012d.closeComment(true, true);
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void e() {
            a r100 = this.f220026a;
            CommentPlugin r101 = r100.f220012d;
            AreaCommentMode r102 = r100.f220022n;
            ImageData.Image r103 = r100.f220010b.c7();
            if (r103 == null) goto L5;
            String r104 = r103.getUuid();
        L6:
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.addAreaComment(r102, r104, this.f220026a.f220023o);
            return;
        L5:
            r104 = null;
            goto L6
        }

        public b(a r100) {
            this.f220026a = r100;
        }

        @Override // com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout.c
        public final void onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            a r101 = this.f220026a;
            if (r101.f220013e == false) goto L6;
            return;
        L6:
            if (r101.f220021m == true) goto L8;
            return;
        L8:
            if (r100.getAction() != 1) goto L12;
            this.f220026a.f220012d.closeComment(true, true);
            return;
        }
    }

    public static final class c implements l2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220027a;

        public c(a r100) {
            this.f220027a = r100;
        }

        @Override // com.bytedance.ee.bear.document.comment.l2
        public final void a(o2 r110) {
            Intrinsics.checkNotNullParameter(r110, "state");
            tt5.a.h("ImageCommentAreaView", "stateChange: " + r110);
            if ((r110 instanceof com.bytedance.ee.bear.document.comment.a) == false) goto L10;
            if (((com.bytedance.ee.bear.document.comment.a) r110).f219274a == false) goto L101;
            ViewGroup r100 = this.f220027a.f220010b.getContainerView();
            if (r100 == null) goto L102;
            r100.removeView(this.f220027a.f220014f);
            return;
        L102:
            return;
        L101:
            return;
        L10:
            if ((r110 instanceof w2) == false) goto L92;
            CommentRectF r101 = this.f220027a.f220014f.getCurrentAreaRect();
            if (r101 != null) goto L18;
            ViewGroup r102 = this.f220027a.f220010b.getContainerView();
            if (r102 == null) goto L16;
            r102.removeView(this.f220027a.f220014f);
        L16:
            tt5.a.k("ImageCommentAreaView", "stateChange: commentRectF is null");
            return;
        L18:
            a r103 = this.f220027a;
            ImageData.Image r104 = r103.f220010b.c7();
            int r105 = vw4.a.f557426a;
            Intrinsics.checkNotNullParameter(r101, "r");
            float[] r106 = {((RectF) r101).left, ((RectF) r101).top, ((RectF) r101).right, ((RectF) r101).bottom};
            String r107 = null;
            if (r104 == null) goto L58;
            if (r103.f220024p == true) goto L24;
        L51:
            float[] r108 = r104.getCrop();
            Intrinsics.checkNotNullParameter(r106, "areaPercent");
            if (r108 == null) goto L58;
            if (r108.length < 4) goto L58;
            float r109 = r108[0];
            float r111 = r108[1];
            float r112 = r108[2] - r109;
            float r113 = r108[3] - r111;
            r106 = new float[]{(r106[0] * r112) + r109, (r106[1] * r113) + r111, r109 + (r106[2] * r112), r111 + (r106[3] * r113)};
            goto L58
        L24:
            if (r104.getTransformerInfo() == null) goto L51;
            if (r104.getLocalTransformerInfo() == null) goto L51;
            com.bytedance.ee.bear.contract.imageviewer.bean.a r114 = r104.getLocalTransformerInfo();
            r114.getClass();
            float[] r115 = r114.b();
            float r116 = r115[0];
            float r117 = r115[1];
            float r118 = r115[2];
            float r119 = r115[3];
            Float r120 = Float.valueOf(r118 - r116);
            if (r120.floatValue() != 0.0f) goto L31;
            boolean r121 = true;
        L33:
            if ((!r121) == true) goto L36;
            r120 = null;
        L36:
            float r122 = 1.0f;
            if (r120 == null) goto L39;
            float r123 = r120.floatValue();
        L40:
            Float r124 = Float.valueOf(r119 - r117);
            if (r124.floatValue() != 0.0f) goto L43;
            boolean r125 = true;
        L45:
            if ((!r125) == true) goto L48;
            r124 = null;
        L48:
            if (r124 == null) goto L50;
            r122 = r124.floatValue();
        L50:
            float r126 = (r106[0] * r123) + r116;
            float r127 = (r106[1] * r122) + r117;
            float r128 = r116 + (r106[2] * r123);
            float r129 = r117 + (r106[3] * r122);
            r106 = new float[]{com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.min(r126, r128)), com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.min(r127, r129)), com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.max(r126, r128)), com.bytedance.ee.bear.contract.imageviewer.bean.a.a(Math.max(r127, r129))};
            goto L58
        L43:
            r125 = false;
            goto L45
        L39:
            r123 = 1.0f;
            goto L40
        L31:
            r121 = false;
        L58:
            if (AreaCommentMode.CREATE != this.f220027a.f220022n) goto L60;
            String r130 = ((w2) r110).f219380c;
        L61:
            Pair[] r131 = new Pair[3];
            r131[0] = TuplesKt.to("areaComment", r106);
            String r132 = "";
            if (r130 != null) goto L64;
            String r133 = "";
        L65:
            r131[1] = TuplesKt.to("commentId", r133);
            r131[2] = TuplesKt.to("mode", this.f220027a.f220022n.getValue());
            Map<String, Object> r134 = MapsKt.mutableMapOf(r131);
            a r135 = this.f220027a;
            if (r135.f220022n != AreaCommentMode.EDIT) goto L78;
            s15.a r136 = r135.f220023o;
            if (r136 == null) goto L70;
            String r137 = r136.f540155b;
        L72:
            if (TextUtils.isEmpty(r137) == true) goto L78;
            s15.a r138 = this.f220027a.f220023o;
            if (r138 == null) goto L76;
            String r139 = r138.f540155b;
        L77:
            r134.put("replyId", r139);
            goto L78
        L76:
            r139 = null;
            goto L77
        L70:
            r137 = null;
        L78:
            a r140 = this.f220027a;
            ImageViewerPlugin r141 = r140.f220011c;
            ImageData.Image r142 = r140.f220010b.c7();
            if (r142 == null) goto L81;
            String r143 = r142.getUuid();
        L82:
            if (r143 == null) goto L85;
            r132 = r143;
        L85:
            r141.onCallback("addAreaComment", r132, this.f220027a.f220011c.getCurrIndex(), r134);
            StringBuilder r144 = new StringBuilder("stateChange: mode: ");
            r144.append(this.f220027a.f220022n);
            r144.append(", areaComment: ");
            r144.append(r106);
            r144.append(", commentId: ");
            r144.append(du5.b.h(r130));
            r144.append(", replyId: ");
            s15.a r145 = this.f220027a.f220023o;
            if (r145 == null) goto L88;
            r107 = r145.f540155b;
        L88:
            r144.append(du5.b.h(r107));
            tt5.a.h("ImageCommentAreaView", r144.toString());
            ViewGroup r146 = this.f220027a.f220010b.getContainerView();
            if (r146 == null) goto L104;
            r146.removeView(this.f220027a.f220014f);
            return;
        L104:
            return;
        L81:
            r143 = null;
            goto L82
        L64:
            r133 = r130;
            goto L65
        L60:
            r130 = ((w2) r110).f219379b;
            goto L61
        L92:
            if ((r110 instanceof p2) == false) goto L98;
            a r147 = this.f220027a;
            r147.f220021m = false;
            if (r147.f220013e == true) goto L96;
            r147.f220012d.setInputCommentFullClick(true);
        L96:
            this.f220027a.f220014f.i(false, true);
            return;
        L98:
            if ((r110 instanceof r2) == false) goto L107;
            a r148 = this.f220027a;
            r148.f220021m = true;
            r148.f220012d.setInputCommentFullClick(false);
            this.f220027a.f220014f.i(true, true);
            return;
        }
    }

    public static final class d implements sy4.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220028a;

        public d(a r100) {
            this.f220028a = r100;
        }

        @Override // sy4.d
        public final void a(sy4.b r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            tt5.a.h("ImageCommentAreaView", "onStateChanged: " + r100);
            if ((r100 instanceof sy4.e) == true) goto L5;
            return;
        L5:
            if (((sy4.e) r100).f543884b == false) goto L11;
            ViewGroup r101 = this.f220028a.f220010b.getContainerView();
            if (r101 == null) goto L12;
            r101.removeView(this.f220028a.f220014f);
            return;
        L12:
            return;
        }
    }

    public static final class e implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220029a;

        public e(a r100) {
            this.f220029a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            sa5.b r101 = a.a(this.f220029a);
            if (r101 == null) goto L5;
            r101.e(this.f220029a.f220019k);
        L5:
            this.f220029a.f220012d.closeCommentCards();
            this.f220029a.f220010b.hl(IImageViewer.ImageCommentMode.AREA_COMMENT_ADD);
            FollowPlugin r102 = (FollowPlugin) this.f220029a.f220011c.getHost().findPlugin(FollowPlugin.class);
            if (r102 == null) goto L10;
            BaseFollowImpl r103 = r102.getDocumentFollow();
            if (r103 == null) goto L10;
            r103.registerDocFollowStateObserver(this.f220029a.f220016h);
        L10:
            com.bytedance.ee.bear.document.comment.e r104 = this.f220029a.f220012d.getCommentStateDispatcher();
            com.bytedance.ee.bear.document.comment.d r105 = (com.bytedance.ee.bear.document.comment.d) r104;
            r105.c(this.f220029a.f220015g);
            a r106 = this.f220029a;
            BaseUnspecifiedOrientationPlugin<?> r107 = r106.f220017i;
            if (r107 == null) goto L13;
            r107.onOrientationSupportPanelShowing(r106.f220018j);
        L13:
            FollowPlugin r108 = (FollowPlugin) this.f220029a.f220011c.getHost().findPlugin(FollowPlugin.class);
            if (r108 == null) goto L19;
            BaseFollowImpl r109 = r108.getDocumentFollow();
            if (r109 == null) goto L20;
            r109.processContentEvent(new KeyboardStateChangedEvent(false, true));
            return;
        L20:
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            sa5.b r101 = a.a(this.f220029a);
            if (r101 == null) goto L5;
            r101.d(this.f220029a.f220019k);
        L5:
            this.f220029a.f220010b.hl(IImageViewer.ImageCommentMode.EXIT);
            FollowPlugin r102 = (FollowPlugin) this.f220029a.f220011c.getHost().findPlugin(FollowPlugin.class);
            if (r102 == null) goto L10;
            BaseFollowImpl r103 = r102.getDocumentFollow();
            if (r103 == null) goto L10;
            r103.unregisterDocFollowStateObserver(this.f220029a.f220016h);
        L10:
            com.bytedance.ee.bear.document.comment.e r104 = this.f220029a.f220012d.getCommentStateDispatcher();
            c r105 = this.f220029a.f220015g;
            com.bytedance.ee.bear.document.comment.d r106 = (com.bytedance.ee.bear.document.comment.d) r104;
            r106.getClass();
            Intrinsics.checkNotNullParameter(r105, "listener");
            ((ArrayList) r106.f219292b).remove(r105);
            this.f220029a.f220014f.i(false, false);
            this.f220029a.f220014f.j();
            a r107 = this.f220029a;
            BaseUnspecifiedOrientationPlugin<?> r108 = r107.f220017i;
            if (r108 == null) goto L13;
            r108.onOrientationSupportPanelDismiss(r107.f220018j);
        L13:
            a r109 = this.f220029a;
            r109.f220020l = null;
            r109.f220012d.closeComment(true, true);
            FollowPlugin r110 = (FollowPlugin) this.f220029a.f220011c.getHost().findPlugin(FollowPlugin.class);
            if (r110 == null) goto L19;
            BaseFollowImpl r111 = r110.getDocumentFollow();
            if (r111 == null) goto L20;
            r111.processContentEvent(new KeyboardStateChangedEvent(false, false));
            return;
        L20:
            return;
        }
    }

    public static final class f {
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220030a;

        public g(a r100) {
            this.f220030a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("ImageCommentAreaView", "attachCreateViewWithBitmap: post show");     // Catch: Throwable -> L4
            this.f220030a.f220014f.u();     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f220031a;

        @Override // com.bytedance.ee.bear.document.orientation.p
        public final boolean shouldDisableLandscape() {
            return !DeviceUtils.isPad(this.f220031a.getContext());
        }

        public h(a r100) {
            this.f220031a = r100;
        }
    }

    static {
    }

    public final void d() {
        if (this.f220021m == false) goto L12;
        final CommentRectLayout r100 = this.f220014f;
        if (r100.E.u() == true) goto L7;
    L10:
        tt5.a.b("CommentRectLayout", "moveBgImageToCreateRect: mBgImage does not have image or mCommentCreateView is not visible");
        return;
    L7:
        if (r100.f236809y.getVisibility() != 0) goto L10;
        r100.post(new j(r100));
        return;
    }

    public final Context getContext() {
        return this.f220009a;
    }

    public static final sa5.b a(a r100) {
        r100.getClass();
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r101 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.f216466a;
        FragmentActivity r102 = r100.f220011c.getHost().getActivity();
        Fragment r103 = r100.f220011c.getHost().getHostFragment();
        r101.getClass();
        return com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r102, r103);
    }

    public final void b(SubsamplingScaleImageView r110) {
        Bitmap r111 = r110.getImageBitmap();
        if (r111 != null) goto L7;
        tt5.a.k("ImageCommentAreaView", "scaleImageView: bitmap is null");
        return;
    L7:
        if (this.f220024p == false) goto L28;
        ImageData.Image r100 = this.f220010b.c7();
        if (r100 == null) goto L11;
        com.bytedance.ee.bear.contract.imageviewer.bean.a r101 = r100.getLocalTransformerInfo();
    L12:
        if (r101 == null) goto L24;
        int r102 = com.ss.android.lark.imagewidget.largeimage.transform.a.f426681a;
        float r103 = r101.f217080a;
        float r104 = r101.f217081b;
        Path r105 = r101.f217085f;
        AreaCommentCreate$applyScaleAndClipPathIfNeeded$outBitmap$1 r106 = AreaCommentCreate$applyScaleAndClipPathIfNeeded$outBitmap$1.INSTANCE;
        if (r105 == null) goto L16;
        boolean r107 = true;
    L17:
        Bitmap r108 = com.ss.android.lark.imagewidget.largeimage.transform.a.a(r111, r103, r104, r105, r107, r106);
        tt5.a.b("ImageCommentAreaView", "transform result=" + r108.getWidth() + Permission.EXECUTE + r108.getHeight());
        if (r108 != r111) goto L32;
        Bitmap.Config r109 = r111.getConfig();
        if (r109 != null) goto L23;
        r109 = Bitmap.Config.ARGB_8888;
    L23:
        r108 = r111.copy(r109, false);
    L32:
        if (r108 == null) goto L34;
        c(r108);
        return;
    L34:
        tt5.a.h("ImageCommentAreaView", "scaleImageView: bitmap is null");
        return;
    L16:
        r107 = false;
        goto L17
    L24:
        Bitmap.Config r112 = r111.getConfig();
        if (r112 != null) goto L27;
        r112 = Bitmap.Config.ARGB_8888;
    L27:
        r108 = r111.copy(r112, false);
        goto L32
    L11:
        r101 = null;
        goto L12
    L28:
        Bitmap.Config r113 = r111.getConfig();
        if (r113 != null) goto L31;
        r113 = Bitmap.Config.ARGB_8888;
    L31:
        r108 = r111.copy(r113, false);
        goto L32
    }

    public final void c(Bitmap r100) {
        this.f220020l = this.f220010b.iF();     // Catch: Exception -> L7
        this.f220014f.t(ContextCompat.getColor(this.f220009a, R.color.static_black), r100);     // Catch: Exception -> L7
        ViewGroup r101 = this.f220010b.getContainerView();     // Catch: Exception -> L7
        if (r101 == null) goto L5;
        r101.addView(this.f220014f);     // Catch: Exception -> L7
    L5:
        this.f220014f.post(new g(this));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e("ImageCommentAreaView", "attachCreateViewWithBitmap: ", e, false);
    }

    public a(Context r100, IImageViewer r101, ImageViewerPlugin r102, CommentPlugin r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageViewer");
        Intrinsics.checkNotNullParameter(r102, "imageViewPlugin");
        Intrinsics.checkNotNullParameter(r103, "commentPlugin");
        this.f220009a = r100;
        this.f220010b = r101;
        this.f220011c = r102;
        this.f220012d = r103;
        this.f220013e = r104;
        CommentRectLayout r105 = new CommentRectLayout(r100);
        this.f220014f = r105;
        this.f220018j = new h(this);
        this.f220022n = AreaCommentMode.CREATE;
        this.f220024p = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.slides.image_area_comment_enabled");
        this.f220017i = (BaseUnspecifiedOrientationPlugin) r102.getHost().findPlugin(BaseUnspecifiedOrientationPlugin.class);
        this.f220019k = new C3134a(this);
        r105.setClickable(true);
        r105.setCommentClickListener(new b(this));
        this.f220015g = new c(this);
        this.f220016h = new d(this);
        r105.addOnAttachStateChangeListener(new e(this));
    }
}
