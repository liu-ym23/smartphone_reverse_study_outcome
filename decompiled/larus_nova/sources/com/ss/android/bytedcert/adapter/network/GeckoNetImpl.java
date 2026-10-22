package com.ss.android.bytedcert.adapter.network;

import android.util.Pair;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.geckox.net.INetWork;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.cert.manager.constants.UrlConstant;
import com.ss.android.cert.manager.utils.CertLog;
import java.io.BufferedInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import py5.b;
import wy5.e;

/* JADX INFO: loaded from: classes34.dex */
public class GeckoNetImpl implements INetWork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GeckoNetApi f407258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f407259b;

    public interface GeckoNetApi {
        @GET
        Call<String> doGet(@Url String r100);

        @FormUrlEncoded
        @POST
        Call<String> doPost(@Url String r100, @FieldMap Map<String, String> r101);

        @GET
        @Streaming
        Call<TypedInput> downloadFile(@Url String r100, @HeaderList List<Header> r101);

        @POST
        Call<String> postBody(@Url String r100, @Body TypedOutput r101);
    }

    public GeckoNetImpl() {
        this.f407258a = (GeckoNetApi) RetrofitUtils.createSsService(UrlConstant.getSCHEME() + UrlConstant.getGeckoHost(), GeckoNetApi.class);
        this.f407259b = "GeckoNetImpl";
    }

    public final Map<String, String> b(List<Header> r100) {
        HashMap r101 = new HashMap();
        if (CollectionUtils.isEmpty(r100) == true) goto L8;
        Iterator<Header> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Header r103 = r102.next();
        r101.put(r103.getName(), r103.getValue());
    L8:
        return r101;
    }

    @Override // com.bytedance.geckox.net.INetWork
    public e doGet(String r100) throws Exception {
        Pair<String, String> r101 = UrlUtils.parseUrl(r100, new LinkedHashMap());
        SsResponse<String> r102 = this.f407258a.doGet((String) r101.second).execute();
        CertLog.e(this.f407259b, "do get " + ((String) r101.second));
        return new e(b(r102.headers()), r102.body(), r102.code(), r102.raw().getReason());
    }

    @Override // com.bytedance.geckox.net.INetWork
    public e doPost(String r100, String r101) throws Exception {
        TypedByteArray r102 = new TypedByteArray("application/json", r101.getBytes(Charset.forName("UTF-8")), new String[0]);
        Pair<String, String> r103 = UrlUtils.parseUrl(r100, new LinkedHashMap());
        SsResponse<String> r104 = this.f407258a.postBody((String) r103.second, r102).execute();
        CertLog.e(this.f407259b, "do post 2" + ((String) r103.second));
        return new e(b(r104.headers()), r104.body(), r104.code(), r104.raw().getReason());
    }

    @Override // com.bytedance.geckox.net.INetWork
    public e doPost(String r100, List<Pair<String, String>> r101) throws Exception {
        HashMap r102 = new HashMap();
        if (CollectionUtils.isEmpty(r101) == true) goto L8;
        Iterator<Pair<String, String>> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Pair<String, String> r104 = r103.next();
        r102.put(r104.first, r104.second);
    L8:
        CertLog.e(this.f407259b, "do post " + r100);
        SsResponse<String> r105 = this.f407258a.doPost(r100, r102).execute();
        return new e(b(r105.headers()), r105.body(), r105.code(), r105.raw().getReason());
    }

    @Override // com.bytedance.geckox.net.INetWork
    public void downloadFile(String r100, long r101, b r102) throws Exception {
        BufferedInputStream r103 = null;
        int r104 = 0;
        CertLog.e(this.f407259b, "downloadFile " + r100);     // Catch: Throwable -> L19 Exception -> L21
        SsResponse<TypedInput> r105 = this.f407258a.downloadFile(r100, null).execute();     // Catch: Throwable -> L19 Exception -> L21
        int r106 = r105.code();     // Catch: Throwable -> L19 Exception -> L21
        BufferedInputStream r107 = new BufferedInputStream(r105.body().in());     // Catch: Exception -> L17 Throwable -> L19
        byte[] r108 = new byte[2048];     // Catch: Throwable -> L13 Exception -> L15
    L7:
        int r109 = r107.read(r108, 0, 2048);     // Catch: Throwable -> L13 Exception -> L15
        if (r109 == (-1)) goto L11;
        r102.write(r108, 0, r109);     // Catch: Throwable -> L13 Exception -> L15
    L11:
        ez5.b.a(r107);
        return;
    L15:
        e = e;
        r104 = r106;
        r103 = r107;
    L23:
        throw new RuntimeException("downloadFile failed, code: " + r104 + ", url:" + r100 + ", caused by:" + e.getMessage(), e);     // Catch: Throwable -> L19
    L13:
        th = th;
    L25:
        ez5.b.a(r107);
        throw th;
    L17:
        e = e;
        r104 = r106;
    L21:
        e = e;
    L19:
        th = th;
        r107 = r103;
        goto L25
    }
}
