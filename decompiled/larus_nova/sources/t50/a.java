package t50;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.bytedance.android.live.core.gl.primitive.RotationOrder;
import com.bytedance.android.live.core.gl.primitive.c;
import com.bytedance.android.live.core.gl.primitive.e;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import m50.d;
import n50.b;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends com.bytedance.android.live.core.gl.core.shader.a {
    @Override // com.bytedance.android.live.core.gl.core.shader.a
    public final void c() {
        String[] r100 = {"a_Position", "a_TexCoordinate"};
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f64813b = r100;
        Intrinsics.checkNotNullParameter("uniform mat4 u_MVPMatrix; \nattribute vec4 a_Position; \nattribute vec2 a_TexCoordinate; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   v_TexCoordinate = a_TexCoordinate; \n   gl_Position = u_MVPMatrix * a_Position; \n}", "<set-?>");
        this.f64814c = "uniform mat4 u_MVPMatrix; \nattribute vec4 a_Position; \nattribute vec2 a_TexCoordinate; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   v_TexCoordinate = a_TexCoordinate; \n   gl_Position = u_MVPMatrix * a_Position; \n}";
        Intrinsics.checkNotNullParameter("precision mediump float; \nuniform sampler2D u_Texture; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   gl_FragColor = texture2D(u_Texture, v_TexCoordinate);\n}", "<set-?>");
        this.f64815d = "precision mediump float; \nuniform sampler2D u_Texture; \nvarying vec2 v_TexCoordinate; \nvoid main() { \n   gl_FragColor = texture2D(u_Texture, v_TexCoordinate);\n}";
    }

    @Override // com.bytedance.android.live.core.gl.core.shader.a
    public final void e() {
        this.f64821j = GLES20.glGetUniformLocation(this.f64816e, "u_MVPMatrix");
        GLES20.glGetUniformLocation(this.f64816e, "u_Texture");
        this.f64819h = GLES20.glGetAttribLocation(this.f64816e, "a_Position");
        this.f64820i = GLES20.glGetAttribLocation(this.f64816e, "a_TexCoordinate");
    }

    public a() {
    }

    @Override // com.bytedance.android.live.core.gl.core.shader.a
    public final void d(f r210, d r211, b r212) {
        Intrinsics.checkNotNullParameter(r210, "rendererParams");
        Intrinsics.checkNotNullParameter(r211, "modelParams");
        Intrinsics.checkNotNullParameter(r212, "sceneParams");
        Intrinsics.checkNotNullParameter(r211, "modelParams");
        Intrinsics.checkNotNullParameter(r212, "sceneParams");
        float[] r100 = this.f64822k;
        float[] r101 = r212.f517991a.f64801c;
        com.bytedance.android.live.core.gl.primitive.d r102 = r211.f512077c;
        e r103 = r102.f64835a;
        if (r103.f64844d == false) goto L5;
        r103.f64844d = false;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L19;
        e r105 = r102.f64836b;
        if (r105.f64844d == false) goto L10;
        r105.f64844d = false;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L19;
        e r107 = r102.f64837c;
        if (r107.f64844d == false) goto L15;
        r107.f64844d = false;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L19;
        boolean r109 = false;
    L20:
        if (r109 == false) goto L31;
        Matrix.setIdentityM(r102.f64839e, 0);
        float[] r110 = r102.f64839e;
        e r111 = r102.f64835a;
        Matrix.translateM(r110, 0, r111.f64841a, r111.f64842b, r111.f64843c);
        RotationOrder r112 = r102.f64838d;
        switch(c.f64834b[r112.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            default: goto L30;
        };
    L24:
        r102.c();
        r102.b();
        r102.a();
        goto L30
    L25:
        r102.c();
        r102.a();
        r102.b();
        goto L30
    L26:
        r102.b();
        r102.c();
        r102.a();
        goto L30
    L27:
        r102.b();
        r102.a();
        r102.c();
        goto L30
    L28:
        r102.a();
        r102.c();
        r102.b();
        goto L30
    L29:
        r102.a();
        r102.b();
        r102.c();
    L30:
        float[] r113 = r102.f64839e;
        e r114 = r102.f64837c;
        Matrix.scaleM(r113, 0, r114.f64841a, r114.f64842b, r114.f64843c);
    L31:
        Matrix.multiplyMM(r100, 0, r101, 0, r102.f64839e, 0);
        float[] r115 = this.f64822k;
        Matrix.multiplyMM(r115, 0, r212.f517991a.f64800b, 0, r115, 0);
        GLES20.glUniformMatrix4fv(this.f64821j, 1, false, this.f64822k, 0);
        return;
    L15:
        r108 = false;
        goto L16
    L10:
        r106 = false;
    L19:
        r103.f64844d = false;
        r102.f64836b.f64844d = false;
        r102.f64837c.f64844d = false;
        r109 = true;
        goto L20
    L5:
        r104 = false;
        goto L6
    }
}
