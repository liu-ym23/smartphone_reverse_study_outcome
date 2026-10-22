package com.bytedance.awemeopen.apps.framework.feed.ui.information;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.ad.AdElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent.BottomLeftButtonElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.camera.CameraAnchorElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.desc.t;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent.LeftComponentElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent.l;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.poi.LocalLifeAnchorElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.recommend.tag.RecommendTagElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.ShoppingCardElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.b0;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class InformationGroup extends BaseGroup<c, LinearLayout, tz3.a, jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.createtime.a A;
    public final ArrayList<BaseElement<?, ?, ?, jz3.a>> B;
    public final ArrayList<BaseElement<?, ?, ?, jz3.a>> C;
    public final Activity j;
    public final o k;
    public final l14.c l;
    public final Function1<Boolean, Unit> m;
    public final AdElement n;
    public final ShoppingCardElement o;
    public final LocalLifeAnchorElement p;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard.b q;
    public final RecommendTagElement r;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.username.b s;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.desc.g t;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.music.title.b u;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.tag.a v;
    public final com.bytedance.awemeopen.apps.framework.feed.ui.information.warning.a w;
    public final LeftComponentElement x;
    public final BottomLeftButtonElement y;
    public final CameraAnchorElement z;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void f() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void i() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void j() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.d a() {
        return new c();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ArrayList<BaseElement<?, ?, ?, jz3.a>> c() {
        return CollectionsKt.arrayListOf(new BaseElement[]{this.n, this.r, this.s, this.t, this.v, this.u, this.w, this.o, this.p, this.x, this.z, this.q, this.y, this.A});
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void h() {
        t r0 = this.t.h();
        Function0<Integer> r1 = new InformationGroup$onCreate$1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.f = r1;
        b0 r2 = this.o.h();
        Observer<Boolean> r3 = new d(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.h.a(r3);
        b0 r4 = this.o.h();
        Observer<Boolean> r5 = new e(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.j.a(r5);
        l r6 = this.x.h();
        Observer<Boolean> r7 = new f(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.d.a(r7);
        t r8 = this.t.h();
        Observer<Boolean> r9 = new g(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.b.a(r9);
        t r10 = this.t.h();
        Function0<Integer> r11 = new InformationGroup$onCreate$6(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.g = r11;
        t r12 = this.t.h();
        Function0<Integer> r13 = new InformationGroup$onCreate$7(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.h = r13;
    }

    public final Activity getActivity() {
        return this.j;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final ViewGroup b(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(0, -2);
        float r1 = 12;
        Resources r3 = Resources.getSystem();
        int r4 = MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics())));
        Resources r6 = Resources.getSystem();
        int r5 = MathKt.roundToInt(TypedValue.applyDimension(1, 93, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        Resources r7 = Resources.getSystem();
        r0.setMargins(r4, 0, r5, MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()))));
        r0.bottomToTop = 2131363067;
        r0.leftToLeft = 0;
        r0.rightToRight = 0;
        LinearLayout r2 = new LinearLayout(r9);
        r2.setLayoutParams(r0);
        r2.setOrientation(1);
        return r2;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.group.BaseGroup
    public final void g(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.B.clear();
        this.C.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InformationGroup(Activity r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, o r4, l14.c r5, Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        Intrinsics.checkNotNullParameter(r6, "onDescExpand");
        super(r2);
        this.j = r2;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = new AdElement(r2, r3.d, r4, r5);
        this.o = new ShoppingCardElement(r2, r4);
        this.p = new LocalLifeAnchorElement(r2, r4);
        this.q = new com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard.b(r2, r3.d, r4);
        this.r = new RecommendTagElement(r2, r4);
        this.s = new com.bytedance.awemeopen.apps.framework.feed.ui.information.username.b(r2, r4, r3.f);
        this.t = new com.bytedance.awemeopen.apps.framework.feed.ui.information.desc.g(getContext(), r4);
        this.u = new com.bytedance.awemeopen.apps.framework.feed.ui.information.music.title.b(getContext(), r4);
        this.v = new com.bytedance.awemeopen.apps.framework.feed.ui.information.tag.a(getContext());
        this.w = new com.bytedance.awemeopen.apps.framework.feed.ui.information.warning.a(getContext());
        this.x = new LeftComponentElement(getContext(), r3.d, r4);
        this.y = new BottomLeftButtonElement(getContext(), r3.d, r4);
        this.z = new CameraAnchorElement(getContext(), r3.d, r4);
        this.A = new com.bytedance.awemeopen.apps.framework.feed.ui.information.createtime.a(getContext(), r4);
        this.B = new ArrayList();
        this.C = new ArrayList();
    }
}
