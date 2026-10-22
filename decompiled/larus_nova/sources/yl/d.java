package yl;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lyl/d;", "", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "Lyl/f;", "preloadList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "tryUseReflection", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "ec-opt_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private final Integer limit;

    @SerializedName("preload_list")
    private final List<f> preloadList;

    @SerializedName("try_use_reflection")
    private final Boolean tryUseReflection;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.limit, r101.limit) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preloadList, r101.preloadList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tryUseReflection, r101.tryUseReflection) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.limit;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<f> r104 = this.preloadList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.tryUseReflection;
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
        return "NetImagePreloadData(limit=" + this.limit + ", preloadList=" + this.preloadList + ", tryUseReflection=" + this.tryUseReflection + ")";
    }

    public d() {
        this.limit = null;
        this.preloadList = null;
        this.tryUseReflection = null;
    }

    public final Integer a() {
        return this.limit;
    }

    public final List<f> b() {
        return this.preloadList;
    }

    public final Boolean c() {
        return this.tryUseReflection;
    }
}
