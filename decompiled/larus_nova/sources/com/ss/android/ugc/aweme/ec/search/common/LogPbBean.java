package com.ss.android.ugc.aweme.ec.search.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/ec/search/common/LogPbBean;", "Ljava/io/Serializable;", "()V", "imprId", "", "getImprId", "()Ljava/lang/String;", "setImprId", "(Ljava/lang/String;)V", "logExtra", "Lcom/ss/android/ugc/aweme/ec/search/common/LogExtra;", "getLogExtra", "()Lcom/ss/android/ugc/aweme/ec/search/common/LogExtra;", "setLogExtra", "(Lcom/ss/android/ugc/aweme/ec/search/common/LogExtra;)V", "stabExtra", "Lcom/ss/android/ugc/aweme/ec/search/common/StabExtraStruct;", "getStabExtra", "()Lcom/ss/android/ugc/aweme/ec/search/common/StabExtraStruct;", "setStabExtra", "(Lcom/ss/android/ugc/aweme/ec/search/common/StabExtraStruct;)V", "getExtra", "setExtra", "", "extra", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LogPbBean implements Serializable {

    @SerializedName("impr_id")
    private String imprId;

    @SerializedName("log_extra")
    private LogExtra logExtra;

    @SerializedName("stab_extra")
    private StabExtraStruct stabExtra;

    public LogPbBean() {
    }

    public final LogExtra getExtra() {
        return this.logExtra;
    }

    public final String getImprId() {
        return this.imprId;
    }

    public final LogExtra getLogExtra() {
        return this.logExtra;
    }

    public final StabExtraStruct getStabExtra() {
        return this.stabExtra;
    }

    public final void setExtra(LogExtra r100) {
        this.logExtra = r100;
    }

    public final void setImprId(String r100) {
        this.imprId = r100;
    }

    public final void setLogExtra(LogExtra r100) {
        this.logExtra = r100;
    }

    public final void setStabExtra(StabExtraStruct r100) {
        this.stabExtra = r100;
    }
}
