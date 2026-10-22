package aa3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Laa3/d;", "", "", "", "pageNameList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "dayShowCount", "I", "a", "()I", "hideShowCount", "b", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("day_show_count")
    private final int dayShowCount;

    @SerializedName("hide_14_show_count")
    private final int hideShowCount;

    @SerializedName("page_name_list")
    private final List<String> pageNameList;

    public d() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L12;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.pageNameList, r4.pageNameList) == true) goto L8;
        return false;
    L8:
        if (this.dayShowCount == r4.dayShowCount) goto L10;
        return false;
    L10:
        if (this.hideShowCount == r4.hideShowCount) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.pageNameList;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + this.dayShowCount) * 31) + this.hideShowCount;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "MallRefreshGuideConfig(pageNameList=" + this.pageNameList + ", dayShowCount=" + this.dayShowCount + ", hideShowCount=" + this.hideShowCount + ")";
    }

    public final int a() {
        return this.dayShowCount;
    }

    public final int b() {
        return this.hideShowCount;
    }

    public final List<String> c() {
        return this.pageNameList;
    }

    public d(Object r1) {
        this.pageNameList = null;
        this.dayShowCount = 0;
        this.hideShowCount = 0;
    }
}
