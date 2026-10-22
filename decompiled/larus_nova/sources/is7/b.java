package is7;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f495625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f495626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f495627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f495628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ByteBuffer f495629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f495630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f495631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f495632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f495633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f495634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f495635k;

    public final String toString() {
        return "CameraData{, mColorWidth=" + this.f495626b + ", mColorHeight=" + this.f495627c + ", mColorFrameMode=" + this.f495628d + ", mDepthWidth=" + this.f495630f + ", mDepthHeight=" + this.f495631g + ", mPreviewWidth=" + this.f495632h + ", mPreviewHeight=" + this.f495633i + ", mMirror=" + this.f495635k + '}';
    }

    public b() {
    }

    public b(ByteBuffer r100, int r101, int r102, int r103, int r104) {
        this.f495625a = r100;
        this.f495626b = r101;
        this.f495627c = r102;
        this.f495628d = 0;
        this.f495629e = null;
        this.f495630f = 0;
        this.f495631g = 0;
        this.f495632h = r103;
        this.f495633i = r104;
        this.f495635k = false;
    }
}
