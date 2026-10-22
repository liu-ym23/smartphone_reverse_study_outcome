package com.bytedance.ee.bear.drive.core.thumbnail;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f224367a;

    @Override // com.bytedance.ee.bear.drive.core.thumbnail.j
    public final void b() {
    }

    public c(b r100) {
        this.f224367a = r100;
    }

    @Override // com.bytedance.ee.bear.drive.core.thumbnail.j
    public final void a(int r100, boolean r101) {
        if (r101 == true) goto L15;
        b r102 = this.f224367a;
        if (r100 >= 0) goto L6;
        r102.getClass();
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L12;
        return;
    L12:
        if (this.f224367a.f224359b.getCurrentItem() == r100) goto L17;
        tt5.a.h("DrivePreviewThumbnailController", "onFling settle position=" + r100);
        this.f224367a.f224359b.setCurrentItem(r100, true);
        return;
    L17:
        return;
    L6:
        if (r100 >= ((ArrayList) r102.f224360c).size()) goto L9;
        r103 = true;
        goto L10
    }
}
