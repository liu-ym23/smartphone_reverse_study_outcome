package oy1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements a {
    public f() {
    }

    @Override // oy1.a
    public final boolean a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == true) goto L6;
        ToastUtil.a(R.string.ttlive_core_network_unavailable, 0);
        return false;
    L6:
        return true;
    }
}
