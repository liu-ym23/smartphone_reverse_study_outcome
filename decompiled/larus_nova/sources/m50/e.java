package m50;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f512078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f512079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f512080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FloatBuffer f512081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f512082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f512083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f512084g;

    public final void a() {
        int r100 = this.f512084g;
        if (r100 == 0) goto L7;
        this.f512081d = ByteBuffer.allocateDirect(r100 * this.f512080c).order(ByteOrder.nativeOrder()).asFloatBuffer();
        return;
    L7:
        throw new RuntimeException("Cannot allocate zero-sized buffer.");
    }

    public final void b() {
        if (this.f512081d == null) goto L14;
        int[] r100 = new int[1];
        GLES20.glGenBuffers(1, r100, 0);
        int r101 = r100[0];
        this.f512083f = r101;
        if (r101 >= 0) goto L7;
        int r102 = v50.b.f553230a;
        Intrinsics.checkNotNullParameter("Error creating buffer object. Handle is " + this.f512083f + '.', "message");
    L7:
        FloatBuffer r103 = this.f512081d;
        if (r103 == null) goto L12;
        r103.position(0);
        GLES20.glBindBuffer(this.f512078a, this.f512083f);
        GLES20.glBufferData(this.f512078a, this.f512084g * this.f512080c, r103, this.f512079b);
        GLES20.glBindBuffer(this.f512078a, 0);
        return;
    L12:
        throw new RuntimeException("Buffer is null");
    L14:
        throw new RuntimeException("Buffer is null");
    }

    public final void c() {
        FloatBuffer r100 = this.f512081d;
        if (r100 == null) goto L5;
        r100.put(this.f512082e);
    L5:
        FloatBuffer r101 = this.f512081d;
        if (r101 == null) goto L9;
        r101.position(0);
        return;
    }

    public e(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        this.f512078a = 34962;
        this.f512079b = 35044;
        this.f512080c = 4;
        this.f512083f = -1;
        this.f512084g = r100.length;
        this.f512082e = r100;
    }
}
