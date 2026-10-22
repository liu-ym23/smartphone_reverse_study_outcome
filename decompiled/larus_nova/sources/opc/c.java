package opc;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f524826a;

    public c(Context r100) {
        this.f524826a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i08.a.b(this.f524826a, y9c.d.h(R.string.Lark_Legacy_Sending));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
