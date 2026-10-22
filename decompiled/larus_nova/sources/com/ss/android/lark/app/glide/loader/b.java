package com.ss.android.lark.app.glide.loader;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.LogTime;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements DataFetcher<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GlideUrl f408736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f408737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HttpURLConnection f408738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f408739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f408740e;

    public static class a {
        public a() {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        this.f408740e = true;
    }

    static {
        new a();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        InputStream r100 = this.f408739d;
        if (r100 != null) goto L12;
    L7:
        HttpURLConnection r101 = this.f408738c;
        if (r101 == null) goto L10;
        r101.disconnect();
    L10:
        this.f408738c = null;
        return;
    L12:
        r100.close();     // Catch: IOException -> L6
        goto L7
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public b(GlideUrl r100, int r101) {
        this.f408736a = r100;
        this.f408737b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v3, types: [double] */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r100, DataFetcher.DataCallback<? super InputStream> r101) {
        String r102 = "Finished http url fetcher fetch in ";
        long r103 = LogTime.getLogTime();
        r101.onDataReady(a(this.f408736a.toURL(), 0, null, this.f408736a.getHeaders()));     // Catch: Throwable -> L5 IOException -> L7
        StringBuilder r104 = new StringBuilder("Finished http url fetcher fetch in ");
    L10:
        r103 = LogTime.getElapsedMillis(r103);
        r104.append(r103);
        r102 = r104.toString();
        GlideLogUtil.i("SafeHttpUrlFetcher", r102);
        return;
    L5:
        th = move-exception;
        GlideLogUtil.i("SafeHttpUrlFetcher", r102 + LogTime.getElapsedMillis(r103));
        throw th;
    L7:
        e = move-exception;
        GlideLogUtil.e("SafeHttpUrlFetcher", "Failed to load data for url", e);     // Catch: Throwable -> L5
        r101.onLoadFailed(e);     // Catch: Throwable -> L5
        r104 = new StringBuilder("Finished http url fetcher fetch in ");
        goto L10
    }

    public final InputStream a(URL r110, int r111, URL r112, Map<String, String> r113) throws IOException {
        if (r111 >= 5) goto L98;
        if (r112 == null) goto L102;
        if (r110.toURI().equals(r112.toURI()) == false) goto L102;
        throw new HttpException("In re-direct loop");     // Catch: URISyntaxException -> L99
    L102:
        String r100 = r110.getHost();     // Catch: Throwable -> L16 IOException -> L95
        String r101 = r110.getPath();     // Catch: Throwable -> L16 IOException -> L95
        if (com.obric.assistant.network.okhttp.a.c(r100, r101) == false) goto L18;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r100 + " path=" + r101);     // Catch: Throwable -> L16 IOException -> L95
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r100, r101), r100, r101);     // Catch: Throwable -> L16 IOException -> L95
        throw new IOException("[NetGuard] dropped " + r110);     // Catch: Throwable -> L16 IOException -> L95
    L18:
        this.f408738c = (HttpURLConnection) r110.openConnection();
        Map<String, String> r102 = Headers.DEFAULT.getHeaders();
        String r103 = r110.getHost();
        String r104 = this.f408736a.toURL().getHost();
        boolean r105 = false;
        if (r112 != null) goto L22;
    L60:
        r102 = r113;
    L61:
        Iterator<Map.Entry<String, String>> r114 = r102.entrySet().iterator();
    L63:
        if (r114.hasNext() == false) goto L65;
        Map.Entry<String, String> r106 = r114.next();
        this.f408738c.addRequestProperty(r106.getKey(), r106.getValue());
        goto L63
    L65:
        this.f408738c.setConnectTimeout(this.f408737b);
        this.f408738c.setReadTimeout(this.f408737b);
        this.f408738c.setUseCaches(false);
        this.f408738c.setDoInput(true);
        this.f408738c.setInstanceFollowRedirects(false);
        this.f408738c.connect();
        this.f408739d = this.f408738c.getInputStream();
        if (this.f408740e == false) goto L68;
        return null;
    L68:
        int r115 = this.f408738c.getResponseCode();
        int r107 = r115 / 100;
        if (r107 != 2) goto L71;
        boolean r108 = true;
    L72:
        if (r108 == false) goto L80;
        InputStream r116 = this.f408739d;
        String r117 = this.f408738c.getContentEncoding();
        int r118 = this.f408738c.getContentLength();
        if (TextUtils.isEmpty(r117) == false) goto L76;
        this.f408739d = ContentLengthInputStream.obtain(r116, r118);
    L78:
        return this.f408739d;
    L76:
        GlideLogUtil.w("SafeHttpUrlFetcher", "Got non empty content encoding: " + r117);
        this.f408739d = r116;
        goto L78
    L80:
        if (r107 != 3) goto L82;
        r105 = true;
    L82:
        if (r105 == false) goto L90;
        String r119 = this.f408738c.getHeaderField("Location");
        if (TextUtils.isEmpty(r119) == true) goto L88;
        URL r109 = new URL(r110, r119);
        cleanup();
        return a(r109, r111 + 1, r110, r113);
    L88:
        throw new HttpException("Received empty or null redirect url");
    L90:
        if (r115 != (-1)) goto L94;
        throw new HttpException(r115);
    L94:
        throw new HttpException(this.f408738c.getResponseMessage(), r115);
    L71:
        r108 = false;
        goto L72
    L22:
        if (TextUtils.equals(r103, r104) == true) goto L60;
        if (GlideRedirectionTrustedDomainFilter.f408732b.get(r103) == null) goto L27;
        Log.i("GlideRedirectionTrustedDomainFilter", "trusted from cache");
    L52:
        boolean r120 = true;
    L59:
        if (r120 == false) goto L61;
    L27:
        Lazy r121 = GlideRedirectionTrustedDomainFilter.f408731a;
        if (((List) r121.getValue()).isEmpty() == true) goto L53;
        if (r103 == null) goto L53;
        Iterator r122 = ((List) r121.getValue()).iterator();
    L33:
        if (r122.hasNext() == false) goto L45;
        Object r123 = r122.next();
        String r124 = (String) r123;
        if (Intrinsics.areEqual(r103, r124) == false) goto L37;
    L40:
        boolean r125 = true;
    L41:
        if (r125 == false) goto L43;
        GlideRedirectionTrustedDomainFilter.f408732b.put(r103, Boolean.TRUE);
    L43:
        if (r125 == false) goto L33;
    L46:
        String r126 = (String) r123;
        StringBuilder r127 = new StringBuilder("host: ");
        r127.append(r103);
        r127.append(", isTrusted: ");
        if (r126 == null) goto L49;
        boolean r128 = true;
    L50:
        r127.append(r128);
        Log.i("GlideRedirectionTrustedDomainFilter", r127.toString());
        if (r126 != null) goto L52;
    L58:
        r120 = false;
        goto L59
    L49:
        r128 = false;
        goto L50
    L37:
        if (StringsKt.endsWith$default(r103, "." + r124, false, 2, null) == true) goto L40;
        r125 = false;
        goto L41
    L45:
        r123 = null;
    L53:
        StringBuilder r129 = new StringBuilder("domainList is empty: ");
        r129.append(((List) r121.getValue()).isEmpty());
        r129.append(", host is null: ");
        if (r103 != null) goto L56;
        boolean r130 = true;
    L57:
        r129.append(r130);
        Log.i("GlideRedirectionTrustedDomainFilter", r129.toString());
        goto L58
    L56:
        r130 = false;
    L95:
        e = move-exception;
        throw e;
    L16:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L18
    L98:
        throw new HttpException("Too many (> 5) redirects!");
    }
}
