package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "height", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class BottomRightAnim$showLinkedAnimation$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function3 $animatorCallback;
    final /* synthetic */ RoomContextController $contextController;
    final /* synthetic */ boolean $ignoreLinkedAnim;
    final /* synthetic */ Function0 $onAnimEnd;
    final /* synthetic */ Function0 $onAnimStart;
    final /* synthetic */ View $view;

    public BottomRightAnim$showLinkedAnimation$1(View r1, Function0 r2, Function3 r3, RoomContextController r4, Function0 r5, boolean r6) {
        this.$view = r1;
        this.$onAnimEnd = r2;
        this.$animatorCallback = r3;
        this.$contextController = r4;
        this.$onAnimStart = r5;
        this.$ignoreLinkedAnim = r6;
        super(1);
    }

    public final void invoke(int r8) {
        this.$view.setAlpha(0.0f);
        BottomRightAnim$showLinkedAnimation$1$animRequest$1 r0 = new BottomRightAnim$showLinkedAnimation$1$animRequest$1(this, r8);
        if (this.$ignoreLinkedAnim == false) goto L5;
        r0.a();
        return;
    L5:
        ECContext r9 = this.$contextController.r();
        if (r9 == null) goto L38;
        com.bytedance.live.datacontext.i<CartCardLinkedAnimController> r10 = r9.getLinkedAnimController();
        if (r10 == null) goto L38;
        CartCardLinkedAnimController r11 = (CartCardLinkedAnimController) r10.getValue();
        if (r11 == null) goto L38;
        View r1 = this.$view;
        Intrinsics.checkNotNullParameter(r1, "cardView");
        if (r11.d() == true) goto L14;
    L37:
        r0.a();
        return;
    L14:
        if (r11.b == true) goto L37;
        if (r11.a(r1) == false) goto L37;
        if (r11.d == null) goto L37;
        int r2 = ECContextContainer.b;
        ECContext r3 = ECContextContainer.a.a(r11.f, Integer.valueOf(r11.g));
        if (r3 == null) goto L26;
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.isPromotionListShow();
        if (r4 == null) goto L26;
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L37;
    L26:
        yk2.c r5 = r11.d;
        if (r5 == null) goto L30;
        r5.a(true, r11.b(true));
    L30:
        if (r11.c != null) goto L32;
    L36:
        r11.c = r0;
        UtilityKotlinExtentionsKt.b.postDelayed(r11.e, 1000);
        return;
    L32:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L36;
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g r6 = r11.c;
        if (r6 == null) goto L36;
        r6.onCanceled();
    L38:
        BottomRightAnim r12 = BottomRightAnim.a;
        final RoomContextController r7 = this.$contextController;
        final View r13 = this.$view;
        final Function3 r14 = this.$animatorCallback;
        final Function0 r15 = this.$onAnimEnd;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r7, "contextController");
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r15, "onAnimEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[anim] showSwitchAnimation");
        final Function0<Integer> r16 = new BottomRightAnim$showSwitchAnimation$getViewHeight$1(r13);
        BottomRightAnim.i(r13, new BottomRightAnim$showSwitchAnimation$1(r13, r7, r15, r14, r16));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
