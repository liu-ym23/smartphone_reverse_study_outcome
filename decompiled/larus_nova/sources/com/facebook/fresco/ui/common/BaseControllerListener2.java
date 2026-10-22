package com.facebook.fresco.ui.common;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class BaseControllerListener2<INFO> implements ControllerListener2<INFO> {
    private static final ControllerListener2 NO_OP_LISTENER = null;

    public BaseControllerListener2() {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String r100, @Nullable Throwable r101, @Nullable ControllerListener2.Extras r102) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String r100, @Nullable INFO r101, @Nullable ControllerListener2.Extras r102) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(String r100) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(String r100, @Nullable INFO r101) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String r100, @Nullable ControllerListener2.Extras r101) {
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String r100, @Nullable Object r101, @Nullable ControllerListener2.Extras r102) {
    }

    static {
        NO_OP_LISTENER = new BaseControllerListener2();
    }

    public static <I> ControllerListener2<I> getNoOpListener() {
        return NO_OP_LISTENER;
    }
}
