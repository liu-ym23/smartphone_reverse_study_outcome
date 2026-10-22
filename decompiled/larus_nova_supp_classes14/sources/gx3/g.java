package gx3;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends a {
    @Override // gx3.a
    public final boolean c(b r4) {
        int r5 = a();
        if (r5 >= 0) goto L6;
        return true;
    L6:
        if (r5 <= 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(10000) >= this.a) goto L13;
        return false;
    L13:
        return true;
    }

    public g(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }
}
