package com.bytedance.frameworks.baselib.network.http.cronet.diagnosis;

/* JADX INFO: loaded from: classes19.dex */
public interface ICronetDiagnosisRequest {

    public interface Callback {
        void onNetDiagnosisRequestComplete(String r100);
    }

    void cancel();

    void doExtraCommand(String r100, String r101);

    void start();
}
