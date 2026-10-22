package com.suite.lark.component.navroute.graph;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes40.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f460374a = null;

    static {
        f460374a = new b();
    }

    public b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        r100.run();
    }
}
