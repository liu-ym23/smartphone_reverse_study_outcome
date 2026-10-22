package com.bytedance.android.window.shop.holder.presenter;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.widget.WindowRecommendAndBoughtCard;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHeaderFansBuyItemPresenter extends ECWindowHolderBaseFragmentPresenter {
    public WindowRecommendAndBoughtCard i;
    public final WindowHeaderFansBuyItemPresenter$observer$1 j;

    public final void c0() {
        d0().getSubCollapseProgress().removeObserver(this.j);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.window.shop.holder.presenter.WindowHeaderFansBuyItemPresenter$observer$1] */
    public WindowHeaderFansBuyItemPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.j = new WindowHeaderFansBuyItemPresenter$observer$1(this);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.android.window.shop.widget.WindowRecommendAndBoughtCard] */
    public final void b0(QModel r11) {
        String r1 = null;
        if ((r11 instanceof oq3.d) == true) goto L5;
        r11 = null;
    L5:
        oq3.d r12 = (oq3.d) r11;
        if (r12 == null) goto L56;
        Object r0 = a0();
        if (r0 == null) goto L55;
        ?? r2 = (WindowRecommendAndBoughtCard) r0;
        this.i = r2;
        Intrinsics.checkNotNullParameter(r12, "fansBuyItemVO");
        String r3 = r12.k;
        boolean r4 = true;
        if (r3 != null) goto L12;
    L19:
        TextView r5 = r2.b;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recommendName");
    L22:
        r5.setText(r5.getContext().getString(2131896795));
        r5.setTextColor(com.bytedance.android.ec.window.base.utils.c.c(r5.getContext(), 2131105952));
    L23:
        String r6 = r12.j;
        if (r6 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == false) goto L32;
    L35:
        if (r4 == false) goto L43;
        View r13 = r2.c;
        if (r13 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("userBoughtContainer");
    L39:
        r13.setVisibility(8);
        View r14 = r2.a;
        if (r14 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("boughtEmpty");
    L42:
        r14.setVisibility(0);
    L47:
        Function0<Unit> r15 = r2.e;
        if (r15 == null) goto L50;
        Unit r16 = (Unit) r15.invoke();
    L50:
        WindowRecommendAndBoughtCard r17 = this.i;
        if (r17 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L53:
        r17.setDoEventAction(new WindowHeaderFansBuyItemPresenter$onBind$$inlined$also$lambda$1(this));
        d0().getSubCollapseProgress().observe(e0(), this.j);
        return;
    L43:
        TextView r8 = r2.d;
        if (r8 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("boughtCount");
    L46:
        r8.setText(r12.j);
        goto L47
    L32:
        if (Intrinsics.areEqual(r12.j, "0") == true) goto L35;
        r4 = false;
        goto L35
    L26:
        if (r6.length() == 0) goto L29;
        r7 = false;
        goto L30
    L12:
        if ((!StringsKt.isBlank(r3)) == false) goto L14;
        r1 = r3;
    L14:
        if (r1 == null) goto L19;
        SpannableString r9 = new SpannableString(ag4.a.a(2131896801, CollectionsKt.listOf(r1)));
        int r10 = r1.length() + 7;
        r9.setSpan(new ForegroundColorSpan(com.bytedance.android.ec.window.base.utils.c.c(r2.getContext(), 2131101185)), 7, r10, 33);
        r9.setSpan(new StyleSpan(1), 7, r10, 33);
        TextView r18 = r2.b;
        if (r18 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recommendName");
    L18:
        r18.setTextColor(com.bytedance.android.ec.window.base.utils.c.c(r18.getContext(), 2131105952));
        r18.setText(r9);
        goto L23
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.WindowRecommendAndBoughtCard");
    }
}
