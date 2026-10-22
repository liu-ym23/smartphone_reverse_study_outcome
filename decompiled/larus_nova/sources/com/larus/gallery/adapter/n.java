package com.larus.gallery.adapter;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes29.dex */
public final class n extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryVideoHolder f343721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f343722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.larus.gallery.api.k f343723c;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        r r102 = this.f343721a.f343681d;
        if (r102 == null) goto L6;
        r102.e(ImageSetResult.Fail, this.f343722b, this.f343723c, null);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, Object r101) {
        r r102 = this.f343721a.f343681d;
        if (r102 == null) goto L6;
        r102.e(ImageSetResult.LowRes, this.f343722b, this.f343723c, null);
        return;
    }

    public n(GalleryVideoHolder r100, int r101, com.larus.gallery.api.k r102) {
        this.f343721a = r100;
        this.f343722b = r101;
        this.f343723c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        r r103 = this.f343721a.f343681d;
        if (r103 == null) goto L10;
        ImageSetResult r104 = ImageSetResult.Success;
        int r105 = this.f343722b;
        com.larus.gallery.api.k r106 = this.f343723c;
        if ((r101 instanceof ImageInfo) == false) goto L7;
        ImageInfo r107 = (ImageInfo) r101;
    L8:
        r103.e(r104, r105, r106, r107);
        return;
    L7:
        r107 = null;
        goto L8
    }
}
