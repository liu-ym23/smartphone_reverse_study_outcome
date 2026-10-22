package com.bytedance.locallife.live.goodsshelves.processor;

import com.bytedance.locallife.live.goodsshelves.bean.i0;
import com.bytedance.locallife.live.goodsshelves.bean.t;
import com.bytedance.locallife.live.goodsshelves.bean.u;
import com.bytedance.locallife.live.goodsshelves.bean.x;
import ev6.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements a<ev6.h> {
    public f() {
    }

    @Override // com.bytedance.locallife.live.goodsshelves.processor.a
    public final b a(i0 r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, "businessData");
        ev6.h r112 = new ev6.h(null);
        u r113 = r110.i();
        if (r113 == null) goto L36;
        t r100 = r113.d();
        if (r100 == null) goto L11;
        List<String> r101 = r100.c();
        if (r101 == null) goto L11;
        String r102 = (String) CollectionsKt.getOrNull(r101, 0);
        if (r102 == null) goto L11;
        r112.f474320b = new ev6.f(r102, r100.d(), r100.a());
    L11:
        List<t> r103 = r113.a();
        String r104 = "";
        if (r103 == null) goto L26;
        List<t> r105 = r103;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L15:
        if (r107.hasNext() == false) goto L25;
        t r108 = (t) r107.next();
        List<String> r109 = r108.c();
        if (r109 == null) goto L20;
        String r114 = (String) CollectionsKt.getOrNull(r109, 0);
        if (r114 == null) goto L20;
    L21:
        ev6.f r115 = new ev6.f(r114, r108.d(), r108.a());
        String r116 = r108.b();
        if (r116 != null) goto L24;
        r116 = "";
    L24:
        r106.add(new ev6.g(r115, new n0(r116, null, 126)));
    L20:
        r114 = "";
        goto L21
    L25:
        r112.f474321c = r106;
    L26:
        x r117 = r113.c();
        if (r117 == null) goto L30;
        String r118 = r117.e();
        if (r118 == null) goto L30;
    L31:
        r112.f474322d = r118;
        String r119 = r113.b();
        if (r119 == null) goto L35;
        r104 = r119;
    L35:
        r112.f474323e = MapsKt.mapOf(TuplesKt.to("jump_url", r104));
        r112.f474319a = new ev6.h.a(true);
    L30:
        r118 = "";
    L36:
        return r112;
    }
}
