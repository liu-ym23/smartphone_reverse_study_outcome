package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.ContainerTrackAbility;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ h a;
    public final /* synthetic */ jq.a b;
    public final /* synthetic */ Map c;

    public final void a(String r8, Map<Object, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        Map r1 = this.c;
        if (r1 == null) goto L5;
        r0.putAll(r1);
    L5:
        Map r2 = this.b.i();
        if (r2 == null) goto L8;
        r0.putAll(r2);
    L8:
        ArrayList r3 = new ArrayList(r9.size());
        Iterator r10 = ((LinkedHashMap) r9).entrySet().iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r10.next();
        r3.add(TuplesKt.to(r4.getKey().toString(), r4.getValue()));
        goto L10
    L12:
        MapsKt.putAll(r0, r3);
        ContainerTrackAbility.a r5 = this.a.a.a().m();
        r5.a = r0;
        m.a.a(r5, r8, false, null, null, 14);
    }

    public i(h r1, jq.a r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
