package spa;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static double[] a(ArrayList<Double> r100) {
        int r101 = r100.size();
        double[] r102 = new double[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = ((Double) ListProtector.get(r100, r103)).doubleValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static int[] b(ArrayList<Integer> r100) {
        int r101 = r100.size();
        int[] r102 = new int[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = ((Integer) ListProtector.get(r100, r103)).intValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static long[] c(ArrayList<Long> r100) {
        int r101 = r100.size();
        long[] r102 = new long[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = ((Long) ListProtector.get(r100, r103)).longValue();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static <T> Object[] d(ArrayList<T> r100) {
        Object[] r101 = r100.toArray();
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L9;
        Object r103 = r101[r102];
        if ((r103 instanceof ArrayList) == false) goto L8;
        r101[r102] = d((ArrayList) r103);
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r101;
    }
}
