package com.lynx.canvas;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public class LynxKryptonFrameService extends KryptonFrameService {
    private ArrayList<KryptonFrameService.FrameCallback> mBeforeVsyncEndCallbacks;
    private ArrayList<KryptonFrameService.FrameCallback> mCallbacks;
    private long mNativeFrameService;

    private native long nativeCreateFrameService(long r100);

    private native void nativeDestroyFrameService(long r100);

    private native void nativeDoRegisterBeforeVSyncEndListener(long r100);

    private native void nativeDoRequestVSync(long r100);

    @Override // com.lynx.canvas.KryptonFrameService
    public void setPreferredFramesPerSecond(long r100) {
    }

    @Override // com.lynx.canvas.KryptonService
    public void onDestroy() {
        long r100 = this.mNativeFrameService;
        if (r100 == 0) goto L6;
        nativeDestroyFrameService(r100);
        this.mNativeFrameService = 0;
        return;
    }

    public LynxKryptonFrameService(long r100) {
        this.mCallbacks = new ArrayList();
        this.mBeforeVsyncEndCallbacks = new ArrayList();
        this.mNativeFrameService = nativeCreateFrameService(r100);
    }

    public void OnBeforeVSyncEnd(long r100) {
        Iterator<KryptonFrameService.FrameCallback> r101 = this.mBeforeVsyncEndCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().doFrame(r100);
        goto L4
    }

    public void OnVSync(long r100) {
        ArrayList r101 = new ArrayList(this.mCallbacks);
        this.mCallbacks.clear();
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((KryptonFrameService.FrameCallback) r102.next()).doFrame(r100);
        goto L4
    }

    @Override // com.lynx.canvas.KryptonFrameService
    public void registerBeforeVSyncEndListener(KryptonFrameService.FrameCallback r100) {
        this.mBeforeVsyncEndCallbacks.add(r100);
        nativeDoRegisterBeforeVSyncEndListener(this.mNativeFrameService);
    }

    @Override // com.lynx.canvas.KryptonFrameService
    public void requestVSync(KryptonFrameService.FrameCallback r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mCallbacks.add(r100);
        nativeDoRequestVSync(this.mNativeFrameService);
    }
}
