package com.bytedance.common.jato.views.fps;

import android.os.SystemClock;
import android.os.Trace;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.bytedance.android.livesdk.performance.j0;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes15.dex */
public class WindowState implements ViewTreeObserver.OnPreDrawListener {
    private final int FRAME_ACCURACY_MILLIS;
    private final int FRAME_ACCURACY_NANOS;
    protected SceneState curScene;
    protected boolean isPreventByOtherWindow;
    protected int mCurrentFrameInterval;
    private final FPSUtils mFpsUtils;
    protected int mFrameCount;
    private int mFrameIndex;
    protected long mLastFrameTime;
    private long mLastFrameTimeFPS;
    protected int mOtherWinMinFrameInterval;
    protected boolean mPreventBackgroundFrame;
    private long[] mSavedFrameBuffer;
    protected int mSelfWinMinFrameInterval;
    protected int mSkippedFrameCount;
    private WindowStateListener mStateListener;
    protected int mTargetFPS;
    protected Window mWindow;
    protected String windowName;

    public static class WindowConfig {
    }

    public void destroy() {
        Window r100 = this.mWindow;
        if (r100 != null) goto L5;
        return;
    L5:
        INVOKEVIRTUAL_com_bytedance_common_jato_views_fps_WindowState_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getViewTreeObserver().removeOnPreDrawListener(this);
        this.mWindow = null;
        this.curScene = null;
        if (WindowFPSManager.IS_DEBUG == true) goto L8;
        return;
    }

    public void notifyUpdateWindows() {
        this.curScene.updateWindows();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.mFrameCount++;
        long r100 = SystemClock.elapsedRealtimeNanos();
        boolean r101 = needDrawForTargetFPS(this.mFrameCount, r100) & needDrawForFPSControl(r100);
        WindowStateListener r102 = this.mStateListener;
        if (r102 == null) goto L5;
        r102.getClass();
    L5:
        if (r101 == false) goto L11;
        FPSUtils r103 = this.mFpsUtils;
        if (r103 == null) goto L11;
        r103.addFrame(r100 / 1000000);
        if (this.mFpsUtils.getIndex() != 0) goto L11;
        this.mFpsUtils.getFPS();
    L11:
        return r101;
    }

    public String toString() {
        return "WindowState{windowName='" + this.windowName + "', curScene=" + this.curScene + ", mLastFrameTime=" + this.mLastFrameTime + ", mSkippedFrameCount=" + this.mSkippedFrameCount + ", mSelfWinMinFrameInterval=" + this.mSelfWinMinFrameInterval + ", mOtherWinMinFrameInterval=" + this.mOtherWinMinFrameInterval + ", mPreventBackgroundFrame=" + this.mPreventBackgroundFrame + ", mCurrentFrameInterval=" + this.mCurrentFrameInterval + ", isPreventByOtherWindow=" + this.isPreventByOtherWindow + '}';
    }

    public static View INVOKEVIRTUAL_com_bytedance_common_jato_views_fps_WindowState_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private boolean needDrawForFPSControl(long r100) {
        long r101 = r100 / 1000000;
        if (this.isPreventByOtherWindow == true) goto L11;
        long r102 = this.mLastFrameTime;
        if (r102 != 0) goto L7;
    L9:
        this.mLastFrameTime = r101;
        this.mSkippedFrameCount = 0;
        return true;
    L7:
        if (Math.abs(r101 - r102) >= this.mCurrentFrameInterval) goto L9;
    L11:
        if (WindowFPSManager.IS_DEBUG == false) goto L13;
        this.mSkippedFrameCount++;
        Trace.beginSection("WindowFPSManager SkipFrame");
        Trace.endSection();
    L13:
        return false;
    }

    public void setOtherBgMinInterval(int r100) {
        if (this.mOtherWinMinFrameInterval == r100) goto L6;
        this.mOtherWinMinFrameInterval = r100;
        notifyUpdateWindows();
        return;
    }

    public void setStateListener(WindowStateListener r100) {
        this.mStateListener = r100;
    }

