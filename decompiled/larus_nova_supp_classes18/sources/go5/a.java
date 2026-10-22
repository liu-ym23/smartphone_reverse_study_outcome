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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements DataFetcher<InputStream> {
    public final Call.a a;
    public final BearGlideUrl b;
    public InputStream c;
    public ResponseBody d;
    public volatile Call e;
    public volatile boolean f;

    public final void cancel() {
        this.f = true;
        Call r0 = this.e;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final void cleanup() {
        InputStream r0 = this.c;     // Catch: IOException -> L6
        if (r0 == null) goto L7;
        r0.close();     // Catch: IOException -> L6
    L7:
        ResponseBody r1 = this.d;
        if (r1 == null) goto L13;
        r1.close();
        return;
    }

    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public a(Call.a r1, BearGlideUrl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void loadData(Priority r4, DataFetcher.DataCallback<? super InputStream> r5) {
    L10:
        e = move-exception;
        tt5.a.d("OkHttpStreamFetcher", "loadData failed:" + e);
        r5.onLoadFailed(e);
        return;
    L3:
        if (this.b.isValid() == false) goto L9;
        InputStream r6 = a(this.b.toURL(), 0, null, this.b.getHeaders());     // Catch: Exception -> L10
        if (r6 == null) goto L7;
        r5.onDataReady(r6);     // Catch: Exception -> L10
        return;
    L7:
        r5.onLoadFailed(new Exception("Request is canceled"));     // Catch: Exception -> L10
        return;
    L9:
        throw new IOException("url or headers is null");     // Catch: Exception -> L10
    }

    public final InputStream a(URL r4, int r5, URL r6, Map<String, String> r7) throws IOException {
        if (r5 >= 5) goto L37;
        if (r6 != null) goto L39;
    L10:
        Request.Builder r8 = new Request.Builder().url(this.b.toStringUrl());
        Iterator<Map.Entry<String, String>> r0 = r7.entrySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r0.next();
        r8.addHeader(r1.getKey(), r1.getValue());
        goto L12
    L14:
        this.e = this.a.newCall(r8.build());
        Response r9 = this.e.execute();
        if (this.f == false) goto L18;
        return null;
    L18:
        int r2 = r9.code();
        this.d = r9.body();
        int r3 = r2 / 100;
        if (r3 != 2) goto L23;
        InputStream r10 = r9.body().byteStream();
        this.c = r10;
        return r10;
    L23:
        if (r3 != 3) goto L31;
        String r11 = r9.header("Location");
        if (TextUtils.isEmpty(r11) == true) goto L29;
        return a(new URL(r4, r11), r5 + 1, r4, r7);
    L29:
        throw new IOException("Received empty or null redirect url");
    L31:
        if (r2 != (-1)) goto L35;
        throw new IOException("Unable to retrieve response code from OkHttpClient.");
    L35:
        throw new IOException("Request failed " + r2 + ": " + r9.message());
    L39:
        if (r4.toURI().equals(r6.toURI()) == false) goto L10;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L38
    L37:
        throw new IOException("Too many (> 5) redirects!");
    }
}
