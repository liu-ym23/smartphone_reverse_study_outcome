package com.bytedance.ug.sdk.luckycat.impl.model;

/* JADX INFO: loaded from: classes22.dex */
public final enum PluginState extends Enum<PluginState> {
    public static final PluginState DOWNLOADING = null;
    public static final PluginState INSTALLED = null;
    public static final PluginState INSTALLING = null;
    public static final PluginState LOADED = null;
    public static final PluginState LOADING = null;
    public static final PluginState RUNNING = null;
    public static final PluginState UN_DOWNLOAD = null;
    public static final PluginState UN_INSTALLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PluginState[] f271380a = null;
    public String status;

    static {
        PluginState r100 = new PluginState("UN_DOWNLOAD", 0, "un_download");
        UN_DOWNLOAD = r100;
        PluginState r101 = new PluginState("DOWNLOADING", 1, "downloading");
        DOWNLOADING = r101;
        PluginState r102 = new PluginState("UN_INSTALLED", 2, "un_installed");
        UN_INSTALLED = r102;
        PluginState r103 = new PluginState("INSTALLING", 3, "installing");
        INSTALLING = r103;
        PluginState r104 = new PluginState("INSTALLED", 4, "installed");
        INSTALLED = r104;
        PluginState r105 = new PluginState("LOADING", 5, "loading");
        LOADING = r105;
        PluginState r110 = new PluginState("LOADED", 6, "loaded");
        LOADED = r110;
        PluginState r111 = new PluginState("RUNNING", 7, "running");
        RUNNING = r111;
        f271380a = new PluginState[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static PluginState[] values() {
        return (PluginState[]) f271380a.clone();
    }

    public static PluginState valueOf(String r100) {
        return (PluginState) r27.a.a(PluginState.class, r100);
    }

    public PluginState(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
