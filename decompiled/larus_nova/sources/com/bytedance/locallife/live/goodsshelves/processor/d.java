package com.bytedance.locallife.live.goodsshelves.processor;

import com.bytedance.locallife.live.goodsshelves.bean.i0;
import com.bytedance.locallife.live.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements a<ev6.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<?>> f259761a;

    public d() {
        ArrayList r100 = new ArrayList();
        this.f259761a = r100;
        r100.add(new c());
        r100.add(new e());
        r100.add(new f());
    }

    @Override // com.bytedance.locallife.live.goodsshelves.processor.a
    public final /* bridge */ /* synthetic */ b a(i0 r100, Map r101) {
        return b(r100, r101);
    }

    public final ev6.d b(i0 r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r110, "businessData");
        boolean r100 = false;
        ev6.d r101 = new ev6.d(0);
        Iterator r102 = ((ArrayList) this.f259761a).iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        b r103 = ((a) r102.next()).a(r110, r111);
        if ((r103 instanceof ev6.c) == true) goto L7;
        if ((r103 instanceof ev6.e) == true) goto L10;
        if ((r103 instanceof ev6.h) == false) goto L4;
        r101.f474291d = (ev6.h) r103;
        goto L4
    L10:
        r101.f474290c = (ev6.e) r103;
        goto L4
    L7:
        r101.f474289b = (ev6.c) r103;
        goto L4
    L14:
        ev6.d.a r112 = new ev6.d.a(0);
        ev6.c r104 = r101.f474289b;
        if (r104 == null) goto L17;
        ev6.c.a r105 = r104.f474275a;
    L18:
        float r106 = 12.0f;
        if (r105 == null) goto L40;
        int r107 = r105.f474281c;
        float r108 = 138.0f;
        float r109 = 0.0f;
        if (r107 != 1) goto L34;
        float r113 = 170.0f;
        if (r105.f474282d <= 1) goto L30;
        if (r105.f474279a == true) goto L28;
        r113 = 138.0f;
    L28:
        float r114 = 12.0f;
    L39:
        float r115 = r114;
        r109 = r106;
        float r116 = 0.0f;
        r106 = 0.0f;
        float r117 = 0.0f;
    L41:
        ev6.h r118 = r101.f474291d;
        if (r118 == null) goto L48;
        ev6.h.a r119 = r118.f474319a;
        if (r119 == null) goto L48;
        if (r119.f474324a != true) goto L48;
        boolean r120 = true;
    L49:
        if (r120 == false) goto L51;
        r108 = r108 + 65.0f;
        r113 = r113 + 65.0f;
    L51:
        r112.f474292a = r113;
        r112.f474293b = r117;
        r112.f474296e = r109;
        r112.f474297f = r115;
        r112.f474298g = r106;
        r112.f474299h = r116;
        r112.f474294c = r108;
        if (r111 == null) goto L59;
        Integer r121 = w.b(r111, "is_top_explain");
        if (r121 == null) goto L59;
        if (r121.intValue() != 1) goto L59;
        r100 = true;
    L59:
        if (r100 == false) goto L61;
        String r122 = "#FE2C550D";
    L62:
        Intrinsics.checkNotNullParameter(r122, "<set-?>");
        r112.f474295d = r122;
        r101.f474288a = r112;
        return r101;
    L61:
        r122 = "#FFFFFFFF";
    L48:
        r120 = false;
        goto L49
    L30:
        if (r105.f474279a == true) goto L33;
        r113 = 138.0f;
    L33:
        r116 = 12.0f;
        r115 = 12.0f;
        r109 = 12.0f;
        r117 = 8.0f;
        goto L41
    L34:
        if (r107 <= 1) goto L40;
        if (r105.f474282d != r107) goto L38;
        r116 = 12.0f;
        r115 = 0.0f;
        r113 = 138.0f;
        r117 = 10.0f;
        goto L41
    L38:
        r114 = 0.0f;
        r106 = 0.0f;
        r113 = 138.0f;
    L40:
        r108 = 136.0f;
        r116 = 12.0f;
        r115 = 12.0f;
        r109 = 12.0f;
        r113 = 136.0f;
        r117 = 6.0f;
        goto L41
    L17:
        r105 = null;
        goto L18
    }
}
