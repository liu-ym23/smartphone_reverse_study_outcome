package lw9;

import android.content.ClipData;
import android.content.Context;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements jn7.b {
    public b() {
    }

    @Override // jn7.b
    public final void a() {
    }

    @Override // jn7.b
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // jn7.b
    public final void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        ClipData r103 = ClipData.newPlainText("text", r101);     // Catch: Throwable -> L11
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        r104.d0();     // Catch: Throwable -> L11
        i1 r105 = i1.f346188a;
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L11
        r105.i(r100, r103, "bpea-message-share-link-copy");     // Catch: Throwable -> L11
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        FLogger.f375446a.i("ShareClipboardConfigImpl", "write clipboard failed: " + r108.getMessage());
        return;
    L19:
        return;
    L8:
        r106 = null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
