package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463275a;

    private static int a(boolean r100) {
        return r100 ? 1 : 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static List<cn> m8918a(Context r210) {
        SharedPreferences r100 = m8917a(r210);
        String[] r101 = a(r100.getString("host", null));
        if (r101 != null) goto L5;
    L46:
        com.xiaomi.channel.commonutils.logger.b.m8718a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    L5:
        if (r101.length <= 0) goto L46;
        String[] r102 = a(r100.getString(WsConstants.KEY_NETWORK_STATE, null));
        String[] r103 = a(r100.getString("reason", null));
        String[] r104 = a(r100.getString("ping_interval", null));
        String[] r105 = a(r100.getString("network_type", null));
        String[] r106 = a(r100.getString("wifi_digest", null));
        String[] r107 = a(r100.getString("connected_network_type", null));
        String[] r108 = a(r100.getString("disconnect_time", null));
        String[] r110 = a(r100.getString("connected_time", null));
        String[] r111 = a(r100.getString("xmsf_vc", null));
        String[] r109 = a(r100.getString("android_vc", null));
        if (r102 == null) goto L44;
        if (r103 == null) goto L44;
        if (r104 == null) goto L44;
        if (r105 == null) goto L44;
        if (r106 == null) goto L44;
        if (r107 == null) goto L44;
        if (r108 == null) goto L44;
        if (r110 == null) goto L44;
        if (r111 == null) goto L44;
        if (r109 == null) goto L44;
        if (r101.length != r102.length) goto L44;
        if (r101.length != r103.length) goto L44;
        if (r101.length != r104.length) goto L44;
        if (r101.length != r105.length) goto L44;
        if (r101.length != r106.length) goto L44;
        if (r101.length != r107.length) goto L44;
        if (r101.length != r108.length) goto L44;
        if (r101.length != r110.length) goto L44;
        if (r101.length != r111.length) goto L44;
        if (r101.length != r109.length) goto L44;
        ArrayList r112 = new ArrayList(r101.length);
        int r113 = 0;
    L40:
        if (r113 >= r101.length) goto L43;
        cn r114 = new cn();
        r114.a(1);
        r114.a(r101[r113]);
        r114.b(r.a(r102[r113], -1));
        r114.c(r.a(r103[r113], -1));
        String[] r211 = r102;
        String[] r115 = r101;
        ArrayList r116 = r112;
        r114.a(r.a(r104[r113], -1));
        r114.d(r.a(r105[r113], -1));
        r114.b(r106[r113]);
        r114.e(r.a(r107[r113], -1));
        long r117 = r.a(r108[r113], -1);
        long r118 = r.a(r110[r113], -1);
        String[] r119 = r104;
        r114.b(r118 - r117);
        r114.c(r117);
        r114.d(r118);
        r114.f(r.a(r111[r113], -1));
        r114.g(r.a(r109[r113], -1));
        r116.add(r114);
        r113 = r113 + 1;
        r102 = r211;
        r112 = r116;
        r104 = r119;
        r103 = r103;
        r101 = r115;
        r105 = r105;
        goto L40
    L43:
        return r112;
    L44:
        com.xiaomi.channel.commonutils.logger.b.m8718a("DisconnectStatsSP Cached data incorrect,drop.");
        return null;
    }

    private static void b(Context r100) {
        cm.a("resetAfterUpload");
        m8917a(r100).edit().putString("host", null).putString(WsConstants.KEY_NETWORK_STATE, null).putString("reason", null).putString("ping_interval", null).putString("network_type", null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m8919a(Context r100) {
        cm.a("upload");
        List<cn> r101 = m8918a(r100);
        new co().a(r100, r101);
        b(r100);
    }

    private static String[] a(String r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() > 0) goto L6;
        return null;
    L6:
        return r100.split(com.alipay.sdk.m.u.i.f25853b);
    }

    private static int a(Context r100) {
        if (f463275a > 0) goto L6;
        f463275a = j.b(r100);
    L6:
        return f463275a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m8917a(Context r100) {
        return r100.getSharedPreferences("sp_disconnect_stats", 0);
    }

    private static String a(String r100, String r101) {
        if (r101 != null) goto L4;
    L5:
        r101 = "null";
    L6:
        if (r100 != null) goto L8;
        return r101;
    L8:
        if (r100.length() > 0) goto L10;
        return r101;
    L10:
        return r100 + com.alipay.sdk.m.u.i.f25853b + r101;
    L4:
        if (r101.length() != 0) goto L6;
        goto L5
    }

    public static /* synthetic */ void b(Context r100, long r101) {
        c(r100, r101);
    }

    private static synchronized void c(Context r110, long r111) {
        monitor-enter(cp.class);
        SharedPreferences r100 = m8917a(r110);     // Catch: Throwable -> L20
        long r101 = r100.getLong("start_time_for_day", 0);     // Catch: Throwable -> L20
        if (r101 != 0) goto L9;
        r100.edit().putLong("start_time_for_day", r111).putLong("last_discnt_time", 0).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();     // Catch: Throwable -> L20
        monitor-exit(cp.class);
        return;
    L9:
        int r102 = r100.getInt("discnt_count", 0);     // Catch: Throwable -> L20
        int r103 = r100.getInt("cnt_count", 0);     // Catch: Throwable -> L20
        if (r102 <= r103) goto L13;
        String r104 = a(r100.getString("connected_time", null), r111);     // Catch: Throwable -> L20
        SharedPreferences.Editor r105 = r100.edit();     // Catch: Throwable -> L20
        r105.putInt("cnt_count", r103 + 1).putString("connected_time", r104).apply();     // Catch: Throwable -> L20
    L13:
        if ((r111 - r101) < 86400000) goto L16;
        r100.edit().putLong("start_time_for_day", r111).putInt("discnt_count_in_day", 0).apply();     // Catch: Throwable -> L20
        m8919a(r110);     // Catch: Throwable -> L20
    L18:
        monitor-exit(cp.class);
        return;
    L16:
        if (r102 < 10) goto L18;
        m8919a(r110);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static void a(final Context r100, final long r101) {
        ad.a(r100).a(new AnonymousClass2(r100, r101));
    }

    private static String a(String r100, int r101) {
        return a(r100, String.valueOf(r101));
    }

    private static String a(String r100, long r101) {
        return a(r100, String.valueOf(r101));
    }

    private static void a(Context r210, String r211, int r212, long r213, int r214, long r215, int r310, String r311, int r312) {
        cm.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", new Object[]{r211, Integer.valueOf(r212), Long.valueOf(r213), Integer.valueOf(r214), Long.valueOf(r215), Integer.valueOf(r310), r311, Integer.valueOf(r312)}));
        SharedPreferences r100 = m8917a(r210);
        String r101 = r100.getString("host", null);
        String r102 = r100.getString(WsConstants.KEY_NETWORK_STATE, null);
        String r103 = r100.getString("reason", null);
        String r110 = r100.getString("ping_interval", null);
        String r111 = r100.getString("network_type", null);
        String r112 = r100.getString("wifi_digest", null);
        String r113 = r100.getString("connected_network_type", null);
        String r114 = r100.getString("disconnect_time", null);
        String r104 = r100.getString("xmsf_vc", null);
        String r105 = r100.getString("android_vc", null);
        String r106 = a(r101, r211);
        String r107 = a(r102, r212);
        String r108 = a(r103, r214);
        String r109 = a(r110, r215);
        String r115 = a(r111, r310);
        String r116 = a(r112, r311);
        String r117 = a(r113, r312);
        String r118 = a(r114, r213);
        String r119 = a(r104, a(r210));
        r100.edit().putString("host", r106).putString(WsConstants.KEY_NETWORK_STATE, r107).putString("reason", r108).putString("ping_interval", r109).putString("network_type", r115).putString("wifi_digest", r116).putString("connected_network_type", r117).putString("disconnect_time", r118).putString("xmsf_vc", r119).putString("android_vc", a(r105, Build.VERSION.SDK_INT)).apply();
    }

    public static /* synthetic */ void b(Context r100, String r101, boolean r102, long r103, int r104, long r105, int r106, String r107, int r110) {
        c(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }

    private static synchronized void c(Context r110, String r111, boolean r112, long r113, int r210, long r211, int r212, String r213, int r214) {
        monitor-enter(cp.class);
        SharedPreferences r100 = m8917a(r110);     // Catch: Throwable -> L30
        long r101 = r100.getLong("start_time_for_day", 0);     // Catch: Throwable -> L30
        if (r101 != 0) goto L10;
        cm.a("recordDisconnection not initialized");     // Catch: Throwable -> L30
        monitor-exit(cp.class);
        return;
    L10:
        if ((r113 - r100.getLong("last_discnt_time", 0)) >= 60000) goto L15;
        cm.a("recordDisconnection anti-shake");     // Catch: Throwable -> L30
        monitor-exit(cp.class);
        return;
    L15:
        if ((r113 - r101) >= 86400000) goto L23;
        int r102 = r100.getInt("discnt_count_in_day", 0);     // Catch: Throwable -> L30
        if (r102 <= 100) goto L21;
        cm.a("recordDisconnection count > 100 in 24H cycle,abandon.");     // Catch: Throwable -> L30
        monitor-exit(cp.class);
        return;
    L21:
        int r103 = r102 + 1;
        r100.edit().putInt("discnt_count_in_day", r103).apply();     // Catch: Throwable -> L30
    L24:
        int r114 = r100.getInt("discnt_count", 0);     // Catch: Throwable -> L30
        if (r114 != r100.getInt("cnt_count", 0)) goto L27;
        a(r110, r111, a(r112), r113, r210, r211, r212, r213, r214);     // Catch: Throwable -> L30
        SharedPreferences.Editor r104 = r100.edit().putLong("last_discnt_time", r113);     // Catch: Throwable -> L30
        r104.putInt("discnt_count", r114 + 1).apply();     // Catch: Throwable -> L30
    L27:
        cm.a("recordDisconnection complete");     // Catch: Throwable -> L30
        monitor-exit(cp.class);
        return;
    L23:
        cm.a("recordDisconnection with the current time exceeds 24H cycle, go on.");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public static void a(final Context r110, final String r111, final boolean r112, final long r113, final int r114, final long r210, final int r211, final String r212, final int r213) {
        ad.a(r110).a(new AnonymousClass1(r110, r111, r112, r113, r114, r210, r211, r212, r213));
    }
}