    public void setStopBackgroundFrame(boolean r100) {
        if (WindowFPSManager.IS_DEBUG == true) goto L5;
    L5:
        this.mPreventBackgroundFrame = r100;
        notifyUpdateWindows();
    }

    public void setTargetFPSSelfWindow(int r100) {
        if (this.mTargetFPS == r100) goto L6;
        this.mTargetFPS = r100;
        notifyUpdateWindows();
        return;
    }

    private boolean needDrawForTargetFPS(int r110, long r111) {
        int r112 = this.mTargetFPS;
        if (r112 <= 0) goto L20;
        int r100 = this.mFrameIndex;
        int r101 = ((r100 + 5) - 1) % 5;
        long r113 = r111 / 10000;
        long r102 = this.mLastFrameTimeFPS;
        long r103 = r113 - r102;
        if (r102 > 0) goto L7;
    L15:
        boolean r114 = true;
    L16:
        if (r114 == false) goto L19;
        this.mSavedFrameBuffer[r100] = r113;
        this.mFrameIndex = (r100 + 1) % 5;
        this.mLastFrameTimeFPS = r113;
    L19:
        return r114;
    L7:
        if (r103 <= 0) goto L15;
        int r104 = 100000 / r112;
        long[] r115 = this.mSavedFrameBuffer;
        long r105 = ((r103 * 2) + (r115[r101] - r115[r100])) / 5;
        if (WindowFPSManager.IS_DEBUG == true) goto L13;
    L13:
        if (r105 >= r104) goto L15;
        r114 = false;
        goto L16
    L20:
        return true;
    }

    public void onWindowsUpdate(WindowState r100, int r101, boolean r102) {
        int r103 = this.mCurrentFrameInterval;
        if (r100 != this) goto L5;
        this.mCurrentFrameInterval = -1;
        this.isPreventByOtherWindow = false;
    L11:
        if (WindowFPSManager.IS_DEBUG == false) goto L13;
        String.format("window update: %s, cur=%d, pr=%b", new Object[]{this.windowName, Integer.valueOf(this.mCurrentFrameInterval), Boolean.valueOf(this.isPreventByOtherWindow)});
    L13:
        WindowStateListener r104 = this.mStateListener;
        if (r104 == null) goto L24;
        if (r103 > 0) goto L19;
        int r105 = this.mCurrentFrameInterval;
        if (r105 <= 0) goto L19;
        ((j0.b) r104).a(this, true, r105);
        return;
    L19:
        if (r103 <= 0) goto L26;
        int r106 = this.mCurrentFrameInterval;
        if (r106 > 0) goto L27;
        ((j0.b) r104).a(this, false, r106);
        return;
    L27:
        return;
    L26:
        return;
    L24:
        return;
    L5:
        int r107 = this.mSelfWinMinFrameInterval;
        if (r107 < 0) goto L8;
        this.mCurrentFrameInterval = r107;
    L9:
        this.isPreventByOtherWindow = r102;
        goto L11
    L8:
        this.mCurrentFrameInterval = Math.max(r101, WindowFPSManager.DEFAULT_MIN_FRAME_INTERVAL);
        goto L9
    }

    public WindowState(String r100, Window r101, SceneState r102, WindowConfig r103) {
        this.mTargetFPS = -1;
        this.mSelfWinMinFrameInterval = -1;
        this.mOtherWinMinFrameInterval = -1;
        this.mPreventBackgroundFrame = false;
        this.mCurrentFrameInterval = -1;
        this.isPreventByOtherWindow = false;
        if (WindowFPSManager.IS_DEBUG == false) goto L5;
        FPSUtils r104 = new FPSUtils(60);
    L6:
        this.mFpsUtils = r104;
        this.FRAME_ACCURACY_NANOS = 10000;
        this.FRAME_ACCURACY_MILLIS = 100;
        this.mSavedFrameBuffer = new long[5];
        this.mLastFrameTimeFPS = -1;
        this.windowName = r100;
        this.curScene = r102;
        this.mWindow = r101;
        INVOKEVIRTUAL_com_bytedance_common_jato_views_fps_WindowState_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).getViewTreeObserver().addOnPreDrawListener(this);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
