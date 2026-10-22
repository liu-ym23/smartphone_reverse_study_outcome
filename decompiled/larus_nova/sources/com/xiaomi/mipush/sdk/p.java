package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile p f463076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<n> f184a;

    private p(Context r100) {
        this.f184a = new ArrayList();
        Context r101 = r100.getApplicationContext();
        this.f183a = r101;
        if (r101 != null) goto L6;
        this.f183a = r100;
        return;
    }

    public int a(String r100) {
        List<n> r101 = this.f184a;
        monitor-enter(r101);
        n r102 = new n();     // Catch: Throwable -> L17
        r102.f181a = r100;     // Catch: Throwable -> L17
        if (this.f184a.contains(r102) == false) goto L14;
        Iterator<n> r103 = this.f184a.iterator();     // Catch: Throwable -> L17
    L8:
        if (r103.hasNext() == false) goto L14;
        n r104 = r103.next();     // Catch: Throwable -> L17
        if (r104.equals(r102) == false) goto L8;
        int r105 = r104.f463074a;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return r105;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public void b(String r100) {
        List<n> r101 = this.f184a;
        monitor-enter(r101);
        n r102 = new n();     // Catch: Throwable -> L15
        r102.f181a = r100;     // Catch: Throwable -> L15
        if (this.f184a.contains(r102) == false) goto L12;
        Iterator<n> r103 = this.f184a.iterator();     // Catch: Throwable -> L15
    L8:
        if (r103.hasNext() == false) goto L12;
        n r104 = r103.next();     // Catch: Throwable -> L15
        if (r102.equals(r104) == false) goto L8;
        r102 = r104;
    L12:
        r102.f463074a++;     // Catch: Throwable -> L15
        this.f184a.remove(r102);     // Catch: Throwable -> L15
        this.f184a.add(r102);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void c(String r100) {
        List<n> r101 = this.f184a;
        monitor-enter(r101);
        n r102 = new n();     // Catch: Throwable -> L9
        r102.f181a = r100;     // Catch: Throwable -> L9
        if (this.f184a.contains(r102) == false) goto L7;
        this.f184a.remove(r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8772a(String r100) {
        List<n> r101 = this.f184a;
        monitor-enter(r101);
        n r102 = new n();     // Catch: Throwable -> L10
        r102.f463074a = 0;     // Catch: Throwable -> L10
        r102.f181a = r100;     // Catch: Throwable -> L10
        if (this.f184a.contains(r102) == false) goto L7;
        this.f184a.remove(r102);     // Catch: Throwable -> L10
    L7:
        this.f184a.add(r102);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8773a(String r100) {
        List<n> r101 = this.f184a;
        monitor-enter(r101);
        n r102 = new n();     // Catch: Throwable -> L12
        r102.f181a = r100;     // Catch: Throwable -> L12
        if (this.f184a.contains(r102) == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return true;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public static p a(Context r100) {
        if (f463076a != null) goto L15;
        monitor-enter(p.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463076a != null) goto L9;
        f463076a = new p(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(p.class);     // Catch: Throwable -> L11
    L15:
        return f463076a;
    }

    public synchronized String a(v r100) {
        monitor-enter(this);
        String r101 = this.f183a.getSharedPreferences("mipush_extra", 0).getString(r100.name(), "");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(v r100, String r101) {
        monitor-enter(this);
        SharedPreferences r102 = this.f183a.getSharedPreferences("mipush_extra", 0);     // Catch: Throwable -> L6
        String r103 = r100.name();     // Catch: Throwable -> L6
        r102.edit().putString(r103, r101).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
