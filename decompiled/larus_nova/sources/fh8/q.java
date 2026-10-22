package fh8;

import android.text.Spanned;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class q<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spanned f477140a;

    public q(Spanned r100) {
        this.f477140a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Spanned r102 = this.f477140a;
        Integer r103 = Integer.valueOf(r102.getSpanStart((TableRowSpan2) r100));
        Spanned r104 = this.f477140a;
        return ComparisonsKt.compareValues(r103, Integer.valueOf(r104.getSpanStart((TableRowSpan2) r101)));
    }
}
