package com.bytedance.ies.stark.plugin;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/ies/stark/plugin/PluginModule$Type", "", "Lcom/bytedance/ies/stark/plugin/PluginModule$Type;", "GLOBAL", "LYNX", "RN", "WEB_VIEW", "FLUTTER", "TIMOR", "stark-api_release"}, k = 1, mv = {1, 7, 1})
public final enum PluginModule$Type extends Enum<PluginModule$Type> {
    public static final PluginModule$Type FLUTTER = null;
    public static final PluginModule$Type GLOBAL = null;
    public static final PluginModule$Type LYNX = null;
    public static final PluginModule$Type RN = null;
    public static final PluginModule$Type TIMOR = null;
    public static final PluginModule$Type WEB_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginModule$Type[] f248665a = null;

    public static PluginModule$Type valueOf(String r100) {
        return (PluginModule$Type) r27.a.a(PluginModule$Type.class, r100);
    }

    public static PluginModule$Type[] values() {
        return (PluginModule$Type[]) f248665a.clone();
    }

    static {
        PluginModule$Type r100 = new PluginModule$Type("GLOBAL", 0);
        GLOBAL = r100;
        PluginModule$Type r101 = new PluginModule$Type("LYNX", 1);
        LYNX = r101;
        PluginModule$Type r102 = new PluginModule$Type("RN", 2);
        RN = r102;
        PluginModule$Type r103 = new PluginModule$Type("WEB_VIEW", 3);
        WEB_VIEW = r103;
        PluginModule$Type r104 = new PluginModule$Type("FLUTTER", 4);
        FLUTTER = r104;
        PluginModule$Type r105 = new PluginModule$Type("TIMOR", 5);
        TIMOR = r105;
        f248665a = new PluginModule$Type[]{r100, r101, r102, r103, r104, r105};
    }

    public PluginModule$Type(String r100, int r101) {
        super(r100, r101);
    }
}
