package com.ss.android.lark.qrcode.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes37.dex */
final class FinderPatternFinder$CenterComparator implements Comparator<a>, Serializable {
    private final float average;

    public FinderPatternFinder$CenterComparator(float r100, b r101) {
        this.average = r100;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(a r100, a r101) {
        r101.getClass();
        r100.getClass();
        int r102 = Integer.compare(0, 0);
        if (r102 == 0) goto L5;
        return r102;
    L5:
        return Float.compare(Math.abs(0.0f - this.average), Math.abs(0.0f - this.average));
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(a r100, a r101) {
        return compare2(r100, r101);
    }
}
