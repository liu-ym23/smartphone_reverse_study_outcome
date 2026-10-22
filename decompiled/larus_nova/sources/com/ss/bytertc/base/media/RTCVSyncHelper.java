package com.ss.bytertc.base.media;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.bytedance.realx.base.RXLogging;

/* JADX INFO: loaded from: classes40.dex */
public class RTCVSyncHelper {

    public static class ChoreographerFrameCallback implements Choreographer.FrameCallback {
        public long nativeCallbackHandle;
        public String renderTaskUUID;

        public void resetCallback() {
            this.nativeCallbackHandle = 0;
        }

        public ChoreographerFrameCallback() {
            this.nativeCallbackHandle = 0;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long r100) {
            if (this.nativeCallbackHandle == 0) goto L9;
            Choreographer r101 = Choreographer.getInstance();
            if (r101 == null) goto L7;
            r101.postFrameCallback(this);
        L7:
            RTCNativeFunctions.nativeNotifyVSyncDoFrame(this.nativeCallbackHandle, this.renderTaskUUID);
            return;
        }
    }

    public RTCVSyncHelper() {
    }

    public static /* synthetic */ void a(ChoreographerFrameCallback r100) {
        lambda$registerVSyncCallback$0(r100);
    }

    private static /* synthetic */ void lambda$registerVSyncCallback$0(ChoreographerFrameCallback r100) {
        Choreographer r101 = Choreographer.getInstance();
        if (r101 == null) goto L5;
        r101.postFrameCallback(r100);
        return;
    L5:
        RXLogging.e("RTCVSyncHelper", "Choreographer.getInstance() return null");
    }

    public static void unregisterVSyncCallback(Object r100) {
        if ((r100 instanceof ChoreographerFrameCallback) == false) goto L6;
        ((ChoreographerFrameCallback) r100).resetCallback();
        return;
    }

    public static Object registerVSyncCallback(long r100, String r101) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        final ChoreographerFrameCallback r102 = new ChoreographerFrameCallback();
        r102.nativeCallbackHandle = r100;
        r102.renderTaskUUID = r101;
        new Handler(Looper.getMainLooper()).post(new k(r102));
        return r102;
    }
}
