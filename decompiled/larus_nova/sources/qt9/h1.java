package qt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\r\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/FlowIndependentCacheConfig;", "", "conv", "Lkotlin/Triple;", "", "actionbar", "<init>", "(Lkotlin/Triple;Lkotlin/Triple;)V", "getConv", "()Lkotlin/Triple;", "getActionbar", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h1 {

    @SerializedName("actionbar")
    private final Triple<Integer, Integer, Integer> actionbar;

    @SerializedName("conv")
    private final Triple<Integer, Integer, Integer> conv;

    public h1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.conv, r101.conv) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionbar, r101.actionbar) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Triple<Integer, Integer, Integer> r100 = this.conv;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Triple<Integer, Integer, Integer> r104 = this.actionbar;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowIndependentCacheConfig(conv=" + this.conv + ", actionbar=" + this.actionbar + ')';
    }

    public final Triple<Integer, Integer, Integer> a() {
        return this.actionbar;
    }

    public final Triple<Integer, Integer, Integer> b() {
        return this.conv;
    }

    public h1(Object r100) {
        Triple<Integer, Integer, Integer> r101 = new Triple(1024, 512, 256);
        Triple<Integer, Integer, Integer> r102 = new Triple(100, 75, 50);
        this.conv = r101;
        this.actionbar = r102;
    }
}
