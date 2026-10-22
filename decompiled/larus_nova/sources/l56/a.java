package l56;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Callable;
import vl2.e;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f507524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f507525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f507526c;

    @Override // java.lang.Runnable
    public final void run() {
        Handler r100 = this.f507524a;     // Catch: Throwable -> L15
        if (r100 == null) goto L22;
        Message r101 = r100.obtainMessage(this.f507526c);     // Catch: Throwable -> L15
        r101.obj = this.f507525b.call();     // Catch: Exception -> L11 Throwable -> L15
    L13:
        this.f507524a.sendMessage(r101);     // Catch: Throwable -> L15
        return;
    L11:
        e = move-exception;
        r101.obj = e;     // Catch: Throwable -> L15
        goto L13
    L22:
        this.f507525b.call();     // Catch: Exception -> L6 Throwable -> L15
    L26:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L25;
        throw th;
    }

    public a(WeakHandler r100, e r101, int r102) {
        this.f507524a = r100;
        this.f507525b = r101;
        this.f507526c = r102;
    }
}
