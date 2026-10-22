package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.Lazy;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.IAbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.imagepipeline.blurhash.BlurDecodeProducer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash2.PreviewBlurHashProducer;
import com.facebook.imagepipeline.blurhash2.PreviewHashConfig;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.fackbook.drawee.DefaultDraweeConfig;
import com.larus.nova.R;
import javax.annotation.Nullable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleDraweeView extends GenericDraweeView {
    private static DraweePlaceHolderConfig sDefaultDraweePlaceHolderConfig;
    private static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    private static boolean sEnableLazySize;
    private static boolean sEnableVisibleOpt;
    private static IAbstractDraweeControllerBuilder sIDraweecontrollerbuildersupplier;
    private Lazy<AbstractDraweeControllerBuilder> mControllerBuilder;

    /* JADX INFO: loaded from: classes23.dex */
    public interface PreviewBlurHashCallBack {
        void blurhashFailed(String r100, String r101);

        void blurhashResult(long r100, Bitmap r101);
    }

    public static void shutDown() {
        sDraweecontrollerbuildersupplier = null;
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder.get();
    }

    static {
        sDraweecontrollerbuildersupplier = getDefaultControllerBuilder(!FrescoCacheMonitorUtil.isControllerBuilderByLazyInit());
        sEnableVisibleOpt = true;
    }

    public Uri getImageUri() {
        DraweeController r100 = getController();
        if ((r100 instanceof AbstractDraweeController) == false) goto L8;
        ImageRequest r101 = ((AbstractDraweeController) r100).getImageRequest();
        if ((r101 instanceof ImageRequest) == true) goto L7;
        return null;
    L7:
        return r101.getSourceUri();
    L8:
        return null;
    }

    public static /* synthetic */ Supplier access$000() {
        return sDraweecontrollerbuildersupplier;
    }

    public static /* synthetic */ IAbstractDraweeControllerBuilder access$200() {
        return sIDraweecontrollerbuildersupplier;
    }

    static /* synthetic */ boolean access$400() {
        return sEnableVisibleOpt;
    }

    public SimpleDraweeView(Context r100) {
        super(r100);
        this.mControllerBuilder = new AnonymousClass1(this);
        init(r100, null);
    }

    public static /* synthetic */ Supplier access$002(Supplier r100) {
        sDraweecontrollerbuildersupplier = r100;
        return r100;
    }

    public static /* synthetic */ Supplier access$100(boolean r100) {
        return getDefaultControllerBuilder(r100);
    }

    public static void enableLazySize(boolean r100) {
        sEnableLazySize = r100;
    }

    public static void enableVisibleOpt(boolean r100) {
        sEnableVisibleOpt = r100;
    }

    private static Supplier<? extends AbstractDraweeControllerBuilder> getDefaultControllerBuilder(boolean r100) {
        if (r100 == true) goto L5;
        return null;
    L5:
        DefaultDraweeConfig.f274112c.getClass();
        kotlin.Lazy r101 = DefaultDraweeConfig.f274111b;
        KProperty r102 = DefaultDraweeConfig.f274110a[0];
        return (Supplier) r101.getValue();
    }

    public static void initialize(Supplier<? extends AbstractDraweeControllerBuilder> r100) {
        sDraweecontrollerbuildersupplier = r100;
        sDefaultDraweePlaceHolderConfig = r100.get().getDraweePlaceHolderConfig();
    }

    private void setDefaultPlaceHolder(TypedArray r100) {
        DraweePlaceHolderConfig r101 = sDefaultDraweePlaceHolderConfig;
        if (r101 != null) goto L5;
        return;
    L5:
        setDefaultPlaceHolderImage(r100, r101);
        setDefaultFailureImage(r100, sDefaultDraweePlaceHolderConfig);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(final boolean r100) {
        UiThreadImmediateExecutorService.getInstance().execute(new AnonymousClass6(this, r100));
    }

    public void setActualImageResource(int r100) {
        setActualImageResource(r100, null);
    }

    public void setImageRequest(ImageRequest r100) {
        setController(this.mControllerBuilder.get().setImageRequest(r100).setOldController(getController()).build());
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageResource(int r100) {
        super.setImageResource(r100);
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri r100) {
        setImageURI(r100, null);
    }

    public static void initialize(IAbstractDraweeControllerBuilder r100) {
        sIDraweecontrollerbuildersupplier = r100;
        sDefaultDraweePlaceHolderConfig = r100.getDraweePlaceHolderConfig();
    }

    public void setImageURI(@Nullable String r100) {
        setImageURI(r100, null);
    }

    public SimpleDraweeView(Context r100, GenericDraweeHierarchy r101) {
        super(r100, r101);
        this.mControllerBuilder = new AnonymousClass1(this);
        init(r100, null);
    }

    public static /* synthetic */ void access$301(SimpleDraweeView r100, boolean r101) {
        super.onVisibilityAggregated(r101);
    }

    private void init(Context r100, @Nullable AttributeSet r101) {
    L30:
        th = move-exception;
        if (FrescoSystrace.isTracing() == false) goto L34;
        FrescoSystrace.endSection();
    L34:
        throw th;
    L3:
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("SimpleDraweeView#init");     // Catch: Throwable -> L30
    L6:
        if (isInEditMode() == false) goto L8;
        getHierarchy().setRoundingParams(null);     // Catch: Throwable -> L30
        getTopLevelDrawable().setVisible(true, false);     // Catch: Throwable -> L30
        getTopLevelDrawable().invalidateSelf();     // Catch: Throwable -> L30
    L8:
        if (r101 == null) goto L27;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.actualImageResource, R.attr.actualImageScaleType, R.attr.actualImageUri, R.attr.backgroundImage, R.attr.fadeDuration, R.attr.failureImage, R.attr.failureImageScaleType, R.attr.overlayImage, R.attr.placeholderImage, R.attr.placeholderImageScaleType, R.attr.pressedStateOverlayImage, R.attr.progressBarAutoRotateInterval, R.attr.progressBarImage, R.attr.progressBarImageScaleType, R.attr.retryImage, R.attr.retryImageScaleType, R.attr.roundAsCircle, R.attr.roundBottomEnd, R.attr.roundBottomLeft, R.attr.roundBottomRight, R.attr.roundBottomStart, R.attr.roundTopEnd, R.attr.roundTopLeft, R.attr.roundTopRight, R.attr.roundTopStart, R.attr.roundWithOverlayColor, R.attr.roundedCornerRadius, R.attr.roundingBorderColor, R.attr.roundingBorderPadding, R.attr.roundingBorderWidth, R.attr.viewAspectRatio});     // Catch: Throwable -> L30
    L23:
        th = move-exception;
        r102.recycle();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L11:
        if (r102.hasValue(2) == false) goto L14;
        setImageURI(Uri.parse(r102.getString(2)), null);     // Catch: Throwable -> L23
    L21:
        setDefaultPlaceHolder(r102);     // Catch: Throwable -> L23
        r102.recycle();     // Catch: Throwable -> L30
        goto L27
    L14:
        if (r102.hasValue(0) == false) goto L21;
        int r103 = r102.getResourceId(0, -1);     // Catch: Throwable -> L23
        if (r103 == (-1)) goto L21;
        if (isInEditMode() == false) goto L20;
        setImageResource(r103);     // Catch: Throwable -> L23
        goto L21
    L20:
        setActualImageResource(r103);     // Catch: Throwable -> L23
    L27:
        if (FrescoSystrace.isTracing() == false) goto L38;
        FrescoSystrace.endSection();
        return;
    }

    private void setDefaultFailureImage(TypedArray r100, DraweePlaceHolderConfig r101) {
        if (r100.hasValue(5) == false) goto L6;
        return;
    L6:
        if (r101.getFailureScaleType() != null) goto L8;
        ScalingUtils.ScaleType r102 = ScalingUtils.ScaleType.FIT_XY;
    L9:
        Drawable r103 = r101.getPlaceHolderDrawable();
        if (r103 == null) goto L14;
        getHierarchy().setFailureImage(r103, r102);
        return;
    L14:
        if (r101.getFailureImageDrawableRes() == 0) goto L18;
        getHierarchy().setFailureImage(r101.getFailureImageDrawableRes(), r102);
        return;
    L18:
        if (r101.getFailureImageColorRes() == 0) goto L21;
        getHierarchy().setFailureImage(r101.getFailureImageColorRes(), r102);
        return;
    L21:
        return;
    L8:
        r102 = r101.getFailureScaleType();
        goto L9
    }

    private void setDefaultPlaceHolderImage(TypedArray r100, DraweePlaceHolderConfig r101) {
        if (r100.hasValue(8) == false) goto L6;
        return;
    L6:
        if (r101.getPlaceHolderScaleType() != null) goto L8;
        ScalingUtils.ScaleType r102 = ScalingUtils.ScaleType.FIT_XY;
    L9:
        Drawable r103 = r101.getPlaceHolderDrawable();
        if (r103 == null) goto L14;
        getHierarchy().setPlaceholderImage(r103, r102);
        return;
    L14:
        if (r101.getPlaceHolderImageDrawableRes() == 0) goto L18;
        getHierarchy().setPlaceholderImage(r101.getPlaceHolderImageDrawableRes(), r102);
        return;
    L18:
        if (r101.getPlaceHolderImageColorRes() == 0) goto L21;
        getHierarchy().setPlaceholderImage(r101.getPlaceHolderImageColorRes(), r102);
        return;
    L21:
        return;
    L8:
        r102 = r101.getPlaceHolderScaleType();
        goto L9
    }

    public void setActualImageResource(int r100, @Nullable Object r101) {
        setImageURI(UriUtil.getUriForResourceId(r100), r101);
    }

    public void setBlurHashImage(final String r110, final BlurHashConfig r111) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        FLog.d("SimpleDraweeView", "setBlurHashImage, blurHash is null!");
        return;
    L6:
        DraweeController r100 = getController();
        ImageRequest r101 = null;
        if ((r100 instanceof AbstractDraweeController) == false) goto L11;
        ImageRequest r102 = ((AbstractDraweeController) r100).getImageRequest();
        if ((r102 instanceof ImageRequest) == false) goto L11;
        r101 = r102;
    L11:
        final ImageRequest r103 = r101;
        if (r103 == null) goto L14;
        r103.setPreviewUsed(true);
        r103.setPreviewAlgo(1);
    L14:
        final long r104 = SystemClock.uptimeMillis();
        new BlurDecodeProducer(r110, r111, new AnonymousClass7(this, r111, r104, r103, r110));
    }

    public void setImageURI(Uri r100, @Nullable Object r101) {
        if (sEnableLazySize == false) goto L6;
        if (r100 == null) goto L6;
        AbstractDraweeControllerBuilder r102 = this.mControllerBuilder.get().setCallerContext(r101).setOldController(getController());
        setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.newBuilderWithSource(r100), r102, this));
        return;
    L6:
        setController(this.mControllerBuilder.get().setCallerContext(r101).setUri(r100).setOldController(getController()).build());
    }

    public void setPreviewHashImage(String r100, PreviewHashConfig r101) {
        setPreviewHashImage(r100, r101, null);
    }

    public SimpleDraweeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mControllerBuilder = new AnonymousClass1(this);
        init(r100, r101);
    }

    public void setImageURI(@Nullable String r100, @Nullable Object r101) {
        if (r100 == null) goto L4;
        Uri r102 = Uri.parse(r100);
    L5:
        setImageURI(r102, r101);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public SimpleDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mControllerBuilder = new AnonymousClass1(this);
        init(r100, r101);
    }

    public void setController(@Nullable DraweeController r100, String r101, BlurHashConfig r102) {
        setController(r100);
        if (TextUtils.isEmpty(r101) == true) goto L8;
        setBlurHashImage(r101, r102);
        if ((r100 instanceof AbstractDraweeController) == false) goto L9;
        ((AbstractDraweeController) r100).setEnableHeaderBlurhash(false);
        return;
    L9:
        return;
    }

    public void setImageURI(Uri r100, @Nullable Object r101, boolean r102) {
        if (sEnableLazySize == false) goto L6;
        if (r100 == null) goto L6;
        AbstractDraweeControllerBuilder r103 = this.mControllerBuilder.get().setCallerContext(r101).setOldController(getController()).setEnableHeaderBlurhash(r102);
        setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.newBuilderWithSource(r100), r103, this));
        return;
    L6:
        setController(this.mControllerBuilder.get().setCallerContext(r101).setEnableHeaderBlurhash(r102).setUri(r100).setOldController(getController()).build());
    }

    public void setImageURIWithBlur(Uri r100, String r101, PreviewHashConfig r102) {
        setImageURI(r100, null, false);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        setPreviewHashImage(r101, r102, null);
        return;
    }

    public void setPreviewHashImage(final String r110, final PreviewHashConfig r111, final PreviewBlurHashCallBack r112) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        FLog.d("SimpleDraweeView", "setPreviewHashImage, base64data is null!");
        return;
    L6:
        DraweeController r100 = getController();
        ImageRequest r101 = null;
        if ((r100 instanceof AbstractDraweeController) == false) goto L11;
        ImageRequest r102 = ((AbstractDraweeController) r100).getImageRequest();
        if ((r102 instanceof ImageRequest) == false) goto L11;
        r101 = r102;
    L11:
        final ImageRequest r103 = r101;
        if (r103 == null) goto L19;
        r103.setPreviewUsed(true);
        if (r111 != null) goto L16;
    L18:
        r103.setPreviewAlgo(2);
        goto L19
    L16:
        if (r111.isOptVvic() == false) goto L18;
        r103.setPreviewAlgo(3);
    L19:
        final long r104 = SystemClock.uptimeMillis();
        new PreviewBlurHashProducer(r110, r111, new AnonymousClass2(this, r112, r104, r111, r103, r110), new AnonymousClass3(this, r112, r110));
    }

    public void setImageURI(Uri r100, String r101, BlurHashConfig r102) {
        setImageURI(r100, null, false);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        setBlurHashImage(r101, r102);
        return;
    }

    public void setPreviewHashImage(String r100, String r101, PreviewHashConfig r102) {
        setPreviewHashImage(r100, r101, r102, null);
    }

    public void setImageURI(@Nullable String r100, String r101, BlurHashConfig r102) {
        setImageURI(r100, null);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        setBlurHashImage(r101, r102);
        return;
    }

    public void setImageURI(@Nullable String r100, String r101, String r102) {
        if (r100 == null) goto L5;
        Uri r103 = Uri.parse(r100);
    L6:
        setImageURI(r103, r101, r102, null);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void setImageURI(Uri r100, String r101, String r102) {
        setImageURI(r100, r101, r102, null);
    }

    public SimpleDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.mControllerBuilder = new AnonymousClass1(this);
        init(r100, r101);
    }

    public void setImageURI(Uri r100, String r101, String r102, @Nullable Object r103) {
        if (sEnableLazySize == false) goto L6;
        if (r100 == null) goto L6;
        AbstractDraweeControllerBuilder r104 = this.mControllerBuilder.get().setCallerContext(r103).setOldController(getController());
        setLazySizeAttach(new LazySizeAttach(ImageRequestBuilder.newBuilderWithSource(r100).setPublicKey(r101).setUrlKey(r102), r104, this));
        return;
    L6:
        setController(this.mControllerBuilder.get().setCallerContext(r103).setUri(r100, r101, r102).setOldController(getController()).build());
    }

    public void setPreviewHashImage(String r110, final String r111, final PreviewHashConfig r112, final PreviewBlurHashCallBack r113) {
        if (TextUtils.isEmpty(r111) == false) goto L6;
        FLog.d("SimpleDraweeView", "setPreviewHashImage, base64data is null!");
        return;
    L6:
        DraweeController r100 = getController();
        ImageRequest r101 = null;
        if ((r100 instanceof AbstractDraweeController) == false) goto L11;
        ImageRequest r102 = ((AbstractDraweeController) r100).getImageRequest();
        if ((r102 instanceof ImageRequest) == false) goto L11;
        r101 = r102;
    L11:
        final ImageRequest r103 = r101;
        if (r103 == null) goto L19;
        r103.setPreviewUsed(true);
        if (r112 != null) goto L16;
    L18:
        r103.setPreviewAlgo(2);
        goto L19
    L16:
        if (r112.isOptVvic() == false) goto L18;
        r103.setPreviewAlgo(3);
    L19:
        final long r104 = SystemClock.uptimeMillis();
        new PreviewBlurHashProducer(r111, r110, r112, new AnonymousClass4(this, r113, r104, r112, r103, r111), new AnonymousClass5(this, r113, r111));
    }
}
