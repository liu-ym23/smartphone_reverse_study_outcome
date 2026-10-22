package com.ss.android.lark.widget.photo.preview.image;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.common_selection.SelectionContainer;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.photo.preview.PhotoPagerInitData;
import com.ss.android.lark.widget.photo.preview.adapter.PhotoPagerAdapter;
import com.ss.android.lark.widget.photo.preview.ocr.SelectionMenu;
import com.ss.android.lark.widget.photo.preview.ocr.TextGraphicOverlay;
import com.ss.android.lark.widget.photo.preview.utils.PhotoPagerFgUtils;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.coordinator.PhotoPreviewCoordinator;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.io.File;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u001d2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u001a\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010N\u001a\u00020LH\u0016J\b\u0010O\u001a\u00020LH\u0003J\b\u0010P\u001a\u00020LH\u0003J\b\u0010Q\u001a\u00020LH\u0002J\b\u0010R\u001a\u00020LH\u0002J\u0010\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020XH\u0002J\u0012\u0010Y\u001a\u00020Z*\b\u0012\u0004\u0012\u00020\\0[H\u0002J\u0010\u0010]\u001a\u00020L2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020L2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010a\u001a\u00020L2\b\u0010b\u001a\u0004\u0018\u00010\bJ\b\u0010c\u001a\u00020LH\u0016J\u0010\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020fH\u0016J\u0012\u0010g\u001a\u00020L2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010h\u001a\u00020LH\u0016J\u0012\u0010i\u001a\u00020L2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010j\u001a\u00020L2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010k\u001a\u00020L2\u0006\u0010l\u001a\u00020mH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR#\u0010\u001c\u001a\n \u0012*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\"\u001a\n \u0012*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b#\u0010$R#\u0010&\u001a\n \u0012*\u0004\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010;\u001a\n \u0012*\u0004\u0018\u00010<0<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0016\u001a\u0004\b=\u0010>R#\u0010@\u001a\n \u0012*\u0004\u0018\u00010A0A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0016\u001a\u0004\bB\u0010C¨\u0006o"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/image/LargeImageFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/widget/photopicker/fragment/OnOuterEventListener;", "<init>", "()V", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "mRootView", "Landroid/view/View;", "mLoading", "mCleanedFlag", "Landroid/widget/TextView;", "mCleanedFlagContainer", "Landroid/widget/FrameLayout;", "mCloseFlag", "Landroidx/appcompat/widget/AppCompatImageView;", "scaleImageView", "Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "kotlin.jvm.PlatformType", "getScaleImageView", "()Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "scaleImageView$delegate", "Lkotlin/Lazy;", "errorImageView", "Landroid/widget/ImageView;", "getErrorImageView", "()Landroid/widget/ImageView;", "errorImageView$delegate", "mInfoContainer", "Landroid/view/ViewGroup;", "getMInfoContainer", "()Landroid/view/ViewGroup;", "mInfoContainer$delegate", "mInfoView", "mFailedPathTV", "getMFailedPathTV", "()Landroid/widget/TextView;", "mFailedPathTV$delegate", "mOCRScanView", "Lcom/ss/android/lark/imageocr/view/OCRScanView;", "getMOCRScanView", "()Lcom/ss/android/lark/imageocr/view/OCRScanView;", "mOCRScanView$delegate", "mItemDependency", "Lcom/ss/android/lark/widget/photo/preview/adapter/PhotoPagerAdapter$IItemDependency;", "mIsSecret", "", "mEnableLongClick", "mLargeImageLoadController", "Lcom/ss/android/lark/widget/photo/preview/image/LargeImageLoadController;", "mReleaseBitmapTemporarily", "photoBaseRect", "Landroid/graphics/RectF;", "selectionManager", "Lcom/larksuite/common_selection/SelectionManager;", "selectionMenu", "Lcom/ss/android/lark/widget/photo/preview/ocr/SelectionMenu;", "skipNextMatrixChange", "scheduleShowSelectionMenu", "ocrGraphicOverlay", "Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphicOverlay;", "getOcrGraphicOverlay", "()Lcom/ss/android/lark/widget/photo/preview/ocr/TextGraphicOverlay;", "ocrGraphicOverlay$delegate", "selectionContainer", "Lcom/larksuite/common_selection/SelectionContainer;", "getSelectionContainer", "()Lcom/larksuite/common_selection/SelectionContainer;", "selectionContainer$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "initView", "initSelection", "initViewModel", "uploadImageOCR", "handleOCRFinish", "ocrState", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoOCRState$Finish;", "handleImageOCRResult", "data", "Lcom/ss/android/lark/pb/pan/ImageOCRResponse;", "toRect", "Landroid/graphics/Rect;", "", "Landroid/graphics/Point;", "postShowPhoto", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "showPhotoItem", "setInfoView", "infoView", "onDestroyView", "onPageScrolled", "positionOffsetPixels", "", "onRefreshCurrentPage", "releaseBitmapTemporarily", "onUpdateState", "showResourceDeletedCoverImpl", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LargeImageFragment extends BaseFragment implements hdc.a {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PhotoItem f446627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f446628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f446629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f446630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f446631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f446632i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f446633j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f446634k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f446635l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f446636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f446637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PhotoPagerAdapter.b f446638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f446639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f446640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public n f446641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f446642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f446643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.larksuite.common_selection.i f446644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SelectionMenu f446645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f446646w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f446647x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f446648y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f446649z;

    public static final class a {
        public static LargeImageFragment a(PhotoItem r100, PhotoPagerInitData r101, PhotoPagerAdapter.b r102, View r103) {
            Intrinsics.checkNotNullParameter(r100, "photoItem");
            Intrinsics.checkNotNullParameter(r101, "photoPagerInitData");
            LargeImageFragment r104 = new LargeImageFragment();
            r104.f446639p = r101.isSecret();
            r104.f446640q = r101.getEnableLongClick();
            r104.f446627d = r100;
            r104.f446638o = r102;
            r104.f446635l = r103;
            return r104;
        }
    }

    public static final class b implements edc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LargeImageFragment f446650a;

        @Override // edc.b
        public final Drawable getDrawable() {
            LargeImageFragment r100 = this.f446650a;
            int r101 = LargeImageFragment.A;
            return r100.T90().getImageDrawable();
        }

        public b(LargeImageFragment r100) {
            this.f446650a = r100;
        }
    }

    static {
    }

    public final TextGraphicOverlay S90() {
        return (TextGraphicOverlay) this.f446648y.getValue();
    }

    public final LargeImageView T90() {
        return (LargeImageView) this.f446632i.getValue();
    }

    public final SelectionContainer U90() {
        return (SelectionContainer) this.f446649z.getValue();
    }

    @Override // hdc.a
    public final void releaseBitmapTemporarily() {
        if (this.f446628e == null) goto L5;
        boolean r100 = true;
    L6:
        Log.i("LargeImageFragment", "releaseBitmapTemporarily, isInitialized:" + r100);
        if (r100 == false) goto L15;
        this.f446642s = true;
        SubsamplingScaleImageView r101 = T90().getScaleImageView();
        if (r101 == null) goto L11;
        r101.setVisibility(8);
    L11:
        qlb.a r102 = qlb.a.a((Bitmap) PhotoUtilsNew.f447143b.getValue());
        SubsamplingScaleImageView r103 = T90().getScaleImageView();
        if (r103 == null) goto L16;
        r103.setImage(r102);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public LargeImageFragment() {
        this.f446632i = LazyKt.lazy(new LargeImageFragment$scaleImageView$2(this));
        this.f446633j = LazyKt.lazy(new LargeImageFragment$errorImageView$2(this));
        this.f446634k = LazyKt.lazy(new LargeImageFragment$mInfoContainer$2(this));
        this.f446636m = LazyKt.lazy(new LargeImageFragment$mFailedPathTV$2(this));
        this.f446637n = LazyKt.lazy(new LargeImageFragment$mOCRScanView$2(this));
        this.f446640q = true;
        this.f446643t = new RectF();
        this.f446648y = LazyKt.lazy(new LargeImageFragment$ocrGraphicOverlay$2(this));
        this.f446649z = LazyKt.lazy(new LargeImageFragment$selectionContainer$2(this));
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        n r100 = this.f446641r;
        if (r100 == null) goto L12;
        LargeImageView r101 = r100.f446680d;
        if (r101 == null) goto L11;
        SubsamplingScaleImageView r102 = r101.f426675b;
        if (r102 == null) goto L11;
        if (r102.getVisibility() != 0) goto L11;
        SubsamplingScaleImageView r103 = r101.f426675b;
        r103.G(true);
        r103.G1 = null;
        r103.H1 = null;
        r103.L1 = null;
        r103.M1 = null;
    L11:
        r100.f446678b = null;
        r100.f446679c = null;
        r100.f446680d = null;
        r100.f446681e = null;
    L12:
        this.f446641r = null;
        SubsamplingScaleImageView r104 = T90().getScaleImageView();
        if (r104 == null) goto L18;
        plb.a r105 = r104.f426704g2;
        if (r105 == null) goto L19;
        r105.a();
        return;
    L19:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        PhotoItem r100 = this.f446627d;
        if (r100 == null) goto L5;
        Boolean.valueOf(fdc.a.c(r100)).booleanValue();
        V90(this.f446627d);
    L5:
        PerfPhotoViewMonitor.f447616a.getClass();
        PerfPhotoViewMonitor.d(1);
        if (this.f446642s == false) goto L18;
        Log.i("LargeImageFragment", "restore bitmap");
        this.f446642s = false;
        PhotoItem r101 = this.f446627d;
        if (r101 == null) goto L19;
        File r102 = r101.getPhotoState().getShowFile().getValue();
        if (r102 == null) goto L20;
        n r103 = this.f446641r;
        if (r103 == null) goto L14;
        int r104 = n.f446676f;
        r103.g(r101, r102, new PerfPhotoViewMonitor.b());
    L14:
        SubsamplingScaleImageView r105 = T90().getScaleImageView();
        if (r105 == null) goto L21;
        r105.setVisibility(0);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void V90(PhotoItem r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, this.f446627d) == false) goto L39;
        ResourceType r101 = ResourceType.IMAGE;
        ResourceCleanScene r102 = r100.getResourceCleanScene();
        MessageIdentity r103 = r100.getMessageIdentity();
        if (r103 == null) goto L9;
        String r104 = r103.getSenderTenantId();
    L10:
        acc.d r105 = new acc.d(r101, r102, acc.a.d(r104));
        TextView r106 = this.f446630g;
        if (r106 == null) goto L18;
        Context r107 = getContext();
        if (r107 == null) goto L15;
        String r108 = acc.a.b(r107, r105);
    L16:
        r106.setText(r108);
        goto L18
    L15:
        r108 = null;
    L18:
        if (fdc.a.c(r100) == false) goto L31;
        TextView r109 = this.f446630g;
        if (r109 == null) goto L22;
        r109.setCompoundDrawables(null, UDIconUtils.getIconDrawable(r109.getContext(), R.drawable.ud_icon_warning_outlined, UIUtils.getColor(r109.getContext(), R.color.static_white), new UDDimension.Dp(40)), null, null);
    L22:
        FrameLayout r110 = this.f446631h;
        if (r110 == null) goto L25;
        r110.setVisibility(0);
    L25:
        PhotoPagerAdapter.b r111 = this.f446638o;
        if (r111 == null) goto L28;
        r111.b(r100);
    L28:
        this.f446640q = false;
        View r112 = this.f446629f;
        if (r112 == null) goto L37;
        r112.setVisibility(8);
        return;
    L37:
        return;
    L31:
        FrameLayout r113 = this.f446631h;
        if (r113 == null) goto L34;
        r113.setVisibility(8);
    L34:
        this.f446640q = true;
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        this.f446643t.setEmpty();
        S90().setScaleX(1.0f);
        S90().setScaleY(1.0f);
        S90().setTranslationX(0.0f);
        S90().setTranslationY(0.0f);
        this.f446646w = true;
        this.f446647x = true;
        SelectionMenu r101 = this.f446645v;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // hdc.a
    public final void onPageScrolled(float r100) {
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L6;
        PhotoPreviewCoordinator.Companion.getClass();
        PhotoPreviewCoordinator.a.b(r101).setGalleryDrawableProvider(new b(this));
        return;
    }

    @Override // hdc.a
    public final void onUpdateState(PhotoItem r100) {
        if (r100 == null) goto L5;
        V90(r100);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f446628e;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r102 = null;
    L5:
        this.f446629f = r102.findViewById(R.id.loading);
        View r104 = this.f446628e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r104 = null;
    L8:
        this.f446630g = (TextView) r104.findViewById(R.id.flag_resource_cleaned);
        View r105 = this.f446628e;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r105 = null;
    L11:
        ((AppCompatImageView) r105.findViewById(R.id.error_close)).setOnClickListener(new f(this));
        View r106 = this.f446628e;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r106 = null;
    L14:
        FrameLayout r107 = (FrameLayout) r106.findViewById(R.id.flag_container);
        r107.setVisibility(8);
        this.f446631h = r107;
        PhotoItem r108 = this.f446627d;
        if (r108 == null) goto L17;
        Boolean.valueOf(fdc.a.c(r108)).booleanValue();
        V90(this.f446627d);
    L17:
        View r109 = this.f446635l;
        if (r109 != null) goto L20;
    L27:
        h r110 = new h(this);
        T90().setOnClickListener(r110);
        View r111 = this.f446628e;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        r111 = null;
    L30:
        r111.setOnClickListener(r110);
        if (this.f446640q == true) goto L33;
    L36:
        View r112 = this.f446628e;
        if (r112 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L40:
        this.f446641r = new n(r103.getContext(), new i(this));
        Context r113 = T90().getContext();
        PerfPhotoViewMonitor.f447616a.getClass();
        PerfPhotoViewMonitor.f(2);
        PerfPhotoViewMonitor.f(3);
        UICallbackExecutor.post(new j(r113, this));
        int r114 = com.ss.android.lark.widget.photo.preview.ocr.menu.b.f447104e;
        com.ss.android.lark.widget.photo.preview.ocr.menu.b r115 = com.ss.android.lark.widget.photo.preview.ocr.menu.b.a.b(requireActivity());
        if (r115 == null) goto L45;
        Log.i("LargeImageFragment", "init live text selection");
        this.f446644u = r115.f447105a;
        this.f446645v = r115.f447106b;
        U90().setSelectionManager(this.f446644u);
        S90().setDrawOverlay(false);
        T90().getScaleImageView().setOnMatrixChangedListener(new d(this));
        T90().getScaleImageView().setOnTouchListener(new e(this));
        return;
    L45:
        return;
    L39:
        r103 = r112;
        goto L40
    L33:
        if (PhotoPagerFgUtils.c() == false) goto L35;
        SelectionContainer r116 = U90();
        Function0<Unit> r117 = new LargeImageFragment$initView$4(this);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "handleLongClick");
        r116.f282836j = 1000;
        r116.f282835i = r117;
        goto L36
    L35:
        T90().setOnLongClickListener(new g(this));
        goto L36
    L20:
        if (r109.getParent() == null) goto L26;
        View r118 = this.f446635l;
        if (r118 == null) goto L24;
        ViewParent r119 = r118.getParent();
    L25:
        Intrinsics.checkNotNull(r119, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r119).removeView(this.f446635l);
        goto L26
    L24:
        r119 = null;
    L26:
        ((ViewGroup) this.f446634k.getValue()).addView(this.f446635l);
        ((ViewGroup) this.f446634k.getValue()).setVisibility(0);
        goto L27
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        fsb.f.b().i("Gallery#onCreate");
        this.f446628e = r100.inflate(R.layout.fragment_large_image, r101, false);
        StringBuilder r103 = new StringBuilder("onCreateView, photoItem:");
        PhotoItem r104 = this.f446627d;
        if (r104 == null) goto L5;
        Serializable r105 = r104.getLoadModel();
    L6:
        r103.append(r105);
        Log.d("LargeImageFragment", r103.toString());
        View r106 = this.f446628e;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L10:
        return r106;
    L5:
        r105 = null;
        goto L6
    }
}
