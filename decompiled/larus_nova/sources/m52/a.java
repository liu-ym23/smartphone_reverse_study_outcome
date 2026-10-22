package m52;

import android.os.Message;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f512092a;

    /* JADX INFO: renamed from: m52.a$a, reason: collision with other inner class name */
    public static final class RunnableC6773a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f512093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedList f512094b;

        public RunnableC6773a(Function1 r100, LinkedList r101) {
            this.f512093a = r100;
            this.f512094b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f512093a.invoke(this.f512094b);     // Catch: Throwable -> L4
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
        this.f512092a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.what != 17234) goto L18;
        Object r101 = r100.obj;
        if (r101 == null) goto L15;
        LinkedList r102 = (LinkedList) r101;
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        h52.c r104 = (h52.c) r103.next();
        b r105 = this.f512092a;
        r105.f512101g.a(r104, r105.f512099e);
        goto L9
    L11:
        b r106 = this.f512092a;
        Function1<? super List<? extends h52.c>, Unit> r107 = r106.f512102h;
        if (r107 == null) goto L19;
        r106.f512100f.post(new RunnableC6773a(r107, r102));
        return;
    L19:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.IPublicScreenMessageModel>");
    }
}
