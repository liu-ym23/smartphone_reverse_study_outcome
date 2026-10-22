package nqc;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static void a(ByteBuffer r100) {
        if (r100.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static Pair<ByteBuffer, Long> b(RandomAccessFile r110, int r111) throws IOException {
        if (r111 < 0) goto L25;
        if (r111 > 65535) goto L25;
        long r100 = r110.length();
        if (r100 >= 22) goto L8;
        return null;
    L8:
        ByteBuffer r112 = ByteBuffer.allocate(((int) Math.min(r111, r100 - 22)) + 22);
        r112.order(ByteOrder.LITTLE_ENDIAN);
        long r101 = r100 - ((long) r112.capacity());
        r110.seek(r101);
        r110.readFully(r112.array(), r112.arrayOffset(), r112.capacity());
        a(r112);
        int r113 = r112.capacity();
        if (r113 < 22) goto L19;
        int r114 = r113 - 22;
        int r102 = Math.min(r114, 65535);
        int r103 = 0;
    L12:
        if (r103 > r102) goto L19;
        int r104 = r114 - r103;
        if (r112.getInt(r104) != 101010256) goto L18;
        if ((r112.getShort(r104 + 20) & 65535) != r103) goto L18;
    L20:
        if (r104 != (-1)) goto L22;
        return null;
    L22:
        r112.position(r104);
        ByteBuffer r115 = r112.slice();
        r115.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(r115, Long.valueOf(r101 + ((long) r104)));
    L18:
        r103 = r103 + 1;
    L19:
        r104 = -1;
    L25:
        throw new IllegalArgumentException("maxCommentSize: " + r111);
    }
}
