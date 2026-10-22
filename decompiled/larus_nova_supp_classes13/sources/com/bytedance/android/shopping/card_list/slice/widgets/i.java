package com.bytedance.android.shopping.card_list.slice.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ CounterView a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public i(CounterView r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r11) {
        if (this.a.t.hasFocus() == true) goto L5;
        return;
    L5:
        Integer r12 = StringsKt.toIntOrNull(String.valueOf(r11));
        if (r12 == null) goto L20;
        int r13 = r12.intValue();
        if (r13 >= this.a.getMinQuantity()) goto L14;
        CardListTrackerComponent r14 = CounterView.d(this.a);
        if (r14 == null) goto L12;
        CardListTrackerComponent.h(r14, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.a.getMinLimitToast()), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a.getProductId())}), 4);
    L12:
        ECToast.showToast$default(ECToast.INSTANCE, this.a.getContext(), this.a.getMinLimitToast(), 0, null, 8, null);
        CounterView r15 = this.a;
        r15.h(r15.getMinQuantity());
        return;
    L14:
        if (r13 <= this.a.getMaxQuantity()) goto L22;
        CardListTrackerComponent r16 = CounterView.d(this.a);
        if (r16 == null) goto L18;
        CardListTrackerComponent.h(r16, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.a.getMaxLimitToast()), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a.getProductId())}), 4);
    L18:
        ECToast.showToast$default(ECToast.INSTANCE, this.a.getContext(), this.a.getMaxLimitToast(), 0, null, 8, null);
        CounterView r17 = this.a;
        r17.h(r17.getMaxQuantity());
        return;
    L22:
        return;
    }
}
