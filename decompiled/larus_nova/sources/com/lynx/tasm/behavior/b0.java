package com.lynx.tasm.behavior;

import android.graphics.RectF;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f381965a;

    public final void a() {
        Iterator<u> r100 = this.f381965a.f382001v.iterator();
    L4:
        if (r100.hasNext() == false) goto L16;
        u r101 = r100.next();
        if (r101 == null) goto L7;
        if (r101.f382330n.size() == 0) goto L4;
        RectF r102 = r101.b();
        Iterator<u.b> r103 = r101.f382330n.iterator();
    L14:
        if (r103.hasNext() == false) goto L4;
        r101.a(r103.next(), r102, false);
        goto L14
    L7:
        LLog.e("Lynx.IntersectionObserver", "LynxIntersectionObserverManager.notifyObservers failed, because observer is null");
        return;
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

    public b0(d0 r100) {
        this.f381965a = r100;
    }
}
