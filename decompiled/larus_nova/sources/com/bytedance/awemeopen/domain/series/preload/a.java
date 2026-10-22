package com.bytedance.awemeopen.domain.series.preload;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f44.a f198458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap<String, List<Function0<Unit>>> f198459b = null;

    public a() {
    }

    static {
        new ConcurrentHashMap();
        f198458a = new f44.a(new h24.a(true, 3000000, 1200000));
        f198459b = new ConcurrentHashMap();
    }

    public static final void a(String r100) {
        List r101 = (List) ((ConcurrentHashMap) f198459b).get(r100);
        if (r101 == null) goto L10;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Function0 r103 = (Function0) r102.next();
        if (r103 == null) goto L6;
        r103.invoke();
    L10:
        ((ConcurrentHashMap) f198459b).remove(r100);
    }
}
