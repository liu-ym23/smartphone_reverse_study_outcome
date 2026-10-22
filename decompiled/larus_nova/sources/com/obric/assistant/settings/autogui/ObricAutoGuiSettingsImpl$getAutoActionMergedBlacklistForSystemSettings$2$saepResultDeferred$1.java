package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.obric.assistant.AutoGuiAppScopeConfig;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/autogui/ObricSaepRestrictedPackageReader$Result;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_SEEK_CLK}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ObricSaepRestrictedPackageReader.a>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ AutoGuiAppScopeConfig $appScopeConfig;
    int label;

    public ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1(AutoGuiAppScopeConfig r100, Context r101, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1> r102) {
        this.$appScopeConfig = r100;
        this.$appContext = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1(this.$appScopeConfig, this.$appContext, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ObricSaepRestrictedPackageReader.a> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ObricSaepRestrictedPackageReader.a> r101) {
        return ((ObricAutoGuiSettingsImpl$getAutoActionMergedBlacklistForSystemSettings$2$saepResultDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return (ObricSaepRestrictedPackageReader.a) r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        if (this.$appScopeConfig.getEnableSaepRestrictedPackages() == false) goto L15;
        ObricSaepRestrictedPackageReader r103 = ObricSaepRestrictedPackageReader.f391872a;
        Context r104 = this.$appContext;
        Intrinsics.checkNotNull(r104);
        this.label = 1;
        r100 = r103.query(r104, this);
        if (r100 != r101) goto L16;
        return r101;
    L15:
        return new ObricSaepRestrictedPackageReader.a(SetsKt.emptySet(), SetsKt.emptySet(), true, ObricSaepRestrictedPackageReader.Source.DISABLED_OR_UNSUPPORTED);
    }
}
