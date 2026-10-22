package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "Ljava/io/Serializable;", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "displayMode", "Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "position", "", "<init>", "(Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;I)V", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getDisplayMode", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "getPosition", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceEventSource implements Serializable {
    private final OfficeListDisplayMode displayMode;
    private final int position;

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    private final OfficeSpaceTab f235458tab;

    public static /* synthetic */ OfficeSpaceEventSource copy$default(OfficeSpaceEventSource r100, OfficeSpaceTab r101, OfficeListDisplayMode r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f235458tab;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.displayMode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.position;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final OfficeSpaceTab component1() {
        return this.f235458tab;
    }

    public final OfficeListDisplayMode component2() {
        return this.displayMode;
    }

    public final int component3() {
        return this.position;
    }

    public final OfficeSpaceEventSource copy(OfficeSpaceTab r100, OfficeListDisplayMode r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Intrinsics.checkNotNullParameter(r101, "displayMode");
        return new OfficeSpaceEventSource(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceEventSource) == true) goto L8;
        return false;
    L8:
        OfficeSpaceEventSource r101 = (OfficeSpaceEventSource) r100;
        if (this.f235458tab == r101.f235458tab) goto L12;
        return false;
    L12:
        if (this.displayMode == r101.displayMode) goto L15;
        return false;
    L15:
        if (this.position == r101.position) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f235458tab.hashCode() * 31) + this.displayMode.hashCode()) * 31) + this.position;
    }

    public String toString() {
        return "OfficeSpaceEventSource(tab=" + this.f235458tab + ", displayMode=" + this.displayMode + ", position=" + this.position + ')';
    }

    public final OfficeListDisplayMode getDisplayMode() {
        return this.displayMode;
    }

    public final int getPosition() {
        return this.position;
    }

    public final OfficeSpaceTab getTab() {
        return this.f235458tab;
    }

    public OfficeSpaceEventSource(OfficeSpaceTab r100, OfficeListDisplayMode r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        Intrinsics.checkNotNullParameter(r101, "displayMode");
        this.f235458tab = r100;
        this.displayMode = r101;
        this.position = r102;
    }

    public /* synthetic */ OfficeSpaceEventSource(OfficeSpaceTab r100, OfficeListDisplayMode r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}
