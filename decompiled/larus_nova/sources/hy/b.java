package hy;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((AnchorLinkUser) r100).getLinkMicId()), Long.valueOf(((AnchorLinkUser) r101).getLinkMicId()));
    }
}
