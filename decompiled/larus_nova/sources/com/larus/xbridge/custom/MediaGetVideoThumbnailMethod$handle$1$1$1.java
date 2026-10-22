package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$handle$1$1$1", f = "MediaGetVideoThumbnailMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaGetVideoThumbnailMethod$handle$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ Pair<String, String> $pair;
    int label;
    final /* synthetic */ s1 this$0;

    public MediaGetVideoThumbnailMethod$handle$1$1$1(s1 r100, IvyBridgeMethod.a r101, Pair<String, String> r102, Continuation<? super MediaGetVideoThumbnailMethod$handle$1$1$1> r103) {
        this.this$0 = r100;
        this.$callback = r101;
        this.$pair = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MediaGetVideoThumbnailMethod$handle$1$1$1(this.this$0, this.$callback, this.$pair, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MediaGetVideoThumbnailMethod$handle$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        s1 r101 = this.this$0;
        IvyBridgeMethod.a r102 = this.$callback;
        LinkedHashMap r103 = new LinkedHashMap();
        Pair<String, String> r104 = this.$pair;
        String r105 = r104.getFirst();
        if (r105 == null) goto L7;
        r103.put(TTVideoEngineInterface.PLAY_API_KEY_BASE64, r105);
    L7:
        String r106 = r104.getSecond();
        if (r106 == null) goto L10;
        r103.put("tmpPath", r106);
    L10:
        Unit r107 = Unit.INSTANCE;
        bx7.c.d(r101, r102, r103);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
