package yd9;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r101).getLocalIndex()), Long.valueOf(((Message) r100).getLocalIndex()));
    }
}
