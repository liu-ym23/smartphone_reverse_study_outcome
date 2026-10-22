package mm9;

import android.app.Application;
import android.content.Context;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p implements h {
    public p() {
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
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r101 = ISecPrivacyService.a.a();
        if (r101 == null) goto L5;
        boolean r102 = r101.a();
    L6:
        if (r102 == true) goto L11;
        ISecPrivacyService r103 = ISecPrivacyService.a.a();
        if (r103 == null) goto L12;
        r103.c(r100);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
