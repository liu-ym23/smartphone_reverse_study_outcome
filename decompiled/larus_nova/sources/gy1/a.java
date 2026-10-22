package gy1;

import android.content.Context;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends AbsBannerGiftPlugin {
    @Override // com.bytedance.android.livesdk.gift.platform.business.AbsBannerGiftPlugin
    public final boolean J(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        String r101 = r100.getBannerScheme();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        e0 r103 = r100.getGiftBanner();
        if (r103 == null) goto L13;
        k r104 = r103.backgroundImage;
    L14:
        if (r104 == null) goto L20;
        if (r100.getType() == 11) goto L20;
        if (r100.getType() == 12) goto L20;
        return true;
    L13:
        r104 = null;
    L20:
        return false;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public a(DataCenter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
