package h83;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ECUrlModel> f484086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f484087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScrollMoreText f484088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f484089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f484090e;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f484086a, r101.f484086a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f484087b, r101.f484087b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f484088c, r101.f484088c) == true) goto L12;
        return false;
    L12:
        if (this.f484089d == r101.f484089d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f484090e, r101.f484090e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        List<ECUrlModel> r100 = this.f484086a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f484087b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ScrollMoreText r107 = this.f484088c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f484089d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.f484090e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
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
        return "SkuVO(skuImageList=" + this.f484086a + ", skuTitleList=" + this.f484087b + ", scrollMoreText=" + this.f484088c + ", fullscreen=" + this.f484089d + ", findSameGoodsSchemaList=" + this.f484090e + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return this.f484086a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends ECUrlModel> r100, List<String> r101, ScrollMoreText r102, boolean r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "skuImageList");
        Intrinsics.checkNotNullParameter(r101, "skuTitleList");
        Intrinsics.checkNotNullParameter(r104, "findSameGoodsSchemaList");
        this.f484086a = r100;
        this.f484087b = r101;
        this.f484088c = r102;
        this.f484089d = r103;
        this.f484090e = r104;
    }
}
