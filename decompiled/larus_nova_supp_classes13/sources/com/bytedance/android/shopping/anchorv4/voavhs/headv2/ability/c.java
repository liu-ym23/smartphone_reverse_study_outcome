package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ a a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ boolean c;

    public final void a(String r5, Map<Object, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        AnchorV4HeadV2VO r1 = this.a.b.K10();
        if (r1 == null) goto L7;
        Map<String, String> r2 = r1.getTrackMeta();
        if (r2 == null) goto L7;
        r0.putAll(r2);
    L7:
        Map r3 = this.b;
        if (r3 == null) goto L10;
        r0.putAll(r3);
    L10:
        ArrayList r4 = new ArrayList(r6.size());
        Iterator r7 = ((LinkedHashMap) r6).entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Map.Entry r8 = (Map.Entry) r7.next();
        r4.add(TuplesKt.to(r8.getKey().toString(), r8.getValue()));
        goto L12
    L14:
        MapsKt.putAll(r0, r4);
        this.a.b.rR().o0(r5, r0, this.c);
    }

    public c(a r1, Map r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
