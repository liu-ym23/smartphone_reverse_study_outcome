package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010 \u001a\u00020!H\u0002J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003Ja\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "Ljava/io/Serializable;", "initialTab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "enabledTabs", "", "showLeftMenu", "", "showSearch", "showMore", "headerConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "menuConfigJson", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Ljava/util/Set;ZZZLcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;Ljava/lang/String;)V", "getInitialTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getEnabledTabs", "()Ljava/util/Set;", "getShowLeftMenu", "()Z", "getShowSearch", "getShowMore", "getHeaderConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "getMenuConfigJson", "()Ljava/lang/String;", "writeReplace", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceConfig implements Serializable {
    public final transient Set<OfficeSpaceTab> a;
    private final OfficeSpaceHeaderConfig headerConfig;
    private final OfficeSpaceTab initialTab;
    private final OfficeListConfig listConfig;
    private final String menuConfigJson;
    private final boolean showLeftMenu;
    private final boolean showMore;
    private final boolean showSearch;

    public OfficeSpaceConfig() {
        this(null, null, false, false, false, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceConfig copy$default(OfficeSpaceConfig r9, OfficeSpaceTab r10, Set r11, boolean r12, boolean r13, boolean r14, OfficeSpaceHeaderConfig r15, OfficeListConfig r16, String r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        OfficeSpaceTab r2 = r9.initialTab;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Set r3 = r9.a;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r4 = r9.showLeftMenu;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.showSearch;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.showMore;
    L23:
        if ((r18 & 32) == 0) goto L25;
        OfficeSpaceHeaderConfig r7 = r9.headerConfig;
    L27:
        if ((r18 & 64) == 0) goto L29;
        OfficeListConfig r8 = r9.listConfig;
    L31:
        if ((r18 & 128) == 0) goto L33;
        String r1 = r9.menuConfigJson;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final OfficeSpaceTab component1() {
        return this.initialTab;
    }

    public final Set<OfficeSpaceTab> component2() {
        return this.a;
    }

    public final boolean component3() {
        return this.showLeftMenu;
    }

    public final boolean component4() {
        return this.showSearch;
    }

    public final boolean component5() {
        return this.showMore;
    }

    public final OfficeSpaceHeaderConfig component6() {
        return this.headerConfig;
    }

    public final OfficeListConfig component7() {
        return this.listConfig;
    }

    public final String component8() {
        return this.menuConfigJson;
    }

    public final OfficeSpaceConfig copy(OfficeSpaceTab r11, Set<? extends OfficeSpaceTab> r12, boolean r13, boolean r14, boolean r15, OfficeSpaceHeaderConfig r16, OfficeListConfig r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "initialTab");
        Intrinsics.checkNotNullParameter(r12, "enabledTabs");
        Intrinsics.checkNotNullParameter(r16, "headerConfig");
        Intrinsics.checkNotNullParameter(r17, "listConfig");
        return new OfficeSpaceConfig(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceConfig) == true) goto L8;
        return false;
    L8:
        OfficeSpaceConfig r6 = (OfficeSpaceConfig) r5;
        if (this.initialTab == r6.initialTab) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L15;
        return false;
    L15:
        if (this.showLeftMenu == r6.showLeftMenu) goto L18;
        return false;
    L18:
        if (this.showSearch == r6.showSearch) goto L21;
        return false;
    L21:
        if (this.showMore == r6.showMore) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headerConfig, r6.headerConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.listConfig, r6.listConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.menuConfigJson, r6.menuConfigJson) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.initialTab.hashCode() * 31) + this.a.hashCode()) * 31;
        int r2 = 1231;
        if (this.showLeftMenu == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.showSearch == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.showMore == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (((((r5 + r2) * 31) + this.headerConfig.hashCode()) * 31) + this.listConfig.hashCode()) * 31;
        String r7 = this.menuConfigJson;
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
        return "OfficeSpaceConfig(initialTab=" + this.initialTab + ", enabledTabs=" + this.a + ", showLeftMenu=" + this.showLeftMenu + ", showSearch=" + this.showSearch + ", showMore=" + this.showMore + ", headerConfig=" + this.headerConfig + ", listConfig=" + this.listConfig + ", menuConfigJson=" + this.menuConfigJson + ')';
    }

    private final Object writeReplace() {
        return new OfficeSpaceConfigSerializedForm(this.initialTab, f.a(this.a), this.showLeftMenu, this.showSearch, this.showMore, this.headerConfig, this.listConfig, this.menuConfigJson);
    }

    public final Set<OfficeSpaceTab> getEnabledTabs() {
        return this.a;
    }

    public final OfficeSpaceHeaderConfig getHeaderConfig() {
        return this.headerConfig;
    }

    public final OfficeSpaceTab getInitialTab() {
        return this.initialTab;
    }

    public final OfficeListConfig getListConfig() {
        return this.listConfig;
    }

    public final String getMenuConfigJson() {
        return this.menuConfigJson;
    }

    public final boolean getShowLeftMenu() {
        return this.showLeftMenu;
    }

    public final boolean getShowMore() {
        return this.showMore;
    }

    public final boolean getShowSearch() {
        return this.showSearch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSpaceConfig(OfficeSpaceTab r2, Set<? extends OfficeSpaceTab> r3, boolean r4, boolean r5, boolean r6, OfficeSpaceHeaderConfig r7, OfficeListConfig r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "initialTab");
        Intrinsics.checkNotNullParameter(r3, "enabledTabs");
        Intrinsics.checkNotNullParameter(r7, "headerConfig");
        Intrinsics.checkNotNullParameter(r8, "listConfig");
        this.initialTab = r2;
        this.a = r3;
        this.showLeftMenu = r4;
        this.showSearch = r5;
        this.showMore = r6;
        this.headerConfig = r7;
        this.listConfig = r8;
        this.menuConfigJson = r9;
    }

    public OfficeSpaceConfig(OfficeSpaceTab r18, Set r19, boolean r20, boolean r21, boolean r22, OfficeSpaceHeaderConfig r23, OfficeListConfig r24, String r25, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 1) == 0) goto L5;
        OfficeSpaceTab r1 = OfficeSpaceTab.RECENT;
    L6:
        boolean r3 = true;
        if ((r26 & 2) == 0) goto L9;
        OfficeSpaceTab.Companion.getClass();
        Set r2 = SetsKt.setOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE});
    L11:
        if ((r26 & 4) == 0) goto L13;
        boolean r4 = true;
    L15:
        if ((r26 & 8) == 0) goto L17;
        boolean r5 = true;
    L19:
        if ((r26 & 16) != 0) goto L23;
        r3 = r22;
    L23:
        if ((r26 & 32) == 0) goto L25;
        OfficeSpaceHeaderConfig r6 = new OfficeSpaceHeaderConfig(r4, r5, r3);
    L27:
        if ((r26 & 64) == 0) goto L29;
        OfficeListConfig r7 = new OfficeListConfig(null, false, false, false, null, null, 63, null);
    L31:
        if ((r26 & 128) == 0) goto L33;
        String r0 = null;
    L34:
        this(r1, r2, r4, r5, r3, r6, r7, r0);
        return;
    L33:
        r0 = r25;
        goto L34
    L29:
        r7 = r24;
        goto L31
    L25:
        r6 = r23;
        goto L27
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r2 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L6
    }
}
