package tt3;

import java.util.Comparator;
import vu3.a$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Comparator<a$a> {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(a$a r5, a$a r6) {
        return (int) ((r6.b * 100.0d) - (r5.b * 100.0d));
    }
}
