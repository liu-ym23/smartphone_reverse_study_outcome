package cx;

import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.android.latch.internal.AbsLatchProcess;
import com.bytedance.android.latch.internal.perf.LatchPerfMetricCollector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class c extends AbsLatchProcess {
    public c(ix.a r100, LatchProcessOptions r110) {
        Intrinsics.checkNotNullParameter(r100, "options");
        Intrinsics.checkNotNullParameter(r110, "processOptions");
        super(r100, "", "vmsdk", new LatchPerfMetricCollector(), new b(), r110);
    }
}
