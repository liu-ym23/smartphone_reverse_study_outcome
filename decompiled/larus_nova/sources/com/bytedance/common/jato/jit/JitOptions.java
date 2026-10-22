package com.bytedance.common.jato.jit;

import com.bytedance.common.jato.JatoNativeLoader;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes15.dex */
public class JitOptions {
    public JitOptions() {
    }

    public static native void compilerOptionsSupport14();

    public static native long[] getCompileThreshold();

    public static native int getJitTaskCount();

    public static native void setCompileThreshold(int r100, int r101, int r102, int r103, int r104);

    private static native void setCompilerOptions(String[] r100);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void setCompilerOptionsDebugInfoExplicit(boolean r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == true) goto L6;
        r101.add("--no-generate-debug-info");
        r101.add("--no-generate-mini-debug-info");
    L6:
        if (r101.isEmpty() == false) goto L8;
        return;
    L8:
        String[] r102 = new String[r101.size()];
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L12;
        r102[r104] = (String) r103.next();
        r104 = r104 + 1;
        goto L10
    L12:
        setCompilerOptions(r102);
    }

    public static void setCompilerOptionsExplicit(int r100, boolean r101) {
        ArrayList r102 = new ArrayList();
        if (r100 < 0) goto L5;
        r102.add("--inline-max-code-units=" + r100);
    L5:
        if (r101 == true) goto L8;
        r102.add("--no-generate-debug-info");
        r102.add("--no-generate-mini-debug-info");
    L8:
        if (r102.isEmpty() == false) goto L10;
        return;
    L10:
        String[] r103 = new String[r102.size()];
        Iterator r104 = r102.iterator();
        int r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L14;
        r103[r105] = (String) r104.next();
        r105 = r105 + 1;
        goto L12
    L14:
        setCompilerOptions(r103);
    }
}
