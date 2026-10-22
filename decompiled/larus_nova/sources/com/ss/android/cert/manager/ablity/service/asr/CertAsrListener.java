package com.ss.android.cert.manager.ablity.service.asr;

/* JADX INFO: loaded from: classes34.dex */
public interface CertAsrListener {
    void onError(String r100);

    void onFinalResult(String r100);

    void onPartialMessage(String r100);

    void onStart(String r100);

    void onStop(String r100);
}
