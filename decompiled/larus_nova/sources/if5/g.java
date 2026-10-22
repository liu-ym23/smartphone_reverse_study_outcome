package if5;

import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bytedance.ee.bear.middleground.comment.image.CommentImageGlideUrl;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
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
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements DataFetcher<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.a f489585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentImageGlideUrl f489586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f489587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ResponseBody f489588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Call f489589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f489590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.imageviewer.b f489591g;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        this.f489590f = true;
        Call r100 = this.f489589e;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        InputStream r100 = this.f489587c;     // Catch: IOException -> L6
        if (r100 == null) goto L7;
        r100.close();     // Catch: IOException -> L6
    L7:
        ResponseBody r101 = this.f489588d;
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

    public g(Call.a r100, CommentImageGlideUrl r101) {
        this.f489591g = new com.bytedance.ee.bear.imageviewer.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        this.f489585a = r100;
        this.f489586b = r101;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r100, DataFetcher.DataCallback<? super InputStream> r101) {
    L11:
        e = move-exception;
        tt5.a.d("Comment#CommentImageStreamFetcher", "loadData failed with exception:" + e);
        r101.onLoadFailed(e);
        return;
    L4:
        if (this.f489586b.isValid() == false) goto L10;
        InputStream r102 = a(this.f489586b.toURL(), 0, null);     // Catch: Exception -> L11
        if (r102 == null) goto L8;
        tt5.a.h("Comment#CommentImageStreamFetcher", "loadData succeed.");     // Catch: Exception -> L11
        r101.onDataReady(r102);     // Catch: Exception -> L11
        return;
    L8:
        tt5.a.d("Comment#CommentImageStreamFetcher", "loadData failed.");     // Catch: Exception -> L11
        r101.onLoadFailed(new Exception("Request is canceled"));     // Catch: Exception -> L11
        return;
    L10:
        throw new IOException("url is null");     // Catch: Exception -> L11
    }

    public final InputStream a(URL r110, int r111, URL r112) throws IOException {
        if (r111 >= 5) goto L45;
        if (r112 != null) goto L52;
    L10:
        Request.Builder r100 = new Request.Builder().url(this.f489586b.toStringUrl());
        Iterator<Map.Entry<String, String>> r101 = this.f489586b.getHeaders().entrySet().iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, String> r102 = r101.next();
        r100.addHeader(r102.getKey(), r102.getValue());
        goto L12
    L14:
        long r103 = System.currentTimeMillis();
        this.f489589e = this.f489585a.newCall(r100.build());
        Response r104 = this.f489589e.execute();
        if (this.f489590f == false) goto L18;
        return null;
    L18:
        long r105 = System.currentTimeMillis() - r103;
        int r106 = r104.code();
        tt5.a.h("Comment#CommentImageStreamFetcher", "statusCode =" + r106 + ", costTime=" + r105);
        this.f489588d = r104.body();
        if (r106 != 200) goto L25;
        if (r104.body() == null) goto L25;
        this.f489591g.a(200, "success", "commentCardDocs", r104.body().contentLength(), r105);
        InputStream r107 = r104.body().byteStream();
        this.f489587c = r107;
        return r107;
    L25:
        if ((r106 / 100) != 3) goto L48;
        String r108 = r104.header("Location");
        if (TextUtils.isEmpty(r108) == true) goto L31;
        return a(new URL(r110, r108), r111 + 1, r110);
    L31:
        throw new IOException("Received empty or null redirect url");
    L48:
        JSONObject r109 = new JSONObject(r104.body().string());     // Catch: JSONException -> L38
        int r113 = JSONObjectProtectorUtils.getInt(r109, "code");     // Catch: JSONException -> L38
        String r114 = JSONObjectProtectorUtils.getString(r109, "message");     // Catch: JSONException -> L38
        tt5.a.b("Comment#CommentImageStreamFetcher", "parse json code=" + r113 + "; message=" + r114);     // Catch: JSONException -> L38
        com.bytedance.ee.bear.imageviewer.b r115 = this.f489591g;     // Catch: JSONException -> L38
        if (r115 == null) goto L43;
        r115.a(r113, r114, "commentCardDocs", -1, r105);     // Catch: JSONException -> L47
    L43:
        throw new IOException("Request failed " + r106 + ": " + r104.message());
    L39:
        tt5.a.d("Comment#CommentImageStreamFetcher", "parse json data fail.");
        String r116 = r104.message();
        com.bytedance.ee.bear.imageviewer.b r117 = this.f489591g;
        if (r117 == null) goto L43;
        r117.a(r106, r116, "commentCardDocs", -1, r105);
        goto L43
    L52:
        if (r110.toURI().equals(r112.toURI()) == false) goto L10;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L46
    L45:
        throw new IOException("Too many (> 5) redirects!");
    }
}
