package com.ss.android.lark.gadget.preload.entity;

import com.ss.android.lark.gadget.preload.listener.MiniAppPreloadStateListener;

/* JADX INFO: loaded from: classes36.dex */
public class MiniAppPreloadConfigEntity {
    private boolean mCancelPreloadWhenNotWifi;
    private MiniAppPreloadStateListener mPreloadStateListener;

    public MiniAppPreloadConfigEntity() {
        this.mCancelPreloadWhenNotWifi = true;
    }

    public MiniAppPreloadStateListener getPreloadStateListener() {
        return this.mPreloadStateListener;
    }

    public boolean isCancelPreloadWhenNotWifi() {
        return this.mCancelPreloadWhenNotWifi;
    }

    public void setCancelPreloadWhenNotWifi(boolean r100) {
        this.mCancelPreloadWhenNotWifi = r100;
    }

    public void setPreloadStateListener(MiniAppPreloadStateListener r100) {
        this.mPreloadStateListener = r100;
    }
}
