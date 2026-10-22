package com.ss.android.lark.flow.chat.message.image;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils", f = "FlowYunPanFileUtils.kt", i = {0, 0}, l = {290}, m = "driveDownloadImageInner", n = {"token", "localPath"}, s = {"L$0", "L$1"})
final class FlowYunPanFileUtils$driveDownloadImageInner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowYunPanFileUtils this$0;

    public FlowYunPanFileUtils$driveDownloadImageInner$1(FlowYunPanFileUtils r100, Continuation<? super FlowYunPanFileUtils$driveDownloadImageInner$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FlowYunPanFileUtils.a(this.this$0, null, null, this);
    }
}
