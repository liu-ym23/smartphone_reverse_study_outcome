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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements DataFetcher<InputStream> {
    public final Call.a a;
    public final CommentImageGlideUrl b;
    public InputStream c;
    public ResponseBody d;
    public volatile Call e;
    public volatile boolean f;
    public final com.bytedance.ee.bear.imageviewer.b g;

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

    public g(Call.a r3, CommentImageGlideUrl r4) {
        this.g = new com.bytedance.ee.bear.imageviewer.b((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        this.a = r3;
        this.b = r4;
    }

    public final void loadData(Priority r4, DataFetcher.DataCallback<? super InputStream> r5) {
    L11:
        e = move-exception;
        tt5.a.d("Comment#CommentImageStreamFetcher", "loadData failed with exception:" + e);
        r5.onLoadFailed(e);
        return;
    L4:
        if (this.b.isValid() == false) goto L10;
        InputStream r0 = a(this.b.toURL(), 0, null);     // Catch: Exception -> L11
        if (r0 == null) goto L8;
        tt5.a.h("Comment#CommentImageStreamFetcher", "loadData succeed.");     // Catch: Exception -> L11
        r5.onDataReady(r0);     // Catch: Exception -> L11
        return;
    L8:
        tt5.a.d("Comment#CommentImageStreamFetcher", "loadData failed.");     // Catch: Exception -> L11
        r5.onLoadFailed(new Exception("Request is canceled"));     // Catch: Exception -> L11
        return;
    L10:
        throw new IOException("url is null");     // Catch: Exception -> L11
    }

    public final InputStream a(URL r17, int r18, URL r19) throws IOException {
        if (r18 >= 5) goto L45;
        if (r19 != null) goto L52;
    L10:
        Request.Builder r3 = new Request.Builder().url(this.b.toStringUrl());
        Iterator r4 = this.b.getHeaders().entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        Map.Entry r5 = (Map.Entry) r4.next();
        r3.addHeader((String) r5.getKey(), (String) r5.getValue());
        goto L12
    L14:
        long r6 = System.currentTimeMillis();
        this.e = this.a.newCall(r3.build());
        Response r7 = this.e.execute();
        if (this.f == false) goto L18;
        return null;
    L18:
        long r8 = System.currentTimeMillis() - r6;
        int r9 = r7.code();
        tt5.a.h("Comment#CommentImageStreamFetcher", "statusCode =" + r9 + ", costTime=" + r8);
        this.d = r7.body();
        if (r9 != 200) goto L25;
        if (r7.body() == null) goto L25;
        this.g.a(200, "success", "commentCardDocs", r7.body().contentLength(), r8);
        InputStream r1 = r7.body().byteStream();
        this.c = r1;
        return r1;
    L25:
        if ((r9 / 100) != 3) goto L48;
        String r10 = r7.header("Location");
        if (TextUtils.isEmpty(r10) == true) goto L31;
        return a(new URL(r17, r10), r18 + 1, r17);
    L31:
        throw new IOException("Received empty or null redirect url");
    L48:
        JSONObject r2 = new JSONObject(r7.body().string());     // Catch: JSONException -> L38
        int r11 = JSONObjectProtectorUtils.getInt(r2, "code");     // Catch: JSONException -> L38
        String r12 = JSONObjectProtectorUtils.getString(r2, "message");     // Catch: JSONException -> L38
        tt5.a.b("Comment#CommentImageStreamFetcher", "parse json code=" + r11 + "; message=" + r12);     // Catch: JSONException -> L38
        com.bytedance.ee.bear.imageviewer.b r13 = this.g;     // Catch: JSONException -> L38
        if (r13 == null) goto L43;
        r13.a(r11, r12, "commentCardDocs", -1, r8);     // Catch: JSONException -> L47
    L43:
        throw new IOException("Request failed " + r9 + ": " + r7.message());
    L39:
        tt5.a.d("Comment#CommentImageStreamFetcher", "parse json data fail.");
        String r14 = r7.message();
        com.bytedance.ee.bear.imageviewer.b r15 = this.g;
        if (r15 == null) goto L43;
        r15.a(r9, r14, "commentCardDocs", -1, r8);
        goto L43
    L52:
        if (r17.toURI().equals(r19.toURI()) == false) goto L10;
        throw new IOException("In re-direct loop");     // Catch: URISyntaxException -> L46
    L45:
        throw new IOException("Too many (> 5) redirects!");
    }
}
