package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.i;
import com.bytedance.lark.view_flow_wrapper.MoltenService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedBadgeServiceWrapper extends MoltenService<i> implements b {
    public FeedBadgeServiceWrapper(Function1<? super Continuation<? super i>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceProvider");
        super(r100);
    }

    @Override // com.bytedance.lark.lark_biz_feed_android_wrapper.b
    public final <T> Object lc(Function1<? super i, ? extends T> r100, Continuation<? super Result<? extends T>> r101) {
        if ((r101 instanceof FeedBadgeServiceWrapper$invoke$1) == false) goto L7;
        FeedBadgeServiceWrapper$invoke$1 r102 = (FeedBadgeServiceWrapper$invoke$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FeedBadgeServiceWrapper$invoke$2 r107 = new FeedBadgeServiceWrapper$invoke$2(r100);
        r102.label = 1;
        Object r108 = c(r107, r102);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new FeedBadgeServiceWrapper$invoke$1(this, r101);
        goto L8
    }
}
