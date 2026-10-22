package com.lynx.devtool.helper;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import android.view.View;
import com.lynx.devtool.framecapture.FrameCapturer;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.BitmapUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes32.dex */
public class ScreenCapturer extends FrameCapturer {
    private static final int CARD_PREVIEW_MAX_HEIGHT = 800;
    private static final int CARD_PREVIEW_MAX_WIDTH = 400;
    private static final int CARD_PREVIEW_QUALITY = 100;
    public static final int SCREEN_SHOT_PREVIEW_DELAY_TIME = 1500;
    private static final String TAG = "ScreenCapturer";
    private static final ScreenCapturer mInstance = null;
    private final ExecutorService executorService;
    private final AtomicBoolean mAckReceived;
    private IDevToolDelegate mDevToolDelegate;
    protected AtomicBoolean mIsDirty;
    private boolean mIsEnabled;
    private Choreographer.FrameCallback mResetDirtyCallBack;
    private final ScreenMetadata mScreenMetadata;
    private final ScreenRequest mScreenRequest;
    private ScreenshotListener mScreenshotListener;
    private volatile long mScreenshotOnMainThreadTime;
    private long mScreenshotStartTime;

    public static class ScreenMetadata {
        public float mDeviceHeight;
        public float mDeviceWidth;
        public float mOffsetTop;
        public float mPageScaleFactor;
        public float mScrollOffsetX;
        public float mScrollOffsetY;
        public float mTimestamp;

        public ScreenMetadata() {
        }
    }

    public static class ScreenRequest {
        private int mMaxHeight;
        private int mMaxWidth;
        private int mQuality;
        private String mScreenshotMode;

        private ScreenRequest() {
        }

        public /* synthetic */ ScreenRequest(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ int access$200(ScreenRequest r100) {
            return r100.mMaxWidth;
        }

        public static /* synthetic */ int access$300(ScreenRequest r100) {
            return r100.mMaxHeight;
        }

        public static /* synthetic */ int access$400(ScreenRequest r100) {
            return r100.mQuality;
        }

        public static /* synthetic */ String access$500(ScreenRequest r100) {
            return r100.mScreenshotMode;
        }

        public static /* synthetic */ int access$202(ScreenRequest r100, int r101) {
            r100.mMaxWidth = r101;
            return r101;
        }

        public static /* synthetic */ int access$302(ScreenRequest r100, int r101) {
            r100.mMaxHeight = r101;
            return r101;
        }

        public static /* synthetic */ int access$402(ScreenRequest r100, int r101) {
            r100.mQuality = r101;
            return r101;
        }

        public static /* synthetic */ String access$502(ScreenRequest r100, String r101) {
            r100.mScreenshotMode = r101;
            return r101;
        }
    }

    public interface ScreenshotListener {
        void onNewScreenshotBitmapData(String r100, long r101);
    }

    static {
        mInstance = new ScreenCapturer();
    }

