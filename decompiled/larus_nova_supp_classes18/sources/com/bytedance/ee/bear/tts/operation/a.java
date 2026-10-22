package com.bytedance.ee.bear.tts.operation;

import com.bytedance.ee.bear.tts.TtsResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a {
    public final String a;
    public mo5.b b;
    public mo5.b c;

    public void b() {
        tt5.a.h(this.a, "onAttach");
    }

    public void c() {
        tt5.a.h(this.a, "onDetach");
    }

    public void d() {
        tt5.a.h(this.a, "onStart");
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.a = r2;
    }

    public final void a(TtsResult r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        mo5.b r0 = this.b;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        mo5.b r1 = this.c;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    }
}
