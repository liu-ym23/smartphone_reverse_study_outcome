package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface ReuseableHandlerThread {
    void execute(Runnable r1);

    int getIdentify();

    boolean isReuse();

    String name();

    void onQuit();
}
