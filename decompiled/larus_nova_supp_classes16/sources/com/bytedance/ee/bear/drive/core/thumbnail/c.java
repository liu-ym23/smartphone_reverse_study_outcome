package com.bytedance.ee.bear.drive.core.thumbnail;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements j {
    public final /* synthetic */ b a;

    @Override // com.bytedance.ee.bear.drive.core.thumbnail.j
    public final void b() {
    }

    public c(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.core.thumbnail.j
    public final void a(int r3, boolean r4) {
        if (r4 == true) goto L15;
        b r5 = this.a;
        if (r3 >= 0) goto L6;
        r5.getClass();
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L12;
        return;
    L12:
        if (this.a.b.getCurrentItem() == r3) goto L17;
        tt5.a.h("DrivePreviewThumbnailController", "onFling settle position=" + r3);
        this.a.b.setCurrentItem(r3, true);
        return;
    L17:
        return;
    L6:
        if (r3 >= ((ArrayList) r5.c).size()) goto L9;
        r6 = true;
        goto L10
    }
}
