package com.obric.assistant.component;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricUpdateComponent$checkForceUpdateRom$1", f = "ObricUpdateComponent.kt", i = {}, l = {588}, m = "invokeSuspend", n = {}, s = {})
final class ObricUpdateComponent$checkForceUpdateRom$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    int label;
    final /* synthetic */ ObricUpdateComponent this$0;

    public ObricUpdateComponent$checkForceUpdateRom$1(ObricUpdateComponent r100, FragmentActivity r101, Continuation<? super ObricUpdateComponent$checkForceUpdateRom$1> r102) {
        this.this$0 = r100;
        this.$activity = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricUpdateComponent$checkForceUpdateRom$1(this.this$0, this.$activity, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricUpdateComponent$checkForceUpdateRom$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.assistant.component.p4] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.component.q4] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L21
    L15:
        Boolean r103 = (Boolean) r100;     // Catch: Exception -> L21
    L18:
        if (Intrinsics.areEqual(r103, Boxing.boxBoolean(true)) == false) goto L24;
        final ObricUpdateComponent r104 = this.this$0;     // Catch: Exception -> L21
        final FragmentActivity r105 = this.$activity;     // Catch: Exception -> L21
        ObricUpdateComponent.p3(r104, new p4(r104, r105), new q4(r104, r105));     // Catch: Exception -> L21
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        IObricUpdateService r106 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L21
        if (r106 == null) goto L16;
        this.label = 1;     // Catch: Exception -> L21
        r100 = r106.g(this);     // Catch: Exception -> L21
        if (r100 != r101) goto L15;
        return r101;
    L16:
        r103 = null;
    L21:
        e = move-exception;
        FLogger.f375446a.i("ObricUpdateComponent", "checkForceUpdateRom " + e);
        goto L24
    }
}
