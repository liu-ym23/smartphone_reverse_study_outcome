package ykc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.atomic.AtomicInteger;
import vr3.h;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f568293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HandlerC8351a f568294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f568295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f568296d;

    /* JADX INFO: renamed from: ykc.a$a, reason: collision with other inner class name */
    public static class HandlerC8351a extends Handler {
        public HandlerC8351a(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            b r101 = a.f568295c;
            if (r101 != null) goto L5;
            return;
        L5:
            int r102 = r100.what;
            Context r103 = (Context) r100.obj;
            if (r102 != 1) goto L8;
            ((h.a) r101).a(c.c(r103), -1);     // Catch: Exception -> L23
        L24:
            goto L21
        L8:
            if (r102 != 2) goto L10;
            c.d(r103);     // Catch: Exception -> L23
            ((h.a) r101).a(-1.0f, -1);     // Catch: Exception -> L23
            goto L24
        L10:
            if (r102 != 3) goto L12;
            ((h.a) r101).a(-1.0f, c.b(r103));     // Catch: Exception -> L23
            goto L24
        L12:
            if (r102 != 4) goto L14;
            float r104 = c.c(r103);     // Catch: Exception -> L23
            c.d(r103);     // Catch: Exception -> L23
            ((h.a) r101).a(r104, -1);     // Catch: Exception -> L23
            goto L24
        L14:
            if (r102 != 5) goto L21;
            float r105 = c.c(r103);     // Catch: Exception -> L23
            c.d(r103);     // Catch: Exception -> L23
            ((h.a) r101).a(r105, c.b(r103));     // Catch: Exception -> L23
        L21:
            sendMessageDelayed(obtainMessage(r102, r103), a.f568296d);
        }
    }

    static {
        new AtomicInteger(0);
    }

    public static void a(Context r100, h.a r101, int r102) {
        if (f568293a != null) goto L5;
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("Thor-Handler-Thread");
        f568293a = r103;
        ThreadMethodProxy.start(r103);
        f568294b = new HandlerC8351a(f568293a.getLooper());
        f568295c = r101;
        r101.f556856a.j();
        f568296d = r102;
    L5:
        HandlerC8351a r104 = f568294b;
        r104.sendMessage(r104.obtainMessage(5, r100));
    }
}
