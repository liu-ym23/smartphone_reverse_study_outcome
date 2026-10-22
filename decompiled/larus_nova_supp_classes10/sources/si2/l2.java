package si2;

import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l2 implements am3.c<RequestInfo> {
    public l2() {
    }

    public static RequestInfo a(am3.g r13) throws Exception {
        RequestInfo r0 = new RequestInfo();
        r0.pop = new HashMap();
        r0.intro = new HashMap();
        r0.list = new HashMap();
        long r1 = r13.c();
    L3:
        int r3 = r13.f();
        if (r3 == (-1)) goto L59;
        Integer r9 = null;
        if (r3 != 1) goto L7;
        long r10 = r13.c();
        Request r4 = null;
    L44:
        int r12 = r13.f();
        if (r12 == (-1)) goto L51;
        if (r12 != 1) goto L47;
        r9 = Integer.valueOf(r13.i());
        goto L44
    L47:
        if (r12 != 2) goto L44;
        r4 = m2.a(r13);
        goto L44
    L51:
        r13.d(r10);
        if (r9 == null) goto L58;
        if (r4 == null) goto L56;
        r0.list.put(r9, r4);
        goto L3
    L56:
        throw new IllegalStateException("Map value must not be null!");
    L58:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r3 != 2) goto L9;
        long r11 = r13.c();
        Request r5 = null;
    L28:
        int r14 = r13.f();
        if (r14 == (-1)) goto L35;
        if (r14 != 1) goto L31;
        r9 = Integer.valueOf(r13.i());
        goto L28
    L31:
        if (r14 != 2) goto L28;
        r5 = m2.a(r13);
        goto L28
    L35:
        r13.d(r11);
        if (r9 == null) goto L42;
        if (r5 == null) goto L40;
        r0.pop.put(r9, r5);
        goto L3
    L40:
        throw new IllegalStateException("Map value must not be null!");
    L42:
        throw new IllegalStateException("Map key must not be null!");
    L9:
        if (r3 != 3) goto L10;
        long r15 = r13.c();
        Request r6 = null;
    L12:
        int r16 = r13.f();
        if (r16 == (-1)) goto L19;
        if (r16 != 1) goto L15;
        r9 = Integer.valueOf(r13.i());
        goto L12
    L15:
        if (r16 != 2) goto L12;
        r6 = m2.a(r13);
        goto L12
    L19:
        r13.d(r15);
        if (r9 == null) goto L26;
        if (r6 == null) goto L24;
        r0.intro.put(r9, r6);
        goto L3
    L24:
        throw new IllegalStateException("Map value must not be null!");
    L26:
        throw new IllegalStateException("Map key must not be null!");
    L10:
        am3.h.e(r13);
        goto L3
    L59:
        r13.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
