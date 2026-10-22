package com.ss.texturerender;

import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class RenderCheckDispatcher {
    private final String TAG;
    private ConcurrentHashMap<VideoSurfaceTexture, FrameRenderChecker> checkerMap;
    private volatile boolean isEnabled;
    private int mTexType;
    private final Handler msgHandler;
    private volatile int startCount;

    private void doStart() {
        TextureRenderLog.i(this.mTexType, this.TAG, "doStart");
        Handler r100 = this.msgHandler;
        if (r100 == null) goto L6;
        r100.sendEmptyMessage(38);
        return;
    }

    private void doStop() {
        TextureRenderLog.i(this.mTexType, this.TAG, "doStop");
        Handler r100 = this.msgHandler;
        if (r100 == null) goto L6;
        r100.sendEmptyMessage(39);
        return;
    }

    public void checkSurfaceTextureCallbackTime() {
        if (this.isEnabled == true) goto L5;
        return;
    L5:
        Iterator<Map.Entry<VideoSurfaceTexture, FrameRenderChecker>> r100 = this.checkerMap.entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L14;
        Map.Entry<VideoSurfaceTexture, FrameRenderChecker> r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.getValue() == null) goto L7;
        r101.getValue().checkSurfaceTextureCallbackTime();
        goto L7
    }

    public boolean isStarted() {
        if (this.startCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void onDrawSucceed(VideoSurfaceTexture r100) {
        if (this.isEnabled == true) goto L5;
        return;
    L5:
        FrameRenderChecker r101 = this.checkerMap.get(r100);
        if (r101 == null) goto L9;
        r101.onDrawSucceed();
        return;
    }

    public void onFrameCome(VideoSurfaceTexture r100) {
        if (this.isEnabled == true) goto L5;
        return;
    L5:
        FrameRenderChecker r101 = this.checkerMap.get(r100);
        if (r101 == null) goto L9;
        r101.onFrameCome();
        return;
    }

    public void onSurfaceTextureCallbackCalled(VideoSurfaceTexture r100) {
        if (this.isEnabled == true) goto L5;
        return;
    L5:
        FrameRenderChecker r101 = this.checkerMap.get(r100);
        if (r101 == null) goto L9;
        r101.onSurfaceTextureCallbackCalled();
        return;
    }

    public void setEnabled(boolean r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "setEnabled, " + r100);
        this.isEnabled = r100;
    }

    public RenderCheckDispatcher(Handler r100, int r101) {
        this.mTexType = -1;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.msgHandler = r100;
        this.checkerMap = new ConcurrentHashMap();
        this.mTexType = r101;
    }

    public void decrease(VideoSurfaceTexture r100, FrameRenderChecker r101) {
        if (r100 == null) goto L4;
        TextureRenderLog.i(r100.texType(), this.TAG, "decrease, VideoSurfaceTexture " + r100);
    L4:
        if (r100 == null) goto L14;
        if (r101 == null) goto L16;
        this.checkerMap.remove(r100);
        if (this.startCount > 0) goto L10;
        return;
    L10:
        this.startCount--;
        if (this.startCount != 0) goto L15;
        doStop();
        return;
    L15:
        return;
    L16:
        return;
    }

    public void increase(VideoSurfaceTexture r100, FrameRenderChecker r101) {
        if (r100 == null) goto L4;
        TextureRenderLog.i(r100.texType(), this.TAG, "increase, VideoSurfaceTexture " + r100);
    L4:
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        this.checkerMap.put(r100, r101);
        if (this.startCount != 0) goto L10;
        doStart();
    L10:
        this.startCount++;
        return;
    L13:
        return;
    }
}
