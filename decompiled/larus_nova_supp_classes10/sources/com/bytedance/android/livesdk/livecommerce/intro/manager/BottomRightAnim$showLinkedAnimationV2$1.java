package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "height", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class BottomRightAnim$showLinkedAnimationV2$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function3 $animatorCallback;
    final /* synthetic */ RoomContextController $contextController;
    final /* synthetic */ boolean $ignoreLinkedAnim;
    final /* synthetic */ Function0 $onAnimEnd;
    final /* synthetic */ Function0 $onAnimStart;
    final /* synthetic */ View $view;
    final /* synthetic */ BottomRightAnim this$0;

    public BottomRightAnim$showLinkedAnimationV2$1(BottomRightAnim r1, View r2, Function0 r3, Function3 r4, Function0 r5, RoomContextController r6, boolean r7) {
        this.this$0 = r1;
        this.$view = r2;
        this.$onAnimStart = r3;
        this.$animatorCallback = r4;
        this.$onAnimEnd = r5;
        this.$contextController = r6;
        this.$ignoreLinkedAnim = r7;
        super(1);
    }

    public final void invoke(int r7) {
        this.$view.setAlpha(0.0f);
        BottomRightAnim$showLinkedAnimationV2$1$animRequest$1 r0 = new BottomRightAnim$showLinkedAnimationV2$1$animRequest$1(this, r7);
        if (this.$ignoreLinkedAnim == false) goto L5;
        r0.a();
        return;
    L5:
        ECContext r8 = this.$contextController.r();
        if (r8 == null) goto L42;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r9 = r8.getLinkedAnimController();
        if (r9 == null) goto L42;
        CartCardLinkedAnimController r10 = (CartCardLinkedAnimController) r9.getValue();
        if (r10 == null) goto L42;
        View r1 = this.$view;
        Intrinsics.checkNotNullParameter(r1, "cardView");
        if (r10.d() == true) goto L14;
    L41:
        r0.a();
        return;
    L14:
        if (r10.b == true) goto L41;
        if (r10.a(r1) == false) goto L41;
        if (r10.d == null) goto L41;
        int r2 = ECContextContainer.b;
        ECContext r3 = ECContextContainer.a.a(r10.f, Integer.valueOf(r10.g));
        if (r3 == null) goto L26;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.isPromotionListShow();
        if (r4 == null) goto L26;
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L41;
    L26:
        yk2.c r5 = r10.d;
        if (r5 == null) goto L34;
        if (EComABUtils.isToolbarIconOpt() == false) goto L31;
        List r6 = (List) CartCardLinkedAnimController.i.getValue();
    L32:
        r5.a(true, new com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.webp.e(r6));
        goto L34
    L31:
        r6 = CollectionsKt.listOf(new String[]{"https://lf3-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_has_flower_v2.4.webp", "https://lf9-static.bytednsdoc.com/obj/eden-cn/uhkpozpbn/eclive/cart/v2/ec_live_cart_has_flower_v2.4.webp"});
    L34:
        if (r10.c != null) goto L36;
    L40:
        r10.c = r0;
        UtilityKotlinExtentionsKt.b.postDelayed(r10.e, 1000);
        return;
    L36:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L40;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g r11 = r10.c;
        if (r11 == null) goto L40;
        r11.onCanceled();
    L42:
        BottomRightAnim r12 = BottomRightAnim.a;
        RoomContextController r13 = this.$contextController;
        View r14 = this.$view;
        Function3 r15 = this.$animatorCallback;
        Function0 r16 = this.$onAnimEnd;
        Function0 r17 = this.$onAnimStart;
        r12.getClass();
        BottomRightAnim.h(r13, r14, r15, r16, r17);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
