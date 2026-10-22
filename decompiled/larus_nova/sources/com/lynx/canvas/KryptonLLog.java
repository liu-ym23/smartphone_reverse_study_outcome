package com.lynx.canvas;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonLLog {
    static final String KRYPTON_TAG = "[Krypton]";

    public KryptonLLog() {
    }

    public static void d(String r100, String r101) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r102 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().getValue().d(KRYPTON_TAG + r100, r101);
        goto L4
    }

    public static void e(String r100, String r101) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r102 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().getValue().e(KRYPTON_TAG + r100, r101);
        goto L4
    }

    public static void i(String r100, String r101) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r102 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().getValue().i(KRYPTON_TAG + r100, r101);
        goto L4
    }

    public static void v(String r100, String r101) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r102 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().getValue().v(KRYPTON_TAG + r100, r101);
        goto L4
    }

    public static void w(String r100, String r101) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> r102 = Krypton.inst().getLoggers().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().getValue().w(KRYPTON_TAG + r100, r101);
        goto L4
    }
}
