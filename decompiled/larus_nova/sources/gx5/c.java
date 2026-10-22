package gx5;

import com.bytedance.forest.pollyfill.ttnet.ForestNetAPI;
import com.bytedance.forest.utils.e;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends ForestNetAPI.HttpResponse {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Response f483119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f483120g;

    @Override // com.bytedance.forest.pollyfill.ttnet.ForestNetAPI.HttpResponse
    public final InputStream b() {
        String r100 = this.f244422c.get("content-length");
        if (r100 == null) goto L5;
        Integer r101 = StringsKt.toIntOrNull(r100);
    L6:
        if (r101 != null) goto L9;
    L24:
        Response r102 = this.f483119f;     // Catch: Exception -> L21
        if (r102 == null) goto L17;
        TypedInput r103 = r102.getBody();     // Catch: Exception -> L21
        if (r103 == null) goto L17;
        InputStream r104 = r103.in();     // Catch: Exception -> L21
    L18:
        if (r104 != null) goto L26;
        com.bytedance.forest.utils.c.a(this.f483120g.f244543g, 6, "TTNetDepender", "response in empty when providing input stream", true, null, null, 48);     // Catch: Exception -> L21
    L26:
        return r104;
    L17:
        r104 = null;
    L21:
        e = move-exception;
        com.bytedance.forest.utils.c.a(this.f483120g.f244543g, 6, "TTNetDepender", "error occurs when getting input stream from response", true, e, null, 32);
        return null;
    L9:
        if (r101.intValue() != 0) goto L24;
        return new ByteArrayInputStream(new byte[0]);
    L5:
        r101 = null;
        goto L6
    }

    public c(Response r100, e r101) {
        int r102 = r100.getStatus();
        List<Header> r103 = r100.getHeaders();
        HashMap r104 = new HashMap();
        Iterator<Header> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        Header r106 = r105.next();
        String r107 = r106.getName();
        Locale r108 = Locale.ENGLISH;
        if (r107 == null) goto L9;
        r104.put(r107.toLowerCase(r108), r106.getValue());
        goto L4
    L9:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L10:
        this(r102, "", r104, r101);
        this.f483119f = r100;
    }

    public c(HttpResponseException r100, e r101) {
        int r102 = r100.getStatusCode();
        String r103 = r100.getMessage();
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        this(r102, r103, new HashMap(), r101);
    }

    public c(int r100, String r101, Map<String, String> r102, e r103) {
        Integer r104 = Integer.valueOf(r100);
        if (r104.intValue() == 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L9;
        r104 = null;
    L9:
        if (r104 == null) goto L11;
        int r106 = r104.intValue();
    L12:
        super(r106, r101, r102, 8);
        this.f483120g = r103;
        return;
    L11:
        r106 = -1;
        goto L12
    L5:
        r105 = false;
        goto L6
    }
}
