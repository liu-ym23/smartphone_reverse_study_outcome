package com.bytedance.android.shopping.card_list.slice.widgets;

import android.view.KeyEvent;
import android.widget.TextView;
import com.bytedance.android.shopping.card_list.utils.CardListExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements TextView.OnEditorActionListener {
    public final /* synthetic */ CounterView a;

    public h(CounterView r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "v");
        if (r2 != 6) goto L9;
        r1.clearFocus();
        CardListExtentionsKt.h(r1);
        Integer r4 = CardListExtentionsKt.b(r1.getText().toString());
        if (r4 == null) goto L11;
        int r5 = r4.intValue();
        this.a.g(r5);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
