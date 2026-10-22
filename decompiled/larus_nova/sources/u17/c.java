package u17;

import android.os.Debug;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IOOMCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f548308a;

    public c() {
        this.f548308a = e.a.f548311a;
    }

    @Override // com.bytedance.crash.IOOMCallback
    public final void onCrash(CrashType r100, Throwable r101, Thread r102, long r103) {
        r17.c.b("onCrash callback", new Object[0]);
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof OutOfMemoryError) == true) goto L23;
        s17.d.f().getClass();
        if (s17.d.a() == false) goto L24;
        e r104 = this.f548308a;
        r104.getClass();
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L10:
        if ((System.currentTimeMillis() - r104.f548309a) < 60000) goto L25;
        r104.f548309a = System.currentTimeMillis();     // Catch: Throwable -> L17
        t17.a.c("npth_dump_begin");     // Catch: Throwable -> L17
        q17.a.e().f().getDumpAndShrinkConfig();     // Catch: Throwable -> L17
        PolarisFileWrapper r105 = new PolarisFileWrapper(s17.c.b().f540163e, "npth.jpg");     // Catch: Throwable -> L17
        if (r105.exists() == false) goto L15;
        r105.delete();     // Catch: Throwable -> L17
    L15:
        Debug.dumpHprofData(r105.getAbsolutePath());     // Catch: Throwable -> L17
        t17.a.c("npth_dump_end");     // Catch: Throwable -> L17
        r17.c.b("onCrash dump finish:" + r105.getAbsolutePath(), new Object[0]);     // Catch: Throwable -> L17
        return;
    L25:
        return;
    L24:
        return;
    }
}
