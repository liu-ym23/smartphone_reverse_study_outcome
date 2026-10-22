package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItem;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$requestNextPagePluginItem$1$response$1", f = "PluginManagerDelegate.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class PluginManagerDelegate$requestNextPagePluginItem$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PluginItem>>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ DowngradeSource $downgradeSource;
    final /* synthetic */ boolean $updateFirstPage;
    int label;

    public PluginManagerDelegate$requestNextPagePluginItem$1$response$1(String r100, boolean r101, DowngradeSource r102, Continuation<? super PluginManagerDelegate$requestNextPagePluginItem$1$response$1> r103) {
        this.$botId = r100;
        this.$updateFirstPage = r101;
        this.$downgradeSource = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PluginManagerDelegate$requestNextPagePluginItem$1$response$1(this.$botId, this.$updateFirstPage, this.$downgradeSource, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends PluginItem>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<PluginItem>> r101) {
        return ((PluginManagerDelegate$requestNextPagePluginItem$1$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        PluginItemPagingCache r104 = PluginManager.a.a(this.$botId).f297305a;
        boolean r105 = this.$updateFirstPage;
        DowngradeSource r106 = this.$downgradeSource;
        this.label = 1;
        r100 = r104.a(r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
