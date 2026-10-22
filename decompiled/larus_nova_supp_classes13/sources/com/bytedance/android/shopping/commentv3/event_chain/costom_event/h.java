package com.bytedance.android.shopping.commentv3.event_chain.costom_event;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.bytedance.android.shopping.commentv3.action.ActionType;
import com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder.FilterCardViewHolder;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends com.bytedance.android.shopping.commentv3.event_chain.a {

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ hc3.b a;

        public a(hc3.b r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Object r4 = r3.getAnimatedValue();
            if ((r4 instanceof Integer) == true) goto L5;
            r4 = null;
        L5:
            Integer r5 = (Integer) r4;
            if ((r5 instanceof Integer) == false) goto L18;
            View r0 = this.a.g;
            if (r0 == null) goto L14;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L14;
            r1.height = r5.intValue();
            View r2 = this.a.g;
            if (r2 == null) goto L14;
            r2.setLayoutParams(r1);
        L14:
            Function1<? super Integer, Unit> r6 = this.a.f;
            if (r6 == null) goto L19;
            Unit r7 = (Unit) r6.invoke(r5);
            return;
        L19:
            return;
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ hc3.b a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ FilterCardViewHolder.a c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == true) goto L5;
            this.c.a = true;
        L5:
            this.a.e.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == false) goto L6;
            this.c.a = false;
            return;
        }

        public b(hc3.b r1, boolean r2, FilterCardViewHolder.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public h(Context r2, com.bytedance.android.shopping.commentv3.data.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(ActionType.FILTER_EXPAND.getType());
    }

    @Override // com.bytedance.android.shopping.commentv3.event_chain.a
    public final void c(EventContext r9, fc3.a r10, fc3.c r11, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "eventContext");
        Intrinsics.checkNotNullParameter(r10, "actionContext");
        Intrinsics.checkNotNullParameter(r11, "handleActionParams");
        Intrinsics.checkNotNullParameter(r12, "completion");
        Map<String, ? extends fc3.b> r13 = r11.c;
        if (r13 == null) goto L5;
        fc3.b r14 = r13.get(((t96.a) this).a);
    L7:
        if ((r14 instanceof hc3.b) == true) goto L9;
        r14 = null;
    L9:
        hc3.b r15 = (hc3.b) r14;
        if (r15 != null) goto L12;
    L31:
        dm.a.a("CommentAbsCommonChainEventImpl").i("don't have FilterExpandParams");
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r12.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "FilterExpandEvent don't have FilterExpandParams", null, null, 57));
        return;
    L12:
        if (r15.a <= 0) goto L19;
        int r0 = r15.b;
        if (r0 <= 0) goto L19;
        int r1 = r15.c;
        if (r1 <= 0) goto L19;
        if (r0 >= r1) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == false) goto L31;
        FilterCardViewHolder.a r3 = r15.d;
        boolean r4 = r3.a;
        if (r4 == false) goto L25;
        int r5 = r15.b;
    L26:
        if (r4 == false) goto L28;
        int r6 = r15.c;
    L29:
        ValueAnimator r17 = ValueAnimator.ofInt(new int[]{r5, r6});
        r17.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.4f, 1.0f));
        r17.addUpdateListener(new a(r15));
        r17.addListener(new b(r15, r4, r3));
        r17.setDuration(r15.a);
        r17.start();
        int r18 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r12.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L28:
        r6 = r15.b;
        goto L29
    L25:
        r5 = r15.c;
    L19:
        r2 = false;
        goto L20
    L5:
        r14 = null;
        goto L7
    }
}
