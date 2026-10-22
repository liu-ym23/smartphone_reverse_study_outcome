package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0 extends BaseViewHolder {
    public final TextView c;

    public g0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.c = (TextView) r2.findViewById(2131390740);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "itemData");
        if ((r1 instanceof d) == true) goto L5;
        r1 = null;
    L5:
        d r3 = (d) r1;
        if (r3 == null) goto L9;
        this.c.setText(r3.b);
        return;
    }
}
