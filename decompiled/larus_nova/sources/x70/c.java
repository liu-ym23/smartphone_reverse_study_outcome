package x70;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f562777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f562778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f562779c;

    public class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f562780a;

        public a(c r100) {
            this.f562780a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            C8200c r101 = (C8200c) r100.obj;
            ViewGroup r102 = r101.f562785d;
            if (d80.d.f467386b.booleanValue() == false) goto L8;
            WeakReference<ViewGroup> r103 = r101.f562784c;
            if (r103 == null) goto L8;
            r102 = r103.get();
        L8:
            if (r101.f562787f != null) goto L10;
            r101.f562787f = this.f562780a.f562777a.inflate(r101.f562786e, r102, false);
        L10:
            View r104 = r101.f562787f;
            if (r104 == null) goto L13;
            r101.f562788g.a(r104, r101.f562786e);
        L13:
            d r105 = this.f562780a.f562778b;
            r105.getClass();
            r101.f562788g = null;
            r101.f562782a = null;
            r101.f562783b = null;
            r101.f562784c = null;
            r101.f562785d = null;
            r101.f562786e = 0;
            r101.f562787f = null;
            r105.f562791w.release(r101);
            return true;
        }
    }

    public static class b extends LayoutInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f562781a = null;

        static {
            f562781a = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        public b(Context r100) {
            super(r100);
        }

        @Override // android.view.LayoutInflater
        public final LayoutInflater cloneInContext(Context r100) {
            return new b(r100);
        }

        @Override // android.view.LayoutInflater
        public final View onCreateView(String r100, AttributeSet r101) throws ClassNotFoundException {
            String[] r102 = f562781a;
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L10;
            View r105 = createView(r100, r102[r104], r101);     // Catch: ClassNotFoundException -> L11
            if (r105 == null) goto L8;
            return r105;
        L8:
            r104 = r104 + 1;
            goto L3
        L10:
            return super.onCreateView(r100, r101);
        }
    }

    /* JADX INFO: renamed from: x70.c$c, reason: collision with other inner class name */
    public static class C8200c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f562782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<c> f562783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<ViewGroup> f562784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ViewGroup f562785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f562786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f562787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public e f562788g;

        public C8200c() {
        }
    }

    public static final class d extends PthreadThreadV2 {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final d f562789x = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final ArrayBlockingQueue<C8200c> f562790v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final Pools.SynchronizedPool<C8200c> f562791w;

        static {
            d r100 = new d();
            f562789x = r100;
            ThreadMethodProxy.start(r100);
        }

        public d() {
            super("LiveAsyncLayoutInflater$InflateThread");
            this.f562790v = new ArrayBlockingQueue(10);
            this.f562791w = new Pools.SynchronizedPool(10);
        }

        public final void l() {
        L3:
            if (d80.d.f467386b.booleanValue() == false) goto L42;
            C8200c r100 = this.f562790v.take();     // Catch: Throwable -> L57
            if (r100 == null) goto L20;
            WeakReference<c> r101 = r100.f562783b;     // Catch: Exception -> L19
            if (r101 == null) goto L20;
            if (r101.get() == null) goto L20;
            if (r100.f562783b.get().f562777a == null) goto L20;
            if ((r100.f562783b.get().f562777a.getContext() instanceof LifecycleOwner) == false) goto L20;
            Lifecycle r102 = ((LifecycleOwner) r100.f562783b.get().f562777a.getContext()).getLifecycle();     // Catch: Exception -> L19
            if (r102 == null) goto L20;
            if (r102.getCurrentState() == Lifecycle.State.DESTROYED) goto L3;
        L20:
            if (r100 != null) goto L59;
        L34:
            if (r100 == null) goto L3;
            WeakReference<c> r103 = r100.f562783b;
            if (r103 == null) goto L3;
            if (r103.get() == null) goto L3;
            if (r100.f562783b.get().f562779c == null) goto L3;
            Message.obtain(r100.f562783b.get().f562779c, 0, r100).sendToTarget();
            goto L3
        L59:
            WeakReference<c> r104 = r100.f562783b;     // Catch: RuntimeException -> L33
            if (r104 == null) goto L34;
            if (r104.get() == null) goto L34;
            if (r100.f562783b.get().f562777a == null) goto L34;
            WeakReference<ViewGroup> r105 = r100.f562784c;     // Catch: RuntimeException -> L33
            if (r105 == null) goto L30;
            ViewGroup r106 = r105.get();     // Catch: RuntimeException -> L33
        L31:
            r100.f562787f = r100.f562783b.get().f562777a.inflate(r100.f562786e, r106, false);     // Catch: RuntimeException -> L33
            goto L34
        L30:
            r106 = null;
            goto L31
        L42:
            C8200c r107 = this.f562790v.take();     // Catch: Throwable -> L57
            if (r107 == null) goto L65;
            c r108 = r107.f562782a;
            if (r108 == null) goto L65;
            b r109 = r108.f562777a;
            if (r109 == null) goto L65;
            if ((r109.getContext() instanceof LifecycleOwner) == false) goto L65;
            Lifecycle r110 = ((LifecycleOwner) r107.f562782a.f562777a.getContext()).getLifecycle();
            if (r110 == null) goto L65;
            if (r110.getCurrentState() == Lifecycle.State.DESTROYED) goto L3;
        L65:
            r107.f562787f = r107.f562782a.f562777a.inflate(r107.f562786e, r107.f562785d, false);     // Catch: RuntimeException -> L58
        L56:
            Message.obtain(r107.f562782a.f562779c, 0, r107).sendToTarget();
            goto L3
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public interface e {
        void a(View r100, int r101);
    }

    public c(Context r100) {
        a r101 = new a(this);
        this.f562777a = new b(r100);
        this.f562778b = d.f562789x;
        this.f562779c = new Handler(r101);
    }

    public final void a(int r100, ViewGroup r101, e r102) {
        if (r102 == null) goto L14;
        C8200c r103 = this.f562778b.f562791w.acquire();
        if (r103 != null) goto L7;
        r103 = new C8200c();
    L7:
        if (d80.d.f467386b.booleanValue() == false) goto L9;
        r103.f562783b = new WeakReference(this);
        r103.f562784c = new WeakReference(r101);
    L10:
        r103.f562786e = r100;
        r103.f562788g = r102;
        d r104 = this.f562778b;
        r104.getClass();
        r104.f562790v.put(r103);     // Catch: InterruptedException -> L15
        return;
    L18:
        return;
    L9:
        r103.f562782a = this;
        r103.f562785d = r101;
        goto L10
    L14:
        throw new NullPointerException("callback argument may not be null!");
    }
}
