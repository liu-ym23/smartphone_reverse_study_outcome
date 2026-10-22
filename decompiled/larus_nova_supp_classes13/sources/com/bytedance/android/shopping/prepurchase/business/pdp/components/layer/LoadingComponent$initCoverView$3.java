package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer;

import android.util.Pair;
import com.bytedance.android.shopping.anchorv4.perf.monitor.c;
import com.bytedance.android.shopping.anchorv4.perf.monitor.j;
import com.bytedance.android.shopping.anchorv4.perf.monitor.k;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/y;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.LoadingComponent$initCoverView$3", f = "LoadingComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LoadingComponent$initCoverView$3 extends SuspendLambda implements Function3<CoroutineScope, y, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hideCover;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LoadingComponent this$0;

    public LoadingComponent$initCoverView$3(LoadingComponent r1, boolean r2, Continuation r3) {
        this.this$0 = r1;
        this.$hideCover = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, y r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        LoadingComponent$initCoverView$3 r6 = new LoadingComponent$initCoverView$3(this.this$0, this.$hideCover, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (y) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r5);
        c r6 = ((y) this.L$0).V();
        if (r6 == null) goto L27;
        k r7 = r6.c;
        if (r7 == null) goto L27;
        Boolean r2 = null;
        if (this.$hideCover == true) goto L17;
        Pair<String, Boolean> r0 = this.this$0.m;
        if (r0 == null) goto L13;
        String r1 = (String) r0.first;
    L15:
        if (com.bytedance.android.shopping.extensions.k.c(r1) == false) goto L17;
        boolean r3 = true;
    L18:
        Pair<String, Boolean> r4 = this.this$0.m;
        if (r4 == null) goto L22;
        r2 = (Boolean) r4.second;
    L22:
        if (Intrinsics.areEqual(r2, Boxing.boxBoolean(true)) == false) goto L24;
        float r8 = 0.75f;
    L25:
        j r9 = r7.a;
        r9.a = r3;
        r9.b = r8;
        goto L27
    L24:
        r8 = 1.0f;
        goto L25
    L13:
        r1 = null;
    L17:
        r3 = false;
    L27:
        return Unit.INSTANCE;
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
