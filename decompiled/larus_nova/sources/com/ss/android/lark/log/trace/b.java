package com.ss.android.lark.log.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431421a;

    public static final class a {
    }

    static {
    }

    public b() {
        Intrinsics.checkNotNullParameter("user_flow", "eventName");
        this.f431421a = "user_flow";
    }

    public final StepTrace a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stepName");
        return new StepTrace(this.f431421a, r100);
    }
}
