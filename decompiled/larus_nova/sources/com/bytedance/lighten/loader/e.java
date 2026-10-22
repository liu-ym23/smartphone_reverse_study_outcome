package com.bytedance.lighten.loader;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes20.dex */
public final class e extends BaseControllerListener<ImageInfo> implements ImageOriginListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SmartImageView f254724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public hf6.f f254725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f254726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CloseableAnimatedImage f254727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f254728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public df6.t f254729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f254730g;

    public e() {
        this.f254728e = false;
        this.f254730g = -1;
    }

    public final void a(df6.t r100) {
        this.f254729f = r100;
        this.f254724a = (SmartImageView) r100.f468274z;
        this.f254725b = r100.B;
        ef6.a r101 = r100.E;
        if (r101 != null) goto L5;
    L7:
        this.f254726c = r100.f468249a;
        return;
    L5:
        if (r101.a() == true) goto L7;
        this.f254726c = UriProtector.parse((String) ListProtector.get(r100.E.f472521a, 0));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
        super.onRelease(r100);
        hf6.f r101 = this.f254725b;
        if (r101 == null) goto L5;
        r101.onRelease(this.f254726c);
    L5:
        this.f254728e = false;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Objects.toString(r101);
        hf6.f r102 = this.f254725b;
        if (r102 == null) goto L5;
        r102.onFailed(this.f254726c, this.f254724a, r101);
    L5:
        this.f254728e = false;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
        super.onIntermediateImageFailed(r100, r101);
        hf6.f r102 = this.f254725b;
        if (r102 == null) goto L5;
        r102.onIntermediateImageFailed(this.f254726c, r101);
    L5:
        this.f254728e = false;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, @Nullable Object r101) {
        ImageInfo r102 = (ImageInfo) r101;
        super.onIntermediateImageSet(r100, r102);
        hf6.f r103 = this.f254725b;
        if (r103 == null) goto L7;
        if (r102 == null) goto L6;
        df6.o r104 = new df6.o(r102.getWidth(), r102.getHeight(), this.f254730g);
        this.f254725b.onIntermediateImageSet(this.f254726c, r104);
        goto L7
    L6:
        r103.onIntermediateImageSet(this.f254726c, null);
    L7:
        this.f254728e = false;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        hf6.f r102 = this.f254725b;
        if (r102 == null) goto L6;
        r102.onStart(this.f254726c, this.f254724a);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r103 instanceof CloseableAnimatedImage) == false) goto L5;
        this.f254727d = (CloseableAnimatedImage) r103;
    L5:
        boolean r104 = true;
        if (r102 != null) goto L9;
        r104 = false;
    L9:
        this.f254728e = r104;
        hf6.f r105 = this.f254725b;
        if (r105 == null) goto L15;
        if (r103 == null) goto L13;
        df6.o r106 = new df6.o(r103.getWidth(), r103.getHeight(), this.f254730g);
        r106.f468226d = r103;
        this.f254725b.onComplete(this.f254726c, this.f254724a, r106, r102);
        goto L15
    L13:
        r105.onComplete(this.f254726c, this.f254724a, null, r102);
    L15:
        if (this.f254727d == null) goto L18;
        this.f254729f.getClass();
    L18:
        if (this.f254728e == true) goto L20;
        return;
    L20:
        if (this.f254729f.f468251c == false) goto L24;
        this.f254724a.n();
        return;
    }

    @Override // com.facebook.drawee.backends.pipeline.info.ImageOriginListener
    public final void onImageLoaded(String r100, int r101, boolean r102) {
        this.f254730g = r101;
    }
}
