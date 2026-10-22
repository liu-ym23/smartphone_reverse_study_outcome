package com.larus.bmhome.chat.layout.item;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes25.dex */
public final class o implements ControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f304544a;

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
    }

    public o(n r100) {
        this.f304544a = r100;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        RoundAvatarImageView r102 = this.f304544a.f304514q;
        if (r102 == null) goto L7;
        GenericDraweeHierarchy r103 = r102.getHierarchy();
        if (r103 == null) goto L7;
        r103.setPlaceholderImage(R.drawable.larus_common_ui_avatar_placeholder);
    L7:
        RoundAvatarImageView r104 = this.f304544a.f304514q;
        if (r104 == null) goto L10;
        r104.setActualImageResource(R.drawable.larus_common_ui_avatar_placeholder);
    L10:
        this.f304544a.n();
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
        this.f304544a.n();
    }
}
