package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends t96.a {
    public Runnable c;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.arch.atom_event.a$a, reason: collision with other inner class name */
    public static final class RunnableC0153a implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1 b;

        public RunnableC0153a(a r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1 r0 = this.b;     // Catch: Throwable -> L4
            int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Throwable -> L4
            r0.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));     // Catch: Throwable -> L4
            this.a.c = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a() {
        Intrinsics.checkNotNullParameter("delay", "name");
        super("delay");
    }

    public final void onDestroy() {
        Runnable r0 = this.c;
        if (r0 == null) goto L5;
        Lazy r1 = UIUtils.a;
        UIUtils.c().removeCallbacks(r0);
    L5:
        this.c = null;
    }

    public final void b(EventContext r7, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r8, "completion");
        Map r9 = r7.k;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r9 == null) goto L8;
        Object r10 = r9.get("duration");     // Catch: Throwable -> L11
        if (r10 == null) goto L8;
        Long r11 = ECHybridExtensionsKt.j(r10);     // Catch: Throwable -> L11
    L9:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r12) == true) goto L17;
        r0 = r12;
    L17:
        Long r2 = (Long) r0;
        if (r2 == null) goto L20;
        long r3 = r2.longValue();
    L21:
        Runnable r13 = this.c;
        if (r13 == null) goto L25;
        Lazy r4 = UIUtils.a;
        UIUtils.c().removeCallbacks(r13);
    L25:
        if (r3 >= 0) goto L27;
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "duration < 0", null, null, 57));
        return;
    L27:
        RunnableC0153a r15 = new RunnableC0153a(this, r8);
        this.c = r15;
        Lazy r16 = UIUtils.a;
        UIUtils.c().postDelayed(r15, r3);
        return;
    L20:
        r3 = 0;
    L8:
        r11 = null;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
