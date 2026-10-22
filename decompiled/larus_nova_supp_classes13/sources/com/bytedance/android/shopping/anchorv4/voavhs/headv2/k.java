package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/k;", "", "", "index", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "scaling", "Ljava/lang/Float;", "getScaling", "()Ljava/lang/Float;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "cell", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "a", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderContentModel;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "clickAction", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "b", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("cell")
    private final HeaderContentModel cell;

    @SerializedName("click_action")
    private final IAction clickAction;

    @SerializedName("index")
    private final Integer index;

    @SerializedName("scaling")
    private final Float scaling;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L14;
        k r4 = (k) r3;
        if (Intrinsics.areEqual(this.index, r4.index) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scaling, r4.scaling) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cell, r4.cell) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clickAction, r4.clickAction) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.index;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Float r4 = this.scaling;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        HeaderContentModel r7 = this.cell;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        IAction r10 = this.clickAction;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HeaderMultiContent(index=" + this.index + ", scaling=" + this.scaling + ", cell=" + this.cell + ", clickAction=" + this.clickAction + ")";
    }

    public k() {
        this.index = null;
        this.scaling = null;
        this.cell = null;
        this.clickAction = null;
    }

    public final HeaderContentModel a() {
        return this.cell;
    }

    public final IAction b() {
        return this.clickAction;
    }

    public final Integer c() {
        return this.index;
    }
}
