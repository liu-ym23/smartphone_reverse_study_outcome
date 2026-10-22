package retrofit2;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes41.dex */
public final class r {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f537550k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f537551l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f537552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUrl f537553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public String f537554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public HttpUrl.a f537555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Request.Builder f537556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public MediaType f537557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f537558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final okhttp3.k.a f537559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public final FormBody.Builder f537560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public RequestBody f537561j;

    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestBody f537562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaType f537563b;

        @Override // okhttp3.RequestBody
        public final long contentLength() throws IOException {
            return this.f537562a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public final MediaType contentType() {
            return this.f537563b;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink r100) throws IOException {
            this.f537562a.writeTo(r100);
        }

        public a(RequestBody r100, MediaType r101) {
            this.f537562a = r100;
            this.f537563b = r101;
        }
    }

    static {
        f537550k = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        f537551l = PatternProtector.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    }

    public final void a(String r100, String r101) {
        if ("Content-Type".equalsIgnoreCase(r100) == true) goto L11;
        this.f537556e.addHeader(r100, r101);
        return;
    L11:
        this.f537557f = MediaType.get(r101);     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        throw new IllegalArgumentException("Malformed content type: " + r101, e);
    }

    public final void b(String r100, @Nullable String r110, boolean r111) {
        String r101 = this.f537554c;
        String r102 = null;
        if (r101 == null) goto L9;
        HttpUrl.a r103 = this.f537553b.newBuilder(r101);
        this.f537555d = r103;
        if (r103 == null) goto L8;
        this.f537554c = null;
        goto L9
    L8:
        throw new IllegalArgumentException("Malformed URL. Base: " + this.f537553b + ", Relative: " + this.f537554c);
    L9:
        if (r111 == false) goto L21;
        HttpUrl.a r112 = this.f537555d;
        if (r100 != null) goto L13;
        r112.getClass();
        throw new NullPointerException("encodedName == null");
    L13:
        if (r112.f523782g != null) goto L15;
        r112.f523782g = new ArrayList();
    L15:
        r112.f523782g.add(HttpUrl.canonicalize(r100, " \"'<>#&=", true, false, true, true));
        List<String> r104 = r112.f523782g;
        if (r110 == null) goto L18;
        r102 = HttpUrl.canonicalize(r110, " \"'<>#&=", true, false, true, true);
    L18:
        r104.add(r102);
        return;
    L21:
        this.f537555d.a(r100, r110);
    }

    public r(String r100, HttpUrl r101, @Nullable String r102, @Nullable Headers r103, @Nullable MediaType r104, boolean r105, boolean r106, boolean r107) {
        this.f537552a = r100;
        this.f537553b = r101;
        this.f537554c = r102;
        Request.Builder r108 = new Request.Builder();
        this.f537556e = r108;
        this.f537557f = r104;
        this.f537558g = r105;
        if (r103 == null) goto L5;
        r108.headers(r103);
    L5:
        if (r106 == false) goto L7;
        this.f537560i = new FormBody.Builder();
        return;
    L7:
        if (r107 == false) goto L11;
        okhttp3.k.a r109 = new okhttp3.k.a();
        this.f537559h = r109;
        r109.e(okhttp3.k.f523924f);
        return;
    }
}
