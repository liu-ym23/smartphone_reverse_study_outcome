package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class r1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q1 f457928a;

    public final void a() {
        q1 r100 = this.f457928a;
        r100.f457912e.a();
        if (r100.f457910c.isEmpty() == false) goto L5;
        e0.c r101 = null;
    L6:
        r100.f457912e.b();
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.f457928a.f457913f.b() <= 0) goto L11;
        this.f457928a.f457913f.a();
    L11:
        Logger r102 = Logger.INSTANCE;
        r102.w("JKL", "[TaskManager][新接口][开始][" + r101.getId() + ']');
        this.f457928a.f457909b.put(r101.getId(), r101);
        r101.run();
        this.f457928a.f457909b.remove(r101.getId());
        r102.w("JKL", "[TaskManager][新接口][结束][" + r101.getId() + ']');
        q1 r103 = this.f457928a;
        if (r103.f457911d.contains(r101) == false) goto L20;
        r103.f457911d.remove(r101);
        r103.f457910c.add(r101);
        if ((r101 instanceof BaseTask) == false) goto L17;
        ((BaseTask) r101).f457532b = false;
    L17:
        r102.d("JKL", "[TaskManager][暂停][重新加入到等待队列][" + r101.getId() + ']');
        r103.f457916i.execute(new r1(r103));
        return;
    L20:
        return;
    L5:
        r101 = r100.f457910c.remove(0);
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

    public r1(q1 r100) {
        this.f457928a = r100;
    }
}
