package go5;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.ResponseBody;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements DataFetcher<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call.a f481924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThumbGlideUrl f481925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f481926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f481927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public lo5.a f481928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f481929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f481930g;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cancel() {
        tt5.a.h("ThumbStreamFetcher", "cancel download task " + Log.getStackTraceString(new Throwable()));
        this.f481927d = true;
        lo5.a r100 = this.f481928e;
        if (r100 == null) goto L8;
        r100.f510128c = true;
        Call r101 = r100.f510129d;
        if (r101 == null) goto L9;
        r101.cancel();
        return;
    L9:
        return;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void cleanup() {
        InputStream r100 = this.f481926c;     // Catch: IOException -> L6
        if (r100 == null) goto L7;
        r100.close();     // Catch: IOException -> L6
    L7:
        lo5.a r101 = this.f481928e;
        if (r101 == null) goto L20;
        ResponseBody r102 = r101.f510130e;
        if (r102 == null) goto L21;
        r102.close();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        tt5.a.f("ThumbDownloadTask", th, false);
        return;
    L21:
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

    public c(Call.a r100, ThumbGlideUrl r101) {
        this.f481924a = r100;
        this.f481925b = r101;
    }

    public final void d(long r100, long r101) {
        com.bytedance.ee.bear.contract.d r102 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (this.f481927d == true) goto L8;
        if (r102 == null) goto L9;
        HashMap r103 = new HashMap(5);
        r103.put("file_type", e.c(this.f481925b.getDocType()));
        r103.put("source", this.f481925b.getSource());
        r103.put("time_cost_ms", String.valueOf(r100));
        r103.put("file_size", String.valueOf(r101 / 1024));
        r103.put("is_encrypt", String.valueOf(this.f481930g));
        r102.v("thumb_info", r103);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v30, types: [io5.c] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v8, types: [byte[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r5v16, types: [aw4.a] */
    /* JADX WARN: Type inference failed for: r6v12, types: [aw4.a] */
    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority r110, DataFetcher.DataCallback<? super InputStream> r111) {
        long r100 = System.currentTimeMillis();
        String r101 = this.f481925b.getUrl();
        boolean r112 = this.f481925b.needUpdate(r101);
        this.f481930g = this.f481925b.isEncrypt();
    L63:
        e = e;
        String r102 = r101;
    L65:
        tt5.a.e("ThumbStreamFetcher", "ThumbStreamFetcher.loadData. load error, callback loadFailed", e, false);
        r111.onLoadFailed(e);
        c(r102, r112, false, false, e.getMessage());
        return;
    L4:
        if (this.f481925b.isValid() == false) goto L62;
        ?? r103 = a(this.f481925b.getEncryptCacheKey(), this.f481925b.getUrl(), this.f481925b.toURL(), true);     // Catch: Exception -> L63
        if (r103 != 0) goto L10;
        tt5.a.d("ThumbStreamFetcher", "ThumbStreamFetcher.getEncryptData. get encrypt data failed, callback loadFailed");     // Catch: Exception -> L63
        r111.onLoadFailed(new IOException("not cache and load form net without etag return null"));     // Catch: Exception -> L63
        c(r101, r112, this.f481930g, false, "ThumbStreamFetcher.getEncryptData. get encrypt data failed, callback loadFailed");     // Catch: Exception -> L63
        return;
    L10:
        if (this.f481930g == false) goto L15;
        String r104 = this.f481925b.getEncryptCacheKey();     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r104) == true) goto L15;
        ((aw4.a) org.koin.java.a.a(aw4.a.class)).a(r104, r103);     // Catch: Exception -> L63
    L15:
        if (this.f481925b.isEncrypt() == true) goto L17;
    L31:
        ?? r105 = r103;
    L32:
        if (r105 == 0) goto L34;
    L49:
        String r106 = r101;
        if (r105 != 0) goto L53;
        tt5.a.d("ThumbStreamFetcher", "ThumbStreamFetcher.loadData. resultData==null, callback loadFailed");     // Catch: Exception -> L59
        r111.onLoadFailed(new IOException("ThumbStreamFetcher.loadData. resultData==null, callback loadFailed"));     // Catch: Exception -> L59
        c(r106, false, false, false, "ThumbStreamFetcher.loadData. resultData==null, callback loadFailed");     // Catch: Exception -> L59
        return;
    L53:
        ByteArrayInputStream r107 = new ByteArrayInputStream(r105);     // Catch: Exception -> L59
        this.f481926c = r107;     // Catch: Exception -> L59
        r111.onDataReady(r107);     // Catch: Exception -> L59
        c(r106, r112, this.f481930g, true, "");     // Catch: Exception -> L59
        if (this.f481929f == false) goto L56;
        return;
    L56:
        if (this.f481926c == null) goto L70;
        d(System.currentTimeMillis() - r100, r105.length);     // Catch: Exception -> L59
        return;
    L70:
        return;
    L59:
        e = e;
        r102 = r106;
        goto L65
    L34:
        if (this.f481925b.isIcon() == true) goto L49;
        if (this.f481925b.isForceEncryption() == false) goto L38;
    L47:
        tt5.a.h("ThumbStreamFetcher", "ThumbStreamFetcher.decryption. force encryption but decrypt failed, callback cacheData");     // Catch: Exception -> L63
        ByteArrayInputStream r108 = new ByteArrayInputStream(r103);     // Catch: Exception -> L63
        this.f481926c = r108;     // Catch: Exception -> L63
        r111.onDataReady(r108);     // Catch: Exception -> L63
        c(r101, r112, this.f481930g, true, "ThumbStreamFetcher.decryption. force encryption but decrypt failed, callback cacheData");     // Catch: Exception -> L63
        return;
    L38:
        if (this.f481925b.isConnected() == false) goto L47;
        tt5.a.h("ThumbStreamFetcher", "ThumbStreamFetcher.decryption. decrypt failed, try load again use origin url");     // Catch: Exception -> L63
        r101 = this.f481925b.getOriginUrl();     // Catch: Exception -> L63
        r112 = this.f481925b.needUpdate(r101);     // Catch: Exception -> L63
        this.f481930g = false;     // Catch: Exception -> L63
        r105 = a("", this.f481925b.getOriginUrl(), this.f481925b.toURLForOriginUrl(), false);     // Catch: Exception -> L63
        if (r105 == 0) goto L45;
        String r109 = this.f481925b.getEncryptCacheKey();     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r109) == true) goto L49;
        ((aw4.a) org.koin.java.a.a(aw4.a.class)).a(r109, r105);     // Catch: Exception -> L63
        goto L49
    L45:
        tt5.a.d("ThumbStreamFetcher", "ThumbStreamFetcher.getOriginData. get origin data failed, callback loadFailed");     // Catch: Exception -> L63
        r111.onLoadFailed(new IOException("ThumbStreamFetcher.getOriginData. get origin data failed, callback loadFailed"));     // Catch: Exception -> L63
        c(r101, false, false, false, "ThumbStreamFetcher.getOriginData. get origin data failed, callback loadFailed");     // Catch: Exception -> L63
        return;
    L17:
        if (this.f481925b.isIcon() == true) goto L31;
        tt5.a.b("ThumbStreamFetcher", "ThumbStreamFetcher.decryption. isUseCached: " + this.f481929f);     // Catch: Exception -> L63
        int r113 = this.f481925b.getDecodeType();     // Catch: Exception -> L63
        String r114 = this.f481925b.getDecodeKey();     // Catch: Exception -> L63
        String r115 = this.f481925b.getDecodeNonce();     // Catch: Exception -> L63
        if (r113 != 1) goto L22;
        ?? r116 = new io5.b();     // Catch: Exception -> L63
    L28:
        if (r116 == 0) goto L31;
        r105 = r116.a(r114, r115, r103);     // Catch: Exception -> L63
        goto L32
    L22:
        if (r113 != 2) goto L25;
        r116 = new io5.a();     // Catch: Exception -> L63
        goto L28
    L25:
        if (r113 != 3) goto L27;
        r116 = new io5.d();     // Catch: Exception -> L63
        goto L28
    L27:
        r116 = 0;
        goto L28
    L62:
        throw new IOException("url or headers is null");     // Catch: Exception -> L63
    }

    public final byte[] b(URL r100, String r101, boolean r102) throws IOException {
        lo5.a r103 = new lo5.a(this.f481924a, this.f481925b);
        this.f481928e = r103;
        InputStream r104 = r103.a(r100, 0, null, r101, r102);
        if (r104 != null) goto L18;
        return null;
    L18:
        byte[] r105 = new byte[1024];     // Catch: Exception -> L14
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();     // Catch: Exception -> L14
    L20:
        int r107 = r104.read(r105);     // Catch: Exception -> L12
        if (r107 == (-1)) goto L10;
        r106.write(r105, 0, r107);     // Catch: Exception -> L12
        goto L20
    L10:
        r106.close();     // Catch: Exception -> L12
        return r106.toByteArray();
    L12:
        e = e;
    L16:
        tt5.a.e("ThumbStreamFetcher", "transStreamToByte error:", e, false);
        IOUtils.close(r106);
        return null;
    L14:
        e = e;
        r106 = null;
        goto L16
    }

    public final byte[] a(String r100, String r101, URL r102, boolean r110) throws Exception {
        byte[] r103 = null;
        boolean r104 = false;
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L25:
        if (r103 != null) goto L27;
    L38:
        byte[] r105 = b(r102, "", r110);
        this.f481929f = false;
        return r105;
    L27:
        if (r103.length == 0) goto L38;
        if (this.f481925b.needUpdate(r101) == false) goto L37;
        byte[] r106 = b(r102, this.f481925b.getETag(), r110);
        if (r106 == null) goto L33;
        r104 = true;
    L33:
        this.f481929f = r104;
        if (r106 != null) goto L44;
        return r103;
    L44:
        return r106;
    L37:
        this.f481929f = true;
        return r103;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L25;
        aw4.a r107 = (aw4.a) org.koin.java.a.a(aw4.a.class);
        if (r107 == null) goto L11;
        r103 = (byte[]) r107.get(r100);
    L11:
        ThumbGlideUrl r108 = this.f481925b;
        ho5.c r109 = ho5.c.d();
        String r111 = this.f481925b.getUrl();
        String r112 = this.f481925b.getVersion();
        monitor-enter(r109);
    L40:
        th = move-exception;
        throw th;
    L14:
        if (TextUtils.isEmpty(r111) == false) goto L17;
        monitor-exit(r109);
        boolean r113 = false;
    L24:
        r108.setIcon(r113);
        goto L25
    L17:
        String r114 = r109.e(r111, r112) + "_isIcon";     // Catch: Throwable -> L40
        Boolean r115 = ho5.c.f486223g.get(r114);     // Catch: Throwable -> L40
        if (r115 != null) goto L22;
        r113 = ((Boolean) ho5.c.f486218b.a(du5.b.e(r114), Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L40
        monitor-exit(r109);
        goto L24
    L22:
        r113 = r115.booleanValue();     // Catch: Throwable -> L40
        monitor-exit(r109);
        goto L24
    }

    public final void c(String r100, boolean r101, boolean r102, boolean r103, String r110) {
        com.bytedance.ee.bear.contract.d r104 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (this.f481927d == true) goto L24;
        if (r104 == null) goto L25;
        HashMap r105 = new HashMap(8);
        r105.put("source", this.f481925b.getSource());
        String r106 = "1";
        if (r103 == false) goto L9;
        Object r107 = "1";
    L10:
        r105.put("status_name", r107);
        r105.put("file_type", e.c(this.f481925b.getDocType()));
        r105.put("url", du5.b.g(r100));
        if (r101 == false) goto L13;
        Object r108 = "1";
    L14:
        r105.put("is_update", r108);
        if (r102 == false) goto L17;
        Object r109 = "1";
    L18:
        r105.put("is_new", r109);
        r105.put("errorMsg", r110);
        if (this.f481925b.isConnected() == true) goto L22;
        r106 = "0";
    L22:
        r105.put("network_status", r106);
        r104.v("thumb_request_result", r105);
        tt5.a.b("ThumbStreamFetcher", "reportLoad: " + r105.toString());
        return;
    L17:
        r109 = "0";
        goto L18
    L13:
        r108 = "0";
        goto L14
    L9:
        r107 = "0";
        goto L10
    L25:
        return;
    }
}
