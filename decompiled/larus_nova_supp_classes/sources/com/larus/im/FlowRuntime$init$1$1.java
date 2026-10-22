package com.larus.im;

import android.util.EventsUtils;
import gd9.h;
import gd9.q;
import java.util.ArrayList;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", XmlPullParser.NO_NAMESPACE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
@DebugMetadata(c = "com.larus.im.FlowRuntime$init$1$1", f = "FlowRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowRuntime$init$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public FlowRuntime$init$1$1(Continuation<? super FlowRuntime$init$1$1> r2) {
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new FlowRuntime$init$1$1(r2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((FlowRuntime$init$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r3);
        q r4 = FlowRuntime.a;
        if (r4 == null) goto L9;
        h r5 = r4.e();
        if (r5 == null) goto L9;
        q r0 = FlowRuntime.a;
        r5.e("FlowRuntime", "init flow runtime , current pending action size = " + ((ArrayList) FlowRuntime.d).size());
    L9:
        Iterator<T> r6 = FlowRuntime.d.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        ((Runnable) r6.next()).run();
        goto L11
    L13:
        ((ArrayList) FlowRuntime.d).clear();
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
