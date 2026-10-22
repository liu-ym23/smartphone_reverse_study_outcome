package fe3;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f476566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f476567b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<fe3.a> f476568c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f476569d;

    public static final class a implements MessageQueue.IdleHandler {
        public a() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            Handler r100 = b.f476566a;
            fe3.a r101 = b.f476568c.poll();
            if (r101 != null) goto L6;
            Looper.myQueue().removeIdleHandler(b.f476567b);
            b.f476569d = false;
            return true;
        L6:
            SystemClock.uptimeMillis();
            r101.run();
            SystemClock.uptimeMillis();
            return true;
        }
    }

    static {
        f476566a = new Handler(Looper.getMainLooper());
        f476567b = new a();
        f476568c = new LinkedList();
    }
}
