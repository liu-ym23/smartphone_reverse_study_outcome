package s72;

import android.os.Message;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f540908a;

    /* JADX INFO: renamed from: s72.a$a, reason: collision with other inner class name */
    public static final class RunnableC7581a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f540909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k32.a f540910b;

        public RunnableC7581a(a r100, k32.a r101) {
            this.f540909a = r100;
            this.f540910b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f540909a.f540908a.f540916f.invoke(this.f540910b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(b r100) {
        this.f540908a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 12345) goto L14;
        Object r101 = r100.obj;
        if ((r101 instanceof va) == true) goto L8;
        r101 = null;
    L8:
        va r102 = (va) r101;
        if (r102 != null) goto L11;
        return;
    L11:
        k32.a r103 = this.f540908a.f540915e.invoke(r102);
        this.f540908a.f540914d.post(new RunnableC7581a(this, r103));
        return;
    }
}
