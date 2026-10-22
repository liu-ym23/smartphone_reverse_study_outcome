package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.SharedAlbumUploadCoordinator", f = "SharedAlbumUploadCoordinator.kt", i = {0}, l = {166}, m = LocationMonitorConst.SUBMIT, n = {LocationMonitorConst.IDENTIFIER}, s = {"L$0"})
public final class SharedAlbumUploadCoordinator$submit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedAlbumUploadCoordinator this$0;

    public SharedAlbumUploadCoordinator$submit$1(SharedAlbumUploadCoordinator r100, Continuation<? super SharedAlbumUploadCoordinator$submit$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, null, null, this);
    }
}
