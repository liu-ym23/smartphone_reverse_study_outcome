package jc1;

import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakContainer<h> f498072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f498073b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakContainer<i> f498074c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C6414b f498075d = null;

    public static final class a implements h {
        public a() {
        }

        @Override // jc1.h
        public final void a(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.a(r100);
            goto L4
        }

        @Override // jc1.h
        public final void b(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.b(r100);
            goto L4
        }

        @Override // jc1.h
        public final void c(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.c(r100);
            goto L4
        }

        @Override // jc1.h
        public final void d(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.d(r100);
            goto L4
        }

        @Override // jc1.h
        public final void e(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.e(r100);
            goto L4
        }

        @Override // jc1.h
        public final void f(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.f(r100);
            goto L4
        }

        @Override // jc1.h
        public final void g(boolean r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.g(r100);
            goto L4
        }

        @Override // jc1.h
        public final void h(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<h> r102 = b.f498072a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            h r103 = r102.next();
            if (r103 == null) goto L4;
            r103.h(r100);
            goto L4
        }
    }

    /* JADX INFO: renamed from: jc1.b$b, reason: collision with other inner class name */
    public static final class C6414b implements i {
        public C6414b() {
        }

        @Override // jc1.i
        public final void a(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<i> r102 = b.f498074c.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            i r103 = r102.next();
            if (r103 == null) goto L4;
            r103.a(r100);
            goto L4
        }

        @Override // jc1.i
        public final void b(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<i> r102 = b.f498074c.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            i r103 = r102.next();
            if (r103 == null) goto L4;
            r103.b(r100);
            goto L4
        }

        @Override // jc1.i
        public final void c(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<i> r102 = b.f498074c.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            i r103 = r102.next();
            if (r103 == null) goto L4;
            r103.c(r100);
            goto L4
        }

        @Override // jc1.i
        public final void d(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<i> r102 = b.f498074c.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            i r103 = r102.next();
            if (r103 == null) goto L4;
            r103.d(r100);
            goto L4
        }

        @Override // jc1.i
        public final void e(long r100) {
            WeakContainer<h> r101 = b.f498072a;
            Iterator<i> r102 = b.f498074c.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            i r103 = r102.next();
            if (r103 == null) goto L4;
            r103.e(r100);
            goto L4
        }
    }

    static {
        f498072a = new WeakContainer();
        f498073b = new a();
        f498074c = new WeakContainer();
        f498075d = new C6414b();
    }

    @JvmStatic
    public static final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f498072a.add(r100);
    }

    @JvmStatic
    public static final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        f498072a.remove(r100);
    }
}
