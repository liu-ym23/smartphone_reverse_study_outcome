package tc3;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b%\u0010\u000bR\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000bR\u001c\u0010(\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000bR\u001c\u0010*\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b+\u0010\u000bR\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001c\u00100\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b1\u0010\u000bR\u001c\u00102\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000bR\u001c\u00104\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000b¨\u00066"}, d2 = {"Ltc3/b;", "", "", "descAreaOptimize", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "", "bottomAreaOptimize", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "descChangeOrder", "f", "descAddAnimation", "d", "descIntervalOptimize", "g", "searchOptimize", "p", "manualMuteKV", "l", "disableWysiwyg", "h", "foldOptimize", "i", "fullScreen", "getFullScreen", "multiTabStyle", "m", "tabAutoSlide", "q", "couponFreq", "c", "optTitleView", "n", "pitayaAutoSlide", "o", "enableVideoPauseTag", "getEnableVideoPauseTag", "enableScreenShotPopup", "getEnableScreenShotPopup", "enableFeedbackPopup", "getEnableFeedbackPopup", "aiRequestUseNewTriggers", "a", "marketingExpressionStrengthEnable", "getMarketingExpressionStrengthEnable", "changeRecReasonOrder", "getChangeRecReasonOrder", "gestureTrackEnable", "j", "infoSwipeEnterDetailEnable", "k", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {
    public Map<String, ? extends Object> a;

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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L52;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.descAreaOptimize, r4.descAreaOptimize) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomAreaOptimize, r4.bottomAreaOptimize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.descChangeOrder, r4.descChangeOrder) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descAddAnimation, r4.descAddAnimation) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.descIntervalOptimize, r4.descIntervalOptimize) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.searchOptimize, r4.searchOptimize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.manualMuteKV, r4.manualMuteKV) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.disableWysiwyg, r4.disableWysiwyg) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.foldOptimize, r4.foldOptimize) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fullScreen, r4.fullScreen) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.multiTabStyle, r4.multiTabStyle) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.tabAutoSlide, r4.tabAutoSlide) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.couponFreq, r4.couponFreq) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.optTitleView, r4.optTitleView) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.pitayaAutoSlide, r4.pitayaAutoSlide) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.enableVideoPauseTag, r4.enableVideoPauseTag) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.enableScreenShotPopup, r4.enableScreenShotPopup) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.enableFeedbackPopup, r4.enableFeedbackPopup) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.aiRequestUseNewTriggers, r4.aiRequestUseNewTriggers) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.marketingExpressionStrengthEnable, r4.marketingExpressionStrengthEnable) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.changeRecReasonOrder, r4.changeRecReasonOrder) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.gestureTrackEnable, r4.gestureTrackEnable) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.infoSwipeEnterDetailEnable, r4.infoSwipeEnterDetailEnable) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.descAreaOptimize;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.bottomAreaOptimize;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.descChangeOrder;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.descAddAnimation;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.descIntervalOptimize;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.searchOptimize;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.manualMuteKV;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.disableWysiwyg;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.foldOptimize;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.fullScreen;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.multiTabStyle;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.tabAutoSlide;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.couponFreq;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.optTitleView;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Boolean r43 = this.pitayaAutoSlide;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        Boolean r46 = this.enableVideoPauseTag;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.enableScreenShotPopup;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        Boolean r52 = this.enableFeedbackPopup;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        Boolean r55 = this.aiRequestUseNewTriggers;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        Boolean r58 = this.marketingExpressionStrengthEnable;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        Boolean r61 = this.changeRecReasonOrder;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        Boolean r64 = this.gestureTrackEnable;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        Boolean r67 = this.infoSwipeEnterDetailEnable;
        if (r67 == null) goto L94;
        r1 = r67.hashCode();
    L94:
        return r66 + r1;
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedConfig(descAreaOptimize=" + this.descAreaOptimize + ", bottomAreaOptimize=" + this.bottomAreaOptimize + ", descChangeOrder=" + this.descChangeOrder + ", descAddAnimation=" + this.descAddAnimation + ", descIntervalOptimize=" + this.descIntervalOptimize + ", searchOptimize=" + this.searchOptimize + ", manualMuteKV=" + this.manualMuteKV + ", disableWysiwyg=" + this.disableWysiwyg + ", foldOptimize=" + this.foldOptimize + ", fullScreen=" + this.fullScreen + ", multiTabStyle=" + this.multiTabStyle + ", tabAutoSlide=" + this.tabAutoSlide + ", couponFreq=" + this.couponFreq + ", optTitleView=" + this.optTitleView + ", pitayaAutoSlide=" + this.pitayaAutoSlide + ", enableVideoPauseTag=" + this.enableVideoPauseTag + ", enableScreenShotPopup=" + this.enableScreenShotPopup + ", enableFeedbackPopup=" + this.enableFeedbackPopup + ", aiRequestUseNewTriggers=" + this.aiRequestUseNewTriggers + ", marketingExpressionStrengthEnable=" + this.marketingExpressionStrengthEnable + ", changeRecReasonOrder=" + this.changeRecReasonOrder + ", gestureTrackEnable=" + this.gestureTrackEnable + ", infoSwipeEnterDetailEnable=" + this.infoSwipeEnterDetailEnable + ")";
    }

    public final Map<String, Object> r() {
        Map<String, ? extends Object> r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("desc_area_optimize", this.descAreaOptimize), TuplesKt.to("bottom_area_optimize", this.bottomAreaOptimize), TuplesKt.to("desc_change_order", this.descChangeOrder), TuplesKt.to("desc_add_animation", this.descAddAnimation), TuplesKt.to("desc_interval_optimize", this.descIntervalOptimize), TuplesKt.to("search_optimize", this.searchOptimize), TuplesKt.to("manual_mute_kv", this.manualMuteKV), TuplesKt.to("disable_wysiwyg", this.disableWysiwyg), TuplesKt.to("fold_optimize", this.foldOptimize), TuplesKt.to("full_screen", this.fullScreen), TuplesKt.to("multi_tab_style", this.multiTabStyle), TuplesKt.to("tab_auto_slide", this.tabAutoSlide), TuplesKt.to("coupon_freq", this.couponFreq), TuplesKt.to("opt_title_view", this.optTitleView), TuplesKt.to("enable_video_pause_tag", this.enableVideoPauseTag), TuplesKt.to("enable_screenshot_popup", this.enableScreenShotPopup), TuplesKt.to("enable_feedback_popup", this.enableFeedbackPopup), TuplesKt.to("marketing_expression_strength_enable", this.marketingExpressionStrengthEnable), TuplesKt.to("change_rec_reason_order", this.changeRecReasonOrder)});
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (r4.getValue() == null) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L7;
        r2.put(r4.getKey(), r4.getValue());
        goto L7
    L11:
        r5 = false;
        goto L12
    L14:
        this.a = r2;
        return r2;
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

    public b(int r1) {
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
