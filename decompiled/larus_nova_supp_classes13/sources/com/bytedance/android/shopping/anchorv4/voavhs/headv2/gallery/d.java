package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class d extends b {
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
    public final boolean a(int r1) {
        return true;
    }

    public d(View r8, boolean r9, boolean r10, boolean r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r12 & 16) == 0) goto L9;
        boolean r3 = false;
    L10:
        Intrinsics.checkNotNullParameter(r8, FreqActions.ACTION_VIEW);
        super(r8, new m0(r9, true, r3, 0, r5, 24));
        return;
    L9:
        r3 = r11;
        goto L10
    L5:
        r5 = r10;
        goto L7
    }
}
