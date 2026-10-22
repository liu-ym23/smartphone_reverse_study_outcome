package hy5;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f487636a;

    public static String a() {
        String r100 = f487636a;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100;
    L5:
        String r101 = null;
        BufferedReader r102 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L13
    L8:
        int r104 = r102.read();     // Catch: Throwable -> L13
        if (r104 <= 0) goto L11;
        r103.append((char) r104);     // Catch: Throwable -> L13
        goto L8
    L11:
        r101 = r103.toString();     // Catch: Throwable -> L13
    L24:
        r102.close();     // Catch: Exception -> L19
    L17:
        f487636a = r101;
        return r101;
    L15:
        if (r102 == null) goto L17;
    L14:
        r102 = null;
        goto L15
    }
}
