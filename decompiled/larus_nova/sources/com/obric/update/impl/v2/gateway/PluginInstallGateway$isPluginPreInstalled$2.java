package com.obric.update.impl.v2.gateway;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.gateway.PluginInstallGateway$isPluginPreInstalled$2", f = "PluginInstallGateway.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PluginInstallGateway$isPluginPreInstalled$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ File $apkFile;
    int label;
    final /* synthetic */ PluginInstallGateway this$0;

    public PluginInstallGateway$isPluginPreInstalled$2(PluginInstallGateway r100, File r101, Continuation<? super PluginInstallGateway$isPluginPreInstalled$2> r102) {
        this.this$0 = r100;
        this.$apkFile = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PluginInstallGateway$isPluginPreInstalled$2(this.this$0, this.$apkFile, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((PluginInstallGateway$isPluginPreInstalled$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r100);
        boolean r101 = false;
        long r102 = PluginInstallGateway.a(this.this$0, AppHost.f326268a.getApplication(), this.$apkFile.getPath());     // Catch: Exception -> L17
        IZeusPluginService r103 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);     // Catch: Exception -> L17
        boolean r104 = true;
        if (r103 != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        FLogger r106 = FLogger.f375446a;     // Catch: Exception -> L17
        StringBuilder r107 = new StringBuilder("isPluginPreInstalled versionCode:");     // Catch: Exception -> L17
        r107.append(r102);     // Catch: Exception -> L17
        r107.append(",isPluginPreInstalled:");     // Catch: Exception -> L17
        if (r105 == true) goto L15;
        r104 = false;
    L15:
        r107.append(r104);     // Catch: Exception -> L17
        r106.i("PluginInstallGateway", r107.toString());     // Catch: Exception -> L17
        r101 = r105;
    L20:
        return Boxing.boxBoolean(r101);
    L8:
        if (r103.c(String.valueOf(r102)) != true) goto L10;
        r105 = true;
    L17:
        e = move-exception;
        FLogger.f375446a.e("PluginInstallGateway", "isPluginPreInstalled fail:" + e.getMessage());
        goto L20
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
