package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.app.Activity;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o implements ExpandableLinearLayoutV4.c {
    public final /* synthetic */ AnchorV4DetailSkuPropertiesFragment a;

    public o(AnchorV4DetailSkuPropertiesFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.ExpandableLinearLayoutV4.c
    public final void a(ExpandableLinearLayoutV4.d r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        if ((r9 instanceof ExpandableLinearLayoutV4.d.a) == false) goto L6;
        return;
    L6:
        if ((r9 instanceof ExpandableLinearLayoutV4.d.b) == false) goto L9;
        return;
    L9:
        if ((r9 instanceof ExpandableLinearLayoutV4.d.c) == false) goto L51;
        AnchorV4DetailSkuPropertiesFragment r10 = this.a;
        int r0 = AnchorV4DetailSkuPropertiesFragment.o;
        r10.getClass();
        Activity r1 = ECAppInfoService.e.getCurrentActivity();
        if (r1 == null) goto L40;
        int r2 = c.a;
        AnchorV4DetailSkuVO r3 = r10.k.getVo();
        if (r3 == null) goto L15;
        String r4 = r3.getJumpUrl();
    L16:
        t r5 = r10.k.getViewModel();
        AnchorV4DetailSkuVO r6 = r10.k.getVo();
        if (r6 == null) goto L20;
        String r7 = r6.getSkuId();
        if (r7 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r7, "activeId");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "activeId");
        if (r4 == null) goto L38;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("active_id", r7);
        if (r5 == null) goto L30;
        CommonMeta r11 = r5.a();
        if (r11 == null) goto L30;
        String r12 = r11.getPromotionId();
        if (r12 == null) goto L30;
        r8.put(PdpOpenThirdParam.KEY_PROMOTION_ID, r12);
    L30:
        if (r5 == null) goto L34;
        CommonMeta r13 = r5.a();
        if (r13 == null) goto L34;
        int r14 = com.bytedance.android.shopping.anchorv4.containers.b.a;
        r8.put("track_params", com.bytedance.android.shopping.anchorv4.containers.b.a(r13, r5.b()).toString());
    L34:
        String r15 = p0.b(r4, r8);
        if (r15 == null) goto L38;
        r4 = r15;
    L38:
        if (r4 == null) goto L40;
        ECLiveHybridUtil.k(r1, r4, false, false, false, null, 252);
    L20:
        r7 = "";
        goto L21
    L15:
        r4 = null;
    L40:
        int r16 = b.a;
        t r17 = r10.k.getViewModel();
        AnchorV4DetailSkuVO r18 = r10.k.getVo();
        boolean r19 = false;
        if (r18 == null) goto L45;
        List<AnchorV4SubProduct> r20 = r18.getSubProducts();
        if (r20 == null) goto L45;
        int r21 = r20.size();
    L46:
        AnchorV4DetailSkuVO r22 = r10.k.getVo();
        if (r22 == null) goto L49;
        r19 = r22.getShowBottomView();
    L49:
        b.a(r17, r21, r19, "");
        return;
    L45:
        r21 = 0;
        goto L46
    }
}
