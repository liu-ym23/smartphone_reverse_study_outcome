package com.ss.android.medialib.presenter;

/* JADX INFO: loaded from: classes38.dex */
public interface ITEVideoController {

    public interface a {
    }

    public interface b {
    }

    void pause();

    void restart();

    void seek(long r100);

    void setEnableEffCtrl(boolean r100);

    void setOnDuetProcessListener(a r100);

    void setVEOnVideoEOFListener(b r100);

    void start();
}
