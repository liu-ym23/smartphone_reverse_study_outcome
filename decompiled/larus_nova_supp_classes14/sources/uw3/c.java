package uw3;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends a {
    public final boolean b() {
        HashSet r0 = ((a) this).a;
        if (r0 != null) goto L5;
    L6:
        HashMap r1 = ((a) this).b;
        if (r1 != null) goto L9;
    L12:
        return true;
    L9:
        if (r1.isEmpty() == true) goto L12;
    L11:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L11;
        goto L6
    }

    public final boolean d(String r2) {
        HashSet r0 = ((a) this).a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r2) == false) goto L7;
        return true;
    }

    public c(HashSet r1, HashMap r2) {
        super(r1, r2);
    }

    public final boolean e(HashSet<String> r1, String r2) {
        return r1.contains(r2);
    }
}
