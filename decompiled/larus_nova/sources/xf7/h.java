package xf7;

import android.content.Context;
import android.util.LruCache;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements yf7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f563476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f563477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f563478c;

    public static class a extends LruCache<String, byte[]> {
        public a() {
            super(BmLocated.ALIGN_RIGHT_BOTTOM);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, byte[] r101) {
            return r101.length;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f563479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f563480b;

        public b(boolean r100, String r101) {
            this.f563479a = r100;
            this.f563480b = r101;
        }
    }

    @Override // yf7.d
    public final File D0() {
        return this.f563476a.getFileStreamPath("bd_sync_sdk");
    }

    public h(Context r100) {
        this.f563476a = r100;
        this.f563477b = new a();
        this.f563478c = new HashMap();
    }

    @Override // yf7.d
    public final void g(String r100) {
        zf7.b.d("FileCache  delete ".concat(r100));
        this.f563477b.remove(new PolarisFileWrapper(r100).getName());     // Catch: Exception -> L5
        IOUtils.deleteFile(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // yf7.d
    public final void q0(long r100) {
        zf7.b.d("FileCache  deleteAllFiles " + r100);
        Iterator r101 = ((HashMap) this.f563478c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        Map.Entry r102 = (Map.Entry) r101.next();
        if (r102.getValue() == null) goto L4;
        if (((Long) r102.getValue()).longValue() != r100) goto L4;
        r101.remove();
        goto L4
    L16:
        IOUtils.deletePath(new PolarisFileWrapper(this.f563476a.getFileStreamPath("bd_sync_sdk"), String.valueOf(r100)).getAbsolutePath());     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // yf7.d
    public final String t0(String r100) {
        zf7.b.d("FileCache  readCache ".concat(r100));
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        String r102 = r101.getName();
        byte[] r103 = this.f563477b.get(r102);
        if (r103 != null) goto L47;
        zf7.b.d("FileCache  real readCache ".concat(r100));
        if (r101.exists() == true) goto L49;
    L23:
        r103 = null;
        goto L47
    L49:
        BufferedSource r104 = Okio.buffer(new okio.q(Okio.source(r101)));     // Catch: Throwable -> L15
        r103 = r104.readByteArray();     // Catch: Throwable -> L13
        r104.close();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        Throwable th10 = th;
    L37:
        th10.printStackTrace();     // Catch: Throwable -> L24
        if (r104 == null) goto L23;
        r104.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        th = move-exception;
        if (r104 != null) goto L39;
    L30:
        throw th;
    L39:
        r104.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L15:
        th = move-exception;
        th10 = th;
        r104 = null;
    L47:
        String r105 = new String(r103, "UTF-8");     // Catch: UnsupportedEncodingException -> L34
        if (r102.endsWith("_" + StringEncryptUtils.encrypt(r105, "MD5")) == false) goto L36;
        return r105;
    L36:
        return null;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }

    @Override // yf7.d
    public final String r(long r100, long r110, byte[] r111) {
        return z("synclog", r100, r110, r111, StringEncryptUtils.encrypt(new String(r111, "UTF-8"), "MD5"));
    L5:
        return null;
    }

    @Override // yf7.d
    public final String z(String r100, long r101, long r102, byte[] r103, String r104) {
        zf7.b.d("FileCache  putCache " + r101 + r104);
        String r105 = r100 + "_" + r102 + "_" + r104;
        this.f563477b.put(r105, r103);
        ((HashMap) this.f563478c).put(r105, Long.valueOf(r101));
        PolarisFileWrapper r106 = new PolarisFileWrapper(this.f563476a.getFileStreamPath("bd_sync_sdk"), r101 + File.separator + r105);
        String r107 = r106.getAbsolutePath();
        File r108 = r106.getParentFile();     // Catch: Throwable -> L14
        if (r108.exists() == true) goto L6;
        r108.mkdirs();     // Catch: Throwable -> L14
    L6:
        IOUtils.deleteFile(r106.getAbsolutePath());     // Catch: Throwable -> L14
        r106.createNewFile();     // Catch: Throwable -> L14
        BufferedSink r109 = Okio.buffer(new okio.p(Okio.sink(r106)));     // Catch: Throwable -> L14
        r109.write(r103);     // Catch: Throwable -> L12
        r109.flush();     // Catch: Throwable -> L12
        b r110 = new b(true, null);     // Catch: Throwable -> L12
        r109.close();     // Catch: IOException -> L10
    L23:
        JSONObject r111 = new JSONObject();
        eg7.a.c(r111, "file_path", r107);
        JSONObject r112 = new JSONObject();
        r112.put("success", r110.f563479a);     // Catch: JSONException -> L26
    L29:
        if (r110.f563479a == true) goto L31;
        eg7.a.c(r112, "error_msg", r110.f563480b);
    L31:
        t.a("sync_sdk_save_file_monitor", r112, null, r111);
        if (r110.f563479a == false) goto L34;
        return r107;
    L34:
        return null;
    L26:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        Throwable th10 = th;
    L46:
        th10.printStackTrace();     // Catch: Throwable -> L35
        b r113 = new b(false, th10.getClass().toString() + ": " + th10.getMessage());     // Catch: Throwable -> L35
        if (r109 != null) goto L44;
    L22:
        r110 = r113;
        goto L23
    L44:
        r109.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L35:
        th = move-exception;
        if (r109 != null) goto L48;
    L41:
        throw th;
    L48:
        r109.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L14:
        th = move-exception;
        th10 = th;
        r109 = null;
        goto L46
    }
}
