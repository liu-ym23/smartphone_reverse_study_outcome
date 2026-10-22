package com.bytedance.android.shopping.yata.business.function.common;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kl3.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import ll3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RegexCheck {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(a r3, String r4, Map r5) {
        String r0 = (String) r5.get("failed_trigger");
        Object r6 = r5.get("trigger_match_vo");
        if ((r6 instanceof Map) == true) goto L5;
        r6 = null;
    L5:
        final Map r7 = (Map) r6;
        if (r3.d().d(r7) == false) goto L15;
        Iterator r8 = r3.c().d(new RegexCheck$triggerFailedEvent$matchedNodes$1(r7)).iterator();
    L9:
        if (r8.hasNext() == false) goto L13;
        c r9 = (c) r8.next();
        if (r3.d().d(r0) == false) goto L9;
        r3.c().h(r9.getKey(), r0, null);
        goto L9
    L13:
        return;
    L15:
        if (r3.d().d(r0) == false) goto L23;
        r3.c().h(r4, r0, null);
        return;
    }

    public static boolean a(String r7, a r8, List r9, Map r10, com.bytedance.kmp.ec.yata.event.core.a r11, String r12) {
        Intrinsics.checkNotNullParameter(r7, "selfEventName");
        Intrinsics.checkNotNullParameter(r8, "abilities");
        Intrinsics.checkNotNullParameter(r11, "input");
        if (r9 == null) goto L42;
        Iterator r13 = r9.iterator();
    L6:
        if (r13.hasNext() == false) goto L42;
        Map r1 = (Map) r13.next();
        String r2 = (String) r1.get("field_path");
        if (r8.d().b(r2) == false) goto L18;
        int r3 = ll3.a.a;
        String r4 = "field_path(" + r2 + ") is nullOrEmpty";
        Intrinsics.checkNotNullParameter("RegexCheck", "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        dm.a.b r14 = dm.a.a;     // Catch: Throwable -> L12
        dm.a.a("yata_business_RegexCheck").a(r4);     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r15 = Result.exceptionOrNull-impl(r5);
        if (r15 == null) goto L17;
        ECExceptionMonitor.e(r15);
    L17:
        b.a(r8, r7, "field_path is empty", r11);
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        String r17 = (String) r1.get("regex");
        Object r18 = "";
        if (r17 != null) goto L21;
        r17 = "";
    L21:
        kl3.b r19 = r8.d();
        Intrinsics.checkNotNull(r2);
        Object r20 = r19.a(r10, r2, null);
        if ((r20 instanceof Boolean) == false) goto L25;
        r18 = r20.toString();
    L37:
        if (r8.d().b(Boolean.valueOf(new Regex(r17).matches((CharSequence) r18))) == false) goto L6;
        b(r8, r12, r1);
        return false;
    L25:
        if ((r20 instanceof Number) == false) goto L27;
        r18 = String.valueOf(r20);
        goto L37
    L27:
        r8.d().getClass();
        if (r20 != null) goto L30;
        boolean r21 = true;
    L31:
        if (r21 == true) goto L37;
        if ((r20 instanceof String) == false) goto L40;
        r18 = r20;
        goto L37
    L40:
        b(r8, r12, r1);
        b.a(r8, r7, "target is illegal", r11);
        return false;
    L30:
        r21 = false;
    L42:
        return true;
    }
}
