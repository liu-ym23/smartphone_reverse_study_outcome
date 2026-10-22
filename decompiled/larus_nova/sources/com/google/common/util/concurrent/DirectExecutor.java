package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    private static /* synthetic */ DirectExecutor[] $values() {
        return new DirectExecutor[]{INSTANCE};
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }

    static {
        INSTANCE = new DirectExecutor("INSTANCE", 0);
        $VALUES = $values();
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    public static DirectExecutor valueOf(String r100) {
        return (DirectExecutor) r27.a.a(DirectExecutor.class, r100);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        r100.run();
    }

    private DirectExecutor(String r100, int r101) {
        super(r100, r101);
    }
}
