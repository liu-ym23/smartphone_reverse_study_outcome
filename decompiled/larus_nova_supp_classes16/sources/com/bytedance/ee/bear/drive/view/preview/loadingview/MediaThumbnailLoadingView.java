package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.drive.core.thumbnail.DriveThumbnailImageProvider;
import com.bytedance.ee.bear.drive.core.thumbnail.i;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.bytedance.ee.drive.render.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.disposables.Disposable;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0017\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0012\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010.\u001a\u00020#H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020#H\u0002J\u001a\u00101\u001a\u00020#2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020&H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020\u0014H\u0002J\b\u00107\u001a\u00020\u0014H\u0002J\b\u00108\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u001cH\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u001cH\u0002J\u0014\u0010>\u001a\u0004\u0018\u00010?2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010@\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006D"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/loadingview/MediaThumbnailLoadingView;", "Lcom/bytedance/ee/bear/drive/view/preview/loadingview/AbsLoadingView;", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/OnViewNeedReleaseListener;", "context", "Landroid/content/Context;", "parentViewOwner", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;", "fileModel", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;", "mimeTypeInfo", "Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeInfo;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;Lcom/bytedance/ee/bear/drive/view/preview/wrapper/PreviewFileModel;Lcom/bytedance/ee/bear/drive/mimetype/MimeTypeInfo;)V", "componentRenderVM", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/DriveComponentRenderVM;", "imageProvider", "Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageProvider;", "backgroundDisposable", "Lio/reactivex/disposables/Disposable;", "backgroundRequested", "", "released", "rootView", "com/bytedance/ee/bear/drive/view/preview/loadingview/MediaThumbnailLoadingView$rootView$1", "Lcom/bytedance/ee/bear/drive/view/preview/loadingview/MediaThumbnailLoadingView$rootView$1;", "backgroundView", "Landroid/widget/ImageView;", "maskView", "Landroid/view/View;", "progressBar", "Landroid/widget/ProgressBar;", "showRunnable", "Ljava/lang/Runnable;", "getView", "show", "", "setProgress", "progress", "", "setUIConfig", "downloadingUIConfig", "Lcom/bytedance/ee/drive/render/IDriveUIConfig$Downloading;", "releaseKey", "", "getReleaseKey", "()Ljava/lang/String;", "onRelease", "setupViews", "loadBackgroundIfNeeded", "applyBackgroundSource", "source", "Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailImageSource;", "decodeSize", "clearBackground", "isMediaLoadingType", "isImageLoadingType", "isVideoLoadingType", "coverSize", "backgroundDecodeSizePx", "isGlideContextAlive", "view", "isGlideClearSafe", "findActivity", "Landroid/app/Activity;", "dp", "value", "", "Companion", "assemble-office_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaThumbnailLoadingView extends AbsLoadingView implements m85.a {
    public static final a Companion = null;
    private static final int DEFAULT_BACKGROUND_DECODE_SIZE = 120;
    private static final float IMAGE_BACKGROUND_DECODE_SIZE_DP = 30.0f;
    private static final int IMAGE_COVER_SIZE = 120;
    private static final int MASK_ALPHA = 96;
    private static final int PROGRESS_MAX = 100;
    private static final float PROGRESS_SIZE_DP = 48.0f;
    private static final String TAG = "MediaThumbnailLoadingView";
    private static final float VIDEO_BACKGROUND_DECODE_SIZE_DP = 200.0f;
    private static final int VIDEO_COVER_SIZE = 360;
    private Disposable backgroundDisposable;
    private boolean backgroundRequested;
    private final ImageView backgroundView;
    private final DriveComponentRenderVM componentRenderVM;
    private final DriveThumbnailImageProvider imageProvider;
    private final View maskView;
    private final ProgressBar progressBar;
    private final String releaseKey;
    private boolean released;
    private final c rootView;
    private final Runnable showRunnable;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements RequestListener<Bitmap> {
        public final /* synthetic */ MediaThumbnailLoadingView a;
        public final /* synthetic */ i b;
        public final /* synthetic */ int c;

        public b(MediaThumbnailLoadingView r1, i r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final boolean onLoadFailed(GlideException r1, Object r2, Target<Bitmap> r3, boolean r4) {
            tt5.a.l(MediaThumbnailLoadingView.TAG, "[thumbnail download] result=background_load_failed loadingType=" + this.a.mMimeTypeInfo.d + " source=" + this.b + " decodeSize=" + this.c, r1);
            return false;
        }

        public final boolean onResourceReady(Object r1, Object r2, Target r3, DataSource r4, boolean r5) {
            Bitmap r6 = (Bitmap) r1;
            tt5.a.h(MediaThumbnailLoadingView.TAG, "[thumbnail download] result=background_load_success loadingType=" + this.a.mMimeTypeInfo.d + " source=" + this.b + " decodeSize=" + this.c + " dataSource=" + r4);
            return false;
        }
    }

    public static final class c extends FrameLayout {
        public final /* synthetic */ MediaThumbnailLoadingView a;

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (MediaThumbnailLoadingView.access$getComponentRenderVM$p(this.a).needBindReleaseListener() == true) goto L6;
            this.a.onRelease();
            return;
        }

        public c(Context r1, MediaThumbnailLoadingView r2) {
            this.a = r2;
            super(r1);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MediaThumbnailLoadingView a;

        public d(MediaThumbnailLoadingView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (MediaThumbnailLoadingView.access$getReleased$p(this.a) == false) goto L5;
            return;
        L5:
            if (MediaThumbnailLoadingView.access$getRootView$p(this.a).getParent() != null) goto L7;
            return;
        L7:
            if (MediaThumbnailLoadingView.access$getRootView$p(this.a).getVisibility() == 8) goto L18;
            MediaThumbnailLoadingView.access$getRootView$p(this.a).setVisibility(0);     // Catch: Throwable -> L10
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void setUIConfig(k.b r1) {
    }

    private final void clearBackground() {
        if (isGlideClearSafe(this.backgroundView) == false) goto L5;
        Glide.with(this.backgroundView).clear(this.backgroundView);
    L5:
        this.backgroundView.setImageDrawable(null);
    }

    private final boolean isImageLoadingType() {
        if (this.mMimeTypeInfo.d != DriveLocalMime.IMAGE.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isMediaLoadingType() {
        if (this.mMimeTypeInfo.d != DriveLocalMime.IMAGE.getValue()) goto L5;
    L8:
        return true;
    L5:
        if (this.mMimeTypeInfo.d == DriveLocalMime.VIDEO.getValue()) goto L8;
        return false;
    }

    private final boolean isVideoLoadingType() {
        if (this.mMimeTypeInfo.d != DriveLocalMime.VIDEO.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    private final void loadBackgroundIfNeeded() {
        if (this.backgroundRequested == false) goto L5;
        return;
    L5:
        this.backgroundRequested = true;
        String r3 = this.mFileModel.o;
        if (r3 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        boolean r0 = true ^ r1;
        boolean r4 = isMediaLoadingType();
        boolean r5 = isImageLoadingType();
        int r6 = coverSize();
        final int r2 = backgroundDecodeSizePx();
        tt5.a.h(TAG, "[thumbnail download] result=background_start loadingType=" + this.mMimeTypeInfo.d + " hasFileId=" + r0 + " allowRemoteCover=" + r4 + " allowPreviewFallback=" + r5 + " coverSize=" + r6 + " decodeSize=" + r2);
        this.backgroundDisposable = this.imageProvider.d(r3, r4, r5, r6, new AnonymousClass1(this, r2));
        return;
    L8:
        if (StringsKt.isBlank(r3) == true) goto L11;
        r1 = false;
        goto L12
    }

    @Override // m85.a
    public void onRelease() {
        if (this.released == false) goto L5;
        return;
    L5:
        this.released = true;
        this.rootView.removeCallbacks(this.showRunnable);
        Disposable r0 = this.backgroundDisposable;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.backgroundDisposable = null;
        this.imageProvider.e();
        clearBackground();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void show() {
        if (this.rootView.getVisibility() == 8) goto L5;
        this.rootView.setVisibility(4);
    L5:
        loadBackgroundIfNeeded();
        this.rootView.removeCallbacks(this.showRunnable);
        this.rootView.postDelayed(this.showRunnable, 400);
    }

    private final int backgroundDecodeSizePx() {
        if (isImageLoadingType() == false) goto L6;
        return dp(this.rootView.getContext(), IMAGE_BACKGROUND_DECODE_SIZE_DP);
    L6:
        if (isVideoLoadingType() == true) goto L11;
        return 120;
    L11:
        return dp(this.rootView.getContext(), VIDEO_BACKGROUND_DECODE_SIZE_DP);
    }

    private final int coverSize() {
        if (isVideoLoadingType() == false) goto L5;
        return VIDEO_COVER_SIZE;
    L5:
        return 120;
    }

    @Override // m85.a
    public String getReleaseKey() {
        return this.releaseKey;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public View getView() {
        return this.rootView;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_ee_bear_drive_view_preview_loadingview_MediaThumbnailLoadingView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final /* synthetic */ DriveComponentRenderVM access$getComponentRenderVM$p(MediaThumbnailLoadingView r0) {
        return r0.componentRenderVM;
    }

    public static final /* synthetic */ boolean access$getReleased$p(MediaThumbnailLoadingView r0) {
        return r0.released;
    }

    public static final /* synthetic */ c access$getRootView$p(MediaThumbnailLoadingView r0) {
        return r0.rootView;
    }

    private final Activity findActivity(Context r2) {
        if ((r2 instanceof Activity) == false) goto L6;
        return (Activity) r2;
    L6:
        if ((r2 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return findActivity(((ContextWrapper) r2).getBaseContext());
    }

    private final boolean isGlideClearSafe(View r2) {
        if (isGlideContextAlive(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (ViewCompat.isAttachedToWindow(r2) == false) goto L7;
        return true;
    }

    private final boolean isGlideContextAlive(View r2) {
        Activity r3 = findActivity(r2.getContext());
        if (r3 != null) goto L5;
    L10:
        return true;
    L5:
        if (r3.isFinishing() == false) goto L7;
    L9:
        return false;
    L7:
        if (r3.isDestroyed() == true) goto L9;
        goto L9
    }

    private final void setupViews(Context r6) {
        this.rootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.rootView.setBackgroundColor(-16777216);
        this.rootView.setVisibility(4);
        this.backgroundView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.backgroundView.setBackgroundColor(-16777216);
        this.rootView.addView(this.backgroundView, new FrameLayout.LayoutParams(-1, -1));
        this.maskView.setBackgroundColor(Color.argb(MASK_ALPHA, 0, 0, 0));
        this.rootView.addView(this.maskView, new FrameLayout.LayoutParams(-1, -1));
        this.progressBar.setIndeterminate(false);
        this.progressBar.setMax(100);
        this.progressBar.setProgress(0);
        this.progressBar.setSecondaryProgress(0);
        ProgressBar r0 = this.progressBar;
        Drawable r1 = ContextCompat.getDrawable(r6, 2131244667);
        if (r1 == null) goto L5;
        Drawable r2 = r1.mutate();
    L6:
        r0.setProgressDrawable(r2);
        this.progressBar.setProgressTintList(null);
        this.progressBar.setProgressBackgroundTintList(null);
        this.progressBar.setSecondaryProgressTintList(null);
        this.progressBar.setIndeterminateTintList(null);
        this.rootView.addView(this.progressBar, new FrameLayout.LayoutParams(dp(r6, PROGRESS_SIZE_DP), dp(r6, PROGRESS_SIZE_DP), 17));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void setProgress(int r4) {
        this.progressBar.setProgress(RangesKt.coerceIn(r4, 0, 100));
    }

    private final void applyBackgroundSource(i r4, int r5) {
        if (this.released == false) goto L6;
        return;
    L6:
        if (r4 != null) goto L10;
        tt5.a.h(TAG, "[thumbnail download] result=background_source_empty loadingType=" + this.mMimeTypeInfo.d + " source=none decodeSize=" + r5);
        return;
    L10:
        if (isGlideContextAlive(this.backgroundView) == true) goto L14;
        tt5.a.k(TAG, "[thumbnail download] result=background_context_invalid loadingType=" + this.mMimeTypeInfo.d + " source=" + r4 + " decodeSize=" + r5 + " reason=invalidContext");
        return;
    L14:
        if ((r4 instanceof i.a) == false) goto L17;
        File r0 = ((i.a) r4).a;
    L19:
        Glide.with(this.backgroundView).asBitmap().load(r0).format(DecodeFormat.PREFER_RGB_565).override(r5, r5).fitCenter().dontAnimate().placeholder(new ColorDrawable(-16777216)).error(new ColorDrawable(-16777216)).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).listener(new b(this, r4, r5)).into(this.backgroundView);
        return;
    L17:
        if ((r4 instanceof i.b) == false) goto L22;
        r0 = ((i.b) r4).a;
        goto L19
    L22:
        throw new NoWhenBranchMatchedException();
    }

    private final int dp(Context r2, float r3) {
        return (int) TypedValue.applyDimension(1, r3, INVOKEVIRTUAL_com_bytedance_ee_bear_drive_view_preview_loadingview_MediaThumbnailLoadingView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r2.getResources()));
    }

    public static final /* synthetic */ void access$applyBackgroundSource(MediaThumbnailLoadingView r0, i r1, int r2) {
        r0.applyBackgroundSource(r1, r2);
    }

    public MediaThumbnailLoadingView(Context r2, ViewOwner r3, z r4, g85.e r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parentViewOwner");
        Intrinsics.checkNotNullParameter(r4, "fileModel");
        Intrinsics.checkNotNullParameter(r5, "mimeTypeInfo");
        super(r2, r3, r4, r5);
        DriveComponentRenderVM r6 = (DriveComponentRenderVM) r3.viewModel(DriveComponentRenderVM.class);
        this.componentRenderVM = r6;
        this.imageProvider = new DriveThumbnailImageProvider();
        this.rootView = new c(r2, this);
        this.backgroundView = new ImageView(r2);
        this.maskView = new View(r2);
        this.progressBar = new ProgressBar(r2, null, R.attr.progressBarStyleHorizontal);
        this.showRunnable = new d(this);
        r6.bindReleaseListener(this);
        setupViews(r2);
        this.releaseKey = TAG;
    }
}
