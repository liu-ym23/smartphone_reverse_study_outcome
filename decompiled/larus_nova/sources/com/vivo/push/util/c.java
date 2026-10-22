package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f462567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f462569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f462570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f462571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f462572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, Boolean> f462573g;

    private synchronized void c() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f462569c != null) goto L10;
        Context r100 = this.f462567a;     // Catch: Throwable -> L12
        if (r100 == null) goto L9;
        this.f462569c = r100.getSharedPreferences(this.f462568b, 0);     // Catch: Throwable -> L12
        goto L10
    L9:
        throw new RuntimeException("SharedPreferences is not init", new Throwable());     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final void b() {
        this.f462571e.clear();
        this.f462572f.clear();
        this.f462573g.clear();
        this.f462570d.clear();
        c();
        if (this.f462569c == null) goto L6;
        SharedPreferences.Editor r100 = this.f462569c.edit();
        r100.clear();
        a(r100);
        return;
    }

    public c() {
        this.f462570d = new HashMap();
        this.f462571e = new HashMap();
        this.f462572f = new HashMap();
        this.f462573g = new HashMap();
    }

    public final SharedPreferences a() {
        c();
        return this.f462569c;
    }

    public final void a(String r100) {
        this.f462573g.put(r100, Boolean.TRUE);
        c();
        if (this.f462569c == null) goto L6;
        SharedPreferences.Editor r101 = this.f462569c.edit();
        r101.putBoolean(r100, true);
        a(r101);
        return;
    }

    public final boolean b(String r100) {
        Boolean r101 = this.f462573g.get(r100);
        if (r101 != null) goto L5;
        c();
        Boolean r102 = Boolean.FALSE;
        if (this.f462569c == null) goto L15;
        Boolean r103 = Boolean.valueOf(this.f462569c.getBoolean(r100, false));
        if (r103 != null) goto L11;
    L13:
        r102 = r103;
        goto L15
    L11:
        if (r103.equals(r102) == true) goto L13;
        this.f462573g.put(r100, r103);
    L15:
        return r102.booleanValue();
    L5:
        return r101.booleanValue();
    }

    public final void c(String r100) {
        this.f462571e.remove(r100);
        this.f462572f.remove(r100);
        this.f462573g.remove(r100);
        this.f462570d.remove(r100);
        c();
        if (this.f462569c == null) goto L8;
        SharedPreferences.Editor r101 = this.f462569c.edit();
        if (this.f462569c.contains(r100) == false) goto L9;
        r101.remove(r100);
        a(r101);
        return;
    L9:
        return;
    }

    public static void a(SharedPreferences.Editor r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        r100.apply();
        return;
    L8:
        r100.commit();
    }

    public final void a(String r100, int r101) {
        this.f462572f.put(r100, Integer.valueOf(r101));
        c();
        if (this.f462569c == null) goto L6;
        SharedPreferences.Editor r102 = this.f462569c.edit();
        r102.putInt(r100, r101);
        a(r102);
        return;
    }

    public final int b(String r100, int r101) {
        Integer r102 = this.f462572f.get(r100);
        if (r102 != null) goto L5;
        c();
        if (this.f462569c == null) goto L12;
        r102 = Integer.valueOf(this.f462569c.getInt(r100, r101));
        if (r102.equals(Integer.valueOf(r101)) == true) goto L12;
        this.f462572f.put(r100, r102);
    L12:
        return r102.intValue();
    L5:
        return r102.intValue();
    }

    public final void a(String r100, long r101) {
        this.f462571e.put(r100, Long.valueOf(r101));
        c();
        if (this.f462569c == null) goto L6;
        SharedPreferences.Editor r102 = this.f462569c.edit();
        r102.putLong(r100, r101);
        a(r102);
        return;
    }

    public final long b(String r100, long r101) {
        Long r102 = this.f462571e.get(r100);
        if (r102 != null) goto L5;
        c();
        if (this.f462569c == null) goto L12;
        r102 = Long.valueOf(this.f462569c.getLong(r100, r101));
        if (r102.equals(Long.valueOf(r101)) == true) goto L12;
        this.f462571e.put(r100, r102);
    L12:
        return r102.longValue();
    L5:
        return r102.longValue();
    }

    public final void a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L7;
        this.f462568b = r101;
        this.f462569c = r100.getSharedPreferences(r101, 0);
        this.f462567a = r100;
        return;
    L7:
        throw new RuntimeException("sharedFileName can't be null");
    }

    public final String b(String r100, String r101) {
        String r102 = this.f462570d.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        c();
        if (this.f462569c == null) goto L12;
        r102 = this.f462569c.getString(r100, r101);
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (r102.equals(r101) == true) goto L12;
        this.f462570d.put(r100, r102);
    L12:
        return r102;
    }

    public final void a(String r100, String r101) {
        this.f462570d.put(r100, r101);
        c();
        if (this.f462569c == null) goto L6;
        SharedPreferences.Editor r102 = this.f462569c.edit();
        r102.putString(r100, r101);
        a(r102);
        return;
    }
}
