package com.relax.runtime.gen;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u001d\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tHÆ\u0003J\u0080\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006+"}, d2 = {"Lcom/relax/runtime/gen/MeasureOptions;", "", "showContent", "", "maxWidth", "", "textModifierIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "attributeKeys", "attributeValues", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getAttributeKeys", "()Ljava/util/ArrayList;", "setAttributeKeys", "(Ljava/util/ArrayList;)V", "getAttributeValues", "setAttributeValues", "getMaxWidth", "()Ljava/lang/Double;", "setMaxWidth", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getShowContent", "()Ljava/lang/Boolean;", "setShowContent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTextModifierIds", "setTextModifierIds", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)Lcom/relax/runtime/gen/MeasureOptions;", "equals", "other", "hashCode", "toString", "", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MeasureOptions {
    private ArrayList<Integer> attributeKeys;
    private ArrayList<Object> attributeValues;
    private Double maxWidth;
    private Boolean showContent;
    private ArrayList<Integer> textModifierIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MeasureOptions copy$default(MeasureOptions r100, Boolean r101, Double r102, ArrayList r103, ArrayList r104, ArrayList r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.showContent;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.maxWidth;
    L8:
        Double r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.textModifierIds;
    L11:
        ArrayList r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.attributeKeys;
    L14:
        ArrayList r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.attributeValues;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.showContent;
    }

    public final Double component2() {
        return this.maxWidth;
    }

    public final ArrayList<Integer> component3() {
        return this.textModifierIds;
    }

    public final ArrayList<Integer> component4() {
        return this.attributeKeys;
    }

    public final ArrayList<Object> component5() {
        return this.attributeValues;
    }

    public final MeasureOptions copy(Boolean r100, Double r101, ArrayList<Integer> r110, ArrayList<Integer> r111, ArrayList<Object> r112) {
        return new MeasureOptions(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MeasureOptions) == true) goto L8;
        return false;
    L8:
        MeasureOptions r101 = (MeasureOptions) r100;
        if (Intrinsics.areEqual(this.showContent, r101.showContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxWidth, r101.maxWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textModifierIds, r101.textModifierIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.attributeKeys, r101.attributeKeys) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attributeValues, r101.attributeValues) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.showContent;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.maxWidth;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<Integer> r107 = this.textModifierIds;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ArrayList<Integer> r110 = this.attributeKeys;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ArrayList<Object> r113 = this.attributeValues;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MeasureOptions(showContent=" + this.showContent + ", maxWidth=" + this.maxWidth + ", textModifierIds=" + this.textModifierIds + ", attributeKeys=" + this.attributeKeys + ", attributeValues=" + this.attributeValues + ')';
    }

    public final ArrayList<Integer> getAttributeKeys() {
        return this.attributeKeys;
    }

    public final ArrayList<Object> getAttributeValues() {
        return this.attributeValues;
    }

    public final Double getMaxWidth() {
        return this.maxWidth;
    }

    public final Boolean getShowContent() {
        return this.showContent;
    }

    public final ArrayList<Integer> getTextModifierIds() {
        return this.textModifierIds;
    }

    public final void setAttributeKeys(ArrayList<Integer> r100) {
        this.attributeKeys = r100;
    }

    public final void setAttributeValues(ArrayList<Object> r100) {
        this.attributeValues = r100;
    }

    public final void setMaxWidth(Double r100) {
        this.maxWidth = r100;
    }

    public final void setShowContent(Boolean r100) {
        this.showContent = r100;
    }

    public final void setTextModifierIds(ArrayList<Integer> r100) {
        this.textModifierIds = r100;
    }

    public MeasureOptions(Boolean r100, Double r101, ArrayList<Integer> r102, ArrayList<Integer> r103, ArrayList<Object> r104) {
        this.showContent = r100;
        this.maxWidth = r101;
        this.textModifierIds = r102;
        this.attributeKeys = r103;
        this.attributeValues = r104;
    }
}
