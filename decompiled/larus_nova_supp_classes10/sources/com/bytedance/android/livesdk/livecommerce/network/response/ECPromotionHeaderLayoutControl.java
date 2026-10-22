package com.bytedance.android.livesdk.livecommerce.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionHeaderLayoutControl;", "Ljava/io/Serializable;", "()V", "browsingStyle", "", "getBrowsingStyle", "()I", "entryInnerSpacing", "getEntryInnerSpacing", "headerStyle", "getHeaderStyle", "tabStyle", "getTabStyle", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionHeaderLayoutControl implements Serializable {

    @SerializedName("browsing_style")
    private final int browsingStyle;

    @SerializedName("entry_inner_spacing")
    private final int entryInnerSpacing;

    @SerializedName("header_style")
    private final int headerStyle;

    @SerializedName("tab_style")
    private final int tabStyle;

    public ECPromotionHeaderLayoutControl() {
    }

    public final int getBrowsingStyle() {
        return this.browsingStyle;
    }

    public final int getEntryInnerSpacing() {
        return this.entryInnerSpacing;
    }

    public final int getHeaderStyle() {
        return this.headerStyle;
    }

    public final int getTabStyle() {
        return this.tabStyle;
    }
}
