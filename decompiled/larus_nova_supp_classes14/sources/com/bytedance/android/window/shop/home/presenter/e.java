package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends j {
    public SimpleDraweeView m;
    public View n;
    public View o;
    public int p;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            uq3.a r12 = (uq3.a) r11;
            uq3.o r0 = r12.c;
            ViewGroup.LayoutParams r1 = null;
            if (r0 == null) goto L5;
            ECUrlModel r2 = r0.g;
        L7:
            if (r2 != null) goto L21;
            if (this.a.F() == true) goto L21;
            e r3 = this.a;
            View r4 = r3.n;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("bgSecondPart");
        L13:
            r4.setVisibility(8);
            View r5 = r3.o;
            if (r5 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
        L16:
            r5.setVisibility(8);
            SimpleDraweeView r6 = r3.m;
            if (r6 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("baseBg");
        L19:
            r6.setVisibility(8);
            e.a0(this.a, r12);
            return;
        L21:
            if (this.a.F() == false) goto L86;
            e r7 = this.a;
            SimpleDraweeView r8 = r7.m;
            if (r8 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("baseBg");
        L25:
            r8.setVisibility(4);
            int r9 = r7.u().c().getResources().getColor(2131105907);
            View r10 = r7.n;
            if (r10 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("bgSecondPart");
        L28:
            r10.setBackgroundColor(r9);
            uq3.a r13 = (uq3.a) r7.O().getHeaderResponse().getValue();
            if (r13 == null) goto L35;
            uq3.o r14 = r13.c;
            if (r14 == null) goto L35;
            if (r14.a() != true) goto L35;
            int r15 = 51;
        L36:
            GradientDrawable r16 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(r15, Color.red(r9), Color.green(r9), Color.blue(r9)), r9});
            View r17 = r7.o;
            if (r17 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
        L39:
            r17.setBackgroundDrawable(r16);
            e r18 = this.a;
            View r19 = r18.y();
        L40:
            if (r19 == null) goto L48;
            View r20 = com.bytedance.android.ec.window.base.utils.c.a(r18.X(), ECWindowBackGroundPresenter$initPull2enlarged$owner$1.INSTANCE);
            if (r20 != null) goto L43;
            Object r21 = r19.getParent();
            if ((r21 instanceof View) == true) goto L47;
            r21 = null;
        L47:
            r19 = (View) r21;
            goto L40
        L43:
            r19 = r20;
        L48:
            if (r19 == null) goto L50;
            ViewGroup.LayoutParams r22 = r19.getLayoutParams();
        L52:
            if ((r22 instanceof CoordinatorLayout.LayoutParams) == true) goto L54;
            r22 = null;
        L54:
            CoordinatorLayout.LayoutParams r23 = (CoordinatorLayout.LayoutParams) r22;
            if (r23 == null) goto L57;
            CoordinatorLayout.Behavior r24 = r23.getBehavior();
        L59:
            if ((r24 instanceof ECWindowOverScrollExpandBehavior) == true) goto L61;
            r24 = null;
        L61:
            ECWindowOverScrollExpandBehavior r25 = (ECWindowOverScrollExpandBehavior) r24;
            if (r25 == null) goto L64;
            r25.setExpandController(new g(r25.getOriginHeight(), r18));
        L64:
            e r26 = this.a;
            View r27 = r26.o;
            if (r27 != null) goto L67;
            Intrinsics.throwUninitializedPropertyAccessException("bgTransitionMask");
        L67:
            wg.a.f(r27, 0, 0, 0, 0);
            View r28 = r26.n;
            if (r28 != null) goto L70;
            Intrinsics.throwUninitializedPropertyAccessException("bgSecondPart");
        L70:
            ViewGroup.LayoutParams r29 = r28.getLayoutParams();
            if ((r29 instanceof ConstraintLayout.LayoutParams) == true) goto L73;
            r29 = null;
        L73:
            ViewGroup.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
            if (r30 == null) goto L76;
            ((ConstraintLayout.LayoutParams) r30).topToBottom = 2131371297;
            r1 = r30;
        L76:
            View r31 = r26.n;
            if (r31 != null) goto L79;
            Intrinsics.throwUninitializedPropertyAccessException("bgSecondPart");
        L79:
            r31.setLayoutParams(r1);
            r26.y().post(new h(r26, r12));
            return;
        L57:
            r24 = null;
            goto L59
        L50:
            r22 = null;
        L35:
            r15 = 71;
            goto L36
        L86:
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    static {
    }

    public e() {
    }

    public final void A(QModel r4) {
        this.m = w().b(2131371292).f();
        this.n = w().b(2131371294).f();
        this.o = w().b(2131371297).f();
        O().getHeaderResponse().a(ECQuickUtilKt.a(u()), new f(this), false);
        O().getHeaderResponse().a(ECQuickUtilKt.a(u()), new b(this), false);
    }

    public static final void a0(e r5, uq3.a r6) {
        FrameLayout r0 = (FrameLayout) r5.w().b(2131370845).f();
        boolean r3 = true;
        if (yq3.a.f() == 1) goto L7;
        r3 = false;
    L7:
        if (r3 == false) goto L9;
        View r7 = LayoutInflater.from(r5.u().c()).inflate(2131561012, null);
    L10:
        r0.addView(r7);
        View r1 = r7.findViewById(2131371291);
        SimpleDraweeView r8 = r7.findViewById(2131371256);
        if (r3 == false) goto L13;
        ImageRequest r2 = ImageRequestBuilder.newBuilderWithResourceId(2131234882).build();
        r8.setController(Fresco.newDraweeControllerBuilder().setOldController(r8.getController()).setImageRequest(r2).build());
    L13:
        uq3.o r9 = r6.c;
        if (r9 == null) goto L19;
        String r10 = r9.i;
        if (r10 == null) goto L20;
        int[] r11 = j2.a(r10);
        GradientDrawable r4 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.e(r4, (int[]) r11.clone());
        Unit r12 = Unit.INSTANCE;
        com.bytedance.android.ec.window.base.utils.c.d(r1, r4);
        r1.setVisibility(0);
        r8.setVisibility(0);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r7 = LayoutInflater.from(r5.u().c()).inflate(2131561011, null);
        goto L10
    }
}
