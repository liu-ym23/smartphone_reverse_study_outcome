package com.ss.android.bytedcert.adapter.network;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.cert.manager.ablity.INetWork;
import com.ss.android.cert.manager.constants.UrlConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import zra.a;

/* JADX INFO: loaded from: classes5.dex */
public class NetWorkAdapter implements INetWork {
    public NetWorkAdapter() {
    }

    public static RequestContext a(Map r100) {
        RequestContext r101 = new RequestContext();
        if (r100 != null) goto L5;
    L13:
        return r101;
    L5:
        if (r100.containsKey("timeout_connect") == false) goto L8;
        r101.timeout_connect = ((Long) r100.get("timeout_connect")).longValue();
    L8:
        if (r100.containsKey("timeout_read") == false) goto L11;
        r101.timeout_read = ((Long) r100.get("timeout_read")).longValue();
    L11:
        if (r100.containsKey("timeout_write") == false) goto L13;
        r101.timeout_write = ((Long) r100.get("timeout_write")).longValue();
        goto L13
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public int checkResponseException(Throwable r100) {
        if ((r100 instanceof HttpResponseException) == false) goto L6;
        return 105;
    L6:
        if ((r100 instanceof NetworkNotAvailabeException) == false) goto L8;
        return -106;
    L8:
        return 0;
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public int getExceptionStatusCode(Throwable r100) {
        if ((r100 instanceof HttpResponseException) == false) goto L6;
        return ((HttpResponseException) r100).getStatusCode();
    L6:
        if ((r100 instanceof CronetIOException) == true) goto L11;
        return 0;
    L11:
        return ((CronetIOException) r100).getStatusCode();
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executeGet(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, Object> r110) throws Exception {
        RequestContext r103 = a(r110);
        Call<String> r104 = a.b(r100).doGet(true, r100, r102, a.a(r101), r103);
        if (r104 == null) goto L5;
        SsResponse<String> r105 = r104.execute();
    L6:
        if (r105 != null) goto L9;
        return "request error";
    L9:
        return r105.body();
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executePost(String r100, Map<String, String> r101, String r102, Map<String, Object> r110) throws Exception {
        RequestContext r103 = a(r110);
        Call<String> r104 = a.b(r100).postBody(true, r100, a.a(r101), new TypedString(r102), r103);
        if (r104 == null) goto L5;
        SsResponse<String> r105 = r104.execute();
    L6:
        if (r105 != null) goto L9;
        return "request error";
    L9:
        return r105.body();
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executePostFile(String r100, Map<String, String> r101, Map<String, String> r110, Map<String, Pair<String, byte[]>> r111) throws Exception {
        HashMap r102 = new HashMap();
        Iterator<Map.Entry<String, String>> r112 = r110.entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r112.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (TextUtils.isEmpty(r104) == true) goto L4;
        if (TextUtils.isEmpty(r105) == true) goto L4;
        r102.put(r104, new TypedString(r105));
        goto L4
    L10:
        if (r111 != null) goto L12;
    L23:
        Call<String> r106 = ((NetService) RetrofitUtils.createSsService(UrlConstant.getBaseUrl(), NetService.class)).postMultiPart(true, -1, r100, null, r102, a.a(r101));
        if (r106 == null) goto L26;
        SsResponse<String> r107 = r106.execute();
    L27:
        if (r107 != null) goto L30;
        return "request error";
    L30:
        return r107.body();
    L26:
        r107 = null;
        goto L27
    L12:
        if (r111.size() == 0) goto L23;
        Iterator<Map.Entry<String, Pair<String, byte[]>>> r113 = r111.entrySet().iterator();
    L15:
        if (r113.hasNext() == false) goto L23;
        Map.Entry<String, Pair<String, byte[]>> r114 = r113.next();
        String r108 = r114.getKey();
        Pair<String, byte[]> r115 = r114.getValue();
        if (TextUtils.isEmpty(r108) == true) goto L15;
        if (r115 == null) goto L15;
        String r109 = (String) r115.first;
        byte[] r116 = (byte[]) r115.second;
        if (TextUtils.isEmpty(r109) == true) goto L15;
        if (r116 == null) goto L15;
        r102.put(r108, new TypedByteArray("application/octet-stream", r116, new String[]{r109}));
        goto L15
    }

    @Override // com.ss.android.cert.manager.ablity.INetWork
    public String executePost(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, Object> r110) throws Exception {
        RequestContext r103 = a(r110);
        Call<String> r104 = a.b(r100).doPost(true, r100, a.a(r101), r102, r103);
        if (r104 == null) goto L5;
        SsResponse<String> r105 = r104.execute();
    L6:
        if (r105 != null) goto L9;
        return "request error";
    L9:
        return r105.body();
    L5:
        r105 = null;
        goto L6
    }
}
