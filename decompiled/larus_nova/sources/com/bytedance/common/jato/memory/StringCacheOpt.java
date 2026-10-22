package com.bytedance.common.jato.memory;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes15.dex */
public class StringCacheOpt {
    public StringCacheOpt() {
    }

    private static native void doStringCache(boolean r100, String[] r101, String[] r102, String[] r103);

    private static void ensureJNIMethodInited() {
        String r100 = new String("ab");
        String r101 = new String("H".getBytes(), StandardCharsets.UTF_8);
        PrintStream r102 = System.out;
        r102.println("Init string jni funcs, content: b" + "H" + r101 + r100);
    }
}
