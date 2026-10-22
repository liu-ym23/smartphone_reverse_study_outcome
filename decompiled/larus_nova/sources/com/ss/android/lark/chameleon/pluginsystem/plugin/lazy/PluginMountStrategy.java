package com.ss.android.lark.chameleon.pluginsystem.plugin.lazy;

/* JADX INFO: loaded from: classes35.dex */
public final enum PluginMountStrategy extends Enum<PluginMountStrategy> {
    private static final /* synthetic */ PluginMountStrategy[] $VALUES = null;
    public static final PluginMountStrategy FirstFind = null;
    public static final PluginMountStrategy FirstJSCall = null;
    public static final PluginMountStrategy Immediate = null;
    public static final PluginMountStrategy LoadFinish = null;

    static {
        PluginMountStrategy r100 = new PluginMountStrategy("Immediate", 0);
        Immediate = r100;
        PluginMountStrategy r101 = new PluginMountStrategy("FirstFind", 1);
        FirstFind = r101;
        PluginMountStrategy r102 = new PluginMountStrategy("FirstJSCall", 2);
        FirstJSCall = r102;
        PluginMountStrategy r103 = new PluginMountStrategy("LoadFinish", 3);
        LoadFinish = r103;
        $VALUES = new PluginMountStrategy[]{r100, r101, r102, r103};
    }

    public static PluginMountStrategy[] values() {
        return (PluginMountStrategy[]) $VALUES.clone();
    }

    public static PluginMountStrategy valueOf(String r100) {
        return (PluginMountStrategy) r27.a.a(PluginMountStrategy.class, r100);
    }

    private PluginMountStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
