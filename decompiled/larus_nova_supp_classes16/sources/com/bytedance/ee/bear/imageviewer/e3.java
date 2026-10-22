package com.bytedance.ee.bear.imageviewer;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e3 implements com.bytedance.ee.bear.bizwidget.magicshare.cursor.a {
    public final /* synthetic */ c3 a;

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.a
    public final View o0() {
        return this.a.iF();
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.a
    public final RectF p0() {
        LargeImageView r0 = o0();
        if ((r0 instanceof LargeImageView) == false) goto L14;
        LargeImageView r1 = r0;
        ImageView r2 = r1.getImageView();
        if (r2.getVisibility() != 0) goto L10;
        RectF r3 = new RectF();
        Drawable r4 = r2.getDrawable();
        if (r4 == null) goto L10;
        r3.set(0.0f, 0.0f, r4.getIntrinsicWidth(), r4.getIntrinsicHeight());
        r2.getImageMatrix().mapRect(r3);
        return r3;
    L10:
        SubsamplingScaleImageView r5 = r1.getScaleImageView();
        if (r5.getVisibility() == 0) goto L13;
        return null;
    L13:
        return r5.getContentRect();
    L14:
        return null;
    }

    public e3(c3 r1) {
        this.a = r1;
    }
}
