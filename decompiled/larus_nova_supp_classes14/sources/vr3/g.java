package vr3;

import com.bytedance.apm.util.t;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Comparator<t> {
    public g() {
    }

    @Override // java.util.Comparator
    public final int compare(t r3, t r4) {
        return (int) (r4.c - r3.c);
    }
}
