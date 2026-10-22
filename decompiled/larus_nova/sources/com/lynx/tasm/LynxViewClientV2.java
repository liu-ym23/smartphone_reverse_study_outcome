package com.lynx.tasm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class LynxViewClientV2 implements y7a.a {

    public static class LynxPipelineInfo {

        public static final enum LynxPipelineOrigin extends Enum<LynxPipelineOrigin> {
            public static final LynxPipelineOrigin LYNX_FIRST_SCREEN = null;
            public static final LynxPipelineOrigin LYNX_RELOAD = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ LynxPipelineOrigin[] f381740a = null;
            private final int origin;

            static {
                LynxPipelineOrigin r100 = new LynxPipelineOrigin("LYNX_FIRST_SCREEN", 0, 1);
                LYNX_FIRST_SCREEN = r100;
                LynxPipelineOrigin r101 = new LynxPipelineOrigin("LYNX_RELOAD", 1, 2);
                LYNX_RELOAD = r101;
                f381740a = new LynxPipelineOrigin[]{r100, r101};
            }

            public static LynxPipelineOrigin[] values() {
                return (LynxPipelineOrigin[]) f381740a.clone();
            }

            public int getValue() {
                return this.origin;
            }

            public static LynxPipelineOrigin valueOf(String r100) {
                return (LynxPipelineOrigin) r27.a.a(LynxPipelineOrigin.class, r100);
            }

            public LynxPipelineOrigin(String r100, int r101, int r102) {
                super(r100, r101);
                this.origin = r102;
            }
        }

        public LynxPipelineInfo() {
        }
    }

    public static class a {
    }

    public LynxViewClientV2() {
    }

    public void a(JSONObject r100) {
    }

    public void b(LynxView r100, LynxPipelineInfo r101) {
    }

    public void c() {
    }

    @Override // y7a.a
    public void onPerformanceEvent(b8a.l r100) {
    }
}
