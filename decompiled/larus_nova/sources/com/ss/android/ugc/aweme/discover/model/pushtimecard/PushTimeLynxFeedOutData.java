package com.ss.android.ugc.aweme.discover.model.pushtimecard;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLynxFeedOutData;", "Ljava/io/Serializable;", "()V", "layout", "Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLayoutData;", "getLayout", "()Lcom/ss/android/ugc/aweme/discover/model/pushtimecard/PushTimeLayoutData;", "lifeCycleStrategy", "", "getLifeCycleStrategy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "noShow", "getNoShow", "()I", "rawData", "", "getRawData", "()Ljava/lang/String;", "schema", "getSchema", "type", "getType", "trade-search-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PushTimeLynxFeedOutData implements Serializable {

    @SerializedName("layout")
    private final PushTimeLayoutData layout;

    @SerializedName("life_cycle_strategy")
    private final Integer lifeCycleStrategy;

    @SerializedName("no_show")
    private final int noShow;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private final String rawData;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("type")
    private final String type;

    public PushTimeLynxFeedOutData() {
    }

    public final PushTimeLayoutData getLayout() {
        return this.layout;
    }

    public final Integer getLifeCycleStrategy() {
        return this.lifeCycleStrategy;
    }

    public final int getNoShow() {
        return this.noShow;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getType() {
        return this.type;
    }
}