    public void onAckReceived() {
        this.mAckReceived.set(true);
        triggerNextCapture();
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onScreenshotActionEnd() {
        if (this.mScreenshotStartTime != 0) goto L6;
        LLog.e(TAG, "onScreenshotActionEnd: lastTime == 0");
        return;
    L6:
        this.mScreenshotOnMainThreadTime = System.nanoTime() - this.mScreenshotStartTime;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onScreenshotActionStart() {
        this.mIsDirty.set(false);
        this.mScreenshotStartTime = System.nanoTime();
        this.mScreenshotOnMainThreadTime = 0;
    }

    public void triggerNextCapture() {
        if (this.mIsEnabled == true) goto L6;
        return;
    L6:
        if (this.mScreenshotBitmapDataCache != null) goto L8;
    L11:
        screenshot();
        return;
    L8:
        if (this.mAckReceived.get() == true) goto L10;
        return;
    L10:
        if (this.mIsDirty.get() == true) goto L11;
    }

    private ScreenCapturer() {
        this.mDevToolDelegate = null;
        this.mScreenshotOnMainThreadTime = 0;
        this.mScreenshotStartTime = 0;
        this.executorService = PThreadExecutorsUtils.newCachedThreadPool(new AnonymousClass1(this));
        this.mScreenRequest = new ScreenRequest(null);
        this.mScreenMetadata = new ScreenMetadata();
        this.mIsEnabled = false;
        this.mScreenshotListener = null;
        this.mAckReceived = new AtomicBoolean(false);
        this.mIsDirty = new AtomicBoolean(false);
        this.mFrameChangeListener = new AnonymousClass2(this);
        this.mResetDirtyCallBack = new AnonymousClass3(this);
    }

    private void addResetDirtyStatusCallBack() {
        Choreographer.getInstance().postFrameCallback(this.mResetDirtyCallBack);
    }

    public static ScreenCapturer getInstance() {
        return mInstance;
    }

    public ScreenMetadata getScreenMetadata() {
        return this.mScreenMetadata;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public static /* synthetic */ Choreographer.FrameCallback access$100(ScreenCapturer r100) {
        return r100.mResetDirtyCallBack;
    }

    public static /* synthetic */ String access$600(ScreenCapturer r100) {
        return r100.mScreenshotBitmapDataCache;
    }

    public static /* synthetic */ String access$800(ScreenCapturer r100) {
        return r100.mScreenshotBitmapDataCache;
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void onNewScreenshotBitmapData(String r100) {
        this.mAckReceived.set(false);
        if (this.mScreenshotListener != null) goto L5;
        return;
    L5:
        if (this.mScreenshotOnMainThreadTime != 0) goto L7;
        LLog.e(TAG, "onNewScreenshotBitmapData: screenshotMainTime == 0");
    L7:
        this.mScreenshotListener.onNewScreenshotBitmapData(r100, this.mScreenshotOnMainThreadTime);
    }

    public void onScreenshotBitmapReady(final Bitmap r100) {
        this.executorService.submit(new AnonymousClass4(this, r100));
    }

    public void setDevToolDelegate(IDevToolDelegate r100) {
        this.mDevToolDelegate = r100;
    }

    public void stopCapture(View r100) {
        if (r100 == this.mView.get()) goto L5;
        return;
    L5:
        stopFrameViewTrace();
        this.mIsEnabled = false;
        this.mView.clear();
    }

    public void submit(Runnable r100) {
        this.executorService.submit(r100);
    }

    public static /* synthetic */ String access$702(ScreenCapturer r100, String r101) {
        r100.mScreenshotBitmapDataCache = r101;
        return r101;
    }

    public String getScreenshotDataFromBitmap(Bitmap r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 100;
    L5:
        if (r101 == false) goto L7;
        int r103 = 400;
    L8:
        if (r101 == false) goto L10;
        int r104 = 800;
    L12:
        return BitmapUtils.bitmapToBase64WithQuality(scaleImage(r100, r103, r104), r102);
    L10:
        r104 = ScreenRequest.access$300(this.mScreenRequest);
        goto L12
    L7:
        r103 = ScreenRequest.access$200(this.mScreenRequest);
        goto L8
    L4:
        r102 = ScreenRequest.access$400(this.mScreenRequest);
        goto L5
    }

    @Override // com.lynx.devtool.framecapture.FrameCapturer
    public void screenshot(View r100, ScreenshotBitmapHandler r101) {
        IDevToolDelegate r102 = this.mDevToolDelegate;
        if (r102 == null) goto L5;
        r102.takeScreenshot(r101, ScreenRequest.access$500(this.mScreenRequest));
    L5:
        onScreenshotActionEnd();
    }

    private Bitmap scaleImage(Bitmap r100, int r101, int r110) {
        if (r100 != null) goto L5;
        LLog.e(TAG, "scaleImage: bitmap is null");
        return null;
    L5:
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        float r104 = getScale(r102, r103, r101, r110);
        DisplayMetrics r111 = DisplayMetricsHolder.getScreenDisplayMetrics();
        ScreenMetadata r105 = this.mScreenMetadata;
        float r112 = r111.density;
        r105.mDeviceWidth = r102 / r112;
        r105.mDeviceHeight = r103 / r112;
        r105.mPageScaleFactor = 1.0f;
        Matrix r106 = new Matrix();     // Catch: Throwable -> L8
        r106.postScale(r104, r104);     // Catch: Throwable -> L8
        return Bitmap.createBitmap(r100, 0, 0, r102, r103, r106, true);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r100;
    }

    private float getScale(int r100, int r101, int r102, int r103) {
        if (r102 == 0) goto L7;
        if (r103 == 0) goto L7;
        if (r100 > r102) goto L6;
        if (r101 <= r103) goto L7;
    L6:
        float r104 = r102 / r100;
        float r105 = r103 / r101;
    L13:
        return Math.min(r104, r105);
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0.0f;
    L7:
        r104 = 1.0f;
        r105 = 1.0f;
        goto L13
    }

    public void startCapture(int r100, int r101, int r102, String r103, ScreenshotListener r104) {
        ScreenRequest.access$202(this.mScreenRequest, r100);
        ScreenRequest.access$302(this.mScreenRequest, r101);
        ScreenRequest.access$402(this.mScreenRequest, r102);
        ScreenRequest.access$502(this.mScreenRequest, r103);
        this.mScreenshotListener = r104;
        this.mIsEnabled = true;
        addResetDirtyStatusCallBack();
        startFrameViewTrace();
        triggerNextCapture();
    }
}
