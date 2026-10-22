package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes22.dex */
public class JitCodeCacheMProtectOpt {
    private static final int SDK_INT = 0;

    public JitCodeCacheMProtectOpt() {
    }

    private static native void nStartPharse1(long r100, long r101);

    private static native void nStartPharse2();

    static {
        SDK_INT = Build.VERSION.SDK_INT;
    }

    public static void startPharse1(Context r110) {
        int r100 = SDK_INT;
        int r101 = 24;
        if (r100 >= 24) goto L5;
        return;
    L5:
        if (r100 <= 30) goto L7;
        return;
    L7:
        if (Process.is64Bit() == true) goto L9;
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r110) == false) goto L102;
        String r102 = null;
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/maps"));     // Catch: IOException -> L73
        String r104 = null;
        boolean r105 = false;
        int r106 = 0;
        boolean r107 = false;
    L84:
        String r108 = r103.readLine();     // Catch: IOException -> L71
        if (r108 == null) goto L66;
        int r111 = SDK_INT;     // Catch: IOException -> L71
        if (r111 < r101) goto L31;
        if (r111 > 25) goto L31;
        if (r108.contains("dalvik-jit-code-cache") == false) goto L47;
        String[] r109 = r108.split("\\s+")[0].split("-");     // Catch: IOException -> L71
        r102 = r109[0];     // Catch: IOException -> L71
        String r112 = r109[1];     // Catch: IOException -> L71
        if (r102.startsWith("0x") == false) goto L27;
        r102 = r102.substring(2);     // Catch: IOException -> L69
    L27:
        if (r112.startsWith("0x") == false) goto L67;
        r112 = r112.substring(2);     // Catch: IOException -> L69
    L67:
        r103.close();     // Catch: IOException -> L69
    L76:
        ByteHook.init();
        if (r102 == null) goto L103;
        if (r112 == null) goto L104;
        nStartPharse1(CastLongProtector.parseLong(r102, 16), CastLongProtector.parseLong(r112, 16));
        return;
    L104:
        return;
    L103:
        return;
    L69:
        e = e;
        r104 = r112;
    L75:
        e.printStackTrace();
        r112 = r104;
    L47:
        r101 = 24;
    L31:
        if (r111 >= 26) goto L33;
    L48:
        if (r105 == false) goto L53;
        r106 = r106 + 1;     // Catch: IOException -> L71
        if (r106 == 2) goto L66;
    L53:
        if (r108.contains("jit-cache") == false) goto L47;
        String[] r113 = r108.split("\\s+")[0].split("-");     // Catch: IOException -> L71
        r102 = r113[0];     // Catch: IOException -> L71
        r112 = r113[1];     // Catch: IOException -> L71
        if (r102.startsWith("0x") == false) goto L59;
        r102 = r102.substring(2);     // Catch: IOException -> L69
    L59:
        if (r112.startsWith("0x") == false) goto L61;
        r112 = r112.substring(2);     // Catch: IOException -> L69
    L61:
        r104 = r112;
        if (CastLongProtector.parseLong(r102, 16) <= BodyPartID.bodyIdMax) goto L47;
        CastLongProtector.parseLong(r102, 16);     // Catch: IOException -> L71
        r105 = true;
        goto L47
    L33:
        if (r111 > 28) goto L48;
        if (r108.contains("dalvik-jit-code-cache") == false) goto L45;
        String[] r114 = r108.split("\\s+")[0].split("-");     // Catch: IOException -> L71
        if (r107 == true) goto L42;
        r102 = r114[0];     // Catch: IOException -> L71
        if (r102.startsWith("0x") == false) goto L41;
        r102 = r102.substring(2);     // Catch: IOException -> L71
    L41:
        r107 = true;
    L42:
        r104 = r114[1];     // Catch: IOException -> L71
        if (r104.startsWith("0x") == false) goto L47;
        r104 = r104.substring(2);     // Catch: IOException -> L71
        goto L47
    L45:
        if (r107 == false) goto L47;
    L66:
        r112 = r104;
    L71:
        e = e;
    L73:
        e = e;
        r104 = null;
        goto L75
    }

    public static void startPharse2(Context r100) {
        int r101 = SDK_INT;
        if (r101 >= 24) goto L5;
        return;
    L5:
        if (r101 <= 30) goto L7;
        return;
    L7:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L12;
        nStartPharse2();
        return;
    }
}
