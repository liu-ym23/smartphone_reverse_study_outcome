package com.larus.gallery.adapter.ui;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.gallery.adapter.ImageSetResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes29.dex */
public final class l extends BaseControllerListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<ImageSetResult, ImageInfo, Unit> f343785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> f343786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GalleryImageView f343787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f343788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f343789e;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        this.f343786b.invoke(Boolean.TRUE, Boolean.FALSE);
        this.f343785a.invoke(ImageSetResult.Fail, null);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, Object r101) {
        this.f343785a.invoke(ImageSetResult.LowRes, (ImageInfo) r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        Function2<Boolean, Boolean, Unit> r102 = this.f343786b;
        Boolean r103 = Boolean.FALSE;
        if (this.f343788d == false) goto L5;
    L7:
        boolean r104 = false;
    L8:
        r102.invoke(r103, Boolean.valueOf(r104));
        return;
    L5:
        if (this.f343789e == true) goto L7;
        r104 = true;
        goto L8
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        Function2<Boolean, Boolean, Unit> r103 = this.f343786b;
        Boolean r104 = Boolean.FALSE;
        r103.invoke(r104, r104);
        if (this.f343787c.f343751w.isAttachedToWindow() == false) goto L5;
        this.f343787c.f343751w.invalidateOutline();
    L5:
        this.f343785a.invoke(ImageSetResult.Success, (ImageInfo) r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function2<? super ImageSetResult, ? super ImageInfo, Unit> r100, Function2<? super Boolean, ? super Boolean, Unit> r101, GalleryImageView r102, boolean r103, boolean r104) {
        this.f343785a = r100;
        this.f343786b = r101;
        this.f343787c = r102;
        this.f343788d = r103;
        this.f343789e = r104;
    }
}
