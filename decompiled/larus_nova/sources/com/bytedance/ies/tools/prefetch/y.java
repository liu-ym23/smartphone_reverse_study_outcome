package com.bytedance.ies.tools.prefetch;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProcessManager f248841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f248842b;

    public y(ProcessManager r100, PrefetchHandler$1.a r101) {
        this.f248841a = r100;
        this.f248842b = r101;
    }

    public final void a() {
        h r100 = this.f248841a.f248759c;
        if (r100 == null) goto L28;
        Collection r101 = r100.b();
        if (r101 == null) goto L26;
        ProcessManager r102 = this.f248841a;
        monitor-enter(r102);
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L23
    L10:
        if (r103.hasNext() == false) goto L20;
        String r104 = (String) r103.next();     // Catch: Throwable -> L23
        String r105 = r100.getString(r104);     // Catch: Throwable -> L23
        if (r105 == null) goto L10;
        int r106 = PrefetchProcess.f248734i;     // Catch: JSONException -> L18 Throwable -> L23
        PrefetchProcess r107 = PrefetchProcess.a.a(new JSONObject(r105));     // Catch: JSONException -> L18 Throwable -> L23
        this.f248841a.getClass();     // Catch: JSONException -> L18 Throwable -> L23
    L14:
        if (ProcessManager.g(r107) == true) goto L15;
        this.f248841a.f248757a.c(r104, r107);     // Catch: JSONException -> L18 Throwable -> L23
        this.f248841a.f248758b.add(r104);     // Catch: JSONException -> L18 Throwable -> L23
        goto L10
    L15:
        r100.remove(r104);     // Catch: JSONException -> L18 Throwable -> L23
    L18:
        e = move-exception;
        k r108 = p.f248826a;     // Catch: Throwable -> L23
        p.c("Failed to load cache at " + r104, e);     // Catch: Throwable -> L23
        goto L10
    L20:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r102);
    L23:
        th = move-exception;
        throw th;
    L26:
        p.b("Nothing found in LocalStorage.");
        r100.removeAll();
        return;
    L28:
        this.f248842b.invoke();
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
