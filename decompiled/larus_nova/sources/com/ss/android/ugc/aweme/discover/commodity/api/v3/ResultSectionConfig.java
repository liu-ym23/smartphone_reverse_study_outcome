package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006)"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSectionConfig;", "Ljava/io/Serializable;", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ITabInfo;", "()V", "channel", "", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "searchId", "getSearchId", "setSearchId", "sectionId", "getSectionId", "setSectionId", "sectionName", "getSectionName", "setSectionName", "tabName", "getTabName", "setTabName", "tabType", "getTabType", "setTabType", "getExtraData", "getName", "getRank", "getType", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResultSectionConfig implements Serializable, ITabInfo {

    @SerializedName("channel")
    private String channel;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("position")
    private int position;

    @SerializedName("search_id")
    private String searchId;

    @SerializedName("section_id")
    private String sectionId;

    @SerializedName("section_name")
    private String sectionName;

    @SerializedName(a.KEY_TAB_NAME)
    private String tabName;

    @SerializedName("tab_type")
    private String tabType;

    public ResultSectionConfig() {
    }

    public String getName() {
        String r100 = this.tabName;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.api.v3.ITabInfo
    public String getType() {
        String r100 = this.tabType;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public String getExtraData() {
        return this.channel;
    }

    public final int getPosition() {
        return this.position;
    }

    public int getRank() {
        return this.position;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabType() {
        return this.tabType;
    }

    public final void setChannel(String r100) {
        this.channel = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setPosition(int r100) {
        this.position = r100;
    }

    public final void setSearchId(String r100) {
        this.searchId = r100;
    }

    public final void setSectionId(String r100) {
        this.sectionId = r100;
    }

    public final void setSectionName(String r100) {
        this.sectionName = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public final void setTabType(String r100) {
        this.tabType = r100;
    }
}
