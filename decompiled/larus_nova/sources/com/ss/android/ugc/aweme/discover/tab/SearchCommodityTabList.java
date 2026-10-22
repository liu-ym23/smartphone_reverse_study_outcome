package com.ss.android.ugc.aweme.discover.tab;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.ugc.aweme.common.TabsGuideInfo;
import com.ss.android.ugc.aweme.framework.tab.TabFeedModel;
import com.ss.android.ugc.aweme.search.tabguide.model.GuideIconInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/tab/SearchCommodityTabList;", "", "", "Lcom/ss/android/ugc/aweme/framework/tab/TabFeedModel;", "tabList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/aweme/search/tabguide/model/GuideIconInfo;", "guideIconInfo", "Lcom/ss/android/ugc/aweme/search/tabguide/model/GuideIconInfo;", "getGuideIconInfo", "()Lcom/ss/android/ugc/aweme/search/tabguide/model/GuideIconInfo;", "setGuideIconInfo", "(Lcom/ss/android/ugc/aweme/search/tabguide/model/GuideIconInfo;)V", "", "originTabList", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setOriginTabList", "(Ljava/lang/String;)V", "", "isHideTab", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setHideTab", "(Ljava/lang/Boolean;)V", "forceUpdate", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setForceUpdate", "showTabFilterCard", "getShowTabFilterCard", "setShowTabFilterCard", "Lcom/ss/android/ugc/aweme/discover/tab/SelectedData;", "selectedInfo", "Lcom/ss/android/ugc/aweme/discover/tab/SelectedData;", "c", "()Lcom/ss/android/ugc/aweme/discover/tab/SelectedData;", "setSelectedInfo", "(Lcom/ss/android/ugc/aweme/discover/tab/SelectedData;)V", "Lcom/ss/android/ugc/aweme/common/TabsGuideInfo;", "tabsGuideInfo", "Lcom/ss/android/ugc/aweme/common/TabsGuideInfo;", "e", "()Lcom/ss/android/ugc/aweme/common/TabsGuideInfo;", "setTabsGuideInfo", "(Lcom/ss/android/ugc/aweme/common/TabsGuideInfo;)V", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityTabList {

    @SerializedName(DownloadConstants.KEY_FORCE_UPDATE)
    private Boolean forceUpdate;

    @SerializedName("guide_icon_info")
    private GuideIconInfo guideIconInfo;

    @SerializedName("need_hide_tab")
    private Boolean isHideTab;

    @SerializedName("origin_tab_list")
    private String originTabList;

    @SerializedName("selected")
    private SelectedData selectedInfo;

    @SerializedName("show_tab_filter_card")
    private Boolean showTabFilterCard;

    @SerializedName("tab_list")
    private List<TabFeedModel> tabList;

    @SerializedName("tabs_guide_info")
    private TabsGuideInfo tabsGuideInfo;

    public SearchCommodityTabList() {
        Boolean r100 = Boolean.FALSE;
        this.isHideTab = r100;
        this.forceUpdate = r100;
        this.showTabFilterCard = r100;
    }

    public final Boolean a() {
        return this.forceUpdate;
    }

    public final String b() {
        return this.originTabList;
    }

    public final SelectedData c() {
        return this.selectedInfo;
    }

    public final List<TabFeedModel> d() {
        return this.tabList;
    }

    public final TabsGuideInfo e() {
        return this.tabsGuideInfo;
    }
}
