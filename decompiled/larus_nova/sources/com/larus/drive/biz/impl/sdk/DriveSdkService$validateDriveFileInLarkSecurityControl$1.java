package com.larus.drive.biz.impl.sdk;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.sdk.DriveSdkService", f = "DriveSdkService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE}, m = "validateDriveFileInLarkSecurityControl", n = {}, s = {})
final class DriveSdkService$validateDriveFileInLarkSecurityControl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveSdkService this$0;

    public DriveSdkService$validateDriveFileInLarkSecurityControl$1(DriveSdkService r100, Continuation<? super DriveSdkService$validateDriveFileInLarkSecurityControl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.w(this);
    }
}
