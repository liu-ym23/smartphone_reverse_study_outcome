package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LabelPosition;", "Ljava/io/Serializable;", "marginTop", "", "marginLeft", "marginRight", "marginBottom", "archPosition", "", "(IIIILjava/lang/String;)V", "getArchPosition", "()Ljava/lang/String;", "getMarginBottom", "()I", "getMarginLeft", "getMarginRight", "getMarginTop", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LabelPosition implements Serializable {

    @SerializedName("arch_position")
    private final String archPosition;

    @SerializedName("margin_bottom")
    private final int marginBottom;

    @SerializedName("margin_left")
    private final int marginLeft;

    @SerializedName("margin_right")
    private final int marginRight;

    @SerializedName("margin_top")
    private final int marginTop;

    public LabelPosition() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public static /* synthetic */ LabelPosition copy$default(LabelPosition r100, int r101, int r102, int r103, int r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.marginTop;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.marginLeft;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.marginRight;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.marginBottom;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.archPosition;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.marginTop;
    }

    public final int component2() {
        return this.marginLeft;
    }

    public final int component3() {
        return this.marginRight;
    }

    public final int component4() {
        return this.marginBottom;
    }

    public final String component5() {
        return this.archPosition;
    }

    public final LabelPosition copy(int r100, int r101, int r110, int r111, String r112) {
        return new LabelPosition(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LabelPosition) == false) goto L16;
        LabelPosition r101 = (LabelPosition) r100;
        if (this.marginTop == r101.marginTop) goto L8;
        return false;
    L8:
        if (this.marginLeft == r101.marginLeft) goto L10;
        return false;
    L10:
        if (this.marginRight == r101.marginRight) goto L12;
        return false;
    L12:
        if (this.marginBottom == r101.marginBottom) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.archPosition, r101.archPosition) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r100 = ((((((this.marginTop * 31) + this.marginLeft) * 31) + this.marginRight) * 31) + this.marginBottom) * 31;
        String r101 = this.archPosition;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "LabelPosition(marginTop=" + this.marginTop + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", archPosition=" + this.archPosition + ")";
    }

    public final String getArchPosition() {
        return this.archPosition;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginRight() {
        return this.marginRight;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public LabelPosition(int r100, int r101, int r102, int r103, String r104) {
        this.marginTop = r100;
        this.marginLeft = r101;
        this.marginRight = r102;
        this.marginBottom = r103;
        this.archPosition = r104;
    }

    public /* synthetic */ LabelPosition(int r100, int r101, int r102, int r103, String r104, int r105, DefaultConstructorMarker r110) {
        int r106 = -1;
        if ((r105 & 1) == 0) goto L5;
        int r111 = -1;
    L7:
        if ((r105 & 2) == 0) goto L9;
        int r107 = -1;
    L11:
        if ((r105 & 4) == 0) goto L13;
        int r108 = -1;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = "";
    L21:
        String r109 = r104;
        this(r111, r107, r108, r106, r109);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
