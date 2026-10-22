package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public final class CronetMetrics extends RequestFinishedInfo.Metrics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Long mAddCookieCostUs;
    private long mBizReadResponseBodyInterval;
    private boolean mBypassApiReport;
    private final long mConnectEndMs;
    private final long mConnectStartMs;
    private String mCookieRelMetric;
    private final long mDnsEndMs;
    private final long mDnsStartMs;
    private long mFirstReadResponseBodyStart;
    private long mLastReadResponseBodyEnd;
    private final String mPeerAddr;
    private final Long mPeerPort;
    private boolean mPreSamplingReportable;
    private final long mPushEndMs;
    private final long mPushStartMs;
    private long mReadResponseBodyDuration;
    private final Long mReceivedByteCount;
    private Integer mRequestCookieSource;
    private final long mRequestEndMs;
    private final String mRequestHeaders;
    private String mRequestLog;
    private final long mRequestStartMs;
    private long mResponseBodyReadTimes;
    private final String mResponseHeaders;
    private final long mResponseStartMs;
    private final Long mRetryAttempts;
    private Long mSaveCookieCostUs;
    private final long mSendingEndMs;
    private final long mSendingStartMs;
    private final Long mSentByteCount;
    private final boolean mSocketReused;
    private final long mSslEndMs;
    private final long mSslStartMs;
    private final Long mTotalTimeMs;
    private final Long mTtfbMs;
    private int mURLDispatchDropReason;

    private static boolean checkOrder(long r100, long r101) {
        if (r101 < r100) goto L7;
        if (r100 == (-1)) goto L7;
    L8:
        return true;
    L7:
        if (r101 == (-1)) goto L8;
        return false;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getConnectEnd() {
        return toDate(this.mConnectEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getConnectStart() {
        return toDate(this.mConnectStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getDnsEnd() {
        return toDate(this.mDnsEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getDnsStart() {
        return toDate(this.mDnsStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPushEnd() {
        return toDate(this.mPushEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getPushStart() {
        return toDate(this.mPushStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getRequestEnd() {
        return toDate(this.mRequestEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getRequestStart() {
        return toDate(this.mRequestStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getResponseStart() {
        return toDate(this.mResponseStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSendingEnd() {
        return toDate(this.mSendingEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSendingStart() {
        return toDate(this.mSendingStartMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSslEnd() {
        return toDate(this.mSslEndMs);
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Date getSslStart() {
        return toDate(this.mSslStartMs);
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getAddCookieCostUs() {
        return this.mAddCookieCostUs;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public long getBizReadResponseBodyInterval() {
        return this.mBizReadResponseBodyInterval;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public boolean getBypassApiReport() {
        return this.mBypassApiReport;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getCookieRelMetric() {
        return this.mCookieRelMetric;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public long getFirstReadResponseBodyStart() {
        return this.mFirstReadResponseBodyStart;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public long getLastReadResponseBodyEnd() {
        return this.mLastReadResponseBodyEnd;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getPeerAddr() {
        return this.mPeerAddr;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getPeerPort() {
        return this.mPeerPort;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public boolean getPreSamplingReportable() {
        return this.mPreSamplingReportable;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public long getReadResponseBodyDuration() {
        return this.mReadResponseBodyDuration;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getReceivedByteCount() {
        return this.mReceivedByteCount;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Integer getRequestCookieSource() {
        return this.mRequestCookieSource;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getRequestHeaders() {
        return this.mRequestHeaders;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getRequestLog() {
        return this.mRequestLog;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public long getResponseBodyReadTimes() {
        return this.mResponseBodyReadTimes;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public String getResponseHeaders() {
        return this.mResponseHeaders;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getRetryAttempts() {
        return this.mRetryAttempts;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getSaveCookieCostUs() {
        return this.mSaveCookieCostUs;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getSentByteCount() {
        return this.mSentByteCount;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public boolean getSocketReused() {
        return this.mSocketReused;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getTotalTimeMs() {
        return this.mTotalTimeMs;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public Long getTtfbMs() {
        return this.mTtfbMs;
    }

    @Override // com.ttnet.org.chromium.net.RequestFinishedInfo.Metrics
    public int getURLDispatchDropReason() {
        return this.mURLDispatchDropReason;
    }

    private static Date toDate(long r100) {
        if (r100 != (-1)) goto L5;
        return null;
    L5:
        return new Date(r100);
    }

    public void setRequestLog(String r100) {
        this.mRequestLog = r100;
    }

    public CronetMetrics(Long r100, Long r101, Long r102, Long r103) {
        this.mResponseBodyReadTimes = 0;
        this.mFirstReadResponseBodyStart = -1;
        this.mLastReadResponseBodyEnd = -1;
        this.mReadResponseBodyDuration = -1;
        this.mBizReadResponseBodyInterval = -1;
        this.mTtfbMs = r100;
        this.mTotalTimeMs = r101;
        this.mSentByteCount = r102;
        this.mReceivedByteCount = r103;
        this.mRequestStartMs = -1;
        this.mDnsStartMs = -1;
        this.mDnsEndMs = -1;
        this.mConnectStartMs = -1;
        this.mConnectEndMs = -1;
        this.mSslStartMs = -1;
        this.mSslEndMs = -1;
        this.mSendingStartMs = -1;
        this.mSendingEndMs = -1;
        this.mPushStartMs = -1;
        this.mPushEndMs = -1;
        this.mResponseStartMs = -1;
        this.mRequestEndMs = -1;
        this.mSocketReused = false;
        this.mPeerAddr = "";
        this.mPeerPort = 0L;
        this.mRetryAttempts = 0L;
        this.mRequestHeaders = "";
        this.mResponseHeaders = "";
        this.mAddCookieCostUs = -1L;
        this.mSaveCookieCostUs = -1L;
        this.mRequestCookieSource = -1;
        this.mPreSamplingReportable = false;
        this.mBypassApiReport = false;
    }

    public void setReadResponseBodyMetrics(long r100, long r101, long r102, long r103, long r104) {
        this.mResponseBodyReadTimes = r100;
        this.mFirstReadResponseBodyStart = r101;
        this.mLastReadResponseBodyEnd = r102;
        this.mReadResponseBodyDuration = r103;
        this.mBizReadResponseBodyInterval = r104;
    }

    public CronetMetrics(long r110, long r111, long r112, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, boolean r410, long r411, long r412, String r413, long r414, long r415, String r510, String r511, long r512, long r513, int r514, String r515, boolean r516, boolean r517, int r610) {
        this.mResponseBodyReadTimes = 0;
        this.mFirstReadResponseBodyStart = -1;
        this.mLastReadResponseBodyEnd = -1;
        this.mReadResponseBodyDuration = -1;
        this.mBizReadResponseBodyInterval = -1;
        this.mRequestStartMs = r110;
        this.mDnsStartMs = r111;
        this.mDnsEndMs = r112;
        this.mConnectStartMs = r210;
        this.mConnectEndMs = r211;
        this.mSslStartMs = r212;
        this.mSslEndMs = r213;
        this.mSendingStartMs = r214;
        this.mSendingEndMs = r310;
        this.mPushStartMs = r311;
        this.mPushEndMs = r312;
        this.mResponseStartMs = r313;
        this.mRequestEndMs = r314;
        this.mSocketReused = r410;
        this.mSentByteCount = Long.valueOf(r411);
        this.mReceivedByteCount = Long.valueOf(r412);
        this.mAddCookieCostUs = Long.valueOf(r512);
        this.mSaveCookieCostUs = Long.valueOf(r513);
        this.mRequestCookieSource = Integer.valueOf(r514);
        this.mCookieRelMetric = r515;
        this.mPreSamplingReportable = r516;
        this.mBypassApiReport = r517;
        this.mURLDispatchDropReason = r610;
        this.mPeerAddr = r413;
        this.mPeerPort = Long.valueOf(r414);
        this.mRetryAttempts = Long.valueOf(r415);
        if (r313 != (-1)) goto L5;
    L7:
        this.mTtfbMs = null;
    L9:
        if (r110 != (-1)) goto L11;
    L13:
        this.mTotalTimeMs = null;
    L14:
        this.mRequestHeaders = r510;
        this.mResponseHeaders = r511;
        return;
    L11:
        if (r314 == (-1)) goto L13;
        this.mTotalTimeMs = Long.valueOf(r314 - r110);
        goto L14
    L5:
        if (r310 == (-1)) goto L7;
        this.mTtfbMs = Long.valueOf(r313 - r310);
        goto L9
    }
}
