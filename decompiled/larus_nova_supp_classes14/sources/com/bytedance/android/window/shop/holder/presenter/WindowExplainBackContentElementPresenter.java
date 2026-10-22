package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.presenter.playable.ECWindowPlayableProductCardGroupPresenter;
import com.bytedance.android.window.shop.product.utils.WindowBstReport;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowExplainBackContentElementPresenter extends com.bytedance.android.ec.window.base.utils.quick.c<com.bytedance.android.window.shop.repository.tab.entity.k> {
    public static final /* synthetic */ int o = 0;
    public final Lazy e;
    public final Lazy f;
    public com.bytedance.android.window.shop.repository.tab.entity.k g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final View l;
    public final Fragment m;
    public final WindowLayoutType n;

    public static final class a {
    }

    static {
    }

    public final void C() {
        this.g = null;
    }

    public final BaseWindowTabViewModel E() {
        return (BaseWindowTabViewModel) this.e.getValue();
    }

    public final void D(QModel r19) {
        com.bytedance.android.window.shop.repository.tab.entity.k r1 = (com.bytedance.android.window.shop.repository.tab.entity.k) r19;
        this.g = r1;
        WindowLayoutType r2 = this.n;
        if (r2 != null) goto L5;
    L17:
        if (r1 == null) goto L19;
        String r3 = r1.l;
    L20:
        if (r1 == null) goto L22;
        String r4 = r1.m;
    L23:
        if (r1 == null) goto L25;
        com.bytedance.android.window.shop.repository.dto.f r5 = r1.p;
    L26:
        if (r1 == null) goto L28;
        com.bytedance.android.window.shop.repository.dto.f r6 = r1.q;
    L29:
        Pair r7 = new Pair(new Pair(r3, r4), new Pair(r5, r6));
        Pair r8 = (Pair) r7.component1();
        Pair r9 = (Pair) r7.component2();
        String r10 = (String) r8.component1();
        String r11 = (String) r8.component2();
        com.bytedance.android.window.shop.repository.dto.f r12 = (com.bytedance.android.window.shop.repository.dto.f) r9.component1();
        com.bytedance.android.window.shop.repository.dto.f r13 = (com.bytedance.android.window.shop.repository.dto.f) r9.component2();
        TextView r14 = (TextView) this.j.getValue();
        String r15 = "";
        if (r10 != null) goto L32;
        r10 = "";
    L32:
        r14.setText(r10);
        TextView r16 = (TextView) this.k.getValue();
        if (r11 != null) goto L35;
        r11 = "";
    L35:
        r16.setText(r11);
        ECDraweeView r17 = (ECDraweeView) this.h.getValue();
        if (r12 == null) goto L38;
        ECUrlModel r18 = r12.a();
    L39:
        ECWindowViewModel r20 = (ECWindowViewModel) this.f.getValue();
        if (r20 == null) goto L42;
        com.bytedance.android.ec.core.imagex.r r110 = r20.getImageCallerContext();
    L43:
        h0.d(r17, r18, r110, null, null, null, null, 120);
        ECDraweeView r21 = (ECDraweeView) this.i.getValue();
        if (r13 == null) goto L46;
        ECUrlModel r111 = r13.a();
    L47:
        ECWindowViewModel r22 = (ECWindowViewModel) this.f.getValue();
        if (r22 == null) goto L50;
        com.bytedance.android.ec.core.imagex.r r112 = r22.getImageCallerContext();
    L51:
        h0.d(r21, r111, r112, null, null, null, null, 120);
        if (r1 == null) goto L54;
        Integer r23 = r1.b;
    L55:
        View r24 = this.l;
        String r113 = "a1.b7635.c68164.d98383_i" + r23;
        com.bytedance.android.window.shop.repository.tab.entity.k r25 = this.g;
        if (r25 == null) goto L77;
        tq3.c r114 = r25.s;
        if (r114 == null) goto L77;
        ECWindowViewModel r115 = (ECWindowViewModel) this.f.getValue();
        if (r115 == null) goto L77;
        if (E().shouldReportEvent(wn.a.h, r113) == false) goto L77;
        int r26 = ECWindowPlayableProductCardGroupPresenter.v;
        BaseWindowTabViewModel r27 = E();
        WindowLayoutType r116 = this.n;
        String r117 = E().getLastCategoryId();
        if (r117 == null) goto L69;
        r15 = r117;
    L69:
        Map r28 = ECWindowPlayableProductCardGroupPresenter.a.a(r115, r27, r114, r116, r15);
        com.bytedance.android.window.shop.repository.tab.entity.k r29 = this.g;
        if (r29 == null) goto L75;
        Map<String, ? extends Map<String, String>> r30 = r29.d;
        if (r30 == null) goto L75;
        Map<String, String> r31 = r30.get("replay_collection");
        if (r31 == null) goto L75;
    L76:
        Map r118 = MapsKt.plus(r28, r31);
        int r32 = WindowBstReport.a;
        WindowBstReport.h(r24, r113, r114, this.n, r118, r115, E(), "window_explain_back_show", true);
    L75:
        r31 = MapsKt.emptyMap();
    L77:
        final GenericDraweeView r33 = (ECDraweeView) this.h.getValue();
        if (r12 == null) goto L80;
        final String r34 = r12.b();
    L81:
        final String r35 = "a1.b7635.c68164.d98383_i" + r23 + "_w372";
        com.bytedance.android.ec.core.widget.f.c(r33, null, null, new WindowExplainBackContentElementPresenter$bindClickEvent$1(this, r34, r35, r33), 3);
        final GenericDraweeView r36 = (ECDraweeView) this.i.getValue();
        if (r13 == null) goto L84;
        final String r37 = r13.b();
    L85:
        final String r38 = "a1.b7635.c68164.d98383_i" + r23 + "_w373";
        com.bytedance.android.ec.core.widget.f.c(r36, null, null, new WindowExplainBackContentElementPresenter$bindClickEvent$1(this, r37, r38, r36), 3);
        final View r39 = this.l;
        if (r1 == null) goto L88;
        final String r40 = r1.n;
    L89:
        final String r41 = "a1.b7635.c68164.d98383_i" + r23;
        com.bytedance.android.ec.core.widget.f.c(r39, null, null, new WindowExplainBackContentElementPresenter$bindClickEvent$1(this, r40, r41, r39), 3);
        return;
    L88:
        r40 = null;
        goto L89
    L84:
        r37 = null;
        goto L85
    L80:
        r34 = null;
        goto L81
    L54:
        r23 = null;
        goto L55
    L50:
        r112 = null;
        goto L51
    L46:
        r111 = null;
        goto L47
    L42:
        r110 = null;
        goto L43
    L38:
        r18 = null;
    L28:
        r6 = null;
        goto L29
    L25:
        r5 = null;
        goto L26
    L22:
        r4 = null;
        goto L23
    L19:
        r3 = null;
        goto L20
    L5:
        if (r2.isSingleColumn() != true) goto L17;
        if (r1 == null) goto L8;
        r3 = r1.j;
    L9:
        if (r1 == null) goto L11;
        r4 = r1.k;
    L12:
        if (r1 == null) goto L14;
        r5 = r1.q;
    L15:
        if (r1 == null) goto L28;
        r6 = r1.r;
        goto L29
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    public WindowExplainBackContentElementPresenter(View r2, Fragment r3, WindowLayoutType r4) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.e = LazyKt.lazy(new WindowExplainBackContentElementPresenter$tabVm$2(this));
        this.f = LazyKt.lazy(new WindowExplainBackContentElementPresenter$windowViewModel$2(this));
        this.h = LazyKt.lazy(new WindowExplainBackContentElementPresenter$img0$2(this));
        this.i = LazyKt.lazy(new WindowExplainBackContentElementPresenter$img1$2(this));
        this.j = LazyKt.lazy(new WindowExplainBackContentElementPresenter$mainTitleView$2(this));
        this.k = LazyKt.lazy(new WindowExplainBackContentElementPresenter$subTitleView$2(this));
    }
}
