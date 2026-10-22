package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardTabInfo;", "Ljava/io/Serializable;", "()V", "cardList", "", "", "getCardList", "()Ljava/util/List;", "setCardList", "(Ljava/util/List;)V", "tabExtraText", "getTabExtraText", "()Ljava/lang/String;", "setTabExtraText", "(Ljava/lang/String;)V", "tabId", "", "getTabId", "()I", "setTabId", "(I)V", "tabName", "getTabName", "setTabName", "tabNameEn", "getTabNameEn", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveLocalLifeCardTabInfo implements Serializable {

    @SerializedName("card_list")
    private List<String> cardList;

    @SerializedName("tab_extra_text")
    private String tabExtraText;

    @SerializedName("tab_id")
    private int tabId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private String tabName;

    @SerializedName("tab_name_en")
    private final String tabNameEn;

    public LiveLocalLifeCardTabInfo() {
    }

    public final List<String> getCardList() {
        return this.cardList;
    }

    public final String getTabExtraText() {
        return this.tabExtraText;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabNameEn() {
        return this.tabNameEn;
    }

    public final void setCardList(List<String> r100) {
        this.cardList = r100;
    }

    public final void setTabExtraText(String r100) {
        this.tabExtraText = r100;
    }

    public final void setTabId(int r100) {
        this.tabId = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }
}
