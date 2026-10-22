package com.bytedance.locallife.dito.core;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f258158a = null;

    static {
        f258158a = new w();
    }

    public w() {
    }

    public static void a() {
        ConcurrentHashMap<v.c, ConcurrentLinkedQueue<v.a>> r100 = v.f257992a;
        if (r100.size() <= 50) goto L20;
        rq6.a.f538927a.a("DitoPageCacheCenter", "cleanLRUCache");
        Iterator r101 = CollectionsKt.sortedWith(CollectionsKt.toList(r100.entrySet()), new x()).iterator();
    L7:
        if (r101.hasNext() == false) goto L20;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (v.f257992a.size() <= 50) goto L20;
        Iterator<v.b> r103 = v.f257995d.iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        v.b r104 = r103.next();
        v.c r105 = (v.c) r102.getKey();
        Queue r106 = (Queue) r102.getValue();
        if (r104.a() == false) goto L13;
        rq6.a.f538927a.a("DitoPageCacheCenter", "cleanLRUCache interceptClean page" + r102.getKey());
        boolean r107 = true;
    L18:
        if (r107 == true) goto L7;
        v.f257992a.remove(r102.getKey());
        rq6.a.f538927a.a("DitoPageCacheCenter", "cleanLRUCache page" + r102.getKey());
        goto L7
    L17:
        r107 = false;
    L20:
        v.f257994c = null;
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
