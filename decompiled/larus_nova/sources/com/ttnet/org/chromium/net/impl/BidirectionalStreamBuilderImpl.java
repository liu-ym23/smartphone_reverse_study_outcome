package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public class BidirectionalStreamBuilderImpl extends ExperimentalBidirectionalStream.Builder {
    private final BidirectionalStream.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDelayRequestHeadersUntilFirstFlush;
    private final Executor mExecutor;
    private String mHttpMethod;
    private long mNetworkHandle;
    private int mPriority;
    private Collection<Object> mRequestAnnotations;
    private final ArrayList<Map.Entry<String, String>> mRequestHeaders;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private final String mUrl;

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public ExperimentalBidirectionalStream build() {
        return this.mCronetEngine.createBidirectionalStream(this.mUrl, this.mCallback, this.mExecutor, this.mHttpMethod, this.mRequestHeaders, this.mPriority, this.mDelayRequestHeadersUntilFirstFlush, this.mRequestAnnotations, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder addRequestAnnotation(Object r100) {
        if (r100 == null) goto L9;
        if (this.mRequestAnnotations != null) goto L6;
        this.mRequestAnnotations = new ArrayList();
    L6:
        this.mRequestAnnotations.add(r100);
        return this;
    L9:
        throw new NullPointerException("Invalid metrics annotation.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder bindToNetwork(long r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r100;
        return this;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r100) {
        return delayRequestHeadersUntilFirstFlush(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl setHttpMethod(String r100) {
        if (r100 == null) goto L6;
        this.mHttpMethod = r100;
        return this;
    L6:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r100) {
        return setPriority(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder setTrafficStatsTag(int r100) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder
    public ExperimentalBidirectionalStream.Builder setTrafficStatsUid(int r100) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r100) {
        return delayRequestHeadersUntilFirstFlush(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r100) {
        return setHttpMethod(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder setPriority(int r100) {
        return setPriority(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl delayRequestHeadersUntilFirstFlush(boolean r100) {
        this.mDelayRequestHeadersUntilFirstFlush = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder setHttpMethod(String r100) {
        return setHttpMethod(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl setPriority(int r100) {
        this.mPriority = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public BidirectionalStreamBuilderImpl addHeader(String r100, String r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L7;
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r100, r101));
        return this;
    L7:
        throw new NullPointerException("Invalid header value.");
    L9:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r100, String r101) {
        return addHeader(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalBidirectionalStream.Builder, com.ttnet.org.chromium.net.BidirectionalStream.Builder
    public /* bridge */ /* synthetic */ ExperimentalBidirectionalStream.Builder addHeader(String r100, String r101) {
        return addHeader(r100, r101);
    }

    public BidirectionalStreamBuilderImpl(String r100, BidirectionalStream.Callback r101, Executor r102, CronetEngineBase r103) {
        this.mRequestHeaders = new ArrayList();
        this.mHttpMethod = "POST";
        this.mPriority = 3;
        this.mNetworkHandle = -1;
        if (r100 == null) goto L16;
        if (r101 == null) goto L14;
        if (r102 == null) goto L12;
        if (r103 == null) goto L10;
        this.mUrl = r100;
        this.mCallback = r101;
        this.mExecutor = r102;
        this.mCronetEngine = r103;
        return;
    L10:
        throw new NullPointerException("CronetEngine is required.");
    L12:
        throw new NullPointerException("Executor is required.");
    L14:
        throw new NullPointerException("Callback is required.");
    L16:
        throw new NullPointerException("URL is required.");
    }
}
