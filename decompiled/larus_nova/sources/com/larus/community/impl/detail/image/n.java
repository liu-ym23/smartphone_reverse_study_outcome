package com.larus.community.impl.detail.image;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class n extends BaseControllerListener<ImageInfo> {
    public n() {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("load fail ,");
        if (r101 == null) goto L5;
        String r104 = r101.getMessage();
    L6:
        r103.append(r104);
        r102.e("CreationDetailImageView", r103.toString());
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, Object r101) {
        ImageInfo r102 = (ImageInfo) r101;
        super.onIntermediateImageSet(r100, r102);
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("load onIntermediateImageSet imageInfo is ");
        Integer r105 = null;
        if (r102 == null) goto L5;
        Integer r106 = Integer.valueOf(r102.getWidth());
    L6:
        r104.append(r106);
        r104.append(' ');
        if (r102 == null) goto L9;
        r105 = Integer.valueOf(r102.getHeight());
    L9:
        r104.append(r105);
        r103.i("CreationDetailImageView", r104.toString());
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        super.onSubmit(r100, r101);
        FLogger.f375446a.i("CreationDetailImageView", "load success");
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        super.onFinalImageSet(r100, r103, r102);
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("load onFinalImageSet imageInfo is ");
        Integer r106 = null;
        if (r103 == null) goto L5;
        Integer r107 = Integer.valueOf(r103.getWidth());
    L6:
        r105.append(r107);
        r105.append(' ');
        if (r103 == null) goto L9;
        r106 = Integer.valueOf(r103.getHeight());
    L9:
        r105.append(r106);
        r104.i("CreationDetailImageView", r105.toString());
        return;
    L5:
        r107 = null;
        goto L6
    }
}
