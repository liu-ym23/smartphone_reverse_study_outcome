package com.bytedance.ee.lark.plugin_annotation.bean;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum PluginEnv extends Enum<PluginEnv> {
    public static final PluginEnv APP_ENV = null;
    public static final PluginEnv BIZ_ENV = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginEnv[] f242840a = null;

    static {
        PluginEnv r100 = new PluginEnv("BIZ_ENV", 0);
        BIZ_ENV = r100;
        PluginEnv r101 = new PluginEnv("APP_ENV", 1);
        APP_ENV = r101;
        f242840a = new PluginEnv[]{r100, r101};
    }

    public static PluginEnv[] values() {
        return (PluginEnv[]) f242840a.clone();
    }

    public static PluginEnv valueOf(String r100) {
        return (PluginEnv) a.a(PluginEnv.class, r100);
    }

    public PluginEnv(String r100, int r101) {
        super(r100, r101);
    }
}
