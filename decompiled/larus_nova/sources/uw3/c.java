package uw3;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends a {
    @Override // uw3.e
    public final boolean b() {
        HashSet<String> r100 = this.f551931a;
        if (r100 != null) goto L5;
    L6:
        HashMap<String, HashSet<String>> r101 = this.f551932b;
        if (r101 != null) goto L9;
    L12:
        return true;
    L9:
        if (r101.isEmpty() == true) goto L12;
    L11:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L11;
        goto L6
    }

    @Override // uw3.a
    public final boolean d(String r100) {
        HashSet<String> r101 = this.f551931a;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100) == false) goto L7;
        return true;
    }

    public c(HashSet r100, HashMap r101) {
        super(r100, r101);
    }

    @Override // uw3.a
    public final boolean e(HashSet<String> r100, String r101) {
        return r100.contains(r101);
    }
}
