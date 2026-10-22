package si2;

import com.bytedance.android.livesdk.livecommerce.model.Request;
import com.bytedance.android.livesdk.livecommerce.model.RequestInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class l2 implements am3.c<RequestInfo> {
    public l2() {
    }

    public static RequestInfo a(am3.g r110) throws Exception {
        RequestInfo r100 = new RequestInfo();
        r100.pop = new HashMap();
        r100.intro = new HashMap();
        r100.list = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L59;
        Integer r103 = null;
        if (r102 != 1) goto L7;
        long r111 = r110.c();
        Request r104 = null;
    L44:
        int r112 = r110.f();
        if (r112 == (-1)) goto L51;
        if (r112 != 1) goto L47;
        r103 = Integer.valueOf(r110.i());
        goto L44
    L47:
        if (r112 != 2) goto L44;
        r104 = m2.a(r110);
        goto L44
    L51:
        r110.d(r111);
        if (r103 == null) goto L58;
        if (r104 == null) goto L56;
        r100.list.put(r103, r104);
        goto L3
    L56:
        throw new IllegalStateException("Map value must not be null!");
    L58:
        throw new IllegalStateException("Map key must not be null!");
    L7:
        if (r102 != 2) goto L9;
        long r113 = r110.c();
        Request r105 = null;
    L28:
        int r114 = r110.f();
        if (r114 == (-1)) goto L35;
        if (r114 != 1) goto L31;
        r103 = Integer.valueOf(r110.i());
        goto L28
    L31:
        if (r114 != 2) goto L28;
        r105 = m2.a(r110);
        goto L28
    L35:
        r110.d(r113);
        if (r103 == null) goto L42;
        if (r105 == null) goto L40;
        r100.pop.put(r103, r105);
        goto L3
    L40:
        throw new IllegalStateException("Map value must not be null!");
    L42:
        throw new IllegalStateException("Map key must not be null!");
    L9:
        if (r102 != 3) goto L10;
        long r115 = r110.c();
        Request r106 = null;
    L12:
        int r116 = r110.f();
        if (r116 == (-1)) goto L19;
        if (r116 != 1) goto L15;
        r103 = Integer.valueOf(r110.i());
        goto L12
    L15:
        if (r116 != 2) goto L12;
        r106 = m2.a(r110);
        goto L12
    L19:
        r110.d(r115);
        if (r103 == null) goto L26;
        if (r106 == null) goto L24;
        r100.intro.put(r103, r106);
        goto L3
    L24:
        throw new IllegalStateException("Map value must not be null!");
    L26:
        throw new IllegalStateException("Map key must not be null!");
    L10:
        am3.h.e(r110);
        goto L3
    L59:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final RequestInfo decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
