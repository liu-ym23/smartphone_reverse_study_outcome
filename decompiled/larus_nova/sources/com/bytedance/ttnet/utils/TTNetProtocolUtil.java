package com.bytedance.ttnet.utils;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTNetProtocolUtil {

    /* JADX INFO: loaded from: classes3.dex */
    public interface Service {
        @GET
        @Priority(3)
        Call<TypedInput> getCall(@Url String r100, @QueryMap(encode = true) Map<String, String> r101, @AddCommonParam boolean r102, @HeaderList List<Header> r103);
    }

    public TTNetProtocolUtil() {
    }

    public static void sendTTNetProtocolRequest(String r100, String r101, Map<String, String> r102, Map<String, String> r103) throws IOException {
        String r104 = "https://" + r100 + r101;
        Pair<String, String> r105 = UrlUtils.parseUrl(r104, r102);
        String r106 = (String) r105.first;
        String r107 = (String) r105.second;
        Retrofit r108 = RetrofitUtils.getSsRetrofit(r106);
        if (r108 == null) goto L24;
        Service r109 = (Service) r108.create(Service.class);
        ArrayList r110 = new ArrayList();
        r110.add(new Header("x-ttnet-protocol-handler", "1"));
        r110.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        if (r103 != null) goto L7;
    L12:
        Call<TypedInput> r111 = r109.getCall(r107, r102, false, r110);
        r111.execute();     // Catch: Throwable -> L16 Exception -> L18
        r111.cancel();
        return;
    L16:
        th = move-exception;
        r111.cancel();
        throw th;
    L18:
        e = move-exception;
        throw new IOException("TTNet-protocol request execution failed for URL: " + r104, e);     // Catch: Throwable -> L16
    L7:
        if (r103.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r112 = r103.entrySet().iterator();
    L10:
        if (r112.hasNext() == false) goto L12;
        Map.Entry<String, String> r113 = r112.next();
        r110.add(new Header(r113.getKey(), r113.getValue()));
        goto L10
    L24:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r106);
    }

    public static void sendTTNetProtocolRequestAsync(String r100, String r101, Map<String, String> r102, Map<String, String> r103, Callback<TypedInput> r104) throws IOException {
        Pair<String, String> r105 = UrlUtils.parseUrl("https://" + r100 + r101, r102);
        String r106 = (String) r105.first;
        String r107 = (String) r105.second;
        Retrofit r108 = RetrofitUtils.getSsRetrofit(r106);
        if (r108 == null) goto L15;
        Service r109 = (Service) r108.create(Service.class);
        ArrayList r110 = new ArrayList();
        r110.add(new Header("x-ttnet-protocol-handler", "1"));
        r110.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        if (r103 != null) goto L7;
    L12:
        r109.getCall(r107, r102, false, r110).enqueue(r104);
        return;
    L7:
        if (r103.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r111 = r103.entrySet().iterator();
    L10:
        if (r111.hasNext() == false) goto L12;
        Map.Entry<String, String> r112 = r111.next();
        r110.add(new Header(r112.getKey(), r112.getValue()));
        goto L10
    L15:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r106);
    }
}
