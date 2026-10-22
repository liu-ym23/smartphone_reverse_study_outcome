package com.bytedance.android.shopping.buynow.slice.counter;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.buynow.utils.ViewUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements TextView.OnEditorActionListener {
    public final /* synthetic */ BuyNowCounterView a;

    public a(BuyNowCounterView r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (r3 != 6) goto L6;
        r2.clearFocus();
        ViewUtilsKt.a(r2);
        int r5 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r2.getText().toString(), 0);
        BuyNowCounterView r6 = this.a;
        int r7 = BuyNowCounterView.u;
        r6.d(r5);
        return true;
    L6:
        return false;
    }
}
