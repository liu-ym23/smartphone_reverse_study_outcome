package com.bytedance.services.apm.api;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class EnsureManager {
    private static IEnsure sEnsure;

    public static void ensureNotReachHere() {
        IEnsure r100 = sEnsure;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.ensureNotReachHere();
    }

    private EnsureManager() {
    }

    public static IEnsure getEnsureImpl() {
        return sEnsure;
    }

    public static boolean ensureFalse(boolean r100) {
        IEnsure r101 = sEnsure;
        if (r101 != null) goto L5;
        return r100;
    L5:
        r101.ensureFalse(r100);
        return r100;
    }

    public static boolean ensureNotEmpty(Collection r100) {
        if (r100 != null) goto L4;
    L6:
        boolean r101 = false;
    L7:
        IEnsure r102 = sEnsure;
        if (r102 != null) goto L10;
        return r101;
    L10:
        r102.ensureNotEmpty(r100);
        return r101;
    L4:
        if (r100.isEmpty() == true) goto L6;
        r101 = true;
        goto L7
    }

    public static boolean ensureNotNull(Object r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        IEnsure r102 = sEnsure;
        if (r102 != null) goto L8;
        return r101;
    L8:
        r102.ensureNotNull(r100);
        return r101;
    L4:
        r101 = false;
        goto L5
    }

    public static void ensureNotReachHere(String r100) {
        IEnsure r101 = sEnsure;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.ensureNotReachHere(r100);
    }

    public static boolean ensureTrue(boolean r100) {
        IEnsure r101 = sEnsure;
        if (r101 != null) goto L5;
        return r100;
    L5:
        r101.ensureTrue(r100);
        return r100;
    }

    public static void setEnsureImpl(IEnsure r100) {
        sEnsure = r100;
    }

    public static void ensureNotReachHere(Throwable r100) {
        IEnsure r101 = sEnsure;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.ensureNotReachHere(r100);
    }

    public static boolean ensureFalse(boolean r100, String r101) {
        IEnsure r102 = sEnsure;
        if (r102 != null) goto L5;
        return r100;
    L5:
        r102.ensureFalse(r100, r101);
        return r100;
    }

    public static boolean ensureNotNull(Object r100, String r101) {
        if (r100 == null) goto L4;
        boolean r102 = true;
    L5:
        IEnsure r103 = sEnsure;
        if (r103 != null) goto L8;
        return r102;
    L8:
        r103.ensureNotNull(r100, r101);
        return r102;
    L4:
        r102 = false;
        goto L5
    }

    public static void ensureNotReachHere(String r100, Map<String, String> r101) {
        IEnsure r102 = sEnsure;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.ensureNotReachHere(r100, r101);
    }

    public static boolean ensureTrue(boolean r100, String r101) {
        IEnsure r102 = sEnsure;
        if (r102 != null) goto L5;
        return r100;
    L5:
        r102.ensureTrue(r100, r101);
        return r100;
    }

    public static void ensureNotReachHere(Throwable r100, String r101) {
        IEnsure r102 = sEnsure;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.ensureNotReachHere(r100, r101);
    }

    public static boolean ensureFalse(boolean r100, String r101, Map<String, String> r102) {
        IEnsure r103 = sEnsure;
        if (r103 != null) goto L5;
        return r100;
    L5:
        r103.ensureFalse(r100, r101, r102);
        return r100;
    }

    public static void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        IEnsure r103 = sEnsure;
        if (r103 != null) goto L5;
        return;
    L5:
        r103.ensureNotReachHere(r100, r101, r102);
    }

    public static boolean ensureTrue(boolean r100, String r101, Map<String, String> r102) {
        IEnsure r103 = sEnsure;
        if (r103 != null) goto L5;
        return r100;
    L5:
        r103.ensureTrue(r100, r101, r102);
        return r100;
    }

    public static void reportLogEException(int r100, Throwable r101, String r102, boolean r103) {
        IEnsure r104 = sEnsure;
        if (r104 != null) goto L5;
        return;
    L5:
        r104.reportLogException(r100, r101, r102);
    }
}
