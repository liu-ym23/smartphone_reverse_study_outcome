package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.CreationAlbumPipelinePrewarmer", f = "CreationAlbumPipelinePrewarmer.kt", i = {0, 0}, l = {159}, m = "takeClaimedTask", n = {LocationMonitorConst.IDENTIFIER, "entry"}, s = {"L$0", "L$1"})
public final class CreationAlbumPipelinePrewarmer$takeClaimedTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationAlbumPipelinePrewarmer this$0;

    public CreationAlbumPipelinePrewarmer$takeClaimedTask$1(CreationAlbumPipelinePrewarmer r100, Continuation<? super CreationAlbumPipelinePrewarmer$takeClaimedTask$1> r101) {
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
