package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes23.dex */
public class RoundedNinePatchDrawable extends RoundedDrawable {
    public RoundedNinePatchDrawable(NinePatchDrawable r100) {
        super(r100);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("RoundedNinePatchDrawable#draw");
    L6:
        if (shouldRound() == true) goto L11;
        super.draw(r100);
        if (FrescoSystrace.isTracing() == false) goto L15;
        FrescoSystrace.endSection();
        return;
    L15:
        return;
    L11:
        updateTransform();
        updatePath();
        r100.clipPath(this.mPath);
        super.draw(r100);
        if (FrescoSystrace.isTracing() == false) goto L16;
        FrescoSystrace.endSection();
        return;
    }
}
