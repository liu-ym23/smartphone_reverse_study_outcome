package com.ss.videoarch.strategy.network;

import android.util.Pair;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class LSSDKConfig {
    static String TAG = "VeLSSettingsManager";
    final String mApiHost;
    final List<Pair<String, String>> mCommonParams;
    final ThreadPoolExecutor mCustomThreadPool;
    final IHttpExecutor mHttpExecutor;

    /* JADX INFO: renamed from: com.ss.videoarch.strategy.network.LSSDKConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String mApiHost;
        private List<Pair<String, String>> mCommonParams;
        private ThreadPoolExecutor mCustomThreadPool;
        private IHttpExecutor mHttpExecutor;

        public LSSDKConfig build() {
            return new LSSDKConfig(this, null);
        }

        public Builder() {
            this.mCommonParams = new ArrayList();
        }

        public static /* synthetic */ String access$000(Builder r100) {
            return r100.mApiHost;
        }

        public static /* synthetic */ IHttpExecutor access$100(Builder r100) {
            return r100.mHttpExecutor;
        }

        public static /* synthetic */ List access$200(Builder r100) {
            return r100.mCommonParams;
        }

        public static /* synthetic */ ThreadPoolExecutor access$300(Builder r100) {
            return r100.mCustomThreadPool;
        }

        public Builder setApiHost(String r100) {
            this.mApiHost = r100;
            return this;
        }

        public Builder setCommonParams(List<Pair<String, String>> r100) {
            this.mCommonParams = r100;
            return this;
        }

        public Builder setCustomThreadPool(ThreadPoolExecutor r100) {
            this.mCustomThreadPool = r100;
            return this;
        }

        public Builder setHttpExecutor(IHttpExecutor r100) {
            this.mHttpExecutor = r100;
            return this;
        }
    }

    public static class DefaultHttpExecutor implements IHttpExecutor {
        private int SEND_REQUEST_TIMEOUT;

        public DefaultHttpExecutor() {
            this.SEND_REQUEST_TIMEOUT = 5;
        }

        @Skip({"com.obric.assistant.network.okhttp"})
        public static URLConnection INVOKEVIRTUAL_com_ss_videoarch_strategy_network_LSSDKConfig$DefaultHttpExecutor_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
            String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
            String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
            if (a.c(r101, r102) == false) goto L11;
            FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
            a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
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

        @Override // com.ss.videoarch.strategy.network.IHttpExecutor
        public String executeGet(String r100) throws Exception {
            HttpURLConnection r101 = getHttpURLConnection("GET", r100);
            if (r101 != null) goto L20;
            String r102 = LSSDKConfig.TAG;
            return null;
        L20:
            if (r101.getResponseCode() == 200) goto L9;
        L11:
            r101.disconnect();
            return null;
        L9:
            r101.disconnect();
            return SliceInitService.DEFAULT_SWITCH;
        L14:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            r101.disconnect();
            throw th;
        }

        private HttpURLConnection getHttpURLConnection(String r100, String r101) {
            HttpURLConnection r102 = null;
            HttpURLConnection r103 = (HttpURLConnection) INVOKEVIRTUAL_com_ss_videoarch_strategy_network_LSSDKConfig$DefaultHttpExecutor_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r101));     // Catch: Exception -> L8
            r103.setRequestMethod(r100);     // Catch: Exception -> L6
            r103.setUseCaches(false);     // Catch: Exception -> L6
            r103.setConnectTimeout(this.SEND_REQUEST_TIMEOUT * 1000);     // Catch: Exception -> L6
            r103.setReadTimeout(this.SEND_REQUEST_TIMEOUT * 1000);     // Catch: Exception -> L6
            r103.setDoInput(true);     // Catch: Exception -> L6
            return r103;
        L6:
            e = e;
            r102 = r103;
        L9:
            e.printStackTrace();
            return r102;
        L8:
            e = e;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.io.OutputStream] */
        /* JADX WARN: Type inference failed for: r8v7, types: [java.io.OutputStream] */
        @Override // com.ss.videoarch.strategy.network.IHttpExecutor
        public String executePost(String r100, byte[] r101, String r102, String r103) throws Exception {
            HttpURLConnection r104 = getHttpURLConnection("POST", r100);
            if (r104 != null) goto L83;
            String r105 = LSSDKConfig.TAG;
            return null;
        L83:
            r103 = r104.getOutputStream();     // Catch: Throwable -> L36 Exception -> L38
        L85:
            r103.write(r101);     // Catch: Throwable -> L32 Exception -> L34
            if (r104.getResponseCode() != 200) goto L70;
            InputStream r106 = r104.getInputStream();     // Catch: Throwable -> L32 Exception -> L34
            BufferedReader r107 = new BufferedReader(new InputStreamReader(r106));     // Catch: Exception -> L26 Throwable -> L53
            StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L26 Throwable -> L53
        L11:
            String r109 = r107.readLine();     // Catch: Exception -> L26 Throwable -> L53
            if (r109 == null) goto L14;
            r108.append(r109);     // Catch: Exception -> L26 Throwable -> L53
            goto L11
        L14:
            String r110 = r108.toString();     // Catch: Exception -> L26 Throwable -> L53
            r103.close();     // Catch: IOException -> L17
        L19:
            if (r106 != null) goto L68;
        L24:
            r104.disconnect();
            return r110;
        L68:
            r106.close();     // Catch: IOException -> L22
        L22:
            e = move-exception;
            e.printStackTrace();
        L17:
            e = move-exception;
            e.printStackTrace();
        L26:
            e = e;
        L40:
            e.printStackTrace();     // Catch: Throwable -> L53
            if (r103 != 0) goto L72;
        L46:
            if (r106 != null) goto L77;
        L51:
            r104.disconnect();
            return null;
        L77:
            r106.close();     // Catch: IOException -> L49
        L49:
            e = move-exception;
            e.printStackTrace();
            goto L51
        L72:
            r103.close();     // Catch: IOException -> L44
        L44:
            e = move-exception;
            e.printStackTrace();
            goto L46
        L70:
            r103.close();     // Catch: IOException -> L30
        L30:
            e = move-exception;
            e.printStackTrace();
        L34:
            e = e;
            r106 = null;
        L32:
            th = move-exception;
            th = th;
            r101 = 0;
        L54:
            if (r103 != 0) goto L75;
        L59:
            if (r101 != 0) goto L66;
        L64:
            r104.disconnect();
            throw th;
        L66:
            r101.close();     // Catch: IOException -> L62
        L62:
            e = move-exception;
            e.printStackTrace();
            goto L64
        L75:
            r103.close();     // Catch: IOException -> L57
        L57:
            e = move-exception;
            e.printStackTrace();
        L38:
            e = e;
            r106 = null;
            r103 = 0;
        L36:
            th = move-exception;
            r103 = 0;
            th = th;
            r101 = 0;
        L53:
            th = th;
            goto L54
        }
    }

    public String getApiHost() {
        return this.mApiHost;
    }

    private LSSDKConfig(Builder r100) {
        this.mApiHost = Builder.access$000(r100);
        if (Builder.access$100(r100) != null) goto L5;
        this.mHttpExecutor = new DefaultHttpExecutor();
    L6:
        this.mCommonParams = Builder.access$200(r100);
        this.mCustomThreadPool = Builder.access$300(r100);
        return;
    L5:
        this.mHttpExecutor = Builder.access$100(r100);
        goto L6
    }

    public /* synthetic */ LSSDKConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
