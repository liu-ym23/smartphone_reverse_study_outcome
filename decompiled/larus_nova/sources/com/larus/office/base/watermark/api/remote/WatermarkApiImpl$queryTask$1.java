package com.larus.office.base.watermark.api.remote;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.api.remote.WatermarkApiImpl", f = "WatermarkApiImpl.kt", i = {0}, l = {77}, m = "queryTask", n = {DBDefinition.TASK_ID}, s = {"L$0"})
public final class WatermarkApiImpl$queryTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatermarkApiImpl this$0;

    public WatermarkApiImpl$queryTask$1(WatermarkApiImpl r100, Continuation<? super WatermarkApiImpl$queryTask$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
