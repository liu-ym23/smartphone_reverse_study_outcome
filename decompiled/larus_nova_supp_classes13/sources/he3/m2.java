package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lhe3/m2;", "", "", "title", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "subTitle", "getSubTitle", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m2 {

    @SerializedName("sub_title")
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    public m2() {
        this(null, 3);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m2) == false) goto L10;
        m2 r4 = (m2) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subTitle, r4.subTitle) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.subTitle;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ToastInfo(title=" + this.title + ", subTitle=" + this.subTitle + ")";
    }

    public final String a() {
        return this.title;
    }

    public m2(String r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.title = r2;
        this.subTitle = null;
    }
}
