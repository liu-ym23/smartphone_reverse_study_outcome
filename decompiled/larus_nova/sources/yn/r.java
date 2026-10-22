package yn;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lyn/r;", "", "", "productCountText", "Ljava/lang/String;", "getProductCountText", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "productCovers", "Ljava/util/List;", "b", "()Ljava/util/List;", "viewers", "getViewers", "likes", "getLikes", "", "productCounts", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("likes")
    private final String likes;

    @SerializedName("product_count_text")
    private final String productCountText;

    @SerializedName("product_counts")
    private final Integer productCounts;

    @SerializedName("product_covers")
    private final List<ECUrlModel> productCovers;

    @SerializedName("viewers")
    private final String viewers;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L16;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.productCountText, r101.productCountText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productCovers, r101.productCovers) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.viewers, r101.viewers) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.likes, r101.likes) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productCounts, r101.productCounts) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.productCountText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ECUrlModel> r104 = this.productCovers;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.viewers;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.likes;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.productCounts;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowLiveProductDTO(productCountText=" + this.productCountText + ", productCovers=" + this.productCovers + ", viewers=" + this.viewers + ", likes=" + this.likes + ", productCounts=" + this.productCounts + ")";
    }

    public r() {
        this.productCountText = null;
        this.productCovers = null;
        this.viewers = null;
        this.likes = null;
        this.productCounts = null;
    }

    public final Integer a() {
        return this.productCounts;
    }

    public final List<ECUrlModel> b() {
        return this.productCovers;
    }
}
