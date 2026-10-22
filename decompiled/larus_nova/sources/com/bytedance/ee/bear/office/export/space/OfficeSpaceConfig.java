package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010 \u001a\u00020!H\u0002J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003Ja\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "Ljava/io/Serializable;", "initialTab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "enabledTabs", "", "showLeftMenu", "", "showSearch", "showMore", "headerConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "menuConfigJson", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Ljava/util/Set;ZZZLcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;Ljava/lang/String;)V", "getInitialTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getEnabledTabs", "()Ljava/util/Set;", "getShowLeftMenu", "()Z", "getShowSearch", "getShowMore", "getHeaderConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "getMenuConfigJson", "()Ljava/lang/String;", "writeReplace", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceConfig implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Set<OfficeSpaceTab> f235457a;
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
    public static /* synthetic */ OfficeSpaceConfig copy$default(OfficeSpaceConfig r100, OfficeSpaceTab r110, Set r111, boolean r112, boolean r113, boolean r114, OfficeSpaceHeaderConfig r115, OfficeListConfig r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        OfficeSpaceTab r101 = r100.initialTab;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Set r102 = r100.f235457a;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.showLeftMenu;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.showSearch;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.showMore;
    L23:
        if ((r118 & 32) == 0) goto L25;
        OfficeSpaceHeaderConfig r106 = r100.headerConfig;
    L27:
        if ((r118 & 64) == 0) goto L29;
        OfficeListConfig r107 = r100.listConfig;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.menuConfigJson;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final OfficeSpaceTab component1() {
        return this.initialTab;
    }

    public final Set<OfficeSpaceTab> component2() {
        return this.f235457a;
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

    public final OfficeSpaceConfig copy(OfficeSpaceTab r110, Set<? extends OfficeSpaceTab> r111, boolean r112, boolean r113, boolean r114, OfficeSpaceHeaderConfig r115, OfficeListConfig r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "initialTab");
        Intrinsics.checkNotNullParameter(r111, "enabledTabs");
        Intrinsics.checkNotNullParameter(r115, "headerConfig");
        Intrinsics.checkNotNullParameter(r116, "listConfig");
        return new OfficeSpaceConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceConfig) == true) goto L8;
        return false;
    L8:
        OfficeSpaceConfig r101 = (OfficeSpaceConfig) r100;
        if (this.initialTab == r101.initialTab) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235457a, r101.f235457a) == true) goto L15;
        return false;
    L15:
        if (this.showLeftMenu == r101.showLeftMenu) goto L18;
        return false;
    L18:
        if (this.showSearch == r101.showSearch) goto L21;
        return false;
    L21:
        if (this.showMore == r101.showMore) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headerConfig, r101.headerConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.listConfig, r101.listConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.menuConfigJson, r101.menuConfigJson) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.initialTab.hashCode() * 31) + this.f235457a.hashCode()) * 31;
        int r101 = 1231;
        if (this.showLeftMenu == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.showSearch == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.showMore == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (((((r105 + r101) * 31) + this.headerConfig.hashCode()) * 31) + this.listConfig.hashCode()) * 31;
        String r107 = this.menuConfigJson;
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
        return "OfficeSpaceConfig(initialTab=" + this.initialTab + ", enabledTabs=" + this.f235457a + ", showLeftMenu=" + this.showLeftMenu + ", showSearch=" + this.showSearch + ", showMore=" + this.showMore + ", headerConfig=" + this.headerConfig + ", listConfig=" + this.listConfig + ", menuConfigJson=" + this.menuConfigJson + ')';
    }

    private final Object writeReplace() {
        return new OfficeSpaceConfigSerializedForm(this.initialTab, f.a(this.f235457a), this.showLeftMenu, this.showSearch, this.showMore, this.headerConfig, this.listConfig, this.menuConfigJson);
    }

    public final Set<OfficeSpaceTab> getEnabledTabs() {
        return this.f235457a;
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
    public OfficeSpaceConfig(OfficeSpaceTab r100, Set<? extends OfficeSpaceTab> r101, boolean r102, boolean r103, boolean r104, OfficeSpaceHeaderConfig r105, OfficeListConfig r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "initialTab");
        Intrinsics.checkNotNullParameter(r101, "enabledTabs");
        Intrinsics.checkNotNullParameter(r105, "headerConfig");
        Intrinsics.checkNotNullParameter(r106, "listConfig");
        this.initialTab = r100;
        this.f235457a = r101;
        this.showLeftMenu = r102;
        this.showSearch = r103;
        this.showMore = r104;
        this.headerConfig = r105;
        this.listConfig = r106;
        this.menuConfigJson = r107;
    }

    public OfficeSpaceConfig(OfficeSpaceTab r110, Set r111, boolean r210, boolean r211, boolean r212, OfficeSpaceHeaderConfig r213, OfficeListConfig r214, String r215, int r216, DefaultConstructorMarker r217) {
        if ((r216 & 1) == 0) goto L5;
        OfficeSpaceTab r100 = OfficeSpaceTab.RECENT;
    L6:
        boolean r101 = true;
        if ((r216 & 2) == 0) goto L9;
        OfficeSpaceTab.Companion.getClass();
        Set r102 = SetsKt.setOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE});
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r216 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r216 & 16) != 0) goto L23;
        r101 = r212;
    L23:
        if ((r216 & 32) == 0) goto L25;
        OfficeSpaceHeaderConfig r105 = new OfficeSpaceHeaderConfig(r103, r104, r101);
    L27:
        if ((r216 & 64) == 0) goto L29;
        OfficeListConfig r106 = new OfficeListConfig(null, false, false, false, null, null, 63, null);
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = null;
    L34:
        this(r100, r102, r103, r104, r101, r105, r106, r107);
        return;
    L33:
        r107 = r215;
        goto L34
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
