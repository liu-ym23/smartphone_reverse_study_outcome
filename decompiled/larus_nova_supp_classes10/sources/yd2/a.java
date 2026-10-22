package yd2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final HashMap<String, List<String>> a;

    public a() {
        this.a = new HashMap();
    }

    public final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "dressId");
        List<String> r0 = this.a.get(r3);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        this.a.put(r3, r0);
    L5:
        r0.add(r4);
    }
}
