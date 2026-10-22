package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2SkuInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedSkuInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q1 implements am3.c<ECV2UpdatedSkuInfo> {
    public q1() {
    }

    public static ECV2UpdatedSkuInfo a(am3.g r11) throws Exception {
        ECV2UpdatedSkuInfo r0 = new ECV2UpdatedSkuInfo();
        r0.skus = new HashMap();
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L35;
        if (r3 != 1) goto L7;
        long r7 = r11.c();
        String r4 = null;
        ECV2SkuInfo r9 = null;
    L20:
        int r10 = r11.f();
        if (r10 == (-1)) goto L27;
        if (r10 != 1) goto L23;
        r4 = am3.h.c(r11);
        goto L20
    L23:
        if (r10 != 2) goto L20;
        r9 = j1.a(r11);
        goto L20
    L27:
        r11.d(r7);
        if (r4 == null) goto L34;
        if (r9 == null) goto L32;
        r0.skus.put(r4, r9);
        goto L3
    L32:
        throw new IllegalStateException("Map value must not be null!");
    L34:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r3 != 2) goto L9;
        r0.minPrice = r11.j();
        goto L3
    L9:
        if (r3 != 3) goto L11;
        r0.maxPrice = r11.j();
        goto L3
    L11:
        if (r3 != 4) goto L13;
        r0.unUseMinPrice = r11.j();
        goto L3
    L13:
        if (r3 != 5) goto L14;
        r0.couponPrice = r11.j();
        goto L3
    L14:
        am3.h.e(r11);
        goto L3
    L35:
        r11.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
