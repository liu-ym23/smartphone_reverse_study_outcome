package oy1;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements a {
    public g() {
    }

    @Override // oy1.a
    public final boolean a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        if (((wh6.a) vh6.c.b(wh6.a.class)).isNeedProtectUnderage() == false) goto L6;
        ToastUtil.a(R.string.ttlive_live_protect_underage, 0);
        return false;
    L6:
        return true;
    }
}
