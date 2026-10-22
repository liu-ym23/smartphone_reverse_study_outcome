package rja;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f538164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f538165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f538166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f538167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f538168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FloatBuffer f538169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f538170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f538171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f538172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f538173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f538174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f538175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f538176m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f538177n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f538178o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f538179p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SurfaceTexture f538180q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a.InterfaceC7494a f538181r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ScaleType f538182s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final tja.a f538183t;

    @Override // rja.a
    public final void onCompletion() {
        this.f538178o.compareAndSet(true, false);
        this.f538178o.get();
        this.f538183t.requestRender();
    }

    @Override // rja.a
    public final void onFirstFrame() {
        this.f538178o.compareAndSet(false, true);
        this.f538178o.get();
        this.f538183t.requestRender();
    }

    public static void a() {
        if (GLES20.glGetError() != 0) goto L5;
        return;
    }

    public b(tja.a r100) {
        Intrinsics.checkNotNullParameter(r100, "alphaVideoView");
        this.f538183t = r100;
        this.f538164a = 4;
        this.f538165b = 20;
        this.f538166c = 3;
        this.f538167d = 36197;
        this.f538168e = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f538170g = new float[16];
        float[] r101 = new float[16];
        this.f538171h = r101;
        this.f538178o = new AtomicBoolean(false);
        this.f538179p = new AtomicBoolean(false);
        this.f538182s = ScaleType.ScaleAspectFill;
        FloatBuffer r102 = ByteBuffer.allocateDirect(this.f538168e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f538169f = r102;
        r102.put(this.f538168e).position(0);
        Matrix.setIdentityM(r101, 0);
    }

    @Override // rja.a
    public final void f(a.InterfaceC7494a r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceListener");
        this.f538181r = r100;
    }

    @Override // rja.a
    public final void m(ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "scaleType");
        this.f538182s = r100;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m, android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r110) {
        Intrinsics.checkNotNullParameter(r110, "glUnused");
        if (this.f538179p.compareAndSet(true, false) == true) goto L21;
    L15:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.f538178o.get() == true) goto L19;
        GLES20.glFinish();
        return;
    L19:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.f538172i);
        a();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f538167d, this.f538173j);
        this.f538169f.position(0);
        GLES20.glVertexAttribPointer(this.f538176m, 3, 5126, false, this.f538165b, this.f538169f);
        a();
        GLES20.glEnableVertexAttribArray(this.f538176m);
        a();
        this.f538169f.position(this.f538166c);
        GLES20.glVertexAttribPointer(this.f538177n, 3, 5126, false, this.f538165b, this.f538169f);
        a();
        GLES20.glEnableVertexAttribArray(this.f538177n);
        a();
        Matrix.setIdentityM(this.f538170g, 0);
        GLES20.glUniformMatrix4fv(this.f538174k, 1, false, this.f538170g, 0);
        GLES20.glUniformMatrix4fv(this.f538175l, 1, false, this.f538171h, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a();
        GLES20.glFinish();
        return;
    L21:
        SurfaceTexture r111 = this.f538180q;     // Catch: Exception -> L9
        if (r111 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");     // Catch: Exception -> L9
    L7:
        r111.updateTexImage();     // Catch: Exception -> L9
    L11:
        SurfaceTexture r112 = this.f538180q;
        if (r112 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L14:
        r112.getTransformMatrix(this.f538171h);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        this.f538179p.compareAndSet(false, true);
        this.f538183t.requestRender();
    }

    public static int b(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        if (r102 == 0) goto L8;
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        int[] r103 = new int[1];
        GLES20.glGetShaderiv(r102, 35713, r103, 0);
        if (r103[0] != 0) goto L9;
        GLES20.glGetShaderInfoLog(r102);
        GLES20.glDeleteShader(r102);
        return 0;
    L9:
        return r102;
    L8:
        return r102;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m, android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "glUnused");
        Intrinsics.checkNotNullParameter(r101, "config");
        int r102 = b(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r102 == 0) goto L13;
        int r103 = b(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r103 != 0) goto L8;
        GLES20.glDeleteShader(r102);
        goto L13
    L8:
        int r104 = GLES20.glCreateProgram();
        if (r104 == 0) goto L14;
        GLES20.glAttachShader(r104, r102);
        a();
        GLES20.glAttachShader(r104, r103);
        a();
        GLES20.glLinkProgram(r104);
        int[] r105 = new int[1];
        GLES20.glGetProgramiv(r104, 35714, r105, 0);
        if (r105[0] == 1) goto L14;
        GLES20.glGetProgramInfoLog(r104);
        GLES20.glDeleteProgram(r104);
    L14:
        this.f538172i = r104;
        if (r104 != 0) goto L17;
        return;
    L17:
        this.f538176m = GLES20.glGetAttribLocation(r104, "aPosition");
        a();
        if (this.f538176m == (-1)) goto L43;
        this.f538177n = GLES20.glGetAttribLocation(this.f538172i, "aTextureCoord");
        a();
        if (this.f538177n == (-1)) goto L41;
        this.f538174k = GLES20.glGetUniformLocation(this.f538172i, "uMVPMatrix");
        a();
        if (this.f538174k == (-1)) goto L39;
        this.f538175l = GLES20.glGetUniformLocation(this.f538172i, "uSTMatrix");
        a();
        if (this.f538175l == (-1)) goto L37;
        int[] r106 = new int[1];
        GLES20.glGenTextures(1, r106, 0);
        int r107 = r106[0];
        this.f538173j = r107;
        GLES20.glBindTexture(this.f538167d, r107);
        a();
        GLES20.glTexParameterf(this.f538167d, 10241, 9728);
        GLES20.glTexParameterf(this.f538167d, 10240, 9729);
        SurfaceTexture r108 = new SurfaceTexture(this.f538173j);
        this.f538180q = r108;
        r108.setDefaultBufferSize(this.f538183t.getMeasuredWidth(), this.f538183t.getMeasuredHeight());
        SurfaceTexture r109 = this.f538180q;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L28:
        r109.setOnFrameAvailableListener(this);
        SurfaceTexture r110 = this.f538180q;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("surfaceTexture");
    L31:
        Surface r111 = new Surface(r110);
        a.InterfaceC7494a r112 = this.f538181r;
        if (r112 == null) goto L34;
        r112.a(r111);
    L34:
        this.f538179p.compareAndSet(true, false);
        return;
    L37:
        throw new RuntimeException("Could not get attrib location for uSTMatrix");
    L39:
        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    L41:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L43:
        throw new RuntimeException("Could not get attrib location for aPosition");
    L13:
        r104 = 0;
        goto L14
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m, android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "glUnused");
        GLES20.glViewport(0, 0, r101, r102);
    }

    @Override // rja.a
    public final void h(float r100, float r110, float r111, float r112) {
        float r101 = 0;
        if (r100 > r101) goto L5;
        return;
    L5:
        if (r110 > r101) goto L7;
        return;
    L7:
        if (r111 > r101) goto L9;
        return;
    L9:
        if (r112 <= r101) goto L36;
        ScaleType r102 = this.f538182s;
        float r103 = r100 / r110;
        float r113 = r111 / r112;
        float r114 = 0.0f;
        if (r103 <= r113) goto L14;
        float r104 = (1.0f - (r110 / (r100 / r113))) / 2.0f;
        float r105 = 0.0f;
    L16:
        switch(sja.a.C7622a.f542310a[r102.ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L17;
        };
    L17:
        float[] r106 = sja.a.a(0.0f, 0.0f, 0.0f, 0.0f);
    L31:
        this.f538168e = r106;
        FloatBuffer r107 = ByteBuffer.allocateDirect(r106.length * this.f538164a).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f538169f = r107;
        r107.put(this.f538168e).position(0);
        return;
    L18:
        r106 = sja.a.b(((1.0f - ((r110 * r113) / r100)) / 2.0f) * 2.0f, 0.0f, 0.0f, 0.0f);
        goto L31
    L19:
        r106 = sja.a.b(0.0f, 0.0f, ((1.0f - ((r110 * r113) / r100)) / 2.0f) * 2.0f, 0.0f);
        goto L31
    L20:
        r106 = sja.a.b(0.0f, ((1.0f - ((r100 / r113) / r110)) / 2.0f) * 2.0f, 0.0f, 0.0f);
        goto L31
    L21:
        r106 = sja.a.b(0.0f, 0.0f, 0.0f, ((1.0f - ((r100 / r113) / r110)) / 2.0f) * 2.0f);
        goto L31
    L22:
        r106 = sja.a.a(r105 * 2.0f, r104, 0.0f, r104);
        goto L31
    L23:
        r106 = sja.a.a(0.0f, r104, r105 * 2.0f, r104);
        goto L31
    L24:
        r106 = sja.a.a(r105, r104 * 2.0f, r105, 0.0f);
        goto L31
    L25:
        r106 = sja.a.a(r105, 0.0f, r105, r104 * 2.0f);
        goto L31
    L26:
        r106 = sja.a.a(r105, r104, r105, r104);
        goto L31
    L27:
        if (r103 <= r113) goto L29;
        r114 = (1.0f - ((r110 * r113) / r100)) / 2.0f;
        float r108 = 0.0f;
    L30:
        r106 = sja.a.b(r114, r108, r114, r108);
        goto L31
    L29:
        r108 = (1.0f - ((r100 / r113) / r110)) / 2.0f;
        goto L30
    L14:
        r105 = (1.0f - (r100 / (r110 * r113))) / 2.0f;
        r104 = 0.0f;
        goto L16
    }
}
