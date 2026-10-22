package r50;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import k50.f;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m50.c;
import m50.d;
import m50.e;

/* JADX INFO: loaded from: classes45.dex */
public class a implements m50.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l50.b f536133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m50.a f536134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f536135c;

    public a() {
        m50.a r100 = new m50.a();
        d r101 = new d();
        Intrinsics.checkNotNullParameter(r100, "geometry");
        Intrinsics.checkNotNullParameter(r101, "modelParams");
        this.f536134b = r100;
        this.f536135c = r101;
    }

    @Override // m50.b
    public final void b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        this.f536134b.c(r100);
    }

    @Override // m50.b
    public final void a(f r210, n50.b r211) {
        Intrinsics.checkNotNullParameter(r210, "rendererParams");
        Intrinsics.checkNotNullParameter(r211, "sceneParams");
        m50.a r100 = this.f536134b;
        d r101 = this.f536135c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "rendererParams");
        Intrinsics.checkNotNullParameter(r101, "modelParams");
        Intrinsics.checkNotNullParameter(r211, "sceneParams");
        r101.getClass();
        GLES20.glEnable(2884);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        Pair<Integer, Integer> r102 = r210.f501812c;
        GLES20.glBlendFunc(r102.getFirst().intValue(), r102.getSecond().intValue());
        com.bytedance.android.live.core.gl.core.shader.b r103 = r210.f501810a.f501809b;
        int r104 = r101.f512076b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r210, "rendererParams");
        if (r103.f64825a.containsKey(Integer.valueOf(r104)) == true) goto L5;
        int r105 = v50.b.f553230a;
        Intrinsics.checkNotNullParameter("Shader " + r104 + " not found", "message");
    L5:
        com.bytedance.android.live.core.gl.core.shader.a r106 = r103.f64825a.get(Integer.valueOf(r104));
        if (r106 == null) goto L8;
        Intrinsics.checkNotNullParameter(r210, "rendererParams");
        r106.a(r210);
        GLES20.glUseProgram(r106.f64816e);
        r106.e();
    L8:
        l50.b r107 = this.f536133a;
        if (r107 == null) goto L11;
        r107.a(r210, this.f536135c, r211);
    L11:
        m50.a r108 = this.f536134b;
        d r109 = this.f536135c;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r210, "rendererParams");
        Intrinsics.checkNotNullParameter(r109, "modelParams");
        Intrinsics.checkNotNullParameter(r211, "sceneParams");
        r109.getClass();
        if (r210.f501815f == true) goto L14;
        com.bytedance.android.live.core.gl.core.shader.a r110 = r210.f501810a.f501809b.f64825a.get(Integer.valueOf(r109.f512076b));
        if (r110 == null) goto L71;
        r110.d(r210, r109, r211);
        e r111 = r108.f512062a;
        if (r111 == null) goto L69;
        FloatBuffer r112 = r111.f512081d;
        if (r112 == null) goto L46;
        r112.position(0);
    L46:
        GLES20.glEnableVertexAttribArray(r110.f64819h);
        GLES20.glVertexAttribPointer(r110.f64819h, 3, 5126, false, r111.f512080c * 3, r111.f512081d);
        if (r110.f64820i <= 0) goto L58;
        e r113 = r108.f512064c;
        if (r113 == null) goto L57;
        FloatBuffer r114 = r113.f512081d;
        if (r114 == null) goto L53;
        r114.position(0);
    L53:
        GLES20.glEnableVertexAttribArray(r110.f64820i);
        GLES20.glVertexAttribPointer(r110.f64820i, 2, 5126, false, r113.f512080c * 2, r113.f512081d);
        o50.b r115 = r210.f501810a.f501808a;
        int r116 = r109.f512075a;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r210, "rp");
        o50.a r117 = r115.f522033b.get(Integer.valueOf(r116));
        if (r117 == null) goto L59;
        r115.f522032a = r116;
        r117.a(r210);
    L59:
        c r118 = r108.f512066e;
        if (r118 == null) goto L67;
        ShortBuffer r119 = r118.f512071d;
        if (r119 == null) goto L64;
        r119.position(0);
    L64:
        GLES20.glDrawElements(4, r118.f512074g, 5123, r118.f512071d);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        return;
    L67:
        throw new RuntimeException("Index buffer is null");
    L57:
        throw new RuntimeException("Texture coord buffer is null");
    L58:
        r210.f501810a.f501808a.b();
        goto L59
    L69:
        throw new RuntimeException("Vertex buffer is null");
    L71:
        throw new RuntimeException("Shader " + r109.f512076b + " for  not found");
    L14:
        if (r108.f512067f == r210.f501811b) goto L16;
        r108.c(r210);
    L16:
        com.bytedance.android.live.core.gl.core.shader.a r120 = r210.f501810a.f501809b.f64825a.get(Integer.valueOf(r109.f512076b));
        if (r120 == null) goto L38;
        r120.d(r210, r109, r211);
        e r121 = r108.f512062a;
        if (r121 == null) goto L36;
        GLES20.glBindBuffer(r121.f512078a, r121.f512083f);
        GLES20.glVertexAttribPointer(r120.f64819h, 3, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(r120.f64819h);
        if (r120.f64820i <= 0) goto L29;
        e r122 = r108.f512064c;
        if (r122 == null) goto L28;
        GLES20.glBindBuffer(r122.f512078a, r122.f512083f);
        GLES20.glVertexAttribPointer(r120.f64820i, 2, 5126, false, 0, 0);
        GLES20.glEnableVertexAttribArray(r120.f64820i);
        o50.b r123 = r210.f501810a.f501808a;
        int r124 = r109.f512075a;
        r123.getClass();
        Intrinsics.checkNotNullParameter(r210, "rp");
        o50.a r125 = r123.f522033b.get(Integer.valueOf(r124));
        if (r125 == null) goto L30;
        r123.f522032a = r124;
        r125.a(r210);
    L30:
        c r126 = r108.f512066e;
        if (r126 == null) goto L34;
        GLES20.glBindBuffer(r126.f512068a, r126.f512073f);
        GLES20.glDrawElements(4, r126.f512074g, 5123, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        return;
    L34:
        throw new RuntimeException("Index buffer is null");
    L28:
        throw new RuntimeException("Texture coord  buffer is null");
    L29:
        r210.f501810a.f501808a.b();
        goto L30
    L36:
        throw new RuntimeException("Vertex buffer is null");
    L38:
        throw new RuntimeException("Shader " + r109.f512076b + " for  not found");
    }
}
