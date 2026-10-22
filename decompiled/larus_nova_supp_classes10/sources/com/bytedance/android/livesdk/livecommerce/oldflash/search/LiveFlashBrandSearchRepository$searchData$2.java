package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import xi2.k0;
import xi2.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.oldflash.search.LiveFlashBrandSearchRepository$searchData$2", f = "LiveFlashBrandSearchRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LiveFlashBrandSearchRepository$searchData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Pair<? extends String, ? extends String>>>, Object> {
    final /* synthetic */ String $prefix;
    int label;
    final /* synthetic */ LiveFlashBrandSearchRepository this$0;

    public LiveFlashBrandSearchRepository$searchData$2(LiveFlashBrandSearchRepository r1, String r2, Continuation r3) {
        this.this$0 = r1;
        this.$prefix = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new LiveFlashBrandSearchRepository$searchData$2(this.this$0, this.$prefix, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L52;
        ResultKt.throwOnFailure(r8);
        LiveFlashBrandSearchRepository r1 = this.this$0;     // Catch: Exception -> L48
        u r2 = vi2.h.n(r1.c, r1.d, this.$prefix);     // Catch: Exception -> L48
        if (r2 != null) goto L8;
    L38:
        dm.a.b r3 = dm.a.a("LiveFlashBrandSearchRepository");     // Catch: Exception -> L48
        StringBuilder r4 = new StringBuilder("error code:");     // Catch: Exception -> L48
        if (r2 == null) goto L41;
        Integer r0 = Boxing.boxInt(((com.bytedance.android.ec.model.g) r2).statusCode);     // Catch: Exception -> L48
    L42:
        r4.append(r0);     // Catch: Exception -> L48
        r4.append(",error message:");     // Catch: Exception -> L48
        if (r2 == null) goto L45;
        String r5 = ((com.bytedance.android.ec.model.g) r2).statusMessage;     // Catch: Exception -> L48
    L46:
        r4.append(r5);     // Catch: Exception -> L48
        r3.b(r4.toString(), null);     // Catch: Exception -> L48
        return null;
    L45:
        r5 = null;
        goto L46
    L41:
        r0 = null;
        goto L42
    L8:
        if (((com.bytedance.android.ec.model.g) r2).statusCode != 0) goto L38;
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L48
        LiveFlashBrandSearchRepository r7 = this.this$0;     // Catch: Exception -> L48
        k0 r9 = r2.a();     // Catch: Exception -> L48
        if (r9 == null) goto L15;
        String r10 = r9.a();     // Catch: Exception -> L48
        if (r10 == null) goto L15;
    L16:
        r7.getClass();     // Catch: Exception -> L48
        int r11 = m0.a;     // Catch: Exception -> L19
        xi2.b r12 = (xi2.b) m0.a.a.fromJson(r10, xi2.b.class);     // Catch: Exception -> L19
    L21:
        if (r12 == null) goto L24;
        List<String> r13 = r12.a();     // Catch: Exception -> L48
        if (r13 == null) goto L24;
    L25:
        k0 r14 = r2.a();     // Catch: Exception -> L48
        if (r14 == null) goto L37;
        List<String> r15 = r14.b();     // Catch: Exception -> L48
        if (r15 == null) goto L37;
        IntIterator r16 = CollectionsKt.getIndices(r15).iterator();     // Catch: Exception -> L48
    L31:
        if (r16.hasNext() == false) goto L37;
        int r17 = r16.nextInt();     // Catch: Exception -> L48
        if (r13.size() <= r17) goto L35;
        String r18 = (String) ListProtector.get(r13, r17);     // Catch: Exception -> L48
    L36:
        r6.add(TuplesKt.to(ListProtector.get(r15, r17), r18));     // Catch: Exception -> L48
        goto L31
    L35:
        r18 = "";
    L37:
        return r6;
    L24:
        r13 = CollectionsKt.emptyList();     // Catch: Exception -> L48
        goto L25
    L19:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L48
        r12 = null;
    L15:
        r10 = "";
    L48:
        e = move-exception;
        ECExceptionMonitor.c(String.valueOf(e.getMessage()));
        return null;
    L52:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
