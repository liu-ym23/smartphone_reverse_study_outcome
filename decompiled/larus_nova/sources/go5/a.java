package go5;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bytedance.ee.util.glide.BearGlideUrl;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements DataFetcher<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.a f481916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BearGlideUrl f481917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f481918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResponseBody f481919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Call f481920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f481921f;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        this.f481921f = true;
        Call r100 = this.f481920e;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        InputStream r100 = this.f481918c;     // Catch: IOException -> L6
        if (r100 == null) goto L7;
        r100.close();     // Catch: IOException -> L6
    L7:
        ResponseBody r101 = this.f481919d;
        if (r101 == null) goto L13;
        r101.close();
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(Call.a r100, BearGlideUrl r101) {
        this.f481916a = r100;
        this.f481917b = r101;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r100, DataFetcher.DataCallback<? super InputStream> r101) {
    L10:
        e = move-exception;
        tt5.a.d("OkHttpStreamFetcher", "loadData failed:" + e);
        r101.onLoadFailed(e);
        return;
    L3:
        if (this.f481917b.isValid() == false) goto L9;
        InputStream r102 = a(this.f481917b.toURL(), 0, null, this.f481917b.getHeaders());     // Catch: Exception -> L10
        if (r102 == null) goto L7;
        r101.onDataReady(r102);     // Catch: Exception -> L10
        return;
    L7:
        r101.onLoadFailed(new Exception("Request is canceled"));     // Catch: Exception -> L10
        return;
    L9:
        throw new IOException("url or headers is null");     // Catch: Exception -> L10
    }

    public final InputStream a(URL r100, int r101, URL r102, Map<String, String> r103) throws IOException {
        if (r101 >= 5) goto L37;
        if (r102 != null) goto L39;
    L10:
        Request.Builder r104 = new Request.Builder().url(this.f481917b.toStringUrl());
        Iterator<Map.Entry<String, String>> r105 = r103.entrySet().iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, String> r106 = r105.next();
        r104.addHeader(r106.getKey(), r106.getValue());
        goto L12
    L14:
        this.f481920e = this.f481916a.newCall(r104.build());
        Response r107 = this.f481920e.execute();
        if (this.f481921f == false) goto L18;
        return null;
    L18:
        int r108 = r107.code();
        this.f481919d = r107.body();
        int r109 = r108 / 100;
        if (r109 != 2) goto L23;
        InputStream r110 = r107.body().byteStream();
        this.f481918c = r110;
        return r110;
    L23:
        if (r109 != 3) goto L31;
        String r111 = r107.header("Location");
        if (TextUtils.isEmpty(r111) == true) goto L29;
        return a(new URL(r100, r111), r101 + 1, r100, r103);
    L29:
        throw new IOException("Received empty or null redirect url");
    L31:
        if (r108 != (-1)) goto L35;
        throw new IOException("Unable to retrieve response code from OkHttpClient.");
    L35:
        throw new IOException("Request failed " + r108 + ": " + r107.message());
    L39:
        if (r100.toURI().equals(r102.toURI()) == false) goto L10;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L38
    L37:
        throw new IOException("Too many (> 5) redirects!");
    }
}
