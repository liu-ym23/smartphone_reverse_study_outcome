package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "height", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BottomRightAnim$showLinkedAnimation$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ RoomContextController $contextController;
    final /* synthetic */ boolean $ignoreLinkedAnim;
    final /* synthetic */ Function0 $onAnimEnd;
    final /* synthetic */ Function0 $onAnimStart;
    final /* synthetic */ View $view;

    public static final class a implements g {
        public boolean a;
        public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1 b;
        public final /* synthetic */ int c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnim$showLinkedAnimation$1$a$a, reason: collision with other inner class name */
        public static final class C0105a extends AnimatorListenerAdapter {
            public final /* synthetic */ a a;

            public C0105a(a r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                this.a.b.$onAnimEnd.invoke();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                a r3 = this.a;
                if (r3.a == true) goto L6;
                r3.a = true;
                r3.b.$onAnimStart.invoke();
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void c(int r1) {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void a() {
            View r0 = this.b.$view;
            r0.setAlpha(0.05f);
            r0.setScaleX(0.5f);
            r0.setScaleY(0.5f);
            if (this.b.$contextController.v() == false) goto L5;
            float r1 = r0.getWidth();
        L6:
            r0.setPivotX(r1);
            r0.setPivotY(this.c);
            ViewPropertyAnimator r2 = r0.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f);
            r2.setDuration(160);
            int r3 = BottomRightAnim.a;
            r2.setInterpolator(new d());
            r2.setListener(new C0105a(this)).start();
            return;
        L5:
            r1 = 0.0f;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void b() {
            if (this.a == true) goto L6;
            this.a = true;
            this.b.$onAnimStart.invoke();
            return;
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
        public final void onCanceled() {
            a();
        }

        public a(BottomRightAnim$showLinkedAnimation$1 r1, int r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public BottomRightAnim$showLinkedAnimation$1(View r1, RoomContextController r2, Function0 r3, Function0 r4, boolean r5) {
        this.$view = r1;
        this.$contextController = r2;
        this.$onAnimEnd = r3;
        this.$onAnimStart = r4;
        this.$ignoreLinkedAnim = r5;
        super(1);
    }

    public final void invoke(int r6) {
        this.$view.setAlpha(0.0f);
        a r0 = new a(this, r6);
        if (this.$ignoreLinkedAnim == false) goto L6;
        r0.a();
        return;
    L6:
        if (this.$contextController.v() == false) goto L8;
        RoomContextController r7 = this.$contextController;
    L9:
        ECContext r1 = r7.r();
        if (r1 == null) goto L42;
        i<CartCardLinkedAnimController> r2 = r1.getLinkedAnimController();
        if (r2 == null) goto L42;
        CartCardLinkedAnimController r3 = (CartCardLinkedAnimController) r2.getValue();
        if (r3 == null) goto L42;
        View r8 = this.$view;
        Intrinsics.checkNotNullParameter(r8, "cardView");
        if (r3.d() == true) goto L18;
    L41:
        r0.a();
        return;
    L18:
        if (r3.b == true) goto L41;
        if (r3.a(r8) == false) goto L41;
        if (r3.d == null) goto L41;
        int r9 = ECContextContainer.b;
        ECContext r10 = ECContextContainer.a.a(r3.f, Integer.valueOf(r3.g));
        if (r10 == null) goto L30;
        m<Boolean> r11 = r10.isPromotionListShow();
        if (r11 == null) goto L30;
        if (((Boolean) r11.getValue()).booleanValue() == true) goto L41;
    L30:
        yk2.c r12 = r3.d;
        if (r12 == null) goto L34;
        r12.b(true, CartCardLinkedAnimController.c(true), r3.b(true));
    L34:
        if (r3.c != null) goto L36;
    L40:
        r3.c = r0;
        UtilityKotlinExtentionsKt.b.postDelayed(r3.e, 1000);
        return;
    L36:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L40;
        g r13 = r3.c;
        if (r13 == null) goto L40;
        r13.onCanceled();
    L42:
        int r4 = BottomRightAnim.a;
        BottomRightAnim.d(r7.v(), this.$view, this.$onAnimEnd);
        return;
    L8:
        int r14 = RoomContextController.h;
        r7 = RoomContextController.a.a();
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
