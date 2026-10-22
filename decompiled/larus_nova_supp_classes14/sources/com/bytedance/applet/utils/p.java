package com.bytedance.applet.utils;

import com.larus.platform.api.e5;
import com.larus.platform.api.f5;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements e5 {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    public p(q r1) {
        this.a = r1;
    }

    public final void a(f5 r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        Function1<Boolean, Unit> r0 = this.a;
        String r4 = r3.a;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        r0.invoke(Boolean.valueOf(!r5));
        return;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r5 = false;
        goto L9
    }
}
