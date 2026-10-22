package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public class TTNetDiagnosisRequestBuilderImpl extends TTNetDiagnosisRequest.Builder {
    private static final String TAG = null;
    private final TTNetDiagnosisRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private final Executor mExecutor;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private List<String> mTargets;
    private int mTimeoutMs;

    static {
        TAG = "TTNetDiagnosisRequestBuilderImpl";
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest build() {
        return this.mCronetEngine.createNetDiagnosisRequest(this.mCallback, this.mExecutor, this.mReqType, this.mTargets, this.mNetDetectType, this.mMultiNetAction, this.mTimeoutMs);
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setMultiNetAction(int r100) {
        this.mMultiNetAction = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setNetDetectType(int r100) {
        this.mNetDetectType = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setRequestType(int r100) {
        this.mReqType = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setTargets(List<String> r100) {
        this.mTargets = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Builder
    public TTNetDiagnosisRequest.Builder setTimeout(int r100) {
        this.mTimeoutMs = r100;
        return this;
    }

    public TTNetDiagnosisRequestBuilderImpl(TTNetDiagnosisRequest.Callback r100, Executor r101, CronetEngineBase r102) {
        this.mCronetEngine = r102;
        this.mCallback = r100;
        this.mExecutor = r101;
    }
}
