package com.tencent.open.a;

import android.text.TextUtils;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;
import okhttp3.k;

/* JADX INFO: loaded from: classes29.dex */
class e implements com.tencent.open.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OkHttpClient f461693a;

    public static class a implements Interceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f461694a;

        public a(String r100) {
            this.f461694a = r100;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain r100) throws IOException {
            return r100.proceed(r100.request().newBuilder().header("User-Agent", this.f461694a).build());
        }
    }

    private void a(OkHttpClient.Builder r100) {
    }

    public e(String r100) throws NoClassDefFoundError {
        a(r100);
    }

    private void a(String r100) {
        String r101 = Version.userAgent();
        if (r101 == null) goto L9;
        if (r101.startsWith("okhttp/3") == false) goto L9;
        a r102 = new a(r100);
        OkHttpClient.Builder r103 = new OkHttpClient.Builder().connectionSpecs(Arrays.asList(new okhttp3.f[]{okhttp3.f.f523840e, okhttp3.f.f523841f}));
        TimeUnit r104 = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder r105 = r103.connectTimeout(15000, r104).readTimeout(30000, r104).writeTimeout(30000, r104).cache(null).addInterceptor(r102);
        a(r105);
        this.f461693a = r105.build();
        return;
    L9:
        throw new NoClassDefFoundError();
    }

    @Override // com.tencent.open.a.a
    public g a(String r100, String r101) throws IOException {
        SLog.i("OkHttpServiceImpl", "get.");
        if (TextUtils.isEmpty(r101) == true) goto L12;
        int r102 = r101.indexOf("?");
        if (r102 != (-1)) goto L8;
        r100 = r100 + "?";
    L10:
        r100 = r100 + r101;
        goto L12
    L8:
        if (r102 == (r100.length() - 1)) goto L10;
        r100 = r100.concat("&");
    L12:
        return new d(this.f461693a.newCall(new Request.Builder().url(r100).get().build()).execute(), r101.length());
    }

    @Override // com.tencent.open.a.a
    public g a(String r100, Map<String, String> r101) throws IOException {
        SLog.i("OkHttpServiceImpl", "post data");
        FormBody.Builder r102 = new FormBody.Builder();
        if (r101 != null) goto L5;
    L12:
        FormBody r103 = r102.build();
        Request r104 = new Request.Builder().url(r100).post(r103).build();
        return new d(this.f461693a.newCall(r104).execute(), (int) r103.contentLength());
    L5:
        if (r101.size() <= 0) goto L12;
        Iterator<String> r105 = r101.keySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();
        String r107 = r101.get(r106);
        if (r107 == null) goto L8;
        r102.add(r106, r107);
        goto L8
    }

    @Override // com.tencent.open.a.a
    public void a(long r100, long r101) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r101 > 0) goto L8;
        return;
    L8:
        if (this.f461693a.connectTimeoutMillis() == r100) goto L10;
    L11:
        SLog.i("OkHttpServiceImpl", "setTimeout changed.");
        OkHttpClient.Builder r102 = this.f461693a.newBuilder();
        TimeUnit r103 = TimeUnit.MILLISECONDS;
        this.f461693a = r102.connectTimeout(r100, r103).readTimeout(r101, r103).writeTimeout(r101, r103).build();
        return;
    L10:
        if (this.f461693a.readTimeoutMillis() != r101) goto L11;
    }

    @Override // com.tencent.open.a.a
    public g a(String r100, Map<String, String> r101, Map<String, byte[]> r102) throws IOException {
        if (r102 == null) goto L27;
        if (r102.size() == 0) goto L27;
        SLog.i("OkHttpServiceImpl", "post data, has byte data");
        k.a r103 = new k.a();
        if (r101 != null) goto L9;
    L16:
        Iterator<String> r104 = r102.keySet().iterator();
    L18:
        if (r104.hasNext() == false) goto L24;
        String r105 = r104.next();
        byte[] r106 = r102.get(r105);
        if (r106 == null) goto L18;
        if (r106.length <= 0) goto L18;
        r103.b(r105, r105, RequestBody.create(MediaType.get("content/unknown"), r106));
        SLog.w("OkHttpServiceImpl", "post byte data.");
        goto L18
    L24:
        k r107 = r103.d();
        Request r108 = new Request.Builder().url(r100).post(r107).build();
        return new d(this.f461693a.newCall(r108).execute(), (int) r107.contentLength());
    L9:
        if (r101.size() <= 0) goto L16;
        Iterator<String> r109 = r101.keySet().iterator();
    L12:
        if (r109.hasNext() == false) goto L16;
        String r110 = r109.next();
        String r111 = r101.get(r110);
        if (r111 == null) goto L12;
        r103.a(r110, r111);
    L27:
        return a(r100, r101);
    }
}
