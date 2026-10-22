package xx5;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, HandlerThread> f565334a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f565335b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f565336c = null;

    /* JADX INFO: renamed from: xx5.a$a, reason: collision with other inner class name */
    public static class HandlerThreadC8285a extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f565337c;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, com.ss.android.ugc.bytex.pthread.base.convergence.hook.HandlerThreadProxyWrapper, java.lang.Thread
        public final synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f565337c == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f565337c = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        public HandlerThreadC8285a() {
            super("ParseThread", 0);
            this.f565337c = false;
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        f565334a = new HashMap();
        f565335b = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        f565336c = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        new HashMap();
    }

    public static HandlerThread a() {
        Iterator<Map.Entry<String, HandlerThread>> r100 = f565334a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if (ThreadMethodProxy.isAlive(r100.next().getValue()) == true) goto L4;
        r100.remove();
        goto L4
    L8:
        HashMap<String, HandlerThread> r101 = f565334a;
        HandlerThread r102 = r101.get("ParseThread");
        if (r102 != null) goto L17;
        HandlerThreadC8285a r103 = new HandlerThreadC8285a();
        ThreadMethodProxy.start(r103);
        r101.put("ParseThread", r103);
        return r103;
    L17:
        return r102;
    }
}
