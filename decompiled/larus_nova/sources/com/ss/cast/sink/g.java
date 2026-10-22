package com.ss.cast.sink;

import com.byted.cast.common.Logger;
import com.byted.cast.common.api.IBindSdkInfoListener;
import com.byted.cast.common.config.IInitListener;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.cast.sink.api.ByteCastSink$1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IInitListener f456442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f456443b;

    public final void a() {
        Logger.d("ByteCastSinkImpl", "set Auth by local, bind sdk info listener size:" + ((ArrayList) this.f456443b.f456471x).size());
        IInitListener r100 = this.f456442a;
        if (r100 == null) goto L5;
        r100.onSuccess();
    L5:
        Iterator r101 = ((ArrayList) this.f456443b.f456471x).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((IBindSdkInfoListener) r101.next()).onByteCastSuccess();
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

    public g(j r100, ByteCastSink$1 r101) {
        this.f456443b = r100;
        this.f456442a = r101;
    }
}
