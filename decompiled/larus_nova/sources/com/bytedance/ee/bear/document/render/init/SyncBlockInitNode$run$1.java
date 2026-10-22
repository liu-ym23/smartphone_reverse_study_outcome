package com.bytedance.ee.bear.document.render.init;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.render.init.SyncBlockInitNode", f = "SyncBlockInitNode.kt", i = {0, 0, 0, 0, 0, 0}, l = {101, 106}, m = "run", n = {"bearUrl", KtvSubElement.CONTAINER, "arguments", "retryArguments", "syncUrl", "routeService"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class SyncBlockInitNode$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SyncBlockInitNode this$0;

    public SyncBlockInitNode$run$1(SyncBlockInitNode r100, Continuation<? super SyncBlockInitNode$run$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
