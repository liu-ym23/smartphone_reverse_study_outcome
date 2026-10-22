package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Bitmap2JpegBytes_In extends Bitmap2JpegBytes.In {
    private final int jpegQuality;
    private final Packet<Bitmap> packet;

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.jpegQuality;
    }

    public String toString() {
        return "In{packet=" + this.packet + ", jpegQuality=" + this.jpegQuality + "}";
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.In
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.Bitmap2JpegBytes.In
    public Packet<Bitmap> getPacket() {
        return this.packet;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Bitmap2JpegBytes.In) == false) goto L14;
        Bitmap2JpegBytes.In r6 = (Bitmap2JpegBytes.In) r5;
        if (this.packet.equals(r6.getPacket()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.jpegQuality != r6.getJpegQuality()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_Bitmap2JpegBytes_In(Packet<Bitmap> r1, int r2) {
        if (r1 == null) goto L7;
        this.packet = r1;
        this.jpegQuality = r2;
        return;
    L7:
        throw new NullPointerException("Null packet");
    }
}
