package y8;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f566655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f566656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f566657c = null;

    public e() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    static {
        f566655a = new e();
        f566657c = new Object();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        int r100 = d.f566654a;
        d.a(DegradeStatus.lowMemory, 0, 6);
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = f566657c;
        monitor-enter(r101);
        int r102 = f566656b;     // Catch: Throwable -> L15
        if (r102 > 0) goto L8;
        monitor-exit(r101);
        return;
    L8:
        int r103 = r102 - 1;
        f566656b = r103;     // Catch: Throwable -> L15
        if (r103 != 0) goto L12;
        r100.unregisterComponentCallbacks(this);     // Catch: Throwable -> L15
    L12:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r101);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        if (r100 == 10) goto L9;
        if (r100 != 15) goto L14;
        int r101 = d.f566654a;
        d.a(DegradeStatus.lowMemory, 0, 6);
        return;
    L14:
        return;
    L9:
        if (AnnieConfigSettingKeys.ANNIE_LOW_MEMORY_USE_LEVEL_NORMAL.a().booleanValue() == false) goto L13;
        int r102 = d.f566654a;
        d.a(DegradeStatus.lowMemory, 0, 6);
        return;
    }
}
