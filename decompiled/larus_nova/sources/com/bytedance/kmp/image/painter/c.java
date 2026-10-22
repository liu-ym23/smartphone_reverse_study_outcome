package com.bytedance.kmp.image.painter;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import com.bytedance.kmp.image.options.g;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.BaseFrescoControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends BaseFrescoControllerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f252175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super com.bytedance.kmp.image.options.c, Unit> f252176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ControllerListener<? super ImageInfo> f252177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f252178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f252179e;

    public static final class a implements AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f252180a;

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationReset(AnimatedDrawable2 r100) {
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
        }

        public a(c r100) {
            this.f252180a = r100;
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationRepeat(AnimatedDrawable2 r100) {
            if (r100 == null) goto L10;
            c r101 = this.f252180a;
            if (r100.getLoopCount() == 0) goto L8;
            int r102 = r101.f252179e + 1;
            r101.f252179e = r102;
            if (r102 < r100.getLoopCount()) goto L11;
            r100.stop();
            r101.f252179e = 0;
            return;
        L11:
            return;
        L8:
            r101.f252179e = 0;
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            this.f252180a.getClass();
        }

        @Override // com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
            c r102 = this.f252180a;
            if (r102.f252178d == true) goto L6;
            r102.getClass();
            this.f252180a.f252178d = true;
            return;
        }
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
        super.onRelease(r100);
        ControllerListener<? super ImageInfo> r101 = this.f252177c;
        if (r101 == null) goto L5;
        r101.onRelease(r100);
    L5:
        this.f252177c = null;
        this.f252175a = null;
        this.f252176b = null;
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public final void onControllerStart(ImageRequest r100, long r101) {
        super.onControllerStart(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        ControllerListener<? super ImageInfo> r102 = this.f252177c;
        if (r102 == null) goto L5;
        r102.onFailure(r100, r101);
    L5:
        g r103 = this.f252175a;
        if (r103 == null) goto L11;
        if (r101 != null) goto L9;
        r101 = new Exception("unknown Error");
    L9:
        r103.onFail(r101);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
        super.onIntermediateImageFailed(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public final void onRelease(String r100, ImageRequest r101) {
        super.onRelease(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        super.onSubmit(r100, r101);
        ControllerListener<? super ImageInfo> r102 = this.f252177c;
        if (r102 == null) goto L5;
        r102.onSubmit(r100, r101);
    L5:
        g r103 = this.f252175a;
        if (r103 == null) goto L9;
        r103.onLoadStart();
        return;
    }

    public c(g r100, Function1 r101, ControllerListener r102) {
        this.f252175a = r100;
        this.f252176b = r101;
        this.f252177c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public final void onFailure(String r100, ImageRequest r101, Throwable r102) {
        super.onFailure(r100, r101, r102);
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public final void onFinalImageSet(String r100, Object r110, Animatable r111, ImageRequest r112, Map<Object, Object> r113) {
        super.onFinalImageSet(r100, r110, r111, r112, r113);
        AnimatedDrawable2 r101 = null;
        if ((r110 instanceof ImageInfo) == false) goto L5;
        ImageInfo r114 = (ImageInfo) r110;
    L6:
        ControllerListener<? super ImageInfo> r102 = this.f252177c;
        if ((r102 instanceof BaseControllerListener) == false) goto L9;
        BaseControllerListener r103 = (BaseControllerListener) r102;
    L10:
        if (r103 == null) goto L12;
        r103.onFinalImageSet(r100, r114, r111, r112, r113);
    L12:
        if (r114 == null) goto L16;
        Rect r104 = r114.getSmartCrop();
        if (r104 == null) goto L16;
        g.a r115 = new g.a(r104.left, r104.top, r104.right, r104.bottom);
    L17:
        g r105 = this.f252175a;
        if (r105 != null) goto L20;
    L25:
        if (r111 != null) goto L27;
        return;
    L27:
        if ((r111 instanceof AnimatedDrawable2) == false) goto L29;
        r101 = (AnimatedDrawable2) r111;
    L29:
        if (r101 == null) goto L35;
        r101.setAnimationListener(new a(this));
        Function1<? super com.bytedance.kmp.image.options.c, Unit> r106 = this.f252176b;
        if (r106 == null) goto L36;
        r106.invoke(new com.bytedance.kmp.image.painter.a(r101));
        return;
    L36:
        return;
    L35:
        return;
    L20:
        if (r114 == null) goto L22;
        r114.getWidth();
    L22:
        if (r114 == null) goto L24;
        r114.getHeight();
    L24:
        r105.onSuccess(new g.b(r115));
    L16:
        r115 = new g.a(0, 0, 0, 0);
        goto L17
    L9:
        r103 = null;
        goto L10
    L5:
        r114 = null;
        goto L6
    }
}
