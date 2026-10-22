package com.bytedance.common.jato.boost;

import android.os.Process;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes15.dex */
public class NonMovingSpaceOpt {
    public NonMovingSpaceOpt() {
    }

    private static native void mprotectOptInternal(long r100, long r101);

    public static void mprotectOpt() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        String r100 = null;
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/maps"));     // Catch: IOException -> L21
        String r102 = null;
        boolean r103 = false;
    L37:
        String r104 = r101.readLine();     // Catch: IOException -> L19
        if (r104 == null) goto L17;
        if (r104.contains("dalvik-non moving space") == true) goto L12;
        if (r103 == false) goto L37;
    L12:
        String[] r105 = r104.split("\\s+")[0].split("-");     // Catch: IOException -> L19
        if (r103 == true) goto L15;
        r100 = r105[0];     // Catch: IOException -> L19
        r103 = true;
    L15:
        r102 = r105[1];     // Catch: IOException -> L19
    L17:
        r101.close();     // Catch: IOException -> L19
    L24:
        if (r100 == null) goto L46;
        if (r102 != null) goto L28;
        return;
    L28:
        if (r100.startsWith("0x") == false) goto L31;
        r100 = r100.substring(2);
    L31:
        if (r102.startsWith("0x") == false) goto L33;
        r102 = r102.substring(2);
    L33:
        ByteHook.init();
        mprotectOptInternal(CastLongProtector.parseLong(r100, 16), CastLongProtector.parseLong(r102, 16));
        return;
    L46:
        return;
    L19:
        e = e;
    L23:
        e.printStackTrace();
    L21:
        e = e;
        r102 = null;
        goto L23
    }

    static {
        JatoNativeLoader.loadLibrary();
    }
}
