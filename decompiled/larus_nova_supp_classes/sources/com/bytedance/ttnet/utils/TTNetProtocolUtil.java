package com.bytedance.ttnet.utils;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TTNetProtocolUtil {
    public TTNetProtocolUtil() {
    }

    public static void sendTTNetProtocolRequest(String r5, String r6, Map<String, String> r7, Map<String, String> r8) throws IOException {
        String r9 = "https://" + r5 + r6;
        Pair r10 = UrlUtils.parseUrl(r9, r7);
        String r0 = (String) r10.first;
        String r11 = (String) r10.second;
        Retrofit r1 = RetrofitUtils.getSsRetrofit(r0);
        if (r1 == null) goto L24;
        Service r2 = (Service) r1.create(Service.class);
        ArrayList r3 = new ArrayList();
        r3.add(new Header("x-ttnet-protocol-handler", "1"));
        r3.add(new Header("x-metasec-bypass-ttnet-features", "1"));
        if (r8 != null) goto L7;
    L12:
        Call r12 = r2.getCall(r11, r7, false, r3);
        r12.execute();     // Catch: Throwable -> L16 Exception -> L18
        r12.cancel();
        return;
    L16:
        th = move-exception;
        r12.cancel();
        throw th;
    L18:
        e = move-exception;
        throw new IOException("TTNet-protocol request execution failed for URL: " + r9, e);     // Catch: Throwable -> L16
    L7:
        if (r8.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r13 = r8.entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        Map.Entry<String, String> r4 = r13.next();
        r3.add(new Header(r4.getKey(), r4.getValue()));
        goto L10
    L24:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r0);
    }

    public static void sendTTNetProtocolRequestAsync(String r4, String r5, Map<String, String> r6, Map<String, String> r7, Callback<TypedInput> r8) throws IOException {
        Pair r9 = UrlUtils.parseUrl("https://" + r4 + r5, r6);
        String r10 = (String) r9.first;
        String r11 = (String) r9.second;
        Retrofit r0 = RetrofitUtils.getSsRetrofit(r10);
        if (r0 == null) goto L15;
        Service r12 = (Service) r0.create(Service.class);
        ArrayList r1 = new ArrayList();
        r1.add(new Header("x-ttnet-protocol-handler", "1"));
        r1.add(new Header("x-metasec-bypass-ttnet-features", "1"));
        if (r7 != null) goto L7;
    L12:
        r12.getCall(r11, r6, false, r1).enqueue(r8);
        return;
    L7:
        if (r7.isEmpty() == true) goto L12;
        Iterator<Map.Entry<String, String>> r13 = r7.entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        Map.Entry<String, String> r2 = r13.next();
        r1.add(new Header(r2.getKey(), r2.getValue()));
        goto L10
    L15:
        throw new IOException("Failed to get Retrofit instance for base URL: " + r10);
    }
}
