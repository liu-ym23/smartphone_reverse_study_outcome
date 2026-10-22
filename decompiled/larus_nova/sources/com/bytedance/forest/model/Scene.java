package com.bytedance.forest.model;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/forest/model/Scene;", "", "LYNX_TEMPLATE", "LYNX_EXTERNAL_JS", "LYNX_COMPONENT", "LYNX_FONT", "LYNX_I18N", "LYNX_IMAGE", "LYNX_LOTTIE", "LYNX_VIDEO", "LYNX_SVG", "LYNX_CORE_JS", "LYNX_THEME", "LYNX_CHILD_RESOURCE", "WEB_MAIN_DOCUMENT", "WEB_CHILD_RESOURCE", "PRELOAD_CONFIG", FlowDoraWifiScene.OTHER, "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum Scene extends Enum<Scene> {
    public static final Scene LYNX_CHILD_RESOURCE = null;
    public static final Scene LYNX_COMPONENT = null;
    public static final Scene LYNX_CORE_JS = null;
    public static final Scene LYNX_EXTERNAL_JS = null;
    public static final Scene LYNX_FONT = null;
    public static final Scene LYNX_I18N = null;
    public static final Scene LYNX_IMAGE = null;
    public static final Scene LYNX_LOTTIE = null;
    public static final Scene LYNX_SVG = null;
    public static final Scene LYNX_TEMPLATE = null;
    public static final Scene LYNX_THEME = null;
    public static final Scene LYNX_VIDEO = null;
    public static final Scene OTHER = null;
    public static final Scene PRELOAD_CONFIG = null;
    public static final Scene WEB_CHILD_RESOURCE = null;
    public static final Scene WEB_MAIN_DOCUMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f244325a = null;

    static {
        Scene r100 = new Scene("LYNX_TEMPLATE", 0);
        LYNX_TEMPLATE = r100;
        Scene r101 = new Scene("LYNX_EXTERNAL_JS", 1);
        LYNX_EXTERNAL_JS = r101;
        Scene r102 = new Scene("LYNX_COMPONENT", 2);
        LYNX_COMPONENT = r102;
        Scene r103 = new Scene("LYNX_FONT", 3);
        LYNX_FONT = r103;
        Scene r104 = new Scene("LYNX_I18N", 4);
        LYNX_I18N = r104;
        Scene r105 = new Scene("LYNX_IMAGE", 5);
        LYNX_IMAGE = r105;
        Scene r106 = new Scene("LYNX_LOTTIE", 6);
        LYNX_LOTTIE = r106;
        Scene r107 = new Scene("LYNX_VIDEO", 7);
        LYNX_VIDEO = r107;
        Scene r108 = new Scene("LYNX_SVG", 8);
        LYNX_SVG = r108;
        Scene r109 = new Scene("LYNX_CORE_JS", 9);
        LYNX_CORE_JS = r109;
        Scene r110 = new Scene("LYNX_THEME", 10);
        LYNX_THEME = r110;
        Scene r111 = new Scene("LYNX_CHILD_RESOURCE", 11);
        LYNX_CHILD_RESOURCE = r111;
        Scene r112 = new Scene("WEB_MAIN_DOCUMENT", 12);
        WEB_MAIN_DOCUMENT = r112;
        Scene r113 = new Scene("WEB_CHILD_RESOURCE", 13);
        WEB_CHILD_RESOURCE = r113;
        Scene r114 = new Scene("PRELOAD_CONFIG", 14);
        PRELOAD_CONFIG = r114;
        Scene r115 = new Scene(FlowDoraWifiScene.OTHER, 15);
        OTHER = r115;
        f244325a = new Scene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115};
    }

    public static Scene valueOf(String r100) {
        return (Scene) r27.a.a(Scene.class, r100);
    }

    public static Scene[] values() {
        return (Scene[]) f244325a.clone();
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
