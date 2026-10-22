package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f408092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f408093b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f408094c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static eta.b f408095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f408096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f408097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f408098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f408099h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String f408100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f408101j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f408102k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile c0.b f408103l;

    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f408104a = null;

        static {
            int[] r100 = new int[Level.values().length];
            f408104a = r100;
            r100[Level.L0.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f408104a[Level.L1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public interface b {
        NetworkUtils.NetworkType getNetworkType();
    }

    static {
        f408092a = new String[]{"aid", "app_version", "tt_data", "device_id"};
        f408093b = new String[]{"tt_data", "device_platform", "aid", "device_id", WsConstants.KEY_INSTALL_ID};
        f408094c = new String[]{"aid", "version_code", TTVideoEngineInterface.PLAY_API_KEY_ABVERSION, "device_id", WsConstants.KEY_INSTALL_ID, "device_platform"};
        f408095d = null;
        f408099h = new Object();
        f408100i = "app_log_encrypt_switch_count";
        f408101j = new ConcurrentHashMap();
        f408102k = new ConcurrentHashMap();
    }

    public static void a(Context r100) {
        if (f408096e == true) goto L14;
        if (r100 == null) goto L20;
        Object r101 = f408099h;
        monitor-enter(r101);
        SharedPreferences r102 = r100.getSharedPreferences(f408100i, 0);     // Catch: Throwable -> L15
        f408098g = r102.getInt("app_log_encrypt_faild_count", 0);     // Catch: Throwable -> L15
        SharedPreferences.Editor r103 = r102.edit();     // Catch: Throwable -> L15
        r103.putInt("app_log_encrypt_faild_count", f408098g + 1);     // Catch: Throwable -> L15
        r103.apply();     // Catch: Throwable -> L15
        f408096e = true;     // Catch: Throwable -> L15
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L20:
        return;
    }

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        Uri.Builder r101 = UriProtector.parse(e(r100, f408092a)).buildUpon();
        r101.appendQueryParameter("tt_info", new String(Base64.encode(b(null, UriProtector.parse(r100).getQuery().getBytes("UTF-8")), 8)));     // Catch: Throwable -> L8
        return r101.build().toString();
    L11:
        return r100;
    }

    public static void f(Context r100) {
        if (f408097f == true) goto L18;
        if (r100 == null) goto L24;
        Object r101 = f408099h;
        monitor-enter(r101);
        SharedPreferences.Editor r102 = r100.getSharedPreferences(f408100i, 0).edit();     // Catch: Throwable -> L19
        if (f408098g <= 2) goto L11;
        f408098g -= 2;     // Catch: Throwable -> L19
    L12:
        r102.putInt("app_log_encrypt_faild_count", f408098g);     // Catch: Throwable -> L19
        r102.apply();     // Catch: Throwable -> L19
        f408097f = true;     // Catch: Throwable -> L19
        goto L20
    L11:
        f408098g = 0;     // Catch: Throwable -> L19
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L24:
        return;
    }

    public static byte[] b(Context r100, byte[] r101) throws Exception {
        byte[] r102 = null;
        if (r101 != null) goto L5;
    L27:
        return null;
    L5:
        if (r101.length <= 0) goto L27;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r104 = new GZIPOutputStream(r103);
        r104.write(r101);     // Catch: Throwable -> L20
        r104.close();
        byte[] r105 = r103.toByteArray();
        if (r100 == null) goto L16;
        a(r100);
        if (f408098g >= 3) goto L19;
        r102 = EncryptorUtil.b(r105, r105.length);
        f(r100);
        if (r102 != null) goto L19;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);
    L19:
        return r102;
    L16:
        r102 = EncryptorUtil.b(r105, r105.length);
        if (r102 != null) goto L19;
        e.a().b(StatsCountKeys.ENCRYPT_ERROR_COUNT, 1);
    L20:
        th = move-exception;
        e.a().b(StatsCountKeys.COMPRESS_ERROR_COUNT, 1);     // Catch: Throwable -> L24
        ita.j.c("AppLog compress with gzip exception: ", th);     // Catch: Throwable -> L24
        r104.close();
        return null;
    L24:
        th = move-exception;
        r104.close();
        throw th;
    }

    public static void c(Map<String, String> r100, Map<String, String> r101) {
        if (r100.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: Exception -> L18
    L6:
        if (r102.hasNext() == false) goto L33;
        Map.Entry<String, String> r103 = r102.next();     // Catch: Exception -> L18
        if (r103 == null) goto L6;
        String r104 = r103.getKey();     // Catch: Exception -> L18
        String r105 = r103.getValue();     // Catch: Exception -> L18
        if (StringUtils.isEmpty(r104) == true) goto L6;
        if (StringUtils.isEmpty(r105) == true) goto L6;
        r101.put(r104, r105);     // Catch: Exception -> L18
    L33:
        return;
    L17:
        return;
    }

    public static String e(String r100, String[] r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        Uri r102 = UriProtector.parse(r100);
        HashMap r103 = new HashMap(r101.length);
        int r104 = r101.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        String r106 = r101[r105];
        String r107 = UriProtector.getQueryParameter(r102, r106);
        if (TextUtils.isEmpty(r107) == true) goto L10;
        r103.put(r106, r107);
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        Uri.Builder r108 = r102.buildUpon();
        r108.clearQuery();
        Iterator r109 = r103.keySet().iterator();
    L13:
        if (r109.hasNext() == false) goto L16;
        String r110 = (String) r109.next();
        r108.appendQueryParameter(r110, (String) r103.get(r110));
        goto L13
    L16:
        return r108.build().toString();
    }
}
