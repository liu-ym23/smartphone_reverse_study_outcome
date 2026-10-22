package hf4;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements com.bytedance.ies.bullet.service.webkit.c {
    public c() {
    }

    @Override // com.bytedance.ies.bullet.service.webkit.c
    public final com.bytedance.ies.bullet.service.webkit.a a(com.bytedance.ies.bullet.service.webkit.d r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new b(r100);
    }
}
