package com.bytedance.android.shopping.card_list.common_params;

import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b,\b\u0086\b\u0018\u0000 U2\u00020\u0001:\u0001VBÉ\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bS\u0010TJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u0010\u000e\u001a\u00020\fHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bHÆ\u0003J\t\u0010\u0011\u001a\u00020\fHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003JË\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\fHÖ\u0001J\u0013\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003R\u001b\u00102\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00105\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00106\u001a\u0004\b7\u00108R\u001a\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\b:\u0010;R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010<\u001a\u0004\b=\u00101R$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010<\u001a\u0004\b>\u00101\"\u0004\b?\u0010@R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010<\u001a\u0004\bA\u00101R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\bB\u00101R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010C\u001a\u0004\bD\u0010ER\u001a\u0010\u001f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010F\u001a\u0004\bG\u0010HR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010C\u001a\u0004\bI\u0010ER\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010C\u001a\u0004\bJ\u0010ER\u001a\u0010\"\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010F\u001a\u0004\bK\u0010HR\u001a\u0010#\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\bL\u0010;R\u001a\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u00109\u001a\u0004\bM\u0010;R\u001a\u0010%\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\bN\u0010;R\u001a\u0010&\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u00109\u001a\u0004\bO\u0010;R\u001c\u0010'\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010P\u001a\u0004\bQ\u0010R¨\u0006W"}, d2 = {"Lcom/bytedance/android/shopping/card_list/common_params/CardListContainerConfig;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "component1", "", "component2", "", "component3", "component4", "component5", "component6", "", "", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "component16", "bizType", "queryDataInStarter", "pageName", "pageType", "showEventName", "clickEventName", "uplinkCodesNeedReload", "cacheValidDuration", "bottomPlaceholderEnableScenes", "skipExplicitLoadingTriggerList", "gulPreloadThreshold", "needLoadGUL", "needSetGradientView", "needCacheManager", "needPullRefresh", "pageInfo", "copy", "toString", "hashCode", "", "other", "equals", "standardShowEventName$delegate", "Lkotlin/Lazy;", "getStandardShowEventName", "()Ljava/lang/String;", "standardShowEventName", "standardClickEventName$delegate", "getStandardClickEventName", "standardClickEventName", "Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "getBizType", "()Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "Z", "getQueryDataInStarter", "()Z", "Ljava/lang/String;", "getPageName", "getPageType", "setPageType", "(Ljava/lang/String;)V", "getShowEventName", "getClickEventName", "Ljava/util/List;", "getUplinkCodesNeedReload", "()Ljava/util/List;", "I", "getCacheValidDuration", "()I", "getBottomPlaceholderEnableScenes", "getSkipExplicitLoadingTriggerList", "getGulPreloadThreshold", "getNeedLoadGUL", "getNeedSetGradientView", "getNeedCacheManager", "getNeedPullRefresh", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "getPageInfo", "()Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "<init>", "(Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;Ljava/util/List;IZZZZLcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListContainerConfig implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("biz_type")
    private final LauncherBizType bizType;

    @SerializedName("bottom_placeholder_enable_scenes")
    private final List<String> bottomPlaceholderEnableScenes;

    @SerializedName("cache_valid_duration")
    private final int cacheValidDuration;

    @SerializedName("standard_click_event_name")
    private final String clickEventName;

    @SerializedName("gul_preload_threshold")
    private final int gulPreloadThreshold;

    @SerializedName("need_cache_manager")
    private final boolean needCacheManager;

    @SerializedName("need_load_gul")
    private final boolean needLoadGUL;

    @SerializedName("need_pull_refresh")
    private final boolean needPullRefresh;

    @SerializedName("need_set_gradient_view")
    private final boolean needSetGradientView;

    @SerializedName("page_info")
    private final YataPageInfo pageInfo;

    @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
    private final String pageName;

    @SerializedName("page_type")
    private String pageType;

    @SerializedName("query_data_in_starter")
    private final boolean queryDataInStarter;

    @SerializedName("standard_show_event_name")
    private final String showEventName;

    @SerializedName("skip_explicit_loading_trigger_list")
    private final List<String> skipExplicitLoadingTriggerList;
    private final Lazy standardClickEventName$delegate;
    private final Lazy standardShowEventName$delegate;

    @SerializedName("uplink_codes_need_reload")
    private final List<Integer> uplinkCodesNeedReload;

    public static final class a {
        public a() {
        }

        public static CardListContainerConfig a(Map r27) {
            Intrinsics.checkNotNullParameter(r27, "pageConfig");
            Object r3 = null;
            if (CardListExtentionsKt.c(r27, "need_frontier", false) == false) goto L5;
            YataPageInfo r26 = new YataPageInfo(true, false, null, 6, null);
        L6:
            int r1 = CardListExtentionsKt.d(r27, "biz_type", 0);
            LauncherBizType[] r4 = LauncherBizType.values();
            int r5 = r4.length;
            int r6 = 0;
        L8:
            if (r6 >= r5) goto L16;
            LauncherBizType r8 = r4[r6];
            if (r8.ordinal() != r1) goto L12;
            boolean r9 = true;
        L13:
            if (r9 == true) goto L14;
            r6 = r6 + 1;
            goto L8
        L14:
            LauncherBizType r11 = r8;
        L17:
            if (r11 == null) goto L29;
            boolean r12 = CardListExtentionsKt.c(r27, "query_data_in_starter", false);
            String r13 = CardListExtentionsKt.f(r27, PdpOpenThirdParam.KEY_PAGE_NAME, "");
            String r14 = CardListExtentionsKt.f(r27, "page_type", "");
            String r15 = CardListExtentionsKt.f(r27, "standard_show_event_name", "");
            String r16 = CardListExtentionsKt.f(r27, "standard_click_event_name", "");
            List r2 = CollectionsKt.emptyList();
            Intrinsics.checkNotNullParameter(r27, "$this$getIntList");
            Intrinsics.checkNotNullParameter("uplink_codes_need_reload", "key");
            Intrinsics.checkNotNullParameter(r2, "default");
            Object r7 = r27.get("uplink_codes_need_reload");
            if ((r7 instanceof List) == false) goto L22;
            r3 = r7;
        L22:
            List r10 = (List) r3;
            if (r10 != null) goto L25;
            List r17 = r2;
        L27:
            return new CardListContainerConfig(r11, r12, r13, r14, r15, r16, r17, CardListExtentionsKt.d(r27, "cache_valid_duration", 0), CardListExtentionsKt.g(r27, "bottom_placeholder_enable_scenes"), CardListExtentionsKt.g(r27, "skip_explicit_loading_trigger_list"), CardListExtentionsKt.d(r27, "gul_preload_threshold", 3), CardListExtentionsKt.c(r27, "need_load_gul", true), CardListExtentionsKt.c(r27, "need_set_gradient_view", false), CardListExtentionsKt.c(r27, "need_cache_manager", false), CardListExtentionsKt.c(r27, "need_pull_refresh", true), r26);
        L25:
            r17 = r10;
            goto L27
        L29:
            throw new IllegalArgumentException("Invalid enum value: " + r1);
        L12:
            r9 = false;
            goto L13
        L16:
            r11 = null;
            goto L17
        L5:
            r26 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public CardListContainerConfig() {
        this(null, false, null, null, null, null, null, 0, null, null, 0, false, false, false, false, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardListContainerConfig copy$default(CardListContainerConfig r17, LauncherBizType r18, boolean r19, String r20, String r21, String r22, String r23, List r24, int r25, List r26, List r27, int r28, boolean r29, boolean r30, boolean r31, boolean r32, YataPageInfo r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        LauncherBizType r2 = r17.bizType;
    L7:
        if ((r34 & 2) == 0) goto L9;
        boolean r3 = r17.queryDataInStarter;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.pageName;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = r17.pageType;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = r17.showEventName;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r7 = r17.clickEventName;
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r8 = r17.uplinkCodesNeedReload;
    L31:
        if ((r34 & 128) == 0) goto L33;
        int r9 = r17.cacheValidDuration;
    L35:
        if ((r34 & 256) == 0) goto L37;
        List r10 = r17.bottomPlaceholderEnableScenes;
    L39:
        if ((r34 & 512) == 0) goto L41;
        List r11 = r17.skipExplicitLoadingTriggerList;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        int r12 = r17.gulPreloadThreshold;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        boolean r13 = r17.needLoadGUL;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        boolean r14 = r17.needSetGradientView;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        boolean r15 = r17.needCacheManager;
    L58:
        boolean r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        boolean r16 = r17.needPullRefresh;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        YataPageInfo r1 = r17.pageInfo;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
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

    public final LauncherBizType component1() {
        return this.bizType;
    }

    public final List<String> component10() {
        return this.skipExplicitLoadingTriggerList;
    }

    public final int component11() {
        return this.gulPreloadThreshold;
    }

    public final boolean component12() {
        return this.needLoadGUL;
    }

    public final boolean component13() {
        return this.needSetGradientView;
    }

    public final boolean component14() {
        return this.needCacheManager;
    }

    public final boolean component15() {
        return this.needPullRefresh;
    }

    public final YataPageInfo component16() {
        return this.pageInfo;
    }

    public final boolean component2() {
        return this.queryDataInStarter;
    }

    public final String component3() {
        return this.pageName;
    }

    public final String component4() {
        return this.pageType;
    }

    public final String component5() {
        return this.showEventName;
    }

    public final String component6() {
        return this.clickEventName;
    }

    public final List<Integer> component7() {
        return this.uplinkCodesNeedReload;
    }

    public final int component8() {
        return this.cacheValidDuration;
    }

    public final List<String> component9() {
        return this.bottomPlaceholderEnableScenes;
    }

    public final CardListContainerConfig copy(LauncherBizType r20, boolean r21, String r22, String r23, String r24, String r25, List<Integer> r26, int r27, List<String> r28, List<String> r29, int r30, boolean r31, boolean r32, boolean r33, boolean r34, YataPageInfo r35) {
        Intrinsics.checkNotNullParameter(r20, "bizType");
        return new CardListContainerConfig(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CardListContainerConfig) == false) goto L38;
        CardListContainerConfig r4 = (CardListContainerConfig) r3;
        if (Intrinsics.areEqual(this.bizType, r4.bizType) == true) goto L8;
        return false;
    L8:
        if (this.queryDataInStarter == r4.queryDataInStarter) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageType, r4.pageType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showEventName, r4.showEventName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.clickEventName, r4.clickEventName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uplinkCodesNeedReload, r4.uplinkCodesNeedReload) == true) goto L20;
        return false;
    L20:
        if (this.cacheValidDuration == r4.cacheValidDuration) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bottomPlaceholderEnableScenes, r4.bottomPlaceholderEnableScenes) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.skipExplicitLoadingTriggerList, r4.skipExplicitLoadingTriggerList) == true) goto L26;
        return false;
    L26:
        if (this.gulPreloadThreshold == r4.gulPreloadThreshold) goto L28;
        return false;
    L28:
        if (this.needLoadGUL == r4.needLoadGUL) goto L30;
        return false;
    L30:
        if (this.needSetGradientView == r4.needSetGradientView) goto L32;
        return false;
    L32:
        if (this.needCacheManager == r4.needCacheManager) goto L34;
        return false;
    L34:
        if (this.needPullRefresh == r4.needPullRefresh) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pageInfo, r4.pageInfo) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public final String getStandardClickEventName() {
        return (String) this.standardClickEventName$delegate.getValue();
    }

    public final String getStandardShowEventName() {
        return (String) this.standardShowEventName$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        LauncherBizType r0 = this.bizType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.queryDataInStarter;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        String r8 = this.pageName;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        String r11 = this.pageType;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r10 + r12) * 31;
        String r14 = this.showEventName;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.clickEventName;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        List<Integer> r20 = this.uplinkCodesNeedReload;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r22 = (((r19 + r21) * 31) + this.cacheValidDuration) * 31;
        List<String> r23 = this.bottomPlaceholderEnableScenes;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        List<String> r26 = this.skipExplicitLoadingTriggerList;
        if (r26 == null) goto L36;
        int r27 = r26.hashCode();
    L37:
        int r28 = (((r25 + r27) * 31) + this.gulPreloadThreshold) * 31;
        boolean r29 = this.needLoadGUL;
        ?? r30 = r29;
        if (r29 == false) goto L40;
        r30 = 1;
    L40:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.needSetGradientView;
        ?? r33 = r32;
        if (r32 == false) goto L43;
        r33 = 1;
    L43:
        int r34 = (r31 + r33) * 31;
        boolean r35 = this.needCacheManager;
        ?? r36 = r35;
        if (r35 == false) goto L46;
        r36 = 1;
    L46:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.needPullRefresh;
        if (r38 == true) goto L50;
        r5 = r38;
    L50:
        int r39 = (r37 + r5) * 31;
        YataPageInfo r40 = this.pageInfo;
        if (r40 == null) goto L54;
        r1 = r40.hashCode();
    L54:
        return r39 + r1;
    L36:
        r27 = 0;
        goto L37
    L32:
        r24 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CardListContainerConfig(bizType=" + this.bizType + ", queryDataInStarter=" + this.queryDataInStarter + ", pageName=" + this.pageName + ", pageType=" + this.pageType + ", showEventName=" + this.showEventName + ", clickEventName=" + this.clickEventName + ", uplinkCodesNeedReload=" + this.uplinkCodesNeedReload + ", cacheValidDuration=" + this.cacheValidDuration + ", bottomPlaceholderEnableScenes=" + this.bottomPlaceholderEnableScenes + ", skipExplicitLoadingTriggerList=" + this.skipExplicitLoadingTriggerList + ", gulPreloadThreshold=" + this.gulPreloadThreshold + ", needLoadGUL=" + this.needLoadGUL + ", needSetGradientView=" + this.needSetGradientView + ", needCacheManager=" + this.needCacheManager + ", needPullRefresh=" + this.needPullRefresh + ", pageInfo=" + this.pageInfo + ")";
    }

    public final LauncherBizType getBizType() {
        return this.bizType;
    }

    public final List<String> getBottomPlaceholderEnableScenes() {
        return this.bottomPlaceholderEnableScenes;
    }

    public final int getCacheValidDuration() {
        return this.cacheValidDuration;
    }

    public final String getClickEventName() {
        return this.clickEventName;
    }

    public final int getGulPreloadThreshold() {
        return this.gulPreloadThreshold;
    }

    public final boolean getNeedCacheManager() {
        return this.needCacheManager;
    }

    public final boolean getNeedLoadGUL() {
        return this.needLoadGUL;
    }

    public final boolean getNeedPullRefresh() {
        return this.needPullRefresh;
    }

    public final boolean getNeedSetGradientView() {
        return this.needSetGradientView;
    }

    public final YataPageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final boolean getQueryDataInStarter() {
        return this.queryDataInStarter;
    }

    public final String getShowEventName() {
        return this.showEventName;
    }

    public final List<String> getSkipExplicitLoadingTriggerList() {
        return this.skipExplicitLoadingTriggerList;
    }

    public final List<Integer> getUplinkCodesNeedReload() {
        return this.uplinkCodesNeedReload;
    }

    public final void setPageType(String r1) {
        this.pageType = r1;
    }

    public CardListContainerConfig(LauncherBizType r4, boolean r5, String r6, String r7, String r8, String r9, List<Integer> r10, int r11, List<String> r12, List<String> r13, int r14, boolean r15, boolean r16, boolean r17, boolean r18, YataPageInfo r19) {
        Intrinsics.checkNotNullParameter(r4, "bizType");
        this.bizType = r4;
        this.queryDataInStarter = r5;
        this.pageName = r6;
        this.pageType = r7;
        this.showEventName = r8;
        this.clickEventName = r9;
        this.uplinkCodesNeedReload = r10;
        this.cacheValidDuration = r11;
        this.bottomPlaceholderEnableScenes = r12;
        this.skipExplicitLoadingTriggerList = r13;
        this.gulPreloadThreshold = r14;
        this.needLoadGUL = r15;
        this.needSetGradientView = r16;
        this.needCacheManager = r17;
        this.needPullRefresh = r18;
        this.pageInfo = r19;
        this.standardShowEventName$delegate = LazyKt.lazy(new CardListContainerConfig$standardShowEventName$2(this));
        this.standardClickEventName$delegate = LazyKt.lazy(new CardListContainerConfig$standardClickEventName$2(this));
    }

    public /* synthetic */ CardListContainerConfig(LauncherBizType r18, boolean r19, String r20, String r21, String r22, String r23, List r24, int r25, List r26, List r27, int r28, boolean r29, boolean r30, boolean r31, boolean r32, YataPageInfo r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        LauncherBizType r1 = LauncherBizType.NONE;
    L7:
        if ((r34 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r9 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        int r10 = 0;
    L35:
        if ((r34 & 256) == 0) goto L37;
        List r11 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        List r12 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        int r13 = 3;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        boolean r14 = true;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        boolean r3 = false;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        boolean r5 = false;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        boolean r15 = true;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        YataPageInfo r0 = null;
    L66:
        this(r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r3, r5, r15, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r15 = r32;
        goto L63
    L57:
        r5 = r31;
        goto L59
    L53:
        r3 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r2 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
