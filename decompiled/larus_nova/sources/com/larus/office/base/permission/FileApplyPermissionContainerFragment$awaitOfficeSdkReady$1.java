package com.larus.office.base.permission;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.permission.FileApplyPermissionContainerFragment", f = "FileApplyPermissionContainerFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE}, m = "awaitOfficeSdkReady", n = {}, s = {})
final class FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileApplyPermissionContainerFragment this$0;

    public FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1(FileApplyPermissionContainerFragment r100, Continuation<? super FileApplyPermissionContainerFragment$awaitOfficeSdkReady$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FileApplyPermissionContainerFragment.S90(this.this$0, this);
    }
}
