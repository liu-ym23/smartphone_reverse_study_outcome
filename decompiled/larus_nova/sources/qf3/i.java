package qf3;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends com.bytedance.ies.web.jsbridge2.g<j, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f532727a;

    public static final class a {
    }

    static {
    }

    public i(h r100) {
        Intrinsics.checkNotNullParameter(r100, "stateChangedHandler");
        this.f532727a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(j r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f532727a.a(new j(2));
        return null;
    }
}
