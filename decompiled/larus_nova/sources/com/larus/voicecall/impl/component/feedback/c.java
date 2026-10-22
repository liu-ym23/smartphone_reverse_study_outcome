package com.larus.voicecall.impl.component.feedback;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f377445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f377446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f377447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f377448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f377449e;

    public final Map<String, String> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        boolean r101 = true;
        Object r102 = null;
        if ((!((ArrayList) this.f377445a).isEmpty()) == false) goto L20;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L6
        Lazy r104 = com.larus.utils.gson.b.f375403a;     // Catch: Throwable -> L6
        Object r105 = Result.m9449constructorimpl(com.larus.utils.gson.b.a(this.f377445a));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r105) == false) goto L11;
        r105 = null;
    L11:
        String r106 = (String) r105;
        if (r106 == null) goto L20;
        if (r106.length() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L20;
        r100.put("call_error_details", r106);
        goto L20
    L16:
        r107 = false;
    L6:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        if ((!((ArrayList) this.f377446b).isEmpty()) == false) goto L37;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L23
        Lazy r110 = com.larus.utils.gson.b.f375403a;     // Catch: Throwable -> L23
        Object r111 = Result.m9449constructorimpl(com.larus.utils.gson.b.a(this.f377446b));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r111) == false) goto L28;
        r111 = null;
    L28:
        String r112 = (String) r111;
        if (r112 == null) goto L37;
        if (r112.length() <= 0) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L37;
        r100.put("call_type_trace", r112);
        goto L37
    L33:
        r113 = false;
    L23:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L37:
        if ((!((ArrayList) this.f377447c).isEmpty()) == false) goto L55;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L40
        Lazy r116 = com.larus.utils.gson.b.f375403a;     // Catch: Throwable -> L40
        Object r117 = Result.m9449constructorimpl(com.larus.utils.gson.b.a(this.f377447c));     // Catch: Throwable -> L40
    L43:
        if (Result.m9455isFailureimpl(r117) == true) goto L46;
        r102 = r117;
    L46:
        String r118 = (String) r102;
        if (r118 == null) goto L55;
        if (r118.length() <= 0) goto L51;
        boolean r119 = true;
    L52:
        if (r119 == false) goto L55;
        r100.put("room_id", r118);
        goto L55
    L51:
        r119 = false;
    L40:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L55:
        if (this.f377448d.length() <= 0) goto L57;
        boolean r121 = true;
    L58:
        if (r121 == false) goto L61;
        r100.put("log_id", this.f377448d);
    L61:
        if (this.f377449e.length() > 0) goto L64;
        r101 = false;
    L64:
        if (r101 == false) goto L66;
        r100.put("task_id", this.f377449e);
    L66:
        r100.put("device_type", "android");
        return r100;
    L57:
        r121 = false;
        goto L58
    }

    public c() {
        this.f377445a = new ArrayList();
        this.f377446b = new ArrayList();
        this.f377447c = new ArrayList();
        this.f377448d = "";
        this.f377449e = "";
    }

    public final void a(CallTypeTrace r100) {
        Intrinsics.checkNotNullParameter(r100, "callTypeTrace");
        List<String> r101 = this.f377446b;
        ArrayList r102 = (ArrayList) r101;
        r102.add(r100.getCallType());
    }
}
