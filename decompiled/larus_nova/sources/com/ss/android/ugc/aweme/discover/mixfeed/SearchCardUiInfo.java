package com.ss.android.ugc.aweme.discover.mixfeed;

import com.google.gson.annotations.SerializedName;
import com.larus.media.MediaScene;
import java.io.Serializable;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bH\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 l2\u00020\u0001:\u0002lmB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00100\u001a\u00020\"J\b\u0010j\u001a\u00020kH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016R\"\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b4\u0010\u0014\"\u0004\b5\u0010\u0016R\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016R\"\u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b=\u0010\u0014\"\u0004\b>\u0010\u0016R\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\u001e\u0010D\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001e\u0010F\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010$\"\u0004\bG\u0010&R\u001e\u0010H\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010$\"\u0004\bI\u0010&R\u001e\u0010J\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001e\u0010L\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\"\u0010O\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\bP\u0010\u0014\"\u0004\bQ\u0010\u0016R\"\u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\bS\u0010\u0014\"\u0004\bT\u0010\u0016R\"\u0010U\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\bV\u0010\u0014\"\u0004\bW\u0010\u0016R\"\u0010X\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\bY\u0010\u0014\"\u0004\bZ\u0010\u0016R\"\u0010[\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\\\u0010\u0014\"\u0004\b]\u0010\u0016R\u001e\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR \u0010a\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u000f\"\u0004\bc\u0010\u0011R\u001e\u0010d\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010$\"\u0004\bf\u0010&R\u001e\u0010g\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0006\"\u0004\bi\u0010\b¨\u0006n"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo;", "Ljava/io/Serializable;", "()V", "activityCardBottom", "", "getActivityCardBottom", "()I", "setActivityCardBottom", "(I)V", "alignStyleLayout", "getAlignStyleLayout", "setAlignStyleLayout", "bottomDividerConfig", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerConfig;", "getBottomDividerConfig", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerConfig;", "setBottomDividerConfig", "(Lcom/ss/android/ugc/aweme/discover/mixfeed/DividerConfig;)V", "cardCornerType", "getCardCornerType", "()Ljava/lang/Integer;", "setCardCornerType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "containGS", "getContainGS", "setContainGS", "containerAnimConfig", "Lcom/ss/android/ugc/aweme/discover/mixfeed/ContainerAnimConfig;", "getContainerAnimConfig", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/ContainerAnimConfig;", "setContainerAnimConfig", "(Lcom/ss/android/ugc/aweme/discover/mixfeed/ContainerAnimConfig;)V", "cornerForceByClip", "", "getCornerForceByClip", "()Z", "setCornerForceByClip", "(Z)V", "darkThemeStyle", "getDarkThemeStyle", "setDarkThemeStyle", "dividerTransparentNeedClear", "getDividerTransparentNeedClear", "setDividerTransparentNeedClear", "enableCardStrongStyle", "getEnableCardStrongStyle", "setEnableCardStrongStyle", "enableHideDividerInFusionCard", "getEnableHideDividerInFusionCard", "setEnableHideDividerInFusionCard", "enableQualityStyle", "getEnableQualityStyle", "setEnableQualityStyle", "fullScreenWidth", "getFullScreenWidth", "setFullScreenWidth", "hideDivider", "getHideDivider", "setHideDivider", "hideTitle", "getHideTitle", "setHideTitle", "inFloatingBgColor", "getInFloatingBgColor", "setInFloatingBgColor", "isInBackGround", "setInBackGround", "isInRectangleBackground", "setInRectangleBackground", "isSingleRange", "setSingleRange", "isStreamCard", "setStreamCard", "isWaterfallLayout", "setWaterfallLayout", "lightThemeStyle", "getLightThemeStyle", "setLightThemeStyle", "marginBottom", "getMarginBottom", "setMarginBottom", "marginEnd", "getMarginEnd", "setMarginEnd", "marginStart", "getMarginStart", "setMarginStart", "marginTop", "getMarginTop", "setMarginTop", "qualityStyleCornerType", "getQualityStyleCornerType", "setQualityStyleCornerType", "suggestWordsConfig", "getSuggestWordsConfig", "setSuggestWordsConfig", "topDividerConfig", "getTopDividerConfig", "setTopDividerConfig", "useCardBackground", "getUseCardBackground", "setUseCardBackground", "useCardOriginConfig", "getUseCardOriginConfig", "setUseCardOriginConfig", "toString", "", "Companion", "CornerType", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchCardUiInfo implements Serializable {
    public static final int AMBIENT = 1;
    public static final Companion Companion = null;
    public static final int DARK = 1;
    public static final int FULL_SCREEN_WIDTH = 1;
    public static final int FULL_SPAN = 0;
    public static final int HEAD_CORNER_TYPE_BOTTOM = 2;
    public static final int HEAD_CORNER_TYPE_FULL = 3;
    public static final int HEAD_CORNER_TYPE_NO = 0;
    public static final int HEAD_CORNER_TYPE_TOP = 1;
    public static final int HEAD_IN_BG = 1;
    public static final int HEAD_IN_RECTANGLE = 1;
    public static final int HEAD_NOT_INT_BG = 0;
    public static final int HEAD_NOT_IN_RECTANGLE = 0;
    public static final int LAST_AMBIENT = 2;
    public static final int LEFT = 1;
    public static final int LIGHT = 2;
    public static final int NORMAL_LAYOUT = 0;
    public static final int NORMAL_WIDTH = 0;
    public static final int NOT_IN = 0;
    public static final int RIGHT = 2;
    public static final int SYSTEM = 0;
    public static final int WATER_FALL_LAYOUT = 1;

    @SerializedName("activity_card_bottom")
    private int activityCardBottom;
    private int alignStyleLayout;

    @SerializedName("bottom_divider_config")
    private DividerConfig bottomDividerConfig;

    @SerializedName("card_corner_type")
    private Integer cardCornerType;

    @SerializedName("contain_gs")
    private Integer containGS;

    @SerializedName("container_animation_config")
    private ContainerAnimConfig containerAnimConfig;

    @SerializedName("corner_force_by_clip")
    private boolean cornerForceByClip;

    @SerializedName("dark_theme_style")
    private int darkThemeStyle;

    @SerializedName("divider_transparent_need_clear")
    private int dividerTransparentNeedClear;

    @SerializedName("enable_card_strong_style")
    private int enableCardStrongStyle;

    @SerializedName("enable_hide_divider_in_fusion_card")
    private Integer enableHideDividerInFusionCard;

    @SerializedName("enable_quality_style")
    private Integer enableQualityStyle;

    @SerializedName("full_screen_width")
    private int fullScreenWidth;

    @SerializedName("hide_divider")
    private Integer hideDivider;

    @SerializedName("hide_title")
    private Integer hideTitle;

    @SerializedName("in_floating_bg_color")
    private int inFloatingBgColor;

    @SerializedName("is_in_background")
    private int isInBackGround;

    @SerializedName("is_in_rectangle_background")
    private int isInRectangleBackground;

    @SerializedName("is_single_range")
    private boolean isSingleRange;

    @SerializedName("is_stream_card")
    private boolean isStreamCard;

    @SerializedName("is_waterfall_layout")
    private int isWaterfallLayout;

    @SerializedName("light_theme_style")
    private int lightThemeStyle;

    @SerializedName("margin_bottom")
    private Integer marginBottom;

    @SerializedName("margin_end")
    private Integer marginEnd;

    @SerializedName("margin_start")
    private Integer marginStart;

    @SerializedName("margin_top")
    private Integer marginTop;

    @SerializedName("quality_style_corner_type")
    private Integer qualityStyleCornerType;

    @SerializedName("suggest_words_config")
    private int suggestWordsConfig;

    @SerializedName("top_divider_config")
    private DividerConfig topDividerConfig;

    @SerializedName("use_card_background")
    private boolean useCardBackground;

    @SerializedName("use_card_origin_config")
    private int useCardOriginConfig;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo$Companion;", "", "", "AMBIENT", "I", "DARK", "FULL_SCREEN_WIDTH", "FULL_SPAN", "HEAD_CORNER_TYPE_BOTTOM", "HEAD_CORNER_TYPE_FULL", "HEAD_CORNER_TYPE_NO", "HEAD_CORNER_TYPE_TOP", "HEAD_IN_BG", "HEAD_IN_RECTANGLE", "HEAD_NOT_INT_BG", "HEAD_NOT_IN_RECTANGLE", "LAST_AMBIENT", "LEFT", "LIGHT", "NORMAL_LAYOUT", "NORMAL_WIDTH", "NOT_IN", "RIGHT", MediaScene.SYSTEM, "WATER_FALL_LAYOUT", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchCardUiInfo$CornerType;", "", "", "value", "I", "getValue", "()I", "NoneCorner", "TopCorner", "BottomCorner", "TopAndBottomCorner", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CornerType extends Enum<CornerType> {
        public static final CornerType BottomCorner = null;
        public static final CornerType NoneCorner = null;
        public static final CornerType TopAndBottomCorner = null;
        public static final CornerType TopCorner = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CornerType[] f450480a = null;
        private final int value;

        public static CornerType valueOf(String r100) {
            return (CornerType) a.a(CornerType.class, r100);
        }

        public static CornerType[] values() {
            return (CornerType[]) f450480a.clone();
        }

        static {
            CornerType r100 = new CornerType("NoneCorner", 0, 0);
            NoneCorner = r100;
            CornerType r101 = new CornerType("TopCorner", 1, 1);
            TopCorner = r101;
            CornerType r102 = new CornerType("BottomCorner", 2, 2);
            BottomCorner = r102;
            CornerType r103 = new CornerType("TopAndBottomCorner", 3, 3);
            TopAndBottomCorner = r103;
            f450480a = new CornerType[]{r100, r101, r102, r103};
        }

        public final int getValue() {
            return this.value;
        }

        public CornerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final boolean enableHideDividerInFusionCard() {
        Integer r100 = this.enableHideDividerInFusionCard;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public String toString() {
        return "hideDivider = " + this.hideDivider + ", hideTitle = " + this.hideTitle + ", isInBackground = " + this.isInBackGround + ", activityCardBottom = " + this.activityCardBottom;
    }

    public SearchCardUiInfo() {
        this.hideDivider = 0;
        this.hideTitle = 0;
        this.enableHideDividerInFusionCard = 1;
    }

    public final int getActivityCardBottom() {
        return this.activityCardBottom;
    }

    public final int getAlignStyleLayout() {
        return this.alignStyleLayout;
    }

    public final DividerConfig getBottomDividerConfig() {
        return this.bottomDividerConfig;
    }

    public final Integer getCardCornerType() {
        return this.cardCornerType;
    }

    public final Integer getContainGS() {
        return this.containGS;
    }

    public final ContainerAnimConfig getContainerAnimConfig() {
        return this.containerAnimConfig;
    }

    public final boolean getCornerForceByClip() {
        return this.cornerForceByClip;
    }

    public final int getDarkThemeStyle() {
        return this.darkThemeStyle;
    }

    public final int getDividerTransparentNeedClear() {
        return this.dividerTransparentNeedClear;
    }

    public final int getEnableCardStrongStyle() {
        return this.enableCardStrongStyle;
    }

    public final Integer getEnableHideDividerInFusionCard() {
        return this.enableHideDividerInFusionCard;
    }

    public final Integer getEnableQualityStyle() {
        return this.enableQualityStyle;
    }

    public final int getFullScreenWidth() {
        return this.fullScreenWidth;
    }

    public final Integer getHideDivider() {
        return this.hideDivider;
    }

    public final Integer getHideTitle() {
        return this.hideTitle;
    }

    public final int getInFloatingBgColor() {
        return this.inFloatingBgColor;
    }

    public final int getLightThemeStyle() {
        return this.lightThemeStyle;
    }

    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    public final Integer getMarginEnd() {
        return this.marginEnd;
    }

    public final Integer getMarginStart() {
        return this.marginStart;
    }

    public final Integer getMarginTop() {
        return this.marginTop;
    }

    public final Integer getQualityStyleCornerType() {
        return this.qualityStyleCornerType;
    }

    public final int getSuggestWordsConfig() {
        return this.suggestWordsConfig;
    }

    public final DividerConfig getTopDividerConfig() {
        return this.topDividerConfig;
    }

    public final boolean getUseCardBackground() {
        return this.useCardBackground;
    }

    public final int getUseCardOriginConfig() {
        return this.useCardOriginConfig;
    }

    public final int isInBackGround() {
        return this.isInBackGround;
    }

    public final int isInRectangleBackground() {
        return this.isInRectangleBackground;
    }

    public final boolean isSingleRange() {
        return this.isSingleRange;
    }

    public final boolean isStreamCard() {
        return this.isStreamCard;
    }

    public final int isWaterfallLayout() {
        return this.isWaterfallLayout;
    }

    public final void setActivityCardBottom(int r100) {
        this.activityCardBottom = r100;
    }

    public final void setAlignStyleLayout(int r100) {
        this.alignStyleLayout = r100;
    }

    public final void setBottomDividerConfig(DividerConfig r100) {
        this.bottomDividerConfig = r100;
    }

    public final void setCardCornerType(Integer r100) {
        this.cardCornerType = r100;
    }

    public final void setContainGS(Integer r100) {
        this.containGS = r100;
    }

    public final void setContainerAnimConfig(ContainerAnimConfig r100) {
        this.containerAnimConfig = r100;
    }

    public final void setCornerForceByClip(boolean r100) {
        this.cornerForceByClip = r100;
    }

    public final void setDarkThemeStyle(int r100) {
        this.darkThemeStyle = r100;
    }

    public final void setDividerTransparentNeedClear(int r100) {
        this.dividerTransparentNeedClear = r100;
    }

    public final void setEnableCardStrongStyle(int r100) {
        this.enableCardStrongStyle = r100;
    }

    public final void setEnableHideDividerInFusionCard(Integer r100) {
        this.enableHideDividerInFusionCard = r100;
    }

    public final void setEnableQualityStyle(Integer r100) {
        this.enableQualityStyle = r100;
    }

    public final void setFullScreenWidth(int r100) {
        this.fullScreenWidth = r100;
    }

    public final void setHideDivider(Integer r100) {
        this.hideDivider = r100;
    }

    public final void setHideTitle(Integer r100) {
        this.hideTitle = r100;
    }

    public final void setInBackGround(int r100) {
        this.isInBackGround = r100;
    }

    public final void setInFloatingBgColor(int r100) {
        this.inFloatingBgColor = r100;
    }

    public final void setInRectangleBackground(int r100) {
        this.isInRectangleBackground = r100;
    }

    public final void setLightThemeStyle(int r100) {
        this.lightThemeStyle = r100;
    }

    public final void setMarginBottom(Integer r100) {
        this.marginBottom = r100;
    }

    public final void setMarginEnd(Integer r100) {
        this.marginEnd = r100;
    }

    public final void setMarginStart(Integer r100) {
        this.marginStart = r100;
    }

    public final void setMarginTop(Integer r100) {
        this.marginTop = r100;
    }

    public final void setQualityStyleCornerType(Integer r100) {
        this.qualityStyleCornerType = r100;
    }

    public final void setSingleRange(boolean r100) {
        this.isSingleRange = r100;
    }

    public final void setStreamCard(boolean r100) {
        this.isStreamCard = r100;
    }

    public final void setSuggestWordsConfig(int r100) {
        this.suggestWordsConfig = r100;
    }

    public final void setTopDividerConfig(DividerConfig r100) {
        this.topDividerConfig = r100;
    }

    public final void setUseCardBackground(boolean r100) {
        this.useCardBackground = r100;
    }

    public final void setUseCardOriginConfig(int r100) {
        this.useCardOriginConfig = r100;
    }

    public final void setWaterfallLayout(int r100) {
        this.isWaterfallLayout = r100;
    }
}
