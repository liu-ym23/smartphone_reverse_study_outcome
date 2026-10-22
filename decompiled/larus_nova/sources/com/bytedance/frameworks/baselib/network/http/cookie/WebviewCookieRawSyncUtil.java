package com.bytedance.frameworks.baselib.network.http.cookie;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WebviewCookieRawSyncUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f244686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f244687b = null;

    public static final enum SyncResult extends Enum<SyncResult> {
        public static final SyncResult EMPTY_COOKIE_DB = null;
        public static final SyncResult INVALID = null;
        public static final SyncResult QUERY_DB_FAILED = null;
        public static final SyncResult SUCCESS = null;
        public static final SyncResult TEMP_DB_NOT_EXIST = null;
        public static final SyncResult WEBVIEW_DB_COPY_FAILED = null;
        public static final SyncResult WEBVIEW_DB_NOT_EXIST = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SyncResult[] f244688a = null;

        static {
            SyncResult r100 = new SyncResult("INVALID", 0);
            INVALID = r100;
            SyncResult r101 = new SyncResult("EMPTY_COOKIE_DB", 1);
            EMPTY_COOKIE_DB = r101;
            SyncResult r102 = new SyncResult("WEBVIEW_DB_NOT_EXIST", 2);
            WEBVIEW_DB_NOT_EXIST = r102;
            SyncResult r103 = new SyncResult("WEBVIEW_DB_COPY_FAILED", 3);
            WEBVIEW_DB_COPY_FAILED = r103;
            SyncResult r104 = new SyncResult("TEMP_DB_NOT_EXIST", 4);
            TEMP_DB_NOT_EXIST = r104;
            SyncResult r105 = new SyncResult("QUERY_DB_FAILED", 5);
            QUERY_DB_FAILED = r105;
            SyncResult r110 = new SyncResult("SUCCESS", 6);
            SUCCESS = r110;
            f244688a = new SyncResult[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static SyncResult[] values() {
            return (SyncResult[]) f244688a.clone();
        }

        public static SyncResult valueOf(String r100) {
            return (SyncResult) r27.a.a(SyncResult.class, r100);
        }

        public SyncResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        f244687b = new JSONObject();
        f244686a = Keva.getRepo("ttnetCookieConfig", 1);
    }

    public static boolean d() {
        if (f244686a.getInt("cookie_sync_result", -1) != SyncResult.SUCCESS.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public static String b(Cursor r100, String r101) {
        int r102 = r100.getColumnIndex(r101);
        if (r102 != (-1)) goto L5;
        return null;
    L5:
        if (r100.isNull(r102) == false) goto L8;
        return null;
    L8:
        return r100.getString(r102);
    }

    public static PolarisFileWrapper c(Context r100, String r110) throws Throwable {
        File r101 = r100.getCacheDir();
        String r102 = com.bytedance.frameworks.baselib.network.http.util.i.b(r100);
        String r103 = "ttnet_cookie_raw_temp_";
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103 = "ttnet_cookie_raw_temp_" + r102;
    L5:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101, r103);
        if (r104.exists() == false) goto L8;
        r104.delete();
    L8:
        FileChannel r105 = null;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r110);     // Catch: Throwable -> L24
        PolarisFileOutputStreamWrapper r111 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L22
        FileChannel r107 = r106.getChannel();     // Catch: Throwable -> L20
        r105 = r111.getChannel();     // Catch: Throwable -> L18
        r105.transferFrom(r107, 0, r107.size());     // Catch: Throwable -> L18
        r105.close();     // Catch: IOException -> L46
    L67:
        r107.close();     // Catch: IOException -> L47
    L65:
        r111.close();     // Catch: IOException -> L48
    L55:
        r106.close();     // Catch: IOException -> L49
    L17:
        return r104;
    L18:
        Throwable th10 = th;
    L73:
    L30:
        th = move-exception;
        if (r105 != null) goto L57;
    L35:
        if (r107 != null) goto L71;
    L39:
        if (r111 != null) goto L61;
    L43:
        if (r106 == null) goto L77;
        r106.close();     // Catch: IOException -> L50
        throw th;
    L78:
        throw th;
    L77:
        throw th;
    L61:
        r111.close();     // Catch: IOException -> L42
        goto L43
    L71:
        r107.close();     // Catch: IOException -> L38
        goto L39
    L57:
        r105.close();     // Catch: IOException -> L34
        goto L35
    L27:
        if (r104.exists() == false) goto L29;
        r104.delete();     // Catch: Throwable -> L30
    L29:
        throw th10;     // Catch: Throwable -> L30
    L20:
        th10 = th;
        r107 = null;
    L22:
        th = move-exception;
        th10 = th;
        r111 = null;
        r107 = null;
    L24:
        th = move-exception;
        th10 = th;
        r111 = null;
        r106 = null;
        r107 = null;
        goto L73
    }

    public static void e(final Context r110, final SSCookieHandler.WebViewCookieMgrUsage r111) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (ix5.b.f496369h == false) goto L7;
        return;
    L7:
        if (ix5.b.f496375n == false) goto L10;
        return;
    L10:
        if (com.bytedance.frameworks.baselib.network.http.util.i.d(r110) == true) goto L12;
        return;
    L12:
        Keva r100 = f244686a;
        int r101 = r100.getInt("cookie_sync_result", -1);
        long r102 = r100.getLong("cookie_last_sync_time", -1);
        boolean r103 = true;
        if (r101 == SyncResult.SUCCESS.ordinal()) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L24;
        long r112 = ix5.b.f496371j;
        if (r102 >= 0) goto L20;
    L23:
        r104 = r103;
        goto L24
    L20:
        if ((System.currentTimeMillis() - r102) >= (r112 * 1000)) goto L23;
        r103 = false;
    L24:
        if (r104 == true) goto L27;
        String r113 = r100.getString("cookie_synced_error", null);
        long r114 = r100.getLong("cookie_sync_cost_ms", -1);
        long r115 = r100.getLong("cookie_sync_count", -1);
        a(true, r101, r100.getInt("cookie_db_path_index", -1), r102, r114, r113, r115);
        return;
    L27:
        TTExecutors.getScheduledThreadPool().schedule(new i(r110, r111), ix5.b.f496370i, TimeUnit.MILLISECONDS);
        return;
    L15:
        r104 = false;
        goto L16
    }

    public static void a(boolean r100, int r101, int r102, long r103, long r104, String r110, long r111) {
        JSONObject r105 = f244687b;
        monitor-enter(r105);
        r105.put("skip", r100);     // Catch: Throwable -> L23
        r105.put("result", r101);     // Catch: Throwable -> L23
        r105.put("p", r102);     // Catch: Throwable -> L23
        if (r100 == false) goto L10;
        if (r103 <= 0) goto L10;
        r105.put("after_s", (System.currentTimeMillis() - r103) / 1000);     // Catch: Throwable -> L23
    L10:
        if (r104 < 0) goto L13;
        r105.put("cost_ms", r104);     // Catch: Throwable -> L23
    L13:
        if (TextUtils.isEmpty(r110) == true) goto L16;
        r105.put("error", r110);     // Catch: Throwable -> L23
    L16:
        if (r111 < 0) goto L26;
        r105.put("count", r111);     // Catch: Throwable -> L23
    L26:
        monitor-exit(r105);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
