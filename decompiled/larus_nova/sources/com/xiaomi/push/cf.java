package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.district.DistrictSearchQuery;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttvideoengine.net.DNSParser;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static Context f463241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cf f308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected static boolean f309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final Map<String, cb> f463242b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f463243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f463244d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ce f311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected b f312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected final Map<String, cc> f314a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f315b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f316b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private long f317c;

    public interface a {
        cf a(Context r100, ce r101, b r102, String r103);
    }

    public interface b {
        String a(String r100);
    }

    private String f() {
        return "host_fallbacks";
    }

    public String b() {
        return "resolver.msg.xiaomi.net";
    }

    static {
        f463242b = new HashMap();
        f309a = false;
    }

    private String g() {
        PackageInfo r100 = f463241a.getPackageManager().getPackageInfo(f463241a.getPackageName(), 16384);     // Catch: Exception -> L8
        if (r100 == null) goto L6;
        return r100.versionName;
    L6:
        return "0";
    L11:
        return "0";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m8898a() {
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L15
        r101.put("ver", 2);     // Catch: Throwable -> L15
        JSONArray r102 = new JSONArray();     // Catch: Throwable -> L15
        Iterator<cc> r103 = this.f314a.values().iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.put(r103.next().m8892a());     // Catch: Throwable -> L15
        goto L6
    L8:
        r101.put("data", r102);     // Catch: Throwable -> L15
        JSONArray r104 = new JSONArray();     // Catch: Throwable -> L15
        Iterator<cb> r105 = f463242b.values().iterator();     // Catch: Throwable -> L15
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.put(r105.next().m8887a());     // Catch: Throwable -> L15
        goto L10
    L12:
        r101.put(PromotionDepositPresaleActivity.RESERVED, r104);     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return r101;
    L15:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8902b() {
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
        m8901a();     // Catch: Throwable -> L21
        ArrayList<String> r101 = new ArrayList(this.f314a.keySet());     // Catch: Throwable -> L21
        int r102 = r101.size() - 1;     // Catch: Throwable -> L21
    L5:
        if (r102 < 0) goto L12;
        cc r103 = this.f314a.get(r101.get(r102));     // Catch: Throwable -> L21
        if (r103 == null) goto L11;
        if (r103.a() == null) goto L11;
        r101.remove(r102);     // Catch: Throwable -> L21
    L11:
        r102 = r102 - 1;     // Catch: Throwable -> L21
        goto L5
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L21
        ArrayList<cb> r104 = a(r101);
        int r105 = 0;
    L15:
        if (r105 >= r101.size()) goto L20;
        if (ListProtector.get(r104, r105) == null) goto L19;
        a((String) ListProtector.get(r101, r105), (cb) ListProtector.get(r104, r105));
    L19:
        r105 = r105 + 1;
        goto L15
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m8904c() {
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
        BufferedOutputStream r101 = null;
        String r102 = m8898a().toString();     // Catch: Throwable -> L21 Exception -> L23
        com.xiaomi.channel.commonutils.logger.b.b("persist host fallbacks = " + r102);     // Catch: Throwable -> L21 Exception -> L23
        if (TextUtils.isEmpty(r102) == true) goto L17;
        FileOutputStream r103 = f463241a.openFileOutput(f(), 0);     // Catch: Throwable -> L21 Exception -> L23
        BufferedOutputStream r104 = new BufferedOutputStream(r103);     // Catch: Throwable -> L13 Exception -> L15
        r104.write(h.b(m8896a(), r102.getBytes(StandardCharsets.UTF_8)));     // Catch: Exception -> L11 Throwable -> L29
        r104.flush();     // Catch: Exception -> L11 Throwable -> L29
        r101 = r104;
    L18:
        v.a(r101);     // Catch: Throwable -> L33
    L19:
        v.a(r103);     // Catch: Throwable -> L33
        monitor-exit(r100);     // Catch: Throwable -> L33
        return;
    L11:
        Exception e100 = e;
    L25:
        com.xiaomi.channel.commonutils.logger.b.m8718a("persist bucket failure: " + e100.getMessage());     // Catch: Throwable -> L29
        v.a(r104);     // Catch: Throwable -> L33
    L29:
        th = th;
        r101 = r104;
    L31:
        v.a(r101);     // Catch: Throwable -> L33
        v.a(r103);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L15:
        e = move-exception;
        r104 = null;
        e100 = e;
    L13:
        th = th;
        goto L31
    L17:
        r103 = null;
    L33:
        th = move-exception;
        throw th;
    L23:
        e = move-exception;
        r104 = null;
        e100 = e;
        r103 = null;
    L21:
        th = th;
        r103 = null;
        goto L31
    }

    public String d() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(f463241a.getFilesDir(), f());     // Catch: Throwable -> L15
        if (r100.isFile() == false) goto L14;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L15
        BufferedInputStream r102 = new BufferedInputStream(r101);     // Catch: Throwable -> L12
        String r103 = new String(h.a(m8896a(), v.a(r102)), StandardCharsets.UTF_8);     // Catch: Throwable -> L10
        com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = ".concat(r103));     // Catch: Throwable -> L10
        v.a(r102);
        v.a(r101);
        return r103;
    L10:
        th = th;
    L23:
        com.xiaomi.channel.commonutils.logger.b.m8718a("load host exception " + th.getMessage());     // Catch: Throwable -> L20
        v.a(r102);
        v.a(r101);
    L19:
        return null;
    L20:
        th = move-exception;
        v.a(r102);
        v.a(r101);
        throw th;
    L12:
        th = th;
        r102 = null;
        goto L23
    L14:
        v.a(null);
        v.a(null);
    L15:
        th = th;
        r102 = null;
        r101 = null;
        goto L23
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m8906e() {
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
        Iterator<cc> r101 = this.f314a.values().iterator();     // Catch: Throwable -> L20
    L6:
        if (r101.hasNext() == false) goto L9;
        r101.next().a(true);     // Catch: Throwable -> L20
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L18;
        Iterator<String> r103 = this.f314a.keySet().iterator();     // Catch: Throwable -> L20
    L13:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();     // Catch: Throwable -> L20
        if (this.f314a.get(r104).m8891a().isEmpty() == false) goto L13;
        this.f314a.remove(r104);     // Catch: Throwable -> L20
        goto L9
    L17:
        r102 = true;
        goto L10
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8901a() {
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f309a == true) goto L17;
        f309a = true;     // Catch: Throwable -> L19
        this.f314a.clear();     // Catch: Throwable -> L19
        String r101 = d();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == true) goto L14;
        m8903b(r101);     // Catch: Throwable -> L12
        com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L19
        return true;
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return false;
    L12:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("load bucket failure: " + th.getMessage());     // Catch: Throwable -> L19
        goto L14
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return true;
    }

    public String c() {
        StringBuilder r100 = new StringBuilder();
        Map<String, cc> r101 = this.f314a;
        monitor-enter(r101);
        Iterator<Map.Entry<String, cc>> r102 = this.f314a.entrySet().iterator();     // Catch: Throwable -> L11
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, cc> r103 = r102.next();     // Catch: Throwable -> L11
        r100.append(r103.getKey());     // Catch: Throwable -> L11
        r100.append(":\n");     // Catch: Throwable -> L11
        r100.append(r103.getValue().toString());     // Catch: Throwable -> L11
        r100.append("\n");     // Catch: Throwable -> L11
        goto L6
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r100.toString();
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m8905d() {
        String r100 = e();
        PolarisFileWrapper r101 = new PolarisFileWrapper(f463241a.getFilesDir(), r100);     // Catch: Exception -> L12
        if (r101.exists() == false) goto L10;
        boolean r102 = r101.delete();     // Catch: Exception -> L12
        StringBuilder r103 = new StringBuilder("Delete old host fallbacks file ");     // Catch: Exception -> L12
        r103.append(r100);     // Catch: Exception -> L12
        if (r102 == false) goto L8;
        String r104 = " successful.";
    L9:
        r103.append(r104);     // Catch: Exception -> L12
        com.xiaomi.channel.commonutils.logger.b.m8718a(r103.toString());     // Catch: Exception -> L12
    L15:
        return;
    L8:
        r104 = " failed.";
        goto L9
    L10:
        com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + r100 + " does not exist.");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Delete old host fallbacks file " + r100 + " error: " + e.getMessage());
    }

    public String e() {
        if ("com.xiaomi.xmsf".equals(f463243c) == false) goto L7;
        return f463243c;
    L7:
        return f463243c + TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m8895a() {
        if (f463241a != null) goto L15;
        return "unknown";
    L15:
        au r100 = at.m8812a();     // Catch: Throwable -> L14
        if (r100 != null) goto L9;
        return "unknown";
    L9:
        if (r100.a() != 1) goto L12;
        return "WIFI-UNKNOWN";
    L12:
        return r100.m8822a() + "-" + r100.m8824b();
    L14:
        return "unknown";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private byte[] m8896a() {
        return az.m8830a(f463241a.getPackageName() + "_key_salt");
    }

    public static synchronized cf a() {
        monitor-enter(cf.class);
        cf r100 = f308a;     // Catch: Throwable -> L10
        if (r100 == null) goto L9;
        monitor-exit(cf.class);
        return r100;
    L9:
        throw new IllegalStateException("the host manager is not initialized yet.");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8899a() {
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
        this.f314a.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ArrayList<cb> a(ArrayList<String> r110) {
        m8906e();
        Map<String, cc> r100 = this.f314a;
        monitor-enter(r100);
        m8901a();     // Catch: Throwable -> L103
        Iterator<String> r101 = this.f314a.keySet().iterator();     // Catch: Throwable -> L103
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();     // Catch: Throwable -> L103
        if (r110.contains(r102) == true) goto L6;
        r110.add(r102);     // Catch: Throwable -> L103
        goto L6
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L103
        Map<String, cb> r103 = f463242b;
        monitor-enter(r103);
        Object[] r104 = r103.values().toArray();     // Catch: Throwable -> L100
        int r105 = r104.length;     // Catch: Throwable -> L100
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L19;
        cb r107 = (cb) r104[r106];     // Catch: Throwable -> L100
        if (r107.b() == true) goto L18;
        f463242b.remove(r107.f304b);     // Catch: Throwable -> L100
    L18:
        r106 = r106 + 1;     // Catch: Throwable -> L100
        goto L14
    L19:
        monitor-exit(r103);     // Catch: Throwable -> L100
        if (r110.contains(b()) == true) goto L23;
        r110.add(b());
    L23:
        ArrayList<cb> r108 = new ArrayList(r110.size());
        int r109 = 0;
    L25:
        if (r109 >= r110.size()) goto L110;
        r108.add(null);
        r109 = r109 + 1;
        goto L25
    L110:
    L89:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("failed to get bucket " + e.getMessage());
    L91:
        int r111 = 0;
    L93:
        if (r111 >= r110.size()) goto L98;
        cb r112 = (cb) ListProtector.get(r108, r111);
        if (r112 == null) goto L97;
        a((String) ListProtector.get(r110, r111), r112);
    L97:
        r111 = r111 + 1;
        goto L93
    L98:
        m8904c();
        return r108;
    L28:
        if (at.d(f463241a) == false) goto L30;
        String r113 = "wifi";
    L31:
        String r114 = a(r110, r113, this.f313a, true);     // Catch: Exception -> L89
        if (TextUtils.isEmpty(r114) == true) goto L91;
        JSONObject r115 = new JSONObject(r114);     // Catch: Exception -> L89
        com.xiaomi.channel.commonutils.logger.b.b(r114);     // Catch: Exception -> L89
        if ("OK".equalsIgnoreCase(JSONObjectProtectorUtils.getString(r115, ExifInterface.LATITUDE_SOUTH)) == false) goto L91;
        JSONObject r116 = JSONObjectProtectorUtils.getJSONObject(r115, "R");     // Catch: Exception -> L89
        String r117 = JSONObjectProtectorUtils.getString(r116, "province");     // Catch: Exception -> L89
        String r118 = JSONObjectProtectorUtils.getString(r116, "city");     // Catch: Exception -> L89
        String r119 = JSONObjectProtectorUtils.getString(r116, "isp");     // Catch: Exception -> L89
        String r120 = JSONObjectProtectorUtils.getString(r116, DNSParser.DNS_RESULT_IP);     // Catch: Exception -> L89
        String r121 = JSONObjectProtectorUtils.getString(r116, DistrictSearchQuery.KEYWORDS_COUNTRY);     // Catch: Exception -> L89
        JSONObject r122 = JSONObjectProtectorUtils.getJSONObject(r116, r113);     // Catch: Exception -> L89
        com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + r119 + ", hosts=" + r122.toString());     // Catch: Exception -> L89
        int r123 = 0;
    L37:
        if (r123 >= r110.size()) goto L60;
        String r124 = (String) ListProtector.get(r110, r123);     // Catch: Exception -> L89
        JSONArray r125 = r122.optJSONArray(r124);     // Catch: Exception -> L89
        if (r125 != null) goto L41;
        com.xiaomi.channel.commonutils.logger.b.m8718a("no bucket found for " + r124);     // Catch: Exception -> L89
        JSONObject r126 = r122;
    L59:
        r123 = r123 + 1;     // Catch: Exception -> L89
        r122 = r126;
        goto L37
    L41:
        cb r127 = new cb(r124);     // Catch: Exception -> L89
        int r128 = 0;
    L43:
        if (r128 >= r125.length()) goto L49;
        String r129 = JSONArrayProtectorUtils.getString(r125, r128);     // Catch: Exception -> L89
        if (TextUtils.isEmpty(r129) == true) goto L48;
        r127.a(new ci(r129, r125.length() - r128));     // Catch: Exception -> L89
    L48:
        r128 = r128 + 1;     // Catch: Exception -> L89
        r122 = r122;
        goto L43
    L49:
        r126 = r122;
        ListProtector.set(r108, r123, r127);     // Catch: Exception -> L89
        r127.f463235g = r121;     // Catch: Exception -> L89
        r127.f463231c = r117;     // Catch: Exception -> L89
        r127.f463233e = r119;     // Catch: Exception -> L89
        r127.f463234f = r120;     // Catch: Exception -> L89
        r127.f463232d = r118;     // Catch: Exception -> L89
        if (r116.has("stat-percent") == false) goto L53;
        r127.a(JSONObjectProtectorUtils.getDouble(r116, "stat-percent"));     // Catch: Exception -> L89
    L53:
        if (r116.has("stat-domain") == false) goto L56;
        r127.b(JSONObjectProtectorUtils.getString(r116, "stat-domain"));     // Catch: Exception -> L89
    L56:
        if (r116.has(RemoteMessageConst.TTL) == false) goto L58;
        r127.a(((long) JSONObjectProtectorUtils.getInt(r116, RemoteMessageConst.TTL)) * 1000);     // Catch: Exception -> L89
    L58:
        m8900a(r127.a());     // Catch: Exception -> L89
        goto L59
    L60:
        JSONObject r130 = r116.optJSONObject(PromotionDepositPresaleActivity.RESERVED);     // Catch: Exception -> L89
        if (r130 == null) goto L91;
        if (r116.has("reserved-ttl") == false) goto L65;
        long r131 = ((long) JSONObjectProtectorUtils.getInt(r116, "reserved-ttl")) * 1000;     // Catch: Exception -> L89
    L66:
        Iterator<String> r132 = r130.keys();     // Catch: Exception -> L89
    L68:
        if (r132.hasNext() == false) goto L91;
        String r133 = r132.next();     // Catch: Exception -> L89
        JSONArray r134 = r130.optJSONArray(r133);     // Catch: Exception -> L89
        if (r134 == null) goto L71;
        cb r135 = new cb(r133);     // Catch: Exception -> L89
        r135.a(r131);     // Catch: Exception -> L89
        int r136 = 0;
    L74:
        if (r136 >= r134.length()) goto L79;
        String r137 = JSONArrayProtectorUtils.getString(r134, r136);     // Catch: Exception -> L89
        if (TextUtils.isEmpty(r137) == true) goto L78;
        r135.a(new ci(r137, r134.length() - r136));     // Catch: Exception -> L89
    L78:
        r136 = r136 + 1;     // Catch: Exception -> L89
        goto L74
    L79:
        Map<String, cb> r138 = f463242b;     // Catch: Exception -> L89
        monitor-enter(r138);     // Catch: Exception -> L89
        if (this.f311a.a(r133) == false) goto L84;
        r138.put(r133, r135);     // Catch: Throwable -> L86
    L84:
        monitor-exit(r138);     // Catch: Throwable -> L86
        goto L68
    L86:
        th = move-exception;
        throw th;     // Catch: Exception -> L89
    L71:
        com.xiaomi.channel.commonutils.logger.b.m8718a("no bucket found for " + r133);     // Catch: Exception -> L89
        goto L68
    L65:
        r131 = 604800000;
        goto L66
    L30:
        r113 = "wap";
    L100:
        th = move-exception;
        throw th;
    L103:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8903b(String r100) {
        Map<String, cc> r101 = this.f314a;
        monitor-enter(r101);
        this.f314a.clear();     // Catch: Throwable -> L26
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L26
        if (r102.optInt("ver") != 2) goto L25;
        JSONArray r103 = r102.optJSONArray("data");     // Catch: Throwable -> L26
        int r104 = 0;
        if (r103 == null) goto L12;
        int r105 = 0;
    L10:
        if (r105 >= r103.length()) goto L12;
        cc r106 = new cc().a(r103.getJSONObject(r105));     // Catch: Throwable -> L26
        this.f314a.put(r106.m8890a(), r106);     // Catch: Throwable -> L26
        r105 = r105 + 1;     // Catch: Throwable -> L26
    L12:
        JSONArray r107 = r102.optJSONArray(PromotionDepositPresaleActivity.RESERVED);     // Catch: Throwable -> L26
        if (r107 != null) goto L15;
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L26
        return;
    L15:
        if (r104 >= r107.length()) goto L22;
        JSONObject r108 = r107.getJSONObject(r104);     // Catch: Throwable -> L26
        String r109 = r108.optString("host");     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r109) == true) goto L21;
        cb r110 = new cb(r109).a(r108);     // Catch: JSONException -> L20 Throwable -> L26
        f463242b.put(r110.f304b, r110);     // Catch: JSONException -> L20 Throwable -> L26
        com.xiaomi.channel.commonutils.logger.b.m8718a("load local reserved host for " + r110.f304b);     // Catch: JSONException -> L20 Throwable -> L26
    L20:
        com.xiaomi.channel.commonutils.logger.b.m8718a("parse reserved host fail.");     // Catch: Throwable -> L26
    L21:
        r104 = r104 + 1;     // Catch: Throwable -> L26
        goto L15
    L25:
        throw new JSONException("Bad version");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public cb c(String r100) {
        Map<String, cc> r101 = this.f314a;
        monitor-enter(r101);
        m8901a();     // Catch: Throwable -> L12
        cc r102 = this.f314a.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        cb r103 = r102.a();
        if (r103 == null) goto L17;
        return r103;
    L17:
        return null;
    L10:
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public cb d(String r100) {
        Map<String, cb> r101 = f463242b;
        monitor-enter(r101);
        cb r102 = r101.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public cb e(String r100) {
        if ((System.currentTimeMillis() - this.f317c) <= ((this.f310a * 60) * 1000)) goto L13;
        this.f317c = System.currentTimeMillis();
        ArrayList<String> r101 = new ArrayList();
        r101.add(r100);
        cb r102 = (cb) ListProtector.get(a(r101), 0);
        if (r102 == null) goto L8;
        this.f310a = 0;
        return r102;
    L8:
        long r103 = this.f310a;
        if (r103 >= 15) goto L14;
        this.f310a = r103 + 1;
        return null;
    L14:
        return null;
    L13:
        return null;
    }

    public static String a(String r100) {
        int r101 = r100.length();     // Catch: UnsupportedEncodingException -> L11
        byte[] r102 = r100.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L11
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L9;
        byte r104 = r102[r103];     // Catch: UnsupportedEncodingException -> L11
        int r105 = r104 & 240;     // Catch: UnsupportedEncodingException -> L11
        if (r105 == 240) goto L8;
        byte r106 = (byte) (((r104 >> 4) + r101) & 15);     // Catch: UnsupportedEncodingException -> L11
        r102[r103] = (byte) (((r104 & 15) ^ r106) | r105);     // Catch: UnsupportedEncodingException -> L11
    L8:
        r103 = r103 + 1;     // Catch: UnsupportedEncodingException -> L11
        goto L4
    L9:
        return new String(r102);
    L11:
        return r100;
    }

    public cb b(String r100) {
        return a(r100, true);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public cb m8897a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        return a(new URL(r100).getHost(), true);
    L7:
        throw new IllegalArgumentException("the url is empty");
    }

    public static synchronized void a(a r100) {
        monitor-enter(cf.class);
        f307a = r100;     // Catch: Throwable -> L7
        f308a = null;     // Catch: Throwable -> L7
        monitor-exit(cf.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8900a(String r100) {
        this.f316b = r100;
    }

    public void a(String r100, cb r101) {
        if (TextUtils.isEmpty(r100) == true) goto L20;
        if (r101 == null) goto L20;
        if (this.f311a.a(r100) == false) goto L18;
        Map<String, cc> r102 = this.f314a;
        monitor-enter(r102);
        m8901a();     // Catch: Throwable -> L15
        if (this.f314a.containsKey(r100) == false) goto L12;
        this.f314a.get(r100).a(r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L12:
        cc r103 = new cc(r100);     // Catch: Throwable -> L15
        r103.a(r101);     // Catch: Throwable -> L15
        this.f314a.put(r100, r103);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return;
    L20:
        throw new IllegalArgumentException("the argument is invalid " + r100 + ", " + r101);
    }

    public cb a(final String r100, boolean r101) {
        com.xiaomi.channel.commonutils.logger.b.b("HostManager", new Object[]{"-->getFallbacksByHost(): host=", r100, ", fetchRemoteIfNeed=", Boolean.valueOf(r101)});
        if (TextUtils.isEmpty(r100) == true) goto L22;
        if (this.f311a.a(r100) == true) goto L8;
        return null;
    L8:
        final cb r102 = c(r100);
        if (r102 != null) goto L11;
    L13:
        if (r101 == false) goto L20;
        if (at.m8819a(f463241a) == false) goto L20;
        cb r103 = e(r100);
        if (r103 == null) goto L20;
        return r103;
    L20:
        return new AnonymousClass2(this, r100, r102);
    L11:
        if (r102.b() == false) goto L13;
        return r102;
    L22:
        throw new IllegalArgumentException("the host is empty");
    }

    public static void a(String r100, String r101) {
        Map<String, cb> r102 = f463242b;
        cb r103 = r102.get(r100);
        monitor-enter(r102);
        if (r103 != null) goto L6;
        cb r104 = new cb(r100);     // Catch: Throwable -> L9
        r104.a(604800000);     // Catch: Throwable -> L9
        r104.m8888a(r101);     // Catch: Throwable -> L9
        r102.put(r100, r104);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L6:
        r103.m8888a(r101);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public cf(Context r100, ce r101, b r110, String r111) {
        this(r100, r101, r110, r111, null, null);
    }

    public String a(ArrayList<String> r100, String r101, String r102, boolean r110) {
        ArrayList<String> r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        r104.add(new aq("type", r101));
        if (r101.equals("wap") == false) goto L5;
        r104.add(new aq("conpt", a(at.m8815a(f463241a))));
    L5:
        if (r110 == false) goto L7;
        r104.add(new aq(PromotionDepositPresaleActivity.RESERVED, "1"));
    L7:
        r104.add(new aq(ST.UUID_DEVICE, r102));
        r104.add(new aq("list", ba.a(r100, ",")));
        r104.add(new aq("countrycode", com.xiaomi.push.service.b.a(f463241a).b()));
        r104.add(new aq("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String r105 = b();
        cb r106 = c(r105);
        String r107 = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", new Object[]{r105});
        if (r106 != null) goto L22;
        r103.add(r107);
        Map<String, cb> r111 = f463242b;
        monitor-enter(r111);
        cb r108 = r111.get(r105);     // Catch: Throwable -> L19
        if (r108 == null) goto L17;
        Iterator<String> r109 = r108.a(true).iterator();     // Catch: Throwable -> L19
    L15:
        if (r109.hasNext() == false) goto L17;
        r103.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", new Object[]{r109.next()}));     // Catch: Throwable -> L19
    L17:
        monitor-exit(r111);     // Catch: Throwable -> L19
    L23:
        Iterator<String> r112 = r103.iterator();
        IOException e100 = null;
    L25:
        if (r112.hasNext() == false) goto L37;
        Uri.Builder r113 = UriProtector.parse(r112.next()).buildUpon();
        Iterator r114 = r104.iterator();
    L28:
        if (r114.hasNext() == false) goto L41;
        as r115 = (as) r114.next();
        r113.appendQueryParameter(r115.a(), r115.b());
        goto L28
    L41:
        b r116 = this.f312a;     // Catch: IOException -> L35
        if (r116 != null) goto L34;
        return at.a(f463241a, new URL(r113.toString()));
    L34:
        return r116.a(r113.toString());
    L35:
        e100 = e;
        goto L25
    L37:
        if (e100 != null) goto L39;
        return null;
    L39:
        com.xiaomi.channel.commonutils.logger.b.m8718a("network exception: " + e100.getMessage());
        throw e100;
    L19:
        th = move-exception;
        throw th;
    L22:
        r103 = r106.a(r107);
        goto L23
    }

    public cf(Context r100, ce r101, b r102, String r103, String r104, String r110) {
        this.f314a = new HashMap();
        this.f313a = "0";
        this.f310a = 0;
        this.f315b = 15;
        this.f317c = 0;
        this.f316b = "isp_prov_city_country_ip";
        this.f312a = r102;
        if (r101 != null) goto L5;
        this.f311a = new AnonymousClass1(this);
    L6:
        this.f313a = r103;
        if (r104 != null) goto L10;
        r104 = r100.getPackageName();
    L10:
        f463243c = r104;
        if (r110 != null) goto L14;
        r110 = g();
    L14:
        f463244d = r110;
        return;
    L5:
        this.f311a = r101;
        goto L6
    }

    public static synchronized void a(Context r100, ce r110, b r111, String r112, String r113, String r114) {
        monitor-enter(cf.class);
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L15
        f463241a = r101;     // Catch: Throwable -> L15
        if (r101 != null) goto L8;
        f463241a = r100;     // Catch: Throwable -> L15
    L8:
        if (f308a != null) goto L13;
        a r102 = f307a;     // Catch: Throwable -> L15
        if (r102 != null) goto L12;
        f308a = new cf(r100, r110, r111, r112, r113, r114);     // Catch: Throwable -> L15
        goto L13
    L12:
        f308a = r102.a(r100, r110, r111, r112);     // Catch: Throwable -> L15
    L13:
        monitor-exit(cf.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
