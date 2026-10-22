package mm9;

import android.app.Application;
import android.content.Context;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e implements h {
    public e() {
    }

    @Override // mm9.h
    public final void a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // mm9.h
    public final void b(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
    }

    @Override // mm9.h
    public final void beforeAttachBaseContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // mm9.h
    public final void afterAttachBaseContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IBootProtectorLauncher.f317602a.getClass();
        IBootProtectorLauncher r101 = IBootProtectorLauncher.a.c();
        if (r101 == null) goto L6;
        r101.f();
        return;
    }
}
