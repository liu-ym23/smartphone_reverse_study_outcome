package com.larus.uaigc.helper;

import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bduploader.UploadKeys;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageRemoteDownloadHandler", f = "CreationImageNodeHandlers.kt", i = {1}, l = {UploadKeys.KeyIsSkipMeta, BDVideoUploaderBase.KeyIsSkipCode2ndFileSize}, m = "decodeRemoteImageToLocalPath", n = {"closeableRef"}, s = {"L$0"})
public final class CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageRemoteDownloadHandler this$0;

    public CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1(CreationImageRemoteDownloadHandler r100, Continuation<? super CreationImageRemoteDownloadHandler$decodeRemoteImageToLocalPath$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
