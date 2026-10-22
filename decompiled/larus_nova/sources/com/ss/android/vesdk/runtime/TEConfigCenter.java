package com.ss.android.vesdk.runtime;

import com.ss.android.ttve.nativePort.TECodecNativeLibsLoader;
import com.ss.android.vesdk.VEConfigCenter;

/* JADX INFO: loaded from: classes40.dex */
public class TEConfigCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f455882a = 0;

    public TEConfigCenter() {
    }

    public static native void nativeClear();

    public static native void nativeSetABSetType(int r100);

    public static native void nativeSetBoolConfig(String r100, boolean r101, boolean r102, int r103);

    public static native void nativeSetFloatConfig(String r100, float r101, boolean r102, int r103);

    public static native void nativeSetIntConfig(String r100, int r101, boolean r102, int r103);

    public static native void nativeSetStringConfig(String r100, String r101, boolean r102, int r103);

    static {
        TECodecNativeLibsLoader.d();
    }

    public static void a(String r100, VEConfigCenter.ValuePkt r101) {
        if (r101.getABType() != VEConfigCenter.ABType.FOREFFECT) goto L5;
        boolean r102 = true;
    L6:
        int r103 = r101.getDataType().ordinal();
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L10;
    L18:
        nativeSetIntConfig(r100, ((Integer) r101.getValue()).intValue(), r102, r101.getConfigType().ordinal());
        return;
    L10:
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L14;
        nativeSetFloatConfig(r100, ((Float) r101.getValue()).floatValue(), r102, r101.getConfigType().ordinal());
        return;
    L14:
        if (r103 != 4) goto L24;
        nativeSetStringConfig(r100, (String) r101.getValue(), r102, r101.getConfigType().ordinal());
        return;
    L24:
        return;
    L19:
        nativeSetBoolConfig(r100, ((Boolean) r101.getValue()).booleanValue(), r102, r101.getConfigType().ordinal());
        return;
    L5:
        r102 = false;
        goto L6
    }
}
