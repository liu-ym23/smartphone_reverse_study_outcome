package com.ss.cast.source;

import com.byted.cast.common.api.IBindSdkInfoListener;
import com.byted.cast.common.config.IInitListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IInitListener f456565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteCastSourceImpl f456566b;

    public final void a() {
        this.f456566b.f456482b.d("ByteCastSourceImpl", "set Auth by local, bind sdk info listener size:" + ((CopyOnWriteArrayList) this.f456566b.K).size());
        IInitListener r100 = this.f456565a;
        if (r100 == null) goto L5;
        r100.onSuccess();
    L5:
        Iterator r101 = ((CopyOnWriteArrayList) this.f456566b.K).iterator();
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

    public b(ByteCastSourceImpl r100, IInitListener r101) {
        this.f456566b = r100;
        this.f456565a = r101;
    }
}
