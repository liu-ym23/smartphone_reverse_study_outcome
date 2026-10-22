package u92;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements j {
    public f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
    public final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "textMessage");
        T r101 = r100.f133141b;
        int r102 = r.f133649a;
        if ((r101 instanceof c4) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((c4) r101).getBizScene(), "ecom_order_msg") == false) goto L7;
        return true;
    }
}
