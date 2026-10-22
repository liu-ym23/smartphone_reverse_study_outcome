package com.lynx.devtool.framecapture;

import android.os.Build;
import android.view.View;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public abstract class FrameCapturer {
    private static final int CALLBACK_LAST = 0;
    private final Runnable mCallback;
    protected FrameChangeListener mFrameChangeListener;
    protected long mLastScreenshotTime;
    protected long mMaxScreenshotAreaSize;
    protected volatile String mScreenshotBitmapDataCache;
    protected int mScreenshotInterval;
    protected int mScreenshotQuality;
    protected WeakReference<View> mView;

    public interface FrameChangeListener {
        void onFrameChanged();
    }

    public void clearScreenshotBitmapDataCache() {
        this.mScreenshotBitmapDataCache = null;
    }

    public abstract boolean isEnabled();

    public abstract void onNewScreenshotBitmapData(String r100);

    public void onScreenshotActionEnd() {
    }

    public void onScreenshotActionStart() {
    }

    public abstract void screenshot(View r100, ScreenshotBitmapHandler r101);

    public void stopFrameViewTrace() {
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 23) goto L6;
        CALLBACK_LAST = 2;
        return;
    L6:
        if (r100 >= 29) goto L8;
        CALLBACK_LAST = 3;
        return;
    L8:
        CALLBACK_LAST = 4;
    }

    public FrameCapturer() {
        this.mScreenshotQuality = 70;
        this.mMaxScreenshotAreaSize = 256000;
        this.mScreenshotInterval = 1000000;
        this.mLastScreenshotTime = 0;
        this.mView = new WeakReference(null);
        this.mCallback = new AnonymousClass1(this);
    }

    public void addFrameViewCallback() {
        if (isEnabled() == false) goto L6;
        FrameTraceUtil.addFrameCallback(this.mCallback);
        return;
    }

    public void screenshot() {
        long r100 = FrameTraceUtil.getSystemBootTimeNs() / 1000;
        if ((r100 - this.mLastScreenshotTime) >= this.mScreenshotInterval) goto L5;
        return;
    L5:
        this.mLastScreenshotTime = r100;
        UIThreadUtils.runOnUiThread(new AnonymousClass2(this));
    }

    public void startFrameViewTrace() {
        clearScreenshotBitmapDataCache();
        if (isEnabled() == false) goto L6;
        addFrameViewCallback();
        return;
    }

    public void attachView(View r100) {
        this.mView = new WeakReference(r100);
    }
}
