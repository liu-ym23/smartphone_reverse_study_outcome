package com.ss.android.ugc.aweme.discover.model.commodity.aladdin;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinInfo;", "Ljava/io/Serializable;", "()V", "aladdinLogData", "Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinLogData;", "getAladdinLogData", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinLogData;", "setAladdinLogData", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/AladdinLogData;)V", "display", "Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/Display;", "getDisplay", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/Display;", "setDisplay", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/aladdin/Display;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AladdinInfo implements Serializable {

    @SerializedName("aladdin_log_data")
    private AladdinLogData aladdinLogData;

    @SerializedName("display")
    private Display display;

    public AladdinInfo() {
    }

    public final AladdinLogData getAladdinLogData() {
        return this.aladdinLogData;
    }

    public final Display getDisplay() {
        return this.display;
    }

    public final void setAladdinLogData(AladdinLogData r100) {
        this.aladdinLogData = r100;
    }

    public final void setDisplay(Display r100) {
        this.display = r100;
    }
}
