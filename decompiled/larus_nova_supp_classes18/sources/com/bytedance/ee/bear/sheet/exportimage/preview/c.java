package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public c(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        FrameLayout r0 = this.a.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L7;
        int r5 = 0;
    L8:
        r0.setVisibility(r5);
        return;
    L7:
        r5 = 8;
        goto L8
    }
}
