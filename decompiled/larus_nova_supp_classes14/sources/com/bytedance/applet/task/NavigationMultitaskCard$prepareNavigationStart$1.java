package com.bytedance.applet.task;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.NavigationMultitaskCard$prepareNavigationStart$1", f = "NavigationMultitaskCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NavigationMultitaskCard$prepareNavigationStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavigationCardSessionState.a $owner;
    int label;

    public NavigationMultitaskCard$prepareNavigationStart$1(NavigationCardSessionState.a r1, Continuation<? super NavigationMultitaskCard$prepareNavigationStart$1> r2) {
        this.$owner = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new NavigationMultitaskCard$prepareNavigationStart$1(this.$owner, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r2);
        if (NavigationMultitaskCard.e.a(this.$owner) == false) goto L16;
        String r3 = NavigationMultitaskCard.d;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        NavigationMultitaskCard.a(NavigationMultitaskCard.a);
        goto L16
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
