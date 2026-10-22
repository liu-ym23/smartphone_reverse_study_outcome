package eb0;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import fb0.e;
import fb0.i;
import ib0.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Bitmap, fb0.a> f471783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fb0.c f471784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ib0.a f471785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f471786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f471787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f471788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f471789g;

    public b() {
        e r100 = new e();
        this.f471783a = new WeakHashMap();
        this.f471784b = r100;
        r100.f476225o = new a(this);
        this.f471785c = new ib0.a();
        this.f471786d = new float[4];
    }

    public final void a() {
        Iterator r100 = ((WeakHashMap) this.f471783a).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((fb0.a) r100.next()).e();
        goto L4
    L6:
        ((WeakHashMap) this.f471783a).clear();
    }

    public final void finalize() throws Throwable {
        super.finalize();
        a();
    }

    public final void b(Bitmap r210, int r211, int r212, d r213) {
        this.f471789g = r213;
        if (r210.isRecycled() == true) goto L86;
        if (r210.isPremultiplied() == true) goto L14;
        if (r210.getConfig() != Bitmap.Config.ARGB_8888) goto L14;
        if (r210.hasAlpha() == false) goto L14;
        throw new RuntimeException("Canvas: trying to use a non-premultiplied bitmap " + r210);
    L14:
        if (((WeakHashMap) this.f471783a).containsKey(r210) == false) goto L16;
        fb0.a r100 = (fb0.a) ((WeakHashMap) this.f471783a).get(r210);
    L18:
        if ((r213 instanceof ib0.c) == false) goto L23;
        ((ib0.c) r213).getClass();
        if ((r100 instanceof i) == false) goto L22;
        ((i) r100).getClass();
        r100 = null;
        goto L23
    L22:
        throw null;
    L23:
        r100.c();
        r213.c(r100);
        fb0.c r101 = this.f471784b;
        int r102 = r210.getWidth();
        int r103 = r210.getHeight();
        e r104 = (e) r101;
        r104.getClass();
        if (r102 <= 0) goto L89;
        if (r103 <= 0) goto L90;
        int r105 = r100.b();
        r104.f476224n = r213;
        if (r105 != 3553) goto L37;
        if (((HashMap) r104.f476211a).containsKey(r213) == false) goto L35;
        int r106 = ((Integer) ((HashMap) r104.f476211a).get(r213)).intValue();
        r104.f476221k = r106;
        e.b[] r107 = r104.f476227q;
        int r110 = 0;
    L33:
        if (r110 >= r107.length) goto L43;
        r107[r110].a(r106);
        r110 = r110 + 1;
    L43:
        RectF r108 = r104.f476232v;
        int r109 = r100.c();
        int r111 = r100.a();
        r100.getClass();
        r108.set(0, 0, r109, r111);
        r104.f476233w.set(r211, r212, r211 + r102, r103 + r212);
        RectF r112 = r104.f476232v;
        int r113 = r100.c();
        int r114 = r100.a();
        int r115 = r100.f476205e;
        int r116 = r100.f476206f;
        float r117 = r115;
        r112.left /= r117;
        float r118 = r112.right / r117;
        r112.right = r118;
        float r119 = r116;
        r112.top /= r119;
        float r120 = r112.bottom / r119;
        r112.bottom = r120;
        float r121 = r113 / r117;
        if (r118 <= r121) goto L46;
        r112.right = r121;
    L46:
        float r122 = r114 / r119;
        if (r120 <= r122) goto L49;
        r112.bottom = r122;
    L49:
        RectF r123 = r104.f476232v;
        RectF r124 = r104.f476233w;
        float r125 = r100.a() / r100.f476206f;
        float r126 = r100.c() / r100.f476205e;
        if (r123.right <= r126) goto L53;
        r124.right = r124.left + ((r124.width() * (r126 - r123.left)) / r123.width());
    L53:
        if (r123.bottom <= r125) goto L55;
        r124.bottom = r124.top + ((r124.height() * (r125 - r123.top)) / r123.height());
    L55:
        RectF r127 = r104.f476232v;
        RectF r128 = r104.f476233w;
        float[] r129 = r104.f476234x;
        r129[0] = r127.width();
        r129[5] = r127.height();
        r129[12] = r127.left;
        r129[13] = r127.top;
        float[] r130 = r104.f476234x;
        int[] r131 = new int[4];
        GLES20.glGetIntegerv(2978, r131, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glGetIntegerv(2978, r131, 0);
        GLES20.glViewport(0, 0, r104.f476218h, r104.f476219i);
        if (r104.f476223m != (-1)) goto L59;
        float[] r132 = e.A;
        FloatBuffer r133 = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r133.put(r132, 0, 20).position(0);
        GLES20.glGenBuffers(1, r104.f476235y, 0);
        int r134 = r104.f476235y[0];
        GLES20.glBindBuffer(34962, r134);
        GLES20.glBufferData(34962, r133.capacity() * 4, r133, 35044);
        r104.f476223m = r134;
    L59:
        if (r100.b() != 3553) goto L61;
        e.b[] r135 = r104.f476227q;
        int r136 = r104.f476221k;
    L62:
        GLES20.glUseProgram(r136);
        if (r100.isOpaque() == true) goto L65;
    L68:
        boolean r137 = true;
    L70:
        if (r137 == false) goto L72;
        GLES20.glEnable(3042);
    L73:
        GLES20.glActiveTexture(33984);
        r100.d(r104);
        GLES20.glBindTexture(r100.b(), r100.f476201a);
        GLES20.glUniform1i(r135[3].f476236a, 0);
        GLES20.glUniform1f(r135[4].f476236a, r104.f476214d[r104.f476216f]);
        GLES20.glUniform1i(r135[5].f476236a, 0);
        int r138 = r135[6].f476236a;
        float[] r139 = r104.f476226p;
        GLES20.glUniform4f(r138, r139[0], r139[1], r139[2], r139[3]);
        GLES20.glBindBuffer(34962, r104.f476223m);
        GLES20.glVertexAttribPointer(r135[0].f476236a, 2, 5126, false, 8, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glUniformMatrix4fv(r135[2].f476236a, 1, false, r130, 0);
        if (r104.f476225o != null) goto L76;
    L80:
        float r140 = r128.left;
        float r141 = r128.top;
        float r142 = r128.width();
        float r143 = r128.height();
        GLES20.glViewport(0, 0, r104.f476218h, r104.f476219i);
        Matrix.translateM(r104.f476231u, 0, r104.f476213c, r104.f476217g, r140, r141, 0.0f);
        Matrix.scaleM(r104.f476231u, 0, r142, r143, 1.0f);
        float[] r144 = r104.f476231u;
        Matrix.multiplyMM(r144, 16, r104.f476220j, 0, r144, 0);
        GLES20.glUniformMatrix4fv(r135[1].f476236a, 1, false, r104.f476231u, 16);
        int r145 = r135[0].f476236a;
        GLES20.glEnableVertexAttribArray(r145);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r145);
        if (r104.f476215e == false) goto L83;
        GLES20.glBindFramebuffer(36160, 0);
    L83:
        GLES20.glViewport(r131[0], r131[1], r131[2], r131[3]);
        return;
    L76:
        if (r100.b() != 3553) goto L78;
        int r146 = r104.f476221k;
    L79:
        r104.f476224n.e(r146);
        goto L80
    L78:
        r146 = r104.f476222l;
        goto L79
    L72:
        GLES20.glDisable(3042);
        goto L73
    L65:
        if (r104.f476214d[r104.f476216f] < 0.95f) goto L68;
        r137 = false;
        goto L70
    L61:
        r135 = r104.f476228r;
        r136 = r104.f476222l;
        goto L62
    L35:
        e.b[] r147 = r104.f476227q;
        r213.d();
        int r148 = e.a(e.b(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n"), e.b(35632, r213.a()), r147, r104.f476235y);
        r104.f476221k = r148;
        ((HashMap) r104.f476211a).put(r213, Integer.valueOf(r148));
        goto L43
    L37:
        if (((HashMap) r104.f476212b).containsKey(r213) == false) goto L42;
        int r149 = ((Integer) ((HashMap) r104.f476212b).get(r213)).intValue();
        r104.f476222l = r149;
        e.b[] r150 = r104.f476228r;
        int r151 = 0;
    L40:
        if (r151 >= r150.length) goto L43;
        r150[r151].a(r149);
        r151 = r151 + 1;
        goto L40
    L42:
        e.b[] r152 = r104.f476228r;
        r213.d();
        int r153 = e.a(e.b(35633, "uniform mat4 uMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec4 pos = vec4(aPosition, 0.0, 1.0);\n  gl_Position = uMatrix * pos;\n  vTextureCoord = (uTextureMatrix * pos).xy;\n}\n"), e.b(35632, r213.b()), r152, r104.f476235y);
        r104.f476222l = r153;
        ((HashMap) r104.f476212b).put(r213, Integer.valueOf(r153));
        goto L43
    L90:
        return;
    L89:
        return;
    L16:
        r100 = new fb0.b(r210);
        ((WeakHashMap) this.f471783a).put(r210, r100);
        goto L18
    L86:
        throw new RuntimeException("Canvas: trying to use a recycled bitmap " + r210);
    }
}
