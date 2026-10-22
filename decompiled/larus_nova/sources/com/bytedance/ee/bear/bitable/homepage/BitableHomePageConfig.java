package com.bytedance.ee.bear.bitable.homepage;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "ccm_base_recommend")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/BitableHomePageConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "recommendChunkSize", "", "getRecommendChunkSize", "()Ljava/lang/Integer;", "setRecommendChunkSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "homeDiversionTimeout", "", "getHomeDiversionTimeout", "()Ljava/lang/Long;", "setHomeDiversionTimeout", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "recommendViewReportIntervalMills", "getRecommendViewReportIntervalMills", "setRecommendViewReportIntervalMills", "recommendListCacheVersion", "", "getRecommendListCacheVersion", "()Ljava/lang/String;", "setRecommendListCacheVersion", "(Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHomePageConfig implements NonProguard {

    @SerializedName("home_diversion_timeout")
    private Long homeDiversionTimeout;

    @SerializedName("recommend_chunk_size")
    private Integer recommendChunkSize;

    @SerializedName("list_cache_version")
    private String recommendListCacheVersion;

    @SerializedName("recommend_view_report_interval_mills")
    private Long recommendViewReportIntervalMills;

    public BitableHomePageConfig() {
        this.recommendChunkSize = 12;
        this.homeDiversionTimeout = 200L;
        this.recommendViewReportIntervalMills = 1500L;
        this.recommendListCacheVersion = OuterPayLoginWrapper.LOGIN_STYLE_V1;
    }

    public final Long getHomeDiversionTimeout() {
        return this.homeDiversionTimeout;
    }

    public final Integer getRecommendChunkSize() {
        return this.recommendChunkSize;
    }

    public final String getRecommendListCacheVersion() {
        return this.recommendListCacheVersion;
    }

    public final Long getRecommendViewReportIntervalMills() {
        return this.recommendViewReportIntervalMills;
    }

    public final void setHomeDiversionTimeout(Long r100) {
        this.homeDiversionTimeout = r100;
    }

    public final void setRecommendChunkSize(Integer r100) {
        this.recommendChunkSize = r100;
    }

    public final void setRecommendListCacheVersion(String r100) {
        this.recommendListCacheVersion = r100;
    }

    public final void setRecommendViewReportIntervalMills(Long r100) {
        this.recommendViewReportIntervalMills = r100;
    }
}
