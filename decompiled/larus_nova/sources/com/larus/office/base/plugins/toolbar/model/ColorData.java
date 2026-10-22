package com.larus.office.base.plugins.toolbar.model;

import com.google.gson.annotations.SerializedName;
import in9.b;
import in9.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/ColorData;", "", "value", "", "Lcom/larus/office/base/plugins/toolbar/model/ColorSelectedItem;", "children", "Lcom/larus/office/base/plugins/toolbar/model/ColorListItem;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "getChildren", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorData {

    @SerializedName("children")
    private final List<b> children;

    @SerializedName("value")
    private final List<c> value;

    /* JADX WARN: Multi-variable type inference failed */
    public ColorData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColorData copy$default(ColorData r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.value;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.children;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<c> component1() {
        return this.value;
    }

    public final List<b> component2() {
        return this.children;
    }

    public final ColorData copy(List<c> r100, List<b> r101) {
        return new ColorData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ColorData) == true) goto L8;
        return false;
    L8:
        ColorData r101 = (ColorData) r100;
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.children, r101.children) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<c> r100 = this.value;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<b> r104 = this.children;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ColorData(value=" + this.value + ", children=" + this.children + ')';
    }

    public final List<b> getChildren() {
        return this.children;
    }

    public final List<c> getValue() {
        return this.value;
    }

    public ColorData(List<c> r100, List<b> r101) {
        this.value = r100;
        this.children = r101;
    }

    public /* synthetic */ ColorData(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
