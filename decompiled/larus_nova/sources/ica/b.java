package ica;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f489270a = null;

    static {
        f489270a = new ConcurrentHashMap();
    }

    public static void a() {
        long r100 = System.currentTimeMillis();
        Iterator<Map.Entry<String, a>> r101 = f489270a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, a> r102 = r101.next();
        String r103 = r102.getKey();
        a r104 = r102.getValue();
        if ((r100 - r104.f489269e) <= 120000) goto L4;
        if (f489270a.remove(r103, r104) == false) goto L4;
        r104.a();
        goto L4
    }

    public static a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        a();
        a r101 = f489270a.remove(r100);
        if (r101 != null) goto L5;
    L12:
        return null;
    L5:
        if ((System.currentTimeMillis() - r101.f489269e) <= 120000) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        r101.a();
    L10:
        if (r102 == true) goto L12;
        return r101;
    L7:
        r102 = false;
        goto L8
    }
}
