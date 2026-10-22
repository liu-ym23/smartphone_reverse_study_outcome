package zv8;

import com.larus.business.debug.base.register.EntranceGroup;
import java.util.Comparator;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class l<T> implements Comparator {
    public l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        EntranceGroup[] r102 = EntranceGroup.values();
        Integer r103 = Integer.valueOf(ArraysKt.indexOf(r102, (EntranceGroup) r100));
        EntranceGroup[] r104 = EntranceGroup.values();
        return ComparisonsKt.compareValues(r103, Integer.valueOf(ArraysKt.indexOf(r104, (EntranceGroup) r101)));
    }
}
