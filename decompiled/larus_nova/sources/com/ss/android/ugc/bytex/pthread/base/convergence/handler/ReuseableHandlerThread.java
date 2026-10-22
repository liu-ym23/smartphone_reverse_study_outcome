package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

/* JADX INFO: loaded from: classes.dex */
public interface ReuseableHandlerThread {
    void execute(Runnable r100);

    int getIdentify();

    boolean isReuse();

    String name();

    void onQuit();
}
