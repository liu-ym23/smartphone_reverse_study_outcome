package com.ss.android.ugc.aweme.framework.tab;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class TabFeedModel implements Serializable {
    public IBuildFragmentConfig buildFragmentConfig;

    @SerializedName("extra")
    public Map<String, String> extra;

    @SerializedName("feed_type")
    public Integer feedType;

    @SerializedName("is_default_landing")
    public Boolean isDefaultLanding;

    @SerializedName("position")
    public Integer position;

    @SerializedName("prefix_icon")
    public UrlModel prefixIcon;

    @SerializedName("priority")
    public Integer priority;

    @SerializedName(a.KEY_TAB_NAME)
    public String tabName;

    @SerializedName("tab_type")
    public String tabType;

    @AllowImpl
    public int hashCode() {
        return Objects.hash(new Object[]{this.tabType, this.tabName, this.feedType});
    }

    public String toString() {
        return "TabFeedModel{tabType='" + this.tabType + "', tabName='" + this.tabName + "', feedType=" + this.feedType + '}';
    }

    public TabFeedModel() {
        this.feedType = null;
        this.position = null;
        this.priority = 0;
    }

    @AllowImpl
    public Integer getFeedType() {
        return this.feedType;
    }

    @AllowImpl
    public String getTabName() {
        return this.tabName;
    }

    @AllowImpl
    public String getTabType() {
        return this.tabType;
    }

    @AllowImpl
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        TabFeedModel r101 = (TabFeedModel) r100;
        if (this.feedType == r101.feedType) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.tabType, r101.tabType) == false) goto L17;
        if (Objects.equals(this.tabName, r101.tabName) == false) goto L17;
        return true;
    }

    @AllowImpl
    public void setFeedType(int r100) {
        this.feedType = Integer.valueOf(r100);
    }

    @AllowImpl
    public void setTabName(String r100) {
        this.tabName = r100;
    }

    @AllowImpl
    public void setTabType(String r100) {
        this.tabType = r100;
    }

    public TabFeedModel(String r100, String r101, int r102) {
        this.feedType = null;
        this.position = null;
        this.priority = 0;
        this.tabType = r100;
        this.tabName = r101;
        this.feedType = Integer.valueOf(r102);
    }
}
