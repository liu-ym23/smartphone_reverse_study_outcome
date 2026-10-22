package com.larus.avlink.gallery.coordinator;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$disconnectWifi$1", f = "MediaSyncCoordinator.kt", i = {}, l = {530, 531}, m = "invokeSuspend", n = {}, s = {})
public final class MediaSyncCoordinator$disconnectWifi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaSyncCoordinator$disconnectWifi$1(Continuation<? super MediaSyncCoordinator$disconnectWifi$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MediaSyncCoordinator$disconnectWifi$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MediaSyncCoordinator$disconnectWifi$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L17:
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r103 == null) goto L25;
        IDoraService.j r104 = r103.S();
        if (r104 == null) goto L25;
        this.label = 2;
        if (r104.disconnect(FlowDoraWifiScene.ALBUM_SILENT) != r101) goto L25;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        IDoraService r105 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r105 == null) goto L17;
        IDoraService.j r106 = r105.S();
        if (r106 == null) goto L17;
        this.label = 1;
        if (r106.disconnect(FlowDoraWifiScene.ALBUM) != r101) goto L17;
        return r101;
    }
}
