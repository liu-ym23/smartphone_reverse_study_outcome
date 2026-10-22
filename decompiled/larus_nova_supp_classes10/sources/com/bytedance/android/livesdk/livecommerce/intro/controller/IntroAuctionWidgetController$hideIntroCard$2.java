package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.manager.BottomRightAnim;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "onAnimEnd", "Lkotlin/Function0;", "invoke"}, k = 3, mv = {1, 4, 3})
final class IntroAuctionWidgetController$hideIntroCard$2 extends Lambda implements Function2<View, Function0<? extends Unit>, Unit> {
    final /* synthetic */ boolean $isSwitch;
    final /* synthetic */ IntroAuctionWidgetController this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ IntroAuctionWidgetController$hideIntroCard$2 a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ View c;
        public final /* synthetic */ Function3 d;

        public a(IntroAuctionWidgetController$hideIntroCard$2 r1, Function0 r2, View r3, Function3 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            if (IntroAuctionWidgetController.c(this.a.this$0) == false) goto L6;
            this.a.this$0.t.b(220, 0, 0);
            this.b.invoke();
            return;
        L6:
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().a() == false) goto L11;
            IntroAuctionWidgetController$hideIntroCard$2 r0 = this.a;
            if (r0.$isSwitch == false) goto L10;
            BottomRightAnim r1 = BottomRightAnim.a;
            View r2 = this.c;
            Function3 r3 = this.d;
            Function0 r4 = this.b;
            r1.getClass();
            BottomRightAnim.e(r2, r3, r4);
            return;
        L10:
            BottomRightAnim r5 = BottomRightAnim.a;
            RoomContextController r6 = r0.this$0.o;
            View r7 = this.c;
            Function3 r8 = this.d;
            Function0 r9 = this.b;
            r5.getClass();
            BottomRightAnim.d(r6, r7, r8, r9);
            return;
        L11:
            BottomRightAnim r10 = BottomRightAnim.a;
            RoomContextController r11 = this.a.this$0.o;
            View r12 = this.c;
            Function3 r13 = this.d;
            Function0 r14 = this.b;
            r10.getClass();
            BottomRightAnim.c(r11, r12, r13, r14);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public IntroAuctionWidgetController$hideIntroCard$2(IntroAuctionWidgetController r1, boolean r2) {
        this.this$0 = r1;
        this.$isSwitch = r2;
        super(2);
    }

    public final void invoke(View r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "onAnimEnd");
        if (this.this$0.c.getCardState().a() != null) goto L6;
        r4.invoke();
        this.this$0.t.b(220, 0, 0);
        return;
    L6:
        new a(this, r4, r3, new IntroAuctionWidgetController$hideIntroCard$2$animatorCallback$1(this)).run();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((View) r1, (Function0) r2);
        return Unit.INSTANCE;
    }
}
