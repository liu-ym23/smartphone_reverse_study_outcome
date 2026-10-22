package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    public static final int HTTP_DEFAULT_TIMEOUT = 30000;
    public static final int HTTP_PERMANENT_REDIRECT = 308;
    public static final int HTTP_TEMPORARY_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 5;
    private static final int NUM_NETWORK_THREADS = 3;
    private final ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;

    private static boolean isHttpRedirect(int r100) {
        if (r100 != 307) goto L5;
        return true;
    L5:
        if (r100 == 308) goto L11;
        switch(r100) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    private static boolean isHttpSuccess(int r100) {
        if (r100 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 300) goto L7;
        return true;
    }

    public HttpUrlConnectionNetworkFetcher() {
        this(PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("HttpUrlConnectionNetworkFetcher")));
    }

    public HttpUrlConnectionNetworkFetcher(int r100) {
        this(PThreadExecutorsUtils.newFixedThreadPool(3, new DefaultThreadFactory("HttpUrlConnectionNetworkFetcher")));
        this.mHttpConnectionTimeout = r100;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_facebook_imagepipeline_producers_HttpUrlConnectionNetworkFetcher_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public static HttpURLConnection openConnectionTo(Uri r100) throws IOException {
        return (HttpURLConnection) INVOKEVIRTUAL_com_facebook_imagepipeline_producers_HttpUrlConnectionNetworkFetcher_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(UriUtil.uriToUrl(r100));
    }

    public HttpUrlConnectionNetworkFetcher(ExecutorService r100) {
        this.mExecutorService = r100;
    }

    private HttpURLConnection downloadFrom(Uri r100, int r101) throws IOException {
        HttpURLConnection r102 = openConnectionTo(r100);
        r102.setConnectTimeout(this.mHttpConnectionTimeout);
        int r103 = r102.getResponseCode();
        if (isHttpSuccess(r103) == false) goto L6;
        return r102;
    L6:
        if (isHttpRedirect(r103) == false) goto L23;
        String r104 = r102.getHeaderField("Location");
        r102.disconnect();
        if (r104 != null) goto L10;
        Uri r105 = null;
    L11:
        String r106 = r100.getScheme();
        if (r101 <= 0) goto L18;
        if (r105 == null) goto L18;
        if (r105.getScheme().equals(r106) == true) goto L18;
        return downloadFrom(r105, r101 - 1);
    L18:
        if (r101 != 0) goto L20;
        String r107 = error("URL %s follows too many redirects", new Object[]{r100.toString()});
    L22:
        throw new IOException(r107);
    L20:
        r107 = error("URL %s returned %d without a valid redirect", new Object[]{r100.toString(), Integer.valueOf(r103)});
        goto L22
    L10:
        r105 = Uri.parse(r104);
        goto L11
    L23:
        r102.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{r100.toString(), Integer.valueOf(r103)}));
    }

    private static String error(String r100, Object... r101) {
        return String.format(Locale.getDefault(), r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public FetchState createFetchState(Consumer<EncodedImage> r100, ProducerContext r101) {
        return new FetchState(r100, r101);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(final FetchState r100, final NetworkFetcher.Callback r101) {
        final Future<?> r102 = this.mExecutorService.submit(new AnonymousClass1(this, r100, r101));
        r100.getContext().addCallbacks(new AnonymousClass2(this, r102, r101));
    }

    public void fetchSync(FetchState r100, NetworkFetcher.Callback r101) {
        InputStream r102 = null;
        HttpURLConnection r103 = downloadFrom(r100.getUri(), 5);     // Catch: Throwable -> L15 IOException -> L17
        if (r103 != null) goto L35;
    L9:
        if (r102 != null) goto L42;
    L13:
        if (r103 == null) goto L46;
    L25:
        r103.disconnect();
        return;
    L46:
        return;
    L42:
        r102.close();     // Catch: IOException -> L12
        goto L13
    L35:
        r102 = r103.getInputStream();     // Catch: IOException -> L7 Throwable -> L27
        r101.onResponse(r102, -1);     // Catch: IOException -> L7 Throwable -> L27
    L7:
        e = e;
    L19:
        r101.onFailure(e);     // Catch: Throwable -> L27
        if (r102 != null) goto L38;
    L24:
        if (r103 != null) goto L25;
        return;
    L38:
        r102.close();     // Catch: IOException -> L23
    L27:
        th = th;
    L28:
        if (r102 != null) goto L40;
    L32:
        if (r103 == null) goto L48;
        r103.disconnect();
        throw th;
    L48:
        throw th;
    L40:
        r102.close();     // Catch: IOException -> L31
        goto L32
    L17:
        e = e;
        r103 = null;
    L15:
        th = th;
        r103 = null;
        goto L28
    }
}
