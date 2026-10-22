package com.bytedance.mira.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes21.dex */
public class ZipUtils {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    public static class CentralDirectory {
        long offset;
        long size;

        public CentralDirectory() {
        }
    }

    public ZipUtils() {
    }

    private static CentralDirectory findCentralDirectory(RandomAccessFile r100) throws IOException, ZipException {
        long r101 = r100.length() - 22;
        long r102 = 0;
        if (r101 < 0) goto L19;
        long r103 = r101 - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (r103 < 0) goto L8;
        r102 = r103;
    L8:
        int r104 = Integer.reverseBytes(ENDSIG);
    L9:
        r100.seek(r101);
        if (r100.readInt() == r104) goto L11;
        r101 = r101 - 1;
        if (r101 >= r102) goto L9;
        throw new ZipException("End Of Central Directory signature not found");
    L11:
        r100.skipBytes(2);
        r100.skipBytes(2);
        r100.skipBytes(2);
        r100.skipBytes(2);
        CentralDirectory r105 = new CentralDirectory();
        r105.size = ((long) Integer.reverseBytes(r100.readInt())) & BodyPartID.bodyIdMax;
        r105.offset = ((long) Integer.reverseBytes(r100.readInt())) & BodyPartID.bodyIdMax;
        return r105;
    L19:
        throw new ZipException("File too short to be a zip file: " + r100.length());
    }

    public static long getZipCrc(File r100) throws IOException {
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");
        long r102 = computeCrcOfCentralDir(r101, findCentralDirectory(r101));     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();
        throw th;
    }

    private static long computeCrcOfCentralDir(RandomAccessFile r100, CentralDirectory r110) throws IOException {
        CRC32 r101 = new CRC32();
        long r102 = r110.size;
        r100.seek(r110.offset);
        int r111 = (int) Math.min(16384, r102);
        byte[] r103 = new byte[16384];
        int r112 = r100.read(r103, 0, r111);
    L4:
        if (r112 == (-1)) goto L10;
        r101.update(r103, 0, r112);
        r102 = r102 - ((long) r112);
        if (r102 == 0) goto L10;
        r112 = r100.read(r103, 0, (int) Math.min(16384, r102));
    L10:
        return r101.getValue();
    }
}
