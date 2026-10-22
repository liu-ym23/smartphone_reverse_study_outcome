package com.bytedance.crash.upload;

import com.bytedance.crash.util.p;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f203382a;

    public final void a() {
        i r100 = this.f203382a;
        r100.getClass();
        p.d("disaster:checkNetworkRestore");
        if (r100.f203373a.size() <= 0) goto L23;
        HashMap r101 = new HashMap();     // Catch: Throwable -> L24
        Iterator<Map.Entry<String, h>> r102 = r100.f203373a.entrySet().iterator();     // Catch: Throwable -> L24
    L8:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, h> r103 = r102.next();     // Catch: Throwable -> L24
        if (r103 == null) goto L8;
        h r104 = r103.getValue();     // Catch: Throwable -> L24
        if (r104 == null) goto L8;
        if (r100.i(r104) > 0) goto L8;
        r101.put(r104.f203362b, r104.f203363c);     // Catch: Throwable -> L24
        goto L8
    L18:
        Iterator r105 = r101.entrySet().iterator();     // Catch: Throwable -> L24
    L19:
        if (r105.hasNext() == false) goto L40;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L24
        r100.p((String) r106.getKey(), (String) r106.getValue());     // Catch: Throwable -> L24
        goto L19
    L40:
        return;
    L23:
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

    public j(i r100) {
        this.f203382a = r100;
    }
}
