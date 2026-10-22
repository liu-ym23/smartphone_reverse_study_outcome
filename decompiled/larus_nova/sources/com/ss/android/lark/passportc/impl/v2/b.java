package com.ss.android.lark.passportc.impl.v2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f438236a = null;

    static {
        f438236a = new b();
    }

    public b() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        r100.run();
    }
}
