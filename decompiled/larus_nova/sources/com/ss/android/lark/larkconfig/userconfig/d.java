package com.ss.android.lark.larkconfig.userconfig;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tpb.a f431137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f431138b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tpb.b f431139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f431140b;

        @Override // java.lang.Runnable
        public final void run() {
            tpb.b r100 = this.f431139a;     // Catch: Throwable -> L4
            tpb.a r101 = this.f431140b.f431137a;     // Catch: Throwable -> L4
            r100.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, tpb.b r101) {
            this.f431140b = r100;
            this.f431139a = r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((ConcurrentHashMap) this.f431138b.f431144d).keySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        tpb.b r101 = (tpb.b) r100.next();     // Catch: Throwable -> L7
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(this, r101));     // Catch: Throwable -> L7
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

    public d(e r100, tpb.a r101) {
        this.f431138b = r100;
        this.f431137a = r101;
    }
}
