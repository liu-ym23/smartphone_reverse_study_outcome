package org.apache.commons.imaging.palette;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes42.dex */
class MostPopulatedBoxesMedianCut$ColorComparer implements Comparator<ColorCount>, Serializable {
    private static final long serialVersionUID = 1;
    private final ColorComponent colorComponent;

    public MostPopulatedBoxesMedianCut$ColorComparer(ColorComponent r100) {
        this.colorComponent = r100;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(ColorCount r100, ColorCount r101) {
        int r102 = MostPopulatedBoxesMedianCut$1.$SwitchMap$org$apache$commons$imaging$palette$ColorComponent[this.colorComponent.ordinal()];
        if (r102 != 1) goto L5;
        int r103 = r100.alpha;
        int r104 = r101.alpha;
    L14:
        return r103 - r104;
    L5:
        if (r102 != 2) goto L7;
        r103 = r100.red;
        r104 = r101.red;
        goto L14
    L7:
        if (r102 != 3) goto L9;
        r103 = r100.green;
        r104 = r101.green;
        goto L14
    L9:
        if (r102 == 4) goto L12;
        return 0;
    L12:
        r103 = r100.blue;
        r104 = r101.blue;
        goto L14
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ColorCount r100, ColorCount r101) {
        return compare2(r100, r101);
    }
}
