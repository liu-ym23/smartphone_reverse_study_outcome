package com.xiaomi.push;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
class ci implements Comparable<ci> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f463249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedList<ca> f321a;

    public ci() {
        this(null, 0);
    }

    public synchronized JSONObject a() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L10
        r100.put("tt", this.f319a);     // Catch: Throwable -> L10
        r100.put("wt", this.f463249a);     // Catch: Throwable -> L10
        r100.put("host", this.f320a);     // Catch: Throwable -> L10
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L10
        Iterator<ca> r102 = this.f321a.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put(r102.next().m8885a());     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.put("ah", r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return this.f320a + ":" + this.f463249a;
    }

    public ci(String r100) {
        this(r100, 0);
    }

    public synchronized void a(ca r100) {
        monitor-enter(this);
        if (r100 != null) goto L22;
    L20:
        monitor-exit(this);
        return;
    L22:
        this.f321a.add(r100);     // Catch: Throwable -> L17
        int r101 = r100.a();     // Catch: Throwable -> L17
        if (r101 <= 0) goto L7;
        this.f463249a += r100.a();     // Catch: Throwable -> L17
    L14:
        if (this.f321a.size() <= 30) goto L20;
        this.f463249a -= this.f321a.remove().a();     // Catch: Throwable -> L17
        goto L20
    L7:
        int r102 = this.f321a.size() - 1;     // Catch: Throwable -> L17
        int r103 = 0;
    L8:
        if (r102 < 0) goto L12;
        if (this.f321a.get(r102).a() >= 0) goto L12;
        r103 = r103 + 1;     // Catch: Throwable -> L17
        r102 = r102 - 1;     // Catch: Throwable -> L17
    L12:
        this.f463249a += r101 * r103;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ci r100) {
        return a(r100);
    }

    public synchronized ci a(JSONObject r100) {
        monitor-enter(this);
        this.f319a = JSONObjectProtectorUtils.getLong(r100, "tt");     // Catch: Throwable -> L10
        this.f463249a = JSONObjectProtectorUtils.getInt(r100, "wt");     // Catch: Throwable -> L10
        this.f320a = JSONObjectProtectorUtils.getString(r100, "host");     // Catch: Throwable -> L10
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "ah");     // Catch: Throwable -> L10
        int r102 = 0;
    L5:
        if (r102 >= r101.length()) goto L8;
        JSONObject r103 = JSONArrayProtectorUtils.getJSONObject(r101, r102);     // Catch: Throwable -> L10
        this.f321a.add(new ca().a(r103));     // Catch: Throwable -> L10
        r102 = r102 + 1;
        goto L5
    L8:
        monitor-exit(this);
        return this;
    L10:
        th = move-exception;
        throw th;
    }

    public int a(ci r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return r100.f463249a - this.f463249a;
    }

    public ci(String r100, int r101) {
        this.f321a = new LinkedList();
        this.f319a = 0;
        this.f320a = r100;
        this.f463249a = r101;
    }
}
