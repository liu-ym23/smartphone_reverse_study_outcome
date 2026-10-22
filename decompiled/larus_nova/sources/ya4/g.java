package ya4;

import com.bytedance.bdp.live.livecontainer.miniapp.PageStatus;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lya4/g;", "", "Lcom/bytedance/bdp/live/livecontainer/miniapp/PageStatus;", "pageStatus", "Lcom/bytedance/bdp/live/livecontainer/miniapp/PageStatus;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/bdp/live/livecontainer/miniapp/PageStatus;", "", "needSnapshot", "Z", "getNeedSnapshot", "()Z", "livecontainer_douyinRelease"}, k = 1, mv = {1, 4, 0})
public final class g {

    @SerializedName("needSnapshot")
    private final boolean needSnapshot;

    @SerializedName("pageStatus")
    private final PageStatus pageStatus;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.pageStatus, r101.pageStatus) == true) goto L8;
        return false;
    L8:
        if (this.needSnapshot == r101.needSnapshot) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        PageStatus r100 = this.pageStatus;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.needSnapshot;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PageConfig(pageStatus=" + this.pageStatus + ", needSnapshot=" + this.needSnapshot + ")";
    }

    public final PageStatus a() {
        return this.pageStatus;
    }

    public g(PageStatus r100) {
        this.pageStatus = r100;
        this.needSnapshot = true;
    }
}
