package com.larus.gallery.adapter.ui;

import com.larus.gallery.adapter.r;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class e implements com.larus.common_ui.photoviewer.a.InterfaceC4188a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseScaleGalleryView f343766a;

    @Override // com.larus.common_ui.photoviewer.a.InterfaceC4188a
    public final void b() {
        FLogger.f375446a.i(this.f343766a.f343730b, "onScaleStart");
        r r100 = this.f343766a.getListener();
        if (r100 == null) goto L6;
        r100.h(false);
        return;
    }

    public e(BaseScaleGalleryView r100) {
        this.f343766a = r100;
    }

    @Override // com.larus.common_ui.photoviewer.a.InterfaceC4188a
    public final void a(boolean r100) {
        FLogger.f375446a.i(this.f343766a.f343730b, "onScaleEnd: isScaled " + r100);
        r r101 = this.f343766a.getListener();
        if (r101 == null) goto L11;
        if (r100 == false) goto L6;
    L8:
        boolean r102 = false;
    L9:
        r101.h(r102);
        return;
    L6:
        if (this.f343766a.f() == false) goto L8;
        r102 = true;
        goto L9
    }
}
