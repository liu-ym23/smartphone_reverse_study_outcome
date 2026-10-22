package com.bytedance.awemeopen.bizmodels.feed.shopping.card;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\"\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017¨\u00062"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/a;", "", "", "", "promotionIds", "Ljava/util/List;", "getPromotionIds", "()Ljava/util/List;", "elasticSecondTitle", "Ljava/lang/String;", "getElasticSecondTitle", "()Ljava/lang/String;", "", "elasticSecondTitleStyle", "I", "getElasticSecondTitleStyle", "()I", "anchorPrice", "getAnchorPrice", "", "showProductImage", "Ljava/lang/Boolean;", "getShowProductImage", "()Ljava/lang/Boolean;", "anchorSuffix", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "goodPriceParam", "getGoodPriceParam", "goodPriceCardGuessLikeOpt", "Ljava/lang/Integer;", "getGoodPriceCardGuessLikeOpt", "()Ljava/lang/Integer;", "goodPriceCardMainOpt", "getGoodPriceCardMainOpt", "innerLandingImageSearch", "getInnerLandingImageSearch", "Lcom/google/gson/JsonObject;", "fullProductFlowConfig", "Lcom/google/gson/JsonObject;", "getFullProductFlowConfig", "()Lcom/google/gson/JsonObject;", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/b;", "anchorSuffixUIConfig", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/b;", "getAnchorSuffixUIConfig", "()Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/b;", "shopAnchorLibraTag", "getShopAnchorLibraTag", "shopAnchorShowFix", "getShopAnchorShowFix", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    @SerializedName("anchor_price")
    private final String anchorPrice;

    @SerializedName("anchor_suffix")
    private final String anchorSuffix;

    @SerializedName("anchor_suffix_ui_config")
    private final b anchorSuffixUIConfig;

    @SerializedName("elastic_second_title")
    private final String elasticSecondTitle;

    @SerializedName("elastic_second_title_style")
    private final int elasticSecondTitleStyle;

    @SerializedName("immersive_inner_flow_config")
    private final JsonObject fullProductFlowConfig;

    @SerializedName("good_price_card_guess_like_opt")
    private final Integer goodPriceCardGuessLikeOpt;

    @SerializedName("good_price_card_main_opt")
    private final Integer goodPriceCardMainOpt;

    @SerializedName("good_price_param")
    private final List<String> goodPriceParam;

    @SerializedName("inner_landing_image_search")
    private final Integer innerLandingImageSearch;

    @SerializedName("promotion_id_list")
    private final List<String> promotionIds;

    @SerializedName("shop_anchor_libra_tag")
    private final String shopAnchorLibraTag;

    @SerializedName("shop_anchor_show_fix")
    private final Boolean shopAnchorShowFix;

    @SerializedName("show_product_image")
    private final Boolean showProductImage;

    public a() {
        this.promotionIds = null;
        this.elasticSecondTitle = "";
        this.elasticSecondTitleStyle = 1;
        this.anchorPrice = null;
        this.showProductImage = null;
        this.anchorSuffix = null;
        this.goodPriceParam = null;
        this.goodPriceCardGuessLikeOpt = 0;
        this.goodPriceCardMainOpt = 0;
        this.innerLandingImageSearch = null;
        this.fullProductFlowConfig = null;
        this.anchorSuffixUIConfig = null;
        this.shopAnchorLibraTag = null;
        this.shopAnchorShowFix = null;
    }

    public final String a() {
        return this.anchorSuffix;
    }
}
