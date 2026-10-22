package com.ss.android.ugc.aweme.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/common/TabGuideInfo;", "Ljava/io/Serializable;", "()V", "tabGuideExitInfo", "Lcom/ss/android/ugc/aweme/common/TabGuideExitInfo;", "getTabGuideExitInfo", "()Lcom/ss/android/ugc/aweme/common/TabGuideExitInfo;", "tabGuideType", "", "getTabGuideType", "()I", "tabType", "", "getTabType", "()Ljava/lang/String;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabGuideInfo implements Serializable {

    @SerializedName("tab_guide_exit_info")
    private final TabGuideExitInfo tabGuideExitInfo;

    @SerializedName("guide_type")
    private final int tabGuideType;

    @SerializedName("tab_type")
    private final String tabType;

    public TabGuideInfo() {
    }

    public final TabGuideExitInfo getTabGuideExitInfo() {
        return this.tabGuideExitInfo;
    }

    public final int getTabGuideType() {
        return this.tabGuideType;
    }

    public final String getTabType() {
        return this.tabType;
    }
}
