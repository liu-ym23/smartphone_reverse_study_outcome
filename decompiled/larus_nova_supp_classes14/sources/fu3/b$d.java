package fu3;

import android.util.Pair;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$d implements Comparator<Pair<String, Integer>> {
    public b$d() {
    }

    @Override // java.util.Comparator
    public final int compare(Pair<String, Integer> r1, Pair<String, Integer> r2) {
        return ((Integer) r2.second).intValue() - ((Integer) r1.second).intValue();
    }
}
