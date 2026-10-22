package com.ss.videoarch.live.ttquic;

/* JADX INFO: loaded from: classes38.dex */
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    public JNIUtils() {
    }

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    public static Object getClassLoader() {
        ClassLoader r100 = sJniClassLoader;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return JNIUtils.class.getClassLoader();
    }

    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled != null) goto L6;
        sSelectiveJniRegistrationEnabled = Boolean.FALSE;
    L6:
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }

    static {
    }

    public static void setClassLoader(ClassLoader r100) {
        sJniClassLoader = r100;
    }
}
