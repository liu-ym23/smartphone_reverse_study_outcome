package androidx.camera.core.streamsharing;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.UseCaseConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DynamicRangeUtils {
    private DynamicRangeUtils() {
    }

    private static DynamicRange intersectDynamicRange(List<DynamicRange> r6) {
        if (r6.isEmpty() == false) goto L5;
        return null;
    L5:
        DynamicRange r0 = (DynamicRange) ListProtector.get(r6, 0);
        Integer r2 = Integer.valueOf(r0.getEncoding());
        Integer r1 = Integer.valueOf(r0.getBitDepth());
        int r3 = 1;
    L7:
        if (r3 >= r6.size()) goto L15;
        DynamicRange r4 = (DynamicRange) ListProtector.get(r6, r3);
        r2 = intersectDynamicRangeEncoding(r2, Integer.valueOf(r4.getEncoding()));
        r1 = intersectDynamicRangeBitDepth(r1, Integer.valueOf(r4.getBitDepth()));
        if (r2 == null) goto L13;
        if (r1 == null) goto L13;
        r3 = r3 + 1;
    L13:
        return null;
    L15:
        return new DynamicRange(r2.intValue(), r1.intValue());
    }

    public static DynamicRange resolveDynamicRange(Set<UseCaseConfig<?>> r2) {
        ArrayList r0 = new ArrayList();
        Iterator<UseCaseConfig<?>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r0.add(r3.next().getDynamicRange());
        goto L4
    L7:
        return intersectDynamicRange(r0);
    }

    private static Integer intersectDynamicRangeBitDepth(Integer r2, Integer r3) {
        if (r2.equals(0) == false) goto L6;
        return r3;
    L6:
        if (r3.equals(0) == false) goto L9;
        return r2;
    L9:
        if (r2.equals(r3) == true) goto L13;
        return null;
    L13:
        return r2;
    }

    private static Integer intersectDynamicRangeEncoding(Integer r3, Integer r4) {
        if (r3.equals(0) == false) goto L6;
        return r4;
    L6:
        if (r4.equals(0) == false) goto L9;
        return r3;
    L9:
        if (r3.equals(2) == false) goto L14;
        if (r4.equals(1) == true) goto L14;
        return r4;
    L14:
        if (r4.equals(2) == false) goto L19;
        if (r3.equals(1) == true) goto L19;
        return r3;
    L19:
        if (r3.equals(r4) == true) goto L23;
        return null;
    L23:
        return r3;
    }
}
