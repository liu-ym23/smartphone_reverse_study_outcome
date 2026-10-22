package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import com.bytedance.android.ec.hybrid.a;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ItemAnimationController$checkControl$2", f = "ItemAnimationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ItemAnimationController$checkControl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ ItemAnimationController this$0;

    public ItemAnimationController$checkControl$2(ItemAnimationController r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ItemAnimationController$checkControl$2(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r11);
        ChannelVO.Animation r0 = this.this$0.e;     // Catch: Exception -> L33
        if (r0 == null) goto L32;
        Long r1 = r0.getDayRange();     // Catch: Exception -> L33
        if (r1 == null) goto L32;
        long r2 = TimeUnit.DAYS.toMillis(r1.longValue());     // Catch: Exception -> L33
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L33
        ChannelVO r4 = this.this$0.d;     // Catch: Exception -> L33
        if (r4 == null) goto L12;
        r4.getComponentId();     // Catch: Exception -> L33
    L12:
        a.e();     // Catch: Exception -> L33
        if ("".length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L36;
        Gson r6 = p.a;     // Catch: Exception -> L33
        ItemAnimationController.ChannelSwiperStorageStruct r7 = (ItemAnimationController.ChannelSwiperStorageStruct) p.a("", ItemAnimationController.ChannelSwiperStorageStruct.class);     // Catch: Exception -> L33
        Ref.IntRef r8 = new Ref.IntRef();     // Catch: Exception -> L33
        r8.element = 0;     // Catch: Exception -> L33
        if (r7 == null) goto L28;
        List<Long> r9 = r7.getClickTimes();     // Catch: Exception -> L33
        if (r9 == null) goto L28;
        Iterator<T> r10 = r9.iterator();     // Catch: Exception -> L33
    L23:
        if (r10.hasNext() == false) goto L28;
        if (r2 <= (r3 - ((Number) r10.next()).longValue())) goto L23;
        r8.element++;     // Catch: Exception -> L33
    L28:
        if (r8.element < 3) goto L36;
        return Boxing.boxBoolean(false);
    L36:
        return Boxing.boxBoolean(true);
    L15:
        r5 = false;
    L32:
        return Boxing.boxBoolean(true);
    L33:
        e = move-exception;
        b0.l(e.getMessage(), e);
        goto L36
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
