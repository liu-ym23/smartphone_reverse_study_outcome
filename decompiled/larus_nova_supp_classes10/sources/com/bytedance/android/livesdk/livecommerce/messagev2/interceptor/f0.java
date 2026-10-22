package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.LynxAnchorPromotionListUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0 extends a {
    public f0() {
        super(true);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean d() {
        return !ECLiveABUtils.INSTANCE.getECOM_LIVE_MESSAGE_NO_LOGIN().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        boolean r2 = false;
        if ((r9 instanceof si2.f0) == true) goto L5;
        return false;
    L5:
        si2.f0 r10 = (si2.f0) r9;
        if (r10.updateType != 9) goto L25;
        sg2.v r1 = new sg2.v("livesdk_hot_atmosphere_message_received", com.bytedance.android.ec.common.api.jump.model.b.a);
        sg2.b r5 = r10.getCommon();
        String r6 = "NoValue";
        if (r5 == null) goto L11;
        String r7 = r5.a;
        if (r7 == null) goto L11;
    L12:
        r1.c("message_id", r7);
        ECV2HotAtmosphere r8 = r10.hotAtmosphere;
        if (r8 == null) goto L16;
        String r11 = ((ECHotAtmosphere) r8).num;
        if (r11 == null) goto L16;
    L17:
        r1.c("hot_sale_num", r11);
        ECV2HotAtmosphere r12 = r10.hotAtmosphere;
        if (r12 == null) goto L23;
        String r13 = r12.getTypeStr();
        if (r13 == null) goto L23;
        r6 = r13;
    L23:
        r1.c("hot_sale_type", r6);
        r1.c("product_id", String.valueOf(r10.productIds));
        r1.c("use_new_message", BDLocationException.ERROR_TIMEOUT);
        r1.c("handled", BDLocationException.ERROR_TIMEOUT);
        r1.i(null);
    L16:
        r11 = "NoValue";
    L11:
        r7 = "NoValue";
    L25:
        if (EComABUtils.useNewProductRefreshMessage() != 1) goto L37;
        int r3 = r10.updateType;
        if (r3 != 1) goto L29;
    L36:
        boolean r4 = true;
    L38:
        if (r4 == false) goto L40;
    L51:
        boolean r14 = LynxAnchorPromotionListUtils.a;
        Intrinsics.checkNotNullParameter(r10, "message");
        ECLiveHybridUtil.f("ecom.anchor.productUpdateMessage", tv5.a.a(u0.c(), r10));     // Catch: JSONException -> L54
    L56:
        return true;
    L54:
        e = move-exception;
        dm.a.a("ecom.anchor.productUpdateMessage").b(String.valueOf(e.getMessage()), null);
        ECExceptionMonitor.c(String.valueOf(e.getMessage()));
        goto L56
    L40:
        if (EComABUtils.useNewProductRefreshMessageAtmosphere() == true) goto L42;
    L44:
        if (r2 == true) goto L51;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o r15 = (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o) b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.o.class, r10);
        if (r15 == null) goto L48;
        r15.d(r10);
    L48:
        lj2.a r16 = (lj2.a) b(lj2.a.class, r10);
        if (r16 == null) goto L51;
        r16.d(r10);
        goto L51
    L42:
        if (r10.updateType != 9) goto L44;
        r2 = true;
        goto L44
    L29:
        if (r3 == 3) goto L36;
        if (r3 == 6) goto L36;
        if (r3 == 11) goto L36;
        if (r3 == 12) goto L36;
    L37:
        r4 = false;
        goto L38
    }
}
