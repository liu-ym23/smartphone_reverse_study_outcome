package okhttp3;

import androidx.collection.SieveCacheKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.n;

/* JADX INFO: loaded from: classes6.dex */
public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final dvc.e cache;
    private int hitCount;
    final dvc.i internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    /* JADX INFO: loaded from: classes42.dex */
    public class a implements dvc.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Cache f523747a;

        @Override // dvc.i
        public final void b() {
            this.f523747a.trackConditionalCacheHit();
        }

        public a(Cache r100) {
            this.f523747a = r100;
        }

        @Override // dvc.i
        public final Response a(Request r100) throws IOException {
            return this.f523747a.get(r100);
        }

        @Override // dvc.i
        public final void c(dvc.d r100) {
            this.f523747a.trackResponse(r100);
        }

        @Override // dvc.i
        public final void d(Request r100) throws IOException {
            this.f523747a.remove(r100);
        }

        @Override // dvc.i
        public final dvc.c e(Response r100) throws IOException {
            return this.f523747a.put(r100);
        }

        @Override // dvc.i
        public void update(Response r100, Response r101) {
            this.f523747a.update(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class b implements Iterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dvc.g f523748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f523749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f523750c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f523749b == null) goto L5;
            return true;
        L5:
            this.f523750c = false;
        L7:
            if (this.f523748a.hasNext() == false) goto L16;
            dvc.e.d r100 = (dvc.e.d) this.f523748a.next();
            this.f523749b = Okio.buffer(r100.f470277c[0]).readUtf8LineStrict();     // Catch: Throwable -> L12 IOException -> L15
        L10:
            r100.close();
            return true;
        L15:
            r100.close();
        L12:
            th = move-exception;
            r100.close();
            throw th;
        L16:
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f523750c == false) goto L7;
            this.f523748a.remove();
            return;
        L7:
            throw new IllegalStateException("remove() before next()");
        }

        @Override // java.util.Iterator
        public final String next() {
            if (hasNext() == false) goto L7;
            String r100 = this.f523749b;
            this.f523749b = null;
            this.f523750c = true;
            return r100;
        L7:
            throw new NoSuchElementException();
        }

        public b(Cache r100) throws IOException {
            dvc.e r101 = r100.cache;
            monitor-enter(r101);
            r101.g();     // Catch: Throwable -> L8
            dvc.g r102 = new dvc.g(r101);     // Catch: Throwable -> L8
            monitor-exit(r101);
            this.f523748a = r102;
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public final class c implements dvc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dvc.e.b f523751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Sink f523752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f523753c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f523754d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Cache f523755e;

        public class a extends n {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ dvc.e.b f523756b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f523757c;

            @Override // okio.n, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                Cache r100 = this.f523757c.f523755e;
                monitor-enter(r100);
                c r101 = this.f523757c;     // Catch: Throwable -> L12
                if (r101.f523754d == false) goto L8;
                monitor-exit(r100);     // Catch: Throwable -> L12
                return;
            L8:
                r101.f523754d = true;     // Catch: Throwable -> L12
                r101.f523755e.writeSuccessCount++;     // Catch: Throwable -> L12
                monitor-exit(r100);     // Catch: Throwable -> L12
                super.close();
                this.f523756b.b();
                return;
            L12:
                th = move-exception;
                throw th;
            }

            public a(c r100, Sink r101, dvc.e.b r102) {
                this.f523757c = r100;
                this.f523756b = r102;
                super(r101);
            }
        }

        public final void a() {
            Cache r100 = this.f523755e;
            monitor-enter(r100);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.f523754d == false) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L13
            return;
        L8:
            this.f523754d = true;     // Catch: Throwable -> L13
            this.f523755e.writeAbortCount++;     // Catch: Throwable -> L13
            monitor-exit(r100);     // Catch: Throwable -> L13
            cvc.c.e(this.f523752b);
            this.f523751a.a();     // Catch: IOException -> L16
            return;
        }

        public c(Cache r100, dvc.e.b r101) {
            this.f523755e = r100;
            this.f523751a = r101;
            Sink r102 = r101.d(1);
            this.f523752b = r102;
            this.f523753c = new a(this, r102, r101);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class d extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dvc.e.d f523758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f523759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f523760c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final String f523761d;

        public class a extends ForwardingSource {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ dvc.e.d f523762a;

            @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                this.f523762a.close();
                super.close();
            }

            public a(Source r100, dvc.e.d r101) {
                this.f523762a = r101;
                super(r100);
            }
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            String r100 = this.f523761d;     // Catch: NumberFormatException -> L7
            if (r100 == null) goto L10;
            return CastLongProtector.parseLong(r100);
        L10:
            return -1;
        L11:
            return -1;
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            String r100 = this.f523760c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return MediaType.parse(r100);
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.f523759b;
        }

        public d(dvc.e.d r100, String r101, String r102) {
            this.f523758a = r100;
            this.f523760c = r101;
            this.f523761d = r102;
            this.f523759b = Okio.buffer(new a(r100.f470277c[1], r100));
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f523763k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f523764l = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f523765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Headers f523766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f523767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Protocol f523768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f523769e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f523770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Headers f523771g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final j f523772h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f523773i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f523774j;

        static {
            hvc.g r100 = hvc.g.f487396a;
            r100.getClass();
            f523763k = "OkHttp-Sent-Millis";
            r100.getClass();
            f523764l = "OkHttp-Received-Millis";
        }

        public e(Source r100) throws IOException {
            BufferedSource r101 = Okio.buffer(r100);     // Catch: Throwable -> L33
            this.f523765a = r101.readUtf8LineStrict();     // Catch: Throwable -> L33
            this.f523767c = r101.readUtf8LineStrict();     // Catch: Throwable -> L33
            Headers.Builder r102 = new Headers.Builder();     // Catch: Throwable -> L33
            int r103 = Cache.readInt(r101);     // Catch: Throwable -> L33
            int r104 = 0;
            int r105 = 0;
        L4:
            if (r105 >= r103) goto L6;
            r102.addLenient(r101.readUtf8LineStrict());     // Catch: Throwable -> L33
            r105 = r105 + 1;     // Catch: Throwable -> L33
            goto L4
        L6:
            this.f523766b = r102.build();     // Catch: Throwable -> L33
            evc.j r106 = evc.j.a(r101.readUtf8LineStrict());     // Catch: Throwable -> L33
            this.f523768d = r106.f474521a;     // Catch: Throwable -> L33
            this.f523769e = r106.f474522b;     // Catch: Throwable -> L33
            this.f523770f = r106.f474523c;     // Catch: Throwable -> L33
            Headers.Builder r107 = new Headers.Builder();     // Catch: Throwable -> L33
            int r108 = Cache.readInt(r101);     // Catch: Throwable -> L33
        L7:
            if (r104 >= r108) goto L9;
            r107.addLenient(r101.readUtf8LineStrict());     // Catch: Throwable -> L33
            r104 = r104 + 1;     // Catch: Throwable -> L33
            goto L7
        L9:
            String r109 = f523763k;     // Catch: Throwable -> L33
            String r110 = r107.get(r109);     // Catch: Throwable -> L33
            String r111 = f523764l;     // Catch: Throwable -> L33
            String r112 = r107.get(r111);     // Catch: Throwable -> L33
            r107.removeAll(r109);     // Catch: Throwable -> L33
            r107.removeAll(r111);     // Catch: Throwable -> L33
            long r113 = 0;
            if (r110 == null) goto L12;
            long r114 = Long.parseLong(r110);     // Catch: Throwable -> L33
        L13:
            this.f523773i = r114;     // Catch: Throwable -> L33
            if (r112 == null) goto L16;
            r113 = Long.parseLong(r112);     // Catch: Throwable -> L33
        L16:
            this.f523774j = r113;     // Catch: Throwable -> L33
            this.f523771g = r107.build();     // Catch: Throwable -> L33
            if (this.f523765a.startsWith("https://") == false) goto L30;
            String r115 = r101.readUtf8LineStrict();     // Catch: Throwable -> L33
            if (r115.length() > 0) goto L29;
            okhttp3.e r116 = okhttp3.e.a(r101.readUtf8LineStrict());     // Catch: Throwable -> L33
            List r117 = a(r101);     // Catch: Throwable -> L33
            List r118 = a(r101);     // Catch: Throwable -> L33
            if (r101.exhausted() == true) goto L23;
            TlsVersion r119 = TlsVersion.forJavaName(r101.readUtf8LineStrict());     // Catch: Throwable -> L33
        L24:
            if (r119 == null) goto L27;
            this.f523772h = new j(r119, r116, cvc.c.n(r117), cvc.c.n(r118));     // Catch: Throwable -> L33
        L31:
            r100.close();
            return;
        L27:
            throw new NullPointerException("tlsVersion == null");     // Catch: Throwable -> L33
        L23:
            r119 = TlsVersion.SSL_3_0;     // Catch: Throwable -> L33
            goto L24
        L29:
            throw new IOException("expected \"\" but was \"" + r115 + "\"");     // Catch: Throwable -> L33
        L30:
            this.f523772h = null;     // Catch: Throwable -> L33
            goto L31
        L12:
            r114 = 0;
        L33:
            th = move-exception;
            r100.close();
            throw th;
        }

        public static List a(BufferedSource r100) throws IOException {
            int r101 = Cache.readInt(r100);
            if (r101 == (-1)) goto L5;
            CertificateFactory r102 = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L11
            ArrayList r103 = new ArrayList(r101);     // Catch: CertificateException -> L11
            int r104 = 0;
        L7:
            if (r104 >= r101) goto L10;
            String r105 = r100.readUtf8LineStrict();     // Catch: CertificateException -> L11
            Buffer r106 = new Buffer();     // Catch: CertificateException -> L11
            r106.write(ByteString.decodeBase64(r105));     // Catch: CertificateException -> L11
            r103.add(r102.generateCertificate(r106.inputStream()));     // Catch: CertificateException -> L11
            r104 = r104 + 1;
            goto L7
        L10:
            return r103;
        L11:
            e = move-exception;
            throw new IOException(e.getMessage());
        L5:
            return Collections.emptyList();
        }

        public final void c(dvc.e.b r100) throws IOException {
            int r101 = 0;
            BufferedSink r102 = Okio.buffer(r100.d(0));
            r102.writeUtf8(this.f523765a).writeByte(10);
            r102.writeUtf8(this.f523767c).writeByte(10);
            r102.writeDecimalLong(this.f523766b.size()).writeByte(10);
            int r103 = this.f523766b.size();
            int r104 = 0;
        L4:
            if (r104 >= r103) goto L6;
            r102.writeUtf8(this.f523766b.name(r104)).writeUtf8(": ").writeUtf8(this.f523766b.value(r104)).writeByte(10);
            r104 = r104 + 1;
            goto L4
        L6:
            Protocol r105 = this.f523768d;
            int r106 = this.f523769e;
            String r107 = this.f523770f;
            StringBuilder r108 = new StringBuilder();
            if (r105 != Protocol.HTTP_1_0) goto L9;
            String r109 = "HTTP/1.0";
        L10:
            r108.append(r109);
            r108.append(' ');
            r108.append(r106);
            if (r107 == null) goto L13;
            r108.append(' ');
            r108.append(r107);
        L13:
            r102.writeUtf8(r108.toString()).writeByte(10);
            r102.writeDecimalLong(this.f523771g.size() + 2).writeByte(10);
            int r110 = this.f523771g.size();
        L14:
            if (r101 >= r110) goto L16;
            r102.writeUtf8(this.f523771g.name(r101)).writeUtf8(": ").writeUtf8(this.f523771g.value(r101)).writeByte(10);
            r101 = r101 + 1;
            goto L14
        L16:
            r102.writeUtf8(f523763k).writeUtf8(": ").writeDecimalLong(this.f523773i).writeByte(10);
            r102.writeUtf8(f523764l).writeUtf8(": ").writeDecimalLong(this.f523774j).writeByte(10);
            if (this.f523765a.startsWith("https://") == false) goto L19;
            r102.writeByte(10);
            r102.writeUtf8(this.f523772h.f523920b.f523839a).writeByte(10);
            b(r102, this.f523772h.f523921c);
            b(r102, this.f523772h.f523922d);
            r102.writeUtf8(this.f523772h.f523919a.javaName()).writeByte(10);
        L19:
            r102.close();
            return;
        L9:
            r109 = "HTTP/1.1";
            goto L10
        }

        public e(Response r100) {
            this.f523765a = r100.request().url().toString();
            ByteString r101 = evc.e.f474509a;
            Headers r102 = r100.networkResponse().request().headers();
            Set<String> r103 = evc.e.i(r100.headers());
            if (r103.isEmpty() == false) goto L5;
            Headers r104 = new Headers.Builder().build();
        L12:
            this.f523766b = r104;
            this.f523767c = r100.request().method();
            this.f523768d = r100.protocol();
            this.f523769e = r100.code();
            this.f523770f = r100.message();
            this.f523771g = r100.headers();
            this.f523772h = r100.handshake();
            this.f523773i = r100.sentRequestAtMillis();
            this.f523774j = r100.receivedResponseAtMillis();
            return;
        L5:
            Headers.Builder r105 = new Headers.Builder();
            int r106 = r102.size();
            int r107 = 0;
        L6:
            if (r107 >= r106) goto L11;
            String r108 = r102.name(r107);
            if (r103.contains(r108) == false) goto L10;
            r105.add(r108, r102.value(r107));
        L10:
            r107 = r107 + 1;
            goto L6
        L11:
            r104 = r105.build();
            goto L12
        }

        public static void b(BufferedSink r100, List r101) throws IOException {
            r100.writeDecimalLong(r101.size()).writeByte(10);     // Catch: CertificateEncodingException -> L7
            int r102 = r101.size();     // Catch: CertificateEncodingException -> L7
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            r100.writeUtf8(ByteString.of(((Certificate) ListProtector.get(r101, r103)).getEncoded()).base64()).writeByte(10);     // Catch: CertificateEncodingException -> L7
            r103 = r103 + 1;
            goto L3
        L6:
            return;
        L7:
            e = move-exception;
            throw new IOException(e.getMessage());
        }
    }

    public synchronized int hitCount() {
        monitor-enter(this);
        int r100 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int networkCount() {
        monitor-enter(this);
        int r100 = this.networkCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int requestCount() {
        monitor-enter(this);
        int r100 = this.requestCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void trackConditionalCacheHit() {
        monitor-enter(this);
        this.hitCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int writeAbortCount() {
        monitor-enter(this);
        int r100 = this.writeAbortCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int writeSuccessCount() {
        monitor-enter(this);
        int r100 = this.writeSuccessCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.f470242b;
    }

    public void evictAll() throws IOException {
        this.cache.e();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public void initialize() throws IOException {
        this.cache.g();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        dvc.e r100 = this.cache;
        monitor-enter(r100);
        long r101 = r100.f470247g;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public long size() throws IOException {
        dvc.e r100 = this.cache;
        monitor-enter(r100);
        r100.g();     // Catch: Throwable -> L7
        long r101 = r100.f470249i;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public Iterator<String> urls() throws IOException {
        return new b(this);
    }

    private void abortQuietly(@Nullable dvc.e.b r100) {
        if (r100 == null) goto L8;
        r100.a();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String key(HttpUrl r100) {
        return ByteString.encodeUtf8(r100.toString()).md5().hex();
    }

    public static int readInt(BufferedSource r100) throws IOException {
        long r101 = r100.readDecimalLong();     // Catch: NumberFormatException -> L13
        String r102 = r100.readUtf8LineStrict();     // Catch: NumberFormatException -> L13
        if (r101 < 0) goto L12;
        if (r101 > SieveCacheKt.NodeLinkMask) goto L12;
        if (r102.isEmpty() == false) goto L12;
        return (int) r101;
    L12:
        throw new IOException("expected an int but was \"" + r101 + r102 + "\"");     // Catch: NumberFormatException -> L13
    L13:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Nullable
    public Response get(Request r100) {
        String r101 = key(r100.url());
        dvc.e.d r102 = this.cache.f(r101);     // Catch: IOException -> L26
        if (r102 != null) goto L29;
        return null;
    L29:
        boolean r103 = false;
        e r104 = new e(r102.f470277c[0]);     // Catch: IOException -> L24
        String r105 = r104.f523771g.get("Content-Type");
        String r106 = r104.f523771g.get("Content-Length");
        Request r107 = new Request.Builder().url(r104.f523765a).method(r104.f523767c, null).headers(r104.f523766b).build();
        Response r108 = new Response.Builder().request(r107).protocol(r104.f523768d).code(r104.f523769e).message(r104.f523770f).headers(r104.f523771g).body(new d(r102, r105, r106)).handshake(r104.f523772h).sentRequestAtMillis(r104.f523773i).receivedResponseAtMillis(r104.f523774j).build();
        if (r104.f523765a.equals(r100.url().toString()) == true) goto L10;
    L20:
        if (r103 == true) goto L23;
        cvc.c.e(r108.body());
        return null;
    L23:
        return r108;
    L10:
        if (r104.f523767c.equals(r100.method()) == false) goto L20;
        Headers r109 = r104.f523766b;
        ByteString r110 = evc.e.f474509a;
        Iterator<String> r111 = evc.e.i(r108.headers()).iterator();
    L13:
        if (r111.hasNext() == false) goto L17;
        String r112 = r111.next();
        if (cvc.c.k(r109.values(r112), r100.headers(r112)) == true) goto L13;
        boolean r113 = false;
    L18:
        if (r113 == false) goto L20;
        r103 = true;
        goto L20
    L17:
        r113 = true;
    L24:
        cvc.c.e(r102);
    L25:
        return null;
    }

    @Nullable
    public dvc.c put(Response r100) {
        String r101 = r100.request().method();
        if (evc.f.a(r100.request().method()) == false) goto L7;
        remove(r100.request());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if (r101.equals("GET") == true) goto L9;
        return null;
    L9:
        ByteString r102 = evc.e.f474509a;
        if (evc.e.i(r100.headers()).contains("*") == false) goto L12;
        return null;
    L12:
        e r103 = new e(r100);
        dvc.e.b r104 = this.cache.d(key(r100.request().url()), -1);     // Catch: IOException -> L18
        if (r104 != null) goto L23;
        return null;
    L23:
        r103.c(r104);     // Catch: IOException -> L21
        return new c(this, r104);
    L19:
        abortQuietly(r104);
        return null;
    L18:
        r104 = null;
        goto L19
    }

    public void remove(Request r100) throws IOException {
        this.cache.m(key(r100.url()));
    }

    public synchronized void trackResponse(dvc.d r100) {
        monitor-enter(this);
        this.requestCount++;     // Catch: Throwable -> L11
        if (r100.f470238a == null) goto L7;
        this.networkCount++;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r100.f470239b == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public Cache(File r100, long r101) {
        this(r100, r101, FileSystem.SYSTEM);
    }

    public void update(Response r100, Response r101) {
        e r102 = new e(r101);
        dvc.e.d r103 = ((d) r100.body()).f523758a;
        dvc.e.b r104 = r103.f470278d.d(r103.f470275a, r103.f470276b);     // Catch: IOException -> L7
        if (r104 == null) goto L15;
        r102.c(r104);     // Catch: IOException -> L10
        r104.b();     // Catch: IOException -> L10
        return;
    L8:
        abortQuietly(r104);
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public Cache(File r100, long r101, FileSystem r110) {
        this.internalCache = new a(this);
        this.cache = dvc.e.c(r110, r100, VERSION, 2, r101);
    }
}
