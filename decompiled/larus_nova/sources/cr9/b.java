package cr9;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f465116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f465117b = null;

    static {
        f465116a = new int[]{4, 9, 14, 19, 24};
        f465117b = SetsKt.setOf(new Integer[]{10, 11, 12, 9});
    }

    public static final boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.length();
        int[] r102 = f465116a;
        if (r101 > ArraysKt.last(r102)) goto L8;
        return false;
    L8:
        Iterable r103 = ArraysKt.getIndices(r102);
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L12;
        int r105 = ((IntIterator) r104).nextInt();
        if (r100.charAt(r102[r105]) != "OFL0X".charAt(r105)) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L15;
        return false;
    L19:
        r106 = false;
    L12:
        return true;
    L11:
        if (((Collection) r103).isEmpty() == false) goto L13;
        goto L12
    }
}
