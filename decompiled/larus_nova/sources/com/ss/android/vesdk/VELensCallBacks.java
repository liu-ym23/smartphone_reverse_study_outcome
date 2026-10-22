package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VELensCallBacks {
    private volatile VEListener.p mLensStateListener;

    public VELensCallBacks() {
        this.mLensStateListener = null;
    }

    public void setmLensStateListener(Object r100) {
        this.mLensStateListener = (VEListener.p) r100;
    }

    public static boolean onAlgorithmProcess(Object r100, int r101) {
        if ((r100 instanceof VELensCallBacks) == false) goto L9;
        VELensCallBacks r102 = (VELensCallBacks) r100;
        if (r102.mLensStateListener == null) goto L9;
        if (r102.mLensStateListener.getState() == false) goto L9;
        return true;
    L9:
        return false;
    }
}
