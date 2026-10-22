package m17;

import java.io.InvalidObjectException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f511607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f511608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f511609c;

    public static a a(byte[] r100) throws InvalidObjectException {
        ByteBuffer r101 = ByteBuffer.wrap(r100);
        r101.order(ByteOrder.BIG_ENDIAN);
        short r102 = r101.getShort();
        short r103 = r101.getShort();
        int r104 = r101.getInt();
        byte[] r105 = Arrays.copyOfRange(r100, r101.position(), r100.length);
        CRC32 r106 = new CRC32();
        r106.update(r105);
        long r107 = r106.getValue();
        if (((short) ((r107 >> 16) ^ (65535 & r107))) != r102) goto L7;
        return new a(r105, r104, 1.0d / ((double) r103));
    L7:
        throw new InvalidObjectException("Bad checksum");
    }

    public a(byte[] r100, int r101, double r102) throws RuntimeException {
        if (r101 < 1) goto L23;
        if (1.0d <= r102) goto L23;
        if (r102 <= 1.0E-9d) goto L23;
        double r103 = -(Math.log(r102) / 0.480453013918201d);
        int r104 = (int) (((double) r101) * r103);
        this.f511607a = r104;
        int r105 = r104 / 8;
        if ((r104 % 8) == 0) goto L11;
        int r106 = 1;
    L12:
        int r107 = r105 + r106;
        if (r100 != null) goto L15;
        this.f511609c = new byte[r107];
    L20:
        this.f511608b = (int) Math.ceil(r103 * 0.693147180559945d);
        return;
    L15:
        if (r107 != r100.length) goto L18;
        this.f511609c = r100;
        goto L20
    L18:
        throw new RuntimeException(String.format("Expected %d bytes, got %d", new Object[]{Integer.valueOf(r107), Integer.valueOf(r100.length)}));
    L11:
        r106 = 0;
    L23:
        throw new RuntimeException("Invalid params for bloom filter");
    }
}
