package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 l2\u00020\u0001:\u0002klB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR,\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR \u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR&\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR&\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010-\"\u0004\bF\u0010/R \u0010G\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR,\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001d\"\u0004\bL\u0010\u001fR \u0010M\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR \u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR \u0010U\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR&\u0010[\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010-\"\u0004\b^\u0010/R&\u0010_\u001a\n\u0012\u0004\u0012\u00020V\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010-\"\u0004\ba\u0010/R \u0010b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0006\"\u0004\bd\u0010\bR\u001e\u0010e\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00103\"\u0004\bg\u00105R\u001e\u0010h\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00103\"\u0004\bj\u00105¨\u0006m"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/EcomInfo;", "Ljava/io/Serializable;", "()V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "breathInfo", "Lcom/ss/android/ugc/aweme/discover/model/EcomInfo$BreathInfo;", "getBreathInfo", "()Lcom/ss/android/ugc/aweme/discover/model/EcomInfo$BreathInfo;", "btnBackgroundColor", "getBtnBackgroundColor", "setBtnBackgroundColor", "btnColor", "getBtnColor", "setBtnColor", "enterColor", "getEnterColor", "setEnterColor", "enterText", "getEnterText", "setEnterText", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "grade", "getGrade", "setGrade", "liveBcmParams", "getLiveBcmParams", "setLiveBcmParams", "recommendInfo", "getRecommendInfo", "setRecommendInfo", "recommendInfoV2", "", "Lcom/ss/android/ugc/aweme/discover/model/RecommendText;", "getRecommendInfoV2", "()Ljava/util/List;", "setRecommendInfoV2", "(Ljava/util/List;)V", "recommendTextEllipsisIndex", "", "getRecommendTextEllipsisIndex", "()I", "setRecommendTextEllipsisIndex", "(I)V", "scalesText", "getScalesText", "setScalesText", "schema", "getSchema", "setSchema", a.KEY_SCORE, "", "getScore", "()Ljava/lang/Float;", "setScore", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "scoreTags", "Lcom/ss/android/ugc/aweme/discover/model/ScoreTags;", "getScoreTags", "setScoreTags", "scoreText", "getScoreText", "setScoreText", "shopAreaBcmParams", "getShopAreaBcmParams", "setShopAreaBcmParams", "shopGuaranteeTags", "getShopGuaranteeTags", "()Lcom/ss/android/ugc/aweme/discover/model/ScoreTags;", "setShopGuaranteeTags", "(Lcom/ss/android/ugc/aweme/discover/model/ScoreTags;)V", "shopId", "getShopId", "setShopId", "shopLogo", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getShopLogo", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setShopLogo", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "shopServiceInfoList", "Lcom/ss/android/ugc/aweme/discover/model/UserServiceInfo;", "getShopServiceInfoList", "setShopServiceInfoList", "shopTags", "getShopTags", "setShopTags", "shopText", "getShopText", "setShopText", "shopType", "getShopType", "setShopType", "userIdentity", "getUserIdentity", "setUserIdentity", "BreathInfo", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomInfo implements Serializable {
    public static final int AVATAR_VERIFY_HIDDEN_YES = 1;
    public static final Companion Companion = null;
    public static final String ENTER_SHOP_STYLE = "enter_button_style";
    public static final int ENTER_SHOP_STYLE_IS_NEW = 1;
    public static final String INSTANT_ADDRESS_INFO = "instant_address_info";
    public static final String IS_AVATAR_VERIFY_HIDDEN = "is_avatar_verify_hidden";
    public static final String IS_SEARCH_SUPERMARKET = "is_search_supermarket";
    public static final String LIVE_INFO_BREATH_STYLE = "live_info_breath_style";
    public static final int LIVE_INFO_BREATH_STYLE_IS_NEW = 1;
    public static final String LIVE_JUMP_TO_SHOP = "live_jump_to_shop";
    public static final String LIVE_JUMP_TO_STORE = "live_jump_to_store";
    public static final double MAX_SCORE = 5.0d;
    public static final String SHOP_NO_PRODUCT_TIPS = "bottom_tips";
    public static final int SHOP_USER_IDENTITY = 1;
    public static final int TYPE_SHOP_STRONG = 1;
    public static final int TYPE_SHOP_WEAK = 2;
    public static final int TYPE_SHOP_WINDOW = 0;
    public static final int TYPE_SHOP_WINDOW_V2 = 4;
    public static final int WINDOW_USER_IDENTITY = 2;

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("breath_info")
    private final BreathInfo breathInfo;

    @SerializedName("btn_background_color")
    private String btnBackgroundColor;

    @SerializedName("btn_color")
    private String btnColor;

    @SerializedName("enter_color")
    private String enterColor;

    @SerializedName("enter_text")
    private String enterText;

    @SerializedName("extra")
    private Map<String, ? extends Object> extra;

    @SerializedName("grade")
    private String grade;

    @SerializedName("live_bcm_params")
    private Map<String, String> liveBcmParams;

    @SerializedName(a.KEY_RECOMMEND_INFO)
    private String recommendInfo;

    @SerializedName("recommend_info_v2")
    private List<RecommendText> recommendInfoV2;

    @SerializedName("recommend_text_ellipsis_index")
    private int recommendTextEllipsisIndex;

    @SerializedName("sales_text")
    private String scalesText;

    @SerializedName("schema")
    private String schema;

    @SerializedName(a.KEY_SCORE)
    private Float score;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<ScoreTags> scoreTags;

    @SerializedName("score_text")
    private String scoreText;

    @SerializedName("shop_area_bcm_params")
    private Map<String, String> shopAreaBcmParams;

    @SerializedName("shop_guarantee_tags")
    private ScoreTags shopGuaranteeTags;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shop_logo")
    private UrlModel shopLogo;

    @SerializedName("shop_service_info_list")
    private List<UserServiceInfo> shopServiceInfoList;

    @SerializedName("shop_tags")
    private List<? extends UrlModel> shopTags;

    @SerializedName("shop_text")
    private String shopText;

    @SerializedName("shop_type")
    private int shopType;

    @SerializedName("user_identity")
    private int userIdentity;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/EcomInfo$BreathInfo;", "Ljava/io/Serializable;", "icon", "", "lineColor", "schema", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getLineColor", "getSchema", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BreathInfo implements Serializable {

        @SerializedName("icon")
        private final String icon;

        @SerializedName("line_color")
        private final String lineColor;

        @SerializedName("schema")
        private final String schema;

        public static /* synthetic */ BreathInfo copy$default(BreathInfo r100, String r101, String r102, String r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.icon;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.lineColor;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.schema;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.icon;
        }

        public final String component2() {
            return this.lineColor;
        }

        public final String component3() {
            return this.schema;
        }

        public final BreathInfo copy(String r100, String r101, String r102) {
            return new BreathInfo(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof BreathInfo) == false) goto L12;
            BreathInfo r101 = (BreathInfo) r100;
            if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.lineColor, r101.lineColor) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.icon;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.lineColor;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.schema;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "BreathInfo(icon=" + this.icon + ", lineColor=" + this.lineColor + ", schema=" + this.schema + ")";
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getLineColor() {
            return this.lineColor;
        }

        public final String getSchema() {
            return this.schema;
        }

        public BreathInfo(String r100, String r101, String r102) {
            this.icon = r100;
            this.lineColor = r101;
            this.schema = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/EcomInfo$Companion;", "", "()V", "AVATAR_VERIFY_HIDDEN_YES", "", "ENTER_SHOP_STYLE", "", "ENTER_SHOP_STYLE_IS_NEW", "INSTANT_ADDRESS_INFO", "IS_AVATAR_VERIFY_HIDDEN", "IS_SEARCH_SUPERMARKET", "LIVE_INFO_BREATH_STYLE", "LIVE_INFO_BREATH_STYLE_IS_NEW", "LIVE_JUMP_TO_SHOP", "LIVE_JUMP_TO_STORE", "MAX_SCORE", "", "SHOP_NO_PRODUCT_TIPS", "SHOP_USER_IDENTITY", "TYPE_SHOP_STRONG", "TYPE_SHOP_WEAK", "TYPE_SHOP_WINDOW", "TYPE_SHOP_WINDOW_V2", "WINDOW_USER_IDENTITY", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public EcomInfo() {
        this.recommendTextEllipsisIndex = -1;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final BreathInfo getBreathInfo() {
        return this.breathInfo;
    }

    public final String getBtnBackgroundColor() {
        return this.btnBackgroundColor;
    }

    public final String getBtnColor() {
        return this.btnColor;
    }

    public final String getEnterColor() {
        return this.enterColor;
    }

    public final String getEnterText() {
        return this.enterText;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getGrade() {
        return this.grade;
    }

    public final Map<String, String> getLiveBcmParams() {
        return this.liveBcmParams;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final List<RecommendText> getRecommendInfoV2() {
        return this.recommendInfoV2;
    }

    public final int getRecommendTextEllipsisIndex() {
        return this.recommendTextEllipsisIndex;
    }

    public final String getScalesText() {
        return this.scalesText;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Float getScore() {
        return this.score;
    }

    public final List<ScoreTags> getScoreTags() {
        return this.scoreTags;
    }

    public final String getScoreText() {
        return this.scoreText;
    }

    public final Map<String, String> getShopAreaBcmParams() {
        return this.shopAreaBcmParams;
    }

    public final ScoreTags getShopGuaranteeTags() {
        return this.shopGuaranteeTags;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final UrlModel getShopLogo() {
        return this.shopLogo;
    }

    public final List<UserServiceInfo> getShopServiceInfoList() {
        return this.shopServiceInfoList;
    }

    public final List<UrlModel> getShopTags() {
        return this.shopTags;
    }

    public final String getShopText() {
        return this.shopText;
    }

    public final int getShopType() {
        return this.shopType;
    }

    public final int getUserIdentity() {
        return this.userIdentity;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setBtnBackgroundColor(String r100) {
        this.btnBackgroundColor = r100;
    }

    public final void setBtnColor(String r100) {
        this.btnColor = r100;
    }

    public final void setEnterColor(String r100) {
        this.enterColor = r100;
    }

    public final void setEnterText(String r100) {
        this.enterText = r100;
    }

    public final void setExtra(Map<String, ? extends Object> r100) {
        this.extra = r100;
    }

    public final void setGrade(String r100) {
        this.grade = r100;
    }

    public final void setLiveBcmParams(Map<String, String> r100) {
        this.liveBcmParams = r100;
    }

    public final void setRecommendInfo(String r100) {
        this.recommendInfo = r100;
    }

    public final void setRecommendInfoV2(List<RecommendText> r100) {
        this.recommendInfoV2 = r100;
    }

    public final void setRecommendTextEllipsisIndex(int r100) {
        this.recommendTextEllipsisIndex = r100;
    }

    public final void setScalesText(String r100) {
        this.scalesText = r100;
    }

    public final void setSchema(String r100) {
        this.schema = r100;
    }

    public final void setScore(Float r100) {
        this.score = r100;
    }

    public final void setScoreTags(List<ScoreTags> r100) {
        this.scoreTags = r100;
    }

    public final void setScoreText(String r100) {
        this.scoreText = r100;
    }

    public final void setShopAreaBcmParams(Map<String, String> r100) {
        this.shopAreaBcmParams = r100;
    }

    public final void setShopGuaranteeTags(ScoreTags r100) {
        this.shopGuaranteeTags = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShopLogo(UrlModel r100) {
        this.shopLogo = r100;
    }

    public final void setShopServiceInfoList(List<UserServiceInfo> r100) {
        this.shopServiceInfoList = r100;
    }

    public final void setShopTags(List<? extends UrlModel> r100) {
        this.shopTags = r100;
    }

    public final void setShopText(String r100) {
        this.shopText = r100;
    }

    public final void setShopType(int r100) {
        this.shopType = r100;
    }

    public final void setUserIdentity(int r100) {
        this.userIdentity = r100;
    }
}
