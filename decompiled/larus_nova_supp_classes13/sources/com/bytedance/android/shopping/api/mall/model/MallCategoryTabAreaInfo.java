package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "", "mallCategoryTabArea", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;", "tabPanelConfig", "Lcom/bytedance/android/shopping/api/mall/model/TabPanelConfig;", "tabUIConfig", "Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;", "(Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;Lcom/bytedance/android/shopping/api/mall/model/TabPanelConfig;Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;)V", "getMallCategoryTabArea", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;", "getTabPanelConfig", "()Lcom/bytedance/android/shopping/api/mall/model/TabPanelConfig;", "getTabUIConfig", "()Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTabAreaInfo {

    @SerializedName("mall_category_tab_area")
    private final MallCategoryTabArea mallCategoryTabArea;

    @SerializedName("tab_panel_config")
    private final TabPanelConfig tabPanelConfig;

    @SerializedName("ui_config")
    private final TabUIConfig tabUIConfig;

    public MallCategoryTabAreaInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MallCategoryTabAreaInfo copy$default(MallCategoryTabAreaInfo r0, MallCategoryTabArea r1, TabPanelConfig r2, TabUIConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.mallCategoryTabArea;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.tabPanelConfig;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.tabUIConfig;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final MallCategoryTabArea component1() {
        return this.mallCategoryTabArea;
    }

    public final TabPanelConfig component2() {
        return this.tabPanelConfig;
    }

    public final TabUIConfig component3() {
        return this.tabUIConfig;
    }

    public final MallCategoryTabAreaInfo copy(MallCategoryTabArea r2, TabPanelConfig r3, TabUIConfig r4) {
        return new MallCategoryTabAreaInfo(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MallCategoryTabAreaInfo) == false) goto L12;
        MallCategoryTabAreaInfo r4 = (MallCategoryTabAreaInfo) r3;
        if (Intrinsics.areEqual(this.mallCategoryTabArea, r4.mallCategoryTabArea) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabPanelConfig, r4.tabPanelConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabUIConfig, r4.tabUIConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        MallCategoryTabArea r0 = this.mallCategoryTabArea;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TabPanelConfig r4 = this.tabPanelConfig;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TabUIConfig r7 = this.tabUIConfig;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "MallCategoryTabAreaInfo(mallCategoryTabArea=" + this.mallCategoryTabArea + ", tabPanelConfig=" + this.tabPanelConfig + ", tabUIConfig=" + this.tabUIConfig + ")";
    }

    public final MallCategoryTabArea getMallCategoryTabArea() {
        return this.mallCategoryTabArea;
    }

    public final TabPanelConfig getTabPanelConfig() {
        return this.tabPanelConfig;
    }

    public final TabUIConfig getTabUIConfig() {
        return this.tabUIConfig;
    }

    public MallCategoryTabAreaInfo(MallCategoryTabArea r1, TabPanelConfig r2, TabUIConfig r3) {
        this.mallCategoryTabArea = r1;
        this.tabPanelConfig = r2;
        this.tabUIConfig = r3;
    }

    public /* synthetic */ MallCategoryTabAreaInfo(MallCategoryTabArea r2, TabPanelConfig r3, TabUIConfig r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
