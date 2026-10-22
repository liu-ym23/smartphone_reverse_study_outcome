package com.obric.assistant.provider;

import android.database.MatrixCursor;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/database/MatrixCursor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MatrixCursor>, Object> {
    int label;

    public ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2(Continuation<? super ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super MatrixCursor> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super MatrixCursor> r101) {
        return ((ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L13:
        List r103 = (List) r100;
    L15:
        MatrixCursor r104 = new MatrixCursor(new String[]{"package_name"});
        if (r103 == null) goto L21;
        Iterator r105 = r103.iterator();
    L19:
        if (r105.hasNext() == false) goto L21;
        r104.addRow(new String[]{((com.obric.assistant.settings.e) r105.next()).f392021a});
    L21:
        return r104;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IObricAutoGuiSettingsApi r106 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
        if (r106 == null) goto L14;
        this.label = 1;
        r100 = IObricAutoGuiSettingsApi.a.a(r106, true, this, 2);
        if (r100 != r101) goto L13;
        return r101;
    L14:
        r103 = null;
        goto L15
    }
}
