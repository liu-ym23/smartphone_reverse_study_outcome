package com.bytedance.android.shopping.deepfeed.data.repo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010=\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJÂ\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010E\u001a\u00020\bHÖ\u0001J\t\u0010F\u001a\u00020#HÖ\u0001R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b)\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b*\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b.\u0010\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b/\u0010\u001aR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b0\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b1\u0010\u0016¨\u0006G"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "Ljava/io/Serializable;", "styleOpt", "", "styleOptV2", "reduceHeight", "changeButtonColor", "notFullScreenCount", "", "slideToastFreqCount", "slideToastFreqCycle", "", "slideToastFreqVersion", "enterProductAutoSlide", "changeImageSlogan", "videoWithImage", "aiRecommendPosition", "aiRecommendAnim", "deepFeedUseSlc", "keepAiWord", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAiRecommendAnim", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAiRecommendPosition", "getChangeButtonColor", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChangeImageSlogan", "getDeepFeedUseSlc", "getEnterProductAutoSlide", "getKeepAiWord", "getNotFullScreenCount", "originMap", "", "", "", "getOriginMap", "()Ljava/util/Map;", "setOriginMap", "(Ljava/util/Map;)V", "getReduceHeight", "getSlideToastFreqCount", "getSlideToastFreqCycle", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSlideToastFreqVersion", "getStyleOpt", "getStyleOptV2", "getVideoWithImage", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/shopping/deepfeed/data/repo/DeepFeedAbValues;", "equals", "other", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAbValues implements Serializable {

    @SerializedName("ai_recommend_animation")
    private final Integer aiRecommendAnim;

    @SerializedName("ai_recommend_position")
    private final Integer aiRecommendPosition;

    @SerializedName("change_button_color")
    private final Boolean changeButtonColor;

    @SerializedName("change_image_slogan")
    private final Boolean changeImageSlogan;

    @SerializedName("deep_feed_slice")
    private final Integer deepFeedUseSlc;

    @SerializedName("enter_product_auto_slide")
    private final Boolean enterProductAutoSlide;

    @SerializedName("keep_ai_word")
    private final Boolean keepAiWord;

    @SerializedName("not_full_screen_cell_count")
    private final Integer notFullScreenCount;
    private Map<String, ? extends Object> originMap;

    @SerializedName("reduce_height")
    private final Boolean reduceHeight;

    @SerializedName("slide_toast_freq_count")
    private final Integer slideToastFreqCount;

    @SerializedName("slide_toast_freq_cycle")
    private final Double slideToastFreqCycle;

    @SerializedName("slide_toast_freq_version")
    private final Integer slideToastFreqVersion;

    @SerializedName("style_optimize")
    private final Boolean styleOpt;

    @SerializedName("style_optimize_v2")
    private final Boolean styleOptV2;

    @SerializedName("video_with_images")
    private final Integer videoWithImage;

    public DeepFeedAbValues() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ DeepFeedAbValues copy$default(DeepFeedAbValues r16, Boolean r17, Boolean r18, Boolean r19, Boolean r20, Integer r21, Integer r22, Double r23, Integer r24, Boolean r25, Boolean r26, Integer r27, Integer r28, Integer r29, Integer r30, Boolean r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        Boolean r2 = r16.styleOpt;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Boolean r3 = r16.styleOptV2;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Boolean r4 = r16.reduceHeight;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Boolean r5 = r16.changeButtonColor;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Integer r6 = r16.notFullScreenCount;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Integer r7 = r16.slideToastFreqCount;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Double r8 = r16.slideToastFreqCycle;
    L31:
        if ((r32 & 128) == 0) goto L33;
        Integer r9 = r16.slideToastFreqVersion;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Boolean r10 = r16.enterProductAutoSlide;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Boolean r11 = r16.changeImageSlogan;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Integer r12 = r16.videoWithImage;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Integer r13 = r16.aiRecommendPosition;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        Integer r14 = r16.aiRecommendAnim;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        Integer r15 = r16.deepFeedUseSlc;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        Boolean r1 = r16.keepAiWord;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final Boolean component1() {
        return this.styleOpt;
    }

    public final Boolean component10() {
        return this.changeImageSlogan;
    }

    public final Integer component11() {
        return this.videoWithImage;
    }

    public final Integer component12() {
        return this.aiRecommendPosition;
    }

    public final Integer component13() {
        return this.aiRecommendAnim;
    }

    public final Integer component14() {
        return this.deepFeedUseSlc;
    }

    public final Boolean component15() {
        return this.keepAiWord;
    }

    public final Boolean component2() {
        return this.styleOptV2;
    }

    public final Boolean component3() {
        return this.reduceHeight;
    }

    public final Boolean component4() {
        return this.changeButtonColor;
    }

    public final Integer component5() {
        return this.notFullScreenCount;
    }

    public final Integer component6() {
        return this.slideToastFreqCount;
    }

    public final Double component7() {
        return this.slideToastFreqCycle;
    }

    public final Integer component8() {
        return this.slideToastFreqVersion;
    }

    public final Boolean component9() {
        return this.enterProductAutoSlide;
    }

    public final DeepFeedAbValues copy(Boolean r18, Boolean r19, Boolean r20, Boolean r21, Integer r22, Integer r23, Double r24, Integer r25, Boolean r26, Boolean r27, Integer r28, Integer r29, Integer r30, Integer r31, Boolean r32) {
        return new DeepFeedAbValues(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DeepFeedAbValues) == false) goto L36;
        DeepFeedAbValues r4 = (DeepFeedAbValues) r3;
        if (Intrinsics.areEqual(this.styleOpt, r4.styleOpt) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.styleOptV2, r4.styleOptV2) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reduceHeight, r4.reduceHeight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.changeButtonColor, r4.changeButtonColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.notFullScreenCount, r4.notFullScreenCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.slideToastFreqCount, r4.slideToastFreqCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slideToastFreqCycle, r4.slideToastFreqCycle) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.slideToastFreqVersion, r4.slideToastFreqVersion) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.enterProductAutoSlide, r4.enterProductAutoSlide) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.changeImageSlogan, r4.changeImageSlogan) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.videoWithImage, r4.videoWithImage) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.aiRecommendPosition, r4.aiRecommendPosition) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.aiRecommendAnim, r4.aiRecommendAnim) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.deepFeedUseSlc, r4.deepFeedUseSlc) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.keepAiWord, r4.keepAiWord) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        Boolean r0 = this.styleOpt;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.styleOptV2;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.reduceHeight;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.changeButtonColor;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.notFullScreenCount;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.slideToastFreqCount;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Double r19 = this.slideToastFreqCycle;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.slideToastFreqVersion;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.enterProductAutoSlide;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.changeImageSlogan;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.videoWithImage;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.aiRecommendPosition;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.aiRecommendAnim;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Integer r40 = this.deepFeedUseSlc;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Boolean r43 = this.keepAiWord;
        if (r43 == null) goto L62;
        r1 = r43.hashCode();
    L62:
        return r42 + r1;
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

    public String toString() {
        return "DeepFeedAbValues(styleOpt=" + this.styleOpt + ", styleOptV2=" + this.styleOptV2 + ", reduceHeight=" + this.reduceHeight + ", changeButtonColor=" + this.changeButtonColor + ", notFullScreenCount=" + this.notFullScreenCount + ", slideToastFreqCount=" + this.slideToastFreqCount + ", slideToastFreqCycle=" + this.slideToastFreqCycle + ", slideToastFreqVersion=" + this.slideToastFreqVersion + ", enterProductAutoSlide=" + this.enterProductAutoSlide + ", changeImageSlogan=" + this.changeImageSlogan + ", videoWithImage=" + this.videoWithImage + ", aiRecommendPosition=" + this.aiRecommendPosition + ", aiRecommendAnim=" + this.aiRecommendAnim + ", deepFeedUseSlc=" + this.deepFeedUseSlc + ", keepAiWord=" + this.keepAiWord + ")";
    }

    public final Integer getAiRecommendAnim() {
        return this.aiRecommendAnim;
    }

    public final Integer getAiRecommendPosition() {
        return this.aiRecommendPosition;
    }

    public final Boolean getChangeButtonColor() {
        return this.changeButtonColor;
    }

    public final Boolean getChangeImageSlogan() {
        return this.changeImageSlogan;
    }

    public final Integer getDeepFeedUseSlc() {
        return this.deepFeedUseSlc;
    }

    public final Boolean getEnterProductAutoSlide() {
        return this.enterProductAutoSlide;
    }

    public final Boolean getKeepAiWord() {
        return this.keepAiWord;
    }

    public final Integer getNotFullScreenCount() {
        return this.notFullScreenCount;
    }

    public final Map<String, Object> getOriginMap() {
        return this.originMap;
    }

    public final Boolean getReduceHeight() {
        return this.reduceHeight;
    }

    public final Integer getSlideToastFreqCount() {
        return this.slideToastFreqCount;
    }

    public final Double getSlideToastFreqCycle() {
        return this.slideToastFreqCycle;
    }

    public final Integer getSlideToastFreqVersion() {
        return this.slideToastFreqVersion;
    }

    public final Boolean getStyleOpt() {
        return this.styleOpt;
    }

    public final Boolean getStyleOptV2() {
        return this.styleOptV2;
    }

    public final Integer getVideoWithImage() {
        return this.videoWithImage;
    }

    public final void setOriginMap(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.originMap = r2;
    }

    public DeepFeedAbValues(Boolean r1, Boolean r2, Boolean r3, Boolean r4, Integer r5, Integer r6, Double r7, Integer r8, Boolean r9, Boolean r10, Integer r11, Integer r12, Integer r13, Integer r14, Boolean r15) {
        this.styleOpt = r1;
        this.styleOptV2 = r2;
        this.reduceHeight = r3;
        this.changeButtonColor = r4;
        this.notFullScreenCount = r5;
        this.slideToastFreqCount = r6;
        this.slideToastFreqCycle = r7;
        this.slideToastFreqVersion = r8;
        this.enterProductAutoSlide = r9;
        this.changeImageSlogan = r10;
        this.videoWithImage = r11;
        this.aiRecommendPosition = r12;
        this.aiRecommendAnim = r13;
        this.deepFeedUseSlc = r14;
        this.keepAiWord = r15;
        this.originMap = MapsKt.emptyMap();
    }

    public /* synthetic */ DeepFeedAbValues(Boolean r17, Boolean r18, Boolean r19, Boolean r20, Integer r21, Integer r22, Double r23, Integer r24, Boolean r25, Boolean r26, Integer r27, Integer r28, Integer r29, Integer r30, Boolean r31, int r32, DefaultConstructorMarker r33) {
        Boolean r2 = null;
        if ((r32 & 1) == 0) goto L5;
        Boolean r1 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        Boolean r3 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        Boolean r4 = Boolean.FALSE;
    L15:
        if ((r32 & 8) == 0) goto L17;
        Boolean r5 = null;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Integer r6 = 3;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Integer r7 = null;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Double r8 = Double.valueOf(-1.0d);
    L31:
        if ((r32 & 128) == 0) goto L33;
        Integer r9 = 0;
    L35:
        if ((r32 & 256) == 0) goto L37;
        Boolean r10 = Boolean.FALSE;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Boolean r11 = null;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Integer r12 = null;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        Integer r15 = null;
    L59:
        if ((r32 & 16384) != 0) goto L62;
        r2 = r31;
    L62:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2);
        return;
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
