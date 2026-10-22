package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class BaseControllerListener<INFO> implements ControllerListener<INFO> {
    private static final ControllerListener<Object> NO_OP_LISTENER = null;

    public BaseControllerListener() {
    }

    public void onControllerStart(ImageRequest r100, long r101) {
    }

    public void onFailure(String r100, ImageRequest r101, Throwable r102) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102) {
    }

    public void onFinalImageSet(String r100, INFO r101, Animatable r102, ImageRequest r103, Map r104) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String r100, Throwable r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageSet(String r100, @Nullable INFO r101) {
    }

    public void onIntermediateImageSet(String r100, @Nullable INFO r101, @Nullable Animatable r102) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String r100) {
    }

    public void onRelease(String r100, ImageRequest r101) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String r100, Object r101) {
    }

    static {
        NO_OP_LISTENER = new BaseControllerListener();
    }

    public static <INFO> ControllerListener<INFO> getNoOpListener() {
        return (ControllerListener<INFO>) NO_OP_LISTENER;
    }
}
