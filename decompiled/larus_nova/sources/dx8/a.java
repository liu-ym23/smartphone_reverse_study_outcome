package dx8;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    static {
    }

    public static String a(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L15
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L15
        byte[] r103 = new byte[8192];     // Catch: Throwable -> L15
    L17:
        int r104 = r102.read(r103);     // Catch: Throwable -> L12
        if (r104 <= 0) goto L7;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L12
        goto L17
    L7:
        byte[] r105 = r101.digest();     // Catch: Throwable -> L12
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L12
        int r107 = r105.length;     // Catch: Throwable -> L12
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L10;
        byte r109 = r105[r108];     // Catch: Throwable -> L12
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L12
        r106.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r109)}, 1)));     // Catch: Throwable -> L12
        r108 = r108 + 1;     // Catch: Throwable -> L12
        goto L8
    L10:
        String r111 = r106.toString();     // Catch: Throwable -> L12
        r102.close();     // Catch: Throwable -> L15
        return r111;
    L12:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        return null;
    }
}
