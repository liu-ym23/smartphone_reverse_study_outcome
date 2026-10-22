package u9b;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final void a(e r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "spanNodeMapper");
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r100.a((d) r102.next());
        goto L4
    }
}
