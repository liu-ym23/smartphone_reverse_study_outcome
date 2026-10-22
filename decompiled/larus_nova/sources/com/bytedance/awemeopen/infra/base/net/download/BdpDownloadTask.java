package com.bytedance.awemeopen.infra.base.net.download;

import android.content.Context;
import com.alipay.sdk.m.p.e;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.net.AoNetworkEventHelper;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.util.f;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import q64.c;
import q64.d;

/* JADX INFO: loaded from: classes46.dex */
public final class BdpDownloadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f198693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f198694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AoDownloadRequest f198695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AoDownloadCallback f198696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f198697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f198698f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        AoLogger.g("BdpDownloadTask", new Object[]{"execute", this.f198695c});
        AoDownloadCallback r100 = this.f198696d;
        if (r100 == null) goto L5;
        r100.onStart(this.f198693a);
    L5:
        PolarisFileOutputStreamWrapper r101 = null;
        if (this.f198697e.compareAndSet(1, 2) == true) goto L9;
        b(-201, "task is finished", null, null);
        return;
    L9:
        File r110 = this.f198695c.getTargetFile();
        if (r110 != null) goto L13;
        AoLogger.g("BdpDownloadTask", new Object[]{"target file is null"});
        b(-100, "target file is null", null, null);
        return;
    L13:
        Function0<String> r102 = AoNet.f198669a;
        AoDownloadRequest r103 = this.f198695c;
        String r104 = r103.getUrl();
        AoFromSource r105 = AoFromSource.download;
        Intrinsics.checkNotNullParameter(r104, "httpUrl");
        Intrinsics.checkNotNullParameter(r105, "fromSource");
        new ArrayList();
        AoRequestType.a r106 = AoRequestType.Companion;
        HashMap r107 = new HashMap();
        AoRequestType r108 = r103.getRequestLibType();
        Intrinsics.checkNotNullParameter(r108, "libType");
        boolean r210 = r103.getAddBdpCommonParams();
        boolean r111 = r103.getAddHostCommonParams();
        boolean r112 = r103.getAddHostSecurityParams();
        long r211 = r103.getTimeout();
        long r212 = r103.getTimeout();
        long r310 = r103.getTimeout();
        c r109 = r103.getHeaders();
        Intrinsics.checkNotNullParameter(r109, "headers");
        Intrinsics.checkNotNullParameter(r109, "headers");
        ArrayList r113 = new ArrayList(r109.f531790a);
        d r213 = r103.getBody();
        Intrinsics.checkNotNullParameter("GET", e.f25671s);
        AoNetResponse r114 = AoNet.d(new AoNetRequest(r104, "GET", r105, true, r112, r111, false, r210, new c(r113), true, r108, r213, r211, r212, r310, true, null, r103.getEnableHttp2(), r107)).execute();
        if (r114.getThrowable() == null) goto L18;
        b(r114.getCode(), r114.getMessage(), r114, r114.getThrowable());
        return;
    L18:
        if (this.f198695c.getVerifyHttpCode() == true) goto L20;
    L23:
        q64.e r115 = r114.getBody();
        if (r115 != null) goto L28;
        AoLogger.c("BdpDownloadTask", new Object[]{"responseBody is null"});
        b(-105, "response has no body", r114, null);
        return;
    L28:
        if (this.f198695c.getMaxLength() <= 0) goto L160;
        if (r114.contentLength() <= this.f198695c.getMaxLength()) goto L160;
        b(-202, "response body exceed max size " + this.f198695c.getMaxLength(), r114, null);
        return;
    L160:
        PolarisFileWrapper r116 = new PolarisFileWrapper(this.f198694b.getCacheDir(), "bdp/download/" + System.currentTimeMillis() + '_' + this.f198693a + DefaultDiskStorage.FileType.TEMP);     // Catch: Exception -> L45
        File r117 = r116.getParentFile();     // Catch: Exception -> L45
        if (r117 != null) goto L37;
    L39:
        boolean r118 = false;
    L40:
        if (r118 == false) goto L44;
        File r119 = r116.getParentFile();     // Catch: Exception -> L45
        if (r119 == null) goto L44;
        r119.mkdirs();     // Catch: Exception -> L45
    L44:
        PolarisFileWrapper r120 = r116;
    L47:
        int r121 = -1;
        if (r120 != null) goto L51;
        AoLogger.c("BdpDownloadTask", new Object[]{"createTempFile is null"});
        b(-1, "create temp file failed", r114, null);
        return;
    L51:
        long r122 = r115.b();
        byte[] r123 = new byte[2048];
        long r124 = 0;
        PolarisFileOutputStreamWrapper r125 = new PolarisFileOutputStreamWrapper(r120);     // Catch: Throwable -> L135
        AoDownloadCallback r126 = this.f198696d;     // Catch: Throwable -> L132
        if (r126 != null) goto L158;
        PolarisFileWrapper r214 = r120;
        String r215 = "BdpDownloadTask";
        PolarisFileOutputStreamWrapper r127 = r125;
    L61:
        int r128 = r115.read(r123);     // Catch: Throwable -> L130
        if (r128 <= 0) goto L77;
        r127.write(r123, 0, r128);     // Catch: Throwable -> L130
        r127.flush();     // Catch: Throwable -> L130
        r124 = r124 + ((long) r128);     // Catch: Throwable -> L130
        AoDownloadCallback r129 = this.f198696d;     // Catch: Throwable -> L130
        if (r129 == null) goto L66;
        d(r129, this.f198693a, r124, r122);     // Catch: Throwable -> L130
    L66:
        long r130 = this.f198695c.getMaxLength();     // Catch: Throwable -> L130
        if (1 <= r130) goto L69;
    L71:
        boolean r131 = false;
    L72:
        if (r131 == false) goto L61;
        f.delete(r214);     // Catch: Throwable -> L130
        b(-202, "response body exceed max size " + this.f198695c.getMaxLength(), r114, null);     // Catch: Throwable -> L130
        f.a(r127);
        f.a(r115);
        return;
    L130:
        th = th;
    L76:
        PolarisFileWrapper r132 = r214;
        String r133 = r215;
    L134:
        r121 = -1;
        r101 = r127;
    L162:
        AoLogger.c(r133, new Object[]{th});     // Catch: Throwable -> L144
        f.delete(r132);     // Catch: Throwable -> L144
        String r134 = th.getMessage();     // Catch: Throwable -> L144
        if (r134 != null) goto L141;
        r134 = LynxError.LYNX_THROWABLE;
    L141:
        b(r121, r134, r114, th);     // Catch: Throwable -> L144
        f.a(r101);
        f.a(r115);
        return;
    L144:
        th = move-exception;
        f.a(r101);
        f.a(r115);
        throw th;
    L69:
        if (r130 >= r124) goto L71;
        r131 = true;
        goto L72
    L77:
        f.a(r127);
        f.a(r115);
        String r135 = this.f198695c.getMd5();
        if (r135 != null) goto L80;
    L86:
        boolean r136 = false;
    L87:
        if (r136 == true) goto L156;
        PolarisFileWrapper r137 = r214;
    L166:
        File r138 = r110.getParentFile();     // Catch: Throwable -> L127
        if (r138 == null) goto L116;
        r138.mkdirs();     // Catch: Throwable -> L127
    L116:
        if (r110.exists() == false) goto L119;
        r110.delete();     // Catch: Throwable -> L127
    L119:
        if (r137.exists() == true) goto L121;
        AoLogger.c(r215, new Object[]{"temp file not exist", r137, r110});     // Catch: Throwable -> L127
        b(-1, "temp file not exist", r114, null);     // Catch: Throwable -> L127
    L125:
        f.delete(r137);
        return;
    L121:
        String r139 = r215;
        if (c(r137, r110) == true) goto L124;
        AoLogger.c(r139, new Object[]{"move file failed", r137, Long.valueOf(r137.length()), r110});     // Catch: Throwable -> L127
        b(-1, "move target file failed", r114, null);     // Catch: Throwable -> L127
        goto L125
    L124:
        e(r110, r114);     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        f.delete(r137);
        throw th;
    L156:
        MessageDigest r140 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L104
        r137 = r214;
        PolarisFileInputStreamWrapper r141 = new PolarisFileInputStreamWrapper(r137);     // Catch: FileNotFoundException -> L147
        byte[] r142 = new byte[8192];
    L150:
        int r143 = r141.read(r142);     // Catch: Throwable -> L97 IOException -> L99
        if (r143 <= 0) goto L95;
        r140.update(r142, 0, r143);     // Catch: Throwable -> L97 IOException -> L99
        goto L150
    L95:
        String r144 = String.format("%32s", new Object[]{new BigInteger(1, r140.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L97 IOException -> L99
        f.a(r141);
    L107:
        if (Intrinsics.areEqual(r144, this.f198695c.getMd5()) == true) goto L166;
        f.delete(r137);
        b(-1, "md5 verify failed", r114, null);
        return;
    L97:
        th = move-exception;
        f.a(r141);
        throw th;
    L99:
        e = move-exception;
        throw new RuntimeException("Unable to process MD5", e);     // Catch: Throwable -> L97
    L105:
        r144 = null;
    L104:
        r137 = r214;
        goto L105
    L80:
        if (r135.length() <= 0) goto L82;
        boolean r145 = true;
    L84:
        if (r145 != true) goto L86;
        r136 = true;
        goto L87
    L82:
        r145 = false;
        goto L84
    L158:
        r214 = r120;
        r215 = "BdpDownloadTask";
        r127 = r125;
        d(r126, this.f198693a, 0, r122);     // Catch: Throwable -> L130
    L58:
        th = th;
        r214 = r120;
        r215 = "BdpDownloadTask";
        r127 = r125;
    L132:
        th = th;
        r132 = r120;
        r133 = "BdpDownloadTask";
        r127 = r125;
    L135:
        th = th;
        r132 = r120;
        r133 = "BdpDownloadTask";
        goto L162
    L37:
        if (r117.exists() == true) goto L39;
        r118 = true;
    L45:
        e = move-exception;
        AoLogger.c("BdpDownloadTask", new Object[]{"createTempFile", e});
        r120 = null;
        goto L47
    L20:
        if (r114.isSuccessful() == true) goto L23;
        b(r114.getCode(), r114.getMessage(), r114, null);
    }

    public static boolean c(PolarisFileWrapper r100, File r101) {
        if (r100.renameTo(r101) == false) goto L5;
        return true;
    L5:
        char r102 = 2;
        AoLogger.g("BdpDownloadTask", new Object[]{"copy", r100, r101});
        File r103 = r101.getParentFile();
        if (r103 != null) goto L8;
    L10:
        Closeable r104 = null;
    L37:
        Closeable r105 = null;
    L38:
        f.a(r104);
        f.a(r105);
        r102 = 1;
    L39:
        if (r102 == 0) goto L52;
        return false;
    L52:
        return true;
    L35:
        Closeable r106 = null;
    L36:
        f.a(r104);
        f.a(r106);
    L31:
        th = th;
        Closeable r107 = null;
    L33:
        f.a(r104);
        f.a(r107);
        throw th;
    L12:
        if (r101.exists() == true) goto L14;
        r101.createNewFile();     // Catch: Throwable -> L31 IOException -> L35 FileNotFoundException -> L37
    L14:
        PolarisFileInputStreamWrapper r108 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L31 IOException -> L35 FileNotFoundException -> L37
    L47:
        PolarisFileOutputStreamWrapper r109 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L27 IOException -> L43 FileNotFoundException -> L44
    L49:
        byte[] r110 = new byte[4096];     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
    L18:
        int r111 = r108.read(r110);     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
        if (r111 <= 0) goto L21;
        r109.write(r110, 0, r111);     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
        goto L18
    L21:
        r100.delete();     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L26
        f.a(r108);
        f.a(r109);
        r102 = 0;
        goto L39
    L26:
        r104 = r109;
    L25:
        r104 = r109;
    L23:
        th = th;
        r104 = r109;
    L28:
        r107 = r104;
        r104 = r108;
    L27:
        th = th;
    L30:
        r105 = r104;
        r104 = r108;
    L29:
        r106 = r104;
        r104 = r108;
        goto L36
    L8:
        if (r103.exists() == true) goto L10;
        r103.mkdirs();
        goto L10
    }

    public final AoDownloadResponse e(File r110, AoNetResponse r111) {
        AoLogger.g("BdpDownloadTask", new Object[]{"success", r110, r111, this.f198697e});
        AoDownloadResponse r100 = new AoDownloadResponse(r111.getCode(), r111.getMessage(), r110, r111.getHeaders(), r111.contentLength(), r111.getThrowable(), r111.getLibType(), r111.getMetric());
        if (this.f198697e.compareAndSet(2, 3) == false) goto L8;
        AoDownloadCallback r101 = this.f198696d;
        if (r101 == null) goto L12;
        r101.onFinish(this.f198693a, this.f198695c, r100);
    L12:
        AoNetworkEventHelper.INSTANCE.mpDownloadMonitor(this.f198695c, r100, this.f198697e.get());
        return r100;
    L8:
        if (this.f198697e.get() != 4) goto L12;
        AoDownloadCallback r102 = this.f198696d;
        if (r102 == null) goto L12;
        r102.onCancel(this.f198693a, this.f198695c);
        goto L12
    }

    public BdpDownloadTask(int r100, Context r101, AoDownloadRequest r102, AoDownloadCallback r103) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "downloadRequest");
        this.f198693a = r100;
        this.f198694b = r101;
        this.f198695c = r102;
        this.f198696d = r103;
        this.f198697e = new AtomicInteger(1);
    }

    public final AoDownloadResponse b(int r110, String r111, AoNetResponse r112, Throwable r113) {
        AoLogger.g("BdpDownloadTask", new Object[]{"failed", Integer.valueOf(r110), r111, r112, r113, this.f198697e});
        if (r112 == null) goto L6;
        c r100 = r112.getHeaders();
        if (r100 == null) goto L6;
    L7:
        c r101 = r100;
        if (r112 == null) goto L10;
        long r102 = r112.contentLength();
    L11:
        long r103 = r102;
        if (r113 != null) goto L19;
        if (r112 == null) goto L15;
        Throwable r104 = r112.getThrowable();
    L16:
        if (r104 != null) goto L18;
        r104 = new Exception(r111);
    L18:
        Throwable r105 = r104;
    L20:
        AoRequestType r106 = this.f198695c.getRequestLibType();
        if (r112 == null) goto L24;
        AoNetworkMetric r107 = r112.getMetric();
        if (r107 == null) goto L24;
    L25:
        AoDownloadResponse r114 = new AoDownloadResponse(r110, r111, null, r101, r103, r105, r106, r107);
        if (this.f198697e.compareAndSet(2, 3) == false) goto L31;
        AoDownloadCallback r108 = this.f198696d;
        if (r108 == null) goto L35;
        r108.onFinish(this.f198693a, this.f198695c, r114);
    L35:
        AoNetworkEventHelper.INSTANCE.mpDownloadMonitor(this.f198695c, r114, this.f198697e.get());
        return r114;
    L31:
        if (this.f198697e.get() != 4) goto L35;
        AoDownloadCallback r109 = this.f198696d;
        if (r109 == null) goto L35;
        r109.onCancel(this.f198693a, this.f198695c);
    L24:
        r107 = new AoNetworkMetric();
        goto L25
    L15:
        r104 = null;
        goto L16
    L19:
        r105 = r113;
        goto L20
    L10:
        r102 = 0;
    L6:
        r100 = c.f531789b;
        goto L7
    }

    public final void d(final AoDownloadCallback r110, final int r111, final long r112, final long r113) {
        if (this.f198697e.get() == 2) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - this.f198698f) >= 100) goto L8;
        return;
    L8:
        this.f198698f = System.currentTimeMillis();
        AoPool.b(new BdpDownloadTask$progress$1(this, r110, r111, r112, r113));
    }
}
