package ev7;

import com.google.archivepatcher.applier.PatchFormatException;
import com.google.archivepatcher.shared.PatchConstants$DeltaFormat;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public final class l {
    public static d c(InputStream r110) throws IOException {
        DataInputStream r100 = new DataInputStream(r110);
        long r101 = r100.readByte();
        b(r101, PatchConstants$DeltaFormat.BSDIFF.patchValue, PatchConstants$DeltaFormat.HDIFF.patchValue, "delta format");
        long r102 = r100.readLong();
        a(r102, "delta-friendly old file work range offset");
        long r103 = r100.readLong();
        a(r103, "delta-friendly old file work range length");
        long r104 = r100.readLong();
        a(r104, "delta-friendly new file work range offset");
        long r105 = r100.readLong();
        a(r105, "delta-friendly new file work range length");
        long r111 = r100.readLong();
        a(r111, "delta length");
        return new d(PatchConstants$DeltaFormat.fromPatchValue((byte) r101), new iv7.a(r102, r103), new iv7.a(r104, r105), r111);
    }

    public static void a(long r100, String r101) throws PatchFormatException {
        if (r100 < 0) goto L6;
        return;
    L6:
        throw new PatchFormatException("Bad value for " + r101 + ": " + r100);
    }

    public static void b(long r100, long r101, long r102, String r103) throws PatchFormatException {
        if (r100 < r101) goto L8;
        if (r100 > r102) goto L8;
        return;
    L8:
        throw new PatchFormatException("Bad value for " + r103 + ": " + r100 + " (valid range: [" + r101 + "," + r102 + "]");
    }
}
