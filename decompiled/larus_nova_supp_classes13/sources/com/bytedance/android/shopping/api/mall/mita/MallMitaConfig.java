package com.bytedance.android.shopping.api.mall.mita;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003JÃ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u0010<\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018¨\u0006A"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/mita/MallMitaConfig;", "", "enableSharedRecyclerViewPool", "", "mallMitaPrefetchNextTabFeed", "mallMitaUseOldCache", "enableMitaLayoutSuppress", "mallMitaCardExposeCheckOpt", "mallMitaAdjustRVHeightOpt", "mallMitaReuseFirstScreenParsedDataOpt", "mallMitaFoldSlotChildScrollOpt", "mallMitaFoldNestedBridgeOpt", "skipStraightOutNodeIds", "", "", "xTabFullBuildOnNextFrame", "enableMitaGulPageNames", "enableFeedPreInit", "enableFeedDataFastPath", "enableDMTViewPager", "enableFoldHeaderAlwaysCanDrag", "closeRefreshableFeedAutoMeasure", "(ZZZZZZZZZLjava/util/List;ZLjava/util/List;ZZZZZ)V", "getCloseRefreshableFeedAutoMeasure", "()Z", "getEnableDMTViewPager", "getEnableFeedDataFastPath", "getEnableFeedPreInit", "getEnableFoldHeaderAlwaysCanDrag", "getEnableMitaGulPageNames", "()Ljava/util/List;", "getEnableMitaLayoutSuppress", "getEnableSharedRecyclerViewPool", "getMallMitaAdjustRVHeightOpt", "getMallMitaCardExposeCheckOpt", "getMallMitaFoldNestedBridgeOpt", "getMallMitaFoldSlotChildScrollOpt", "getMallMitaPrefetchNextTabFeed", "getMallMitaReuseFirstScreenParsedDataOpt", "getMallMitaUseOldCache", "getSkipStraightOutNodeIds", "getXTabFullBuildOnNextFrame", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallMitaConfig {

    @SerializedName("mall_mita_close_refreshable_feed_auto_measure")
    private final boolean closeRefreshableFeedAutoMeasure;

    @SerializedName("mall_mita_enable_dmt_view_pager")
    private final boolean enableDMTViewPager;

    @SerializedName("mall_mita_enable_feed_data_fast_path")
    private final boolean enableFeedDataFastPath;

    @SerializedName("mall_mita_enable_feed_pre_init")
    private final boolean enableFeedPreInit;

    @SerializedName("mall_mita_enable_fold_header_always_can_drag")
    private final boolean enableFoldHeaderAlwaysCanDrag;

    @SerializedName("enable_gul_page_name")
    private final List<String> enableMitaGulPageNames;

    @SerializedName("enable_mita_layout_suppress")
    private final boolean enableMitaLayoutSuppress;

    @SerializedName("enable_shared_recycler_view_pool")
    private final boolean enableSharedRecyclerViewPool;

    @SerializedName("mall_mita_adjust_rv_height_opt")
    private final boolean mallMitaAdjustRVHeightOpt;

    @SerializedName("mall_mita_list_card_expose_opt")
    private final boolean mallMitaCardExposeCheckOpt;

    @SerializedName("mall_mita_fold_nested_bridge_opt")
    private final boolean mallMitaFoldNestedBridgeOpt;

    @SerializedName("mall_mita_fold_slot_child_scroll_opt")
    private final boolean mallMitaFoldSlotChildScrollOpt;

    @SerializedName("mall_mita_prefetch_next_tab_feed")
    private final boolean mallMitaPrefetchNextTabFeed;

    @SerializedName("mall_mita_reuse_first_screen_parsed_data_opt")
    private final boolean mallMitaReuseFirstScreenParsedDataOpt;

    @SerializedName("mall_mita_use_old_cache")
    private final boolean mallMitaUseOldCache;

    @SerializedName("mall_mita_skip_straight_out_node_ids")
    private final List<String> skipStraightOutNodeIds;

    @SerializedName("mall_mita_xtab_full_build_on_next_frame")
    private final boolean xTabFullBuildOnNextFrame;

    public MallMitaConfig() {
        this(false, false, false, false, false, false, false, false, false, null, false, null, false, false, false, false, false, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallMitaConfig copy$default(MallMitaConfig r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, List r27, boolean r28, List r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        boolean r2 = r17.enableSharedRecyclerViewPool;
    L7:
        if ((r35 & 2) == 0) goto L9;
        boolean r3 = r17.mallMitaPrefetchNextTabFeed;
    L11:
        if ((r35 & 4) == 0) goto L13;
        boolean r4 = r17.mallMitaUseOldCache;
    L15:
        if ((r35 & 8) == 0) goto L17;
        boolean r5 = r17.enableMitaLayoutSuppress;
    L19:
        if ((r35 & 16) == 0) goto L21;
        boolean r6 = r17.mallMitaCardExposeCheckOpt;
    L23:
        if ((r35 & 32) == 0) goto L25;
        boolean r7 = r17.mallMitaAdjustRVHeightOpt;
    L27:
        if ((r35 & 64) == 0) goto L29;
        boolean r8 = r17.mallMitaReuseFirstScreenParsedDataOpt;
    L31:
        if ((r35 & 128) == 0) goto L33;
        boolean r9 = r17.mallMitaFoldSlotChildScrollOpt;
    L35:
        if ((r35 & 256) == 0) goto L37;
        boolean r10 = r17.mallMitaFoldNestedBridgeOpt;
    L39:
        if ((r35 & 512) == 0) goto L41;
        List r11 = r17.skipStraightOutNodeIds;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        boolean r12 = r17.xTabFullBuildOnNextFrame;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        List r13 = r17.enableMitaGulPageNames;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        boolean r14 = r17.enableFeedPreInit;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        boolean r15 = r17.enableFeedDataFastPath;
    L58:
        boolean r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        boolean r16 = r17.enableDMTViewPager;
    L62:
        boolean r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        boolean r110 = r17.enableFoldHeaderAlwaysCanDrag;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        boolean r1 = r17.closeRefreshableFeedAutoMeasure;
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

    public final boolean component1() {
        return this.enableSharedRecyclerViewPool;
    }

    public final List<String> component10() {
        return this.skipStraightOutNodeIds;
    }

    public final boolean component11() {
        return this.xTabFullBuildOnNextFrame;
    }

    public final List<String> component12() {
        return this.enableMitaGulPageNames;
    }

    public final boolean component13() {
        return this.enableFeedPreInit;
    }

    public final boolean component14() {
        return this.enableFeedDataFastPath;
    }

    public final boolean component15() {
        return this.enableDMTViewPager;
    }

    public final boolean component16() {
        return this.enableFoldHeaderAlwaysCanDrag;
    }

    public final boolean component17() {
        return this.closeRefreshableFeedAutoMeasure;
    }

    public final boolean component2() {
        return this.mallMitaPrefetchNextTabFeed;
    }

    public final boolean component3() {
        return this.mallMitaUseOldCache;
    }

    public final boolean component4() {
        return this.enableMitaLayoutSuppress;
    }

    public final boolean component5() {
        return this.mallMitaCardExposeCheckOpt;
    }

    public final boolean component6() {
        return this.mallMitaAdjustRVHeightOpt;
    }

    public final boolean component7() {
        return this.mallMitaReuseFirstScreenParsedDataOpt;
    }

    public final boolean component8() {
        return this.mallMitaFoldSlotChildScrollOpt;
    }

    public final boolean component9() {
        return this.mallMitaFoldNestedBridgeOpt;
    }

    public final MallMitaConfig copy(boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, List<String> r29, boolean r30, List<String> r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36) {
        return new MallMitaConfig(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MallMitaConfig) == false) goto L40;
        MallMitaConfig r4 = (MallMitaConfig) r3;
        if (this.enableSharedRecyclerViewPool == r4.enableSharedRecyclerViewPool) goto L8;
        return false;
    L8:
        if (this.mallMitaPrefetchNextTabFeed == r4.mallMitaPrefetchNextTabFeed) goto L10;
        return false;
    L10:
        if (this.mallMitaUseOldCache == r4.mallMitaUseOldCache) goto L12;
        return false;
    L12:
        if (this.enableMitaLayoutSuppress == r4.enableMitaLayoutSuppress) goto L14;
        return false;
    L14:
        if (this.mallMitaCardExposeCheckOpt == r4.mallMitaCardExposeCheckOpt) goto L16;
        return false;
    L16:
        if (this.mallMitaAdjustRVHeightOpt == r4.mallMitaAdjustRVHeightOpt) goto L18;
        return false;
    L18:
        if (this.mallMitaReuseFirstScreenParsedDataOpt == r4.mallMitaReuseFirstScreenParsedDataOpt) goto L20;
        return false;
    L20:
        if (this.mallMitaFoldSlotChildScrollOpt == r4.mallMitaFoldSlotChildScrollOpt) goto L22;
        return false;
    L22:
        if (this.mallMitaFoldNestedBridgeOpt == r4.mallMitaFoldNestedBridgeOpt) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.skipStraightOutNodeIds, r4.skipStraightOutNodeIds) == true) goto L26;
        return false;
    L26:
        if (this.xTabFullBuildOnNextFrame == r4.xTabFullBuildOnNextFrame) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.enableMitaGulPageNames, r4.enableMitaGulPageNames) == true) goto L30;
        return false;
    L30:
        if (this.enableFeedPreInit == r4.enableFeedPreInit) goto L32;
        return false;
    L32:
        if (this.enableFeedDataFastPath == r4.enableFeedDataFastPath) goto L34;
        return false;
    L34:
        if (this.enableDMTViewPager == r4.enableDMTViewPager) goto L36;
        return false;
    L36:
        if (this.enableFoldHeaderAlwaysCanDrag == r4.enableFoldHeaderAlwaysCanDrag) goto L38;
        return false;
    L38:
        if (this.closeRefreshableFeedAutoMeasure == r4.closeRefreshableFeedAutoMeasure) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v25, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean r0 = this.enableSharedRecyclerViewPool;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.mallMitaPrefetchNextTabFeed;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.mallMitaUseOldCache;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.enableMitaLayoutSuppress;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.mallMitaCardExposeCheckOpt;
        ?? r14 = r13;
        if (r13 == false) goto L17;
        r14 = 1;
    L17:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.mallMitaAdjustRVHeightOpt;
        ?? r17 = r16;
        if (r16 == false) goto L20;
        r17 = 1;
    L20:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.mallMitaReuseFirstScreenParsedDataOpt;
        ?? r20 = r19;
        if (r19 == false) goto L23;
        r20 = 1;
    L23:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.mallMitaFoldSlotChildScrollOpt;
        ?? r23 = r22;
        if (r22 == false) goto L26;
        r23 = 1;
    L26:
        int r24 = (r21 + r23) * 31;
        boolean r25 = this.mallMitaFoldNestedBridgeOpt;
        ?? r26 = r25;
        if (r25 == false) goto L29;
        r26 = 1;
    L29:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.skipStraightOutNodeIds;
        int r29 = 0;
        if (r28 == null) goto L32;
        int r30 = r28.hashCode();
    L33:
        int r31 = (r27 + r30) * 31;
        boolean r32 = this.xTabFullBuildOnNextFrame;
        ?? r33 = r32;
        if (r32 == false) goto L36;
        r33 = 1;
    L36:
        int r34 = (r31 + r33) * 31;
        List<String> r35 = this.enableMitaGulPageNames;
        if (r35 == null) goto L39;
        r29 = r35.hashCode();
    L39:
        int r36 = (r34 + r29) * 31;
        boolean r37 = this.enableFeedPreInit;
        ?? r38 = r37;
        if (r37 == false) goto L42;
        r38 = 1;
    L42:
        int r39 = (r36 + r38) * 31;
        boolean r40 = this.enableFeedDataFastPath;
        ?? r41 = r40;
        if (r40 == false) goto L45;
        r41 = 1;
    L45:
        int r42 = (r39 + r41) * 31;
        boolean r43 = this.enableDMTViewPager;
        ?? r44 = r43;
        if (r43 == false) goto L48;
        r44 = 1;
    L48:
        int r45 = (r42 + r44) * 31;
        boolean r46 = this.enableFoldHeaderAlwaysCanDrag;
        ?? r47 = r46;
        if (r46 == false) goto L51;
        r47 = 1;
    L51:
        int r48 = (r45 + r47) * 31;
        boolean r49 = this.closeRefreshableFeedAutoMeasure;
        if (r49 == true) goto L56;
        r1 = r49;
    L56:
        return r48 + r1;
    L32:
        r30 = 0;
        goto L33
    }

    public String toString() {
        return "MallMitaConfig(enableSharedRecyclerViewPool=" + this.enableSharedRecyclerViewPool + ", mallMitaPrefetchNextTabFeed=" + this.mallMitaPrefetchNextTabFeed + ", mallMitaUseOldCache=" + this.mallMitaUseOldCache + ", enableMitaLayoutSuppress=" + this.enableMitaLayoutSuppress + ", mallMitaCardExposeCheckOpt=" + this.mallMitaCardExposeCheckOpt + ", mallMitaAdjustRVHeightOpt=" + this.mallMitaAdjustRVHeightOpt + ", mallMitaReuseFirstScreenParsedDataOpt=" + this.mallMitaReuseFirstScreenParsedDataOpt + ", mallMitaFoldSlotChildScrollOpt=" + this.mallMitaFoldSlotChildScrollOpt + ", mallMitaFoldNestedBridgeOpt=" + this.mallMitaFoldNestedBridgeOpt + ", skipStraightOutNodeIds=" + this.skipStraightOutNodeIds + ", xTabFullBuildOnNextFrame=" + this.xTabFullBuildOnNextFrame + ", enableMitaGulPageNames=" + this.enableMitaGulPageNames + ", enableFeedPreInit=" + this.enableFeedPreInit + ", enableFeedDataFastPath=" + this.enableFeedDataFastPath + ", enableDMTViewPager=" + this.enableDMTViewPager + ", enableFoldHeaderAlwaysCanDrag=" + this.enableFoldHeaderAlwaysCanDrag + ", closeRefreshableFeedAutoMeasure=" + this.closeRefreshableFeedAutoMeasure + ")";
    }

    public final boolean getCloseRefreshableFeedAutoMeasure() {
        return this.closeRefreshableFeedAutoMeasure;
    }

    public final boolean getEnableDMTViewPager() {
        return this.enableDMTViewPager;
    }

    public final boolean getEnableFeedDataFastPath() {
        return this.enableFeedDataFastPath;
    }

    public final boolean getEnableFeedPreInit() {
        return this.enableFeedPreInit;
    }

    public final boolean getEnableFoldHeaderAlwaysCanDrag() {
        return this.enableFoldHeaderAlwaysCanDrag;
    }

    public final List<String> getEnableMitaGulPageNames() {
        return this.enableMitaGulPageNames;
    }

    public final boolean getEnableMitaLayoutSuppress() {
        return this.enableMitaLayoutSuppress;
    }

    public final boolean getEnableSharedRecyclerViewPool() {
        return this.enableSharedRecyclerViewPool;
    }

    public final boolean getMallMitaAdjustRVHeightOpt() {
        return this.mallMitaAdjustRVHeightOpt;
    }

    public final boolean getMallMitaCardExposeCheckOpt() {
        return this.mallMitaCardExposeCheckOpt;
    }

    public final boolean getMallMitaFoldNestedBridgeOpt() {
        return this.mallMitaFoldNestedBridgeOpt;
    }

    public final boolean getMallMitaFoldSlotChildScrollOpt() {
        return this.mallMitaFoldSlotChildScrollOpt;
    }

    public final boolean getMallMitaPrefetchNextTabFeed() {
        return this.mallMitaPrefetchNextTabFeed;
    }

    public final boolean getMallMitaReuseFirstScreenParsedDataOpt() {
        return this.mallMitaReuseFirstScreenParsedDataOpt;
    }

    public final boolean getMallMitaUseOldCache() {
        return this.mallMitaUseOldCache;
    }

    public final List<String> getSkipStraightOutNodeIds() {
        return this.skipStraightOutNodeIds;
    }

    public final boolean getXTabFullBuildOnNextFrame() {
        return this.xTabFullBuildOnNextFrame;
    }

    public MallMitaConfig(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, List<String> r12, boolean r13, List<String> r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        this.enableSharedRecyclerViewPool = r3;
        this.mallMitaPrefetchNextTabFeed = r4;
        this.mallMitaUseOldCache = r5;
        this.enableMitaLayoutSuppress = r6;
        this.mallMitaCardExposeCheckOpt = r7;
        this.mallMitaAdjustRVHeightOpt = r8;
        this.mallMitaReuseFirstScreenParsedDataOpt = r9;
        this.mallMitaFoldSlotChildScrollOpt = r10;
        this.mallMitaFoldNestedBridgeOpt = r11;
        this.skipStraightOutNodeIds = r12;
        this.xTabFullBuildOnNextFrame = r13;
        this.enableMitaGulPageNames = r14;
        this.enableFeedPreInit = r15;
        this.enableFeedDataFastPath = r16;
        this.enableDMTViewPager = r17;
        this.enableFoldHeaderAlwaysCanDrag = r18;
        this.closeRefreshableFeedAutoMeasure = r19;
    }

    public /* synthetic */ MallMitaConfig(boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, List r29, boolean r30, List r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36, int r37, DefaultConstructorMarker r38) {
        boolean r2 = false;
        if ((r37 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r37 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r37 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r37 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r37 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r37 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r37 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r37 & 128) == 0) goto L33;
        boolean r9 = false;
    L35:
        if ((r37 & 256) == 0) goto L37;
        boolean r10 = false;
    L38:
        List r12 = null;
        if ((r37 & 512) == 0) goto L41;
        List r11 = null;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r37 & 2048) != 0) goto L51;
        r12 = r31;
    L51:
        if ((r37 & 4096) == 0) goto L53;
        boolean r14 = false;
    L55:
        if ((r37 & 8192) != 0) goto L58;
        r2 = r33;
    L58:
        boolean r16 = true;
        if ((r37 & 16384) == 0) goto L61;
        boolean r15 = true;
    L63:
        if ((r37 & 32768) == 0) goto L65;
        boolean r17 = true;
    L67:
        if ((r37 & 65536) != 0) goto L70;
        r16 = r36;
    L70:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r12, r14, r2, r15, r17, r16);
        return;
    L65:
        r17 = r35;
        goto L67
    L61:
        r15 = r34;
        goto L63
    L53:
        r14 = r32;
        goto L55
    L45:
        r13 = r30;
        goto L47
    L41:
        r11 = r29;
        goto L43
    L37:
        r10 = r28;
        goto L38
    L33:
        r9 = r27;
        goto L35
    L29:
        r8 = r26;
        goto L31
    L25:
        r7 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
