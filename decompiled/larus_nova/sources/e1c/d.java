package e1c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements e1c.b, e1c.b.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f470765m = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, o1c.c<?, ?>> f470766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<o1c.c<?, ?>>, o1c.c<?, ?>> f470767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Class<o1c.c<?, ?>>> f470768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Class<k1c.b<Object>>, k1c.b<Object>> f470769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<e1c.b.a> f470770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e1c.a f470771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n1c.a f470772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n1c.a f470773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Runnable> f470774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f470775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Handler f470776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f470777l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f470778a = null;

        static {
            f470778a = new d();
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f470779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o1c.c<?, ?> f470780b;

        public c(d r100, o1c.c<?, ?> r101) {
            this.f470779a = r100;
            this.f470780b = r101;
        }

        public final void a() {
            Map<String, o1c.c<?, ?>> r100 = this.f470779a.f470766a;
            HashMap r101 = (HashMap) r100;
            r101.put(this.f470780b.getTaskId(), this.f470780b);
            Map<Class<o1c.c<?, ?>>, o1c.c<?, ?>> r102 = this.f470779a.f470767b;
            ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
            r103.put(this.f470780b.getClass(), this.f470780b);
            Map<String, Class<o1c.c<?, ?>>> r104 = this.f470779a.f470768c;
            ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
            r105.put(this.f470780b.getTaskId(), this.f470780b.getClass());
            this.f470780b.J0(this.f470779a.f470771f);
            this.f470780b.K(this.f470779a);
            if (e1c.c.f470763c.get() == false) goto L5;
            List<g1c.b<?>> r106 = CollectionsKt.plus(CollectionsKt.plus(this.f470780b.p0().f438810a, this.f470780b.w0().f438810a), this.f470780b.C1().f438810a);
        L6:
            d r107 = this.f470779a;
            Iterator<T> r108 = r106.iterator();
        L8:
            if (r108.hasNext() == false) goto L19;
            g1c.b<Object> r109 = (g1c.b) r108.next();
            Class<? extends k1c.b<Object>> r110 = r109.b();
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type java.lang.Class<com.ss.android.lark.preload.v2.detector.IDetector<kotlin.Any?>>");
            k1c.b<Object> r111 = r107.f470769d.get(r110);
            if (r111 != null) goto L17;
            r111 = r110.newInstance();
            if (r111 == null) goto L17;
            Context r112 = r107.f470777l;
            if (r112 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            r112 = null;
        L16:
            r111.j(r112, r107);
        L17:
            if (r111 == null) goto L8;
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.condition.ICondition<kotlin.Any?>");
            r111.h(r109);
            r107.f470769d.put((Class<k1c.b<Object>>) r110, r111);
            goto L8
        L19:
            this.f470779a.d(this.f470780b);
            return;
        L5:
            r106 = this.f470780b.p0().f438810a;
            goto L6
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
    }

    /* JADX INFO: renamed from: e1c.d$d, reason: collision with other inner class name */
    public static final class RunnableC5731d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set<g1c.b<?>> f470781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f470782b;

        /* JADX WARN: Multi-variable type inference failed */
        public RunnableC5731d(Set<? extends g1c.b<?>> r100, d r101) {
            this.f470781a = r100;
            this.f470782b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<g1c.b<?>> r100 = this.f470781a.iterator();     // Catch: Throwable -> L16
        L4:
            if (r100.hasNext() == false) goto L8;
            if (r100.next().a() == false) goto L4;
            boolean r101 = true;
        L9:
            Handler r102 = this.f470782b.f470776k;     // Catch: Throwable -> L16
            if (r102 == null) goto L12;
            r102.removeMessages(3);     // Catch: Throwable -> L16
        L12:
            Handler r103 = this.f470782b.f470776k;     // Catch: Throwable -> L16
            if (r103 == null) goto L19;
            d.o(r103, 2, Boolean.valueOf(r101), 50);     // Catch: Throwable -> L16
            return;
        L19:
            return;
        L8:
            r101 = false;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set<g1c.b<?>> f470783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f470784b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Set<? extends g1c.b<?>> r100, d r101) {
            this.f470783a = r100;
            this.f470784b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<g1c.b<?>> r100 = this.f470783a.iterator();     // Catch: Throwable -> L16
        L4:
            if (r100.hasNext() == false) goto L8;
            if (r100.next().a() == false) goto L4;
            boolean r101 = true;
        L9:
            Handler r102 = this.f470784b.f470776k;     // Catch: Throwable -> L16
            if (r102 == null) goto L12;
            r102.removeMessages(2);     // Catch: Throwable -> L16
        L12:
            Handler r103 = this.f470784b.f470776k;     // Catch: Throwable -> L16
            if (r103 == null) goto L19;
            d.o(r103, 3, Boolean.valueOf(r101), 50);     // Catch: Throwable -> L16
            return;
        L19:
            return;
        L8:
            r101 = false;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set<g1c.b<?>> f470785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f470786b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Set<? extends g1c.b<?>> r100, d r101) {
            this.f470785a = r100;
            this.f470786b = r101;
        }

        public final void a() {
            Set<g1c.b<?>> r100 = this.f470785a;
            d r101 = this.f470786b;
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            g1c.b r103 = (g1c.b) r102.next();
            Iterator r104 = ((HashMap) r101.f470766a).values().iterator();
        L7:
            if (r104.hasNext() == false) goto L4;
            r103.e((o1c.c) r104.next());
            goto L7
        L9:
            Handler r105 = this.f470786b.f470776k;
            if (r105 == null) goto L15;
            d.o(r105, 1, this.f470785a, 100);
            return;
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
    }

    static {
        f470765m = Log.isLoggable("PreloadTaskManager", 2);
    }

    public d() {
        this.f470766a = new HashMap();
        this.f470767b = new ConcurrentHashMap();
        this.f470768c = new ConcurrentHashMap();
        this.f470769d = new HashMap();
        this.f470770e = new ArrayList();
        this.f470771f = new e1c.a();
        int r100 = n1c.a.f516682h;
        this.f470772g = n1c.a.C6882a.a(1, Math.max(r100 * 8, 64));
        this.f470773h = n1c.a.C6882a.a(1, r100);
        this.f470774i = new ArrayList();
        this.f470775j = new AtomicBoolean(false);
    }

    @Override // e1c.b
    public final void a(Set<? extends g1c.b<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditions");
        Handler r101 = this.f470776k;
        if (r101 == null) goto L6;
        r101.post(new e(r100, this));
        return;
    }

    @Override // e1c.b.a
    public final void c(o1c.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<T> r101 = this.f470770e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e1c.b.a) r101.next()).c(r100);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskDisabled:".concat(r100.getClass().getSimpleName()));
    }

    @Override // e1c.b.a
    public final void d(o1c.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<T> r101 = this.f470770e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e1c.b.a) r101.next()).d(r100);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskAdded:" + r100.getClass().getSimpleName() + '_' + r100.getTaskId());
    }

    @Override // e1c.b
    public final void f(Set<? extends g1c.b<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditions");
        Handler r101 = this.f470776k;
        if (r101 == null) goto L6;
        r101.post(new f(r100, this));
        return;
    }

    @Override // o1c.c.a
    public final void g(o1c.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<T> r101 = this.f470770e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((e1c.b.a) r101.next()).g(r100);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskCleared:".concat(r100.getClass().getSimpleName()));
    }

    @Override // e1c.b
    public final void h(Set<? extends g1c.b<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditions");
        Handler r101 = this.f470776k;
        if (r101 == null) goto L6;
        o(r101, 4, r100, 50);
        return;
    }

    @Override // e1c.b
    public final void i(Set<? extends g1c.b<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "conditions");
        Handler r101 = this.f470776k;
        if (r101 == null) goto L6;
        r101.post(new RunnableC5731d(r100, this));
        return;
    }

    public final String j(o1c.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Handler r101 = this.f470776k;
        if (r101 == null) goto L6;
        r101.post(new c(this, r100));
    L6:
        return r100.getTaskId();
    }

    @Override // o1c.c.a
    public final void e(o1c.c<?, ?> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<T> r102 = this.f470770e.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((e1c.b.a) r102.next()).e(r100, r101);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskPreExecuted:" + r100.getClass().getSimpleName() + '_' + r100.getTaskId());
    }

    @Override // o1c.c.a
    public final void m(o1c.c r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<e1c.b.a> r102 = this.f470770e.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().m(r100, r101);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onHitCache:".concat(r100.getClass().getSimpleName()));
    }

    public final Object n(Class r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "taskClass");
        o1c.c r102 = (o1c.c) ((ConcurrentHashMap) this.f470767b).get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.j(r101);
    }

    @Override // o1c.c.a
    public final void b(o1c.c<?, ?> r100, int r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<T> r103 = this.f470770e.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((e1c.b.a) r103.next()).b(r100, r101, r102);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onTaskPostExecuted:" + r100.getClass().getSimpleName() + '_' + r100.getTaskId());
    }

    @Override // o1c.c.a
    public final void k(o1c.c r100, boolean r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<e1c.b.a> r103 = this.f470770e.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().k(r100, r101, r102);
        goto L4
    L6:
        com.ss.android.lark.log.Log.i("PreloadTaskManager", "onGetCache:".concat(r100.getClass().getSimpleName()));
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, o1c.c] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
    public final void l(Class r100, AudioResourceLoadTask.b r101, IGetDataCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "taskClass");
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        ?? r104 = (o1c.c) ((ConcurrentHashMap) this.f470767b).get(r100);
        r103.element = r104;
        if (r104 != 0) goto L5;
        ?? r105 = r100.newInstance();
        r103.element = r105;
        j((o1c.c) r105);
    L5:
        this.f470772g.execute(new e1c.e(r103, r101, r102));
    }

    public static void o(Handler r100, int r101, Object r102, long r103) {
        r100.removeMessages(r101);
        r100.sendMessageDelayed(Message.obtain(r100, r101, r102), r103);
    }
}
