package cu8;

import com.bytedance.sysoptimizer.anr.AnrManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f465442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f465443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f465444c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f465445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f465446e;

    static {
        f465442a = new CopyOnWriteArrayList();
        f465444c = 5;
    }

    public static void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) f465442a;
        if (r101.contains(r100) == false) goto L5;
        return;
    L5:
        nu8.a.e("FlowAnrMonitor", "registerANRListener result: " + r101.add(r100));
        if ((!r101.isEmpty()) == true) goto L8;
        return;
    L8:
        if (f465443b != null) goto L12;
        f465443b = new b();
        nu8.a.e("FlowAnrMonitor", "startSysOptimizerAnrMonitor");
        AnrManager.getInstance().registerListener(f465443b);
        return;
    }
}
