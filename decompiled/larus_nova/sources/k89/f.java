package k89;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class f<T> implements Comparator {
    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r101).getCreateTime()), Long.valueOf(((Message) r100).getCreateTime()));
    }
}
