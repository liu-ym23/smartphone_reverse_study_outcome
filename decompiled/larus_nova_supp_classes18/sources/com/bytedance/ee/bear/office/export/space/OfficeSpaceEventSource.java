package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "Ljava/io/Serializable;", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "displayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "position", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;I)V", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getDisplayMode", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "getPosition", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceEventSource implements Serializable {
    private final OfficeListDisplayMode displayMode;
    private final int position;
    private final OfficeSpaceTab tab;

    public static /* synthetic */ OfficeSpaceEventSource copy$default(OfficeSpaceEventSource r0, OfficeSpaceTab r1, OfficeListDisplayMode r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.tab;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.displayMode;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.position;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final OfficeSpaceTab component1() {
        return this.tab;
    }

    public final OfficeListDisplayMode component2() {
        return this.displayMode;
    }

    public final int component3() {
        return this.position;
    }

    public final OfficeSpaceEventSource copy(OfficeSpaceTab r2, OfficeListDisplayMode r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r3, "displayMode");
        return new OfficeSpaceEventSource(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceEventSource) == true) goto L8;
        return false;
    L8:
        OfficeSpaceEventSource r6 = (OfficeSpaceEventSource) r5;
        if (this.tab == r6.tab) goto L12;
        return false;
    L12:
        if (this.displayMode == r6.displayMode) goto L15;
        return false;
    L15:
        if (this.position == r6.position) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.tab.hashCode() * 31) + this.displayMode.hashCode()) * 31) + this.position;
    }

    public String toString() {
        return "OfficeSpaceEventSource(tab=" + this.tab + ", displayMode=" + this.displayMode + ", position=" + this.position + ')';
    }

    public final OfficeListDisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public final int getPosition() {
        return this.position;
    }

    public final OfficeSpaceTab getTab() {
        return this.tab;
    }

    public OfficeSpaceEventSource(OfficeSpaceTab r2, OfficeListDisplayMode r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r3, "displayMode");
        this.tab = r2;
        this.displayMode = r3;
        this.position = r4;
    }

    public /* synthetic */ OfficeSpaceEventSource(OfficeSpaceTab r1, OfficeListDisplayMode r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = -1;
    L5:
        this(r1, r2, r3);
    }
}
