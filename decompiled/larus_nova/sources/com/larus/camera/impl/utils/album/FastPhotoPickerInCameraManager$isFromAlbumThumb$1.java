package com.larus.camera.impl.utils.album;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.album.FastPhotoPickerInCameraManager", f = "FastPhotoPickerInCameraManager.kt", i = {0}, l = {77}, m = "isFromAlbumThumb", n = {"conversationId"}, s = {"L$0"})
public final class FastPhotoPickerInCameraManager$isFromAlbumThumb$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FastPhotoPickerInCameraManager this$0;

    public FastPhotoPickerInCameraManager$isFromAlbumThumb$1(FastPhotoPickerInCameraManager r100, Continuation<? super FastPhotoPickerInCameraManager$isFromAlbumThumb$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
