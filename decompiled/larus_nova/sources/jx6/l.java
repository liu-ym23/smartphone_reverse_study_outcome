package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ljx6/l;", "", "", "type", "I", "getType", "()I", "totalCount", "b", "", "Ljx6/c0;", "tabVOList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("itemTabList")
    private final List<c0> tabVOList;

    @SerializedName("itemInfoTotal")
    private final int totalCount;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.totalCount == r101.totalCount) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabVOList, r101.tabVOList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.type * 31) + this.totalCount) * 31;
        List<c0> r101 = this.tabVOList;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "HeadImageTabVO(type=" + this.type + ", totalCount=" + this.totalCount + ", tabVOList=" + this.tabVOList + ')';
    }

    public l() {
        this.type = 0;
        this.totalCount = 0;
        this.tabVOList = null;
    }

    public final List<c0> a() {
        return this.tabVOList;
    }

    public final int b() {
        return this.totalCount;
    }

    public final int getType() {
        return this.type;
    }
}
