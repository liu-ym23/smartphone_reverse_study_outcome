package si2;

import com.bytedance.android.livesdk.livecommerce.model.Request;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class m2 implements am3.c<Request> {
    public m2() {
    }

    public static Request a(am3.g r110) throws Exception {
        Request r100 = new Request();
        r100.params = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L30;
        if (r102 != 1) goto L8;
        r100.path = am3.h.c(r110);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L14:
        int r111 = r110.f();
        if (r111 == (-1)) goto L21;
        if (r111 != 1) goto L17;
        r104 = am3.h.c(r110);
        goto L14
    L17:
        if (r111 != 2) goto L14;
        r105 = am3.h.c(r110);
        goto L14
    L21:
        r110.d(r103);
        if (r104 == null) goto L28;
        if (r105 == null) goto L26;
        r100.params.put(r104, r105);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L10:
        if (r102 != 3) goto L11;
        r100.delayParam = y0.a(r110);
        goto L3
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final Request decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
