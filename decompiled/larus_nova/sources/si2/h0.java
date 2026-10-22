package si2;

import com.bytedance.android.livesdk.livecommerce.model.AtmosphereInfo;
import com.bytedance.android.livesdk.livecommerce.model.ProductAtmosphere;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class h0 implements am3.c<AtmosphereInfo> {
    public h0() {
    }

    public static AtmosphereInfo a(am3.g r110) throws Exception {
        AtmosphereInfo r100 = new AtmosphereInfo();
        r100.atmosphere = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L25;
        if (r102 != 1) goto L7;
        long r103 = r110.c();
        Integer r104 = null;
        ProductAtmosphere r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = Integer.valueOf(r110.i());
        goto L9
    L13:
        if (r106 != 2) goto L9;
        r105 = f2.a(r110);
        goto L9
    L17:
        r110.d(r103);
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r100.atmosphere.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Map value must not be null!");
    L24:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        am3.h.e(r110);
        goto L3
    L25:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final AtmosphereInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
