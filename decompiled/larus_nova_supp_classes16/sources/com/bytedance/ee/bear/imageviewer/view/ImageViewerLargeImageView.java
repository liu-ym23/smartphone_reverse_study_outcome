package com.bytedance.ee.bear.imageviewer.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.largeimage.transform.CropAndRotationTransformation;
import com.ss.android.lark.imagewidget.largeimage.transform.ScaleAndCliPathTransformation;
import com.ss.android.lark.imagewidget.largeimage.transform.WhiteBgTransformation;
import com.ss.android.lark.imagewidget.largeimage.transform.b;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.List;
import nlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageViewerLargeImageView extends LargeImageView {
    public AppCompatImageView g;

    public ImageViewerLargeImageView(Context r1) {
        super(r1);
    }

    public final SubsamplingScaleImageView l(Context r2) {
        return new ImageViewerSubsamplingScaleImageView(r2);
    }

    public final List<BitmapTransformation> m(g r7) {
        ArrayList r0 = new ArrayList();
        b r8 = r7.d;
        if (r8 == null) goto L7;
        r0.add(new CropAndRotationTransformation(r8.c, r8.b));
        r0.add(new ScaleAndCliPathTransformation(r8.d, r8.e, r8.f, r8.g));
        if (r8.i == false) goto L8;
        r0.add(new WhiteBgTransformation());
    L8:
        return r0;
    L7:
        r0.add(new WhiteBgTransformation());
        goto L8
    }

    public void setScaleImageViewInfo(g r5) {
        b r6 = r5.d;
        if (r6 != null) goto L5;
        return;
    L5:
        SubsamplingScaleImageView r0 = ((LargeImageView) this).b;
        if ((r0 instanceof ImageViewerSubsamplingScaleImageView) == false) goto L22;
        ImageViewerSubsamplingScaleImageView r1 = (ImageViewerSubsamplingScaleImageView) r0;
        Integer r2 = r6.h;
        if (r2 == null) goto L10;
        r0.setTileBackgroundColor(r2.intValue());
    L10:
        float r3 = r6.d;
        if (r3 == 1.0f) goto L13;
    L16:
        r1.S(r3, r6.e);
    L18:
        if (TextUtils.isEmpty(r6.f) == true) goto L20;
        r1.setClipPath(r6.g);
        return;
    L20:
        r1.setClipPath(null);
        return;
    L13:
        if (r6.e != 1.0f) goto L16;
        r1.S(1.0f, 1.0f);
        goto L18
    }

    public ImageViewerLargeImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ImageViewerLargeImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
