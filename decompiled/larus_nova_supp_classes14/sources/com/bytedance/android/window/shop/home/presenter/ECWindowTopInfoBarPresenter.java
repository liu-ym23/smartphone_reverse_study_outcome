package com.bytedance.android.window.shop.home.presenter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowTopInfoBarPresenter extends j implements View.OnClickListener {
    public static final /* synthetic */ int u = 0;
    public tp3.a m;
    public View n;
    public View o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public final Lazy t;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowTopInfoBarPresenter a;

        public b(ECWindowTopInfoBarPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Boolean r9 = (Boolean) r8;
            ImageView r10 = this.a.p;
            if (r10 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L5:
            r10.setColorFilter(-1);
            ImageView r11 = this.a.r;
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L8:
            r11.setColorFilter(-1);
            ImageView r12 = this.a.q;
            if (r12 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("searchViewPlaceholder");
        L11:
            r12.setColorFilter(-1);
            if (this.a.F() == true) goto L14;
        L22:
            boolean r1 = false;
        L23:
            if (r1 == false) goto L28;
            ImageView r13 = this.a.s;
            if (r13 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("enterLiveHint");
        L27:
            r13.setOnClickListener(new f2(this));
        L28:
            this.a.O().getOffsetState().a(this.a.U(), new g2(this, r1), false);
            final ECWindowTopInfoBarPresenter r14 = this.a;
            uq3.a r2 = (uq3.a) r14.O().getHeaderResponse().getValue();
            if (r2 == null) goto L33;
            uq3.o r3 = r2.c;
            if (r3 == null) goto L33;
            final uq3.m r4 = r3.v;
        L34:
            if (r4 == null) goto L47;
            ViewStub r5 = (ViewStub) r14.y().findViewById(2131370971);
            if (r5 == null) goto L48;
            GenericDraweeView r6 = r5.inflate();
            if ((r6 instanceof ECDraweeView) == true) goto L42;
            r6 = null;
        L42:
            GenericDraweeView r7 = (ECDraweeView) r6;
            if (r7 == null) goto L49;
            com.bytedance.android.ec.core.utils.y.a(r7, r4.a);
            r14.O().doEventAction(r4.c + "_show", new Pair[0]);
            com.bytedance.android.ec.core.widget.f.b(r7, 500L, null, new ECWindowTopInfoBarPresenter$prepareImEntry$1(r14, r4));
            return;
        L49:
            return;
        L48:
            return;
        L47:
            return;
        L33:
            r4 = null;
            goto L34
        L14:
            if (this.a.O().isCroppedStyle() == true) goto L22;
            uq3.a r15 = (uq3.a) this.a.O().getHeaderResponse().getValue();
            r1 = true;
            if (r15 == null) goto L23;
            uq3.o r16 = r15.c;
            if (r16 == null) goto L23;
            if (r16.a() == true) goto L22;
            goto L22
        }
    }

    static {
    }

    public final void C() {
    }

    public ECWindowTopInfoBarPresenter() {
        this.t = LazyKt.lazy(new ECWindowTopInfoBarPresenter$actionButtonGroup$2(this));
    }

    public final void A(QModel r5) {
        View r6 = w().b(2131370975).f();
        this.n = r6;
        r6.setOnClickListener(this);
        this.o = w().b(2131370879).f();
        ImageView r7 = (ImageView) w().b(2131370967).f();
        if (O().isSplitStyle() == false) goto L5;
        r7.setImageResource(2131233378);
    L5:
        Unit r0 = Unit.INSTANCE;
        this.p = r7;
        this.s = (ImageView) w().b(2131371258).f();
        this.q = (ImageView) w().b(2131370973).f();
        this.r = (ImageView) w().b(2131370972).f();
        ImageView r8 = this.p;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L8:
        fo.a<WindowLayoutType> r1 = WindowConstDef.a;
        Lazy r2 = WindowConstDef.q;
        com.bytedance.android.window.shop.home.tab.presenter.c0.j(r8, com.bytedance.android.window.shop.holder.d.a(Float.valueOf(((Number) r2.getValue()).floatValue())));
        com.bytedance.android.window.shop.home.tab.presenter.c0.j((View) this.t.getValue(), com.bytedance.android.window.shop.holder.d.a(Float.valueOf(((Number) r2.getValue()).floatValue())));
        ImageView r9 = this.p;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L11:
        r9.setOnClickListener(this);
        ImageView r10 = this.r;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L14:
        r10.setOnClickListener(this);
        ImageView r11 = this.q;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchViewPlaceholder");
    L17:
        r11.setOnClickListener(this);
        w().b(2131370969).f().setOnClickListener(this);
        QContext r12 = u();
        Activity r3 = com.bytedance.android.ec.core.utils.l0.c(r12.c());
        if ((r3 instanceof FragmentActivity) == true) goto L20;
        r3 = null;
    L20:
        if (r3 != null) goto L22;
        r3 = r12.a();
    L22:
        int r13 = com.bytedance.android.ec.core.utils.y1.a;
        com.bytedance.android.ec.core.utils.y1.c(r3, r3.getWindow(), false);
        int r14 = com.bytedance.android.ec.core.utils.j.a;
        com.bytedance.android.ec.core.utils.j.a.a(w().b(2131370954).f());
        O().getTopBarHeight().setValue(Integer.valueOf(eh.b.b(r3) + w().b(2131370969).f().getLayoutParams().height));
        O().doEventAction("show_search", new Pair[]{TuplesKt.to("enter_from", "search_window")});
        O().isLiveOn().a(U(), new b(this), false);
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
        tp3.a r9 = this.m;
        if (r9 == null) goto L24;
        if (r9.isShowing() != true) goto L24;
        return;
    L24:
        if (this.m != null) goto L32;
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
        this.m = r10;
    L32:
        tp3.a r11 = this.m;
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
        View r13 = this.n;
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
}
