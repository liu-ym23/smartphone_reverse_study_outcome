package mc3;

import com.bytedance.android.shopping.commentv3.data.FusionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final Map<String, Object> a;

    public final boolean a() {
        FusionState.a r0 = FusionState.Companion;
        Map<String, Object> r1 = this.a;
        FusionState r2 = FusionState.FUSION;
        int r3 = nc3.a.b(r1, "fusion_state", r2.getType());
        r0.getClass();
        if (r3 != r2.getType()) goto L5;
        FusionState r4 = r2;
    L6:
        if (r4 != r2) goto L8;
        return true;
    L8:
        return false;
    L5:
        r4 = FusionState.PRODUCT;
        goto L6
    }

    public b(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a = r2;
    }
}
