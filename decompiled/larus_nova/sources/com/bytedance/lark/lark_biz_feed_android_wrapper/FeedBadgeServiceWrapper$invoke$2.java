package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.i;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class FeedBadgeServiceWrapper$invoke$2<T> extends FunctionReferenceImpl implements Function2<i, Continuation<? super T>, Object>, SuspendFunction {
    public FeedBadgeServiceWrapper$invoke$2(Object r100) {
        super(2, r100, Intrinsics.Kotlin.class, "suspendConversion0", "invoke_gIAlu_s$suspendConversion0(Lkotlin/jvm/functions/Function1;Lcom/bytedance/lark/lark_biz_feed_android/FeedBadgeService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(i r100, Continuation<? super T> r101) {
        return ((Function1) this.receiver).invoke(r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(i r100, Object r101) {
        return invoke(r100, (Continuation) r101);
    }
}
