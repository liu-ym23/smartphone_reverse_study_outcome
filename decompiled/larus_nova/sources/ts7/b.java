package ts7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f547409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, a> f547410b = null;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f547412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public HandlerThreadC7767b f547413c;

        public a(HandlerThreadC7767b r100) {
            super(r100.getLooper());
            this.f547411a = "SingleThreadControl";
            this.f547413c = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            if (r100.what != 0) goto L16;
            Object r101 = b.f547409a;
            monitor-enter(r101);
        L13:
            th = move-exception;
            throw th;
        L7:
            if (this.f547412b != 0) goto L9;
            b.f547410b.remove(this.f547411a);     // Catch: Throwable -> L13
            boolean r102 = true;
        L10:
            monitor-exit(r101);     // Catch: Throwable -> L13
            if (r102 == false) goto L19;
            HandlerThreadC7767b r103 = this.f547413c;
            r103.f547414a = true;
            r103.quitSafely();
            r103.f547414a = false;
            this.f547413c = null;
            return;
        L19:
            return;
        L9:
            r102 = false;
            goto L10
        }
    }

    /* JADX INFO: renamed from: ts7.b$b, reason: collision with other inner class name */
    public static class HandlerThreadC7767b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f547414a;

        public HandlerThreadC7767b() {
            super("SingleThreadControl");
            this.f547414a = false;
        }

        @Override // android.os.HandlerThread
        public final boolean quit() {
            if (this.f547414a == false) goto L7;
            return super.quit();
        L7:
            throw new IllegalStateException("HandlerThread borrowed from HandlerThreadPool cannot call quit directory, use HandlerThreadPool.returnThread() instead");
        }

        @Override // android.os.HandlerThread
        public final boolean quitSafely() {
            if (this.f547414a == false) goto L7;
            return super.quitSafely();
        L7:
            throw new IllegalStateException("HandlerThread borrowed from HandlerThreadPool cannot call quitSafely directly, use HandlerThreadPool.returnThread() instead");
        }
    }

    static {
        f547409a = new Object();
        f547410b = new HashMap();
    }

    public static HandlerThreadC7767b a() {
        Object r100 = f547409a;
        monitor-enter(r100);
        HashMap<String, a> r101 = f547410b;     // Catch: Throwable -> L13
        a r102 = r101.get("SingleThreadControl");     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
    L8:
        HandlerThreadC7767b r103 = new HandlerThreadC7767b();     // Catch: Throwable -> L13
        r103.start();     // Catch: Throwable -> L13
        a r104 = new a(r103);     // Catch: Throwable -> L13
        r101.put("SingleThreadControl", r104);     // Catch: Throwable -> L13
        r102 = r104;
    L9:
        r102.removeMessages(0);     // Catch: Throwable -> L13
        r102.f547412b++;     // Catch: Throwable -> L13
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r102.f547413c;
    L7:
        if (r102.f547413c != null) goto L9;
    L13:
        th = move-exception;
        throw th;
    }
}
