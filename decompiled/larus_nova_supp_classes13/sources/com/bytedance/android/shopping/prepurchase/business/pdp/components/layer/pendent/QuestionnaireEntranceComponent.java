package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.g0;
import vg3.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class QuestionnaireEntranceComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m {
    public l73.c m;
    public ti.l n;
    public String o;

    public static final class a {
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ QuestionnaireEntranceComponent a;

        public b(QuestionnaireEntranceComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r13) {
            l73.c r14 = (l73.c) r13;
            QuestionnaireEntranceComponent r0 = this.a;
            ti.l r1 = null;
            if (r14 == null) goto L36;
            r0.getClass();
            if (r14.d == false) goto L36;
            r0.m = r14;
            String r2 = r14.a;
            if (r2 == null) goto L40;
            View r3 = r0.e2();
            if ((r3 instanceof ViewGroup) == true) goto L13;
            r3 = null;
        L13:
            ViewGroup r4 = (ViewGroup) r3;
            if (r4 == null) goto L41;
            ti.l r5 = r0.n;
            if (r5 == null) goto L19;
            r5.renderTemplate(r2, null);
            r0.i2();
            return;
        L19:
            ti.l r6 = r0.O1().e().D0().p(new com.bytedance.android.shopping.prepurchase.arch.container.ability.o(r4.getContext(), UriProtector.parse(r2).buildUpon().appendQueryParameter("identifier", r0.g2().getSessionId()).build().toString(), null, null, false, null, 60));
            if (r6 == null) goto L22;
            w.a.e(w.b, r6, r4.getContext(), Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(r0.O1())).b.a), 8);
            Unit r7 = Unit.INSTANCE;
            r1 = r6;
        L22:
            r0.n = r1;
            if (r1 == null) goto L34;
            View r8 = r1.getHybridView();
            if (r8 == null) goto L34;
            r4.removeAllViews();
            Integer r9 = r14.c;
            int r10 = 0;
            if (r9 == null) goto L29;
            int r11 = com.bytedance.android.shopping.extensions.b.b(r9);
        L30:
            Integer r15 = r14.b;
            if (r15 == null) goto L33;
            r10 = com.bytedance.android.shopping.extensions.b.b(r15);
        L33:
            r4.addView(r8, new LinearLayout.LayoutParams(r11, r10));
            r0.i2();
        L35:
            Unit r16 = Unit.INSTANCE;
            return;
        L29:
            r11 = 0;
        L34:
            r0.h2();
            goto L35
        L41:
            return;
        L40:
            return;
        L36:
            r0.h2();
            r0.m = null;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{i0.class, vg3.d.class, g0.class});
    }

    public final void i2() {
        l73.c r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        e2().setVisibility(0);
        int r1 = com.bytedance.android.shopping.extensions.b.b(154);
        Integer r3 = r0.b;
        if (r3 == null) goto L8;
        int r4 = r3.intValue();
    L9:
        int r5 = r1 + com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r4));
        int r6 = com.bytedance.android.shopping.extensions.b.b(234);
        Integer r7 = r0.b;
        if (r7 == null) goto L12;
        r2 = r7.intValue();
    L12:
        j2(r5, r6 + com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r2)));
        return;
    L8:
        r4 = 0;
        goto L9
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().s.getValue(), this, new b(this));
        Z1(i0.class, new QuestionnaireEntranceComponent$onAttach$2(this, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        ti.l r0 = this.n;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.n = null;
    }

    public final void h2() {
        e2().setVisibility(8);
        j2(com.bytedance.android.shopping.extensions.b.b(130), com.bytedance.android.shopping.extensions.b.b(226));
    }

    public QuestionnaireEntranceComponent() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        FrameLayout r4 = new FrameLayout(r2.getContext());
        r4.setId(2131383540);
        r4.setVisibility(8);
        return r4;
    }

    public final void j2(int r6, int r7) {
        vg3.d r0 = (vg3.d) N1(vg3.d.class);
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L13;
        ECDraweeView r2 = r0.X();
        if (r2 == null) goto L13;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r3 = null;
    L9:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 != null) goto L12;
        r4 = new ViewGroup.MarginLayoutParams(-2, -2);
    L12:
        r4.bottomMargin = r6;
        Unit r8 = Unit.INSTANCE;
        r2.setLayoutParams(r4);
    L13:
        g0 r9 = (g0) N1(g0.class);
        if (r9 == null) goto L26;
        LongContentLabelComponentView r10 = r9.r0();
        if (r10 == null) goto L27;
        ViewGroup.LayoutParams r5 = r10.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r1 = r5;
    L21:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r1;
        if (r11 != null) goto L24;
        r11 = new ViewGroup.MarginLayoutParams(-2, -2);
    L24:
        r11.bottomMargin = r7;
        Unit r12 = Unit.INSTANCE;
        r10.setLayoutParams(r11);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r2, ViewGroup.LayoutParams r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 85;
        r5.bottomMargin = com.bytedance.android.shopping.extensions.b.b(112);
        Unit r0 = Unit.INSTANCE;
        super.b2(r2, r5, r4);
    }
}
