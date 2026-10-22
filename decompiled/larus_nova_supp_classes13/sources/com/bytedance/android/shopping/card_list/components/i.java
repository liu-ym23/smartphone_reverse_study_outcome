package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends b {
    public final LinearLayout d;

    public final int g() {
        LinearLayout r1 = this.d;     // Catch: Throwable -> L13
        if (r1 == null) goto L17;
        View r2 = r1.getChildAt(r1.getChildCount() - 1);     // Catch: Throwable -> L13
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.getMeasuredHeight());     // Catch: Throwable -> L13
    L9:
        if (r3 == null) goto L17;
        return r3.intValue();
    L8:
        r3 = null;
    L17:
        return com.bytedance.android.shopping.extensions.b.b(64);
    L14:
        return com.bytedance.android.shopping.extensions.b.b(64);
    }

    public i(CardListObjectContainer r2, LinearLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        super(r2);
        this.d = r3;
    }
}
