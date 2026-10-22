package com.bytedance.keva;

import android.os.Looper;
import java.lang.reflect.Field;
import me.ele.lancet.base.Origin;

/* JADX INFO: loaded from: classes3.dex */
public class KevaPrivateImplLancet {
    public static final int INVALID_MODE = -1;
    private static Field kevaModeField;
    public static boolean modeFieldInit;
    public static final Looper sMainLooper = null;

    public KevaPrivateImplLancet() {
    }

    static {
        sMainLooper = Looper.getMainLooper();
        modeFieldInit = false;
    }

    public KevaImpl obtain() {
        KevaImpl r100 = (KevaImpl) Origin.call();
        if (KevaPreloadHolder.fetchEnable == true) goto L5;
    L9:
        return r100;
    L5:
        if (Looper.myLooper() != sMainLooper) goto L9;
        int r101 = getKevaMode(r100);
        if (r101 == (-1)) goto L9;
        KevaPreloadHolder.tryPutPreloadMap(r100.name(), r101);
        goto L9
    }

    public static int getKevaMode(KevaImpl r100) {
        Field r101 = kevaModeField;
        if (modeFieldInit == false) goto L6;
        if (r101 != null) goto L6;
        return -1;
    L6:
        if (r101 == null) goto L17;
    L15:
        return ((Integer) r101.get(r100)).intValue();
    L14:
        return -1;
    L17:
        Field r102 = KevaImpl.class.getDeclaredField("mMode");     // Catch: NoSuchFieldException -> L10
        r102.setAccessible(true);
        kevaModeField = r102;
        modeFieldInit = true;
        r101 = r102;
    L10:
        modeFieldInit = true;
        return -1;
    }
}
