package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018JR\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "Ljava/io/Serializable;", "displayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "enableLongPressMenu", "", "enableMultiSelect", "disableInternalFolderFallback", "multiSelectEnabledTabs", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "recentFilterTabType", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZZLjava/util/Set;Ljava/lang/Integer;)V", "getDisplayMode", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "getEnableLongPressMenu", "()Z", "getEnableMultiSelect", "getDisableInternalFolderFallback", "getMultiSelectEnabledTabs", "()Ljava/util/Set;", "getRecentFilterTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "writeReplace", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZZLjava/util/Set;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "equals", "other", "hashCode", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeListConfig implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Set<OfficeSpaceTab> f235450a;
    private final boolean disableInternalFolderFallback;
    private final OfficeListDisplayMode displayMode;
    private final boolean enableLongPressMenu;
    private final boolean enableMultiSelect;
    private final Integer recentFilterTabType;

    public OfficeListConfig() {
        this(null, false, false, false, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeListConfig copy$default(OfficeListConfig r100, OfficeListDisplayMode r101, boolean r102, boolean r103, boolean r104, Set r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.displayMode;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.enableLongPressMenu;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.enableMultiSelect;
    L11:
        boolean r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.disableInternalFolderFallback;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.f235450a;
    L17:
        Set r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.recentFilterTabType;
    L20:
        OfficeListDisplayMode r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final OfficeListDisplayMode component1() {
        return this.displayMode;
    }

    public final boolean component2() {
        return this.enableLongPressMenu;
    }

    public final boolean component3() {
        return this.enableMultiSelect;
    }

    public final boolean component4() {
        return this.disableInternalFolderFallback;
    }

    public final Set<OfficeSpaceTab> component5() {
        return this.f235450a;
    }

    public final Integer component6() {
        return this.recentFilterTabType;
    }

    public final OfficeListConfig copy(OfficeListDisplayMode r100, boolean r110, boolean r111, boolean r112, Set<? extends OfficeSpaceTab> r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r100, "displayMode");
        Intrinsics.checkNotNullParameter(r113, "multiSelectEnabledTabs");
        return new OfficeListConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeListConfig) == true) goto L8;
        return false;
    L8:
        OfficeListConfig r101 = (OfficeListConfig) r100;
        if (this.displayMode == r101.displayMode) goto L12;
        return false;
    L12:
        if (this.enableLongPressMenu == r101.enableLongPressMenu) goto L15;
        return false;
    L15:
        if (this.enableMultiSelect == r101.enableMultiSelect) goto L18;
        return false;
    L18:
        if (this.disableInternalFolderFallback == r101.disableInternalFolderFallback) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f235450a, r101.f235450a) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recentFilterTabType, r101.recentFilterTabType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = this.displayMode.hashCode() * 31;
        int r101 = 1231;
        if (this.enableLongPressMenu == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.enableMultiSelect == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.disableInternalFolderFallback == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (((r105 + r101) * 31) + this.f235450a.hashCode()) * 31;
        Integer r107 = this.recentFilterTabType;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return r106 + r108;
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeListConfig(displayMode=" + this.displayMode + ", enableLongPressMenu=" + this.enableLongPressMenu + ", enableMultiSelect=" + this.enableMultiSelect + ", disableInternalFolderFallback=" + this.disableInternalFolderFallback + ", multiSelectEnabledTabs=" + this.f235450a + ", recentFilterTabType=" + this.recentFilterTabType + ')';
    }

    private final Object writeReplace() {
        return new OfficeListConfigSerializedForm(this.displayMode, this.enableLongPressMenu, this.enableMultiSelect, this.disableInternalFolderFallback, f.a(this.f235450a), this.recentFilterTabType);
    }

    public final boolean getDisableInternalFolderFallback() {
        return this.disableInternalFolderFallback;
    }

    public final OfficeListDisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public final boolean getEnableLongPressMenu() {
        return this.enableLongPressMenu;
    }

    public final boolean getEnableMultiSelect() {
        return this.enableMultiSelect;
    }

    public final Set<OfficeSpaceTab> getMultiSelectEnabledTabs() {
        return this.f235450a;
    }

    public final Integer getRecentFilterTabType() {
        return this.recentFilterTabType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeListConfig(OfficeListDisplayMode r100, boolean r101, boolean r102, boolean r103, Set<? extends OfficeSpaceTab> r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "displayMode");
        Intrinsics.checkNotNullParameter(r104, "multiSelectEnabledTabs");
        this.displayMode = r100;
        this.enableLongPressMenu = r101;
        this.enableMultiSelect = r102;
        this.disableInternalFolderFallback = r103;
        this.f235450a = r104;
        this.recentFilterTabType = r105;
    }

    public /* synthetic */ OfficeListConfig(OfficeListDisplayMode r100, boolean r101, boolean r102, boolean r103, Set r104, Integer r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = OfficeListDisplayMode.FLOW;
    L6:
        if ((r111 & 2) == 0) goto L8;
        boolean r113 = true;
    L10:
        if ((r111 & 4) == 0) goto L12;
        boolean r105 = false;
    L14:
        if ((r111 & 8) == 0) goto L16;
        boolean r106 = false;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r104 = SetsKt.setOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE});
    L20:
        Set r107 = r104;
        if ((r111 & 32) == 0) goto L23;
        r110 = null;
    L23:
        this(r100, r113, r105, r106, r107, r110);
        return;
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r113 = r101;
        goto L10
    }
}
