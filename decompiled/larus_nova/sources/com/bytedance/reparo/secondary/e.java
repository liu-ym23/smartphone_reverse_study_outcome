package com.bytedance.reparo.secondary;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f267477a;

    public final void a() {
        f r100 = this.f267477a;
        r100.getClass();
        if (MonitorService.c().getLogTypeSwitch("inited") == false) goto L27;
        Iterator<String> r101 = r100.f267483c.keys();
    L7:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();
        ((HashSet) r100.f267481a).remove(r102);
        r100.b(r102);
        goto L7
    L9:
        Iterator r103 = ((HashSet) r100.f267481a).iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        r100.b((String) r103.next());
        goto L11
    L13:
        JSONObject r104 = r100.f267483c;
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.length() == 0) goto L28;
        PolarisFileWrapper r105 = new PolarisFileWrapper(f.f267480f.getFilesDir(), "reparo-root/localConfig");
        w87.b.j(r105, r100.f267483c.toString());     // Catch: IOException -> L21
        return;
    L29:
        return;
    L28:
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

    public e(f r100) {
        this.f267477a = r100;
    }
}
