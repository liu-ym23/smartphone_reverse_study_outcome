package f73;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lf73/a;", "", "", "geckoAddress", "Ljava/lang/String;", "getGeckoAddress", "()Ljava/lang/String;", "", "width", "I", "getWidth", "()I", "height", "getHeight", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("gecko_address")
    private final String geckoAddress;

    @SerializedName("height")
    private final int height;

    @SerializedName("width")
    private final int width;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.geckoAddress, r101.geckoAddress) == true) goto L8;
        return false;
    L8:
        if (this.width == r101.width) goto L10;
        return false;
    L10:
        if (this.height == r101.height) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.geckoAddress;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.width) * 31) + this.height;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "GeckoImage(geckoAddress=" + this.geckoAddress + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public a() {
        this.geckoAddress = null;
        this.width = 0;
        this.height = 0;
    }
}
