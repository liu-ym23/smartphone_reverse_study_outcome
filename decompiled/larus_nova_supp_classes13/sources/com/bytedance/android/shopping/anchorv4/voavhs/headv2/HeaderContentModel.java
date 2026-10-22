package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u00105\u001a\u00020\u0005\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u00107\u001a\u00020\u0005¢\u0006\u0004\bd\u0010eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001aJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\u0005HÆ\u0003Jî\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010.\u001a\u00020\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010 2\b\b\u0002\u00105\u001a\u00020\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010#2\b\b\u0002\u00107\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b8\u00109J\t\u0010:\u001a\u00020\u0002HÖ\u0001J\t\u0010;\u001a\u00020#HÖ\u0001J\u0013\u0010>\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010<HÖ\u0003R\u001c\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010(\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bC\u0010DR\u001c\u0010)\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010E\u001a\u0004\bF\u0010GR(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010H\u001a\u0004\bI\u0010JR(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010H\u001a\u0004\bK\u0010JR\u001c\u0010,\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010L\u001a\u0004\bM\u0010NR\u001c\u0010-\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010O\u001a\u0004\bP\u0010QR\u001a\u0010.\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010R\u001a\u0004\bS\u0010TR\u001c\u0010/\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010U\u001a\u0004\bV\u0010\u001aR\u001c\u00100\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010U\u001a\u0004\bW\u0010\u001aR\u001c\u00101\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010U\u001a\u0004\bX\u0010\u001aR\u001c\u00102\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010U\u001a\u0004\bY\u0010\u001aR\u001c\u00103\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010Z\u001a\u0004\b[\u0010\\R\u001c\u00104\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010]\u001a\u0004\b^\u0010_R\u001a\u00105\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010R\u001a\u0004\b`\u0010TR\u001c\u00106\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010a\u001a\u0004\bb\u0010%R\u001a\u00107\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010R\u001a\u0004\bc\u0010T¨\u0006f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "Ljava/io/Serializable;", "", "getSkuSpecId", "getTrackType", "", "isCommentTest", "half", "", "getWHScale", "(Z)Ljava/lang/Float;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "component2", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component3", "", "component4", "component5", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "component6", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "component7", "component8", "component9", "()Ljava/lang/Float;", "component10", "component11", "component12", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "component13", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;", "component14", "component15", "", "component16", "()Ljava/lang/Integer;", "component17", "media", "slice", "clickAction", "track", "meta", "config", "lynx", "needShowBar", "whScale", "whScaleHalf", "topPadding", "topPaddingHalf", "style", "multiPreview", "defaultHide", "fixedHeight", "needStatusBarPlace", "copy", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;ZLjava/lang/Integer;Z)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "toString", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "getMedia", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "getSlice", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getClickAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "Ljava/util/Map;", "getTrack", "()Ljava/util/Map;", "getMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "getLynx", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;", "Z", "getNeedShowBar", "()Z", "Ljava/lang/Float;", "getWhScale", "getWhScaleHalf", "getTopPadding", "getTopPaddingHalf", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "getStyle", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;", "getMultiPreview", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;", "getDefaultHide", "Ljava/lang/Integer;", "getFixedHeight", "getNeedStatusBarPlace", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaModel;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderSliceModel;Lcom/bytedance/android/ecom/arch/slice/action/IAction;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/Config;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/j;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/r;ZLjava/lang/Integer;Z)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderContentModel implements Serializable {

    @SerializedName("click_action")
    private final IAction clickAction;

    @SerializedName("config")
    private final Config config;

    @SerializedName("default_hide")
    private final boolean defaultHide;

    @SerializedName("fixed_height")
    private final Integer fixedHeight;

    @SerializedName("lynx_container")
    private final j lynx;

    @SerializedName("media")
    private final HeaderMediaModel media;

    @SerializedName("meta")
    private final Map<String, String> meta;

    @SerializedName("multi_preview")
    private final r multiPreview;

    @SerializedName("need_show_bar")
    private final boolean needShowBar;

    @SerializedName("need_status_bar_place")
    private final boolean needStatusBarPlace;

    @SerializedName("slice")
    private final HeaderSliceModel slice;

    @SerializedName("style")
    private final i style;

    @SerializedName("top_padding")
    private final Float topPadding;

    @SerializedName("top_padding_half")
    private final Float topPaddingHalf;

    @SerializedName("track")
    private final Map<String, String> track;

    @SerializedName("wh_scale")
    private final Float whScale;

    @SerializedName("wh_scale_half")
    private final Float whScaleHalf;

    public HeaderContentModel() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderContentModel copy$default(HeaderContentModel r17, HeaderMediaModel r18, HeaderSliceModel r19, IAction r20, Map r21, Map r22, Config r23, j r24, boolean r25, Float r26, Float r27, Float r28, Float r29, i r30, r r31, boolean r32, Integer r33, boolean r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        HeaderMediaModel r2 = r17.media;
    L7:
        if ((r35 & 2) == 0) goto L9;
        HeaderSliceModel r3 = r17.slice;
    L11:
        if ((r35 & 4) == 0) goto L13;
        IAction r4 = r17.clickAction;
    L15:
        if ((r35 & 8) == 0) goto L17;
        Map r5 = r17.track;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Map r6 = r17.meta;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Config r7 = r17.config;
    L27:
        if ((r35 & 64) == 0) goto L29;
        j r8 = r17.lynx;
    L31:
        if ((r35 & 128) == 0) goto L33;
        boolean r9 = r17.needShowBar;
    L35:
        if ((r35 & 256) == 0) goto L37;
        Float r10 = r17.whScale;
    L39:
        if ((r35 & 512) == 0) goto L41;
        Float r11 = r17.whScaleHalf;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        Float r12 = r17.topPadding;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        Float r13 = r17.topPaddingHalf;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        i r14 = r17.style;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        r r15 = r17.multiPreview;
    L58:
        r r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        boolean r16 = r17.defaultHide;
    L62:
        boolean r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        Integer r110 = r17.fixedHeight;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        boolean r1 = r17.needStatusBarPlace;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r110, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r110 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final HeaderMediaModel component1() {
        return this.media;
    }

    public final Float component10() {
        return this.whScaleHalf;
    }

    public final Float component11() {
        return this.topPadding;
    }

    public final Float component12() {
        return this.topPaddingHalf;
    }

    public final i component13() {
        return this.style;
    }

    public final r component14() {
        return this.multiPreview;
    }

    public final boolean component15() {
        return this.defaultHide;
    }

    public final Integer component16() {
        return this.fixedHeight;
    }

    public final boolean component17() {
        return this.needStatusBarPlace;
    }

    public final HeaderSliceModel component2() {
        return this.slice;
    }

    public final IAction component3() {
        return this.clickAction;
    }

    public final Map<String, String> component4() {
        return this.track;
    }

    public final Map<String, String> component5() {
        return this.meta;
    }

    public final Config component6() {
        return this.config;
    }

    public final j component7() {
        return this.lynx;
    }

    public final boolean component8() {
        return this.needShowBar;
    }

    public final Float component9() {
        return this.whScale;
    }

    public final HeaderContentModel copy(HeaderMediaModel r20, HeaderSliceModel r21, IAction r22, Map<String, String> r23, Map<String, String> r24, Config r25, j r26, boolean r27, Float r28, Float r29, Float r30, Float r31, i r32, r r33, boolean r34, Integer r35, boolean r36) {
        return new HeaderContentModel(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderContentModel) == false) goto L40;
        HeaderContentModel r4 = (HeaderContentModel) r3;
        if (Intrinsics.areEqual(this.media, r4.media) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.slice, r4.slice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clickAction, r4.clickAction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.track, r4.track) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.meta, r4.meta) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.config, r4.config) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynx, r4.lynx) == true) goto L20;
        return false;
    L20:
        if (this.needShowBar == r4.needShowBar) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.whScale, r4.whScale) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.whScaleHalf, r4.whScaleHalf) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.topPadding, r4.topPadding) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.topPaddingHalf, r4.topPaddingHalf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.style, r4.style) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.multiPreview, r4.multiPreview) == true) goto L34;
        return false;
    L34:
        if (this.defaultHide == r4.defaultHide) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.fixedHeight, r4.fixedHeight) == true) goto L38;
        return false;
    L38:
        if (this.needStatusBarPlace == r4.needStatusBarPlace) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        HeaderMediaModel r0 = this.media;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HeaderSliceModel r4 = this.slice;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        IAction r7 = this.clickAction;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.track;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.meta;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Config r16 = this.config;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        j r19 = this.lynx;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.needShowBar;
        ?? r23 = 1;
        ?? r24 = r22;
        if (r22 == false) goto L33;
        r24 = 1;
    L33:
        int r25 = (r21 + r24) * 31;
        Float r26 = this.whScale;
        if (r26 == null) goto L36;
        int r27 = r26.hashCode();
    L37:
        int r28 = (r25 + r27) * 31;
        Float r29 = this.whScaleHalf;
        if (r29 == null) goto L40;
        int r30 = r29.hashCode();
    L41:
        int r31 = (r28 + r30) * 31;
        Float r32 = this.topPadding;
        if (r32 == null) goto L44;
        int r33 = r32.hashCode();
    L45:
        int r34 = (r31 + r33) * 31;
        Float r35 = this.topPaddingHalf;
        if (r35 == null) goto L48;
        int r36 = r35.hashCode();
    L49:
        int r37 = (r34 + r36) * 31;
        i r38 = this.style;
        if (r38 == null) goto L52;
        int r39 = r38.hashCode();
    L53:
        int r40 = (r37 + r39) * 31;
        r r41 = this.multiPreview;
        if (r41 == null) goto L56;
        int r42 = r41.hashCode();
    L57:
        int r43 = (r40 + r42) * 31;
        boolean r44 = this.defaultHide;
        ?? r45 = r44;
        if (r44 == false) goto L60;
        r45 = 1;
    L60:
        int r46 = (r43 + r45) * 31;
        Integer r47 = this.fixedHeight;
        if (r47 == null) goto L63;
        r1 = r47.hashCode();
    L63:
        int r48 = (r46 + r1) * 31;
        boolean r49 = this.needStatusBarPlace;
        if (r49 == true) goto L68;
        r23 = r49;
    L68:
        return r48 + r23;
    L56:
        r42 = 0;
        goto L57
    L52:
        r39 = 0;
        goto L53
    L48:
        r36 = 0;
        goto L49
    L44:
        r33 = 0;
        goto L45
    L40:
        r30 = 0;
        goto L41
    L36:
        r27 = 0;
        goto L37
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
        return "HeaderContentModel(media=" + this.media + ", slice=" + this.slice + ", clickAction=" + this.clickAction + ", track=" + this.track + ", meta=" + this.meta + ", config=" + this.config + ", lynx=" + this.lynx + ", needShowBar=" + this.needShowBar + ", whScale=" + this.whScale + ", whScaleHalf=" + this.whScaleHalf + ", topPadding=" + this.topPadding + ", topPaddingHalf=" + this.topPaddingHalf + ", style=" + this.style + ", multiPreview=" + this.multiPreview + ", defaultHide=" + this.defaultHide + ", fixedHeight=" + this.fixedHeight + ", needStatusBarPlace=" + this.needStatusBarPlace + ")";
    }

    public final String getSkuSpecId() {
        Map<String, String> r0 = this.meta;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("spec_id");
    }

    public final String getTrackType() {
        Map<String, String> r0 = this.track;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("type");
    }

    public final boolean isCommentTest() {
        if (Intrinsics.areEqual(getTrackType(), "test") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(getTrackType(), "more_test") == true) goto L8;
        return false;
    }

    public final IAction getClickAction() {
        return this.clickAction;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final boolean getDefaultHide() {
        return this.defaultHide;
    }

    public final Integer getFixedHeight() {
        return this.fixedHeight;
    }

    public final j getLynx() {
        return this.lynx;
    }

    public final HeaderMediaModel getMedia() {
        return this.media;
    }

    public final Map<String, String> getMeta() {
        return this.meta;
    }

    public final r getMultiPreview() {
        return this.multiPreview;
    }

    public final boolean getNeedShowBar() {
        return this.needShowBar;
    }

    public final boolean getNeedStatusBarPlace() {
        return this.needStatusBarPlace;
    }

    public final HeaderSliceModel getSlice() {
        return this.slice;
    }

    public final i getStyle() {
        return this.style;
    }

    public final Float getTopPadding() {
        return this.topPadding;
    }

    public final Float getTopPaddingHalf() {
        return this.topPaddingHalf;
    }

    public final Map<String, String> getTrack() {
        return this.track;
    }

    public final Float getWhScale() {
        return this.whScale;
    }

    public final Float getWhScaleHalf() {
        return this.whScaleHalf;
    }

    public final Float getWHScale(boolean r4) {
        if (r4 == false) goto L7;
        Float r5 = this.whScaleHalf;
        if (r5 != null) goto L12;
        return null;
    L12:
        return Float.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r5.floatValue(), 0.75f), 2.0f));
    L7:
        Float r6 = this.whScale;
        if (r6 != null) goto L10;
        return null;
    L10:
        return Float.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r6.floatValue(), 0.75f), 2.0f));
    }

    public HeaderContentModel(HeaderMediaModel r3, HeaderSliceModel r4, IAction r5, Map<String, String> r6, Map<String, String> r7, Config r8, j r9, boolean r10, Float r11, Float r12, Float r13, Float r14, i r15, r r16, boolean r17, Integer r18, boolean r19) {
        this.media = r3;
        this.slice = r4;
        this.clickAction = r5;
        this.track = r6;
        this.meta = r7;
        this.config = r8;
        this.lynx = r9;
        this.needShowBar = r10;
        this.whScale = r11;
        this.whScaleHalf = r12;
        this.topPadding = r13;
        this.topPaddingHalf = r14;
        this.style = r15;
        this.multiPreview = r16;
        this.defaultHide = r17;
        this.fixedHeight = r18;
        this.needStatusBarPlace = r19;
    }

    public /* synthetic */ HeaderContentModel(HeaderMediaModel r19, HeaderSliceModel r20, IAction r21, Map r22, Map r23, Config r24, j r25, boolean r26, Float r27, Float r28, Float r29, Float r30, i r31, r r32, boolean r33, Integer r34, boolean r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        HeaderMediaModel r1 = null;
    L7:
        if ((r36 & 2) == 0) goto L9;
        HeaderSliceModel r3 = null;
    L11:
        if ((r36 & 4) == 0) goto L13;
        IAction r4 = null;
    L15:
        if ((r36 & 8) == 0) goto L17;
        Map r5 = null;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Map r6 = null;
    L23:
        if ((r36 & 32) == 0) goto L25;
        Config r7 = null;
    L27:
        if ((r36 & 64) == 0) goto L29;
        j r8 = null;
    L31:
        if ((r36 & 128) == 0) goto L33;
        boolean r9 = false;
    L35:
        if ((r36 & 256) == 0) goto L37;
        Float r11 = null;
    L39:
        if ((r36 & 512) == 0) goto L41;
        Float r12 = null;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        Float r13 = null;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        Float r14 = null;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        i r15 = null;
    L55:
        if ((r36 & 8192) == 0) goto L57;
        r r2 = null;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        boolean r10 = false;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        Integer r16 = null;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        boolean r0 = false;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r2, r10, r16, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r16 = r34;
        goto L67
    L61:
        r10 = r33;
        goto L63
    L57:
        r2 = r32;
        goto L59
    L53:
        r15 = r31;
        goto L55
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r9 = r26;
        goto L35
    L29:
        r8 = r25;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r19;
        goto L7
    }
}
