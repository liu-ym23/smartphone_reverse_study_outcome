package uu4;

import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public static final Lazy a = null;

    static {
        a = org.koin.java.a.d(m.class);
    }

    public static m b() {
        return (m) a.getValue();
    }

    @JvmStatic
    public static final void a(String r3, HashMap<String, Serializable> r4) {
        Intrinsics.checkNotNullParameter(r4, "hashMap");
        if (r3 == null) goto L10;
        Iterator<Map.Entry<String, Serializable>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L16;
        Map.Entry<String, Serializable> r0 = r5.next();
        Serializable r1 = r0.getValue();
        if (r1 == null) goto L6;
        b().addTraceExtra(r3, r0.getKey(), r1);
        goto L6
    L16:
        return;
    }
}
