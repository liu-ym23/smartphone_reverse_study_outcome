package e7a;

import java.util.Comparator;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements Comparator<f.b> {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(f.b r100, f.b r101) {
        return Integer.compare(Math.abs(r100.f471250c), Math.abs(r101.f471250c));
    }
}
