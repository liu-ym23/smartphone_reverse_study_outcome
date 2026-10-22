package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.bitable.chameleon.BitableWikiUrlInitNode", f = "BitableWikiUrlInitNode.kt", i = {0, 0, 0}, l = {38}, m = "run", n = {"bearUrl", "loaderTypeBefore", KtvSubElement.CONTAINER}, s = {"L$0", "L$1", "L$2"})
public final class BitableWikiUrlInitNode$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitableWikiUrlInitNode this$0;

    public BitableWikiUrlInitNode$run$1(BitableWikiUrlInitNode r100, Continuation<? super BitableWikiUrlInitNode$run$1> r101) {
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
