package wt3;

import java.util.Comparator;
import vt3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class h$b implements Comparator<h> {
    public h$b() {
    }

    @Override // java.util.Comparator
    public final int compare(h r5, h r6) {
        return (int) ((r6.d * 100.0d) - (r5.d * 100.0d));
    }
}
