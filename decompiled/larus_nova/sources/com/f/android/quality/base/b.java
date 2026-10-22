package com.f.android.quality.base;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.f.android.quality.impl.d f274064a;

    public b(com.f.android.quality.impl.d r100) {
        this.f274064a = r100;
    }

    public final void a() {
        int r100 = c.f274065a;
        com.f.android.quality.impl.d r101 = this.f274064a;
        LinkedHashMap r102 = new LinkedHashMap();
        r101.getClass();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101.f274092a);
        r103.putAll(r101.f274093b);
        r103.put("business_type", r101.f274095d);
        r103.put("major_name", r101.f274096e);
        r103.put("minor_name", r101.f274097f);
        r103.put("scene", r101.f274096e + '.' + r101.f274097f);
        r102.putAll(com.f.android.quality.impl.c.a(com.f.android.quality.impl.c.f274090b));
        ConcurrentHashMap<String, Object> r104 = com.f.android.quality.impl.c.f274089a.get(r101.f274095d);
        if (r104 == null) goto L5;
        Map r105 = new HashMap(r104);
    L6:
        r102.putAll(com.f.android.quality.impl.c.a(r105));
        r102.putAll(r103);
        rt7.a r106 = a.f274060a;
        if (a.f274062c == false) goto L21;
        Lazy r107 = QualityLogger.f274059a;
        rt7.b r108 = a.f274061b;
        if (r108 != null) goto L12;
        r108 = (rt7.b) QualityLogger.f274059a.getValue();
    L12:
        r108.d("[DEBUG] ========================");
        String r109 = r102.toString();
        rt7.b r110 = a.f274061b;
        if (r110 != null) goto L16;
        r110 = (rt7.b) QualityLogger.f274059a.getValue();
    L16:
        r110.d(r109);
        rt7.b r111 = a.f274061b;
        if (r111 != null) goto L20;
        r111 = (rt7.b) QualityLogger.f274059a.getValue();
    L20:
        r111.d("[DEBUG] ========================");
    L21:
        rt7.a r112 = a.f274060a;
        if (r112 != null) goto L25;
        r112 = com.f.android.quality.impl.a.f274084a;
    L25:
        r112.onReport(r101.f274094c, r102);
        return;
    L5:
        r105 = MapsKt.emptyMap();
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
