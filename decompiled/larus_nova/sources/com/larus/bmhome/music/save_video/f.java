package com.larus.bmhome.music.save_video;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Result;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> f313101a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(kotlinx.coroutines.i<? super Boolean> r100) {
        this.f313101a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        kotlinx.coroutines.i<Boolean> r102 = this.f313101a;
        Result.Companion r103 = Result.Companion;
        r102.resumeWith(Result.m9449constructorimpl(Boolean.FALSE));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        kotlinx.coroutines.i<Boolean> r104 = this.f313101a;
        Result.Companion r105 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(Boolean.TRUE));
    }
}
