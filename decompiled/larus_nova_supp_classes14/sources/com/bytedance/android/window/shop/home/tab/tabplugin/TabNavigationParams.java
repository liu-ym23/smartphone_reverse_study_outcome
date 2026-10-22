package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.window.shop.repository.api.ForceInsertInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001+BS\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b(\u0010)J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003Jh\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b'\u0010\u001e¨\u0006,"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "", "component1", "", "component2", "()Ljava/lang/Long;", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "component6", "forceInsertInfo", "sortType", "categoryId", "subCategoryId", "targetTabType", "childCategoryVO", "copy", "(Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/Long;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "toString", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "getForceInsertInfo", "()Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "Ljava/lang/Long;", "getSortType", "getCategoryId", "Ljava/lang/String;", "getSubCategoryId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getTargetTabType", "getChildCategoryVO", "<init>", "(Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/Long;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabNavigationParams implements Serializable {
    public static final a Companion = null;
    private final WindowNavigationParam<String> categoryId;
    private final WindowNavigationParam<String> childCategoryVO;
    private final WindowNavigationParam<String> forceInsertInfo;
    private final Long sortType;
    private final String subCategoryId;
    private final Integer targetTabType;

    public static final class a {
        public a() {
        }

        public static TabNavigationParams a(JSONObject r13) {
            Intrinsics.checkNotNullParameter(r13, "params");
            Long r0 = Long.valueOf(r13.optLong("sort_type", Long.MIN_VALUE));
            if (r0.longValue() == Long.MIN_VALUE) goto L5;
            boolean r1 = true;
        L6:
            String r2 = null;
            JSONObject r3 = null;
            if (r1 == false) goto L9;
            Long r8 = r0;
        L10:
            String r4 = r13.optString("category_id", "");
            if ((!Intrinsics.areEqual(r4, "")) == true) goto L14;
            r4 = null;
        L14:
            int r5 = r13.optInt("tab_select", 100);
            String r6 = r13.optString("target_subcategory_id", "");
            if ((!Intrinsics.areEqual(r6, "")) == false) goto L17;
            String r10 = r6;
        L18:
            String r14 = r13.optString("can_use_products", "");
            if (Intrinsics.areEqual(r14, "") == false) goto L29;
        L27:
            WindowNavigationParam.Companion.getClass();
            return new TabNavigationParams(WindowNavigationParam.a.c(r2), r8, WindowNavigationParam.a.c(r4), r10, Integer.valueOf(r5), WindowNavigationParam.a.b());
        L29:
            r3 = new JSONObject(r14);     // Catch: Exception -> L23
        L24:
            if (r3 != null) goto L26;
            ForceInsertInfo r7 = new ForceInsertInfo();
            r7.setPromotionIds(r14);
            r7.setScene(1);
            r14 = r7.serializeAsJson();
        L26:
            r2 = r14;
            goto L27
        L17:
            r10 = null;
            goto L18
        L9:
            r8 = null;
            goto L10
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabNavigationParams copy$default(TabNavigationParams r4, WindowNavigationParam r5, Long r6, WindowNavigationParam r7, String r8, Integer r9, WindowNavigationParam r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.forceInsertInfo;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.sortType;
    L8:
        Long r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.categoryId;
    L11:
        WindowNavigationParam r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.subCategoryId;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.targetTabType;
    L17:
        Integer r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.childCategoryVO;
    L20:
        WindowNavigationParam r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final WindowNavigationParam<String> component1() {
        return this.forceInsertInfo;
    }

    public final Long component2() {
        return this.sortType;
    }

    public final WindowNavigationParam<String> component3() {
        return this.categoryId;
    }

    public final String component4() {
        return this.subCategoryId;
    }

    public final Integer component5() {
        return this.targetTabType;
    }

    public final WindowNavigationParam<String> component6() {
        return this.childCategoryVO;
    }

    public final TabNavigationParams copy(WindowNavigationParam<String> r9, Long r10, WindowNavigationParam<String> r11, String r12, Integer r13, WindowNavigationParam<String> r14) {
        Intrinsics.checkNotNullParameter(r14, "childCategoryVO");
        return new TabNavigationParams(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TabNavigationParams) == false) goto L18;
        TabNavigationParams r4 = (TabNavigationParams) r3;
        if (Intrinsics.areEqual(this.forceInsertInfo, r4.forceInsertInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sortType, r4.sortType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.categoryId, r4.categoryId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subCategoryId, r4.subCategoryId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.targetTabType, r4.targetTabType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.childCategoryVO, r4.childCategoryVO) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        WindowNavigationParam<String> r0 = this.forceInsertInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.sortType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        WindowNavigationParam<String> r7 = this.categoryId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.subCategoryId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.targetTabType;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        WindowNavigationParam<String> r16 = this.childCategoryVO;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
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
        return "TabNavigationParams(forceInsertInfo=" + this.forceInsertInfo + ", sortType=" + this.sortType + ", categoryId=" + this.categoryId + ", subCategoryId=" + this.subCategoryId + ", targetTabType=" + this.targetTabType + ", childCategoryVO=" + this.childCategoryVO + ")";
    }

    static {
        Companion = new a();
    }

    public final WindowNavigationParam<String> getCategoryId() {
        return this.categoryId;
    }

    public final WindowNavigationParam<String> getChildCategoryVO() {
        return this.childCategoryVO;
    }

    public final WindowNavigationParam<String> getForceInsertInfo() {
        return this.forceInsertInfo;
    }

    public final Long getSortType() {
        return this.sortType;
    }

    public final String getSubCategoryId() {
        return this.subCategoryId;
    }

    public final Integer getTargetTabType() {
        return this.targetTabType;
    }

    public TabNavigationParams(WindowNavigationParam<String> r2, Long r3, WindowNavigationParam<String> r4, String r5, Integer r6, WindowNavigationParam<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "childCategoryVO");
        this.forceInsertInfo = r2;
        this.sortType = r3;
        this.categoryId = r4;
        this.subCategoryId = r5;
        this.targetTabType = r6;
        this.childCategoryVO = r7;
    }
}
