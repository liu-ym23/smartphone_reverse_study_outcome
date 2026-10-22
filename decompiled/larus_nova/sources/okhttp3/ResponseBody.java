package okhttp3;

import androidx.collection.SieveCacheKt;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ResponseBody implements Closeable {

    @Nullable
    private Reader reader;

    public static class a extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f523793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f523794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BufferedSource f523795c;

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f523794b;
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public final MediaType contentType() {
            return this.f523793a;
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.f523795c;
        }

        public a(MediaType r100, long r101, BufferedSource r102) {
            this.f523793a = r100;
            this.f523794b = r101;
            this.f523795c = r102;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static final class b extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedSource f523796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Charset f523797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f523798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Reader f523799d;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.f523798c = true;
            Reader r100 = this.f523799d;
            if (r100 == null) goto L5;
            r100.close();
            return;
        L5:
            this.f523796a.close();
        }

        public b(BufferedSource r100, Charset r101) {
            this.f523796a = r100;
            this.f523797b = r101;
        }

        @Override // java.io.Reader
        public final int read(char[] r100, int r101, int r102) throws IOException {
            if (this.f523798c == true) goto L10;
            Reader r103 = this.f523799d;
            if (r103 != null) goto L8;
            Charset r104 = cvc.c.b(this.f523796a, this.f523797b);
            InputStreamReader r105 = new InputStreamReader(this.f523796a.inputStream(), r104);
            this.f523799d = r105;
            r103 = r105;
        L8:
            return r103.read(r100, r101, r102);
        L10:
            throw new IOException("Stream closed");
        }
    }

    public ResponseBody() {
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final Reader charStream() {
        Reader r100 = this.reader;
        if (r100 != null) goto L7;
        b r101 = new b(source(), charset());
        this.reader = r101;
        return r101;
    L7:
        return r100;
    }

    private Charset charset() {
        MediaType r100 = contentType();
        if (r100 == null) goto L6;
        return r100.charset(cvc.c.f465522j);
    L6:
        return cvc.c.f465522j;
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws IOException {
        long r100 = contentLength();
        if (r100 > SieveCacheKt.NodeLinkMask) goto L18;
        BufferedSource r101 = source();
        byte[] r102 = r101.readByteArray();     // Catch: Throwable -> L14
        cvc.c.e(r101);
        if (r100 != (-1)) goto L9;
    L13:
        return r102;
    L9:
        if (r100 == r102.length) goto L13;
        throw new IOException("Content-Length (" + r100 + ") and stream length (" + r102.length + ") disagree");
    L14:
        th = move-exception;
        cvc.c.e(r101);
        throw th;
    L18:
        throw new IOException("Cannot buffer entire body for content length: " + r100);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        cvc.c.e(source());
    }

    public final String string() throws IOException {
        BufferedSource r100 = source();
        String r101 = r100.readString(cvc.c.b(r100, charset()));     // Catch: Throwable -> L6
        cvc.c.e(r100);
        return r101;
    L6:
        th = move-exception;
        cvc.c.e(r100);
        throw th;
    }

    public static ResponseBody create(@Nullable MediaType r100, String r101) {
        Charset r102 = cvc.c.f465522j;
        if (r100 == null) goto L8;
        Charset r103 = r100.charset();
        if (r103 != null) goto L7;
        r100 = MediaType.parse(r100 + "; charset=utf-8");
        goto L8
    L7:
        r102 = r103;
    L8:
        Buffer r104 = new Buffer().writeString(r101, r102);
        return create(r100, r104.size(), r104);
    }

    public static ResponseBody create(@Nullable MediaType r100, ByteString r101) {
        return create(r100, r101.size(), new Buffer().write(r101));
    }

    public static ResponseBody create(@Nullable MediaType r100, byte[] r101) {
        return create(r100, r101.length, new Buffer().write(r101));
    }

    public static ResponseBody create(@Nullable MediaType r100, long r101, BufferedSource r102) {
        if (r102 == null) goto L6;
        return new a(r100, r101, r102);
    L6:
        throw new NullPointerException("source == null");
    }
}
