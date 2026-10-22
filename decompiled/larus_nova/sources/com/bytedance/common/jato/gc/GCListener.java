package com.bytedance.common.jato.gc;

/* JADX INFO: loaded from: classes15.dex */
public abstract class GCListener {
    public GCListener() {
    }

    public boolean callbackOnMainThreadWaitOnly() {
        return true;
    }

    public abstract void onGCEnd(int r100, int r101, int r102, long r103, boolean r104, long r105, long r106, long r110, long r111, long r112);

    public abstract void onGCStart(int r100, int r101, int r102);

    public abstract void onWaitGc(int r100, int r101, int r102);
}
