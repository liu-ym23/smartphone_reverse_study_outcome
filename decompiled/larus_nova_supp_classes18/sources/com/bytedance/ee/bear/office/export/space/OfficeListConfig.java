package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018JR\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "Ljava/io/Serializable;", "displayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "enableLongPressMenu", "", "enableMultiSelect", "disableInternalFolderFallback", "multiSelectEnabledTabs", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "recentFilterTabType", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZZLjava/util/Set;Ljava/lang/Integer;)V", "getDisplayMode", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "getEnableLongPressMenu", "()Z", "getEnableMultiSelect", "getDisableInternalFolderFallback", "getMultiSelectEnabledTabs", "()Ljava/util/Set;", "getRecentFilterTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "writeReplace", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;ZZZLjava/util/Set;Ljava/lang/Integer;)Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "equals", "other", "hashCode", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeListConfig implements Serializable {
    public final transient Set<OfficeSpaceTab> a;
    private final boolean disableInternalFolderFallback;
    private final OfficeListDisplayMode displayMode;
    private final boolean enableLongPressMenu;
    private final boolean enableMultiSelect;
    private final Integer recentFilterTabType;

    public OfficeListConfig() {
        this(null, false, false, false, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeListConfig copy$default(OfficeListConfig r4, OfficeListDisplayMode r5, boolean r6, boolean r7, boolean r8, Set r9, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.displayMode;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.enableLongPressMenu;
    L8:
        boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.enableMultiSelect;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.disableInternalFolderFallback;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.a;
    L17:
        Set r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.recentFilterTabType;
    L20:
        OfficeListDisplayMode r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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
        return this.a;
    }

    public final Integer component6() {
        return this.recentFilterTabType;
    }

    public final OfficeListConfig copy(OfficeListDisplayMode r9, boolean r10, boolean r11, boolean r12, Set<? extends OfficeSpaceTab> r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r9, "displayMode");
        Intrinsics.checkNotNullParameter(r13, "multiSelectEnabledTabs");
        return new OfficeListConfig(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeListConfig) == true) goto L8;
        return false;
    L8:
        OfficeListConfig r6 = (OfficeListConfig) r5;
        if (this.displayMode == r6.displayMode) goto L12;
        return false;
    L12:
        if (this.enableLongPressMenu == r6.enableLongPressMenu) goto L15;
        return false;
    L15:
        if (this.enableMultiSelect == r6.enableMultiSelect) goto L18;
        return false;
    L18:
        if (this.disableInternalFolderFallback == r6.disableInternalFolderFallback) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recentFilterTabType, r6.recentFilterTabType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.displayMode.hashCode() * 31;
        int r2 = 1231;
        if (this.enableLongPressMenu == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.enableMultiSelect == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.disableInternalFolderFallback == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (((r5 + r2) * 31) + this.a.hashCode()) * 31;
        Integer r7 = this.recentFilterTabType;
        if (r7 != null) goto L17;
        int r8 = 0;
    L19:
        return r6 + r8;
    L17:
        r8 = r7.hashCode();
        goto L19
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeListConfig(displayMode=" + this.displayMode + ", enableLongPressMenu=" + this.enableLongPressMenu + ", enableMultiSelect=" + this.enableMultiSelect + ", disableInternalFolderFallback=" + this.disableInternalFolderFallback + ", multiSelectEnabledTabs=" + this.a + ", recentFilterTabType=" + this.recentFilterTabType + ')';
    }

    private final Object writeReplace() {
        return new OfficeListConfigSerializedForm(this.displayMode, this.enableLongPressMenu, this.enableMultiSelect, this.disableInternalFolderFallback, f.a(this.a), this.recentFilterTabType);
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
        return this.a;
    }

    public final Integer getRecentFilterTabType() {
        return this.recentFilterTabType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeListConfig(OfficeListDisplayMode r2, boolean r3, boolean r4, boolean r5, Set<? extends OfficeSpaceTab> r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r2, "displayMode");
        Intrinsics.checkNotNullParameter(r6, "multiSelectEnabledTabs");
        this.displayMode = r2;
        this.enableLongPressMenu = r3;
        this.enableMultiSelect = r4;
        this.disableInternalFolderFallback = r5;
        this.a = r6;
        this.recentFilterTabType = r7;
    }

    public /* synthetic */ OfficeListConfig(OfficeListDisplayMode r5, boolean r6, boolean r7, boolean r8, Set r9, Integer r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = OfficeListDisplayMode.FLOW;
    L6:
        if ((r11 & 2) == 0) goto L8;
        boolean r13 = true;
    L10:
        if ((r11 & 4) == 0) goto L12;
        boolean r2 = false;
    L14:
        if ((r11 & 8) == 0) goto L16;
        boolean r3 = false;
    L18:
        if ((r11 & 16) == 0) goto L20;
        r9 = SetsKt.setOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE});
    L20:
        Set r0 = r9;
        if ((r11 & 32) == 0) goto L23;
        r10 = null;
    L23:
        this(r5, r13, r2, r3, r0, r10);
        return;
    L16:
        r3 = r8;
        goto L18
    L12:
        r2 = r7;
        goto L14
    L8:
        r13 = r6;
        goto L10
    }
}
