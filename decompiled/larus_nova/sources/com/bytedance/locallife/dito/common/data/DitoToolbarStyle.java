package com.bytedance.locallife.dito.common.data;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/dito/common/data/DitoToolbarStyle;", "Ljava/io/Serializable;", "backgroundColor", "", "radius", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "getBackgroundColor", "()Ljava/lang/String;", "getRadius", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoToolbarStyle implements Serializable {
    private final String backgroundColor;
    private final List<Float> radius;

    /* JADX WARN: Multi-variable type inference failed */
    public DitoToolbarStyle() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoToolbarStyle copy$default(DitoToolbarStyle r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.backgroundColor;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.radius;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.backgroundColor;
    }

    public final List<Float> component2() {
        return this.radius;
    }

    public final DitoToolbarStyle copy(String r100, List<Float> r101) {
        return new DitoToolbarStyle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoToolbarStyle) == true) goto L8;
        return false;
    L8:
        DitoToolbarStyle r101 = (DitoToolbarStyle) r100;
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.backgroundColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Float> r104 = this.radius;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DitoToolbarStyle(backgroundColor=" + this.backgroundColor + ", radius=" + this.radius + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final List<Float> getRadius() {
        return this.radius;
    }

    public DitoToolbarStyle(String r100, List<Float> r101) {
        this.backgroundColor = r100;
        this.radius = r101;
    }

    public /* synthetic */ DitoToolbarStyle(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
