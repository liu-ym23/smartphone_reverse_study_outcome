package qf3;

import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.ies.web.jsbridge2.g<j, Object> {
    public final g a;

    public static final class a {
    }

    static {
    }

    public i(h r2) {
        Intrinsics.checkNotNullParameter(r2, "stateChangedHandler");
        this.a = r2;
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((j) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a.a(new j(2));
        return null;
    }
}
