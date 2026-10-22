package mt3;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements Comparator<String> {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(String r100, String r101) {
        Comparator r102 = String.CASE_INSENSITIVE_ORDER;
        return r102.compare(r100, r101);
    }
}
