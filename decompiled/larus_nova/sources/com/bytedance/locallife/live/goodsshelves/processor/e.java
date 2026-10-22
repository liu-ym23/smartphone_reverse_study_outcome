package com.bytedance.locallife.live.goodsshelves.processor;

import com.bytedance.locallife.live.goodsshelves.bean.i0;
import ev6.o;
import ev6.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements a<ev6.e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<?>> f259762a;

    public e() {
        ArrayList r100 = new ArrayList();
        this.f259762a = r100;
        r100.add(new h());
        r100.add(new i());
    }

    @Override // com.bytedance.locallife.live.goodsshelves.processor.a
    public final b a(i0 r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "businessData");
        ev6.e r102 = new ev6.e(0);
        Iterator r103 = ((ArrayList) this.f259762a).iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        b r104 = ((a) r103.next()).a(r100, r101);
        if ((r104 instanceof o) == true) goto L7;
        if ((r104 instanceof p) == false) goto L4;
        r102.f474303b = (p) r104;
        goto L4
    L7:
        r102.f474302a = (o) r104;
        goto L4
    L11:
        return r102;
    }
}
