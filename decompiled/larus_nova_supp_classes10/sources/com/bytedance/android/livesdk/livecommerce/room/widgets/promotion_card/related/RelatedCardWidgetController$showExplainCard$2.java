package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.view.View;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnim;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "onAnimEnd", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
final class RelatedCardWidgetController$showExplainCard$2 extends Lambda implements Function2<View, Function0<? extends Unit>, Unit> {
    final /* synthetic */ ExplainCardViewModel $explainCardViewModel;
    final /* synthetic */ boolean $isFromMessage;
    final /* synthetic */ RelatedCardWidgetController this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardWidgetController$showExplainCard$2$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        final /* synthetic */ Function0 $onAnimEnd;
        final /* synthetic */ Runnable $onlineAnim;
        final /* synthetic */ View $view;
        final /* synthetic */ RelatedCardWidgetController$showExplainCard$2 this$0;

        public AnonymousClass1(RelatedCardWidgetController$showExplainCard$2 r1, Runnable r2, View r3, Function0 r4) {
            this.this$0 = r1;
            this.$onlineAnim = r2;
            this.$view = r3;
            this.$onAnimEnd = r4;
            super(1);
        }

        public final void invoke(Integer r4) {
            dm.a.a("RelatedCardWidgetController").i("in showExplainCard, ecom_disable_explain_card_anim decision is " + r4);
            if (EComABUtils.ecLiveExplainAnimFromMsg() == true) goto L5;
        L8:
            if (r4 != null) goto L11;
        L13:
            if (r4 != null) goto L16;
        L18:
            this.$onlineAnim.run();
            return;
        L16:
            if (r4.intValue() != 0) goto L18;
            int r5 = BottomRightAnim.a;
            BottomRightAnim.c(this.this$0.this$0.r, this.$view, this.$onAnimEnd, AnonymousClass2.INSTANCE);
            return;
        L11:
            if (r4.intValue() != 1) goto L13;
            View r6 = this.$view;
            r6.setAlpha(1.0f);
            r6.setScaleX(1.0f);
            r6.setScaleY(1.0f);
            this.$onAnimEnd.invoke();
            return;
        L5:
            if (this.this$0.$isFromMessage == true) goto L8;
            this.$onlineAnim.run();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Integer) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardWidgetController$showExplainCard$2$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Runnable $onlineAnim;

        public AnonymousClass2(Runnable r1) {
            this.$onlineAnim = r1;
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1216invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1216invoke() {
            this.$onlineAnim.run();
        }
    }

    public RelatedCardWidgetController$showExplainCard$2(RelatedCardWidgetController r1, ExplainCardViewModel r2, boolean r3) {
        this.this$0 = r1;
        this.$explainCardViewModel = r2;
        this.$isFromMessage = r3;
        super(2);
    }

    public final void invoke(final View r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "onAnimEnd");
        if (this.$explainCardViewModel.isFromLive() == false) goto L26;
        RelatedCardWidgetController r0 = this.this$0;
        RoomContextController r1 = r0.r;
        ml.b r2 = r0.m;
        if (r2 == null) goto L7;
        String r3 = r2.roomId();
    L8:
        ECContext r4 = ControllerExtensionsKt.c(r1, r3).r();
        if (r4 != null) goto L11;
    L12:
        OptCardUtil.b(null, "set bottom card visible");
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r7 = r4.isBottomCardVisible();
        if (r7 == null) goto L18;
        r7.setValue(Boolean.TRUE);
    L18:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.j == false) goto L22;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h r8 = this.this$0.b;
        if (r8 == null) goto L22;
        r8.q(true);
    L22:
        Runnable r9 = new RelatedCardWidgetController$showExplainCard$2$onlineAnim$1(this, r5, r6);
        int r10 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L25;
        r11.getStrategyService();
    L25:
        r9.run();
        return;
    L11:
        if (r4.isCleared() == true) goto L22;
    L7:
        r3 = null;
        goto L8
    L26:
        int r12 = BottomRightAnim.a;
        BottomRightAnim.d(this.this$0.r.v(), r5, r6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((View) r1, (Function0) r2);
        return Unit.INSTANCE;
    }
}
