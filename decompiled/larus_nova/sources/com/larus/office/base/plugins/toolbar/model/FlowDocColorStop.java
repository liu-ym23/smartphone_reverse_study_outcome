package com.larus.office.base.plugins.toolbar.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/office/base/plugins/toolbar/model/FlowDocColorStop;", "", "alpha", "", "color", "", "offset", "<init>", "(FLjava/lang/String;F)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getOffset", "setOffset", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocColorStop {

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("color")
    private String color;

    @SerializedName("offset")
    private float offset;

    public FlowDocColorStop() {
        this(0.0f, null, 0.0f, 7, null);
    }

    public static /* synthetic */ FlowDocColorStop copy$default(FlowDocColorStop r100, float r101, String r102, float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.alpha;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.color;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.offset;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final float component1() {
        return this.alpha;
    }

    public final String component2() {
        return this.color;
    }

    public final float component3() {
        return this.offset;
    }

    public final FlowDocColorStop copy(float r100, String r101, float r102) {
        return new FlowDocColorStop(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowDocColorStop) == true) goto L8;
        return false;
    L8:
        FlowDocColorStop r101 = (FlowDocColorStop) r100;
        if (Float.compare(this.alpha, r101.alpha) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.offset, r101.offset) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = Float.floatToIntBits(this.alpha) * 31;
        String r101 = this.color;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + Float.floatToIntBits(this.offset);
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "FlowDocColorStop(alpha=" + this.alpha + ", color=" + this.color + ", offset=" + this.offset + ')';
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final String getColor() {
        return this.color;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final void setAlpha(float r100) {
        this.alpha = r100;
    }

    public final void setColor(String r100) {
        this.color = r100;
    }

    public final void setOffset(float r100) {
        this.offset = r100;
    }

    public FlowDocColorStop(float r100, String r101, float r102) {
        this.alpha = r100;
        this.color = r101;
        this.offset = r102;
    }

    public /* synthetic */ FlowDocColorStop(float r100, String r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0.0f;
    L11:
        this(r100, r101, r102);
    }
}
