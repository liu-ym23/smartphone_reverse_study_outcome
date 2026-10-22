package si2;

import com.bytedance.android.livesdk.livecommerce.model.IntelligentPopMessage;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v1 implements am3.c<IntelligentPopMessage> {
    public v1() {
    }

    public final Object decode(am3.g r12) throws Exception {
        IntelligentPopMessage r0 = new IntelligentPopMessage();
        r0.params = new HashMap();
        long r1 = r12.c();
    L3:
        int r3 = r12.f();
        if (r3 == (-1)) goto L42;
        if (r3 != 1) goto L8;
        r0.msgType = r12.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.bubbleType = r12.i();
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.promotionId = r12.j();
        goto L3
    L12:
        if (r3 != 4) goto L14;
        r0.delayParam = y0.a(r12);
        goto L3
    L14:
        if (r3 != 5) goto L16;
        long r7 = r12.c();
        String r4 = null;
        String r9 = null;
    L23:
        int r10 = r12.f();
        if (r10 == (-1)) goto L30;
        if (r10 != 1) goto L26;
        r4 = am3.h.c(r12);
        goto L23
    L26:
        if (r10 != 2) goto L23;
        r9 = am3.h.c(r12);
        goto L23
    L30:
        r12.d(r7);
        if (r4 == null) goto L37;
        if (r9 == null) goto L35;
        r0.params.put(r4, r9);
        goto L3
    L35:
        throw new IllegalStateException("Map value must not be null!");
    L37:
        throw new IllegalStateException("Map key must not be null!");
    L16:
        if (r3 != 10) goto L18;
        r0.listTopPath = am3.h.c(r12);
        goto L3
    L18:
        if (r3 != 11) goto L19;
        r0.popPath = am3.h.c(r12);
        goto L3
    L19:
        am3.h.e(r12);
        goto L3
    L42:
        r12.d(r1);
        return r0;
    }
}
