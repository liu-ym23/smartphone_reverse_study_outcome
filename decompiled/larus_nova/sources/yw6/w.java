package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lyw6/w;", "", "", "enable", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "", "valueDiffWhiteList", "Ljava/util/List;", "c", "()Ljava/util/List;", "valueDiffBlackList", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("valueDiffBlackList")
    private final List<String> valueDiffBlackList;

    @SerializedName("valueDiffWhiteList")
    private final List<String> valueDiffWhiteList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.valueDiffWhiteList, r101.valueDiffWhiteList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.valueDiffBlackList, r101.valueDiffBlackList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.valueDiffWhiteList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.valueDiffBlackList;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiGoodsDetailTrackerDetection(enable=" + this.enable + ", valueDiffWhiteList=" + this.valueDiffWhiteList + ", valueDiffBlackList=" + this.valueDiffBlackList + ')';
    }

    public w() {
        this(Boolean.FALSE, null, null);
    }

    public final Boolean a() {
        return this.enable;
    }

    public final List<String> b() {
        return this.valueDiffBlackList;
    }

    public final List<String> c() {
        return this.valueDiffWhiteList;
    }

    public w(Boolean r100, List<String> r101, List<String> r102) {
        this.enable = r100;
        this.valueDiffWhiteList = r101;
        this.valueDiffBlackList = r102;
    }
}
