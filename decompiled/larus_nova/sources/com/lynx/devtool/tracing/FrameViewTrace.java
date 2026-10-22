package com.lynx.devtool.tracing;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.lynx.devtool.framecapture.FrameCapturer;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.utils.BitmapUtils;

/* JADX INFO: loaded from: classes32.dex */
public class FrameViewTrace extends FrameCapturer {
    private long mNativeFrameViewTrace;

    public static class FrameViewTraceLoader {
        private static final FrameViewTrace INSTANCE = null;

        private FrameViewTraceLoader() {
        }

        static {
            INSTANCE = new FrameViewTrace();
        }

        public static /* synthetic */ FrameViewTrace access$000() {
            return INSTANCE;
        }
    }

    private native long nativeCreateFrameViewTrace();

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public boolean isEnabled() {
        return TraceEvent.categoryEnabled(2);
    }

    public FrameViewTrace() {
        this.mNativeFrameViewTrace = 0;
        this.mNativeFrameViewTrace = nativeCreateFrameViewTrace();
    }

    public static FrameViewTrace getInstance() {
        return FrameViewTraceLoader.access$000();
    }

    public long getNativeFrameViewTrace() {
        return this.mNativeFrameViewTrace;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void startFrameViewTrace() {
        super.startFrameViewTrace();
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void stopFrameViewTrace() {
        super.stopFrameViewTrace();
    }

    private String takeScreenshot(View r110) {
        r110.setDrawingCacheEnabled(true);     // Catch: Throwable -> L10
        Bitmap r100 = Bitmap.createBitmap(r110.getDrawingCache());     // Catch: Throwable -> L10
        r110.setDrawingCacheEnabled(false);     // Catch: Throwable -> L10
        if (r100 == null) goto L15;
        int r101 = r100.getWidth();     // Catch: Throwable -> L10
        int r102 = r100.getHeight();     // Catch: Throwable -> L10
        float r111 = r102 * r101;     // Catch: Throwable -> L10
        long r103 = this.mMaxScreenshotAreaSize;     // Catch: Throwable -> L10
        if (r111 <= r103) goto L8;
        float r112 = (float) Math.sqrt(r103 / r111);     // Catch: Throwable -> L10
        Matrix r104 = new Matrix();     // Catch: Throwable -> L10
        r104.setScale(r112, r112);     // Catch: Throwable -> L10
        r100 = Bitmap.createBitmap(r100, 0, 0, r101, r102, r104, false);     // Catch: Throwable -> L10
    L8:
        return BitmapUtils.bitmapToBase64WithQuality(r100, this.mScreenshotQuality);
    L15:
        return null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onNewScreenshotBitmapData(String r100) {
        if (isEnabled() == false) goto L6;
        FrameTraceService.getInstance().screenshot(r100);
        return;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void screenshot(View r100, ScreenshotBitmapHandler r101) {
        String r102 = takeScreenshot(r100);
        onScreenshotActionEnd();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.equals(this.mScreenshotBitmapDataCache) == true) goto L10;
        this.mScreenshotBitmapDataCache = r102;
        onNewScreenshotBitmapData(r102);
        return;
    }
}
