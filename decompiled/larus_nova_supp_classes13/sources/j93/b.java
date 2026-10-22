package j93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lj93/b;", "", "", "dropOpt", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "cacheBtm", "a", "cacheGlobalProps", "b", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("cache_btm")
    private final Integer cacheBtm;

    @SerializedName("cache_global_props")
    private final Integer cacheGlobalProps;

    @SerializedName("drop_opt")
    private final Integer dropOpt;

    public b() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.dropOpt, r4.dropOpt) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cacheBtm, r4.cacheBtm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cacheGlobalProps, r4.cacheGlobalProps) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.dropOpt;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.cacheBtm;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.cacheGlobalProps;
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

    public final String toString() {
        return "MallDropOptByReport(dropOpt=" + this.dropOpt + ", cacheBtm=" + this.cacheBtm + ", cacheGlobalProps=" + this.cacheGlobalProps + ")";
    }

    public final Integer a() {
        return this.cacheBtm;
    }

    public final Integer b() {
        return this.cacheGlobalProps;
    }

    public final Integer c() {
        return this.dropOpt;
    }

    public b(int r1) {
        this.dropOpt = null;
        this.cacheBtm = null;
        this.cacheGlobalProps = null;
    }
}
