package com.bytedance.ee.bear.browser.plugin.lazy;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum PluginMountStrategy extends Enum<PluginMountStrategy> {
    public static final PluginMountStrategy FirstFind = null;
    public static final PluginMountStrategy FirstJSCall = null;
    public static final PluginMountStrategy Immediate = null;
    public static final PluginMountStrategy LoadFinish = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginMountStrategy[] f216626a = null;

    static {
        PluginMountStrategy r100 = new PluginMountStrategy("Immediate", 0);
        Immediate = r100;
        PluginMountStrategy r101 = new PluginMountStrategy("FirstFind", 1);
        FirstFind = r101;
        PluginMountStrategy r102 = new PluginMountStrategy("FirstJSCall", 2);
        FirstJSCall = r102;
        PluginMountStrategy r103 = new PluginMountStrategy("LoadFinish", 3);
        LoadFinish = r103;
        f216626a = new PluginMountStrategy[]{r100, r101, r102, r103};
    }

    public static PluginMountStrategy[] values() {
        return (PluginMountStrategy[]) f216626a.clone();
    }

    public static PluginMountStrategy valueOf(String r100) {
        return (PluginMountStrategy) a.a(PluginMountStrategy.class, r100);
    }

    public PluginMountStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
