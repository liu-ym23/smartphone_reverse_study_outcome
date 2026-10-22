package he3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lhe3/l0;", "", "", "", "mainImage", "Ljava/util/List;", "b", "()Ljava/util/List;", "displayImage", "a", "shopLogo", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName("display_image")
    private final List<String> displayImage;

    @SerializedName("main_image")
    private final List<String> mainImage;

    @SerializedName("shop_logo")
    private final List<String> shopLogo;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l0) == false) goto L12;
        l0 r4 = (l0) r3;
        if (Intrinsics.areEqual(this.mainImage, r4.mainImage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.displayImage, r4.displayImage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.shopLogo, r4.shopLogo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.mainImage;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.displayImage;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.shopLogo;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
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
