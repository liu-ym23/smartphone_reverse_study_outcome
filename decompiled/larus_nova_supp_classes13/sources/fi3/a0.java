package fi3;

import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a0 {
    public static final /* synthetic */ int d = 0;
    public final RecommendInShopProductStruct a;
    public final int b;
    public final Map<String, Object> c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a0) == false) goto L12;
        a0 r4 = (a0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        RecommendInShopProductStruct r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.b) * 31;
        Map<String, Object> r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPRecommendGoodsShowActionHandlerParam(showProduct=" + this.a + ", index=" + this.b + ", params=" + this.c + ")";
    }

    public a0(RecommendInShopProductStruct r1, int r2, Map<String, ? extends Object> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
