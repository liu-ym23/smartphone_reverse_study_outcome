package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.live.ECPromotionListTopData;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import xi2.m0;
import xi2.w;
import xi2.x;
import xi2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ECPromotionList extends com.bytedance.android.ec.model.g {

    @SerializedName("show_cart_num")
    public int addCartOpt;

    @SerializedName("anchor_tags")
    public Map<String, List<ECRitTag>> anchorTags;

    @SerializedName("apply_resp")
    public JsonObject applyResp;

    @SerializedName("ask_explain_auth")
    public boolean askExplainAuth;

    @SerializedName("ask_explain_pop_info")
    public x askExplainPopInfo;

    @SerializedName("author_bubble_info")
    public b authorBubbleInfo;

    @SerializedName("author_order_limit")
    public c authorOrderLimit;

    @SerializedName("author_reputation")
    public d authorReputation;

    @SerializedName("author_room_data_strategy")
    public int authorRoomDataStrategy;

    @SerializedName("author_shop_info")
    public f authorShopInfo;

    @SerializedName("bottom_info")
    public xi2.j bottomInfo;

    @SerializedName("bottom_recommend_title")
    public String bottomRecommendTitle;

    @SerializedName("bottom_title")
    public String bottomTitle;

    @SerializedName("categories")
    public List<PromotionCategory> categories;

    @SerializedName("current_promotion_id")
    public String currentPromotionId;

    @SerializedName("entries")
    public List<ECPromotionEntry> entries;

    @SerializedName("entries_style")
    public int entriesStyle;

    @SerializedName("expire_time")
    public long expireTime;

    @SerializedName("extra")
    public m extra;

    @SerializedName("extra_param")
    public String extraParam;

    @SerializedName("flash_total")
    public int flashTotal;

    @SerializedName("goods_card_strategy")
    public int goodsCardStrategy;

    @SerializedName("commentary_video_auth")
    public boolean hasCommentaryVideoAuth;

    @SerializedName("hourly_purchase_shop_id")
    public String hourlyPurchaseShopId;

    @SerializedName("ignore_categories")
    public List<String> ignoreCategoryIds;

    @SerializedName("im")
    public n imStruct;

    @SerializedName("list_banner")
    public o listBanner;

    @SerializedName("list_top_data")
    public ECPromotionListTopData listTopData;

    @SerializedName("lite_list_style")
    public int liteListStyle;

    @SerializedName("live_store")
    public z liveStore;

    @SerializedName("minimum_guarantee_address")
    public int minimum_guarantee_address;

    @SerializedName("promotion_background")
    public r promotionBackground;

    @SerializedName("promotions")
    public List<ECPromotion> promotionList;

    @SerializedName("replay_flow")
    public t replayFlowInfo;

    @SerializedName("room_cart")
    public u roomCart;

    @SerializedName("room_type")
    public int roomType;

    @SerializedName("search_button_style")
    public int searchButtonStyle;

    @SerializedName("search_schema")
    public String searchSchema;

    @SerializedName("sec_kill_style")
    public int secKillStyle;

    @SerializedName("sell_point_style")
    public int sellPointStyle;

    @SerializedName("server_time")
    public long serverTime;

    @SerializedName("show_cart")
    public int showCart;

    @SerializedName("show_category_product_count")
    public int showCategoryProductCount;

    @SerializedName("skin")
    public q skinConfig;

    @SerializedName("author_shop_window_info")
    public v storeEntranceInfo;

    @SerializedName(LBSLightLocationTraceLogger.TOTAL)
    public int total;
    public transient List<ECUIPromotion> uiPromotionList;

    @SerializedName("use_benefit_label")
    public boolean useBenefitLabel;

    public static class a {

        @SerializedName("browsing_title")
        public String avatarTitle;

        @SerializedName("border_color")
        public String borderColor;

        @SerializedName("browsing_icon")
        public ECUrlModel browsingIcon;

        @SerializedName("height")
        public long height;

        @SerializedName("url_list")
        public List<String> urlList;

        @SerializedName("width")
        public long width;

        public a() {
        }
    }

    public static class b {

        @SerializedName("bubbles")
        public List<h> bubbles;

        @SerializedName("multi_bubble_text")
        public String multiBubbleText;

        public b() {
        }
    }

    public static class c {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("content")
        public List<j> content;

        @SerializedName("icon")
        public ECUrlModel icon;

        public c() {
        }
    }

    public static class d {

        @SerializedName("level")
        public int level;

        @SerializedName("score")
        public double score;

        @SerializedName("score_content")
        public e scoreContent;

        @SerializedName("shop_tag")
        public ECRitTag shopTag;

        @SerializedName("text")
        public String text;

        @SerializedName(LocationMonitorConst.TYPE)
        public int type;

        public d() {
        }
    }

    public static class e {

        @SerializedName(TraceCons.METRIC_BACKGROUND)
        public ECUrlModel background;

        @SerializedName("font_size")
        public long fontSize;

        @SerializedName("bold")
        public boolean isBold;

        @SerializedName("left_width")
        public long leftWidth;

        @SerializedName("text")
        public String text;

        @SerializedName("text_color")
        public String textColor;

        public e() {
        }
    }

    public static class f {

        @SerializedName("reputation")
        public d authorReputationInside;

        @SerializedName("avatars")
        public a avatar;

        @SerializedName("change_store_icon")
        public i changeStoreIcon;

        @SerializedName("eta")
        public k etaInfo;

        @SerializedName("event_param")
        public Map<String, String> eventParams;

        @SerializedName("font_size")
        public long fontSize;

        @SerializedName("jump_url")
        public String jumpUrl;

        @SerializedName("live_params_type")
        public List<Integer> liveParamsType;

        @SerializedName("name")
        public String name;

        @SerializedName("tags")
        public List<ECRitTag> tags;

        public f() {
        }
    }

    public static class g {

        @SerializedName("color")
        public String color;

        @SerializedName("track")
        public m0 extra;

        @SerializedName("font_size")
        public long fontSize;

        @SerializedName("format")
        public String format;

        @SerializedName("height")
        public int height;

        @SerializedName("image")
        public String image;

        @SerializedName("link_url")
        public String linkUrl;

        @SerializedName("width")
        public int width;

        public g() {
            this.height = 0;
            this.width = 0;
            this.fontSize = 13;
            this.linkUrl = "";
            this.extra = null;
        }
    }

    public static class h {

        @SerializedName("key")
        public String key;

        @SerializedName("max_show_time")
        public int maxShowTimes;

        @SerializedName("priority")
        public int priority;

        @SerializedName("text")
        public String text;

        public h() {
        }
    }

    public static class i {

        @SerializedName("event_params")
        public Map<String, String> eventParams;

        @SerializedName("icon")
        public ECUrlModel icon;

        @SerializedName("schema")
        public String schema;

        @SerializedName("track_name")
        public String trackName;

        public i() {
        }
    }

    public static class j {

        @SerializedName("color")
        public String color;

        @SerializedName("font_size")
        public int fontSize;

        @SerializedName("text")
        public String text;

        @SerializedName("url")
        public String url;

        public j() {
        }
    }

    public static class k {

        @SerializedName("labels")
        public List<l> labels;

        @SerializedName("ui_config")
        public ECUIConfig uiConfig;

        public k() {
        }
    }

    public static class l {

        @SerializedName("label_type")
        public int labelType;

        @SerializedName("text")
        public String text;

        public l() {
        }
    }

    public static class m {

        @SerializedName("has_shield")
        public String hasShield;

        @SerializedName("logid")
        public String logid;

        @SerializedName("set_coupon_notice")
        public String setCouponNotice;

        @SerializedName("shield_notice")
        public String shieldNotice;

        @SerializedName("shield_skip_notice")
        public String shieldSkipNotice;

        public m() {
        }
    }

    public static class n {

        @SerializedName("unread_msg")
        public boolean unread;

        @SerializedName("url")
        public String url;

        public n() {
        }
    }

    public static class o extends com.bytedance.android.ec.model.g {

        @SerializedName("list_banner_info")
        public p listBannerInfo;

        @SerializedName("list_banner_refresh_timing")
        public List<String> listBannerRefreshTiming;

        public o() {
        }
    }

    public static class p {
        public boolean a;

        @SerializedName("banner_type")
        public int bannerType;

        @SerializedName("bg_image_url")
        public String bgImageUrl;

        @SerializedName("jump_url")
        public String jumpUrl;

        @SerializedName("left_content")
        public List<com.bytedance.android.ec.model.live.b> leftContent;

        @SerializedName("priority")
        public int priority;

        @SerializedName("right_content")
        public List<com.bytedance.android.ec.model.live.b> rightContent;

        @SerializedName("track_info")
        public m0 trackInfo;

        public p() {
            this.a = false;
        }
    }

    public static class q {

        @SerializedName(LocationMonitorConst.TYPE)
        public String type;

        public q() {
        }
    }

    public static class r {

        @SerializedName("horizontal")
        public s horizontal;

        @SerializedName(LocationMonitorConst.TYPE)
        public int type;

        @SerializedName("vertical")
        public s vertical;

        public r() {
            this.type = 1;
        }
    }

    public static class s {

        @SerializedName("background_components")
        public xi2.e backgroundComponent;

        @SerializedName("background_left")
        public g backgroundLeft;

        @SerializedName("height")
        public long height;

        @SerializedName("image")
        public String image;

        @SerializedName("background_left_v2")
        public xi2.e leftBackgroundComponent;

        @SerializedName("market_component")
        public w marketComponent;

        @SerializedName("width")
        public long width;

        public s() {
        }
    }

    public static class t {

        @SerializedName("button")
        public String buttonText;

        @SerializedName("text")
        public List<String> contents;

        @SerializedName("is_user_shop")
        public int isUserShop;

        @SerializedName("pic")
        public ECUrlModel pic;

        @SerializedName("title")
        public String title;

        public t() {
        }
    }

    public static class u {
        public static final u a = null;

        @SerializedName("horizontal")
        public de.b horizontal;

        @SerializedName("global_custom_icons")
        public de.a roomCartIcons;

        @SerializedName("show_cart")
        public boolean showCart;

        @SerializedName("vertical")
        public de.b vertical;

        static {
            a = new u();
        }

        public u() {
            this.showCart = false;
        }
    }

    public static class v {

        @SerializedName("avatars")
        public a avatar;

        @SerializedName("event_param")
        public Map<String, String> eventParams;

        @SerializedName("font_size")
        public long fontSize;

        @SerializedName("jump_url")
        public String jumpUrl;

        @SerializedName("suffix_text")
        public String suffixText;

        @SerializedName("text")
        public String text;

        public v() {
        }
    }

    public ECPromotionList() {
        this.goodsCardStrategy = 0;
        this.serverTime = 0;
        this.useBenefitLabel = false;
        this.sellPointStyle = 0;
        this.showCategoryProductCount = 4;
        this.expireTime = -1;
    }
}
