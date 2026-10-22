package lpa;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.loader.FrescoImageLoader;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderCallback;
import com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl;
import com.relax.embedding.LLog;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends ResourceLoaderImpl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f510247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrescoImageLoader f510248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kpa.a f510249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f510250d;

    /* JADX INFO: renamed from: lpa.a$a, reason: collision with other inner class name */
    public class RunnableC6723a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f510251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ResourceLoaderCallback f510252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f510253c;

        public final void a() {
            byte[] r100 = this.f510253c.a(this.f510251a);
            if (r100 != null) goto L5;
        L8:
            c5a.c.c("DefaultResourceLoader", "load async, fail ;");
            this.f510252b.onFailed("read local or asset file fail ");
            return;
        L5:
            if (r100.length == 0) goto L8;
            c5a.c.c("DefaultResourceLoader", "load async, success : len: " + r100.length);
            this.f510252b.onSucceeded(r100);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC6723a(a r100, String r101, ResourceLoaderCallback r102) {
            this.f510253c = r100;
            this.f510251a = r101;
            this.f510252b = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f510254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.lynx.clay.embedding.engine.loader.d f510255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f510256c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f510256c.c(this.f510254a, this.f510255b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, String r101, com.lynx.clay.embedding.engine.loader.d r102) {
            this.f510256c = r100;
            this.f510254a = r101;
            this.f510255b = r102;
        }
    }

    public static class c implements Callable<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f510257a;

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ byte[] call() throws Exception {
            return call2();
        }

        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public byte[] call2() throws Exception {
            return this.f510257a;
        }
    }

    public static class d implements Callable<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f510258a;

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ e call() throws Exception {
            return call2();
        }

        public d() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public e call2() throws Exception {
            return this.f510258a;
        }

        public void setResult(e r100) {
            this.f510258a = r100;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f510259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f510260b;

        public e(String r100, InputStream r101) {
            this.f510259a = r100;
            this.f510260b = r101;
        }
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public final void cancelAll(boolean r100) {
    }

    public a(Context r100) {
        Executor r101 = PThreadExecutorsUtils.newFixedThreadPool(2, new spa.c());     // Catch: Throwable -> L5
    L7:
        this.f510250d = r101;
        this.f510248b = new FrescoImageLoader();
        this.f510247a = r100.getApplicationContext();
        return;
    L5:
        th = move-exception;
        LLog.e("ThreadUtils getExecutor:" + th.toString());
        r101 = new spa.d();
        goto L7
    }

    public static byte[] b(InputStream r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[4096];
    L13:
        int r103 = r100.read(r102, 0, 4096);     // Catch: IOException -> L12
        if (r103 == (-1)) goto L10;
        r101.write(r102, 0, r103);     // Catch: IOException -> L12
        goto L13
    L10:
        return r101.toByteArray();
    L12:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    public final byte[] a(String r100) {
        InputStream r101 = null;
        if (r100.startsWith("asset://") == false) goto L28;
        boolean r102 = r100.startsWith("asset://");
        String r103 = r100;
        if (r102 == false) goto L76;
        String r104 = r100.substring(8);
        boolean r105 = r104.startsWith(HTTP.URL_DEFAULT);
        r103 = r104;
        if (r105 == false) goto L76;
        r103 = r104.substring(1);
    L76:
        r101 = this.f510247a.getResources().getAssets().open(r103);     // Catch: Throwable -> L12 IOException -> L14
        byte[] r106 = b(r101);     // Catch: Throwable -> L12 IOException -> L14
        if (r101 != null) goto L93;
    L20:
        return r106;
    L93:
        r101.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L14:
        r106 = new byte[0];     // Catch: Throwable -> L12
        if (r101 == null) goto L20;
    L12:
        th = move-exception;
        if (r101 != null) goto L84;
    L26:
        throw th;
    L84:
        r101.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L28:
        if (r100.startsWith("content://") == true) goto L82;
        boolean r107 = r100.contains(MSkiaImageRegionDecoder.FILE_PREFIX);
        String r108 = r100;
        if (r107 == false) goto L80;
        r108 = r100.substring(7);
    L80:
        InputStream r109 = new PolarisFileInputStreamWrapper(r108);     // Catch: Throwable -> L60 IOException -> L75
        byte[] r110 = b(r109);     // Catch: Throwable -> L57 IOException -> L59
        r109.close();     // Catch: IOException -> L55
        r108 = r110;
    L90:
    L67:
        return r108;
    L59:
        r101 = r109;
    L57:
        th = th;
    L69:
        if (r109 != null) goto L95;
    L74:
        throw th;
    L95:
        r109.close();     // Catch: IOException -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
    L60:
        th = th;
        r109 = r101;
    L55:
        e = move-exception;
        e.printStackTrace();
    L62:
        r108 = new byte[0];     // Catch: Throwable -> L60
        if (r101 == null) goto L67;
        r101.close();     // Catch: IOException -> L55
        r108 = r108;
        goto L90
    L82:
        r101 = ContentResolverWrapper.openInputStream(this.f510247a.getContentResolver(), UriProtector.parse(r100));     // Catch: Throwable -> L35 Exception -> L37
        byte[] r111 = b(r101);     // Catch: Throwable -> L35 Exception -> L37
        if (r101 != null) goto L78;
    L41:
        return r111;
    L78:
        r101.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L41
    L37:
        r111 = new byte[0];     // Catch: Throwable -> L35
        if (r101 == null) goto L41;
    L35:
        th = move-exception;
        if (r101 != null) goto L87;
    L47:
        throw th;
    L87:
        r101.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L47
    }

    public final void c(String r100, com.lynx.clay.embedding.engine.loader.d r101) {
        InputStream r102 = null;
        if (r100.startsWith("content://") == false) goto L23;
        InputStream r103 = ContentResolverWrapper.openInputStream(this.f510247a.getContentResolver(), UriProtector.parse(r100));     // Catch: Exception -> L13
        if (r103 != null) goto L8;
        c5a.c.c("DefaultResourceLoader", "load content file fail");     // Catch: Exception -> L10
        ((h5a.a) r101).a("read local or asset file fail ");     // Catch: Exception -> L10
        return;
    L8:
        ((h5a.a) r101).b(null, r103);     // Catch: Exception -> L10
        return;
    L10:
        Exception e100 = e;
        r102 = r103;
    L15:
        e100.printStackTrace();
        if (r102 != null) goto L62;
    L21:
        c5a.c.c("DefaultResourceLoader", "load content file fail");
        ((h5a.a) r101).a("read local or asset file fail ");
        return;
    L62:
        r102.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e100 = e;
        goto L15
    L23:
        if (r100.startsWith("asset://") == false) goto L44;
        if (r100.startsWith("asset://") == false) goto L56;
        r100 = r100.substring(8);
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L56;
        r100 = r100.substring(1);
    L56:
        InputStream r104 = this.f510247a.getResources().getAssets().open(r100);     // Catch: Exception -> L34
        ((h5a.a) r101).b(null, r104);     // Catch: Exception -> L32
        return;
    L32:
        Exception e101 = e;
        r102 = r104;
    L36:
        e101.printStackTrace();
        if (r102 != null) goto L54;
    L42:
        c5a.c.c("DefaultResourceLoader", "load file fail");
        ((h5a.a) r101).a("read local or asset file fail ");
        return;
    L54:
        r102.close();     // Catch: IOException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
    L34:
        e = move-exception;
        e101 = e;
        goto L36
    L44:
        if (r100.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L60;
        r100 = r100.substring(7);
    L60:
    L50:
        e = move-exception;
        e.printStackTrace();
    L52:
        c5a.c.c("DefaultResourceLoader", "load file fail");
        ((h5a.a) r101).a("read local or asset file fail ");
        return;
    L47:
        if (new PolarisFileWrapper(r100).exists() == false) goto L52;
        c5a.c.c("DefaultResourceLoader", "load file success");     // Catch: Exception -> L50
        ((h5a.a) r101).b(r100, null);     // Catch: Exception -> L50
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public final void loadAsFile(String r110, com.lynx.clay.embedding.engine.loader.d r111, boolean r112) {
        c5a.c.c("DefaultResourceLoader", "load " + r110);
        kpa.a r100 = this.f510249c;
        if (r100 == null) goto L5;
        String r101 = r100.a(r110);
        c5a.c.c("DefaultResourceLoader", "call redirect, new url is : " + r110);
        String r102 = r101;
    L7:
        if (r102.startsWith("http") == false) goto L9;
        d r103 = new d();
        this.f510250d.execute(new lpa.c(this, r112, new FutureTask(r103), r111, r103, r102));
        return;
    L9:
        if (r112 == false) goto L11;
        c(r102, r111);
        return;
    L11:
        this.f510250d.execute(new b(this, r102, r111));
        return;
    L5:
        r102 = r110;
        goto L7
    }

    @Override // com.lynx.clay.embedding.engine.loader.ResourceLoaderImpl.b
    public final void load(int r110, String r111, ResourceLoaderCallback r112, boolean r113, boolean r114) {
        c5a.c.c("DefaultResourceLoader", "load " + r111 + " type=" + r110 + " needRedirect=" + r114);
        if (r114 == false) goto L7;
        kpa.a r100 = this.f510249c;
        if (r100 == null) goto L7;
        r111 = r100.a(r111);
        c5a.c.c("DefaultResourceLoader", "call redirect, new url is : " + r111);
    L7:
        String r101 = r111;
        if (r101.startsWith("http") == false) goto L30;
        if (r110 != 0) goto L13;
        FrescoImageLoader r102 = this.f510248b;
        if (r102 == null) goto L13;
        r102.load(r110, r101, r112, r113, r114);
        return;
    L13:
        HashMap r103 = new HashMap();
        r103.put("lynx_need_redirect", String.valueOf(r114));
        c r104 = new c();
        FutureTask r115 = new FutureTask(r104);
        this.f510250d.execute(new lpa.b(this, r101, r103, r113, r104, r115, r112));
        if (r113 == false) goto L43;
        c5a.c.d(5, "DefaultResourceLoader", "warning : maybe android.os.NetworkOnMainThreadException . Call async instead.");
        byte[] r116 = (byte[]) r115.get(5, TimeUnit.SECONDS);     // Catch: Throwable -> L18 InterruptedException -> L20 ExecutionException -> L22
    L24:
        if (r116 != null) goto L26;
    L29:
        c5a.c.d(5, "DefaultResourceLoader", "load sync, fail");
        r112.onFailed("Can't get get meaningful response");
        return;
    L26:
        if (r116.length == 0) goto L29;
        c5a.c.c("DefaultResourceLoader", "load sync, success : len: " + r116.length);
        r112.onSucceeded(r116);
        return;
    L18:
        e = move-exception;
        r112.onFailed("load network fail");
        e.printStackTrace();
        r116 = null;
        goto L24
    L43:
        return;
    L30:
        if (r113 == false) goto L38;
        byte[] r117 = a(r101);
        if (r117 != null) goto L34;
    L37:
        c5a.c.c("DefaultResourceLoader", "load sync , fail ;");
        r112.onFailed("read local or asset file fail ");
        return;
    L34:
        if (r117.length == 0) goto L37;
        c5a.c.c("DefaultResourceLoader", "load sync, success : len: " + r117.length);
        r112.onSucceeded(r117);
        return;
    L38:
        this.f510250d.execute(new RunnableC6723a(this, r101, r112));
    }
}
