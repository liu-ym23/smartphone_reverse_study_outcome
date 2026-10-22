package com.bytedance.locallife.live.goodsshelves.processor;

import com.bytedance.locallife.live.goodsshelves.bean.i0;
import com.bytedance.locallife.live.goodsshelves.bean.n;
import com.bytedance.locallife.live.goodsshelves.bean.t;
import com.bytedance.locallife.live.goodsshelves.bean.x;
import com.bytedance.locallife.live.util.w;
import ev6.n0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements a<ev6.c> {
    public c() {
    }

    @Override // com.bytedance.locallife.live.goodsshelves.processor.a
    public final b a(i0 r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, "businessData");
        boolean r100 = false;
        ev6.c r101 = new ev6.c(0);
        String r102 = com.bytedance.locallife.live.goodsshelves.helper.d.b();
        Map<String, n> r112 = r110.d();
        if (r112 == null) goto L75;
        n r113 = r112.get(r102);
        if (r113 == null) goto L75;
        if (r111 == null) goto L14;
        Integer r114 = w.b(r111, "is_top_explain");
        if (r114 == null) goto L14;
        if (r114.intValue() != 1) goto L14;
        boolean r115 = true;
    L15:
        if (r115 == false) goto L19;
        Integer r103 = r113.e();
        if (r103 != null) goto L20;
        r103 = r113.g();
    L20:
        if (r103 == null) goto L22;
        int r104 = r103.intValue();
    L23:
        if (r115 == false) goto L27;
        Integer r116 = r113.d();
        if (r116 != null) goto L28;
        r116 = r113.f();
    L28:
        if (r116 == null) goto L30;
        int r117 = r116.intValue();
    L32:
        if (Intrinsics.areEqual(r113.h(), Boolean.TRUE) == false) goto L75;
        if (r104 != 1) goto L74;
        t r105 = r113.a();
        if (r105 == null) goto L48;
        List<String> r106 = r105.c();
        if (r106 == null) goto L39;
        String r107 = (String) CollectionsKt.getOrNull(r106, 0);
    L40:
        if (r107 != null) goto L42;
    L45:
        boolean r108 = true;
    L46:
        if (r108 == true) goto L48;
        r101.f474276b = new ev6.f(r107, r105.d(), r105.a());
        goto L48
    L42:
        if (r107.length() == 0) goto L45;
        r108 = false;
        goto L46
    L39:
        r107 = null;
    L48:
        x r109 = r113.b();
        if (r109 == null) goto L59;
        String r118 = r109.e();
        if (r118 != null) goto L53;
    L56:
        boolean r119 = true;
    L57:
        if (r119 == true) goto L59;
        r101.f474277c = new n0(r118, null, 126);
        goto L59
    L53:
        if (r118.length() == 0) goto L56;
        r119 = false;
    L59:
        x r120 = r113.c();
        if (r120 == null) goto L71;
        String r121 = r120.e();
        if (r121 != null) goto L64;
    L67:
        boolean r122 = true;
    L68:
        if (r122 == true) goto L71;
        r101.f474278d = new n0(r121, null, 126);
        goto L71
    L64:
        if (r121.length() == 0) goto L67;
        r122 = false;
    L71:
        if (r101.f474277c == null) goto L73;
        r100 = true;
    L73:
        r101.f474275a = new ev6.c.a(r100, 10.0f, r104, r117);
        goto L75
    L74:
        r101.f474275a = new ev6.c.a(r104, r117, 2);
        goto L75
    L30:
        r117 = 1;
        goto L32
    L27:
        r116 = r113.f();
        goto L28
    L22:
        r104 = 1;
        goto L23
    L19:
        r103 = r113.g();
    L14:
        r115 = false;
    L75:
        return r101;
    }
}
