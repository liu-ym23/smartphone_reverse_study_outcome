package com.bytedance.android.shopping.anchorv4.voavhs.logistics;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Padding;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/logistics/DeliveryDetailElement;", "Ljava/io/Serializable;", "stages", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "padding", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "connector", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getConnector", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getPadding", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Padding;", "getStages", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeliveryDetailElement implements Serializable {

    @SerializedName("connector")
    private final ECUrlModel connector;

    @SerializedName("padding")
    private final Padding padding;

    @SerializedName("stages")
    private final List<TextWithOneIconElement> stages;

    public DeliveryDetailElement() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeliveryDetailElement copy$default(DeliveryDetailElement r0, List r1, Padding r2, ECUrlModel r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.stages;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.padding;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.connector;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<TextWithOneIconElement> component1() {
        return this.stages;
    }

    public final Padding component2() {
        return this.padding;
    }

    public final ECUrlModel component3() {
        return this.connector;
    }

    public final DeliveryDetailElement copy(List<TextWithOneIconElement> r2, Padding r3, ECUrlModel r4) {
        return new DeliveryDetailElement(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DeliveryDetailElement) == false) goto L12;
        DeliveryDetailElement r4 = (DeliveryDetailElement) r3;
        if (Intrinsics.areEqual(this.stages, r4.stages) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.padding, r4.padding) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.connector, r4.connector) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        List<TextWithOneIconElement> r0 = this.stages;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Padding r4 = this.padding;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.connector;
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
        return "DeliveryDetailElement(stages=" + this.stages + ", padding=" + this.padding + ", connector=" + this.connector + ")";
    }

    public final ECUrlModel getConnector() {
        return this.connector;
    }

    public final Padding getPadding() {
        return this.padding;
    }

    public final List<TextWithOneIconElement> getStages() {
        return this.stages;
    }

    public DeliveryDetailElement(List<TextWithOneIconElement> r1, Padding r2, ECUrlModel r3) {
        this.stages = r1;
        this.padding = r2;
        this.connector = r3;
    }

    public /* synthetic */ DeliveryDetailElement(List r2, Padding r3, ECUrlModel r4, int r5, DefaultConstructorMarker r6) {
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
