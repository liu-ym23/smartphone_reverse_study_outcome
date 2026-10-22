package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J\\\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeListConfigSerializedForm;", "Ljava/io/Serializable;", "displayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "enableLongPressMenu", "", "enableMultiSelect", "disableInternalFolderFallback", "multiSelectEnabledTabs", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "Lkotlin/collections/ArrayList;", "recentFilterTabType", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZZLjava/util/ArrayList;Ljava/lang/Integer;)V", "getDisplayMode", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "getEnableLongPressMenu", "()Z", "getEnableMultiSelect", "getDisableInternalFolderFallback", "getMultiSelectEnabledTabs", "()Ljava/util/ArrayList;", "getRecentFilterTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "readResolve", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZZLjava/util/ArrayList;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/office/export/space/OfficeListConfigSerializedForm;", "equals", "other", "hashCode", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class OfficeListConfigSerializedForm implements Serializable {
    private final boolean disableInternalFolderFallback;
    private final OfficeListDisplayMode displayMode;
    private final boolean enableLongPressMenu;
    private final boolean enableMultiSelect;
    private final ArrayList<OfficeSpaceTab> multiSelectEnabledTabs;
    private final Integer recentFilterTabType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeListConfigSerializedForm copy$default(OfficeListConfigSerializedForm r100, OfficeListDisplayMode r101, boolean r102, boolean r103, boolean r104, ArrayList r105, Integer r110, int r111, Object r112) {
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
        r105 = r100.multiSelectEnabledTabs;
    L17:
        ArrayList r108 = r105;
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

    public final ArrayList<OfficeSpaceTab> component5() {
        return this.multiSelectEnabledTabs;
    }

    public final Integer component6() {
        return this.recentFilterTabType;
    }

    public final OfficeListConfigSerializedForm copy(OfficeListDisplayMode r100, boolean r110, boolean r111, boolean r112, ArrayList<OfficeSpaceTab> r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r100, "displayMode");
        Intrinsics.checkNotNullParameter(r113, "multiSelectEnabledTabs");
        return new OfficeListConfigSerializedForm(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeListConfigSerializedForm) == true) goto L8;
        return false;
    L8:
        OfficeListConfigSerializedForm r101 = (OfficeListConfigSerializedForm) r100;
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
        if (Intrinsics.areEqual(this.multiSelectEnabledTabs, r101.multiSelectEnabledTabs) == true) goto L24;
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
        int r106 = (((r105 + r101) * 31) + this.multiSelectEnabledTabs.hashCode()) * 31;
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
        return "OfficeListConfigSerializedForm(displayMode=" + this.displayMode + ", enableLongPressMenu=" + this.enableLongPressMenu + ", enableMultiSelect=" + this.enableMultiSelect + ", disableInternalFolderFallback=" + this.disableInternalFolderFallback + ", multiSelectEnabledTabs=" + this.multiSelectEnabledTabs + ", recentFilterTabType=" + this.recentFilterTabType + ')';
    }

    private final Object readResolve() {
        return new OfficeListConfig(this.displayMode, this.enableLongPressMenu, this.enableMultiSelect, this.disableInternalFolderFallback, new LinkedHashSet(this.multiSelectEnabledTabs), this.recentFilterTabType);
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

    public final ArrayList<OfficeSpaceTab> getMultiSelectEnabledTabs() {
        return this.multiSelectEnabledTabs;
    }

    public final Integer getRecentFilterTabType() {
        return this.recentFilterTabType;
    }

    public OfficeListConfigSerializedForm(OfficeListDisplayMode r100, boolean r101, boolean r102, boolean r103, ArrayList<OfficeSpaceTab> r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "displayMode");
        Intrinsics.checkNotNullParameter(r104, "multiSelectEnabledTabs");
        this.displayMode = r100;
        this.enableLongPressMenu = r101;
        this.enableMultiSelect = r102;
        this.disableInternalFolderFallback = r103;
        this.multiSelectEnabledTabs = r104;
        this.recentFilterTabType = r105;
    }
}
