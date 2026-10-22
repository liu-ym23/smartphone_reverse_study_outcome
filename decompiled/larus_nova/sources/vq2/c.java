package vq2;

import com.bytedance.android.livesdk.revenue.condition.RevConditionType;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant$ConditionType;
import com.bytedance.android.scope.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements a, o {
    public c() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vq2.a
    public final void g7(RevConditionType r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        xs2.b r101 = xs2.b.a();
        if (b.f556758a[r100.ordinal()] != 1) goto L7;
        r101.post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant$ConditionType.SHOW_GIFT_EFFECT));
        return;
    L7:
        throw new NoWhenBranchMatchedException();
    }
}
