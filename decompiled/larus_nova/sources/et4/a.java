package et4;

import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final GroupPosition a(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new GroupPosition(r100, -1);
    }

    public static final int b(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return 0;
    L9:
        return r100[ArraysKt.getLastIndex(r100)];
    L5:
        r101 = false;
        goto L6
    }

    public static final int[] c(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = 0;
        if (r100.length != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        int[] r103 = new int[r100.length - 1];
        int r104 = r100.length - 1;
    L10:
        if (r101 >= r104) goto L12;
        r103[r101] = r100[r101];
        r101 = r101 + 1;
        goto L10
    L12:
        return r103;
    L8:
        return new int[0];
    L5:
        r102 = false;
        goto L6
    }

    public static final boolean d(int[] r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "arr");
        if (r100.length >= r101.length) goto L5;
        return false;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (r100[r103] != r101[r103]) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }
}
