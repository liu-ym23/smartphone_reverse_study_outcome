package com.ss.android.lark.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes38.dex */
public class GLAnimationView extends GLSurfaceView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f445618b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f445619a;

    public static class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final float[] f445620i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final float[] f445621j = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f445622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatBuffer f445623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FloatBuffer f445624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ShortBuffer f445625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f445626e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f445627f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final short[] f445628g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f445629h;

        static {
            f445620i = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            f445621j = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        }

        public a(int r100) {
            short[] r101 = {0, 1, 2, 0, 2, 3};
            this.f445628g = r101;
            this.f445629h = r100;
            ByteBuffer r102 = ByteBuffer.allocateDirect(32);
            r102.order(ByteOrder.nativeOrder());
            FloatBuffer r103 = r102.asFloatBuffer();
            this.f445623b = r103;
            r103.put(f445620i);
            r103.position(0);
            ByteBuffer r104 = ByteBuffer.allocateDirect(12);
            r104.order(ByteOrder.nativeOrder());
            ShortBuffer r105 = r104.asShortBuffer();
            this.f445625d = r105;
            r105.put(r101);
            r105.position(0);
            ByteBuffer r106 = ByteBuffer.allocateDirect(32);
            r106.order(ByteOrder.nativeOrder());
            FloatBuffer r107 = r106.asFloatBuffer();
            this.f445624c = r107;
            r107.put(f445621j);
            r107.position(0);
            int r108 = GLES20.glCreateShader(35633);
            GLES20.glShaderSource(r108, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}");
            GLES20.glCompileShader(r108);
            int r109 = GLES20.glCreateShader(35632);
            GLES20.glShaderSource(r109, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}");
            GLES20.glCompileShader(r109);
            int r110 = GLES20.glCreateProgram();
            this.f445622a = r110;
            GLES20.glAttachShader(r110, r108);
            GLES20.glAttachShader(r110, r109);
            GLES20.glLinkProgram(r110);
        }
    }

    public class b implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f445630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f445631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Surface f445632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f445633d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f445634e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final GLAnimationView f445635f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public SurfaceTexture f445636g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Paint f445637h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f445638i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f445639j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ GLAnimationView f445640k;

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 r100) {
            Canvas r101 = this.f445632c.lockCanvas(null);
            this.f445635f.getClass();
            r101.drawARGB(255, Color.red(this.f445640k.f445619a), Color.green(this.f445640k.f445619a), Color.blue(this.f445640k.f445619a));
            this.f445637h.setAlpha(255);
            r101.drawText(this.f445638i, (this.f445633d - this.f445639j) / 2.0f, this.f445634e / 2, this.f445637h);
            this.f445632c.unlockCanvasAndPost(r101);
            this.f445632c.release();
            this.f445632c = null;
            this.f445632c = new Surface(this.f445636g);
            this.f445636g.updateTexImage();
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            a r102 = this.f445631b;
            GLES20.glUseProgram(r102.f445622a);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, r102.f445629h);
            int r103 = GLES20.glGetAttribLocation(r102.f445622a, "vPosition");
            r102.f445626e = r103;
            GLES20.glEnableVertexAttribArray(r103);
            r102.f445623b.clear();
            r102.f445623b.put(a.f445620i);
            r102.f445623b.position(0);
            GLES20.glVertexAttribPointer(r102.f445626e, 2, 5126, false, 8, r102.f445623b);
            int r104 = GLES20.glGetAttribLocation(r102.f445622a, "inputTextureCoordinate");
            r102.f445627f = r104;
            GLES20.glEnableVertexAttribArray(r104);
            GLES20.glVertexAttribPointer(r102.f445627f, 2, 5126, false, 8, r102.f445624c);
            GLES20.glDrawElements(4, r102.f445628g.length, 5123, r102.f445625d);
            GLES20.glDisableVertexAttribArray(r102.f445626e);
            GLES20.glDisableVertexAttribArray(r102.f445627f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 r110, EGLConfig r111) {
            this.f445632c = null;
            this.f445636g = null;
            this.f445633d = this.f445635f.getWidth();
            int r100 = this.f445635f.getHeight();
            this.f445634e = r100;
            int r101 = this.f445633d;
            int[] r112 = new int[1];
            GLES20.glGenTextures(1, r112, 0);
            int r113 = r112[0];
            this.f445630a = r113;
            if (r113 <= 0) goto L5;
            GLES20.glBindTexture(36197, r113);
            GLES20.glTexImage2D(3553, 0, 6407, r101, r100, 0, 6407, 5121, null);
            GLES20.glTexParameteri(36197, 10241, 9728);
            GLES20.glTexParameteri(36197, 10240, 9728);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
        L5:
            int r114 = this.f445630a;
            this.f445630a = r114;
            if (r114 <= 0) goto L9;
            SurfaceTexture r115 = new SurfaceTexture(this.f445630a);
            this.f445636g = r115;
            r115.setDefaultBufferSize(this.f445633d, this.f445634e);
            this.f445632c = new Surface(this.f445636g);
            this.f445631b = new a(this.f445630a);
            return;
        }

        public b(GLAnimationView r100, Context r101, GLAnimationView r102) {
            this.f445640k = r100;
            this.f445636g = null;
            this.f445635f = r102;
            Paint r103 = new Paint();
            this.f445637h = r103;
            int r104 = GLAnimationView.f445618b;
            Resources r105 = r101.getResources();
            r103.setTextSize((int) ((15.0f * WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).scaledDensity) + 0.5f));
            r103.setAntiAlias(true);
            r103.setColor(ContextCompat.getColor(r101, R.color.text_placeholder));
            String r106 = r101.getResources().getString(R.string.Lark_Legacy_LoadingTip);
            this.f445638i = r106;
            this.f445639j = r103.measureText(r106);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
            r100.glViewport(0, 0, r101, r102);
        }
    }

    public final void a() {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-2);
        setZOrderOnTop(true);
        setRenderer(new b(this, getContext(), this));
        setRenderMode(0);
    }

    public GLAnimationView(Context r100) {
        super(r100);
        this.f445619a = 16777215;
        a();
    }

    public void setColor(int r100) {
        this.f445619a = r100;
    }

    public GLAnimationView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445619a = 16777215;
        a();
    }
}
