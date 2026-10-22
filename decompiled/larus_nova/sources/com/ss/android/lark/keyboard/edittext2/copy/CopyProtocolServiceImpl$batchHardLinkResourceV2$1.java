package com.ss.android.lark.keyboard.edittext2.copy;

import com.bytedance.lark.pb.im.v1.BatchHardLinkResourcesV2Request;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.copy.CopyProtocolServiceImpl", f = "CopyProtocolServiceImpl.kt", i = {}, l = {79}, m = "batchHardLinkResourceV2-0E7RQCE", n = {}, s = {})
final class CopyProtocolServiceImpl$batchHardLinkResourceV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CopyProtocolServiceImpl this$0;

    public CopyProtocolServiceImpl$batchHardLinkResourceV2$1(CopyProtocolServiceImpl r100, Continuation<? super CopyProtocolServiceImpl$batchHardLinkResourceV2$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        final CopyProtocolServiceImpl r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        CopyProtocolServiceImpl$batchHardLinkResourceV2$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        final RichText r106 = null;
        new CopyProtocolServiceImpl$batchHardLinkResourceV2$entityMapper$1(r106, r101);
        new BatchHardLinkResourcesV2Request.Builder();
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    L9:
        if (r105 != 1) goto L23;
        ResultKt.throwOnFailure(r104);
        b r107 = (b) r104;
        r107.getClass();
        if ((true ^ (r107 instanceof b.C3939b)) == false) goto L13;
        Result.Companion r108 = Result.Companion;
        Object r109 = Result.m9449constructorimpl(r107.b());
    L18:
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r109;
    L21:
        return Result.m9448boximpl(r109);
    L13:
        Result.Companion r110 = Result.Companion;
        ErrorResult r111 = r107.a();
        if (r111 != null) goto L16;
        r111 = new ErrorResult("");
    L16:
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(r111));
        goto L18
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new CopyProtocolServiceImpl$batchHardLinkResourceV2$1(r101, this);
        goto L6
    }
}
