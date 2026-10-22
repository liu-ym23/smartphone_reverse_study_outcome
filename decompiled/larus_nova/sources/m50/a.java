package m50;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import k50.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f512062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f512063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f512064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f512065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f512066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f512067f;

    /* JADX INFO: renamed from: m50.a$a, reason: collision with other inner class name */
    public static final class C6772a {
    }

    static {
    }

    public final void a() {
        e r100 = this.f512062a;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        e r101 = this.f512064c;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        e r102 = this.f512063b;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        e r103 = this.f512065d;
        if (r103 == null) goto L14;
        r103.a();
    L14:
        c r104 = this.f512066e;
        if (r104 == null) goto L21;
        int r105 = r104.f512074g;
        if (r105 == 0) goto L20;
        r104.f512071d = ByteBuffer.allocateDirect(r105 * r104.f512070c).order(ByteOrder.nativeOrder()).asShortBuffer();
        return;
    L20:
        throw new RuntimeException("Cannot allocate zero-sized buffer.");
    }

    public final void d() {
        e r100 = this.f512062a;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        e r101 = this.f512064c;
        if (r101 == null) goto L8;
        r101.c();
    L8:
        e r102 = this.f512063b;
        if (r102 == null) goto L11;
        r102.c();
    L11:
        e r103 = this.f512065d;
        if (r103 == null) goto L14;
        r103.c();
    L14:
        c r104 = this.f512066e;
        if (r104 == null) goto L23;
        ShortBuffer r105 = r104.f512071d;
        if (r105 == null) goto L19;
        r105.put(r104.f512072e);
    L19:
        ShortBuffer r106 = r104.f512071d;
        if (r106 == null) goto L24;
        r106.position(0);
        return;
    L24:
        return;
    }

    public a() {
        this.f512067f = -1;
    }

    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        e r101 = this.f512062a;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        e r102 = this.f512064c;
        if (r102 == null) goto L8;
        r102.b();
    L8:
        e r103 = this.f512063b;
        if (r103 == null) goto L11;
        r103.b();
    L11:
        e r104 = this.f512065d;
        if (r104 == null) goto L14;
        r104.b();
    L14:
        c r105 = this.f512066e;
        if (r105 != null) goto L17;
    L28:
        this.f512067f = r100.f501811b;
        return;
    L17:
        if (r105.f512071d == null) goto L27;
        int[] r106 = new int[1];
        GLES20.glGenBuffers(1, r106, 0);
        int r107 = r106[0];
        r105.f512073f = r107;
        if (r107 >= 0) goto L21;
        int r108 = v50.b.f553230a;
        Intrinsics.checkNotNullParameter("Error creating index buffer object. Handle is " + r105.f512073f + '.', "message");
    L21:
        ShortBuffer r109 = r105.f512071d;
        if (r109 == null) goto L25;
        r109.position(0);
        GLES20.glBindBuffer(r105.f512068a, r105.f512073f);
        GLES20.glBufferData(r105.f512068a, r105.f512074g * r105.f512070c, r109, r105.f512069b);
        GLES20.glBindBuffer(r105.f512068a, 0);
        goto L28
    L25:
        throw new RuntimeException("Buffer is null");
    L27:
        throw new RuntimeException("Buffer is null");
    }

    public final void b(float[] r100, float[] r101, float[] r102, float[] r103, short[] r104) {
        Intrinsics.checkNotNullParameter(r100, "vertices");
        Intrinsics.checkNotNullParameter(r104, "indices");
        this.f512062a = new e(r100);
        if (r101 == null) goto L5;
        this.f512064c = new e(r101);
    L5:
        if (r102 == null) goto L7;
        this.f512063b = new e(r102);
    L7:
        if (r103 == null) goto L9;
        this.f512065d = new e(r103);
    L9:
        this.f512066e = new c(r104);
    }
}
