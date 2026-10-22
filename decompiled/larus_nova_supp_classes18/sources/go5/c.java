package go5;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.ResponseBody;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements DataFetcher<InputStream> {
    public final Call.a a;
    public final ThumbGlideUrl b;
    public InputStream c;
    public volatile boolean d;
    public lo5.a e;
    public boolean f;
    public boolean g;

    public final void cancel() {
        tt5.a.h("ThumbStreamFetcher", "cancel download task " + Log.getStackTraceString(new Throwable()));
        this.d = true;
        lo5.a r1 = this.e;
        if (r1 == null) goto L8;
        r1.c = true;
        Call r0 = r1.d;
        if (r0 == null) goto L9;
        r0.cancel();
        return;
    L9:
        return;
    }

    public final void cleanup() {
        InputStream r0 = this.c;     // Catch: IOException -> L6
        if (r0 == null) goto L7;
        r0.close();     // Catch: IOException -> L6
    L7:
        lo5.a r1 = this.e;
        if (r1 == null) goto L20;
        ResponseBody r2 = r1.e;
        if (r2 == null) goto L21;
        r2.close();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        tt5.a.f("ThumbDownloadTask", th, false);
        return;
    L21:
        return;
    }

    public final Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public final DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public c(Call.a r1, ThumbGlideUrl r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d(long r5, long r7) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (this.d == true) goto L8;
        if (r0 == null) goto L9;
        HashMap r1 = new HashMap(5);
        r1.put("file_type", e.c(this.b.getDocType()));
        r1.put("source", this.b.getSource());
        r1.put("time_cost_ms", String.valueOf(r5));
        r1.put("file_size", String.valueOf(r7 / 1024));
        r1.put("is_encrypt", String.valueOf(this.g));
        r0.v("thumb_info", r1);
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
    public final void loadData(Priority r13, DataFetcher.DataCallback<? super InputStream> r14) {
        long r1 = System.currentTimeMillis();
        String r3 = this.b.getUrl();
        boolean r10 = this.b.needUpdate(r3);
        this.g = this.b.isEncrypt();
    L63:
        e = e;
        String r2 = r3;
    L65:
        tt5.a.e("ThumbStreamFetcher", "ThumbStreamFetcher.loadData. load error, callback loadFailed", e, false);
        r14.onLoadFailed(e);
        c(r2, r10, false, false, e.getMessage());
        return;
    L4:
        if (this.b.isValid() == false) goto L62;
        ?? r4 = a(this.b.getEncryptCacheKey(), this.b.getUrl(), this.b.toURL(), true);     // Catch: Exception -> L63
        if (r4 != 0) goto L10;
        tt5.a.d("ThumbStreamFetcher", "ThumbStreamFetcher.getEncryptData. get encrypt data failed, callback loadFailed");     // Catch: Exception -> L63
        r14.onLoadFailed(new IOException("not cache and load form net without etag return null"));     // Catch: Exception -> L63
        c(r3, r10, this.g, false, "ThumbStreamFetcher.getEncryptData. get encrypt data failed, callback loadFailed");     // Catch: Exception -> L63
        return;
    L10:
        if (this.g == false) goto L15;
        String r5 = this.b.getEncryptCacheKey();     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r5) == true) goto L15;
        ((aw4.a) org.koin.java.a.a(aw4.a.class)).a(r5, r4);     // Catch: Exception -> L63
    L15:
        if (this.b.isEncrypt() == true) goto L17;
    L31:
        ?? r0 = r4;
    L32:
        if (r0 == 0) goto L34;
    L49:
        String r9 = r3;
        if (r0 != 0) goto L53;
        tt5.a.d("ThumbStreamFetcher", "ThumbStreamFetcher.loadData. resultData==null, callback loadFailed");     // Catch: Exception -> L59
        r14.onLoadFailed(new IOException("ThumbStreamFetcher.loadData. resultData==null, callback loadFailed"));     // Catch: Exception -> L59
        c(r9, false, false, false, "ThumbStreamFetcher.loadData. resultData==null, callback loadFailed");     // Catch: Exception -> L59
        return;
    L53:
        ByteArrayInputStream r6 = new ByteArrayInputStream(r0);     // Catch: Exception -> L59
        this.c = r6;     // Catch: Exception -> L59
        r14.onDataReady(r6);     // Catch: Exception -> L59
        c(r9, r10, this.g, true, "");     // Catch: Exception -> L59
        if (this.f == false) goto L56;
        return;
    L56:
        if (this.c == null) goto L70;
        d(System.currentTimeMillis() - r1, r0.length);     // Catch: Exception -> L59
        return;
    L70:
        return;
    L59:
        e = e;
        r2 = r9;
        goto L65
    L34:
        if (this.b.isIcon() == true) goto L49;
        if (this.b.isForceEncryption() == false) goto L38;
    L47:
        tt5.a.h("ThumbStreamFetcher", "ThumbStreamFetcher.decryption. force encryption but decrypt failed, callback cacheData");     // Catch: Exception -> L63
        ByteArrayInputStream r7 = new ByteArrayInputStream(r4);     // Catch: Exception -> L63
        this.c = r7;     // Catch: Exception -> L63
        r14.onDataReady(r7);     // Catch: Exception -> L63
        c(r3, r10, this.g, true, "ThumbStreamFetcher.decryption. force encryption but decrypt failed, callback cacheData");     // Catch: Exception -> L63
        return;
    L38:
        if (this.b.isConnected() == false) goto L47;
        tt5.a.h("ThumbStreamFetcher", "ThumbStreamFetcher.decryption. decrypt failed, try load again use origin url");     // Catch: Exception -> L63
        r3 = this.b.getOriginUrl();     // Catch: Exception -> L63
        r10 = this.b.needUpdate(r3);     // Catch: Exception -> L63
        this.g = false;     // Catch: Exception -> L63
        r0 = a("", this.b.getOriginUrl(), this.b.toURLForOriginUrl(), false);     // Catch: Exception -> L63
        if (r0 == 0) goto L45;
        String r8 = this.b.getEncryptCacheKey();     // Catch: Exception -> L63
        if (TextUtils.isEmpty(r8) == true) goto L49;
        ((aw4.a) org.koin.java.a.a(aw4.a.class)).a(r8, r0);     // Catch: Exception -> L63
        goto L49
    L45:
        tt5.a.d("ThumbStreamFetcher", "ThumbStreamFetcher.getOriginData. get origin data failed, callback loadFailed");     // Catch: Exception -> L63
        r14.onLoadFailed(new IOException("ThumbStreamFetcher.getOriginData. get origin data failed, callback loadFailed"));     // Catch: Exception -> L63
        c(r3, false, false, false, "ThumbStreamFetcher.getOriginData. get origin data failed, callback loadFailed");     // Catch: Exception -> L63
        return;
    L17:
        if (this.b.isIcon() == true) goto L31;
        tt5.a.b("ThumbStreamFetcher", "ThumbStreamFetcher.decryption. isUseCached: " + this.f);     // Catch: Exception -> L63
        int r11 = this.b.getDecodeType();     // Catch: Exception -> L63
        String r12 = this.b.getDecodeKey();     // Catch: Exception -> L63
        String r15 = this.b.getDecodeNonce();     // Catch: Exception -> L63
        if (r11 != 1) goto L22;
        ?? r16 = new io5.b();     // Catch: Exception -> L63
    L28:
        if (r16 == 0) goto L31;
        r0 = r16.a(r12, r15, r4);     // Catch: Exception -> L63
        goto L32
    L22:
        if (r11 != 2) goto L25;
        r16 = new io5.a();     // Catch: Exception -> L63
        goto L28
    L25:
        if (r11 != 3) goto L27;
        r16 = new io5.d();     // Catch: Exception -> L63
        goto L28
    L27:
        r16 = 0;
        goto L28
    L62:
        throw new IOException("url or headers is null");     // Catch: Exception -> L63
    }

    public final byte[] b(URL r7, String r8, boolean r9) throws IOException {
        lo5.a r0 = new lo5.a(this.a, this.b);
        this.e = r0;
        InputStream r10 = r0.a(r7, 0, null, r8, r9);
        if (r10 != null) goto L18;
        return null;
    L18:
        byte[] r11 = new byte[DocUserPermission.USER_PERM_FULL_ACCESS];     // Catch: Exception -> L14
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Exception -> L14
    L20:
        int r2 = r10.read(r11);     // Catch: Exception -> L12
        if (r2 == (-1)) goto L10;
        r1.write(r11, 0, r2);     // Catch: Exception -> L12
        goto L20
    L10:
        r1.close();     // Catch: Exception -> L12
        return r1.toByteArray();
    L12:
        e = e;
    L16:
        tt5.a.e("ThumbStreamFetcher", "transStreamToByte error:", e, false);
        IOUtils.close(r1);
        return null;
    L14:
        e = e;
        r1 = null;
        goto L16
    }

    public final byte[] a(String r7, String r8, URL r9, boolean r10) throws Exception {
        byte[] r1 = null;
        boolean r2 = false;
        if (TextUtils.isEmpty(r7) == false) goto L6;
    L25:
        if (r1 != null) goto L27;
    L38:
        byte[] r3 = b(r9, "", r10);
        this.f = false;
        return r3;
    L27:
        if (r1.length == 0) goto L38;
        if (this.b.needUpdate(r8) == false) goto L37;
        byte[] r11 = b(r9, this.b.getETag(), r10);
        if (r11 == null) goto L33;
        r2 = true;
    L33:
        this.f = r2;
        if (r11 != null) goto L44;
        return r1;
    L44:
        return r11;
    L37:
        this.f = true;
        return r1;
    L6:
        if (TextUtils.isEmpty(r7) == true) goto L25;
        aw4.a r0 = (aw4.a) org.koin.java.a.a(aw4.a.class);
        if (r0 == null) goto L11;
        r1 = (byte[]) r0.get(r7);
    L11:
        ThumbGlideUrl r12 = this.b;
        ho5.c r4 = ho5.c.d();
        String r5 = this.b.getUrl();
        String r6 = this.b.getVersion();
        monitor-enter(r4);
    L40:
        th = move-exception;
        throw th;
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        monitor-exit(r4);
        boolean r13 = false;
    L24:
        r12.setIcon(r13);
        goto L25
    L17:
        String r14 = r4.e(r5, r6) + "_isIcon";     // Catch: Throwable -> L40
        Boolean r15 = ho5.c.g.get(r14);     // Catch: Throwable -> L40
        if (r15 != null) goto L22;
        r13 = ((Boolean) ho5.c.b.a(du5.b.e(r14), Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L40
        monitor-exit(r4);
        goto L24
    L22:
        r13 = r15.booleanValue();     // Catch: Throwable -> L40
        monitor-exit(r4);
        goto L24
    }

    public final void c(String r6, boolean r7, boolean r8, boolean r9, String r10) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        if (this.d == true) goto L24;
        if (r0 == null) goto L25;
        HashMap r1 = new HashMap(8);
        r1.put("source", this.b.getSource());
        String r2 = "1";
        if (r9 == false) goto L9;
        Object r11 = "1";
    L10:
        r1.put("status_name", r11);
        r1.put("file_type", e.c(this.b.getDocType()));
        r1.put(ResourceData.KEY_URL, du5.b.g(r6));
        if (r7 == false) goto L13;
        Object r12 = "1";
    L14:
        r1.put("is_update", r12);
        if (r8 == false) goto L17;
        Object r13 = "1";
    L18:
        r1.put("is_new", r13);
        r1.put("errorMsg", r10);
        if (this.b.isConnected() == true) goto L22;
        r2 = "0";
    L22:
        r1.put("network_status", r2);
        r0.v("thumb_request_result", r1);
        tt5.a.b("ThumbStreamFetcher", "reportLoad: " + r1.toString());
        return;
    L17:
        r13 = "0";
        goto L18
    L13:
        r12 = "0";
        goto L14
    L9:
        r11 = "0";
        goto L10
    L25:
        return;
    }
}
