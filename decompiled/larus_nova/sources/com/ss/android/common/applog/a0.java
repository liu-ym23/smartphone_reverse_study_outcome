package com.ss.android.common.applog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f408075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f408076b;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void onEventExpired(List<Long> r100);
    }

    public static class b extends Handler {
        public b(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            a r101 = a0.f408075a;     // Catch: Throwable -> L23
            switch(r100.what) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L9;
                case 5: goto L7;
                case 6: goto L5;
                default: goto L28;
            };     // Catch: Throwable -> L23
        L5:
            if (r101 == null) goto L29;
            String r102 = (String) ((Object[]) r100.obj)[0];     // Catch: Throwable -> L23
            r101.d();     // Catch: Throwable -> L23
            return;
        L29:
            return;
        L7:
            if (r101 == null) goto L31;
            Object[] r103 = (Object[]) r100.obj;     // Catch: Throwable -> L23
            String r104 = (String) r103[0];     // Catch: Throwable -> L23
            String r105 = (String) r103[1];     // Catch: Throwable -> L23
            String r106 = (String) r103[2];     // Catch: Throwable -> L23
            ((Integer) r103[3]).intValue();     // Catch: Throwable -> L23
            r101.b();     // Catch: Throwable -> L23
            return;
        L31:
            return;
        L9:
            if (r101 == null) goto L33;
            Iterator r107 = ((List) ((Object[]) r100.obj)[0]).iterator();     // Catch: Throwable -> L23
        L12:
            if (r107.hasNext() == false) goto L42;
            String r108 = (String) r107.next();     // Catch: Throwable -> L23
            r101.c();     // Catch: Throwable -> L23
            goto L12
        L42:
            return;
        L33:
            return;
        L14:
            if (r101 == null) goto L34;
            r101.onEventExpired((List) ((Object[]) r100.obj)[0]);     // Catch: Throwable -> L23
            return;
        L34:
            return;
        L16:
            if (r101 == null) goto L36;
            Object[] r109 = (Object[]) r100.obj;     // Catch: Throwable -> L23
            ((Boolean) r109[0]).booleanValue();     // Catch: Throwable -> L23
            ((Long) r109[1]).longValue();     // Catch: Throwable -> L23
            r101.e();     // Catch: Throwable -> L23
            return;
        L36:
            return;
        L18:
            if (r101 == null) goto L38;
            r101.a();     // Catch: Throwable -> L23
            return;
        L38:
            return;
        L20:
            if (r101 == null) goto L40;
            Object[] r110 = (Object[]) r100.obj;     // Catch: Throwable -> L23
            ((Boolean) r110[0]).booleanValue();     // Catch: Throwable -> L23
            List r111 = (List) r110[1];     // Catch: Throwable -> L23
            r101.f();     // Catch: Throwable -> L23
            return;
        L40:
            return;
        L28:
            return;
        L23:
            th = move-exception;
            ita.j.c("LogTrace handle log trace exception", th);
        }
    }

    public a0() {
    }

    public static void a(int r100, int r101, Object[] r102) {
        if (f408076b == null) goto L5;
    L14:
        b r103 = f408076b;
        if (r103 == null) goto L20;
        Message r104 = r103.obtainMessage(r100);
        r104.arg1 = r101;
        r104.obj = r102;
        r103.sendMessage(r104);
        return;
    L20:
        return;
    L5:
        monitor-enter(a0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f408076b != null) goto L9;
        PthreadHandlerThreadV2 r105 = new PthreadHandlerThreadV2("LogTraceThread");     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r105);     // Catch: Throwable -> L11
        f408076b = new b(r105.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(a0.class);     // Catch: Throwable -> L11
        goto L14
    }
}
