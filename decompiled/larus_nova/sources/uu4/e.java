package uu4;

import com.bytedance.ee.bear.bitable.statistic.m;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f551746a = null;

    static {
        f551746a = org.koin.java.a.d(m.class);
    }

    public static m b() {
        return (m) f551746a.getValue();
    }

    @JvmStatic
    public static final void a(String r100, HashMap<String, Serializable> r101) {
        Intrinsics.checkNotNullParameter(r101, "hashMap");
        if (r100 == null) goto L10;
        Iterator<Map.Entry<String, Serializable>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, Serializable> r103 = r102.next();
        Serializable r104 = r103.getValue();
        if (r104 == null) goto L6;
        b().addTraceExtra(r100, r103.getKey(), r104);
        goto L6
    L16:
        return;
    }
}
