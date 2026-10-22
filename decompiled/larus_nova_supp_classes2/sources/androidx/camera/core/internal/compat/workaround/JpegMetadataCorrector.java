package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class JpegMetadataCorrector {
    private final IncorrectJpegMetadataQuirk mQuirk;

    public boolean needCorrectJpegMetadata() {
        if (this.mQuirk == null) goto L5;
        return true;
    L5:
        return false;
    }

    public JpegMetadataCorrector(Quirks r2) {
        this.mQuirk = (IncorrectJpegMetadataQuirk) r2.get(IncorrectJpegMetadataQuirk.class);
    }

    public byte[] jpegImageToJpegByteArray(ImageProxy r2) {
        IncorrectJpegMetadataQuirk r0 = this.mQuirk;
        if (r0 != null) goto L7;
        ByteBuffer r3 = r2.getPlanes()[0].getBuffer();
        byte[] r1 = new byte[r3.capacity()];
        r3.rewind();
        r3.get(r1);
        return r1;
    L7:
        return r0.jpegImageToJpegByteArray(r2);
    }
}
