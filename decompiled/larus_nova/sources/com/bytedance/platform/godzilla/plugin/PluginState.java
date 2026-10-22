package com.bytedance.platform.godzilla.plugin;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum PluginState extends Enum<PluginState> {
    public static final PluginState DESTROYED = null;
    public static final PluginState INITIALIZED = null;
    public static final PluginState STARTED = null;
    public static final PluginState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginState[] f266619a = null;

    static {
        PluginState r100 = new PluginState("INITIALIZED", 0);
        INITIALIZED = r100;
        PluginState r101 = new PluginState("STARTED", 1);
        STARTED = r101;
        PluginState r102 = new PluginState("STOPPED", 2);
        STOPPED = r102;
        PluginState r103 = new PluginState("DESTROYED", 3);
        DESTROYED = r103;
        f266619a = new PluginState[]{r100, r101, r102, r103};
    }

    public static PluginState[] values() {
        return (PluginState[]) f266619a.clone();
    }

    public static PluginState valueOf(String r100) {
        return (PluginState) a.a(PluginState.class, r100);
    }

    public PluginState(String r100, int r101) {
        super(r100, r101);
    }
}
