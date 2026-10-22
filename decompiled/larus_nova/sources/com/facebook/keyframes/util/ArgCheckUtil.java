package com.facebook.keyframes.util;

import com.facebook.keyframes.model.KFAnimationGroup;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class ArgCheckUtil {
    public ArgCheckUtil() {
    }

    public static boolean checkAnimationGroupIdUniqueness(List<KFAnimationGroup> r100) {
        if (r100 != null) goto L5;
    L13:
        return true;
    L5:
        if (r100.size() == 0) goto L13;
        HashSet r101 = new HashSet(r100.size());
        int r102 = r100.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        Integer r104 = Integer.valueOf(r100.get(r103).getGroupId());
        if (r101.contains(r104) == true) goto L11;
        r101.add(r104);
        r103 = r103 + 1;
        goto L8
    L11:
        return false;
    }

    public static boolean checkTimingCurveObjectValidity(float[][][] r100, int r101) {
        if (r101 > 1) goto L9;
        if (r100 != null) goto L6;
    L7:
        return true;
    L6:
        if (r100.length == 0) goto L7;
    L9:
        if ((r101 - 1) == r100.length) goto L11;
        return false;
    L11:
        int r102 = 0;
    L13:
        if (r102 >= r100.length) goto L25;
        if (r100[r102].length != 2) goto L16;
        int r103 = 0;
    L18:
        float[][] r104 = r100[r102];
        if (r103 >= r104.length) goto L24;
        if (r104[r103].length != 2) goto L22;
        r103 = r103 + 1;
        goto L18
    L22:
        return false;
    L24:
        r102 = r102 + 1;
        goto L13
    L16:
        return false;
    L25:
        return true;
    }

    public static <T> T checkArg(T r100, boolean r101, String r102) {
        if (r101 == false) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(String.format(Locale.US, "Illegal argument for %s.", new Object[]{r102}));
    }
}
