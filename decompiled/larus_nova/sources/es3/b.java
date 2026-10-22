package es3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f473697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f473698b;

    public final void a() {
        e.a r100 = this.f473698b.f473706d;
        long r101 = this.f473697a;
        r100.f473707a++;
        r100.f473708b += r101;
        int r102 = 0;
    L4:
        if (r102 >= this.f473698b.f473704b.size()) goto L6;
        et3.h r103 = (et3.h) ListProtector.get(this.f473698b.f473704b, r102);
        long r104 = this.f473697a;
        e.a r105 = r103.f473915c;
        r105.f473707a++;
        r105.f473708b += r104;
        r102 = r102 + 1;
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

    public b(e r100, long r101, boolean r102) {
        this.f473698b = r100;
        this.f473697a = r101;
    }
}
