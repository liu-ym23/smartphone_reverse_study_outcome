package ze1;

import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((BackupSeiModel) r100).getSeiIndex()), Long.valueOf(((BackupSeiModel) r101).getSeiIndex()));
    }
}
