package o25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import p25.b;
import p25.c;
import p25.d;
import p25.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final List<iua.a<String>> a() {
        ArrayList r0 = new ArrayList();
        r0.add(new d());
        r0.add(new b());
        r0.add(new p25.a());
        r0.add(new c());
        r0.add(new e());
        return r0;
    }

    @JvmStatic
    public static final Map<String, iua.a<?>> b() {
        HashMap r0 = new HashMap();
        Iterator<T> r1 = a().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        iua.a r2 = (iua.a) r1.next();
        r0.put(r2.getLarkExperimentInfo().a, r2);
        goto L4
    L6:
        return r0;
    }
}
