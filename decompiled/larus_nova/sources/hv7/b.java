package hv7;

import androidx.collection.SieveCacheKt;
import iv7.c;
import iv7.f;
import iv7.i;
import iv7.l;
import iv7.n;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes23.dex */
public final class b<T> extends ev7.a<jv7.b, n<T>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kv7.a f487341e;

    public static class a<T> implements ev7.a.InterfaceC5824a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jv7.b f487342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InputStream f487343b;

        @Override // ev7.a.InterfaceC5824a
        public final Object a() {
            return null;
        }

        @Override // ev7.a.InterfaceC5824a
        public final void destroy() {
            iv7.b.a(this.f487343b);
            iv7.b.a(this.f487342a);
        }

        @Override // ev7.a.InterfaceC5824a
        public final long getLength() {
            return this.f487342a.b();
        }

        @Override // ev7.a.InterfaceC5824a
        public final InputStream openStream() throws IOException {
            BufferedInputStream r100 = new BufferedInputStream(this.f487342a.c());
            this.f487343b = r100;
            return r100;
        }

        @Override // ev7.a.InterfaceC5824a
        public final jv7.b b() {
            return this.f487342a;
        }

        public a(jv7.b r100) {
            this.f487342a = r100;
        }
    }

    /* JADX INFO: renamed from: hv7.b$b, reason: collision with other inner class name */
    public static class C6203b<T> extends ev7.a.b<jv7.b, T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final f f487344i;

        public C6203b(n r100, jv7.b r101, boolean r102) throws IOException {
            super(r100, r101, r102, -1);
            f r103 = new f();
            this.f487344i = r103;
            if (true == r103.f495951a) goto L8;
            i r104 = r103.f495952b;
            if (r104 == null) goto L7;
            r104.a();
            r103.f495952b = null;
        L7:
            r103.f495951a = true;
        L8:
            r103.f495953c = true;
        }

        @Override // ev7.a.b
        public final void b(Object r100, jv7.b r101, OutputStream r102) {
            InputStream r103 = r101.c();     // Catch: IOException -> L17
            this.f487344i.a(r103, r102);     // Catch: Throwable -> L8
            r102.flush();     // Catch: Throwable -> L8
            if (r103 == null) goto L27;
            r103.close();     // Catch: IOException -> L17
            return;
        L27:
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (r103 != null) goto L25;
        L16:
            throw th;     // Catch: IOException -> L17
        L25:
            r103.close();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L17
        L17:
            e = move-exception;
            e.printStackTrace();
            this.f474469h = e;
        }
    }

    public b(List<n<T>> r100, long r101, ExecutorService r102) {
        super(r100, r101, r102);
    }

    public final void b(List<n<T>> r110, jv7.b r111, Queue<ev7.a.InterfaceC5824a<n<T>>> r112) throws IOException {
        if (r110 == null) goto L25;
        Iterator<n<T>> r113 = r110.iterator();
        long r100 = 0;
    L5:
        if (r113.hasNext() == false) goto L17;
        n<T> r101 = r113.next();
        long r102 = r101.b() - r100;
        if (r102 <= 0) goto L9;
        ((LinkedList) r112).offer(new a(r111.e(r100, r102)));
        this.f487341e.getClass();
    L9:
        long r103 = r101.a();
        long r104 = this.f474459b;
        if (r104 >= r103) goto L12;
    L15:
        boolean r105 = false;
    L16:
        C6203b r106 = new C6203b(r101, r111.e(r101.b(), r101.a()), r105);
        this.f487341e.getClass();
        this.f474460c.submit(r106);
        ((LinkedList) this.f474461d).offer(new ev7.b(r106));
        this.f487341e.getClass();
        r100 = r101.b() + r101.a();
        goto L5
    L12:
        if (r103 > SieveCacheKt.NodeLinkMask) goto L15;
        this.f474459b = r104 - r103;
        r105 = true;
        goto L16
    L17:
        long r107 = r111.b() - r100;
        if (r107 <= 0) goto L20;
        ((LinkedList) r112).offer(new a(r111.e(r100, r107)));
    L20:
        this.f487341e.getClass();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(jv7.b r100, l r101, kv7.a r102) throws IOException {
        this.f487341e = r102;
        c r103 = new c(r101);
        b(this.f474458a, r100, this.f474461d);
    L4:
        if (this.f474461d.isEmpty() == true) goto L22;
        ev7.a.InterfaceC5824a r104 = (ev7.a.InterfaceC5824a) ((LinkedList) this.f474461d).poll();
        if (r104.a() != null) goto L13;
        InputStream r105 = r104.openStream();     // Catch: Throwable -> L16
        ev7.a.a(r105, r103);     // Catch: Throwable -> L11
        r104.getLength();     // Catch: Throwable -> L11
    L15:
        iv7.b.a(r105);
        r104.destroy();
    L11:
        Throwable th10 = th;
    L18:
        iv7.b.a(r105);
        if (r104 == null) goto L21;
        r104.destroy();
    L21:
        throw th10;
    L13:
        r105 = r104.openStream();     // Catch: Throwable -> L16
        ev7.a.a(r105, r103);     // Catch: Throwable -> L11
        r104.getLength();     // Catch: Throwable -> L11
    L16:
        th = move-exception;
        th10 = th;
        r105 = null;
        goto L18
    L22:
        r103.flush();
    }
}
