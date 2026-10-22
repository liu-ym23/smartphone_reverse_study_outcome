package ze1;

import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class k<T> implements Comparator<T> {
    public k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((BackupSeiModel) r100).getPts()), Long.valueOf(((BackupSeiModel) r101).getPts()));
    }
}
