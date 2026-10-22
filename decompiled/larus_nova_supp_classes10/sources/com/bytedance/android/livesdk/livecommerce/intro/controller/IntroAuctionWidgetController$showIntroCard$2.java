package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.view.View;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "onAnimEnd", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
final class IntroAuctionWidgetController$showIntroCard$2 extends Lambda implements Function2<View, Function0<? extends Unit>, Unit> {
    final /* synthetic */ boolean $isFromEnterRoom;
    final /* synthetic */ boolean $isSwitch;
    final /* synthetic */ IntroAuctionWidgetController this$0;

    public IntroAuctionWidgetController$showIntroCard$2(IntroAuctionWidgetController r1, boolean r2, boolean r3) {
        this.this$0 = r1;
        this.$isFromEnterRoom = r2;
        this.$isSwitch = r3;
        super(2);
    }

    public final void invoke(View r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "onAnimEnd");
        ECContext r0 = this.this$0.o.r();
        if (r0 != null) goto L5;
    L6:
        OptCardUtil.b(null, "set bottom card visible");
        if (r0 == null) goto L11;
        m<Boolean> r1 = r0.isIntroCardVisible();
        if (r1 == null) goto L11;
        r1.setValue(Boolean.TRUE);
    L11:
        boolean r2 = IntroCardLoadOpt.f;
        if (IntroCardLoadOpt.j == false) goto L16;
        qh2.b r3 = this.this$0.u;
        if (r3 == null) goto L16;
        r3.t(true);
    L16:
        new IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1(this, r5, r6).run();
        return;
    L5:
        if (r0.isCleared() == true) goto L16;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((View) r1, (Function0) r2);
        return Unit.INSTANCE;
    }
}
