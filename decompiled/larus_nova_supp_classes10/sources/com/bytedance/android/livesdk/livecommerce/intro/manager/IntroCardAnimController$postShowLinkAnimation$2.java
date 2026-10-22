package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "animView", "Landroid/view/View;", "onEnd", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
final class IntroCardAnimController$postShowLinkAnimation$2 extends Lambda implements Function2<View, Function0<? extends Unit>, Unit> {
    final /* synthetic */ Function0 $onAnimInvoked;
    final /* synthetic */ IntroCardAnimController this$0;

    public IntroCardAnimController$postShowLinkAnimation$2(IntroCardAnimController r1, Function0 r2) {
        this.this$0 = r1;
        this.$onAnimInvoked = r2;
        super(2);
    }

    public final void invoke(View r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "animView");
        Intrinsics.checkNotNullParameter(r10, "onEnd");
        Function0 r0 = this.$onAnimInvoked;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke();
    L5:
        Function3<Integer, Integer, Float, Unit> r2 = new IntroCardAnimController$postShowLinkAnimation$2$animatorCallback$1(this);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().a() == false) goto L8;
        BottomRightAnim.a.g(this.this$0.i, r9, false, r2, r10, AnonymousClass1.INSTANCE);
        return;
    L8:
        BottomRightAnim r3 = BottomRightAnim.a;
        RoomContextController r4 = this.this$0.i;
        AnonymousClass2 r6 = AnonymousClass2.INSTANCE;
        r3.getClass();
        BottomRightAnim.f(r4, r9, false, r2, r10, r6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((View) r1, (Function0) r2);
        return Unit.INSTANCE;
    }
}
