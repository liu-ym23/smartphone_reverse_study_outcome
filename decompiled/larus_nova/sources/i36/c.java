package i36;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends b {
    public c() {
    }

    public final long e(List<Pair<String, String>> r110) {
        Intrinsics.checkNotNullParameter(r110, "stageList");
        Iterator<Pair<String, String>> r111 = r110.iterator();
        long r100 = 0;
    L4:
        if (r111.hasNext() == false) goto L14;
        Pair<String, String> r101 = r111.next();
        long r102 = b(r101.getFirst());
        long r103 = b(r101.getSecond());
        if (r102 != (-1)) goto L8;
    L11:
        long r104 = 0;
    L12:
        r100 = r100 + r104;
        goto L4
    L8:
        if (r103 == (-1)) goto L11;
        r104 = r103 - r102;
        goto L12
    L14:
        return r100 / ((long) 1000000);
    }
}
