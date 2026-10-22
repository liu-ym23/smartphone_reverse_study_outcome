package com.ttnet.org.chromium.base;

import android.content.Context;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@MainDex
public class JNIUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ClassLoader sJniClassLoader;
    private static Boolean sSelectiveJniRegistrationEnabled;

    public JNIUtils() {
    }

    public static void enableSelectiveJniRegistration() {
        sSelectiveJniRegistrationEnabled = Boolean.TRUE;
    }

    private static ClassLoader getClassLoader() {
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

    public static ClassLoader getSplitClassLoader(String r100) {
        Context r101 = ContextUtils.getApplicationContext();
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (BundleUtils.isIsolatedSplitInstalled(r101, r100) == false) goto L9;
        return BundleUtils.createIsolatedSplitContext(r101, r100).getClassLoader();
    L9:
        return getClassLoader();
    }

    public static void setClassLoader(ClassLoader r100) {
        sJniClassLoader = r100;
    }

    public static <K, V> void splitMap(Map<K, V> r100, K[] r101, V[] r102) {
        Iterator<Map.Entry<K, V>> r103 = r100.entrySet().iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<K, V> r105 = r103.next();
        r101[r104] = r105.getKey();
        r102[r104] = r105.getValue();
        r104 = r104 + 1;
        goto L4
    }
}
