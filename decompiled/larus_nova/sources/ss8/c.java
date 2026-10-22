package ss8;

import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IActionBarFilter) r100).getPriority()), Integer.valueOf(((IActionBarFilter) r101).getPriority()));
    }
}
