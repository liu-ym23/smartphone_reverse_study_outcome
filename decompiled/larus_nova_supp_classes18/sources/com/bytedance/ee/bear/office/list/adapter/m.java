package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public static int a(Document r4) {
        int r0 = r4.getType();
        if (r0 != sbb.e.f.b) goto L5;
    L45:
        Intrinsics.checkNotNullParameter(r4, "document");
        if (h0.b(r4) == true) goto L55;
        boolean r5 = mbb.c.a;
        return kac.a.b(2131254455);
    L55:
        return rbb.b.g();
    L5:
        if (r0 == 111) goto L45;
        if (r0 != sbb.e.l.b) goto L11;
        return rbb.b.e(r4.F);
    L11:
        if (r0 == sbb.e.n.b) goto L53;
        int r1 = r4.getType();
        String r6 = r4.F2;
        if (r6 != null) goto L16;
    L19:
        boolean r2 = true;
    L20:
        Long r3 = null;
        Object r7 = null;
        if (r2 == true) goto L54;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L37
        JSONObject r9 = new JSONObject(r6);     // Catch: Throwable -> L37
        if (r9.has("obj_sub_type") == true) goto L26;
    L34:
        Long r10 = null;
    L35:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r11) == true) goto L43;
        r7 = r11;
    L43:
        r3 = (Long) r7;
        goto L54
    L26:
        if (r9.isNull("obj_sub_type") == true) goto L34;
        Object r12 = r9.opt("obj_sub_type");     // Catch: Throwable -> L37
        if ((r12 instanceof Number) == false) goto L32;
        r10 = Long.valueOf(((Number) r12).longValue());     // Catch: Throwable -> L37
        goto L35
    L32:
        if ((r12 instanceof String) == false) goto L34;
        r10 = StringsKt.toLongOrNull((String) r12);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L54:
        return rbb.b.c(r1, r3);
    L16:
        if (StringsKt.isBlank(r6) == true) goto L19;
        r2 = false;
        goto L20
    L53:
        return ua5.a.l(r4.y1, r4.a);
    }
}
