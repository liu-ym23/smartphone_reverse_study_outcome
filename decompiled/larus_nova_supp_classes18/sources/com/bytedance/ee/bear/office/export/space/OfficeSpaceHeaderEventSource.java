package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "Ljava/io/Serializable;", "currentTab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "enabledTabs", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Ljava/util/List;)V", "getCurrentTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getEnabledTabs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceHeaderEventSource implements Serializable {
    private final OfficeSpaceTab currentTab;
    private final List<OfficeSpaceTab> enabledTabs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSpaceHeaderEventSource copy$default(OfficeSpaceHeaderEventSource r0, OfficeSpaceTab r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.currentTab;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enabledTabs;
    L9:
        return r0.copy(r1, r2);
    }

    public final OfficeSpaceTab component1() {
        return this.currentTab;
    }

    public final List<OfficeSpaceTab> component2() {
        return this.enabledTabs;
    }

    public final OfficeSpaceHeaderEventSource copy(OfficeSpaceTab r2, List<? extends OfficeSpaceTab> r3) {
        Intrinsics.checkNotNullParameter(r2, "currentTab");
        Intrinsics.checkNotNullParameter(r3, "enabledTabs");
        return new OfficeSpaceHeaderEventSource(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceHeaderEventSource) == true) goto L8;
        return false;
    L8:
        OfficeSpaceHeaderEventSource r6 = (OfficeSpaceHeaderEventSource) r5;
        if (this.currentTab == r6.currentTab) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enabledTabs, r6.enabledTabs) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.currentTab.hashCode() * 31) + this.enabledTabs.hashCode();
    }

    public String toString() {
        return "OfficeSpaceHeaderEventSource(currentTab=" + this.currentTab + ", enabledTabs=" + this.enabledTabs + ')';
    }

    public final OfficeSpaceTab getCurrentTab() {
        return this.currentTab;
    }

    public final List<OfficeSpaceTab> getEnabledTabs() {
        return this.enabledTabs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSpaceHeaderEventSource(OfficeSpaceTab r2, List<? extends OfficeSpaceTab> r3) {
        Intrinsics.checkNotNullParameter(r2, "currentTab");
        Intrinsics.checkNotNullParameter(r3, "enabledTabs");
        this.currentTab = r2;
        this.enabledTabs = r3;
    }
}
