package h3a;

import com.larus.voicecall.impl.component.dialog.RealtimeDialogTriggerTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f483728a;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            ((h3a.a) r100).getPriority();
            ((h3a.a) r101).getPriority();
            return ComparisonsKt.compareValues(10000, 10000);
        }
    }

    public c() {
        this.f483728a = LazyKt.lazy(new b());
    }

    public final void a(RealtimeDialogTriggerTime r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerTime");
        List r101 = (List) ((Map) this.f483728a.getValue()).get(r100);
        if (r101 == null) goto L14;
        Iterator r102 = CollectionsKt.sortedWith(r101, new a()).iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        h3a.a r103 = (h3a.a) r102.next();
        if (r103.a(r100) == false) goto L6;
        r103.b(r100);
        return;
    L15:
        return;
    }
}
