package com.bytedance.lego.init;

import bf6.g;
import com.bytedance.lego.init.model.ExecutionPeriod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l {
    public static final Map<ExecutionPeriod, List<g>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static void a(ExecutionPeriod r1) {
        List r2 = (List) ((LinkedHashMap) a).get(r1);
        if (r2 == null) goto L9;
        Iterator r3 = r2.iterator();
        if (r3.hasNext() == false) goto L10;
        ((g) r3.next()).getClass();
        throw null;
    L10:
        return;
    }
}
