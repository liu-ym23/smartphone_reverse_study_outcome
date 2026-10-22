package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECCheckLoginActionAtomEvent extends t96.a {
    public final Context c;

    public ECCheckLoginActionAtomEvent(Context r3) {
        Intrinsics.checkNotNullParameter("loginVerification", "name");
        Intrinsics.checkNotNullParameter(r3, "context");
        super("loginVerification");
        this.c = r3;
    }

    public final void b(EventContext r12, final Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "eventContext");
        Intrinsics.checkNotNullParameter(r13, "completion");
        CheckLoginParam.a r0 = CheckLoginParam.Companion;
        Map r14 = r12.k;
        r0.getClass();
        final CheckLoginParam r15 = CheckLoginParam.a.a(r14);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        Context r2 = this.c;     // Catch: Throwable -> L32
        String r3 = null;
        if ((r2 instanceof Activity) == true) goto L6;
        r2 = null;
    L6:
        Activity r4 = (Activity) r2;     // Catch: Throwable -> L32
        final long r5 = System.currentTimeMillis();     // Catch: Throwable -> L32
        if (r4 != null) goto L10;
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;     // Catch: Throwable -> L32
        r13.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "activity is null", null, null, 57));     // Catch: Throwable -> L32
        return;
    L10:
        Map r6 = LoginUtil.a;     // Catch: Throwable -> L32
        if (r15 == null) goto L14;
        String r7 = r15.getEnterFrom();     // Catch: Throwable -> L32
    L16:
        if (r7 != null) goto L18;
        String r8 = "";
    L19:
        if (r15 == null) goto L21;
        String r9 = r15.getEnterMethod();     // Catch: Throwable -> L32
    L22:
        if (r9 != null) goto L24;
        String r10 = "";
    L25:
        if (r15 == null) goto L27;
        r3 = r15.getSource();     // Catch: Throwable -> L32
    L27:
        if (r3 != null) goto L29;
        String r11 = "";
    L30:
        LoginUtil.b(r4, r8, r10, r11, new ECCheckLoginActionAtomEvent$handle$$inlined$runCatching$lambda$1(r5, this, r13, r15), new ECCheckLoginActionAtomEvent$handle$$inlined$runCatching$lambda$2(this, r13, r15));     // Catch: Throwable -> L32
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L39;
        int r19 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r13.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "check login exception: " + r18.getMessage(), null, null, 57));
        return;
    L39:
        return;
    L29:
        r11 = r3;
        goto L30
    L24:
        r10 = r9;
        goto L25
    L21:
        r9 = null;
        goto L22
    L18:
        r8 = r7;
        goto L19
    L14:
        r7 = null;
    L32:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }
}
