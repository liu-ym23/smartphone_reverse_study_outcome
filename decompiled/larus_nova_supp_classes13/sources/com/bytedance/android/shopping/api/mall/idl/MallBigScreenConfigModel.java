package com.bytedance.android.shopping.api.mall.idl;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003JC\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/idl/MallBigScreenConfigModel;", "", "enableWidescreenStylePageName", "", "", "customFavoriteColumnExcludeTabId", "", "enableSplitScreenPageName", "enableSplitScreenSupplementedVisibility", "", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Z)V", "getCustomFavoriteColumnExcludeTabId", "()Ljava/util/Set;", "getEnableSplitScreenPageName", "getEnableSplitScreenSupplementedVisibility", "()Z", "getEnableWidescreenStylePageName", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallBigScreenConfigModel {

    @SerializedName("custom_favorite_column_exclude_tab_id")
    private final Set<Integer> customFavoriteColumnExcludeTabId;

    @SerializedName("enable_split_screen_page_name")
    private final Set<String> enableSplitScreenPageName;

    @SerializedName("enable_split_screen_supplemented_visibility")
    private final boolean enableSplitScreenSupplementedVisibility;

    @SerializedName("enable_widescreen_style_page_name")
    private final Set<String> enableWidescreenStylePageName;

    public MallBigScreenConfigModel() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallBigScreenConfigModel copy$default(MallBigScreenConfigModel r0, Set r1, Set r2, Set r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.enableWidescreenStylePageName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.customFavoriteColumnExcludeTabId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.enableSplitScreenPageName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.enableSplitScreenSupplementedVisibility;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Set<String> component1() {
        return this.enableWidescreenStylePageName;
    }

    public final Set<Integer> component2() {
        return this.customFavoriteColumnExcludeTabId;
    }

    public final Set<String> component3() {
        return this.enableSplitScreenPageName;
    }

    public final boolean component4() {
        return this.enableSplitScreenSupplementedVisibility;
    }

    public final MallBigScreenConfigModel copy(Set<String> r2, Set<Integer> r3, Set<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "enableWidescreenStylePageName");
        Intrinsics.checkNotNullParameter(r3, "customFavoriteColumnExcludeTabId");
        Intrinsics.checkNotNullParameter(r4, "enableSplitScreenPageName");
        return new MallBigScreenConfigModel(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MallBigScreenConfigModel) == false) goto L14;
        MallBigScreenConfigModel r4 = (MallBigScreenConfigModel) r3;
        if (Intrinsics.areEqual(this.enableWidescreenStylePageName, r4.enableWidescreenStylePageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.customFavoriteColumnExcludeTabId, r4.customFavoriteColumnExcludeTabId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enableSplitScreenPageName, r4.enableSplitScreenPageName) == true) goto L12;
        return false;
    L12:
        if (this.enableSplitScreenSupplementedVisibility == r4.enableSplitScreenSupplementedVisibility) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Set<String> r0 = this.enableWidescreenStylePageName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Set<Integer> r4 = this.customFavoriteColumnExcludeTabId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Set<String> r7 = this.enableSplitScreenPageName;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.enableSplitScreenSupplementedVisibility;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "MallBigScreenConfigModel(enableWidescreenStylePageName=" + this.enableWidescreenStylePageName + ", customFavoriteColumnExcludeTabId=" + this.customFavoriteColumnExcludeTabId + ", enableSplitScreenPageName=" + this.enableSplitScreenPageName + ", enableSplitScreenSupplementedVisibility=" + this.enableSplitScreenSupplementedVisibility + ")";
    }

    public final Set<Integer> getCustomFavoriteColumnExcludeTabId() {
        return this.customFavoriteColumnExcludeTabId;
    }

    public final Set<String> getEnableSplitScreenPageName() {
        return this.enableSplitScreenPageName;
    }

    public final boolean getEnableSplitScreenSupplementedVisibility() {
        return this.enableSplitScreenSupplementedVisibility;
    }

    public final Set<String> getEnableWidescreenStylePageName() {
        return this.enableWidescreenStylePageName;
    }

    public MallBigScreenConfigModel(Set<String> r2, Set<Integer> r3, Set<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "enableWidescreenStylePageName");
        Intrinsics.checkNotNullParameter(r3, "customFavoriteColumnExcludeTabId");
        Intrinsics.checkNotNullParameter(r4, "enableSplitScreenPageName");
        this.enableWidescreenStylePageName = r2;
        this.customFavoriteColumnExcludeTabId = r3;
        this.enableSplitScreenPageName = r4;
        this.enableSplitScreenSupplementedVisibility = r5;
    }

    public /* synthetic */ MallBigScreenConfigModel(Set r3, Set r4, Set r5, boolean r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = SetsKt.emptySet();
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = SetsKt.setOf(new Integer[]{202, 301});
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = SetsKt.emptySet();
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = true;
    L14:
        this(r3, r4, r5, r6);
    }
}
