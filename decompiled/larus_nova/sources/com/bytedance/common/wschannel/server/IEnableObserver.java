package com.bytedance.common.wschannel.server;

/* JADX INFO: loaded from: classes3.dex */
public interface IEnableObserver {

    public interface OnWsChannelEnableChangedObserver {
        void onWsChannelEnableChange(boolean r100);
    }

    boolean isEnable();

    void setEnableListener(OnWsChannelEnableChangedObserver r100);

    void startLoad();
}
