package com.bytedance.android.shopping.api.mall.homepage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010R\u001a\u0004\u0018\u00010/2\u0006\u0010S\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001e\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R,\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u001e\u00107\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001e\u0010:\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010'\"\u0004\b<\u0010)R\u001e\u0010=\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR\u001e\u0010@\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001e\u0010C\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001e\u0010F\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R\u001e\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001e\u0010L\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010'\"\u0004\bN\u0010)R\u001e\u0010O\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\b¨\u0006U"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig;", "Ljava/io/Serializable;", "()V", "cardCount", "", "getCardCount", "()I", "setCardCount", "(I)V", "cardCountLarge", "getCardCountLarge", "setCardCountLarge", "cardCoverPlaceholder", "", "getCardCoverPlaceholder", "()Ljava/lang/String;", "setCardCoverPlaceholder", "(Ljava/lang/String;)V", "cardCoverPlaceholderRatio", "", "getCardCoverPlaceholderRatio", "()F", "setCardCoverPlaceholderRatio", "(F)V", "cardRadius", "", "getCardRadius", "()D", "setCardRadius", "(D)V", "cardTitlePlaceholder", "getCardTitlePlaceholder", "setCardTitlePlaceholder", "cardTitlePlaceholderRatio", "getCardTitlePlaceholderRatio", "setCardTitlePlaceholderRatio", "forbidExitAnimation", "", "getForbidExitAnimation", "()Z", "setForbidExitAnimation", "(Z)V", "forceLayoutEnable", "getForceLayoutEnable", "setForceLayoutEnable", "headerPlaceholderMap", "", "Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig$Placeholder;", "getHeaderPlaceholderMap", "()Ljava/util/Map;", "setHeaderPlaceholderMap", "(Ljava/util/Map;)V", "itemGap", "getItemGap", "setItemGap", "itemGapLarge", "getItemGapLarge", "setItemGapLarge", "jumpAfterImageLoaded", "getJumpAfterImageLoaded", "setJumpAfterImageLoaded", "marginHorizontal", "getMarginHorizontal", "setMarginHorizontal", "marginHorizontalLarge", "getMarginHorizontalLarge", "setMarginHorizontalLarge", "maxDelayJumpDuration", "getMaxDelayJumpDuration", "setMaxDelayJumpDuration", "modifyExposureEventParamsEnable", "getModifyExposureEventParamsEnable", "setModifyExposureEventParamsEnable", "renderFirstScreenWaitingTimeout", "getRenderFirstScreenWaitingTimeout", "setRenderFirstScreenWaitingTimeout", "reportFirstCardOnly", "getReportFirstCardOnly", "setReportFirstCardOnly", "targetDuration", "getTargetDuration", "setTargetDuration", "findHeaderPlaceholder", "headerPlaceholderType", "Placeholder", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallDeliveryReduceConfig implements Serializable {

    @SerializedName("card_count")
    private int cardCount;

    @SerializedName("card_count_large")
    private int cardCountLarge;

    @SerializedName("card_cover_placeholder")
    private String cardCoverPlaceholder;

    @SerializedName("card_cover_placeholder_ratio")
    private float cardCoverPlaceholderRatio;

    @SerializedName("card_radius")
    private double cardRadius;

    @SerializedName("card_title_placeholder")
    private String cardTitlePlaceholder;

    @SerializedName("card_title_placeholder_ratio")
    private float cardTitlePlaceholderRatio;

    @SerializedName("forbid_exit_animation")
    private boolean forbidExitAnimation;

    @SerializedName("force_layout_enable")
    private boolean forceLayoutEnable;

    @SerializedName("header_placeholder_map")
    private Map<String, Placeholder> headerPlaceholderMap;

    @SerializedName("item_gap")
    private double itemGap;

    @SerializedName("item_gap_large")
    private double itemGapLarge;

    @SerializedName("jump_after_image_loaded")
    private boolean jumpAfterImageLoaded;

    @SerializedName("margin_horizontal")
    private double marginHorizontal;

    @SerializedName("margin_horizontal_large")
    private double marginHorizontalLarge;

    @SerializedName("max_delay_jump_duration")
    private int maxDelayJumpDuration;

    @SerializedName("modify_exposure_event_params_enable")
    private boolean modifyExposureEventParamsEnable;

    @SerializedName("render_first_screen_waiting_timeout")
    private int renderFirstScreenWaitingTimeout;

    @SerializedName("report_first_card_only")
    private boolean reportFirstCardOnly;

    @SerializedName("target_duration")
    private int targetDuration;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0015J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig$Placeholder;", "Ljava/io/Serializable;", "url", "", "ratio", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Float;)Lcom/bytedance/android/shopping/api/mall/homepage/ECMallDeliveryReduceConfig$Placeholder;", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Placeholder implements Serializable {

        @SerializedName("ratio")
        private Float ratio;

        @SerializedName("url")
        private String url;

        /* JADX WARN: Multi-variable type inference failed */
        public Placeholder() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Placeholder copy$default(Placeholder r0, String r1, Float r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.url;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.ratio;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.url;
        }

        public final Float component2() {
            return this.ratio;
        }

        public final Placeholder copy(String r2, Float r3) {
            return new Placeholder(r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Placeholder) == false) goto L10;
            Placeholder r4 = (Placeholder) r3;
            if (Intrinsics.areEqual(this.url, r4.url) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.ratio, r4.ratio) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.url;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Float r4 = this.ratio;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Placeholder(url=" + this.url + ", ratio=" + this.ratio + ")";
        }

        public final boolean isValid() {
            String r0 = this.url;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L18;
            Float r2 = this.ratio;
            if (r2 == null) goto L18;
            if (r2 == null) goto L14;
            float r3 = r2.floatValue();
        L16:
            if (r3 <= 0) goto L18;
            return true;
        L14:
            r3 = -1.0f;
        L18:
            return false;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }

        public final Float getRatio() {
            return this.ratio;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setRatio(Float r1) {
            this.ratio = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }

        public Placeholder(String r1, Float r2) {
            this.url = r1;
            this.ratio = r2;
        }

        public /* synthetic */ Placeholder(String r2, Float r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    public ECMallDeliveryReduceConfig() {
        this.cardCoverPlaceholderRatio = 1.0f;
        this.cardTitlePlaceholderRatio = 2.368f;
        this.marginHorizontal = 5.0d;
        this.marginHorizontalLarge = 12.0d;
        this.itemGap = 5.0d;
        this.itemGapLarge = 8.0d;
        this.cardRadius = 8.0d;
        this.cardCount = 4;
        this.cardCountLarge = 9;
        this.jumpAfterImageLoaded = true;
        this.renderFirstScreenWaitingTimeout = 3000;
        this.targetDuration = -1;
        this.maxDelayJumpDuration = 100;
        this.forceLayoutEnable = true;
        this.reportFirstCardOnly = true;
        this.modifyExposureEventParamsEnable = true;
        this.forbidExitAnimation = true;
    }

    public final int getCardCount() {
        return this.cardCount;
    }

    public final int getCardCountLarge() {
        return this.cardCountLarge;
    }

    public final String getCardCoverPlaceholder() {
        return this.cardCoverPlaceholder;
    }

    public final float getCardCoverPlaceholderRatio() {
        return this.cardCoverPlaceholderRatio;
    }

    public final double getCardRadius() {
        return this.cardRadius;
    }

    public final String getCardTitlePlaceholder() {
        return this.cardTitlePlaceholder;
    }

    public final float getCardTitlePlaceholderRatio() {
        return this.cardTitlePlaceholderRatio;
    }

    public final boolean getForbidExitAnimation() {
        return this.forbidExitAnimation;
    }

    public final boolean getForceLayoutEnable() {
        return this.forceLayoutEnable;
    }

    public final Map<String, Placeholder> getHeaderPlaceholderMap() {
        return this.headerPlaceholderMap;
    }

    public final double getItemGap() {
        return this.itemGap;
    }

    public final double getItemGapLarge() {
        return this.itemGapLarge;
    }

    public final boolean getJumpAfterImageLoaded() {
        return this.jumpAfterImageLoaded;
    }

    public final double getMarginHorizontal() {
        return this.marginHorizontal;
    }

    public final double getMarginHorizontalLarge() {
        return this.marginHorizontalLarge;
    }

    public final int getMaxDelayJumpDuration() {
        return this.maxDelayJumpDuration;
    }

    public final boolean getModifyExposureEventParamsEnable() {
        return this.modifyExposureEventParamsEnable;
    }

    public final int getRenderFirstScreenWaitingTimeout() {
        return this.renderFirstScreenWaitingTimeout;
    }

    public final boolean getReportFirstCardOnly() {
        return this.reportFirstCardOnly;
    }

    public final int getTargetDuration() {
        return this.targetDuration;
    }

    public final Placeholder findHeaderPlaceholder(String r3) {
        Intrinsics.checkNotNullParameter(r3, "headerPlaceholderType");
        Map<String, Placeholder> r0 = this.headerPlaceholderMap;
        if (r0 == null) goto L10;
        Placeholder r4 = r0.get(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        if (r4.isValid() == true) goto L9;
        return null;
    L9:
        return r4;
    L10:
        return null;
    }

    public final void setCardCount(int r1) {
        this.cardCount = r1;
    }

    public final void setCardCountLarge(int r1) {
        this.cardCountLarge = r1;
    }

    public final void setCardCoverPlaceholder(String r1) {
        this.cardCoverPlaceholder = r1;
    }

    public final void setCardCoverPlaceholderRatio(float r1) {
        this.cardCoverPlaceholderRatio = r1;
    }

    public final void setCardRadius(double r1) {
        this.cardRadius = r1;
    }

    public final void setCardTitlePlaceholder(String r1) {
        this.cardTitlePlaceholder = r1;
    }

    public final void setCardTitlePlaceholderRatio(float r1) {
        this.cardTitlePlaceholderRatio = r1;
    }

    public final void setForbidExitAnimation(boolean r1) {
        this.forbidExitAnimation = r1;
    }

    public final void setForceLayoutEnable(boolean r1) {
        this.forceLayoutEnable = r1;
    }

    public final void setHeaderPlaceholderMap(Map<String, Placeholder> r1) {
        this.headerPlaceholderMap = r1;
    }

    public final void setItemGap(double r1) {
        this.itemGap = r1;
    }

    public final void setItemGapLarge(double r1) {
        this.itemGapLarge = r1;
    }

    public final void setJumpAfterImageLoaded(boolean r1) {
        this.jumpAfterImageLoaded = r1;
    }

    public final void setMarginHorizontal(double r1) {
        this.marginHorizontal = r1;
    }

    public final void setMarginHorizontalLarge(double r1) {
        this.marginHorizontalLarge = r1;
    }

    public final void setMaxDelayJumpDuration(int r1) {
        this.maxDelayJumpDuration = r1;
    }

    public final void setModifyExposureEventParamsEnable(boolean r1) {
        this.modifyExposureEventParamsEnable = r1;
    }

    public final void setRenderFirstScreenWaitingTimeout(int r1) {
        this.renderFirstScreenWaitingTimeout = r1;
    }

    public final void setReportFirstCardOnly(boolean r1) {
        this.reportFirstCardOnly = r1;
    }

    public final void setTargetDuration(int r1) {
        this.targetDuration = r1;
    }
}
