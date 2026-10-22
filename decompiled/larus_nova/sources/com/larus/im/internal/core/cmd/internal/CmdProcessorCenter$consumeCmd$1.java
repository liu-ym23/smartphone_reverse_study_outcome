package com.larus.im.internal.core.cmd.internal;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.cmd.internal.CmdProcessorCenter", f = "CmdProcessorCenter.kt", i = {0}, l = {87}, m = "consumeCmd", n = {MapBundleKey.MapObjKey.OBJ_SL_OBJ}, s = {"L$0"})
public final class CmdProcessorCenter$consumeCmd$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CmdProcessorCenter this$0;

    public CmdProcessorCenter$consumeCmd$1(CmdProcessorCenter r100, Continuation<? super CmdProcessorCenter$consumeCmd$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CmdProcessorCenter r101 = this.this$0;
        CmdProcessorCenter r102 = CmdProcessorCenter.f347522a;
        return r101.b(null, null, null, this);
    }
}
