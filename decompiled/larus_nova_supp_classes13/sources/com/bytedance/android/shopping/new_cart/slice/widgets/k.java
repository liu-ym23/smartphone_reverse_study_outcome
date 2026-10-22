package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements TextWatcher {
    public final /* synthetic */ CounterViewV2 a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public k(CounterViewV2 r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r14) {
        if (this.a.r.hasFocus() == true) goto L5;
        return;
    L5:
        Integer r0 = StringsKt.toIntOrNull(String.valueOf(r14));
        if (r0 == null) goto L20;
        int r1 = r0.intValue();
        if (r1 >= this.a.getMinQuantity()) goto L14;
        CartViewModel r7 = this.a.getCartVM();
        if (r7 == null) goto L12;
        CartViewModel.doEventAction$default(r7, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.a.getMinLimitToast()), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a.getProductId())}), null, 4, null);
    L12:
        ECToast.showToast$default(ECToast.INSTANCE, this.a.getContext(), this.a.getMinLimitToast(), 0, null, 8, null);
        CounterViewV2 r2 = this.a;
        r2.e(r2.getMinQuantity());
        return;
    L14:
        if (r1 <= this.a.getMaxQuantity()) goto L22;
        CartViewModel r8 = this.a.getCartVM();
        if (r8 == null) goto L18;
        CartViewModel.doEventAction$default(r8, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.a.getMaxLimitToast()), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, this.a.getProductId())}), null, 4, null);
    L18:
        ECToast.showToast$default(ECToast.INSTANCE, this.a.getContext(), this.a.getMaxLimitToast(), 0, null, 8, null);
        CounterViewV2 r3 = this.a;
        r3.e(r3.getMaxQuantity());
        return;
    L22:
        return;
    }
}
