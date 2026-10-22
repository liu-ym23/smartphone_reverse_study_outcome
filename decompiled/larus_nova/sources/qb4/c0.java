package qb4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f532326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f532327b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0 f532328a = null;

        static {
            f532328a = new c0();
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f532329a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            this.f532329a.getClass();
            Object r102 = r100.obj;
            if (r102 == null) goto L38;
            ((t) r102).o0();
            return;
        L38:
            return;
        L5:
            if (r101 != 2) goto L7;
            ac4.c r103 = (ac4.c) r100.obj;
            ReentrantLock r104 = x.f532393a;
            JSONObject r105 = new JSONObject();
            r105.put("os_name", "android");     // Catch: Throwable -> L19 Exception -> L22
            ReentrantLock r106 = x.f532393a;     // Catch: Throwable -> L19 Exception -> L22
            r106.lockInterruptibly();     // Catch: Throwable -> L19 Exception -> L22
            List<JSONObject> r107 = x.f532394b;     // Catch: Throwable -> L19 Exception -> L22
            r105.put("touch", new JSONArray(r107));     // Catch: Throwable -> L19 Exception -> L22
            ((LinkedList) r107).size();     // Catch: Throwable -> L19 Exception -> L22
            int r108 = n.f532367a;     // Catch: Throwable -> L19 Exception -> L22
            ((LinkedList) r107).clear();     // Catch: Throwable -> L19 Exception -> L22
            ((LinkedList) r107).size();     // Catch: Throwable -> L19 Exception -> L22
        L23:
            r106.unlock();
            r103.d(1, r105);     // Catch: Exception -> L30
            return;
        L41:
            return;
        L22:
            r106 = x.f532393a;
        L19:
            th = move-exception;
            x.f532393a.unlock();
            throw th;
        L7:
            if (r101 != 3) goto L39;
            ReentrantLock r109 = x.f532393a;     // Catch: Throwable -> L11 Exception -> L14
            r109.lockInterruptibly();     // Catch: Throwable -> L11 Exception -> L14
            ((LinkedList) x.f532394b).clear();     // Catch: Throwable -> L11 Exception -> L14
        L15:
            r109.unlock();
            return;
        L14:
            r109 = x.f532393a;
        L11:
            th = move-exception;
            x.f532393a.unlock();
            throw th;
        }

        public b(c0 r100, Looper r101) {
            this.f532329a = r100;
            super(r101);
        }
    }

    public final void d() {
        if (this.f532326a == null) goto L5;
        return;
    L5:
        monitor-enter(c0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f532326a != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("TuringVerifyThread");     // Catch: Throwable -> L11
        this.f532326a = r100;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        this.f532327b = new b(this, this.f532326a.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c0.class);     // Catch: Throwable -> L11
    }

    public c0() {
    }

    public final void a(Runnable r100) {
        b r101 = this.f532327b;
        if (r101 == null) goto L6;
        r101.post(r100);
        return;
    }

    public final boolean b(Runnable r100, long r101) {
        b r102 = this.f532327b;
        if (r102 == null) goto L7;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r102.postDelayed(r100, r101);
    L7:
        return false;
    }

    public final void c(int r100, Object r101) {
        b r102 = this.f532327b;
        if (r102 == null) goto L6;
        Message r103 = r102.obtainMessage(r100, r101);
        this.f532327b.sendMessage(r103);
        return;
    }
}
