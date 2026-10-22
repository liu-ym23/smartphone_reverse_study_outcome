package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.feed.model.search.SearchCommodityTagInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R*\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/FilterItem;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SelectItem;", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "selectTextColor", "Ljava/lang/String;", "getSelectTextColor", "()Ljava/lang/String;", "setSelectTextColor", "(Ljava/lang/String;)V", "unSelectTextColor", "getUnSelectTextColor", "setUnSelectTextColor", "selectBgColor", "getSelectBgColor", "setSelectBgColor", "unSelectBgColor", "getUnSelectBgColor", "setUnSelectBgColor", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "activityIcon", "Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "getActivityIcon", "()Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "setActivityIcon", "(Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/HeadIcon;", "headIcon", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/HeadIcon;", "getHeadIcon", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/HeadIcon;", "setHeadIcon", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/HeadIcon;)V", "selectedHeadIcon", "getSelectedHeadIcon", "setSelectedHeadIcon", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SubFilterItem;", "subFilters", "Ljava/util/List;", "getSubFilters", "()Ljava/util/List;", "setSubFilters", "(Ljava/util/List;)V", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterItem extends SelectItem {

    @SerializedName("activity_icon")
    private SearchCommodityTagInfo activityIcon;

    @SerializedName("head_icon")
    private HeadIcon headIcon;

    @SerializedName("select_bg_color")
    private String selectBgColor;

    @SerializedName("select_text_color")
    private String selectTextColor;

    @SerializedName("select_head_icon")
    private HeadIcon selectedHeadIcon;

    @SerializedName("sub_filters")
    private List<SubFilterItem> subFilters;

    @SerializedName("type")
    private int type;

    @SerializedName("unselect_bg_color")
    private String unSelectBgColor;

    @SerializedName("unselect_text_color")
    private String unSelectTextColor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/FilterItem$Companion;", "", "()V", "FILTER_ACTIVITY", "", "FILTER_INVALID", "FILTER_NORMAL", "FILTER_WITH_SUB_FILTERS", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public FilterItem() {
        this.type = -1;
    }

    public final int getType() {
        return this.type;
    }
}
