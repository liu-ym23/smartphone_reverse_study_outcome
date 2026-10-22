package up3;

import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lup3/b;", "", "", "desc", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", UploadTypeInf.COUNT, "J", "a", "()J", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(UploadTypeInf.COUNT)
    private final long count;

    @SerializedName("desc")
    private final String desc;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof b) == false) goto L10;
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L8;
        return false;
    L8:
        if (this.count == r6.count) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.desc;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.count;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "ECShopInnerFlowCommentTagsDTO(desc=" + this.desc + ", count=" + this.count + ")";
    }

    public b() {
        this.desc = "";
        this.count = 0;
    }

    public final long a() {
        return this.count;
    }

    public final String b() {
        return this.desc;
    }
}
