package com.ss.ttvideoengine;

import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: classes34.dex */
public interface SubInfoCallBack {
    void onSubInfoCallback(int r100, String r101);

    void onSubLoadFinished(int r100);

    void onSubLoadFinished2(int r100, String r101);

    void onSubPathInfo(String r100, Error r101);

    void onSubSwitchCompleted(int r100, int r101);
}
