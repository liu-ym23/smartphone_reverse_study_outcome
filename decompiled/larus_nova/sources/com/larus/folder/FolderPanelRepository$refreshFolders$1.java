package com.larus.folder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.folder.FolderPanelRepository", f = "FolderPanelRepository.kt", i = {}, l = {76}, m = "refreshFolders", n = {}, s = {})
public final class FolderPanelRepository$refreshFolders$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FolderPanelRepository this$0;

    public FolderPanelRepository$refreshFolders$1(FolderPanelRepository r100, Continuation<? super FolderPanelRepository$refreshFolders$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
