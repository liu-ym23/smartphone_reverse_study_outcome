package kotlinx.datetime.internal.format;

import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes42.dex */
public final class o {
    public static final <T> void a(List<k<T>> r100, n<? super T> r101) {
        if ((r101 instanceof e) == false) goto L6;
        r100.add(((e) r101).f505285a);
        return;
    L6:
        if ((r101 instanceof h) == false) goto L12;
        Iterator<T> r102 = ((h) r101).f505290a.iterator();
    L9:
        if (r102.hasNext() == false) goto L39;
        a(r100, (q) r102.next());
        goto L9
    L39:
        return;
    L12:
        if ((r101 instanceof j) == false) goto L14;
        return;
    L14:
        if ((r101 instanceof SignedFormatStructure) == false) goto L17;
        a(r100, ((SignedFormatStructure) r101).f505270a);
        return;
    L17:
        if ((r101 instanceof c) == false) goto L23;
        c r103 = (c) r101;
        a(r100, r103.f505282a);
        Iterator<T> r104 = r103.f505283b.iterator();
    L20:
        if (r104.hasNext() == false) goto L40;
        a(r100, (n) r104.next());
        goto L20
    L40:
        return;
    L23:
        if ((r101 instanceof OptionalFormatStructure) == false) goto L28;
        a(r100, ((OptionalFormatStructure) r101).f505265b);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L28:
        throw new NoWhenBranchMatchedException();
    }
}
