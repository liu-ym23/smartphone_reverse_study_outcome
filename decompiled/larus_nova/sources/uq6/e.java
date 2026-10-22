package uq6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Luq6/e;", "", "", "pageRenderStartTs", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "c", "(Ljava/lang/Long;)V", "pageRenderCost", "getPageRenderCost", "b", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("page_render_cost")
    private Long pageRenderCost;

    @SerializedName("page_render_start_ts")
    private Long pageRenderStartTs;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.pageRenderStartTs, r101.pageRenderStartTs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageRenderCost, r101.pageRenderCost) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.pageRenderStartTs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.pageRenderCost;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoPageRenderTimingInfo(pageRenderStartTs=" + this.pageRenderStartTs + ", pageRenderCost=" + this.pageRenderCost + ')';
    }

    public final Long a() {
        return this.pageRenderStartTs;
    }

    public e(int r100) {
        this.pageRenderStartTs = Long.valueOf(System.currentTimeMillis());
        this.pageRenderCost = null;
    }

    public final void b(Long r100) {
        this.pageRenderCost = r100;
    }

    public final void c(Long r100) {
        this.pageRenderStartTs = r100;
    }
}
