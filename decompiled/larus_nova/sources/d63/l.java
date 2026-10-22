package d63;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.Product3DEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.ProductArEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionReplayInfo;
import com.bytedance.android.shopping.anchorv3.view.z;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l extends VOIdentifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f63.a> f467152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f467153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PromotionReplayInfo f467154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Product3DEntryStruct f467155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProductArEntryStruct f467156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final fj.d f467157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECUrlModel f467158h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L20;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f467152b, r101.f467152b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f467153c, r101.f467153c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f467154d, r101.f467154d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467155e, r101.f467155e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f467156f, r101.f467156f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f467157g, r101.f467157g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f467158h, r101.f467158h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        List<f63.a> r100 = this.f467152b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        z r104 = this.f467153c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        PromotionReplayInfo r107 = this.f467154d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Product3DEntryStruct r110 = this.f467155e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ProductArEntryStruct r113 = this.f467156f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        fj.d r116 = this.f467157g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ECUrlModel r119 = this.f467158h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
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
        return "HeaderBannerVO(images=" + this.f467152b + ", liveVO=" + this.f467153c + ", replayInfo=" + this.f467154d + ", m3DEntryInfo=" + this.f467155e + ", arEntryInfo=" + this.f467156f + ", productVideo=" + this.f467157g + ", atmosphereImage=" + this.f467158h + ")";
    }

    public l(List<f63.a> r100, z r101, PromotionReplayInfo r102, Product3DEntryStruct r103, ProductArEntryStruct r104, fj.d r105, ECUrlModel r106) {
        Intrinsics.checkNotNullParameter(r100, "images");
        this.f467152b = r100;
        this.f467153c = r101;
        this.f467154d = r102;
        this.f467155e = r103;
        this.f467156f = r104;
        this.f467157g = r105;
        this.f467158h = r106;
    }
}
