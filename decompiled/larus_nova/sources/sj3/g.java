package sj3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lsj3/g;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "status", "I", "getStatus", "()I", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f542278id;

    @SerializedName("status")
    private final int status;

    public g() {
        this("", 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f542278id, r101.f542278id) == true) goto L8;
        return false;
    L8:
        if (this.status == r101.status) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f542278id;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.status;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "SortSelectStatus(id=" + this.f542278id + ", status=" + this.status + ")";
    }

    public g(String r100, int r101) {
        this.f542278id = r100;
        this.status = r101;
    }
}
