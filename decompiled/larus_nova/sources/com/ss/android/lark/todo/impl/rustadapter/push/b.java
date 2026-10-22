package com.ss.android.lark.todo.impl.rustadapter.push;

import com.alibaba.fastjson.JSONObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f444231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f444232b;

    public b(c.a r100, JSONObject r101) {
        this.f444231a = r100;
        this.f444232b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<WeakReference<a>> r100 = this.f444231a.f444236b.iterator();     // Catch: Throwable -> L9
    L4:
        if (r100.hasNext() == false) goto L21;
        a r101 = r100.next().get();     // Catch: Throwable -> L9
        if (r101 == null) goto L4;
        r101.a(this.f444232b);     // Catch: Throwable -> L9
        goto L4
    L21:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
