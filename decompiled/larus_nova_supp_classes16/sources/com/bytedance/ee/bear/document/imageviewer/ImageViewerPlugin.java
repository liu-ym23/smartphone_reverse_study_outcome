package com.bytedance.ee.bear.document.imageviewer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.imageviewer.api.IImageViewer;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageCommentData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageData;
import com.bytedance.ee.bear.contract.imageviewer.bean.ImageType;
import com.bytedance.ee.bear.contract.imageviewer.plugin.BaseDiagramPlugin;
import com.bytedance.ee.bear.doc.follow.event.OpenImageWhiteboard;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.u0;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.imageviewer.bean.AreaCommentMode;
import com.bytedance.ee.bear.document.imageviewer.bean.CardCommentData;
import com.bytedance.ee.bear.document.imageviewer.bean.DeleteImageData;
import com.bytedance.ee.bear.document.imageviewer.bean.EnterAreaCommentParams;
import com.bytedance.ee.bear.document.imageviewer.bean.ImageCardsData;
import com.bytedance.ee.bear.document.imageviewer.bean.ImageDataModel;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.multitask.MultiTaskPlugin;
import com.bytedance.ee.bear.document.orientation.BaseSensorOrientationDetectorPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.templatePlugin.BaseTemplatePreviewPlugin;
import com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.vfs.VFSPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import r15.n;
import r15.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageViewerPlugin extends DocumentPluginV2 implements p {
    private static final String FROM_CREATE_AI = "creationAI";
    private static final String TAG = "ImageViewerPlugin";
    private boolean areaCommentAddEnable;
    private boolean areaCommentReadEnable;
    private ImageViewerViewModel imageViewerViewModel;
    private boolean isFirstOpen;
    private r15.a mAnalytic;
    private com.bytedance.ee.bear.document.imageviewer.areacomment.c mAreaCommentRender;
    private ImageDataModel mCurrentImageData;
    private ImageCardsData mImageCardsData;
    private IImageViewer mImageViewer;
    private MutableLiveData<Boolean> mIsActive;
    private Observer<ru5.d> mLandScapeObserver;
    private tb5.m mOpenCallBack;
    private l onCommentClickListener;
    private boolean slideAreaCommentEnable;
    private final boolean uniformInterface;

    public class a implements ImageViewerViewModel.a {
        public final /* synthetic */ ImageViewerPlugin a;

        public a(ImageViewerPlugin r1) {
            this.a = r1;
        }

        public final void a(String r3, String r4, int r5) {
            this.a.onCallback(r3, r4, r5, new HashMap());
        }
    }

    public class b implements uw4.b {
        public boolean a;
        public final /* synthetic */ ImageViewerPlugin b;

        @Override // uw4.b
        public final void d(String r1, FrameLayout r2, LargeImageView r3) {
        }

        @Override // uw4.b
        public final void e() {
            ImageViewerPlugin.access$1300(this.b).closeCommentCards();
        }

        public b(ImageViewerPlugin r1) {
            this.b = r1;
            this.a = true;
        }

        @Override // uw4.b
        public final void a(String r2, int r3) {
            ImageViewerPlugin.access$1300(this.b).loadError(r2, r3);
        }

        @Override // uw4.b
        public final void c(String r2, int r3, View r4) {
            if (ImageViewerPlugin.access$1200(this.b) == null) goto L5;
            ImageViewerPlugin.access$1200(this.b).g(r4);
        L5:
            ImageViewerPlugin.access$1300(this.b).swipe(r2, r3);
        }

        @Override // uw4.b
        public final void b(String r3, int r4, ImageData.Image r5, LargeImageView r6) {
            if (this.a == true) goto L5;
        L13:
            this.a = false;
            if (ImageViewerPlugin.access$1200(this.b) == null) goto L29;
            com.bytedance.ee.bear.document.imageviewer.areacomment.c r7 = ImageViewerPlugin.access$1200(this.b);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r5, "currImage");
            Intrinsics.checkNotNullParameter(r6, "currPageSubView");
            ImageData.Image r8 = r7.c.c7();
            if (r8 == null) goto L18;
            String r9 = r8.getUuid();
        L20:
            if (y0.a(r3, r9) == true) goto L22;
        L27:
            tt5.a.h("AreaCommentRender", "onLoadSuccess: uuid not equals or currPageSubView not equals");
            return;
        L22:
            if (Intrinsics.areEqual(r6, r7.i) == false) goto L27;
            RectF r10 = r7.c();
            if (r10 == null) goto L30;
            r7.b(r10, r7.d());
            return;
        L30:
            return;
        L18:
            r9 = null;
            goto L20
        L29:
            return;
        L5:
            if (ImageViewerPlugin.access$1100(this.b) == false) goto L13;
            ImageData r0 = (ImageData) ImageViewerPlugin.access$1300(this.b).getImageData().getValue();
            if (r0 == null) goto L13;
            if (r0.getImage() == null) goto L13;
            if (TextUtils.equals(r0.getImage().getUuid(), r3) == false) goto L13;
            ImageViewerPlugin.access$1300(this.b).openSuccess(r3, r4);
            goto L13
        }
    }

    public class c implements uw4.f {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // uw4.f
        public final void a() {
        }

        @Override // uw4.f
        public final /* synthetic */ void b(String r1, View r2, View r3, VFSPath r4) {
        }

        @Override // uw4.f
        public final void c() {
        }

        public c(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // uw4.f
        public final void d(String r2) {
            if (ImageViewerPlugin.access$1300(this.a) == null) goto L5;
            ImageViewerPlugin.access$1300(this.a).editImage(r2);
            return;
        L5:
            tt5.a.d(ImageViewerPlugin.TAG, "onClickEdit imageViewerViewModel null!!!");
        }

        @Override // uw4.f
        public final void e(String r3) {
            if (ImageViewerPlugin.access$1400(this.a) == null) goto L8;
            if ("sheet".equals(ImageViewerPlugin.access$1400(this.a).getSource()) == false) goto L8;
            ImageViewerPlugin.access$1300(this.a).commentImage(r3, -1);
            return;
        L8:
            if (ImageViewerPlugin.access$800(this.a) == true) goto L10;
        L12:
            ImageViewerPlugin.access$1600(this.a);
            return;
        L10:
            if (ImageViewerPlugin.access$1500(this.a) == null) goto L12;
            CommentPlugin.a(((u0) ImageViewerPlugin.access$1500(this.a)).a, r3);
        }

        @Override // uw4.f
        public final void f(String r4, float[] r5, Matrix r6) {
            tt5.a.h(ImageViewerPlugin.TAG, "onClickFollowMark...");
            FollowPlugin r1 = (FollowPlugin) ImageViewerPlugin.access$1700(this.a, FollowPlugin.class);
            if (r1 == null) goto L5;
            r1.processEvent(new OpenImageWhiteboard(r4, r5, r6));
            return;
        L5:
            tt5.a.k(ImageViewerPlugin.TAG, "followPlugin is null");
        }
    }

    public class d implements uw4.c {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // uw4.c
        public final void onCreated() {
            ImageViewerPlugin.access$1800(this.a);
            this.a.getHost().findPluginToDo(MultiTaskPlugin.class, new r15.i());
            this.a.getHost().findPluginToDo(BaseTemplatePreviewPlugin.class, new r15.j());
            this.a.getHost().findPluginToDo(BaseTitlePlugin.class, new r15.k());
        }

        public d(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // uw4.c
        public final void a(IImageViewer r3) {
            ImageViewerPlugin.access$1900(this.a);
            ImageViewerPlugin.access$2000(this.a);
            if (ImageViewerPlugin.access$1300(this.a) != null) goto L5;
        L7:
            this.a.getHost().findPluginToDo(BaseTitlePlugin.class, new r15.l());
            if (ImageViewerPlugin.access$1100(this.a) == false) goto L11;
            this.a.getHost().findPluginToDo(CommentPlugin.class, new r15.m());
            return;
        L11:
            return;
        L5:
            if (((Boolean) ImageViewerPlugin.access$1300(this.a).getCloseImageViewer().getValue()).booleanValue() == false) goto L7;
            ImageViewerPlugin.access$2102(this.a, null);
            goto L7
        }

        @Override // uw4.c
        public final void b(String r3) {
            ImageViewerPlugin.access$1900(this.a);
            ImageViewerPlugin.access$1300(this.a).closeImageViewer(r3);
            ImageViewerPlugin.access$2000(this.a);
            this.a.getHost().findPluginToDo(MultiTaskPlugin.class, new n());
            this.a.getHost().findPluginToDo(BaseTemplatePreviewPlugin.class, new o());
        }
    }

    public class e implements tw4.a {
        public final /* synthetic */ ImageViewerPlugin a;

        public e(ImageViewerPlugin r1) {
            this.a = r1;
        }
    }

    public class f implements tw4.c {
        public final /* synthetic */ ImageViewerPlugin a;

        public f(ImageViewerPlugin r1) {
            this.a = r1;
        }

        public final void a(String r5) {
            r15.a r0 = ImageViewerPlugin.access$2400(this.a);
            ((HashMap) r0.a).put("preview_viable", DiagramData$RESULT.SUCCESS);
            Map<String, Object> r1 = r0.a;
            HashMap r2 = (HashMap) r1;
            r2.put("object_id", du5.b.g(r5));
            ((HashMap) r0.a).put("object_file_type", "png");
            com.bytedance.ee.bear.contract.d r6 = r0.b;
            if (r6 == null) goto L6;
            r6.n("ccm_drive_page_view", r0.a);
            return;
        }

        public final void b(ImageType r2) {
            r15.a r0 = ImageViewerPlugin.access$2400(this.a);
            r0.getClass();
            if (r2 == null) goto L6;
            r0.c = r2.name().toLowerCase();
            return;
        }
    }

    public class g implements tb5.i<Void> {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            Void r3 = (Void) r1;
            tt5.a.h(ImageViewerPlugin.TAG, "CloseImgViewerHandler handle(): ");
            if (ImageViewerPlugin.access$1300(this.a) == null) goto L6;
            ImageViewerPlugin.access$1300(this.a).setCloseImageViewer(Boolean.TRUE);
            return;
        }
    }

    public class h implements tb5.i<DeleteImageData> {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            DeleteImageData r4 = (DeleteImageData) r2;
            tt5.a.b(ImageViewerPlugin.TAG, "updateDeleteImageData...");
            if (r4 != null) goto L5;
            tt5.a.d(ImageViewerPlugin.TAG, "JS request delete image data is null");
            return;
        L5:
            ImageViewerPlugin.access$1300(this.a).updateDeleteImageData(r4);
        }
    }

    public class i implements tb5.i<EnterAreaCommentParams> {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r9, tb5.m r10) {
            EnterAreaCommentParams r11 = (EnterAreaCommentParams) r9;
            if (r11 != null) goto L5;
            tt5.a.k(ImageViewerPlugin.TAG, "JS request enter area comment data is null");
            return;
        L5:
            tt5.a.h(ImageViewerPlugin.TAG, "EnterAreaCommentHandler handle(): " + du5.b.h(r11.getUuid()));
            if (ImageViewerPlugin.access$2100(this.a) != null) goto L8;
        L71:
            tt5.a.k(ImageViewerPlugin.TAG, "image viewer is not showing");
            return;
        L8:
            if (ImageViewerPlugin.access$2100(this.a).isShowing() == false) goto L71;
            if (ImageViewerPlugin.access$1200(this.a) != null) goto L13;
            tt5.a.k(ImageViewerPlugin.TAG, "area comment render is null");
            return;
        L13:
            com.bytedance.ee.bear.document.imageviewer.areacomment.c r12 = ImageViewerPlugin.access$1200(this.a);
            r12.getClass();
            Intrinsics.checkNotNullParameter(r11, "enterAreaCommentParams");
            ImageData.Image r1 = r12.c.c7();
            if (r1 != null) goto L17;
            tt5.a.h("AreaCommentRender", "showReadyAddComment: image is null");
            return;
        L17:
            if (y0.a(r11.getUuid(), r1.getUuid()) == false) goto L70;
            tt5.a.h("AreaCommentRender", "showReadyAddComment: uuid equals");
            com.bytedance.ee.bear.document.imageviewer.areacomment.a r13 = r12.m;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r11, "enterAreaCommentParams");
            if (r13.p == false) goto L25;
            ImageData.Image r0 = r13.b.c7();
            if (r0 == null) goto L25;
            ImageData.Image.a r2 = r0.getTransfromedCommentableArea();
            if (r2 == null) goto L25;
            r13.f.setCommentableAreaPercent(new RectF(r2.a, r2.b, r2.c, r2.d));
        L25:
            AreaCommentMode.a r3 = AreaCommentMode.Companion;
            String r4 = r11.getMode();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "value");
            AreaCommentMode[] r5 = AreaCommentMode.values();
            int r6 = r5.length;
            boolean r7 = false;
            int r8 = 0;
        L26:
            SubsamplingScaleImageView r14 = null;
            if (r8 >= r6) goto L32;
            AreaCommentMode r16 = r5[r8];
            if (Intrinsics.areEqual(AreaCommentMode.access$getValue$p(r16), r4) == true) goto L33;
            r8 = r8 + 1;
        L33:
            if (r16 != null) goto L35;
            r16 = AreaCommentMode.CREATE;
        L35:
            r13.n = r16;
            r13.o = new s15.a(r11.getCommentId(), r11.getReplyId());
            LargeImageView r17 = r13.b.iF();
            if ((r17 instanceof LargeImageView) == false) goto L38;
            LargeImageView r18 = r17;
        L39:
            if (r18 == null) goto L41;
            ImageView r19 = r18.getImageView();
        L42:
            if (r18 == null) goto L45;
            r14 = r18.getScaleImageView();
        L45:
            if (r19 != null) goto L47;
        L49:
            boolean r20 = false;
        L51:
            if (r20 == true) goto L53;
        L60:
            if (r14 != null) goto L62;
        L64:
            if (r7 == true) goto L66;
            tt5.a.h("ImageCommentAreaView", "showReadyAddComment: scaleImageView has no image");
            return;
        L66:
            tt5.a.h("ImageCommentAreaView", "showReadyAddComment: scaleImageView ready=" + r14.b1 + ", loaded=" + r14.g1);
            if (r14.g1 == false) goto L69;
            r13.b(r14);
            return;
        L69:
            r14.setOnImageEventListener(new com.bytedance.ee.bear.document.imageviewer.areacomment.b(r14, r13));
            return;
        L62:
            if (r14.u() != true) goto L64;
            r7 = true;
            goto L64
        L53:
            if (r19.getDrawable() == null) goto L60;
            if (r19.getDrawable().getIntrinsicWidth() > 0) goto L57;
        L59:
            tt5.a.h("ImageCommentAreaView", "showReadyAddComment: imageView size invalid");
            return;
        L57:
            if (r19.getDrawable().getIntrinsicHeight() <= 0) goto L59;
            Bitmap r21 = Bitmap.createBitmap(r19.getDrawable().getIntrinsicWidth(), r19.getDrawable().getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            r19.getDrawable().draw(new Canvas(r21));
            r13.c(r21);
            return;
        L47:
            if (r19.getVisibility() != 0) goto L49;
            r20 = true;
            goto L51
        L41:
            r19 = null;
            goto L42
        L38:
            r18 = null;
            goto L39
        L32:
            r16 = null;
            goto L33
        L70:
            tt5.a.h("AreaCommentRender", "showReadyAddComment: uuid not equals");
        }
    }

    public class j implements tb5.i<NonProguard> {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public j(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            NonProguard r3 = (NonProguard) r1;
            tt5.a.h(ImageViewerPlugin.TAG, "ExitAreaCommentHandler handle(): ");
            if (ImageViewerPlugin.access$1200(this.a) != null) goto L5;
            tt5.a.k(ImageViewerPlugin.TAG, "area comment render is null");
            return;
        L5:
            com.bytedance.ee.bear.document.imageviewer.areacomment.a r4 = ImageViewerPlugin.access$1200(this.a).m;
            ViewGroup r5 = r4.b.getContainerView();
            if (r5 == null) goto L10;
            r5.removeView(r4.f);
            return;
        }
    }

    public class k implements tb5.i<ImageCardsData> {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            ImageCardsData r4 = (ImageCardsData) r2;
            if (r4 != null) goto L5;
            tt5.a.d(ImageViewerPlugin.TAG, "JS request image comments is null");
            return;
        L5:
            tt5.a.h(ImageViewerPlugin.TAG, "ImageCommentHandler, handle()...");
            ImageViewerPlugin.access$1300(this.a).updateCardsData(r4);
            if (ImageViewerPlugin.access$1200(this.a) == null) goto L10;
            ImageViewerPlugin.access$1200(this.a).f();
            return;
        }
    }

    public interface l {
    }

    public class m implements tb5.i<ImageDataModel> {
        public final /* synthetic */ ImageViewerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public m(ImageViewerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r6, tb5.m r7) {
            ImageDataModel r8 = (ImageDataModel) r6;
            ImageViewerPlugin.access$2502(this.a, r7);
            if (r8 == null) goto L28;
            tt5.a.h(ImageViewerPlugin.TAG, "OpenImageHandler, handle()... " + r8.getToolbarStatusLog());
            if ((ImageViewerPlugin.access$2600(this.a) & KeyboardUtils.isSoftShowing(ImageViewerPlugin.access$2700(this.a))) == false) goto L7;
            KeyboardUtils.hideKeyboard(ImageViewerPlugin.access$2800(this.a));
        L7:
            ImageViewerPlugin.access$2602(this.a, false);
            com.bytedance.ee.bear.appsetting.c r9 = com.bytedance.ee.bear.appsetting.c.a.a;
            if (r9.i("spacekit.mobile.img_viewer_anim_enable", false) == true) goto L13;
            if (r8.getImage() == null) goto L13;
            r8.getImage().setPosition(null);
        L13:
            if (r8.hasValidEnterAnimator() == true) goto L15;
        L17:
            EditPanelsManager r1 = (EditPanelsManager) ViewModelProviders.of(ImageViewerPlugin.access$2900(this.a)).get(EditPanelsManager.class);
            if (r9.h("ccm.mobile.area_comment_polish_for_ms") == true) goto L20;
            r1.forceCloseToolbarV2();
        L26:
            ImageViewerPlugin.access$3100(this.a, r8);
            ImageViewerPlugin.access$1300(this.a).openImage(r8);
            return;
        L20:
            if (ImageViewerPlugin.access$2100(this.a) != null) goto L22;
        L24:
            r1.requestNotFocus(ImageViewerPlugin.access$3000(this.a));
            goto L26
        L22:
            if (ImageViewerPlugin.access$2100(this.a).isShowing() == false) goto L24;
            tt5.a.h(ImageViewerPlugin.TAG, "image viewer is showing");
            goto L26
        L15:
            if (this.a.getEditorAbility() == null) goto L17;
            ImageData.Position r2 = r8.getImage().getPosition();
            int[] r3 = new int[2];
            this.a.getEditorAbility().getContentView().getLocationInWindow(r3);
            r2.y += com.bytedance.ee.util.ui.n.E(r3[1]);
            goto L17
        }
    }

    public static /* synthetic */ void a(ImageViewerPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$3(r1);
    }

    public static /* synthetic */ void c(ImageViewerPlugin r0, ImageDataModel r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void d(ImageViewerPlugin r0, ru5.d r1) {
        r0.lambda$processOrientationChange$4(r1);
    }

    public static /* synthetic */ void e(ImageViewerPlugin r0, ImageCardsData r1) {
        r0.lambda$onAttachToHost$2(r1);
    }

    public static /* synthetic */ void f(ImageViewerPlugin r0, DeleteImageData r1) {
        r0.updateDeleteImageData(r1);
    }

    public static /* synthetic */ void g(ImageViewerPlugin r0, String r1) {
        r0.lambda$addFragment$5(r1);
    }

    public static /* synthetic */ void h(ImageViewerPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return false;
    }

    private void closeImageViewer() {
        IImageViewer r0 = this.mImageViewer;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    private void destroyImageComment() {
        com.bytedance.ee.bear.document.imageviewer.areacomment.c r0 = this.mAreaCommentRender;
        if (r0 == null) goto L14;
        tt5.a.h("AreaCommentRender", "onDestroy");
        r0.c.hl(IImageViewer.ImageCommentMode.EXIT);
        com.bytedance.ee.bear.document.comment.e r1 = r0.h;
        com.bytedance.ee.bear.document.imageviewer.areacomment.c.d r3 = r0.l;
        com.bytedance.ee.bear.document.comment.d r2 = (com.bytedance.ee.bear.document.comment.d) r1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r2.b).remove(r3);
        r0.o.getClass();
        tt5.a.h("ImageCommentAreaView", "onDestroy");
        com.bytedance.ee.bear.document.imageviewer.areacomment.a r4 = r0.m;
        ViewGroup r5 = r4.b.getContainerView();
        if (r5 == null) goto L7;
        r5.removeView(r4.f);
    L7:
        ValueAnimator r6 = r0.r;
        if (r6 == null) goto L10;
        r6.cancel();
    L10:
        com.bytedance.ee.bear.document.imageviewer.areacomment.d r7 = r0.s;
        if (r7 == null) goto L13;
        com.bytedance.ee.util.ui.j.e(r7);
    L13:
        com.bytedance.ee.util.ui.j.e(r0.q);
        r0.v.detach();
    L14:
        this.mAreaCommentRender = null;
    }

    private void initImageComment() {
        if (this.areaCommentReadEnable == true) goto L7;
        tt5.a.d(TAG, "initImageComment, areaCommentReadEnable is false");
        return;
    L7:
        if (isUIContainerAttached() == true) goto L10;
        tt5.a.d(TAG, "initImageComment, uiContainer not attached");
        return;
    L10:
        CommentPlugin r7 = (CommentPlugin) getHost().findPlugin(CommentPlugin.class);
        if (r7 != null) goto L15;
        tt5.a.d(TAG, "initImageComment, commentPlugin is null");
        return;
    L15:
        if (this.mImageViewer != null) goto L18;
        tt5.a.d(TAG, "initImageComment, imageViewer is null");
        return;
    L18:
        this.mAreaCommentRender = new com.bytedance.ee.bear.document.imageviewer.areacomment.c(getContext(), this.imageViewerViewModel, this.mImageViewer, this, r7);
    }

    private void processOrientationChange() {
        BaseSensorOrientationDetectorPlugin r0 = (BaseSensorOrientationDetectorPlugin) findPlugin(BaseSensorOrientationDetectorPlugin.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mLandScapeObserver != null) goto L8;
        this.mLandScapeObserver = new r15.b(this);
    L8:
        r0.getOrientation().observe(getLifecycleOwner(), this.mLandScapeObserver);
    }

    private void resetData() {
        this.imageViewerViewModel.updateDeleteImageData(null);
        this.imageViewerViewModel.updateCardsData(null);
        this.imageViewerViewModel.updateImageData(null);
        BaseDiagramPlugin r0 = (BaseDiagramPlugin) findPlugin(BaseDiagramPlugin.class);
        if (r0 == null) goto L6;
        r0.unregisterDiagramBase64DataRequestListener();
        return;
    }

    private void showCommentCard() {
        this.mAnalytic.b("send_comment");
        if (this.mImageCardsData != null) goto L6;
        tt5.a.d(TAG, "showCommentCard(), imageCommentData is null");
        return;
    L6:
        String r0 = this.mImageViewer.mC();
        CardCommentData r2 = this.mImageCardsData.getData().get(r0);
        if (r2.isCommentable() == true) goto L10;
        tt5.a.h(TAG, "can not comment");
        return;
    L10:
        List<Card> r1 = r2.getComments();
        if (r1 != null) goto L13;
    L16:
        this.imageViewerViewModel.showCommentInput(r0);
        return;
    L13:
        if (r1.size() == 0) goto L16;
        this.imageViewerViewModel.showCommentCards(r0, this.mImageCardsData);
    }

    private void updateImageCommentData() {
        tt5.a.h(TAG, "updateImageCommentData");
        if (this.mImageViewer != null) goto L5;
        return;
    L5:
        ImageCardsData r2 = this.mImageCardsData;
        if (r2 != null) goto L8;
    L44:
        ImageCommentData r3 = null;
    L45:
        tt5.a.h(TAG, "updateImageCommentData");
        this.mImageViewer.JB(r3);
        return;
    L8:
        if (r2.getData() == null) goto L44;
        if (this.mImageCardsData.getData().isEmpty() == true) goto L44;
        r3 = new ImageCommentData();
        Iterator<Map.Entry<String, CardCommentData>> r4 = this.mImageCardsData.getData().entrySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L45;
        Map.Entry<String, CardCommentData> r5 = r4.next();
        String r6 = r5.getKey();
        CardCommentData r7 = r5.getValue();
        boolean r8 = false;
        if (r7 != null) goto L17;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L38;
        int r10 = 0;
        int r11 = 0;
    L25:
        if (r10 >= r7.getComments().size()) goto L39;
        int r12 = ((Card) ListProtector.get(r7.getComments(), r10)).getCommentType();
        if (r12 != 0) goto L35;
        List<CommentBean.CommentDetail> r13 = ((Card) ListProtector.get(r7.getComments(), r10)).getCommentList();
        if (r13 == null) goto L37;
        r11 = r11 + r13.size();
        if (r13.size() < 1) goto L37;
        if (((CommentBean.CommentDetail) ListProtector.get(r13, 0)).getReply_id().equals("fake_reply_id") == false) goto L37;
        r11 = r11 - 2;
    L37:
        r10 = r10 + 1;
        goto L25
    L35:
        if (r12 != 1) goto L37;
        r11 = r11 + 1;
    L39:
        if (r7 == null) goto L43;
        if (r7.isCommentable() == false) goto L43;
        r8 = true;
    L43:
        r3.setCommentInfo(r6, r8, r11);
        goto L13
    L38:
        r11 = 0;
        goto L39
    L17:
        if (r7.getComments() == null) goto L21;
        if (r7.getComments().size() == 0) goto L21;
        r9 = true;
        goto L22
    }

    public int getCurrIndex() {
        return this.imageViewerViewModel.getCurrIndex();
    }

    public LiveData<Boolean> getIsActive() {
        if (this.mIsActive != null) goto L6;
        this.mIsActive = new MutableLiveData();
    L6:
        return this.mIsActive;
    }

    public ImageViewerPlugin() {
        this.isFirstOpen = true;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.areaCommentReadEnable = r0.g("ccm.doc.image_region_comment_view");
        this.areaCommentAddEnable = r0.g("ccm.doc.image_region_comment_add");
        this.slideAreaCommentEnable = r0.g("ccm.slides.image_area_comment_enabled");
        boolean r1 = ImageCommentInterfaceConfig.getValue().uniform_interface_enable;
        this.uniformInterface = r1;
        tt5.a.h(TAG, "uniformInterface = " + r1);
    }

    private BearUrl getBearUrl() {
        if (getDocumentMetadata() != null) goto L7;
        return null;
    L7:
        return getDocumentMetadata().getBearUrl();
    }

    public static /* synthetic */ boolean access$1100(ImageViewerPlugin r0) {
        return r0.areaCommentReadEnable;
    }

    public static /* synthetic */ com.bytedance.ee.bear.document.imageviewer.areacomment.c access$1200(ImageViewerPlugin r0) {
        return r0.mAreaCommentRender;
    }

    public static /* synthetic */ ImageViewerViewModel access$1300(ImageViewerPlugin r0) {
        return r0.imageViewerViewModel;
    }

    public static /* synthetic */ ImageDataModel access$1400(ImageViewerPlugin r0) {
        return r0.mCurrentImageData;
    }

    public static /* synthetic */ l access$1500(ImageViewerPlugin r0) {
        return r0.onCommentClickListener;
    }

    public static /* synthetic */ void access$1600(ImageViewerPlugin r0) {
        r0.showCommentCard();
    }

    public static /* synthetic */ void access$1800(ImageViewerPlugin r0) {
        r0.initImageComment();
    }

    public static /* synthetic */ void access$1900(ImageViewerPlugin r0) {
        r0.destroyImageComment();
    }

    public static /* synthetic */ void access$2000(ImageViewerPlugin r0) {
        r0.resetData();
    }

    public static /* synthetic */ IImageViewer access$2100(ImageViewerPlugin r0) {
        return r0.mImageViewer;
    }

    public static /* synthetic */ r15.a access$2400(ImageViewerPlugin r0) {
        return r0.mAnalytic;
    }

    public static /* synthetic */ boolean access$2600(ImageViewerPlugin r0) {
        return r0.isFirstOpen;
    }

    public static /* synthetic */ FragmentActivity access$2700(ImageViewerPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$2800(ImageViewerPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$2900(ImageViewerPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$3000(ImageViewerPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentManager access$400(ImageViewerPlugin r0) {
        return r0.getFragmentManager();
    }

    public static /* synthetic */ Context access$700(ImageViewerPlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ boolean access$800(ImageViewerPlugin r0) {
        return r0.uniformInterface;
    }

    private void handleImageData(ImageDataModel r4) {
        if (this.slideAreaCommentEnable == true) goto L6;
        tt5.a.h(TAG, "handleImageData, slideAreaCommentEnable is false");
        return;
    L6:
        BearUrl r0 = getBearUrl();
        if (r0 != null) goto L9;
        return;
    L9:
        if ("slides".equals(r0.getType()) == false) goto L16;
        tt5.a.h(TAG, "handleImageData, deal image data");
        RectF r1 = com.bytedance.ee.bear.contract.imageviewer.bean.a.g;
        com.bytedance.ee.bear.contract.imageviewer.bean.a.C0038a.a(r4.getImage());
        Iterator<ImageData.Image> r5 = r4.getImageList().iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        ImageData.Image r2 = r5.next();
        RectF r3 = com.bytedance.ee.bear.contract.imageviewer.bean.a.g;
        com.bytedance.ee.bear.contract.imageviewer.bean.a.C0038a.a(r2);
        goto L12
    L17:
        return;
    }

    private /* synthetic */ void lambda$addFragment$5(String r2) {
        this.imageViewerViewModel.deleteImage(r2);
    }

    private void lambda$onAttachToHost$0(ImageDataModel r3) {
        if (r3 == null) goto L10;
        if (getUIContainer().l(this) != null) goto L8;
        Boolean r0 = Boolean.TRUE;
        if (r0.equals(getIsActive().getValue()) == true) goto L8;
        addFragment(getUIContainer(), r3);
        setIsActiveValue(r0);
    L8:
        this.imageViewerViewModel.setCloseImageViewer(Boolean.FALSE);
    L10:
        if (this.mCurrentImageData == null) goto L12;
        this.mAnalytic.b("refresh_image");
    L12:
        this.mCurrentImageData = r3;
        IImageViewer r1 = this.mImageViewer;
        if (r1 == null) goto L18;
        r1.wn(r3);
        updateImageCommentData();
        com.bytedance.ee.bear.document.imageviewer.areacomment.c r4 = this.mAreaCommentRender;
        if (r4 == null) goto L19;
        r4.f();
        return;
    L19:
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L6;
        closeImageViewer();
        return;
    }

    private void lambda$onAttachToHost$2(ImageCardsData r3) {
        if (this.mImageCardsData == null) goto L5;
        this.mAnalytic.b("refresh_comment");
    L5:
        this.mImageCardsData = r3;
        updateCommentCard(r3);
        updateImageCommentData();
    }

    private /* synthetic */ void lambda$onAttachToHost$3(Boolean r3) {
        tt5.a.h(TAG, "onChanged(): active = " + r3);
        BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(r3) == false) goto L7;
        r0.onOrientationSupportPanelShowing(this);
        return;
    L7:
        r0.onOrientationSupportPanelDismiss(this);
    }

    private void lambda$processOrientationChange$4(ru5.d r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mAnalytic != null) goto L7;
        this.mAnalytic = new r15.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), getBearUrl());
    L7:
        boolean r5 = r4.isLandscape();
        if (getUIContainer().l(this) != null) goto L10;
        boolean r0 = true;
    L11:
        tt5.a.h(TAG, "imageViewer isLandScape  = " + r5 + ",image isClose = " + r0);
        if (r5 == false) goto L21;
        r15.a r6 = this.mAnalytic;
        if (r0 == false) goto L16;
        String r1 = "doc";
    L17:
        r6.getClass();
        HashMap r2 = new HashMap();
        r2.put("source", r1);
        r6.a(r2);
        tt5.a.h("ImageViewerAnalytic", "reportLandScape(): " + r2);
        com.bytedance.ee.bear.contract.d r7 = r6.b;
        if (r7 == null) goto L22;
        r7.v("client_horizontal_screen", r2);
        return;
    L22:
        return;
    L16:
        r1 = "image";
        goto L17
    L21:
        return;
    L10:
        r0 = false;
        goto L11
    }

    private void setIsActiveValue(Boolean r2) {
        getIsActive().setValue(r2);
    }

    private void updateCommentCard(ImageCardsData r3) {
        if (r3 != null) goto L7;
        tt5.a.d(TAG, "updateCommentCard(), imageCommentData is null");
        return;
    L7:
        if (TextUtils.isEmpty(this.mImageCardsData.getCur_comment_id()) == true) goto L11;
        IImageViewer r4 = this.mImageViewer;
        if (r4 == null) goto L13;
        String r5 = r4.mC();
        this.imageViewerViewModel.showCommentCards(r5, this.mImageCardsData);
        return;
    L13:
        return;
    L11:
        tt5.a.h(TAG, "updateCommentCard(), but cur_comment_id is empty");
    }

    private void updateDeleteImageData(DeleteImageData r4) {
        if (r4 != null) goto L6;
        tt5.a.d(TAG, "updateDeleteImageData(): deleteImageData == null");
        return;
    L6:
        if (r4.isSuccess() == false) goto L8;
        Toast.showSuccessText(getContext(), getContext().getString(2131887741), 0);
        closeImageViewer();
        return;
    L8:
        Toast.showFailureText(getContext(), getContext().getString(2131887739), 0);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.openImg", new m(this));
        r3.put("biz.comment.showOuterDocCards", new k(this));
        r3.put("biz.util.deleteImgCallback", new h(this));
        r3.put("biz.util.closeImgViewer", new g(this));
        if (this.areaCommentAddEnable == true) goto L5;
        return;
    L5:
        if (this.areaCommentReadEnable == false) goto L9;
        r3.put("biz.image.enterAreaComment", new i(this));
        r3.put("biz.image.exitAreaComment", new j(this));
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        this.imageViewerViewModel = (ImageViewerViewModel) viewModel(ImageViewerViewModel.class);
        this.mAnalytic = new r15.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), getBearUrl());
        Observer r4 = new r15.d(this);
        this.imageViewerViewModel.getImageData().observe(getLifecycleOwner(), r4);
        this.imageViewerViewModel.getCloseImageViewer().observe(getLifecycleOwner(), new r15.e(this));
        this.imageViewerViewModel.getDeleteImageData().observe(getLifecycleOwner(), new r15.f(this));
        this.imageViewerViewModel.getCardsData().observe(getLifecycleOwner(), new r15.g(this));
        getIsActive().observe(getLifecycleOwner(), new r15.h(this));
    }

    public void setOnCommentClickListener(l r1) {
        this.onCommentClickListener = r1;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$1000(ImageViewerPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$1700(ImageViewerPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ IImageViewer access$2102(ImageViewerPlugin r0, IImageViewer r1) {
        r0.mImageViewer = r1;
        return r1;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$2200(ImageViewerPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$2300(ImageViewerPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ tb5.m access$2502(ImageViewerPlugin r0, tb5.m r1) {
        r0.mOpenCallBack = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$2602(ImageViewerPlugin r0, boolean r1) {
        r0.isFirstOpen = r1;
        return r1;
    }

    public static /* synthetic */ void access$3100(ImageViewerPlugin r0, ImageDataModel r1) {
        r0.handleImageData(r1);
    }

    public static /* synthetic */ void access$500(ImageViewerPlugin r0, Boolean r1) {
        r0.setIsActiveValue(r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$600(ImageViewerPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$900(ImageViewerPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    private void addFragment(t r16, ImageDataModel r17) {
        s r6 = s.a(2130772329, 2130772330, 2130772329, 2130772330);
        BearUrl r1 = getDocumentMetadata().getBearUrl();
        String r3 = "";
        if (getBearUrl() == null) goto L9;
        String r2 = getBearUrl().b;
        String r4 = getBearUrl().h;
        if (r4 == null) goto L8;
        r3 = r4;
    L8:
        String r12 = r2;
        String r5 = r3;
    L11:
        if (TextUtils.equals(r17.getFrom(), FROM_CREATE_AI) == false) goto L13;
        this.mImageViewer = ((sw4.c) org.koin.java.a.a(sw4.c.class)).b(getContext(), r16.getFragmentManager(), r17, TAG, r12, sbb.e.g(r1.getType()), "");
    L14:
        IImageViewer r7 = this.mImageViewer;
        if (r7 != null) goto L18;
        tt5.a.d(TAG, "addFragment err: mImageViewer null");
        return;
    L18:
        r7.mG(new b(this));
        this.mImageViewer.qK(new c(this));
        this.mImageViewer.xJ(new d(this));
        this.mImageViewer.aQ(new r15.c(this));
        this.mImageViewer.c80(new e(this));
        this.mImageViewer.Ob(new f(this));
        return;
    L13:
        String r10 = r12;
        this.mImageViewer = ((sw4.c) org.koin.java.a.a(sw4.c.class)).d(getContext(), r16.getFragmentManager(), r6, r16.c(this), r17, TAG, r10, sbb.e.g(r1.getType()), r5);
        goto L14
    L9:
        r5 = "";
        r12 = r5;
        goto L11
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.imageViewerViewModel.setDelegate(new a(this));
        processOrientationChange();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.imageViewerViewModel.setDelegate(null);
        this.imageViewerViewModel.updateCardsData(null);
    }

    public void onCallback(String r3, String r4, int r5, Map<String, Object> r6) {
        tt5.a.h(TAG, "type = " + r3 + ", mOpenCallBack = " + this.mOpenCallBack);
        if (this.mOpenCallBack == null) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("type", r3);
        r0.put("uuid", r4);
        r0.put("index", Integer.valueOf(r5));
        r0.putAll(r6);
        this.mOpenCallBack.b(r0);
        return;
    }
}
