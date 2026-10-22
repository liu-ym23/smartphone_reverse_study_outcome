package si2;

import com.bytedance.android.livesdk.livecommerce.model.Request;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m2 implements am3.c<Request> {
    public m2() {
    }

    public static Request a(am3.g r11) throws Exception {
        Request r0 = new Request();
        r0.params = new HashMap();
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L30;
        if (r3 != 1) goto L8;
        r0.path = am3.h.c(r11);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        long r7 = r11.c();
        String r4 = null;
        String r9 = null;
    L14:
        int r10 = r11.f();
        if (r10 == (-1)) goto L21;
        if (r10 != 1) goto L17;
        r4 = am3.h.c(r11);
        goto L14
    L17:
        if (r10 != 2) goto L14;
        r9 = am3.h.c(r11);
        goto L14
    L21:
        r11.d(r7);
        if (r4 == null) goto L28;
        if (r9 == null) goto L26;
        r0.params.put(r4, r9);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L10:
        if (r3 != 3) goto L11;
        r0.delayParam = y0.a(r11);
        goto L3
    L11:
        am3.h.e(r11);
        goto L3
    L30:
        r11.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
