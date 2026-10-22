package fi3;

import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f477237d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecommendInShopProductStruct f477238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f477240c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L12;
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f477238a, r101.f477238a) == true) goto L8;
        return false;
    L8:
        if (this.f477239b == r101.f477239b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477240c, r101.f477240c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        RecommendInShopProductStruct r100 = this.f477238a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f477239b) * 31;
        Map<String, Object> r104 = this.f477240c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPRecommendGoodsShowActionHandlerParam(showProduct=" + this.f477238a + ", index=" + this.f477239b + ", params=" + this.f477240c + ")";
    }

    public a0(RecommendInShopProductStruct r100, int r101, Map<String, ? extends Object> r102) {
        this.f477238a = r100;
        this.f477239b = r101;
        this.f477240c = r102;
    }
}
