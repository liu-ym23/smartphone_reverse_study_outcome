package iu3;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static String a(String r100) throws Exception {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        BufferedReader r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L21
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L13
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r103));     // Catch: Throwable -> L17
    L29:
        String r106 = r105.readLine();     // Catch: Throwable -> L15
        if (r106 == null) goto L10;
        r104.append(r106);     // Catch: Throwable -> L15
        r104.append('\n');     // Catch: Throwable -> L15
        goto L29
    L10:
        r105.close();     // Catch: Throwable -> L13
        String r107 = r104.toString();     // Catch: Throwable -> L13
        r103.close();
        return r107;
    L15:
        th = move-exception;
        th = th;
        r102 = r105;
    L18:
        if (r102 == null) goto L20;
        r102.close();     // Catch: Throwable -> L13
    L20:
        throw th;     // Catch: Throwable -> L13
    L17:
        th = th;
    L13:
        Throwable th10 = th;
    L23:
        if (r103 == null) goto L25;
        r103.close();
    L25:
        throw th10;
    L21:
        th = move-exception;
        r103 = null;
        th10 = th;
        goto L23
    }
}
