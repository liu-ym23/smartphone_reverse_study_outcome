package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lm93/i;", "", "", "isFiltered", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f512608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512609b;

    @SerializedName("is_filtered")
    private final Boolean isFiltered;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.isFiltered, r101.isFiltered) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512608a, r101.f512608a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512609b, r101.f512609b) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.isFiltered;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f512608a;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f512609b;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FilterDefault(isFiltered=" + this.isFiltered + ", code=" + this.f512608a + ", reason=" + this.f512609b + ")";
    }

    public i() {
        this.isFiltered = null;
        this.f512608a = null;
        this.f512609b = null;
    }
}
