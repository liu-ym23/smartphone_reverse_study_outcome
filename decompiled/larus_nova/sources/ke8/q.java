package ke8;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q extends le8.a<he8.d> {
    @Override // le8.b
    public final void a(ie8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // le8.a
    public final void b() {
    }

    public q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
