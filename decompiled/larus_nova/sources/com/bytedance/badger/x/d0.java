package com.bytedance.badger.x;

import android.content.Context;
import com.bytedance.badger.monitor.c;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f199375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f199376b;

    public d0(v r100, int r101) {
        this.f199375a = r100;
        this.f199376b = r101;
    }

    public final void a() {
        long r100 = System.currentTimeMillis();
        com.bytedance.badger.e.b("DeviceFp1Task", "executeSourceWithRetry type " + this.f199375a.f199412b.c() + " attempt " + this.f199376b);     // Catch: Throwable -> L12
        v r101 = this.f199375a;     // Catch: Throwable -> L12
        f0 r102 = r101.f199411a;     // Catch: Throwable -> L12
        Context r103 = r101.f199413c;     // Catch: Throwable -> L12
        q r104 = r101.f199412b;     // Catch: Throwable -> L12
        Lazy r105 = f0.f199381g;     // Catch: Throwable -> L12
        r102.getClass();     // Catch: Throwable -> L12
        r104.d(r103);     // Catch: Throwable -> L12
        if (r104.e() == true) goto L6;
        r104.b();     // Catch: Throwable -> L12
    L6:
        String r106 = r104.a();     // Catch: Throwable -> L12
        if ((!StringsKt.isBlank(r106)) == false) goto L11;
        v r107 = this.f199375a;     // Catch: Throwable -> L12
        r107.f199414d.invoke(new a0(true, r106, this.f199376b, CollectionsKt.toList(r107.f199415e)));     // Catch: Throwable -> L12
        return;
    L11:
        throw new Exception("get fp1 failed");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        com.bytedance.badger.e.e("DeviceFp1Task", "executeSourceWithRetry error: " + th);
        this.f199375a.f199415e.add(th);
        v r108 = this.f199375a;
        f0 r109 = r108.f199411a;
        String r110 = r108.f199412b.c();
        int r111 = this.f199376b - 1;
        long r112 = System.currentTimeMillis() - r100;
        Lazy r113 = f0.f199381g;
        r109.getClass();
        HashMap r114 = new HashMap();
        r114.put("type_ds0", r110);
        r114.put("error_ds0", f0.b(th));
        r114.put("retry_count", Integer.valueOf(r111));
        r114.put("duration", Long.valueOf(r112));
        c.f199044c.getClass();
        c.d("badger_loader_ds0_fail", r114);
        v r115 = this.f199375a;
        f0 r116 = r115.f199411a;
        int r117 = this.f199376b;
        int r118 = r115.f199416f;
        r116.getClass();
        boolean r119 = false;
        if (r117 < r118) goto L16;
        boolean r120 = false;
    L17:
        if (r120 == true) goto L20;
        v r121 = this.f199375a;
        r121.f199414d.invoke(new a0(this.f199376b, CollectionsKt.toList(r121.f199415e), 2));
        return;
    L20:
        v r122 = this.f199375a;
        f0 r123 = r122.f199411a;
        q r124 = r122.f199412b;
        int r125 = this.f199376b;
        int r126 = r122.f199416f;
        r123.getClass();
        if (r125 != (r126 - 1)) goto L23;
        r119 = true;
    L23:
        if (r119 == true) goto L34;
    L28:
        Integer r127 = (Integer) CollectionsKt.getOrNull(this.f199375a.f199417g, this.f199376b - 1);
        if (r127 == null) goto L31;
        long r128 = r127.intValue();
    L32:
        this.f199375a.a(this.f199376b + 1, r128);
        return;
    L31:
        r128 = 0;
        goto L32
    L34:
        r124.f();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        com.bytedance.badger.e.c("DeviceFp1Task", "remove failed", th);
        goto L28
    L16:
        r120 = true;
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
