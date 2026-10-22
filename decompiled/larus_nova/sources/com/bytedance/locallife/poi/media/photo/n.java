package com.bytedance.locallife.poi.media.photo;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements hf6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlidePhotosViewPagerAdapter.SlidesPhotosViewPagerHolder f262790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f262791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SlidePhotosViewPagerAdapter f262792c;

    @Override // hf6.f
    public final void onIntermediateImageFailed(Uri r100, Throwable r101) {
    }

    @Override // hf6.f
    public final void onIntermediateImageSet(Uri r100, df6.o r101) {
    }

    @Override // hf6.f
    public final void onRelease(Uri r100) {
    }

    @Override // hf6.f
    public final void onStart(Uri r100, View r101) {
        if (Intrinsics.areEqual(this.f262790a.f262700a.getTag(), this.f262791b) == true) goto L5;
        return;
    L5:
        this.f262790a.f262702c.setVisibility(0);
        this.f262790a.f262701b.setVisibility(8);
    }

    public n(SlidePhotosViewPagerAdapter.SlidesPhotosViewPagerHolder r100, String r101, SlidePhotosViewPagerAdapter r102) {
        this.f262790a = r100;
        this.f262791b = r101;
        this.f262792c = r102;
    }

    @Override // hf6.f
    public final void onFailed(Uri r100, View r101, Throwable r102) {
        if (Intrinsics.areEqual(this.f262790a.f262700a.getTag(), this.f262791b) == true) goto L5;
        return;
    L5:
        hy6.c r103 = this.f262792c.f262698b;
        if (r103 == null) goto L8;
        r103.b(this.f262791b, r102);
    L8:
        this.f262790a.f262700a.setVisibility(8);
        this.f262790a.f262702c.setVisibility(8);
        this.f262790a.f262701b.setVisibility(0);
    }

    @Override // hf6.f
    public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
        if (Intrinsics.areEqual(this.f262790a.f262700a.getTag(), this.f262791b) == true) goto L6;
        return;
    L6:
        if (r102 != null) goto L12;
        hy6.c r104 = this.f262792c.f262698b;
        if (r104 == null) goto L10;
        r104.b(this.f262791b, null);
    L10:
        this.f262790a.f262700a.setVisibility(8);
        this.f262790a.f262702c.setVisibility(8);
        this.f262790a.f262701b.setVisibility(0);
        return;
    L12:
        hy6.c r105 = this.f262792c.f262698b;
        if (r105 == null) goto L15;
        r105.l(this.f262791b, this.f262790a.getAdapterPosition());
    L15:
        this.f262790a.f262700a.setVisibility(0);
        this.f262790a.f262702c.setVisibility(8);
        this.f262790a.f262701b.setVisibility(8);
    }
}
