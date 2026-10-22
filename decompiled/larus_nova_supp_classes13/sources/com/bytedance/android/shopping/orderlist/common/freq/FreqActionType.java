package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;", "Ljava/io/Serializable;", FreqActions.ACTION_VIEW, "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "click", FreqActions.ACTION_CLOSE, "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;)V", "getClick", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "setClick", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;)V", "getClose", "setClose", "getView", "setView", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqActionType implements Serializable {

    @SerializedName("click")
    private FreqParam click;

    @SerializedName(FreqActions.ACTION_CLOSE)
    private FreqParam close;

    @SerializedName(FreqActions.ACTION_VIEW)
    private FreqParam view;

    public FreqActionType() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FreqActionType copy$default(FreqActionType r0, FreqParam r1, FreqParam r2, FreqParam r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.view;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.click;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.close;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final FreqParam component1() {
        return this.view;
    }

    public final FreqParam component2() {
        return this.click;
    }

    public final FreqParam component3() {
        return this.close;
    }

    public final FreqActionType copy(FreqParam r2, FreqParam r3, FreqParam r4) {
        return new FreqActionType(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FreqActionType) == false) goto L12;
        FreqActionType r4 = (FreqActionType) r3;
        if (Intrinsics.areEqual(this.view, r4.view) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.click, r4.click) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.close, r4.close) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        FreqParam r0 = this.view;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        FreqParam r4 = this.click;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        FreqParam r7 = this.close;
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
        return "FreqActionType(view=" + this.view + ", click=" + this.click + ", close=" + this.close + ")";
    }

    public final FreqParam getClick() {
        return this.click;
    }

    public final FreqParam getClose() {
        return this.close;
    }

    public final FreqParam getView() {
        return this.view;
    }

    public final void setClick(FreqParam r1) {
        this.click = r1;
    }

    public final void setClose(FreqParam r1) {
        this.close = r1;
    }

    public final void setView(FreqParam r1) {
        this.view = r1;
    }

    public FreqActionType(FreqParam r1, FreqParam r2, FreqParam r3) {
        this.view = r1;
        this.click = r2;
        this.close = r3;
    }

    public /* synthetic */ FreqActionType(FreqParam r2, FreqParam r3, FreqParam r4, int r5, DefaultConstructorMarker r6) {
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
