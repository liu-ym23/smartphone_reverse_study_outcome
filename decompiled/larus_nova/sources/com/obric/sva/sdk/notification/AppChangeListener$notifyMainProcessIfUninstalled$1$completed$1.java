package com.obric.sva.sdk.notification;

import android.content.Context;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.obric.sva.sdk.notification.AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1", f = "AppChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ String $pkg;
    private /* synthetic */ Object L$0;
    int label;

    public AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1(Context r100, String r101, Continuation<? super AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1> r102) {
        this.$appContext = r100;
        this.$pkg = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1 r102 = new AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1(this.$appContext, this.$pkg, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((AppChangeListener$notifyMainProcessIfUninstalled$1$completed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Context r102 = this.$appContext;
        String r103 = this.$pkg;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        rna.b.o(r102, r103);     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r106 = this.$pkg;
        Throwable r107 = Result.m9452exceptionOrNullimpl(r105);
        if (r107 == null) goto L13;
        LogUtils.i("SvaAppChangeListener", "notifyMainProcessIfUninstalled failed pkg=" + r106 + ": " + r107.getMessage(), new Object[0]);
    L13:
        return Boxing.boxBoolean(true);
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
