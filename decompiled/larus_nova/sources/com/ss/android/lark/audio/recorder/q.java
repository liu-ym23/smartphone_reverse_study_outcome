package com.ss.android.lark.audio.recorder;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes34.dex */
public final class q implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f409151a = null;

    static {
        f409151a = new q();
    }

    public q() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        CoreThreadPool.getDefault().getUIExecutor().execute(r100);
    }
}
