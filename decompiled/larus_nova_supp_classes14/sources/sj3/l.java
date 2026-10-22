package sj3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lsj3/l;", "", "", "begin", "I", "a", "()I", "end", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("begin")
    private final int begin;

    @SerializedName("end")
    private final int end;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L10;
        l r4 = (l) r3;
        if (this.begin == r4.begin) goto L8;
        return false;
    L8:
        if (this.end == r4.end) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.begin * 31) + this.end;
    }

    public final String toString() {
        return "SugPositionDTO(begin=" + this.begin + ", end=" + this.end + ")";
    }

    public l() {
        this.begin = 0;
        this.end = 0;
    }

    public final int a() {
        return this.begin;
    }

    public final int b() {
        return this.end;
    }
}
