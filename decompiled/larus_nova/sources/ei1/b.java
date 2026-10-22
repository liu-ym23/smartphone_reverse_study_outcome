package ei1;

import com.bytedance.android.livesdk.room.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends c<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public b() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void u(com.bytedance.android.livesdk.room.b r100) {
        r100.f("data_device_fold_state", new a(this, jk1.a.c(r100)));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
