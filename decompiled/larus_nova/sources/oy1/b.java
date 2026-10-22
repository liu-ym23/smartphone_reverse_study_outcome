package oy1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements a {
    public b() {
    }

    @Override // oy1.a
    public final boolean a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        if (((com.bytedance.android.livesdk.revenue.service.interact.d) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class)).getCurrentScene() != 10) goto L6;
        int r101 = ToastUtil.f90810a;
        ToastUtil.b(s1.B(R.string.not_support_buy_goods_when_playing_short_video), 0);
        return false;
    L6:
        return true;
    }
}
