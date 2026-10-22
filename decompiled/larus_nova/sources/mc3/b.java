package mc3;

import com.bytedance.android.shopping.commentv3.data.FusionState;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f512872a;

    public final boolean a() {
        FusionState.a r100 = FusionState.Companion;
        Map<String, Object> r101 = this.f512872a;
        FusionState r102 = FusionState.FUSION;
        int r103 = nc3.a.b(r101, "fusion_state", r102.getType());
        r100.getClass();
        if (r103 != r102.getType()) goto L5;
        FusionState r104 = r102;
    L6:
        if (r104 != r102) goto L8;
        return true;
    L8:
        return false;
    L5:
        r104 = FusionState.PRODUCT;
        goto L6
    }

    public b(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f512872a = r100;
    }
}
