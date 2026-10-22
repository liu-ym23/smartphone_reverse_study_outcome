package x02;

import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends d0 {
    public f() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final void c(com.bytedance.android.livesdk.gift.platform.core.model.t r100, p2 r101, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r102, Function1<? super y, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Intrinsics.checkNotNullParameter(r103, "nextPlugin");
        super.c(r100, r101, r102, r103);
        if (r100.a().f130922b <= 0) goto L6;
        ((ar2.a) vh6.c.b(ar2.a.class)).z5();
        return;
    }
}
