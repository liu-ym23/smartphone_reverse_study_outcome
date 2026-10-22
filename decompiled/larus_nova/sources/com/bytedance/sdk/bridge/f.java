package com.bytedance.sdk.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<h> f269593a = null;

    static {
        List<h> r100 = b.f269575a;
        ((CopyOnWriteArrayList) r100).clear();
        f269593a = r100;
    }

    public static void a(String r100) {
        HashMap r101 = new HashMap();
        Logger.f269563c.getClass();
        Logger.a();
        Iterator r102 = ((CopyOnWriteArrayList) f269593a).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        h r103 = (h) r102.next();
        if (r103 == null) goto L4;
        r103.getSubscriberInfoMap(r101, r100);
        if ((!r101.isEmpty()) == false) goto L4;
    L9:
        Iterator r104 = r101.entrySet().iterator();
    L11:
        if (r104.hasNext() == false) goto L19;
        Map.Entry r105 = (Map.Entry) r104.next();
        if ((!Intrinsics.areEqual((i) r105.getValue(), (i) ((ConcurrentHashMap) tc7.a.f545409a).get(r105.getKey()))) == false) goto L11;
        boolean r106 = false;
    L20:
        if (r106 == false) goto L22;
        return;
    L22:
        if ((!r101.isEmpty()) == false) goto L40;
        Map<Class<?>, i> r107 = tc7.a.f545409a;
        Logger r108 = Logger.f269563c;
        r101.size();
        r108.getClass();
        Logger.a();
        ((ConcurrentHashMap) tc7.a.f545409a).putAll(r101);
        return;
    L40:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L19:
        r106 = true;
        goto L20
    }
}
