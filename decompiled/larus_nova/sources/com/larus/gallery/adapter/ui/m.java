package com.larus.gallery.adapter.ui;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryImageView f343790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f343791b;

    public m(GalleryImageView r100, float r101) {
        this.f343790a = r100;
        this.f343791b = r101;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        if (r100.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        RectF r102 = new RectF();
        this.f343790a.f343751w.getHierarchy().getActualImageBounds(r102);
        if (r102.isEmpty() == true) goto L8;
        int r103 = r100.getPaddingLeft() + ((int) r102.left);
        int r104 = r100.getPaddingTop() + ((int) r102.top);
        int r105 = r100.getPaddingLeft() + ((int) r102.right);
        int r106 = r100.getPaddingTop();
        r101.setRoundRect(r103, r104, r105, ((int) r102.bottom) + r106, this.f343791b);
        return;
    L8:
        r101.setRoundRect(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getWidth() - r100.getPaddingRight(), r100.getHeight() - r100.getPaddingBottom(), this.f343791b);
    }
}
