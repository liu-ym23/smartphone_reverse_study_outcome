package uw3;

import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends a {
    @Override // uw3.e
    public final boolean b() {
        return false;
    }

    @Override // uw3.a
    public final boolean d(String r100) {
        return !this.f551931a.contains(r100);
    }

    public b(HashSet r100, HashMap r101) {
        super(r100, r101);
    }

    @Override // uw3.a
    public final boolean e(HashSet<String> r100, String r101) {
        return !r100.contains(r101);
    }
}
