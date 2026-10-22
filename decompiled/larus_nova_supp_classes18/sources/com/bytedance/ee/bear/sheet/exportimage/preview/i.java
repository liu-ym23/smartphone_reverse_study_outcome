package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public i(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L8;
        SheetImagePreviewFragment r4 = this.a;
        ExternalShareView r0 = r4.h;
        if (r0 == null) goto L9;
        r0.post(new h(r4));
        return;
    L9:
        return;
    }
}
