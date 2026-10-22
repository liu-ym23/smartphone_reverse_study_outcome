package androidx.camera.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.compose.material3.MenuKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ScreenFlashView extends View {
    private static final long ANIMATION_DURATION_MILLIS = 1000;
    private static final String TAG = "ScreenFlashView";
    private CameraController mCameraController;
    private ImageCapture.ScreenFlash mScreenFlash;
    private Window mScreenFlashWindow;

    public static /* synthetic */ void a(ScreenFlashView r0, ValueAnimator r1) {
        r0.lambda$animateToFullOpacity$0(r1);
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000;
    }

    private float getBrightness() {
        Window r0 = this.mScreenFlashWindow;
        if (r0 != null) goto L7;
        Logger.e(TAG, "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    L7:
        return r0.getAttributes().screenBrightness;
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public ScreenFlashView(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ float access$000(ScreenFlashView r0) {
        return r0.getBrightness();
    }

    private ValueAnimator animateToFullOpacity(final Runnable r4) {
        Logger.d(TAG, "animateToFullOpacity");
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{MenuKt.ClosedAlphaTarget, 1.0f});
        r0.setDuration(getVisibilityRampUpAnimationDurationMillis());
        r0.addUpdateListener(new v(this));
        r0.addListener(new AnonymousClass2(this, r4));
        r0.start();
        return r0;
    }

    private /* synthetic */ void lambda$animateToFullOpacity$0(ValueAnimator r3) {
        Logger.d(TAG, "animateToFullOpacity: value = " + ((Float) r3.getAnimatedValue()).floatValue());
        setAlpha(((Float) r3.getAnimatedValue()).floatValue());
    }

    private void setBrightness(float r4) {
        if (this.mScreenFlashWindow != null) goto L7;
        Logger.e(TAG, "setBrightness: mScreenFlashWindow is null!");
        return;
    L7:
        if (Float.isNaN(r4) == false) goto L10;
        Logger.e(TAG, "setBrightness: value is NaN!");
        return;
    L10:
        WindowManager.LayoutParams r0 = this.mScreenFlashWindow.getAttributes();
        r0.screenBrightness = r4;
        this.mScreenFlashWindow.setAttributes(r0);
        Logger.d(TAG, "Brightness set to " + r0.screenBrightness);
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash r4) {
        CameraController r0 = this.mCameraController;
        if (r0 != null) goto L6;
        Logger.d(TAG, "setScreenFlashUiInfo: mCameraController is null!");
        return;
    L6:
        r0.setScreenFlashUiInfo(new ScreenFlashUiInfo(ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW, r4));
    }

    private void updateScreenFlash(Window r2) {
        if (this.mScreenFlashWindow == r2) goto L9;
        if (r2 != null) goto L6;
        ImageCapture.ScreenFlash r3 = null;
    L7:
        this.mScreenFlash = r3;
        return;
    L6:
        r3 = new AnonymousClass1(this);
        goto L7
    }

    public void setController(CameraController r2) {
        Threads.checkMainThread();
        CameraController r0 = this.mCameraController;
        if (r0 == null) goto L6;
        if (r0 == r2) goto L6;
        setScreenFlashUiInfo(null);
    L6:
        this.mCameraController = r2;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.getImageCaptureFlashMode() == 3) goto L12;
    L16:
        setScreenFlashUiInfo(getScreenFlash());
        return;
    L12:
        if (this.mScreenFlashWindow != null) goto L16;
        throw new IllegalStateException("No window set despite setting FLASH_MODE_SCREEN in CameraController");
    }

    public void setScreenFlashWindow(Window r1) {
        Threads.checkMainThread();
        updateScreenFlash(r1);
        this.mScreenFlashWindow = r1;
        setScreenFlashUiInfo(getScreenFlash());
    }

    public ScreenFlashView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static /* synthetic */ void access$100(ScreenFlashView r0, float r1) {
        r0.setBrightness(r1);
    }

    public static /* synthetic */ ValueAnimator access$200(ScreenFlashView r0, Runnable r1) {
        return r0.animateToFullOpacity(r1);
    }

    public ScreenFlashView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public ScreenFlashView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        setBackgroundColor(-1);
        setAlpha(MenuKt.ClosedAlphaTarget);
        setElevation(Float.MAX_VALUE);
    }
}
