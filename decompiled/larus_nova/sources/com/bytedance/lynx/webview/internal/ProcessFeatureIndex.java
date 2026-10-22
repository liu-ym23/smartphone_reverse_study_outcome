package com.bytedance.lynx.webview.internal;

/* JADX INFO: loaded from: classes21.dex */
public final enum ProcessFeatureIndex extends Enum<ProcessFeatureIndex> {
    public static final ProcessFeatureIndex ENABLE_CLAMP_JVM_HEAP = null;
    public static final ProcessFeatureIndex ENABLE_CLEAR_GLOBAL_CODECACHE = null;
    public static final ProcessFeatureIndex ENABLE_MEDIA_TTMP = null;
    public static final ProcessFeatureIndex ENABLE_RENDER_IN_BROWSER = null;
    public static final ProcessFeatureIndex ENABLE_RENDER_PROCESS = null;
    public static final ProcessFeatureIndex ENABLE_SAFE_BROWSING = null;
    public static final ProcessFeatureIndex ENABLE_SELECT_MENU = null;
    public static final ProcessFeatureIndex ENABLE_UNMAP_WEBVIEW_RESERVED = null;
    public static final ProcessFeatureIndex ENABLE_UPLOAD_DATA = null;
    public static final ProcessFeatureIndex ENABLE_UPLOAD_EVENT = null;
    public static final ProcessFeatureIndex ENABLE_USE_TTWEBVIEW = null;
    public static final ProcessFeatureIndex ENABLE_WARMUP = null;
    public static final ProcessFeatureIndex ENABLE_WARMUP_RENDERPROCESSHOST = null;
    public static final ProcessFeatureIndex ENABLE_WARMUP_RENDER_PROCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProcessFeatureIndex[] f265157a = null;
    private int index;

    static {
        ProcessFeatureIndex r100 = new ProcessFeatureIndex("ENABLE_RENDER_PROCESS", 0, 1);
        ENABLE_RENDER_PROCESS = r100;
        ProcessFeatureIndex r101 = new ProcessFeatureIndex("ENABLE_WARMUP", 1, 2);
        ENABLE_WARMUP = r101;
        ProcessFeatureIndex r102 = new ProcessFeatureIndex("ENABLE_RENDER_IN_BROWSER", 2, 3);
        ENABLE_RENDER_IN_BROWSER = r102;
        ProcessFeatureIndex r103 = new ProcessFeatureIndex("ENABLE_SELECT_MENU", 3, 4);
        ENABLE_SELECT_MENU = r103;
        ProcessFeatureIndex r104 = new ProcessFeatureIndex("ENABLE_WARMUP_RENDERPROCESSHOST", 4, 5);
        ENABLE_WARMUP_RENDERPROCESSHOST = r104;
        ProcessFeatureIndex r110 = new ProcessFeatureIndex("ENABLE_CLAMP_JVM_HEAP", 5, 6);
        ENABLE_CLAMP_JVM_HEAP = r110;
        ProcessFeatureIndex r111 = new ProcessFeatureIndex("ENABLE_UNMAP_WEBVIEW_RESERVED", 6, 7);
        ENABLE_UNMAP_WEBVIEW_RESERVED = r111;
        ProcessFeatureIndex r112 = new ProcessFeatureIndex("ENABLE_MEDIA_TTMP", 7, 8);
        ENABLE_MEDIA_TTMP = r112;
        ProcessFeatureIndex r113 = new ProcessFeatureIndex("ENABLE_USE_TTWEBVIEW", 8, 9);
        ENABLE_USE_TTWEBVIEW = r113;
        ProcessFeatureIndex r114 = new ProcessFeatureIndex("ENABLE_UPLOAD_EVENT", 9, 10);
        ENABLE_UPLOAD_EVENT = r114;
        ProcessFeatureIndex r115 = new ProcessFeatureIndex("ENABLE_UPLOAD_DATA", 10, 11);
        ENABLE_UPLOAD_DATA = r115;
        ProcessFeatureIndex r105 = new ProcessFeatureIndex("ENABLE_CLEAR_GLOBAL_CODECACHE", 11, 12);
        ENABLE_CLEAR_GLOBAL_CODECACHE = r105;
        ProcessFeatureIndex r106 = new ProcessFeatureIndex("ENABLE_SAFE_BROWSING", 12, 13);
        ENABLE_SAFE_BROWSING = r106;
        ProcessFeatureIndex r107 = new ProcessFeatureIndex("ENABLE_WARMUP_RENDER_PROCESS", 13, 14);
        ENABLE_WARMUP_RENDER_PROCESS = r107;
        f265157a = new ProcessFeatureIndex[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107};
    }

    public static ProcessFeatureIndex[] values() {
        return (ProcessFeatureIndex[]) f265157a.clone();
    }

    public int value() {
        return this.index;
    }

    public static ProcessFeatureIndex valueOf(String r100) {
        return (ProcessFeatureIndex) r27.a.a(ProcessFeatureIndex.class, r100);
    }

    public ProcessFeatureIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
