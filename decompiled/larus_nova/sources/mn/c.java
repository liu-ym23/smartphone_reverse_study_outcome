package mn;

import android.graphics.Rect;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends d {

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Rect r102 = ((ln.c) r100).r();
            int r103 = Integer.MIN_VALUE;
            if (r102 == null) goto L5;
            int r104 = r102.top;
        L6:
            Integer r105 = Integer.valueOf(r104);
            Rect r106 = ((ln.c) r101).r();
            if (r106 == null) goto L10;
            r103 = r106.top;
        L10:
            return ComparisonsKt.compareValues(r105, Integer.valueOf(r103));
        L5:
            r104 = Integer.MIN_VALUE;
            goto L6
        }
    }

    public c() {
    }

    @Override // mn.d
    public final void d(List<ln.c> r100, com.bytedance.android.ec.store.utils.playable.controller.a r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "itemsToPlay");
        Intrinsics.checkNotNullParameter(r101, "mgr");
        Intrinsics.checkNotNullParameter(r102, "area");
        if (d.b(r100) != null) goto L8;
        ln.c r103 = d.c(r102, r101);
        if (r103 == null) goto L8;
        r100.remove(r103);
        ListProtector.add(r100, 0, r103);
    L8:
        if (r100.size() <= 1) goto L10;
        CollectionsKt.sortWith(r100, new a());
    L10:
        ln.c r104 = d.b(r100);
        ln.c r105 = d.a(r101.a());
        List<? extends ln.c> r106 = CollectionsKt.emptyList();
        if ((true ^ Intrinsics.areEqual(r104, r105)) == false) goto L13;
        r101.f();
    L20:
        r101.e(r100, r106);
        return;
    L13:
        if (r104 == null) goto L20;
        if (r104.isPlaying() == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L20;
        r106 = CollectionsKt.listOf(r104);
        goto L20
    }
}
