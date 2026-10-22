package rib;

import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((SearchBaseInfo) r101).getTimeStamp()), Long.valueOf(((SearchBaseInfo) r100).getTimeStamp()));
    }
}
