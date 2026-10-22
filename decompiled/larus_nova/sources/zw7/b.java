package zw7;

import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import ww7.a0;
import ww7.c0;
import ww7.h;
import ww7.v;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements Runnable {

    public class a implements ww7.a<Void> {
        public a() {
        }

        @Override // ww7.a
        public final void onSuccess(Void r100) {
            f.b("HonorUnRegister", "honor unregister success");
        }

        @Override // ww7.a
        public final void onFailure(int r100, String r101) {
            f.e("HonorUnRegister", "honor unregister failed,errorCode:errorCode" + r100 + " errorString:" + r101);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = ww7.b.f561640a;     // Catch: Throwable -> L5
        a r101 = new a();     // Catch: Throwable -> L5
        h.a(new a0(c0.f561643e, new v(r101), r101));     // Catch: Throwable -> L5
        f.b("HonorUnRegister", "honor unregister success");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.c("HonorUnRegister", "honor unregister failed", th);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public b() {
    }
}
