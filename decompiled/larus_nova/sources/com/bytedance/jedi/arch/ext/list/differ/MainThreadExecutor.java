package com.bytedance.jedi.arch.ext.list.differ;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/jedi/arch/ext/list/differ/MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "()V", "handler", "Landroid/os/Handler;", "execute", "", "command", "Ljava/lang/Runnable;", "ext_list_release"}, k = 1, mv = {1, 1, 16})
public final class MainThreadExecutor implements Executor {
    private final Handler handler;

    public MainThreadExecutor() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        this.handler.post(r100);
    }
}
