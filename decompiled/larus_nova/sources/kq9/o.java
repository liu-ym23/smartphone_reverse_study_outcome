package kq9;

import com.larus.platform.model.album.FastSendFromCameraScene;
import com.larus.platform.model.album.FastSendFromShowType;

/* JADX INFO: loaded from: classes31.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f505651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f505653c;

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f505651a == r101.f505651a) goto L12;
        return false;
    L12:
        if (this.f505652b == r101.f505652b) goto L15;
        return false;
    L15:
        if (this.f505653c == r101.f505653c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f505651a * 31) + this.f505652b) * 31) + this.f505653c;
    }

    public final String toString() {
        return "FastSendFromCameraAlbumThumbConfig(scene=" + this.f505651a + ", showType=" + this.f505652b + ", showCount=" + this.f505653c + ')';
    }

    public /* synthetic */ o(int r100) {
        this(FastSendFromCameraScene.DEFAULT.getScene(), FastSendFromShowType.EVERY_COLD_LAUNCH.getType(), 0);
    }

    public o(int r100, int r101, int r102) {
        this.f505651a = r100;
        this.f505652b = r101;
        this.f505653c = r102;
    }
}
