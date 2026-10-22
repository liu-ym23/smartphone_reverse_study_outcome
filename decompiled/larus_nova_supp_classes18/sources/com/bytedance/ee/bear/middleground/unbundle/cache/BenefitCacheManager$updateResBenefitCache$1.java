package com.bytedance.ee.bear.middleground.unbundle.cache;

import aj5.a;
import aj5.e;
import aj5.f;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.unbundle.cache.BenefitCacheManager$updateResBenefitCache$1", f = "BenefitCacheManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BenefitCacheManager$updateResBenefitCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BenefitStore $benefitStore;
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ Ref.ObjectRef<Job> $job;
    int label;
    final /* synthetic */ BenefitCacheManager this$0;

    public BenefitCacheManager$updateResBenefitCache$1(BenefitCacheManager r1, String r2, BenefitStore r3, Ref.ObjectRef<Job> r4, Continuation<? super BenefitCacheManager$updateResBenefitCache$1> r5) {
        this.this$0 = r1;
        this.$cacheKey = r2;
        this.$benefitStore = r3;
        this.$job = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BenefitCacheManager$updateResBenefitCache$1(this.this$0, this.$cacheKey, this.$benefitStore, this.$job, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r6);
        f r7 = this.this$0.e;
        a r0 = new a();
        String r1 = this.$cacheKey;
        BenefitStore r2 = this.$benefitStore;
        BenefitCacheManager r3 = this.this$0;
        Ref.ObjectRef<Job> r4 = this.$job;
        r0.a = r1;
        r0.b = r2.getOwnerId();
        r0.c = r2.getSourceBenefit();
        r0.d = Boxing.boxLong(System.currentTimeMillis());
        List<Job> r5 = r3.f;
        ArrayList r8 = (ArrayList) r5;
        r8.remove(r4.element);
        r7.getClass();
        e r9 = (e) r7.a();     // Catch: Exception -> L11
        r9.a.assertNotSuspendingTransaction();     // Catch: Exception -> L11
        r9.a.beginTransaction();     // Catch: Exception -> L11
        r9.b.insert(r0);     // Catch: Throwable -> L8
        r9.a.setTransactionSuccessful();     // Catch: Throwable -> L8
        r9.a.endTransaction();     // Catch: Exception -> L11
        tt5.a.h("Benefit_DataManager", "insertBenefitData...");     // Catch: Exception -> L11
    L14:
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        r9.a.endTransaction();     // Catch: Exception -> L11
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.e("Benefit_DataManager", "insertBenefitData...", e, false);
        goto L14
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
