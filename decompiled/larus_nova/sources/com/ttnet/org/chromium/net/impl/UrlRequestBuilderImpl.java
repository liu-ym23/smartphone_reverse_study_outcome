package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import android.util.Pair;
import com.ttnet.org.chromium.net.ExperimentalUrlRequest;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public class UrlRequestBuilderImpl extends ExperimentalUrlRequest.Builder {
    private static final String TAG = null;
    private boolean mAllowDirectExecutor;
    private final UrlRequest.Callback mCallback;
    private final CronetEngineBase mCronetEngine;
    private boolean mDisableCache;
    private boolean mDisableConnectionMigration;
    private final Executor mExecutor;
    private int mIdempotency;
    private String mMethod;
    private long mNetworkHandle;
    private int mPriority;
    private Collection<Object> mRequestAnnotations;
    private RequestFinishedInfo.Listener mRequestFinishedListener;
    private final ArrayList<Pair<String, String>> mRequestHeaders;
    private int mRequestTimeout;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private int mTrafficStatsTag;
    private boolean mTrafficStatsTagSet;
    private int mTrafficStatsUid;
    private boolean mTrafficStatsUidSet;
    private UploadDataProvider mUploadDataProvider;
    private Executor mUploadDataProviderExecutor;
    private final String mUrl;

    static {
        TAG = "UrlRequestBuilderImpl";
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBase build() {
        UrlRequestBase r100 = this.mCronetEngine.createRequest(this.mUrl, this.mCallback, this.mExecutor, this.mPriority, this.mRequestAnnotations, this.mDisableCache, this.mDisableConnectionMigration, this.mAllowDirectExecutor, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mRequestFinishedListener, this.mIdempotency, this.mNetworkHandle);
        String r101 = this.mMethod;
        if (r101 == null) goto L5;
        r100.setHttpMethod(r101);
    L5:
        Iterator<Pair<String, String>> r102 = this.mRequestHeaders.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Pair<String, String> r103 = r102.next();
        r100.addHeader((String) r103.first, (String) r103.second);
        goto L7
    L9:
        UploadDataProvider r104 = this.mUploadDataProvider;
        if (r104 == null) goto L12;
        r100.setUploadDataProvider(r104, this.mUploadDataProviderExecutor);
    L12:
        r100.setSocketConnectTimeout(this.mSocketConnectTimeout);
        r100.setSocketReadTimeout(this.mSocketReadTimeout);
        r100.setSocketWriteTimeout(this.mSocketWriteTimeout);
        r100.setRequestTimeout(this.mRequestTimeout);
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder disableConnectionMigration() {
        return disableConnectionMigration();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder allowDirectExecutor() {
        return allowDirectExecutor();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder disableCache() {
        return disableCache();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl disableConnectionMigration() {
        this.mDisableConnectionMigration = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl allowDirectExecutor() {
        this.mAllowDirectExecutor = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest build() {
        return build();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl disableCache() {
        this.mDisableCache = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl addRequestAnnotation(Object r100) {
        if (r100 == null) goto L9;
        if (this.mRequestAnnotations != null) goto L6;
        this.mRequestAnnotations = new ArrayList();
    L6:
        this.mRequestAnnotations.add(r100);
        return this;
    L9:
        throw new NullPointerException("Invalid metrics annotation.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl bindToNetwork(long r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r100;
        return this;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public ExperimentalUrlRequest.Builder setHttpMethod(String r100) {
        if (r100 == null) goto L6;
        this.mMethod = r100;
        return this;
    L6:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setIdempotency(int r100) {
        return setIdempotency(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setPriority(int r100) {
        return setPriority(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setRequestFinishedListener(RequestFinishedInfo.Listener r100) {
        return setRequestFinishedListener(r100);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setRequestTimeout(int r100) {
        return setRequestTimeout(r100);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketConnectTimeout(int r100) {
        return setSocketConnectTimeout(r100);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketReadTimeout(int r100) {
        return setSocketReadTimeout(r100);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setSocketWriteTimeout(int r100) {
        return setSocketWriteTimeout(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsTag(int r100) {
        this.mTrafficStatsTagSet = true;
        this.mTrafficStatsTag = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setTrafficStatsUid(int r100) {
        this.mTrafficStatsUidSet = true;
        this.mTrafficStatsUid = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addRequestAnnotation(Object r100) {
        return addRequestAnnotation(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder bindToNetwork(long r100) {
        return bindToNetwork(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setHttpMethod(String r100) {
        return setHttpMethod(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setIdempotency(int r100) {
        this.mIdempotency = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setPriority(int r100) {
        return setPriority(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public UrlRequestBuilderImpl setRequestFinishedListener(RequestFinishedInfo.Listener r100) {
        this.mRequestFinishedListener = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setRequestTimeout(int r100) {
        this.mRequestTimeout = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketConnectTimeout(int r100) {
        this.mSocketConnectTimeout = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketReadTimeout(int r100) {
        this.mSocketReadTimeout = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setSocketWriteTimeout(int r100) {
        this.mSocketWriteTimeout = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsTag(int r100) {
        return setTrafficStatsTag(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setTrafficStatsUid(int r100) {
        return setTrafficStatsUid(r100);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setPriority(int r100) {
        this.mPriority = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl addHeader(String r100, String r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L7;
        this.mRequestHeaders.add(Pair.create(r100, r101));
        return this;
    L7:
        throw new NullPointerException("Invalid header value.");
    L9:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public UrlRequestBuilderImpl setUploadDataProvider(UploadDataProvider r100, Executor r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L10;
        if (this.mMethod != null) goto L7;
        this.mMethod = "POST";
    L7:
        this.mUploadDataProvider = r100;
        this.mUploadDataProviderExecutor = r101;
        return this;
    L10:
        throw new NullPointerException("Invalid UploadDataProvider Executor.");
    L12:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder addHeader(String r100, String r101) {
        return addHeader(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ ExperimentalUrlRequest.Builder setUploadDataProvider(UploadDataProvider r100, Executor r101) {
        return setUploadDataProvider(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder addHeader(String r100, String r101) {
        return addHeader(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalUrlRequest.Builder, com.ttnet.org.chromium.net.UrlRequest.Builder
    public /* bridge */ /* synthetic */ UrlRequest.Builder setUploadDataProvider(UploadDataProvider r100, Executor r101) {
        return setUploadDataProvider(r100, r101);
    }

    public UrlRequestBuilderImpl(String r100, UrlRequest.Callback r101, Executor r102, CronetEngineBase r103) {
        this.mRequestHeaders = new ArrayList();
        this.mPriority = 3;
        this.mNetworkHandle = -1;
        this.mIdempotency = 0;
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
