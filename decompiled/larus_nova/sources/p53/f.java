package p53;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPriceStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f527776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PromotionProductPriceStruct f527778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f527779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f527780f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f527775a, r101.f527775a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527776b, r101.f527776b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f527777c, r101.f527777c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527778d, r101.f527778d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f527779e, r101.f527779e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f527780f, r101.f527780f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f527775a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f527776b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f527777c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        PromotionProductPriceStruct r110 = this.f527778d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f527779e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f527780f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "ProductCardVO(productId=" + this.f527775a + ", icon=" + this.f527776b + ", title=" + this.f527777c + ", price=" + this.f527778d + ", statusText=" + this.f527779e + ", goodRatio=" + this.f527780f + ")";
    }

    public f(String r100, ECUrlModel r101, String r102, PromotionProductPriceStruct r103, String r104, String r105) {
        this.f527775a = r100;
        this.f527776b = r101;
        this.f527777c = r102;
        this.f527778d = r103;
        this.f527779e = r104;
        this.f527780f = r105;
    }
}
