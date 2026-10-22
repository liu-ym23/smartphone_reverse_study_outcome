package com.bytedance.common.jato.memory;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes15.dex */
public class StringUncompressionOpt {
    public StringUncompressionOpt() {
    }

    private static void ensureJNIMethodInited() {
        String r100 = new String("ab".getBytes());
        String r101 = new String("H".getBytes(), StandardCharsets.UTF_8);
        PrintStream r102 = System.out;
        r102.println("H" + r100 + r101 + "abcĩ");
    }

    private static native void nDeoptimizeString();
}
