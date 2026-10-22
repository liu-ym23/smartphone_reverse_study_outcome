package com.bytedance.badger.x;

import android.content.Context;
import android.os.Build;
import com.bytedance.badger.monitor.c;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.v.d;
import com.bytedance.badger.z.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class f0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f199381g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f199382h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f199383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f199384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f199385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z0 f199386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f199387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f199388f;

    public f0() {
        this.f199383a = new AtomicBoolean(false);
        this.f199385c = new CopyOnWriteArrayList();
        this.f199386d = new z0("dp1", 1, 8);
        this.f199387e = new r();
        this.f199388f = new u();
    }

    public static String b(Throwable r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getClass().getName());
        String r102 = r100.getMessage();
        if (r102 == null) goto L11;
        if ((!StringsKt.isBlank(r102)) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L11;
        r101.append(" ");
        r101.append(r102);
    L11:
        return r101.toString();
    }

    public static boolean g() {
        if (Build.VERSION.SDK_INT < 23) goto L12;
        boolean r100 = p.h();     // Catch: Throwable -> L6
    L7:
        if (r100 == false) goto L13;
        return true;
    L13:
        return false;
    L6:
        r100 = false;
        goto L7
    L12:
        return false;
    }

    public final void d(Context r110, q r111, List r112, Function1 r113) {
        new v(this, r111, r110, r113, new ArrayList(), r112.size() + 1, r112).a(1, 0);
    }

    static {
        f199382h = new x();
        f199381g = LazyKt.lazy(m.f199393a);
    }

    public final void e(Context r100, c1 r101) {
        this.f199385c.add(r101);
        boolean r102 = false;
        if (this.f199383a.compareAndSet(false, true) == true) goto L12;
        long r103 = System.currentTimeMillis() - this.f199384b;
        d.f199322f0.getClass();
        com.bytedance.badger.v.g r104 = d.H;
        KProperty r105 = d.f199311a[34];
        if (r103 < ((com.bytedance.badger.v.w) r104.a()).f199356a) goto L8;
        r102 = true;
    L8:
        if (r102 == true) goto L11;
        com.bytedance.badger.e.f("DeviceFp1Task", "execute not exceed max time, lastStartTime:" + this.f199384b + ", currentTime:" + System.currentTimeMillis());
        return;
    L11:
        com.bytedance.badger.e.f("DeviceFp1Task", "execute exceed max time, lastStartTime:" + this.f199384b + ", currentTime:" + System.currentTimeMillis());
    L12:
        this.f199386d.a(new e0(this, r100));
    }

    public static final String a(f0 r100, List r101, String r102) {
        r100.getClass();
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        r103.append(" ");
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        r103.append(b((Throwable) r104.next()));
        goto L4
    L7:
        return r103.toString();
    }

    public final void c(long r100, y r110, String r111, String r112) {
        long r101 = System.currentTimeMillis() - r100;
        boolean r113 = false;
        this.f199383a.set(false);
        StringBuilder r102 = new StringBuilder("onExecuteComplete, executeDuration:");
        r102.append(r101);
        r102.append(", errCode:");
        r102.append(r110.f199424a);
        r102.append(", errMsg:");
        r102.append(r110.f199425b);
        r102.append(",  type:");
        r102.append(r110.f199428e);
        r102.append(", has_ds0:");
        String r103 = r110.f199427d;
        if (r103 == null) goto L5;
        int r104 = r103.length();
    L7:
        if (r104 <= 3) goto L9;
        r113 = true;
    L9:
        r102.append(r113);
        r102.append(" isSupportProvider:");
        r102.append(r110.f199426c.f199430a);
        r102.append(", isSupportService:");
        r102.append(r110.f199426c.f199431b);
        r102.append(" providerErrMsg:");
        r102.append(r111);
        r102.append(", serviceErrMsg:");
        r102.append(r112);
        com.bytedance.badger.e.f("DeviceFp1Task", r102.toString());
        f("execute", r110, r101, r112, r111);
        Iterator r105 = this.f199385c.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        ((b0) r105.next()).a(r110, r101);
        goto L11
    L13:
        this.f199385c.clear();
        return;
    L5:
        r104 = 0;
        goto L7
    }

    public static void f(String r100, y r101, long r102, String r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("position", r100);
        r105.put("duration_ds0", Long.valueOf(r102));
        if (r103 == null) goto L5;
        r105.put("error_ds0_service", r103);
    L5:
        if (r104 == null) goto L7;
        r105.put("error_ds0_provider", r104);
    L7:
        String r106 = r101.f199427d;
        boolean r107 = false;
        if (r106 == null) goto L10;
        int r108 = r106.length();
    L12:
        if (r108 <= 3) goto L14;
        boolean r109 = true;
    L15:
        r105.put("has_ds0", Boolean.valueOf(r109));
        String r110 = r101.f199428e;
        if (r110 != null) goto L19;
        r110 = "";
    L19:
        r105.put("type_ds0", r110);
        z r111 = r101.f199426c;
        if (r111.f199430a == false) goto L22;
    L23:
        r107 = true;
    L24:
        r105.put("support_ds0", Boolean.valueOf(r107));
        r105.put("support_ds0_provider", Boolean.valueOf(r101.f199426c.f199430a));
        r105.put("support_ds0_service", Boolean.valueOf(r101.f199426c.f199431b));
        r105.put("error_ds0", r101.f199425b);
        c.f199044c.getClass();
        c.d("badger_loader_s_monitor", r105);
        return;
    L22:
        if (r111.f199431b == false) goto L24;
    L14:
        r109 = false;
        goto L15
    L10:
        r108 = 0;
        goto L12
    }
}
