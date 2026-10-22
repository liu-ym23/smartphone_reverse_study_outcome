package com.obric.assistant.special_input;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i {
    public static final t0 a(t0 r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r110, "currentState");
        if (r111 != null) goto L7;
        return t0.a(r110, false, false, false, false, 0, false, false, 63);
    L7:
        return t0.a(r110, false, false, false, false, r111.intValue(), true, true, 15);
    }

    public static final t0 b(t0 r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "currentState");
        if (r111 != null) goto L7;
        return t0.a(r110, false, false, false, false, 0, false, false, 119);
    L7:
        return t0.a(r110, r111.booleanValue(), true, true, true, 0, false, false, 112);
    }
}
