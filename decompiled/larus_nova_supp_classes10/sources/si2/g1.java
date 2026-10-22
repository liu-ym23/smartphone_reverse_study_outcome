package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2RedirectData;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g1 implements am3.c<ECV2RedirectData> {
    public g1() {
    }

    public static ECV2RedirectData a(am3.g r11) throws Exception {
        ECV2RedirectData r0 = new ECV2RedirectData();
        r0.route = new HashMap();
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L25;
        if (r3 != 1) goto L7;
        long r6 = r11.c();
        String r4 = null;
        String r8 = null;
    L9:
        int r9 = r11.f();
        if (r9 == (-1)) goto L17;
        if (r9 != 1) goto L13;
        r4 = am3.h.c(r11);
        goto L9
    L13:
        if (r9 != 2) goto L9;
        r8 = am3.h.c(r11);
        goto L9
    L17:
        r11.d(r6);
        if (r4 == null) goto L24;
        if (r8 == null) goto L22;
        r0.route.put(r4, r8);
        goto L3
    L22:
        throw new IllegalStateException("Map value must not be null!");
    L24:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        am3.h.e(r11);
        goto L3
    L25:
        r11.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
