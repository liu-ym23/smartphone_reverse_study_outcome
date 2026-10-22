package androidx.camera.core.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SurfaceCombination {
    private final List<SurfaceConfig> mSurfaceConfigList;

    public SurfaceCombination() {
        this.mSurfaceConfigList = new ArrayList();
    }

    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    private List<int[]> getElementsArrangements(int r4) {
        ArrayList r0 = new ArrayList();
        generateArrangements(r0, r4, new int[r4], 0);
        return r0;
    }

    public boolean addSurfaceConfig(SurfaceConfig r2) {
        return this.mSurfaceConfigList.add(r2);
    }

    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(List<SurfaceConfig> r10) {
        if (r10.isEmpty() == false) goto L7;
        return new ArrayList();
    L7:
        if (r10.size() == this.mSurfaceConfigList.size()) goto L9;
        return null;
    L9:
        List<int[]> r0 = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] r1 = new SurfaceConfig[r10.size()];
        Iterator<int[]> r2 = r0.iterator();
    L10:
        int r4 = 0;
        if (r2.hasNext() == false) goto L24;
        int[] r3 = r2.next();
        boolean r6 = true;
    L14:
        if (r4 >= this.mSurfaceConfigList.size()) goto L22;
        if (r3[r4] >= r10.size()) goto L21;
        r6 = r6 & ((SurfaceConfig) ListProtector.get(this.mSurfaceConfigList, r4)).isSupported((SurfaceConfig) ListProtector.get(r10, r3[r4]));
        if (r6 == false) goto L22;
        r1[r3[r4]] = (SurfaceConfig) ListProtector.get(this.mSurfaceConfigList, r4);
    L21:
        r4 = r4 + 1;
    L22:
        if (r6 == false) goto L10;
        r4 = 1;
    L24:
        if (r4 != 0) goto L26;
        return null;
    L26:
        return Arrays.asList(r1);
    }

    public boolean removeSurfaceConfig(SurfaceConfig r2) {
        return this.mSurfaceConfigList.remove(r2);
    }

    private static void generateArrangements(List<int[]> r4, int r5, int[] r6, int r7) {
        if (r7 < r6.length) goto L6;
        r4.add((int[]) r6.clone());
        return;
    L6:
        int r1 = 0;
    L7:
        if (r1 >= r5) goto L18;
        int r2 = 0;
    L9:
        if (r2 >= r7) goto L14;
        if (r1 == r6[r2]) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
        r6[r7] = r1;
        generateArrangements(r4, r5, r6, r7 + 1);
    L17:
        r1 = r1 + 1;
        goto L7
    L14:
        r3 = false;
        goto L15
    }
}
