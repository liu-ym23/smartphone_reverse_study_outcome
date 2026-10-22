package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes35.dex */
public final class f {
    static {
    }

    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r104 = r100[r103];
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r101.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r104)}, 1)));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    @JvmStatic
    public static final String b(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L12 Exception -> L14
        byte[] r103 = new byte[8];     // Catch: Throwable -> L8 Exception -> L10
        r102.read(r103);     // Catch: Throwable -> L8 Exception -> L10
        String r104 = a(r103);     // Catch: Throwable -> L8 Exception -> L10
        r102.close();
        return r104;
    L10:
        e = e;
        r101 = r102;
    L15:
        Log.e("Diskcache", "read file header failed", e);     // Catch: Throwable -> L12
        if (r101 == null) goto L29;
        r101.close();
        return "";
    L29:
        return "";
    L8:
        th = th;
    L21:
        if (r102 == null) goto L23;
        r102.close();
    L23:
        throw th;
    L14:
        e = e;
    L12:
        th = th;
        r102 = r101;
        goto L21
    }
}
