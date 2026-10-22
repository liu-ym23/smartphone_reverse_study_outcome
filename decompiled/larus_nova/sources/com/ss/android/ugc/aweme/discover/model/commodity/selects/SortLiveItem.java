package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortLiveItem;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SortItem;", "", "selectTextColor", "Ljava/lang/String;", "getSelectTextColor", "()Ljava/lang/String;", "setSelectTextColor", "(Ljava/lang/String;)V", "unselectTextColor", "getUnselectTextColor", "setUnselectTextColor", "selectBgColor", "getSelectBgColor", "setSelectBgColor", "unselectBgColor", "getUnselectBgColor", "setUnselectBgColor", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/Icon;", "img", "Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/Icon;", "getImg", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/Icon;", "setImg", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/Icon;)V", "selectedImg", "getSelectedImg", "setSelectedImg", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortLiveItem extends SortItem {

    @SerializedName("head_icon")
    private Icon img;

    @SerializedName("select_bg_color")
    private String selectBgColor;

    @SerializedName("select_text_color")
    private String selectTextColor;

    @SerializedName("select_head_icon")
    private Icon selectedImg;

    @SerializedName("unselect_bg_color")
    private String unselectBgColor;

    @SerializedName("unselect_text_color")
    private String unselectTextColor;

    public SortLiveItem() {
    }
}
