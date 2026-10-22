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
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
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
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.entity.LoadParams;
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

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f219996a;

        public a(ImageViewerPlugin r100) {
            this.f219996a = r100;
        }

        public final void a(String r100, String r101, int r102) {
            this.f219996a.onCallback(r100, r101, r102, new HashMap());
        }
    }

    public class b implements uw4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f219997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f219998b;

        @Override // uw4.b
        public final void d(String r100, FrameLayout r101, LargeImageView r102) {
        }

        @Override // uw4.b
        public final void e() {
            ImageViewerPlugin.access$1300(this.f219998b).closeCommentCards();
        }

        public b(ImageViewerPlugin r100) {
            this.f219998b = r100;
            this.f219997a = true;
        }

        @Override // uw4.b
        public final void a(String r100, int r101) {
            ImageViewerPlugin.access$1300(this.f219998b).loadError(r100, r101);
        }

        @Override // uw4.b
        public final void c(String r100, int r101, View r102) {
            if (ImageViewerPlugin.access$1200(this.f219998b) == null) goto L5;
            ImageViewerPlugin.access$1200(this.f219998b).g(r102);
        L5:
            ImageViewerPlugin.access$1300(this.f219998b).swipe(r100, r101);
        }

        @Override // uw4.b
        public final void b(String r100, int r101, ImageData.Image r102, LargeImageView r103) {
            if (this.f219997a == true) goto L5;
        L13:
            this.f219997a = false;
            if (ImageViewerPlugin.access$1200(this.f219998b) == null) goto L29;
            com.bytedance.ee.bear.document.imageviewer.areacomment.c r104 = ImageViewerPlugin.access$1200(this.f219998b);
            r104.getClass();
            Intrinsics.checkNotNullParameter(r102, "currImage");
            Intrinsics.checkNotNullParameter(r103, "currPageSubView");
            ImageData.Image r105 = r104.f220036c.c7();
            if (r105 == null) goto L18;
            String r106 = r105.getUuid();
        L20:
            if (y0.a(r100, r106) == true) goto L22;
        L27:
            tt5.a.h("AreaCommentRender", "onLoadSuccess: uuid not equals or currPageSubView not equals");
            return;
        L22:
            if (Intrinsics.areEqual(r103, r104.f220042i) == false) goto L27;
            RectF r107 = r104.c();
            if (r107 == null) goto L30;
            r104.b(r107, r104.d());
            return;
        L30:
            return;
        L18:
            r106 = null;
            goto L20
        L29:
            return;
        L5:
            if (ImageViewerPlugin.access$1100(this.f219998b) == false) goto L13;
            ImageDataModel r108 = ImageViewerPlugin.access$1300(this.f219998b).getImageData().getValue();
            if (r108 == null) goto L13;
            if (r108.getImage() == null) goto L13;
            if (TextUtils.equals(r108.getImage().getUuid(), r100) == false) goto L13;
            ImageViewerPlugin.access$1300(this.f219998b).openSuccess(r100, r101);
            goto L13
        }
    }

    public class c implements uw4.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f219999a;

        @Override // uw4.f
        public final void a() {
        }

        @Override // uw4.f
        public final /* synthetic */ void b(String r100, View r101, View r102, VFSPath r103) {
        }

        @Override // uw4.f
        public final void c() {
        }

        public c(ImageViewerPlugin r100) {
            this.f219999a = r100;
        }

        @Override // uw4.f
        public final void d(String r100) {
            if (ImageViewerPlugin.access$1300(this.f219999a) == null) goto L5;
            ImageViewerPlugin.access$1300(this.f219999a).editImage(r100);
            return;
        L5:
            tt5.a.d(ImageViewerPlugin.TAG, "onClickEdit imageViewerViewModel null!!!");
        }

        @Override // uw4.f
        public final void e(String r100) {
            if (ImageViewerPlugin.access$1400(this.f219999a) == null) goto L8;
            if (DocumentType.SHEET_NAME.equals(ImageViewerPlugin.access$1400(this.f219999a).getSource()) == false) goto L8;
            ImageViewerPlugin.access$1300(this.f219999a).commentImage(r100, -1);
            return;
        L8:
            if (ImageViewerPlugin.access$800(this.f219999a) == true) goto L10;
        L12:
            ImageViewerPlugin.access$1600(this.f219999a);
            return;
        L10:
            if (ImageViewerPlugin.access$1500(this.f219999a) == null) goto L12;
            CommentPlugin.a(((u0) ImageViewerPlugin.access$1500(this.f219999a)).f219365a, r100);
        }

        @Override // uw4.f
        public final void f(String r100, float[] r101, Matrix r102) {
            tt5.a.h(ImageViewerPlugin.TAG, "onClickFollowMark...");
            FollowPlugin r103 = (FollowPlugin) ImageViewerPlugin.access$1700(this.f219999a, FollowPlugin.class);
            if (r103 == null) goto L5;
            r103.processEvent(new OpenImageWhiteboard(r100, r101, r102));
            return;
        L5:
            tt5.a.k(ImageViewerPlugin.TAG, "followPlugin is null");
        }
    }

    public class d implements uw4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220000a;

        @Override // uw4.c
        public final void onCreated() {
            ImageViewerPlugin.access$1800(this.f220000a);
            this.f220000a.getHost().findPluginToDo(MultiTaskPlugin.class, new r15.i());
            this.f220000a.getHost().findPluginToDo(BaseTemplatePreviewPlugin.class, new r15.j());
            this.f220000a.getHost().findPluginToDo(BaseTitlePlugin.class, new r15.k());
        }

        public d(ImageViewerPlugin r100) {
            this.f220000a = r100;
        }

        @Override // uw4.c
        public final void a(IImageViewer r100) {
            ImageViewerPlugin.access$1900(this.f220000a);
            ImageViewerPlugin.access$2000(this.f220000a);
            if (ImageViewerPlugin.access$1300(this.f220000a) != null) goto L5;
        L7:
            this.f220000a.getHost().findPluginToDo(BaseTitlePlugin.class, new r15.l());
            if (ImageViewerPlugin.access$1100(this.f220000a) == false) goto L11;
            this.f220000a.getHost().findPluginToDo(CommentPlugin.class, new r15.m());
            return;
        L11:
            return;
        L5:
            if (ImageViewerPlugin.access$1300(this.f220000a).getCloseImageViewer().getValue().booleanValue() == false) goto L7;
            ImageViewerPlugin.access$2102(this.f220000a, null);
            goto L7
        }

        @Override // uw4.c
        public final void b(String r100) {
            ImageViewerPlugin.access$1900(this.f220000a);
            ImageViewerPlugin.access$1300(this.f220000a).closeImageViewer(r100);
            ImageViewerPlugin.access$2000(this.f220000a);
            this.f220000a.getHost().findPluginToDo(MultiTaskPlugin.class, new n());
            this.f220000a.getHost().findPluginToDo(BaseTemplatePreviewPlugin.class, new o());
        }
    }

    public class e implements tw4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220001a;

        public e(ImageViewerPlugin r100) {
            this.f220001a = r100;
        }
    }

    public class f implements tw4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220002a;

        public f(ImageViewerPlugin r100) {
            this.f220002a = r100;
        }

        public final void a(String r100) {
            r15.a r101 = ImageViewerPlugin.access$2400(this.f220002a);
            ((HashMap) r101.f535658a).put("preview_viable", "1");
            Map<String, Object> r102 = r101.f535658a;
            HashMap r103 = (HashMap) r102;
            r103.put("object_id", du5.b.g(r100));
            ((HashMap) r101.f535658a).put("object_file_type", LoadParams.ImageFormat.PNG);
            com.bytedance.ee.bear.contract.d r104 = r101.f535659b;
            if (r104 == null) goto L6;
            r104.n("ccm_drive_page_view", r101.f535658a);
            return;
        }

        public final void b(ImageType r100) {
            r15.a r101 = ImageViewerPlugin.access$2400(this.f220002a);
            r101.getClass();
            if (r100 == null) goto L6;
            r101.f535660c = r100.name().toLowerCase();
            return;
        }
    }

    public class g implements tb5.i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220003a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(ImageViewerPlugin r100) {
            this.f220003a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            Void r102 = (Void) r100;
            tt5.a.h(ImageViewerPlugin.TAG, "CloseImgViewerHandler handle(): ");
            if (ImageViewerPlugin.access$1300(this.f220003a) == null) goto L6;
            ImageViewerPlugin.access$1300(this.f220003a).setCloseImageViewer(Boolean.TRUE);
            return;
        }
    }

    public class h implements tb5.i<DeleteImageData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220004a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(ImageViewerPlugin r100) {
            this.f220004a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            DeleteImageData r102 = (DeleteImageData) r100;
            tt5.a.b(ImageViewerPlugin.TAG, "updateDeleteImageData...");
            if (r102 != null) goto L5;
            tt5.a.d(ImageViewerPlugin.TAG, "JS request delete image data is null");
            return;
        L5:
            ImageViewerPlugin.access$1300(this.f220004a).updateDeleteImageData(r102);
        }
    }

    public class i implements tb5.i<EnterAreaCommentParams> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220005a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public i(ImageViewerPlugin r100) {
            this.f220005a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r110) {
            EnterAreaCommentParams r101 = (EnterAreaCommentParams) r100;
            if (r101 != null) goto L5;
            tt5.a.k(ImageViewerPlugin.TAG, "JS request enter area comment data is null");
            return;
        L5:
            tt5.a.h(ImageViewerPlugin.TAG, "EnterAreaCommentHandler handle(): " + du5.b.h(r101.getUuid()));
            if (ImageViewerPlugin.access$2100(this.f220005a) != null) goto L8;
        L71:
            tt5.a.k(ImageViewerPlugin.TAG, "image viewer is not showing");
            return;
        L8:
            if (ImageViewerPlugin.access$2100(this.f220005a).isShowing() == false) goto L71;
            if (ImageViewerPlugin.access$1200(this.f220005a) != null) goto L13;
            tt5.a.k(ImageViewerPlugin.TAG, "area comment render is null");
            return;
        L13:
            com.bytedance.ee.bear.document.imageviewer.areacomment.c r111 = ImageViewerPlugin.access$1200(this.f220005a);
            r111.getClass();
            Intrinsics.checkNotNullParameter(r101, "enterAreaCommentParams");
            ImageData.Image r102 = r111.f220036c.c7();
            if (r102 != null) goto L17;
            tt5.a.h("AreaCommentRender", "showReadyAddComment: image is null");
            return;
        L17:
            if (y0.a(r101.getUuid(), r102.getUuid()) == false) goto L70;
            tt5.a.h("AreaCommentRender", "showReadyAddComment: uuid equals");
            com.bytedance.ee.bear.document.imageviewer.areacomment.a r112 = r111.f220046m;
            r112.getClass();
            Intrinsics.checkNotNullParameter(r101, "enterAreaCommentParams");
            if (r112.f220024p == false) goto L25;
            ImageData.Image r103 = r112.f220010b.c7();
            if (r103 == null) goto L25;
            ImageData.Image.a r104 = r103.getTransfromedCommentableArea();
            if (r104 == null) goto L25;
            r112.f220014f.setCommentableAreaPercent(new RectF(r104.f217070a, r104.f217071b, r104.f217072c, r104.f217073d));
        L25:
            AreaCommentMode.a r105 = AreaCommentMode.Companion;
            String r106 = r101.getMode();
            r105.getClass();
            Intrinsics.checkNotNullParameter(r106, "value");
            AreaCommentMode[] r107 = AreaCommentMode.values();
            int r108 = r107.length;
            boolean r109 = false;
            int r113 = 0;
        L26:
            SubsamplingScaleImageView r114 = null;
            if (r113 >= r108) goto L32;
            AreaCommentMode r115 = r107[r113];
            if (Intrinsics.areEqual(AreaCommentMode.access$getValue$p(r115), r106) == true) goto L33;
            r113 = r113 + 1;
        L33:
            if (r115 != null) goto L35;
            r115 = AreaCommentMode.CREATE;
        L35:
            r112.f220022n = r115;
            r112.f220023o = new s15.a(r101.getCommentId(), r101.getReplyId());
            View r116 = r112.f220010b.iF();
            if ((r116 instanceof LargeImageView) == false) goto L38;
            LargeImageView r117 = (LargeImageView) r116;
        L39:
            if (r117 == null) goto L41;
            ImageView r118 = r117.getImageView();
        L42:
            if (r117 == null) goto L45;
            r114 = r117.getScaleImageView();
        L45:
            if (r118 != null) goto L47;
        L49:
            boolean r119 = false;
        L51:
            if (r119 == true) goto L53;
        L60:
            if (r114 != null) goto L62;
        L64:
            if (r109 == true) goto L66;
            tt5.a.h("ImageCommentAreaView", "showReadyAddComment: scaleImageView has no image");
            return;
        L66:
            tt5.a.h("ImageCommentAreaView", "showReadyAddComment: scaleImageView ready=" + r114.f426696b1 + ", loaded=" + r114.f426703g1);
            if (r114.f426703g1 == false) goto L69;
            r112.b(r114);
            return;
        L69:
            r114.setOnImageEventListener(new com.bytedance.ee.bear.document.imageviewer.areacomment.b(r114, r112));
            return;
        L62:
            if (r114.u() != true) goto L64;
            r109 = true;
            goto L64
        L53:
            if (r118.getDrawable() == null) goto L60;
            if (r118.getDrawable().getIntrinsicWidth() > 0) goto L57;
        L59:
            tt5.a.h("ImageCommentAreaView", "showReadyAddComment: imageView size invalid");
            return;
        L57:
            if (r118.getDrawable().getIntrinsicHeight() <= 0) goto L59;
            Bitmap r120 = Bitmap.createBitmap(r118.getDrawable().getIntrinsicWidth(), r118.getDrawable().getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            r118.getDrawable().draw(new Canvas(r120));
            r112.c(r120);
            return;
        L47:
            if (r118.getVisibility() != 0) goto L49;
            r119 = true;
            goto L51
        L41:
            r118 = null;
            goto L42
        L38:
            r117 = null;
            goto L39
        L32:
            r115 = null;
            goto L33
        L70:
            tt5.a.h("AreaCommentRender", "showReadyAddComment: uuid not equals");
        }
    }

    public class j implements tb5.i<NonProguard> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220006a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public j(ImageViewerPlugin r100) {
            this.f220006a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            NonProguard r102 = (NonProguard) r100;
            tt5.a.h(ImageViewerPlugin.TAG, "ExitAreaCommentHandler handle(): ");
            if (ImageViewerPlugin.access$1200(this.f220006a) != null) goto L5;
            tt5.a.k(ImageViewerPlugin.TAG, "area comment render is null");
            return;
        L5:
            com.bytedance.ee.bear.document.imageviewer.areacomment.a r103 = ImageViewerPlugin.access$1200(this.f220006a).f220046m;
            ViewGroup r104 = r103.f220010b.getContainerView();
            if (r104 == null) goto L10;
            r104.removeView(r103.f220014f);
            return;
        }
    }

    public class k implements tb5.i<ImageCardsData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220007a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public k(ImageViewerPlugin r100) {
            this.f220007a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            ImageCardsData r102 = (ImageCardsData) r100;
            if (r102 != null) goto L5;
            tt5.a.d(ImageViewerPlugin.TAG, "JS request image comments is null");
            return;
        L5:
            tt5.a.h(ImageViewerPlugin.TAG, "ImageCommentHandler, handle()...");
            ImageViewerPlugin.access$1300(this.f220007a).updateCardsData(r102);
            if (ImageViewerPlugin.access$1200(this.f220007a) == null) goto L10;
            ImageViewerPlugin.access$1200(this.f220007a).f();
            return;
        }
    }

    public interface l {
    }

    public class m implements tb5.i<ImageDataModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageViewerPlugin f220008a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public m(ImageViewerPlugin r100) {
            this.f220008a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            ImageDataModel r102 = (ImageDataModel) r100;
            ImageViewerPlugin.access$2502(this.f220008a, r101);
            if (r102 == null) goto L28;
            tt5.a.h(ImageViewerPlugin.TAG, "OpenImageHandler, handle()... " + r102.getToolbarStatusLog());
            if ((ImageViewerPlugin.access$2600(this.f220008a) & KeyboardUtils.isSoftShowing(ImageViewerPlugin.access$2700(this.f220008a))) == false) goto L7;
            KeyboardUtils.hideKeyboard(ImageViewerPlugin.access$2800(this.f220008a));
        L7:
            ImageViewerPlugin.access$2602(this.f220008a, false);
            com.bytedance.ee.bear.appsetting.c r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
            if (r103.i("spacekit.mobile.img_viewer_anim_enable", false) == true) goto L13;
            if (r102.getImage() == null) goto L13;
            r102.getImage().setPosition(null);
        L13:
            if (r102.hasValidEnterAnimator() == true) goto L15;
        L17:
            EditPanelsManager r104 = (EditPanelsManager) ViewModelProviders.of(ImageViewerPlugin.access$2900(this.f220008a)).get(EditPanelsManager.class);
            if (r103.h("ccm.mobile.area_comment_polish_for_ms") == true) goto L20;
            r104.forceCloseToolbarV2();
        L26:
            ImageViewerPlugin.access$3100(this.f220008a, r102);
            ImageViewerPlugin.access$1300(this.f220008a).openImage(r102);
            return;
        L20:
            if (ImageViewerPlugin.access$2100(this.f220008a) != null) goto L22;
        L24:
            r104.requestNotFocus(ImageViewerPlugin.access$3000(this.f220008a));
            goto L26
        L22:
            if (ImageViewerPlugin.access$2100(this.f220008a).isShowing() == false) goto L24;
            tt5.a.h(ImageViewerPlugin.TAG, "image viewer is showing");
            goto L26
        L15:
            if (this.f220008a.getEditorAbility() == null) goto L17;
            ImageData.Position r105 = r102.getImage().getPosition();
            int[] r106 = new int[2];
            this.f220008a.getEditorAbility().getContentView().getLocationInWindow(r106);
            r105.f217075y += com.bytedance.ee.util.ui.n.E(r106[1]);
            goto L17
        }
    }

    public static /* synthetic */ void a(ImageViewerPlugin r100, Boolean r101) {
        r100.lambda$onAttachToHost$3(r101);
    }

    public static /* synthetic */ void c(ImageViewerPlugin r100, ImageDataModel r101) {
        r100.lambda$onAttachToHost$0(r101);
    }

    public static /* synthetic */ void d(ImageViewerPlugin r100, ru5.d r101) {
        r100.lambda$processOrientationChange$4(r101);
    }

    public static /* synthetic */ void e(ImageViewerPlugin r100, ImageCardsData r101) {
        r100.lambda$onAttachToHost$2(r101);
    }

    public static /* synthetic */ void f(ImageViewerPlugin r100, DeleteImageData r101) {
        r100.updateDeleteImageData(r101);
    }

    public static /* synthetic */ void g(ImageViewerPlugin r100, String r101) {
        r100.lambda$addFragment$5(r101);
    }

    public static /* synthetic */ void h(ImageViewerPlugin r100, Boolean r101) {
        r100.lambda$onAttachToHost$1(r101);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return false;
    }

    private void closeImageViewer() {
        IImageViewer r100 = this.mImageViewer;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    private void destroyImageComment() {
        com.bytedance.ee.bear.document.imageviewer.areacomment.c r100 = this.mAreaCommentRender;
        if (r100 == null) goto L14;
        tt5.a.h("AreaCommentRender", LiveCommonConstants.REASON_ON_DEDTROY);
        r100.f220036c.hl(IImageViewer.ImageCommentMode.EXIT);
        com.bytedance.ee.bear.document.comment.e r101 = r100.f220041h;
        com.bytedance.ee.bear.document.imageviewer.areacomment.c.d r102 = r100.f220045l;
        com.bytedance.ee.bear.document.comment.d r103 = (com.bytedance.ee.bear.document.comment.d) r101;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "listener");
        ((ArrayList) r103.f219292b).remove(r102);
        r100.f220048o.getClass();
        tt5.a.h("ImageCommentAreaView", LiveCommonConstants.REASON_ON_DEDTROY);
        com.bytedance.ee.bear.document.imageviewer.areacomment.a r104 = r100.f220046m;
        ViewGroup r105 = r104.f220010b.getContainerView();
        if (r105 == null) goto L7;
        r105.removeView(r104.f220014f);
    L7:
        ValueAnimator r106 = r100.f220051r;
        if (r106 == null) goto L10;
        r106.cancel();
    L10:
        com.bytedance.ee.bear.document.imageviewer.areacomment.d r107 = r100.f220052s;
        if (r107 == null) goto L13;
        com.bytedance.ee.util.ui.j.e(r107);
    L13:
        com.bytedance.ee.util.ui.j.e(r100.f220050q);
        r100.f220055v.detach();
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
        CommentPlugin r100 = (CommentPlugin) getHost().findPlugin(CommentPlugin.class);
        if (r100 != null) goto L15;
        tt5.a.d(TAG, "initImageComment, commentPlugin is null");
        return;
    L15:
        if (this.mImageViewer != null) goto L18;
        tt5.a.d(TAG, "initImageComment, imageViewer is null");
        return;
    L18:
        this.mAreaCommentRender = new com.bytedance.ee.bear.document.imageviewer.areacomment.c(getContext(), this.imageViewerViewModel, this.mImageViewer, this, r100);
    }

    private void processOrientationChange() {
        BaseSensorOrientationDetectorPlugin r100 = (BaseSensorOrientationDetectorPlugin) findPlugin(BaseSensorOrientationDetectorPlugin.class);
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mLandScapeObserver != null) goto L8;
        this.mLandScapeObserver = new r15.b(this);
    L8:
        r100.getOrientation().observe(getLifecycleOwner(), this.mLandScapeObserver);
    }

    private void resetData() {
        this.imageViewerViewModel.updateDeleteImageData(null);
        this.imageViewerViewModel.updateCardsData(null);
        this.imageViewerViewModel.updateImageData(null);
        BaseDiagramPlugin r100 = (BaseDiagramPlugin) findPlugin(BaseDiagramPlugin.class);
        if (r100 == null) goto L6;
        r100.unregisterDiagramBase64DataRequestListener();
        return;
    }

    private void showCommentCard() {
        this.mAnalytic.b("send_comment");
        if (this.mImageCardsData != null) goto L6;
        tt5.a.d(TAG, "showCommentCard(), imageCommentData is null");
        return;
    L6:
        String r100 = this.mImageViewer.mC();
        CardCommentData r101 = this.mImageCardsData.getData().get(r100);
        if (r101.isCommentable() == true) goto L10;
        tt5.a.h(TAG, "can not comment");
        return;
    L10:
        List<Card> r102 = r101.getComments();
        if (r102 != null) goto L13;
    L16:
        this.imageViewerViewModel.showCommentInput(r100);
        return;
    L13:
        if (r102.size() == 0) goto L16;
        this.imageViewerViewModel.showCommentCards(r100, this.mImageCardsData);
    }

    private void updateImageCommentData() {
        tt5.a.h(TAG, "updateImageCommentData");
        if (this.mImageViewer != null) goto L5;
        return;
    L5:
        ImageCardsData r100 = this.mImageCardsData;
        if (r100 != null) goto L8;
    L44:
        ImageCommentData r101 = null;
    L45:
        tt5.a.h(TAG, "updateImageCommentData");
        this.mImageViewer.JB(r101);
        return;
    L8:
        if (r100.getData() == null) goto L44;
        if (this.mImageCardsData.getData().isEmpty() == true) goto L44;
        r101 = new ImageCommentData();
        Iterator<Map.Entry<String, CardCommentData>> r102 = this.mImageCardsData.getData().entrySet().iterator();
    L13:
        if (r102.hasNext() == false) goto L45;
        Map.Entry<String, CardCommentData> r103 = r102.next();
        String r104 = r103.getKey();
        CardCommentData r105 = r103.getValue();
        boolean r106 = false;
        if (r105 != null) goto L17;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L38;
        int r108 = 0;
        int r109 = 0;
    L25:
        if (r108 >= r105.getComments().size()) goto L39;
        int r110 = ((Card) ListProtector.get(r105.getComments(), r108)).getCommentType();
        if (r110 != 0) goto L35;
        List<CommentBean.CommentDetail> r111 = ((Card) ListProtector.get(r105.getComments(), r108)).getCommentList();
        if (r111 == null) goto L37;
        r109 = r109 + r111.size();
        if (r111.size() < 1) goto L37;
        if (((CommentBean.CommentDetail) ListProtector.get(r111, 0)).getReply_id().equals("fake_reply_id") == false) goto L37;
        r109 = r109 - 2;
    L37:
        r108 = r108 + 1;
        goto L25
    L35:
        if (r110 != 1) goto L37;
        r109 = r109 + 1;
    L39:
        if (r105 == null) goto L43;
        if (r105.isCommentable() == false) goto L43;
        r106 = true;
    L43:
        r101.setCommentInfo(r104, r106, r109);
        goto L13
    L38:
        r109 = 0;
        goto L39
    L17:
        if (r105.getComments() == null) goto L21;
        if (r105.getComments().size() == 0) goto L21;
        r107 = true;
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
        com.bytedance.ee.bear.appsetting.c r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.areaCommentReadEnable = r100.g("ccm.doc.image_region_comment_view");
        this.areaCommentAddEnable = r100.g("ccm.doc.image_region_comment_add");
        this.slideAreaCommentEnable = r100.g("ccm.slides.image_area_comment_enabled");
        boolean r101 = ImageCommentInterfaceConfig.getValue().uniform_interface_enable;
        this.uniformInterface = r101;
        tt5.a.h(TAG, "uniformInterface = " + r101);
    }

    private BearUrl getBearUrl() {
        if (getDocumentMetadata() != null) goto L7;
        return null;
    L7:
        return getDocumentMetadata().getBearUrl();
    }

    public static /* synthetic */ boolean access$1100(ImageViewerPlugin r100) {
        return r100.areaCommentReadEnable;
    }

    public static /* synthetic */ com.bytedance.ee.bear.document.imageviewer.areacomment.c access$1200(ImageViewerPlugin r100) {
        return r100.mAreaCommentRender;
    }

    public static /* synthetic */ ImageViewerViewModel access$1300(ImageViewerPlugin r100) {
        return r100.imageViewerViewModel;
    }

    public static /* synthetic */ ImageDataModel access$1400(ImageViewerPlugin r100) {
        return r100.mCurrentImageData;
    }

    public static /* synthetic */ l access$1500(ImageViewerPlugin r100) {
        return r100.onCommentClickListener;
    }

    public static /* synthetic */ void access$1600(ImageViewerPlugin r100) {
        r100.showCommentCard();
    }

    public static /* synthetic */ void access$1800(ImageViewerPlugin r100) {
        r100.initImageComment();
    }

    public static /* synthetic */ void access$1900(ImageViewerPlugin r100) {
        r100.destroyImageComment();
    }

    public static /* synthetic */ void access$2000(ImageViewerPlugin r100) {
        r100.resetData();
    }

    public static /* synthetic */ IImageViewer access$2100(ImageViewerPlugin r100) {
        return r100.mImageViewer;
    }

    public static /* synthetic */ r15.a access$2400(ImageViewerPlugin r100) {
        return r100.mAnalytic;
    }

    public static /* synthetic */ boolean access$2600(ImageViewerPlugin r100) {
        return r100.isFirstOpen;
    }

    public static /* synthetic */ FragmentActivity access$2700(ImageViewerPlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$2800(ImageViewerPlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$2900(ImageViewerPlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$3000(ImageViewerPlugin r100) {
        return r100.getActivity();
    }

    public static /* synthetic */ FragmentManager access$400(ImageViewerPlugin r100) {
        return r100.getFragmentManager();
    }

    public static /* synthetic */ Context access$700(ImageViewerPlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ boolean access$800(ImageViewerPlugin r100) {
        return r100.uniformInterface;
    }

    private void handleImageData(ImageDataModel r100) {
        if (this.slideAreaCommentEnable == true) goto L6;
        tt5.a.h(TAG, "handleImageData, slideAreaCommentEnable is false");
        return;
    L6:
        BearUrl r101 = getBearUrl();
        if (r101 != null) goto L9;
        return;
    L9:
        if ("slides".equals(r101.getType()) == false) goto L16;
        tt5.a.h(TAG, "handleImageData, deal image data");
        RectF r102 = com.bytedance.ee.bear.contract.imageviewer.bean.a.f217077g;
        com.bytedance.ee.bear.contract.imageviewer.bean.a.C3094a.a(r100.getImage());
        Iterator<ImageData.Image> r103 = r100.getImageList().iterator();
    L12:
        if (r103.hasNext() == false) goto L17;
        ImageData.Image r104 = r103.next();
        RectF r105 = com.bytedance.ee.bear.contract.imageviewer.bean.a.f217077g;
        com.bytedance.ee.bear.contract.imageviewer.bean.a.C3094a.a(r104);
        goto L12
    L17:
        return;
    }

    private /* synthetic */ void lambda$addFragment$5(String r100) {
        this.imageViewerViewModel.deleteImage(r100);
    }

    private void lambda$onAttachToHost$0(ImageDataModel r100) {
        if (r100 == null) goto L10;
        if (getUIContainer().l(this) != null) goto L8;
        Boolean r101 = Boolean.TRUE;
        if (r101.equals(getIsActive().getValue()) == true) goto L8;
        addFragment(getUIContainer(), r100);
        setIsActiveValue(r101);
    L8:
        this.imageViewerViewModel.setCloseImageViewer(Boolean.FALSE);
    L10:
        if (this.mCurrentImageData == null) goto L12;
        this.mAnalytic.b("refresh_image");
    L12:
        this.mCurrentImageData = r100;
        IImageViewer r102 = this.mImageViewer;
        if (r102 == null) goto L18;
        r102.wn(r100);
        updateImageCommentData();
        com.bytedance.ee.bear.document.imageviewer.areacomment.c r103 = this.mAreaCommentRender;
        if (r103 == null) goto L19;
        r103.f();
        return;
    L19:
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L6;
        closeImageViewer();
        return;
    }

    private void lambda$onAttachToHost$2(ImageCardsData r100) {
        if (this.mImageCardsData == null) goto L5;
        this.mAnalytic.b("refresh_comment");
    L5:
        this.mImageCardsData = r100;
        updateCommentCard(r100);
        updateImageCommentData();
    }

    private /* synthetic */ void lambda$onAttachToHost$3(Boolean r100) {
        tt5.a.h(TAG, "onChanged(): active = " + r100);
        BaseUnspecifiedOrientationPlugin r101 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (Boolean.TRUE.equals(r100) == false) goto L7;
        r101.onOrientationSupportPanelShowing(this);
        return;
    L7:
        r101.onOrientationSupportPanelDismiss(this);
    }

    private void lambda$processOrientationChange$4(ru5.d r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mAnalytic != null) goto L7;
        this.mAnalytic = new r15.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), getBearUrl());
    L7:
        boolean r101 = r100.isLandscape();
        if (getUIContainer().l(this) != null) goto L10;
        boolean r102 = true;
    L11:
        tt5.a.h(TAG, "imageViewer isLandScape  = " + r101 + ",image isClose = " + r102);
        if (r101 == false) goto L21;
        r15.a r103 = this.mAnalytic;
        if (r102 == false) goto L16;
        String r104 = "doc";
    L17:
        r103.getClass();
        HashMap r105 = new HashMap();
        r105.put("source", r104);
        r103.a(r105);
        tt5.a.h("ImageViewerAnalytic", "reportLandScape(): " + r105);
        com.bytedance.ee.bear.contract.d r106 = r103.f535659b;
        if (r106 == null) goto L22;
        r106.v("client_horizontal_screen", r105);
        return;
    L22:
        return;
    L16:
        r104 = "image";
        goto L17
    L21:
        return;
    L10:
        r102 = false;
        goto L11
    }

    private void setIsActiveValue(Boolean r100) {
        ((MutableLiveData) getIsActive()).setValue(r100);
    }

    private void updateCommentCard(ImageCardsData r100) {
        if (r100 != null) goto L7;
        tt5.a.d(TAG, "updateCommentCard(), imageCommentData is null");
        return;
    L7:
        if (TextUtils.isEmpty(this.mImageCardsData.getCur_comment_id()) == true) goto L11;
        IImageViewer r101 = this.mImageViewer;
        if (r101 == null) goto L13;
        String r102 = r101.mC();
        this.imageViewerViewModel.showCommentCards(r102, this.mImageCardsData);
        return;
    L13:
        return;
    L11:
        tt5.a.h(TAG, "updateCommentCard(), but cur_comment_id is empty");
    }

    private void updateDeleteImageData(DeleteImageData r100) {
        if (r100 != null) goto L6;
        tt5.a.d(TAG, "updateDeleteImageData(): deleteImageData == null");
        return;
    L6:
        if (r100.isSuccess() == false) goto L8;
        Toast.showSuccessText(getContext(), getContext().getString(R.string.Doc_Facade_DeleteSuccessfully), 0);
        closeImageViewer();
        return;
    L8:
        Toast.showFailureText(getContext(), getContext().getString(R.string.Doc_Facade_DeleteFailedNoNet), 0);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        r100.put("biz.util.openImg", new m(this));
        r100.put("biz.comment.showOuterDocCards", new k(this));
        r100.put("biz.util.deleteImgCallback", new h(this));
        r100.put("biz.util.closeImgViewer", new g(this));
        if (this.areaCommentAddEnable == true) goto L5;
        return;
    L5:
        if (this.areaCommentReadEnable == false) goto L9;
        r100.put("biz.image.enterAreaComment", new i(this));
        r100.put("biz.image.exitAreaComment", new j(this));
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        this.imageViewerViewModel = (ImageViewerViewModel) viewModel(ImageViewerViewModel.class);
        this.mAnalytic = new r15.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), getBearUrl());
        Observer<? super ImageDataModel> r101 = new r15.d(this);
        this.imageViewerViewModel.getImageData().observe(getLifecycleOwner(), r101);
        this.imageViewerViewModel.getCloseImageViewer().observe(getLifecycleOwner(), new r15.e(this));
        this.imageViewerViewModel.getDeleteImageData().observe(getLifecycleOwner(), new r15.f(this));
        this.imageViewerViewModel.getCardsData().observe(getLifecycleOwner(), new r15.g(this));
        getIsActive().observe(getLifecycleOwner(), new r15.h(this));
    }

    public void setOnCommentClickListener(l r100) {
        this.onCommentClickListener = r100;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$1000(ImageViewerPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$1700(ImageViewerPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static /* synthetic */ IImageViewer access$2102(ImageViewerPlugin r100, IImageViewer r101) {
        r100.mImageViewer = r101;
        return r101;
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$2200(ImageViewerPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$2300(ImageViewerPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static /* synthetic */ tb5.m access$2502(ImageViewerPlugin r100, tb5.m r101) {
        r100.mOpenCallBack = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$2602(ImageViewerPlugin r100, boolean r101) {
        r100.isFirstOpen = r101;
        return r101;
    }

    public static /* synthetic */ void access$3100(ImageViewerPlugin r100, ImageDataModel r101) {
        r100.handleImageData(r101);
    }

    public static /* synthetic */ void access$500(ImageViewerPlugin r100, Boolean r101) {
        r100.setIsActiveValue(r101);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$600(ImageViewerPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$900(ImageViewerPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }

    private void addFragment(t r110, ImageDataModel r111) {
        s r100 = s.a(R.anim.image_pager_enter_animation, R.anim.image_pager_exit_animation, R.anim.image_pager_enter_animation, R.anim.image_pager_exit_animation);
        BearUrl r101 = getDocumentMetadata().getBearUrl();
        String r102 = "";
        if (getBearUrl() == null) goto L9;
        String r103 = getBearUrl().f222561b;
        String r104 = getBearUrl().f222567h;
        if (r104 == null) goto L8;
        r102 = r104;
    L8:
        String r112 = r103;
        String r105 = r102;
    L11:
        if (TextUtils.equals(r111.getFrom(), FROM_CREATE_AI) == false) goto L13;
        this.mImageViewer = ((sw4.c) org.koin.java.a.a(sw4.c.class)).b(getContext(), r110.getFragmentManager(), r111, TAG, r112, sbb.e.g(r101.getType()), "");
    L14:
        IImageViewer r106 = this.mImageViewer;
        if (r106 != null) goto L18;
        tt5.a.d(TAG, "addFragment err: mImageViewer null");
        return;
    L18:
        r106.mG(new b(this));
        this.mImageViewer.qK(new c(this));
        this.mImageViewer.xJ(new d(this));
        this.mImageViewer.aQ(new r15.c(this));
        this.mImageViewer.c80(new e(this));
        this.mImageViewer.Ob(new f(this));
        return;
    L13:
        String r113 = r112;
        this.mImageViewer = ((sw4.c) org.koin.java.a.a(sw4.c.class)).d(getContext(), r110.getFragmentManager(), r100, r110.c(this), r111, TAG, r113, sbb.e.g(r101.getType()), r105);
        goto L14
    L9:
        r105 = "";
        r112 = r105;
        goto L11
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.imageViewerViewModel.setDelegate(new a(this));
        processOrientationChange();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.imageViewerViewModel.setDelegate(null);
        this.imageViewerViewModel.updateCardsData(null);
    }

    public void onCallback(String r100, String r101, int r102, Map<String, Object> r103) {
        tt5.a.h(TAG, "type = " + r100 + ", mOpenCallBack = " + this.mOpenCallBack);
        if (this.mOpenCallBack == null) goto L6;
        JSONObject r104 = new JSONObject();
        r104.put2("type", r100);
        r104.put2(ST.UUID_DEVICE, r101);
        r104.put2("index", Integer.valueOf(r102));
        r104.putAll(r103);
        this.mOpenCallBack.b(r104);
        return;
    }
}
