package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderConfig;", "Ljava/io/Serializable;", "showLeftMenu", "", "showSearch", "showMore", "<init>", "(ZZZ)V", "getShowLeftMenu", "()Z", "getShowSearch", "getShowMore", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceHeaderConfig implements Serializable {
    private final boolean showLeftMenu;
    private final boolean showMore;
    private final boolean showSearch;

    public OfficeSpaceHeaderConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ OfficeSpaceHeaderConfig copy$default(OfficeSpaceHeaderConfig r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.showLeftMenu;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.showSearch;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.showMore;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.showLeftMenu;
    }

    public final boolean component2() {
        return this.showSearch;
    }

    public final boolean component3() {
        return this.showMore;
    }

    public final OfficeSpaceHeaderConfig copy(boolean r2, boolean r3, boolean r4) {
        return new OfficeSpaceHeaderConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceHeaderConfig) == true) goto L8;
        return false;
    L8:
        OfficeSpaceHeaderConfig r6 = (OfficeSpaceHeaderConfig) r5;
        if (this.showLeftMenu == r6.showLeftMenu) goto L12;
        return false;
    L12:
        if (this.showSearch == r6.showSearch) goto L15;
        return false;
    L15:
        if (this.showMore == r6.showMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.showLeftMenu == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.showSearch == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.showMore == true) goto L15;
        r1 = 1237;
    L15:
        return r4 + r1;
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeSpaceHeaderConfig(showLeftMenu=" + this.showLeftMenu + ", showSearch=" + this.showSearch + ", showMore=" + this.showMore + ')';
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

    public OfficeSpaceHeaderConfig(boolean r1, boolean r2, boolean r3) {
        this.showLeftMenu = r1;
        this.showSearch = r2;
        this.showMore = r3;
    }

    public /* synthetic */ OfficeSpaceHeaderConfig(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = true;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = true;
    L11:
        this(r2, r3, r4);
    }
}
