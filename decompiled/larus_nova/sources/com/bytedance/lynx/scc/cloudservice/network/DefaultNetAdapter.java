package com.bytedance.lynx.scc.cloudservice.network;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Method;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import o07.a;
import o07.b;
import o07.c;
import o07.d;

/* JADX INFO: loaded from: classes21.dex */
public final class DefaultNetAdapter implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f264866a;

    public interface TTNetAdapterApi {
        @GET
        Call<TypedInput> doGet(@Url String r100, @AddCommonParam boolean r101, @QueryMap(encode = true) Map<String, String> r102, @ExtraInfo Object r103, @HeaderList List<Header> r104);

        @HTTP(method = "{CUSTOM}")
        Call<TypedInput> send(@Method("CUSTOM") String r100, @Url String r101, @AddCommonParam boolean r102, @QueryMap(encode = true) Map<String, String> r103, @ExtraInfo Object r104, @Body TypedOutput r105, @HeaderList List<Header> r106);
    }

    public DefaultNetAdapter(SccDelegate.a r100) {
        this.f264866a = r100;
    }

    public static Map b(List r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        Header r103 = (Header) r102.next();
        String r104 = r103.getName();
        String r105 = r103.getValue();
        if (r101.containsKey(r104) == true) goto L10;
        ArrayList r106 = new ArrayList();
        r106.add(r105);
        r101.put(r104, r106);
        goto L7
    L10:
        Object r107 = r101.get(r104);
        Objects.requireNonNull(r107);
        ((List) r107).add(r105);
        goto L7
    L12:
        return r101;
    }

    @Override // o07.a
    public final d a(c r110, boolean r111) {
        LinkedHashMap r100 = new LinkedHashMap();
        Map<String, String> r101 = r110.f521634a;
        SsResponse<TypedInput> r102 = null;
        if (r101 != null) goto L5;
        ArrayList r103 = null;
    L10:
        d r104 = new d();
        Pair<String, String> r105 = UrlUtils.parseUrl(r110.f521635b, r100);     // Catch: Exception -> L40
        String r106 = (String) r105.first;     // Catch: Exception -> L40
        String r107 = (String) r105.second;     // Catch: Exception -> L40
        b r108 = this.f264866a;     // Catch: Exception -> L40
        if (r108 == null) goto L14;
        TTNetAdapterApi r109 = (TTNetAdapterApi) r108.create(r106, TTNetAdapterApi.class);     // Catch: Exception -> L40
    L15:
        RequestContext r112 = new RequestContext();     // Catch: Exception -> L40
        r112.protect_timeout = r110.f521638e;     // Catch: Exception -> L40
        if (TextUtils.isEmpty(r110.f521636c) == false) goto L18;
        Call<TypedInput> r113 = r109.doGet(r107, true, r100, r112, r103);     // Catch: Exception -> L40
    L23:
        if (r113 == null) goto L25;
        r102 = r113.execute();     // Catch: Exception -> L40
    L25:
        if (r102 == null) goto L38;
        r104.f521642d = b(r102.headers());     // Catch: Exception -> L40
        r104.f521639a = r102.code();     // Catch: Exception -> L40
        if (r102.isSuccessful() == false) goto L33;
        InputStream r114 = r102.body().in();     // Catch: Exception -> L40
        ByteArrayOutputStream r115 = new ByteArrayOutputStream();     // Catch: Exception -> L40
        byte[] r116 = new byte[4096];     // Catch: Exception -> L40
    L29:
        int r117 = r114.read(r116);     // Catch: Exception -> L40
        if (r117 == (-1)) goto L32;
        r115.write(r116, 0, r117);     // Catch: Exception -> L40
        goto L29
    L32:
        r104.f521640b = r115.toByteArray();     // Catch: Exception -> L40
    L42:
        return r104;
    L33:
        InputStream r118 = r102.body().in();     // Catch: Exception -> L40
        ByteArrayOutputStream r119 = new ByteArrayOutputStream();     // Catch: Exception -> L40
        byte[] r120 = new byte[4096];     // Catch: Exception -> L40
    L34:
        int r121 = r118.read(r120);     // Catch: Exception -> L40
        if (r121 == (-1)) goto L37;
        r119.write(r120, 0, r121);     // Catch: Exception -> L40
        goto L34
    L37:
        r104.f521641c = new String(r119.toByteArray());     // Catch: Exception -> L40
        goto L42
    L38:
        r104.f521641c = "Empty response body!";     // Catch: Exception -> L40
        goto L42
    L18:
        String r122 = r110.f521637d;     // Catch: Exception -> L40
        if (r122 == null) goto L21;
        TypedByteArray r123 = new TypedByteArray("application/x-www-form-urlencoded; charset=UTF-8", r122.getBytes(), new String[0]);     // Catch: Exception -> L40
    L22:
        r113 = r109.send(r110.f521636c, r107, r111, r100, r112, r123, r103);     // Catch: Exception -> L40
        goto L23
    L21:
        r123 = null;
        goto L22
    L14:
        r109 = (TTNetAdapterApi) RetrofitUtils.createSsService(r106, TTNetAdapterApi.class);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        Log.getStackTraceString(e);
        r104.f521639a = -1;
        r104.f521641c = e.getMessage();
        goto L42
    L5:
        ArrayList r124 = new ArrayList();
        Iterator<Map.Entry<String, String>> r125 = r101.entrySet().iterator();
    L7:
        if (r125.hasNext() == false) goto L9;
        Map.Entry<String, String> r126 = r125.next();
        r124.add(new Header(r126.getKey(), r126.getValue()));
        goto L7
    L9:
        r103 = r124;
        goto L10
    }
}
