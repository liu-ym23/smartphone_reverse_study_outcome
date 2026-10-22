package com.bytedance.dataplatform;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Triple;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f204303a;

    public h(q r100) {
        this.f204303a = r100;
    }

    public final void a() {
        KProperty[] r100 = ClientExperimentManager.f204275a;
        Iterator<T> r101 = ClientExperimentManager.f204278d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Triple r102 = (Triple) r101.next();
        this.f204303a.b((String) r102.getFirst(), (ij4.a) r102.getSecond(), (String) r102.getThird());
        goto L4
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
