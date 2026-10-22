package u02;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PKBattlePropEffectWidget f548147a;

    public b(PKBattlePropEffectWidget r100) {
        this.f548147a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
        r102 = null;
    L5:
        AnimatedDrawable2 r104 = (AnimatedDrawable2) r102;
        if (r104 == null) goto L17;
        this.f548147a.f130005d = r104;
        r104.setLoopCount(1);
        AnimatedDrawable2 r105 = this.f548147a.f130005d;
        if (r105 == null) goto L10;
        r105.start();
    L10:
        AnimatedDrawable2 r106 = this.f548147a.f130005d;
        if (r106 == null) goto L13;
        com.bytedance.android.live.core.utils.fresco.c.b(r106);
    L13:
        PKBattlePropEffectWidget r107 = this.f548147a;
        AnimatedDrawable2 r108 = r107.f130005d;
        if (r108 == null) goto L18;
        r108.setAnimationListener(r107.f130012k);
        return;
    L18:
        return;
    }
}
