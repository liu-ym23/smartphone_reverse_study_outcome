package com.obric.assistant.provider;

import android.database.MatrixCursor;
import android.os.Bundle;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.settings.h1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/MatrixCursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MatrixCursor>, Object> {
    int label;

    public ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2(Continuation<? super ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super MatrixCursor> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super MatrixCursor> r101) {
        return ((ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L13:
        h1 r103 = (h1) r100;
        if (r103 == null) goto L24;
        MatrixCursor r104 = new MatrixCursor(new String[]{"package_name"});
        Iterator<T> r105 = r103.f392079a.iterator();
    L17:
        if (r105.hasNext() == false) goto L19;
        r104.addRow(new String[]{((com.obric.assistant.settings.e) r105.next()).f392021a});
        goto L17
    L19:
        Bundle r106 = new Bundle();
        r106.putBoolean("is_complete", r103.f392080b);
        r104.setExtras(r106);
        return r104;
    L24:
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IObricAutoGuiSettingsApi r107 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
        if (r107 == null) goto L21;
        this.label = 1;
        r100 = r107.f(this);
        if (r100 != r101) goto L13;
        return r101;
    L21:
        return null;
    }
}
