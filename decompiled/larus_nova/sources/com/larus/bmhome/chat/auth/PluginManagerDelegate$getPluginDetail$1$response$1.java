package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.auth.model.PluginItem;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$getPluginDetail$1$response$1", f = "PluginManagerDelegate.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class PluginManagerDelegate$getPluginDetail$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PluginItem>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $pluginId;
    int label;

    public PluginManagerDelegate$getPluginDetail$1$response$1(String r100, String r101, Continuation<? super PluginManagerDelegate$getPluginDetail$1$response$1> r102) {
        this.$botId = r100;
        this.$pluginId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PluginManagerDelegate$getPluginDetail$1$response$1(this.$botId, this.$pluginId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super PluginItem> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super PluginItem> r101) {
        return ((PluginManagerDelegate$getPluginDetail$1$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ConcurrentHashMap<String, PluginManager> r103 = PluginManager.f297302d;
        PluginAuthRepository r104 = PluginManager.f297304f;
        String r105 = this.$botId;
        String r106 = this.$pluginId;
        this.label = 1;
        r100 = r104.b(r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
