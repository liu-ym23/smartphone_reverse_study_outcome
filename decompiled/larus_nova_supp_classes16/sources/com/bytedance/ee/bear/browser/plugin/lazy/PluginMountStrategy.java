package com.bytedance.ee.bear.browser.plugin.lazy;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum PluginMountStrategy extends Enum<PluginMountStrategy> {
    public static final PluginMountStrategy FirstFind = null;
    public static final PluginMountStrategy FirstJSCall = null;
    public static final PluginMountStrategy Immediate = null;
    public static final PluginMountStrategy LoadFinish = null;
    public static final /* synthetic */ PluginMountStrategy[] a = null;

    static {
        PluginMountStrategy r0 = new PluginMountStrategy("Immediate", 0);
        Immediate = r0;
        PluginMountStrategy r1 = new PluginMountStrategy("FirstFind", 1);
        FirstFind = r1;
        PluginMountStrategy r3 = new PluginMountStrategy("FirstJSCall", 2);
        FirstJSCall = r3;
        PluginMountStrategy r5 = new PluginMountStrategy("LoadFinish", 3);
        LoadFinish = r5;
        a = new PluginMountStrategy[]{r0, r1, r3, r5};
    }

    public static PluginMountStrategy[] values() {
        return (PluginMountStrategy[]) a.clone();
    }

    public static PluginMountStrategy valueOf(String r1) {
        return (PluginMountStrategy) a.a(PluginMountStrategy.class, r1);
    }

    public PluginMountStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
