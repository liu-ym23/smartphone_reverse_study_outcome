package com.bytedance.locallife.pdp.container.view.lynx;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements LynxLoadDispatcher, Handler.Callback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f261289j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f261290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f261291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.container.view.lynx.a f261292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.locallife.pdp.container.view.lynx.a f261293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Pair<Boolean, l>> f261294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f261295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f261296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f261297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f261298i;

    public final class a implements LynxLoader.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f261299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LynxLoader.c f261300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f261301c;

        /* JADX INFO: renamed from: com.bytedance.locallife.pdp.container.view.lynx.b$a$a, reason: collision with other inner class name */
        public static final class RunnableC3685a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f261302a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f261303b;

            public RunnableC3685a(b r100, a r101) {
                this.f261302a = r100;
                this.f261303b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f261302a;     // Catch: Throwable -> L4
                String r101 = this.f261303b.f261299a;     // Catch: Throwable -> L4
                int r102 = b.f261289j;     // Catch: Throwable -> L4
                r100.e(r101);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoader.c
        public final void a() {
            LynxLoader.c r100 = this.f261300b;
            if (r100 == null) goto L5;
            r100.a();
        L5:
            b r101 = this.f261301c;
            r101.f261295f.post(new RunnableC3685a(r101, this));
        }

        public a(b r100, String r101, LynxLoader.c r102) {
            Intrinsics.checkNotNullParameter(r101, "uniqueTag");
            this.f261301c = r100;
            this.f261299a = r101;
            this.f261300b = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.locallife.pdp.container.view.lynx.b$b, reason: collision with other inner class name */
    public static final class C3686b {
    }

    public final class c implements LynxLoader.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f261304a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Pair<l, LynxLoader> f261305b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f261306c;

        @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoader.b
        public final void a(i r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f261305b.getFirst().f261330a.f261325d.a(r100);
            b r101 = this.f261306c;
            r101.f261295f.post(new com.bytedance.locallife.pdp.container.view.lynx.c(this, r101));
        }

        @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoader.b
        public final void c(i r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f261305b.getFirst().f261330a.f261325d.c(r100);
        }

        @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoader.b
        public final void d(Throwable r100) {
            this.f261305b.getFirst().f261330a.f261325d.d(r100);
            b r101 = this.f261306c;
            r101.f261295f.post(new com.bytedance.locallife.pdp.container.view.lynx.c(this, r101));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(b r100, boolean r101, Pair<l, ? extends LynxLoader> r102) {
            Intrinsics.checkNotNullParameter(r102, "lynxLoadTaskAndLoader");
            this.f261306c = r100;
            this.f261304a = r101;
            this.f261305b = r102;
        }

        @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoader.b
        public final void b(i r100, String r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "stats");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.f261305b.getFirst().f261330a.f261325d.b(r100, r101, r102);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f261307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f261308b;

        public d(b r100, l r101) {
            this.f261307a = r100;
            this.f261308b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f261307a.b(this.f261308b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f261309a;

        public e(b r100) {
            this.f261309a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f261309a;     // Catch: Throwable -> L4
            r100.f261292c.a();     // Catch: Throwable -> L4
            r100.f261293d.a();     // Catch: Throwable -> L4
            ((LinkedHashMap) r100.f261294e).clear();     // Catch: Throwable -> L4
            r100.f261297h = 0;     // Catch: Throwable -> L4
            r100.f261298i = 0;     // Catch: Throwable -> L4
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
    }

    public b() {
        g r100 = g.f261321a;
        Intrinsics.checkNotNullParameter(r100, "lynxLoaderFactory");
        this.f261290a = r100;
        this.f261291b = 5;
        this.f261292c = new com.bytedance.locallife.pdp.container.view.lynx.a();
        this.f261293d = new com.bytedance.locallife.pdp.container.view.lynx.a();
        this.f261294e = new LinkedHashMap();
        this.f261295f = new Handler(Looper.getMainLooper(), this);
        this.f261296g = new AtomicInteger(1);
    }

    @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoadDispatcher
    public final void release() {
        if (this.f261296g.compareAndSet(0, 2) == false) goto L6;
        reset();
        return;
    }

    @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoadDispatcher
    public final void reset() {
        this.f261295f.removeCallbacksAndMessages(null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        this.f261292c.a();
        this.f261293d.a();
        ((LinkedHashMap) this.f261294e).clear();
        this.f261297h = 0;
        this.f261298i = 0;
        return;
    L5:
        this.f261295f.post(new e(this));
    }

    public static void d() {
        HostServiceUtilsKt.u().p();
    }

    @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoadDispatcher
    public final void a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxLoadTask");
        Objects.toString(r100.f261331b);
        d();
        if (this.f261296g.get() != 2) goto L11;
        LynxLoadDispatcher.a r101 = r100.f261334e;
        if (r101 == null) goto L7;
        r101.b(new IllegalStateException("cancelled"));
    L7:
        qs6.b r102 = HostServiceUtilsKt.k();
        if (r102 == null) goto L17;
        r102.e("DLLD", "try dispatch but in cancel state now");
        return;
    L17:
        return;
    L11:
        this.f261296g.compareAndSet(1, 0);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L15;
        b(r100);
        return;
    L15:
        this.f261295f.post(new d(this, r100));
    }

    public final void b(l r100) {
        LynxLoadDispatcher.LoadType r101 = r100.f261331b;
        LynxLoadDispatcher.LoadType r102 = LynxLoadDispatcher.LoadType.CACHE;
        boolean r103 = true;
        if (r101 != r102) goto L5;
        this.f261298i++;
    L7:
        if (r101 == r102) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L21;
        String r105 = "has run normal tasks before,just ignore cache task:" + r100.f261332c;
        qs6.b r106 = HostServiceUtilsKt.k();
        if (r106 == null) goto L16;
        r106.e("DLLD", r105);
    L16:
        LynxLoadDispatcher.a r107 = r100.f261334e;
        if (r107 == null) goto L77;
        r107.b(new IllegalStateException("has normal tasks before,ignore current"));
        return;
    L77:
        return;
    L21:
        if (r100.f261331b != LynxLoadDispatcher.LoadType.NORMAL) goto L29;
        Iterator r108 = ((ArrayList) this.f261293d.f261287c).iterator();
    L24:
        if (r108.hasNext() == false) goto L28;
        LynxLoadDispatcher.a r109 = ((l) r108.next()).f261334e;
        if (r109 == null) goto L24;
        r109.b(new IllegalStateException("cancelledByNormalTask"));
        goto L24
    L28:
        ((ArrayList) this.f261293d.f261287c).clear();
    L29:
        LynxLoadDispatcher.LoadType r110 = r100.f261331b;
        if (r110 != LynxLoadDispatcher.LoadType.NORMAL) goto L32;
        int r111 = this.f261297h;
    L34:
        if (r111 > this.f261291b) goto L36;
        boolean r112 = true;
    L37:
        if (r112 == true) goto L52;
        LynxLoadDispatcher.LoadType r113 = LynxLoadDispatcher.LoadType.CACHE;
        if (r110 != r113) goto L41;
        com.bytedance.locallife.pdp.container.view.lynx.a r114 = this.f261293d;
    L43:
        if ((!(!((ArrayList) r114.f261285a).isEmpty())) == true) goto L52;
        Objects.toString(r100.f261331b);
        d();
        if (r100.f261331b != r113) goto L48;
        com.bytedance.locallife.pdp.container.view.lynx.a r115 = this.f261293d;
    L49:
        r115.getClass();
        Intrinsics.checkNotNullParameter(r100, "task");
        ((ArrayList) r115.f261287c).add(r100);
        return;
    L48:
        r115 = this.f261292c;
        goto L49
    L41:
        r114 = this.f261292c;
    L52:
        if (r100.f261331b == LynxLoadDispatcher.LoadType.CACHE) goto L67;
        com.bytedance.locallife.pdp.container.view.lynx.a r116 = this.f261293d;
        String r117 = r100.f261332c;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, "uniqueTaskTag");
        if (((ArrayList) r116.f261288d).contains(r117) == false) goto L67;
        IPoiLynxKitDelegate r118 = r100.f261330a.f261323b;
        if (r118 == null) goto L62;
        CubeContext r119 = r118.getCubeContext();
        if (r119 == null) goto L62;
        DelegateStatus r120 = r119.a();
    L64:
        if (r120 == DelegateStatus.SUCCESS) goto L67;
        r103 = false;
    L62:
        r120 = null;
    L67:
        if (r103 == false) goto L70;
        c(r112, r100);
        return;
    L70:
        d();
        Pair<Boolean, l> r121 = new Pair(Boolean.valueOf(r112), r100);
        this.f261294e.put(r100.f261332c, r121);
        Handler r122 = this.f261295f;
        r122.sendMessageDelayed(Message.obtain(r122, 123, r121), 500);
        return;
    L36:
        r112 = false;
        goto L37
    L32:
        r111 = this.f261298i;
        goto L34
    L9:
        if ((!((ArrayList) this.f261292c.f261288d).isEmpty()) == false) goto L11;
        r104 = true;
        goto L12
    L5:
        this.f261297h++;
        goto L7
    }

    public final void e(String r100) {
        this.f261295f.removeMessages(123);
        Pair<Boolean, l> r101 = this.f261294e.remove(r100);
        if (r101 == null) goto L6;
        d();
        l r102 = r101.getSecond();
        c(r101.getFirst().booleanValue(), r102);
        return;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (this.f261296g.get() == 0) goto L6;
        return true;
    L6:
        if (r100.what != 123) goto L49;
        Object r101 = r100.obj;
        DelegateStatus r102 = null;
        if ((r101 instanceof Pair) == false) goto L10;
        Pair r103 = (Pair) r101;
    L11:
        if (r103 == null) goto L13;
        Object r104 = r103.getFirst();
    L15:
        if ((r104 instanceof Boolean) == false) goto L17;
        Boolean r105 = (Boolean) r104;
    L18:
        if (r103 == null) goto L20;
        Object r106 = r103.getSecond();
    L22:
        if ((r106 instanceof l) == false) goto L24;
        l r107 = (l) r106;
    L25:
        if (r105 == null) goto L49;
        if (r107 == null) goto L49;
        IPoiLynxKitDelegate r108 = r107.f261330a.f261323b;
        if (r108 == null) goto L33;
        CubeContext r109 = r108.getCubeContext();
        if (r109 == null) goto L33;
        r102 = r109.a();
    L33:
        if (r102 != DelegateStatus.SUCCESS) goto L35;
        boolean r110 = true;
    L37:
        if (r110 == false) goto L43;
        qs6.b r111 = HostServiceUtilsKt.k();
        if (r111 == null) goto L41;
        r111.e("DLLD", "timeout to wait,but now in right state");
    L41:
        e(r107.f261332c);
        return true;
    L43:
        qs6.b r112 = HostServiceUtilsKt.k();
        if (r112 == null) goto L46;
        r112.e("DLLD", "timeout to wait,in error state");
    L46:
        this.f261294e.remove(r107.f261332c);
        LynxLoadDispatcher.a r113 = r107.f261334e;
        if (r113 == null) goto L49;
        r113.b(new IllegalStateException("timeoutToWaitCubeSwitchToSuccessState"));
        goto L49
    L35:
        r110 = false;
        goto L37
    L24:
        r107 = null;
        goto L25
    L20:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L15
    L10:
        r103 = null;
    L49:
        return true;
    }

    public final void c(boolean r100, l r110) {
        Objects.toString(r110.f261331b);
        if (this.f261296g.get() == 0) goto L8;
        LynxLoadDispatcher.a r101 = r110.f261334e;
        if (r101 == null) goto L28;
        r101.b(new IllegalStateException("cancelled"));
        return;
    L28:
        return;
    L8:
        LynxLoadDispatcher.a r102 = r110.f261334e;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        m r103 = this.f261290a;
        j r104 = r110.f261333d;
        if (r104 != null) goto L14;
        r104 = new j(false);
    L14:
        com.bytedance.locallife.pdp.container.view.lynx.d r105 = r103.a(r104);
        Pair r106 = new Pair(r110, r105);
        LynxLoadDispatcher.LoadType r107 = r110.f261331b;
        LynxLoadDispatcher.LoadType r108 = LynxLoadDispatcher.LoadType.CACHE;
        if (r107 != r108) goto L17;
        com.bytedance.locallife.pdp.container.view.lynx.a r109 = this.f261293d;
    L18:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "task");
        Intrinsics.checkNotNullParameter(r105, "loader");
        if (r100 == false) goto L21;
        List<Pair<l, LynxLoader>> r111 = r109.f261285a;
    L22:
        r111.add(new Pair(r110, r105));
        List<String> r112 = r109.f261288d;
        ArrayList r113 = (ArrayList) r112;
        r113.add(r110.f261332c);
        h r114 = r110.f261330a;
        String r115 = r114.f261322a;
        IPoiLynxKitDelegate r116 = r114.f261323b;
        LynxLoader.a r117 = r114.f261324c;
        c r118 = new c(this, r100, r106);
        if (r110.f261331b != r108) goto L25;
        a r119 = new a(this, r110.f261332c, r114.f261326e);
    L26:
        r105.b(r115, r116, r117, r118, r119);
        return;
    L25:
        r119 = null;
        goto L26
    L21:
        r111 = r109.f261286b;
        goto L22
    L17:
        r109 = this.f261292c;
        goto L18
    }
}
