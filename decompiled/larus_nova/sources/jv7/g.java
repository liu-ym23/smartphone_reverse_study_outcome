package jv7;

import com.larus.apm.impl.protector.RunnableProtector;
import iv7.k;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes23.dex */
public final class g extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<h<k>> f500573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<k> f500574e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f500575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f500576b;

        public final void a() {
            g r100 = this.f500576b;
            monitor-enter(r100);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (((ArrayDeque) this.f500576b.f500573d).size() <= 10) goto L7;
            Queue<h<k>> r101 = this.f500576b.f500573d;     // Catch: Throwable -> L10
            ArrayDeque r102 = (ArrayDeque) r101;     // Catch: Throwable -> L10
            r102.remove(this.f500575a);     // Catch: Throwable -> L10
            List<k> r103 = this.f500576b.f500574e;     // Catch: Throwable -> L10
            ArrayList r104 = (ArrayList) r103;     // Catch: Throwable -> L10
            r104.remove(this.f500575a.f500577a);     // Catch: Throwable -> L10
            iv7.b.a(this.f500575a.f500577a);     // Catch: Throwable -> L10
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            Queue<h<k>> r105 = this.f500576b.f500573d;     // Catch: Throwable -> L10
            ArrayDeque r106 = (ArrayDeque) r105;     // Catch: Throwable -> L10
            r106.add(this.f500575a);     // Catch: Throwable -> L10
            goto L8
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

        public a(g r100, h r101) {
            this.f500576b = r100;
            this.f500575a = r101;
        }
    }

    @Override // jv7.b
    public final ByteBuffer a() throws IOException {
        return e.d(this.f500560a, 0, this.f500561b);
    }

    @Override // jv7.d, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        Iterator r100 = ((ArrayList) this.f500574e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        iv7.b.a((k) r100.next());
        goto L4
    }

    public final void finalize() throws Throwable {
        close();
    }

    public g(File r100) throws IOException {
        super(r100, false);
        this.f500573d = new ArrayDeque();
        this.f500574e = new ArrayList();
    }

    public g(File r100, int r101) throws IOException {
        super(r100, true);
        this.f500573d = new ArrayDeque();
        this.f500574e = new ArrayList();
    }

    @Override // jv7.b
    public final InputStream d(long r100, long r101) throws IOException {
        monitor-enter(this);
        h r102 = (h) ((ArrayDeque) this.f500573d).poll();     // Catch: Throwable -> L6
        if (r102 != null) goto L8;
        k r103 = new k(this.f500560a);     // Catch: Throwable -> L6
        ((ArrayList) this.f500574e).add(r103);     // Catch: Throwable -> L6
        r102 = new h(r103);     // Catch: Throwable -> L6
    L8:
        ((k) r102.f500577a).a(r100, r101);     // Catch: Throwable -> L6
        a r104 = new a(this, r102);     // Catch: Throwable -> L6
        r102.f500579c = true;     // Catch: Throwable -> L6
        r102.f500578b = r104;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r102;
    L6:
        th = move-exception;
        throw th;
    }
}
