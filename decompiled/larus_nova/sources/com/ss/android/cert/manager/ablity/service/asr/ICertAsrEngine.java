package com.ss.android.cert.manager.ablity.service.asr;

import android.content.Context;

/* JADX INFO: loaded from: classes34.dex */
public interface ICertAsrEngine {
    void config(CertAsrConfig r100);

    void destroy();

    void feedAudio(byte[] r100, int r101);

    void initEngine(Context r100);

    void setListener(CertAsrListener r100);

    int start();

    int stop();
}
