package l17;

import android.util.SparseArray;
import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.lynx.webview.internal.c0;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f506997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f506998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f506999c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f507000d = null;

    public static class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f507001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RandomAccessFile f507002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f507003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f507004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f507005e;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            c0 r100 = TTWebContext.h().p();     // Catch: Throwable -> L6 Exception -> L14
            r100.s(this.f507001a.toString(), this.f507003c, false);     // Catch: Throwable -> L6 Exception -> L14
            boolean r101 = e.b(this.f507001a, this.f507004d, this.f507005e, this.f507002b);     // Catch: Throwable -> L6 Exception -> L14
            if (r101 == false) goto L8;
            e.f507000d.getAndIncrement();     // Catch: Throwable -> L6 Exception -> L14
        L8:
            r100.s(this.f507001a.toString(), this.f507003c, r101);     // Catch: Throwable -> L6 Exception -> L14
            Boolean r102 = Boolean.valueOf(r101);     // Catch: Throwable -> L6 Exception -> L14
            this.f507002b.close();     // Catch: IOException -> L11
        L13:
            return r102;
        L11:
            e = move-exception;
            k.b(new String[]{"random file close failed", e.toString()});
            goto L13
        L6:
            th = move-exception;
            this.f507002b.close();     // Catch: IOException -> L23
        L25:
            throw th;
        L23:
            e = move-exception;
            k.b(new String[]{"random file close failed", e.toString()});
        L14:
            e = move-exception;
            k.b(new String[]{"call doDownload error=", e.toString()});     // Catch: Throwable -> L6
            Boolean r103 = Boolean.FALSE;     // Catch: Throwable -> L6
            this.f507002b.close();     // Catch: IOException -> L18
        L20:
            return r103;
        L18:
            e = move-exception;
            k.b(new String[]{"random file close failed", e.toString()});
            goto L20
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() throws Exception {
            return call();
        }

        public a(URL r100, String r101, int r102, long r103, long r104) throws FileNotFoundException {
            this.f507001a = r100;
            this.f507002b = new RandomAccessFile(new PolarisFileWrapper(r101), "rwd");
            this.f507003c = r102;
            this.f507004d = r103;
            this.f507005e = r104;
        }
    }

    static {
        f506997a = new AtomicLong(0);
        f506998b = -1;
        f506999c = Runtime.getRuntime().availableProcessors() + 1;
        f507000d = new AtomicInteger(0);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
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

    public static boolean e(String r100) {
        c0 r101 = TTWebContext.h().p();
        Setting.c().b("sdk_use_app_download_handler", false);
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L16
        if (r101.f265273b.getLong(r100 + "_downloadSize", -1) > 0) goto L8;
        return false;
    L8:
        int r102 = r101.d();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        if (r101.i(r100, r103) == false) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public static boolean c(String r110, String r111) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r111);
        c0 r101 = TTWebContext.h().p();
        long r102 = r101.f265273b.getLong(r110 + "_downloadSize", -1);
        int r103 = r101.d();
        int r104 = Setting.c().d("sdk_download_seg_num", 10);
        if (r100.exists() == true) goto L5;
    L11:
        r101.b("clearUrl", r101.d());
        if (r103 == r104) goto L14;
        r101.f265273b.edit().putInt("download_seg_num", r104).apply();
    L14:
        c0 r105 = TTWebContext.h().p();
        r105.b(r110, r105.d());
        f506997a.set(0);
        StringBuffer r106 = b.f506991a;
        long r107 = d(r110, r111);
        r.d("[Download] download length:" + r107);
        if (r107 > 0) goto L17;
        r.b("[Download] DownloadUtil error. length:" + r107);
        return false;
    L17:
        r105.f265273b.edit().putLong(r110 + "_downloadSize", r107).apply();
        return f(r110, r111, r107);
    L5:
        if (r101.f265273b.getStringSet("downloadUrls", new HashSet()).contains(r110) == false) goto L11;
        if (r102 <= 0) goto L11;
        if (r103 != r104) goto L11;
        r101.f265273b.getString("download_seg_list", "");
        StringBuffer r108 = b.f506991a;
        return f(r110, r111, r102);
    }

    public static long d(String r110, String r111) {
        HttpURLConnection r100 = null;
        HttpURLConnection r101 = (HttpURLConnection) a(new URL(r110));     // Catch: Throwable -> L32 Exception -> L34
    L66:
        r101.setConnectTimeout(5000);     // Catch: Throwable -> L26 Exception -> L29
        r101.setRequestMethod("HEAD");     // Catch: Throwable -> L26 Exception -> L29
        if (r101.getResponseCode() == 200) goto L8;
        long r102 = -1;
    L11:
        if (r102 > 0) goto L14;
        r101.disconnect();
        return 0;
    L14:
        RandomAccessFile r103 = new RandomAccessFile(new PolarisFileWrapper(r111), "rwd");     // Catch: Throwable -> L26 Exception -> L29
        r103.setLength(r102);     // Catch: Throwable -> L22 Exception -> L24
        r101.disconnect();
        r103.close();     // Catch: IOException -> L19
    L21:
        return r102;
    L19:
        e = move-exception;
        r.c("[Download] fileclose failed.", e);
        goto L21
    L24:
        e = e;
    L31:
        r100 = r101;
    L54:
        r.c("[Download] getLength failed! url:" + r110 + " dest:" + r111 + "\n", e);     // Catch: Throwable -> L45
        e.printStackTrace();     // Catch: Throwable -> L45
        if (r100 == null) goto L44;
        r100.disconnect();
        if (r103 == null) goto L44;
        r103.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        r.c("[Download] fileclose failed.", e);
    L44:
        return -1;
    L45:
        th = th;
    L46:
        if (r100 == null) goto L53;
        r100.disconnect();
        if (r103 == null) goto L53;
        r103.close();     // Catch: IOException -> L51
    L51:
        e = move-exception;
        r.c("[Download] fileclose failed.", e);
    L53:
        throw th;
    L22:
        th = th;
    L28:
        r100 = r101;
        goto L46
    L8:
        r102 = r101.getContentLength();     // Catch: Throwable -> L26 Exception -> L29
    L29:
        e = e;
        r103 = null;
    L26:
        th = th;
        r103 = null;
    L34:
        e = e;
        r103 = null;
    L32:
        th = th;
        r103 = null;
        goto L46
    }

    public static boolean f(String r310, String r311, long r312) {
        int r100 = 0;
        boolean r101 = Setting.c().b("sdk_disable_download_thread_pool", false);
        int r102 = Setting.c().d("sdk_download_retry_times", 0);
        int r103 = 3;
        if (r102 <= 0) goto L6;
        if (r102 >= 3) goto L6;
        r103 = r102;
    L6:
        f506998b = r312;
        TTWebContext.j().c(0, f506998b);
        boolean r104 = false;
        int r105 = 0;
    L7:
        if (r104 == true) goto L158;
        if (r105 >= r103) goto L158;
        if (r101 == false) goto L75;
        c0 r106 = TTWebContext.h().p();
        int r110 = r106.d();
        int r111 = Setting.c().d("sdk_download_segments_size", r100);
        long r107 = (long) Math.floor(r312 / ((long) r110));
        if (r111 <= 0) goto L14;
        if (r111 >= r110) goto L14;
    L171:
        URL r112 = new URL(r310);     // Catch: Throwable -> L55
        RandomAccessFile r108 = new RandomAccessFile(new PolarisFileWrapper(r311), "rwd");     // Catch: Throwable -> L53
        int r109 = 0;
        long r113 = 0;
    L19:
        if (r109 >= r110) goto L47;
        long r114 = (r113 + r107) - 1;
        boolean r313 = r101;
        if (r109 != (r110 - 1)) goto L167;
        r114 = r312;
    L167:
    L45:
        th = th;
        int r314 = r103;
    L159:
        k.b(new String[]{"doDownloadTasks error : ", th.toString()});     // Catch: Throwable -> L67
        if (r108 != null) goto L181;
    L65:
        boolean r115 = false;
    L66:
        r104 = r115;
    L148:
        r105 = r105 + 1;
        r101 = r313;
        r103 = r314;
        r100 = 0;
        goto L7
    L181:
        r108.close();     // Catch: IOException -> L63
    L63:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L67:
        th = move-exception;
        if (r108 == null) goto L208;
        r108.close();     // Catch: IOException -> L72
        throw th;
    L72:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
        throw th;
    L208:
        throw th;
    L24:
        if (r106.i(r310, r109) == true) goto L43;
        r314 = r103;
        r106.s(r112.toString(), r109, false);     // Catch: Throwable -> L41
        boolean r116 = b(r112, r113, r114, r108);     // Catch: Throwable -> L41
        r106.s(r112.toString(), r109, r116);     // Catch: Throwable -> L41
        if (r116 == false) goto L36;
        f507000d.getAndIncrement();     // Catch: Throwable -> L41
        r111 = r111 - 1;     // Catch: Throwable -> L41
        if (r111 > 0) goto L44;
        k.b(new String[]{"doDownloadTasks reach to limit."});     // Catch: Throwable -> L41
        r108.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L44:
        r109 = r109 + 1;
        r113 = r114 + 1;
        r101 = r313;
        r103 = r314;
        goto L19
    L36:
        k.b(new String[]{"doDownloadTasks download segment failed"});     // Catch: Throwable -> L41
        f507000d.get();     // Catch: Throwable -> L41
        StringBuffer r117 = b.f506991a;     // Catch: Throwable -> L41
        r108.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L41:
        th = th;
        goto L159
    L43:
        r314 = r103;
        goto L44
    L47:
        r313 = r101;
        r314 = r103;
        r108.close();     // Catch: IOException -> L50
    L52:
        r115 = true;
    L50:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L53:
        th = th;
    L57:
        r313 = r101;
        r314 = r103;
        r108 = null;
    L55:
        th = th;
    L14:
        r111 = r110;
        goto L171
    L75:
        r313 = r101;
        r314 = r103;
        ExecutorService r118 = PThreadExecutorsUtils.newFixedThreadPool(f506999c, new DefaultThreadFactory("DownloadUtils"));
        c0 r119 = TTWebContext.h().p();
        int r120 = r119.d();
        long r121 = (long) Math.floor(r312 / ((long) r120));
        URL r122 = new URL(r310);     // Catch: Throwable -> L98 TimeoutException -> L100 ExecutionException -> L108 InterruptedException -> L118 FileNotFoundException -> L126 MalformedURLException -> L136
        SparseArray r123 = new SparseArray();     // Catch: Throwable -> L98 TimeoutException -> L100 ExecutionException -> L108 InterruptedException -> L118 FileNotFoundException -> L126 MalformedURLException -> L136
        int r124 = 0;
        long r210 = 0;
    L77:
        if (r124 >= r120) goto L85;
        long r125 = (r210 + r121) - 1;     // Catch: Throwable -> L98 TimeoutException -> L100 ExecutionException -> L108 InterruptedException -> L118 FileNotFoundException -> L126 MalformedURLException -> L136
        if (r124 != (r120 - 1)) goto L82;
        r125 = r312;
    L82:
        if (r119.i(r310, r124) == true) goto L84;
        r123.put(r124, r118.submit(new a(r122, r311, r124, r210, r125)));     // Catch: Throwable -> L98 TimeoutException -> L100 ExecutionException -> L108 InterruptedException -> L118 FileNotFoundException -> L126 MalformedURLException -> L136
    L84:
        r210 = r125 + 1;     // Catch: Throwable -> L98 TimeoutException -> L100 ExecutionException -> L108 InterruptedException -> L118 FileNotFoundException -> L126 MalformedURLException -> L136
        r124 = r124 + 1;     // Catch: Throwable -> L98 TimeoutException -> L100 ExecutionException -> L108 InterruptedException -> L118 FileNotFoundException -> L126 MalformedURLException -> L136
        goto L77
    L85:
        int r126 = 0;
        boolean r127 = true;
    L87:
        if (r126 >= r123.size()) goto L90;
        r127 = r127 & ((Boolean) ((Future) r123.valueAt(r126)).get(60, TimeUnit.SECONDS)).booleanValue();
        r126 = r126 + 1;
        goto L87
    L90:
        if (r118 != null) goto L187;
    L97:
        f507000d.get();
        StringBuffer r128 = b.f506991a;
    L147:
        r104 = r127;
        goto L148
    L187:
        r118.shutdown();     // Catch: Throwable -> L95
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L97;
        r118.shutdownNow();     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
        goto L97
    L98:
        th = move-exception;
        if (r118 != null) goto L163;
    L156:
        f507000d.get();
        StringBuffer r129 = b.f506991a;
        throw th;
    L163:
        r118.shutdown();     // Catch: Throwable -> L154
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L156;
        r118.shutdownNow();     // Catch: Throwable -> L154
    L154:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
    L126:
        e = move-exception;
        k.b(new String[]{"download file not found", e.toString()});     // Catch: Throwable -> L98
        if (r118 != null) goto L183;
    L146:
        f507000d.get();
        StringBuffer r130 = b.f506991a;
        r127 = false;
        goto L147
    L183:
        r118.shutdown();     // Catch: Throwable -> L134
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L146;
        r118.shutdownNow();     // Catch: Throwable -> L134
    L134:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
    L136:
        e = move-exception;
        k.b(new String[]{"download url error", e.toString()});     // Catch: Throwable -> L98
        if (r118 == null) goto L146;
        r118.shutdown();     // Catch: Throwable -> L144
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L146;
        r118.shutdownNow();     // Catch: Throwable -> L144
    L144:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
    L108:
        e = move-exception;
        k.b(new String[]{"download execute error", e.toString()});     // Catch: Throwable -> L98
        if (r118 == null) goto L146;
        r118.shutdown();     // Catch: Throwable -> L116
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L146;
        r118.shutdownNow();     // Catch: Throwable -> L116
    L116:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
    L118:
        k.b(new String[]{"download is interrupted"});     // Catch: Throwable -> L98
        if (r118 == null) goto L146;
        r118.shutdown();     // Catch: Throwable -> L124
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L146;
        r118.shutdownNow();     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
    L100:
        k.b(new String[]{"download seg timeout"});     // Catch: Throwable -> L98
        if (r118 == null) goto L146;
        r118.shutdown();     // Catch: Throwable -> L106
        if (r118.awaitTermination(60, TimeUnit.SECONDS) == true) goto L146;
        r118.shutdownNow();     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        k.b(new String[]{"close threadPool error", th.toString()});
    L158:
        return r104;
    }

    public static boolean b(URL r100, long r110, long r111, RandomAccessFile r112) {
        HttpURLConnection r101 = null;
        ReadableByteChannel r102 = null;
        r102 = null;
        r102 = null;
        r101 = null;
        HttpURLConnection r103 = (HttpURLConnection) a(r100);     // Catch: Throwable -> L23 Exception -> L25
    L53:
        r103.setConnectTimeout(10000);     // Catch: Throwable -> L19 Exception -> L21
        r103.setRequestMethod("GET");     // Catch: Throwable -> L19 Exception -> L21
        r103.setRequestProperty("Range", "bytes=" + r110 + "-" + r111);     // Catch: Throwable -> L19 Exception -> L21
        r112.seek(r110);     // Catch: Throwable -> L19 Exception -> L21
        if (r103.getResponseCode() != 206) goto L12;
        r102 = Channels.newChannel(r103.getInputStream());     // Catch: Throwable -> L19 Exception -> L21
        ByteBuffer r113 = ByteBuffer.allocate(4096);     // Catch: Throwable -> L19 Exception -> L21
    L9:
        if (r102.read(r113) == (-1)) goto L11;
        r113.flip();     // Catch: Throwable -> L19 Exception -> L21
        f506997a.addAndGet(r113.limit());     // Catch: Throwable -> L19 Exception -> L21
        r112.getChannel().write(r113);     // Catch: Throwable -> L19 Exception -> L21
        r113.clear();     // Catch: Throwable -> L19 Exception -> L21
        goto L9
    L11:
        TTWebContext.j().c(f506997a.get(), f506998b);     // Catch: Throwable -> L19 Exception -> L21
    L12:
        r103.disconnect();
        if (r102 != null) goto L47;
    L18:
        return true;
    L47:
        r102.close();     // Catch: IOException -> L16
    L16:
        e = move-exception;
        k.b(new String[]{"ReadableByteChannel close failed", e.toString()});
    L21:
        Exception e100 = e;
        ReadableByteChannel r104 = r102;
        r101 = r103;
        ReadableByteChannel r105 = r104;
    L49:
        k.b(new String[]{"doDownload error=", e100.toString()});     // Catch: Throwable -> L36
        if (r101 == null) goto L30;
        r101.disconnect();
    L30:
        if (r105 != null) goto L51;
    L35:
        return false;
    L51:
        r105.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        k.b(new String[]{"ReadableByteChannel close failed", e.toString()});
    L36:
        Throwable th10 = th;
    L37:
        if (r101 == null) goto L39;
        r101.disconnect();
    L39:
        if (r105 != null) goto L45;
    L44:
        throw th10;
    L45:
        r105.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        k.b(new String[]{"ReadableByteChannel close failed", e.toString()});
    L19:
        th10 = th;
        ReadableByteChannel r106 = r102;
        r101 = r103;
        r105 = r106;
    L25:
        e = move-exception;
        e100 = e;
        r105 = null;
    L23:
        th = move-exception;
        th10 = th;
        r105 = null;
        goto L37
    }
}
