package com.obric.assistant.activation.presentation.runtime.precheck;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static final ObricChildListeningPrecheck.b a(ObricChildListeningPrecheck.Reason r100) {
        ObricChildListeningPrecheck.b r101 = ObricChildListeningPrecheck.b.f385458c;
        Intrinsics.checkNotNullParameter(r100, "reason");
        return new ObricChildListeningPrecheck.b(ObricChildListeningPrecheck.Status.BLOCKED, r100);
    }
}
