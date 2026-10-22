package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEnhancedSearchEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionSingleEntry;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bH\u0010IR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010&\u001a\u0004\b1\u0010(R\u001c\u00103\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001c\u00108\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001c\u0010=\u001a\u0004\u0018\u00010<8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010B\u001a\u00020A8\u0006X\u0087D¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010&\u001a\u0004\bG\u0010(¨\u0006J"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageHeaderData;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$r;", "promotionBackground", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$r;", "getPromotionBackground", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$r;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$f;", "authorShopInfo", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$f;", "getAuthorShopInfo", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$f;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$v;", "storeEntranceInfo", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$v;", "getStoreEntranceInfo", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$v;", "", "", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "anchorTags", "Ljava/util/Map;", "getAnchorTags", "()Ljava/util/Map;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "authorReputation", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "getAuthorReputation", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$o;", "listBanner", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$o;", "getListBanner", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$o;", "setListBanner", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$o;)V", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEntry;", "entries", "Ljava/util/List;", "getEntries", "()Ljava/util/List;", "searchSchema", "getSearchSchema", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEnhancedSearchEntry;", "enhanceSearchEntry", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEnhancedSearchEntry;", "getEnhanceSearchEntry", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionEnhancedSearchEntry;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSingleEntry;", "singleEntry", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSingleEntry;", "getSingleEntry", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionSingleEntry;", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionHeaderLayoutControl;", "layoutControl", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionHeaderLayoutControl;", "getLayoutControl", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionHeaderLayoutControl;", "", "enterMergeShop", "I", "getEnterMergeShop", "()I", "callback", "getCallback", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionPageHeaderData implements Serializable {

    @SerializedName("anchor_tags")
    private final Map<String, List<ECRitTag>> anchorTags;

    @SerializedName("author_reputation")
    private final ECPromotionList.d authorReputation;

    @SerializedName("author_shop_info")
    private final ECPromotionList.f authorShopInfo;

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("callback")
    private final String callback;

    @SerializedName("enhanced_search_entry")
    private final ECPromotionEnhancedSearchEntry enhanceSearchEntry;

    @SerializedName("enter_merge_shop")
    private final int enterMergeShop;

    @SerializedName("entries")
    private final List<ECPromotionEntry> entries;

    @SerializedName("layout_control")
    private final ECPromotionHeaderLayoutControl layoutControl;

    @SerializedName("list_banner")
    private ECPromotionList.o listBanner;

    @SerializedName("promotion_background")
    private final ECPromotionList.r promotionBackground;

    @SerializedName("search_schema")
    private final String searchSchema;

    @SerializedName("single_entry")
    private final ECPromotionSingleEntry singleEntry;

    @SerializedName("author_shop_window_info")
    private final ECPromotionList.v storeEntranceInfo;

    public LivePromotionPageHeaderData() {
    }

    public final Map<String, List<ECRitTag>> getAnchorTags() {
        return this.anchorTags;
    }

    public final ECPromotionList.d getAuthorReputation() {
        return this.authorReputation;
    }

    public final ECPromotionList.f getAuthorShopInfo() {
        return this.authorShopInfo;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getCallback() {
        return this.callback;
    }

    public final ECPromotionEnhancedSearchEntry getEnhanceSearchEntry() {
        return this.enhanceSearchEntry;
    }

    public final int getEnterMergeShop() {
        return this.enterMergeShop;
    }

    public final List<ECPromotionEntry> getEntries() {
        return this.entries;
    }

    public final ECPromotionHeaderLayoutControl getLayoutControl() {
        return this.layoutControl;
    }

    public final ECPromotionList.o getListBanner() {
        return this.listBanner;
    }

    public final ECPromotionList.r getPromotionBackground() {
        return this.promotionBackground;
    }

    public final String getSearchSchema() {
        return this.searchSchema;
    }

    public final ECPromotionSingleEntry getSingleEntry() {
        return this.singleEntry;
    }

    public final ECPromotionList.v getStoreEntranceInfo() {
        return this.storeEntranceInfo;
    }

    public final void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public final void setListBanner(ECPromotionList.o r1) {
        this.listBanner = r1;
    }
}
