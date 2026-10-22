package com.larksuite.framework.http.call;

import android.text.TextUtils;
import com.larksuite.framework.http.request.FormBody;
import com.larksuite.framework.http.request.HttpHeaders;
import com.larksuite.framework.http.request.HttpMethod;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import x18.d;

/* JADX INFO: loaded from: classes24.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z18.a<T> f285569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f285570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b28.b f285571c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285572a = null;

        static {
            int[] r100 = new int[HttpMethod.values().length];
            f285572a = r100;
            r100[HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f285572a[HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public b(d r100, z18.a<T> r101) {
        this.f285569a = r101;
        this.f285570b = r100;
        String r102 = r101.b();
        Request r103 = null;
        RequestBody r104 = null;
        r104 = null;
        if (TextUtils.isEmpty(r102) == true) goto L39;
        Request.Builder r105 = new Request.Builder().url(r102);
        HttpHeaders r106 = r101.a();
        if (r106.isEmpty() == true) goto L11;
        Iterator<String> r107 = r106.getNames().iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        String r108 = r107.next();
        r105.addHeader(r108, r106.get(r108));
    L11:
        int r109 = a.f285572a[r101.f569681d.ordinal()];
        if (r109 != 1) goto L14;
        r105.get();
    L38:
        r103 = r105.build();
        goto L39
    L14:
        if (r109 != 2) goto L38;
        com.larksuite.framework.http.request.RequestBody r110 = r101.f569682e;
        if (r110 != null) goto L20;
    L36:
        r105.post(r104);
        goto L38
    L20:
        if ((r110 instanceof FormBody) == false) goto L42;
        FormBody r111 = (FormBody) r110;
        Charset r112 = r111.getCharset();
        okhttp3.FormBody.Builder r113 = new okhttp3.FormBody.Builder();
        Map<String, String> r114 = r111.getName2Value();
        Iterator<String> r115 = r114.keySet().iterator();
    L23:
        if (r115.hasNext() == false) goto L28;
        String r116 = r115.next();
        String r117 = r114.get(r116);
        if (r112 == null) goto L26;
        r113.addEncoded(r116, r117);
        goto L23
    L26:
        r113.add(r116, r117);
        goto L23
    L28:
        r104 = r113.build();
        goto L36
    L42:
        MediaType r118 = MediaType.parse(r110.getMediaType());     // Catch: Exception -> L34
        if (r110.getContent() == null) goto L32;
        r104 = RequestBody.create(r118, r110.getContent());     // Catch: Exception -> L34
    L41:
        goto L36
    L32:
        r104 = RequestBody.create(r118, r110.getBytesContent());     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L39:
        this.f285571c = b28.b.c(this.f285570b, r103, false);
    }
}
