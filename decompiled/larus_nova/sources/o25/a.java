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

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f521782a = 0;

    static {
    }

    @JvmStatic
    public static final List<iua.a<String>> a() {
        ArrayList r100 = new ArrayList();
        r100.add(new d());
        r100.add(new b());
        r100.add(new p25.a());
        r100.add(new c());
        r100.add(new e());
        return r100;
    }

    @JvmStatic
    public static final Map<String, iua.a<?>> b() {
        HashMap r100 = new HashMap();
        Iterator<T> r101 = a().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        iua.a r102 = (iua.a) r101.next();
        r100.put(r102.getLarkExperimentInfo().f495803a, r102);
        goto L4
    L6:
        return r100;
    }
}
