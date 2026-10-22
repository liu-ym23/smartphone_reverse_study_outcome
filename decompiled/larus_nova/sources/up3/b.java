package up3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lup3/b;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "count", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("count")
    private final long count;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L8;
        return false;
    L8:
        if (this.count == r101.count) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.desc;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.count;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
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
