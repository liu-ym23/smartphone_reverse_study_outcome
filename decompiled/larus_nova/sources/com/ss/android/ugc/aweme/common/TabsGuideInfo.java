package com.ss.android.ugc.aweme.common;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/common/TabsGuideInfo;", "Ljava/io/Serializable;", "()V", "globalTabGuideExitInfo", "Lcom/ss/android/ugc/aweme/common/GlobalTabGuideExitInfo;", "getGlobalTabGuideExitInfo", "()Lcom/ss/android/ugc/aweme/common/GlobalTabGuideExitInfo;", "tabGuideList", "", "Lcom/ss/android/ugc/aweme/common/TabGuideInfo;", "getTabGuideList", "()Ljava/util/List;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabsGuideInfo implements Serializable {

    @SerializedName("global_tab_guide_exit_info")
    private final GlobalTabGuideExitInfo globalTabGuideExitInfo;

    @SerializedName("tab_guide_list")
    private final List<TabGuideInfo> tabGuideList;

    public TabsGuideInfo() {
    }

    public final GlobalTabGuideExitInfo getGlobalTabGuideExitInfo() {
        return this.globalTabGuideExitInfo;
    }

    public final List<TabGuideInfo> getTabGuideList() {
        return this.tabGuideList;
    }
}
