package u50;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import k50.f;
import kotlin.jvm.internal.Intrinsics;
import v50.b;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements o50.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f548758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f548759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f548760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f548761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f548762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f548763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bitmap f548764g;

    @Override // o50.a
    public final void unbind() {
        GLES20.glBindTexture(3553, 0);
    }

    @Override // o50.a
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        if (this.f548762e == r100.f501811b) goto L27;
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        if (this.f548762e == r100.f501811b) goto L27;
        Bitmap r101 = this.f548764g;
        if (r101 == null) goto L29;
    L14:
        if (r101 == null) goto L27;
        int[] r102 = new int[1];
        GLES20.glGenTextures(1, r102, 0);
        int r103 = r102[0];
        if (r103 == 0) goto L25;
        GLES20.glBindTexture(3553, r103);
        if (this.f548761d == false) goto L21;
        int r104 = 9985;
    L22:
        GLES20.glTexParameteri(3553, 10241, r104);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, r101, 0);
        if (this.f548761d == false) goto L26;
        GLES20.glGenerateMipmap(3553);
    L26:
        this.f548762e = r100.f501811b;
        r101.recycle();
        this.f548760c = r102[0];
        goto L27
    L21:
        r104 = 9729;
        goto L22
    L25:
        int r105 = b.f553230a;
        Intrinsics.checkNotNullParameter("BitmapTexture: textureHandle is 0!", "message");
        goto L26
    L29:
        Resources r106 = r100.getContext().getResources();     // Catch: Exception -> L12
        int r107 = this.f548759b;     // Catch: Exception -> L12
        int r108 = this.f548763f;     // Catch: Exception -> L12
        BitmapFactory.Options r109 = new BitmapFactory.Options();     // Catch: Exception -> L12
        r109.inSampleSize = r108;     // Catch: Exception -> L12
        r101 = BitmapFactory.decodeResource(r106, r107, r109);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        int r110 = b.f553230a;
        Intrinsics.checkNotNullParameter("Texture: Error creating bitmap " + this.f548758a, "message");
        e.printStackTrace();
        r101 = null;
    L27:
        GLES20.glBindTexture(3553, this.f548760c);
    }

    public a(Bitmap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f548764g = r100;
        this.f548759b = -1;
        this.f548761d = true;
        this.f548762e = -1;
        this.f548763f = 1;
        this.f548758a = r101;
        this.f548759b = 0;
    }
}
