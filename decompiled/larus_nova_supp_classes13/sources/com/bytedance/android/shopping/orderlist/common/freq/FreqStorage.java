package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0003J\u0006\u0010\u0011\u001a\u00020\u0012Jc\u0010\u0013\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00032\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00032\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R*\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStorage;", "Ljava/io/Serializable;", FreqActions.ACTION_VIEW, "", "", "", "", "click", FreqActions.ACTION_CLOSE, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getClick", "()Ljava/util/Map;", "getClose", "getView", "component1", "component2", "component3", "containsContent", "", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqStorage implements Serializable {

    @SerializedName("click")
    private final Map<String, List<Long>> click;

    @SerializedName(FreqActions.ACTION_CLOSE)
    private final Map<String, List<Long>> close;

    @SerializedName(FreqActions.ACTION_VIEW)
    private final Map<String, List<Long>> view;

    public FreqStorage() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FreqStorage copy$default(FreqStorage r0, Map r1, Map r2, Map r3, int r4, Object r5) {
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

    public final Map<String, List<Long>> component1() {
        return this.view;
    }

    public final Map<String, List<Long>> component2() {
        return this.click;
    }

    public final Map<String, List<Long>> component3() {
        return this.close;
    }

    public final FreqStorage copy(Map<String, List<Long>> r2, Map<String, List<Long>> r3, Map<String, List<Long>> r4) {
        return new FreqStorage(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FreqStorage) == false) goto L12;
        FreqStorage r4 = (FreqStorage) r3;
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
        Map<String, List<Long>> r0 = this.view;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, List<Long>> r4 = this.click;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, List<Long>> r7 = this.close;
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
        return "FreqStorage(view=" + this.view + ", click=" + this.click + ", close=" + this.close + ")";
    }

    public final boolean containsContent() {
        if (this.view == null) goto L5;
    L10:
        return true;
    L5:
        if (this.click != null) goto L10;
        if (this.close != null) goto L10;
        return false;
    }

    public final Map<String, List<Long>> getClick() {
        return this.click;
    }

    public final Map<String, List<Long>> getClose() {
        return this.close;
    }

    public final Map<String, List<Long>> getView() {
        return this.view;
    }

    public FreqStorage(Map<String, List<Long>> r1, Map<String, List<Long>> r2, Map<String, List<Long>> r3) {
        this.view = r1;
        this.click = r2;
        this.close = r3;
    }

    public /* synthetic */ FreqStorage(Map r2, Map r3, Map r4, int r5, DefaultConstructorMarker r6) {
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
