package com.ttnet.org.chromium.net.impl;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.time.Duration;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CronetLogger {

    public static class CronetEngineBuilderInfo {
        private final boolean mBrotiEnabled;
        private final String mExperimentalOptions;
        private final boolean mHttp2Enabled;
        private final int mHttpCacheMode;
        private final boolean mNetworkQualityEstimatorEnabled;
        private final boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        private final boolean mQuicEnabled;
        private final String mStoragePath;
        private final int mThreadPriority;
        private final String mUserAgent;

        public String getExperimentalOptions() {
            return this.mExperimentalOptions;
        }

        public int getHttpCacheMode() {
            return this.mHttpCacheMode;
        }

        public String getStoragePath() {
            return this.mStoragePath;
        }

        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        public String getUserAgent() {
            return this.mUserAgent;
        }

        public boolean isBrotliEnabled() {
            return this.mBrotiEnabled;
        }

        public boolean isHttp2Enabled() {
            return this.mHttp2Enabled;
        }

        public boolean isNetworkQualityEstimatorEnabled() {
            return this.mNetworkQualityEstimatorEnabled;
        }

        public boolean isPublicKeyPinningBypassForLocalTrustAnchorsEnabled() {
            return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        }

        public boolean isQuicEnabled() {
            return this.mQuicEnabled;
        }

        public CronetEngineBuilderInfo(CronetEngineBuilderImpl r100) {
            this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r100.publicKeyPinningBypassForLocalTrustAnchorsEnabled();
            this.mUserAgent = r100.getUserAgent();
            this.mStoragePath = r100.storagePath();
            this.mQuicEnabled = r100.quicEnabled();
            this.mHttp2Enabled = r100.http2Enabled();
            this.mBrotiEnabled = r100.brotliEnabled();
            this.mHttpCacheMode = r100.publicBuilderHttpCacheMode();
            this.mExperimentalOptions = r100.experimentalOptions();
            this.mNetworkQualityEstimatorEnabled = r100.networkQualityEstimatorEnabled();
            this.mThreadPriority = r100.threadPriority(10);
        }
    }

    public static final enum CronetSource extends Enum<CronetSource> {
        private static final /* synthetic */ CronetSource[] $VALUES = null;
        public static final CronetSource CRONET_SOURCE_FALLBACK = null;
        public static final CronetSource CRONET_SOURCE_PLAY_SERVICES = null;
        public static final CronetSource CRONET_SOURCE_STATICALLY_LINKED = null;
        public static final CronetSource CRONET_SOURCE_UNSPECIFIED = null;

        static {
            CronetSource r100 = new CronetSource("CRONET_SOURCE_UNSPECIFIED", 0);
            CRONET_SOURCE_UNSPECIFIED = r100;
            CronetSource r101 = new CronetSource("CRONET_SOURCE_STATICALLY_LINKED", 1);
            CRONET_SOURCE_STATICALLY_LINKED = r101;
            CronetSource r102 = new CronetSource("CRONET_SOURCE_PLAY_SERVICES", 2);
            CRONET_SOURCE_PLAY_SERVICES = r102;
            CronetSource r103 = new CronetSource("CRONET_SOURCE_FALLBACK", 3);
            CRONET_SOURCE_FALLBACK = r103;
            $VALUES = new CronetSource[]{r100, r101, r102, r103};
        }

        public static CronetSource[] values() {
            return (CronetSource[]) $VALUES.clone();
        }

        public static CronetSource valueOf(String r100) {
            return (CronetSource) a.a(CronetSource.class, r100);
        }

        private CronetSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class CronetTrafficInfo {
        private final boolean mDidConnectionMigrationSucceed;
        private final Duration mHeadersLatency;
        private final String mNegotiatedProtocol;
        private final long mRequestBodySizeInBytes;
        private final long mRequestHeaderSizeInBytes;
        private final long mResponseBodySizeInBytes;
        private final long mResponseHeaderSizeInBytes;
        private final int mResponseStatusCode;
        private final Duration mTotalLatency;
        private final boolean mWasConnectionMigrationAttempted;

        public boolean didConnectionMigrationSucceed() {
            return this.mDidConnectionMigrationSucceed;
        }

        public Duration getHeadersLatency() {
            return this.mHeadersLatency;
        }

        public String getNegotiatedProtocol() {
            return this.mNegotiatedProtocol;
        }

        public long getRequestBodySizeInBytes() {
            return this.mRequestBodySizeInBytes;
        }

        public long getRequestHeaderSizeInBytes() {
            return this.mRequestHeaderSizeInBytes;
        }

        public long getResponseBodySizeInBytes() {
            return this.mResponseBodySizeInBytes;
        }

        public long getResponseHeaderSizeInBytes() {
            return this.mResponseHeaderSizeInBytes;
        }

        public int getResponseStatusCode() {
            return this.mResponseStatusCode;
        }

        public Duration getTotalLatency() {
            return this.mTotalLatency;
        }

        public boolean wasConnectionMigrationAttempted() {
            return this.mWasConnectionMigrationAttempted;
        }

        public CronetTrafficInfo(long r100, long r101, long r102, long r103, int r104, Duration r110, Duration r111, String r112, boolean r113, boolean r114) {
            this.mRequestHeaderSizeInBytes = r100;
            this.mRequestBodySizeInBytes = r101;
            this.mResponseHeaderSizeInBytes = r102;
            this.mResponseBodySizeInBytes = r103;
            this.mResponseStatusCode = r104;
            this.mHeadersLatency = r110;
            this.mTotalLatency = r111;
            this.mNegotiatedProtocol = r112;
            this.mWasConnectionMigrationAttempted = r113;
            this.mDidConnectionMigrationSucceed = r114;
        }
    }

    public static class CronetVersion {
        private final int mBuildVersion;
        private final int mMajorVersion;
        private final int mMinorVersion;
        private final int mPatchVersion;

        public String toString() {
            return "" + this.mMajorVersion + "." + this.mMinorVersion + "." + this.mBuildVersion + "." + this.mPatchVersion;
        }

        public int getBuildVersion() {
            return this.mBuildVersion;
        }

        public int getMajorVersion() {
            return this.mMajorVersion;
        }

        public int getMinorVersion() {
            return this.mMinorVersion;
        }

        public int getPatchVersion() {
            return this.mPatchVersion;
        }

        public CronetVersion(String r100) {
            String[] r101 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
            this.mMajorVersion = CastIntegerProtector.parseInt(r101[0]);
            this.mMinorVersion = CastIntegerProtector.parseInt(r101[1]);
            this.mBuildVersion = CastIntegerProtector.parseInt(r101[2]);
            this.mPatchVersion = CastIntegerProtector.parseInt(r101[3]);
        }
    }

    public CronetLogger() {
    }

    public abstract void logCronetEngineCreation(int r100, CronetEngineBuilderInfo r101, CronetVersion r102, CronetSource r103);

    public abstract void logCronetTrafficInfo(int r100, CronetTrafficInfo r101);
}
