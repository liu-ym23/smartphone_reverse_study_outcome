package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f276998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f276999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f277000c;

    private void b() {
    }

    public b() {
        this.f276998a = 4;
        this.f277000c = new c();
    }

    public d a() {
        return this.f277000c;
    }

    public boolean a(int r100) {
        if (r100 < this.f276998a) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(d r100) {
        this.f277000c = r100;
    }

    public void a(String r100, String r101) {
        e r102 = a(4, r100, r101, null);     // Catch: OutOfMemoryError -> L5
        this.f277000c.a(r102.c() + '\n' + r102.a(), 4, r100, r101);     // Catch: OutOfMemoryError -> L5
        return;
    L5:
        b();
    }

    public void a(int r100, String r101, String r102) {
    L6:
        b();
        return;
    L3:
        if (a(r100) == false) goto L10;
        e r103 = a(r100, r101, r102, null);     // Catch: OutOfMemoryError -> L6
        this.f277000c.a(r103.c() + r103.a(), r100, r101, r102);     // Catch: OutOfMemoryError -> L6
        return;
    }

    public void a(Context r100, int r101, String r102) {
        this.f276998a = r101;
        this.f276999b = r102;
        this.f277000c.a(r100, "HMSCore");
    }

    private e a(int r100, String r101, String r102, Throwable r103) {
        e r104 = new e(8, this.f276999b, r100, r101);
        r104.a(r102);
        r104.a(r103);
        return r104;
    }

    public void b(int r100, String r101, String r102, Throwable r103) {
    L6:
        b();
        return;
    L3:
        if (a(r100) == false) goto L10;
        e r104 = a(r100, r101, r102, r103);     // Catch: OutOfMemoryError -> L6
        String r105 = r104.c() + r104.a();     // Catch: OutOfMemoryError -> L6
        this.f277000c.a(r105, r100, r101, r102 + '\n' + Log.getStackTraceString(r103));     // Catch: OutOfMemoryError -> L6
        return;
    }
}
