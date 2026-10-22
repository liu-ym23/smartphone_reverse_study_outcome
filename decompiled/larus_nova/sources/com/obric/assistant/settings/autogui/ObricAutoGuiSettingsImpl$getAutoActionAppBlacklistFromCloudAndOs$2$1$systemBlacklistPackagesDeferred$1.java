package com.obric.assistant.settings.autogui;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$systemBlacklistPackagesDeferred$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$systemBlacklistPackagesDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HashSet<String>>, Object> {
    int label;

    public ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$systemBlacklistPackagesDeferred$1(Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$systemBlacklistPackagesDeferred$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$systemBlacklistPackagesDeferred$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super HashSet<String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super HashSet<String>> r101) {
        return ((ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$2$1$systemBlacklistPackagesDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return CollectionsKt.toHashSet(o0.b().f391942a);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
