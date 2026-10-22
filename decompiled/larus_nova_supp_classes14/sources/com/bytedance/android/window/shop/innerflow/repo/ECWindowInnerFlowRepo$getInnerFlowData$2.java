package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import up3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/window/shop/innerflow/repo/e;", "", "Lvp3/b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowRepo$getInnerFlowData$2", f = "ECWindowInnerFlowRepo.kt", i = {0, 1}, l = {97, 49}, m = "invokeSuspend", n = {"$this$withLock$iv", "$this$withLock$iv"}, s = {"L$0", "L$0"})
public final class ECWindowInnerFlowRepo$getInnerFlowData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e<List<? extends vp3.b>>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ECWindowInnerFlowRepo this$0;

    public ECWindowInnerFlowRepo$getInnerFlowData$2(ECWindowInnerFlowRepo r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ECWindowInnerFlowRepo$getInnerFlowData$2(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
    L31:
        ECShopInnerFlowDTO r11 = (ECShopInnerFlowDTO) r10;     // Catch: Throwable -> L9
        ECWindowInnerFlowRepo r3 = this.this$0;     // Catch: Throwable -> L9
        r3.b.b = false;     // Catch: Throwable -> L9
        if (r11 != null) goto L36;
        e.a r12 = new e.a();     // Catch: Throwable -> L9
        r2.unlock(null);
        return r12;
    L36:
        r3.c.setPageNum(r11.getCursor());     // Catch: Throwable -> L9
        this.this$0.b.update(r11.getHasMore());     // Catch: Throwable -> L9
        List<g> r5 = r11.getMixCards();     // Catch: Throwable -> L9
        if (r5 != null) goto L39;
    L42:
        if (r4 == false) goto L46;
        e.c r13 = new e.c();     // Catch: Throwable -> L9
        r2.unlock(null);
        return r13;
    L46:
        List<g> r14 = r11.getMixCards();     // Catch: Throwable -> L9
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L9
        Iterator<T> r15 = r14.iterator();     // Catch: Throwable -> L9
    L48:
        if (r15.hasNext() == false) goto L52;
        g r7 = (g) r15.next();     // Catch: Throwable -> L9
        vp3.b r8 = (vp3.b) this.this$0.a.a(r7);     // Catch: Throwable -> L9
        if (r8 == null) goto L48;
        r6.add(r8);     // Catch: Throwable -> L9
        goto L48
    L52:
        ECWindowInnerFlowRepo.a(this.this$0, r6);     // Catch: Throwable -> L9
        e.d r16 = new e.d(r6);     // Catch: Throwable -> L9
        r2.unlock(null);
        return r16;
    L39:
        if (r5.isEmpty() == true) goto L42;
        r4 = false;
    L9:
        th = move-exception;
        th = th;
        kotlinx.coroutines.sync.a r17 = r2;
    L57:
        r17.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
        r17 = r9;
    L60:
        ECWindowInnerFlowRepo r18 = this.this$0;     // Catch: Throwable -> L56
        com.bytedance.android.window.shop.repository.tab.datasource.impl.g r19 = r18.b;     // Catch: Throwable -> L56
        if (r19.b == false) goto L23;
        e.b r20 = new e.b();     // Catch: Throwable -> L56
        r17.unlock(null);
        return r20;
    L23:
        if (r19.a == true) goto L27;
        e.c r21 = new e.c();     // Catch: Throwable -> L56
        r17.unlock(null);
        return r21;
    L27:
        r19.b = true;     // Catch: Throwable -> L56
        ECWindowInnerFlowReqParam r22 = r18.c;     // Catch: Throwable -> L56
        this.L$0 = r17;     // Catch: Throwable -> L56
        this.label = 2;     // Catch: Throwable -> L56
        Object r23 = r18.c(r22, this);     // Catch: Throwable -> L56
        if (r23 != r0) goto L30;
        return r0;
    L30:
        r2 = r17;
        r10 = r23;
    L56:
        th = th;
        goto L57
    L14:
        ResultKt.throwOnFailure(r10);
        r17 = this.this$0.e;
        this.L$0 = r17;
        this.label = 1;
        if (r17.a(null, this) != r0) goto L60;
        return r0;
    }
}
