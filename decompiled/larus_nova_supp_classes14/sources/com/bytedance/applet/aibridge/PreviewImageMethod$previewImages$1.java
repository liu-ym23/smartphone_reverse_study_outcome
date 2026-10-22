package com.bytedance.applet.aibridge;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.PreviewImageMethod$previewImages$1", f = "PreviewImageMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PreviewImageMethod$previewImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $footInfos;
    final /* synthetic */ List<String> $imageUrls;
    final /* synthetic */ int $index;
    final /* synthetic */ List<String> $templateURLs;
    final /* synthetic */ List<String> $trackerInfo;
    int label;

    public PreviewImageMethod$previewImages$1(List<String> r1, int r2, List<String> r3, List<String> r4, List<String> r5, Continuation<? super PreviewImageMethod$previewImages$1> r6) {
        this.$imageUrls = r1;
        this.$index = r2;
        this.$templateURLs = r3;
        this.$footInfos = r4;
        this.$trackerInfo = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new PreviewImageMethod$previewImages$1(this.$imageUrls, this.$index, this.$templateURLs, this.$footInfos, this.$trackerInfo, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        Activity r0 = AppHost.a.a().getCurrentActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.Context");
        com.larus.bmhome.bigimg.k.b(r0, this.$imageUrls, this.$index, new uo8.k(MapsKt.mapOf(new Pair[]{TuplesKt.to("user_type", "jsb"), TuplesKt.to("enter_picture_method", "jsb"), TuplesKt.to("enter_from", "chat")}), null), true, this.$templateURLs, this.$footInfos, this.$trackerInfo, 2144);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
