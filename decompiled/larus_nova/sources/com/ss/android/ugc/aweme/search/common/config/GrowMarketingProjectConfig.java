package com.ss.android.ugc.aweme.search.common.config;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/GrowMarketingProjectConfig;", "Ljava/io/Serializable;", "()V", "endTime", "", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "fetchFrequency", "getFetchFrequency", "setFetchFrequency", "fetchWhen", "", "", "getFetchWhen", "()Ljava/util/List;", "setFetchWhen", "(Ljava/util/List;)V", "localTestAk", "getLocalTestAk", "()Ljava/lang/String;", "setLocalTestAk", "(Ljava/lang/String;)V", "name", "getName", "setName", "onlineAk", "getOnlineAk", "setOnlineAk", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "type", "getType", "setType", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GrowMarketingProjectConfig implements Serializable {

    @SerializedName("end_time")
    private Long endTime;

    @SerializedName("fetch_frequency")
    private Long fetchFrequency;

    @SerializedName("fetch_when")
    private List<String> fetchWhen;

    @SerializedName("local_test_ak")
    private String localTestAk;

    @SerializedName("name")
    private String name;

    @SerializedName("online_ak")
    private String onlineAk;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private Long startTime;

    @SerializedName("type")
    private String type;

    public GrowMarketingProjectConfig() {
        this.onlineAk = "";
        this.localTestAk = "";
        this.type = "";
        this.name = "";
        this.startTime = 0L;
        this.endTime = 0L;
        this.fetchFrequency = 0L;
        this.fetchWhen = new ArrayList();
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final Long getFetchFrequency() {
        return this.fetchFrequency;
    }

    public final List<String> getFetchWhen() {
        return this.fetchWhen;
    }

    public final String getLocalTestAk() {
        return this.localTestAk;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOnlineAk() {
        return this.onlineAk;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getType() {
        return this.type;
    }

    public final void setEndTime(Long r100) {
        this.endTime = r100;
    }

    public final void setFetchFrequency(Long r100) {
        this.fetchFrequency = r100;
    }

    public final void setFetchWhen(List<String> r100) {
        this.fetchWhen = r100;
    }

    public final void setLocalTestAk(String r100) {
        this.localTestAk = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setOnlineAk(String r100) {
        this.onlineAk = r100;
    }

    public final void setStartTime(Long r100) {
        this.startTime = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }
}
