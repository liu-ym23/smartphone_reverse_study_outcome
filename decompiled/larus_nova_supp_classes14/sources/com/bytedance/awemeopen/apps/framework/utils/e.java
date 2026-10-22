package com.bytedance.awemeopen.apps.framework.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements com.bytedance.awemeopen.infra.base.event.d {
    public static final /* synthetic */ int c = 0;
    public final r14.c a;
    public final com.bytedance.awemeopen.infra.base.event.d b;

    public static final class a {
        public static Map a(r14.c r4) {
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
            if (r4 == null) goto L8;
            String r5 = r4.r().f;     // Catch: Throwable -> L11
            if (r5 == null) goto L8;
            JSONObject r2 = new JSONObject(r5);     // Catch: Throwable -> L11
        L9:
            Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L11
        L14:
            if (Result.isFailure-impl(r6) == false) goto L16;
            r6 = null;
        L16:
            JSONObject r7 = (JSONObject) r6;
            if (r7 != null) goto L19;
            return null;
        L19:
            Iterator<String> r0 = r7.keys();
            LinkedHashMap r3 = new LinkedHashMap();
        L21:
            if (r0.hasNext() == false) goto L26;
            String r8 = r0.next();
            Object r9 = r7.opt(r8);
            if (r9 == null) goto L21;
            r3.put(r8, r9);
            goto L21
        L26:
            return r3;
        L8:
            r2 = null;
        L11:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r6 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        }
    }

    static {
    }

    public final JSONObject getParams() {
        r14.c r0 = this.a;
        JSONObject r1 = null;
        if (r0 == null) goto L25;
        String r2 = r0.r().f;
        if (r2 == null) goto L25;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(new JSONObject(r2));     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r4) == null) goto L15;
        r4 = new JSONObject();
    L15:
        JSONObject r5 = (JSONObject) r4;
        com.bytedance.awemeopen.infra.base.event.d r6 = this.b;
        if (r6 == null) goto L18;
        r1 = r6.getParams();
    L18:
        if (r1 != null) goto L20;
        return r5;
    L20:
        Iterator<String> r7 = r1.keys();
    L22:
        if (r7.hasNext() == false) goto L24;
        String r8 = r7.next();
        r5.put(r8, r1.opt(r8));
        goto L22
    L24:
        return r5;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        com.bytedance.awemeopen.infra.base.event.d r10 = this.b;
        if (r10 != null) goto L28;
        return null;
    L28:
        return r10.getParams();
    }

    public e(r14.c r1) {
        this.a = r1;
        this.b = null;
    }
}
