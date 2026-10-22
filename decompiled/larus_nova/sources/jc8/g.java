package jc8;

import com.larus.bmhome.chat.block.base.IBlockProvider;
import java.util.Comparator;
import java.util.List;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f498165a;

    public g(List r100) {
        this.f498165a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.f498165a.indexOf(((IBlockProvider) r100).N0())), Integer.valueOf(this.f498165a.indexOf(((IBlockProvider) r101).N0())));
    }
}
