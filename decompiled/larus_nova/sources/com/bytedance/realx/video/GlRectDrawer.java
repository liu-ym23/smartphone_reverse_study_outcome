package com.bytedance.realx.video;

/* JADX INFO: loaded from: classes21.dex */
public class GlRectDrawer extends GlGenericDrawer {
    private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    /* JADX INFO: renamed from: com.bytedance.realx.video.GlRectDrawer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private ShaderCallbacks() {
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader r100) {
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader r100, float[] r101, int r102, int r103, int r104, int r105) {
        }

        public /* synthetic */ ShaderCallbacks(AnonymousClass1 r100) {
            this();
        }
    }

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks(null));
    }
}
