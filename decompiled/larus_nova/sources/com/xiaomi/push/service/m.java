package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.mira.conig.Constants;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ff;
import com.xiaomi.push.gc;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f464310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f1100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f1101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f1102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final SharedPreferences f1103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f1104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicInteger f1105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f1106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f464311b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f1107b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final AtomicInteger f1108b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final boolean f1109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f464312c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private final boolean f1110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f464313d;

    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String b() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }

        public static String a(String r100) {
            return String.format("HB_%s", new Object[]{r100});
        }

        public static String b(String r100) {
            return String.format("HB_dead_time_%s", new Object[]{r100});
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9392a() {
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m9386c() {
        boolean r100 = ah.a(this.f1102a).a(gj.f463746bh.a(), true);
        if (m9387d() == false) goto L8;
        if (r100 == false) goto L8;
        if (com.xiaomi.push.m.f464124a.name().equals(b.a(this.f1102a).a()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    private boolean m9388e() {
        long r100 = this.f1103a.getLong(a.c(), -1);
        if (r100 != (-1)) goto L5;
        return false;
    L5:
        long r101 = System.currentTimeMillis();
        if (r100 <= r101) goto L9;
        return true;
    L9:
        if ((r101 - r100) < Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L11;
        return true;
    L11:
        return false;
    }

    private void f() {
        int r100 = this.f1100a;
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L6;
        String r101 = null;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return;
    L11:
        if (this.f1103a.getLong(a.i(), -1) != (-1)) goto L13;
        this.f1101a = System.currentTimeMillis();
        this.f1103a.edit().putLong(a.i(), this.f1101a).apply();
    L13:
        int r102 = this.f1103a.getInt(r101, 0);
        this.f1103a.edit().putInt(r101, r102 + 1).apply();
        return;
    L6:
        r101 = a.h();
        goto L9
    L7:
        r101 = a.g();
        goto L9
    }

    private void g() {
        if (m9386c() == false) goto L63;
        String r100 = this.f1103a.getString(a.f(), null);
        char r101 = 1;
        char r110 = 0;
        if (TextUtils.isEmpty(r100) == true) goto L21;
        String[] r102 = r100.split("###");
        if (r102 == null) goto L21;
        int r103 = 0;
    L10:
        if (r103 >= r102.length) goto L19;
        if (TextUtils.isEmpty(r102[r103]) == true) goto L18;
        String[] r111 = r102[r103].split(":::");
        if (r111 == null) goto L18;
        if (r111.length < 4) goto L18;
        String r112 = r111[r110];
        String r113 = r111[r101];
        String r114 = r111[2];
        String r115 = r111[3];
        HashMap r104 = new HashMap();
        r104.put("event", "change");
        r104.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);
        r104.put("net_type", r113);
        r104.put("net_name", r112);
        r104.put(VideoThumbInfo.KEY_INTERVAL, r114);
        r104.put("timestamp", r115);
        a("category_hb_change", null, r104);
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] report hb changed events.");
    L18:
        r103 = r103 + 1;
        r101 = 1;
        r110 = 0;
        goto L10
    L19:
        this.f1103a.edit().remove(a.f()).apply();
    L21:
        if (this.f1103a.getBoolean(a.a(), false) == false) goto L29;
        long r105 = this.f1103a.getLong(a.b(), 0);
        long r116 = System.currentTimeMillis();
        if ((r116 - r105) <= 1296000000) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L29;
        HashMap r107 = new HashMap();
        r107.put("event", "support");
        r107.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);
        r107.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a("category_hb_change", null, r107);
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] report support wifi digest events.");
        this.f1103a.edit().putLong(a.b(), r116).apply();
        goto L29
    L25:
        r106 = false;
    L29:
        if (m9388e() == false) goto L37;
        int r108 = this.f1103a.getInt(a.d(), 0);
        int r109 = this.f1103a.getInt(a.e(), 0);
        if (r108 > 0) goto L33;
        if (r109 > 0) goto L33;
    L35:
        long r117 = System.currentTimeMillis();
        this.f1103a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), r117).apply();
    L33:
        long r118 = this.f1103a.getLong(a.c(), -1);
        String r119 = String.valueOf(235000);
        String r120 = String.valueOf(r118);
        String r121 = String.valueOf(System.currentTimeMillis());
        JSONObject r122 = new JSONObject();     // Catch: Throwable -> L50
        r122.put(VideoThumbInfo.KEY_INTERVAL, r119);     // Catch: Throwable -> L50
        r122.put("c_short", String.valueOf(r108));     // Catch: Throwable -> L50
        r122.put("c_long", String.valueOf(r109));     // Catch: Throwable -> L50
        r122.put("count", String.valueOf(r108 + r109));     // Catch: Throwable -> L50
        r122.put(ILoadStallMonitor.START_TIME, r120);     // Catch: Throwable -> L50
        r122.put("end_time", r121);     // Catch: Throwable -> L50
        String r123 = r122.toString();     // Catch: Throwable -> L50
        HashMap r124 = new HashMap();     // Catch: Throwable -> L50
        r124.put("event", "long_and_short_hb_count");     // Catch: Throwable -> L50
        a("category_hb_count", r123, r124);     // Catch: Throwable -> L50
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] report short/long hb count events.");     // Catch: Throwable -> L50
    L37:
        if (m9389f() == false) goto L64;
        String r125 = String.valueOf(this.f1101a);
        String r126 = String.valueOf(System.currentTimeMillis());
        int r127 = this.f1103a.getInt(a.g(), 0);
        if (r127 > 0) goto L56;
    L43:
        int r128 = 0;
    L44:
        int r129 = this.f1103a.getInt(a.h(), r128);
        if (r129 > 0) goto L52;
    L48:
        this.f1101a = System.currentTimeMillis();
        this.f1103a.edit().putLong(a.i(), this.f1101a).apply();
        return;
    L52:
        JSONObject r130 = new JSONObject();     // Catch: Throwable -> L51
        r130.put("net_type", ExifInterface.LONGITUDE_WEST);     // Catch: Throwable -> L51
        r130.put("ptc", r129);     // Catch: Throwable -> L51
        r130.put(ILoadStallMonitor.START_TIME, r125);     // Catch: Throwable -> L51
        r130.put("end_time", r126);     // Catch: Throwable -> L51
        String r131 = r130.toString();     // Catch: Throwable -> L51
        HashMap r132 = new HashMap();     // Catch: Throwable -> L51
        r132.put("event", "ptc_event");     // Catch: Throwable -> L51
        a("category_lc_ptc", r131, r132);     // Catch: Throwable -> L51
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] report ping timeout count events of wifi network.");     // Catch: Throwable -> L51
    L47:
        this.f1103a.edit().putInt(a.h(), 0).apply();
        goto L48
    L56:
        JSONObject r133 = new JSONObject();     // Catch: Throwable -> L42
        r133.put("net_type", "M");     // Catch: Throwable -> L42
        r133.put("ptc", r127);     // Catch: Throwable -> L42
        r133.put(ILoadStallMonitor.START_TIME, r125);     // Catch: Throwable -> L42
        r133.put("end_time", r126);     // Catch: Throwable -> L42
        String r134 = r133.toString();     // Catch: Throwable -> L42
        HashMap r135 = new HashMap();     // Catch: Throwable -> L42
        r135.put("event", "ptc_event");     // Catch: Throwable -> L42
        a("category_lc_ptc", r134, r135);     // Catch: Throwable -> L42
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] report ping timeout count events of mobile network.");     // Catch: Throwable -> L42
        this.f1103a.edit().putInt(a.g(), 0).apply();
    L42:
        r128 = 0;
        this.f1103a.edit().putInt(a.g(), 0).apply();
        goto L44
    L64:
        return;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m9387d() {
        if (c() < System.currentTimeMillis()) goto L5;
        boolean r100 = true;
    L7:
        if (this.f1110c == true) goto L9;
    L14:
        return false;
    L9:
        if (this.f1109b == false) goto L11;
        return true;
    L11:
        if (this.f464313d == true) goto L17;
        if (r100 == false) goto L14;
        return true;
    L17:
        return true;
    L5:
        r100 = false;
        goto L7
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m9391a() {
        long r100 = ff.b();
        boolean r101 = true;
        if (this.f1110c == false) goto L14;
        if (b() == true) goto L14;
        if (ah.a(this.f1102a).a(gj.f463745bg.a(), true) == false) goto L9;
    L10:
        int r102 = a();
        if (r102 == (-1)) goto L14;
        r100 = r102;
        goto L14
    L9:
        if (c() >= System.currentTimeMillis()) goto L10;
    L14:
        if (TextUtils.isEmpty(this.f1104a) == false) goto L16;
    L24:
        this.f464311b = r100;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] ping interval:" + r100);
        return r100;
    L16:
        if ("WIFI-ID-UNKNOWN".equals(this.f1104a) == true) goto L24;
        if (this.f1100a != 1) goto L24;
        if (r100 < 300000) goto L23;
        r101 = false;
    L23:
        a(r101);
        goto L24
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m9395b() {
        if (m9387d() == false) goto L14;
        f();
        if (this.f1106a == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f1104a) == false) goto L9;
        return;
    L9:
        if (this.f1104a.equals(this.f1107b) == false) goto L17;
        this.f1105a.getAndIncrement();
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] ping timeout count:" + this.f1105a);
        if (m9385a() == false) goto L18;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[HB] change hb interval for net:" + this.f1104a);
        c(this.f1104a);
        this.f1106a = false;
        this.f1105a.getAndSet(0);
        d(this.f1104a);
        return;
    L18:
        return;
    L17:
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m9385a() {
        int r100 = Math.max(ah.a(this.f1102a).a(gj.f463747bi.a(), 3), 3);
        if (this.f1105a.get() < r100) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean b() {
        if (TextUtils.isEmpty(this.f1104a) == false) goto L5;
    L14:
        return false;
    L5:
        if (this.f1104a.startsWith("M-") == false) goto L10;
        if (ah.a(this.f1102a).a(gj.f463748bj.a(), false) == true) goto L14;
        return true;
    L10:
        if (this.f1104a.equals("W-NETWORK_ID_WIFI_DEFAULT") == false) goto L14;
        if (m9390g() == true) goto L14;
        return true;
    }

    private long c() {
        return this.f1103a.getLong(a.j(), -1);
    }

    private long d() {
        return ah.a(this.f1102a).a(gj.f463756br.a(), 7776000000L);
    }

    private void e() {
        if (this.f1103a.getBoolean(a.a(), false) == true) goto L6;
        this.f1103a.edit().putBoolean(a.a(), true).apply();
        return;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    private boolean m9389f() {
        if (this.f1101a != (-1)) goto L5;
        return false;
    L5:
        long r100 = System.currentTimeMillis();
        long r101 = this.f1101a;
        if (r101 <= r100) goto L9;
        return true;
    L9:
        if ((r100 - r101) < Constants.DOWNLOAD_TEMP_FILE_PAST_TIME) goto L11;
        return true;
    L11:
        return false;
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    private boolean m9390g() {
        return ah.a(this.f1102a).a(gj.f463760bv.a(), true);
    }

    private int a() {
        if (TextUtils.isEmpty(this.f1104a) == true) goto L9;
        return this.f1103a.getInt(a.a(this.f1104a), -1);
    L10:
        return -1;
    L9:
        return -1;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m9394b() {
        return this.f464311b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m9396c() {
        if (m9387d() == false) goto L6;
        this.f1107b = this.f1104a;
        return;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m9397d() {
        if (m9387d() == false) goto L8;
        g();
        if (this.f1106a == false) goto L9;
        this.f1105a.getAndSet(0);
        return;
    L9:
        return;
    }

    private m(Context r100) {
        this.f1105a = new AtomicInteger(0);
        this.f1104a = null;
        this.f1106a = false;
        this.f1107b = null;
        this.f1108b = new AtomicInteger(0);
        this.f464312c = new AtomicInteger(0);
        this.f1100a = -1;
        this.f464311b = -1;
        this.f1102a = r100;
        this.f1110c = com.xiaomi.push.j.m9295a(r100);
        this.f1109b = ah.a(r100).a(gj.f463745bg.a(), true);
        this.f464313d = m9390g();
        SharedPreferences r101 = r100.getSharedPreferences("hb_record", 0);
        this.f1103a = r101;
        long r102 = System.currentTimeMillis();
        if (r101.getLong(a.c(), -1) != (-1)) goto L5;
        r101.edit().putLong(a.c(), r102).apply();
    L5:
        long r103 = r101.getLong(a.i(), -1);
        this.f1101a = r103;
        if (r103 != (-1)) goto L9;
        this.f1101a = r102;
        r101.edit().putLong(a.i(), r102).apply();
        return;
    }

    private void a(boolean r100) {
        if (m9386c() == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        AtomicInteger r101 = this.f1108b;
    L8:
        int r102 = r101.incrementAndGet();
        Object[] r103 = new Object[2];
        String r104 = "short";
        if (r100 == false) goto L11;
        Object r105 = "short";
    L12:
        r103[0] = r105;
        r103[1] = Integer.valueOf(r102);
        com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", r103));
        if (r102 < 5) goto L26;
        if (r100 == false) goto L16;
        String r106 = a.d();
    L17:
        int r107 = this.f1103a.getInt(r106, 0) + r102;
        this.f1103a.edit().putInt(r106, r107).apply();
        Object[] r108 = new Object[2];
        if (r100 == true) goto L21;
        r104 = "long";
    L21:
        r108[0] = r104;
        r108[1] = Integer.valueOf(r107);
        com.xiaomi.channel.commonutils.logger.b.m8718a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", r108));
        if (r100 == false) goto L24;
        this.f1108b.set(0);
        return;
    L24:
        this.f464312c.set(0);
        return;
    L16:
        r106 = a.e();
        goto L17
    L26:
        return;
    L11:
        r105 = "long";
        goto L12
    L7:
        r101 = this.f464312c;
        goto L8
    }

    private void b(String r110) {
        if ("WIFI-ID-UNKNOWN".equals(r110) == false) goto L13;
        String r111 = this.f1104a;
        if (r111 == null) goto L10;
        if (r111.startsWith("W-") == false) goto L10;
    L14:
        int r112 = this.f1103a.getInt(a.a(this.f1104a), -1);
        long r100 = this.f1103a.getLong(a.b(this.f1104a), -1);
        long r101 = System.currentTimeMillis();
        if (r112 != (-1)) goto L17;
    L22:
        this.f1105a.getAndSet(0);
        if (TextUtils.isEmpty(this.f1104a) == false) goto L25;
    L28:
        this.f1106a = false;
    L29:
        com.xiaomi.channel.commonutils.logger.b.m8718a(String.format("[HB] network changed, netid:%s, %s", new Object[]{this.f1104a, Boolean.valueOf(this.f1106a)}));
        return;
    L25:
        if (a() != (-1)) goto L28;
        this.f1106a = true;
        goto L29
    L17:
        if (r100 != (-1)) goto L20;
        this.f1103a.edit().putLong(a.b(this.f1104a), r101 + d()).apply();
        goto L22
    L20:
        if (r101 <= r100) goto L22;
        this.f1103a.edit().remove(a.a(this.f1104a)).remove(a.b(this.f1104a)).apply();
    L10:
        if (this.f464313d == false) goto L12;
        this.f1104a = "W-NETWORK_ID_WIFI_DEFAULT";
        goto L14
    L12:
        this.f1104a = null;
        goto L14
    L13:
        this.f1104a = r110;
        goto L14
    }

    private void c(String r100) {
        if (a(r100) == true) goto L5;
        return;
    L5:
        this.f1103a.edit().putInt(a.a(r100), 235000).apply();
        this.f1103a.edit().putLong(a.b(this.f1104a), System.currentTimeMillis() + d()).apply();
    }

    private void d(String r100) {
        if (m9386c() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return;
    L9:
        if (r100.startsWith("W-") == false) goto L12;
        String r101 = ExifInterface.LONGITUDE_WEST;
    L14:
        String r102 = String.valueOf(235000);
        String r103 = String.valueOf(System.currentTimeMillis() / 1000);
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append(":::");
        r104.append(r101);
        r104.append(":::");
        r104.append(r102);
        r104.append(":::");
        r104.append(r103);
        String r105 = this.f1103a.getString(a.f(), null);
        if (TextUtils.isEmpty(r105) == false) goto L17;
        String r106 = r104.toString();
    L18:
        this.f1103a.edit().putString(a.f(), r106).apply();
        return;
    L17:
        r106 = r105 + "###" + r104.toString();
        goto L18
    L12:
        if (r100.startsWith("M-") == false) goto L20;
        r101 = "M";
        goto L14
    }

    public synchronized void a(com.xiaomi.push.au r100) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (m9387d() == false) goto L24;
        String r101 = null;
        if (r100 != null) goto L9;
        b(null);     // Catch: Throwable -> L26
        this.f1100a = -1;     // Catch: Throwable -> L26
        goto L24
    L9:
        if (r100.a() != 0) goto L17;
        String r102 = r100.m8824b();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r102) == false) goto L13;
    L15:
        b(r101);     // Catch: Throwable -> L26
        this.f1100a = 0;     // Catch: Throwable -> L26
        goto L24
    L13:
        if ("UNKNOWN".equalsIgnoreCase(r102) == true) goto L15;
        r101 = "M-" + r102;     // Catch: Throwable -> L26
        goto L15
    L17:
        if (r100.a() != 1) goto L19;
    L22:
        b("WIFI-ID-UNKNOWN");     // Catch: Throwable -> L26
        this.f1100a = 1;     // Catch: Throwable -> L26
        goto L24
    L19:
        if (r100.a() == 6) goto L22;
        b(null);     // Catch: Throwable -> L26
        this.f1100a = -1;     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m9393a(String r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L8;
        e();     // Catch: Throwable -> L14
    L8:
        if (m9387d() == true) goto L10;
    L12:
        monitor-exit(this);
        return;
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        b("W-" + r100);     // Catch: Throwable -> L14
        goto L12
    }

    private boolean a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.startsWith("W-") == false) goto L8;
        return true;
    L8:
        if (r100.startsWith("M-") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static m a(Context r100) {
        if (f464310a != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f464310a != null) goto L9;
        f464310a = new m(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f464310a;
    }

    public void a(int r100) {
        long r101 = System.currentTimeMillis() + ((long) (r100 * 1000));
        this.f1103a.edit().putLong(a.j(), r101).apply();
    }

    private void a(String r100, String r101, Map<String, String> r102) {
        gi r103 = new gi();
        r103.d(r100);
        r103.c("hb_name");
        r103.a("hb_channel");
        r103.a(1);
        r103.b(r101);
        r103.a(false);
        r103.b(System.currentTimeMillis());
        r103.g(this.f1102a.getPackageName());
        r103.e("com.xiaomi.xmsf");
        if (r102 != null) goto L5;
        r102 = new HashMap();
    L5:
        p r104 = q.m9409a(this.f1102a);
        if (r104 != null) goto L8;
    L12:
        String r105 = null;
    L13:
        r102.put(ST.UUID_DEVICE, r105);
        r102.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);
        Context r106 = this.f1102a;
        r102.put("avc", String.valueOf(com.xiaomi.push.g.a(r106, r106.getPackageName())));
        r102.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
        r102.put("cvc", String.valueOf(48));
        r103.a(r102);
        gc r107 = gc.a(this.f1102a);
        if (r107 == null) goto L17;
        r107.a(r103, this.f1102a.getPackageName());
        return;
    L17:
        return;
    L8:
        if (TextUtils.isEmpty(r104.f1123a) == true) goto L12;
        String[] r108 = r104.f1123a.split("@");
        if (r108.length <= 0) goto L12;
        r105 = r108[0];
        goto L13
    }
}
