package com.bytedance.locallife.live.goodsshelves.processor;

import com.bytedance.locallife.live.goodsshelves.bean.d0;
import com.bytedance.locallife.live.goodsshelves.bean.i0;
import com.bytedance.locallife.live.goodsshelves.bean.x;
import com.bytedance.locallife.live.util.s;
import ev6.b0;
import ev6.n0;
import ev6.p;
import ev6.q;
import ev6.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements a<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<?>> f259763a;

    public i() {
        ArrayList r100 = new ArrayList();
        this.f259763a = r100;
        r100.add(new g());
        r100.add(new j());
    }

    @Override // com.bytedance.locallife.live.goodsshelves.processor.a
    public final b a(i0 r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, "businessData");
        p r100 = new p(0);
        Iterator r101 = ((ArrayList) this.f259763a).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        b r102 = ((a) r101.next()).a(r110, r111);
        if ((r102 instanceof ev6.j) == true) goto L7;
        if ((r102 instanceof b0) == false) goto L4;
        r100.f474410c = (b0) r102;
        goto L4
    L7:
        r100.f474408a = (ev6.j) r102;
        goto L4
    L11:
        ev6.j r112 = r100.f474408a;
        ev6.j.a r103 = null;
        if (r112 == null) goto L14;
        q r104 = r112.f474347e;
    L15:
        if (r104 != null) goto L33;
        if (r112 == null) goto L18;
        q r105 = r112.f474346d;
    L19:
        if (r105 != null) goto L33;
        if (r112 == null) goto L22;
        r r106 = r112.f474348f;
    L23:
        if (r106 != null) goto L33;
        d0 r113 = r110.k();
        if (r113 == null) goto L29;
        List<x> r114 = r113.a();
        if (r114 == null) goto L29;
        String r115 = CollectionsKt.joinToString$default(r114, null, null, null, 0, null, ShelfProductInfoContainerProcessor$process$soldCountContent$1.INSTANCE, 31, null);
    L31:
        if (s.d(r115) == false) goto L33;
        Intrinsics.checkNotNull(r115);
        r100.f474409b = new n0(r115, null, 126);
    L29:
        r115 = null;
        goto L31
    L22:
        r106 = null;
        goto L23
    L18:
        r105 = null;
    L33:
        b0 r116 = r100.f474410c;
        if (r116 == null) goto L38;
        b0.a r117 = r116.f474265a;
        if (r117 == null) goto L38;
        float r107 = 116.0f - r117.f474271b;
    L39:
        if (r112 == null) goto L41;
        r103 = r112.f474343a;
    L41:
        if (r103 == null) goto L44;
        r103.f474350b = r107;
    L44:
        return r100;
    L38:
        r107 = 76.0f;
        goto L39
    L14:
        r104 = null;
        goto L15
    }
}
