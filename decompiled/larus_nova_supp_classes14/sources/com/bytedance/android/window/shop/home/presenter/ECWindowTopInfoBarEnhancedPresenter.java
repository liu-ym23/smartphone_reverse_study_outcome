package com.bytedance.android.window.shop.home.presenter;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.window.base.widget.BouncingMarqueeTextView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.widget.topbar.ECWindowSearchView;
import com.bytedance.android.window.shop.widget.topbar.MinMode;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowTopInfoBarEnhancedPresenter extends j implements View.OnClickListener, View.OnLayoutChangeListener {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final ViewGroup B;
    public final Lazy m;
    public tp3.a n;
    public View o;
    public View p;
    public ImageView q;
    public final Lazy r;
    public ImageView s;
    public ImageView t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public int x;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter a;

        public b(ECWindowTopInfoBarEnhancedPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            this.a.b0().update(((Float) r2).floatValue());
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter a;

        public c(ECWindowTopInfoBarEnhancedPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Float r6 = (Float) r5;
            if (r6.floatValue() < 0.9f) goto L14;
            BouncingMarqueeTextView r0 = (BouncingMarqueeTextView) this.a.w.getValue();
            if (r0 == null) goto L7;
            r0.setSelected(true);
        L7:
            BouncingMarqueeTextView r1 = (BouncingMarqueeTextView) this.a.w.getValue();
            if (r1 == null) goto L14;
            if (r1.k == r1.j) goto L14;
            r1.y(r1.i);
        L14:
            if (this.a.F() == false) goto L16;
            this.a.b0().update(r6.floatValue());
        L17:
            this.a.b0().setVisibility(0);
            return;
        L16:
            this.a.b0().update(1 - r6.floatValue());
            goto L17
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter a;

        public d(ECWindowTopInfoBarEnhancedPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Boolean r9 = (Boolean) r8;
            ECWindowTopInfoBarEnhancedPresenter r10 = this.a;
            if (r10.A == true) goto L61;
            boolean r0 = true;
            r10.A = true;
            ImageView r11 = r10.q;
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L8:
            r11.setColorFilter(-1);
            ImageView r12 = this.a.s;
            if (r12 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L11:
            r12.setColorFilter(-1);
            if (this.a.F() == true) goto L14;
        L22:
            r0 = false;
        L23:
            if (r0 == false) goto L28;
            ImageView r13 = this.a.t;
            if (r13 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
        L27:
            r13.setOnClickListener(new c2(this));
            this.a.b0().setMinMode(MinMode.ICON);
        L30:
            if (this.a.F() == false) goto L32;
            this.a.b0().setMinMode(MinMode.ICON);
        L33:
            View r14 = this.a.p;
            if (r14 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
        L36:
            r14.addOnLayoutChangeListener(this.a);
            ImageView r15 = this.a.q;
            if (r15 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L39:
            r15.addOnLayoutChangeListener(this.a);
            View r16 = this.a.p;
            if (r16 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
        L42:
            r16.post(new d2(this));
            this.a.O().getOffsetState().a(this.a.U(), new e2(this, r0), false);
            final ECWindowTopInfoBarEnhancedPresenter r17 = this.a;
            uq3.a r1 = (uq3.a) r17.O().getHeaderResponse().getValue();
            if (r1 == null) goto L47;
            uq3.o r2 = r1.c;
            if (r2 == null) goto L47;
            final uq3.m r3 = r2.v;
        L48:
            if (r3 == null) goto L62;
            ViewStub r4 = (ViewStub) r17.y().findViewById(2131370971);
            if (r4 == null) goto L63;
            GenericDraweeView r5 = r4.inflate();
            if ((r5 instanceof ECDraweeView) == true) goto L56;
            r5 = null;
        L56:
            GenericDraweeView r6 = (ECDraweeView) r5;
            if (r6 == null) goto L64;
            com.bytedance.android.ec.core.utils.y.a(r6, r3.a);
            r17.O().doEventAction(r3.c + "_show", new Pair[0]);
            com.bytedance.android.ec.core.widget.f.b(r6, 500L, null, new ECWindowTopInfoBarEnhancedPresenter$prepareImEntry$1(r17, r3));
            return;
        L64:
            return;
        L63:
            return;
        L62:
            return;
        L47:
            r3 = null;
            goto L48
        L32:
            this.a.b0().setMinMode(MinMode.TEXT);
            goto L33
        L28:
            this.a.b0().setMinMode(MinMode.TEXT);
            goto L30
        L14:
            if (this.a.O().isCroppedStyle() == true) goto L22;
            uq3.a r18 = (uq3.a) this.a.O().getHeaderResponse().getValue();
            if (r18 == null) goto L23;
            uq3.o r19 = r18.c;
            if (r19 == null) goto L23;
            if (r19.a() == true) goto L22;
        }
    }

    static {
    }

    public final ECWindowSearchView b0() {
        return (ECWindowSearchView) this.r.getValue();
    }

    public final void c0() {
        Boolean r0 = (Boolean) O().isLiveOn().getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
    L8:
        int r2 = this.y;
    L9:
        int r3 = this.z;
        if (r3 > 0) goto L12;
        return;
    L12:
        if (this.x > 0) goto L14;
        return;
    L14:
        if (this.y <= 0) goto L26;
        int r4 = r3 - r2;
        if (r4 <= 0) goto L20;
        ECWindowSearchView r5 = b0();
        r5.b = r4;
        r5.update(r5.d);
        r5.c = RangesKt.coerceAtMost(r5.c, r4);
    L20:
        if ((!Intrinsics.areEqual((Boolean) O().isLiveOn().getValue(), r1)) == false) goto L25;
        b0().a(Integer.valueOf(this.z - this.y));
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (O().isCroppedStyle() == true) goto L8;
        r2 = this.x;
        goto L9
    }

    public ECWindowTopInfoBarEnhancedPresenter(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        this.B = r2;
        this.m = LazyKt.lazy(ECWindowTopInfoBarEnhancedPresenter$topBarInfoAreaInterpolator$2.INSTANCE);
        this.r = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$searchViewPlaceholder$2(this));
        this.u = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$actionButtonGroup$2(this));
        this.v = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$searchNoticeView$2(this));
        this.w = LazyKt.lazy(new ECWindowTopInfoBarEnhancedPresenter$tvShopName$2(this));
    }

    public static int a0(View r1) {
        Rect r0 = new Rect();
        r1.getGlobalVisibleRect(r0);
        return r0.right;
    }

    public final void A(QModel r6) {
        View r7 = w().b(2131370975).f();
        this.o = r7;
        r7.setOnClickListener(this);
        this.p = w().b(2131370879).f();
        ImageView r8 = (ImageView) w().b(2131370967).f();
        if (O().isSplitStyle() == false) goto L5;
        r8.setImageResource(2131233378);
    L5:
        Unit r0 = Unit.INSTANCE;
        this.q = r8;
        ((View) this.v.getValue()).setSelected(true);
        this.t = (ImageView) w().b(2131371258).f();
        this.s = (ImageView) w().b(2131370972).f();
        ImageView r9 = this.q;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L8:
        r9.setOnClickListener(this);
        ImageView r10 = this.s;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L11:
        r10.setOnClickListener(this);
        b0().setOnClickListener(this);
        w().b(2131370969).f().setOnClickListener(this);
        b0().addOnLayoutChangeListener(this);
        QContext r11 = u();
        Activity r2 = com.bytedance.android.ec.core.utils.l0.c(r11.c());
        if ((r2 instanceof FragmentActivity) == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L16;
        r2 = r11.a();
    L16:
        int r12 = com.bytedance.android.ec.core.utils.y1.a;
        com.bytedance.android.ec.core.utils.y1.c(r2, r2.getWindow(), false);
        int r13 = com.bytedance.android.ec.core.utils.j.a;
        com.bytedance.android.ec.core.utils.j.a.a(w().b(2131370954).f());
        O().getTopBarHeight().setValue(Integer.valueOf(eh.b.b(r2) + w().b(2131370969).f().getLayoutParams().height));
        O().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_window")});
        O().getCollapseProgress().observe(U(), new b(this));
        O().getSubCollapseProgress().observe(U(), new c(this));
        O().isLiveOn().a(U(), new d(this), false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        int r0 = rp.a.a;
        if (rp.a.a(r7.getId()) == false) goto L6;
        return;
    L6:
        if (r7.getId() != 2131370967) goto L16;
        Function1<hp3.b, Boolean> r1 = O().getEventDeliverer();
        if (r1 == null) goto L13;
        if (((Boolean) r1.invoke(lp3.a.a)).booleanValue() == false) goto L15;
        return;
    L15:
        D();
        goto L16
    L13:
        if (O().getPendingTaskViewModel().a() == false) goto L15;
        return;
    L16:
        int r8 = r7.getId();
        FragmentActivity r2 = null;
        if (r8 != 2131370972) goto L37;
        tp3.a r9 = this.n;
        if (r9 == null) goto L24;
        if (r9.isShowing() != true) goto L24;
        return;
    L24:
        if (this.n != null) goto L32;
        QContext r3 = u();
        FragmentActivity r4 = com.bytedance.android.ec.core.utils.l0.c(r3.c());
        if ((r4 instanceof FragmentActivity) == false) goto L29;
        r2 = r4;
    L29:
        if (r2 != null) goto L31;
        r2 = r3.a();
    L31:
        tp3.a r10 = new tp3.a(r2);
        r10.c(O());
        Unit r5 = Unit.INSTANCE;
        this.n = r10;
    L32:
        tp3.a r11 = this.n;
        if (r11 == null) goto L35;
        r11.b(w().b(2131370972).f());
    L35:
        ECWindowViewModel r12 = O();
        int r6 = com.bytedance.android.ec.window.base.utils.i.a;
        r12.doEventAction("click_menu", new Pair[]{com.bytedance.android.ec.window.base.utils.i.a("a1.b7635.c2240.d4411", false)});
        return;
    L37:
        if (r8 != 2131370973) goto L40;
        V();
        return;
    L40:
        if (r8 != 2131370975) goto L54;
        View r13 = this.o;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("topBarContainer");
    L44:
        Drawable r14 = r13.getBackground();
        if (r14 != null) goto L47;
        return;
    L47:
        if (r14.getAlpha() >= 10) goto L56;
        Function3<String, Boolean, String, Unit> r15 = O().getJump2Live();
        if (r15 == null) goto L57;
        Unit r16 = (Unit) r15.invoke(null, Boolean.FALSE, "a1.b7635.c4706.d3124");
        return;
    L57:
        return;
    L56:
        return;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r1 == null) goto L15;
        int r10 = r1.getId();
        ImageView r11 = this.q;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L6:
        if (r11 == null) goto L8;
        Integer r12 = Integer.valueOf(r11.getId());
    L10:
        if (r10 != r12.intValue()) goto L15;
        ImageView r13 = this.q;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L14:
        this.x = a0(r13);
        goto L15
    L8:
        r12 = null;
    L15:
        if (r1 == null) goto L25;
        int r14 = r1.getId();
        View r15 = this.p;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L20:
        if (r14 != r15.getId()) goto L25;
        View r16 = this.p;
        if (r16 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L24:
        this.y = RangesKt.coerceAtLeast(a0(r16), this.y);
    L25:
        if (r1 != null) goto L27;
    L29:
        c0();
        return;
    L27:
        if (r1.getId() != b0().getId()) goto L29;
        this.z = a0(b0());
        goto L29
    }
}
