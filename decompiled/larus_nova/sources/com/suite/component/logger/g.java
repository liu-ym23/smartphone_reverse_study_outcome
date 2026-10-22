package com.suite.component.logger;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements com.suite.component.logger.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f460141a;

    public g() {
    }

    @Override // com.suite.component.logger.api.c
    public final void b() {
        this.f460141a = true;
    }

    @Override // com.suite.component.logger.api.c
    public final boolean isRunning() {
        return this.f460141a;
    }

    @Override // com.suite.component.logger.api.c
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        d.b(r100);
    }
}
