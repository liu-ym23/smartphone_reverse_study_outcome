package iy5;

import android.os.Message;
import android.os.MessageQueue;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.fwatchdog.FWatchDogV2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f496541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f496542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FWatchDogV2 f496543c;

    public final void a() {
        this.f496543c.f244931i.c("do frame wrapper");
        ((Runnable) this.f496541a).run();
        FWatchDogV2 r100 = this.f496543c;
        long r101 = this.f496542b;
        r100.getClass();
        r100.f244931i.c("check and remove doFrame message!");     // Catch: Exception -> L33
        MessageQueue r102 = r100.d();     // Catch: Exception -> L33
        if (r102 == null) goto L36;
        Object r103 = r100.b();     // Catch: Exception -> L33
        if (r103 == null) goto L36;
        Field r104 = r100.f244923a.a(r102.getClass(), "mMessages", Message.class);     // Catch: Exception -> L33
        Message r105 = (Message) r104.get(r102);     // Catch: Exception -> L33
        if (r105 == null) goto L36;
        Field r106 = r100.f244923a.a(r105.getClass(), TeaEventTrack.ACTION_DRAMA_NEXT, Message.class);     // Catch: Exception -> L33
        if (r106 == null) goto L36;
        Message r107 = (Message) r106.get(r105);     // Catch: Exception -> L33
        long r108 = r101 / 1000000;     // Catch: Exception -> L33
        if (r105.getCallback() != r103) goto L20;
        if (r105.getWhen() != r108) goto L20;
        r104.set(r102, r107);     // Catch: Exception -> L33
        r100.f244931i.c("remove doFrame message success!");     // Catch: Exception -> L33
    L20:
        Message r109 = (Message) r106.get(r105);     // Catch: Exception -> L33
        if (r109 == null) goto L36;
        Message r110 = (Message) r106.get(r109);     // Catch: Exception -> L33
        if (r109.getCallback() != r103) goto L30;
        if (r109.getWhen() != r108) goto L30;
        r106.set(r105, r110);     // Catch: Exception -> L33
        r100.f244931i.c("remove doFrame message!");     // Catch: Exception -> L33
    L30:
        if (r109.getWhen() > r108) goto L36;
        r105 = r109;
    L36:
        return;
    L33:
        e = move-exception;
        r100.f244931i.b("FWatchDogV2", "check remove doFrame message error! " + e.getMessage());
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

    public g(FWatchDogV2 r100, Object r101, long r102) {
        this.f496543c = r100;
        this.f496541a = r101;
        this.f496542b = r102;
    }
}
