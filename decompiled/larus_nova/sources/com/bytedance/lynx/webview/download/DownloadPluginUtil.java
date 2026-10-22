package com.bytedance.lynx.webview.download;

import com.bytedance.lynx.webview.internal.Setting;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import h17.b;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import l17.e;
import l17.k;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final class DownloadPluginUtil {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicInteger f265100f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f265101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f265102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f265103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f265104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f265105e;

    public static final enum DownloadStatus extends Enum<DownloadStatus> {
        public static final DownloadStatus DOWNLOAD_FINISH = null;
        public static final DownloadStatus DOWNLOAD_NEW = null;
        public static final DownloadStatus DOWNLOAD_PART = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadStatus[] f265106a = null;

        static {
            DownloadStatus r100 = new DownloadStatus("DOWNLOAD_FINISH", 0);
            DOWNLOAD_FINISH = r100;
            DownloadStatus r101 = new DownloadStatus("DOWNLOAD_NEW", 1);
            DOWNLOAD_NEW = r101;
            DownloadStatus r102 = new DownloadStatus("DOWNLOAD_PART", 2);
            DOWNLOAD_PART = r102;
            f265106a = new DownloadStatus[]{r100, r101, r102};
        }

        public static DownloadStatus[] values() {
            return (DownloadStatus[]) f265106a.clone();
        }

        public static DownloadStatus valueOf(String r100) {
            return (DownloadStatus) a.a(DownloadStatus.class, r100);
        }

        public DownloadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean a() {
        this.f265104d = this.f265105e.f483535a.getLong("size", -1);
        int r100 = 1;
        k.d(new String[]{"retryDownload url: " + this.f265101a + " length: " + this.f265104d});
        boolean r101 = false;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L67;
        String r103 = this.f265101a;
        String r104 = this.f265102b;
        long r105 = this.f265104d;
        k.d(new String[]{"downloadWithSingleThread"});
        int r106 = this.f265105e.f483535a.getInt("segNum", -1);
        int r110 = this.f265103c;
        if (r110 <= 0) goto L7;
        long r111 = r105 / ((long) r110);
    L8:
        int r112 = Setting.c().d("sdk_download_segments_size", 0);
        if (r112 <= 0) goto L12;
        if (r112 >= r106) goto L12;
    L13:
        this.f265105e.f483535a.edit().putInt("segNum", r106).apply();
        URL r113 = new URL(r103);     // Catch: Throwable -> L46
        RandomAccessFile r107 = new RandomAccessFile(new PolarisFileWrapper(r104), "rwd");     // Catch: Throwable -> L46
        long r114 = 0;
        int r108 = 0;
    L16:
        if (r108 >= r106) goto L72;
        long r115 = (r114 + r111) - 1;
        if (r108 != (r106 - 1)) goto L20;
        long r210 = r105;
    L82:
        if (this.f265105e.f483535a.getBoolean("segNum_" + r108, false) == true) goto L38;
        boolean r116 = e.b(r113, r114, r210, r107);     // Catch: Throwable -> L39
        this.f265105e.d(r108, r116);     // Catch: Throwable -> L39
        if (r116 == false) goto L32;
        f265100f.getAndIncrement();     // Catch: Throwable -> L39
        r112 = r112 - 1;     // Catch: Throwable -> L39
        if (r112 >= 0) goto L38;
        k.b(new String[]{"doDownloadTasks reach to limit."});     // Catch: Throwable -> L39
        r107.close();     // Catch: IOException -> L30
    L55:
        r101 = false;
    L56:
        if (r101 == true) goto L67;
        r102 = r102 + 1;
        r100 = 1;
    L30:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
        goto L55
    L32:
        k.b(new String[]{"doDownloadTasks download segment failed"});     // Catch: Throwable -> L39
        r107.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L38:
        r114 = r210 + 1;
        r108 = r108 + 1;
        r113 = r113;
    L39:
        th = th;
    L78:
        k.b(new String[]{"doDownloadTasks error : ", th.toString()});     // Catch: Throwable -> L59
        if (r107 == null) goto L55;
        r107.close();     // Catch: IOException -> L53
    L53:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L59:
        th = move-exception;
        if (r107 == null) goto L90;
        r107.close();     // Catch: IOException -> L64
        throw th;
    L64:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
        throw th;
    L90:
        throw th;
    L20:
        r210 = r115;
        goto L82
    L72:
        r107.close();     // Catch: IOException -> L43
    L45:
        r101 = true;
    L43:
        e = move-exception;
        k.b(new String[]{"random file close failed", e.toString()});
    L46:
        th = th;
        r107 = null;
    L12:
        r112 = r106;
        goto L13
    L7:
        r111 = r105;
    L67:
        return r101;
    }

    static {
        Runtime.getRuntime().availableProcessors();
        f265100f = new AtomicInteger(0);
    }

    public DownloadPluginUtil(String r100, String r101, b r102) {
        this.f265103c = 1;
        this.f265101a = r100;
        this.f265102b = r101;
        this.f265105e = r102;
        int r103 = r102.f483535a.getInt("segNum", -1);
        if (r103 <= 0) goto L5;
        this.f265103c = r103;
        return;
    L5:
        int r104 = Math.min(5, 100);
        this.f265103c = r104;
        r102.f483535a.edit().putInt("segNum", r104).apply();
    }
}
