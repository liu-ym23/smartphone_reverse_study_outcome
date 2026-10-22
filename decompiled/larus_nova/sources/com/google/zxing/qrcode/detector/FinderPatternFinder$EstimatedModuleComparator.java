package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final class FinderPatternFinder$EstimatedModuleComparator implements Comparator<a>, Serializable {
    private FinderPatternFinder$EstimatedModuleComparator() {
    }

    public /* synthetic */ FinderPatternFinder$EstimatedModuleComparator(b r100) {
        this();
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(a r100, a r101) {
        r100.getClass();
        r101.getClass();
        return Float.compare(0.0f, 0.0f);
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(a r100, a r101) {
        return compare2(r100, r101);
    }
}
