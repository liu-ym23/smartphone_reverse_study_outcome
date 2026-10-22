package myb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.optrace.api.TracingCoreSpan;
import com.ss.android.lark.optrace.core.b;
import com.ss.android.lark.optrace.core.c;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TracingCoreSpan f516436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Runnable f516437b;

    public final void a() {
        c.f437607a.getClass();
        b r100 = jyb.a.f501070b;
        TracingCoreSpan r101 = this.f516436a;
        r100.getClass();
        com.ss.android.lark.optrace.core.a r102 = new com.ss.android.lark.optrace.core.a(r100, r101);
        if (this.f516437b != null) goto L5;
        Log.i("SpanWrappedRunnable", "no innerRunnable, do execute()");
    L7:
        if (r100.f437606a.get() != r102) goto L11;
        r100.f437606a.set(r102.f437605b);
        return;
    L11:
        return;
    L5:
        Log.i("SpanWrappedRunnable", "has innerRunnable, ignore execute()");
        this.f516437b.run();
        goto L7
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

    public a(Runnable r100) {
        this.f516437b = r100;
        c.f437607a.getClass();
        com.ss.android.lark.optrace.core.a r101 = jyb.a.f501070b.f437606a.get();
        if (r101 != null) goto L5;
        TracingCoreSpan r102 = null;
    L6:
        if (r102 != null) goto L8;
        Log.w("SpanWrappedRunnable", "no activeSpan for currentThread");
        c.f437607a.getClass();
        r102 = jyb.a.f501071c.generateSpan();
        c.f437607a.getClass();
        b r103 = jyb.a.f501070b;
        r103.getClass();
        new com.ss.android.lark.optrace.core.a(r103, r102);
    L8:
        this.f516436a = r102.generateSpan();
        return;
    L5:
        r102 = r101.f437604a;
        goto L6
    }
}
