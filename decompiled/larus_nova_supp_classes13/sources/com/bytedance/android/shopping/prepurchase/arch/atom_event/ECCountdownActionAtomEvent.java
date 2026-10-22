package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECCountdownActionAtomEvent extends t96.a {
    public final CoroutineScope c;
    public Job d;

    public ECCountdownActionAtomEvent() {
        Intrinsics.checkNotNullParameter("countdown", "name");
        super("countdown");
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(JobKt.Job$default(null, 1, null)));
    }

    public final void onDestroy() {
        Job r0 = this.d;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        CoroutineScopeKt.cancel$default(this.c, null, 1, null);
    }

    public final void b(EventContext r18, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r19) {
        Intrinsics.checkNotNullParameter(r18, "eventContext");
        Intrinsics.checkNotNullParameter(r19, "completion");
        Map r0 = r18.k;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        Object r1 = r0.get("timestamp");     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        Long r2 = ECHybridExtensionsKt.j(r1);     // Catch: Throwable -> L11
    L9:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r3) == false) goto L16;
        r3 = null;
    L16:
        Long r5 = (Long) r3;
        double r6 = System.currentTimeMillis() / 1000.0d;
        if (r5 == null) goto L37;
        long r8 = 0;
        if (r5.longValue() < 0) goto L37;
        if (r6 < r5.longValue()) goto L28;
        Job r7 = this.d;
        if (r7 == null) goto L26;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L26:
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r19.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L28:
        long r10 = (long) ((r5.longValue() - r6) * ((double) 1000));
        if (r10 < 0) goto L32;
        r8 = r10;
    L32:
        Job r11 = this.d;
        if (r11 == null) goto L35;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);
    L35:
        this.d = BuildersKt.launch$default(this.c, null, null, new ECCountdownActionAtomEvent$handle$1(r8, r19, null), 3, null);
        return;
    L37:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r19.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "timestamp is null or <= 0", null, null, 57));
        return;
    L8:
        r2 = null;
    L11:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
