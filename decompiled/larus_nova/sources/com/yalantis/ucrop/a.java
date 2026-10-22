package com.yalantis.ucrop;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements sqc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UCropFragment f464421a;

    public a(UCropFragment r100) {
        this.f464421a = r100;
    }

    @Override // sqc.a
    public final void b(Throwable r100) {
        this.f464421a.f464395d.H20(UCropFragment.S90(r100));
    }

    @Override // sqc.a
    public final void a(Uri r100, int r101, int r102, int r103, int r110) {
        UCropFragment r104 = this.f464421a;
        b r105 = r104.f464395d;
        float r106 = r104.f464403l.getTargetAspectRatio();
        r105.H20(new UCropFragment.c(new Intent().putExtra("com.yalantis.ucrop.OutputUri", r100).putExtra("com.yalantis.ucrop.CropAspectRatio", r106).putExtra("com.yalantis.ucrop.ImageWidth", r103).putExtra("com.yalantis.ucrop.ImageHeight", r110).putExtra("com.yalantis.ucrop.OffsetX", r101).putExtra("com.yalantis.ucrop.OffsetY", r102)));
        this.f464421a.f464395d.vg(false);
        this.f464421a.f464414w.setClickable(false);
    }
}
