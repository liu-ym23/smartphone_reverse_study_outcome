package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.videosend.tools.VideoTools;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowMediaCompressHelper", f = "FlowMediaCompressHelper.kt", i = {0, 1}, l = {55, 57}, m = VideoTools.ERROR_TYPE_COMPRESS, n = {"entity", "entity"}, s = {"L$0", "L$0"})
public final class FlowMediaCompressHelper$compress$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowMediaCompressHelper this$0;

    public FlowMediaCompressHelper$compress$1(FlowMediaCompressHelper r100, Continuation<? super FlowMediaCompressHelper$compress$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
