package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttvideoengine.net.DNSParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f463229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<ci> f303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f463230b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f463231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f463232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f463233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f463234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f463235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f463236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f463237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f463238j;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m8887a() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L10
        r100.put(com.alipay.sdk.m.k.b.f25406k, this.f302a);     // Catch: Throwable -> L10
        r100.put(RemoteMessageConst.TTL, this.f463230b);     // Catch: Throwable -> L10
        r100.put("pct", this.f463229a);     // Catch: Throwable -> L10
        r100.put("ts", this.f301a);     // Catch: Throwable -> L10
        r100.put("city", this.f463232d);     // Catch: Throwable -> L10
        r100.put("prv", this.f463231c);     // Catch: Throwable -> L10
        r100.put(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE, this.f463235g);     // Catch: Throwable -> L10
        r100.put("isp", this.f463233e);     // Catch: Throwable -> L10
        r100.put(DNSParser.DNS_RESULT_IP, this.f463234f);     // Catch: Throwable -> L10
        r100.put("host", this.f304b);     // Catch: Throwable -> L10
        r100.put("xf", this.f463236h);     // Catch: Throwable -> L10
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L10
        Iterator<ci> r102 = this.f303a.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put(r102.next().a());     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.put("fbs", r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean c() {
        long r100 = this.f463230b;
        if (864000000 < r100) goto L6;
        r100 = 864000000;
    L6:
        long r101 = System.currentTimeMillis();
        long r102 = this.f301a;
        if ((r101 - r102) <= r100) goto L9;
    L14:
        return true;
    L9:
        if ((r101 - r102) > this.f463230b) goto L11;
    L13:
        return false;
    L11:
        if (this.f302a.startsWith("WIFI-") == false) goto L13;
        goto L13
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f302a);
        r100.append("\n");
        r100.append(a());
        Iterator<ci> r101 = this.f303a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ci r102 = r101.next();
        r100.append("\n");
        r100.append(r102.toString());
        goto L4
    L6:
        r100.append("\n");
        return r100.toString();
    }

    public boolean b() {
        if ((System.currentTimeMillis() - this.f301a) >= this.f463230b) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized String a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f463237i) == true) goto L9;
        String r100 = this.f463237i;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r100;
    L9:
        if (TextUtils.isEmpty(this.f463233e) == false) goto L14;
        monitor-exit(this);
        return "hardcode_isp";
    L14:
        String r101 = ba.a(new String[]{this.f463233e, this.f463231c, this.f463232d, this.f463235g, this.f463234f}, "_");     // Catch: Throwable -> L17
        this.f463237i = r101;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m8886a() {
        monitor-enter(this);
        ArrayList<String> r100 = a(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8889a() {
        return TextUtils.equals(this.f302a, cf.m8895a());
    }

    public cb(String r100) {
        this.f302a = "";
        this.f303a = new ArrayList();
        this.f463229a = 0.1d;
        this.f463238j = "s.mi1.cc";
        this.f463230b = 86400000;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f301a = System.currentTimeMillis();
        this.f303a.add(new ci(r100, -1));
        this.f302a = cf.m8895a();
        this.f304b = r100;
        return;
    L7:
        throw new IllegalArgumentException("the host is empty");
    }

    private synchronized void c(String r100) {
        monitor-enter(this);
        Iterator<ci> r101 = this.f303a.iterator();     // Catch: Throwable -> L12
    L5:
        if (r101.hasNext() == false) goto L10;
        if (TextUtils.equals(r101.next().f320a, r100) == false) goto L5;
        r101.remove();     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized cb a(JSONObject r100) {
        monitor-enter(this);
        this.f302a = r100.optString(com.alipay.sdk.m.k.b.f25406k);     // Catch: Throwable -> L10
        this.f463230b = JSONObjectProtectorUtils.getLong(r100, RemoteMessageConst.TTL);     // Catch: Throwable -> L10
        this.f463229a = JSONObjectProtectorUtils.getDouble(r100, "pct");     // Catch: Throwable -> L10
        this.f301a = JSONObjectProtectorUtils.getLong(r100, "ts");     // Catch: Throwable -> L10
        this.f463232d = r100.optString("city");     // Catch: Throwable -> L10
        this.f463231c = r100.optString("prv");     // Catch: Throwable -> L10
        this.f463235g = r100.optString(MapBundleKey.OfflineMapKey.OFFLINE_CITY_TYPE);     // Catch: Throwable -> L10
        this.f463233e = r100.optString("isp");     // Catch: Throwable -> L10
        this.f463234f = r100.optString(DNSParser.DNS_RESULT_IP);     // Catch: Throwable -> L10
        this.f304b = r100.optString("host");     // Catch: Throwable -> L10
        this.f463236h = r100.optString("xf");     // Catch: Throwable -> L10
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "fbs");     // Catch: Throwable -> L10
        int r102 = 0;
    L5:
        if (r102 >= r101.length()) goto L8;
        a(new ci().a(JSONArrayProtectorUtils.getJSONObject(r101, r102)));     // Catch: Throwable -> L10
        r102 = r102 + 1;
        goto L5
    L8:
        monitor-exit(this);
        return this;
    L10:
        th = move-exception;
        throw th;
    }

    public void b(String r100) {
        this.f463238j = r100;
    }

    public ArrayList<String> a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        URL r101 = new URL(r100);
        if (TextUtils.equals(r101.getHost(), this.f304b) == false) goto L12;
        ArrayList<String> r102 = new ArrayList();
        Iterator<String> r103 = a(true).iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        cd r104 = cd.a(r103.next(), r101.getPort());
        r102.add(new URL(r101.getProtocol(), r104.m8894a(), r104.a(), r101.getFile()).toString());
        goto L8
    L10:
        return r102;
    L12:
        throw new IllegalArgumentException("the url is not supported by the fallback");
    L14:
        throw new IllegalArgumentException("the url is empty.");
    }

    public synchronized void a(String[] r100) {
        monitor-enter(this);
        int r101 = this.f303a.size() - 1;     // Catch: Throwable -> L25
    L4:
        int r102 = 0;
        if (r101 < 0) goto L13;
        int r103 = r100.length;     // Catch: Throwable -> L25
    L7:
        if (r102 >= r103) goto L12;
        if (TextUtils.equals(((ci) ListProtector.get(this.f303a, r101)).f320a, r100[r102]) == true) goto L10;
        r102 = r102 + 1;     // Catch: Throwable -> L25
        goto L7
    L10:
        ListProtector.remove(this.f303a, r101);     // Catch: Throwable -> L25
    L12:
        r101 = r101 - 1;     // Catch: Throwable -> L25
        goto L4
    L13:
        Iterator<ci> r104 = this.f303a.iterator();     // Catch: Throwable -> L25
        int r105 = 0;
    L15:
        if (r104.hasNext() == false) goto L19;
        int r106 = r104.next().f463249a;     // Catch: Throwable -> L25
        if (r106 <= r105) goto L15;
        r105 = r106;
    L19:
        if (r102 >= r100.length) goto L23;
        a(new ci(r100[r102], (r100.length + r105) - r102));     // Catch: Throwable -> L25
        r102 = r102 + 1;
        goto L19
    L23:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<String> a(boolean r100) {
        monitor-enter(this);
        int r101 = this.f303a.size();     // Catch: Throwable -> L15
        ci[] r102 = new ci[r101];     // Catch: Throwable -> L15
        this.f303a.toArray(r102);     // Catch: Throwable -> L15
        Arrays.sort(r102);     // Catch: Throwable -> L15
        ArrayList<String> r103 = new ArrayList();     // Catch: Throwable -> L15
        int r104 = 0;
    L4:
        if (r104 >= r101) goto L13;
        ci r105 = r102[r104];     // Catch: Throwable -> L15
        if (r100 == false) goto L8;
        r103.add(r105.f320a);     // Catch: Throwable -> L15
    L12:
        r104 = r104 + 1;
        goto L4
    L8:
        int r106 = r105.f320a.indexOf(":");     // Catch: Throwable -> L15
        if (r106 == (-1)) goto L11;
        r103.add(r105.f320a.substring(0, r106));     // Catch: Throwable -> L15
        goto L12
    L11:
        r103.add(r105.f320a);     // Catch: Throwable -> L15
        goto L12
    L13:
        monitor-exit(this);
        return r103;
    L15:
        th = move-exception;
        throw th;
    }

    public void a(long r100) {
        if (r100 <= 0) goto L7;
        this.f463230b = r100;
        return;
    L7:
        throw new IllegalArgumentException("the duration is invalid " + r100);
    }

    public synchronized void a(ci r100) {
        monitor-enter(this);
        c(r100.f320a);     // Catch: Throwable -> L6
        this.f303a.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m8888a(String r100) {
        monitor-enter(this);
        a(new ci(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean a(cb r100) {
        return TextUtils.equals(this.f302a, r100.f302a);
    }

    public void a(double r100) {
        this.f463229a = r100;
    }

    public synchronized void a(String r100, ca r101) {
        monitor-enter(this);
        Iterator<ci> r102 = this.f303a.iterator();     // Catch: Throwable -> L11
    L5:
        if (r102.hasNext() == false) goto L9;
        ci r103 = r102.next();     // Catch: Throwable -> L11
        if (TextUtils.equals(r100, r103.f320a) == false) goto L5;
        r103.a(r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void a(String r100, long r101, long r110) {
        b(new URL(r100).getHost(), r101, r110);     // Catch: MalformedURLException -> L4
        return;
    }

    public void b(String r100, long r110, long r111) {
        a(r100, 0, r110, r111, null);
    }

    public void a(String r100, long r110, long r111, Exception r112) {
        b(new URL(r100).getHost(), r110, r111, r112);     // Catch: MalformedURLException -> L4
        return;
    }

    public void b(String r100, long r110, long r111, Exception r112) {
        a(r100, -1, r110, r111, r112);
    }

    public void a(String r100, int r110, long r111, long r112, Exception r113) {
        a(r100, new ca(r110, r111, r112, r113));
    }
}
