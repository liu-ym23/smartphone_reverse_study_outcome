package fe3;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final Handler a = null;
    public static final a b = null;
    public static final LinkedList<fe3.a> c = null;
    public static boolean d;

    public static final class a implements MessageQueue.IdleHandler {
        public a() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            Handler r0 = b.a;
            fe3.a r1 = b.c.poll();
            if (r1 != null) goto L6;
            Looper.myQueue().removeIdleHandler(b.b);
            b.d = false;
            return true;
        L6:
            SystemClock.uptimeMillis();
            r1.run();
            SystemClock.uptimeMillis();
            return true;
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
        b = new a();
        c = new LinkedList();
    }
}
