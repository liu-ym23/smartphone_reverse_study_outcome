package en6;

import android.content.Context;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.host.perf.PerfStandard;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m implements nq6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f473176a = null;

    static {
        f473176a = new m();
    }

    public m() {
    }

    public final int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return HostServiceUtilsKt.V().h(r100);
    }

    public final int b(PerfStandard r100) {
        Intrinsics.checkNotNullParameter(r100, "standard");
        return HostServiceUtilsKt.V().c(r100);
    }
}
