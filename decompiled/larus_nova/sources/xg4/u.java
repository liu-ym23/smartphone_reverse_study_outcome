package xg4;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.d0;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        L3:
            if (Header.f203194c != (-1)) goto L5;
            Header.f203194c = com.bytedance.crash.general.b.a().contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;     // Catch: Throwable -> L11
        L5:
            boolean r100 = true;
            if (Header.f203194c == 1) goto L9;
            r100 = false;
        L9:
            NativeBridge.Q(r100);     // Catch: Throwable -> L11
            NativeBridge.S(d0.f203146d);     // Catch: Throwable -> L11
            NativeBridge.g();     // Catch: Throwable -> L11
        }

        public a() {
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadMethodProxy.start(new PthreadThreadV2(new a(), "NPTH-AnrMonitor"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public u() {
    }
}
