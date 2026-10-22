package he3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lhe3/l0;", "", "", "", "mainImage", "Ljava/util/List;", "b", "()Ljava/util/List;", "displayImage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "shopLogo", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName("display_image")
    private final List<String> displayImage;

    @SerializedName("main_image")
    private final List<String> mainImage;

    @SerializedName("shop_logo")
    private final List<String> shopLogo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L12;
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.mainImage, r101.mainImage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.displayImage, r101.displayImage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopLogo, r101.shopLogo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.mainImage;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.displayImage;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.shopLogo;
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
        return "DeepFeedSlcPreloadImage(mainImage=" + this.mainImage + ", displayImage=" + this.displayImage + ", shopLogo=" + this.shopLogo + ")";
    }

    public l0() {
        this.mainImage = null;
        this.displayImage = null;
        this.shopLogo = null;
    }

    public final List<String> a() {
        return this.displayImage;
    }

    public final List<String> b() {
        return this.mainImage;
    }

    public final List<String> c() {
        return this.shopLogo;
    }
}
