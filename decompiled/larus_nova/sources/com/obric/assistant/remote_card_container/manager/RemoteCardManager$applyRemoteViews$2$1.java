package com.obric.assistant.remote_card_container.manager;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.remote_card_container.manager.RemoteCardManager$applyRemoteViews$2$1", f = "RemoteCardManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RemoteCardManager$applyRemoteViews$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ i<Pair<? extends View, Boolean>> $continuation;
    final /* synthetic */ ViewGroup $parent;
    final /* synthetic */ RemoteViews $remoteViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteCardManager$applyRemoteViews$2$1(RemoteViews r100, Context r101, ViewGroup r102, String r103, i<? super Pair<? extends View, Boolean>> r104, Continuation<? super RemoteCardManager$applyRemoteViews$2$1> r105) {
        this.$remoteViews = r100;
        this.$context = r101;
        this.$parent = r102;
        this.$cardUri = r103;
        this.$continuation = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        RemoteCardManager$applyRemoteViews$2$1 r101 = new RemoteCardManager$applyRemoteViews$2$1(this.$remoteViews, this.$context, this.$parent, this.$cardUri, this.$continuation, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteCardManager$applyRemoteViews$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        long r100 = SystemClock.elapsedRealtime();
        RemoteViews r112 = this.$remoteViews;
        Context r101 = this.$context;
        ViewGroup r102 = this.$parent;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        if (r112 == null) goto L8;
        View r113 = r112.apply(r101.getApplicationContext(), r102);     // Catch: Throwable -> L11
    L9:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L11
    L13:
        String r104 = this.$cardUri;
        i<Pair<? extends View, Boolean>> r105 = this.$continuation;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r114);
        if (r106 == null) goto L18;
        p9a.e r107 = p9a.b.f528329a;
        p9a.b.c("RemoteCardManager", "applyRemoteViews failed for " + r104 + ". errMsg: " + r106.getMessage(), r106);
        if (r105.isActive() == false) goto L18;
        r105.resumeWith(Result.m9449constructorimpl(TuplesKt.to(null, Boxing.boxBoolean(false))));
    L18:
        String r108 = this.$cardUri;
        i<Pair<? extends View, Boolean>> r109 = this.$continuation;
        if (Result.m9456isSuccessimpl(r114) == false) goto L24;
        View r115 = (View) r114;
        p9a.e r116 = p9a.b.f528329a;
        p9a.b.a("RemoteCardManager", "apply used " + (SystemClock.elapsedRealtime() - r100) + " ms for " + r108);
        if (r109.isActive() == false) goto L24;
        r109.resumeWith(Result.m9449constructorimpl(TuplesKt.to(r115, Boxing.boxBoolean(true))));
    L24:
        return Unit.INSTANCE;
    L8:
        r113 = null;
    L11:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
