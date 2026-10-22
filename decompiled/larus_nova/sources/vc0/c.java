package vc0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f554081a;

    public c(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        Intrinsics.checkNotNullParameter(r100, "map");
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Object> r103 = r102.next();
        Object r104 = r103.getValue();
        if ((r104 instanceof xh6.c) == true) goto L7;
        r101.put(r103.getKey(), r104);
        goto L4
    L7:
        r101.put(r103.getKey(), ((xh6.c) r104).getReal());
        goto L4
    L9:
        this.f554081a = r101;
    }
}
