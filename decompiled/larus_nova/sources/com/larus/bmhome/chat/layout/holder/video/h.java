package com.larus.bmhome.chat.layout.holder.video;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.chat.layout.holder.image.n0;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class h extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f304080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GenerateVideoBox f304081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f304082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f304083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f304084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f304085f;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        String r102 = this.f304080a;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        FLogger.f375446a.e(this.f304081b.f304058y, "[image_load_failed]:" + this.f304080a, r101);
        return;
    L12:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, Object r101) {
        ImageInfo r102 = (ImageInfo) r101;
        FLogger r103 = FLogger.f375446a;
        String r104 = this.f304081b.f304058y;
        StringBuilder r105 = new StringBuilder("[onIntermediateImageSet]:");
        r105.append(this.f304082c);
        r105.append("   ");
        r105.append(r100);
        r105.append(' ');
        if (r102 == null) goto L7;
        ImageFormat r106 = r102.getImageFormat();
        if (r106 == null) goto L7;
        String r107 = r106.getFileExtension();
    L8:
        r105.append(r107);
        r105.append(' ');
        r103.i(r104, r105.toString());
        super.onIntermediateImageSet(r100, r102);
        n0 r108 = this.f304083d;
        if (r108 == null) goto L12;
        r108.b(this.f304084e, this.f304085f);
        return;
    L12:
        return;
    L7:
        r107 = null;
        goto L8
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        super.onSubmit(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        FLogger r104 = FLogger.f375446a;
        String r105 = this.f304081b.f304058y;
        StringBuilder r106 = new StringBuilder("[onFinalImageSet]:");
        r106.append(this.f304080a);
        r106.append("   ");
        r106.append(r100);
        r106.append(tb2.c.DEFAULT_TEXT);
        if (r103 == null) goto L7;
        ImageFormat r107 = r103.getImageFormat();
        if (r107 == null) goto L7;
        String r108 = r107.getFileExtension();
    L8:
        r106.append(r108);
        r106.append(' ');
        r104.i(r105, r106.toString());
        super.onFinalImageSet(r100, r103, r102);
        n0 r109 = this.f304083d;
        if (r109 == null) goto L11;
        r109.b(this.f304084e, this.f304085f);
    L11:
        this.f304081b.f304053t = true;
        return;
    L7:
        r108 = null;
        goto L8
    }

    public h(String r100, GenerateVideoBox r101, Uri r102, n0 r103, String r104, int r105) {
        this.f304080a = r100;
        this.f304081b = r101;
        this.f304082c = r102;
        this.f304083d = r103;
        this.f304084e = r104;
        this.f304085f = r105;
    }
}
