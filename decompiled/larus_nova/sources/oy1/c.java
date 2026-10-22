package oy1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements a {
    public c() {
    }

    @Override // oy1.a
    public final boolean a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        k0 r101 = r100.getGiftPreviewInfo();
        if (r101 != null) goto L5;
    L6:
        k0 r102 = r100.getGiftPreviewInfo();
        if (r102 != null) goto L9;
    L22:
        return true;
    L9:
        if (r102.getClientBlockUseSchemeUrl() == false) goto L22;
        if (r102.getBlockToast().length() <= 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L20;
        String r104 = UriProtector.parse(r102.getBlockSchemeUrl()).getHost();
        if (r104 != null) goto L18;
    L19:
        int r105 = ToastUtil.f90810a;
        ToastUtil.b(r102.getBlockToast(), 0);
        goto L20
    L18:
        if (StringsKt.startsWith$default(r104, "webcast_inroom_toast", false, 2, null) != true) goto L19;
    L20:
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(s1.getContext(), r102.getBlockSchemeUrl());
        return false;
    L13:
        r103 = false;
        goto L14
    L5:
        if (r101.getLockStatus() == k0.UNLOCKED) goto L22;
        goto L6
    }
}
