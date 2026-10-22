package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.ECPreloadGeckoChannelUtil$startPreload$1", f = "ECPreloadGeckoChannelUtil.kt", i = {1}, l = {h1.TYPE_LINK_ROOM_FIGHT_INVITE, 49}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
public final class ECPreloadGeckoChannelUtil$startPreload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $channels;
    int I$0;
    int I$1;
    int label;

    public ECPreloadGeckoChannelUtil$startPreload$1(List r1, Continuation r2) {
        this.$channels = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ECPreloadGeckoChannelUtil$startPreload$1(this.$channels, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004e -> B:20:0x0051). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$1;
        int r6 = this.I$0;
        ResultKt.throwOnFailure(r10);
        ECPreloadGeckoChannelUtil$startPreload$1 r11 = this;
    L20:
        boolean r7 = ECPreloadGeckoChannelUtil.a;
        if (ECPreloadGeckoChannelUtil.b(r11.$channels, ECPreloadGeckoChannelUtil.b) == true) goto L24;
        r6 = r6 + 1;
    L16:
        if (r6 > r2) goto L24;
        r11.I$0 = r6;
        r11.I$1 = r2;
        r11.label = 2;
        if (DelayKt.delay(60000, r11) != r0) goto L20;
        return r0;
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        boolean r12 = ECPreloadGeckoChannelUtil.a;
        if (ECPreloadGeckoChannelUtil.b(this.$channels, ECPreloadGeckoChannelUtil.b) == true) goto L24;
        r11 = this;
        r2 = 5;
        r6 = 1;
        goto L16
    L10:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(60000, this) != r0) goto L13;
        return r0;
    }
}
