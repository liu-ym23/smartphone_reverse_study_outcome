package com.bytedance.lynx.webview.internal;

import java.lang.reflect.InvocationHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Queue<InvocationHandler> f265360a = null;

    static {
        f265360a = new ConcurrentLinkedQueue();
    }

    public static void a(String r100, Object... r101) {
        HashMap r102 = new HashMap();
        r102.put("name", r100);
        r102.put("args", r101);
        Object[] r103 = {"ttwebviewdelegate", 1, r102};
        Iterator r104 = ((ConcurrentLinkedQueue) f265360a).iterator();
    L4:
        if (r104.hasNext() == false) goto L10;
        ((InvocationHandler) r104.next()).invoke(null, null, r103);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        l17.k.b(new String[]{"Monitors: error occurs when executing " + r101[0], th.toString()});
        goto L4
    }
}
