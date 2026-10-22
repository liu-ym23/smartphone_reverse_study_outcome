package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j {
    public static final int a(List<h> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        int r102 = r100.size() - 1;
        int r103 = 0;
    L3:
        if (r103 > r102) goto L11;
        int r104 = (r103 + r102) >>> 1;
        long r105 = ((h) ListProtector.get(r100, r104)).f435222a;
        if (r105 < r101) goto L6;
        if (r105 <= r101) goto L9;
        r102 = r104 - 1;
        goto L3
    L9:
        return r104;
    L6:
        r103 = r104 + 1;
        goto L3
    L11:
        return -(r103 + 1);
    }

    public static final float b(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "s1");
        Intrinsics.checkNotNullParameter(r111, "s2");
        int r100 = 0;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L15;
        if (r111.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        return 1.0f;
    L11:
        r102 = false;
    L15:
        if (r110.length() != 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        return 0.0f;
    L20:
        if (r111.length() != 0) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == true) goto L63;
        Intrinsics.checkNotNullParameter(r110, "s1");
        Intrinsics.checkNotNullParameter(r111, "s2");
        if (Intrinsics.areEqual(r110, r111) == true) goto L55;
        int r105 = r110.length();
        int r106 = r111.length();
        int r107 = r105 + 1;
        int[][] r108 = new int[r107][];
        int r109 = 0;
    L29:
        if (r109 >= r107) goto L31;
        r108[r109] = new int[r106 + 1];
        r109 = r109 + 1;
        goto L29
    L31:
        if (r105 < 0) goto L36;
        int r112 = 0;
    L33:
        r108[r112][0] = r112;
        if (r112 == r105) goto L36;
        r112 = r112 + 1;
    L36:
        if (r106 < 0) goto L41;
        int r113 = 0;
    L38:
        r108[0][r113] = r113;
        if (r113 == r106) goto L41;
        r113 = r113 + 1;
    L41:
        if (1 > r105) goto L53;
        int r114 = 1;
    L43:
        if (1 > r106) goto L51;
        int r115 = 1;
    L45:
        int r116 = r114 - 1;
        int r117 = r115 - 1;
        if (r110.charAt(r116) != r111.charAt(r117)) goto L48;
        r108[r114][r115] = r108[r116][r117];
    L49:
        if (r115 == r106) goto L51;
        r115 = r115 + 1;
        goto L45
    L48:
        int[] r118 = r108[r114];
        int[] r119 = r108[r116];
        r118[r115] = Math.min(r119[r115] + 1, Math.min(r118[r117] + 1, r119[r117] + 1));
    L51:
        if (r114 == r105) goto L53;
        r114 = r114 + 1;
    L53:
        r100 = r108[r105][r106];
    L55:
        return 1.0f - (r100 / Math.max(r110.length(), r111.length()));
    L63:
        return 0.0f;
    L22:
        r104 = false;
        goto L23
    L17:
        r103 = false;
        goto L18
    L5:
        r101 = false;
        goto L7
    }
}
