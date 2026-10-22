package com.bytedance.ug.sdk.deeplink.interfaces;

import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public interface INetwork {
    public static final INetwork DEFAULT = null;

    /* JADX INFO: loaded from: classes22.dex */
    public static class a implements INetwork {
        public a() {
        }

        @Override // com.bytedance.ug.sdk.deeplink.interfaces.INetwork
        public final void fetchScheme(String r100, String r101, int r102, fi7.a r103) throws Exception {
        }

        @Skip({"com.obric.assistant.network.okhttp"})
        public static URLConnection a(URL r100) throws IOException {
            String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
            String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
            if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
            FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
            com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
            throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
        L11:
            return r100.openConnection();
        L12:
            e = move-exception;
            throw e;
        L8:
            th = move-exception;
            FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
            goto L11
        }

        @Override // com.bytedance.ug.sdk.deeplink.interfaces.INetwork
        public final String get(String r100, Map<String, String> r101, boolean r102, long r103) throws Exception {
            URL r104 = new URL(r100);     // Catch: MalformedURLException -> L5
        L26:
            HttpURLConnection r105 = (HttpURLConnection) a(r104);     // Catch: Exception -> L21
            r105.setConnectTimeout(5000);     // Catch: Exception -> L21
            r105.setRequestMethod("GET");     // Catch: Exception -> L21
            if (r101 == null) goto L14;
            Iterator<Map.Entry<String, String>> r106 = r101.entrySet().iterator();     // Catch: Exception -> L21
        L11:
            if (r106.hasNext() == false) goto L14;
            Map.Entry<String, String> r107 = r106.next();     // Catch: Exception -> L21
            r105.setRequestProperty(r107.getKey(), r107.getValue());     // Catch: Exception -> L21
        L14:
            if (r105.getResponseCode() != 200) goto L23;
            InputStream r108 = r105.getInputStream();     // Catch: Exception -> L21
            ByteArrayOutputStream r109 = new ByteArrayOutputStream();     // Catch: Exception -> L21
        L16:
            int r110 = r108.read();     // Catch: Exception -> L21
            if (r110 == (-1)) goto L19;
            r109.write(r110);     // Catch: Exception -> L21
            goto L16
        L19:
            return r109.toString();
        L23:
            return null;
        L21:
            e = move-exception;
            e.printStackTrace();
        L5:
            e = move-exception;
            e.printStackTrace();
            r104 = null;
            goto L26
        }

        @Override // com.bytedance.ug.sdk.deeplink.interfaces.INetwork
        public final String post(String r100, Map<String, String> r101, byte[] r102, long r103, boolean r104, String r105, boolean r110) throws Exception {
            URL r111 = new URL(r100);     // Catch: MalformedURLException -> L5
        L27:
            HttpURLConnection r106 = (HttpURLConnection) a(r111);     // Catch: Exception -> L24
            if (r101 == null) goto L14;
            Iterator<Map.Entry<String, String>> r107 = r101.entrySet().iterator();     // Catch: Exception -> L24
        L11:
            if (r107.hasNext() == false) goto L14;
            Map.Entry<String, String> r112 = r107.next();     // Catch: Exception -> L24
            r106.setRequestProperty(r112.getKey(), r112.getValue());     // Catch: Exception -> L24
        L14:
            if (r103 <= 0) goto L16;
            r106.setConnectTimeout((int) r103);     // Catch: Exception -> L24
        L16:
            r106.setDoOutput(true);     // Catch: Exception -> L24
            r106.setDoInput(true);     // Catch: Exception -> L24
            r106.setUseCaches(false);     // Catch: Exception -> L24
            r106.setRequestMethod("POST");     // Catch: Exception -> L24
            r106.setRequestProperty("Content-Type", r105);     // Catch: Exception -> L24
            r106.setInstanceFollowRedirects(true);     // Catch: Exception -> L24
            r106.connect();     // Catch: Exception -> L24
            DataOutputStream r108 = new DataOutputStream(r106.getOutputStream());     // Catch: Exception -> L24
            r108.write(r102);     // Catch: Exception -> L24
            r108.flush();     // Catch: Exception -> L24
            r108.close();     // Catch: Exception -> L24
            if (r106.getResponseCode() != 200) goto L26;
            InputStream r109 = r106.getInputStream();     // Catch: Exception -> L24
            ByteArrayOutputStream r113 = new ByteArrayOutputStream();     // Catch: Exception -> L24
        L19:
            int r114 = r109.read();     // Catch: Exception -> L24
            if (r114 == (-1)) goto L22;
            r113.write(r114);     // Catch: Exception -> L24
            goto L19
        L22:
            return r113.toString();
        L26:
            return null;
        L24:
            e = move-exception;
            e.printStackTrace();
        L5:
            e = move-exception;
            e.printStackTrace();
            r111 = null;
            goto L27
        }
    }

    void fetchScheme(String r100, String r101, int r102, fi7.a r103) throws Exception;

    String get(String r100, Map<String, String> r101, boolean r102, long r103) throws Exception;

    String post(String r100, Map<String, String> r101, byte[] r102, long r103, boolean r104, String r105, boolean r106) throws Exception;

    static {
        DEFAULT = new a();
    }
}
