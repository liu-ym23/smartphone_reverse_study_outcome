package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/business/markdown/api/model/BgListItemConfig;", "", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(IILjava/lang/Float;Ljava/lang/Integer;)V", "getBgColor", "()I", "getBgMargin", "getBgRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLeading", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Float;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/BgListItemConfig;", "equals", "", "other", "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BgListItemConfig {
    private final int bgColor;
    private final int bgMargin;
    private final Float bgRadius;
    private final Integer leading;

    public static /* synthetic */ BgListItemConfig copy$default(BgListItemConfig r100, int r101, int r102, Float r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bgColor;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bgMargin;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bgRadius;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.leading;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.bgColor;
    }

    public final int component2() {
        return this.bgMargin;
    }

    public final Float component3() {
        return this.bgRadius;
    }

    public final Integer component4() {
        return this.leading;
    }

    public final BgListItemConfig copy(int r100, int r101, Float r102, Integer r103) {
        return new BgListItemConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BgListItemConfig) == true) goto L8;
        return false;
    L8:
        BgListItemConfig r101 = (BgListItemConfig) r100;
        if (this.bgColor == r101.bgColor) goto L12;
        return false;
    L12:
        if (this.bgMargin == r101.bgMargin) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgRadius, r101.bgRadius) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.leading, r101.leading) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.bgColor * 31) + this.bgMargin) * 31;
        Float r101 = this.bgRadius;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.leading;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "BgListItemConfig(bgColor=" + this.bgColor + ", bgMargin=" + this.bgMargin + ", bgRadius=" + this.bgRadius + ", leading=" + this.leading + ')';
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getBgMargin() {
        return this.bgMargin;
    }

    public final Float getBgRadius() {
        return this.bgRadius;
    }

    public final Integer getLeading() {
        return this.leading;
    }

    public BgListItemConfig(int r100, int r101, Float r102, Integer r103) {
        this.bgColor = r100;
        this.bgMargin = r101;
        this.bgRadius = r102;
        this.leading = r103;
    }

    public /* synthetic */ BgListItemConfig(int r100, int r101, Float r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = Float.valueOf(0.0f);
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = 0;
    L8:
        this(r100, r101, r102, r103);
    }
}
