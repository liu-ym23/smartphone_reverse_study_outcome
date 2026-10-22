package tc3;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b%\u0010\u000bR\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR\u001c\u0010(\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000bR\u001c\u0010*\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b+\u0010\u000bR\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b1\u0010\u000bR\u001c\u00102\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000bR\u001c\u00104\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000b¨\u00066"}, d2 = {"Ltc3/b;", "", "", "descAreaOptimize", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "", "bottomAreaOptimize", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "descChangeOrder", "f", "descAddAnimation", "d", "descIntervalOptimize", ce.f26391f, "searchOptimize", "p", "manualMuteKV", "l", "disableWysiwyg", "h", "foldOptimize", RXScreenCaptureService.KEY_INDEX, "fullScreen", "getFullScreen", "multiTabStyle", "m", "tabAutoSlide", "q", "couponFreq", "c", "optTitleView", OfficeSDKRequestTag.KEY_NEW_USER, "pitayaAutoSlide", "o", "enableVideoPauseTag", "getEnableVideoPauseTag", "enableScreenShotPopup", "getEnableScreenShotPopup", "enableFeedbackPopup", "getEnableFeedbackPopup", "aiRequestUseNewTriggers", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "marketingExpressionStrengthEnable", "getMarketingExpressionStrengthEnable", "changeRecReasonOrder", "getChangeRecReasonOrder", "gestureTrackEnable", ce.f26395j, "infoSwipeEnterDetailEnable", ce.f26396k, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends Object> f545398a;

    @SerializedName("ai_request_use_new_triggers")
    private final Boolean aiRequestUseNewTriggers;

    @SerializedName("bottom_area_optimize")
    private final Boolean bottomAreaOptimize;

    @SerializedName("change_rec_reason_order")
    private final Boolean changeRecReasonOrder;

    @SerializedName("coupon_freq")
    private final Integer couponFreq;

    @SerializedName("desc_add_animation")
    private final Boolean descAddAnimation;

    @SerializedName("desc_area_optimize")
    private final Integer descAreaOptimize;

    @SerializedName("desc_change_order")
    private final Boolean descChangeOrder;

    @SerializedName("desc_interval_optimize")
    private final Boolean descIntervalOptimize;

    @SerializedName("disable_wysiwyg")
    private final Boolean disableWysiwyg;

    @SerializedName("enable_feedback_popup")
    private final Boolean enableFeedbackPopup;

    @SerializedName("enable_screenshot_popup")
    private final Boolean enableScreenShotPopup;

    @SerializedName("enable_video_pause_tag")
    private final Boolean enableVideoPauseTag;

    @SerializedName("fold_optimize")
    private final Integer foldOptimize;

    @SerializedName("full_screen")
    private final Boolean fullScreen;

    @SerializedName("mall_deep_feed_gesture_track_enable")
    private final Boolean gestureTrackEnable;

    @SerializedName("mall_deep_feed_info_swipe_enter_detail_enable")
    private final Boolean infoSwipeEnterDetailEnable;

    @SerializedName("manual_mute_kv")
    private final Integer manualMuteKV;

    @SerializedName("marketing_expression_strength_enable")
    private final Boolean marketingExpressionStrengthEnable;

    @SerializedName("multi_tab_style")
    private final Integer multiTabStyle;

    @SerializedName("opt_title_view")
    private final Boolean optTitleView;

    @SerializedName("pitaya_auto_slide")
    private final Boolean pitayaAutoSlide;

    @SerializedName("search_optimize")
    private final Boolean searchOptimize;

    @SerializedName("tab_auto_slide")
    private final Boolean tabAutoSlide;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L52;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.descAreaOptimize, r101.descAreaOptimize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomAreaOptimize, r101.bottomAreaOptimize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.descChangeOrder, r101.descChangeOrder) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descAddAnimation, r101.descAddAnimation) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.descIntervalOptimize, r101.descIntervalOptimize) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.searchOptimize, r101.searchOptimize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.manualMuteKV, r101.manualMuteKV) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.disableWysiwyg, r101.disableWysiwyg) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.foldOptimize, r101.foldOptimize) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fullScreen, r101.fullScreen) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.multiTabStyle, r101.multiTabStyle) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.tabAutoSlide, r101.tabAutoSlide) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.couponFreq, r101.couponFreq) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.optTitleView, r101.optTitleView) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.pitayaAutoSlide, r101.pitayaAutoSlide) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableVideoPauseTag, r101.enableVideoPauseTag) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.enableScreenShotPopup, r101.enableScreenShotPopup) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.enableFeedbackPopup, r101.enableFeedbackPopup) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.aiRequestUseNewTriggers, r101.aiRequestUseNewTriggers) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.marketingExpressionStrengthEnable, r101.marketingExpressionStrengthEnable) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.changeRecReasonOrder, r101.changeRecReasonOrder) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.gestureTrackEnable, r101.gestureTrackEnable) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.infoSwipeEnterDetailEnable, r101.infoSwipeEnterDetailEnable) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.descAreaOptimize;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.bottomAreaOptimize;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.descChangeOrder;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.descAddAnimation;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.descIntervalOptimize;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.searchOptimize;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.manualMuteKV;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.disableWysiwyg;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.foldOptimize;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.fullScreen;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.multiTabStyle;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.tabAutoSlide;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.couponFreq;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Boolean r140 = this.optTitleView;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.pitayaAutoSlide;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Boolean r146 = this.enableVideoPauseTag;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.enableScreenShotPopup;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.enableFeedbackPopup;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.aiRequestUseNewTriggers;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Boolean r158 = this.marketingExpressionStrengthEnable;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Boolean r161 = this.changeRecReasonOrder;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Boolean r164 = this.gestureTrackEnable;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        Boolean r167 = this.infoSwipeEnterDetailEnable;
        if (r167 == null) goto L94;
        r101 = r167.hashCode();
    L94:
        return r166 + r101;
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedConfig(descAreaOptimize=" + this.descAreaOptimize + ", bottomAreaOptimize=" + this.bottomAreaOptimize + ", descChangeOrder=" + this.descChangeOrder + ", descAddAnimation=" + this.descAddAnimation + ", descIntervalOptimize=" + this.descIntervalOptimize + ", searchOptimize=" + this.searchOptimize + ", manualMuteKV=" + this.manualMuteKV + ", disableWysiwyg=" + this.disableWysiwyg + ", foldOptimize=" + this.foldOptimize + ", fullScreen=" + this.fullScreen + ", multiTabStyle=" + this.multiTabStyle + ", tabAutoSlide=" + this.tabAutoSlide + ", couponFreq=" + this.couponFreq + ", optTitleView=" + this.optTitleView + ", pitayaAutoSlide=" + this.pitayaAutoSlide + ", enableVideoPauseTag=" + this.enableVideoPauseTag + ", enableScreenShotPopup=" + this.enableScreenShotPopup + ", enableFeedbackPopup=" + this.enableFeedbackPopup + ", aiRequestUseNewTriggers=" + this.aiRequestUseNewTriggers + ", marketingExpressionStrengthEnable=" + this.marketingExpressionStrengthEnable + ", changeRecReasonOrder=" + this.changeRecReasonOrder + ", gestureTrackEnable=" + this.gestureTrackEnable + ", infoSwipeEnterDetailEnable=" + this.infoSwipeEnterDetailEnable + ")";
    }

    public final Map<String, Object> r() {
        Map<String, ? extends Object> r100 = this.f545398a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Map r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("desc_area_optimize", this.descAreaOptimize), TuplesKt.to("bottom_area_optimize", this.bottomAreaOptimize), TuplesKt.to("desc_change_order", this.descChangeOrder), TuplesKt.to("desc_add_animation", this.descAddAnimation), TuplesKt.to("desc_interval_optimize", this.descIntervalOptimize), TuplesKt.to("search_optimize", this.searchOptimize), TuplesKt.to("manual_mute_kv", this.manualMuteKV), TuplesKt.to("disable_wysiwyg", this.disableWysiwyg), TuplesKt.to("fold_optimize", this.foldOptimize), TuplesKt.to("full_screen", this.fullScreen), TuplesKt.to("multi_tab_style", this.multiTabStyle), TuplesKt.to("tab_auto_slide", this.tabAutoSlide), TuplesKt.to("coupon_freq", this.couponFreq), TuplesKt.to("opt_title_view", this.optTitleView), TuplesKt.to("enable_video_pause_tag", this.enableVideoPauseTag), TuplesKt.to("enable_screenshot_popup", this.enableScreenShotPopup), TuplesKt.to("enable_feedback_popup", this.enableFeedbackPopup), TuplesKt.to("marketing_expression_strength_enable", this.marketingExpressionStrengthEnable), TuplesKt.to("change_rec_reason_order", this.changeRecReasonOrder)});
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L14;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (r104.getValue() == null) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L7;
        r102.put(r104.getKey(), r104.getValue());
        goto L7
    L11:
        r105 = false;
        goto L12
    L14:
        this.f545398a = r102;
        return r102;
    }

    public final Boolean a() {
        return this.aiRequestUseNewTriggers;
    }

    public final Boolean b() {
        return this.bottomAreaOptimize;
    }

    public final Integer c() {
        return this.couponFreq;
    }

    public final Boolean d() {
        return this.descAddAnimation;
    }

    public final Integer e() {
        return this.descAreaOptimize;
    }

    public final Boolean f() {
        return this.descChangeOrder;
    }

    public final Boolean g() {
        return this.descIntervalOptimize;
    }

    public final Boolean h() {
        return this.disableWysiwyg;
    }

    public final Integer i() {
        return this.foldOptimize;
    }

    public final Boolean j() {
        return this.gestureTrackEnable;
    }

    public final Boolean k() {
        return this.infoSwipeEnterDetailEnable;
    }

    public final Integer l() {
        return this.manualMuteKV;
    }

    public final Integer m() {
        return this.multiTabStyle;
    }

    public final Boolean n() {
        return this.optTitleView;
    }

    public final Boolean o() {
        return this.pitayaAutoSlide;
    }

    public final Boolean p() {
        return this.searchOptimize;
    }

    public final Boolean q() {
        return this.tabAutoSlide;
    }

    public b(int r100) {
        this.descAreaOptimize = null;
        this.bottomAreaOptimize = null;
        this.descChangeOrder = null;
        this.descAddAnimation = null;
        this.descIntervalOptimize = null;
        this.searchOptimize = null;
        this.manualMuteKV = null;
        this.disableWysiwyg = null;
        this.foldOptimize = null;
        this.fullScreen = null;
        this.multiTabStyle = null;
        this.tabAutoSlide = null;
        this.couponFreq = null;
        this.optTitleView = null;
        this.pitayaAutoSlide = null;
        this.enableVideoPauseTag = null;
        this.enableScreenShotPopup = null;
        this.enableFeedbackPopup = null;
        this.aiRequestUseNewTriggers = null;
        this.marketingExpressionStrengthEnable = null;
        this.changeRecReasonOrder = null;
        this.gestureTrackEnable = null;
        this.infoSwipeEnterDetailEnable = null;
    }
}
