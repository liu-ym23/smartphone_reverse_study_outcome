package com.bytedance.locallife.poi.media.photo;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlidesPhotosView f262794a;

    @Override // com.bytedance.locallife.poi.media.photo.l.a
    public final boolean a() {
        if (this.f262794a.f262709e.getAutoPlayEnabled() == false) goto L9;
        j r100 = this.f262794a.f262726v;
        if (r100 == null) goto L11;
        r100.a();
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public p(SlidesPhotosView r100) {
        this.f262794a = r100;
    }

    @Override // com.bytedance.locallife.poi.media.photo.l.a
    public final void b(float r110, float r111, long r112) {
        SlidesPhotosView r100 = this.f262794a;
        SlidesPhotosView.e(r100, r100.f262718n, r110, r111, r112, false, 16);
        boolean r113 = true;
        if (r110 != 100.0f) goto L5;
        boolean r114 = true;
    L6:
        if (r114 == false) goto L39;
        SlidesPhotosView r115 = this.f262794a;
        j r116 = r115.f262726v;
        if (r116 == null) goto L10;
        r116.e();
    L10:
        int r117 = r115.f262716l.getItemCount();
        int r101 = r115.f262719o + 1;
        if (r115.f262720p == true) goto L17;
        if (r117 <= 1) goto L17;
        j r102 = r115.f262726v;
        if (r102 == null) goto L16;
        r102.g();
    L16:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L21;
        return;
    L21:
        if (r101 < r117) goto L25;
        if (r115.f262709e.getEnableLoop() == true) goto L25;
    L28:
        hy6.b r118 = r115.f262707c;
        if (r118 == null) goto L31;
        r118.g();
    L31:
        j r119 = r115.f262726v;
        if (r119 == null) goto L34;
        r119.h();
    L35:
        if (r113 == false) goto L41;
        r115.g(0, false, 0);
        return;
    L41:
        return;
    L34:
        r113 = false;
    L25:
        if (r115.f262709e.getEnableLoop() == true) goto L27;
    L37:
        r115.g(r101, true, 0);
        return;
    L27:
        if (r101 < 10000) goto L37;
    L17:
        r103 = false;
        goto L19
    L39:
        return;
    L5:
        r114 = false;
        goto L6
    }
}
