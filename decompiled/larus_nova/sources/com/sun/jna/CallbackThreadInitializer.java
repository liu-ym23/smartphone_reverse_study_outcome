package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public class CallbackThreadInitializer {
    private boolean daemon;
    private boolean detach;
    private ThreadGroup group;
    private String name;

    public CallbackThreadInitializer() {
        this(true);
    }

    public CallbackThreadInitializer(boolean r100) {
        this(r100, false);
    }

    public boolean detach(Callback r100) {
        return this.detach;
    }

    public String getName(Callback r100) {
        return this.name;
    }

    public ThreadGroup getThreadGroup(Callback r100) {
        return this.group;
    }

    public boolean isDaemon(Callback r100) {
        return this.daemon;
    }

    public CallbackThreadInitializer(boolean r100, boolean r101) {
        this(r100, r101, null);
    }

    public CallbackThreadInitializer(boolean r100, boolean r101, String r102) {
        this(r100, r101, r102, null);
    }

    public CallbackThreadInitializer(boolean r100, boolean r101, String r102, ThreadGroup r103) {
        this.daemon = r100;
        this.detach = r101;
        this.name = r102;
        this.group = r103;
    }
}
