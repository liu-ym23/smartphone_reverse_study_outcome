package gx3;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends a {
    @Override // gx3.a
    public final boolean c(b r100) {
        int r101 = a();
        if (r101 >= 0) goto L6;
        return true;
    L6:
        if (r101 <= 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(10000) >= this.f483091a) goto L13;
        return false;
    L13:
        return true;
    }

    public g(int r100, Set<String> r101, Map<String, List<Set<String>>> r102, Map<String, List<Map<String, Object>>> r103) {
        super(r100, r101, r102, r103);
    }
}
