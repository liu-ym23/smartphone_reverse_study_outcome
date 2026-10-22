package vqc;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f556791b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f556792c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f556793a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f556794a;

        public a(InputStream r100) {
            this.f556794a = r100;
        }
    }

    static {
        f556791b = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
        f556792c = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public final int a() throws IOException {
        a r100 = this.f556793a;
        int r101 = 65280;
        short r102 = 255;
        int r103 = (r100.f556794a.read() & 255) | ((r100.f556794a.read() << 8) & 65280);
        if ((r103 & 65496) == 65496) goto L8;
        if (r103 == 19789) goto L8;
        if (r103 == 18761) goto L8;
        boolean r104 = false;
    L10:
        if (r104 == true) goto L16;
        if (Log.isLoggable("ImageHeaderParser", 3) == true) goto L14;
    L14:
        return -1;
    L16:
        if (((short) (this.f556793a.f556794a.read() & r102)) != r102) goto L18;
        short r105 = (short) (this.f556793a.f556794a.read() & r102);
        if (r105 == 218) goto L48;
        if (r105 == 217) goto L48;
        a r110 = this.f556793a;
        int r111 = ((r110.f556794a.read() & r102) | ((r110.f556794a.read() << 8) & r101)) - 2;
        if (r105 == 225) goto L50;
        a r106 = this.f556793a;
        long r112 = r111;
        r106.getClass();
        long r113 = 0;
        if (r112 < 0) goto L44;
        long r107 = r112;
    L33:
        if (r107 <= 0) goto L42;
        long r114 = r106.f556794a.skip(r107);
        if (r114 > 0) goto L41;
        if (r106.f556794a.read() == (-1)) goto L42;
        r114 = 1;
    L41:
        r107 = r107 - r114;
    L42:
        r113 = r112 - r107;
    L44:
        if (r113 != r112) goto L46;
        r101 = 65280;
        r102 = 255;
        goto L16
    L46:
        if (Log.isLoggable("ImageHeaderParser", 3) == false) goto L48;
    L50:
        if (r111 != (-1)) goto L52;
        return -1;
    L52:
        byte[] r108 = new byte[r111];
        a r109 = this.f556793a;
        int r115 = r111;
    L53:
        if (r115 <= 0) goto L57;
        int r116 = r109.f556794a.read(r108, r111 - r115, r115);
        if (r116 == (-1)) goto L59;
        r115 = r115 - r116;
    L59:
        if ((r111 - r115) == r111) goto L64;
        if (Log.isLoggable("ImageHeaderParser", 3) == true) goto L151;
        return -1;
    L151:
        return -1;
    L64:
        if (r111 <= f556791b.length) goto L66;
        boolean r117 = true;
    L67:
        if (r117 == false) goto L75;
        int r118 = 0;
    L69:
        byte[] r119 = f556791b;
        if (r118 >= r119.length) goto L75;
        if (r108[r118] != r119[r118]) goto L73;
        r118 = r118 + 1;
        goto L69
    L73:
        r117 = false;
    L75:
        if (r117 == false) goto L152;
        ByteBuffer r120 = ByteBuffer.wrap(r108);
        ByteOrder r121 = ByteOrder.BIG_ENDIAN;
        ByteBuffer r122 = (ByteBuffer) r120.order(r121).limit(r111);
        short r123 = r122.getShort(6);
        if (r123 == 19789) goto L84;
        if (r123 != 18761) goto L82;
        r121 = ByteOrder.LITTLE_ENDIAN;
        goto L84
    L82:
        if (Log.isLoggable("ImageHeaderParser", 3) == true) goto L84;
    L84:
        r122.order(r121);
        int r124 = r122.getInt(10) + 6;
        short r125 = r122.getShort(r124);
        int r126 = 0;
    L85:
        if (r126 >= r125) goto L154;
        int r127 = (r124 + 2) + (r126 * 12);
        if (r122.getShort(r127) != 274) goto L124;
        short r128 = r122.getShort(r127 + 2);
        if (r128 < 1) goto L122;
        if (r128 > 12) goto L122;
        int r129 = r122.getInt(r127 + 4);
        if (r129 < 0) goto L124;
        if (Log.isLoggable("ImageHeaderParser", 3) == true) goto L100;
    L100:
        int r130 = r129 + f556792c[r128];
        if (r130 > 4) goto L103;
        int r131 = r127 + 8;
        if (r131 < 0) goto L119;
        if (r131 > r122.remaining()) goto L119;
        if (r130 < 0) goto L116;
        if ((r130 + r131) > r122.remaining()) goto L116;
        return r122.getShort(r131);
    L116:
        if (Log.isLoggable("ImageHeaderParser", 3) == false) goto L124;
    L119:
        if (Log.isLoggable("ImageHeaderParser", 3) == false) goto L124;
        goto L124
    L103:
        if (Log.isLoggable("ImageHeaderParser", 3) == false) goto L124;
    L122:
        if (Log.isLoggable("ImageHeaderParser", 3) == true) goto L124;
    L124:
        r126 = r126 + 1;
        goto L85
    L154:
        return -1;
    L152:
        return -1;
    L66:
        r117 = false;
        goto L67
    L57:
        r109.getClass();
    L48:
        r111 = -1;
        goto L50
    L18:
        if (Log.isLoggable("ImageHeaderParser", 3) == false) goto L48;
    L8:
        r104 = true;
        goto L10
    }

    public e(InputStream r100) {
        this.f556793a = new a(r100);
    }
}
