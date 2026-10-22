package ib0;

/* JADX INFO: loaded from: classes45.dex */
public class a implements d {
    public a() {
    }

    @Override // ib0.d
    public String a() {
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\nuniform int uEdgeFadeEffectEnable;\nuniform vec4 uEdgeFadeEffectRegion;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n  if (uEdgeFadeEffectEnable>0) {\n     float leftEdge = uEdgeFadeEffectRegion[0];\n     float topEdge = uEdgeFadeEffectRegion[1];\n     float rightEdge = uEdgeFadeEffectRegion[2];\n     float bottomEdge = uEdgeFadeEffectRegion[3];\n     if(leftEdge > 0.0 && gl_FragCoord.x < leftEdge) {} \n     if(topEdge > 0.0 && gl_FragCoord.y > topEdge) {}\n     if(rightEdge > 0.0 && gl_FragCoord.x > rightEdge) {}\n     if(bottomEdge > 0.0 && gl_FragCoord.y < bottomEdge) {\n        float percent = 1.0 - (bottomEdge - gl_FragCoord.y)/bottomEdge;\n        gl_FragColor *= percent;\n     }\n   }\n}\n";
    }

    @Override // ib0.d
    public void c(fb0.a r100) {
    }

    @Override // ib0.d
    public final void d() {
    }

    @Override // ib0.d
    public void destroy() {
    }

    @Override // ib0.d
    public void e(int r100) {
    }

    @Override // ib0.d
    public final String b() {
        return "#extension GL_OES_EGL_image_external : require\n" + a().replace("sampler2D", "samplerExternalOES");
    }
}
