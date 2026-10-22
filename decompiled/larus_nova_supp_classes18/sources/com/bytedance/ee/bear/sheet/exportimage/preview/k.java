package com.bytedance.ee.bear.sheet.exportimage.preview;

import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import rm5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements o.b {
    public final /* synthetic */ SheetImagePreviewPlugin a;
    public final /* synthetic */ ShareType b;

    @Override // rm5.o.b
    public final void onFail(String r1) {
    }

    @Override // rm5.o.b
    public final void onSuccess() {
        SheetImagePreviewPlugin.access$reportShareExportImageSuccess(this.a, this.b);
    }

    public k(SheetImagePreviewPlugin r1, ShareType r2) {
        this.a = r1;
        this.b = r2;
    }
}
