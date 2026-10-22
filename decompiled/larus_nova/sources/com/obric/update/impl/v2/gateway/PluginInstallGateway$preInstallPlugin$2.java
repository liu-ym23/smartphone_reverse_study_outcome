package com.obric.update.impl.v2.gateway;

import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.gateway.PluginInstallGateway$preInstallPlugin$2", f = "PluginInstallGateway.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class PluginInstallGateway$preInstallPlugin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $apkFile;
    int label;

    public PluginInstallGateway$preInstallPlugin$2(File r100, Continuation<? super PluginInstallGateway$preInstallPlugin$2> r101) {
        this.$apkFile = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PluginInstallGateway$preInstallPlugin$2(this.$apkFile, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PluginInstallGateway$preInstallPlugin$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IZeusPluginService r103 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);
        if (r103 == null) goto L14;
        String r104 = this.$apkFile.getAbsolutePath();
        this.label = 1;
        if (r103.g(r104, 300000, this) != r101) goto L16;
        return r101;
    L14:
        return null;
    }
}
