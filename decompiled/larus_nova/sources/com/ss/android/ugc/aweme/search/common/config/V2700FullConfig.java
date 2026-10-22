package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R2\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/V2700FullConfig;", "", "()V", "enable", "", "getEnable", "()I", "setEnable", "(I)V", "forbiddenChannelList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getForbiddenChannelList", "()Ljava/util/ArrayList;", "setForbiddenChannelList", "(Ljava/util/ArrayList;)V", "passedEntranceList", "getPassedEntranceList", "setPassedEntranceList", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class V2700FullConfig {

    @SerializedName("opt_release_enable")
    private int enable;

    @SerializedName("forbidden_channel_list")
    private ArrayList<String> forbiddenChannelList;

    @SerializedName("passed_entrance_list")
    private ArrayList<String> passedEntranceList;

    public V2700FullConfig() {
        this.enable = 1;
        ArrayList<String> r100 = new ArrayList();
        r100.add("ecom_search_similar_product");
        Unit r101 = Unit.INSTANCE;
        this.forbiddenChannelList = r100;
        ArrayList<String> r102 = new ArrayList();
        r102.add("ecom_photo_search_out_sale_have_notice");
        r102.add("ecom_photo_search_out_sale_no_notice");
        r102.add("ecom_photo_search_goods_limit_single_sku");
        r102.add("ecom_photo_search_goods_limit_multi_sku");
        this.passedEntranceList = r102;
    }

    public final int getEnable() {
        return this.enable;
    }

    public final ArrayList<String> getForbiddenChannelList() {
        return this.forbiddenChannelList;
    }

    public final ArrayList<String> getPassedEntranceList() {
        return this.passedEntranceList;
    }

    public final void setEnable(int r100) {
        this.enable = r100;
    }

    public final void setForbiddenChannelList(ArrayList<String> r100) {
        this.forbiddenChannelList = r100;
    }

    public final void setPassedEntranceList(ArrayList<String> r100) {
        this.passedEntranceList = r100;
    }
}
