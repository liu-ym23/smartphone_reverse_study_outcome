package com.ss.texturerender.vsync;

/* JADX INFO: loaded from: classes40.dex */
public interface IVsyncHelper {
    public static final int MSG_ADD_OBSERVER = 29;
    public static final int MSG_REMOVE_OBSERVER = 30;
    public static final int MSG_VSYNC_COMING = 28;

    void addObserver(IVsyncCallback r100);

    boolean isWorking();

    void removeObserver(IVsyncCallback r100);

    void setEnable(boolean r100);

    void update();
}
