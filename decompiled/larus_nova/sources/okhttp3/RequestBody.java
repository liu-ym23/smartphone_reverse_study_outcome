package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RequestBody {

    /* JADX INFO: loaded from: classes42.dex */
    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f523785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ByteString f523786b;

        @Override // okhttp3.RequestBody
        public final long contentLength() throws IOException {
            return this.f523786b.size();
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public final MediaType contentType() {
            return this.f523785a;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink r100) throws IOException {
            r100.write(this.f523786b);
        }

        public a(MediaType r100, ByteString r101) {
            this.f523785a = r100;
            this.f523786b = r101;
        }
    }

    public static class b extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f523787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f523788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f523789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f523790d;

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            return this.f523788b;
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public final MediaType contentType() {
            return this.f523787a;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink r100) throws IOException {
            r100.write(this.f523789c, this.f523790d, this.f523788b);
        }

        public b(MediaType r100, int r101, byte[] r102, int r103) {
            this.f523787a = r100;
            this.f523788b = r101;
            this.f523789c = r102;
            this.f523790d = r103;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class c extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f523791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f523792b;

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            return this.f523792b.length();
        }

        @Override // okhttp3.RequestBody
        @Nullable
        public final MediaType contentType() {
            return this.f523791a;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink r100) throws IOException {
            Source r101 = null;
            r101 = Okio.source(this.f523792b);     // Catch: Throwable -> L6
            r100.writeAll(r101);     // Catch: Throwable -> L6
            cvc.c.e(r101);
            return;
        L6:
            th = move-exception;
            cvc.c.e(r101);
            throw th;
        }

        public c(MediaType r100, File r101) {
            this.f523791a = r100;
            this.f523792b = r101;
        }
    }

    public RequestBody() {
    }

    public long contentLength() throws IOException {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink r100) throws IOException;

    public static RequestBody create(@Nullable MediaType r100, String r101) {
        Charset r102 = cvc.c.f465522j;
        if (r100 == null) goto L9;
        Charset r103 = r100.charset();
        if (r103 != null) goto L7;
        r100 = MediaType.parse(r100 + "; charset=utf-8");
        goto L9
    L7:
        r102 = r103;
    L9:
        return create(r100, r101.getBytes(r102));
    }

    public static RequestBody create(@Nullable MediaType r100, File r101) {
        if (r101 == null) goto L6;
        return new c(r100, r101);
    L6:
        throw new NullPointerException("file == null");
    }

    public static RequestBody create(@Nullable MediaType r100, byte[] r101) {
        return create(r100, r101, 0, r101.length);
    }

    public static RequestBody create(@Nullable MediaType r100, ByteString r101) {
        return new a(r100, r101);
    }

    public static RequestBody create(@Nullable MediaType r110, byte[] r111, int r112, int r113) {
        if (r111 == null) goto L14;
        long r100 = r111.length;
        long r101 = r112;
        long r102 = r113;
        byte[] r103 = cvc.c.f465513a;
        if ((r101 | r102) < 0) goto L12;
        if (r101 > r100) goto L12;
        if ((r100 - r101) < r102) goto L12;
        return new b(r110, r113, r111, r112);
    L12:
        throw new ArrayIndexOutOfBoundsException();
    L14:
        throw new NullPointerException("content == null");
    }
}
