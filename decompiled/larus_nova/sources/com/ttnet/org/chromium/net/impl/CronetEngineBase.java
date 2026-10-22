package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CronetEngineBase extends ExperimentalCronetEngine {
    protected static final long DEFAULT_NETWORK_HANDLE = -1;

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Idempotency {
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequestPriority {
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface StreamPriority {
    }

    public abstract ExperimentalBidirectionalStream createBidirectionalStream(String r100, BidirectionalStream.Callback r101, Executor r102, String r103, List<Map.Entry<String, String>> r104, int r105, boolean r106, Collection<Object> r107, boolean r108, int r110, boolean r111, int r112, long r113);

    public abstract TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r100, Executor r101, int r102, List<String> r103, int r104, int r105, int r106);

    public abstract UrlRequestBase createRequest(String r100, UrlRequest.Callback r101, Executor r102, int r103, Collection<Object> r104, boolean r105, boolean r106, boolean r107, boolean r108, int r110, boolean r111, int r112, RequestFinishedInfo.Listener r113, int r114, long r115);

    public abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r100, Executor r101, List<String> r102, int r103, String r104, long r105, int r106, long r107, String r110, int r111, String r112, Map<String, String> r113, Map<String, String> r114, boolean r115);

    public abstract TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r100, Executor r101, List<String> r102, Map<String, String> r103, Map<String, String> r104, boolean r105);

    public CronetEngineBase() {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r100, Executor r101) {
        return new TTNetDiagnosisRequestBuilderImpl(r100, r101, this);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r100, Executor r101) {
        return new TTWebsocketConnectionBuilderImpl(r100, r101, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r100, UrlRequest.Callback r101, Executor r102) {
        return new UrlRequestBuilderImpl(r100, r101, r102, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r100, UrlRequest.Callback r101, Executor r102) {
        return newUrlRequestBuilder(r100, r101, r102);
    }
}
