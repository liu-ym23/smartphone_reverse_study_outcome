package com.lynx.tasm.service;

import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class LynxResourceServiceRequestParams {

    public static final enum LynxServiceScene extends Enum<LynxServiceScene> {
        public static final LynxServiceScene LYNX_CHILD_RESOURCE = null;
        public static final LynxServiceScene LYNX_COMPONENT = null;
        public static final LynxServiceScene LYNX_EXTERNAL_JS = null;
        public static final LynxServiceScene LYNX_FONT = null;
        public static final LynxServiceScene LYNX_I18N = null;
        public static final LynxServiceScene LYNX_IMAGE = null;
        public static final LynxServiceScene LYNX_LOTTIE = null;
        public static final LynxServiceScene LYNX_SVG = null;
        public static final LynxServiceScene LYNX_TEMPLATE = null;
        public static final LynxServiceScene LYNX_VIDEO = null;
        public static final LynxServiceScene OTHER = null;
        public static final LynxServiceScene PRELOAD_CONFIG = null;
        public static final LynxServiceScene WEB_CHILD_RESOURCE = null;
        public static final LynxServiceScene WEB_MAIN_RESOURCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxServiceScene[] f383769a = null;

        static {
            LynxServiceScene r100 = new LynxServiceScene("LYNX_TEMPLATE", 0);
            LYNX_TEMPLATE = r100;
            LynxServiceScene r101 = new LynxServiceScene("LYNX_EXTERNAL_JS", 1);
            LYNX_EXTERNAL_JS = r101;
            LynxServiceScene r102 = new LynxServiceScene("LYNX_COMPONENT", 2);
            LYNX_COMPONENT = r102;
            LynxServiceScene r103 = new LynxServiceScene("LYNX_FONT", 3);
            LYNX_FONT = r103;
            LynxServiceScene r104 = new LynxServiceScene("LYNX_I18N", 4);
            LYNX_I18N = r104;
            LynxServiceScene r105 = new LynxServiceScene("LYNX_IMAGE", 5);
            LYNX_IMAGE = r105;
            LynxServiceScene r110 = new LynxServiceScene("LYNX_LOTTIE", 6);
            LYNX_LOTTIE = r110;
            LynxServiceScene r111 = new LynxServiceScene("LYNX_VIDEO", 7);
            LYNX_VIDEO = r111;
            LynxServiceScene r112 = new LynxServiceScene("LYNX_SVG", 8);
            LYNX_SVG = r112;
            LynxServiceScene r113 = new LynxServiceScene("LYNX_CHILD_RESOURCE", 9);
            LYNX_CHILD_RESOURCE = r113;
            LynxServiceScene r114 = new LynxServiceScene("WEB_MAIN_RESOURCE", 10);
            WEB_MAIN_RESOURCE = r114;
            LynxServiceScene r115 = new LynxServiceScene("WEB_CHILD_RESOURCE", 11);
            WEB_CHILD_RESOURCE = r115;
            LynxServiceScene r106 = new LynxServiceScene("PRELOAD_CONFIG", 12);
            PRELOAD_CONFIG = r106;
            LynxServiceScene r107 = new LynxServiceScene(FlowDoraWifiScene.OTHER, 13);
            OTHER = r107;
            f383769a = new LynxServiceScene[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
        }

        public static LynxServiceScene[] values() {
            return (LynxServiceScene[]) f383769a.clone();
        }

        public static LynxServiceScene valueOf(String r100) {
            return (LynxServiceScene) a.a(LynxServiceScene.class, r100);
        }

        public LynxServiceScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LynxResourceServiceRequestParams() {
        LynxServiceScene r100 = LynxServiceScene.LYNX_TEMPLATE;
    }
}
