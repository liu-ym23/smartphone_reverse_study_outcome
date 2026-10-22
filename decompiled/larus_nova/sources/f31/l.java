package f31;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {
    public static final int a(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$height");
        Intrinsics.checkNotNullParameter(r100, "$this$endY");
        Iterator<T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L13;
        k r102 = (k) r101.next();
        int r103 = r102.f475351d + r102.f475353f;
    L6:
        if (r101.hasNext() == false) goto L11;
        k r104 = (k) r101.next();
        int r105 = r104.f475351d;
        int r106 = r104.f475353f + r105;
        if (r103 >= r106) goto L6;
        r103 = r106;
        goto L6
    L11:
        return r103 - d(r100);
    L13:
        throw new NoSuchElementException();
    }

    public static final boolean b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGameLink");
        List<k> r101 = r100.f475330a;
        boolean r102 = false;
        if (r101 == null) goto L10;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((k) r103.next()).f475348a, "mock_game_uid") == false) goto L6;
        r102 = true;
    L10:
        return r102;
    }

    public static final int c(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$startX");
        Iterator<T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L12;
        int r102 = ((k) r101.next()).f475350c;
    L6:
        if (r101.hasNext() == false) goto L10;
        int r103 = ((k) r101.next()).f475350c;
        if (r102 <= r103) goto L6;
        r102 = r103;
        goto L6
    L10:
        return r102;
    L12:
        throw new NoSuchElementException();
    }

    public static final int d(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$startY");
        Iterator<T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L12;
        int r102 = ((k) r101.next()).f475351d;
    L6:
        if (r101.hasNext() == false) goto L10;
        int r103 = ((k) r101.next()).f475351d;
        if (r102 <= r103) goto L6;
        r102 = r103;
        goto L6
    L10:
        return r102;
    L12:
        throw new NoSuchElementException();
    }

    public static final int e(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$width");
        Intrinsics.checkNotNullParameter(r100, "$this$endX");
        Iterator<T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L13;
        k r102 = (k) r101.next();
        int r103 = r102.f475350c + r102.f475352e;
    L6:
        if (r101.hasNext() == false) goto L11;
        k r104 = (k) r101.next();
        int r105 = r104.f475350c;
        int r106 = r104.f475352e + r105;
        if (r103 >= r106) goto L6;
        r103 = r106;
        goto L6
    L11:
        return r103 - c(r100);
    L13:
        throw new NoSuchElementException();
    }
}
