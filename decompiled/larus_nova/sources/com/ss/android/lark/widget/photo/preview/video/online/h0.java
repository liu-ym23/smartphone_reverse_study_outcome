package com.ss.android.lark.widget.photo.preview.video.online;

/* JADX INFO: loaded from: classes38.dex */
public final class h0 implements y0c.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f447361a;

    public final void a() {
        if (fdc.a.c(this.f447361a.f447320a) == false) goto L5;
        f0 r100 = this.f447361a;
        r100.f447338s = false;
        r100.f447337r = false;
        r100.A.showSaveVideo(false).showSaveToDriver(false).showCopyVideo(false);
    L5:
        this.f447361a.f447325f.performHapticFeedback(0);
        if (com.ss.android.lark.widget.photopicker.f.a().t() == false) goto L8;
        f r101 = this.f447361a.B;
        r101.f447318b.generateFuncListItems(r101.f447317a, false);
        return;
    L8:
        this.f447361a.f447326g.A4();
    }

    public h0(f0 r100) {
        this.f447361a = r100;
    }
}
