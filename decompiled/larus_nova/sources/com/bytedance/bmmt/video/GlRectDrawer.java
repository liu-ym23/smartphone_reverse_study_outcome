package com.bytedance.bmmt.video;

/* JADX INFO: loaded from: classes8.dex */
public class GlRectDrawer extends GlGenericDrawer {
    private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        private ShaderCallbacks() {
        }

        public /* synthetic */ ShaderCallbacks(int r100) {
            this();
        }

        @Override // com.bytedance.bmmt.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader r100) {
        }

        @Override // com.bytedance.bmmt.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader r100, float[] r101, int r102, int r103, int r104, int r105) {
        }
    }

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks(0));
    }
}
