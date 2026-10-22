package com.ss.texturerender.vsync;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.texturerender.TextureRenderLog;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class VsyncHelper implements Choreographer.FrameCallback, Handler.Callback, IVsyncHelper {
    public static final float DEFAULT_REFRESH_RATE = 60.0f;
    private static final long NANOS_PER_SECOND = 1000000000;
    private final String TAG;
    private Choreographer choreographer;
    private ArrayList<IVsyncCallback> mCallbackList;
    private boolean mEnable;
    private int mTexType;
    private Handler mainHandler;
    private volatile long vsyncDurationNs;
    private final WindowManager windowManager;

    public static class VsyncCallback implements IVsyncCallback {
        public Handler mHandler;

        @Override // com.ss.texturerender.vsync.IVsyncCallback
        public void notifyVsync() {
            this.mHandler.sendEmptyMessage(28);
        }

        public VsyncCallback(Handler r100) {
            this.mHandler = r100;
        }
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void update() {
    }

    private void updateDefaultDisplayRefreshRateParams() {
        WindowManager r100 = this.windowManager;
        if (r100 == null) goto L5;
        Display r101 = r100.getDefaultDisplay();
    L6:
        if (r101 == null) goto L8;
        this.vsyncDurationNs = (long) (1.0E9d / ((double) r101.getRefreshRate()));
    L9:
        TextureRenderLog.i(this.mTexType, this.TAG, "vsyncDurationNs:" + this.vsyncDurationNs + "defaultDisplay:" + r101);
        return;
    L8:
        this.vsyncDurationNs = 16666667;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public boolean isWorking() {
        if (this.mCallbackList.size() > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mEnable == false) goto L7;
        return true;
    }

    public long getVsyncDurationNs() {
        return this.vsyncDurationNs;
    }

    private void addObserverInternal(Message r100) {
        if (this.mCallbackList.contains((IVsyncCallback) r100.obj) == true) goto L10;
        this.mCallbackList.add((IVsyncCallback) r100.obj);
        if (this.mCallbackList.size() != 1) goto L11;
        Choreographer r101 = this.choreographer;
        if (r101 == null) goto L12;
        r101.postFrameCallback(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void removeObserverInternal(Message r100) {
        this.mCallbackList.remove(r100.obj);
        if (this.mCallbackList.size() != 0) goto L8;
        Choreographer r101 = this.choreographer;
        if (r101 == null) goto L9;
        r101.removeFrameCallback(this);
        return;
    L9:
        return;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void addObserver(IVsyncCallback r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "addObserver");
        if (r100 != null) goto L5;
        return;
    L5:
        Message r101 = this.mainHandler.obtainMessage(29);
        r101.obj = r100;
        r101.sendToTarget();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r100) {
        if (this.mCallbackList.size() > 0) goto L5;
        return;
    L5:
        if (this.mEnable == false) goto L14;
        Iterator<IVsyncCallback> r101 = this.mCallbackList.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().notifyVsync();
        goto L8
    L10:
        this.choreographer.postFrameCallback(this);
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        switch(r100.what) {
            case 28: goto L9;
            case 29: goto L8;
            case 30: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        removeObserverInternal(r100);
        return true;
    L8:
        addObserverInternal(r100);
    L9:
        return true;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void removeObserver(IVsyncCallback r100) {
        TextureRenderLog.i(this.mTexType, this.TAG, "removeObserver");
        if (r100 != null) goto L5;
        return;
    L5:
        Message r101 = this.mainHandler.obtainMessage(30);
        r101.obj = r100;
        r101.sendToTarget();
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public VsyncHelper(Context r100, int r101) {
        this.mTexType = -1;
        String r102 = TextureRenderLog.getLogTag(this);
        this.TAG = r102;
        Handler r103 = new Handler(Looper.getMainLooper(), this);
        this.mainHandler = r103;
        r103.post(new AnonymousClass1(this));
        this.mCallbackList = new ArrayList();
        if (r100 == null) goto L5;
        this.windowManager = (WindowManager) r100.getApplicationContext().getSystemService(LiveEndPageData.TAG_WINDOW);
    L6:
        updateDefaultDisplayRefreshRateParams();
        this.mEnable = true;
        this.mTexType = r101;
        TextureRenderLog.i(r101, r102, "new VsyncHelper");
        return;
    L5:
        this.windowManager = null;
        goto L6
    }

    public static /* synthetic */ Choreographer access$002(VsyncHelper r100, Choreographer r101) {
        r100.choreographer = r101;
        return r101;
    }
}
