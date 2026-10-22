package com.ss.videoarch.live.ttquic;

import com.byted.cast.common.ErrorCode;

/* JADX INFO: loaded from: classes38.dex */
class TTRequestParam {
    public static final int CACHE_MODE_DURATION = 1;
    public static final int CACHE_MODE_FRAME_COUNT = 0;
    public static final int CACHE_MODE_GOP = 2;
    public static final int CACHE_MODE_SIZE = 3;
    public static final int Crypto_Protocol_QUIC = 1;
    public static final int Crypto_Protocol_TLS_1_3 = 2;
    public static final int HTTP1X_VERSION = 1;
    public static final int HTTP2_VERSION = 2;
    public static final int HTTP3_VERSION = 3;
    public static final int LowProtocol_QUIC = 2;
    public static final int LowProtocol_TCP = 0;
    public static final int LowProtocol_TLS = 1;
    public static final int PRELOAD_MODE_FAST_OPEN = 0;
    public static final int PRELOAD_MODE_FLV_HEAD = 11;
    public static final int PRELOAD_MODE_FLV_IO = 10;
    public static final int PRELOAD_MODE_ONLY_MPD = 1;
    public static final int PRELOAD_MODE_STANDARD = 2;
    public static final int PRELOAD_MODE_UNKNOWN = -1;
    public static final int QUIC_VERSION_39 = 39;
    public static final int QUIC_VERSION_43 = 43;
    public static final int QUIC_VERSION_44 = 44;
    public static final int TT_DISABLE = 0;
    public static final int TT_ENABLE = 1;
    public int cacheDuration;
    public int cacheFrameCount;
    public int cacheGopCount;
    public int cacheMode;
    public int cacheSize;
    public int cmafEnableFastOpen;
    public int cmafPreloadMPDExpMs;
    public int cmafPreloadMPDUpdateMs;
    public int cmafPreloadNum;
    public int cmafPreloadParallel;
    public int cmafSkipInitSection;
    public int cmafStartSegOffset;
    public int cryptoProtocol;
    public int enableCertVerify;
    public String format;
    public String host;
    public int httpCacheMaxAgeSec;
    public int httpVersion;
    public String httpxParams;
    public String ipaddr;
    public int lowProtocol;
    public int minCacheDuration;
    public int openTimeoutMs;
    public int optCancelTask;
    public int preloadMode;
    public String protocol;
    public String quicParams;
    public String quicSCFGAddr;
    public int quicVersion;
    public int readTimeoutMs;
    public String url;

    public String toString() {
        return "TTRequestParam{url='" + this.url + "', httpVersion=" + this.httpVersion + ", lowProtocol=" + this.lowProtocol + ", quicVersion=" + this.quicVersion + ", cryptoProtocol=" + this.cryptoProtocol + ", enableCertVerify=" + this.enableCertVerify + ", httpCacheMaxAgeSec=" + this.httpCacheMaxAgeSec + ", openTimeoutMs=" + this.openTimeoutMs + ", readTimeoutMs=" + this.readTimeoutMs + ", preloadMode=" + this.preloadMode + ", cmafEnableFastOpen=" + this.cmafEnableFastOpen + ", cmafSkipInitSection=" + this.cmafSkipInitSection + ", cmafStartSegOffset=" + this.cmafStartSegOffset + ", cmafPreloadNum=" + this.cmafPreloadNum + ", cmafPreloadParallel=" + this.cmafPreloadParallel + ", cmafPreloadMPDInterval=" + this.cmafPreloadMPDUpdateMs + ", cmafPreloadMPDExpTime=" + this.cmafPreloadMPDExpMs + ", quicSCFGAddr='" + this.quicSCFGAddr + "', host='" + this.host + "', ipaddr='" + this.ipaddr + "', format='" + this.format + "', protocol='" + this.protocol + "', cacheMode=" + this.cacheMode + ", cacheFrameCount=" + this.cacheFrameCount + ", cacheDuration=" + this.cacheDuration + ", minCacheDuration=" + this.minCacheDuration + ", optCancelTask=" + this.optCancelTask + '}';
    }

    public TTRequestParam() {
        this.url = "";
        this.httpVersion = 2;
        this.lowProtocol = 2;
        this.quicVersion = 43;
        this.cryptoProtocol = 1;
        this.enableCertVerify = 1;
        this.httpCacheMaxAgeSec = 600;
        this.openTimeoutMs = 5000;
        this.readTimeoutMs = 5000;
        this.preloadMode = 10;
        this.cmafEnableFastOpen = 1;
        this.cmafSkipInitSection = 1;
        this.cmafStartSegOffset = 1;
        this.cmafPreloadNum = 1;
        this.cmafPreloadParallel = 0;
        this.cmafPreloadMPDUpdateMs = 2000;
        this.cmafPreloadMPDExpMs = 5000;
        this.quicSCFGAddr = "";
        this.host = "";
        this.ipaddr = "";
        this.format = "";
        this.protocol = "";
        this.cacheMode = 1;
        this.cacheFrameCount = 100;
        this.cacheDuration = 2000;
        this.cacheGopCount = 1;
        this.cacheSize = ErrorCode.LICENSE_USER_VALID;
        this.minCacheDuration = 500;
        this.optCancelTask = 0;
        this.quicParams = "";
        this.httpxParams = "";
    }
}
