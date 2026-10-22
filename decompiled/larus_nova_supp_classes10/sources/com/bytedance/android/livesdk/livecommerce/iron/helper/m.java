package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.response.StepperActionType;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.livesdk.livecommerce.network.response.ECCartItem;
import com.bytedance.android.livesdk.livecommerce.network.response.ECCartItemBasicInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartData;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartResponse;
import com.bytedance.android.livesdk.livecommerce.network.response.ECShopCartItem;
import com.bytedance.common.utility.UIUtils;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import org.greenrobot.eventbus.EventBus;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements v0<ECEditCartResponse> {
    public final /* synthetic */ PromotionJumpDispatcher a;
    public final /* synthetic */ StepperActionType b;
    public final /* synthetic */ ql.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ cf.a f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ Context n;

    @Override // vi2.v0
    public final void onError(Throwable r2) {
        StepperActionType r3 = this.b;
        int r4 = g.m[r3.ordinal()];
        if (r4 != 1) goto L5;
        Context r5 = this.n;
        UIUtils.displayToast(r5, th.a.g(r5, 2131896302));
        return;
    L5:
        if (r4 != 2) goto L11;
        Context r6 = this.n;
        UIUtils.displayToast(r6, th.a.g(r6, 2131896881));
        return;
    }

    @Override // vi2.v0
    public final void onSuccess(ECEditCartResponse r30) {
        ECEditCartResponse r1 = r30;
        int r2 = 0;
        String r5 = null;
        List<CartNumWithBusinessLine> r6 = null;
        List<CartNumWithBusinessLine> r7 = null;
        if (r1 != null) goto L5;
    L45:
        if (r1 == null) goto L51;
        String r3 = ((com.bytedance.android.ec.model.g) r1).statusMessage;
        if (r3 == null) goto L51;
        if (a2.b(r3) != true) goto L51;
        UIUtils.displayToast(this.n, ((com.bytedance.android.ec.model.g) r1).statusMessage);
    L69:
        PromotionJumpDispatcher r8 = this.a;
        ql.a r9 = this.c;
        com.bytedance.android.ec.common.api.jump.model.g r10 = this.i;
        String r11 = this.j;
        String r12 = this.k;
        String r13 = this.l;
        String r14 = this.m;
        com.bytedance.android.ec.model.response.v r4 = r9.getStepperInfo();
        if (r4 == null) goto L72;
        int r15 = r4.b();
    L73:
        if (r1 == null) goto L75;
        int r16 = ((com.bytedance.android.ec.model.g) r1).statusCode;
    L76:
        PromotionJumpDispatcher.u(r8, r9, r10, r11, r12, r13, false, r14, r15, r16);
        return;
    L75:
        r16 = -1;
        goto L76
    L72:
        r15 = 0;
    L51:
        if (r1 == null) goto L62;
        ECEditCartData r17 = r1.getEditCartData();
        if (r17 == null) goto L62;
        String r18 = r17.getToastMsg();
        if (r18 == null) goto L62;
        if (a2.b(r18) != true) goto L62;
        Context r19 = this.n;
        ECEditCartData r20 = r1.getEditCartData();
        if (r20 == null) goto L61;
        r5 = r20.getToastMsg();
    L61:
        UIUtils.displayToast(r19, r5);
    L62:
        StepperActionType r21 = this.b;
        int r22 = g.l[r21.ordinal()];
        if (r22 != 1) goto L65;
        Context r23 = this.n;
        UIUtils.displayToast(r23, th.a.g(r23, 2131896302));
        goto L69
    L65:
        if (r22 != 2) goto L69;
        Context r24 = this.n;
        UIUtils.displayToast(r24, th.a.g(r24, 2131896881));
        goto L69
    L5:
        if (((com.bytedance.android.ec.model.g) r1).statusCode != 0) goto L45;
        ECEditCartData r25 = r1.getEditCartData();
        if (r25 == null) goto L9;
        r2 = r25.getCartNum();
    L9:
        StepperActionType r26 = this.b;
        int r27 = g.j[r26.ordinal()];
        if (r27 == 1) goto L17;
        if (r27 != 2) goto L21;
        EventBus r110 = EventBus.getDefault();
        String r28 = this.c.getProductId();
        if (r25 == null) goto L16;
        r6 = r25.getCartNumWithBusinessLine();
    L16:
        int r29 = r2;
        List<CartNumWithBusinessLine> r111 = r6;
        r110.post(new hl.b(r29, null, 201, r28, r111, this.d, String.valueOf(this.e), "edit_cart_from_stepper", null, null, null, null, null, null, false, null, null, null, 1048320));
    L21:
        EventBus.getDefault().post(new hl.d(r2));
        EventBus.getDefault().post(new hl.g(r2, true));
        StepperActionType r31 = this.b;
        int r32 = g.k[r31.ordinal()];
        if (r32 != 1) goto L24;
        String r33 = "stepper_add";
    L29:
        String r112 = r33;
        if (r25 == null) goto L44;
        List<ECShopCartItem> r34 = r25.getShopCartItem();
        if (r34 == null) goto L44;
        ECShopCartItem r35 = (ECShopCartItem) CollectionsKt.firstOrNull(r34);
        if (r35 == null) goto L44;
        List<ECCartItem> r36 = r35.getCartItemList();
        if (r36 == null) goto L44;
        ECCartItem r37 = (ECCartItem) CollectionsKt.firstOrNull(r36);
        if (r37 == null) goto L44;
        ECCartItemBasicInfo r38 = r37.getBasicInfo();
        if (r38 == null) goto L44;
        cf.a r39 = this.f;
        if (r39 == null) goto L44;
        r39.b(r38.getComboNum(), r38.getProductId(), this.g, r38.getCartId(), 201, this.h, r38.getComboId(), Integer.valueOf(r38.getComboNum()), r112);
    L44:
        PromotionJumpDispatcher.u(this.a, this.c, this.i, this.j, this.k, this.l, true, this.m, this.e, ((com.bytedance.android.ec.model.g) r1).statusCode);
        return;
    L24:
        if (r32 != 2) goto L27;
        r33 = "stepper_sub";
        goto L29
    L27:
        throw new NoWhenBranchMatchedException();
    L17:
        EventBus r40 = EventBus.getDefault();
        String r41 = this.c.getProductId();
        if (r25 == null) goto L20;
        r7 = r25.getCartNumWithBusinessLine();
    L20:
        r40.post(new hl.f(r41, r7, this.d, String.valueOf(this.e)));
        goto L21
    }

    public m(PromotionJumpDispatcher r1, StepperActionType r2, ql.a r3, String r4, int r5, cf.a r6, String r7, String r8, com.bytedance.android.ec.common.api.jump.model.g r9, String r10, String r11, String r12, String r13, Context r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
