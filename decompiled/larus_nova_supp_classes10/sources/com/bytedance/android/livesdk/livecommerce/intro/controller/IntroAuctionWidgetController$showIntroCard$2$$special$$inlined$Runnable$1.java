package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.manager.BottomRightAnim;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1 implements Runnable {
    public final /* synthetic */ IntroAuctionWidgetController$showIntroCard$2 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;

    public static final class a implements Runnable {
        public final /* synthetic */ IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1 a;

        public a(IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1 r0 = this.a;     // Catch: Throwable -> L4
            r0.a.this$0.t.b(120, r0.b.getHeight(), this.a.a.this$0.t.a(1.0f));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1(IntroAuctionWidgetController$showIntroCard$2 r1, View r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (IntroAuctionWidgetController.c(this.a.this$0) == false) goto L5;
    L24:
        View r0 = this.b;
        r0.setAlpha(1.0f);
        r0.setScaleX(1.0f);
        r0.setScaleY(1.0f);
        this.c.invoke();
        this.b.post(new a(this));
        return;
    L5:
        if (this.a.$isFromEnterRoom == true) goto L7;
    L11:
        Function3<Integer, Integer, Float, Unit> r1 = new IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1$lambda$2(this);
        IntroAuctionWidgetController$showIntroCard$2 r2 = this.a;
        if (r2.$isFromEnterRoom == true) goto L14;
    L16:
        boolean r4 = false;
    L18:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().a() == false) goto L23;
        IntroAuctionWidgetController$showIntroCard$2 r3 = this.a;
        if (r3.$isSwitch == false) goto L22;
        BottomRightAnim r5 = BottomRightAnim.a;
        RoomContextController r6 = r3.this$0.o;
        View r7 = this.b;
        Function0 r8 = this.c;
        Function0<Unit> r9 = new IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1$lambda$3(this);
        r5.getClass();
        BottomRightAnim.h(r6, r7, r1, r8, r9);
        return;
    L22:
        BottomRightAnim.a.g(r3.this$0.o, this.b, r4, r1, this.c, new IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1$lambda$4(this));
        return;
    L23:
        BottomRightAnim r10 = BottomRightAnim.a;
        RoomContextController r11 = this.a.this$0.o;
        View r12 = this.b;
        Function0 r13 = this.c;
        Function0<Unit> r14 = new IntroAuctionWidgetController$showIntroCard$2$$special$$inlined$Runnable$1$lambda$5(this);
        r10.getClass();
        BottomRightAnim.f(r11, r12, r4, r1, r13, r14);
        return;
    L14:
        if (IntroAuctionWidgetController.b(r2.this$0) == false) goto L16;
        r4 = true;
        goto L18
    L7:
        if (((Boolean) IntroAuctionWidgetController.w.getValue()).booleanValue() == false) goto L11;
        if (IntroAuctionWidgetController.b(this.a.this$0) == true) goto L11;
        goto L11
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
