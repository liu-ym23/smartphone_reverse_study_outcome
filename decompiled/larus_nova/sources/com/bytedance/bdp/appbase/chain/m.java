package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.bdptask.BdpTrace;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes11.dex */
public class m<T, R> extends TaskBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f200746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m<?, ?> f200747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f200748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f200749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BdpTask.Builder f200750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f200751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public i0 f200752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<f, T, R> f200753i;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f200754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f200755b;

        public a(m r100, f r101) {
            this.f200754a = r100;
            this.f200755b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final R call() {
            Function2<f, T, R> r100 = this.f200754a.f200753i;
            f r101 = this.f200755b;
            return r100.invoke(r101, (T) r101.f200698d);
        }
    }

    public final BdpTask.Builder i() {
        BdpTask.Builder r100 = this.f200750f;
        if (r100 != null) goto L6;
        BdpTask.Builder r101 = new BdpTask.Builder();
        this.f200750f = r101;
        return r101;
    L6:
        return r100;
    }

    public final void k() {
        BdpPool.directRun("", new n(new f(), this, null));
    }

    public m<?, ?> j() {
        return this.f200747c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function2<? super f, ? super T, ? extends R> r100) {
        this.f200753i = r100;
        int r101 = Chain.f200668k.incrementAndGet();
        this.f200745a = r101;
        this.f200746b = r101;
        this.f200752h = i0.b.f200743a;
    }

    public static String h(f r100) {
        String r101 = r100.f200710p;
        if (r101 == null) goto L10;
        Integer r102 = r100.f200696b;
        if (r102 == null) goto L8;
        String r103 = "FL." + r102.intValue() + Typography.greater;
        if (r103 == null) goto L8;
    L12:
        return r103 + "FL." + r100.f200695a + ' ' + r101;
    L8:
        r103 = "";
        goto L12
    L10:
        return null;
    }

    @Override // com.bytedance.bdp.appbase.chain.TaskBuilder
    public final void b(f r100) {
        m r101 = this;
    L3:
        if (r101 == null) goto L9;
        m<?, ?> r102 = r101.f200747c;
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.f200745a);
    L8:
        r100.f200703i = r103;
        r101 = r101.f(r100);
        goto L3
    L7:
        r103 = null;
        goto L8
    }

    public boolean e(f r100) {
        if (r100.f200699e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public m<?, ?> f(f r100) {
        if (e(r100) == true) goto L5;
    L38:
        th = move-exception;
        return d(th, r100);
    L7:
        if (r100.f200705k == false) goto L19;
        e r101 = r100.f200699e;     // Catch: Throwable -> L38
        if (r101 == null) goto L18;
        Throwable r102 = r101.f200692a;     // Catch: Throwable -> L38
        if (r102 == null) goto L18;
        if ((r102 instanceof CancelEvent) == true) goto L16;
        r102 = null;
    L16:
        if (r102 == null) goto L18;
        throw r102;     // Catch: Throwable -> L38
    L18:
        throw new CancelEvent(null, 1, null);     // Catch: Throwable -> L38
    L19:
        String r103 = h(r100);     // Catch: Throwable -> L38
        if (r103 == null) goto L22;
        Object r104 = BdpPool.directRun(r103, new a(this, r100));     // Catch: Throwable -> L38
    L23:
        r100.f200698d = r104;     // Catch: Throwable -> L38
        if (r100.f200705k == false) goto L37;
        e r105 = r100.f200699e;     // Catch: Throwable -> L38
        if (r105 == null) goto L35;
        Throwable r106 = r105.f200692a;     // Catch: Throwable -> L38
        if (r106 == null) goto L35;
        if ((r106 instanceof CancelEvent) == true) goto L33;
        r106 = null;
    L33:
        if (r106 == null) goto L35;
        throw r106;     // Catch: Throwable -> L38
    L35:
        throw new CancelEvent(null, 1, null);     // Catch: Throwable -> L38
    L37:
        return g(r100);
    L22:
        r104 = this.f200753i.invoke(r100, (T) r100.f200698d);     // Catch: Throwable -> L38
        goto L23
    L5:
        return g(r100);
    }

    public final m<?, ?> g(f r100) {
        m<?, ?> r101 = j();
        if (r101 == null) goto L5;
        int r102 = r101.f200745a;
    L6:
        ArrayList<Chain<?>> r103 = r100.f200700f.get(r102);
        if (r103 == null) goto L24;
        if (r103.size() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L24;
        if (r103.isEmpty() == true) goto L22;
        ListIterator<Chain<?>> r105 = r103.listIterator(r103.size());
    L20:
        if (r105.hasPrevious() == false) goto L22;
        Chain<?> r106 = r105.previous();
        r106.f200747c = r101;
        r101 = r106;
    L22:
        r100.f200700f.remove(r102);
        r101 = (m) ListProtector.get(r103, 0);
        goto L24
    L11:
        r104 = false;
    L24:
        return c(r100, r101);
    L5:
        r102 = r100.f200697c;
        goto L6
    }

    public final m<?, ?> c(f r100, m<?, ?> r110) {
        if (r110 == null) goto L5;
        r100.f200704j = r110;
        final p r101 = this.f200748d;
        if (r101 != null) goto L23;
    L48:
        Object r102 = this.f200749e;
        if (r102 == null) goto L53;
        r100.f200718x.remove(r102);
        f0<Object> r103 = g.a(r102, r100.f200695a);
        if (r103 == null) goto L53;
        r103.b(r103.f200729k.f200698d);
    L53:
        r100.f200710p = null;
        BdpTask.Builder r104 = this.f200750f;
        r100.f200707m = r104;
        r100.f200708n = this.f200752h;
        r100.f200709o = this.f200751g;
        if (r104 == null) goto L56;
        r100.f200711q.put(Integer.valueOf(this.f200746b), new e0(r100.f200708n, r104));
    L56:
        boolean r105 = false;
    L57:
        if (r105 == false) goto L60;
        return null;
    L60:
        if (r100.f200707m != null) goto L64;
        BdpTask.Builder r106 = r100.f200714t;
        if (r106 == null) goto L64;
        r100.f200707m = r106;
    L64:
        BdpTask.Builder r107 = r100.f200707m;
        if (r107 != null) goto L74;
        e0 r108 = r100.f200711q.get(Integer.valueOf(r110.f200746b));
        if (r108 == null) goto L83;
        if ((true ^ Intrinsics.areEqual(r108.f200694b, r100.f200712r)) == true) goto L72;
        r108 = null;
    L72:
        if (r108 == null) goto L83;
        r107 = r108.f200694b;
        r100.f200707m = r107.build().newBuilder().delayedMillis(0).stageListener(null).trace("CN_POP");
        r100.f200709o = 0;
        r100.f200708n = r108.f200693a;
    L83:
        if (r100.f200714t == null) goto L85;
        r100.f200708n = i0.a.f200742a;
        r100.f200714t = null;
    L85:
        BdpTask r109 = r110.a(r100);
        if (r109 == null) goto L95;
        r100.f200712r = r107;
        BdpPool.execute(r109);
        return null;
    L95:
        return r110;
    L74:
        StringBuilder r111 = new StringBuilder();
        if (Intrinsics.areEqual(r107, r100.f200714t) == false) goto L77;
        String r112 = "CN_RESUME ";
    L78:
        r111.append(r112);
        String r113 = h(r100);
        if (r113 != null) goto L81;
        r113 = "";
    L81:
        r111.append(r113);
        r107.trace(r111.toString());
        goto L83
    L77:
        r112 = "CN_NEXT ";
        goto L78
    L23:
        if (r100.f200718x.contains(r101.f200759a) == true) goto L42;
        Function1<f, f0<Object>> r114 = new Flow$addLock$puppetCreator$1(r101, this);
        Object r115 = r101.f200759a;
        int r116 = r101.f200760b;
        HashMap<Object, h> r117 = g.f200735a;
        monitor-enter(r117);
        h r118 = r117.get(r115);     // Catch: Throwable -> L45
        if (r118 != null) goto L31;
        r118 = new h(r116);     // Catch: Throwable -> L45
        r117.put(r115, r118);     // Catch: Throwable -> L45
    L31:
        if (r118.f200737a.contains(Integer.valueOf(r100.f200695a)) == false) goto L35;
        monitor-exit(r117);
        f0<Object> r119 = null;
    L39:
        if (r119 != null) goto L43;
        r100.f200718x.add(r101.f200759a);
    L43:
        if (r119 == null) goto L48;
        r105 = true;
        goto L57
    L35:
        if (r118.f200737a.size() >= r118.f200739c) goto L37;
        r118.f200737a.addLast(Integer.valueOf(r100.f200695a));     // Catch: Throwable -> L45
        r119 = null;
    L38:
        monitor-exit(r117);
        goto L39
    L37:
        r119 = r114.invoke(r100);     // Catch: Throwable -> L45
        r118.f200738b.addLast(r119);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    L42:
        r119 = null;
        goto L43
    L5:
        if (r100.f200716v == true) goto L13;
        r100.f200716v = true;
        Iterator<Object> r120 = r100.f200718x.iterator();
    L9:
        if (r120.hasNext() == false) goto L13;
        f0<Object> r121 = g.a(r120.next(), r100.f200695a);
        if (r121 == null) goto L9;
        r121.b(r121.f200729k.f200698d);
    L13:
        e r122 = r100.f200699e;
        if (r122 == null) goto L19;
        Throwable r123 = r122.f200692a;
        if ((r123 instanceof NotThrowException) == true) goto L19;
        throw r123;
    L19:
        return null;
    }

    public final m<?, ?> d(Throwable r100, f r101) {
        e r102 = r101.f200699e;
        if (r102 == null) goto L5;
        Throwable r103 = r102.f200692a;
    L6:
        boolean r104 = true;
        if ((!Intrinsics.areEqual(r103, r100)) == false) goto L14;
        if ((r100 instanceof NotThrowException) == true) goto L12;
        BdpTrace.getTraceString();
    L12:
        r101.f200699e = new e(r100);
    L14:
        if ((r100 instanceof CancelEvent) == false) goto L18;
        r101.b();
        return g(r101);
    L18:
        if ((r100 instanceof SuspendEvent) == false) goto L45;
        r101.f200699e = null;
        f0<?> r105 = ((SuspendEvent) r100).getPuppetValue();
        Object r106 = r105.f200723e;
        monitor-enter(r106);
        e r107 = r105.f200724f;     // Catch: Throwable -> L41
        if (r107 == null) goto L26;
        r105.f200729k.f200699e = r107;     // Catch: Throwable -> L41
        monitor-exit(r106);
    L30:
        boolean r108 = false;
    L34:
        if (r108 == false) goto L36;
        r101.f200712r = null;
    L37:
        if (r104 == false) goto L40;
        return null;
    L40:
        return g(r101);
    L36:
        r104 = false;
        goto L37
    L26:
        f0.a<?> r109 = r105.f200720b;     // Catch: Throwable -> L41
        if (r109 == null) goto L31;
        r105.f200729k.f200698d = r109.f200731a;     // Catch: Throwable -> L41
        monitor-exit(r106);
        goto L30
    L31:
        r105.d(this);     // Catch: Throwable -> L41
        monitor-exit(r106);
        r108 = true;
    L41:
        th = move-exception;
        throw th;
    L45:
        return g(r101);
    L5:
        r103 = null;
        goto L6
    }
}
