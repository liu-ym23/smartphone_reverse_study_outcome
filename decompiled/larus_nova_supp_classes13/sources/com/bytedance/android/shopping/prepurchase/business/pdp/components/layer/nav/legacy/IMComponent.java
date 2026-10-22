package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.IMMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.verify.AuthUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class IMComponent {
    public final l a;
    public final View b;
    public final IMMeta c;
    public final String d;

    public final void b() {
        if (com.bytedance.android.shopping.utils.i.a() == false) goto L5;
        int r0 = AuthUtils.a;
        AuthUtils.a(d0.a.getActivity(this.b), this.c.getPromotionSource(), null, new IMComponent$logAndAction$1(this));
        return;
    L5:
        a(this.c);
    }

    public final void a(final IMMeta r12) {
        com.bytedance.android.ec.sdk.helper.r r0 = com.bytedance.android.ec.sdk.helper.r.a;
        Unit r3 = null;
        if (r0.isLogin() == false) goto L37;
        final String r13 = r12.getImUrl();
        if (r13 == null) goto L36;
        int r1 = ECSdk.a;
        IVisitUnit r2 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r2 == null) goto L9;
        r2.hookToSchema(VisitActions.PDP_OUT_IM.getKey(), new IMComponent$doRealActionAndLog$1$1(r13));
    L9:
        int r4 = com.bytedance.android.shopping.anchorv3.utils.v.a;
        com.bytedance.android.shopping.anchorv3.utils.v.e(r13, this.d, this.b);
        int r5 = com.bytedance.android.shopping.anchorv3.utils.a.a;
        CommonMeta r6 = this.a.a();
        if (r6 == null) goto L12;
        Boolean r7 = Boolean.valueOf(r6.isLuban());
    L13:
        boolean r8 = com.bytedance.android.shopping.extensions.k.i(r7);
        CommonMeta r9 = this.a.a();
        if (r9 == null) goto L16;
        ECAdLogExtra r10 = r9.getAdLogExtra();
    L17:
        CommonMeta r11 = this.a.a();
        if (r11 == null) goto L20;
        String r14 = r11.getPromotionId();
    L21:
        if (r14 != null) goto L23;
        String r15 = "";
    L24:
        CommonMeta r16 = this.a.a();
        if (r16 == null) goto L27;
        Integer r17 = Integer.valueOf((int) r16.getPromotionSource());
    L28:
        CommonMeta r18 = this.a.a();
        if (r18 == null) goto L31;
        Long r19 = r18.getProductMinPrice();
    L32:
        com.bytedance.android.shopping.anchorv3.utils.a.d(r8, r10, r15, r17, r19, this.a.getDuration());
        final String r20 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(this.d, Boolean.FALSE).withView(this.b).build());
        this.a.d(new IMComponent$doRealActionAndLog$$inlined$let$lambda$1(r20, this));
        Map r21 = ECParamTrackerCenter.a;
        com.bytedance.android.ec.core.monitor.param.a r22 = ECParamTrackerCenter.c(this.a.getSessionId());
        if (r22 == null) goto L35;
        r22.g("im", r13);
        r3 = Unit.INSTANCE;
    L35:
        if (r3 == null) goto L36;
        return;
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
        goto L28
    L23:
        r15 = r14;
        goto L24
    L20:
        r14 = null;
        goto L21
    L16:
        r10 = null;
        goto L17
    L12:
        r7 = null;
    L36:
        Set r110 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.c.j(ECProcessMonitor.c("ec_product_detail", "enter_im"), -2);
        Unit r111 = Unit.INSTANCE;
        return;
    L37:
        Unit r23 = this.b.getContext();
        if ((r23 instanceof Activity) == false) goto L41;
        r3 = r23;
    L41:
        Activity r24 = (Activity) r3;
        Intrinsics.checkNotNull(r24);
        String r25 = r12.getSourcePage();
        if (r25 != null) goto L44;
        r25 = "";
    L44:
        String r26 = r12.getEnterMethod();
        if (r26 != null) goto L47;
        r26 = "";
    L47:
        r0.showLogin(r24, r25, r26, new IMComponent$doRealActionAndLog$3(this, r12), new IMComponent$doRealActionAndLog$4(this, r12));
    }

    public IMComponent(l r2, View r3, IMMeta r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "theView");
        Intrinsics.checkNotNullParameter(r4, "imMeta");
        Intrinsics.checkNotNullParameter(r5, "btmId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
