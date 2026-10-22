package com.ss.android.lark.qrcode.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes37.dex */
final class FinderPatternFinder$FurthestFromAverageComparator implements Comparator<a>, Serializable {
    private final float average;

    public FinderPatternFinder$FurthestFromAverageComparator(float r100, b r101) {
        this.average = r100;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(a r100, a r101) {
        r101.getClass();
        float r102 = Math.abs(0.0f - this.average);
        r100.getClass();
        return Float.compare(r102, Math.abs(0.0f - this.average));
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(a r100, a r101) {
        return compare2(r100, r101);
    }
}
