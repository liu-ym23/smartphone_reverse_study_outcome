package com.larus.bmhome.chat.layout.item;

import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a3 extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleAvatarImageView f304257a;

    public a3(TitleAvatarImageView r100) {
        this.f304257a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        this.f304257a.setActualImageResource(R.drawable.larus_common_ui_avatar_placeholder);
    }
}
