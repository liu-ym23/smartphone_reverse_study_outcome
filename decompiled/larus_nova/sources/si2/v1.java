package si2;

import com.bytedance.android.livesdk.livecommerce.model.IntelligentPopMessage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class v1 implements am3.c<IntelligentPopMessage> {
    public v1() {
    }

    @Override // am3.c
    public final IntelligentPopMessage decode(am3.g r110) throws Exception {
        IntelligentPopMessage r100 = new IntelligentPopMessage();
        r100.params = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L42;
        if (r102 != 1) goto L8;
        r100.msgType = r110.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        r100.bubbleType = r110.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        r100.promotionId = r110.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        r100.delayParam = y0.a(r110);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L23:
        int r111 = r110.f();
        if (r111 == (-1)) goto L30;
        if (r111 != 1) goto L26;
        r104 = am3.h.c(r110);
        goto L23
    L26:
        if (r111 != 2) goto L23;
        r105 = am3.h.c(r110);
        goto L23
    L30:
        r110.d(r103);
        if (r104 == null) goto L37;
        if (r105 == null) goto L35;
        r100.params.put(r104, r105);
        goto L3
    L35:
        throw new IllegalStateException("Map value must not be null!");
    L37:
        throw new IllegalStateException("Map key must not be null!");
    L16:
        if (r102 != 10) goto L18;
        r100.listTopPath = am3.h.c(r110);
        goto L3
    L18:
        if (r102 != 11) goto L19;
        r100.popPath = am3.h.c(r110);
        goto L3
    L19:
        am3.h.e(r110);
        goto L3
    L42:
        r110.d(r101);
        return r100;
    }
}
