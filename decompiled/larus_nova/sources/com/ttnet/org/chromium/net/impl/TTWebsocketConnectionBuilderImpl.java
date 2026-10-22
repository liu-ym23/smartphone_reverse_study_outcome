package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public class TTWebsocketConnectionBuilderImpl extends TTWebsocketConnection.Builder {
    private static final String TAG = null;
    private int mAppId;
    private String mAppKey;
    private String mAppToken;
    private int mAppVersion;
    private final TTWebsocketConnection.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private long mDeviceId;
    private final Executor mExecutor;
    private int mFpid;
    private Map<String, String> mHeaders;
    private long mInstallId;
    private Map<String, String> mParams;
    private String mSessionId;
    private boolean mSharedConnection;
    private List<String> mUrlList;
    private boolean mUseFrontier;

    static {
        TAG = "TTWebsocketConnectionBuilderImpl";
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection build() {
        if (this.mUseFrontier == false) goto L7;
        return this.mCronetEngine.createWebsocketConnection(this.mCallback, this.mExecutor, this.mUrlList, this.mAppId, this.mAppKey, this.mDeviceId, this.mFpid, this.mInstallId, this.mSessionId, this.mAppVersion, this.mAppToken, this.mParams, this.mHeaders, this.mSharedConnection);
    L7:
        return this.mCronetEngine.createWebsocketConnection(this.mCallback, this.mExecutor, this.mUrlList, this.mParams, this.mHeaders, this.mSharedConnection);
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppId(int r100) {
        this.mAppId = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppKey(String r100) {
        this.mAppKey = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppToken(String r100) {
        this.mAppToken = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setAppVersion(int r100) {
        this.mAppVersion = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setCustomizedHeaders(Map<String, String> r100) {
        this.mHeaders = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setCustomizedParams(Map<String, String> r100) {
        this.mParams = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setDeviceId(long r100) {
        this.mDeviceId = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setFpid(int r100) {
        this.mFpid = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setInstallId(long r100) {
        this.mInstallId = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setSessionId(String r100) {
        this.mSessionId = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setSharedConnection(boolean r100) {
        this.mSharedConnection = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder setUrlList(List<String> r100) {
        this.mUrlList = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection.Builder
    public TTWebsocketConnection.Builder useFrontierProtocol(boolean r100) {
        this.mUseFrontier = r100;
        return this;
    }

    public TTWebsocketConnectionBuilderImpl(TTWebsocketConnection.Callback r100, Executor r101, CronetEngineBase r102) {
        this.mSharedConnection = true;
        this.mUseFrontier = true;
        this.mCronetEngine = r102;
        this.mCallback = r100;
        this.mExecutor = r101;
    }
}
