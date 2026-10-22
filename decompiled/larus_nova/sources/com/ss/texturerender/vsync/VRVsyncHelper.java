package com.ss.texturerender.vsync;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class VRVsyncHelper implements IVsyncHelper {
    private CopyOnWriteArrayList<IVsyncCallback> mCallbackList;
    private boolean mEnable;

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public boolean isWorking() {
        if (this.mCallbackList.size() > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mEnable == false) goto L7;
        return true;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void update() {
        if (this.mEnable == false) goto L8;
        Iterator<IVsyncCallback> r100 = this.mCallbackList.iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        r100.next().notifyVsync();
        goto L6
    L10:
        return;
    }

    public VRVsyncHelper() {
        this.mCallbackList = new CopyOnWriteArrayList();
        this.mEnable = true;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void addObserver(IVsyncCallback r100) {
        if (this.mCallbackList.contains(r100) == true) goto L6;
        this.mCallbackList.add(r100);
        return;
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void removeObserver(IVsyncCallback r100) {
        this.mCallbackList.remove(r100);
    }

    @Override // com.ss.texturerender.vsync.IVsyncHelper
    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }
}
