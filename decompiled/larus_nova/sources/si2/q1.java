package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2SkuInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedSkuInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class q1 implements am3.c<ECV2UpdatedSkuInfo> {
    public q1() {
    }

    public static ECV2UpdatedSkuInfo a(am3.g r110) throws Exception {
        ECV2UpdatedSkuInfo r100 = new ECV2UpdatedSkuInfo();
        r100.skus = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L35;
        if (r102 != 1) goto L7;
        long r103 = r110.c();
        String r104 = null;
        ECV2SkuInfo r105 = null;
    L20:
        int r111 = r110.f();
        if (r111 == (-1)) goto L27;
        if (r111 != 1) goto L23;
        r104 = am3.h.c(r110);
        goto L20
    L23:
        if (r111 != 2) goto L20;
        r105 = j1.a(r110);
        goto L20
    L27:
        r110.d(r103);
        if (r104 == null) goto L34;
        if (r105 == null) goto L32;
        r100.skus.put(r104, r105);
        goto L3
    L32:
        throw new IllegalStateException("Map value must not be null!");
    L34:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r102 != 2) goto L9;
        r100.minPrice = r110.j();
        goto L3
    L9:
        if (r102 != 3) goto L11;
        r100.maxPrice = r110.j();
        goto L3
    L11:
        if (r102 != 4) goto L13;
        r100.unUseMinPrice = r110.j();
        goto L3
    L13:
        if (r102 != 5) goto L14;
        r100.couponPrice = r110.j();
        goto L3
    L14:
        am3.h.e(r110);
        goto L3
    L35:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final ECV2UpdatedSkuInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
