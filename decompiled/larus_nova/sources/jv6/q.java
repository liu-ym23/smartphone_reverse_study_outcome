package jv6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ljv6/q;", "", "", "right_space_symbols", "Ljava/lang/String;", "getRight_space_symbols", "()Ljava/lang/String;", "left_space_symbols", "getLeft_space_symbols", "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("left_space_symbols")
    private final String left_space_symbols;

    @SerializedName("right_space_symbols")
    private final String right_space_symbols;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.right_space_symbols, r101.right_space_symbols) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.left_space_symbols, r101.left_space_symbols) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.right_space_symbols;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.left_space_symbols;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfTitleChineseSymbols(right_space_symbols=" + this.right_space_symbols + ", left_space_symbols=" + this.left_space_symbols + ')';
    }

    public q() {
        this.right_space_symbols = null;
        this.left_space_symbols = null;
    }
}
