package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.shopping.verify.AuthUtils;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECLegalVerificationActionAtomEvent extends t96.a {
    public final Context c;

    public final Context getContext() {
        return this.c;
    }

    public ECLegalVerificationActionAtomEvent(Context r3) {
        Intrinsics.checkNotNullParameter("legalVerification", "name");
        Intrinsics.checkNotNullParameter(r3, "context");
        super("legalVerification");
        this.c = r3;
    }

    public final void b(final EventContext r8, final Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "eventContext");
        Intrinsics.checkNotNullParameter(r9, "completion");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        int r1 = g.a;     // Catch: Throwable -> L16
        g r2 = g.a.a(r8.k);     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        Context r3 = this.c;     // Catch: Throwable -> L16
        if ((r3 instanceof Activity) == true) goto L8;
        r3 = null;
    L8:
        Activity r4 = (Activity) r3;     // Catch: Throwable -> L16
        if (r4 != null) goto L12;
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Throwable -> L16
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "context is not Activity", null, null, 57));     // Catch: Throwable -> L16
        return;
    L12:
        int r5 = AuthUtils.a;     // Catch: Throwable -> L16
        AuthUtils.a(r4, r2.a(), null, new ECLegalVerificationActionAtomEvent$handle$$inlined$runCatching$lambda$1(this, r8, r9));     // Catch: Throwable -> L16
    L14:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L23;
        int r6 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "check legal verification exception: " + r12.getMessage(), null, null, 57));
        return;
    L23:
        return;
    L13:
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Throwable -> L16
        Unit r14 = (Unit) r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "eventFields is null", null, null, 57));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
