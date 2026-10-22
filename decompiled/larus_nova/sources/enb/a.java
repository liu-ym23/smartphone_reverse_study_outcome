package enb;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements pbc.a {
    @Inject
    public a() {
    }

    @Override // pbc.a
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
