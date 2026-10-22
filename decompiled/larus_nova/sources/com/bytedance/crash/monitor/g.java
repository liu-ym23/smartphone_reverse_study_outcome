package com.bytedance.crash.monitor;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.util.p;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.bytedance.crash.monitor.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ICommonParams f203301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f203302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d f203303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f203304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f203305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f203306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f203307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a f203308x;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f203309a;

        @Override // java.lang.Runnable
        public final void run() {
            g r100 = this.f203309a;     // Catch: Throwable -> L11
            r100.f203307w--;     // Catch: Throwable -> L11
            if (r100.f203293e != 0) goto L5;
            this.f203309a.u();     // Catch: Throwable -> L11
        L5:
            g r101 = this.f203309a;     // Catch: Throwable -> L11
            if (r101.f203307w > 0) goto L8;
            return;
        L8:
            if (r101.f203293e != 0) goto L18;
            wh4.b.postDelayed(this.f203309a.f203308x, 3000);     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public a(g r100) {
            this.f203309a = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f203310a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f203310a.s();     // Catch: Throwable -> L10
            d r100 = this.f203310a.f203302r;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            r100.notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
        L13:
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public b(g r100) {
            this.f203310a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f203311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f203312b;

        public final void a() {
            if (this.f203312b.f203294f != null) goto L6;
            this.f203312b.t();
        L6:
            if (this.f203312b.f203292d != null) goto L8;
        L15:
            this.f203312b.s();
        L17:
            if (this.f203312b.f203294f != null) goto L19;
        L28:
            int r100 = this.f203311a + 1;
            this.f203311a = r100;
            if (r100 <= 120) goto L32;
            long r101 = -1;
        L39:
            if (r101 < 0) goto L43;
            wh4.b.postDelayed(this, r101);
            return;
        L43:
            return;
        L32:
            if (r100 >= 30) goto L35;
            r101 = 2000;
            goto L39
        L35:
            if (r100 >= 60) goto L37;
            r101 = 5000;
            goto L39
        L37:
            r101 = 600000;
            goto L39
        L19:
            if (this.f203312b.f203292d == null) goto L28;
            if (this.f203312b.f203295g == null) goto L28;
            g r102 = this.f203312b;
            if (r102.f203305u == null) goto L28;
            if (r102.f203296h == null) goto L28;
            if (this.f203312b.f203297i == 0) goto L28;
            return;
        L8:
            if (this.f203312b.f203295g == null) goto L15;
            if (this.f203312b.f203296h == null) goto L15;
            if (this.f203312b.f203297i == 0) goto L15;
            if (this.f203312b.f203305u != null) goto L17;
            goto L15
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

        public c(g r100) {
            this.f203312b = r100;
        }
    }

    public static class d {
        public d() {
        }
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final String a() {
        if (this.f203292d != null) goto L6;
        w();
    L6:
        return super.a();
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final String b() {
        if (this.f203295g != null) goto L6;
        w();
    L6:
        return super.b();
    }

    @Override // com.bytedance.crash.monitor.a, com.bytedance.crash.monitor.f
    public final Map<String, Object> c() {
        ICommonParams r100 = this.f203301q;
        HashMap r101 = null;
        if (r100 == null) goto L23;
        Map<String, Object> r102 = r100.getCommonParams();
        if (r102 == null) goto L12;
        r101 = new HashMap(r102);
        if (r101.containsKey("version_name") == true) goto L25;
    L11:
        r101.remove("release_build");
        goto L12
    L25:
        if (r101.containsKey("app_version") == true) goto L11;
        r101.put("app_version", r101.get("version_name"));     // Catch: Throwable -> L24
        r101.put("app_version_from_name", "1");     // Catch: Throwable -> L24
    L12:
        String r103 = this.f203301q.getSessionId();
        long r104 = this.f203301q.getUserId();
        if (r103 == null) goto L15;
    L16:
        if (r101 != null) goto L18;
        r101 = new HashMap();
    L18:
        if (r103 == null) goto L21;
        r101.put("session_id", r103);
    L21:
        if (r104 <= 0) goto L23;
        r101.put("user_id", Long.valueOf(r104));
        goto L23
    L15:
        if (r104 > 0) goto L16;
    L23:
        return r101;
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final long f() {
        if (this.f203296h != null) goto L5;
    L6:
        w();
    L8:
        return super.f();
    L5:
        if (this.f203297i != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final long g() {
        if (this.f203293e != 0) goto L17;
        if (wh4.b.d() != ThreadMethodProxy.currentThread()) goto L7;
        u();
        goto L17
    L7:
        wh4.b.post(new i(this));
        d r100 = this.f203304t;
        monitor-enter(r100);
        r100.wait(200);     // Catch: Throwable -> L18
    L21:
        monitor-exit(r100);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return super.g();
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final com.bytedance.crash.monitor.c h() {
        if (this.f203296h != null) goto L5;
    L6:
        w();
    L8:
        return super.h();
    L5:
        if (this.f203297i != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final long i() {
        if (this.f203296h != null) goto L5;
    L6:
        w();
    L8:
        return super.i();
    L5:
        if (this.f203297i != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final String j() {
        if (this.f203296h != null) goto L5;
    L6:
        w();
    L8:
        return super.j();
    L5:
        if (this.f203297i != 0) goto L8;
        goto L6
    }

    @Override // com.bytedance.crash.monitor.d
    public final long m() {
        if (this.f203296h != null) goto L5;
    L6:
        w();
    L8:
        return super.m();
    L5:
        if (this.f203297i != 0) goto L8;
        goto L6
    }

    public final void s() {
        Map<String, Object> r100 = this.f203301q.getCommonParams();     // Catch: Throwable -> L73
        if (this.f203292d != null) goto L74;
        Object r101 = r100.get("aid");     // Catch: Throwable -> L73
        if (r101 == null) goto L74;
        String r102 = String.valueOf(r101);     // Catch: Throwable -> L73
        this.f203292d = r102;     // Catch: Throwable -> L73
        this.f203275m.h(r102);     // Catch: Throwable -> L73
    L74:
        if (this.f203306v == true) goto L23;
        Object r103 = r100.get("app_start_time");     // Catch: Throwable -> L71
        if (r103 == null) goto L23;
        long r104 = v(r103);     // Catch: Throwable -> L71
        if (r104 <= 0) goto L23;
        this.f203306v = true;     // Catch: Throwable -> L71
        Long r105 = Long.valueOf(r104);     // Catch: Throwable -> L71
        com.bytedance.crash.i r106 = com.bytedance.crash.i.a();     // Catch: Throwable -> L71
        if (r105.longValue() >= com.bytedance.crash.i.a().f203224d) goto L20;
        long r107 = r105.longValue();     // Catch: Throwable -> L71
    L21:
        r106.f203224d = r107;     // Catch: Throwable -> L71
        goto L23
    L20:
        r107 = com.bytedance.crash.i.a().f203224d;     // Catch: Throwable -> L71
    L23:
        if (this.f203295g != null) goto L28;
        Object r108 = r100.get("channel");     // Catch: Throwable -> L73
        if ((r108 instanceof String) == false) goto L28;
        o((String) r108);     // Catch: Throwable -> L73
    L28:
        if (this.f203296h != null) goto L30;
    L33:
        Object r109 = r100.get("app_version");     // Catch: Throwable -> L73
        Object r110 = r100.get("version_code");     // Catch: Throwable -> L73
        Object r111 = r100.get("version_name");     // Catch: Throwable -> L73
        if ((r111 instanceof String) == false) goto L36;
        this.f203305u = (String) r111;     // Catch: Throwable -> L73
    L36:
        String r112 = this.f203305u;     // Catch: Throwable -> L73
        if (r112 == null) goto L40;
        r109 = r112;
    L40:
        if ((r109 instanceof String) == true) goto L42;
        return;
    L42:
        Object r113 = null;
        if (r110 != null) goto L45;
        PackageInfo r114 = com.bytedance.crash.i.getContext().getPackageManager().getPackageInfo(com.bytedance.crash.i.getContext().getPackageName(), 128);     // Catch: Throwable -> L73
        Object r115 = Integer.valueOf(r114.versionCode);     // Catch: Throwable -> L73
    L46:
        long r116 = v(r100.get("manifest_version_code"));     // Catch: Throwable -> L73
        long r117 = v(r100.get("update_version_code"));     // Catch: Throwable -> L73
        if (r117 != 0) goto L58;
        if (r114 == null) goto L76;
    L51:
        Bundle r118 = r114.applicationInfo.metaData;     // Catch: Throwable -> L72
        if (r118 == null) goto L54;
        r113 = r118.get("UPDATE_VERSION_CODE");     // Catch: Throwable -> L72
    L54:
        if (r113 != null) goto L56;
        r113 = Long.valueOf(v(r100.get("version_code")));     // Catch: Throwable -> L72
    L56:
        r117 = v(r113);     // Catch: Throwable -> L72
        goto L58
    L76:
        r114 = com.bytedance.crash.i.getContext().getPackageManager().getPackageInfo(com.bytedance.crash.i.getContext().getPackageName(), 128);     // Catch: Throwable -> L72
    L58:
        if ((r115 instanceof Long) == false) goto L60;
    L78:
        long r119 = v(r115);     // Catch: Throwable -> L68
        if (r116 > 0) goto L66;
        r116 = r119;
    L66:
        String r120 = (String) r109;     // Catch: Throwable -> L68
        this.f203299k = r117;     // Catch: Throwable -> L68
        this.f203297i = r119;     // Catch: Throwable -> L68
        this.f203296h = r120;     // Catch: Throwable -> L68
        this.f203298j = r116;     // Catch: Throwable -> L68
        this.f203275m.i(r119, r117, r116, r120);     // Catch: Throwable -> L68
        com.bytedance.crash.i.f(r119, r117, r116, r120);     // Catch: Throwable -> L68
        goto L85
    L84:
        return;
    L68:
        th = move-exception;
        ch4.c.c(th);     // Catch: Throwable -> L73
        return;
    L60:
        if ((r115 instanceof Integer) == true) goto L78;
        if ((r115 instanceof String) == true) goto L78;
        return;
    L45:
        r115 = r110;
        r114 = null;
        goto L46
    L30:
        if (this.f203297i == 0) goto L33;
        if (this.f203305u == null) goto L33;
        return;
    }

    public final void t() {
        String r100 = this.f203301q.getDeviceId();     // Catch: Throwable -> L7
        p.e("doUpdateDeviceId:" + r100);     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        p(r100);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        ch4.c.c(th);
    }

    public final void u() {
        long r100 = this.f203301q.getUserId();     // Catch: Throwable -> L6
        if (r100 == 0) goto L11;
        q(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        ch4.c.c(th);
    }

    public final void w() {
        if (wh4.b.d() != ThreadMethodProxy.currentThread()) goto L5;
        s();
        return;
    L5:
        wh4.b.post(new b(this));
        d r100 = this.f203302r;
        monitor-enter(r100);
        r100.wait(200);     // Catch: Throwable -> L14
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public g(ICommonParams r100) {
        this.f203302r = new d();
        this.f203303s = new d();
        this.f203304t = new d();
        this.f203307w = 3;
        a r101 = new a(this);
        this.f203308x = r101;
        this.f203301q = r100;
        wh4.b.post(new c(this));
        wh4.b.postDelayed(r101, 3000);
    }

    public static long v(Object r100) {
        if (r100 != null) goto L8;
        return 0;
    L8:
        return CastLongProtector.parseLong(String.valueOf(r100));
    L10:
        return 0;
    }

    @Override // com.bytedance.crash.monitor.d, com.bytedance.crash.monitor.f
    public final String d(String r100) {
        if (TextUtils.isEmpty(this.f203294f) == false) goto L17;
        if (wh4.b.d() != ThreadMethodProxy.currentThread()) goto L7;
        t();
        goto L17
    L7:
        wh4.b.post(new h(this));
        d r101 = this.f203303s;
        monitor-enter(r101);
        r101.wait(100);     // Catch: Throwable -> L18
    L21:
        monitor-exit(r101);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return super.d(r100);
    }
}
