package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallGulPrefetch;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/help/f;", "", "", "", "pageName", "Ljava/util/List;", "getPageName", "()Ljava/util/List;", "afterWindVanePage", "getAfterWindVanePage", "", "useFetchType", "Ljava/lang/Integer;", "getUseFetchType", "()Ljava/lang/Integer;", "unExposeSkew", "b", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("after_wind_vane_page")
    private final List<String> afterWindVanePage;

    @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
    private final List<String> pageName;

    @SerializedName("un_expose_skew")
    private final Integer unExposeSkew;

    @SerializedName("use_fetch_type")
    private final Integer useFetchType;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L14;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.afterWindVanePage, r4.afterWindVanePage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.useFetchType, r4.useFetchType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unExposeSkew, r4.unExposeSkew) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.pageName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.afterWindVanePage;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.useFetchType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.unExposeSkew;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "FetchGYLByBehaviorConfig(pageName=" + this.pageName + ", afterWindVanePage=" + this.afterWindVanePage + ", useFetchType=" + this.useFetchType + ", unExposeSkew=" + this.unExposeSkew + ")";
    }

    public final Integer b() {
        return this.unExposeSkew;
    }

    public f(Object r2) {
        this.pageName = null;
        this.afterWindVanePage = null;
        this.useFetchType = null;
        this.unExposeSkew = 2;
    }

    public final int a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "pageName");
        Lazy r0 = ECMallGulPrefetch.h;
        Integer r1 = ECMallGulPrefetch.Companion.a().e();
        if (r1 != null) goto L6;
    L8:
        List<String> r2 = this.pageName;
        if (r2 != null) goto L11;
    L13:
        return 0;
    L11:
        if (r2.contains(r4) != true) goto L13;
        return 1;
    L6:
        if (r1.intValue() != 1) goto L8;
        return 0;
    }
}
