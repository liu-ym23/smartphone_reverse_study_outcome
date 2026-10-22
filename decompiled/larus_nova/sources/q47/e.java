package q47;

import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements i47.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f531657h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f531661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f531662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LoadFrom f531663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InputStream f531664g;

    static {
        f531657h = Charset.defaultCharset().name();
    }

    @Override // i47.e
    public final LoadFrom a() {
        return this.f531663f;
    }

    @Override // i47.e
    public final InputStream getData() {
        return this.f531664g;
    }

    @Override // i47.e
    public final String getEncoding() {
        return this.f531659b;
    }

    @Override // i47.e
    public final Map<String, String> getHeaders() {
        return this.f531662e;
    }

    @Override // i47.e
    public final String getMimeType() {
        return this.f531658a;
    }

    @Override // i47.e
    public final String getReasonPhrase() {
        return this.f531661d;
    }

    @Override // i47.e
    public final int getStatusCode() {
        return this.f531660c;
    }

    public e(String r100, String r101, int r102, String r103, Map<String, String> r104, LoadFrom r105, InputStream r106) {
        if (r100 != null) goto L5;
    L6:
        r100 = "text/html";
    L7:
        this.f531658a = r100;
        String r107 = f531657h;
        if (r101 != null) goto L10;
    L11:
        r101 = r107;
    L12:
        this.f531659b = r101;
        this.f531660c = r102;
        if (r103 != null) goto L15;
    L16:
        r103 = "";
    L17:
        this.f531661d = r103;
        if (r104 != null) goto L20;
        this.f531662e = new HashMap();
    L21:
        this.f531663f = r105;
        this.f531664g = r106;
        return;
    L20:
        this.f531662e = r104;
        goto L21
    L15:
        if (r103.isEmpty() == false) goto L17;
    L10:
        if (r101.isEmpty() == false) goto L12;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L6
    }
}
