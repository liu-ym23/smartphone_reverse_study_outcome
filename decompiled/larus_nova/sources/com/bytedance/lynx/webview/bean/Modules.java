package com.bytedance.lynx.webview.bean;

import com.ss.android.download.api.config.HttpMethod;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum Modules extends Enum<Modules> {
    public static final Modules DOWNLOAD = null;
    public static final Modules HOOK = null;
    public static final Modules LOAD = null;
    public static final Modules PREPARE = null;
    public static final Modules SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Modules[] f265075a = null;
    private String mModuleDesc;

    static {
        Modules r100 = new Modules("LOAD", 0, "Load");
        LOAD = r100;
        Modules r101 = new Modules("HOOK", 1, "Hook");
        HOOK = r101;
        Modules r102 = new Modules("PREPARE", 2, "Prepare");
        PREPARE = r102;
        Modules r103 = new Modules("SETTING", 3, "Setting");
        SETTING = r103;
        Modules r104 = new Modules(HttpMethod.DOWNLOAD, 4, "Download");
        DOWNLOAD = r104;
        f265075a = new Modules[]{r100, r101, r102, r103, r104};
    }

    public static Modules[] values() {
        return (Modules[]) f265075a.clone();
    }

    public String getModuleDesc() {
        return this.mModuleDesc;
    }

    public static Modules valueOf(String r100) {
        return (Modules) a.a(Modules.class, r100);
    }

    public Modules(String r100, int r101, String r102) {
        super(r100, r101);
        this.mModuleDesc = r102;
    }
}
