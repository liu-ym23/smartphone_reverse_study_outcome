package okhttp3;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ttnetuploader.uploader.api.Parameters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class k extends RequestBody {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MediaType f523923e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MediaType f523924f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f523925g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f523926h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f523927i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f523928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaType f523929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f523930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f523931d;

    /* JADX INFO: loaded from: classes5.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteString f523932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaType f523933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<b> f523934c;

        public final k d() {
            if (((ArrayList) this.f523934c).isEmpty() == true) goto L7;
            return new k(this.f523932a, this.f523933b, this.f523934c);
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public a() {
            String r100 = UUID.randomUUID().toString();
            this.f523933b = k.f523923e;
            this.f523934c = new ArrayList();
            this.f523932a = ByteString.encodeUtf8(r100);
        }

        public final void c(b r100) {
            if (r100 == null) goto L6;
            ((ArrayList) this.f523934c).add(r100);
            return;
        L6:
            throw new NullPointerException("part == null");
        }

        public final void e(MediaType r100) {
            if (r100 == null) goto L10;
            if (r100.type().equals("multipart") == false) goto L8;
            this.f523933b = r100;
            return;
        L8:
            throw new IllegalArgumentException("multipart != " + r100);
        L10:
            throw new NullPointerException("type == null");
        }

        public final void a(String r100, String r101) {
            c(b.b(r100, null, RequestBody.create(null, r101)));
        }

        public final void b(String r100, @Nullable String r101, RequestBody r102) {
            c(b.b(r100, r101, r102));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Headers f523935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RequestBody f523936b;

        public b(@Nullable Headers r100, RequestBody r101) {
            this.f523935a = r100;
            this.f523936b = r101;
        }

        public static b a(@Nullable Headers r100, RequestBody r101) {
            if (r101 == null) goto L18;
            if (r100 != null) goto L5;
        L9:
            if (r100 == null) goto L16;
            if (r100.get("Content-Length") == null) goto L16;
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        L16:
            return new b(r100, r101);
        L5:
            if (r100.get("Content-Type") == null) goto L9;
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        L18:
            throw new NullPointerException("body == null");
        }

        public static b b(String r100, @Nullable String r101, RequestBody r102) {
            if (r100 == null) goto L9;
            StringBuilder r103 = new StringBuilder("form-data; name=");
            k.a(r103, r100);
            if (r101 == null) goto L7;
            r103.append("; filename=");
            k.a(r103, r101);
        L7:
            return a(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", r103.toString()).build(), r102);
        L9:
            throw new NullPointerException("name == null");
        }
    }

    static {
        f523923e = MediaType.get("multipart/mixed");
        MediaType.get("multipart/alternative");
        MediaType.get("multipart/digest");
        MediaType.get("multipart/parallel");
        f523924f = MediaType.get(Parameters.CONTENT_TYPE_MULTIPART_FORM);
        f523925g = new byte[]{58, 32};
        f523926h = new byte[]{HTTP.CR, 10};
        f523927i = new byte[]{45, 45};
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() throws IOException {
        long r100 = this.f523931d;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        long r101 = writeOrCountBytes(null, true);
        this.f523931d = r101;
        return r101;
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f523929b;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink r100) throws IOException {
        writeOrCountBytes(r100, false);
    }

    public static void a(StringBuilder r100, String r101) {
        r100.append(Typography.quote);
        int r102 = r101.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        char r104 = r101.charAt(r103);
        if (r104 != '\n') goto L7;
        r100.append("%0A");
    L13:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 == '\r') goto L11;
        if (r104 == '\"') goto L10;
        r100.append(r104);
        goto L13
    L10:
        r100.append("%22");
        goto L13
    L11:
        r100.append("%0D");
        goto L13
    L14:
        r100.append(Typography.quote);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long writeOrCountBytes(@Nullable BufferedSink r110, boolean r111) throws IOException {
        if (r111 == false) goto L4;
        r110 = new Buffer();
        Buffer r100 = r110;
    L5:
        int r101 = this.f523930c.size();
        long r102 = 0;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L26;
        b r104 = (b) ListProtector.get(this.f523930c, r103);
        Headers r105 = r104.f523935a;
        RequestBody r106 = r104.f523936b;
        r110.write(f523927i);
        r110.write(this.f523928a);
        r110.write(f523926h);
        if (r105 == null) goto L12;
        int r107 = r105.size();
        int r108 = 0;
    L10:
        if (r108 >= r107) goto L12;
        r110.writeUtf8(r105.name(r108)).write(f523925g).writeUtf8(r105.value(r108)).write(f523926h);
        r108 = r108 + 1;
    L12:
        MediaType r109 = r106.contentType();
        if (r109 == null) goto L15;
        r110.writeUtf8("Content-Type: ").writeUtf8(r109.toString()).write(f523926h);
    L15:
        long r112 = r106.contentLength();
        if (r112 == (-1)) goto L18;
        r110.writeUtf8("Content-Length: ").writeDecimalLong(r112).write(f523926h);
    L21:
        byte[] r113 = f523926h;
        r110.write(r113);
        if (r111 == false) goto L24;
        r102 = r102 + r112;
    L25:
        r110.write(r113);
        r103 = r103 + 1;
        goto L6
    L24:
        r106.writeTo(r110);
        goto L25
    L18:
        if (r111 == false) goto L21;
        r100.clear();
        return -1;
    L26:
        byte[] r114 = f523927i;
        r110.write(r114);
        r110.write(this.f523928a);
        r110.write(r114);
        r110.write(f523926h);
        if (r111 == false) goto L35;
        long r115 = r102 + r100.size();
        r100.clear();
        return r115;
    L35:
        return r102;
    L4:
        r100 = 0;
        goto L5
    }

    public k(ByteString r100, MediaType r101, List<b> r102) {
        this.f523931d = -1;
        this.f523928a = r100;
        this.f523929b = MediaType.get(r101 + "; boundary=" + r100.utf8());
        this.f523930c = cvc.c.n(r102);
    }
}
