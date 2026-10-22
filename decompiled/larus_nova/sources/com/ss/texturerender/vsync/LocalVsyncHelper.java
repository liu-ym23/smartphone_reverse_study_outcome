package com.ss.texturerender.vsync;

import android.os.Handler;
import android.os.Looper;
import com.ss.texturerender.TextureRenderLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class LocalVsyncHelper implements IVsyncHelper {
    private final String TAG;
    private ArrayList<IVsyncCallback> mCallbackList;
    private boolean mEnable;
    private Handler mMainHandler;
    private long mPostDelayedMS;
    Runnable mRunnable;
    private int mTexType;

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void update() {
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

    public static /* synthetic */ ArrayList access$000(LocalVsyncHelper r100) {
        return r100.mCallbackList;
    }

    public static /* synthetic */ boolean access$100(LocalVsyncHelper r100) {
        return r100.mEnable;
    }

    public static /* synthetic */ long access$200(LocalVsyncHelper r100) {
        return r100.mPostDelayedMS;
    }

    public static /* synthetic */ Handler access$300(LocalVsyncHelper r100) {
        return r100.mMainHandler;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void addObserver(IVsyncCallback r100) {
        ArrayList<IVsyncCallback> r101 = this.mCallbackList;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.contains(r100) == true) goto L11;
        this.mCallbackList.add(r100);
        if (this.mCallbackList.size() != 1) goto L12;
        this.mMainHandler.post(this.mRunnable);
        return;
    L12:
        return;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void removeObserver(IVsyncCallback r100) {
        ArrayList<IVsyncCallback> r101 = this.mCallbackList;
        if (r101 == null) goto L6;
        r101.remove(r100);
    L6:
        if (this.mCallbackList.size() != 0) goto L9;
        this.mMainHandler.removeCallbacks(this.mRunnable);
        return;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public LocalVsyncHelper(int r100, float r101) {
        this.mTexType = -1;
        this.mRunnable = new AnonymousClass1(this);
        String r102 = TextureRenderLog.getLogTag(this);
        this.TAG = r102;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mPostDelayedMS = (long) (1000.0f / r101);
        this.mTexType = r100;
        this.mCallbackList = new ArrayList();
        TextureRenderLog.d(r100, r102, "new LocalVsyncHelper,fps:" + r101);
    }
}
