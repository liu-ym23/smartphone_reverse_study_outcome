package j22;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.nf;
import com.bytedance.android.livesdk.config.uj1;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ISpeakingImageDef;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.ImageInfo;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static uj1 f496959g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f496960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f496961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f496962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f496963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f496964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f496965f;

    public class a extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f496966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f496967b;

        public a(c r100, k r101) {
            this.f496967b = r100;
            this.f496966a = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            if ((r102 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r102).setAnimationListener(new j22.b(this, r102));
            return;
        }
    }

    public class b extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f496968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f496969b;

        public b(c r100, String r101) {
            this.f496969b = r100;
            this.f496968a = r101;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            super.onFinalImageSet(r100, r103, r102);
            if ((r103 instanceof CloseableAnimatedImage) == false) goto L10;
            AnimatedImageResult r104 = ((CloseableAnimatedImage) r103).getImageResult();
            if (r104 == null) goto L10;
            if (r104.getImage().getFrameCount() <= 0) goto L10;
            AnimatedImageFrame r105 = r104.getImage().getFrame(0);
            c r106 = this.f496969b;
            r106.f496965f = Bitmap.createBitmap(r106.f496960a.getWidth(), this.f496969b.f496960a.getHeight(), Bitmap.Config.ARGB_8888);
            r105.renderFrame(this.f496969b.f496960a.getWidth(), this.f496969b.f496960a.getHeight(), this.f496969b.f496965f);
        L10:
            if ((r102 instanceof AnimatedDrawable2) == false) goto L13;
            ((AnimatedDrawable2) r102).setAnimationListener(new d(this));
            return;
        }
    }

    static {
        f496959g = nf.f120827a.getValue();
    }

    public c(HSImageView r100) {
        this.f496963d = false;
        this.f496964e = false;
        this.f496960a = r100;
        f496959g = nf.f120827a.getValue();
    }

    public final void a(String r100) {
        if (this.f496960a != null) goto L5;
        return;
    L5:
        AbstractDraweeController r101 = Fresco.newDraweeControllerBuilder().setOldController(this.f496960a.getController()).setUri(r100).setControllerListener(new b(this, r100)).setAutoPlayAnimations(true).build();
        if (this.f496965f == null) goto L8;
        this.f496960a.getHierarchy().setPlaceholderImage(new BitmapDrawable(this.f496965f));
    L8:
        this.f496960a.setController(r101);
    }

    public final void b(k r100) {
        if (this.f496960a != null) goto L5;
        return;
    L5:
        AbstractDraweeController r101 = Fresco.newDraweeControllerBuilder().setOldController(this.f496960a.getController()).setFirstAvailableImageRequests(a1.b(r100, -1)).setControllerListener(new a(this, r100)).setAutoPlayAnimations(true).build();
        if (this.f496965f == null) goto L8;
        this.f496960a.getHierarchy().setPlaceholderImage(new BitmapDrawable(this.f496965f));
    L8:
        this.f496960a.setController(r101);
    }

    public final void d(String r100) {
        this.f496963d = false;
        if (TextUtils.equals(r100, this.f496962c) == true) goto L5;
        this.f496962c = r100;
    L5:
        HSImageView r101 = this.f496960a;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getController() == null) goto L11;
        return;
    L11:
        a(r100);
    }

    public final void e(k r100) {
        this.f496963d = false;
        this.f496964e = false;
        if (r100 != null) goto L5;
    L7:
        HSImageView r101 = this.f496960a;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.getController() == null) goto L13;
        return;
    L13:
        b(this.f496961b);
        return;
    L5:
        if (r100.equals(this.f496961b) == true) goto L7;
        this.f496961b = r100;
        goto L7
    }

    public final void f(k r100) {
        this.f496963d = false;
        this.f496964e = true;
        if (r100 != null) goto L5;
    L7:
        HSImageView r101 = this.f496960a;
        if (r101 != null) goto L10;
    L14:
        b(this.f496961b);
        return;
    L10:
        if (r101.getController() == null) goto L14;
        if (this.f496960a.isAnimating() == false) goto L14;
        return;
    L5:
        if (r100.equals(this.f496961b) == true) goto L7;
        this.f496961b = r100;
        goto L7
    }

    @ISpeakingImageDef.VoiceVolume
    public static int c(int r100, boolean r101) {
        if (r101 == false) goto L4;
        uj1 r102 = f496959g;
    L6:
        if (r100 > 30) goto L9;
        return 0;
    L9:
        if (r100 <= 30) goto L15;
        if (r100 > r102.low) goto L15;
        return 1;
    L15:
        if (r100 > r102.low) goto L17;
        return 3;
    L17:
        if (r100 > r102.media) goto L22;
        return 2;
    L22:
        return 3;
    L4:
        r102 = nf.f120827a.getValue();
        goto L6
    }
}
