package net.bytedance.zdplib;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public class DeltaSignerVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f518938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f518939b;

    private static native void free(long r100);

    private static native int generatePrivateKey(byte[] r100);

    private static native int getPublicKey(byte[] r100, long r101);

    private static native int getPublicKeyUncompressed(byte[] r100, long r101);

    private static native long initPrivateKey(byte[] r100);

    private static native int sign(byte[] r100, long r101, byte[] r102);

    private static native int verify(byte[] r100, byte[] r101, byte[] r102);

    static {
        Intrinsics.checkNotNullParameter("delta", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> delta");
        a.c("delta");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> delta");
    }

    public static String a() throws Exception {
        byte[] r100 = new byte[32];
        int r101 = generatePrivateKey(r100);
        if (r101 < 0) goto L7;
        return Delta.d(r100);
    L7:
        throw new Exception("GeneratePrivateKey  error " + r101);
    }

    public final String c() throws Exception {
        byte[] r100 = new byte[65];
        int r101 = getPublicKeyUncompressed(r100, this.f518938a);
        if (r101 != 0) goto L7;
        return Delta.d(r100);
    L7:
        throw new Exception("getPublicKey error " + r101);
    }

    public DeltaSignerVerifier(String r100) throws Exception {
        byte[] r101 = Delta.e(r100);
        if (r101.length != 32) goto L7;
        this.f518938a = initPrivateKey(r101);
        this.f518939b = r101;
        return;
    L7:
        throw new Exception("invalid private key :".concat(r100));
    }

    public final byte[] b(byte[] r100) throws Exception {
        byte[] r101 = new byte[72];
        int r102 = sign(r101, this.f518938a, r100);
        if (r102 < 0) goto L7;
        return Arrays.copyOfRange(r101, 0, r102);
    L7:
        throw new Exception(String.format("sign error ret=%d", new Object[]{Integer.valueOf(r102)}));
    }
}
