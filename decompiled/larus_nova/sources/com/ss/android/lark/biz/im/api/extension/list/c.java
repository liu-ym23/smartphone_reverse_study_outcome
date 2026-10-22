package com.ss.android.lark.biz.im.api.extension.list;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList<Object> f410171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListComponent<Object, Object> f410172b;

    public c(ArrayList<Object> r100, ListComponent<Object, Object> r101) {
        this.f410171a = r100;
        this.f410172b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<Object> r100 = CollectionsKt.toList(this.f410171a);     // Catch: Throwable -> L7
        this.f410171a.clear();     // Catch: Throwable -> L7
        Iterator<IListComponent.b> r101 = this.f410172b.f410156f.iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        r101.next().a(r100);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
