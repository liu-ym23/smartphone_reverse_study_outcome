package u9;

import android.content.Context;
import com.bytedance.android.annie.bridge.method.z1;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements c {
    public a() {
    }

    @Override // u9.c
    public final void e1(Context r100, z1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "scanResultCallback");
        r101.a();
    }
}
