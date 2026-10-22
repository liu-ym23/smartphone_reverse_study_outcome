package fb0;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements fb0.c {
    public static final float[] A = null;
    public static final f B = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f476210z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ib0.d, Integer> f476211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ib0.d, Integer> f476212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f476213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f476214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f476215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f476216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f476217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f476218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f476219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f476220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f476221k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f476222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f476223m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ib0.d f476224n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public fb0.c.a f476225o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f476226p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b[] f476227q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b[] f476228r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f476229s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<i> f476230t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float[] f476231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f476232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f476233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f476234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f476235y;

    public static class a extends b {
        public a(String r100) {
            super(r100);
        }

        @Override // fb0.e.b
        public final void a(int r100) {
            this.f476236a = GLES20.glGetAttribLocation(r100, this.f476237b);
            String r101 = e.f476210z;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f476236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f476237b;

        public abstract void a(int r100);

        public b(String r100) {
            this.f476237b = r100;
        }
    }

    public static class c extends b {
        public c(String r100) {
            super(r100);
        }

        @Override // fb0.e.b
        public final void a(int r100) {
            this.f476236a = GLES20.glGetUniformLocation(r100, this.f476237b);
            String r101 = e.f476210z;
        }
    }

    static {
        f476210z = e.class.getSimpleName();
        A = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        B = new f();
    }

    public e() {
        new HashMap();
        this.f476211a = new HashMap();
        this.f476212b = new HashMap();
        this.f476213c = new float[128];
        this.f476214d = new float[8];
        new h();
        this.f476215e = true;
        this.f476216f = 0;
        this.f476217g = 0;
        this.f476220j = new float[16];
        this.f476223m = -1;
        this.f476226p = new float[4];
        b[] r100 = {new a("aPosition"), new c("uMatrix"), new c("uColor"), new a("aColor")};
        this.f476227q = new b[]{new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha"), new c("uEdgeFadeEffectEnable"), new c("uEdgeFadeEffectRegion")};
        this.f476228r = new b[]{new a("aPosition"), new c("uMatrix"), new c("uTextureMatrix"), new c("uTextureSampler"), new c("uAlpha")};
        b[] r101 = {new a("aPosition"), new c("uMatrix"), new a("aTextureCoordinate"), new c("uTextureSampler"), new c("uAlpha")};
        this.f476229s = new h();
        ArrayList<i> r102 = new ArrayList();
        this.f476230t = r102;
        this.f476231u = new float[32];
        this.f476232v = new RectF();
        this.f476233w = new RectF();
        float[] r103 = new float[16];
        this.f476234x = r103;
        int[] r104 = new int[1];
        this.f476235y = r104;
        Matrix.setIdentityM(r103, 0);
        Matrix.setIdentityM(this.f476213c, this.f476217g);
        this.f476214d[this.f476216f] = 1.0f;
        r102.add(null);
        a(b(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n}\n"), b(35632, "precision mediump float;\nuniform vec4 uColor;\nvoid main() {\n  gl_FragColor = uColor;\n}\n"), r100, r104);
        a(b(35633, "uniform mat4 uMatrix;\nattribute vec2 aPosition;\nattribute vec2 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = aTextureCoordinate;\n}\n"), b(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float uAlpha;\nuniform sampler2D uTextureSampler;\nuniform int uEdgeFadeEffectEnable;\nuniform vec4 uEdgeFadeEffectRegion;\nvoid main() {\n  gl_FragColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor *= uAlpha;\n  if (uEdgeFadeEffectEnable>0) {\n     float leftEdge = uEdgeFadeEffectRegion[0];\n     float topEdge = uEdgeFadeEffectRegion[1];\n     float rightEdge = uEdgeFadeEffectRegion[2];\n     float bottomEdge = uEdgeFadeEffectRegion[3];\n     if(leftEdge > 0.0 && gl_FragCoord.x < leftEdge) {} \n     if(topEdge > 0.0 && gl_FragCoord.y > topEdge) {}\n     if(rightEdge > 0.0 && gl_FragCoord.x > rightEdge) {}\n     if(bottomEdge > 0.0 && gl_FragCoord.y < bottomEdge) {\n        float percent = 1.0 - (bottomEdge - gl_FragCoord.y)/bottomEdge;\n        gl_FragColor *= percent;\n     }\n   }\n}\n"), r101, r104);
        GLES20.glBlendFunc(1, 771);
    }

    public final void d(fb0.a r100) {
        int r101 = r100.b();
        GLES20.glBindTexture(r101, r100.f476201a);
        GLES20.glTexParameteri(r101, 10242, 33071);
        GLES20.glTexParameteri(r101, 10243, 33071);
        GLES20.glTexParameterf(r101, 10241, 9729.0f);
        GLES20.glTexParameterf(r101, 10240, 9729.0f);
    }

    public static int b(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        return r102;
    }

    public final void c(int r110, int r111) {
        this.f476218h = r110;
        this.f476219i = r111;
        Matrix.setIdentityM(this.f476213c, this.f476217g);
        float r100 = r110;
        float r112 = r111;
        Matrix.orthoM(this.f476220j, 0, 0.0f, r100, 0.0f, r112, -1.0f, 1.0f);
        ArrayList<i> r113 = this.f476230t;
        if (((i) ListProtector.get(r113, r113.size() - 1)) != null) goto L6;
        Matrix.translateM(this.f476213c, this.f476217g, 0.0f, r112, 0.0f);
        Matrix.scaleM(this.f476213c, this.f476217g, 1.0f, -1.0f, 1.0f);
        return;
    }

    public static int a(int r100, int r101, b[] r102, int[] r103) {
        int r104 = GLES20.glCreateProgram();
        if (r104 != 0) goto L5;
        ALogger.e(f476210z, "Cannot create GL program");
    L5:
        GLES20.glAttachShader(r104, r100);
        GLES20.glAttachShader(r104, r101);
        GLES20.glLinkProgram(r104);
        int r105 = 0;
        GLES20.glGetProgramiv(r104, 35714, r103, 0);
        if (r103[0] == 1) goto L9;
        GLES20.glGetProgramInfoLog(r104);
        GLES20.glDeleteProgram(r104);
        r104 = 0;
    L9:
        if (r105 >= r102.length) goto L11;
        r102[r105].a(r104);
        r105 = r105 + 1;
        goto L9
    L11:
        return r104;
    }

    public final void e(fb0.a r100, int r101, int r110, Bitmap r111, int r112, int r113) {
        int r102 = r100.b();
        GLES20.glBindTexture(r102, r100.f476201a);
        GLUtils.texSubImage2D(r102, 0, r101, r110, r111, r112, r113);
    }
}
