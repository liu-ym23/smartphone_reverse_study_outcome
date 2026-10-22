package fi3;

import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f477347e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecommendInShopProductStruct f477348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f477350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f477351d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L14;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f477348a, r101.f477348a) == true) goto L8;
        return false;
    L8:
        if (this.f477349b == r101.f477349b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f477350c, r101.f477350c) == true) goto L12;
        return false;
    L12:
        if (this.f477351d == r101.f477351d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        RecommendInShopProductStruct r100 = this.f477348a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f477349b) * 31;
        Map<String, Object> r104 = this.f477350c;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f477351d;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPRecommendGoodsClickActionHandlerParam(clickedProduct=" + this.f477348a + ", index=" + this.f477349b + ", params=" + this.f477350c + ", isInstantRevision=" + this.f477351d + ")";
    }

    public y(RecommendInShopProductStruct r100, int r101, Map<String, ? extends Object> r102, boolean r103) {
        this.f477348a = r100;
        this.f477349b = r101;
        this.f477350c = r102;
        this.f477351d = r103;
    }
}
