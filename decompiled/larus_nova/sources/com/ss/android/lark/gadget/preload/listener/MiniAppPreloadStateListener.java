package com.ss.android.lark.gadget.preload.listener;

/* JADX INFO: loaded from: classes36.dex */
public interface MiniAppPreloadStateListener {
    void onPreloadCancel(String r100);

    void onPreloadFail(String r100);

    void onPreloadFinish(String r100, boolean r101, long r102);

    void onPreloadProgress(String r100, int r101);

    void onPreloadResume(String r100);

    void onPreloadStart(String r100);

    void onPreloadStop(String r100);
}
