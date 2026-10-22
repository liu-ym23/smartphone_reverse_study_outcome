package fgc;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import faceverify.q;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f476908a = 0;

    /* JADX INFO: renamed from: fgc.a$a, reason: collision with other inner class name */
    public static final class C5902a {
        public static byte[] a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            Intrinsics.checkNotNullParameter("SHA-256", q.KEY_ALGORITHM_CONFIG);
            MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L25
            PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L25
            DigestInputStream r103 = new DigestInputStream(r102, r101);     // Catch: Throwable -> L20
            byte[] r104 = new byte[65536];     // Catch: Throwable -> L15
        L8:
            if (r103.read(r104) != (-1)) goto L8;
            byte[] r105 = r101.digest();     // Catch: Throwable -> L15
        L12:
            CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L20
            CloseableKt.closeFinally(r102, null);     // Catch: Exception -> L25
            return r105;
        L15:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L20
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            CloseableKt.closeFinally(r102, th);     // Catch: Exception -> L25
            throw th;     // Catch: Exception -> L25
        L25:
            e = move-exception;
            throw new RuntimeException(Intrinsics.stringPlus("Failed to calculate hash for file: ", r100), e);
        }

        public static boolean b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "file1");
            Intrinsics.checkNotNullParameter(r101, "file2");
            Intrinsics.checkNotNullParameter("SHA-256", q.KEY_ALGORITHM_CONFIG);
            return Arrays.equals(a(r100), a(r101));
        }
    }

    static {
    }
}
