package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;", "Ljava/io/Serializable;", "selected", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "unselected", "innerSpace", "", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Ljava/lang/Double;)V", "getInnerSpace", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSelected", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "getUnselected", "component1", "component2", "component3", "copy", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Ljava/lang/Double;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNAPendantItemConfig implements Serializable {

    @SerializedName("inner_space")
    private final Double innerSpace;

    @SerializedName("selected")
    private final FontStyle selected;

    @SerializedName("unselected")
    private final FontStyle unselected;

    public HeaderNAPendantItemConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HeaderNAPendantItemConfig copy$default(HeaderNAPendantItemConfig r0, FontStyle r1, FontStyle r2, Double r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.selected;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.unselected;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.innerSpace;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final FontStyle component1() {
        return this.selected;
    }

    public final FontStyle component2() {
        return this.unselected;
    }

    public final Double component3() {
        return this.innerSpace;
    }

    public final HeaderNAPendantItemConfig copy(FontStyle r2, FontStyle r3, Double r4) {
        return new HeaderNAPendantItemConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderNAPendantItemConfig) == false) goto L12;
        HeaderNAPendantItemConfig r4 = (HeaderNAPendantItemConfig) r3;
        if (Intrinsics.areEqual(this.selected, r4.selected) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unselected, r4.unselected) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.innerSpace, r4.innerSpace) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        FontStyle r0 = this.selected;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        FontStyle r4 = this.unselected;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.innerSpace;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderNAPendantItemConfig(selected=" + this.selected + ", unselected=" + this.unselected + ", innerSpace=" + this.innerSpace + ")";
    }

    public final Double getInnerSpace() {
        return this.innerSpace;
    }

    public final FontStyle getSelected() {
        return this.selected;
    }

    public final FontStyle getUnselected() {
        return this.unselected;
    }

    public HeaderNAPendantItemConfig(FontStyle r1, FontStyle r2, Double r3) {
        this.selected = r1;
        this.unselected = r2;
        this.innerSpace = r3;
    }

    public /* synthetic */ HeaderNAPendantItemConfig(FontStyle r2, FontStyle r3, Double r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
