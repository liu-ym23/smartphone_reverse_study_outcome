package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class QualityRatioToResolutionsTable {
    private static final Map<Integer, Rational> sAspectRatioMap = null;
    private static final Map<Quality, Range<Integer>> sQualityRangeMap = null;
    private final Map<QualityRatio, List<Size>> mTable;

    public static abstract class QualityRatio {
        public QualityRatio() {
        }

        public abstract int getAspectRatio();

        public abstract Quality getQuality();

        public static QualityRatio of(Quality r1, int r2) {
            return new AutoValue_QualityRatioToResolutionsTable_QualityRatio(r1, r2);
        }
    }

    public static /* synthetic */ int a(int r0, Size r1, Size r2) {
        return lambda$sortQualityRatioRow$0(r0, r1, r2);
    }

    static {
        HashMap r0 = new HashMap();
        sQualityRangeMap = r0;
        r0.put(Quality.UHD, Range.create(2160, 4319));
        r0.put(Quality.FHD, Range.create(1080, 1439));
        r0.put(Quality.HD, Range.create(720, 1079));
        r0.put(Quality.SD, Range.create(241, 719));
        HashMap r1 = new HashMap();
        sAspectRatioMap = r1;
        r1.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        r1.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    private void addProfileSizesToTable(Map<Quality, Size> r4) {
        Iterator<Map.Entry<Quality, Size>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<Quality, Size> r0 = r5.next();
        List<Size> r1 = getQualityRatioRow(r0.getKey(), -1);
        Objects.requireNonNull(r1);
        r1.add(r0.getValue());
        goto L4
    }

    private void addResolutionsToTable(List<Size> r4) {
        Iterator<Size> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Size r0 = r5.next();
        Quality r1 = findMappedQuality(r0);
        if (r1 == null) goto L4;
        Integer r2 = findMappedAspectRatio(r0);
        if (r2 == null) goto L4;
        List<Size> r3 = getQualityRatioRow(r1, r2.intValue());
        Objects.requireNonNull(r3);
        r3.add(r0);
        goto L4
    }

    private static Integer findMappedAspectRatio(Size r4) {
        Iterator<Map.Entry<Integer, Rational>> r0 = sAspectRatioMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Integer, Rational> r1 = r0.next();
        if (AspectRatioUtil.hasMatchingAspectRatio(r4, r1.getValue(), SizeUtil.RESOLUTION_QVGA) == false) goto L4;
        return r1.getKey();
    L9:
        return null;
    }

    private static Quality findMappedQuality(Size r4) {
        Iterator<Map.Entry<Quality, Range<Integer>>> r0 = sQualityRangeMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<Quality, Range<Integer>> r1 = r0.next();
        if (r1.getValue().contains(Integer.valueOf(r4.getHeight())) == false) goto L4;
        return r1.getKey();
    L9:
        return null;
    }

    private void sortQualityRatioRow(Map<Quality, Size> r5) {
        Iterator<Map.Entry<QualityRatio, List<Size>>> r0 = this.mTable.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<QualityRatio, List<Size>> r1 = r0.next();
        Size r2 = r5.get(r1.getKey().getQuality());
        if (r2 == null) goto L4;
        final int r3 = SizeUtil.getArea(r2);
        Collections.sort(r1.getValue(), new a(r3));
        goto L4
    }

    public QualityRatioToResolutionsTable(List<Size> r7, Map<Quality, Size> r8) {
        this.mTable = new HashMap();
        Iterator<Quality> r0 = sQualityRangeMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Quality r1 = r0.next();
        this.mTable.put(QualityRatio.of(r1, -1), new ArrayList());
        Iterator<Integer> r2 = sAspectRatioMap.keySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Integer r3 = r2.next();
        this.mTable.put(QualityRatio.of(r1, r3.intValue()), new ArrayList());
        goto L7
    L9:
        addProfileSizesToTable(r8);
        addResolutionsToTable(r7);
        sortQualityRatioRow(r8);
    }

    private List<Size> getQualityRatioRow(Quality r2, int r3) {
        return this.mTable.get(QualityRatio.of(r2, r3));
    }

    public List<Size> getResolutions(Quality r1, int r2) {
        List<Size> r3 = getQualityRatioRow(r1, r2);
        if (r3 == null) goto L5;
        ArrayList r4 = new ArrayList(r3);
    L6:
        return r4;
    L5:
        r4 = new ArrayList(0);
        goto L6
    }

    private static /* synthetic */ int lambda$sortQualityRatioRow$0(int r0, Size r1, Size r2) {
        return Math.abs(SizeUtil.getArea(r1) - r0) - Math.abs(SizeUtil.getArea(r2) - r0);
    }
}
