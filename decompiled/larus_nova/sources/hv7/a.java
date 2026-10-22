package hv7;

import androidx.collection.SieveCacheKt;
import com.google.archivepatcher.shared.JreDeflateParameters;
import ev7.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends ev7.a<jv7.b, g> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Iterator<g> f487325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kv7.a f487326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jv7.b f487327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f487328h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f487329i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f487330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f487331k;

    /* JADX INFO: renamed from: hv7.a$a, reason: collision with other inner class name */
    public static class C6202a extends ev7.a.b<jv7.b, g> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final kv7.a f487332i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public final JreDeflateParameters f487333j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f487334k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f487335l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f487336m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DeflaterOutputStream f487337n;

        @Override // ev7.a.b
        public final void b(g r100, jv7.b r101, OutputStream r102) {
            jv7.b r103 = r101;
            if (this.f487333j != null) goto L51;
            return;
        L51:
            InputStream r104 = r103.e(this.f487334k, this.f487335l).c();     // Catch: Throwable -> L19
            JreDeflateParameters r105 = this.f487333j;     // Catch: Throwable -> L17
            Deflater r106 = new Deflater(r105.level, r105.nowrap);     // Catch: Throwable -> L17
            r106.setLevel(r105.level);     // Catch: Throwable -> L15
            r106.setStrategy(r105.strategy);     // Catch: Throwable -> L15
            DeflaterOutputStream r107 = new DeflaterOutputStream(r102, r106, this.f487336m);     // Catch: Throwable -> L15
            this.f487337n = r107;     // Catch: Throwable -> L15
            ev7.a.a(r104, r107);     // Catch: Throwable -> L15
            kv7.a r108 = this.f487332i;     // Catch: Throwable -> L15
            r102.getClass().toString();     // Catch: Throwable -> L15
            r105.toString();     // Catch: Throwable -> L15
            r108.getClass();     // Catch: Throwable -> L15
            iv7.b.a(r104);
            DeflaterOutputStream r109 = this.f487337n;
            if (r109 != null) goto L53;
        L29:
            r106.end();
            r106.finish();
        L30:
            this.f487337n = null;
            iv7.b.a(r102);
            return;
        L53:
            r109.finish();     // Catch: IOException -> L13
            this.f487337n.flush();     // Catch: IOException -> L13
            this.f487337n.close();     // Catch: IOException -> L13
        L13:
            e = move-exception;
            e.printStackTrace();
        L15:
            Throwable th10 = th;
        L45:
            this.f474469h = th10;     // Catch: Throwable -> L32
            iv7.b.a(r104);
            DeflaterOutputStream r110 = this.f487337n;
            if (r110 != null) goto L49;
        L28:
            if (r106 == null) goto L30;
        L49:
            r110.finish();     // Catch: IOException -> L26
            this.f487337n.flush();     // Catch: IOException -> L26
            this.f487337n.close();     // Catch: IOException -> L26
        L26:
            e = move-exception;
            e.printStackTrace();
        L32:
            th = move-exception;
            iv7.b.a(r104);
            DeflaterOutputStream r111 = this.f487337n;
            if (r111 != null) goto L55;
        L39:
            if (r106 == null) goto L41;
            r106.end();
            r106.finish();
        L41:
            this.f487337n = null;
            iv7.b.a(r102);
            throw th;
        L55:
            r111.finish();     // Catch: IOException -> L37
            this.f487337n.flush();     // Catch: IOException -> L37
            this.f487337n.close();     // Catch: IOException -> L37
        L37:
            e = move-exception;
            e.printStackTrace();
        L17:
            th10 = th;
            r106 = null;
        L19:
            th = move-exception;
            th10 = th;
            r104 = null;
            r106 = null;
            goto L45
        }

        public C6202a(g r100, jv7.b r101, boolean r102, long r103, long r104, int r105) throws IOException {
            super(r100, r101, r102, r105);
            this.f487333j = r100.f474480a.f495966b;
            this.f487335l = r104;
            this.f487334k = r103;
            this.f487336m = 4096;
            kv7.a r106 = kv7.a.f506289e;
            if (r106 != null) goto L5;
            r106 = kv7.a.b();
        L5:
            this.f487332i = r106;
        }
    }

    public static class b implements ev7.a.InterfaceC5824a<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jv7.b f487338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f487339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f487340c;

        @Override // ev7.a.InterfaceC5824a
        public final /* bridge */ /* synthetic */ g a() {
            return null;
        }

        @Override // ev7.a.InterfaceC5824a
        public final void destroy() {
        }

        @Override // ev7.a.InterfaceC5824a
        public final jv7.b b() {
            return this.f487338a.e(this.f487339b, this.f487340c);
        }

        @Override // ev7.a.InterfaceC5824a
        public final InputStream openStream() throws IOException {
            return this.f487338a.e(this.f487339b, this.f487340c).c();
        }

        @Override // ev7.a.InterfaceC5824a
        public final long getLength() {
            return this.f487340c;
        }

        public b(jv7.b r100, long r101, long r102) {
            this.f487338a = r100;
            this.f487339b = r101;
            this.f487340c = r102;
        }
    }

    public final long b() {
        g r100 = this.f487329i;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.f474480a.b() - (this.f487331k + this.f487330j);
    }

    public final void c(Object r110) throws IOException {
        jv7.b r100 = (jv7.b) r110;
        this.f487327g = r100;
        this.f487328h = r100.b();
        this.f487331k = 0;
    L4:
        if (this.f487331k >= this.f487328h) goto L30;
        if (b() == 0) goto L7;
        long r101 = this.f487331k;
        if (this.f487329i != null) goto L25;
    L28:
        long r102 = this.f487328h - this.f487331k;
    L29:
        long r111 = r102;
        ((LinkedList) this.f474461d).offer(new b(this.f487327g, r101, r111));
        this.f487331k += r111;
        goto L4
    L25:
        if ((b() + r101) > this.f487328h) goto L28;
        r102 = b();
        goto L29
    L7:
        long r103 = this.f487329i.f474480a.a();
        long r104 = this.f474459b;
        if (r104 >= r103) goto L10;
    L13:
        boolean r112 = false;
    L14:
        g r113 = this.f487329i;
        jv7.b r114 = this.f487327g;
        long r115 = r113.f474480a.b() - this.f487330j;
        long r116 = this.f487329i.f474480a.a();
        long r105 = this.f487329i.f474481b;
        if (r105 <= SieveCacheKt.NodeLinkMask) goto L17;
        int r117 = -1;
    L18:
        C6202a r106 = new C6202a(r113, r114, r112, r115, r116, r117);
        this.f474460c.submit(r106);
        ((LinkedList) this.f474461d).offer(new ev7.b(r106));
        this.f487331k += this.f487329i.f474480a.a();
        if (this.f487325e.hasNext() == true) goto L20;
        this.f487329i = null;
        goto L4
    L20:
        this.f487329i = this.f487325e.next();
        goto L4
    L17:
        r117 = (int) r105;
        goto L18
    L10:
        if (r103 > SieveCacheKt.NodeLinkMask) goto L13;
        this.f474459b = r104 - r103;
        r112 = true;
        goto L14
    L30:
        this.f487326f.getClass();
    }

    public final void d(@Nonnull OutputStream r100) throws IOException {
    L30:
    L20:
        th = move-exception;
        r100.flush();     // Catch: IOException -> L23
    L25:
        throw th;
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L3:
        if (this.f474461d.isEmpty() == true) goto L26;
        ev7.a.InterfaceC5824a r101 = (ev7.a.InterfaceC5824a) ((LinkedList) this.f474461d).poll();     // Catch: Throwable -> L20
        InputStream r102 = r101.openStream();     // Catch: Throwable -> L10
        this.f487326f.getClass();     // Catch: Throwable -> L8
        ev7.a.a(r102, r100);     // Catch: Throwable -> L8
        this.f487326f.getClass();     // Catch: Throwable -> L8
        iv7.b.a(r102);     // Catch: Throwable -> L20
        r101.destroy();     // Catch: Throwable -> L20
    L8:
        th = th;
    L12:
        iv7.b.a(r102);     // Catch: Throwable -> L20
        r101.destroy();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L10:
        th = th;
        r102 = null;
        goto L12
    L26:
        r100.flush();     // Catch: IOException -> L16
    L18:
        this.f487330j += this.f487331k;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public a(List<g> r100, long r101, ExecutorService r102) {
        super(r100, r101, r102);
        Iterator<g> r103 = r100.iterator();
        this.f487325e = r103;
        if (r103.hasNext() == false) goto L5;
        this.f487329i = r103.next();
    L6:
        kv7.a r104 = kv7.a.f506289e;
        if (r104 != null) goto L9;
        r104 = kv7.a.b();
    L9:
        this.f487326f = r104;
        return;
    L5:
        this.f487329i = null;
        goto L6
    }
}
