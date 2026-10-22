package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f463239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<cb> f305a;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m8892a() {
        monitor-enter(this);
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L10
        r100.put("host", this.f463239a);     // Catch: Throwable -> L10
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L10
        Iterator<cb> r102 = this.f305a.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        r101.put(r102.next().m8887a());     // Catch: Throwable -> L10
        goto L5
    L7:
        r100.put("fbs", r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r100;
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f463239a);
        r100.append("\n");
        Iterator<cb> r101 = this.f305a.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next());
        goto L4
    L7:
        return r100.toString();
    }

    public cc() {
        this.f305a = new ArrayList();
    }

    public synchronized cb a() {
        monitor-enter(this);
        int r100 = this.f305a.size() - 1;     // Catch: Throwable -> L14
    L4:
        if (r100 < 0) goto L11;
        cb r101 = (cb) ListProtector.get(this.f305a, r100);     // Catch: Throwable -> L14
        if (r101.m8889a() == true) goto L7;
        r100 = r100 - 1;
        goto L4
    L7:
        cf.a().m8900a(r101.a());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r101;
    L11:
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8890a() {
        return this.f463239a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ArrayList<cb> m8891a() {
        return this.f305a;
    }

    public cc(String r100) {
        this.f305a = new ArrayList();
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f463239a = r100;
        return;
    L7:
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized void a(boolean r100) {
        monitor-enter(this);
        int r101 = this.f305a.size() - 1;     // Catch: Throwable -> L16
    L4:
        if (r101 < 0) goto L14;
        cb r102 = (cb) ListProtector.get(this.f305a, r101);     // Catch: Throwable -> L16
        if (r100 == false) goto L11;
        if (r102.c() == false) goto L13;
        ListProtector.remove(this.f305a, r101);     // Catch: Throwable -> L16
    L13:
        r101 = r101 - 1;
        goto L4
    L11:
        if (r102.b() == true) goto L13;
        ListProtector.remove(this.f305a, r101);     // Catch: Throwable -> L16
        goto L13
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized void a(cb r100) {
        monitor-enter(this);
        int r101 = 0;
    L18:
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r101 >= this.f305a.size()) goto L11;
        if (((cb) ListProtector.get(this.f305a, r101)).a(r100) == true) goto L8;
        r101 = r101 + 1;     // Catch: Throwable -> L15
        goto L18
    L8:
        ListProtector.set(this.f305a, r101, r100);     // Catch: Throwable -> L15
    L11:
        if (r101 < this.f305a.size()) goto L13;
        this.f305a.add(r100);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public synchronized cc a(JSONObject r100) {
        monitor-enter(this);
        this.f463239a = JSONObjectProtectorUtils.getString(r100, "host");     // Catch: Throwable -> L10
        JSONArray r101 = JSONObjectProtectorUtils.getJSONArray(r100, "fbs");     // Catch: Throwable -> L10
        int r102 = 0;
    L5:
        if (r102 >= r101.length()) goto L8;
        this.f305a.add(new cb(this.f463239a).a(JSONArrayProtectorUtils.getJSONObject(r101, r102)));     // Catch: Throwable -> L10
        r102 = r102 + 1;
        goto L5
    L8:
        monitor-exit(this);
        return this;
    L10:
        th = move-exception;
        throw th;
    }
}
