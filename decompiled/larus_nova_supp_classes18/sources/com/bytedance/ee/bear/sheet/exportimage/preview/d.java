package com.bytedance.ee.bear.sheet.exportimage.preview;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public d(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        PreviewTitleModel r3 = (PreviewTitleModel) r2;
        if (r3 == null) goto L13;
        PreviewTitleModel.Item r4 = r3.getTitleItem();
        if (r4 == null) goto L14;
        String r5 = r4.text;
        if (r5 == null) goto L16;
        BaseTitleBar r0 = this.a.i;
        if (r0 == null) goto L15;
        r0.setTitle(r5);
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }
}
