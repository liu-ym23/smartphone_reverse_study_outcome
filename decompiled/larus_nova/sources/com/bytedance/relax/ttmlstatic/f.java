package com.bytedance.relax.ttmlstatic;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.kmp.foundation.i;
import com.bytedance.rts.kmp.foundation.j;
import com.bytedance.rts.kmp.foundation.r;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, e> f267233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f267234b;

    public final void a() {
        Throwable r100 = null;
    L4:
        if (i.a(this.f267234b) <= 0) goto L14;
        ArrayList<String> r101 = this.f267234b;
        IntCompanionObject r102 = IntCompanionObject.INSTANCE;
        int r103 = i.a(r101);
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r104 = (String) ListProtector.get(r101, r103 - 1);
        Intrinsics.checkNotNullParameter(r104, "componentId");     // Catch: Throwable -> L11
        if (((e) j.c(this.f267233a, r104)) == null) goto L4;
        i.a(null);     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r100 != null) goto L4;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.kmp.foundation.RTSErrorKt.RTSError }");
        r100 = th;
        goto L4
    L14:
        this.f267234b = i.b(new String[0]);
        if (r100 == null) goto L32;
        int r105 = r.f267614a;
        Object[] r106 = new Object[1];
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r107 = r100.getMessage();
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        r106[0] = r107;
        r.a.a(r106);
        return;
    }

    public f() {
        this.f267233a = new LinkedHashMap();
        this.f267234b = i.b(new String[0]);
    }
}
