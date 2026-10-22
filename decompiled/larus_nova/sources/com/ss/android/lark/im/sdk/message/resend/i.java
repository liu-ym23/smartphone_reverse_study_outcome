package com.ss.android.lark.im.sdk.message.resend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i extends jkb.a<h> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // jkb.a
    public final void b(jkb.d r100, jkb.b r101, jkb.e r102) {
        Intrinsics.checkNotNullParameter(r100, "pipelineStep");
        Intrinsics.checkNotNullParameter((h) r101, "pipelineContext");
        Intrinsics.checkNotNullParameter(r102, "reason");
        int r103 = com.ss.android.lark.im.sdk.a.f425904a;
        com.ss.android.lark.im.sdk.a.a("ImSdkResendPipeline", "Resend message pipeline terminated terminated in " + r100.getName() + ", reason is " + r102);
    }
}
