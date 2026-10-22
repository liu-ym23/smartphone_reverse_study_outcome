package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\\\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "Ljava/io/Serializable;", "status", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "unfreezeDate", "", FreqActions.ACTION_VIEW, "", "click", FreqActions.ACTION_CLOSE, "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getClick", "()Ljava/util/List;", "setClick", "(Ljava/util/List;)V", "getClose", "setClose", "getStatus", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "setStatus", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;)V", "getUnfreezeDate", "()Ljava/lang/Long;", "setUnfreezeDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getView", "setView", "clearActionIfNeeded", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleFreqCache implements Serializable {

    @SerializedName("click")
    private List<Long> click;

    @SerializedName(FreqActions.ACTION_CLOSE)
    private List<Long> close;

    @SerializedName("status")
    private FreqStatus status;

    @SerializedName("unfreeze_date")
    private Long unfreezeDate;

    @SerializedName(FreqActions.ACTION_VIEW)
    private List<Long> view;

    public SingleFreqCache() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleFreqCache copy$default(SingleFreqCache r3, FreqStatus r4, Long r5, List r6, List r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.status;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.unfreezeDate;
    L8:
        Long r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.view;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.click;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.close;
    L17:
        FreqStatus r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final FreqStatus component1() {
        return this.status;
    }

    public final Long component2() {
        return this.unfreezeDate;
    }

    public final List<Long> component3() {
        return this.view;
    }

    public final List<Long> component4() {
        return this.click;
    }

    public final List<Long> component5() {
        return this.close;
    }

    public final SingleFreqCache copy(FreqStatus r8, Long r9, List<Long> r10, List<Long> r11, List<Long> r12) {
        return new SingleFreqCache(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SingleFreqCache) == false) goto L16;
        SingleFreqCache r4 = (SingleFreqCache) r3;
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unfreezeDate, r4.unfreezeDate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.view, r4.view) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.click, r4.click) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.close, r4.close) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        FreqStatus r0 = this.status;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.unfreezeDate;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<Long> r7 = this.view;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<Long> r10 = this.click;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<Long> r13 = this.close;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
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

    public String toString() {
        return "SingleFreqCache(status=" + this.status + ", unfreezeDate=" + this.unfreezeDate + ", view=" + this.view + ", click=" + this.click + ", close=" + this.close + ")";
    }

    public final void clearActionIfNeeded() {
        List<Long> r0 = this.view;
        if (r0 != null) goto L5;
    L7:
        List<Long> r1 = this.click;
        if (r1 != null) goto L10;
    L12:
        List<Long> r2 = this.close;
        if (r2 != null) goto L15;
        return;
    L15:
        if ((!r2.isEmpty()) != true) goto L19;
        this.close = new LinkedList();
        return;
    L19:
        return;
    L10:
        if ((!r1.isEmpty()) != true) goto L12;
        this.click = new LinkedList();
        goto L12
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        this.view = new LinkedList();
        goto L7
    }

    public final List<Long> getClick() {
        return this.click;
    }

    public final List<Long> getClose() {
        return this.close;
    }

    public final FreqStatus getStatus() {
        return this.status;
    }

    public final Long getUnfreezeDate() {
        return this.unfreezeDate;
    }

    public final List<Long> getView() {
        return this.view;
    }

    public final void setClick(List<Long> r1) {
        this.click = r1;
    }

    public final void setClose(List<Long> r1) {
        this.close = r1;
    }

    public final void setStatus(FreqStatus r1) {
        this.status = r1;
    }

    public final void setUnfreezeDate(Long r1) {
        this.unfreezeDate = r1;
    }

    public final void setView(List<Long> r1) {
        this.view = r1;
    }

    public SingleFreqCache(FreqStatus r1, Long r2, List<Long> r3, List<Long> r4, List<Long> r5) {
        this.status = r1;
        this.unfreezeDate = r2;
        this.view = r3;
        this.click = r4;
        this.close = r5;
    }

    public /* synthetic */ SingleFreqCache(FreqStatus r4, Long r5, List r6, List r7, List r8, int r9, DefaultConstructorMarker r10) {
        Long r0 = null;
        if ((r9 & 1) == 0) goto L5;
        FreqStatus r11 = null;
    L7:
        if ((r9 & 2) != 0) goto L11;
        r0 = r5;
    L11:
        if ((r9 & 4) == 0) goto L13;
        r6 = new LinkedList();
    L13:
        List r1 = r6;
        if ((r9 & 8) == 0) goto L16;
        r7 = new LinkedList();
    L16:
        List r2 = r7;
        if ((r9 & 16) == 0) goto L19;
        r8 = new LinkedList();
    L19:
        this(r11, r0, r1, r2, r8);
        return;
    L5:
        r11 = r4;
        goto L7
    }
}
