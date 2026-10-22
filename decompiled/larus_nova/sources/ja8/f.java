package ja8;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {
    public static final void a(PolarisFileInputStreamWrapper r110, String r111) throws IOException {
        Intrinsics.checkNotNullParameter(r110, "in");
        Intrinsics.checkNotNullParameter(r111, "outputDir");
        PolarisFileWrapper r100 = new PolarisFileWrapper(r111);
        if (r100.exists() == true) goto L6;
        r100.mkdirs();
    L6:
        if (r110.available() <= 0) goto L41;
        byte[] r101 = new byte[3];
        if (r110.read(r101) != 3) goto L40;
        if (r101[0] != 16) goto L40;
        if (r101[1] != 13) goto L40;
        if (r101[2] != 10) goto L40;
        Intrinsics.checkNotNullParameter(r110, "in");
        int r102 = r110.read();
        int r103 = r110.read();
        if (r102 == (-1)) goto L38;
        if (r103 == (-1)) goto L38;
        byte[] r104 = new byte[(r102 << 8) | r103];
        r110.read(r104);
        String r105 = new String(r104, StandardCharsets.UTF_8);
        Intrinsics.checkNotNullParameter(r110, "in");
        int r106 = r110.read();
        int r107 = r110.read();
        int r108 = r110.read();
        int r109 = r110.read();
        if ((((r106 | r107) | r108) | r109) < 0) goto L36;
        int r112 = (((r106 << 24) | (r107 << 16)) | (r108 << 8)) | r109;
        PolarisFileOutputStreamWrapper r113 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100, r105));
        byte[] r114 = new byte[262144];     // Catch: Throwable -> L29
    L22:
        if (r112 <= 0) goto L28;
        int r115 = r110.read(r114, 0, (int) Math.min(262144, r112));     // Catch: Throwable -> L29
        if (r115 == (-1)) goto L27;
        r113.write(r114, 0, r115);     // Catch: Throwable -> L29
        r112 = r112 - r115;     // Catch: Throwable -> L29
        goto L22
    L27:
        throw new EOFException("Unexpected end of stream. Expected " + r112 + " more bytes");     // Catch: Throwable -> L29
    L28:
        r113.close();
    L29:
        th = move-exception;
        r113.close();     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        ExceptionsKt.addSuppressed(th, th);
        goto L34
    L36:
        throw new EOFException("eof exception or read failed");
    L38:
        throw new EOFException("eof exception or read failed");
    L40:
        throw new IOException("invalid file");
    }
}
