package com.bytedance.locallife.pdp.opt;

import com.bytedance.locallife.cube.Cube;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.i.ICubeGlobalListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, CubeConfig> f261619a;

    public b(Map<String, CubeConfig> r100, String r101) {
        this.f261619a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, CubeConfig> r100 = this.f261619a;     // Catch: Throwable -> L15
        if (r100 == null) goto L13;
        Set<String> r101 = r100.keySet();     // Catch: Throwable -> L15
        if (r101 == null) goto L13;
        Map<String, CubeConfig> r102 = this.f261619a;     // Catch: Throwable -> L15
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L15
    L8:
        if (r103.hasNext() == false) goto L13;
        CubeConfig r104 = r102.get((String) r103.next());     // Catch: Throwable -> L15
        if (r104 == null) goto L8;
        kp6.a<ICubeGlobalListener> r105 = Cube.f257155a;     // Catch: Throwable -> L15
        Cube.j(r104);     // Catch: Throwable -> L15
    L13:
        return;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L19;
        return;
    L19:
        throw th;
    }
}
