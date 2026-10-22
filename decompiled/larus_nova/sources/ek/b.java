package ek;

import com.bytedance.android.ec.hybrid.popup.j;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((j) r100).getPriority()), Integer.valueOf(((j) r101).getPriority()));
    }
}
