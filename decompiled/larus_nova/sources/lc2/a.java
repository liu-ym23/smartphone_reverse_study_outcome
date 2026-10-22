package lc2;

import android.os.Message;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f508393a;

    /* JADX INFO: renamed from: lc2.a$a, reason: collision with other inner class name */
    public static final class RunnableC6673a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f508394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedList f508395b;

        public RunnableC6673a(a r100, LinkedList r101) {
            this.f508394a = r100;
            this.f508395b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f508394a.f508393a.f508404i.invoke(this.f508395b);     // Catch: Throwable -> L4
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
        this.f508393a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 10086) goto L16;
        Object r101 = r100.obj;
        if (r101 == null) goto L13;
        LinkedList r102 = (LinkedList) r101;
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        f<?> r104 = (f) r103.next();
        b r105 = this.f508393a;
        r105.f508403h.a(r104, r105.f508401f);
        goto L9
    L11:
        this.f508393a.f508402g.post(new RunnableC6673a(this, r102));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.bytedance.android.livesdk.interactivity.api.entity.AbsTextMessage<out com.bytedance.android.live.base.model.message.IBaseLiveMessage?>>");
    }
}
