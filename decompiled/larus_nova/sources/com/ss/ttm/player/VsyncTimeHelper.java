package com.ss.ttm.player;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ttm.utils.Util;

/* JADX INFO: loaded from: classes40.dex */
public final class VsyncTimeHelper {
    private static final double DEFAULT_REFRESH_RATE = 16.0d;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final long TIME_UNSET = -9223372036854775807L;
    private final DefaultDisplayListener displayListener;
    private long vsyncDurationNs;
    private final UIVSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    public final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;
        final /* synthetic */ VsyncTimeHelper this$0;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int r100) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int r100) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int r100) {
            if (r100 != 0) goto L5;
            VsyncTimeHelper.access$200(this.this$0);
            return;
        }

        public DefaultDisplayListener(VsyncTimeHelper r100, DisplayManager r101) {
            this.this$0 = r100;
            this.displayManager = r101;
        }
    }

    public static final class UIVSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final String BUNDLE_TIMESTAMP = "time";
        private static final String BUNDLE_VSYNC_DURATION = "vsync";
        private static final UIVSyncSampler INSTANCE = null;
        private static final int MSG_ADD_OBSERVER = 0;
        private static final int MSG_REMOVE_OBSERVER = 1;
        private static final int MSG_UPDATE_VSYNC_DURATION = 4;
        private static final int MSG_VSYNC_COMING = 2;
        private static final String TAG = "UIVSyncSampler";
        private Bundle bundle;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private int currentUIFps;
        private final Handler handler;
        public volatile long lastSampledVsyncTimeNs;
        private int lowestUIFps;
        private final Handler mainHandler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs;
        public volatile int skipedFrameCount;
        private long uiVsyncDurationNs;
        private long vsyncSampleCount;

        static {
            INSTANCE = new UIVSyncSampler();
        }

        private void addObserverInternal() {
            int r100 = this.observerCount + 1;
            this.observerCount = r100;
            if (r100 != 1) goto L8;
            Choreographer r101 = this.choreographer;
            if (r101 == null) goto L9;
            r101.postFrameCallback(this);
            return;
        L9:
            return;
        }

        private void removeObserverInternal() {
            int r100 = this.observerCount - 1;
            this.observerCount = r100;
            if (r100 != 0) goto L8;
            Choreographer r101 = this.choreographer;
            if (r101 == null) goto L9;
            r101.removeFrameCallback(this);
            this.sampledVsyncTimeNs = -9223372036854775807L;
            this.lastSampledVsyncTimeNs = -9223372036854775807L;
            this.skipedFrameCount = 0;
            this.currentUIFps = 0;
            this.lowestUIFps = 0;
            this.vsyncSampleCount = 0;
            return;
        L9:
            return;
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(0);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(1);
        }

        private UIVSyncSampler() {
            this.sampledVsyncTimeNs = -9223372036854775807L;
            this.lastSampledVsyncTimeNs = -9223372036854775807L;
            this.skipedFrameCount = 0;
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Vsync:Handler");
            this.choreographerOwnerThread = r100;
            ThreadMethodProxy.start(r100);
            this.handler = new Handler(r100.getLooper(), this);
            this.bundle = new Bundle();
            Handler r101 = new Handler(Looper.getMainLooper());
            this.mainHandler = r101;
            r101.post(new AnonymousClass1(this));
        }

        public static /* synthetic */ UIVSyncSampler access$500() {
            return INSTANCE;
        }

        public static UIVSyncSampler getInstance() {
            return INSTANCE;
        }

        public static /* synthetic */ int access$000(UIVSyncSampler r100) {
            return r100.currentUIFps;
        }

        public static /* synthetic */ int access$100(UIVSyncSampler r100) {
            return r100.lowestUIFps;
        }

        public static /* synthetic */ Choreographer access$300(UIVSyncSampler r100) {
            return r100.choreographer;
        }

        public static /* synthetic */ int access$400(UIVSyncSampler r100) {
            return r100.observerCount;
        }

        private void recordUIFps(long r100) {
            if (this.uiVsyncDurationNs != 0) goto L5;
            return;
        L5:
            this.vsyncSampleCount++;
            this.sampledVsyncTimeNs = r100;
            if (this.lastSampledVsyncTimeNs != (-9223372036854775807L)) goto L9;
            this.lastSampledVsyncTimeNs = this.sampledVsyncTimeNs;
            return;
        L9:
            long r101 = this.sampledVsyncTimeNs - this.lastSampledVsyncTimeNs;
            if (r101 > 0) goto L13;
            this.lastSampledVsyncTimeNs = -9223372036854775807L;
            return;
        L13:
            long r102 = this.uiVsyncDurationNs;
            if ((r101 - r102) <= 0) goto L16;
            int r103 = Math.round((r101 - r102) / r102);
        L17:
            this.skipedFrameCount += r103;
            int r104 = (int) (1000000000 / r101);
            this.currentUIFps = r104;
            int r105 = this.lowestUIFps;
            if (r105 == 0) goto L21;
            r104 = Math.min(r105, r104);
        L21:
            this.lowestUIFps = r104;
            this.lastSampledVsyncTimeNs = this.sampledVsyncTimeNs;
            return;
        L16:
            r103 = 0;
            goto L17
        }

        private void updateUIVsyncDurationNs(long r100) {
            this.uiVsyncDurationNs = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r100) {
            Message r101 = this.handler.obtainMessage(2);
            this.bundle.putLong("time", r100);
            r101.setData(this.bundle);
            r101.sendToTarget();
            this.choreographer.postFrameCallback(this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 == 0) goto L17;
            if (r101 != 1) goto L6;
            removeObserverInternal();
            return true;
        L6:
            if (r101 != 2) goto L8;
            recordUIFps(r100.getData().getLong("time"));
            return true;
        L8:
            if (r101 == 4) goto L11;
            return false;
        L11:
            updateUIVsyncDurationNs(r100.getData().getLong(BUNDLE_VSYNC_DURATION));
            return true;
        L17:
            addObserverInternal();
            return true;
        }

        public void updateVsyncDuration(long r100) {
            this.bundle.putLong(BUNDLE_VSYNC_DURATION, r100);
            Message r101 = this.handler.obtainMessage(4);
            r101.setData(this.bundle);
            r101.sendToTarget();
        }

        public static /* synthetic */ Choreographer access$302(UIVSyncSampler r100, Choreographer r101) {
            r100.choreographer = r101;
            return r101;
        }
    }

    private void updateDefaultDisplayRefreshRateParams() {
        if (Util.SDK_INT >= 30) goto L5;
        Display r100 = this.windowManager.getDefaultDisplay();
    L6:
        if (r100 == null) goto L8;
        this.vsyncDurationNs = (long) (1.0E9d / ((double) r100.getRefreshRate()));
    L9:
        this.vsyncSampler.updateVsyncDuration(this.vsyncDurationNs);
        return;
    L8:
        this.vsyncDurationNs = 62500000;
        goto L9
    L5:
        r100 = null;
        goto L6
    }

    public void disable() {
        if (this.windowManager == null) goto L9;
        DefaultDisplayListener r100 = this.displayListener;
        if (r100 == null) goto L7;
        r100.unregister();
    L7:
        this.vsyncSampler.removeObserver();
        return;
    }

    public void enable() {
        if (this.windowManager == null) goto L9;
        this.vsyncSampler.addObserver();
        DefaultDisplayListener r100 = this.displayListener;
        if (r100 == null) goto L7;
        r100.register();
    L7:
        updateDefaultDisplayRefreshRateParams();
        return;
    }

    public int getLowestUIFps() {
        return UIVSyncSampler.access$100(this.vsyncSampler);
    }

    public int getUIFps() {
        return UIVSyncSampler.access$000(this.vsyncSampler);
    }

    public long getVsyncDurationNs() {
        return this.vsyncDurationNs;
    }

    public VsyncTimeHelper(Context r100) {
        DefaultDisplayListener r101 = null;
        if (r100 == null) goto L5;
        r100 = r100.getApplicationContext();
        this.windowManager = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
    L7:
        if (this.windowManager != null) goto L9;
        this.displayListener = null;
        this.vsyncSampler = null;
    L13:
        this.vsyncDurationNs = -9223372036854775807L;
        return;
    L9:
        if (Util.SDK_INT < 17) goto L11;
        r101 = maybeBuildDefaultDisplayListenerV17(r100);
    L11:
        this.displayListener = r101;
        this.vsyncSampler = UIVSyncSampler.getInstance();
        goto L13
    L5:
        this.windowManager = null;
        goto L7
    }

    public static /* synthetic */ void access$200(VsyncTimeHelper r100) {
        r100.updateDefaultDisplayRefreshRateParams();
    }

    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context r100) {
        DisplayManager r101 = (DisplayManager) r100.getSystemService("display");
        if (r101 != null) goto L6;
        return null;
    L6:
        return new DefaultDisplayListener(this, r101);
    }
}
