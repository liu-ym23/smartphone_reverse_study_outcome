package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public e(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        SheetImagePreviewFragment r0 = this.a;
        r0.n = Intrinsics.areEqual((Boolean) r3, Boolean.TRUE);
    }
}
