package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes5.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    private final Collection<Object> mAnnotations;
    private final CronetException mException;
    private final int mFinishedReason;
    private final RequestFinishedInfo.Metrics mMetrics;
    private final UrlResponseInfo mResponseInfo;
    private final String mUrl;

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FinishedReason {
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public Collection<Object> getAnnotations() {
        Collection<Object> r100 = this.mAnnotations;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Collections.emptyList();
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public CronetException getException() {
        return this.mException;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public int getFinishedReason() {
        return this.mFinishedReason;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public RequestFinishedInfo.Metrics getMetrics() {
        return this.mMetrics;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public UrlResponseInfo getResponseInfo() {
        return this.mResponseInfo;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo
    public String getUrl() {
        return this.mUrl;
    }

    public RequestFinishedInfoImpl(String r100, Collection<Object> r101, RequestFinishedInfo.Metrics r102, int r103, UrlResponseInfo r104, CronetException r105) {
        this.mUrl = r100;
        this.mAnnotations = r101;
        this.mMetrics = r102;
        this.mFinishedReason = r103;
        this.mResponseInfo = r104;
        this.mException = r105;
    }
}
