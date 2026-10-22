package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.processing.Packet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_JpegBytes2Disk_In extends JpegBytes2Disk.In {
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final Packet<byte[]> packet;

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.outputFileOptions.hashCode();
    }

    public String toString() {
        return "In{packet=" + this.packet + ", outputFileOptions=" + this.outputFileOptions + "}";
    }

    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.In
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.JpegBytes2Disk.In
    public Packet<byte[]> getPacket() {
        return this.packet;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof JpegBytes2Disk.In) == false) goto L14;
        JpegBytes2Disk.In r6 = (JpegBytes2Disk.In) r5;
        if (this.packet.equals(r6.getPacket()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.outputFileOptions.equals(r6.getOutputFileOptions()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_JpegBytes2Disk_In(Packet<byte[]> r1, ImageCapture.OutputFileOptions r2) {
        if (r1 == null) goto L11;
        this.packet = r1;
        if (r2 == null) goto L9;
        this.outputFileOptions = r2;
        return;
    L9:
        throw new NullPointerException("Null outputFileOptions");
    L11:
        throw new NullPointerException("Null packet");
    }
}
