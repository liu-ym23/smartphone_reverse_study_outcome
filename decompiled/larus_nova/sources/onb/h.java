package onb;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f524420a;

    public final void a() {
        i r100 = this.f524420a;
        g r101 = r100.f524421a.f524426a;
        String r102 = r100.f524422b.getType();
        String r103 = this.f524420a.f524422b.b();
        r101.getClass();
        if ("requestFromNative".equals(r102) == false) goto L9;
        pnb.b r104 = r101.f524408a.f519693b;
        if (pnb.c.f530000a == false) goto L7;
        r104.getClass();
        rnb.c.a("bridge_send", "requestFromNative:  request=" + r103);
    L7:
        pnb.b.HandlerC7214b r105 = r104.f529991a;
        int r106 = pnb.b.HandlerC7214b.f529998b;
        r105.getClass();
        r105.sendMessage(Message.obtain(r105, 3, r103));
    L14:
        i r107 = this.f524420a;
        if (r107.f524424d == null) goto L21;
        Handler r108 = r107.f524425e;
        long r109 = r107.f524422b.f524405b;
        if (r109 != (-1)) goto L20;
        r109 = r107.f524421a.f524428c;
    L20:
        r108.sendEmptyMessageDelayed(2, r109);
    L21:
        rnb.c.a("RNBridge->JSCall", "hashCode: " + hashCode() + "->sendJSMessage->requestId: " + this.f524420a.f524422b.a());
        return;
    L9:
        if ("requestFromDocs".equals(r102) == false) goto L14;
        pnb.b r110 = r101.f524408a.f519693b;
        if (pnb.c.f530000a == false) goto L13;
        r110.getClass();
        rnb.c.a("bridge_send", "requestFromDocs:  request=" + r103);
    L13:
        pnb.b.HandlerC7214b r111 = r110.f529991a;
        int r112 = pnb.b.HandlerC7214b.f529998b;
        r111.getClass();
        r111.sendMessage(Message.obtain(r111, 5, r103));
        goto L14
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

    public h(i r100) {
        this.f524420a = r100;
    }
}
