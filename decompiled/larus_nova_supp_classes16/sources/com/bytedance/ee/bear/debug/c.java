package com.bytedance.ee.bear.debug;

import android.text.Editable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends AppendParamsActivity.c {
    public final /* synthetic */ AppendParamsActivity.b a;

    public c(AppendParamsActivity.b r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r3) {
        AppendParamsActivity.b r0 = this.a;
        if (r3 == null) goto L6;
        String r4 = r3.toString();
        if (r4 == null) goto L6;
    L7:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
        return;
    L6:
        r4 = "";
        goto L7
    }
}
