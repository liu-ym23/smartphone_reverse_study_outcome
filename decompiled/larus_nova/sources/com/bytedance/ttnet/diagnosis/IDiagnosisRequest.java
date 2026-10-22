package com.bytedance.ttnet.diagnosis;

/* JADX INFO: loaded from: classes22.dex */
public interface IDiagnosisRequest {
    void cancel();

    void doExtraCommand(String r100, String r101);

    void setUserExtraInfo(String r100);

    void start(IDiagnosisCallback r100);
}
