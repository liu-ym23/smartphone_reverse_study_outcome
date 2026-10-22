package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/CommonInfoCommonProp;", "Ljava/io/Serializable;", "()V", "bgConfig", "Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig;", "getBgConfig", "()Lcom/ss/android/ugc/aweme/discover/model/BackgroundConfig;", "logInfo", "", "", "", "getLogInfo", "()Ljava/util/Map;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonInfoCommonProp implements Serializable {

    @SerializedName("bg_config")
    private final BackgroundConfig bgConfig;

    @SerializedName("log_info")
    private final Map<String, Object> logInfo;

    public CommonInfoCommonProp() {
    }

    public final BackgroundConfig getBgConfig() {
        return this.bgConfig;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }
}
