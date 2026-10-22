package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils", f = "FlowYunPanFileUtils.kt", i = {0, 0}, l = {121}, m = "downloadYunPanPictureWithFile", n = {"token", DyPayConstant.KEY_START_TIME}, s = {"L$0", "J$0"})
public final class FlowYunPanFileUtils$downloadYunPanPictureWithFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowYunPanFileUtils this$0;

    public FlowYunPanFileUtils$downloadYunPanPictureWithFile$1(FlowYunPanFileUtils r100, Continuation<? super FlowYunPanFileUtils$downloadYunPanPictureWithFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, false, this);
    }
}
