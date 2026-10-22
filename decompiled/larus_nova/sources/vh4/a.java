package vh4;

import android.os.SystemClock;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.util.p;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends PthreadThreadV2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ c f554956v;

    public final void l() {
        long r100 = this.f554956v.f554962h.f554969j;
    L3:
        c.a r101 = c.f554959k;
        int r102 = r101.f554966d;
        if (r102 == 0) goto L65;
        long r110 = 4;
        if (r102 == 1) goto L36;
        if (r102 == 2) goto L26;
        if (r102 != 3) goto L66;
        long r111 = c.e(this.f554956v.f554962h.f554973n);
        c r103 = this.f554956v;
        if (r111 >= (((long) r103.f554962h.f554968i) * 1024)) goto L14;
        c.f554959k.f554966d = 2;
        r103.getClass();
        c.h(0);
        goto L66
    L14:
        c.f554959k.f554966d = 4;
        r103.getClass();
        p.a("VmMonitor: exit hook");
        c.a r104 = c.f554959k;
        if (r104.f554963a == false) goto L22;
        int r105 = NativeResourceMonitor.i(2, 0);
        if (r105 != 0) goto L20;
        boolean r112 = true;
    L21:
        r104.f554964b = r112;
        r104.f554963a = !r112;
        c.g(0, 2, r105);
        goto L22
    L20:
        r112 = false;
    L22:
        NativeResourceMonitor.j(this.f554956v.f523271b);
        NativeResourceMonitor.i(5, 1);
        int r106 = NativeResourceMonitor.i(5, 0);
        c.g(0, 5, r106);
        if (r106 != 0) goto L66;
        wh4.b.postDelayed(new b(), 60000);
        c.f554959k.f554965c = false;
    L66:
        int r107 = c.f554959k.f554966d;
        if (r107 == (-1)) goto L79;
        if (r107 == 4) goto L79;
        if (r107 == 5) goto L79;
        r100 = Math.max(r100, this.f554956v.f554962h.f554969j);     // Catch: Throwable -> L77
        if (this.f554956v.f554962h.f554972m == false) goto L75;
        r100 = 1000;
    L75:
        SystemClock.sleep(r100);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        th.printStackTrace();
    L79:
        this.f554956v.f523274e.b();
        p.e("Thread exit!");
        c.f554959k.f554965c = false;
        return;
    L26:
        long r108 = c.e(this.f554956v.f554962h.f554973n);
        p.a("VmMonitor: leakSize: " + r108 + ", dumpleaksize: " + (((long) this.f554956v.f554962h.f554968i) * 1024));
        c r109 = this.f554956v;
        int r113 = r109.f554962h.f554968i;
        if (r108 < (((((long) r113) * 1024) * 5) / 4)) goto L30;
        c.f554959k.f554966d = 3;
        r109.getClass();
        p.a("VmMonitor: stop monitor native");
        c.g(0, 4, NativeResourceMonitor.i(4, 0));
        goto L66
    L30:
        if (r108 >= ((((long) r113) * 1024) / 4)) goto L33;
    L64:
        r100 = r100 * r110;
        goto L66
    L33:
        if (r108 == 0) goto L66;
        r100 = r100 * ((((long) r113) * 1024) / r108);
        goto L66
    L36:
        if (this.f554956v.f554962h.f554973n == false) goto L46;
        int r114 = NativeResourceMonitor.i(8, 0);
        if (r114 >= 0) goto L42;
        c.a r115 = c.f554959k;
        if (r115 == null) goto L42;
        r115.f554966d = -1;
    L42:
        long r116 = Math.max(0, r114);
        if (r116 >= c.f554958j) goto L45;
        c.f554958j = r116;
    L45:
        long r117 = c.f554958j;
    L47:
        long r118 = r116 - r117;
        p.a("VmMonitor: growSize: " + r118 + ", originVmSize: " + c.f554957i + ", mwaterLine: " + (((long) this.f554956v.f554962h.f554967h) * 1024));
        d r119 = this.f554956v.f554962h;
        int r120 = r119.f554967h;
        if (r118 < (((long) r120) * 1024)) goto L58;
        c.f554959k.f554966d = 2;
        if (r119.f554973n == false) goto L57;
        int r121 = NativeResourceMonitor.i(8, 0);
        if (r121 >= 0) goto L56;
        c.a r122 = c.f554959k;
        if (r122 == null) goto L56;
        r122.f554966d = -1;
    L56:
        c.f554958j = Math.max(0, r121);
    L57:
        this.f554956v.getClass();
        c.h(0);
        goto L66
    L58:
        r110 = 4;
        if (r118 <= ((((long) r120) * 1024) / 4)) goto L64;
        if (r118 == 0) goto L66;
        r110 = (((long) r120) * 1024) / r118;
        goto L64
    L46:
        r116 = Math.max(0, NativeResourceMonitor.i(7, 0));
        r117 = c.f554957i;
        goto L47
    L65:
        r101.f554966d = 1;
        goto L66
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
    public final void run() {
        l();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(c r100) {
        this.f554956v = r100;
        super("mmapWaterLineModeMonitor");
    }
}
