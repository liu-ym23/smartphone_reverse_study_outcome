package com.bytedance.scene.group;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.bytedance.scene.State;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f268713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f268714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f268715c;

    public class a extends ra7.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ h f268716f;

        @Override // ra7.a, android.content.ContextWrapper, android.content.Context
        public final Object getSystemService(String r100) {
            if ("layout_inflater".equals(r100) == false) goto L7;
            return this.f268716f.f268713a;
        L7:
            return super.getSystemService(r100);
        }

        public a(h r100, Context r101, Resources.Theme r102) {
            this.f268716f = r100;
            super(r101, r102);
        }
    }

    public class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f268717a;

        public b(h r100) {
            this.f268717a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            d r101 = (d) r100.obj;
            if (r101.f268722d != null) goto L5;
            r101.f268722d = this.f268717a.f268713a.inflate(r101.f268721c, r101.f268720b, false);
        L5:
            f r102 = r101.f268723e;
            View r103 = r101.f268722d;
            AsyncLayoutGroupScene.a r104 = (AsyncLayoutGroupScene.a) r102;
            State r105 = r104.f268646b.f268590h;
            if (r105 != State.NONE) goto L9;
        L20:
            e r106 = this.f268717a.f268715c;
            r106.getClass();
            r101.f268723e = null;
            r101.f268719a = null;
            r101.f268720b = null;
            r101.f268721c = 0;
            r101.f268722d = null;
            r106.f268726w.release(r101);
            return true;
        L9:
            if (r105.value < State.VIEW_CREATED.value) goto L12;
            r104.f268645a.addView(r103);
            r104.f268646b.getClass();
        L12:
            if (r105.value < State.ACTIVITY_CREATED.value) goto L15;
            r104.f268646b.getClass();
        L15:
            if (r105.value < State.STARTED.value) goto L18;
            r104.f268646b.getClass();
        L18:
            if (r105.value != State.RESUMED.value) goto L20;
            r104.f268646b.getClass();
            goto L20
        }
    }

    public static class c extends LayoutInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f268718a = null;

        static {
            f268718a = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        @Override // android.view.LayoutInflater
        public final LayoutInflater cloneInContext(Context r100) {
            return new c(this, r100);
        }

        public c(LayoutInflater r100, Context r101) {
            super(r100, r101);
        }

        @Override // android.view.LayoutInflater
        public final View onCreateView(String r100, AttributeSet r101) throws ClassNotFoundException {
            String[] r102 = f268718a;
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

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f268719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f268720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f268721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f268722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f f268723e;

        public d() {
        }
    }

    public static class e extends PthreadThreadV2 {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final e f268724x = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final ArrayBlockingQueue<d> f268725v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final Pools.SynchronizedPool<d> f268726w;

        static {
            e r100 = new e();
            f268724x = r100;
            ThreadMethodProxy.start(r100);
        }

        public e() {
            super("SceneAsyncLayoutInflater$InflateThread");
            this.f268725v = new ArrayBlockingQueue(10);
            this.f268726w = new Pools.SynchronizedPool(10);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L16:
            d r100 = this.f268725v.take();     // Catch: InterruptedException -> L12 Throwable -> L7
            goto L16
        L14:
            r100.f268722d = r100.f268719a.f268713a.inflate(r100.f268721c, r100.f268720b, false);     // Catch: RuntimeException -> L13 Throwable -> L7
        L5:
            Message.obtain(r100.f268719a.f268714b, 0, r100).sendToTarget();     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public interface f {
    }

    public h(Context r100) {
        b r101 = new b(this);
        a r102 = new a(this, r100, r100.getTheme());
        this.f268713a = new c(LayoutInflater.from(r100), r102);
        this.f268714b = new Handler(r101);
        this.f268715c = e.f268724x;
    }
}
