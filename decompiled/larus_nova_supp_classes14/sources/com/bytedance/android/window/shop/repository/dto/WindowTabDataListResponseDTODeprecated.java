package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B©\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0002\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010;\u001a\u00020\u0006\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010C\u001a\u00020#\u0012\b\b\u0002\u0010E\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bN\u0010OJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001a\u0010$\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001bR\"\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010\u001bR\u001c\u00102\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016R\u001c\u00104\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016R\u001c\u00107\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010)\u001a\u0004\b<\u0010+R\u001c\u0010=\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\u0019\u001a\u0004\bB\u0010\u001bR\u001a\u0010C\u001a\u00020#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010%\u001a\u0004\bD\u0010'R\u001a\u0010E\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010)\u001a\u0004\bF\u0010+R\"\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010\u0019\u001a\u0004\bH\u0010\u001bR\"\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010\u0019\u001a\u0004\bK\u0010\u001bR\u001c\u0010L\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0014\u001a\u0004\bM\u0010\u0016¨\u0006P"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowTabDataListResponseDTODeprecated;", "Lcom/bytedance/android/window/shop/repository/compat/WindowTabInfoProvider;", "", "Lcom/bytedance/android/window/shop/repository/dto/p;", "categories", "subCategories", "", "getWindowStatusCode", "", "msg", "cardCount", "getTargetSelectCategoryId", "getTargetSelectSubCategoryId", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "getWindowLayoutType", "tabType", "Ljava/lang/Integer;", "getTabType", "()Ljava/lang/Integer;", "selectCategoryId", "Ljava/lang/String;", "getSelectCategoryId", "()Ljava/lang/String;", "Lcom/bytedance/android/window/shop/repository/dto/a;", "filterType", "Ljava/util/List;", "getFilterType", "()Ljava/util/List;", "Lcom/bytedance/android/window/shop/repository/dto/c;", "mixFullCards", "getMixFullCards", "categoryData", "getCategoryData", "globalMixFullCards", "getGlobalMixFullCards", "", "hasMore", "Z", "getHasMore", "()Z", "cursor", "I", "getCursor", "()I", "Lcom/bytedance/android/ec/window/base/repository/dto/q;", "sortType", "getSortType", "Lcom/bytedance/android/window/shop/repository/dto/i;", "tabs", "getTabs", "searchHint", "getSearchHint", "commonPassThrough", "getCommonPassThrough", "Lcom/bytedance/android/window/shop/repository/dto/v;", "extensionCardControl", "Lcom/bytedance/android/window/shop/repository/dto/v;", "getExtensionCardControl", "()Lcom/bytedance/android/window/shop/repository/dto/v;", "layout", "getLayout", "topCards", "Lcom/bytedance/android/window/shop/repository/dto/c;", "getTopCards", "()Lcom/bytedance/android/window/shop/repository/dto/c;", "category", "getCategory", "hideEmptyStatus", "getHideEmptyStatus", "stickyArea", "getStickyArea", "subCategorys", "getSubCategorys", "Lnq3/a;", "dynamicViews", "getDynamicViews", "selectSubCategory", "getSelectSubCategory", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/window/shop/repository/dto/v;ILcom/bytedance/android/window/shop/repository/dto/c;Ljava/util/List;ZILjava/util/List;Ljava/util/List;Ljava/lang/String;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabDataListResponseDTODeprecated extends WindowTabInfoProvider {

    @SerializedName("category_list")
    private final List<p> category;

    @SerializedName("category_data")
    private final String categoryData;

    @SerializedName("common_pass_through")
    private final String commonPassThrough;

    @SerializedName("cursor")
    private final int cursor;

    @SerializedName("dynamic_views")
    private final List<nq3.a> dynamicViews;

    @SerializedName("extension_card_control")
    private final v extensionCardControl;

    @SerializedName("filter_type")
    private final List<a> filterType;

    @SerializedName("global_mix_full_cards")
    private final List<c> globalMixFullCards;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("hide_empty_status")
    private final boolean hideEmptyStatus;

    @SerializedName("layout")
    private final int layout;

    @SerializedName("mix_full_cards")
    private final List<c> mixFullCards;

    @SerializedName("search_hint")
    private final String searchHint;

    @SerializedName("select_category")
    private final String selectCategoryId;

    @SerializedName("select_sub_category")
    private final String selectSubCategory;

    @SerializedName("sort_types")
    private final List<com.bytedance.android.ec.window.base.repository.dto.q> sortType;

    @SerializedName("ecom_window_goods_sticky_area")
    private final int stickyArea;

    @SerializedName("sub_category_list")
    private final List<p> subCategorys;

    @SerializedName("select_tab_type")
    private final Integer tabType;

    @SerializedName("tabs")
    private final List<i> tabs;

    @SerializedName("top_cards")
    private final c topCards;

    public WindowTabDataListResponseDTODeprecated() {
        this(null, null, null, null, null, null, false, 0, null, null, null, null, null, 0, null, null, false, 0, null, null, null, 2097151, null);
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public int cardCount() {
        List<c> r0 = this.mixFullCards;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public List<p> categories() {
        List<p> r0 = this.category;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public WindowLayoutType getWindowLayoutType() {
        WindowLayoutType.a r0 = WindowLayoutType.Companion;
        Integer r1 = Integer.valueOf(this.layout);
        r0.getClass();
        WindowLayoutType r2 = WindowLayoutType.a.b(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return WindowLayoutType.SINGLECOLUMN;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public List<p> subCategories() {
        List<p> r0 = this.subCategorys;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public int getWindowStatusCode() {
        return getStatusCode();
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String msg() {
        String r0 = getMessage();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final List<p> getCategory() {
        return this.category;
    }

    public final String getCategoryData() {
        return this.categoryData;
    }

    public final String getCommonPassThrough() {
        return this.commonPassThrough;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final List<nq3.a> getDynamicViews() {
        return this.dynamicViews;
    }

    public final v getExtensionCardControl() {
        return this.extensionCardControl;
    }

    public final List<a> getFilterType() {
        return this.filterType;
    }

    public final List<c> getGlobalMixFullCards() {
        return this.globalMixFullCards;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final boolean getHideEmptyStatus() {
        return this.hideEmptyStatus;
    }

    public final int getLayout() {
        return this.layout;
    }

    public final List<c> getMixFullCards() {
        return this.mixFullCards;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final String getSelectCategoryId() {
        return this.selectCategoryId;
    }

    public final String getSelectSubCategory() {
        return this.selectSubCategory;
    }

    public final List<com.bytedance.android.ec.window.base.repository.dto.q> getSortType() {
        return this.sortType;
    }

    public final int getStickyArea() {
        return this.stickyArea;
    }

    public final List<p> getSubCategorys() {
        return this.subCategorys;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final List<i> getTabs() {
        return this.tabs;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String getTargetSelectCategoryId() {
        return this.selectCategoryId;
    }

    @Override // com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider
    public String getTargetSelectSubCategoryId() {
        return this.selectSubCategory;
    }

    public final c getTopCards() {
        return this.topCards;
    }

    public WindowTabDataListResponseDTODeprecated(Integer r3, String r4, List<a> r5, List<c> r6, String r7, List<c> r8, boolean r9, int r10, List<com.bytedance.android.ec.window.base.repository.dto.q> r11, List<i> r12, String r13, String r14, v r15, int r16, c r17, List<p> r18, boolean r19, int r20, List<p> r21, List<nq3.a> r22, String r23) {
        this.tabType = r3;
        this.selectCategoryId = r4;
        this.filterType = r5;
        this.mixFullCards = r6;
        this.categoryData = r7;
        this.globalMixFullCards = r8;
        this.hasMore = r9;
        this.cursor = r10;
        this.sortType = r11;
        this.tabs = r12;
        this.searchHint = r13;
        this.commonPassThrough = r14;
        this.extensionCardControl = r15;
        this.layout = r16;
        this.topCards = r17;
        this.category = r18;
        this.hideEmptyStatus = r19;
        this.stickyArea = r20;
        this.subCategorys = r21;
        this.dynamicViews = r22;
        this.selectSubCategory = r23;
    }

    public /* synthetic */ WindowTabDataListResponseDTODeprecated(Integer r23, String r24, List r25, List r26, String r27, List r28, boolean r29, int r30, List r31, List r32, String r33, String r34, v r35, int r36, c r37, List r38, boolean r39, int r40, List r41, List r42, String r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r44 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r44 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r44 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r44 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r44 & 128) == 0) goto L33;
        int r10 = 0;
    L35:
        if ((r44 & 256) == 0) goto L37;
        List r11 = null;
    L39:
        if ((r44 & 512) == 0) goto L41;
        List r12 = null;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        String r14 = null;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        v r15 = null;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        int r2 = -1;
    L59:
        if ((r44 & 16384) == 0) goto L61;
        c r9 = null;
    L63:
        if ((r44 & 32768) == 0) goto L65;
        List r16 = null;
    L67:
        if ((r44 & 65536) == 0) goto L69;
        boolean r17 = false;
    L71:
        if ((r44 & 131072) == 0) goto L73;
        int r18 = 0;
    L75:
        if ((r44 & 262144) == 0) goto L77;
        List r19 = null;
    L79:
        if ((r44 & 524288) == 0) goto L81;
        List r20 = null;
    L83:
        if ((r44 & 1048576) == 0) goto L85;
        String r0 = null;
    L86:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r2, r9, r16, r17, r18, r19, r20, r0);
        return;
    L85:
        r0 = r43;
        goto L86
    L81:
        r20 = r42;
        goto L83
    L77:
        r19 = r41;
        goto L79
    L73:
        r18 = r40;
        goto L75
    L69:
        r17 = r39;
        goto L71
    L65:
        r16 = r38;
        goto L67
    L61:
        r9 = r37;
        goto L63
    L57:
        r2 = r36;
        goto L59
    L53:
        r15 = r35;
        goto L55
    L49:
        r14 = r34;
        goto L51
    L45:
        r13 = r33;
        goto L47
    L41:
        r12 = r32;
        goto L43
    L37:
        r11 = r31;
        goto L39
    L33:
        r10 = r30;
        goto L35
    L29:
        r8 = r29;
        goto L31
    L25:
        r7 = r28;
        goto L27
    L21:
        r6 = r27;
        goto L23
    L17:
        r5 = r26;
        goto L19
    L13:
        r4 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L7
    }
}
