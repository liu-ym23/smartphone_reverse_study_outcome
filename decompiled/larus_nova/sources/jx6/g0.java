package jx6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ljx6/g0;", "", "Ljx6/f0;", "userBasicInfo", "Ljx6/f0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljx6/f0;", "", "Ljx6/f;", "userTagList", "Ljava/util/List;", "b", "()Ljava/util/List;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("user_basic_info")
    private final f0 userBasicInfo;

    @SerializedName("user_tags_v2")
    private final List<f> userTagList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.userBasicInfo, r101.userBasicInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userTagList, r101.userTagList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        f0 r100 = this.userBasicInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<f> r104 = this.userTagList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserInfo(userBasicInfo=" + this.userBasicInfo + ", userTagList=" + this.userTagList + ')';
    }

    public g0() {
        this.userBasicInfo = null;
        this.userTagList = null;
    }

    public final f0 a() {
        return this.userBasicInfo;
    }

    public final List<f> b() {
        return this.userTagList;
    }
}
