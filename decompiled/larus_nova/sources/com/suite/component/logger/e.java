package com.suite.component.logger;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f460137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.suite.component.logger.api.d> f460138b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(b r100, List<? extends com.suite.component.logger.api.d> r101) {
        Intrinsics.checkNotNullParameter(r100, "logContext");
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        this.f460137a = r100;
        this.f460138b = r101;
    }
}
