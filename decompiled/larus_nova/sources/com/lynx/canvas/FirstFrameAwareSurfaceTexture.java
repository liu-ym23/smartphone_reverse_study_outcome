package com.lynx.canvas;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes32.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "KryptonFirstFrameAwareSurfaceTexture";
    private FirstFrameAvailableListener mCustomFirstFrameAvailableListener;
    private boolean mFirstFrameHasPassed;
    private Handler mOnFrameAvailableHandler;

    public interface FirstFrameAvailableListener {
        void onFirstFrameAvailable();
    }

    private void setupFirstFrameAvailableListenerInternal() {
        super.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }

    @Override // android.graphics.SurfaceTexture
    public void release() {
        KryptonLLog.i(TAG, "release with " + this);
        super.release();
    }

    public FirstFrameAwareSurfaceTexture(int r100) {
        super(r100);
        setupFirstFrameAvailableListenerInternal();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r100) {
        Handler r101 = this.mOnFrameAvailableHandler;
        if (r101 == null) goto L9;
        Message r102 = r101.obtainMessage(0);
        if (Build.VERSION.SDK_INT < 22) goto L7;
        r102.setAsynchronous(true);
    L7:
        this.mOnFrameAvailableHandler.sendMessage(r102);
    L9:
        if (this.mFirstFrameHasPassed == true) goto L14;
        this.mFirstFrameHasPassed = true;
        KryptonLLog.i(TAG, "trigger first frame callback with " + this.mCustomFirstFrameAvailableListener);
        FirstFrameAvailableListener r103 = this.mCustomFirstFrameAvailableListener;
        if (r103 == null) goto L15;
        r103.onFirstFrameAvailable();
        return;
    L15:
        return;
    }

    public void setFirstFrameListener(FirstFrameAvailableListener r100) {
        this.mCustomFirstFrameAvailableListener = r100;
        if (this.mFirstFrameHasPassed == false) goto L6;
        r100.onFirstFrameAvailable();
        return;
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100) {
        setOnFrameAvailableListenerInternal(r100, null);
    }

    private void setOnFrameAvailableListenerInternal(final SurfaceTexture.OnFrameAvailableListener r100, Handler r101) {
        final Handler.Callback r102 = null;
        if (r100 == null) goto L8;
        if (r101 == null) goto L6;
        final Looper r103 = r101.getLooper();
    L7:
        this.mOnFrameAvailableHandler = new AnonymousClass1(this, r103, r102, r100);
        return;
    L6:
        r103 = Looper.getMainLooper();
        goto L7
    L8:
        this.mOnFrameAvailableHandler = null;
    }

    @Override // android.graphics.SurfaceTexture
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100, Handler r101) {
        setOnFrameAvailableListenerInternal(r100, r101);
    }
}
