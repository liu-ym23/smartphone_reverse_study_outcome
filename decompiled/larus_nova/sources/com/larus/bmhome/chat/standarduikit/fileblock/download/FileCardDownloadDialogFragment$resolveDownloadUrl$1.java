package com.larus.bmhome.chat.standarduikit.fileblock.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.fileblock.download.FileCardDownloadDialogFragment", f = "FileCardDownloadDialogFragment.kt", i = {0}, l = {133, 139}, m = "resolveDownloadUrl", n = {"originalUrl"}, s = {"L$0"})
final class FileCardDownloadDialogFragment$resolveDownloadUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileCardDownloadDialogFragment this$0;

    public FileCardDownloadDialogFragment$resolveDownloadUrl$1(FileCardDownloadDialogFragment r100, Continuation<? super FileCardDownloadDialogFragment$resolveDownloadUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FileCardDownloadDialogFragment.V90(this.this$0, null, null, this);
    }
}
